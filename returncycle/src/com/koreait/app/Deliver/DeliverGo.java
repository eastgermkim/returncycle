package com.koreait.app.Deliver;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.koreait.action.Action;
import com.koreait.action.ActionForward;
import com.koreait.app.Deliver.dao.DeliverDAO;
import com.koreait.app.Deliver.vo.DeliverVO;
import com.koreait.app.apply.dao.ApplyDAO;

public class DeliverGo implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {

		ActionForward forward = null;
		
		HttpSession session = req.getSession();
		
		ApplyDAO a_dao = new ApplyDAO();
		DeliverDAO d_dao = new DeliverDAO();
		DeliverVO d_vo = new DeliverVO();
		
		
		d_vo.setR_uid(req.getParameter("r_uid"));
		d_vo.setR_wdate(req.getParameter("r_wdate"));
		d_vo.setR_wtime(req.getParameter("r_wtime"));
		d_vo.setR_id(req.getParameter("r_id"));
		d_vo.setR_name(req.getParameter("r_name"));
		d_vo.setR_phone(req.getParameter("r_phone"));
		d_vo.setR_address(req.getParameter("r_address"));
		d_vo.setR_plastic(Integer.parseInt(req.getParameter("r_plastic")));
		d_vo.setR_vinyl(Integer.parseInt(req.getParameter("r_vinyl")));
		d_vo.setR_can(Integer.parseInt(req.getParameter("r_can")));
		d_vo.setR_glass(Integer.parseInt(req.getParameter("r_glass")));
		d_vo.setR_paper(Integer.parseInt(req.getParameter("r_paper")));
		d_vo.setR_point(Integer.parseInt(req.getParameter("r_point")));
		
		String result_name = req.getParameter("r_name");
		String r_uid = req.getParameter("r_uid");
		String r_id = req.getParameter("r_id");
		int r_point = Integer.parseInt(req.getParameter("r_point"));
		
		Map map = new HashMap();
		map.put("r_id", r_id);
		map.put("r_point", r_point);
		
		if(!d_dao.deliver(d_vo)) {
			PrintWriter out = resp.getWriter();
			resp.setContentType("text/html;charset=utf-8");
			out.println("<script>");
			out.println("alert('모든 입력사항을 입력하세요.')");
			out.println("</script>");
			out.close();
		}else {
			forward = new ActionForward();
			forward.setRedirect(false);
			d_dao.pointPlus(map);
			a_dao.deleteApply(r_uid);
			session.setAttribute("session_result", result_name);
			forward.setPath("/deliver/DeliverResult.do");
		}
		
		return forward;
	}
}
















