<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<!--
	Drift by Pixelarity
	pixelarity.com | hello@pixelarity.com
	License: pixelarity.com/license
-->
<html>
	<head>
		<title>ReturnCycle</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/main.css" />
		<link rel="stylesheet" type="text/css" href="assets/css/YouTubePopUp.css">
	</head>
	<body class="landing is-preload">

		<!-- Header -->
			<%@ include file="header.jsp" %>

		<!-- Banner -->
			<section id="banner">
 				<div class="inner"> 
					<br>
					<p style="margin:0 auto">함께 만들어 나가는</p>
					<h2>올바른 재활용 트렌드</h2>
					<p style="font-size:100%;">자신의 재활용 쓰레기로 만들어진 새로운 물건을 만나보세요</p>
					<br>
					<ul class="actions special">
						<li><a href="${pageContext.request.contextPath}/member/myApplyAction.me?a_id=<%=session.getAttribute("session_id")%>" class="button primary">신청하기</a></li>
					</ul>
					<br>
				</div>
			</section>

		<!-- One -->
			<section id="one" class="wrapper style1">
 				<div class="container">
					<header class="major">				
						<h2>한국은 재활용 강국일까요?</h2>
						<p style="font-size:90%">
						실제로 재활용되는 분리수거 쓰레기 비율이 <strong>30%</strong>라고 합니다.
						<br>
						경제협력개발기구(OECD)의 2013년 조사에 따르면,
						<br>
						한국의 전체 쓰레기 대비 재활용되거나 수거된 비율은 59%로 독일(65%)에 이어 세계 2위였습니다.
						<br> 
						그럼에도 불구하고 애초에 재활용이 어렵게 만들어진 제품이 많은 탓에
						<br>
						분리수거 등을 통해 수거된 쓰레기가 재활용되지 못하고 소각·매립되고 있습니다.
						<br>
						</p>
						<p>
						<strong>ReturnCycle과 함께 새로운 재활용 트렌드를 만들어 주세요.</strong>
						<br>
						</p>
						</header>
						</div>
						
					<div class="slider" style = "padding-bottom:5%;">
						<span class="nav-previous"></span>
						<div class="viewer" style="margin:0 auto;">
							<div class="reel">
								<div class = "slide">
								<iframe width="100%" height="100%" src="https://www.youtube.com/embed/_B_iUs_3x28" style="margin:0 auto;"></iframe>
								</div>
								<div class = "slide">
								<iframe width="100%" height="100%" src="https://www.youtube.com/embed/8_43WaXan1s" style="margin:0 auto;"></iframe>
								</div>
							</div>
						</div>
						<span class="nav-next"></span>
					</div>
			</section>
		<!-- Two -->
			<section id="two" class="wrapper style2">
				<div class="container">
				<div class="row">
						<div class="col-4 col-6-medium col-12-small">
							<article class="box post" style="height:90%;">
								<div style="text-align:left;">
								<img alt="" src="${pageContext.request.contextPath}/images/icon_plasitc.png">
 								<h3 style="display:inline;">플라스틱</h3>
								<p>
								폐기물의 구석구석을 살펴보면 다양한 재활용 마크가 표시되어 있다는 사실! 플라스틱이 다 같은 플라스틱이라는 생각은 잊고 각 재질에 따라 분리수거를 해주세요.
								<br>
								(PET, PVC, PP, PS, PE, PSP재질: 내용물을 깨끗이 비우고 다른 재질로 된 뚜껑이나 부착 상표 등을 제거한 후 압착해주세요.)
								</p><br>
								</div>
								<div>
								<a href="https://www.youtube.com/watch?v=w4KMk5mA9jE" class="button bla-1" style="font-size:1rem;width: -webkit-fill-available;">동영상으로 보기</a>
								</div>
							</article>
						</div>
						
						<div class="col-4 col-6-medium col-12-small">
							<article class="box post" style="height:90%;">
								<div style="text-align:left;">
								<img alt="" src="${pageContext.request.contextPath}/images/icon_vinyl.png">
 								<h3 style="display:inline;">비닐</h3>
								<p>이물질이 묻은 경우 씻어서 버려주세요. 오염됐을 경우 일반 종량제 봉투에 버려야 합니다!</p>
								</div>
								<div>
								<a href="https://www.youtube.com/watch?v=lgbDOxYSDV0" class="button bla-1" style="font-size:1rem;width: -webkit-fill-available;">동영상으로 보기</a>
								</div>
							</article>
						</div>
						
						<div class="col-4 col-6-medium col-12-small">
							<article class="box post" style="height:90%;">
								<div style="text-align:left;">
								<img alt="" src="${pageContext.request.contextPath}/images/icon_metal.png">
 								<h3 style="display:inline;">캔</h3>
								<p>
								<strong>철 캔, 알루미늄 캔 (음, 식용유)</strong> 
								<br>
								캔 속에 들어있는 내용물을 깨끗이 비우고 물로 헹군 후 배출 겉 또는 속의 플라스틱 뚜껑 등 제거, 담배꽁초 등 이물질을 넣지 말아 주세요.
								<br>
								<br>
								<strong>기타 캔 (부탄가스, 살충제 용기)</strong>
								<br> 
								구멍을 뚫어 내용물을 비운 후 배출해 주세요.
								</div>
								<div>
								<a href="https://https://www.youtube.com/watch?v=vxyWl9_JbCk" class="button bla-1" style="font-size:1rem;width:-webkit-fill-available;">동영상으로 보기</a>
								</div>
							</article>
						</div>
				</div>
				</div>
				
				<div class="container">
				<div class="row">
						<div class="col-4 col-6-medium col-12-small">
							<article class="box post" style="height:90%;">
								<div style="text-align:left;">
								<img alt="" src="${pageContext.request.contextPath}/images/icon_glass.png">
 								<h3 style="display:inline;">유리병</h3>
								<p>음료나 주류의 유리병도 이물질을 비우고 씻어낸 후 버려주세요. 단, 거울, 깨진 유리, 도자기, 유리식기 등은 유리병으로 취급되지 않기 때문에 커다란 자루나 종량제봉투에 버리셔야 해요!</p>
								</div>
								<div>
								<a href="https://https://www.youtube.com/watch?v=vxyWl9_JbCk" class="button bla-1" style="font-size:1rem;width: -webkit-fill-available;">동영상으로 보기</a>
								</div>
							</article>
						</div>
						
						<div class="col-4 col-6-medium col-12-small">
							<article class="box post" style="height:90%;">
								<div style="text-align:left;">
								<img alt="" src="${pageContext.request.contextPath}/images/icon_paper.png">
 								<h3 style="display:inline;">종이</h3>
								<p>종이만 묶음 해서 버리고, 이물질이 있는 경우 제거 후 투명봉투에 담아 배출해야 해요. 비닐 코팅된 광고지, 플라스틱, 알루미늄, 철사 등 이물질이 섞이지 않도록 합니다. 상자류는 펼쳐서 압축해서 부피를 최소화해주세요.</p>
								</div>
								<div>
								<a href="https://www.youtube.com/watch?v=Ddxn2rHhcyQ" class="button bla-1" style="font-size:1rem;width: -webkit-fill-available;">동영상으로 보기</a>
								</div>
							</article>
						</div>
						
						<div class="col-4 col-6-medium col-12-small">
							<article class="box post" style="height:90%;">
								<div style="text-align:left;">
								<img alt="" src="${pageContext.request.contextPath}/images/icon_deliver.png">
 								<h3 style="display:inline;">수거</h3>
								<p>제공된 분리수거 통이 채워졌을때, 사이트를 통해 신청해 주시면 담당 기사님이 수거하여 포인트를 적립해드립니다!</p>
								</div>
								<div>
								<a href="https://www.youtube.com/watch?v=E5p8Ql_hZYg" class="button bla-1" style="font-size:1rem;width: -webkit-fill-available;">동영상으로 보기</a>
								</div>
							</article>
						</div>
					</div>
					</div>
			</section>

		<!-- CTA -->
			<section id="cta" class="wrapper style3">
				<h2>올바른 분리수거로 새로운 물품을 교환 받아보세요!</h2>
				<ul class="actions">
					<li><a href="payback.html" class="button large">물품 교환하기</a></li>
				</ul>
			</section>

		<!-- Footer -->
			<%@ include file = "footer.jsp" %>
			
	<script>
	//스크롤 내리면 로고 변화
	$(document).ready(function() {
	     $(document).scroll(function(){
	    //헤더가 클래스 alt 가지고 있으면 로고 흰색
	       if ($('#header').hasClass('alt')){
	           $('#logo').attr('src', "images/logo_w.png");
	         }
	     //헤더가 클래스 alt 가지고 있지 않으면 로고 검정
	       else {
	           $('#logo').attr('src', "images/logo_b.png");
	         }
	       });
	});
	 
	
	</script>
	
	<script type="text/javascript" src="assets/js/YouTubePopUp.jquery.js"></script>
	<script type="text/javascript">
	
		//유투브 팝업 스크립트
		jQuery(function(){
			jQuery("a.bla-1").YouTubePopUp();
			jQuery("a.bla-2").YouTubePopUp( { autoplay: 0 } ); // Disable autoplay
		});
	
	</script>
	</body>
</html>