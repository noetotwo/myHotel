<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <link rel="shortcut icon" href="#"/>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>贤哲管理系统</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/common/layui/css/layui.css"/>
    <%--    获取系统时间--%>
    <script>
        window.onload = function(){
            function getDate(){
                var today = new Date();
                var date;
                date = (today.getFullYear()) +"-" + (today.getMonth() + 1 ) + "-" + today.getDate() + " " + today.toLocaleTimeString();
                return date;
            }
            window.setInterval(function(){
                document.getElementById("EnterTime").value=getDate();
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
                <li class="layui-nav-item " ><a href="${pageContext.request.contextPath}/xian/Home">主页</a></li>
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
                    <a href="javascript:;">房间管理</a>
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
        <!-- 内容主体区域 -->
        <fieldset class="layui-elem-field layui-field-title">
            <legend>添加住客</legend>
        </fieldset>
        <div class="right">

            <form class="layui-form " >

                <div class="layui-form-item">
                    <label class="layui-form-label">姓名</label>
                    <div class="layui-input-block">
                        <input type="text" id="name" required  autocomplete="off" class="layui-input layui-input-inline" >
                    </div>
                </div>

                <div class="layui-form-item">
                    <label class="layui-form-label">性别</label>
                    <div class="layui-input-block">
                        <select id="sex" class="layui-input" autocomplete="off"  required >
                            <option value=""></option>
                            <option value="男">男</option>
                            <option value="女">女</option>
                        </select>
                    </div>
                </div>

                <div class="layui-form-item">
                    <label class="layui-form-label">身份证号</label>
                    <div class="layui-input-block">
                        <input type="card" id="card" oninput="if(value.length>18)value=value.slice(0,18)" required  value="${o.card}" autocomplete="off" class="layui-input">
                    </div>
                </div>

                <div class="layui-form-item">
                    <label class="layui-form-label">手机号</label>
                    <div class="layui-input-block">
                        <input type="text" id="phone" oninput="if(value.length>11)value=value.slice(0,11)" required autocomplete="off" class="layui-input ">
                    </div>
                </div>

                <div class="layui-form-item" >
                    <label class="layui-form-label">入住时间</label>
                    <div class="layui-input-block" >
                        <input type="text" id="EnterTime" required  autocomplete="off" class="layui-input">
                    </div>
                </div>

                <div class="layui-form-item">
                    <label class="layui-form-label">房间号</label>
                    <div class="layui-input-block">
                        <input type="text" id="suiteNum" oninput="Num()" required autocomplete="off" class="layui-input layui-input-inline">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">房间价格</label>
                    <div class="layui-input-block">
                        <input type="text" id="suitePrice" required autocomplete="off" class="layui-input layui-input-inline">
                    </div>
                </div>

                <div class="layui-form-item">
                    <label class="layui-form-label">房间类型</label>
                    <div class="layui-input-block">
                        <select id="suiteType" class="layui-input" autocomplete="off"   required >
                            <option value=""></option>
                            <option value="豪华大床房">豪华大床房</option>
                            <option value="高级大床房">高级大床房</option>
                            <option value="普通大床房">普通大床房</option>
                            <option value="豪华套房">豪华套房</option>
                            <option value="标准套房">标准套房</option>
                            <option value="高级三人间">高级三人间</option>
                            <option value="普通三人间">普通三人间</option>
                            <option value="豪华双床房">豪华双床房</option>
                            <option value="高级双床房">高级双床房</option>
                            <option value="普通双床房">普通双床房</option>
                            <option value="豪华圆床房">豪华圆床房</option>
                            <option value="豪华水床房">豪华水床房</option>
                            <option value="高级电脑房">高级电脑房</option>
                            <option value="大床钟点房（四小时）">大床钟点房（四小时）</option>
                            <option value="双床终点房（四小时）">双床终点房（四小时）</option>
                            <option value="大床钟点房（三小时）">大床钟点房（三小时）</option>
                        </select>
                    </div>
                </div>

                <div class="layui-form-item layui-form-text">
                    <label class="layui-form-label">备注</label>
                    <div class="layui-input-block">
                        <textarea placeholder="请输入备注"  id = "remark"  class="layui-textarea"></textarea>
                    </div>
                </div>

                <div class="layui-form-item">
                    <div class="layui-input-block">
                        <input type="button" class="layui-btn layui-layer-btn0" value="确认添加" />
                    </div>
                </div>
            </form>
        </div>
    </div>

</div>
<script type="text/html" id="barDemo">
    <a class="layui-btn  layui-btn-xs" lay-event="del">编辑</a>
</script>
<script src="${pageContext.request.contextPath}/static/common/jquery-3.6.0.min.js"></script>
<script src="${pageContext.request.contextPath}/static/common/layui/layui.js"></script>
<script>
    //JS
    layui.use(['element', 'layer', 'util'], function(){
        var element = layui.element
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
        add()
    });

    function add(){
        if(document.getElementById("card").value != null && document.getElementById("suiteNum").value != null){
        var json = {
            "name": document.getElementById("name").value,
            "sex":document.getElementById("sex").value,
            "card":document.getElementById("card").value,
            "phone":document.getElementById("phone").value,
            "enterTime":document.getElementById("EnterTime").value,
            "suitePrice":document.getElementById("suitePrice").value,
            "billingAdmin":"${cookie.name.value}",
            "state":"已入住",
            "suiteType":document.getElementById("suiteType").value,
            "suiteNum":document.getElementById("suiteNum").value,
            "remark":document.getElementById("remark").value
        }
        var jsonDate = JSON.stringify(json)
        console.log(jsonDate)
        $.ajax({
            type : 'POST',
            data : jsonDate,
            dataType : 'json',
            contentType: 'application/json;charset=UTF-8',
            url :"${pageContext.request.contextPath}/Order/add",
            success: function(data){
                if(data == "200"){
                    clear()
                    layer.msg('入住成功');
                }else {
                    layer.msg('入住失败');
                }
            }

        });
        }else{
            layer.msg('不能为空');
        }
    }
    function clear(){
        $("#name").val(" ");
        $("#sex").val(" ");
        $("#card").val(" ");
        $("#phone").val(" ");
        $("#EnterTime").val(" ");
        $("#suitePrice").val(" ");
        $("#Type").val(" ");
        $("#suiteNum").val(" ");
        $("#remark").val(" ");
    }

    function Num(){
        if(document.getElementById("suiteNum").value != null){
            var num = String(document.getElementById("suiteNum").value)
            $.ajax({
                url :"${pageContext.request.contextPath}/suite/num?num="+num,
                success: function(data){
                    $("#suitePrice").val(data.price);
                    $("#suiteType").val(data.stype);
                }
            });
        }else{
            layer.msg('房间号不能为空');
        }

    }

</script>
</body>
</html>
