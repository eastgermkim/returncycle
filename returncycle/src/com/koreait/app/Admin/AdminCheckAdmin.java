package com.koreait.app.Admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.koreait.action.Action;
import com.koreait.action.ActionForward;
import com.koreait.app.Admin.dao.AdminDAO;

public class AdminCheckAdmin implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		HttpSession session = req.getSession();
		ActionForward forward = new ActionForward();

/*		String id = req.getParameter("session_id");*/
		String id = req.getParameter("id");
		/*System.out.println(id);*/
		AdminDAO a_dao = new AdminDAO();

		boolean admin = a_dao.checkAdmin(id,"1");
		if(admin == false) {
			forward.setRedirect(true);
			forward.setPath(req.getContextPath() + "/Adminindex.jsp");
		}else {
			forward.setRedirect(false);
			forward.setPath("/404.jsp?checkAdmin=false");
		}
		return forward;
	}
}
















