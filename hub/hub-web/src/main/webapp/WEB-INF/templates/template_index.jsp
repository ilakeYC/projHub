<%--
  Created by IntelliJ IDEA.
  User: ilakeyc
  Date: 2017/3/28
  Time: 14:57
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE HTML>
<%@ page language="java" pageEncoding="UTF-8" %>
<%--<%@ include file="/WEB-INF/commons/head.jsp"%>--%>
<html>
<head>
  <title>Hello</title>
</head>
<body>
<%@ include file="/WEB-INF/commons/message.jsp" %>
<c:if test="${not _blank}">
  <d:body/>
</c:if>
<%--<%@ include file="/WEB-INF/commons/footer.jsp"%>--%>
</body>
</html>
