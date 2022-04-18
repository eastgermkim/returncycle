<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<!--
	Drift by Pixelarity
	pixelarity.com | hello@pixelarity.com
	License: pixelarity.com/license
-->
<html>
	<head>
		<title>Untitled</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/main.css" />
	</head>
	
<!-- Header -->
		<%@ include file="/header.jsp" %>
	
<!-- 리뷰글 보기 -->
<!-- 	<section id="main"> 배경 하얀색으로 전체
		<div class="container">
			<section id="content">
				<header class="major" style="padding: 1.0rem;">
					<h2 style="text-align:center">리뷰 글 보기</h2>
				</header>
				</section> -->
	
	
	<section id="main" class="wrapper style1">
   		<header class="major">
      		<h2>리뷰글</h2>
        </header>
        
        <c:set var="reviewBean" value="${requestScope.reviewBean}"/>
        <c:set var="reviewReplyBeanList" value="${requestScope.reviewReplyBeanList}"/>
		<c:set var="reviewFilesBeanList" value="${requestScope.reviewFilesBeanList} "/>
		<c:set var="uploadFile" value="${requestScope.uploadFile} "/>
		
       	<div class="container">
			<div class="row">
				<table class="table table-striped" style="text-align:center;border-top:1px solid #88ff1a">
					<tbody>
						<tr>
							<td style="width:30%">글 제목</td>
							<td colspan="2">${reviewBean.getReview_title()}</td>
						</tr>
						<tr>
							<td>작성자</td>
							<td colspan="2">${reviewBean.getReview_id()}</td>
						</tr>
						<tr>
							<td>작성일</td>
							<td colspan="2">${reviewBean.getReview_date()}</td>
						</tr>
						<tr>
							<td style="vertical-align: top;">내용</td>
							<td colspan="2" style="min-height:200px; text-align:left;">
  								<c:choose>
									<c:when test="${uploadFile eq reviewFilesBeanList}">
										${reviewBean.getReview_content()}
									</c:when>
									<c:otherwise>
										<img src="${pageContext.request.contextPath}/app/upload/${uploadFile}" style="width: 300px;">
										<br>
										${reviewBean.getReview_content()}
									</c:otherwise>
								</c:choose>
							</td> 
<%-- 							<td colspan="2" style="min-height:200px; text-align:left;">${file.getR_file_name()}</td> --%>
						</tr> 
					</tbody>
				</table>
			
				<ul class="actions" style="padding:1.0rem;margin-left: auto;">
					<c:if test="${session_id ne null}">
						<c:if test="${reviewBean.getReview_id() eq session_id}">
							<li><a href="${pageContext.request.contextPath}/review/ReviewModify.rv?seq=${reviewBean.getReview_idx()}" class="button">수정</a></li>
							<li><a href="javascript:deleteReview()" class="button">삭제</a></li>
						</c:if>
					</c:if>
					<li><a href="${pageContext.request.contextPath}/review/ReviewList.rv" class="button">목록</a></li>
				</ul>
			<form action="${pageContext.request.contextPath}/review/ReviewDeleteOk.rv" method="post" name="reviewForm">
 				<input type="hidden" name="seq" value="${reviewBean.getReview_idx()}"/>
 			</form>
		</div>

		<!-- 댓글 -->
			<form method="post" action="${pageContext.request.contextPath}/review/ReviewReplyOk.rv" name="reviewReply">
				<input type="hidden" name="seq" value="${reviewBean.getReview_idx()}">
				<table>
					<tbody>
						<tr>
							<td width="" align="center">
								<div align="center">Reply</div>
							</td>
							<td>
								<div class="row gtr-uniform">
									<div class="col-12">
										<textarea name="content" placeholder="댓글작성" maxlength="100" style="resize:none;"></textarea>
										<a href="javascript:comment()" style="border-bottom:none;">[Finish]</a>
									</div>
								</div>
							</td>
						</tr>
						<c:choose>
							<c:when test="${reviewReplyBeanList != null and fn:length(reviewReplyBeanList) > 0}">
								<c:set var="i" value="${0}"/>
								<c:forEach var="reply" items="${reviewReplyBeanList}">
									<c:set var="i" value="${i+1}"/>
									<tr>
										<!-- 작성자 -->
										<td width="" align="center">
											<div align="center">${reply.getU_id()}</div>
										</td>
										<!-- 댓글내용 -->
										<td>
											<div class="row gtr-uniform">
												<div class="col-12">
													<textarea id="${i}" name="review_reply_content${i}" class="re" maxlength="100" style="resize:none;" readonly>${reply.getReview_reply_content()}</textarea>
												</div>
												<c:if test="${session_id eq reply.getU_id()}">
													<a id="ready${i}" style="border-bottom:none; display:inline;" href="javascript:updateReply(${i})">[수정]</a>
				 									<a id="ok${i}" style="border-bottom:none; display:none;" href="javascript:updateOkReply(${reply.getReview_reply_num()}, ${i})">[수정 완료]</a>
				 									<a href="${pageContext.request.contextPath}/review/ReviewReplyDeleteOk.rv?review_reply_num=${reply.getReview_reply_num()}&seq=${reviewBean.getReview_idx()}" style="border-bottom:none;">[삭제]</a>
				 								</c:if>
											</div>
										</td>
									</tr>
								</c:forEach>
							</c:when>
							<c:otherwise>
								<tr align="center">
	 								<td align="center" width="150px" colspan="2">댓글이 없습니다.</td>
	 							</tr>
	 						</c:otherwise>
	 					</c:choose>
					</tbody>
				</table>
			</form>
		</div>
	</section>
	<script src="https://rawgit.com/jackmoore/autosize/master/dist/autosize.min.js"></script>
	<script>
	$(document).ready(function() {
	     $(document).scroll(function(){
	       if ($('#header').hasClass('alt')){
	           $('#logo').attr('src', "images/logo_w.png");
	         }
	       else {
	           $('#logo').attr('src', "images/logo_b.png");
	         }
	       });
	});
	</script>
	<script>
		var check=false;
		
		autosize($("textarea.re"));
		
		function deleteReview(){
			reviewForm.submit();
		}
		
		//댓글추가
		function comment(){
			var textarea = $("textarea[name='content']").val();
			
			if(textarea == ""){
				alert("댓글을 작성해 주세요.")
				return false;
			}
			reviewReply.submit();
		}
		
		//수정
		function updateReply(num){
			var textarea = $("textarea#" + num);
			var modify_ready_a = $("a#ready" + num);
			var modify_ok_a = $("a#ok" + num);
			
			if(!check){
				textarea.removeAttr("readonly");
				modify_ready_a.hide();
				modify_ok_a.show();
				check = true;
			}else{
				alert("수정중인 댓글이 있습니다.");
			}
		}
		
		//수정 완료
		function updateOkReply(review_reply_num, num){
			$("form[name='reviewReply']").attr("action","${pageContext.request.contextPath}/review/ReviewReplyModifyOk.rv?review_reply_num="+review_reply_num+"&num="+num);
			
			reviewReply.submit();
		}
	</script>
	<!-- Footer -->
		<%@ include file="/footer.jsp" %>