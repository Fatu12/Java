<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
	  <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %> 
	    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- YOUR own local CSS -->
<link rel="stylesheet" href="/CSS/sytle.css"/>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">


<!-- For any Bootstrap that uses JS -->
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<h1 class="text-center text-primary-emphasis ">New Dorm</h1>

<p class="offset-2"><a href="/users/home">Dashboard</a>
</p>
<form:form action="/dorms/create" method="POST" modelAttribute="newDorm">

 <div class= "offset-1 ps-5">
  <div class="form-group ">
  <form:errors path="dormName"></form:errors>
   <p> <form:label path="dormName">Dorm Name:</form:label></p>
    <form:input type="text" class="form-control"  path ="dormName"/>
  
  <button type="submit" class="btn btn-primary">Add</button>
  
  </div>
</form:form>
</body>
</html>