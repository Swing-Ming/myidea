<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/6/21
  Time: 17:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/static/css/bootstrap.min.css">
</head>
<body>
<div>
    <h1>单词查询</h1>
</div>

<div class="form-group">
    <input type="text" id="keyword" class="form-control" placeholder="请输入要查询的单词点回车">
</div>
<p id="result"></p>

<script>
    (function () {
        var xmlHttp = null;

        function createxmlhttp() {
            if (window.ActiveXObject) {
                xmlHttp = new window.ActiveXObject("Microsoft.xmlHTTP");
            } else {
                xmlHttp = new XMLHttpRequest();
            }
            return xmlHttp;

        }

        document.querySelector("#keyword").onkeyup = function (event) {
            if (event.keyCode == 13) {

                var word = this.value;


                xmlHttp = new createxmlhttp();
                xmlHttp.open("get", "/direct?q=" + encodeURIComponent(word), true);
                xmlHttp.onreadystatechange = function () {
                    if (xmlHttp.readyState == 4) {
                        if (xmlHttp.status == 200) {

                            var xmlDoc = xmlHttp.responseXML;

                            var translation = xmlDoc.getElementsByTagName("translation")[0];
                            var explains = translation.getElementsByTagName("paragraph")[0].childNodes[0].nodeValue;


                            document.querySelector("#result").innerText = explains;


                        }
                    }
                };
                xmlHttp.send();

//                if (word != "" && word.toString().indexOf(" ") !== -1 || word.length >= 7) {
//                    var name = word.toString().split(" ");
//                    var m = "";
//                    for (var s in name) {
//                        m += name[s] + "%20";
//                    }
//                    m = m.substring(0, m.length - 3);
//                    console.log(m);
//                    xmlHttp = new createxmlhttp();
//                    xmlHttp.open("get", "/direct?q=" + encodeURIComponent(m), true);
//                    xmlHttp.onreadystatechange = function () {
//                        if (xmlHttp.readyState == 4) {
//                            if (xmlHttp.status == 200) {
//
//                                var xmlDoc = xmlHttp.responseXML;
//
//                                var translation = xmlDoc.getElementsByTagName("translation")[0];
//                                var explains = translation.getElementsByTagName("paragraph")[0].childNodes[0].nodeValue;
//
//
//                                document.querySelector("#result").innerText = explains;
//
//
//                            }
//                        }
//                    };
//                    xmlHttp.send();
//                }
//                if (word != "" && word.toString().indexOf(" ") == -1 && word.length < 7) {
//                    xmlHttp = new createxmlhttp();
//                    xmlHttp.open("get", "/direct?q=" + encodeURIComponent(word), true);
//                    xmlHttp.onreadystatechange = function () {
//                        if (xmlHttp.readyState == 4) {
//                            if (xmlHttp.status == 200) {
//                                var xmlDoc = xmlHttp.responseXML;
//
//                                var basic = xmlDoc.getElementsByTagName("basic")[0];
//                                var explains = basic.getElementsByTagName("explains")[0];
//                                var ex = explains.getElementsByTagName("ex")[0].childNodes[0].nodeValue;
//
//                                document.querySelector("#result").innerText = ex;
//
//
//                            }
//                        }
//                    };
//                    xmlHttp.send();
//                }
            }
        };




    })
    ();

</script>


</body>
</html>
