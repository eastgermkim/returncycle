package com.koreait.app.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.koreait.action.Action;
import com.koreait.action.ActionForward;
import com.koreait.app.member.dao.MemberDAO;

public class MemberLoginOkAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		req.setCharacterEncoding("UTF-8");
		
		HttpSession session = req.getSession();
		ActionForward forward = new ActionForward();
		
		MemberDAO m_dao = new MemberDAO();
		
		String id = req.getParameter("u_id");
		String pw = req.getParameter("u_pwd");
		
		if(m_dao.loginAdmin(id,"1")) {
			session.setAttribute("session_id", id);
			session.setAttribute("admin", "admin");
			forward.setRedirect(true);
			forward.setPath(req.getContextPath() + "/apply/ApplyList.ap");
			
		}
		else if(m_dao.login(id, pw)) {
			//로그인 성공 시 세션에 아이디 등록, /index.jsp 로 이동
			session.setAttribute("session_id", id);
			forward.setRedirect(true);
			forward.setPath(req.getContextPath() + "/index.jsp");
		
		}else {
			//로그인 실패 시 /app/memeber/loginForm.jsp?login=false로 이동
			forward.setRedirect(false);
			forward.setPath("/app/member/loginForm.jsp?login=false");
		}
		return forward;
	}
}
