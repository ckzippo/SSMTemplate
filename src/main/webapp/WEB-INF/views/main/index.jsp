<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="/common/header.jsp" %>
<html>
<head>
    <%@ include file="/common/lib.jsp" %>
</head>

<body>
    <jsp:include page="top.jsp"></jsp:include>

    <div class="tpl-page-container tpl-page-header-fixed">

        <jsp:include page="left.jsp"></jsp:include>

        <div class="tpl-content-wrapper">
            <div class="tpl-content-scope">
                <div class="note note-info">
                    <h3>Amaze UI 为移动而生<span class="close" data-close="note"></span></h3>
                    <p> Amaze UI 含近 20 个 CSS 组件、20 余 JS 组件，更有多个包含不同主题的 Web 组件，可快速构建界面出色、体验优秀的跨屏页面，大幅提升开发效率。</p>
                    <p><span class="label label-danger">提示:</span> Amaze UI 关注中文排版，根据用户代理调整字体，实现更好的中文排版效果。</p>
                </div>
            </div>

            <div class="row">
                <div class="am-u-lg-3 am-u-md-6 am-u-sm-12">
                    <div class="dashboard-stat blue">
                        <div class="visual">
                            <i class="am-icon-comments-o"></i>
                        </div>
                        <div class="details">
                            <div class="number"> 49 </div>
                            <div class="desc"> 新用户 </div>
                        </div>
                        <a class="more" href="#"> 查看更多 <i class="m-icon-swapright m-icon-white"></i></a>
                    </div>
                </div>
                <div class="am-u-lg-3 am-u-md-6 am-u-sm-12">
                    <div class="dashboard-stat red">
                        <div class="visual">
                            <i class="am-icon-bar-chart-o"></i>
                        </div>
                        <div class="details">
                            <div class="number"> 210 </div>
                            <div class="desc"> 活跃用户 </div>
                        </div>
                        <a class="more" href="#"> 查看更多 <i class="m-icon-swapright m-icon-white"></i></a>
                    </div>
                </div>
                <div class="am-u-lg-3 am-u-md-6 am-u-sm-12">
                    <div class="dashboard-stat green">
                        <div class="visual">
                            <i class="am-icon-apple"></i>
                        </div>
                        <div class="details">
                            <div class="number"> 101 </div>
                            <div class="desc"> 服务号 </div>
                        </div>
                        <a class="more" href="#"> 查看更多 <i class="m-icon-swapright m-icon-white"></i></a>
                    </div>
                </div>
                <div class="am-u-lg-3 am-u-md-6 am-u-sm-12">
                    <div class="dashboard-stat purple">
                        <div class="visual">
                            <i class="am-icon-android"></i>
                        </div>
                        <div class="details">
                            <div class="number"> 239 </div>
                            <div class="desc"> 订阅号 </div>
                        </div>
                        <a class="more" href="#"> 查看更多 <i class="m-icon-swapright m-icon-white"></i></a>
                    </div>
                </div>



            </div>
        </div>
    </div>

</body>

</html>