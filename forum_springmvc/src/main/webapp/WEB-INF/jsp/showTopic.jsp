<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${topic.title }</title>
<jsp:include page="./includes/bootstrap.jsp" />
	<style>
	table{
	max-width: 100%
	}
	</style>
	
</head>
<body>
	<div class="container mt-4 pb-4">
	<header>
	 <jsp:include page="./includes/navbar.jsp" />
	</header>
		
		<h3>Chủ đề: ${topic.title }</h3>
		<c:if
			test="${not empty topic.newMessage && not empty topic.newMessage.creator}">
			<p>
				Bài viết mới nhất gửi
				<fmt:formatDate value="${topic.newMessage.creator.joinDate}"
					pattern="MM-dd-yyyy h:mm a" />
				do ${topic.newMessage.creator.username} gửi.
				${topic.messages.size()} hồi âm
			</p>
		</c:if>

		<table class="table table-bordered">
			<thead>
				<tr>
					<th scope="col" colspan="3"><fmt:formatDate value="${topic.createdTime}"
							pattern="MM-dd-yyyy h:mm a" /></th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td scope="row" rowspan="2" width="230">
						<div class="text-center">
							<strong>${topic.creator.username}</strong>
						</div>
						<div>
							Tham gia
							<fmt:formatDate value="${topic.creator.joinDate}"
								pattern="MM-dd-yyyy h:mm a" />
						</div>
					</td>
					<td><strong> ${topic.title }</strong></td>
					<td width="100"><a href='<c:url value=""/>'>Trả lời</a></td>
				</tr>
				<tr>
					<td colspan="2">${topic.content}</td>
				</tr>

			</tbody>
		</table>

		<c:forEach items="${topic.messages}" var="item">

			<table class="table table-bordered">
				<thead>
					<tr>
						<th scope="col" colspan="3"><fmt:formatDate value="${item.createdTime}"
								pattern="MM-dd-yyyy h:mm a" /></th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td scope="row" rowspan="2" width="230">
							<div class="text-center">
								<strong>${item.creator.username}</strong>
							</div>
							<div>
								Tham gia
								<fmt:formatDate value="${item.creator.joinDate}"
									pattern="MM-dd-yyyy h:mm a" />
							</div>
						</td>
						<td><strong> ${item.title }</strong></td>
						<td width="100"><a href='<c:url value=""/>'>Trả lời</a></td>
					</tr>
					<tr>
						<td colspan="2"><p>${item.content}</p> <span>${item.creator.username}</span>
						</td>
					</tr>

				</tbody>
			</table>
		</c:forEach>

	</div>

</body>
</html>