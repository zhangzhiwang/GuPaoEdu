<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
</head>
<body>
<h2>Spring security自定义登陆页面</h2>
    <form action="login" method="post">
        账号:<input type="text" name="username"><br/>
        密码:<input type="password" name="password"><br/>
        <security:csrfInput/>
        <input type="submit" value="提交">
    </form>
    <img src="img/car.jpeg">
</body>
</html>
