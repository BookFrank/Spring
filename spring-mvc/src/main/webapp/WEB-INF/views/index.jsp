<%--
  User: jiaer.ly
  Date: 2018/2/17
  Time: 下午7:08
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script src="http://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>

    <title>Title</title>

</head>
<body>

<form id="form1">
    <input type="text" name="name">

    <select name="region">
        <option>请选择</option>
        <option value="west">西部</option>
        <option value="east">东部</option>
    </select>

    <input type="button" id="search" value="查找" placeholder="请输入名称...">
</form>




<table class="footable table table-stripped toggle-arrow-tiny" data-page-size="15">
    <thead>
    <tr>

        <th data-toggle="true">事件ID</th>
        <th data-hide="phone">提交时间</th>
        <th>事件来源</th>
        <th>事件类型</th>
        <th>事件名称</th>
        <th data-hide="all">事件详情</th>
        <!-- <th data-hide="phone">Status</th> -->
        <th class="text-right" data-sort-ignore="true">操作</th>
    </tr>
    </thead>
    <tbody>
    <tr>
        <td>1001</td>
        <td>2017-12-19</td>
        <td>广东高管局</td>
        <td>封路</td>
        <td>广深高速大雾封路</td>
        <td>
            2017-12-19，因大雾，广深高速001号段封路。
        </td>
        <td class="text-right">
            <div class="btn-group">
                <button class="btn-white btn btn-xs">编辑</button>
                <button class="btn-white btn btn-xs">删除</button>
            </div>
        </td>
    </tr>
    <tr>
        <td>1001</td>
        <td>2017-12-19</td>
        <td>广东高管局</td>
        <td>封路</td>
        <td>广深高速大雾封路</td>
        <td>
            2017-12-19，因大雾，广深高速001号段封路。
        </td>
        <td class="text-right">
            <div class="btn-group">
                <button class="btn-white btn btn-xs">编辑</button>
                <button class="btn-white btn btn-xs">删除</button>
            </div>
        </td>
    </tr>
    <tr>
        <td>1001</td>
        <td>2017-12-19</td>
        <td>广东高管局</td>
        <td>封路</td>
        <td>广深高速大雾封路</td>
        <td>
            2017-12-19，因大雾，广深高速001号段封路。
        </td>
        <td class="text-right">
            <div class="btn-group">
                <button class="btn-white btn btn-xs">编辑</button>
                <button class="btn-white btn btn-xs">删除</button>
            </div>
        </td>
    </tr>
    <tr>
        <td>1001</td>
        <td>2017-12-19</td>
        <td>广东高管局</td>
        <td>封路</td>
        <td>广深高速大雾封路</td>
        <td>
            2017-12-19，因大雾，广深高速001号段封路。
        </td>
        <td class="text-right">
            <div class="btn-group">
                <button class="btn-white btn btn-xs">编辑</button>
                <button class="btn-white btn btn-xs">删除</button>
            </div>
        </td>
    </tr>
    <tr>
        <td>1001</td>
        <td>2017-12-19</td>
        <td>广东高管局</td>
        <td>封路</td>
        <td>广深高速大雾封路</td>
        <td>
            2017-12-19，因大雾，广深高速001号段封路。
        </td>
        <td class="text-right">
            <div class="btn-group">
                <button class="btn-white btn btn-xs">编辑</button>
                <button class="btn-white btn btn-xs">删除</button>
            </div>
        </td>
    </tr>
    <tr>
        <td>1001</td>
        <td>2017-12-19</td>
        <td>广东高管局</td>
        <td>封路</td>
        <td>广深高速大雾封路</td>
        <td>
            2017-12-19，因大雾，广深高速001号段封路。
        </td>
        <td class="text-right">
            <div class="btn-group">
                <button class="btn-white btn btn-xs">编辑</button>
                <button class="btn-white btn btn-xs">删除</button>
            </div>
        </td>
    </tr>
    </tbody>
    <tfoot>
    <tr>
        <td colspan="6">
            <ul class="pagination pull-right"></ul>
        </td>
    </tr>
    </tfoot>
</table>
<script type="text/javascript">

    $("#search").click(function () {
        $.ajax({
            type: "POST",
            dataType: "json",
            url: "/players",
            data: $('#form1').serialize(),
            success: function(result){
                console.log("success");
                console.log(result);
            },
            error: function(){
                alert("异常");
            }
        });
    });
</script>
</body>
</html>
