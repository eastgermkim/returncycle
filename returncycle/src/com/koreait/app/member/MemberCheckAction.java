package com.koreait.app.member;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.koreait.action.Action;
import com.koreait.action.ActionForward;
import com.koreait.app.member.dao.MemberDAO;

public class MemberCheckAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		
		ActionForward forward = new ActionForward();
		
		MemberDAO m_dao = new MemberDAO();
		
		String id = req.getParameter("u_id");
		
		if(m_dao.getWho(id)==1) {
			forward.setRedirect(true);
			forward.setPath(req.getContextPath() + "/member/MemberYesId.me");
		}else {
			PrintWriter out = resp.getWriter();
			resp.setContentType("text/html;charset=UTF-8");
			out.println("<script>");
			out.println("alert('가입하신 아이디가 없습니다.')");
			out.println("window.close();");
			//returncycle1230_deliver << 자기 프로젝트 이름으로 변경
			out.println("</script>");
			out.close();
		}
		return forward;
	}
}
