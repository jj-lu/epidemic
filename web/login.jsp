<%--
  Created by IntelliJ IDEA.
  User: JJ
  Date: 2020/3/2
  Time: 20:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div id="contanier">
    <form action="${pageContext.request.contextPath}/user/login" method="post">
        账号：<input type="text" name="account"><br>
        密码：<input type="password" name="password"><br>
        <input type="submit" value="登录">
    </form>
    ${msg}
</div>
</body>
</html>
