<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<!--
This is a starter template page. Use this page to start your new project from
scratch. This page gets rid of all links and provides the needed markup only.
-->
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>文件管理</title>
    <!-- Tell the browser to be responsive to screen width -->
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <!-- Bootstrap 3.3.6 -->

    <link rel="stylesheet" href="/static/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/static/plugins/fontawesome/css/font-awesome.min.css">
    <link rel="stylesheet" href="/static/dist/css/AdminLTE.min.css">
    <link rel="stylesheet" href="/static/dist/css/skins/skin-blue.min.css">
    <link rel="stylesheet" href="/static/plugins/webuploader/webuploader.css">

</head>
<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">
    <%@include file="../include/mainHeader.jsp" %>
    <jsp:include page="../include/leftSide.jsp">
        <jsp:param name="menu" value="document"/>
    </jsp:include>

    <div class="content-wrapper">

        <section class="content">
            <div class="box box-primary">
                <div class="box box-header">
                    <h3 class="box-title">文件列表 ${fid}</h3>
                    <div class="box-tools">
                        <%--<span id="uploadBtn"><span class="text"><i class="fa fa-upload"></i>上传文件</span></span>--%>
                            <span id="uploadBtn"><span class="text"><i class="fa fa-upload"></i> 上传文件</span></span>
                            <button class="btn btn-bitbucket btn-xs" id="newDir"><i class="fa fa-folder"></i>新建文件夹</button>
                    </div>
                    <div class="box-body">
                        <table class="table">
                            <thead>
                            <tr>
                                <th>#</th>
                                <th>名称</th>
                                <th>大小</th>
                                <th>创建人</th>
                                <th>创建时间</th>
                            </tr>

                            </thead>
                            <tbody>
                            <c:if test="${empty documentList}">
                                <tr>
                                    <td colspan="5">暂时没有数据</td>
                                </tr>
                            </c:if>

                            <c:forEach items="${documentList}" var="document">
                                <tr>
                                <c:choose>
                                    <c:when test="${document.type == 'dir'}">
                                        <td><i class="fa fa-folder-o"></i></td>
                                        <td><a href="/doc?fid=${document.id}">${document.name}</a></td>
                                    </c:when>
                                    
                                </c:choose>
                                    <td>${document.size}</td>
                                    <td>${document.createuser}</td>
                                    <td><fmt:formatDate value="${document.createtime}" pattern="y-M-d H:m"/></td>
                                </tr>

                            </c:forEach>

                            </tbody>
                        </table>

                    </div>
                </div>
            </div>

        </section>
    </div>


    <div class="modal fade" id="docmodal">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                            aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title">新建文件夹</h4>
                    <div class="modal-body">
                        <form action="/doc/dir/new" method="post" id="saveDirForm">
                            <input type="hidden" name="fid" value="${fid}">
                            <div class="form-group">
                                <label>文件夹名称</label>
                                <input type="text" class="form-control" name="name" id="dirName">
                            </div>
                        </form>
                    </div>

                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                        <button type="button" id="saveDirBtn" class="btn btn-primary">保存</button>
                    </div>
                </div><!-- /.modal-content -->
            </div><!-- /.modal-dialog -->
        </div><!-- /.modal -->

        <!-- jQuery 2.2.3 -->
        <script src="/static/plugins/jQuery/jquery-2.2.3.min.js"></script>
        <!-- Bootstrap 3.3.6 -->
        <script src="/static/bootstrap/js/bootstrap.min.js"></script>
        <!-- AdminLTE App -->
        <script src="/static/dist/js/app.min.js"></script>
        <script src="/static/plugins/webuploader/webuploader.custom.min.js"></script>
        <script>
            $(function () {

                //上传文件

                var uploader = WebUploader.create({
                    swf:"/static/plugins/webuploader/Uploader.swf",
                    pick:'#uploadBtn',
                    server:"/doc/file/upload",
                    fileVal:"file",
                    formData:{"fid":"${fid}"},
                    auto:true

                });
                //文件上传成功
                uploader.on('startUpload',function(){

                    $("#uploadBtn .text").html('<i class="fa fa-spinner fa-spin"></i> 上传中...');
                });
                uploader.on('uploadSuccess',function(file,data){
                    if(dat_row == 'success'){
                        window.history.go(0);
                    }
                });
                uploader.on('uploadError',function(file){
                    alert("文件上传失败");
                });
                uploader.on('uploadComplete',function(file){
                    $("#uploadBtn .text").html('<i class="fa fa-upload"></i> 上传文件').removeAttr("disabled");
                });



                $("#newDir").click(function () {
                    $("#docmodal").modal({
                        show: true,
                        backdrop: 'static',
                        keyboard: false
                    });
                });

                $("#saveDirBtn").click(function () {
                    if (!$("#dirName").val()) {
                        $("#dirName").focus();
                        return;
                    }
                    $("#saveDirForm").submit();
                });


            });


        </script>


</body>
</html>
