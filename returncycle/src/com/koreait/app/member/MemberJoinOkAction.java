package com.koreait.app.member;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.action.Action;
import com.koreait.action.ActionForward;
import com.koreait.app.member.dao.MemberDAO;
import com.koreait.app.member.vo.MemberVO;

public class MemberJoinOkAction implements Action {
	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		 req.setCharacterEncoding("UTF-8");
		
		 ActionForward forward = null;
		 
		 MemberDAO m_dao = new MemberDAO();
		 MemberVO m_vo = new MemberVO();
		 
//		 m_vo.setU_idx(Integer.parseInt(req.getParameter("u_idx")));
		 m_vo.setU_id(req.getParameter("u_id"));
		 m_vo.setU_pwd(req.getParameter("u_pwd"));
		 m_vo.setU_pwd_q(req.getParameter("u_pwd_q"));
		 m_vo.setU_pwd_a(req.getParameter("u_pwd_a"));
		 m_vo.setU_last_name(req.getParameter("u_last_name"));
		 m_vo.setU_first_name(req.getParameter("u_first_name"));
		 m_vo.setU_gender(req.getParameter("u_gender"));
		 m_vo.setU_email(req.getParameter("u_email"));
		 m_vo.setU_phone(req.getParameter("u_phone"));
//		 m_vo.setU_age(Integer.parseInt(req.getParameter("u_age")));
		 m_vo.setU_zipcode(req.getParameter("u_zipcode"));
		 m_vo.setU_address(req.getParameter("u_address"));
		 m_vo.setU_address_detail(req.getParameter("u_address_detail"));
//		 m_vo.setAdmin(Integer.parseInt(req.getParameter("admin")));
//		 m_vo.setU_point(req.getParameter("u_point"));
		 
		 if(!m_dao.join(m_vo)) {
			 //회원가입 실패시 이페이지에서 바로 응답을 해주며 resp를 사용한다.
			 //2중 응답을 막기위해 초기forward에 null이 담긴상태로 넘겨준다.
			 resp.setContentType("text/html;charset=utf-8");
			 PrintWriter out = resp.getWriter();
			 out.println("<script>");
			 out.println("alert('회원가입 실패. 잠시 후 다시 시도해주세요.')");
			 out.println("</script>");
			 out.close();
		 }else {
			 forward = new ActionForward();
			 forward.setRedirect(false);
			 forward.setPath("/member/MemberLogin.me");
	}
		 return forward;
	}

}
