<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<!--
This is a starter template page. Use this page to start your new project from
scratch. This page gets rid of all links and provides the needed markup only.
-->
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>新增公告</title>
    <!-- Tell the browser to be responsive to screen width -->
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <!-- Bootstrap 3.3.6 -->

    <link rel="stylesheet" href="/static/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/static/plugins/fontawesome/css/font-awesome.min.css">
    <link rel="stylesheet" href="/static/dist/css/AdminLTE.min.css">
    <link rel="stylesheet" href="/static/dist/css/skins/skin-blue.min.css">
    <link rel="stylesheet" href="/static/plugins/simditor/styles/simditor.css">

</head>
<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">
    <%@include file="../include/mainHeader.jsp" %>
    <jsp:include page="../include/leftSide.jsp">
        <jsp:param name="menu" value="notice"/>
    </jsp:include>
    <div class="content-wrapper">
        <section class="content">
            <div class="box box-primary">
                <div class="box-header with-border">
                    <h3 class="box-title">新增公告</h3>
                </div>

                <div class="box-body">
                    <form method="post" id="newForm">
                        <div class="form-group">
                            <label>标题</label>
                            <input type="text" name="title" class="form-control" id="title">
                        </div>
                        <div class="form-group">
                            <label>公告内容</label>
                            <textarea name="content" id="context" cols="10" class="form-control"></textarea>
                        </div>
                    </form>

                    <div class="box-footer">
                        <button id="save-btn" class="btn btn-primary pull-right">发表</button>
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
    <script src="/static/plugins/simditor/scripts/module.min.js"></script>
    <script src="/static/plugins/simditor/scripts/hotkeys.min.js"></script>
    <script src="/static/plugins/simditor/scripts/uploader.min.js"></script>
    <script src="/static/plugins/simditor/scripts/simditor.min.js"></script>

    <script>
        $(function(){
            var edit = new Simditor({
                textarea:$("#context")
            });


            $("#save-btn").click(function(){
                if(!$("#title").val()){
                    $("#title").focus();
                    return;
                }

                if(!$("#context").val()){
                    $("#context").focus();
                    return;
                }
                $("#newForm").submit();
            });

        });
    </script>

</body>
</html>

