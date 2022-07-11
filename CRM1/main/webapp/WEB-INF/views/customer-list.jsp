<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<style>
h1 {text-align: center;}
div {text-align: center;}

th, td {
  background-color: #96D4D4;
}
th, td {
  padding: 15px;
}
th, td {
  padding-top: 10px;
  padding-bottom: 20px;
  padding-left: 30px;
  padding-right: 40px;
}

</style>
<meta charset="UTF-8">
<title>Customer Relationship Management - customers</title>
</head>
<body>

<h1 style="background-color:powderblue;">CUSTOMER RELATIONSHIP MANAGEMENT</h1>
<div>
<!--  <a href="addNewCustomer">Add Customer</a>-->
<input type="button" value="Add Customer"
	onClick="window.location.href='addNewCustomer'; return false;"
	class="add-button" />
</div>
<br>
<br>

<table style="border:1px solid black;margin-left:auto;margin-right:auto;">
<thead>
	<tr>
		<th>First Name</th>
		<th>Last Name</th>
		<th>Email</th>
		<th>Action</th>
	</tr>
</thead>
<c:forEach items="${customers}" var="customerObj">


	<c:url var="updateLink" value="/customer/updateCustomer">
		<c:param name="id" value="${customerObj.id}" />
	</c:url>
	
	<c:url var="deleteLink" value="/customer/deleteCustomer">
		<c:param name="id" value="${customerObj.id}" />
	</c:url>

	<tr>
		<td>${customerObj.firstname}</td>
		<td>${customerObj.lastname}</td>
		<td>${customerObj.email}</td>
		<td>
			<!-- Display Update Link -->
			<a href="${updateLink}">Update</a>
			<a href="${deleteLink}"
			onclick="if (!(confirm('Are you sure you want to delete this customer?'))) return false">Delete</a>
		</td>
	</tr>
</c:forEach>
</table>
</body>
</html>