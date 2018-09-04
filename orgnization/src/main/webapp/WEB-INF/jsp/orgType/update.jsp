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
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/main.js"></script>
</head>
<body>
<div class="main_content_container">
	<table class="list_table" cellpadding="0" cellspacing="0">
	<thead>
	 <tr>
	    <td colspan="2" class="title">
		   <jsp:include page="nav.jsp"/>
	    </td>
	  </tr>
	  <tr>
	    <td colspan="2">组织机构类型修改-->${ot.id}</td>
	  </tr>
	</thead>
	<sf:form modelAttribute="ot">
	<tbody>
		<tr>
			<td align="right">组织名称:</td>
			<td align="left"><sf:input path="name"/></td>
		</tr>
		<tr>
			<td align="right">组织序号:</td>
			<td align="left"><sf:input path="sn"/></td>
		</tr>
		<tr>
			<td colspan="2" align="center"><input type="submit" value="修改组织机构类型"/></td>
		</tr>
	 </tbody>
	</sf:form>
	</table>
</div>
</body>
</html>