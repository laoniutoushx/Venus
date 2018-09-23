<%--
  Created by IntelliJ IDEA.
  User: Nagato
  Date: 2018/9/23
  Time: 14:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>用户列表</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap/bootstrap-4.0.0.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/grid.css">
</head>
<body>
<div class="container">
    <h3>用户列表</h3>
    <div class="row">
        <div class="col-sm">用户ID</div>
        <div class="col-sm">用户名称</div>
        <div class="col-sm">用户昵称</div>
        <div class="col-sm">用户状态</div>
        <div class="col-sm">操作</div>
    </div>
    <c:forEach var="user" items="${users}">
        <div class="row row-detail">
            <div class="col-sm">${user.id}</div>
            <div class="col-sm">${user.username}</div>
            <div class="col-sm">${user.nickname}</div>
            <div class="col-sm">
                <c:if test="${user.status eq 1}">正常</c:if>
                <c:if test="${user.status eq -1}">锁定</c:if>
            </div>
            <div class="col-sm">
                <c:if test="${user.status eq -1 }"><span class="emp">停用</span><a href="updateStatus/${user.id }">启用</a></c:if>
                <c:if test="${user.status eq 1 }"><span>启用</span><a href="updateStatus/${user.id }">停用</a></c:if>
                <a href="${pageContext.request.contextPath}/admin/user/update/${user.id}">更新</a>
            </div>
        </div>
    </c:forEach>
    <div class="row">
        <div class="col-sm"><a href="${pageContext.request.contextPath}/admin/user/add">添加</a></div>
    </div>
</div>
</body>
</html>
