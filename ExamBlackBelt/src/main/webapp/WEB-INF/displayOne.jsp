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



 <h3><class="text-danger">${thisTeams.name}</h3>

      <a href="/users/home">dashboard</a>

<h3><class="text-danger">Team name: ${thisTeams.name}</h3>
<h3><class="text-danger">Skil Level: ${thisTeams.skillLevel}</h3>




<h3><class="text-danger">Game Day: <fmt:formatDate value="${thisTeams.gameDay}" pattern="EEE" /> </h3>

  <c:if test = "${thisTeams.creatore.id eq userID}">
<a  href="/teams/edit/${thisTeams.id}"> edit </a>|<a  href="/teams/delete/${thisTeams.id}">delete</a>
       
</c:if>
   
<!--  </div> -->
  <form:form action="/players/create/${thisTeams.id} " method="POST" modelAttribute="newPlayer">
  
  <h1>Players</h1>
  <c:forEach var="player" items="${thisTeams.allTeamPlayers}">
  <ul>
  <li>${player.playerName}</li>
  
</ul>
</form:form> 
<%--    <option value="${player.playerName}"> ${player.playerName} </option>
 --%>
  </c:forEach>

 <div class= "offset-1 ps-5">
  <div class="form-group ">
<%--   <p><c:out value="${error}"/></p>
 --%>  <form:errors path="playerName"></form:errors>
   <p> <form:label path="playerName">Add Player:</form:label></p>
    <form:input type="text" class="form-control"  path ="playerName"/>
  </div>
  
  <button type="submit" class="btn btn-primary">Submit</button>
  
  </div>



</body>
</html>


</body>
</html>