<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h1>Request Params</h1>
	<h2>Tên của bạn là: ${ fisrtName }</h2>
	<c:if test="${ lastName == null}">
	<h2>Bạn chưa có họ</h2>
	</c:if>
	<c:if test="${ lastName != null}">
	<h2>Họ của bạn là: ${ lastName}</h2>
	</c:if>

</body>
</html>