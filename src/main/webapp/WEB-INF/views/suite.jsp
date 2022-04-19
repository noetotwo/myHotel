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
    <div class="right">

        <form class="layui-form" >

            <div class="layui-form-item">
                <label class="layui-form-label">房间号</label>
                <div class="layui-input-block">
                    <input type="text" id="suiteNum" required autocomplete="off" value="${s.roomNum}"  class="layui-input layui-input-inline">
                </div>
            </div>

            <div class="layui-form-item">
                <label class="layui-form-label">房间价格</label>
                <div class="layui-input-block">
                    <input type="text" id="suitePrice" required autocomplete="off" value="${s.price}" class="layui-input layui-input-inline">
                </div>
            </div>

            <div class="layui-form-item">
                <label class="layui-form-label">房间类型</label>
                <div class="layui-input-block">
                    <select id="suiteType" class="layui-input" autocomplete="off"   required >
                        <option value="${s.SType}">${s.SType}</option>
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

            <div class="layui-form-item">
                <label class="layui-form-label">房间状态</label>
                <div class="layui-input-block">
                    <select id="state" class="layui-input" autocomplete="off"   required >
                        <option value="${s.state}">${s.state}</option>
                        <option value="已入住">已入住</option>
                        <option value="空房">空房</option>
                        <option value="维修中">维修中</option>
                        <option value="未打扫">未打扫</option>
                    </select>
                </div>
            </div>

            <div class="layui-form-item layui-form-text">
                <label class="layui-form-label">房间介绍</label>
                <div class="layui-input-block">
                    <textarea placeholder=""  id = "introduce" value="${s.introduce}" class="layui-textarea"></textarea>
                </div>
            </div>

            <div class="layui-form-item">
                <div class="layui-input-block">
                    <input type="button" class="layui-btn layui-layer-btn0" value="确认修改" />
                    <input type="button" class="layui-btn layui-btn-danger layui-layer-btn1"  value="取消修改"/>
                </div>
            </div>
        </form>
    </div>

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
            url :"${pageContext.request.contextPath}/suite/EndUpdate?id="+String(${s.id}),
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
            "id":${s.id},
            "roomNum":document.getElementById("suiteNum").value,
            "stype":document.getElementById("suiteType").value,
            "price":document.getElementById("suitePrice").value,
            "state":document.getElementById("state").value,
            "introduce":document.getElementById("introduce").value,
        }
        var jsonDate = JSON.stringify(json)
        $.ajax({
            type : 'POST',
            data : jsonDate,
            dataType : 'json',
            contentType: 'application/json;charset=UTF-8',
            url :"${pageContext.request.contextPath}/suite/submit",
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
