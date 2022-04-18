package com.koreait.app.member;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;

import com.koreait.action.Action;
import com.koreait.action.ActionForward;
import com.koreait.app.member.dao.MemberDAO;

public class MemberPointAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		req.setCharacterEncoding("UTF-8");

		MemberDAO m_dao = new MemberDAO();
		ActionForward forward = new ActionForward();

		/* String u_id = req.getParameter("u_id"); */

		String id = req.getParameter("id");
		String point = m_dao.getPoint(id);
		req.setAttribute("Point", point);
		forward.setRedirect(false);
		forward.setPath("/app/payback/payback.jsp");
		
		return forward;
	}
}
