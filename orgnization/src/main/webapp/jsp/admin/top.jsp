<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/admin/basic.css" type="text/css"/>
<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/admin/index.css" type="text/css"/>
</head>
<body>
<div id="header">
	<div class="site_title">
		<a href="#">后台管理系统</a>
	</div>
	<div class="section_title"> 
		<h2>JAVA教学后台管理系统</h2>
	</div>
	<div class="view_site">
		<a href="#">View Site</a>
	</div>
</div> 
<!-- end of header bar -->
<div id="secondary_bar">
	<div class="user">
		<p>欢迎(<a href="#">超级管理员</a>)</p>
	</div>
	<div class="breadcrumbs_container">
		<a href="#">后台首页</a>
		<a href="#">首页信息</a>
	</div>
</div>
</body>
</html>