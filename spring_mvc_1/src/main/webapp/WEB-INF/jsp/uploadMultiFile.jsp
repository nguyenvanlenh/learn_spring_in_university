<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>


<div class="container">
	<div class="upload-parent">
		<spring:url value="/uploads" var="action" />
		<form:form method="post" action="${action }"
			enctype="multipart/form-data">
			<label>Upload Multi File</label>
			<br />
			<input type="file" name="files" multiple="multiple" />
			<br />
			<input type="submit" value="Upload" />
		</form:form>
	</div>
</div>
