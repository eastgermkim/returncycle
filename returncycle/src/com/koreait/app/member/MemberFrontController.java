package com.koreait.app.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.action.ActionForward;

public class MemberFrontController extends HttpServlet{
	
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
		
		//Join.me 단순한 페이지이동
		//JoinOk.me DB조회필요
		//만일 사용자가 회원가입을 원한다면 
		if(command.equals("/member/MemberCheckIdOk.me")) {
			try {
				forward = new MemberCheckIdOk().execute(req, resp);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/member/MemberJoin.me")) {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("/app/member/joinForm.jsp");
			
		}else if(command.equals("/member/MemberJoinOk.me")) {
			try {
				forward = new MemberJoinOkAction().execute(req, resp);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/member/MemberLogin.me")){
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("/app/member/loginForm.jsp");
			
		}else if(command.equals("/member/MemberLogOut.me")) {
				try {
					forward = new MemberLogOutAction().execute(req, resp);
				} catch(Exception e) {
					e.printStackTrace();
				}	
		
		}else if(command.equals("/member/MemberLoginOk.me")) {
			try {
				forward = new MemberLoginOkAction().execute(req, resp);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/member/MemberView.me")) {
			try {
				forward = new MemberViewAction().execute(req, resp);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/member/myApplyAction.me")) {
			try {
				forward = new MyApplyAction().execute(req, resp);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/member/myApplyUpdateOk.me")) {
			try {
				forward = new MyApplyUpdateOk().execute(req, resp);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/member/MemberPoint.me")) {
		try {
			forward = new MemberPointAction().execute(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		}else if(command.equals("/member/PaybackChoice.me")) {
		try {
			forward = new PaybackChoiceAction().execute(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		}else if(command.equals("/member/MemberViewInfo.me")) {
			try {
				forward = new MemberViewInfo().execute(req, resp);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}else if(command.equals("/member/MemberModify.me")) {
		try {
			forward = new MemberModifyAction().execute(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
			}
		//id찾기
		}else if(command.equals("/member/MemberFindIdOk.me")) {
		try {
			forward = new MemberFindIdAction().execute(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//id찾기 실패시 id찾기 페이지로 이동
		}else if(command.equals("/member/MemberFindIdForm.me")){
		forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("/app/member/find_Id.jsp");
		
		//pw찾기 실패시 pw찾기 페이지로 이동
		}else if(command.equals("/member/MemberFindPwForm.me")){
		forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("/app/member/find_pw.jsp");
		
	//id찾기 성공시 결과 페이지 이동
	}else if(command.equals("/member/FindId_result.me")) {
		forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("/app/member/findId_result.jsp");
		
	//pw찾기 
	}else if(command.equals("/member/MemberFindPw.me")) {
		try {
			forward = new MemberFindPwAction().execute(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	//pw찾기 성공시 결과 페이지 이동
	}else if(command.equals("/member/FindPw_result.me")) {
		forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("/app/member/findPw_result.jsp");
	//pw찾기 이동시 사용자 있는지 확인
		
	}else if(command.equals("/member/MemberCheck.me")) {
		try {
			forward = new MemberCheckAction().execute(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}else if(command.equals("/member/MemberNoId.me")){
		forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("/app/member/find_Id.jsp");
		
	}else if(command.equals("/member/MemberYesId.me")){
		forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("/app/code/checkUserPw.jsp");
	}
		else {
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
