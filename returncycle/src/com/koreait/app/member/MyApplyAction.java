package com.koreait.app.member;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.action.Action;
import com.koreait.action.ActionForward;
import com.koreait.app.apply.dao.ApplyDAO;
import com.koreait.app.apply.vo.ApplyVO;

public class MyApplyAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		req.setCharacterEncoding("UTF-8");

		ApplyDAO a_dao = new ApplyDAO();
		ApplyVO a_vo = new ApplyVO();
		
		  String a_id = req.getParameter("a_id");
		  
		  a_vo = a_dao.getInfo(a_id);
		  
		  if(a_id == null) {
			  PrintWriter out = resp.getWriter();
				resp.setContentType("text/html;charset=utf-8");
				out.println("<script>");
				out.println("alert('로그인 후 이용해 주세요')");
				out.println("</script>");
				out.close();
			 }
		  else{
			  req.setAttribute("applyBean", a_vo); 
			  ActionForward forward = new ActionForward();
			  forward.setRedirect(false);
			  forward.setPath("/app/member/myApply.jsp");
			  return forward;
		  }
		  
		  return null;
	}
}