<%--
  Created by IntelliJ IDEA.
  User: Nagato
  Date: 2018/9/23
  Time: 23:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap/bootstrap-4.0.0.css">
</head>
<body>
<div class="container">
    <nav class="navbar navbar-expand-lg navbar-light" style="background-color: #e3f2fd;">
        <a class="navbar-brand" href="#">导航</a>     <%--导航title--%>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNavDropdown">
            <ul class="navbar-nav">
                <li class="nav-item active">
                    <a class="nav-link" href="/admin/user/list">用户管理 <span class="sr-only">(current)</span></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/admin/role/list">角色管理</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/admin/res/list">资源管理</a>
                </li>
                <%--<li class="nav-item dropdown">--%>
                    <%--<a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">--%>
                        <%--Dropdown link--%>
                    <%--</a>--%>
                    <%--<div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">--%>
                        <%--<a class="dropdown-item" href="#">Action</a>--%>
                        <%--<a class="dropdown-item" href="#">Another action</a>--%>
                        <%--<a class="dropdown-item" href="#">Something else here</a>--%>
                    <%--</div>--%>
                <%--</li>--%>
            </ul>
            <div class="custom-control-inline">
                <a class="nav-link" href="/logout">注销</a>
            </div>
        </div>
    </nav>
</div>
</body>
</html>
