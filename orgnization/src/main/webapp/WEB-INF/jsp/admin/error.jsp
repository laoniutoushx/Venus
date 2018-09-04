<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link type="text/css" href="<%=request.getContextPath()%>/resources/css/public/error.css" rel="stylesheet"/>
		<style type="text/css">
			#decorator_main_content {
				padding-bottom:20px;
			}
		</style>
		<title>操作出错</title>
	</head>
	<body>
		<div style="width:100%; height:100%; position: relative; float:left;">
		<div id="error_main_container">
			<div class="error_title_div"><h3>出错了！</h3></div>
			<div id="error_content">
				<h3 class="error_title_h3"><span>非常抱歉，操作失败！</span></h3>
				<dl class="error_dl">
					<dt>可能出现以下问题：</dt>
					<dd>${exception.message}</dd>
				</dl>
				<dl class="error_dl">
					<dt>你还可以进行以下操作：</dt>
					<dd>
						<a href="javascript:history.back(-1)" class="error_href_class">返回</a>
					</dd>
				</dl>
			</div>
		</div>
		</div>
	</body>
</html>