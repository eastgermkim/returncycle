package com.koreait.app.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.koreait.action.Action;
import com.koreait.action.ActionForward;

public class MemberLogOutAction implements Action {

   @Override
   public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
      HttpSession session = req.getSession();
      ActionForward forward = new ActionForward();
      
      //세션삭제
      session.invalidate();
      
      //다시 메인페이지로 이동
      forward.setRedirect(true);
      forward.setPath(req.getContextPath() + "/index.jsp");
      return forward;
   }

}