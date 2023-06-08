<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!-- c:out ; c:forEach etc. -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- Formatting (dates) -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registro</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="/css/main.css">
<!-- change to match your file/naming structure -->
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/js/app.js"></script>
<!-- change to match your file/naming structure -->
</head>
<body>
<div class="container mt-3">
		<div class="row">
			<div class="col-4 offset-1 ">

				<h2>Register!</h2>
				<div>
					<form:errors path="user.*" class="text-danger" />
				</div>
				<form:form method="POST" action="/register"
					modelAttribute="employee">
					<div>
						<form:label path="userName">First Name:</form:label>
						<form:input class="form-control" type="text" path="userName" />
					</div>
					<div>
						<form:label path="userLastName">Last Name:</form:label>
						<form:input class="form-control" type="text" path="userLastName" />
					</div>
					
					<div>
						<form:label path="gerente">Gerente :</form:label>
						<form:select class="form-control" path="gerente">
						<c:forEach items="${employees}" var="gerente">
							<form:option value="${gerente.id} "> ${gerente.userName}  
										</form:option>
						</c:forEach>
					</form:select>
					</div>
					
					
					<button type="submit" class="btn btn-success mt-4">Register!!</button>
				</form:form>
				<p class="text-danger mt-2"><c:out value="${succesRegister}" /></p>
			</div>
			

		</div>
	</div>


</body>
</html>