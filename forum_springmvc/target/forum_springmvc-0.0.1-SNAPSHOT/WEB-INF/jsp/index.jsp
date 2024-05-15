<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Đăng nhập</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ"
	crossorigin="anonymous">

<!-- Bootstrap JavaScript -->
<script
	src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"
	integrity="sha384-oBqDVmMxFTKwzxwjkO+rz/8mB/4E4Jj59Tz0mzYzpsTnDQDxEJ2kGbpCLWg1I593"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.min.js"
	integrity="sha384-cn7l7gDp0eyniUwwAZgrzD06kc/tftFf19TOAs2zVinnD/C7E91j9yyk5//jjpt/"
	crossorigin="anonymous"></script>

<style>
.form-login {
	max-width: 350px
}
</style>
</head>
<body>

	<div class="container d-flex justify-content-center">
		<%-- <c:if test="${not empty error}">
			<div class="alert alert-danger" role="alert">${error}</div>
		</c:if> --%>
		<form method="post" action="/login" class="m-5 card p-3 form-login">
			<h3 class="text-center">Đăng nhập</h3>
			<div class="row">
				<div class="mb-3 col-md-12">
					<label for="username" class="form-label">Tên đăng nhập</label> <input
						id="username" type="text" class="form-control" name="username"
						required>
				</div>

				<div class="mb-3 col-md-12">
					<label for="password" class="form-label">Mật khẩu</label> <input
						id="password" type="password" class="form-control" name="password"
						required>
				</div>
			</div>
			<div class="d-grid gap-2 d-md-block col-md-12">
				<button type="submit" class="btn btn-primary w-100">Đăng
					nhập</button>
			</div>

		</form>
	</div>

</body>
</html>