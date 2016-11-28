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

        <jsp:include page="../main/left_admin.jsp"></jsp:include>

        <div class="tpl-content-wrapper">

            <ol class="am-breadcrumb">
                <li><a class="am-icon-home">首页</a></li>
                <li><a class="am-icon-gear">用户角色</a></li>
                <li><a class="am-icon-user am-active">用户管理</a></li>
            </ol>

            <div class="tpl-portlet-components">
                <a class="am-btn am-radius am-btn-sm am-btn-success" href="add"><span class="am-icon-plus"></span> 新增</a>
                <a class="am-btn am-radius am-btn-sm am-btn-danger"><span class="am-icon-trash-o"></span> 删除</a>

                <table class="am-table am-table-bordered">
                    <thead>
                        <tr>
                            <th width="5%"></th>
                            <th width="15%">用户名</th>
                            <th width="20%">手机号码</th>
                            <th width="30%">电子邮件</th>
                            <th width="30%">操作</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="item" items="${list}">
                            <tr>
                                <td align="center"><input type="checkbox"></td>
                                <td>${item.userName}</td>
                                <td>${item.mobile}</td>
                                <td>${item.email}</td>
                                <td>
                                    <a class="am-btn am-radius am-btn-xs am-btn-warning" href="update?id=${item.id}"><span class="am-icon-file-text-o"></span> 修改</a>
                                    <a class="am-btn am-radius am-btn-xs am-btn-default" href="add"><span class="am-icon-exclamation-circle"></span> 禁用</a>
                                    <a class="am-btn am-radius am-btn-xs am-btn-danger" href="delete?id=${item.id}"><span class="am-icon-trash-o"></span> 删除</a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
                <ul class="am-pagination am-pagination-default">
                    <li class="am-pagination-first"><a href="list?page=1">第一页</a></li>
                    <li class="am-pagination-prev"><a href="list?page=${prevPage}">上一页</a> </li>

                    <c:forEach var="i" begin="1" end="${lastPage}">
                        <li <c:if test="${i==page}">class="am-active"</c:if>><a href="list?page=${i}">${i}</a></li>
                    </c:forEach>

                    <li class="am-pagination-next"><a href="list?page=${nextPage}">下一页</a></li>
                    <li class="am-pagination-last"><a href="list?page=${lastPage}">最末页</a></li>
                </ul>
            </div>
        </div>
    </div>

</body>

</html>