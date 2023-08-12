 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
	  <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
	 
<%@ page isErrorPage="true" %>
	  
	  
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
<body>

<div class="offset-2 mt-4">


      <a href="/users/home">go back to dashboard </a>

 
<h3><class="text-danger">Title: ${thisCommuunity.title}</h3>
 <h3><class="text-danger">Description: ${thisCommuunity.discription}</h3>
 <h3><class="text-danger">Date: ${thisCommuunity.date}</h3>
 <h3><class="text-danger">Address: ${thisCommuunity.address}</h3>
 



 <c:if test = "${thisCommuunity.creator.id eq userID}">
<a  href="/community/edit/${thisCommuunity.id}"> edit </a>|<a  href="/community/delete/${thisCommuunity.id}">delete</a>
       
</c:if>
  <h3 class="text-info offset-1">Add Seggustion:</h3> 
<form:form action="/commant/create/${thisCommuunity.id}" method="POST" modelAttribute="newComment">
   <div class= "offset-1 ps-5">
  <div class="form-group ">
  <form:errors path="commant"></form:errors>
   <p> <form:label path="commant">Leave Seggustion for upcoming event:</form:label></p>
    <form:input type="text" class="form-control"  path ="commant"/>
    <button type="submit" class="btn btn-primary">Submit</button>
  </div>
</form:form> 

<div>
 <h3 class="text-info"> Seggution </h3>
<c:forEach var="community" items="${thisCommuunity.commantyCommant}">
 
<ul>
 <li>${community.commantyCommant.title} 
 
  <li>${community.commant}
  <a  href="/commant/delete/${community.id}">delete</a>
  </li>
  
</ul>

  </c:forEach>
  
  </div>

  




