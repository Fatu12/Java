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
<body class="body">
	<h1 class="text-center text-primary-emphasis textColor mt-4">Add Any Information </h1>
<form:form action="/community/create" method="POST" modelAttribute="newNCommunity" class="createForm">
<input type="hidden" name="user" value="${user.id}" />
 <div class= "offset-1 ps-5">
  <div class="form-group ">
  <form:errors path="title" class="text-white"></form:errors>
   <p> <form:label path="title" class="text-white offset-4">Title*</form:label></p>
    <form:input type="text" placeholder="Type here" class="form-control"  path ="title"/>
  </div>
   <div class="offset-1 ps-5 ">
   <form:errors path="address"  class="text-white"></form:errors>
   <p> <form:label path="address" class="text-white offset-4">Address*</form:label></p>
    <form:input  class="form-control" placeholder="Type here"  path ="address"/>
  </div>
  <div class="form-group mt-2">
    <form:errors path="date" class="text-white"></form:errors>
  
    <p><form:label path ="date" class="text-white offset-2 offset-4">Date*</form:label></p>
    <form:input  type ="date" path="date" class="form-control" />
  </div>
  <div class="form-group mt-2 ">
    <form:errors path="discription"  class="text-white"></form:errors>
  
   <p> <form:label path="discription" class="text-white offset-4">Description*</form:label></p>
    <form:textarea cols="50" rows="4"  class="form-control"   placeholder="Type here"  path ="discription"/>
  </div>
  </div>
  <div class="offset-1 ps-5 ">
    <form:errors path="contatctInfo"  class="text-white"></form:errors>
  <p> <form:label path="contatctInfo" class="text-white offset-4">Contatcts Info</form:label></p>
    <form:input  class="form-control"  placeholder="Type here"  path ="contatctInfo"/>
  </div>
  <div>
  <button type="submit" class="btn btn-primary offset-3 mt-3">Submit</button>
  </div>
</form:form>
</body>
</html>