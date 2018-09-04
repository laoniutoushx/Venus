<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/admin/basic.css" type="text/css"/>
<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/admin/index.css" type="text/css"/>
<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/admin/table1.css" type="text/css"/>
<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/icon.css" type="text/css"/>
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/jquery.validate.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/main.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/public/jquery.sysvalidate.js"></script>
<script type="text/javascript">
$(function(){
	$("#adminForm").sysvalidate();
});
</script>
</head>
<body>
<div class="main_content_container">
<sf:form modelAttribute="classroom" id="adminForm" method="post">
	<table class="list_table" cellpadding="0" cellspacing="0">
	<thead>
	 <tr>
	    <td colspan="2" class="title">
		   <jsp:include page="nav.jsp"/>
	    </td>
	  </tr>
	  <tr>
	    <td colspan="2" class="left">修改${classroom.name}班级<span class="em">[父组织-->${parent.name }]</span><input type="hidden" name="pid" value="${parent.id }"/></td>
	  </tr>
	</thead>
	<tbody>
		<tr>
			<td class="right">班级名称:</td>
			<td class="left"><sf:input path="name" size="30"/><sf:errors cssClass="errorContainer" path="name"/></td>
		</tr>
		<tr>
			<td class="right">所在年级:</td>
			<td class="left">
			<sf:input path="grade" size="30"/>
			</td>
		</tr>
		<tr>
			<td class="right">班级类型:</td>
			<td class="left"><sf:input path="type" size="70"/></td>
		</tr>
		<tr>
			<td class="right">班级状态:</td>
			<td class="left"><sf:input path="status" size="70"/></td>
		</tr>
		<tr>
			<td class="right">班级排序号</td>
			<td class="left"><sf:input path="orderNum" size="70"/></td>
		</tr>
		<tr>
			<td colspan="2" class="center"><input type="submit" value="修改班级"/></td>
		</tr>
	 </tbody>
	</table>
	</sf:form>
</div>
</body>
</html>