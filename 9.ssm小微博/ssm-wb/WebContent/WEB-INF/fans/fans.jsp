<%@page pageEncoding="utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
    <meta charset="UTF-8">
    <title>小微博</title>
    <link rel="stylesheet" type="text/css" href="../css/common.css"/>
    <link rel="stylesheet" type="text/css" href="../css/main.css"/>
    <script type="text/javascript" src="../js/libs/modernizr.min.js"></script>
    <style type="text/css">
      .table {
		margin-bottom: 15px;
		width: 100%;
		border-collapse: collapse;
	}
	.table_header td {
		padding: 5px 10px;
		color: rgb(70,122,167);
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
    <script type="text/javascript">
        function findByName(){
           var pname=document.getElementById("nicheng").value;
           window.location.href="toList.action?page=1&pname="+pname+"";
        }
    </script>
</head>
<body>
 <jsp:include page="../util/top.jsp"></jsp:include>
<div class="container clearfix">
 <jsp:include page="../util/left.jsp"></jsp:include>
    <!--/sidebar-->
    <div class="main-wrap">
        <div class="crumb-wrap">
            <div class="crumb-list"><i class="icon-font">&#xe06b;</i><span>欢迎来理想科技公司学习 <span style="color:blue">  现在位置 关注名人</span></span></div>
        </div>
        <div class="result-wrap">
            <div class="result-title">
                <h1>公众号人物</h1>
                                          昵称查找<input type="text" id="nicheng" name="nicheng"/>
                      <input type="button" value="查找" onclick="findByName();"/>
                <table class="table">
						<tr class="table_header">
							<td>
								昵称
							</td>
							<td>
								关注时间
							</td>
							<td>
								取消关注
							</td>
						</tr>
						<c:forEach items="${lists}" var="admin">
						<tr class="row1">
							<td>
								${admin.fanusername}
							<td>
								${admin.createtime}
							</td>
							<td>
								<a href="delete.action?fanid=${admin.fanuserid}" onclick="if(confirm('确定取消关注?')==false)return false;">取消关注</a>
							</td>
						</tr>
						</c:forEach>
					</table>
					<p align="center">
						<c:if test="${page.allPage != 0}">
							<a style="cursor: pointer" href="toList.action?page=${page.page+1}">下一页</a>
							<a style="cursor: pointer" href="toList.action?page=${page.allPage}">尾页</a>
						</c:if>
						
						<c:if test="${page.page > 1 && page.page < page.allPage}">
							<a style="cursor: pointer;" href="toList.action?page=1">首页</a>
							<a style="cursor: pointer" href="toList.action?page=${page.page-1}">上一页</a>
							<a style="cursor: pointer" href="toList.action?page=${page.page+1}">下一页</a>
							<a style="cursor: pointer" href="toList.action?page=${page.allPage}">尾页</a>
						</c:if>
						<c:if test="${page.page==page.allPage && page.allPage > 1}">
							<a style="cursor: pointer;" href="toList.action?page=1">首页</a>
							<a style="cursor: pointer" href="toList.action?page=${page.page-1}">上一页</a>
						</c:if>
						<c:if test="${page.allPage > 0}">共${page.allPage}页，现在是第${page.page}页</c:if>
					</p>
            </div>
            <div class="result-content">
            </div>
        </div>
        <div class="result-wrap">
            <div class="result-title">
                <h1>使用帮助</h1>
            </div>
            <div class="result-content">
                <ul class="sys-info-list">
                    <li>
                        <label class="res-lab">学习了解网站：</label><span class="res-info"><a href="http://www.baidu.com" target="_blank">理想首页</a></span>
                    </li>
                </ul>
            </div>
        </div>
    </div>
    <!--/main-->
</div>
</body>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%></html>