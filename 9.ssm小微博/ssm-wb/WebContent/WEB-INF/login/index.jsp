<%@page pageEncoding="utf-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta charset="UTF-8">
<title>我的小心事</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/common.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/main.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/js/libs/modernizr.min.js"></script>
<style type="text/css">
.table {
	margin-bottom: 15px;
	width: 100%;
	border-collapse: collapse;
}

.table_header td {
	padding: 5px 10px;
	color: rgb(70, 122, 167);
	border-top: 1px solid #CBD6DE;
	border-bottom: 1px solid #ADBECB;
	font-size: 1.1em;
	font-weight: bold;
}

.row1 td {
	padding: 5px 10px;
	color: #666666;
	border: 1px solid #CBD6DE;
	background: #ffffff;
}
</style>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.8.3.min.js"></script>
<script type="text/javascript">
	function findByName() {
		var pname = document.getElementById("nicheng").value;
		window.location.href = "touser.action?page=1&pname=" + pname + "";
	}
	//        $(function(){
	//	        $('tr>td>a').bind('click',function(){
	//	        var name1=$(this).parent().siblings().html();
	//	             alert(name1);
	//	           });
	//        });
</script>
</head>
<body>
	<jsp:include page="../util/top.jsp"></jsp:include>
	<div class="container clearfix">
		<jsp:include page="../util/left.jsp"></jsp:include>
		<!--/sidebar-->
		<div class="main-wrap">
			<div class="crumb-wrap">
				<div class="crumb-list">
					<i class="icon-font">&#xe06b;</i><span>欢迎来理想科技公司学习 <span
						style="color: blue"> 现在位置 名人列表</span></span>
				</div>
			</div>
			<div class="result-wrap">
				<div class="result-title">
					<h1>公众号人物</h1>
					昵称查找<input type="text" id="nicheng" name="nicheng" /> <input
						type="button" value="查找" onclick="findByName();" />
					<table class="table">
						<tr class="table_header">
							<td>昵称</td>
							<td>性别</td>
							<td>注册时间</td>
							<td>是否关注</td>
						</tr>
						<c:forEach items="${lists}" var="admin">
							<tr class="row1">
								<td>${admin.usernichen} <input type="hidden"
									value="${admin.userid}">
								</td>
								<td><c:if test="${admin.usersex=='f'}">
								  女
								</c:if> <c:if test="${admin.usersex=='m'}">
								男
								</c:if></td>
								<td>${admin.usercreatetime}</td>
								<td><a
									href="fans/save.action?fanuserid=${admin.userid}&fanusername=${admin.usernichen}"
									onclick="if(confirm('确定关注?')==false)return false;">关注他</a></td>
							</tr>
						</c:forEach>
					</table>
					<p align="center">
						<c:if test="${page.page==1 && page.allPage > 1}">
							<a style="cursor: pointer" href="touser.action?page=${page.page+1}">下一页</a>
							<a style="cursor: pointer" href="touser.action?page=${page.allPage}">尾页</a>
						</c:if>
						
						<c:if test="${page.page > 1 && page.page < page.allPage}">
							<a style="cursor: pointer;" href="touser.action?page=1">首页</a>
							<a style="cursor: pointer" href="touser.action?page=${page.page-1}">上一页</a>
							<a style="cursor: pointer" href="touser.action?page=${page.page+1}">下一页</a>
							<a style="cursor: pointer" href="touser.action?page=${page.allPage}">尾页</a>
						</c:if>
						<c:if test="${page.page==page.allPage && page.allPage > 1}">
							<a style="cursor: pointer;" href="touser.action?page=1">首页</a>
							<a style="cursor: pointer" href="touser.action?page=${page.page-1}">上一页</a>
						</c:if>
						<c:if test="${page.allPage > 0}">共${page.allPage}页，现在是第${page.page}页</c:if>
					</p>
					
				</div>
				<div class="result-content"></div>
			</div>
			<div class="result-wrap">
				<div class="result-title">
					<h1>使用帮助</h1>
				</div>
				<div class="result-content">
					<ul class="sys-info-list">
						<li><label class="res-lab">学习了解网站：</label><span
							class="res-info"><a href="http://www.baidu.com"
								target="_blank">理想首页</a></span></li>
					</ul>
				</div>
			</div>
		</div>
		<!--/main-->
	</div>
</body>
</html>