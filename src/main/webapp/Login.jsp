<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8" />
    <title>606未知登录对接界面</title>
    <%--<link rel="shortcut icon" href="images/游戏.png" />--%>
    <link rel="shortcut icon"  href="#"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/local/css/login.css">
    <script src="${pageContext.request.contextPath}/static/common/jquery-3.6.0.min.js"></script>

    <script >
        function login(){
            var data = {
                "name": document.getElementById("username").value,
                "password": document.getElementById("passwd").value
            }
            //将js对象转化json
            var jsonDate = JSON.stringify(data)
            alert(jsonDate)
            //使用JQuery向服务端发送post请求
            $.ajax({
                url : "${pageContext.request.contextPath}/xian/Login",
                type : 'POST',
                data : jsonDate,
                dataType : 'json',
                contentType: 'application/json;charset=UTF-8',
                success : function(data) {
                    window.location.href= "${pageContext.request.contextPath}" + data.value;
                },
                Error : function(xhr, error, exception) {
                    alert(exception.toString());
                }
            });
        }
    </script>

</head>

<body class="body-bg">

<div class="container">
    <div class="header">
        <div class="img-cont ta-center">
            <br><p>欢迎使用贤哲国际酒店后台管理系统</p>
        </div>
        <div class="navmenu">
            <ul>
                <li><a><i class="fa fa-share-alt fa-flip-horizontal"></i> 巡官</a></li>
                <li><a><i class="fa fa-question-circle-o"></i> 帮助</a></li>
                <li><a><i class="fa fa-wrench fa-flip-horizontal"></i> 诊断工具</a></li>
            </ul>
        </div>
    </div>

    <div class="jc-center margin-bot20">
        <div class="content-box">
            <div class="login-box">
                <div class="frm-cont">
                    <h3 class="title">贤哲国际酒店后台管理系统</h3>
                    <h4>所属地区：<span class="color-tip">中华神州大陆</span></h4>
                    <h4>时区编码：<span class="color-tip">604</span></h4>
                    <div class="frm-box">
                        <form>
                            <input type="text"  id="username" placeholder="请输入账号" class="fultxt"
                                   value="" />
                            <input type="password"  id="passwd" placeholder="请输入密码" class="fultxt"/>

                            <div class="errmsg"></div>

                            <input type="button" class="button" id="LoginButton" value="登               录" onclick="login()"/>
                        </form>
                        <div>
                            <a class="noul" >找回密码？</a>
                            <a class="noul float-right"  target="_blank">首次接入必看</a>
                            <div style="clear:both;"></div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>
