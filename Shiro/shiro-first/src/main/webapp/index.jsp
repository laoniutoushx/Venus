<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<html>
<body>
    <h2>Hello World! haruhi</h2>

    <shiro:guest>
        <a href="/login">用户登陆</a>
    </shiro:guest>

    <shiro:user>
        <a href="/user/list.jsp">用户列表</a>

        <shiro:hasPermission name="user:add">
            <a href="/user/add.jsp">用户添加</a>
        </shiro:hasPermission>

        <shiro:hasRole name="admin">
            <a href="/admin">管理界面</a>
        </shiro:hasRole>

        <a href="/logout">退出</a>
    </shiro:user>

</body>
</html>
