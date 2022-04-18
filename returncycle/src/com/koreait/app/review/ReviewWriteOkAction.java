package com.koreait.app.review;

import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.action.Action;
import com.koreait.action.ActionForward;
import com.koreait.app.review.dao.ReviewDAO;
import com.koreait.app.review.dao.ReviewFilesDAO;
import com.koreait.app.review.vo.ReviewVO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class ReviewWriteOkAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		
		ReviewFilesDAO rf_dao = new ReviewFilesDAO();
		ReviewDAO r_dao = new ReviewDAO();
		ReviewVO r_vo = new ReviewVO();
		
		String saveFolder = "C:\\web_1530_kdk\\teamproject\\workspace\\returncycle\\WebContent\\app\\upload";
		
		int fileSize = 20*1024*1024; //20M
		
		MultipartRequest multi = null;
		multi = new MultipartRequest(req, saveFolder, fileSize, "UTF-8", new DefaultFileRenamePolicy());
		r_vo.setReview_title(multi.getParameter("review_title"));
		r_vo.setReview_content(multi.getParameter("review_content"));
		r_vo.setReview_id(multi.getParameter("review_id"));
		
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
		
		//REVIEW 테이블에 게시글추가
		if(r_dao.insertReview(r_vo)) {
			//REVIEW_FILES 테이블에 게시글 추가
			if(rf_dao.insertReviewFiles(r_dao.getReviewSeq(), multi)) {
				ActionForward forward = new ActionForward();
				forward.setRedirect(true);
				forward.setPath(req.getContextPath()+"/review/ReviewList.rv");
				return forward;
			}
		}
		
		PrintWriter out = resp.getWriter();
		resp.setContentType("text/html;charset=utf-8");
		
		out.println("<script>");
		out.println("alert('게시글 등록 실패. 다시 시도해주세요.');");
		out.println("</script>");
		out.close();
		
		return null;
	}

}
