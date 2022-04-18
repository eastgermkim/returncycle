package com.koreait.app.apply;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.action.Action;
import com.koreait.action.ActionForward;
import com.koreait.app.apply.dao.ApplyDAO;
import com.koreait.app.apply.vo.ApplyVO;
/*import com.koreait.app.member.dao.MemberDAO;
import com.koreait.app.member.vo.MemberVO;*/

public class ApplyOkAction implements Action {
	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		
		ActionForward forward = null;

		ApplyDAO a_dao = new ApplyDAO();
		ApplyVO a_vo = new ApplyVO();
		/*
		 * MemberDAO m_dao = new MemberDAO(); MemberVO m_vo = new MemberVO();
		 * 
		 * String u_id = req.getParameter("u_id");
		 * 
		 * m_vo = m_dao.getDetail(u_id);
		 * 
		 * req.setAttribute("memberBean", m_vo);
		 * if(m_vo != null) { req.setAttribute("memberBean", m_vo); } 
		 */

			a_vo.setA_uid(req.getParameter("a_uid"));
			a_vo.setA_id(req.getParameter("a_id"));
			a_vo.setA_name(req.getParameter("a_name"));
			a_vo.setA_email(req.getParameter("a_email") + req.getParameter("selected_email"));
			a_vo.setA_phone(req.getParameter("a_phone"));
			a_vo.setA_zipcode(req.getParameter("a_zipcode"));
			a_vo.setA_address(req.getParameter("a_address"));
			a_vo.setA_address_detail(req.getParameter("a_address_detail"));
			a_vo.setA_request(req.getParameter("a_request")+req.getParameter("Requests_m"));
			a_vo.setA_wdate(req.getParameter("a_wdate"));
			a_vo.setA_wtime(req.getParameter("a_wtime"));
			a_vo.setA_plastic(Integer.parseInt(req.getParameter("a_plastic")));
			a_vo.setA_vinyl(Integer.parseInt(req.getParameter("a_vinyl")));
			a_vo.setA_can(Integer.parseInt(req.getParameter("a_can")));
			a_vo.setA_glass(Integer.parseInt(req.getParameter("a_glass")));
			a_vo.setA_paper(Integer.parseInt(req.getParameter("a_paper")));
			a_vo.setA_point(Integer.parseInt(req.getParameter("a_point")));
		
		
		if(!a_dao.Apply(a_vo)) {
			resp.setContentType("text/html;charset=utf-8");
			PrintWriter out = resp.getWriter();
			out.println("<script>");
			out.println("alert('신청 실패. 잠시 후 다시 후 시도해주세요.')");
			out.println("</script>");
			out.close();
		}else{
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("/apply/Apply_result.ap");
		}
		return forward;
	}

}