<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<!--
This is a starter template page. Use this page to start your new project from
scratch. This page gets rid of all links and provides the needed markup only.
-->
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>${notice.title}</title>
    <!-- Tell the browser to be responsive to screen width -->
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <!-- Bootstrap 3.3.6 -->

    <link rel="stylesheet" href="/static/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/static/plugins/fontawesome/css/font-awesome.min.css">
    <link rel="stylesheet" href="/static/dist/css/AdminLTE.min.css">
    <link rel="stylesheet" href="/static/dist/css/skins/skin-blue.min.css">
    <link rel="stylesheet" href="/static/plugins/datatables/css/dataTables.bootstrap.min.css">

</head>
<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">
    <%@include file="../include/mainHeader.jsp" %>
    <jsp:include page="../include/leftSide.jsp">
        <jsp:param name="menu" value="notice"/>
    </jsp:include>
    <div class="content-wrapper">
        <section class="content-header">
            <h1>　　</h1>
            <ol class="breadcrumb">
                <li><a href="/notice"><i class="fa fa-dashboard"></i> 公告列表</a></li>
                <li class="active">${notice.title} </li>
            </ol>
        </section>

        <section class="content">
            <div class="box box-primary">
                <div class="box box-header">
                    <h3 class="box-title">${notice.title} <small>${notice.realname} <fmt:formatDate value="${notice.createtime}" pattern="y-M-d H:m"/></small></h3>
                    <div class="box-body">
                        ${notice.content}
                    </div>
                </div>
            </div>
        </section>


    </div>


    <!-- jQuery 2.2.3 -->
    <script src="/static/plugins/jQuery/jquery-2.2.3.min.js"></script>
    <!-- Bootstrap 3.3.6 -->
    <script src="/static/bootstrap/js/bootstrap.min.js"></script>
    <!-- AdminLTE App -->
    <script src="/static/dist/js/app.min.js"></script>
    <script src="/static/plugins/datatables/js/jquery.dataTables.min.js"></script>


</body>
</html>
