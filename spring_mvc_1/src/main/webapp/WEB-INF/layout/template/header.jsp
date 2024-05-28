<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<div style="background: linear-gradient(to right, #093637, #44a08d)">

 <div class="container">
		<div class="row pt-2 text-light">
            <div class="col-md-7">
                <div class="user-menu">
                    <ul>
                        <c:choose>
                            <c:when test="${pageContext.request.userPrincipal.name == null}">
                               <li>
                                    <a href="<spring:url value="/register" />">
                                        <i class="fa fa-check"></i> 
                                        <spring:message code="message.register" />
                                    </a>
                                </li>
                                <li>
                                    <a href="<spring:url value="/login" />">
                                        <i class="fa fa-user"></i> 
                                        <spring:message code="message.login" />
                                    </a>
                                </li> 
                            </c:when>
                            <c:when test="${pageContext.request.userPrincipal.name != null}">
                                <li>
                                    <a href="#"><i class="fa fa-user"></i>
                                        <spring:message code="message.welcome" /> 
                                        ${pageContext.request.userPrincipal.name}
                                    </a>
                                </li>
                                <li>
                                    <a href="<spring:url value="/logout" />">
                                        <i class="fa fa-sign-out"></i>
                                        <spring:message code="message.logout" />
                                    </a>
                                </li>
                            </c:when>
                        </c:choose>
                    </ul>
                </div>
            </div>
            <div class="col-md-5">
                <form action="<spring:url value="/" />">
                    <div class="row align-items-center">
                        <div class="col-md-12 form-group">
                            <input name="kw" value="${kw}" class="form-control" 
                                   placeholder="Nhập từ khoá tìm kiếm..." />
                        </div>
                    </div>
                </form>
            </div>
        </div>
	</div>
</div>
