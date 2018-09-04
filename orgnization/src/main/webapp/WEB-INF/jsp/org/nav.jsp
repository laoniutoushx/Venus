<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <ul class="function_menu">
    <li><a href="<%=request.getContextPath()%>/admin/org/orgs/${parent.id}"><span class="icon16 icon-search"></span>列表</a></li>
    <li><a href="<%=request.getContextPath()%>/admin/org/orgs/${parent.id}/add"><span class="icon16 icon-user-add"></span>新增</a></li>
    <li><a href="<%=request.getContextPath()%>/admin/org/persons/${parent.id}"><span class="icon16 icon-users"></span>查询人员</a></li>
  </ul>