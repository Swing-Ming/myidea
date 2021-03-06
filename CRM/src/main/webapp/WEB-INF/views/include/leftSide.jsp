<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<aside class="main-sidebar">

    <!-- sidebar: style can be found in sidebar.less -->
    <section class="sidebar">

        <!-- Sidebar Menu -->
        <ul class="sidebar-menu">
            <%--  <li class="header">客户关系管理系统</li>--%>
            <!-- Optionally, you can add icons to the links -->
            <shiro:hasAnyRoles name="经理,员工">
                <li class="${param.menu == 'home'?'active':''}"><a href="/home"><i class="fa fa-home"></i> <span>首页</span></a></li>
                <li class="${param.menu == 'notice'?'active':''}"><a href="/notice"><i class="fa fa-bullhorn"></i> <span>公告</span></a></li>
                <li class="${param.menu == 'customer'?'active':''}"><a href="/customer"><i class="fa fa-building-o"></i> <span>客户管理</span></a></li>
                <li class="${param.menu ==  'sales'?'active':''}"><a href="/sales"><i class="fa fa-users"></i> <span>销售机会</span></a></li>
                <li  class="${param.menu == 'chart'?'active':''}"><a href="/chart"><i class="fa fa-bar-chart"></i> <span>统计</span></a></li>
                <li class="${param.menu == 'task'?'active':''}"><a href="/task"><i class="fa fa-calendar-check-o"></i> <span>待办事项</span></a></li>
                <li class="${param.menu == 'document'?'active':''}"><a href="/doc"><i class="fa fa-file-text"></i> <span>文档管理</span></a></li>
            </shiro:hasAnyRoles>

            <shiro:hasRole name="管理员">
            <li class="treeview">
                <a href="#"><i class="fa fa-cogs"></i> <span>系统管理</span>
            <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right"></i>
            </span>
                </a>
                <ul class="treeview-menu">
                    <li><a href="/admin/user">员工管理</a></li>
                    <li><a href="#">系统设置</a></li>
                </ul>
            </li>
        </ul>
        </shiro:hasRole>
        <!-- /.sidebar-menu -->
    </section>
    <!-- /.sidebar -->
</aside>