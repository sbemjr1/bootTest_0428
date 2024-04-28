<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<c:set var="root" value="${pageContext.request.contextPath }"></c:set>	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
	<%-- <%@ include file="./member/loginheader.jsp" %> --%>
	<jsp:include page="./member/loginheader.jsp"/>
		<c:choose>
			<c:when test="${empty login }">
				<h3>
					<a href="${root }/member/loginform">로그인</a>
				</h3>
			</c:when>
			<c:otherwise>
				<h3>
					<a href="${root }/member/logout">로그아웃</a>
				</h3>
			</c:otherwise>
		</c:choose>
		<h3>
			<a href="${root }/member/signupform">회원가입</a>
		</h3>
		<h3>
			<a href="${root }/member/memberlist">회원리스트조회</a>
		</h3>
			<h3>
				<a href="${root }/fileform">파일 업로드/다운로드</a>
			</h3>
	</div>
</body>
</html>