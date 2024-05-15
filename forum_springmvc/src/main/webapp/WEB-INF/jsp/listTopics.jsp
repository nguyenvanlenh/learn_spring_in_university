<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Danh sách diễn đàn</title>
<jsp:include page="./includes/bootstrap.jsp" />

</head>
<body>

<div class= "container  mt-4 pb-4">
<header>
 <jsp:include page="./includes/navbar.jsp" />
</header>


<a href='<c:url value="/new-topic"/>' class="btn btn-primary mt-3 mb-3" >Gửi bài mới</a>

<table class="table table-striped">
  <thead>
    <tr>
      <th scope="col">Chủ đề</th>
      <th scope="col" class="text-center">Hồi âm</th>
    </tr>
  </thead>
  <tbody>
  <c:forEach items="${topics}" var="item">
    <tr>
      <td>
      <div> <a href='<c:url value="/details/${item.id}"/>'>${item.title}</a>  </div>
      <div>Bài viết mới nhất by ${item.creator.username},
      <fmt:formatDate value="${item.creator.joinDate}" pattern="MM-dd-yyyy h:mm a"/></div>
      </td>
      <td class="text-center">${item.messages.size() }</td>
    </tr>
    </c:forEach>
  </tbody>
</table>
</div>

</body>
</html>