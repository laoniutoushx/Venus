<%--
  Created by IntelliJ IDEA.
  User: Nagato
  Date: 2018/9/15
  Time: 12:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<jsp:include page="${pageContext.request.contextPath}/common.jsp"></jsp:include>
<div class="container">
    <form action="${pageContext.request.contextPath}/login" method="post">
        <div class="mb-3">
            <label for="username">Username</label>
            <input id="username" class="form-control" type="text" name="username" />
        </div>
        <div class="mb-3">
            <label for="password">Password</label>
            <input id="password" class="form-control" type="password" name="password" />
        </div>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
    </form>
</div>
</body>
</html>
