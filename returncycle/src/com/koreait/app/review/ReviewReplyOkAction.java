package com.koreait.app.review;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.koreait.action.Action;
import com.koreait.action.ActionForward;
import com.koreait.app.review.dao.ReviewDAO;
import com.koreait.app.review.vo.ReviewReplyVO;

public class ReviewReplyOkAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		
		ActionForward forward = null;
		HttpSession session = req.getSession();
		ReviewReplyVO rr_vo = new ReviewReplyVO();
		ReviewDAO r_dao = new ReviewDAO();
		//리뷰글 번호, 작성자, 댓글 내용
		
		int review_idx = Integer.parseInt(req.getParameter("seq"));
		String u_id = (String)session.getAttribute("session_id");
		String review_reply_content = req.getParameter("content");
		
		rr_vo.setReview_idx(review_idx);
		rr_vo.setU_id(u_id);
		rr_vo.setReview_reply_content(review_reply_content);
		
		if(r_dao.insertReviewReply(rr_vo)) {
			forward = new ActionForward();
			forward.setRedirect(true);
			forward.setPath(req.getContextPath() + "/review/ReviewView.rv?seq="+review_idx);
		}
		
		return forward;
	}

}
