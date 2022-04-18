package com.koreait.app.code;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.koreait.action.Action;
import com.koreait.action.ActionForward;
import com.koreait.app.code.dao.CodeDAO;
import com.koreait.app.code.vo.CodeVO;
import com.koreait.app.member.dao.MemberDAO;

public class CodeOKAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		HttpSession session = req.getSession();
		ActionForward forward = new ActionForward();

		String c_phone = req.getParameter("c_phone");

		CodeDAO c_dao = new CodeDAO();
		CodeVO c_vo = new CodeVO();
		MemberDAO m_dao = new MemberDAO();
		CodeGenerator cg = new CodeGenerator();
		
		String code = cg.CreateCode();
		
		if(m_dao.Phone(c_phone)==1) {
			cg.goMessage(c_phone, code);
			c_dao.insertCode(c_phone, code);
			forward.setRedirect(true);
		}else {
			forward.setRedirect(false);
			forward.setPath("/404.jsp?checkAdmin=false");
		}
		return forward;
	}
}
















