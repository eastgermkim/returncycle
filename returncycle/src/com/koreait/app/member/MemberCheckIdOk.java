package com.koreait.app.member;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.action.Action;
import com.koreait.action.ActionForward;
import com.koreait.app.member.dao.MemberDAO;

public class MemberCheckIdOk implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		req.setCharacterEncoding("UTF-8");
		
		//파라미터 id값을 받아온다
		String id = req.getParameter("id");
		MemberDAO m_dao = new MemberDAO();
		
		//응답준비
		PrintWriter out = resp.getWriter();
		resp.setContentType("text/html;charset=utf-8");
		
		//만일 받아온 id값으로 행한 checkID가 일치한다면 아이디 중복상태.
		if(m_dao.checkId(id)) {
			out.println("not ok");
		}else {
			out.println("ok");
		}
		out.close();
		return null;
	}

}
