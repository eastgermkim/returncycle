<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!--
   Drift by Pixelarity
   pixelarity.com | hello@pixelarity.com
   License: pixelarity.com/license
-->
<!-- Header -->
<%@ include file="/header.jsp" %>

   	<head>
		<title>ReturnCycle</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/main.css" />
	</head>
	
      <!-- Main -->
         <section id="main" class="wrapper style1">
            <header class="major">
               <h2>ReturnCycle Login</h2>
            </header>
            <div class="container">
            
			   	  <c:if test="${not empty param.login}">
			   	  		<c:if test="${not param.login}">
			   	  			<script>alert("아이디 또는 비밀번호를 다시 확인해주세요.")</script>
			   	  		</c:if>
			   	  </c:if>
               <!-- login -->
                  <section id="login">
                     <form name="loginForm" action="${pageContext.request.contextPath}/member/MemberLoginOk.me" method="post">   
                        <div class="row gtr-uniform" >
                           <div class="col-6 col-12-small" style="margin:0 auto;">
                              <label for="loginId">ID</label>
                                 <input type="text" maxlength="12" name="u_id" id="u_id" value="" placeholder="아이디 입력" required/>
                           <br>
                              <label for="loginPw">Password</label>
                                 <input type="password" maxlength="12" name="u_pwd" id="u_pwd" value="" placeholder="비밀번호 입력" required/>
                           </div>
                        </div>
                     </form>
                     <br>
                     
                     <!-- button -->
                     <ul class="actions">
                              <li style="margin:0 auto;">
                              	 <a href="javascript:loginForm.submit()" class="button">로그인</a>&nbsp;&nbsp;
                                 <!-- <input type="submit" value="로그인" class="primary" id="login" onClick="location.href='javascript:formSubmit()'"/> -->
                                 <a onclick="window.open('${pageContext.request.contextPath}/app/code/checkId.jsp','ID존재 확인','width=430,height=500,location=no,status=no,scrollbars=yes');" class="button">비밀번호 찾기</a>
                              </li>
                     </ul>
                  </section>
            </div>
         </section>
         
         
				<body onkeydown="javascript:EnterLogin();"></body>
		<script>
			function EnterLogin() {
				var keyCode = window.event.keyCode;
				if (keyCode == 13) {
					loginForm.submit();
				}
			}
		</script>
<!-- footer -->
<%@ include file = "/footer.jsp"%>