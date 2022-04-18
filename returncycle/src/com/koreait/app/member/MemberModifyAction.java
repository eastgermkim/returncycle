package com.koreait.app.member;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.javassist.compiler.ast.Member;

import com.koreait.action.Action;
import com.koreait.action.ActionForward;
import com.koreait.app.member.dao.MemberDAO;
import com.koreait.app.member.vo.MemberVO;

public class MemberModifyAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		
		 ActionForward forward = null;
		 
		 MemberDAO m_dao = new MemberDAO();
		
		 
		try {
			MemberVO m_vo = new MemberVO();
			 m_vo.setU_id(req.getParameter("u_id"));
			 m_vo.setU_pwd(req.getParameter("u_pwd"));
			 m_vo.setU_gender(req.getParameter("u_gender"));
			 m_vo.setU_email(req.getParameter("u_email"));
			 m_vo.setU_phone(req.getParameter("u_phone"));
			 m_vo.setU_zipcode(req.getParameter("u_zipcode"));
			 m_vo.setU_address(req.getParameter("u_address"));
			 m_vo.setU_address_detail(req.getParameter("u_address_detail"));

			 m_dao.memberModify(m_vo);
			 
			 forward = new ActionForward();

			 forward.setRedirect(true);
			 forward.setPath(req.getContextPath() + "/app/member/infoResult.jsp");
		} catch (Exception e) {
			//자바스크립트로 안내 메세지 응답
			resp.setContentType("text/html;charset=utf-8");
			 PrintWriter out = resp.getWriter();
			 out.println("<script>");
			 out.println("alert('변경되지 않았습니다. 잠시 후 다시 시도해주세요.')");
			 out.println("</script>");
			 out.close();
		}
		return forward;
	}
}
