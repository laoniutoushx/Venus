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
<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/admin/table1.css" type="text/css"/>
<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/icon.css" type="text/css"/>
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/main.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/admin/jquery.admintable.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/public/jquery.confirmdialog.js"></script>
<script type="text/javascript">
$(function(){
	$("#admintable").admintable({showCheckbox:false});
	$("a[oper='delete']").confirmdialog();
});
</script>
</head>
<body>
<div class="main_content_container">
	<table id="admintable" cellpadding="0" cellspacing="0">
	<thead>
	 <tr>
	    <td colspan="6" class="title">
		   <jsp:include page="nav.jsp"/>
	    </td>
	  </tr>
	  <tr>
	    <td width="20%" align="center"><strong>标识</strong></td>
	    <td width="25%" align="center"><strong>名称</strong></td>
	    <td width="25%" align="center"><strong>编号</strong></td>
	    <td width="20%" align="center"><strong>操作</strong></td>
	  </tr>
	</thead>
	<tbody>
		<c:forEach var="data" items="${orgTypes}">
			 <tr>
			    <td align="center">${data.id }</td>
			    <td class="jianju10"><a href="${data.id }" class="color_red">${data.name }</a></td>
			    <td align="center">${data.sn }</td>
			    <td align="center">
			    	<a href="delete/${data.id }" class="color_red" oper="delete">删除</a>
			    	<a href="update/${data.id }" class="color_red">修改</a>
			    	<a href="setRule/${data.id }" class="color_red">设置规则</a>
			    </td>
			  </tr>
		</c:forEach>
	  </tbody>
	</table>
</div>
</body>
</html>