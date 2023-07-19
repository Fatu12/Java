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
<!-- For any Bootstrap that uses JS -->
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">

</head>
<body>
	<h1 class="text-center text-primary-emphasis "> Create a Project </h1>

		<form:form action="/projects/create" method="POST" modelAttribute="newProjects">
		<input type="hidden" name="user" value="${user.id}" />
		 <div class= "offset-1 ps-5">
		  <div class="form-group ">
		  <form:errors path="title"></form:errors>
		   <p> <form:label path="title">Title:</form:label></p>
		    <form:input type="text" class="form-control"  path ="title"/>
		  </div>
		  
		  <div class="form-group mt-2 ">
		    <form:errors path="description"></form:errors>
		  
		   <p> <form:label path="description">Project Description:</form:label></p>
		    <form:textarea name="" cols="50" rows="4"   class="form-control"  path ="description"/>
		  </div>
		   <div class="form-group mt-2">
		    <form:errors path="duaDate"></form:errors>
		  
		    <p><form:label path ="duaDate">Dua Date:</form:label></p>
		    <form:input  type="date" path="duaDate" class="form-control" />
		  </div> 
		  <button type="submit" class="btn btn-primary">Submit</button>
		  
		  </div>
		</form:form>
		</body>
		</html>