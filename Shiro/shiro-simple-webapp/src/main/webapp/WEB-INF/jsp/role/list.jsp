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
    <title>角色列表</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/grid.css">
</head>
<body>
<jsp:include page="${pageContext.request.contextPath}/common.jsp"></jsp:include>
<div class="container">
    <h3>角色列表</h3>
    <div class="row">
        <div class="col-sm">角色ID</div>
        <div class="col-sm">角色名称</div>
        <div class="col-sm">角色SN</div>
        <div class="col-sm">操作</div>
    </div>
    <c:forEach var="role" items="${roles}">
        <div class="row row-detail">
            <div class="col-sm">${role.id}</div>
            <div class="col-sm">${role.rolename}</div>
            <div class="col-sm">${role.sn}</div>
            <div class="col-sm">
                <a href="${pageContext.request.contextPath}/admin/role/update/${role.id}">更新</a>
            </div>
        </div>
    </c:forEach>
    <div class="row">
        <div class="col-sm"><a href="${pageContext.request.contextPath}/admin/role/add">添加</a></div>
    </div>
</div>
</body>
</html>
