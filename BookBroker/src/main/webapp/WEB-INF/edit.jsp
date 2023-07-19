<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
	  <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %> 
	    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Book</title>
<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- YOUR own local CSS -->
<link rel="stylesheet" href="/CSS/sytle.css"/>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">


<!-- For any Bootstrap that uses JS -->
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
 <a href="/users/books"> back to te shelves </a>
	<h1 class="text-center text-primary-emphasis "> change your Entry</h1>


<form:form action="/users/books/update" method="POST" modelAttribute="bookEdit">
<input type="hidden" name="user" value="${user.id}" />
 <div class= "offset-1 ps-5">
  <div class="form-group ">
  <form:errors path="title"></form:errors>
   <p> <form:label path="title">Title:</form:label></p>
    <form:input type="text" class="form-control"  path ="title"/>
  </div>
  <div class="form-group mt-2">
    <form:errors path="author"></form:errors>
  
    <p><form:label path ="author">Author:</form:label></p>
    <form:input  path="author" class="form-control" />
  </div>
  
  <div class="form-group mt-2 ">
    <form:errors path="comment"></form:errors>
  
   <p> <form:label path="comment">My thoughts:</form:label></p>
    <form:input  class="form-control"  path ="comment"/>
  </div>
  <button type="submit" class="btn btn-primary">Submit</button>
  
  </div>
</form:form>
</body>
</html>