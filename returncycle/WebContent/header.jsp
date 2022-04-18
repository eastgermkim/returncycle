<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
		<!-- Header -->
			<header id="header" class="reveal">
            <a href="${pageContext.request.contextPath}/index.jsp" style="border-bottom: 0px">
            <img  src="${pageContext.request.contextPath}/images/logo_b.png" id="logo" alt="" width=150px; style="margin: 0 auto; padding-left:10px; padding-top:5px" />
            </a>
            <nav id="nav">
               <ul>
               <% if(session.getAttribute("admin") == "admin"){%>
               	<li><a href="${pageContext.request.contextPath}/member/MemberLogOut.me">로그아웃</a></li>
	            <%-- <li><a href="${pageContext.request.contextPath}/mypage.html">마이페이지</a></li> --%>
				<%}else if(session.getAttribute("session_id")!= null){ %>
	             <li><p><%=session.getAttribute("session_id") %>님 </p></li>    
	             <li><a href="${pageContext.request.contextPath}/member/MemberLogOut.me">로그아웃</a></li>
	             <li><a href="${pageContext.request.contextPath}/member/MemberView.me?u_id=<%=session.getAttribute("session_id")%>">마이페이지</a></li>
	             <li><a href="${pageContext.request.contextPath}/review/ReviewList.rv">리뷰</a></li>
                  <li><a href="${pageContext.request.contextPath}/member/MemberPoint.me?id=<%=session.getAttribute("session_id")%>">물품교환</a></li>
                  <li><a href="${pageContext.request.contextPath}/apply/ApplyForm.ap?u_id=<%=session.getAttribute("session_id")%>"><strong><span style="color:#62BD83;">수거하기</span></strong></a></li>
	             <%}else{%>
	             <li><a href="${pageContext.request.contextPath}/member/MemberLogin.me">로그인</a></li>
	             <li><a href ="${pageContext.request.contextPath}/member/MemberJoin.me">회원가입</a></li>
                 <li><a href="${pageContext.request.contextPath}/review/ReviewList.rv">리뷰</a></li>
                 <li><a href="${pageContext.request.contextPath}/member/MemberPoint.me?id=<%=session.getAttribute("session_id")%>">물품교환</a></li>
                 <li><a href="${pageContext.request.contextPath}/apply/ApplyForm.ap?u_id=<%=session.getAttribute("session_id")%>"><strong><span style="color:#62BD83;">수거하기</span></strong></a></li>
	         	<%}%>
               </ul>
            </nav>
         </header>
         


