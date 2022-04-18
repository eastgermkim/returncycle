package com.koreait.app.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.action.Action;
import com.koreait.action.ActionForward;
import com.koreait.app.Deliver.dao.DeliverDAO;
import com.koreait.app.member.dao.MemberDAO;
import com.koreait.app.member.vo.MemberVO;
import com.koreait.app.payback.dao.PaybackDAO;
import com.koreait.app.review.dao.ReviewDAO;

public class MemberViewAction implements Action{
	
	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		req.setCharacterEncoding("UTF-8");
		
		MemberDAO m_dao = new MemberDAO();
		MemberVO m_vo = new MemberVO();
		
		DeliverDAO d_dao = new DeliverDAO();
		PaybackDAO p_dao = new PaybackDAO();
		ReviewDAO r_dao = new ReviewDAO();
		ActionForward forward = new ActionForward();
		
		/* String u_id = req.getParameter("u_id"); */
		String u_id = (String)req.getParameter("u_id");
		
		m_vo = m_dao.getDetail(u_id);
		
		if(m_vo != null) {
			req.setAttribute("memberBean", m_dao.getDetail(u_id));
			req.setAttribute("deliverCount", d_dao.getMyCount(u_id));
			req.setAttribute("paybackCount", p_dao.getMyCount(u_id));
			req.setAttribute("reviewCount", r_dao.getMyCount(u_id));
			forward.setRedirect(false);
			forward.setPath("/app/member/mypage.jsp");
			return forward;		
		}
		return null;
	}
}
