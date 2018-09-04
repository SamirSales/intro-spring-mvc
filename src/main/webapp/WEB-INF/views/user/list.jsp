<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Users</title>
	<spring:url var="css" value="/static/css/bootstrap.css" />
	<link type="text/css" rel="stylesheet" href="${css}" />
</head>
<body>
<div class="container">
	<h1>List of users</h1>
	<hr>
	<div>
		<spring:url value="/user/register" var="register"></spring:url>
		<a class="btn btn-default" href="${register}">New User</a>
	</div>
	<hr>
	
	<div class="${message == null ? 'panel-default' : 'panel-success'}">
		<div class="panel-heading">
			<span>${message == null ? '&nbsp;' : message}</span>
		</div>
		
		<table class="table table-striped table-condensed">
		<thead>
			<tr>
				<th>ID</th>
				<th>NAME</th>
				<th>DATE OF BIRTH</th>
				<th>GENDER</th>
				<th>ACTION</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="user" items="${users}">
				<tr>
					<td>${user.id}</td>
					<td>${user.firstName}&nbsp;${user.lastName}</td>
					<td>
						<f:parseDate var="date" value="${user.dtBirth}" pattern="yyyy-MM-dd" type="date" />
						<f:formatDate value="${date}" pattern="dd/MM/yyyy" type="date" />
					</td>
					<td>${user.gender.value}</td>
					
					<td>
						<spring:url value="/user/update/${user.id}" var="update"></spring:url>
						<a class="btn btn-info" href="${update}">Update</a> 
						
						<spring:url value="/user/delete/${user.id}" var="delete"></spring:url>
						<a class="btn btn-danger" href="${delete}">Delete</a>
					</td>					
				</tr>
			</c:forEach>
		</tbody>
	</table>
	</div>
	<hr>
</div>

	

</body>
</html>