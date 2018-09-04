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
	$("a[oper='delete']").confirmdialog();
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
	   	 所在父节点:<span class="em">[${parent.name}]</span>
	    </td>
	  </tr>
	  <tr>
	    <td width="20%" align="center"><strong>名称</strong></td>
	    <td width="10%" align="center"><strong>年级</strong></td>
	    <td width="10%" align="center"><strong>状态</strong></td>
	    <td width="20%" align="center"><strong>类型</strong></td>
	    <td width="30%" align="center"><strong>操作</strong></td>
	  </tr>
	</thead>
	<tbody>
		<c:forEach var="data" items="${childs.datas}">
			 <tr>
			    <td align="center">${data.name }</td>
			    <td class="jianju10">${data.grade }</td>
			    <td class="jianju10">
			    <c:if test="${data.status eq 0 }">在校</c:if>
			    <c:if test="${data.status eq -1 }">毕业</c:if>
			    </td>
			    <td align="center">
			     <c:if test="${data.type eq 0 }">普通班</c:if>
			     <c:if test="${data.type eq 1 }">选修班</c:if>
			    </td>
			    <td align="center">
			    	<a href="<%=request.getContextPath() %>/admin/classroom/classrooms/${parent.id }/delete/${data.id }" class="color_red" oper="delete">删除</a>
			    	<a href="<%=request.getContextPath() %>/admin/classroom/classrooms/${parent.id }/update/${data.id }" class="color_red">修改</a>
			    	<a href="<%=request.getContextPath() %>/admin/org/persons/${data.id}" class="color_red">班级情况查询</a>
			    </td>
			  </tr>
		</c:forEach>
	  </tbody>
	  <tfoot>
	  <tr><td colspan="6">
	  	<jsp:include page="/jsp/pager/pager.jsp">
		   	<jsp:param value="${childs.total }" name="totalRecord"/>
			<jsp:param value="classrooms/${parent.id }" name="url"/>
	    </jsp:include>
	  </td></tr>
	  </tfoot>
	</table>
</div>
</body>
</html>