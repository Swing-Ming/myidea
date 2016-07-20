<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
    <title>待办事项</title>
    <!-- Tell the browser to be responsive to screen width -->
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <!-- Bootstrap 3.3.6 -->
    <link rel="stylesheet" href="/static/bootstrap/css/bootstrap.min.css">
    <!-- Font Awesome -->
    <link rel="stylesheet" href="/static/plugins/fontawesome/css/font-awesome.min.css">
    <!-- Theme style -->
    <link rel="stylesheet" href="/static/dist/css/AdminLTE.min.css">
    <link rel="stylesheet" href="/static/dist/css/skins/skin-blue.min.css">
    <%-- <link rel="stylesheet" href="/static/plugins/datepicker/datepicker3.css">
     <link rel="stylesheet" href="/static/plugins/fullcalendar/fullcalendar.min.css">
     <link rel="stylesheet" href="/static/plugins/colorpicker/bootstrap-colorpicker.css">--%>
    <link rel="stylesheet" href="/static/plugins/datepicker/datepicker3.css">
    <link rel="stylesheet" href="/static/plugins/fullcalendar/fullcalendar.min.css">
    <link rel="stylesheet" href="/static/plugins/colorpicker/bootstrap-colorpicker.css">
    <style>
        .todo-list > li .text {
            font-weight: normal;
        }
    </style>
</head>
<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">
    <%@include file="../include/mainHeader.jsp" %>
    <jsp:include page="../include/leftSide.jsp">
        <jsp:param name="menu" value="task"/>
    </jsp:include>

    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <div class="row">
                <div class="col-md-8">
                    <div class="box box-solid">
                        <div class="box-body">
                            <div id="calendar"></div>
                        </div>
                    </div>
                </div>
                <div class="col-md-4">
                    <div class="box box-danger">
                        <div class="box-header with-border">
                            <h3 class="box-title">已经延期的事项</h3>
                        </div>
                        <div class="box-body">
                            <ul class="todo-list">
                                <c:forEach items="${taskList}" var="task">
                                    <li>
                                        <input type="checkbox" value="${task.id}" id="sss">
                                        <span class="text">${task.title}</span>
                                        <div class="tools">
                                            <i class="fa fa-trash-o"></i>
                                        </div>
                                    </li>
                                </c:forEach>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>

        </section>

        <!-- Main content -->
        <div class="modal fade" id="newModal">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                                aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title">新增待办事项</h4>
                    </div>
                    <div class="modal-body">
                        <form id="newForm" action="/task/new" method="post">
                            <input type="hidden"  name="done" value="0">
                            <div class="form-group">
                                <label>待办内容</label>
                                <input type="text"  class="form-control" name="title" id="task_title">
                            </div>
                            <div class="form-group">
                                <label>开始日期</label>
                                <input type="text" class="form-control" name="start" id="start_time">
                            </div>
                            <div class="form-group">
                                <label>结束日期</label>
                                <input type="text" class="form-control" name="end" id="end_time">
                            </div>
                            <div class="form-group">
                                <label>提醒时间</label>
                                <div>
                                    <select name="hour" style="width: 100px">
                                        <option value=""></option>
                                        <option value="0">0</option>
                                        <option value="1">1</option>
                                        <option value="2">2</option>
                                        <option value="3">3</option>
                                        <option value="4">4</option>
                                        <option value="5">5</option>
                                        <option value="6">6</option>
                                        <option value="7">7</option>
                                        <option value="8">8</option>
                                        <option value="9">9</option>
                                        <option value="10">10</option>
                                        <option value="11">11</option>
                                        <option value="12">12</option>
                                        <option value="13">13</option>
                                        <option value="14">14</option>
                                        <option value="15">15</option>
                                        <option value="16">16</option>
                                        <option value="17">17</option>
                                        <option value="18">18</option>
                                        <option value="19">19</option>
                                        <option value="20">20</option>
                                        <option value="21">21</option>
                                        <option value="22">22</option>
                                        <option value="23">23</option>
                                    </select>
                                    :
                                    <select name="min" style="width: 100px">
                                        <option value=""></option>
                                        <option value="0">0</option>
                                        <option value="5">5</option>
                                        <option value="10">10</option>
                                        <option value="15">15</option>
                                        <option value="20">20</option>
                                        <option value="25">25</option>
                                        <option value="30">30</option>
                                        <option value="35">35</option>
                                        <option value="40">40</option>
                                        <option value="45">45</option>
                                        <option value="50">50</option>
                                        <option value="55">55</option>
                                    </select>
                                </div>
                            </div>
                            <div class="form-group">
                                <label>显示颜色</label>
                                <input type="text" class="form-control" name="color" id="color" value="#61a5e8">
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
        <!-- /.content -->

        <div class="modal fade" id="taskModal">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                                aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title">查看待办事项</h4>
                    </div>
                    <div class="modal-body">
                        <form id="taskForm" action="/task/new" method="post">
                            <input type="hidden" id="event_id">
                            <div class="form-group">
                                <label>待办内容</label>
                                <div><span id="event_title"></span></div>
                            </div>
                            <div class="form-group">
                                <label>开始时间~结束时间</label>
                                <div><span id="event_time"></span> ~ <span id="event_end_time"></span>
                                </div>
                            </div>
                            <div class="form-group">
                                <label>提醒时间</label>
                                <div><span id="event_remid"></span></div>
                            </div>
                        </form>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                        <button type="button" class="btn btn-danger" id="delBtn"><i class="fa fa-trash">删除</i></button>
                        <button type="button" class="btn btn-primary" id="markBtn"><i class="fa fa-check">标记为已完成</i></button>
                    </div>
                </div><!-- /.modal-content -->
            </div><!-- /.modal-dialog -->
        </div>
    </div>

</div>
<!-- ./wrapper -->

<!-- REQUIRED JS SCRIPTS -->

<!-- jQuery 2.2.3 -->
<script src="/static/plugins/jQuery/jquery-2.2.3.min.js"></script>
<!-- Bootstrap 3.3.6 -->
<script src="/static/bootstrap/js/bootstrap.min.js"></script>
<!-- AdminLTE App -->
<script src="/static/dist/js/app.min.js"></script>
<script src="/static/plugins/datepicker/bootstrap-datepicker.js"></script>
<script src="/static/plugins/datepicker/locales/bootstrap-datepicker.zh-CN.js"></script>
<script src="/static/plugins/moment/moment.min.js"></script>
<script src="/static/plugins/fullcalendar/fullcalendar.min.js"></script>
<script src="/static/plugins/fullcalendar/zh-cn.js"></script>
<script src="/static/plugins/colorpicker/bootstrap-colorpicker.min.js"></script>

<%--<script src="/static/plugins/datepicker/bootstrap-datepicker.js"></script>
<script src="/static/plugins/datepicker/locales/bootstrap-datepicker.zh-CN.js"></script>
<script src="/static/plugins/moment/moment.min.js"></script>
<script src="/static/plugins/fullcalendar/fullcalendar.min.js"></script>
<script src="/static/plugins/fullcalendar/lang-all.js"></script>--%>
<script>
    $(function () {
        //日历
        var _event = null;
        var $calendar = $("#calendar");
        $calendar.fullCalendar({
            lang: 'zh-CN',
            buttonText: {
                today: '今天'
            },
            events: "/task/load",
            dayClick: function (date, jsEvent, view) {
                $("#newForm")[0].reset();
                $("#start_time").val(date.format());
                /*alert('Clicked on: ' + date.format());*///获取当前时间将其格式化
                $("#end_time").val(date.format());
                $("#newModal").modal({
                    show: true,
                    backdrop: 'static'
                });
            },
            eventClick: function (calEvent, jsEvent, view) {
                _event = calEvent;
                //如何让标记为已经延期的事件在点击该事件是隐藏
                /*if(calEvent.done == 1){
                 $("#markBtn")[0].hide();
                 }*/

                $("#event_id").val(calEvent.id);
                $("#event_title").text(calEvent.title);
                $("#event_time").text(moment(calEvent.start).format("YYYY-MM-DD"));
                if (calEvent.end) {
                    $("#event_end_time").text(moment(calEvent.end).format("YYYY-MM-DD"));
                }
                else {
                    $("#event_end_time").text("");
                }

                if (calEvent.remindtime) {
                    $("#event_remid").text(calEvent.remindtime);
                } else {
                    $("#event_remid").text("无");
                }
                $("#taskModal").modal({
                    show: true,
                    backdrop: 'static',
                    keyboard: false
                });

            }
        });
        //修改已延期的事项
        $(document).delegate("#mark", "click", function () {
            var id = $(this).val();
            $.get("/task/" + id + "/mark").done(function (result) {
                if (result.state== "success") {
                    $calendar.fullCalendar('removeEvents',id);
                    $calendar.fullCalendar( 'renderEvent', result.data );

                   /* $calendar.fullCalendar('updateEvent',_event);*/
                }
            }).fail(function () {
                alert("服务器异常");
            });
        });
        //删除已延期的事项
        $(document).delegate(".todo-list > li", "click", function () {
           var id =  $(".todo-list > input").val();

            alert(id);
            $.get("/task/del/" + id).done(function (data) {
                if(data == "success"){
                    alert("bbbbbbbbbbbbbbbbbbbbbbbbb");
                    $calendar.fullCalendar('removeEvents',id);
                    $("#xxxx").hide();

                }
            }).fail(function(){
                alert("服务器异常");

            });


        });
        //删除
        $("#delBtn").click(function () {
            if (confirm("确定要删除么！")) {
                $.get("/task/del/" + _event.id).done(function (data) {
                    if (data == "success") {
                        $("#taskModal").modal('hide');
                        $calendar.fullCalendar('removeEvents', _event.id);
                    }
                }).fail(function () {
                    alert("服务器异常");
                });
            }
        });

        //标记为日程已完成
        $("#markBtn").click(function () {
            $.post("/task/" + _event.id + "/done").done(function (data) {
                if (data == "success") {
                    _event.color = '#cccccc';
                    $("#taskModal").modal('hide');
                    $calendar.fullCalendar('updateEvent', _event);

                }
            }).fail(function () {
                alert("服务器异常");

            });
        });


        //新增
        $("#color").colorpicker({
            color: '#61a5e8'
        });
        //要在datepicker.js该源代码讲552行的10改为非常大的数。
        $("#start_time,#end_time").datepicker({
            format: 'yyyy-mm-dd',
            autoclose: true,
            language: 'zh-CN',
            todayHighlight: true
        });
        $("#saveBtn").click(function () {
            if (!$("#task_title")) {
                $("#task_title").onfocus();
                return;
            }
            if (moment($("#start_time").val()).isAfter(moment($("#end_time").val()))) {
                alert("结束时间必须大于开始时间");
                return;
            }
            $.post("/task/new", $("#newForm").serialize()).done(function (result) {
                if (result.state == "success") {
                    $calendar.fullCalendar('renderEvent', result.data);
                    $("#newModal").modal('hide');
                }
            }).fail(function () {
                alert("服务器异常");
            });
        });

    });


</script>


</body>
</html>

