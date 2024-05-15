<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Đăng nhập</title>
<jsp:include page="./includes/bootstrap.jsp" />

<style>
.form-login {
	max-width: 350px
}
</style>
</head>
<body>

	<div class="container d-flex justify-content-center">
		<c:if test="${not empty error}">
			<div class="alert alert-danger" role="alert">${error}</div>
		</c:if>
		
		<form method="post" action="login" class="m-5 card p-3 form-login">
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