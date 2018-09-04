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
<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/zTree/zTreeStyle.css" type="text/css"/>
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/main.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/tree/jquery.ztree.all-3.5.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/public/jquery.mytree.js"></script>
<script type="text/javascript">
$(function(){
	var mt;
	$("#tree").mytree({
		async_url:$("#ctx").val()+"/admin/org/treeAll",
		check_enable:true,
		check_chkboxType:{"Y":"","N":""},
		initCheckCname:"mids",
		onComplete:function(tree) {
			mt = tree;
		}
	});
	$("#setRule").click(function() {
		var nodes = mt.getCheckedNodes(true);
		if(nodes.length<=0) {
			alert("必须选择管理节点");
			return false;
		}
		var id = $("#id").val();
		var data = {};
		data["id"] = id;
		data["mids"] = new Array();
		for(var i=0;i<nodes.length;i++) {
			data["mids"].push(nodes[i].id);
		};
		$.post($("#ctx").val()+"/admin/org/setRule",data,function(data){
			alert(data.msg);
		});
	});
});
</script>
</head>
<body>
<c:forEach items="${mids }" var="mid">
	<input type="hidden" class="mids" value="${mid}"/>
</c:forEach>
<input type="hidden" id="ctx" value="<%=request.getContextPath()%>"/>
<input type="hidden" id="id" value="${org.id }"/>
<div class="main_content_container" style="margin-left:20px">
	<table width="600px" cellpadding="0" cellspacing="0" align="center" id="admintable">
	<thead>
		<tr>
		<td style="padding-bottom:10px">
			设置<span class="em">[${org.name}]</span>组织机构的管理规则
			<input type="button" value="设置结束" id="setRule"/>
			<a href="<%=request.getContextPath()%>/admin/org/orgs/${org.parent.id}"">返回列表</a>
		 </td>
		</tr>
	</thead>
	<tbody>
		<tr>
		<td align="center" valign=top style="border:1px solid #aaa;">
			<ul id="tree" class="ztree"></ul>
		</td>
	</tbody>
	</table>
</div>
</body>
</html>