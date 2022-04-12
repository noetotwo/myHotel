<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <link rel="shortcut icon" href="#"/>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/common/layui/css/layui.css"/>
    <title>信息修改</title>
    <script src="${pageContext.request.contextPath}/static/common/jquery-3.6.0.min.js"></script>
    <script src="${pageContext.request.contextPath}/static/common/layui/layui.js"></script>
</head>
<body>
<div style="height: 10px"></div>

<form class="layui-form" >

    <div class="layui-form-item">
        <label class="layui-form-label">姓名</label>
        <div class="layui-input-block">
            <input type="text" name="Name" required   value="${o.name}" autocomplete="off" class="layui-input" >
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">性别</label>
        <div class="layui-input-block">
            <select name="Sex" class="layui-input" autocomplete="off"  required >
                <option value="${o.sex}"></option>
                <option value="男">男</option>
                <option value="女">女</option>
            </select>
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">身份证号</label>
        <div class="layui-input-block">
            <input type="number" name="Card" oninput="if(value.length>18)value=value.slice(0,18)" required  value="${o.card}" autocomplete="off" class="layui-input">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">手机号</label>
        <div class="layui-input-block">
            <input type="text" name="Phone" required  value="${o.phone}" autocomplete="off" class="layui-input">
        </div>
    </div>

    <div class="layui-form-item" >
        <label class="layui-form-label">入住时间</label>
        <div class="layui-input-block" >
            <input type="text" id="EnterTime" required   value="${o.enterTime}" autocomplete="off" class="layui-input layui-disabled">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">房间类型</label>
        <div class="layui-input-block">
            <select name="S_Type" class="layui-input" autocomplete="off"   required >
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
                <option value="双床终点房（三小时）">双床终点房（三小时）</option>
            </select>
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">房间号</label>
        <div class="layui-input-block">
            <input type="text" name="Num" required  value="${o.suiteNum}"  autocomplete="off" class="layui-input">
        </div>
    </div>

    <div class="layui-form-item">
        <div class="layui-input-block">
            <input type="submit" class="layui-btn layui-layer-btn0" value="确认修改" />
            <input type="button" class="layui-btn layui-btn-danger layui-layer-btn1"  value="取消修改"/>
        </div>
    </div>
</form>
<script>
    layui.use('form', function(){
        var form = layui.form;
        //各种基于事件的操作，下面会有进一步介绍
    });

    var index = parent.layer.getFrameIndex(window.name);

    $(".layui-layer-btn1").on("click",function () {
        endcode();
        parent.layer.close(index);
    });
    $(".layui-layer-btn0").on("click",function () {
        endcode();
        /*parent.$("#coverone").prop("src",base64url);	//修改元素属性
        parent.$("#input").val(base64url);				//表单回填
        parent.layui.table.reload('tk-info-list');	*/	//表格刷新
        parent.layer.close(index);						//关闭弹窗
    });

    function endcode(){
        $.ajax({
            url :"${pageContext.request.contextPath}/Order/EndUpdate?id="+String(${o.id}),
            success: function(data){
                console.log(data)
            }
        });
        console.log(${o.code});
        console.log("结束")
    }
</script>
</body>
</html>
