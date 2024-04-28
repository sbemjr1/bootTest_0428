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
		<form action="${root }/member/login" method="post">
			<h2>로그인</h2>
			<table border="1">
				<tr>
					<td>id</td>
					<td><input type="text" name="id"></td>
				</tr>
				<tr>
					<td>pw</td>
					<td><input type="text" name="pw"></td>
					
				</tr>
				<tr >
					<td colspan="2"><input type="submit" value="로그인"><input type="reset" value="취소"></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>