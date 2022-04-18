package com.koreait.app.review;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.action.ActionForward;

public class ReviewFrontController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req, resp);
	}
	
	protected void doProcess(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String requestURI = req.getRequestURI();
		String contextPath = req.getContextPath();
		String command = requestURI.substring(contextPath.length());
		
		ActionForward forward = null;
		
		switch(command) {
		case "/review/ReviewList.rv":
			try {
				forward = new ReviewListAction().execute(req, resp);
			}catch(Exception e) {
				e.printStackTrace();
			}
			break;
		case "/review/ReviewView.rv":
			try {
				forward = new ReviewViewAction().execute(req, resp);
			}catch(Exception e) {
				e.printStackTrace();
			}
			break;
		case "/review/ReviewWrite.rv":
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("/app/review/reviewWrite.jsp");
			break;
		case "/review/ReviewWriteOk.rv":
			try {
				forward = new ReviewWriteOkAction().execute(req, resp);
			}catch(Exception e) {
				e.printStackTrace();
			}
			break;
		case "/review/ReviewDeleteOk.rv":
			try {
				forward = new ReviewDeleteOkAction().execute(req, resp);
			}catch(Exception e) {
				e.printStackTrace();
			}
			break;
		case "/review/ReviewModify.rv":
			try {
				forward = new ReviewModifyAction().execute(req, resp);
			}catch(Exception e) {
				e.printStackTrace();
			}
			break;
		case "/review/ReviewModifyOk.rv":
			try {
				forward = new ReviewModifyOkAction().execute(req, resp);
			}catch(Exception e) {
				e.printStackTrace();
			}
			break;
		case "/review/ReviewReplyOk.rv":
			try {
				forward = new ReviewReplyOkAction().execute(req, resp);
			}catch(Exception e) {
				e.printStackTrace();
			}
			break;
		case "/review/ReviewReplyDeleteOk.rv":
			try {
				forward = new ReviewReplyDeleteOkAction().execute(req, resp);
			}catch(Exception e) {
				e.printStackTrace();
			}
			break;
		case "/review/ReviewReplyModifyOk.rv":
			try {
				forward = new ReviewReplyModifyOkAction().execute(req, resp);
			}catch(Exception e) {
				e.printStackTrace();
			}
			break;
			
		default:
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("/app/error/404.jsp");
		}
		
		//일괄처리
		if(forward != null) {
			if(forward.isRedirect()) {
				resp.sendRedirect(forward.getPath());
			}else {
				RequestDispatcher dispatcher = req.getRequestDispatcher(forward.getPath());
				dispatcher.forward(req, resp);
			}
		}
	}
}
