<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>


<h1>Welcome ${pageContext.request.userPrincipal.name == null ? "" : pageContext.request.userPrincipal.name}
	to Spring MVC</h1>
<a href='<c:url value="/upload"/>'>Upload File</a>
<br />
<%-- <c:param name="isExists" value="${ pageContext.request.userPrincipal.name != null}"></c:param>
	<c:if test="${isExists}">
		<a href='<c:url value="/logout"/>'>Logout</a>
	</c:if> --%>


