<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>后台管理页面测试</title>
</head>
<frameset rows="93,*,40" border="0" frameborder="0" framespacing="0">
	<frame src="<%=request.getContextPath() %>/jsp/admin/top.jsp"/>
	<frameset cols="18%,*">
		<frame src="<%=request.getContextPath() %>/jsp/admin/left.jsp"/>
		<frame name="content" src="<%=request.getContextPath() %>/jsp/admin/table.jsp"/>
	</frameset>
	<frame src="<%=request.getContextPath() %>/jsp/admin/bottom.jsp"/>
</frameset>
</html>