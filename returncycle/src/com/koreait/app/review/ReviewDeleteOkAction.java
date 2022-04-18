package com.koreait.app.review;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.action.Action;
import com.koreait.action.ActionForward;
import com.koreait.app.review.dao.ReviewDAO;
import com.koreait.app.review.dao.ReviewFilesDAO;
import com.koreait.app.review.vo.ReviewFilesVO;

public class ReviewDeleteOkAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		ReviewDAO r_dao = new ReviewDAO();
		ReviewFilesDAO rf_dao = new ReviewFilesDAO();
		
		ActionForward forward = new ActionForward();
		
		String saveFolder = "C:\\web_1530_kdk\\teamproject\\workspace\\returncycle\\WebContent\\app\\upload";
		
		int review_idx = Integer.parseInt(req.getParameter("seq"));
	      
	      //파일삭제(upload 경로 파일 삭제) 파일은 하나만 업로드 되므로 한번만 삭제해준다.
	      ReviewFilesVO file = rf_dao.getDetail(review_idx);
	      if(file != null) {
	         File f = new File(saveFolder + "\\" + file.getR_file_name());
	         //값의 유무검사 + 삭제
	         if(f.exists()) {
	            f.delete();
	            //파일 삭제(DB테이블에 있는 파일 삭제)
	            rf_dao.deleteReviewFiles(review_idx);
	         }
	      
	         //업로드 s파일 삭제
	         String s_file_name = "s_"+file.getR_file_name();
	         File s = new File(saveFolder + "\\" + s_file_name);
	            if(s.exists()) {
	               s.delete();
	            }
	         }
	/*      //파일삭제(upload 경로 파일 삭제)
	      for(ReviewFilesVO file: rf_dao.getDetail(review_idx)) {
	         File f = new File(saveFolder + "\\" + file.getR_file_name());
	         //값의 유무검사 + 삭제
	         if(f.exists()) {
	            f.delete();
	         }
	      }*/
	      
	      
	      //댓글 전체 삭제
	      r_dao.deleteReplyAll(review_idx);
	      //게시글 전체삭제
	      r_dao.deleteReview(review_idx);
	      
	      forward.setRedirect(true);
	      forward.setPath(req.getContextPath() + "/review/ReviewList.rv");
	      
	      return forward;
	   }

	}