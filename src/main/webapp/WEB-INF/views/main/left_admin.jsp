<%@ page language="java" pageEncoding="UTF-8"%>
<!-- 左侧菜单 -->
<div class="tpl-left-nav tpl-left-nav-hover">
    <div class="tpl-left-nav-title">
        系统管理
    </div>
    <div class="tpl-left-nav-list">
        <ul class="tpl-left-nav-menu">
            <li class="tpl-left-nav-item">
                <a class="nav-link tpl-left-nav-link-list">
                    <i class="am-icon-gear"></i>
                    <span>用户角色</span>
                    <i class="am-icon-angle-right tpl-left-nav-more-ico am-fr am-margin-right"></i>
                </a>
                <ul class="tpl-left-nav-sub-menu">
                    <li>
                        <a href="${ctx}/user/list">
                            <i class="am-icon-user"></i>
                            <span>用户管理</span>
                        </a>
                        <a href="table-font-list.html">
                            <i class="am-icon-sitemap"></i>
                            <span>角色管理</span>
                        </a>
                    </li>
                </ul>
            </li>
            <li class="tpl-left-nav-item">
                <a class="nav-link tpl-left-nav-link-list">
                    <i class="am-icon-star"></i>
                    <span>公众号管理</span>
                    <i class="am-icon-angle-right tpl-left-nav-more-ico am-fr am-margin-right"></i>
                </a>
                <ul class="tpl-left-nav-sub-menu">
                    <li>
                        <a href="table-font-list.html">
                            <i class="am-icon-weixin"></i>
                            <span>公众号</span>
                        </a>
                        <a href="table-font-list.html">
                            <i class="am-icon-line-chart"></i>
                            <span>统计分析</span>
                        </a>
                    </li>
                </ul>
            </li>
            <li class="tpl-left-nav-item">
                <a class="nav-link">
                    <i class="am-icon-info-circle"></i>
                    <span>我的资料</span>
                </a>
            </li>
        </ul>
    </div>
</div>
