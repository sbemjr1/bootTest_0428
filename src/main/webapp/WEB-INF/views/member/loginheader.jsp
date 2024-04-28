<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>    
<c:set var="root" value="${pageContext.request.contextPath }"></c:set> 
<%-- <% 
	String id = (String)request.getSession().getAttribute("login");
%> --%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	로그인 : ${login} <%-- <%=id   %> --%>
</body>
</html>