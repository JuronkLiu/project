<%@page pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <div class="sidebar-wrap">
        <div class="sidebar-title">
            <h1>菜单</h1>
        </div>
        <div class="sidebar-content">
            <ul class="sidebar-list">
                <li>
                    <a href="#"><i class="icon-font">&#xe003;</i>常用操作</a>
                    <ul class="sub-menu">
                        <li><a href="http://localhost:8080<%=request.getContextPath()%>/composition/toList.action?page=1"><i class="icon-font">&#xe008;</i>我的心情</a></li>
                        <li><a href="http://localhost:8080<%=request.getContextPath()%>/composition/toListAll.action?page=1"><i class="icon-font">&#xe005;</i>大家心情</a></li>
                        <li><a href="http://localhost:8080<%=request.getContextPath()%>/fans/toList.action?page=1"><i class="icon-font">&#xe005;</i>关注名人</a></li>
                        <li><a href="http://localhost:8080<%=request.getContextPath()%>/touser.action?page=1"><i class="icon-font">&#xe005;</i>名人列表</a></li>
                    </ul>
                </li>
                <li>
                    <a href="#"><i class="icon-font">&#xe018;</i>系统管理</a>
                    <ul class="sub-menu">
                        <li><a href="http://localhost:8080<%=request.getContextPath()%>/composition/findDeleted.action?page=1"><i class="icon-font">&#xe045;</i>心情回收</a></li>
                    </ul>
                </li>
                <li>
                    <a href="#"><i class="icon-font">&#xe018;</i>娱乐视频</a>
                    <ul class="sub-menu">
                        <li><a href="system.html"><i class="icon-font">&#xe045;</i>歌曲MV</a></li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>