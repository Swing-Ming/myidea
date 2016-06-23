<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/6/23
  Time: 10:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>docment</title>
</head>
<body>
<button id="btn">Json</button>
<ul id="test">

</ul>

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
        document.getElementById("btn").onclick=function(){
           var  xmlhttp = cretexmlHttp();
            xmlhttp.open("get", "/ajax_json", true);
            xmlhttp.onreadystatechange=function(){
                if(xmlhttp.readyState==4){
                    if(xmlhttp.status==200){
                        var result = xmlhttp.responseText

                        var json = JSON.parse(result);
                        console.log(json);
//                            var json_key = json.message;
//                            var json_value = json.name;
//                            var li = document.createElement("li");
//                            var text = document.createTextNode("message:"+ json_key +"~name:"+ json_value);
//                            li.appendChild(text);
//                            document.querySelector("#test").appendChild(li);


                        for(var i = 0 ;i<json.length;i++){
                            var user = json[i];
                            var id = user.id;
                            var name = user.name;
                            var address =user.address;
                            var li = document.createElement("li");
                            var text = document.createTextNode(id+":"+name+":"+address);
                            li.appendChild(text);
                            document.querySelector("#test").appendChild(li);

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
