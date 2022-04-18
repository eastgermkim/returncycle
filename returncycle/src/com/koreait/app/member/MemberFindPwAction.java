package com.koreait.app.member;


import java.io.PrintWriter;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.action.Action;
import com.koreait.action.ActionForward;
import com.koreait.app.member.dao.MemberDAO;
import com.koreait.app.member.vo.MemberVO;

public class MemberFindPwAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		
		ActionForward forward = new ActionForward();
		MemberDAO m_dao = new MemberDAO();
		MemberVO m_vo = new MemberVO();
		
		m_vo.setU_id(req.getParameter("u_id"));
		m_vo.setU_phone(req.getParameter("u_phone"));
		m_vo.setU_pwd_q(req.getParameter("u_pwd_q"));
		m_vo.setU_pwd_a(req.getParameter("u_pwd_a"));

		String f_id = req.getParameter("u_id");
		String find_Pw = m_dao.findPw(m_vo);
		
		if(m_dao.findPw(m_vo) == null) {
			PrintWriter out = resp.getWriter();
			resp.setContentType("text/html;charset=UTF-8");
			out.println("<script>");
			out.println("alert('가입하신 아이디가 없습니다.')");
			out.println("window.location='/returncycle1230_deliver/member/MemberFindPwForm.me'");
			out.println("</script>");
			out.close();
		}else {
			req.setAttribute("f_id", f_id);
			req.setAttribute("find_Pw",m_dao.decrypt(find_Pw));
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("/member/FindPw_result.me");
		}
		return forward;
	}
}
