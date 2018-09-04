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
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/public/jquery.static.js"></script>
<script type="text/javascript">
$(function(){
	$("#admintable").admintable({showCheckbox:false});
	$("#positions").change(function(){
		var href = window.location.href;
		window.location.href = $.formatHref(href)+"?posId="+$(this).val();
	});
});
</script>
</head>
<body>
<div class="main_content_container">
	<table id="admintable" width="850" cellpadding="0" cellspacing="0">
	<thead>
	 <tr>
	    <td colspan="6" class="title">
		   <jsp:include page="nav.jsp"/>
	    </td>
	  </tr>
	   <tr>
	    <td colspan="6" class="title">
	   	 查询组织:<span class="em">[${org.name}]</span>中的人员
	   	<span>
	   		<select id="positions" name="positions">
	   			<option value="-1">筛选岗位</option>
	   			<c:forEach var="pos" items="${positions}">
	   			<c:if test="${posId eq pos.id }">
	   				<option value="${pos.id }" selected="selected">${pos.name }</option>
	   			</c:if>
	   			<c:if test="${posId != pos.id }">
	   				<option value="${pos.id }">${pos.name }</option>
	   			</c:if>
	   			</c:forEach>
	   		</select>
	   	</span>
	    </td>
	  </tr>
	  <tr>
	    <td width="20%" align="center"><strong>姓名</strong></td>
	    <td width="10%" align="center"><strong>身份证号</strong></td>
	    <td width="10%" align="center"><strong>性别</strong></td>
	    <td width="20%" align="center"><strong>电话</strong></td>
	    <td width="20%" align="center"><strong>岗位</strong></td>
	    <td width="30%" align="center"><strong>操作</strong></td>
	  </tr>
	</thead>
	<tbody>
		<c:forEach var="data" items="${persons.datas}">
			 <tr>
			    <td align="center">${data.name }</td>
			    <td class="jianju10">${data.sfzh }</td>
			    <td class="jianju10">
			    <c:if test="${data.sex eq 0 }">男</c:if>
			    <c:if test="${data.sex eq 1 }">女</c:if>
			    </td>
			    <td align="center">${data.phone }</td>
			    <td align="center">${data.posName }</td>
			    <td align="center">
			    	<a href="<%=request.getContextPath() %>/admin/org/personManagers/${data.pid}" target="_blank" class="color_red">查询所管理部门</a>
			    </td>
			  </tr>
		</c:forEach>
	  </tbody>
	  <tfoot>
	  <tr><td colspan="6">
	  	<jsp:include page="/jsp/pager/pager.jsp">
		   	<jsp:param value="${persons.total }" name="totalRecord"/>
			<jsp:param value="persons/${org.id }" name="url"/>
	    </jsp:include>
	  </td></tr>
	  </tfoot>
	</table>
</div>
</body>
</html>