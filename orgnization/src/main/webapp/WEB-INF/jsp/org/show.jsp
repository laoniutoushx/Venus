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
<script type="text/javascript">
$(function(){
});
</script>
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
	    <td colspan="2" class="left">查询${org.name}组织机构<span class="em">[父组织-->${parent.name }]</span></td>
	  </tr>
	</thead>
	<tbody>
		<tr>
			<td class="right" width="40%">组织机构名称:</td>
			<td class="left">${org.name }</td>
		</tr>
		<tr>
			<td class="right">组织机构类型:</td>
			<td class="left">
			${org.typeName }
			</td>
		</tr>
		<tr>
			<td class="right">组织机构地址:</td>
			<td class="left">${org.address }</td>
		</tr>
		<tr>
			<td class="right">组织机构电话:</td>
			<td class="left">${org.phone }</td>
		</tr>
	 </tbody>
	</table>
	<table class="list_table" cellpadding="0" cellspacing="0">
	<thead>
	  <tr>
	    <td colspan="4" class="left">组织机构的人员情况</td>
	  </tr>
	</thead>
	<tbody>
		<tr>
		<td width="20%" align="center">人员名称</td>
		<td width="6%" align="center">性别</td>
		<Td width="20%" align="center">岗位</Td>
		<td width="35%" align="center">身份证号</td>
		</tr>
	 </tbody>
	 <c:forEach var="p" items="${persons }">
	 <Tr>
	 <td align="center">${p.name }</td>
	 <td align="center">
	   <c:if test="${p.sex eq 0 }">男</c:if>
	   <c:if test="${p.sex eq 1 }">女</c:if>
	 </td>
	 <td align="center">${p.posName }</td>
	 <td align="center">${p.sfzh }</td>
	 </Tr>
	 </c:forEach>
	</table>
</div>
</body>
</html>