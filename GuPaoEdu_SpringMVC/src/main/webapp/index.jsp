<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<body>
<h2>Hello ${requestScope.userName}！我今年${sessionScope.age}岁</h2>
<form action="/GuPaoEdu_SpringMVC/upload" method="post" enctype="multipart/form-data">
	<input type="file" name="multipartFile">	<!-- name的值要和upload方法的形參名称一致 -->
	<input type="submit" name="提交">
</form>
<a href="/GuPaoEdu_SpringMVC/download">下载</a>
<img src="/GuPaoEdu_SpringMVC/img/filter_interceptor.png">
<h1>${interceptorAddParam}</h1>
</body>
</html>
