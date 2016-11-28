<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/common/header.jsp"%>
<html>
<head>
    <%@ include file="/common/lib.jsp"%>
</head>

<body data-type="login">

    <div class="am-g myapp-login">
        <div class="myapp-login-logo-block  tpl-login-max">
            <div class="myapp-login-logo-text">
                <div class="myapp-login-logo-text">
                    WeiXin Manage<i class="am-icon-skyatlas" style="margin:10px;"></i>
                </div>
            </div>

            <div class="login-font">
                <i>Log In </i> or <span> Sign Up</span>
            </div>
            <div class="am-u-sm-10 login-am-center">
                <form class="am-form" action="login">
                    <fieldset>
                        <div class="am-form-group" style="border-bottom:solid 1px #eee;">
                            <input type="text" class="" id="doc-ipt-email-1" placeholder="输入用户名">
                        </div>
                        <div class="am-form-group">
                            <input type="password" class="" id="doc-ipt-pwd-1" placeholder="输入密码">
                        </div>
                        <p>
                            <button type="submit" class="am-btn am-btn-default">登录</button>
                        </p>
                    </fieldset>
                </form>
            </div>
        </div>
    </div>

</body>
</html>