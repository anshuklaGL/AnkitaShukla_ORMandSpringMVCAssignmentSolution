<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Customer Relationship Management - Customer Form</title>
</head>
<style>
 label {
        display: inline-block;
        width: 150px;
      }

 input[type="submit"] {
   transform: translate(2.2%);
   padding: 3px;
   margin-top: 0.6rem;
   font-weight: bold;
  }
</style>
<body>
	<h1 style="background-color:powderblue;">CUSTOMER RELATIONSHIP MANAGEMENT</h1>
	<br>
	<br>
	<h2>Save Customer</h2>

	<form action="save" method="post">
		<input type="hidden" name="id" value="${customerObj.id}">
		<label for="firstname">First Name:</label>
		<input type="text" name="firstname" value="${customerObj.firstname}">
		<br>
		<br>
		<label for="lastname:">Last Name:</label>
		<input type="text" name="lastname" value="${customerObj.lastname}">
		<br>
		<br>
		<label for="email">Email:</label>
		<input type="text" name="email" value="${customerObj.email}">
		<br>
		<br>
		<input type="submit" value="Save" >
	</form>
	<br>
	<div>
	<a href="list">Back to List</a>
	</div>
</body>
</html>
