<%--
  Created by IntelliJ IDEA.
  User: ilakeyc
  Date: 2017/7/16
  Time: 14:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/commons/taglibs.jsp" %>

<%-- 显示所有的人 --%>

<div id="foo" style="margin-left: 30px">

    <h1>人物列表</h1>

    <%--${}--%>
    <%--${persons[0].name}--%>

    <c:forEach var="person" items="${persons}">
        ${person.name}
        <ul>
            <li>年龄：${person.age}</li>
            <li>性别：
                <c:choose>
                    <c:when test="${person.gender == 1}">
                        <c:choose>
                            <c:when test="${person.status == 0}">男</c:when>
                            <c:otherwise>不可用</c:otherwise>
                        </c:choose>
                    </c:when>
                    <c:when test="${person.gender == 2}">女</c:when>
                    <c:otherwise>N/A</c:otherwise>
                </c:choose>
            </li>
            <li>状态：
                <c:if test="${person.status == 0}">正常</c:if>
                <c:if test="${person.status != 0}">不可用</c:if>
            </li>
            <li>操作：<a class="removeButton btn-danger btn" data-name="${person.name}" data-id="${person.id}">删除</a></li>
        </ul>
    </c:forEach>

</div>

<script>

    $(function () {

        $('.removeButton').click(function () {
            var id = $(this).attr('data-id');
            var name = $(this).attr('data-name');
            console.log(name, id);
        })

    })

</script>
