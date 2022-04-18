<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<!--
	Drift by Pixelarity
	pixelarity.com | hello@pixelarity.com
	License: pixelarity.com/license
-->
<%@ include file = "/header.jsp" %>

	<head>
		<title>Untitled</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/main.css" />
	<style>
      #columns{
        /* column-width:350px; */
        column-gap: 0px;
      }
      #columns figure{
        display: inline-block;
        border:1px solid rgba(0,0,0,0.2);
        margin:0;
        margin-bottom: 15px;
        padding:10px;
        box-shadow: 2px 2px 5px rgba(0,0,0,0.5);;
      }
      #columns figure figcaption{
        border-top:1px solid rgba(0,0,0,0.2);
        padding:10px;
        margin-top:11px;
      }
    </style>
	</head>
	
<!-- 리뷰 목록창 -->
	<section id="main" class="wrapper style1">
            <header class="major">
               <h2>리뷰 게시판</h2>
                 <%-- <ul class="actions" style="padding: 1.0rem; float:right;">
					<li><a href="${pageContext.request.contextPath}/app/review/reviewWrite.jsp" class="button primary">리뷰작성하기</a></li>
				</ul> --%>
            </header>
            
        <c:set var="list" value="${requestScope.reviewList}"/>
        <c:set var="filenames" value="${requestScope.filenames}"/>
		<c:set var="nowPage" value="${requestScope.nowPage}"/>
		<c:set var="startPage" value="${requestScope.startPage}"/>
		<c:set var="endPage" value="${requestScope.endPage}"/>
		<c:set var="totalCnt" value="${requestScope.totalCnt}"/>
		<c:set var="realEndPage" value="${requestScope.realEndPage}"/>
		
<%-- 		<c:choose>
			<c:when test="${filenames != null and fn:length(filenames) > 0}">
				<c:set var="i" value="${0}"/>
					<c:forEach var="filenames" items="${filenames}">
						<c:set var="filenames${i}" value="${filenames}"/>
							<p>${filenames${i}}</p>
					</c:forEach>
			</c:when>
		</c:choose>
		 --%>
 
	<div class="container">
		<div id="columns">
		<c:choose>
		<c:when test="${list != null and fn:length(list) > 0}">
			<c:forEach var="i" begin="0" end="${fn:length(list) - 1}">
				<figure onclick="location='${pageContext.request.contextPath}/review/ReviewView.rv?seq=${list[i].getReview_idx()}'" style="height: 250px;width: 250px; vertical-align:top;">
     				<a href="${pageContext.request.contextPath}/review/ReviewView.rv?seq=${list[i].getReview_idx()}" style="border-bottom:none;">${list[i].getReview_title()}</a>
    			
				<c:choose>
					<c:when test="${filenames[i] == null}">
	      				<figcaption>${list[i].getReview_content()}</figcaption>		
					</c:when>
					<c:otherwise>
	      				<figcaption><img src="${pageContext.request.contextPath}/app/upload/${filenames[i]}" style="width:150px;"></figcaption>			
					</c:otherwise>
				</c:choose>
				</figure>
      		</c:forEach>
      	</c:when>
      	<c:otherwise>
      		<div class="container">
 				<p align="center" style="margin:0 0 0 0;">등록된 게시물이 없습니다.</p>
 			</div>
 		</c:otherwise>
 		</c:choose>
 		</div>
 		<a href="${pageContext.request.contextPath}/app/review/reviewWrite.jsp" class="button primary" style="margin-left: 87%;">리뷰작성하기</a>
     </div>
 	<table>
 		<tr align="center" valign="middle">
 			<td>
 			<c:choose>
 				<c:when test="${nowPage > 1}">
 					<a href="${pageContext.request.contextPath}/review/ReviewList.rv?page=${nowPage - 1}">[이전]</a>&nbsp;
 				</c:when>
 			</c:choose>
 			<c:forEach var="i" begin="${startPage}" end="${endPage}">
 				<c:choose>
 					<c:when test="${i eq nowPage}">
						[${i}]&nbsp;
					</c:when>
					<c:otherwise>
						<a href="${pageContext.request.contextPath}/review/ReviewList.rv?page=${i}">${i}&nbsp;</a>
					</c:otherwise>
				</c:choose>
			</c:forEach>
			<c:choose>
				<c:when test="${nowPage != realEndPage}">
					<a href="${pageContext.request.contextPath}/review/ReviewList.rv?page=${nowPage + 1}">[다음]</a>&nbsp;
				</c:when>
			</c:choose>

		</td>
	</tr>
</table>
</section>
	
<script>
/* 	$(window).on('load',function(){
		$('.landing').css('display','block')
	}); */
	/* $(document).ready(function() {
	     $(document).scroll(function(){
	       if ($('#header').hasClass('alt')){
	           $('#logo').attr('src', "/images/logo_w.png");
	         }
	       else {
	           $('#logo').attr('src', "/images/logo_b.png");
	         }
	       });
	}); */
</script>
<script src="//code.jquery.com/jquery-3.5.1.min.js"></script>
<script>var contextPath = "${pageContext.request.contextPath}";</script>
<!-- Footer -->
<%@ include file = "/footer.jsp" %>
