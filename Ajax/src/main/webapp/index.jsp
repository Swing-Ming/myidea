<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/6/20
  Time: 10:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Ajax</title>
</head>
<body>


<input type="text" id="username"><span id="s1"></span>
<script>
    //配置引擎
    (function () {
        var xmlhttp = null;

        function creatXMLHttpRequest() {
            if (window.ActiveXObject) {
                xmlhttp = new ActiveXObject("Microsoft.xmlHTTP");

            } else {
                xmlhttp = new XMLHttpRequest();
            }
            return xmlhttp;
        }
        document.querySelector("#username").onchange = function(){


            var username = this.value;
            //1 设置引擎
            var xmlhttp1 = creatXMLHttpRequest();
            //2 设置请求方式以及url
            xmlhttp1.open("get","/home?username="+username,true);
            //3 回调函数
            xmlhttp1.onreadystatechange = function (){
                //请求状态码
                var readstate = xmlhttp1.readyState;

                if(readstate == 4){

                    //获取Http状态码
                    var httpstate = xmlhttp1.status;
                    if(httpstate == 200){
                        //处理数据
                        var result = xmlhttp1.responseText;
                        if(result == "no"){
                            document.querySelector("#s1").innerText="√";
                        }else{
                            document.querySelector("#s1").innerText="账号已被占用";
                        }
                    }
                }
            }
            xmlhttp1.send();


        }



    })();

</script>

</body>
</html>
