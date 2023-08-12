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
  <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
</head>
<body>

<div class="offset-2 mt-4">



 <h3><class="text-danger">${thisGame.name}</h3>

      <a href="/users/home">dashboard</a>

<h3><class="text-danger">Name: ${thisGame.name}</h3>
<h3><class="text-danger">Deploper: ${thisGame.genre}</h3>
<h3><class="text-danger">Description: ${thisGame.description}</h3>

<c:if test = "${thisGame.creator.id eq userID}">
 <p><a  href="/games/edit/${thisGame.id}"> edit </a></p>
<p><a  href="/games/delete/${thisGame.id}">delete</a></p>
   </c:if>
   
    <h3 class="text-info offset-1">Add Game Mechanic:</h3>
   
<form:form action="/mechanic/create/${thisGame.id}" method="POST" modelAttribute="newGameMechanic">
  
   <div class= "offset-1 ps-5">
  <div class="form-group ">
  <form:errors path="mechanicName"></form:errors>
   <p> <form:label path="mechanicName">Game Mechanic:</form:label></p>
    <form:input type="text" class="form-control"  path ="mechanicName"/>
    <button type="submit" class="btn btn-primary">Submit</button>
  </div>
</form:form> 


 
 <div>
 <h3 class="text-info">Seggested Game Mechanics</h3>
<c:forEach var="game" items="${thisGame.allGameMechanic}">
 
 

<ul>
 <li>${game.gameMechanic.name} 
 
  <li>${game.mechanicName}
  <a  href="/games/delete/${game.id}">delete</a>
  </li>
  
</ul>

  </c:forEach>
  
  </div>






</body>
</html>


</body>
</html>