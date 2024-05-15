<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <c:if test="${not empty sessionScope.user}">
<nav class="navbar navbar-light bg-light d-flex justify-content-end align-items-center">
  
 <div>
            <span> Chào ${sessionScope.user.username}</span><strong>|<a 
            href ='<c:url value="logout"/>'>Thoát</a></strong>
  </div>
</nav>
  </c:if>