<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<c:set var="paybackBean" value="${requestScope.paybackBean}"/>
<!DOCTYPE HTML>
		<!-- Header -->
		<%@ include file="/header.jsp" %>
	<!-- Main -->	

		<head>
		<title>Untitled</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/main.css" />
		</head>
		
			<c:if test="${session_id eq null}">
				<script>
					alert("로그인 후 이용해주세요");
					location.replace("${pageContext.request.contextPath}/member/MemberLogin.me");
				</script>
			</c:if>
	
	<c:set var="p_point" value="${requestScope.p_point}"/>
			
				<section id="main" class="wrapper style1">
				<header class="major">
									<h2>PaybackOrder</h2>
									<p>물품교환을 할 물품을 선택 후 필수 입력 사항을 입력해주세요</p>
				</header>
				<div class="container">
					<form id="paybackForm" name="paybackForm" action="${pageContext.request.contextPath}/payback/PaybackOk.py" method="post">
					<!-- Content -->								  
					<section id="p_info1">
					<h3>필수 입력 사항</h3><br>
					<div class="row gtr-uniform">
					<div class="col-6 col-12-small">
							<h4>ID</h4>
							<input type="text" id="p_id" name="p_id" value="<%=session.getAttribute("session_id")%>"><br>
							<h4>이름</h4>
							<input type="text" name="p_name" id="p_name" placeholder="이름"  value="${paybackBean.getU_last_name()}${paybackBean.getU_first_name()}">
							<br>
							
							<h4>휴대전화</h4>
							<input type="text" name="p_phone" id="p_phone" placeholder="핸드폰번호" value="${paybackBean.getU_phone()}"/>
							<span style="vertical-align:middle;">
							<input type="checkbox" id="safety_number" name="safety_number" checked>
							<label for="safety_number" style="padding-left:1.5em;margin-top:0.5rem; float:right;">안심번호 사용</label>
							</span><br>
							
							<h4>이메일</h4>
							<div class="col-6 col-12-small">
							<input type="text" name="p_email" id="p_email" placeholder="이메일" value="${paybackBean.getU_email()}"/>

							<!--  <div class="col-6 col-12-small">
							<select name="select_email" id="select_email">
								<option value="">- 이메일 -</option>
								<option value="naver.com">네이버</option>
								<option value="hanmail.net">다음</option>
								<option value="gmail.com">구글</option>
								<option value="nate.com">네이트</option>
								<option value="0">직접입력</option>
							</select>
							</div>  -->
							</div>
									
							 <!-- <div style="margin-top:0.5rem;">
							<input type="text" name="selected_email" id="selected_email" placeholder="이메일"/>
							</div>  -->
						<br>
							
					</div>
							
					<div class="col-6 col-12-small">
							<h4>우편번호</h4>
							<div style="display:inline">
							<input type="text" name="p_zipcode" id="p_zipcode" value="${paybackBean.getU_zipcode()}"  style="display:inline; width:13.5rem;" required>
							<input type="button" name="find_zipcode" id="find_zipcode" value="우편번호 찾기" style="display: inline;">
							</div>
							
							<div>	
							<br>
							<h4>주소</h4>
							<input type="text" name="p_address" id="p_address" value="${paybackBean.getU_address()}"  required>
							<br>
							</div>
							
							<div>
							<h4>상세주소</h4>
							<textarea name="p_address_detail" id="p_address_detail" placeholder="상세 주소를 입력해 주세요" rows="3" style="resize: none; height:auto;">${paybackBean.getU_address_detail()}</textarea>
							<br>
							</div>
								
						<br>
						</div>
						
						
							<div class="col-12">
							<h3>요청 사항</h3>
								<select name="p_request" id="p_request" name="p_request">
									<option value="1">- 배달 요청사항 -</option>
									<option value="1">조심히 안전하게 와주세요 :)</option>
									<option value="1">벨 누르지 말고 노크해주세요</option>
									<option value="1">도착하기 전에 전화해주세요</option>
									<option value="1">요청사항 없음</option>
								</select>
							</div>
						
							<div class="col-12">
							<h3>신청 물품과 포인트</h3>
								${p_order} : ${p_point}
								<input type="hidden" id="p_order" name = "p_order" value="${p_order}" readonly>
								<input type="hidden" id="p_point" name = "p_point" value="${p_point}" readonly>
								<%-- <select name="p_order" id="p_order" name="p_order">
									<option value="1">${p_point}</option>
									<option value="1">10,000_Point_1</option>
									<option value="2">10,000_Point_2</option>
									<option value="3">20,000_Point_1</option>
									<option value="3">20,000_Point_2</option>
									<option value="4">30,000_Point_1</option>
									<option value="5">30,000_Point_2</option>
									<option value="6">40,000_Point_1</option>
									<option value="7">40,000_Point_2</option>
									<option value="8">50,000_Point_1</option>
									<option value="9">50,000_Point_2</option>
								</select> --%>
								<br>
							</div><br>
							<div class="col-12" style="margin:0 auto">
						 <ul class="actions">
							<li style="margin:0 auto;">
								<input type="submit" id="submit" name="submit" value="신청하기" class="button" onClick="location.href='javascript:formSubmit()'" style="font-size:100%; background-color:#62BD83; color:white!important;">
								&nbsp;&nbsp;<input type="reset" value="정보 초기화" style="font-size:100%; float:right">
							</li>
						</ul>
						</div></div>
						</section>
	</form></div></section>
	
	
	
			<!-- Footer -->
				<footer id="footer">
					<%@ include file = "/footer.jsp" %>
				</footer>
	
			<!-- Scripts -->
	<script src="//code.jquery.com/jquery-3.5.1.min.js"></script>
	<script>var contextPath = "${pageContext.request.contextPath}";</script>
	<script src="https://ssl.daumcdn.net/dmaps/map_js_init/postcode.v2.js"></script>
	<%@ include file = "/app/payback/paybackFormJS.jsp" %>
	
	<script>
	$(document).ready(function(){
		var u_point = ${paybackBean.getU_point()};
		var p_point = ${p_point};
		if(u_point*1 < p_point*1){
			alert("보유하신 포인트가 적습니다.")
			window.history.back();
		};
	});
	</script>
