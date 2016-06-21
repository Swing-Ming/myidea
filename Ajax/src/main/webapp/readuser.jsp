<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/6/21
  Time: 10:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/static/css/bootstrap-theme.css">
</head>
<body>
    <div class="container">
        <div class="page-header">
            <h3>Ajax读取XML</h3>
        </div>
        <button id="readbtn">Read</button>
        <div id="userBox"></div>

    </div>



    <script>
        (function(){
            function cretexmlHttp(){
                var xmlhttp = null;
                if(window.ActiveXObject){
                    xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
                }else{
                    xmlhttp = new XMLHttpRequest();
                }
                return xmlhttp;
            }



            function creatdiv(id,username,address){
                var div = document.createElement("div");
                var h4 = document.createElement("h4");
                var small = document.createElement("small");
                var p = document.createElement("p");

                var idText = document.createTextNode(id);
                var userText = document.createTextNode(username);
                var addressText = document.createTextNode(address);

                p.appendChild(addressText);
                small.appendChild(idText);
                h4.appendChild(userText);
                h4.appendChild(small);
                div.appendChild(h4);
                div.appendChild(p);
                document.getElementById("userBox").appendChild(div);


            }
            document.getElementById("readbtn").onclick = function(){
                 var xmlhttp = cretexmlHttp();
                xmlhttp.open("get","/user.xml",true);
                xmlhttp.onreadystatechange = function(){
                    if(xmlhttp.readyState == 4){
                        if(xmlhttp.status == 200){
                            document.querySelector("#userBox").innerHTML="";
                            var xmldoc = xmlhttp.responseXML;
                            var userArray = xmldoc.getElementsByTagName("user");
                            for(var i = 0 ; i< userArray.length;i++){
                                var user = userArray[i];
                                var id = user.getAttribute("id");
                                var username = user.getElementsByTagName("username")[0].childNodes[0].nodeValue;
                                var address = user.getElementsByTagName("adress")[0].childNodes[0].nodeValue;
                                console.log("ID: " + id + " UserName:" + username + " Address:" + address);
                                creatdiv(id,username,address);

                            }


                        }

                    }
                }

                xmlhttp.send();

            }



        })();

    </script>


</body>
</html>
