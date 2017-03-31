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
<div class="container">
    <ul class="nav nav-tabs">
        <li role="presentation" class="active"><a href="#">Home</a></li>
        <li role="presentation"><a href="#">Profile</a></li>
        <li role="presentation"><a href="#">Messages</a></li>
    </ul>
</div>
<div class="container">
    <h1>获取<small>会员信息</small></h1>
    <table class="table table-stripe">
        <tr>
            <th>姓名</th>
            <th>年龄</th>
            <th>性别</th>
            <th>好友</th>
        </tr>
    </table>
    <div class="result"></div>
    <nav aria-label="...">
        <ul class="pager">
            <li><a href="#">Previous</a></li>
            <li><a href="#">Next</a></li>
        </ul>
    </nav>
</div>
<hr>
<div class="container">
    <h1>创建<small>会员</small></h1>
    <div class="container">
        <div class="row">
            <div class="col-md-6 col-xs-6">
                <form>
                    <div class="form-group">
                        <label for="exampleName">Name</label>
                        <input type="text" class="form-control" id="exampleName">
                    </div>
                    <div class="form-group">
                        <label for="exampleAge">Age</label>
                        <input type="text" class="form-control" id="exampleAge">
                    </div>
                    <div class="form-group">
                        <label for="exampleGender">Gender</label>
                        <input type="text" class="form-control" id="exampleGender">
                    </div>
                    <div class="form-group">
                        <label for="exampleFriends">Friends</label>
                        <input type="text" class="form-control" id="exampleFriends">
                    </div>
                    <button type="submit" class="btn btn-default">Submit</button>
                </form>
            </div>
        </div>
    </div>
</div>


<!--code there-->
<script>

    $(function () {
        $.getJSON('/api/v1', function(resp) {
            if (resp && resp.e == 0) {
                var info = resp.r;
//                var html = '<p class="text-center">Name:' + info.name + '&nbsp&nbspAge:' + info.age + '&nbsp&nbspFriends' + info.friends + '</p>';
                var html = '<tr><td>'+info.name+'</td><td>'+info.age+'</td><td>'+info.gender+'</td><td>'+info.friends+'</td></tr>'
                $('table').append(html);
            }
        })
    })
</script>
<!--body-->
