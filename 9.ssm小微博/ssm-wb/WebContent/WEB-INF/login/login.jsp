<%@page pageEncoding="utf-8" contentType="text/html; charset=utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
			<title>Login</title>
			<meta name="viewport" content="width=device-width, initial-scale=1">
				<link href="${pageContext.request.contextPath}/css/style.css" rel='stylesheet' type='text/css' />
				<script src="${pageContext.request.contextPath}/js/jquery-1.8.3.min.js"></script>
		<script>
		    function check(form){
		      if($("#username").val()==""||$("#username").val()=="昵称名"||$("#username").val()=="请您输入昵称名"){
		         $("#username").val("请您输入昵称名");
		         return false;
		      }
		      if($("#password").val()==""||$("#password").val()=="Password"||$("#password").val()=="请您输入密码"){
		        $("#sp").html("&nbsp;&nbsp;  请您输入密码");
		        return false;
		      }
		      return true;
		    }
		    
		    function jujiao(){
		      $("#sp").html("");
		      $("#password").val("");
		    }
		</script>
	</head>
	<body>
		<script>
          $(document).ready(function(c) {
	        $('.close').on('click', function(c) {
	    	$('.login-form').fadeOut('slow', function(c) {
			$('.login-form').remove();
	     	});
	       });
          });
       </script>
		<h1>
			小微博
		</h1>
		<div class="login-form">
			<div class="close">
			</div>
			<div class="head-info">
				<label class="lbl-1">
				</label>
				<label class="lbl-2">
				</label>
				<label class="lbl-3">
				</label>
			</div>
			<div class="clear">
			</div>
			<div class="avtar">
				<img src="${pageContext.request.contextPath}/images/avtar.png" />
				<span style="color:red;" id="sp1">
				        
                        </span>
			</div>
			<form action="login.action" method="post">
				<input type="text" name="usernichen" id="username" class="text" value="昵称名"
					onfocus="this.value = '';"
					onblur="if (this.value == '') {this.value = '昵称名';}">
					<div class="key">
						<input type="password" id="password" name="userpassword" value="Password" onfocus="jujiao();"
							onblur="if (this.value == '') {this.value = 'Password';}">
							<br/>
					    <span style="color:red;" id="sp">${message}</span>
					    
					</div>
					<div class="signin">
						<input type="submit"  value="登录" onclick="return check(this.form)">
						<input type="button"  class="quzhuce" onclick="javascript:window.location='toregister.action';" value="注册">
			        </div>
			</form>
			
		</div>
		<div class="copy-rights">
			<p class="back">
				理想心事
			</p>
		</div>

	</body>
</html>