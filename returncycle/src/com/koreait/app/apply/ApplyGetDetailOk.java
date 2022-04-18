package com.koreait.app.apply;

import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.koreait.action.Action;
import com.koreait.action.ActionForward;
import com.koreait.app.apply.dao.ApplyDAO;
import com.koreait.app.apply.vo.ApplyVO;


public class ApplyGetDetailOk implements Action{
	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		//응답준비
		PrintWriter out = resp.getWriter();
		resp.setContentType("text/html;charset=utf-8");
		
		ApplyVO a_vo = new ApplyVO();
		ApplyDAO a_dao = new ApplyDAO();
		String a_uid = req.getParameter("a_uid");
		
		a_vo = a_dao.getDetail(a_uid);
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("a_date", a_vo.getA_date());
		map.put("a_uid", a_vo.getA_uid());
		map.put("a_wdate", a_vo.getA_wdate());
		map.put("a_wtime", a_vo.getA_wtime());
		map.put("a_id", a_vo.getA_id());
		map.put("a_name", a_vo.getA_name());
		map.put("a_email", a_vo.getA_email());
		map.put("a_phone", a_vo.getA_phone());
		map.put("a_zipcode", a_vo.getA_zipcode());
		map.put("a_address", a_vo.getA_address());
		map.put("a_address_detail", a_vo.getA_address_detail());
		map.put("a_request", a_vo.getA_request());
		map.put("a_plastic", a_vo.getA_plastic());
		map.put("a_vinyl", a_vo.getA_vinyl());
		map.put("a_can", a_vo.getA_can());
		map.put("a_glass", a_vo.getA_glass());
		map.put("a_paper", a_vo.getA_paper());
		map.put("a_point", a_vo.getA_point());
		JSONObject jsonObject = new JSONObject();
		
		jsonObject.putAll(map);
		
		if(a_uid != null) {
			out.println(jsonObject);
			/* out.println(id); */
		}else {
			out.println("not ok");
		}
		out.close();
		return null;
	}
}
