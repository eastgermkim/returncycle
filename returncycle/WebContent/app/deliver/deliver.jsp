<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>    
    
<!DOCTYPE HTML>
<!--
	Drift by Pixelarity
	pixelarity.com | hello@pixelarity.com
	License: pixelarity.com/license
-->
	<c:if test="${session_id eq null}">
			<script>
				alert("로그인 후 이용해주세요");
				location.replace("${pageContext.request.contextPath}/member/MemberLogin.me");
			</script>
	</c:if>
<c:set var="list" value="${requestScope.ApplyList}"/>
<c:set var="a_nowPage" value="${requestScope.a_nowPage}"/>
<c:set var="a_startPage" value="${requestScope.a_startPage}"/>
<c:set var="a_endPage" value="${requestScope.a_endPage}"/>
<c:set var="a_totalCnt" value="${requestScope.a_totalCnt}"/>
<c:set var="a_realEndPage" value="${requestScope.a_realEndPage}"/>
<c:set var="a_bean" value="${requestScope.applyBean}"/>
<c:set var="Detail" value="${requestScope.applyDetail}"/>

<html>
	<head>
		<title>수거하기</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/main.css" />
	</head>
	
	<body class="is-preload">
	
		<!-- Header -->
			<%@ include file="/header.jsp" %>
			
		<!-- Main -->
		<section id="main" class="wrapper style1">
			<header class="major">
				<h2>수거하기</h2>
				<p>신청된 수량에서 수거하신 수량을 입력해주세요</p>
			</header>
		<div class="container">
			<%@ include file="deliverList.jsp" %>
			<hr>
			<br>
			<br>
			<br>
			<article id="Deliver">
				<form name="deliverForm" action="${pageContext.request.contextPath}/Deliver/DeliverGo.do">	
					<div class="col-6 col-12-small" style="margin: 0 auto;">
							<input type="hidden" name="r_uid" id="r_uid" value="" placeholder="ID" readonly/><br>
							<input type="hidden" name="r_wdate" id="r_wdate" readonly/><br>
							<input type="hidden" name="r_wtime" id="r_wtime" readonly/><br>
						<label for="userId">사용자 ID</label>
							<input type="text" name="r_id" id="r_id" value="" placeholder="ID" readonly/><br>
						<label for="userName">신청자 이름</label>
							<input type="text" name="r_name" id="r_name" value="" placeholder="Name" readonly/><br>
						<label for="userPhone">신청자 전화번호</label>
							<input type="text" name="r_phone" id="r_phone" value="" placeholder="PhoneNumber" readonly/><br>
						<label for="userPhone">신청자 주소</label>
							<input type="text" name="r_address" id="r_address" value="" placeholder="주소" readonly/><br>
						<label for="userPhone">신청자 요청사항</label>
							<input type="text" name="r_request" id="r_request" value="" placeholder="요청사항" readonly/><br>
						<label for="reqItem">신청 품목</label>
						<div class="row gtr-uniform" style="margin-top:auto;">
						<div style="margin:0 auto">
							<h1 style="display:inline;">플라스틱</h1>
							<input type="text" name="r_plastic" id="r_plastic" class="recycle" value="" placeholder="플라스틱" /><br>
						</div>
						<div style="margin:0 auto">
							<h1 style="display:inline;">비닐</h1>
							<input type="text" name="r_vinyl" id="r_vinyl" class="recycle" value="" placeholder="비닐" /><br>
						</div>
						<div style="margin:0 auto">
							<h1 style="display:inline;">캔</h1>
							<input type="text" name="r_can" id="r_can" class="recycle" value="" placeholder="캔" /><br>
						</div>
					</div>
					<div class="row gtr-uniform" style="margin-top:auto;">
						<div style="margin:0 auto">
							<h1 style="display:inline;">유리</h1>
							<input type="text" name="r_glass" id="r_glass" class="recycle" value="" placeholder="유리" /><br>
						</div>
						<div style="margin:0 auto">
							<h1 style="display:inline;">종이</h1>
							<input type="text" name="r_paper" id="r_paper" class="recycle" value="" placeholder="종이" /><br>
						</div>
						<div style="margin:0 auto">
							<h1 style="display:inline;">적립 포인트</h1>
							<input type="text" name="r_point" id="r_point" value="" placeholder="적립 포인트" readonly/><br>
						</div>
						</div>
					</div>
							<br>

						<ul class="actions">
							<li style="margin:0 auto">
							<%-- <a href="javascript:deliverForm.submit()" class="button" onclick="function>수거하기</a> --%>
							<input type="submit" value="수거 하기" class="primary" id="DeliverSubmit" onsubmit="return delivercheck(this.form)"/>
							</li>
						</ul>
				</form>
			</article>
		</div>
	</section>

	<!-- Footer -->
		<%@ include file = "/footer.jsp" %>

	<!-- Scripts -->
		<script>var contextPath = "${pageContext.request.contextPath}";</script>
		<script src="//code.jquery.com/jquery-3.4.1.min.js"></script>
		<script src="${pageContext.request.contextPath}/app/deliver/deliverListDetail.js"></script>
		
		<script>
		
		
		$(document).on('keyup',function(){
	          var cnt = $(".recycle").length;     
	          console.log(cnt);
			  
	          //반복
			  for(var i=1; i<cnt; i++){
				 // * 뒤에 숫자가 재활용품별 포인트
				 var point_pla = $("#r_plastic").val() * 300;
				 var point_vi = $("#r_vinyl").val() * 200;
				 var point_can = $("#r_can").val() * 100;
				 var point_gl = $("#r_glass").val() * 50;
				 var point_pa = $("#r_paper").val() * 50;
				 
				 // 포인트 합계
				 var point_sum = point_pla + point_vi + point_can + point_gl + point_pa;
				 /* console.log(point_sum); */
				 console.log(point_pa);
			     $("#r_point").val(point_sum);
			  		}
	        });

$(document).ready(function delivercheck() {
$("#DeliverSubmit").on('click',function(){
 //id가 없으면
 if($("#r_id").val() == ""){
    alert("사용자 ID를 입력해주세요.");
    $("#r_id").focus();
    return false;
 }
 //사용자 이름이 없으면
 if($("#r_name").val() == ""){
    alert("신청자 이름을 입력해주세요.");
    $("#r_name").focus();
    return false;
 }
 //핸드폰 번호가 없으면
 if($("#r_phone").val() == ""){
    alert("핸드폰 번호를 입력해주세요.");
    $("#r_phone").focus();
    return false;
 }
 //물품 종류 미 선택시
 if($("#r_item").val() == ""){
    alert("물품을 선택해주세요");
    $("#r_item").focus();
    return false;
 }
 //용량 선택 안헀으면
 if($("#r_capacity").val() == ""){
    alert("물품용량을 선택해주세요");
    $("#r_capacity").focus();
    return false;
 }
 //다 만족하면 true, 결과 페이지 이동
    return true;
 });	   
});
		</script>
	</body>
</html>