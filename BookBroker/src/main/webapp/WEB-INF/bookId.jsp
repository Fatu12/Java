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

      <a href="/users">go back to home </a>


<h3>Kafka on the Shore</h3>
h5>A place for friends ti shae thoughts on boooks</h5>
<a href="users/book">back to the shelve</a>
<h3><span class="text-danger">${showBook.firstName}</span>
 read <span class="text-warning-emphasis"> ${showBook.title}</span>  by<span class="text-primary">${showBook.author}</span></h3>
 
 
 <c:if test = "${showBook.userTable eq userID}">
	<p><c:out value="You read ${showBook.author} and Here are you thoughts!"/></p>
	
       
</c:if>
   
 <h3 class="mt-3"> Here are ${showBook.firstName}'s thoughs </h3>
 
 <hr>
  <h3> ${showBook.comment} </h3>

  <c:if test = "${showBook.id eq userID}">
	<p><c:out value="You got it good !"/></p>
	<div class="d-flex">
	<a  href="/users/${showBook.id}/edit"> edit </a>
       
       <a class="offset-1" href="/users/${showBook.id}/delete"> delete </a>
       </div>
       
</c:if>
   
  </div>

</body>
</html>