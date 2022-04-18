package com.koreait.app.review;

import java.io.File;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.action.Action;
import com.koreait.action.ActionForward;
import com.koreait.app.review.dao.ReviewDAO;
import com.koreait.app.review.dao.ReviewFilesDAO;
import com.koreait.app.review.vo.ReviewFilesVO;
import com.koreait.app.review.vo.ReviewVO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class ReviewModifyOkAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		
		ActionForward forward = null;
		
		ReviewDAO r_dao = new ReviewDAO();
		ReviewFilesDAO rf_dao = new ReviewFilesDAO();
		
		MultipartRequest multi = null;
		
		String saveFolder = "C:\\web_1530_kdk\\teamproject\\workspace\\returncycle\\WebContent\\app\\upload";
		int fileSize = 20*1024*1024;
		
		   try {
		         ReviewVO r_vo = new ReviewVO();
		         multi = new MultipartRequest(req, saveFolder, fileSize, "UTF-8", new DefaultFileRenamePolicy());
		         int review_idx = Integer.parseInt(multi.getParameter("seq"));
		         
		         //업로드 폴더의 파일 삭제
		         ReviewFilesVO file = rf_dao.getDetail(review_idx);
		         if(file != null) {
		            File f = new File(saveFolder, file.getR_file_name());
		               if(f.exists()) {
		                  f.delete();
		                  //DB에서 삭제
		                  rf_dao.deleteReviewFiles(review_idx);
		               }
		               //업로드 s파일 삭제
		               String s_file_name = "s_"+file.getR_file_name();
		               File s = new File(saveFolder, s_file_name);
		               if(s.exists()) {
		                  s.delete();
		               }
		            }
		         //기존 파일은 유지되지 않는다.
		/*         //업로드 폴더의 파일 삭제
		         for(ReviewFilesVO file: rf_dao.getDetail(review_idx)) {
		            File f = new File(saveFolder, file.getR_file_name());
		            if(f.exists()) {
		               f.delete();
		            }
		         }
		         //기존 파일은 유지되지 않는다.
		*/         
		         
		         //새롭게 추가한 첨부파일 DB에 추가
		         rf_dao.insertReviewFiles(review_idx, multi);
		         
		         //수정된 게시글 제목과 내용, 게시글 번호 MODEL에 set
		         r_vo.setReview_idx(review_idx);
		         r_vo.setReview_title(multi.getParameter("review_title"));
		         r_vo.setReview_content(multi.getParameter("review_content"));
		         
		         //새롭게 추가한 첨부파일 리사이즈후 upload폴더에 추가
		         Enumeration files = multi.getFileNames();
		         while(files.hasMoreElements()) {
		            try {
		               String name1 = (String)files.nextElement();
		               String filename = multi.getFilesystemName(name1); 
		               String s_filename ="s_" + filename;
		               String inputImagePath = saveFolder + "\\" + filename;
		               String outputImagePath = saveFolder + "\\" + s_filename;
		               Double percent = 0.25;
		               ImageResizer.resize(inputImagePath, outputImagePath, 100, 100);
		            } catch (Exception e) {
		               break;
		            }
		         }
		         
		         //게시글 수정
		         r_dao.updateReview(r_vo);
		         
		         forward = new ActionForward();
		         
		         forward.setRedirect(true);
		         forward.setPath(req.getContextPath() + "/review/ReviewView.rv?seq=" + review_idx);
		      } catch(Exception e) {
		         //자바스크립트로 안내 메세지 응답
		         PrintWriter out = resp.getWriter();
		         resp.setContentType("text/html; charset=UTF-8");
		         out.println("<script>");
		         out.println("alert('게시글 수정 실패. 다시 시도해주세요.')");
		         out.println("</script>");
		         out.close();
		      }
		      return forward;
		   }

		}