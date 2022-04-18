<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>    
    
<!DOCTYPE HTML>
<c:set var="list" value="${requestScope.ApplyList}"/>
<c:set var="a_nowPage" value="${requestScope.a_nowPage}"/>
<c:set var="a_startPage" value="${requestScope.a_startPage}"/>
<c:set var="a_endPage" value="${requestScope.a_endPage}"/>
<c:set var="a_totalCnt" value="${requestScope.a_totalCnt}"/>
<c:set var="a_realEndPage" value="${requestScope.a_realEndPage}"/>
<c:set var="Detail" value="${requestScope.applyDetail}"/>

<html>
<head>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/main.css" />
<title>Insert title here</title>
</head>
<body>
<!-- Deliver -->
			<!-- <table width="900px" border="0" cellpadding="0" cellspacing="0"> -->
					<div style="float: right;">총 개수 : ${a_totalCnt} 개</div>
					<div align="center"><h3>수거목록</h3></div>

			
			<!-- <table border="1" cellpadding="0" cellspacing="0" width="900px" > -->
			<table>
				<tr align="center" valign="middle">
					<td width="10%" height="26">
						<div align="center">수거 신청일</div>
					</td>
					<td width="12%" height="26">
						<div align="center">희망 수거일</div>
					</td>
					<td width="50%">
						<div align="center">주소</div>
					</td>
					<td width="14%">
						<div align="center">핸드폰 번호</div>
					</td>
				</tr>
			<c:choose>
				<c:when test="${list != null and fn:length(list) > 0}">
					<c:forEach var="a_bean" items="${list}">
						<tr align="center" id="${a_bean.getA_uid()}" valign="middle" class="list"
						 onmouseover="this.style.backgroundColor='#B6DFA7'" onmouseout="this.style.backgroundColor=''">
							<%-- onClick = "location.href='${pageContext.request.contextPath}/apply/ApplyGetDetailOk.ap?a_uid=${a_bean.getA_uid()}'" --%>
							<td height="23" style="font-family:Tahoma;font-size:100%;" >
								${a_bean.getA_date()}
							</td>
							<td height="23" style="font-family:Tahoma;font-ssize:100%;" >
								${fn:substring(a_bean.getA_wdate(), 0, 10)}
								<br>
								${a_bean.getA_wtime()}
							</td>
							
							<%-- <td style="font-family:Tahoma;font-size:10pt;">
								<div align="left">
								<a href="${pageContext.request.contextPath}/board/BoardView.bo?seq=${b_bean.getBoard_num()}">${b_bean.getBoard_title()}</a>
								</div>
							</td> --%>
							
							<td style="font-family:Tahoma; font-ssize:100%; vertical-align: middle;">
								<div align="center">${a_bean.getA_zipcode()}<br>${a_bean.getA_address()} ${a_bean.getA_address_detail()}</div>
							</td>
							<td style="font-family:Tahoma; font-ssize:100%; vertical-align: middle;">
								<div align="center">${a_bean.getA_phone()}</div>
							</td>	
						</tr>
					</c:forEach>
				</c:when>
				<c:otherwise>
				<tr height="50px">
					<td colspan="5" align="center">등록된 수거신청이 없습니다.</td>
				</tr>
				</c:otherwise>
			</c:choose>
			</table>
			
			<br/>
			<!-- <table border="0" cellpadding="0" cellspacing="0" width="900px"> -->
			<table>
				<tr align="center" valign="middle">
					<td>
					<c:choose>
						<c:when test="${a_nowPage > 1}">
							<a href="${pageContext.request.contextPath}/apply/ApplyList.ap?page=${a_nowPage - 1}">[이전]</a>&nbsp;
						</c:when>
					</c:choose>
					<c:forEach var="i" begin="${a_startPage}" end="${a_endPage}">
						<c:choose>
							<c:when test="${i eq a_nowPage}">
								[${i}]&nbsp;
							</c:when>
							<c:otherwise>
								<a href="${pageContext.request.contextPath}/apply/ApplyList.ap?page=${i}">${i}&nbsp;</a>
							</c:otherwise>
						</c:choose>
					</c:forEach>
					<c:choose>
						<c:when test="${a_nowPage != a_realEndPage}">
							<a href="${pageContext.request.contextPath}/apply/ApplyList.bo?page=${a_nowPage + 1}">[다음]</a>&nbsp;
						</c:when>
					</c:choose>
					</td>
				</tr>
			</table>
<script src="//code.jquery.com/jquery-3.4.1.min.js"></script>
</body>
</html>
