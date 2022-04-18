package com.koreait.app.payback;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.action.Action;
import com.koreait.action.ActionForward;
import com.koreait.app.payback.dao.PaybackDAO;
import com.koreait.app.payback.vo.PaybackVO;

public class PaybackOkAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		 req.setCharacterEncoding("UTF-8");
		
		 ActionForward forward = null;
		 
		 PaybackDAO p_dao = new PaybackDAO();
		 PaybackVO p_vo = new PaybackVO();
		 
		 p_vo.setP_id(req.getParameter("p_id"));
		 p_vo.setP_name(req.getParameter("p_name"));
		 p_vo.setP_email(req.getParameter("p_phone"));
		 p_vo.setP_phone(req.getParameter("p_email"));
		 p_vo.setP_zipcode(req.getParameter("p_zipcode"));
		 p_vo.setP_address(req.getParameter("p_address"));
		 p_vo.setP_address_detail(req.getParameter("p_address_detail"));
		 p_vo.setP_request(req.getParameter("p_request"));
		 p_vo.setP_order(req.getParameter("p_order"));
		 p_vo.setP_point(Integer.parseInt(req.getParameter("p_point")));

		 String p_name = req.getParameter("p_name");
		 String p_id = req.getParameter("p_id");
		 int p_point = Integer.parseInt(req.getParameter("p_point"));
		 
		Map map = new HashMap();
		map.put("p_id", p_id);
		map.put("p_point", p_point);
		 
		 if(!p_dao.Payback(p_vo)) {
			 PrintWriter out = resp.getWriter();
			 resp.setContentType("text/html;charset=utf-8");
			 out.println("<script>");
			 out.println("alert('신청 실패. 잠시 후 다시 시도해주세요.')");
			 out.println("</script>");
			 out.close();
		 }else {
			 req.setAttribute("p_name", p_name);
			 p_dao.PointMinus(map);
			 forward = new ActionForward();
			 forward.setRedirect(false);
			 forward.setPath("/payback/Payback_result.py");
	}
		 return forward;
	}

}

