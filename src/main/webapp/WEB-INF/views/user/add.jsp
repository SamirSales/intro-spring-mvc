<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User's Registration</title>
</head>
<body>
	<div class="container">
		<h1>User's Registration</h1>
		<hr>
		<div>
		<spring:url value="/user/all" var="home"></spring:url>
			<a class="btn btn-default" href="${home}">Home</a>
		</div>
		<hr>

		<div class="panel-default">
			<spring:url value="${user.id == null ? '/user/save' : '/user/update'}" var="save" />
			<form:form modelAttribute="user" action="${save}" method="post">
				<form:hidden path="id"/>
				<div class="form-group">
					<label for="firstName">First name: </label>
					<form:input path="firstName" class="form-control" />
				</div>
				<div class="form-group">
					<label for="lastName">Last name: </label>
					<form:input path="lastName" class="form-control" />
				</div>
				<div class="form-group">
					<label for="lastName">Gender: </label>
					<form:select path="gender" class="form-control">
						<form:options items="${genders }" itemLabel="value"/>
					</form:select>
				</div>
				<div class="form-group">
					<label for="lastName">Birth date: </label>
					<form:input path="dtBirth" class="form-control" type="date"/>
				</div>
				<div class="form-group">
					<button type="submit" class="btn btn-primary">Submit</button>
				</div>
			</form:form>
		</div>
		<hr>
	</div>

</body>
</html>