package com.koreait.app.review;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.action.Action;
import com.koreait.action.ActionForward;
import com.koreait.app.review.dao.ReviewDAO;

public class ReviewReplyDeleteOkAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		
		ReviewDAO r_dao = new ReviewDAO();
		ActionForward forward = new ActionForward();
		
		int review_reply_num = Integer.parseInt(req.getParameter("review_reply_num"));
		int review_idx = Integer.parseInt(req.getParameter("seq"));
		
		r_dao.deleteReviewReply(review_reply_num);
		
		forward.setRedirect(true);
		forward.setPath(req.getContextPath() + "/review/ReviewView.rv?seq=" + review_idx);
		
		return forward;
	}

}
