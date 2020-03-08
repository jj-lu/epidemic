<%--
  Created by IntelliJ IDEA.
  User: JJ
  Date: 2020/3/8
  Time: 19:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>疫情数据录入</title>
    <jsp:include page="../template/bootstrap_common.jsp"></jsp:include>
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/bootstrap/datepicker/bootstrap-datepicker3.css">

</head>
<body>
<div class="container">
    <jsp:include page="../template/top.jsp"></jsp:include>
    <div class="row">
        <div class="col-md-3">
            <jsp:include page="../template/menu.jsp"></jsp:include>
        </div>
        <div class="col-md-9">
            <ul class="breadcrumb">
                <li><a href="${pageContext.request.contextPath}/main.jsp">主页</a></li>
                <li>数据录入</li>
            </ul>
            <div class="row">
                <div class="form-group">
                    <div class="input-group date col-md-3" id="datepicker" data-date-format="yyyy-mm-dd">
                        <div class="input-group-addon">数据日期</div>
                        <input class="form-control" size="16" type="text" value="" readonly>
                        <div class="input-group-addon"><span class="add-on glyphicon glyphicon-calendar"></span></div>
                    </div>
                </div>
            </div>
            这是数据录入的内容
        </div>
    </div>
    <div class="row">
        第三行
    </div>
</div>

<!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
<script src="${pageContext.request.contextPath}/bootstrap/js/jquery-1.11.2.js"></script>
<!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
<script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.js"></script>
<script type="text/javascript"
        src="${pageContext.request.contextPath}/bootstrap/datepicker/bootstrap-datepicker.min.js"></script>
<script type="text/javascript"
        src="${pageContext.request.contextPath}/bootstrap/datepicker/bootstrap-datepicker.zh-CN.min.js"></script>
<script type="text/javascript">
    $(function () {
        var datepicker = $("#datepicker");
        datepicker.datepicker({
            language:'zh-CN',
            autoclose: true
        });
        var current = new Date();
        datepicker.datepicker("setDate",current);
        var date1 = new Date();
        date1.setDate(current.getDate()-7);
        datepicker.datepicker("setStartDate",date1);
        datepicker.datepicker("setEndDate",current);
    })
</script>
</body>
</html>
