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


<h1 class="offset-4 mt-4"> WEL COME ${currentUser.firstName}! </h1>
  <h6 class="offset-4 mt-4"><a  href="/users/logout">Log out</a> </h6>

<h4 class="text-center"> Current Games </h4>
<h1 class="offset-1 mt-4"> Game </h1>

<hr> 
<div>
		<c:forEach  var ="game" items="${allGames}" >
      		
      		<h5 class="offset-1"> <a href="/mechanic/${game.id}"> <c:out value="${game.name}"/></a></h4>
      		 <h4  class="offset-1">Genre: <c:out value="${game.genre}"/></t4>
      		     		   
      		     		    
      		 
<%--      		<h4 class="offset-1"><c:out value="${game.description}"/></h4>
 --%>  		     		
     		   </c:forEach>
    		  </div>
    		
    		 <a class="offset-4 mt-5" href="/games/new">Create New Game </a>
    		 
${oderBYName.id}
</body>

</html>