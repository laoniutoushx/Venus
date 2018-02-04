<%@ page import="sos.haruhi.ws.webservice.User" %>
<%@ page import="java.util.List" %>
<%@ page isELIgnored="false"%><%--
  Created by IntelliJ IDEA.
  User: SuzumiyaHaruhi
  Date: 2018/2/4
  Time: 14:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>list</title>
</head>
<body>
当前用户:${loginUser.nickname}
    <h1>List</h1>
    <%
        List<User> users = (List<User>) request.getAttribute("users");
        for(User user:users)
        {
    %>

            <span><%=user.getUsername() %></span> ------<span><%=user.getNickname() %></span><br/>

    <%
        }
    %>

<a href="add.jsp">添加</a><br/>
<a href="del.jsp">删除</a><br/>
<a href="login.jsp">登陆</a><br/>
</body>
</html>
