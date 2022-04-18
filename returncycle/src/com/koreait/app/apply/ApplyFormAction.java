package com.koreait.app.apply;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.action.Action;
import com.koreait.action.ActionForward;
import com.koreait.app.member.dao.MemberDAO;
import com.koreait.app.member.vo.MemberVO;

public class ApplyFormAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		req.setCharacterEncoding("UTF-8");
		
		  MemberDAO m_dao = new MemberDAO(); 
		  MemberVO m_vo = new MemberVO();
		  String u_id = req.getParameter("u_id");
		  
		  m_vo = m_dao.getDetail(u_id);
		  
		  if(u_id == null) {
			  PrintWriter out = resp.getWriter();
				resp.setContentType("text/html;charset=utf-8");
				out.println("<script>");
				out.println("alert('로그인 후 이용해 주세요')");
				out.println("</script>");
				out.close();
			 }
			
		  else{
			  req.setAttribute("memberBean", m_vo); 
			  ActionForward forward = new ActionForward();
			  forward.setRedirect(false);
			  forward.setPath("/app/apply/applyForm.jsp");
			  return forward;
		  }
		  
		  return null;
	}
}
