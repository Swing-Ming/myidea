<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Document</title>
    <link rel="stylesheet" href="/static/css/bootstrap.min.css">
</head>
<body>
<div class="page-header">
    <h3>图书列表</h3>
</div>
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
    <c:forEach items="${books}" var="book">
        <tr>
            <td>${book.bookname}</td>
            <td>${book.bookauthor}</td>
            <td>${book.booknum}</td>
            <td>${book.bookprice}</td>
            <td>${book.typeid}</td>
            <td>${book.pubid}</td>
            <td>
                <a href="/datatable/${book.id}">修改</a>
                <a href="javascript:;" rel="${book.id}" class="delLink">删除</a>

            </td>
        </tr>
    </c:forEach>
    </tbody>

</table>


</body>
</html>