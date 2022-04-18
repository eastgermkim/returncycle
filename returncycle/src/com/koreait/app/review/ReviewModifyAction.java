package com.koreait.app.review;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.action.Action;
import com.koreait.action.ActionForward;
import com.koreait.app.review.dao.ReviewDAO;

public class ReviewModifyAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		
		ReviewDAO r_dao = new ReviewDAO();
		ActionForward forward = new ActionForward();
		
		//상세보기에서 보고있던 게시글 번호를 전달받은후
		int review_idx = Integer.parseInt(req.getParameter("seq"));
		
		//수정할 페이지에 뿌려줄 데이터를 req에 담아서 전달해준다.
		req.setAttribute("reviewBean", r_dao.getDetail(review_idx));
		
		//req를 유지하기 위해서 forward방식을 사용한다.
		forward.setRedirect(false);
		//응답 페이지에서는 reviewBean을 통해서 기존 게시글 정보를 표현할수있게 된다.
		forward.setPath("/app/review/reviewModify.jsp");
		
		return forward;
	}

}
