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
<link rel="stylesheet" href="/css/main.css"/>
<!-- For any Bootstrap that uses JS -->
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
</head>

<body>
<h1> Edit Expense</h1>
             <a href="/travel">Go back</a>


<form:form action="/travel/update/${saveTravelToEdit.id}" method="POST" modelAttribute="saveTravelToEdit">
<div class= "offset-1 ps-5">
  <div class="form-group ">
  <form:errors path="expenseName"></form:errors>
    <form:label path="expenseName">Expense Name:</form:label>
    <form:input type="text" class="form-control"  path ="expenseName"/>
  </div>
  <div class="form-group mt-2">
    <form:errors path="vendor"></form:errors>
  
    <form:label path ="vendor">Vendor:</form:label>
    <form:input  path="vendor" class="form-control" />
  </div>
  <div class="form-group mt-2">
    <form:errors path="amount"></form:errors>
  
    <form:label path= "amount">Amount:</form:label>
    <form:input type="number" class="form-control"  path ="amount"/>
  </div>
  <div class="form-group mt-2 ">
    <form:errors path="description"></form:errors>
  <div>
    <form:label path="description">Description:</form:label>
    <form:input  class="form-control"  path ="description"/>
    </div>
  </div>
  <button type="submit" class="btn btn-primary">Submit</button>
  </div>
</form:form>


</body>
</html>