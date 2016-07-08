<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
    <html>
    <head>
        <meta charset="UTF-8">
        <title>Document</title>
        <link rel="stylesheet" href="/static/css/bootstrap.min.css">
    </head>
    <body>

    <div class="container">

        <div class="page-header">
            <h3>图书列表</h3>
        </div>
    </div>

    <div class="well well-sm">
        <form method="get" class="form-inline">
            <div class="form-grop">
                <input type="text" placeholder="书籍名称" name="bookname" value="${bookname}">
            </div>

            <div class="form-group">
                <label>书籍分类</label>
                <select name="typeid" class="form-control">
                    <c:forEach items="${types}" var="typeid">
                        <option value="${typeid.id}"></option>
                    </c:forEach>
                </select>
            </div>

            <div class="form-group">
                <label>出版社</label>
                <select name="pubid" class="form-control">
                    <c:forEach items="${pubs}" var="pub">
                        <option value="${pub.id}"></option>
                    </c:forEach>
                </select>5
            </div>
        </form>

    </div>

    <a href="/books/new" class="btn btn-success">添加书籍</a>

    <div>
        <c:if test="${not empty message}">
            <div class="alert alert-success">${message}</div>
        </c:if>
    </div>
    <table class="table">
        <thead>
        <tr>
            <th>名称</th>
            <th>作者</th>
            <th>价格</th>
            <th>数量</th>
            <th>出版社</th>
            <th>分类</th>
            <th>#</th>
        </tr>

        </thead>
        <tbody>
        <c:if test="${empty page.items}">
            <tr>
                <td colspan="7">没有任何数据</td>
            </tr>
        </c:if>
        <c:forEach items="${page.items}" var="book">
            <tr>
                <td>${book.bookname}</td>
                <td>${book.bookauthor}</td>
                <td>${book.booknum}</td>
                <td>${book.bookprice}</td>
                <td>${book.publisher.pubname}</td>
                <td>${book.bookType.booktype}</td>
                <td>
                    <a href="/books/${book.id}">修改</a>
                    <a href="javascript:;" rel="${book.id}" class="delLink">删除</a>

                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <ul class="pagination pull-right" id="page"></ul>


    <script src="/static/js/jquery-1.11.3.min.js"></script>
    <script src="/static/js/jquery.twbsPagination.min.js"></script>
    <script>

        $(function () {

            $("#page").twbsPagination({
                totalPages:${page.totalPage},
                visiblePages:10,
                first:'首页',
                prev:'上一页',
                next:'下一页',
                last:'末页',
                href:'?bookname='
                +encodeURIComponent('${bookname}')+'&type=${typeid}&pub=${pubid}&p={{number}}' });

            $(".delLink").click(function () {
                var id = $(this).attr("rel");
                if (confirm("要删除么？")) {
                    window.location.href = "/books/" + id + "/del";
                    console.log(id);
                }
            });

        });
    </script>

    </body>
    </html>