<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Users</title>
</head>
<body>
<div class="container">
	<h1>List of users</h1>
	<hr>
	<div>
		<a class="btn btn-default" href="#">New User</a>
	</div>
	<hr>
	
	<div class="panel-default">
		<div class="panel-heading">
			<span>${message == null ? '&nbsp;' : message}</span>
		</div>
		
		<table class="table table-striped table-condensed">
		<thead>
			<tr>
				<th>ID</th>
				<th>NAME</th>
				<th>ACTION</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="user" items="${users}">
				<tr>
					<td>${user.id}</td>
					<td>${user.firstName}&nbsp;${user.lastName}</td>
					<td>
						<a class="btn btn-info" href="#">Update</a> 
						<a class="btn btn-danger" href="#">Delete</a>
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