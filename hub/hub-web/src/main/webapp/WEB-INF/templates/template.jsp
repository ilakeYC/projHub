<%--
  Created by IntelliJ IDEA.
  User: ilakeyc
  Date: 2017/3/30
  Time: 21:24
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE HTML>
<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/commons/taglibs.jsp" %>
<html>
<head>
  <title>Hello</title>
</head>
<body>
<%@ include file="/WEB-INF/commons/message.jsp" %>
<c:if test="${not _blank}">
  <d:body/>
</c:if>
</body>
</html>
