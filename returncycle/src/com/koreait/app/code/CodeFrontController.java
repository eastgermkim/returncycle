package com.koreait.app.code;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.action.ActionForward;

public class CodeFrontController extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req, resp);
	}
	
	protected void doProcess(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		
		//사용자의 요청 URI전체를 가지고온다. 예)www.naver.com/news/
		String requestURI = req.getRequestURI();
		
		//계속 반복되는 앞쪽의 URI를 잘라서 변수에 담아준다. 예)www.naver.com
		String contextPath = req.getContextPath();
		
		//앞쪽에서 잘라낸 URI로 사용자의 요청이 무엇인지 판단한다. 예)/news
		String command = requestURI.substring(contextPath.length());
		
		ActionForward forward = null;
		
		//사용자 정보에 전화번호가 있으면 인증번호 발송
		if(command.equals("/code/CodeCheckOK.cd")) {
			try {
				forward = new CodeOKAction().execute(req, resp);
			} catch (Exception e) {
				e.printStackTrace();
			}
		//번호와 인증번호가 db에 있으면 비밀번호 찾기로 이동
		}else if(command.equals("/code/CodeContentOK.cd")) {
			try {
				forward = new CodeContentAction().execute(req, resp);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("/app/error/404.jsp");
		}
		//위에서 forward에 뭔가가 담겨있을때
		if(forward != null) {
			//위에서 forward방식이 리다이랙트라면
			if(forward.isRedirect()) {
				resp.sendRedirect(forward.getPath());
			}else {
				//forward방식으로 전달할시 데이터를 다가지고 가기때문에 dispatcher를 사용해서 req, resp둘다 넘겨야한다.
				RequestDispatcher dispatcher = req.getRequestDispatcher(forward.getPath());
				dispatcher.forward(req, resp);
			}
		}
	}

}
