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



 <h3><class="text-danger">${thisHouseHuter.address}</h3>

      <a href="/users/home">go back to home </a>

<h3><class="text-danger">Address: ${thisHouseHuter.address}</h3>
<h3><class="text-danger">Listing: ${thisHouseHuter.createdAt}</h3>

<h3><class="text-danger">Price: ${thisHouseHuter.price}</h3>

 <c:if test = "${thisHouseHuter.creatore.id eq userID}">
<a  href="/houses/edit/${thisHouseHuter.id}"> edit </a>|<a  href="/houses/delete/${showHouseHounter.id}">delete</a>
       
</c:if>

   
<!--  </div> -->
  <form:form action="/notes/create/${thisHouseHuter.id} " method="POST" modelAttribute="newNote">
  
  

 <div class= "offset-1 ps-5">
  <div class="form-group ">
  <form:errors path="hNote"></form:errors>
   <p> <form:label path="hNote">Note:</form:label></p>
    <form:input type="text" class="form-control"  path ="hNote"/>
  </div>
  
  <button type="submit" class="btn btn-primary offset-2">Submit</button>
  
  </div>
</form:form> 



  <c:forEach var="note" items="${thisHouseHuter.houseHNotes}">
  
  
<%--   <h3> Added by  on ${note.creatore.firstName}</h3>
 --%>  
  
<h3> Added by  on ${note.hNote}</h3>
<h3> ${note.userNote.firstName}</h3>
  </c:forEach>

</body>
</html>


<%-- <%@ page language="java" contentType="text/html; charset=UTF-8"
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
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">


<!-- For any Bootstrap that uses JS -->
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<h1 class="text-center text-primary-emphasis ">We have tasks for ${thisHouseHuter.address} </h1>

	<p class="text-center"><a href="/users/home">Home</a></p>	
<form:form action="/tasks/create/${thisHouseHuter.id} " method="POST" modelAttribute="newNote">

 <div class= "offset-1 ps-5">
  <div class="form-group ">
  <form:errors path="taskTicket"></form:errors>
   <p> <form:label path="taskTicket">Ticket:</form:label></p>
    <form:input type="text" class="form-control"  path ="taskTicket"/>
  </div>
  
  <button type="submit" class="btn btn-primary">Submit</button>
  
  </div>
</form:form>

<c:forEach var="task" items="${thisProject.projectTask}">
<h3> Added by  on ${task.createdAt}</h3>
<p> ${task.taskTicket }</p>




 --%>
 
 

</body>
</html>