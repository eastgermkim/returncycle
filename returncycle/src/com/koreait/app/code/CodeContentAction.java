package com.koreait.app.code;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.koreait.action.Action;
import com.koreait.action.ActionForward;
import com.koreait.app.code.dao.CodeDAO;
import com.koreait.app.code.vo.CodeVO;
import com.koreait.app.member.dao.MemberDAO;

public class CodeContentAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		
		ActionForward forward = new ActionForward();

		String tempcode = req.getParameter("tempcode");
		CodeDAO c_dao = new CodeDAO();
			
		if(c_dao.CheckCode(tempcode)) {
			forward.setRedirect(true);
			forward.setPath(req.getContextPath() + "/code/codeCorrect.me");
			c_dao.deleteCode(tempcode);
		}else {
			PrintWriter out = resp.getWriter();
			resp.setContentType("text/html;charset=utf-8");
			out.println("<script>");
			out.println("alert('인증번호가 일치하지 않습니다.')");
			out.println("</script>");
			out.close();
		}
		return forward;
	}
}
















