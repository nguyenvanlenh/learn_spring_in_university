<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Thêm chủ đề</title>
<jsp:include page="./includes/bootstrap.jsp" />
</head>
<body>
	<div class="container  mt-4 pb-4">
		<header>
			<jsp:include page="./includes/navbar.jsp" />
		</header>
		<form>
		<h3 class="text-center">Thêm chủ đề</h3>
			<div class="form-group">
				<label for="name">Tiêu đề</label> <input type="text"
					class="form-control" id="name">
			</div>
			<div class="form-group ">
				<label for="name">Nội dung</label>
				<textarea class="form-control" aria-label="With textarea"></textarea>
			</div>
			<div class="mt-2 mb-2 d-flex ">
				<button type="submit" class="btn btn-primary w-50 m-3">Gửi</button>
				<button type="submit" class="btn btn-secondary w-50 m-3">Hủy</button>
			</div>
		</form>
	</div>

</body>
</html>