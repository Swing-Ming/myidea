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
    <title>销售机会</title>
    <!-- Tell the browser to be responsive to screen width -->
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <!-- Bootstrap 3.3.6 -->
    <link rel="stylesheet" href="/static/bootstrap/css/bootstrap.min.css">
    <!-- Font Awesome -->
    <link rel="stylesheet" href="/static/plugins/fontawesome/css/font-awesome.min.css">
    <!-- Theme style -->
    <link rel="stylesheet" href="/static/dist/css/AdminLTE.min.css">
    <link rel="stylesheet" href="/static/dist/css/skins/skin-blue.min.css">

</head>
<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">
    <%@include file="../include/mainHeader.jsp" %>
    <jsp:include page="../include/leftSide.jsp">
        <jsp:param name="menu" value="sales"/>
    </jsp:include>


    <div class="content-wrapper">
        <%--搜索--%>
        <section class="content">
            <section class="content">
                <div class="box box-default collapsed-box">
                    <div class="box-header with-border">
                        <h3 class="box-title">搜索</h3>
                        <div class="box-tools">
                            <button class="btn btn-box-tool" data-widget="collapse" data-toggle="tooltip"><i class="fa fa-plus"></i></button>
                        </div>
                    </div>
                    <div class="box-body">
                        <form class="form-inline">
                            <input type="hidden" id="search_start_time">
                            <input type="hidden" id="search_end_time">
                            <input type="text" class="form-control" id="search_name" placeholder="机会名称">
                            <select class="form-control" class="form-control" id="search_progress">
                                <option value="">当前进度</option>
                                <option value="初次接触">初次接触</option>
                                <option value="确认意向">确认意向</option>
                                <option value="提供合同">提供合同</option>
                                <option value="完成交易">完成交易</option>
                                <option value="交易搁置">交易搁置</option>
                            </select>
                            <input type="text" id="rangepicker" class="form-control" placeholder="跟进时间">
                            <button type="button" id="search_Btn" class="btn btn-default"><i class="fa fa-search"></i> 搜索</button>
                        </form>
                    </div>
                </div>
            <div class="box box-primary">
                <div class="box-header with-border">
                    <h3 class="box-title">机会列表</h3>
                    <div class="box-tools">
                        <button class="btn btn-success btn-xs" id="newBtn"><i class="fa fa-plus">新增机会</i></button>
                    </div>
                </div>
                <div class="box-body">
                    <table class="table" id="datatTable">
                        <thead>
                        <tr>
                            <th>机会名称</th>
                            <th>关联客户</th>
                            <th>价值</th>
                            <th>当前进度</th>
                            <th>最后跟进时间</th>
                            <th>所属员工</th>
                        </tr>
                        </thead>
                        <tbody></tbody>
                    </table>
                </div>
            </div>
        </section>

        <div class="modal fade" id="newModal">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title">新增机会</h4>
                    </div>
                    <div class="modal-body">
                        <form id="newForm">
                            <div class="form-group">
                                <label>机会名称</label>
                                <input type="text" class="form-control" name="name">
                            </div>
                            <div class="form-group">
                                <label>价值</label>
                                <input type="text" class="form-control" name="price">
                            </div>
                            <div class="form-group">
                                <label>关联客户</label>
                                <select name="custid" class="form-control">
                                    <c:forEach items="${custList}" var="cust">
                                            <option></option>
                                        <option value="${cust.id}">${cust.name}</option>
                                    </c:forEach>
                                </select>
                            </div>
                            <div class="form-group">
                                <label>当前进度</label>
                                <select name="progress" class="form-control">
                                    <option value="初次接触">初次接触</option>
                                    <option value="确认意向">确认意向</option>
                                    <option value="提供合同">提供合同</option>
                                    <option value="完成交易">完成交易</option>
                                    <option value="交易搁置">交易搁置</option>
                                </select>
                            </div>
                        </form>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                        <button type="button" class="btn btn-primary" id="saveBtn">保存</button>
                    </div>
                </div><!-- /.modal-content -->
            </div><!-- /.modal-dialog -->
        </div><!-- /.modal -->

    </div>
</div>


<!-- jQuery 2.2.3 -->
<script src="/static/plugins/jQuery/jquery-2.2.3.min.js"></script>
<!-- Bootstrap 3.3.6 -->
<script src="/static/bootstrap/js/bootstrap.min.js"></script>
<!-- AdminLTE App -->
<script src="/static/dist/js/app.min.js"></script>
<script src="/static/plugins/datatables/js/jquery.dataTables.min.js"></script>
<script src="/static/plugins/datatables/js/dataTables.bootstrap.min.js"></script>
<script>

    $(function(){
        var dataTable = $("#datatTable").DataTable({
            serverSide:true,
            searching:false,
            "autoWidth":false,
            ordering:false,
            ajax:"sales/load",
            columns:[
                {"data":function(row){
                    return "<a href='sales/"+row.id+"'>"+row.name+"</a>";
                }},
                {"data":function(row){
                    return "<a href='customer/"+row.custid+"'>"+row.custname+"</a>";
                }},
                {"data":function(row){
                    return "￥"+ row.price;
                }},
                {"data":function(row){
                   if(row.progress == "完成交易"){
                        return "<span class='label label-success'>"+row.progress+"</span>";
                   }
                    if(row.progerss == "交易搁置"){
                        return "<span class='label label-success'>"+row.progress+"</span>";
                    }
                    return row.progress;
                }},
                {"data":"lastime"},
                {"data":"username"}
            ],

            "language": { //定义中文
                "search": "请输入书籍名称:",
                "zeroRecords": "没有匹配的数据",
                "lengthMenu": "显示 _MENU_ 条数据",
                "info": "显示从 _START_ 到 _END_ 条数据 共 _TOTAL_ 条数据",
                "infoFiltered": "(从 _MAX_ 条数据中过滤得来)",
                "loadingRecords": "加载中...",
                "processing": "处理中...",
                "paginate": {
                    "first": "首页",
                    "last": "末页",
                    "next": "下一页",
                    "previous": "上一页"
                }
            }
        });

        $("#newBtn").click(function(){
            $("#newForm")[0].reset();
            $("#newModal").modal({
                show:true,
                backdrop:'static',
                keyboard:false
            });
        });
        //新增机会
        //++++++++++++++Ajax请求
        $("#saveBtn").click(function(){

            $.post("/sales/newsales",$("#newForm").serialize()).done(function(data){
                if(data == "success"){
                    $("#newModal").modal('hide');
                    dataTable.ajax.reload();
                }

            }).fail(function(){
                alert("服务器异常");
            });

        });
        $("#newBtn").click(function(){
            $("newForm").submit();
        });

        $("#search_Btn").click(function(){

        });



    });
</script>


</body>
</html>
