<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="${pageContext.request.contextPath }/query.action"> </a><button type="button">添加账务</button></a>
	<form action="selectByTimeServlet" method="post">
		*提示:时间格式为 1900-1-1<br>
		<input type="date" value="" name="start">—
		<input type="date" value="" name="end">
		<input type="submit" value="按时间查询"/>
	</form>
	<form action="selectByKey.do" method="post">
		<input type="text" value="" name="key">
		<input type="submit" value="关键字查询"/>
	</form>
	<table border="1px" cellspacing="0px" cellpadding="0px">
		<tr>
			<th>ID</th>
			<th>类别</th>
			<th>账户</th>
			<th>金额</th>
			<th>时间</th>
			<th>说明</th>
			<th>操作</th>
		</tr>
		<c:forEach items="${list}" var="zh">
			<tr>
				<td>${zh.zwid}</td>
				<td>${zh.flname}</td>
				<td>${zh.zhanghu}</td>
				<td>${zh.money}</td>
				<td>${zh.createtime}</td>
				<td>${zh.description}</td>
				<td>
					<a href="findZhangwu.action?zwid=${zh.zwid}">编辑</a>
					<a href="deleteZhangwu.action?zwid=${zh.zwid}">删除</a>
				</td>
			</tr>
		</c:forEach>
	</table>
	
	<button type="button" value="">首页</button>
	<button type="button" value="">${pageBean.totalPage}</button>
	<button type="button" value="">${pageBean.totalPage}</button>
	<button type="button" value="">下一页</button>
</body>
</html>