<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>



	<div class="container">
		<div class="login-parent">
			<h1>Thêm người dùng</h1>
			<h5>${errMg}</h5>
			<spring:url value="/register" var="action"></spring:url>
			<form:form method="Post" action="${action }" modelAttribute="user">
				<lable>Username</lable>
				<input type="text" name="username" />
				<br />
				<lable>Password</lable>
				<input type="password" name="password" />
				<br />
				<lable>Confirm Password</lable>
				<input type="password" name="confirmPassword" />
				<br />
				<lable>Fullname</lable>
				<input type="text" name="fullName" />
				<br />
				<input type="submit" value="Register">
			</form:form>
		</div>
	</div>
