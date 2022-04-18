package com.koreait.app.apply;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.action.Action;
import com.koreait.action.ActionForward;
import com.koreait.app.apply.dao.ApplyDAO;

public class ApplyCheckOkAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		//응답준비
		PrintWriter out = resp.getWriter();
		resp.setContentType("text/html;charset=utf-8");
		
		ApplyDAO a_dao = new ApplyDAO();
		String a_id = req.getParameter("a_id"); 
		
		a_dao.checkApply(a_id);
		
		 if(a_dao.checkApply(a_id)) {
			 out.println("not-ok");
		 }else {
			 out.println("ok");
		 }
		 out.close();
		return null;
	}
}
