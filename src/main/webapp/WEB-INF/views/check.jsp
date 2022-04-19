<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <link rel="shortcut icon" href="#"/>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>贤哲管理系统</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/common/layui/css/layui.css"/>
    <%--    获取系统时间--%>
    <script>
        window.onload = function(){
            function getDate(){
                debugger;
                var today = new Date();
                var date;
                date = (today.getFullYear()) +"-" + (today.getMonth() + 1 ) + "-" + today.getDate() + "-" + today.toLocaleTimeString();
                return date;
            }
            window.setInterval(function(){
                document.getElementById("ExitTime").value=getDate();
            }, 1000);
        }
    </script>
</head>
<body>
<div class="layui-layout layui-layout-admin">
    <div class="layui-header">
        <div class="layui-logo layui-hide-xs layui-bg-black">贤哲</div>
        <!-- 头部区域（可配合layui 已有的水平导航） -->
        <ul class="layui-nav layui-layout-left">
            <!-- 移动端显示 -->
            <li class="layui-nav-item layui-show-xs-inline-block layui-hide-sm" lay-header-event="menuLeft">
                <i class="layui-icon layui-icon-spread-left"></i>
            </li>

            <li class="layui-nav-item layui-hide-xs"><a href="">通知</a></li>
            <li class="layui-nav-item layui-hide-xs"><a href="">活动</a></li>
        </ul>
        <ul class="layui-nav layui-layout-right">
            <li class="layui-nav-item layui-hide layui-show-md-inline-block">
                <a href="javascript:;" text>
                    <img src="${pageContext.request.contextPath}/static/local/img/头像.png" class="layui-nav-img">
                    ${cookie.name.value}
                </a>
                <dl class="layui-nav-child">
                    <dd><a href="">个人资料</a></dd>
                    <dd><a href="${pageContext.request.contextPath}/xian/again">重新登录</a></dd>
                    <dd><a href="${pageContext.request.contextPath}/xian/EndLogin">退出登录</a></dd>
                </dl>
            </li>
            <li class="layui-nav-item" lay-header-event="menuRight" lay-unselect>
                <a href="javascript:;">
                    <i class="layui-icon layui-icon-more-vertical"></i>
                </a>
            </li>
        </ul>
    </div>

    <div class="layui-side layui-bg-black">
        <div class="layui-side-scroll">
            <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
            <ul class="layui-nav layui-nav-tree" lay-filter="test">
                <li class="layui-nav-item" ><a href="${pageContext.request.contextPath}/xian/Home">主页</a></li>
                <li class="layui-nav-item layui-nav-itemed">
                    <a class="layui-this" href="javascript:;">住房管理</a>
                    <dl class="layui-nav-child">
                        <dd><a href="${pageContext.request.contextPath}/Order/addOrder">住户入住</a></dd>
                        <dd><a href="${pageContext.request.contextPath}/Order/list">住户列表</a></dd>
                        <dd><a href="javascript:;">住户预约</a></dd>
                        <dd><a href="${pageContext.request.contextPath}/Order/check">住户退房</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item">
                    <a class="" href="javascript:;">房间管理</a>
                    <dl class="layui-nav-child">
                        <dd><a href="${pageContext.request.contextPath}/suite/addSuite">添加房间</a></dd>
                        <dd><a href="${pageContext.request.contextPath}/suite/list">房间列表</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item">
                    <a href="javascript:;">会员管理</a>
                    <dl class="layui-nav-child">
                        <dd><a href="${pageContext.request.contextPath}/Client/list">会员列表</a></dd>
                        <dd><a href="javascript:;">会员注销</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item"><a href="javascript:;">更多</a></li>
                <li class="layui-nav-item"><a href="${pageContext.request.contextPath}/xian/EndLogin">退出登录</a></li>
            </ul>
        </div>
    </div>

    <div class="layui-body">
        <fieldset class="layui-elem-field layui-field-title">
            <legend>添加新房间</legend>
        </fieldset>
        <div class="right">

            <form class="layui-form" >

                <div class="layui-form-item">
                    <label class="layui-form-label">房间号</label>
                    <div class="layui-input-block">
                        <input type="text" id="suiteNum" required autocomplete="off" oninput="checkNum()"  class="layui-input layui-input-inline">
                    </div>
                </div>

                <div class="layui-form-item">
                    <label class="layui-form-label">房间价格</label>
                    <div class="layui-input-block">
                        <input type="text" id="suitePrice" required autocomplete="off" class="layui-input layui-input-inline layui-disabled">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">结单价格</label>
                    <div class="layui-input-block">
                        <input type="text" id="checkPrice" required autocomplete="off" class="layui-input layui-input-inline layui-disabled">
                    </div>
                </div>

                <div class="layui-form-item">
                    <label class="layui-form-label">房间类型</label>
                    <div class="layui-input-block">
                        <input type="text" id="suiteType" required  autocomplete="off" class="layui-input layui-disabled">
                    </div>
                </div>

                <div class="layui-form-item">
                    <label class="layui-form-label">姓名</label>
                    <div class="layui-input-block">
                        <input type="text" id="name" required  autocomplete="off" class="layui-input layui-input-inline layui-disabled" >
                    </div>
                </div>

                <div class="layui-form-item">
                    <label class="layui-form-label">性别</label>
                    <div class="layui-input-block">
                        <input type="text" id="sex" required  autocomplete="off" class="layui-input layui-disabled">
                    </div>
                </div>

                <div class="layui-form-item">
                    <label class="layui-form-label">身份证号</label>
                    <div class="layui-input-block">
                        <input type="number" id="card" oninput="if(value.length>18)value=value.slice(0,18)" required  value="${o.card}" autocomplete="off" class="layui-input layui-disabled">
                    </div>
                </div>

                <div class="layui-form-item">
                    <label class="layui-form-label">手机号</label>
                    <div class="layui-input-block">
                        <input type="text" id="phone" oninput="if(value.length>11)value=value.slice(0,11)" required autocomplete="off" class="layui-input layui-disabled">
                    </div>
                </div>

                <div class="layui-form-item" >
                    <label class="layui-form-label">入住时间</label>
                    <div class="layui-input-block" >
                        <input type="text" id="EnterTime" required  autocomplete="off" class="layui-input layui-disabled">
                    </div>
                </div>

                <div class="layui-form-item" >
                    <label class="layui-form-label">退房时间</label>
                    <div class="layui-input-block" >
                        <input type="text" id="ExitTime" required  autocomplete="off" class="layui-input layui-disabled">
                    </div>
                </div>

                <div class="layui-form-item">
                    <div class="layui-input-block">
                        <input type="button" class="layui-btn layui-layer-btn0" value="确认退房" />
                    </div>
                </div>
            </form>
        </div>

    </div>

</div>
<script src="${pageContext.request.contextPath}/static/common/jquery-3.6.0.min.js"></script>
<script src="${pageContext.request.contextPath}/static/common/layui/layui.js"></script>
<script>
    var checkprice;
    var id;
    //JS
    layui.use(['upload','element', 'layer', 'util'], function(){
        var element = layui.element
            ,upload = layui.upload
            ,layer = layui.layer
            ,util = layui.util
            ,$ = layui.$;

        //头部事件
        util.event('lay-header-event', {
            //左侧菜单事件
            menuLeft: function(othis){
                layer.msg('展开左侧菜单的操作', {icon: 0});
            }
            ,menuRight: function(){
                layer.open({
                    type: 1
                    ,content: '<div style="padding: 15px;">处理右侧面板的操作</div>'
                    ,area: ['260px', '100%']
                    ,offset: 'rt' //右上角
                    ,anim: 5
                    ,shadeClose: true
                });
            }
        });
    });

        $(".layui-layer-btn0").on("click",function () {
            check()
        });

        function check(){
            var json = {
                "id" : id,
                "suiteNum": document.getElementById("suiteNum").value,
                "checkPrice":document.getElementById("checkPrice").value,
                "checkAdmin":${cookie.name.value},
                "exitTime" : document.getElementById("EnterTime").value,
            }
            var jsonDate = JSON.stringify(json)
            $.ajax({
                type : 'POST',
                data : jsonDate,
                dataType : 'json',
                contentType: 'application/json;charset=UTF-8',
                url :"${pageContext.request.contextPath}/Order/Finish",
                success: function(data){
                    if(data == "200"){
                        clear()
                        layer.msg('操作成功');
                    }else {
                        layer.msg('操作失败');
                    }
                }

            });
        }
        function clear(){
            $("#suitePrice").val(" ");
            $("#suiteType").val(" ");
            $("#roomNum").val(" ");
            $("#sex").val(" ");
            $("#name").val(" ");
            $("#card").val(" ");
            $("#phone").val(" ");
            $("#EnterTime").val("");
            $("#checkPrice ").val("");
        }

        function checkNum(){
            var num = String(document.getElementById("suiteNum").value)
            $.ajax({
                url :"${pageContext.request.contextPath}/Order/checkNum?num="+num,
                success: function(data){
                    $("#suitePrice").val(data.suitePrice);
                    $("#suiteType").val(data.suiteType);
                    $("#name").val(data.name);
                    $("#sex").val(data.sex);
                    $("#phone").val(data.phone);
                    $("#card").val(data.card);
                    $("#EnterTime").val(data.enterTime);
                    $("#checkPrice ").val(data.suitePrice );
                    id = data.id;
                }
            });
        }

</script>
</body>
</html>

