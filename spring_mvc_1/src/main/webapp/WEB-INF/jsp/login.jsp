<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

	<div class="container">
		<div class="login-parent">
			<spring:url value="/login" var="action" />
			<form:form method="post" action="${action}" modelAttribute="loginRequest">
				<spring:message code="label.username" />
				<input type="text" name="username" value="${loginRequest.username}" />
				<br/>
				<form:errors path="username" />
				<br />
				<spring:message code="label.password" />
				<input type="password" name="password"
					value="${loginRequest.password}" />
						<br/>
				<form:errors path="password" />
				<br /> <input type="submit"
					value="<spring:message code="label.login" />" class="login-button" />
			</form:form>

		</div>
	</div>
