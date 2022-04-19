<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <link rel="shortcut icon" href="#"/>
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
                <li class="layui-nav-item" ><a href="${pageContext.request.contextPath}/xian/Home">主页</a></li>
                <li class="layui-nav-item">
                    <a class="" href="javascript:;">住房管理</a>
                    <dl class="layui-nav-child">
                        <dd><a href="${pageContext.request.contextPath}/Order/addOrder">住户入住</a></dd>
                        <dd><a href="${pageContext.request.contextPath}/Order/list">住户列表</a></dd>
                        <dd><a href="javascript:;">住户预约</a></dd>
                        <dd><a href="${pageContext.request.contextPath}/Order/check">住户退房</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item layui-nav-itemed">
                    <a class="layui-this" href="javascript:;">房间管理</a>
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
                        <input type="text" id="suiteNum" required autocomplete="off" class="layui-input layui-input-inline">
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

                <div class="layui-form-item layui-upload">
                    <label class="layui-form-label"></label>
                    <div class="layui-input-block">
                        <button type="button" class="layui-btn layui-btn-normal" id="testList">选择多文件</button>
                        <div class="layui-upload-list" style="max-width: 1000px;">
                            <table class="layui-table">
                                <colgroup>
                                    <col>
                                    <col width="150">
                                    <col width="260">
                                    <col width="150">
                                </colgroup>
                                <thead>
                                <tr><th>文件名</th>
                                    <th>大小</th>
                                    <th>上传进度</th>
                                    <th>操作</th>
                                </tr></thead>
                                <tbody id="demoList"></tbody>
                            </table>
                        </div>
                        <button type="button" class="layui-btn" id="testListAction">开始上传</button>
                    </div>
                </div>

                <div class="layui-form-item layui-form-text">
                    <label class="layui-form-label">房间介绍</label>
                    <div class="layui-input-block">
                        <textarea placeholder="请输入备注"  id = "introduce"  class="layui-textarea"></textarea>
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
<script src="${pageContext.request.contextPath}/static/common/jquery-3.6.0.min.js"></script>
<script src="${pageContext.request.contextPath}/static/common/layui/layui.js"></script>
<script>
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

        $(".layui-layer-btn0").on("click",function () {
            add()
        });

        function add(){
            var json = {
                "roomNum": document.getElementById("suiteNum").value,
                "price":document.getElementById("suitePrice").value,
                "stype":document.getElementById("suiteType").value,
                "introduce":document.getElementById("introduce").value
            }
            var jsonDate = JSON.stringify(json)
            console.log(jsonDate)
            $.ajax({
                type : 'POST',
                data : jsonDate,
                dataType : 'json',
                contentType: 'application/json;charset=UTF-8',
                url :"${pageContext.request.contextPath}/suite/add",
                success: function(data){
                    if(data == "200"){
                        clear()
                        layer.msg('添加成功');
                    }else {
                        layer.msg('添加失败');
                    }
                }

            });
        }
        function clear(){
            $("#suitePrice").val(" ");
            $("#suiteType").val(" ");
            $("#roomNum").val(" ");
            $("#introduce").val(" ");
        }


        var uploadListIns = upload.render({
            elem: '#testList'
            ,elemList: $('#demoList') //列表元素对象
            ,url: 'https://httpbin.org/post' //此处用的是第三方的 http 请求演示，实际使用时改成您自己的上传接口即可。
            ,accept: 'file'
            ,multiple: true
            ,number: 3
            ,auto: false
            ,bindAction: '#testListAction'
            ,choose: function(obj){
                var that = this;
                var files = this.files = obj.pushFile(); //将每次选择的文件追加到文件队列
                //读取本地文件
                obj.preview(function(index, file, result){
                    var tr = $(['<tr id="upload-'+ index +'">'
                        ,'<td>'+ file.name +'</td>'
                        ,'<td>'+ (file.size/1014).toFixed(1) +'kb</td>'
                        ,'<td><div class="layui-progress" lay-filter="progress-demo-'+ index +'"><div class="layui-progress-bar" lay-percent=""></div></div></td>'
                        ,'<td>'
                        ,'<button class="layui-btn layui-btn-xs demo-reload layui-hide">重传</button>'
                        ,'<button class="layui-btn layui-btn-xs layui-btn-danger demo-delete">删除</button>'
                        ,'</td>'
                        ,'</tr>'].join(''));

                    //单个重传
                    tr.find('.demo-reload').on('click', function(){
                        obj.upload(index, file);
                    });

                    //删除
                    tr.find('.demo-delete').on('click', function(){
                        delete files[index]; //删除对应的文件
                        tr.remove();
                        uploadListIns.config.elem.next()[0].value = ''; //清空 input file 值，以免删除后出现同名文件不可选
                    });

                    that.elemList.append(tr);
                    element.render('progress'); //渲染新加的进度条组件
                });
            }
            ,done: function(res, index, upload){ //成功的回调
                var that = this;
                //if(res.code == 0){ //上传成功
                var tr = that.elemList.find('tr#upload-'+ index)
                    ,tds = tr.children();
                tds.eq(3).html(''); //清空操作
                delete this.files[index]; //删除文件队列已经上传成功的文件
                return;
                //}
                this.error(index, upload);
            }
            ,allDone: function(obj){ //多文件上传完毕后的状态回调
                console.log(obj)
            }
            ,error: function(index, upload){ //错误回调
                var that = this;
                var tr = that.elemList.find('tr#upload-'+ index)
                    ,tds = tr.children();
                tds.eq(3).find('.demo-reload').removeClass('layui-hide'); //显示重传
            }
            ,progress: function(n, elem, e, index){ //注意：index 参数为 layui 2.6.6 新增
                element.progress('progress-demo-'+ index, n + '%'); //执行进度条。n 即为返回的进度百分比
            }
        });


    });
</script>
</body>
</html>
