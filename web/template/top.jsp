<%--
  Created by IntelliJ IDEA.
  User: JJ
  Date: 2020/3/8
  Time: 18:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="row" style="background-color: deepskyblue; margin-bottom: 3px">
    <div class="col-md-6 logo">
        疫情数据发布系统
    </div>
    <div class="col-md-2 col-md-offset-4">
        <p>欢迎你：<span class="label label-info">${loginuser.userName}</span></p><br>
        <a href="${pageContext.request.contextPath}/user/logout" class="btn btn-danger">推出登录</a>
    </div>
</div>
