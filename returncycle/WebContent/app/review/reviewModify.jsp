<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<!--
	Drift by Pixelarity
	pixelarity.com | hello@pixelarity.com
	License: pixelarity.com/license
-->

	<head>
		<title>Untitled</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/main.css" />
	</head>
	
	<%@ include file="/header.jsp" %>
	<!-- 리뷰작성 -->
<!-- 	<section id="main"> 배경 하얀색으로 전체
		<div class="container">
			<section id="content">
			<header class="major" style="padding: 1.0rem;">
				<h2 style="text-align:center">리뷰 작성 양식</h2>
			</header> -->
	<section id="main" class="wrapper style1">
   		<header class="major">
      		<h2>리뷰작성</h2>
        </header>
        <script>
				alert("수정시 기존에있던 첨부된사진은 삭제되니 새로운 사진을 첨부해주세요.");
		</script>
       	<div class="container">
			<form method="post" action="${pageContext.request.contextPath}/review/ReviewModifyOk.rv" enctype="multipart/form-data" name="modifyform">
				<input type="hidden" name="seq" value="${reviewBean.getReview_idx()}"/>
				<div class="row gtr-uniform">
					<div class="col-12">
						<input type="text" name="review_title" id="review_title" value="${reviewBean.getReview_title()}"  />
					</div>
					<div class="col-12">
						<input type="text" name="review_id" id="review_id" value="${session_id}" readonly/>
					</div>
					<div class="col-12">
						<textarea name="review_content" id="review_content" rows="6" maxlength="500" style="resize:none;">${reviewBean.getReview_content()}</textarea>
					</div>
						<div class="col-4 col-12-medium">
							<div class="image fit">
								<input name="review_file1" type="file"/>
								<input type="button" onclick="cancleFile('board_file1')" value="첨부 삭제">
							</div>
							<!-- <div class="image fit">
								<img src="images/review_sample1.jpg" alt="기본이미지"id="imgPostPhoto">
							</div>
                        	<div>
                        		<input type="file" name="imgfile"  style="width:221px;">
                       		</div> -->
                       	</div>
                       </div>
						<div class="col-6">
							<ul class="actions" style="padding: 1.5rem 0rem 1.5rem 0rem;">
								<li><a href="javascript:modifyReview()" class="button">수정</a></li>
								<li><a href="${pageContext.request.contextPath}/review/ReviewList.rv" class="button">목록</a></li>
							</ul>
						</div>
					
				</form>
			<!-- </section> -->
		</div>
	</section>
	
	<script src="//code.jquery.com/jquery-migrate-1.2.1.js"></script>
	<script>
		function modifyReview(){
			modifyform.submit();
		}
	</script>
	<script>
	function cancleFile(fileTagName){
		if($.browser.msie){	//ie일 때 초기화
			$("input[name='"+ fileTagName +"']").replaceWith($("input[name='"+ fileTagName +"']").clone(true));
		}else{ //그 외 브라우저일 때 초기화
			$("input[name='"+ fileTagName +"']").val("");
		}
	}	
	</script>
	<script>
	$(document).ready(function() {
	     $(document).scroll(function(){
	       if ($('#header').hasClass('alt')){
	           $('#logo').attr('src', "/images/logo_w.png");
	         }
	       else {
	           $('#logo').attr('src', "/images/logo_b.png");
	         }
	       });
	});
	</script>

<!-- Footer -->
			<%@ include file="/footer.jsp" %>