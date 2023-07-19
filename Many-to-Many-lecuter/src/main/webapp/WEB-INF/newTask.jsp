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
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">

</head>

<body>


<p class="text-center"> We have tasks for ${thisProject.title }</p>
<a href="/users/home"> back to home</a>
<form:form action="/tasks/create/${thisProject.id}" method="POST" modelAttribute="newTask">
<input type="hidden" name="user" value="${user.id}" />
 <div class= "offset-1 ps-5">
  <div class="form-group ">
  <form:errors path="taskTicket"></form:errors>
   <p> <form:label path="taskTicket">Task:</form:label></p>
    <form:input type="text" class="form-control"  path ="taskTicket"/>
  </div>
  
  <button type="submit" class="btn btn-primary">Submit</button>
  
  </div>
</form:form>
  <c:forEach var="task" items="${thisProject.projectTask}">
	<h4 class="text-center">  Added by ${task.creater.firstName} on ${task.createdAt}</h4>
	 <p class="text-center"> ${task.taskTicket}</p>
  
  
  </c:forEach>
</body>

</html>