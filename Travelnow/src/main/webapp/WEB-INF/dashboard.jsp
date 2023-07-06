—<%@ page language="java" contentType="text/html; charset=UTF-8"
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
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">


</head>
</head>
<body>



 <h1 class="text-center text-primary-emphasis "> Save Travels </h1>
<table class=" offset-1 mt-4 table table-hover">
  <thead>
    <tr>
      <th scope="col">Expense</th>
      <th scope="col">Vendor</th>
      <th scope="col">Amount</th>
      <th scope="col">Description</th>
       <th scope="col">Actions</th>
      
      
    </tr>
  </thead>
  <tbody  class= "table-group-divider ">
  
   <c:forEach var="save" items="${allSaveTravel}"> 
        <tr>
             <th ><a href="/travel/${save.id}"> ${save.expenseName}</a> </th> 
            <th ><c:out value="${save.vendor}" ></c:out></th> 
           <th ><c:out value="${save.amount}"></c:out></th> 
            <th ><c:out value="${save.description}"></c:out></th>  
             <th ><a href="/travel/edit/${save.id}">edit</a> |<a href="/travel/delete/${save.id}">Delete</a>
             
            
    </tr>
    <tr>
    </c:forEach>
  </tbody>
</table>

<form:form action="/travel/create" method="POST" modelAttribute="newSaveTravels">
<div class= "offset-1 ps-5">
  <div class="form-group ">
  <form:errors path="expenseName"></form:errors>
   <p> <form:label path="expenseName">Expense Name:</form:label></p>
    <form:input type="text" class="form-control"  path ="expenseName"/>
  </div>
  <div class="form-group mt-2">
    <form:errors path="vendor"></form:errors>
  
    <p><form:label path ="vendor">Vendor:</form:label></p>
    <form:input  path="vendor" class="form-control" />
  </div>
  <div class="form-group mt-2">
    <form:errors path="amount"></form:errors>
  
   <p> <form:label path= "amount">Amount:</form:label></p>
    <form:input type="number" class="form-control"  path ="amount"/>
  </div>
  <div class="form-group mt-2 ">
    <form:errors path="description"></form:errors>
  
   <p> <form:label path="description">Description:</form:label></p>
    <form:input  class="form-control"  path ="description"/>
  </div>
  <button type="submit" class="btn btn-primary">Submit</button>
  
  </div>
</form:form>

</body>
</html>