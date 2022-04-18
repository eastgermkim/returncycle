package com.koreait.app.apply;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.action.Action;
import com.koreait.action.ActionForward;
import com.koreait.app.apply.dao.ApplyDAO;


public class ApplyListAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		
		ActionForward forward = new ActionForward();
		ApplyDAO a_dao = new ApplyDAO();
		
		//페이징 처리
		String temp = req.getParameter("page");
		
		//요청한 페이지가 없다면 default로 1페이지를 응답해주고,
		//요청한 페이지가 있다면 해당 페이지로 응답해준다.
		int page = temp == null ? 1 : Integer.parseInt(temp);
		
		//한 페이지 당 10개의 게시글이 보이도록 설정
		int pageSize = 5;
		
		//한 페이지에서 가장 마지막 행 번호
		int a_endRow = page * pageSize;
		
		//한 페이지에서 가장 첫번째 행 번호
		int a_startRow = a_endRow - (pageSize - 1);
		
		int a_totalCnt = a_dao.getApplyCnt();
		
		//10의 배수로
		int a_startPage = ((page - 1) / pageSize) * pageSize + 1;
		int a_endPage = a_startPage + 9;
		
		int a_realEndPage = (a_totalCnt - 1) / pageSize + 1;
		
		//실제 마지막 페이지와 연산으로 구한 마지막 페이지를 비교하여 일치하도록 해준다.
		a_endPage = a_endPage > a_realEndPage ? a_realEndPage : a_endPage;
		
		req.setAttribute("a_totalCnt", a_totalCnt);
		req.setAttribute("a_realEndPage", a_realEndPage);
		req.setAttribute("a_nowPage", page);
		req.setAttribute("a_startPage", a_startPage);
		req.setAttribute("a_endPage", a_endPage);
		req.setAttribute("ApplyList", a_dao.getApplyList(a_startRow, a_endRow));
		
		forward.setRedirect(false);
		forward.setPath("/app/deliver/deliver.jsp");
		
		return forward;
	}
}
