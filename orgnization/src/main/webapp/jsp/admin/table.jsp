<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<script type="text/javascript">
$(function(){
	$("#admintable").admintable();
});
</script>
</head>
<body>
<div class="main_content_container">
	<table id="admintable" cellpadding="0" cellspacing="0">
	<thead>
	 <tr>
	    <td colspan="6" class="title">
		    <ul class="function_menu">
		      <li><a href="#"><span class="icon16 icon-search"></span>查询</a></li>
		      <li><a href="#"><span class="icon16 icon-user-add"></span>新增</a></li>
		      <li><a href="#"><span class="icon16 icon-edit"></span>修改</a></li> 
		      <li><a href="#"><span class="icon16 icon-cancel"></span>删除</a></li>
		    </ul>
	    </td>
	  </tr>
	  <tr showCheck="1">
	    <td objId="1" width="5%" align="center"><strong>编号</strong></td>
	    <td width="6%" align="center"><strong>类型</strong></td>
	    <td width="68%" align="center"><strong>标题</strong></td>
	    <td width="10%" align="center"><strong>更新时间</strong></td>
	    <td width="8%" align="center"><strong>发布人</strong></td>
	  </tr>
	</thead>
	<tbody>
	  <tr>
	    <td objId="1" align="center">1</td>
	    <td align="center">通报</td>
	    <td class="jianju10"><a href="#" class="color_red">关于免去贾留华大学生创业网总经理职务的决定</a></td>
	    <td align="center">2013-04-27</td>
	    <td align="center"><a href="#" class="name">赵常升</a></td>
	  </tr>
	  <tr>
	    <td objId="2" align="center">2</td>
	    <td align="center">通报</td>
	    <td class="jianju10"><a href="#" class="color_red">关于加强公司的综合信息管理平台管理的意见</a></td>
	    <td align="center">2013-04-27</td>
	    <td align="center"><a href="#" class="name">赵常升</a></td>
	  </tr>
	  <tr>
	    <td objId="3" align="center">3</td>
	    <td align="center">通报</td>
	    <td class="jianju10"><a href="#" class="color_red">关于使用即时通讯工具的通知</a></td>
	    <td align="center">2013-04-27</td>
	    <td align="center"><a href="#" class="name">赵常升</a></td>
	  </tr>
	  <tr>
	    <td objId="4" align="center">4</td>
	    <td align="center">通报</td>
	    <td class="jianju10"><a href="#">关于羽毛球比赛的通知 </a></td>
	    <td align="center">2013-04-27</td>
	    <td align="center"><a href="#" class="name">赵常升</a></td>
	  </tr>
	  <tr>
	    <td objId="5" align="center">5</td>
	    <td align="center">通报</td>
	    <td class="jianju10"><a href="#">CCF YOCSEF郑州分论坛在河南金鹏举办“智慧城市创新社会管理的研究与应用”论坛 </a></td>
	    <td align="center">2013-04-27</td>
	    <td align="center"><a href="#" class="name">赵常升</a></td>
	  </tr>
	  <tr>
	    <td objId="6" align="center">6</td>
	    <td align="center">通报</td>
	    <td class="jianju10"><a href="#">金鹏集团董事长赵长升应邀参加共青团中央主办的“我的中国梦”青年创业典型报告会 </a></td>
	    <td align="center">2013-04-27</td>
	    <td align="center"><a href="#" class="name">赵常升</a></td>
	  </tr>
	  <tr>
	    <td objId="7" align="center">7</td>
	    <td align="center">通报</td>
	    <td class="jianju10"><a href="#">关于2013年“五一”劳动节放假及节后上班时间调整的通知 </a></td>
	    <td align="center">2013-04-27</td>
	    <td align="center"><a href="#" class="name">赵常升</a></td>
	  </tr>
	  	</tbody>
	  	<tfoot>
	  	<tr>
		    <td colspan="6">
			   <%-- <jsp:include page="/jsp/pager/pager.jsp">
				   	<jsp:param value="20" name="totalRecord"/>
					<jsp:param value="list" name="url"/>
			   </jsp:include>
			   --%>
		    </td>
	    </tr>
	    </tfoot>
	</table>
</div>
</body>
</html>