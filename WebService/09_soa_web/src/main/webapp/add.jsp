<%--
  Created by IntelliJ IDEA.
  User: SuzumiyaHaruhi
  Date: 2018/2/4
  Time: 15:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>add</title>
</head>
<body>
    <form action="/list" type="post">
        <input type="hidden" name="method" value="add" />
        UserName:<input type="text" name="username" /><br/>
        PassWord:<input type="password" name="password"/><br/>
        NickName:<input type="text" name="nickname"/><br/>
        <input type="submit" value="submit"/>
    </form>
</body>
</html>
