<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2020/7/14
  Time: 20:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>角色管理</h1>
    当前登录的账号:<security:authentication property="principal.username" /><br/>
    <security:authorize access="hasAnyRole('admin_insert')">
        <a href="#">增</a><br>
    </security:authorize>
    <security:authorize access="hasAnyRole('admin_delete')">
        <a href="#">删</a><br>
    </security:authorize>
    <security:authorize access="hasAnyRole('admin_update')">
        <a href="#">改</a><br>
    </security:authorize>
</body>
</html>
