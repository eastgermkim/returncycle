package com.koreait.app.member;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.action.Action;
import com.koreait.action.ActionForward;
import com.koreait.app.apply.dao.ApplyDAO;
import com.koreait.app.apply.vo.ApplyVO;

public class MyApplyUpdateOk implements Action{
	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		 req.setCharacterEncoding("UTF-8");
		 resp.setCharacterEncoding("UTF-8");
		 
		 ActionForward forward = null;
		 
		 ApplyDAO a_dao = new ApplyDAO();
		 
		 try { 
			 ApplyVO a_vo = new ApplyVO();
			 String a_uid = req.getParameter("a_uid");
			 String a_id = req.getParameter("a_id");
			 String a_name = req.getParameter("a_name");
			 
			 a_vo.setA_uid(a_uid);
			 a_vo.setA_id(a_id);
			 a_vo.setA_name(a_name);
			 a_vo.setA_email(req.getParameter("a_email") + req.getParameter("selected_email"));
			 a_vo.setA_phone(req.getParameter("a_phone"));
			 a_vo.setA_zipcode(req.getParameter("a_zipcode"));
			 a_vo.setA_address(req.getParameter("a_address"));
			 a_vo.setA_address_detail(req.getParameter("a_address_detail"));
			 a_vo.setA_request(req.getParameter("a_request"));
			 a_vo.setA_wdate(req.getParameter("a_wdate"));
			 a_vo.setA_wtime(req.getParameter("a_wtime"));
			 a_vo.setA_plastic(Integer.parseInt(req.getParameter("a_plastic")));
			 a_vo.setA_vinyl(Integer.parseInt(req.getParameter("a_vinyl")));
			 a_vo.setA_can(Integer.parseInt(req.getParameter("a_can")));
			 a_vo.setA_glass(Integer.parseInt(req.getParameter("a_glass")));
			 a_vo.setA_paper(Integer.parseInt(req.getParameter("a_paper")));
			 a_vo.setA_point(Integer.parseInt(req.getParameter("a_point")));
			 
			a_dao.updateApply(a_vo);
			 
			forward = new ActionForward();
				
			forward.setRedirect(true);
			forward.setPath(req.getContextPath() + "/app/member/myApplyResult.jsp");
		 } catch (Exception e) {
			//자바스크립트로 안내 메세지 응답
			 	resp.setContentType("text/html;charset=UTF-8");
				PrintWriter out = resp.getWriter();
				out.println("<script>");
				out.println("alert('신청 수정 실패. 다시 시도해주세요.')");
				out.println("</script>");
				out.close();
		 }
		 return forward;
	}
}
