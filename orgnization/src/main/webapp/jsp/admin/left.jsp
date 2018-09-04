<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	<dl status="show">
		<dt>组织机构管理</dt>
		<dd><a href="<%=request.getContextPath() %>/admin/orgType/orgTypes" target="content"><span class="icon16 icon-user-info"></span>组织机构类型</a></dd>
		<dd><a href="<%=request.getContextPath() %>/admin/org/orgs" target="content"><span class="icon16 icon-security"></span>组织机构管理</a></dd>
		<dd><a href="<%=request.getContextPath() %>/admin/position/positions" target="content"><span class="icon16 icon-security"></span>岗位管理</a></dd>
	</dl>
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
</div>
</body>
</html>