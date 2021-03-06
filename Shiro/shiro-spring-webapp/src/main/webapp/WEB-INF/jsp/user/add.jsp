<%--
  Created by IntelliJ IDEA.
  User: Nagato
  Date: 2018/9/23
  Time: 15:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>添加用户</title>
</head>
<body>
<jsp:include page="${pageContext.request.contextPath}/common.jsp"></jsp:include>
<div class="container">
    <sf:form method="post" modelAttribute="user" id="addForm">
        <div class="mb-3">
            <label for="username">Username</label>
            <sf:input id="username" class="form-control" path="username" />
        </div>
        <div class="mb-3">
            <label for="password">Password</label>
            <sf:password id="password" class="form-control" path="password" />
        </div>
        <div class="mb-3">
            <label for="nickname">Nickname</label>
            <sf:input id="nickname" class="form-control" path="nickname" />
        </div>
        <div class="mb-3">
            <label for="status">Password</label>
            <sf:select class="custom-select d-block w-100" path="status">
                <sf:option value="-1">停用</sf:option>
                <sf:option value="1">启用</sf:option>
            </sf:select>
        </div>
        <div class="mb-3">
            <c:forEach var="role" items="${roles}">
                <div class="custom-control custom-checkbox">
                    <input type="checkbox" class="custom-control-input" id="rid-${role.id}" name="rids" value="${role.id}" />
                    <label class="custom-control-label" for="rid-${role.id}">${role.rolename}</label>
                </div>
            </c:forEach>
        </div>
        <div class="mb-3">
            <input type="submit" value="添加用户"/><input type="reset" value="重置"/>
        </div>
    </sf:form>
</div>
</body>
</html>
