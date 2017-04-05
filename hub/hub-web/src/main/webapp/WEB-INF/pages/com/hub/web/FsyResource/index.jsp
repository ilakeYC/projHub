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

<hr>


<c:out value="aaa"/>
<c:out value="${aaa}"/>
<c:out value="${aaa}" default="default"/>

<c:set var="a" value="hello A"/>
<c:set var="b" value="hello B" scope="session"/>
<c:out value="${a}"/>
<c:out value="${b}"/>

<c:set var="c" value="hello C"/>
<c:if test="${not empty c}">
    <c:out value="${c}"/>
</c:if>

<c:set var="score" value="96"/>
<c:choose>
    <c:when test="${score > 100 || score < 0}">错误地分数：${score}</c:when>
    <c:when test="${score >= 90}">A级</c:when>
    <c:when test="${score >= 80}">B级</c:when>
    <c:when test="${score >= 70}">C级</c:when>
    <c:when test="${score >= 60}">D级</c:when>
    <c:otherwise>E级</c:otherwise>
</c:choose>


<c:set var="sum" value="0"/>
<c:forEach var="i" begin="1" end="10">
    <c:set var="sum" value="${sum + i}"/>
</c:forEach>
<c:out value="sum = ${sum}"/>

<c:set var="sum" value="0"/>
<c:forEach var="i" begin="1" end="10" step="2">
    <c:set var="sum" value="${sum + i}"/>
</c:forEach>
<c:out value="sum = ${sum}"/>

<c:set var="score" value="66"/>
<c:choose>
    <c:when test="${score >= 100 || score < 0}">错误数据：${score}</c:when>
    <c:when test="${score >= 90}">A级</c:when>
    <c:when test="${score >= 80}">B级</c:when>
    <c:when test="${score >= 70}">C级</c:when>
    <c:when test="${score >= 60}">D级</c:when>
    <c:otherwise>E级</c:otherwise>
</c:choose>

<%
    out.println("Your IP address is " + request.getRemoteAddr());
%>
<%! int i = 520; %>
<%! int a, b, c; %>
<% out.println("i = " + i); %>
<c:choose>
    <c:when test="${score < 60}">你的score为：${score}</c:when>
</c:choose>

<p>
    今天的日期是: <%= (new java.util.Date()).toLocaleString()%>
</p>

<%! int day = 8; %>
<% if (day > 0 && day <= 7) { %>
    <p>day day day day day</p>
<% } else { %>
    <p>not</p>
<% } %>
<%
    switch (day) {
        case 1:
        case 2:
        case 3:
        case 4:
        case 5:
        case 6:
        case 7:
            out.print("in the week");
            break;
        default:
            out.print("error!");
            break;
    }
%>
<c:set var="total" value="0"/>
<c:forEach var="i" begin="1" end="100" step="2">
    <c:set var="total" value="${total + i}"/>
</c:forEach>
<c:out value="1+2+...+100 = ${total}"/>
<hr>
<c:out value="查看天数："/>
<c:set var="days" value="0"/>
<c:choose>
    <c:when test="${days > 0 && days < 8}">一星期之内</c:when>
    <c:when test="${days <= 0}">Error---${days}</c:when>
    <c:otherwise>一周后</c:otherwise>
</c:choose>

<hr>



<div class="container">
    <div class="row">
        <div class="col-md-6">
            <table class="table">
                <tr>
                    <th>Name</th>
                    <th>Gender</th>
                    <th>Age</th>
                    <th>Friends</th>
                </tr>
                <c:forEach var="i" begin="1" end="4">
                    <tr>
                        <td></td>
                        <td>1</td>
                        <td>13</td>
                        <td>3</td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
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
<<<<<<< HEAD
        $.getJSON('/api/v1/person', function(resp) {
=======
>>>>>>> ccd58ee2809ae166c022c4b50f51eebf4472f9c9
        $.getJSON('/api/v1/person', function (resp) {
            if (resp && resp.e == 0) {
                var infoArr = resp.r;
                for (var i = 0; i < infoArr.length; i++) {
                    var gender = infoArr[i].gender;
                    var age = infoArr[i].age;
                    var trClassStr = infoArr[i].id.toString();
<<<<<<< HEAD
                    var info = '<tr class = ' + trClassStr + '><td>' + infoArr[i].name + '</td><td>' + gender + '</td><td>' + infoArr[i].age + '</td><td><button class="btn btn-default" type="button">查看好友</button></td></tr>';
=======
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


>>>>>>> ccd58ee2809ae166c022c4b50f51eebf4472f9c9
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
            var json = {
                name: $("#nameTF").val(),
                age: parseInt($("#ageTF").val()),
                gender: genderDigByStr($("#genderTF").val()),
                friends: []
            };
            return json;
        }
<<<<<<< HEAD
=======

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
>>>>>>> ccd58ee2809ae166c022c4b50f51eebf4472f9c9
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
<<<<<<< HEAD

=======

        function updateJsonData() {

            var json = {
                name: $("#nameUpdateTF").val(),
                gender: genderDigByStr($("#genderupdatetf").val()),
                age: parseInt($("#ageupdatetf").val()),
                friends: []
            };
            return json;
        }
>>>>>>> ccd58ee2809ae166c022c4b50f51eebf4472f9c9
    })
</script>
<!--body-->
