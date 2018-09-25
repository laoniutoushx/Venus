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
    <title>更新用户</title>
</head>
<body>
<jsp:include page="${pageContext.request.contextPath}/common.jsp"></jsp:include>
<div class="container">
    <sf:form method="post" modelAttribute="role" id="updateForm">
        <div class="mb-3">
            <label for="rolename">Rolename</label>
            <sf:input id="rolename" class="form-control" path="rolename" />
        </div>
        <div class="mb-3">
            <label for="sn">SN</label>
            <sf:input id="sn" class="form-control" path="sn" />
        </div>
        <div class="mb-3">
            <c:forEach var="res" items="${reses}">
                <div class="custom-control custom-checkbox">
                    <input type="checkbox" class="custom-control-input" <c:if test="${res.checked}">checked="checked"</c:if> id="rid-${res.id}" name="resids" value="${res.id}" />
                    <label class="custom-control-label" for="rid-${res.id}">${res.resname}&nbsp;${res.url}</label>
                </div>
            </c:forEach>
        </div>
        <div class="mb-3">
            <input type="submit" value="更新角色"/><input type="reset" value="重置"/>
        </div>
    </sf:form>
</div>
</body>
</html>
