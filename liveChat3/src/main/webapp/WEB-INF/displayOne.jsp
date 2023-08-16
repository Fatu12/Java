 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
    
	  <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
	    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
	  
	 
<%@ page isErrorPage="true" %>
	  
	  
<%@ page isErrorPage="true" %> 
	    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<link rel="stylesheet" href="/css/sytle.css"/>

<!-- YOUR own local CSS -->
<!-- <link rel="stylesheet" href="/css/main.css"/>
 --><!-- For any Bootstrap that uses JS -->
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">

</head>
<body class="body">

 <h3> <span class="text-primary offset-4">Hello, ${thisCommuunity.creator.firstName}</span></h3>



<div class ="d-flex p-2">

<div class="offset-2 mt-4">
 <span class="flame-text">Title: </span>
 <h5> <span class="text-primary"> ${thisCommuunity.title}</span></h5>
 
  <span class="flame-text">Hosted By:</span>
  <h5><span class="text-primary">${thisCommuunity.creator.firstName}</span></h5>
  
  <span class="flame-text">Date:</span>

 <h5> <span class="text-primary"><fmt:formatDate value="${thisCommuunity.date}" pattern="EEE-MMM-dd-yyyy" /></span></h1>
   <span class="flame-text">Address:</span>
 
 <h5><span class="text-primary">${thisCommuunity.address}</span> </h5>
   <span class="flame-text">Contant:</span>
 
  <h5><span class="text-primary">${thisCommuunity.contatctInfo}</span></h5>
    <span class="flame-text">Description:</span>
  
 <h5><span class="text-primary"> ${thisCommuunity.discription}</span></h5>
 
</div>




<div class=" offset-2 comment">
<div class="offset-2">
 <c:if test = "${thisCommuunity.creator.id eq userID}">
<a href="/community/edit/${thisCommuunity.id}"> <button class="btn btn-danger">edit</button></a>
<a href="/community/delete/${thisCommuunity.id}"> <button class="btn btn-danger">delet</button></a>      
</c:if>
<a href="/users/home"> <button class="btn btn-danger">go back to dashboard</button></a>      

</div>
 

<form:form action="/commant/create/${thisCommuunity.id}" method="POST" modelAttribute="newComment">
   <div class= "offset-1 ps-5">
  <div class="form-group text-primary ">
  <form:errors path="commant"></form:errors>
   <p> <form:label path="commant">Leave Seggustion for upcoming event:</form:label></p>
       <form:textarea cols="50" rows="4"  class="form-control"   placeholder="Type here"  path ="commant"/>
   
    <button type="submit" class="btn btn-primary mt-2 offset-4">Submit</button>
  </div>
</form:form> 

<<%-- c:forEach var="community" items="${thisCommuunity.commantyCommant}">
<h3 class="text-info"> Seggution </h3>
 
<ul class="text-danger">
 <li>${community.commantyCommant.title} 
  
  <li>
<a href="/commant/delete/${community.id}"> <button class="btn btn-danger">delete</button></a>
  </li>
  
</ul>
  </c:forEach>  --%>
  <div>
 <h3 class="text-info"> Seggution </h3>
<c:forEach var="community" items="${thisCommuunity.commantyCommant}">
 
<ul class="text-danger">
 <li>${community.commantyCommant.title} 
 
<%--  <li>${community.creator.firstName}
 --%>   </li>
 
  <li>${community.commant}
   <a  href="/commant/delete/${community.id}/${thisCommuunity.id}">delete</a>
   </a>
  </li>
  
</ul>

  </c:forEach>



<div>
 
  </div>
   
  </div>
  
  
  </div>

   
   
   
   
   
     