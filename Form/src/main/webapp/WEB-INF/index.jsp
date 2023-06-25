<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- YOUR own local CSS -->
<link rel="stylesheet" href="/css/main.css"/>
<!-- For any Bootstrap that uses JS -->
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>

 <h3>Login</h3>
    <form action='/login' method='POST'>
	<label>Email:</label>
    	<input type="text" name='email'>
	<label>Password:</label>
    	<input type='text' name='password'>
    	<input type='submit' value='login'>
    </form>

 

</body>
</html>