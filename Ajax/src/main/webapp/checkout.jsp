<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/6/20
  Time: 12:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<input type="text" id="username"/><span id="s2"></span>
    <script>
        ( function(){
            var xmlhttp = null;
            function creatxmlHttp(){
                if(window.ActiveXObject){
                    xmlhttp = new ActiveXObject("Microsoft.xmlHTTP")
                }else{
                    xmlhttp = new XMLHttpRequest();
                }
                return xmlhttp
            }
            document.querySelector("#username").onchange=function(){
                var username = this.value;
                var xmlhttp1 = new creatxmlHttp();
                xmlhttp1.open("get","/checks?username"+username,true);
                xmlhttp1.onreadystatechange=function(){
                    var readstate = xmlhttp1.readyState
                    if(readstate == 4){
                        var httpstus = xmlhttp1.status;
                        if(httpstus == 200 ){
                            var result = xmlhttp1.responseText;
                            if(result == "no"){
                                document.querySelector("#s2").innerText="√";
                            }else{
                                document.querySelector("#s2").innerText="账号已存在";
                            }
                        }else{
                            alert(HTTP异常);
                        }
                    }else{
                        alert("请求异常");
                    }
                }
                xmlhttp1.send();

            }

        })();

    </script>

</body>
</html>
