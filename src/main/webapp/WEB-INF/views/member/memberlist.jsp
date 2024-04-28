<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<c:set var="root" value="${pageContext.request.contextPath }"></c:set> 
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%-- <%=list.toString() %> --%>
	
	<div align="center">
		<jsp:include page="./loginheader.jsp"/>
		<h2> 회원 리스트</h2>
		<form action="${root }/member/memberdeleteall" method="post">
			<table border="1">
				<tr><td>아이디</td><td>비번</td><td>이름</td><td>나이</td><td>주소</td></tr>
				<c:forEach items="${list }" var="m">
					<tr>
						<td><a href="${root }/member/memberupdateform?id=${m.id }">${m.id }</a></td>
						<td>${m.pw }</td>
						<td>${m.name }</td>
						<td>${m.age }</td>
						<td>${m.addr }</td>
						<td><input type="checkbox" name="memberdels" value="${m.id }"></td>
					</tr>
				</c:forEach>
				<tr><td><input type="submit" value="삭제"></td></tr>
			</table>
		</form>
	</div>
</body>
</html>