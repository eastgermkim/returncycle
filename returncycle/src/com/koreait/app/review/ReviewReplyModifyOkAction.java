package com.koreait.app.review;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.action.Action;
import com.koreait.action.ActionForward;
import com.koreait.app.review.dao.ReviewDAO;
import com.koreait.app.review.vo.ReviewReplyVO;

public class ReviewReplyModifyOkAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		req.setCharacterEncoding("UTF-8");
		
		ReviewDAO r_dao = new ReviewDAO();
		ReviewReplyVO rr_vo = new ReviewReplyVO();
		ActionForward forward = new ActionForward();
		
		int review_reply_num = Integer.parseInt(req.getParameter("review_reply_num"));
		int review_idx = Integer.parseInt(req.getParameter("seq"));
		String review_reply_content = req.getParameter("review_reply_content" + req.getParameter("num"));
		
		rr_vo.setReview_idx(review_idx);
		rr_vo.setReview_reply_num(review_reply_num);
		rr_vo.setReview_reply_content(review_reply_content);
		
		r_dao.updateReviewReply(rr_vo);
		
		forward.setRedirect(true);
		forward.setPath(req.getContextPath() + "/review/ReviewView.rv?seq="+review_idx);

		return forward;
	}

}
