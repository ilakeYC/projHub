<%--
  Created by IntelliJ IDEA.
  User: ilakeyc
  Date: 2017/3/30
  Time: 21:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/commons/taglibs.jsp" %>
<!--body-->
<h1>获取会员信息</h1>
<div class="result"></div>
<h1>创建会员</h1>
<form mothod="POST" id="submit_form">
    <label for="name">姓名：</label>
    <input type="text" id="name">
    <label for="age">年龄：</label>
    <input type="text" id="age">
    <label for="gender">性别：</label>
    <input type="text" id="gender">
    <label for="friends">好友(可多个)：</label>
    <input type="text" id="friends">
    <input id="submit" type="submit" value="确定创建">
</form>
<hr>

<div class="container">
    <div class="row">
        <div class="col-md-6">
            <div class="form-group">
                
            </div>
        </div>
    </div>
</div>


<!--code there-->
<script>
    $(function() {
        $.getJSON('/api/v1', function (resp) {
            if (resp && resp.e == 0) {
                var infomations = resp.r;
                var html = '<p>姓名:' + infomations.name + '&nbsp&nbsp性别:' + infomations.gender + '&nbsp&nbsp好友:' + infomations.friends + '</p>';
                $(".result").append(html);
            }
        });

        $.getJSON('/api/v1', function(resp) {
            if (resp && resp.e == 0) {
                var info = resp.r;
                var html = '<div>name:'+ info.name + '&nbsp&nbspage:' + info.age + '&nbsp&nbspgender:' + info.gender + '</div>'
                $(".result").append(html);
            }
        });




        $("#submit").click(function() {
            var options = {
                url: '/api/v1/add',
                type: 'post',
                dataType: 'text',
                data: $("#submit_form").serialize(),
                success: function (data) {
                    if (data.length > 0)
                        $(".result").html(data);
                        alert("success!")
                }
            };
            $.ajax(options);
        });

    });
</script>
<!--body-->
