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
	<form action="editZhangwu.action" method="post">
	<table border="1px" cellspacing="0px" cellpadding="0px">
		<tr><th>ID</th><td>${zhangwu.zwid}</td></tr>
		<tr><th>类别</th><td><input type="text" name="flname" value="${zhangwu.flname}"/></td></tr>
		<tr><th>账户</th><td><input type="text" name="zhanghu" value="${zhangwu.zhanghu}"/></td></tr>
		<tr><th>金额</th><td><input type="text" name="money" value="${zhangwu.money}"/></td></tr>
		<tr><th>时间</th><td>${zhangwu.createtime}</td></tr>
		<tr><th>说明</th><td><input type="text" name="description" value="${zhangwu.description}"/></td></tr>
	</table>
		<input type="hidden" name="zwid" value ="${zhangwu.zwid}"/>
		<%-- <input type="hidden" name="createtime" value ="${zhangwu.createtime}"/> --%>
		<input type="submit" value="修改"/>
	</form>
</body>
</html>