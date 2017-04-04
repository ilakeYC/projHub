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

<div class="jumbotron">
  <div class="container">
    <h1 class="page-header text-center">Hello, world!</h1>
    <p class="text-center"><a class="btn btn-primary btn-lg" href="#" role="button">Learn more</a></p>
  </div>
</div>
<div class="container">

  <ul class="nav nav-tabs">
    <li role="presentation" class="active"><a href="#">Home</a></li>
    <li role="presentation"><a href="#">Profile</a></li>
    <li role="presentation"><a href="#">Messages</a></li>
  </ul>
</div>

<div class="container">
  <h1>获取
    <small>会员信息</small>
  </h1>
  <table class="table table-stripe table1">
    <tr>
      <th>姓名</th>
      <th>年龄</th>
      <th>性别</th>
      <th>好友</th>
    </tr>
  </table>
  <nav aria-label="...">
    <ul class="pager">
      <li><a href="#">Previous</a></li>
      <li><a href="#">Next</a></li>
    </ul>
  </nav>
  <hr>
</div>
<div class="container">
  <h1>创建
    <small>会员</small>
  </h1>
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
  <hr>
</div>
<div class="container">
  <button type="button" class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal">
    Launch button
  </button>
  <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
              aria-hidden="true">&times;</span></button>
          <h4 class="modal-title" id="myModalLabel">Modal title</h4>
        </div>
        <div class="modal-body">
          ...
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
          <button type="button" class="btn btn-primary">Save changes</button>
        </div>
      </div>
    </div>
  </div>
  <hr>
</div>

<div class="container">
  <h1>会员信息</h1>
  <table class="table table2">
    <tr>
      <th>姓名</th>
      <th>性别</th>
      <th>年龄</th>
      <th>好友</th>
    </tr>
  </table>
  <hr>
</div>

<div class="container">
  <h1>添加
    <small>会员</small>
  </h1>
  <div class="row">
    <div class="col-xs-6 col-md-6">
      <form>
        <div class="form-group">
          <label for="nameTF">Name</label>
          <input type="text" class="form-control" id="nameTF">
        </div>
        <div class="form-group">
          <label for="genderTF">Gender</label>
          <input type="text" class="form-control" id="genderTF">
        </div>
        <div class="form-group">
          <label for="ageTF">Age</label>
          <input type="text" class="form-control" id="ageTF">
        </div>
        <button class="btn btn-default addPersonBtn">Create</button>
      </form>
    </div>
  </div>
  <hr>
</div>
<div class="container">
  <h1>更新
    <small>会员信息</small>
  </h1>
  <div class="row">
    <div class="col-xs-6 col-md-6">
      <form>
        <div class="form-group">
          <label for="nameUpdateTF">Name</label>
          <input type="text" class="form-control" id="nameUpdateTF">
        </div>
        <div class="form-group">
          <label for="genderUpdateTF">Gender</label>
          <input type="text" class="form-control" id="genderUpdateTF">
        </div>
        <div class="form-group">
          <label for="ageUpdateTF">Age</label>
          <input type="text" class="form-control" id="ageUpdateTF">
        </div>
        <div class="form-group">
          <label for="friendsUpdateTF">Friends</label>
          <input type="text" class="form-control" id="friendsUpdateTF">
        </div>
        <button class="btn btn-default updateBtn" type="submit">UpdateInformations</button>
      </form>
    </div>
  </div>
  <hr>
</div>
<!--code there-->
<script>

    $(function () {
        $.getJSON('/api/v1/person', function (resp) {
            if (resp && resp.e == 0) {
                var infomations = resp.r;
                console.log(infomations.length);
                for (var i = 0; i < infomations.length; i++) {
                    var gender = genderStrByDig(infomations[i].gender);
                    var info = '<tr><td>' + infomations[i].name + '</td><td>' + infomations[i].age + '</td><td>' + gender + '</td>';
                    var url = '/api/v1/person/' + infomations[i].id.toString();
                    var friendsName = '';
                    $.ajax({
                        url: url,
                        async: false,
                        success: function (resp) {
                            if (resp && resp.e == 0) {
                                var infos = resp.r;
                                if (infos.properties) {
                                    var friends = infos.properties.friends;
                                    for (var i = 0; i < friends.length; i++) {
                                        friendsName += friends[i].name + ' ';
                                    }
                                }
                            } else {
                                alert('error!!!')
                            }
                        }
                    });
                    info += '<td>' + friendsName + '</td></tr>';
                    console.log(info);
                    $('.table1').append(info);
                }
            }
        });
        $.getJSON('/api/v1/person', function (resp) {
            if (resp && resp.e == 0) {
                var infoArr = resp.r;
                for (var i = 0; i < infoArr.length; i++) {
                    var gender = infoArr[i].gender;
                    var age = infoArr[i].age;
                    var trClassStr = infoArr[i].id.toString();
//                    var info = '<tr class = '+trClassStr+'><td>'+infoArr[i].name+'</td><td>'+gender+'</td><td>'+infoArr[i].age+'</td><td><button class="btn btn-default" type="button">查看好友</button></td></tr>';

                    var info = `
                    <tr class = ${ trClassStr }>
                        <td>${ infoArr[i].name }</td>
                        <td>${ gender }</td>
                        <td>${ age }</td>
                        <td>
                            <button class="btn btn-default" type="button">查看好友</button>
                        </td>
                        </tr>`;


                    $('.table2').append(info);
                }
            }
        });
        $('.addPersonBtn').click(function () {
            $.ajax({
                type: "POST",
                url: "/api/v1/person",
                data: getJsonData(),
                success: function () {
                    alert("SUCCESS：存储成功");
                },
                error: function () {
                    alert("ERROR：存储失败！")
                }
            })
        });
        function getJsonData() {
            var genderStr = $("#genderTF").val();
            var json = {
                name: $("#nameTF").val(),
                age: parseInt($("#ageTF").val()),
                gender: genderDigByStr($("#genderTF").val()),
                friends: []
            };
            return json;
        }

        $(".updateBtn").click(function () {
            $.ajax({
                type: "POST",
                url: "/api/v1/person/{id}/update",
                data: updateJsonData(),
                success: function () {
                    alert("success!");
                },
                error: function () {
                    alert("error")
                }
            })
        });
        function genderDigByStr(genderStr) {
            if (genderStr == "男" || genderStr == "male") {
                return 1;
            } else if (genderStr == "女" || genderStr == "female") {
                return 2;
            }
        }

        function genderStrByDig(genderDig) {
            return genderDig == 1 ? "男" : "女";
        }

        function updateJsonData() {

            var json = {
                name: $("#nameUpdateTF").val(),
                gender: genderDigByStr($("#genderupdatetf").val()),
                age: parseInt($("#ageupdatetf").val()),
                friends: []
            };
            return json;
        }
    })
</script>
<!--body-->
