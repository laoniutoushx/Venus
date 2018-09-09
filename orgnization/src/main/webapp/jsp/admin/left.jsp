<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/admin/basic.css" type="text/css"/>
<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/admin/index.css" type="text/css"/>
<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/icon.css" type="text/css"/>
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/main.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/admin/jquery.adminsidebar.js"></script>
<script type="text/javascript">
	$(function() {
		$("#sidebar").adminsidebar();
	});
</script>
</head>
<body>
<div id="sidebar">
	<c:forEach var="lm" items="${leftMenus }">
		<dl status="show">
			<dt>${lm.parent.name }</dt>
			<c:forEach var="m" items="${lm.childs}">
				<dd auth_menu="1" sn="${m.sn}"><a href="<%=request.getContextPath() %>${m.href}" target="content"><span class="icon16 ${m.icon }"></span>${m.name }</a></dd>
			</c:forEach>
		</dl>
	</c:forEach>
	<%-- 
	<dl status="show">
		<dt>学校部门管理</dt>
		<dd><a href="<%=request.getContextPath() %>/admin/classroom/classrooms" target="content"><span class="icon16 icon-user-grey"></span>班级管理</a></dd>
		<dd><a href="table2.html" target="content"><span class="icon16 icon-role"></span>专业管理</a></dd>
		<dd><a href="table2.html" target="content"><span class="icon16 icon-users"></span>班级管理</a></dd>
	</dl>
	<dl status="hide">
		<dt>用户管理</dt>
		<dd><a href="table2.html" target="content"><span class="icon16 icon-user-grey"></span>用户管理</a></dd>
		<dd><a href="table2.html" target="content"><span class="icon16 icon-role"></span>角色管理</a></dd>
		<dd><a href="table2.html" target="content"><span class="icon16 icon-users"></span>用户组管理</a></dd>
	</dl>
	<dl status="show">
		<dt>业务管理</dt>
		<dd><a href="table2.html" target="content"><span class="icon16 icon-settings"></span>管理员设置</a></dd>
		<dd><a href="table2.html" target="content"><span class="icon16 icon-role"></span>角色管理</a></dd>
		<dd><a href="table2.html" target="content"><span class="icon16 icon-static"></span>静态化管理</a></dd>
	</dl>
	--%>
</div>
</body>
</html>