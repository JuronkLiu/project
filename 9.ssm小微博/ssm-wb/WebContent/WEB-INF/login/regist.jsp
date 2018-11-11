<%@page pageEncoding="utf-8" contentType="text/html; charset=utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
	<head>
		<title>regist</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style1.css" />
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/aj.js"></script>
		
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.8.3.min.js"></script>
		
		<script type="text/javascript">
		
		$(function() {
			 /* 昵称 */
			$("#usernichen").blur(function() {
				if($("#usernichen").val().length == 0){
					$("#usernichenError").text("昵称不能为空").css("visibility","visible");
				}else{
					var params ='{"usernichen":'+$("#usernichen").val()+'}';
					$.ajax({
						url:"checkUserNiChen.action",
						data:params,
						contentType:"application/json;charset=UTF-8",
						type:"post",
						dataType:"json",
						success:function(data){
							if(data.name == "no"){
								$("#usernichenError").text("该昵称已注册").css("visibility","visible");
							}else{
								$("#usernichenError").text("").css("visibility","hidden");
							}
						}
					});
				}
			});
			 
			 /* 真实姓名 */
			$("#username").blur(function() {
				if($("#username").val().length == 0){
					$("#usernameError").text("真实姓名不能为空").css("visibility","visible");
				}else{
					$("#usernameError").text("").css("visibility","hidden");
				}
			});
			 
			/* 密码 */
			$("#userpassword").blur(function() {
				
				if($("#userpassword").val().length == 0){
					$("#userpasswordError").text("密码不能为空").css("visibility","visible");
				}else{
					$("#userpasswordError").text("").css("visibility","hidden");
					if($("#reuserpassword").val().length != 0){
						if($("#reuserpassword").val() == $("#userpassword").val()){
							$("#reuserpasswordError").text("").css("visibility","hidden");
						}else{
							$("#reuserpasswordError").text("密码与确认密码不一致").css("visibility","visible");
						}
					}
				}
			});
			
			/* 确认密码 */
			$("#reuserpassword").blur(function() {
				if($("#reuserpassword").val().length == 0){
					$("#reuserpasswordError").text("确认密码不能为空").css("visibility","visible");
				}else{
					$("#reloginpassError").text("").css("visibility","hidden");
					if($("#reuserpassword").val() == $("#userpassword").val()){
						$("#reuserpasswordError").text("").css("visibility","hidden");
					}else{
						$("#reuserpasswordError").text("密码与确认密码不一致").css("visibility","visible");
					}
				}
			});
			
			/* 验证码 */
			$("#productCheck").blur(function() {
				if($("#productCheck").val().length == 0){
					$("#productCheckError").text("验证码不能为空").css("visibility","visible");
				}else{
					var params ='{"name":'+$("#productCheck").val()+'}';
					$.ajax({
						url:"productCheck.action",
						data:params,
						contentType:"application/json;charset=UTF-8",
						type:"post",
						dataType:"json",
						success:function(data){
							if(data.name == "no"){
								$("#productCheckError").text("验证码有误").css("visibility","visible");
							}else{
								$("#productCheckError").text("").css("visibility","hidden");
							}
						}
					});
				}
			});
		});
		</script>
	</head>
	<body>
		<div id="wrap">
			<div id="top_content">
					<div id="header">
						<div id="rightheader">
						</div>
						<div id="topheader">
							<h1 id="title">
								<a href="#">欢迎注册</a>
							</h1>
						</div>
						<div id="navigation">
						</div>
					</div>
				<div id="content">
					<p id="whereami">
					</p>
					<h1>
						欢迎你
					</h1>
					<form action="register.action" method="post" id="form">
						<table cellpadding="0" cellspacing="0" border="0"
							class="form_table">
							<tr>
								<td valign="middle" align="center" colspan="2">
									<span style="color: red"><c:if test="${checkuser != null }">${checkuser}</c:if></span>
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									昵称:
								</td>
								<td valign="middle" align="left">
									<input type="text" id="usernichen" class="inputgri" name="usernichen" onblur="yz();" />
									<span style="color: red" id="usernichenError"></span>
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									真是姓名
								</td>
								<td valign="middle" align="left">
									<input type="text" id="username"  class="inputgri" name="username" />
									<span style="color: red" id="usernameError"></span>
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									密码
								</td>
								<td valign="middle" align="left">
									<input type="password" id="userpassword" class="inputgri" name="userpassword" />
									<span style="color: red" id="userpasswordError"></span>
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									确认密码
								</td>
								<td valign="middle" align="left">
									<input type="password" id="reuserpassword" class="inputgri" name="reuserpassword" />
									<span style="color: red" id="reuserpasswordError"></span>
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									性别
								</td>
								<td valign="middle" align="left">
									男
									<input type="radio" class="inputgri" name="usersex" value="m" checked="checked"/>
									女
									<input type="radio" class="inputgri" name="usersex" value="f"/>
								</td>
							</tr>
							
							<tr>
								<td valign="middle" align="right">
									验证码
									<img id="num" src="productCheck" onclick="this.src='productCheck??'+new Date();"/>
									<a href="javascript:;" onclick="document.getElementById('num').src = 'productCheck?'+(new Date()).getTime()">换一张</a>
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="productCheck" id="productCheck"/>&nbsp;<span style="color: red;" id="productCheckError">${error}</span>
								</td>
							</tr>
						</table>
						<p>
							<input type="submit" class="button" value="提交" onclick="return tijiao(this.form);"/>
							<input type="reset" class="button" value="重置" />
						</p>
					</form>
				</div>
			</div>
			<div id="footer">
				<div id="footer_bg">
				
				</div>
			</div>
		</div>
	</body>
</html>
