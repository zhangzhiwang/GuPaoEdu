<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
</head>
<body>
<h2>Hello World!</h2>
    <form action="login.do" method="post">
<!--         账号:<input type="text" name="username"><br/>	name和password分别是“username”和“password”，名称和org.apache.shiro.web.filter.authc.FormAuthenticationFilter里面的属性对应，如果要自定义属性名称需要扩展FormAuthenticationFilter并在Spring的配置文件中配置 -->
<!--         密码:<input type="password" name="password"><br/> -->
        账号:<input type="text" name="userNameZzw"><br/>
        密码:<input type="password" name="passwordZzw"><br/>
<!--         <input type="checkbox" name="rememberMeZzw">记住我<br/> -->
        <input type="submit" value="提交">
    </form>
</body>
</html>
