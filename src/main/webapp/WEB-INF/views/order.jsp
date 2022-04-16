<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
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
            <input type="text" id="Name" required   value="${o.name}" autocomplete="off" class="layui-input" >
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">性别</label>
        <div class="layui-input-block">
            <select id="Sex" class="layui-input" autocomplete="off"  required >
                <option value="${o.sex}">${o.sex}</option>
                <option value="男">男</option>
                <option value="女">女</option>
            </select>
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">身份证号</label>
        <div class="layui-input-block">
            <input type="number" id="Card" oninput="if(value.length>18)value=value.slice(0,18)" required  value="${o.card}" autocomplete="off" class="layui-input lay-size=“18” ">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">手机号</label>
        <div class="layui-input-block">
            <input type="text" id="Phone" required  value="${o.phone}" autocomplete="off" class="layui-input lay-size=“11”">
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
            <select id="Type" class="layui-input" autocomplete="off"   required >
                <option value="${o.suiteType}">${o.suiteType}</option>
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
            <input type="text" id="Num" required  value="${o.suiteNum}"  autocomplete="off" class="layui-input">
        </div>
    </div>

    <div class="layui-form-item layui-form-text">
        <label class="layui-form-label">备注</label>
        <div class="layui-input-block">
            <textarea placeholder="${o.remark}"  id = "remark"  class="layui-textarea"></textarea>
        </div>
    </div>

    <div class="layui-form-item">
        <div class="layui-input-block">
            <input type="button" class="layui-btn layui-layer-btn0" value="确认修改" />
            <input type="button" class="layui-btn layui-btn-danger layui-layer-btn1"  value="取消修改"/>
        </div>
    </div>
</form>
<script>
    var index = parent.layer.getFrameIndex(window.name);

    $(".layui-layer-btn1").on("click",function () {
        endcode();
    });
    $(".layui-layer-btn0").on("click",function () {
        ask()
    });

    function endcode(){
        $.ajax({
            url :"${pageContext.request.contextPath}/Order/EndUpdate?id="+String(${o.id}),
            success: function(data){
                if(data == "200"){
                    parent.res();
                    parent.endUpdate();
                }else {
                    layer.msg('服务器异常');
                }
            }
        });
        parent.layer.close(index);//关闭弹窗
    }

    function ask(){
        var json = {
            "id":${o.id},
            "name": document.getElementById("Name").value,
            "sex":document.getElementById("Sex").value,
            "card":document.getElementById("Card").value,
            "phone":document.getElementById("Phone").value,
            "suiteType":document.getElementById("Type").value,
            "suiteNum":document.getElementById("Num").value,
            "remark":document.getElementById("remark").value
        }
        var jsonDate = JSON.stringify(json)
        console.log(jsonDate)
        $.ajax({
            type : 'POST',
            data : jsonDate,
            dataType : 'json',
            contentType: 'application/json;charset=UTF-8',
            url :"${pageContext.request.contextPath}/Order/submit",
            success: function(data){
                if(data == "200"){
                    endcode();
                }
            }

        });
    }
</script>
</body>
</html>
