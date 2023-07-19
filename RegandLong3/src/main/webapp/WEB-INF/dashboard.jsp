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

<div class="text-center">

<h1 class=" mt-4"> WEL COME ${currentUser.firstName} </h1>

<c:out value=""></c:out>
<h3> First Name : ${currentUser.firstName}</h3>
<h3>Last Name: ${currentUser.lastName}</h3>
<h3>Email: ${currentUser.email}</h3>
<a href="/projects/new">+ Add Project</a>

<a href="/users/logout">Log out</a>
</div>




<table class="offset-4">
<h3 class="text-center">All Projects </h3>

  <thead>
  
    <tr class="bg-warning border-2 ">
      <th scope="col">Project</th>
      <th scope="col"> Team Lead</th>
      <th scope="col"> Due Date</th>
       <th scope="col">Actions</th> 
    </tr>
  </thead>
  <c:forEach var ="project" items="${allProjects}">
  		<tr>
  		<td> <c:out value="${project.title}"></c:out> </td>
  		<td> <c:out value="${project.creator.firstName}"></c:out> </td>
  		<td> <c:out value="${project.duaDate}"></c:out> </td>
  		  <td> <a href="/projects/join/${project.id}">Join Team</a> </td>
  		
  		
  		</c:forEach>
  		
  		</table>
  		
   		
   		${creator.firstName }
   		
  		<table class="offset-4">
<h3 class="text-center"> My Project </h3>

  <thead>
  
    <tr class="bg-warning border-2 ">
      <th scope="col">Project</th>
      <th scope="col"> Team Lead</th>
      <th scope="col"> Due Date</th>
       <th scope="col">Actions</th> 
    </tr>
  </thead>
  <c:forEach var ="project" items="${allProjects}">
  		<tr>
  		<td> <c:out value="${project.title}"></c:out> </td>
  		<td> <c:out value="${project.creator.firstName}"></c:out> </td>
  		<td> <c:out value="${project.duaDate}"></c:out> </td>
  		<c:if test="${project.creator.id eq userID}">
  		<td> <a href="/projects/edit/${project.id}">edit</a> | <a href="/projects/delete/${project.id}">delete</a></td>
  		</c:if>
  		
  		<%-- <c:choose> --%>
  		 <%--  <c:when test="${project.creator.id.contains(currentUser)}">
  		  		<td><a href="/projects/unjoin/${project.id}">Leave Team</a></td>
  		</c:when> 
  		<c:otherwise>
  		<td><a href="/projects/join/${project.id}">Join Team</a></td>
  		
  		</c:otherwise>
  		</c:choose>   --%>
  		
  		</c:forEach> 
  		
  		</table>
  		
  		
  		
  		
</body>

</html>