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
 		<jsp:include page="./loginheader.jsp"/>
		<form action="${root }/member/memberupdate" method="post" id="uform">
			<h2>회원수정</h2>
			<table border="1">
				<tr>
					<td>id</td>
					<td><input type="text" name="id" value="${m.id }" readonly="readonly"></td>
				</tr>
				<tr>
					<td>pw</td>
					<td><input type="text" name="pw" value="${m.pw }"></td>
					
				</tr>
				<tr>
					<td>name</td>
					<td><input type="text" name="name" value="${m.name }"></td>
					
				</tr>
				<tr>
					<td>age</td>
					<td><input type="text" name="age" value="${m.age }"></td>
					
				</tr>
				<tr>
					<td>addr</td>
					<td><input type="text" name="addr" value="${m.addr }"></td>
					
				</tr>
				
				<tr >
					<td colspan="2"><input type="submit" value="수정"><input type="button" value="삭제" onclick="javascript:memberdelete(${m.id })"></td>
				</tr>
			</table>
		</form>
	</div>
	<script type="text/javascript">
		function memberdelete(id){
			document.getElementById("uform").action="${root}/member/memberdelete";
			document.getElementById("uform").submit();
		}
	
	</script>
</body>
</html>