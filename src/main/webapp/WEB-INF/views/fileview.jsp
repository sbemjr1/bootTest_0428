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
		<h1>파일 업로드</h1>
		<form action="${root }/fileupload" method="post" enctype="multipart/form-data">
			파일 : <input type="file" name="upfile" multiple>
			<input type="submit" value="업로드">
		</form>
		<hr/>
		<h1>파일 다운로드</h1>
		<c:if test="${!empty filelist}">
			<table border="1">
				<tr><td>fileID</td><td>파일이름</td><td>파일경로</td></tr>
				<c:forEach items="${filelist }" var="file">
					<tr><td><a href="${root }/filedownload?fid=${file.id}">${file.id }</a></td>
					<td>${file.name }</td>
					<td>${file.path }</td></tr>
				</c:forEach>
				
			</table>
		</c:if>
		
		<c:if test="${empty filelist}">
			<h1>저장된 파일이 없습니다</h1>
		</c:if>
	</div>
	
	
</body>
</html>