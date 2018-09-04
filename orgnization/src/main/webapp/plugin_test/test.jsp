<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
.mytable {
	border-spacing: 0px;
	border-left:1px solid #999;
	border-top:1px solid #999;
	font-size: 12px;
}
.mytable td {
	border-right:1px solid #999;
	border-bottom:1px solid #999;
	padding:10px 4px;
}
thead.headBg {
	background:#621;
	color:#fff;
}
tr.evenBg {
	background:#bbb;
}
tr.hoverBg {
	background:#484;
	color:#fff;
}
</style>
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/test/mytable.jquery.js"></script>
<script type="text/javascript">
$(function(){
	$("#mytable").mytable({
		width:800,
		onComplete:function(mt,elem){
			//通过mt和elem可以有效的获取相应的参数，这个参数是在mytable内部
			console.log(mt.options.width);
		},
		onTdClick:function(event) {
			var mt = event.data.mt;
			console.log(mt.options.width);
			console.log($(this).html());
		}
	});
});
</script>
</head>
<body>
<table id="mytable">
	<thead>
		<tr>
			<td>标识</td>
			<td>姓名</td>
			<td>年龄</td>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td>1</td>
			<td>张三</td>
			<td>22</td>
		</tr>
		<tr>
			<td>1</td>
			<td>张三</td>
			<td>22</td>
		</tr>
		<tr>
			<td>1</td>
			<td>张三</td>
			<td>22</td>
		</tr>
		<tr>
			<td>1</td>
			<td>张三</td>
			<td>22</td>
		</tr>
		<tr>
			<td>1</td>
			<td>张三</td>
			<td>22</td>
		</tr>
		<tr>
			<td>1</td>
			<td>张三</td>
			<td>22</td>
		</tr>
		<tr>
			<td>1</td>
			<td>张三</td>
			<td>22</td>
		</tr>
		<tr>
			<td>1</td>
			<td>张三</td>
			<td>22</td>
		</tr>
		<tr>
			<td>1</td>
			<td>张三</td>
			<td>22</td>
		</tr>
		<tr>
			<td>1</td>
			<td>张三</td>
			<td>22</td>
		</tr>
	</tbody>
</table>
</body>
</html>