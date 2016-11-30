<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="/common/header.jsp" %>
<html>
<head>
    <%@ include file="/common/lib.jsp" %>

    <script>

    </script>
</head>

<body>
<jsp:include page="../main/top.jsp"></jsp:include>

<div class="tpl-page-container tpl-page-header-fixed">

    <jsp:include page="../main/left.jsp"></jsp:include>

    <div class="tpl-content-wrapper">

        <ol class="am-breadcrumb">
            <li><a class="am-icon-home">首页</a></li>
            <li><a class="am-icon-gear">用户角色</a></li>
            <li><a class="am-icon-user am-active">用户管理</a></li>
        </ol>

        <div class="tpl-portlet-components">
            <div class="portlet-title">
                <div class="caption font-green bold">
                    <span class="am-icon-code"></span> 新增用户
                </div>
            </div>

            <div class="tpl-block">
                <div class="am-g tpl-amazeui-form">
                    <div class="am-u-sm-12 am-u-md-9">
                        <form class="am-form am-form-horizontal" action="save" id="form">
                            <input type="hidden" name="id" value="${user.id}">
                            <div class="am-form-group">
                                <label for="userName" class="am-u-sm-3 am-form-label">用户名 / UserName</label>
                                <div class="am-u-sm-9">
                                    <input type="text" id="userName" name="userName" placeholder="请输入用户名 / UserName" value="${user.userName}">
                                </div>
                            </div>

                            <div class="am-form-group">
                                <label for="password" class="am-u-sm-3 am-form-label">密码 / Password</label>
                                <div class="am-u-sm-9">
                                    <input type="password" id="password" name="password" placeholder="请输入密码 / Password" value="${user.password}">
                                </div>
                            </div>

                            <div class="am-form-group">
                                <label for="mobile" class="am-u-sm-3 am-form-label">手机号码 / Mobile</label>
                                <div class="am-u-sm-9">
                                    <input type="text" id="mobile" name="mobile" placeholder="请输入手机号码 / Mobile" value="${user.mobile}">
                                </div>
                            </div>

                            <div class="am-form-group">
                                <label for="email" class="am-u-sm-3 am-form-label">电子邮件 / Email</label>
                                <div class="am-u-sm-9">
                                    <input type="email" id="email" name="email" placeholder="请输入电子邮件 / Email" value="${user.email}">
                                </div>
                            </div>

                            <div class="am-form-group">
                                <div class="am-u-sm-9 am-u-sm-push-3">
                                    <button class="am-btn am-btn-primary" onclick="document.form.submit();">保存</button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

</body>

</html>