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
                <li class="layui-nav-item">
                    <a  href="javascript:;">住房管理</a>
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
                <li class="layui-nav-item layui-nav-itemed">
                    <a class="layui-this" href="javascript:;">会员管理</a>
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
        <table class="layui-hide" id="test" lay-filter="roles"></table>
    </div>

</div>
<script type="text/html" id="barDemo">
    <a class="layui-btn  layui-btn-xs " lay-event="del">编辑</a>
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

    function renderAddrTable(res){
        layui.use('table', function(){
            table = layui.table;
            table.render({
                id: "orderData",
                elem: '#test'
                ,cols: [[
                    {field:'id', title: 'ID', sort: true}
                    ,{field:'name',width:'7%', title: '客户姓名'} //width 支持：数字、百分比和不填写。你还可以通过 minWidth 参数局部定义当前单元格的最小宽度，layui 2.2.1 新增
                    ,{field:'sex', title: '性别'}
                    ,{field:'card',width:'13%', title: '身份证号'}
                    ,{field:'phone', width:'10%',title: '手机号'}
                    ,{field:'viptype',width:'8%', title: 'VIP等级',sort: true, }
                    ,{field:'email',width:'13%', title: '邮箱', sort: true, }
                    ,{field:'registerTime',width:'13%', title: '注册时间', sort: true, } //单元格内容水平居右
                    ,{field:'integral',width:'7%', title: '积分', sort: true,}
                    ,{field:'right', title: '操作' ,  toolbar: '#barDemo',align: 'center' }//单元格内容水平居中
                ]]
                ,data : res,
            });

            table.on('tool(roles)', function(obj) {
                var checkStatus = obj.data;
                Revise(checkStatus)
            });
        });
    }
    function Revise(date) {
        layer.open({
            type: 2,
            title:String(date.name)+"用户信息",
            content: "${pageContext.request.contextPath}/Client/update?id="+String(date.id),
            offset: 'rt' ,//右上角
            area: ['500px', '100%'],
            maxmin: true,
            cancel: function(index, layero){
                layer.close(index)
            },
        });
    }

    function res(){
        $.ajax({
            url :"${pageContext.request.contextPath}/Client/all",
            success: function(data){
                renderAddrTable(data)
            }
        });

    }

    function endUpdate(){
        layer.msg('结束修改');
    }

    setTimeout(function() {res();}, 200);
    /*3秒询读取函数*/
    setInterval(function() {res();}, 5000);

</script>
</body>
</html>
