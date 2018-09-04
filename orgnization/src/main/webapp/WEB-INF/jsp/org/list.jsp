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
		onComplete:function(tree) {
			mt = tree;
		}
	});
});
</script>
</head>
<body>
<input type="hidden" id="ctx" value="<%=request.getContextPath()%>"/>
<div class="main_content_container" style="margin-left:0px">
	<table cellpadding="0" cellspacing="0">
	<tbody>
		<tr>
		<td width=230px align=left valign=top style="BORDER-RIGHT: #999999 1px dashed">
			<ul id="tree" class="ztree" style="width:230px; overflow:auto;"></ul>
		</td>
		<td width="850">
		<IFRAME ID="cc" Name="testIframe" FRAMEBORDER=0 SCROLLING=AUTO width=100%  height=600px ></IFRAME>
		</td>
		</tr>
	</tbody>
	</table>
</div>
</body>
</html>