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
  <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
</head>
<body>
 <div class="offset-4 ">
<h1 class="offset-2 mt-4"> WEL COME  ${currentUser.firstName}! </h1>

<c:out value=""></c:out>
<h3> First Name : ${currentUser.firstName}</h3>
<h3>Last Name: ${currentUser.lastName}</h3>
<h3>Email: ${currentUser.email}</h3>
<a href="/users/logout">Log out</a>



<%-- <c:if test = "${allTeams.count(allTeams.id) >= 9 }">
<h> The Team is full </h>       
</c:if>
    --%>

</div>

<table class="offset-3"> 
  <thead>
  
    <tr class="bg-warning border-2 ">
      <th scope="col">Team Name</th>
      <th scope="col"> Skill Level(1-5) </th>
      <th scope="col">Players</th>
       <th scope="col">Game Day</th> 
    </tr>
  </thead>
  <tbody>
 <!--  this is all the project that your not part of it , so just it going to display only join part  -->
      <c:forEach  var ="team" items="${allTeams}">
      		<tr>
      		
      		<td class="table-primary border-3  text-danger"> <a href="/players/${team.id}"> <c:out value="${team.name}"/></a></td>
      		 <td class="table-secondary border-3 text-success "><c:out value="${team.skillLevel}"/></td>
     		<td class="table-secondary border-3 text-success "><c:out value="${team.allTeamPlayers.size()}"/>/9</td>
  		
     		 <td class="table-secondary border-3 text-success"><fmt:formatDate value="${team.gameDay}" pattern="EEE" /></td>
     		
     		   		 </c:forEach>
    		 
    		 </tbody>
    		 </table>
    		 
    		 <a class="offset-4 mt-5" href="/teams/new">Create New Team</a>
    		 
    		
    		 
    		 
    		 
</body>

</html>