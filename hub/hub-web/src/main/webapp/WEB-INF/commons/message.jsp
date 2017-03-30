<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/commons/taglibs.jsp" %>
<c:if test="${not empty _error}">
  <div id="message" class="alert alert-danger"><span class="glyphicon glyphicon-remove-sign" aria-hidden="true"></span>&nbsp;${_error}
  </div>
</c:if><c:if test="${not empty _msg}">
  <div id="message" class="alert alert-info"><span class="glyphicon glyphicon-info-sign" aria-hidden="true"></span>&nbsp;${_msg}
  </div>
</c:if>