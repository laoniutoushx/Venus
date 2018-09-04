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
<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/admin/jquery.insertinput.css" type="text/css"/>
<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/admin/index.css" type="text/css"/>
<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/admin/table1.css" type="text/css"/>
<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/icon.css" type="text/css"/>
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/main.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/public/jquery.confirmdialog.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/admin/jquery.insertinput.js"></script>
<script type="text/javascript">
$(function(){
	$("a[oper='delete']").confirmdialog("删除组织机构类型的关联，可能导致系统无法使用！确定删除吗?");
	$(".ruleAdd").insertinput({
		url:$("#ctx").val()+"/admin/orgType/addRule",
		keys:["cid","pid"],
		pc:"td",
		submitTxt:"添加",
		initVal:"val",
		valKey:"num",
		delegateObj:".ruleAdd"
	});
	$(".ruleUpdate").insertinput({
		url:$("#ctx").val()+"/admin/orgType/updateRule",
		keys:["cid","pid"],
		pc:"td",
		initVal:"val",
		valKey:"num",
		delegateObj:".ruleUpdate"
	});
});

</script>
</head>
<body>
<input type="hidden" id="ctx" value="<%=request.getContextPath()%>"/>
<div class="main_content_container">
	<table class="list_table" cellpadding="0" cellspacing="0">
	<thead>
	  <tr>
	    <td colspan="6" class="title">
		   <jsp:include page="nav.jsp"/>
	    </td>
	  </tr>
	  <tr>
	    <td colspan="5" class="left">设置和查询[<span class="em">${ot.name }</span>]组织机构类型的规则</td>
	  </tr>
	  <tr>
		<td class="center">子组织ID</td>
		<td class="center">子组织名称</td>
		<td class="center">子组织数量</td>
		<td class="center">是否存在</td>
		<td class="left" width="400">操作</td>
	 </tr>
	</thead>
	<tbody>
		<c:forEach var="r" items="${rules }">
		<c:if test="${r.exists }">
			<tr style="background:#eee;color:#632">
				<td class="center">${r.cid }</td>
				<td class="center">${r.cname }</td>
				<td class="center">${r.num }</td>
				<td class="center">存在</td>
				<td class="left">
					<a href="#" class="red_color ruleUpdate" val="${r.num }" cid="${r.cid }" pid="${ot.id }">更新</a>
					&nbsp;&nbsp;<a href="<%=request.getContextPath() %>/admin/orgType/deleteRule/${ot.id}/${r.cid}" class="red_color" oper="delete">删除</a>
				</td>
			</tr>
		</c:if>
		<c:if test="${not r.exists }">
			<tr>
				<td class="center">${r.cid }</td>
				<td class="center">${r.cname }</td>
				<td class="center">无</td>
				<td class="center">不存在</td>
				<td class="left"><a href="#" class="red_color ruleAdd" cid="${r.cid }" pid="${ot.id }">添加</a></td>
			</tr>
		</c:if>	
		</c:forEach>
	 </tbody>
	</table>
</div>
</body>
</html>