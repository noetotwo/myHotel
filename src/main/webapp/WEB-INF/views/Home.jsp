<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>管理系统大布局</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/common/layui/css/layui.css"/>
</head>
<body>
<div class="layui-layout layui-layout-admin">
    <div class="layui-header">
        <div class="layui-logo layui-hide-xs layui-bg-black">layout demo</div>
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
                <a href="javascript:;">
                    <img src="${pageContext.request.contextPath}/static/local/img/a.png" class="layui-nav-img">
                    tester
                </a>
                <dl class="layui-nav-child">
                    <dd><a href="">个人资料</a></dd>
                    <dd><a href="">重新登录</a></dd>
                    <dd><a href="">退出登录</a></dd>
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
                <li class="layui-nav-item layui-this" ><a href="javascript:;">主页</a></li>
                <li class="layui-nav-item">
                    <a class="" href="javascript:;">住房管理</a>
                    <dl class="layui-nav-child">
                        <dd><a href="javascript:;">住户入住</a></dd>
                        <dd><a href="javascript:;">住户列表</a></dd>
                        <dd><a href="javascript:;">住户预约</a></dd>
                        <dd><a href="">住户退房</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item">
                    <a href="javascript:;">房间管理</a>
                    <dl class="layui-nav-child">
                        <dd><a href="javascript:;">房间列表</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item">
                    <a href="javascript:;">会员管理</a>
                    <dl class="layui-nav-child">
                        <dd><a href="javascript:;">会员列表</a></dd>
                        <dd><a href="javascript:;">会员注销</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item"><a href="javascript:;">更多</a></li>
                <li class="layui-nav-item"><a href="">退出登录</a></li>
            </ul>
        </div>
    </div>

    <div class="layui-body">
        <!-- 内容主体区域 -->
        <div style="padding: 15px;">内容主体区域。记得修改 layui.css 和 js 的路径</div>
    </div>

    <div class="layui-footer">
        <!-- 底部固定区域 -->
        底部固定区域
    </div>
</div>
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
</script>
</body>
</html>