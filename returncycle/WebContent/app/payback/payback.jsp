<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML>
<!--
	Drift by Pixelarity
	pixelarity.com | hello@pixelarity.com
	License: pixelarity.com/license
-->
<html>
<head>
<title>Untitled</title>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, user-scalable=no" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/main.css" />
</head>
<body class="is-preload">
	<c:if test="${session_id eq null}">
		<script>
			alert("로그인 후 이용해주세요");
			location.replace("${pageContext.request.contextPath}/member/MemberLogin.me");
		</script>
	</c:if>
	
	<c:set var="Point" value="${requestScope.Point}"/>
	
	<!-- Header -->
	<%@ include file="/header.jsp" %>

	<!-- Main -->
	<section id="three" class="wrapper style1">
		<header class="major">
			<h2>PayBack</h2>
			<p>재활용 활동을 열심히 해준 당신에게</p>
		</header>
		<div class="container">

			<!-- Content -->
			<section id="content">
				<a href="#" class="image fit"><img src="${pageContext.request.contextPath}/images/payback1.png"
					alt="" /></a>
				<h3>재활용 활동을 열심히 한 당신에게 선물을 드립니다.</h3>
				<p>페이백 포인트의 적립방법과 사용법</p>
				<ul>
					<li>재활용 종류 / 용량 / 상태에 따라서 포인트가 <strong>적립</strong>됩니다.
					</li>
					<li>자신이 보유한 페이백 포인트로 다양한 상품들을 고를 수 있습니다.</li>
					<li>신청한 상품의 페이백 포인트만큼 사용자의 포인트가 차감됩니다.</li>
					<li>상품의 배송기간은 3~20일 사이입니다.</li>
				</ul>
				<h3>
					<span style="font-size:110%;">당신의 포인트 : </span>
					<span style="color:red; font-size:160%">${Point}</span> Point</p>
				</h3>

			</section>
			<div class="row">
				<div class="col-4 col-6-medium col-12-small">
					<article class="box post">
						<a class="image fit"><img src="${pageContext.request.contextPath}/images/product5.JPG"
							alt="" /></a>
						<h3>TRIWA 시계</h3>
						<p>바다에 버려진 폐플라스틱을 이용하여, 지속가능한 상품으로 탈바꿈 시키는 스위스 회사 '#Tide
								Ocean Material'(이하 #Tide)과의 협업으로 만들어진 시계</p>
						<ul class="actions special">
							<li><a href="${pageContext.request.contextPath}/member/PaybackChoice.me?p_point=50000&&p_order=시계&&p_id=<%=session.getAttribute("session_id")%>" class="button">상품 신청하기(50,000pts)</a></li>
						</ul>
					</article>
				</div>
				<div class="col-4 col-6-medium col-12-small">
					<article class="box post">
						<a class="image fit"><img src="${pageContext.request.contextPath}/images/product7.JPG"
							alt="" /></a>
						<h3>ADIDAS 신발</h3>
						<p>바다에 떠다니다 회수된 폴리에스터를 주로 사용하여 제작된 운동화</p><br><br>
						<ul class="actions special">
							<li><a href="${pageContext.request.contextPath}/member/PaybackChoice.me?p_point=50000&&p_order=아디다스 운동화&&p_id=<%=session.getAttribute("session_id")%>" class="button">상품 신청하기(50,000pts)</a></li>
						</ul>
					</article>
				</div>
				<div class="col-4 col-6-medium col-12-small">
					<article class="box post">
						<a class="image fit"><img src="${pageContext.request.contextPath}/images/product4.JPG"
							alt="" /></a>
						<h3>가정용 분리수거 용기</h3>
						<p>4대 분리수거 물품을 집에서 분리하여 배출하거나, 모으기 유용하게 사용할 수 있는 가정용 분리수거 용기</p><br>
						<ul class="actions special">
							<li><a href="${pageContext.request.contextPath}/member/PaybackChoice.me?p_point=40000&&p_order=분리수거 용기&&p_id=<%=session.getAttribute("session_id")%>" class="button">상품 신청하기(40,000pts)</a></li>
						</ul>
					</article>
				</div>
				<div class="col-4 col-6-medium col-12-small">
					<article class="box post">
						<a class="image fit"><img src="${pageContext.request.contextPath}/images/product3.JPG"
							alt="" /></a>
						<h3>텀블러</h3>
						<p>폐 유리 / 폐플라스틱들을 주로 재활용 하여 만들어진 텀블러</p><br><br>
						<ul class="actions special">
							<li><a href="${pageContext.request.contextPath}/member/PaybackChoice.me?p_point=30000&&p_order=텀블러&&p_id=<%=session.getAttribute("session_id")%>" class="button">상품 신청하기(30,000pts)</a></li>
						</ul>
					</article>
				</div>
				<div class="col-4 col-6-medium col-12-small">
					<article class="box post">
						<a class="image fit"><img src="${pageContext.request.contextPath}/images/product6.JPG"
							alt="" /></a>
						<h3>머그잔</h3>
						<p>폐 유리를 재활용 하여 만들어진 머그잔</p><br><br><br>
						<ul class="actions special">
							<li><a href="${pageContext.request.contextPath}/member/PaybackChoice.me?p_point=30000&&p_order=머그잔&&p_id=<%=session.getAttribute("session_id")%>" class="button">상품 신청하기(30,000pts)</a></li>
						</ul>
					</article>
				</div>
				<div class="col-4 col-6-medium col-12-small">
					<article class="box post">
						<a class="image fit"><img src="${pageContext.request.contextPath}/images/product1.JPG"
							alt="" /></a>
						<h3>재활용 펜던트</h3>
						<p>우리 주위에서 버려지는 병뚜껑, 끈, 폐 건전지 등으로 만든 재활용 팬던트</p><br><br>
						<ul class="actions special">
							<li><a href="${pageContext.request.contextPath}/member/PaybackChoice.me?p_point=20000&&p_order=팬던트&&p_id=<%=session.getAttribute("session_id")%>" class="button">상품 신청하기(20,000pts)</a></li>
						</ul>
					</article>
				</div>
				<div class="col-4 col-6-medium col-12-small">
					<article class="box post">
						<a class="image fit"><img src="${pageContext.request.contextPath}/images/product2.JPG"
							alt="" /></a>
						<h3>재활용 폐 플라스틱 마스크</h3>
						<p>THE JOINERY에서 폐플라스틱으로 만든 마스크</p><br><br><br>
						<ul class="actions special">
							<li><a href="${pageContext.request.contextPath}/member/PaybackChoice.me?p_point=10000&&p_order=마스크&&p_id=<%=session.getAttribute("session_id")%>" class="button">상품 신청하기(10,000pts)</a></li>
						</ul>
					</article>
				</div>
			</div>
			<div style="text-align: center;">
				<a href="#"><strong>TOP</strong></a>
			</div>
		</div>
	</section>

	<!-- Footer -->
	<footer id="footer">
		<%@ include file = "/footer.jsp" %>
	</footer>

	<!-- Scripts -->
	<script>var contextPath = "${pageContext.request.contextPath}";</script>

</body>
</html>