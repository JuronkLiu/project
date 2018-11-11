<%@page pageEncoding="utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html>
<head>
    <meta charset="UTF-8">
    <title>后台管理</title>
    <link rel="stylesheet" type="text/css" href="../css/common.css"/>
    <link rel="stylesheet" type="text/css" href="../css/main.css"/>
    <script type="text/javascript" src="../js/libs/modernizr.min.js"></script>
</head>
<body>
<jsp:include page="../util/top.jsp"></jsp:include>
<div class="container clearfix">
<jsp:include page="../util/left.jsp"></jsp:include>
    <!--/sidebar-->
    <div class="main-wrap">

        <div class="crumb-wrap">
            <div class="crumb-list"><i class="icon-font"></i><a href="/jscss/admin/design/">首页</a><span class="crumb-step">&gt;</span><a class="crumb-name" href="/jscss/admin/design/">作品管理</a><span class="crumb-step">&gt;</span><span>新增作品</span></div>
        </div>
        <div class="result-wrap">
            <div class="result-content">
                <form action="" method="post" id="myform" name="myform">
                <input type="hidden" name="id" value="${composition.id}">
                    <table class="insert-tab" width="100%">
                        <tbody><tr>
                            <th width="120"><i class="require-red">*</i>分类：</th>
                            <td>
                                <select name="state" id="catid" class="required">
                                   <c:if test="${composition.state==0}">
                                    <option value="0">私密心情</option>
                                   </c:if>
                                   <c:if test="${composition.state==1}">
                                    <option value="1">公共心情</option>
                                   </c:if>
                                   <c:if test="${composition.state==2}">
                                    <option value="2">删除心情</option>
                                   </c:if>
                                </select>
                            </td>
                        </tr>
                            <tr>
                                <th><i class="require-red">*</i>标题：</th>
                                <td>
                                    <input class="common-text required" id="title" readonly="readonly" name="title" size="50" value="${composition.title}" type="text">
                                </td>
                            </tr>
                            <tr>
                                <th>内容：</th>
                                <td><textarea name="neirong" class="common-textarea" readonly="readonly" id="content" cols="30"   style="width: 98%;" rows="20">${composition.neirong}</textarea></td>
                            </tr>
                            <tr>
                                <th></th>
                                <td>
                                    <input class="btn btn6" onclick="history.go(-1)" value="返回" type="button">
                                </td>
                            </tr>
                        </tbody></table>
                </form>
            </div>
        </div>

    </div>
    <!--/main-->
</div>
</body>
</html>