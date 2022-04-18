package com.koreait.app.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.action.Action;
import com.koreait.action.ActionForward;
import com.koreait.app.member.dao.MemberDAO;
import com.koreait.app.member.vo.MemberVO;

public class PaybackChoiceAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {

		ActionForward forward = new ActionForward();
		MemberDAO m_dao = new MemberDAO();
		MemberVO m_vo = new MemberVO();
		
		String p_order = req.getParameter("p_order");
		String p_point = req.getParameter("p_point");
		String p_id = (String)req.getParameter("p_id");
		
		m_vo = m_dao.getDetail(p_id);
		
		if(m_vo != null) {
			req.setAttribute("p_point", p_point);
			req.setAttribute("p_order", p_order);
			req.setAttribute("paybackBean", m_dao.getDetail(p_id));
			forward.setRedirect(false);
			forward.setPath("/app/payback/paybackOrder.jsp");
			return forward;
		}
		return null;
	}
}
















