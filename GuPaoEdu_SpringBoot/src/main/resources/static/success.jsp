<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>success</h1>
	<form action="logout" method="post">
		<security:csrfInput/>
		<input type="submit" value="注销"/>
	</form>
</body>
</html>