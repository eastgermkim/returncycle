package com.koreait.app.review;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.action.Action;
import com.koreait.action.ActionForward;
import com.koreait.app.review.dao.ReviewDAO;
import com.koreait.app.review.dao.ReviewFilesDAO;
import com.koreait.app.review.vo.ReviewFilesVO;
import com.koreait.app.review.vo.ReviewVO;

public class ReviewViewAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		req.setCharacterEncoding("UTF-8");
		
		ReviewFilesDAO rf_dao = new ReviewFilesDAO();
		ReviewDAO r_dao = new ReviewDAO();
		ReviewVO r_vo = new ReviewVO();
		
		int review_idx = Integer.parseInt(req.getParameter("seq"));
		
		r_vo = r_dao.getDetail(review_idx);
		
		ReviewFilesVO reviewFilesList = rf_dao.getDetail(review_idx);

		if(r_vo != null) {
			req.setAttribute("reviewBean", r_vo);
			req.setAttribute("reviewReplyBeanList", r_dao.getReviewReplyList(review_idx));
			if(reviewFilesList != null) {
				String uploadFile = reviewFilesList.getR_file_name();
				//String uploadFile = "s_"+reviewFilesList.getR_file_name();
/*				String saveFolder = "D:\\web_1530_rsy\\javascript\\workspace\\returncycle\\WebContent\\app\\upload";
				String uploadPath = saveFolder + "\\" + uploadFile;*/
				req.setAttribute("uploadFile", uploadFile);
				req.setAttribute("reviewFilesBeanList", reviewFilesList);
			}
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("/app/review/reviewView.jsp");
		return forward;
	}
	return null;
		
		
	}

}
