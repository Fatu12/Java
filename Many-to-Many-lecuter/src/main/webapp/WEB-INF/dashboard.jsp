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


<div class="wrapper text-center">

<h1 class=" mt-4"> WEL COME ${currentUser.firstName} </h1>
<a href="/projects/new"> + add project</a>


<c:out value=""></c:out>
<h3> First Name : ${currentUser.firstName}</h3>
<h3>Last Name: ${currentUser.lastName}</h3>
<h3>Email: ${currentUser.email}</h3>

<a href="/users/logout">LogOut</a>
<a href="/projects/new">+ New Project</a>
</div>
    <!-- this is that the project that the user is not a part of it   -->
<table class="offset-4">
<h3 class="text-center">All Projects</h3>
  <thead>
  
    <tr class="bg-warning border-2 ">
      <th scope="col">Project</th>
      <th scope="col"> Team Lead</th>
      <th scope="col"> Due Date</th>
       <th scope="col">Actions</th> 
    </tr>
  </thead>
  <tbody>
  
 <!--  this is all the project that your not part of it , so just it going to display only join part  -->
      <c:forEach  var ="project" items="${allProjects}" >
      		<tr>
      		<td class="table-primary border-3  text-danger"><c:out value="${project.title}"/></td>
     		<td class="table-secondary border-3 text-success "><a href="/projects/${project.id}"><c:out value="${project.creatore.firstName}"/></a> 
    		 <td class="table-secondary border-3 text-success"> <c:out value="${project.duaDate}"/></td>	
    		 <c:if test="${project.creatore.id eq userID}" >
      		
      		          <td class="table-primary border-3  text-danger"><a href="/projects/edit/${project.id}"> edit </a> |<a href="/projects/delete/${project.id}"> delete </a> 
      		          </td>
      		 </c:if>  
    		     <th> <a href="/projects/join/${project.id}"> Join Team</a>
    		     
    		     
    		     
    		     </th>
    		 
    		 
    		 </c:forEach>
<%--                    <th> <a href="/projects/join/${project.id}">Join Team</a></th>
 --%>
   				   <!-- we on't need this since we only need to join in the toptable  -->
    
      		 <%-- <c:if test="${project.creatore.id eq userID}">
      		
      		          <td class="table-primary border-3  text-danger"><a href="/projects/edit/${project.id}"> edit </a> |<a href="/projects/delete/${project.id}"> delete </a> 
      		          </td>
      		 </c:if>  --%>
<%--       		  <c:choose >
 --%>      		 
		         <%-- <c:when test = "${project.teamMembers.contains(currentUser)}">
		                     <th> <a href="# ">Leave Team</a></th>	       
		         </c:when>  
          --%>
<%--           <c:otherwise>
 --%><%--         			<c:out value="${currentUser}"></c:out>
 --%>        
<%--          </c:otherwise>
 --%>         
<%--     </c:choose> 
 --%>    
      
      <div class="wrapper text-center">

<h1 class=" mt-4"> WEL COME ${currentUser.firstName} </h1>
<a href="/projects/new"> + add project</a>


<c:out value=""></c:out>
<h3> First Name : ${currentUser.firstName}</h3>
<h3>Last Name: ${currentUser.lastName}</h3>
<h3>Email: ${currentUser.email}</h3>

<a href="/users/logout">LogOut</a>
<a href="/projects/new">+ New Project</a>
</div>
    <!-- this is that the project that the user is not a part of it   -->
<table class="offset-4">
<h3 class="text-center">My Projects</h3>
  <thead>
  
    <tr class="bg-warning border-2 ">
      <th scope="col">Project</th>
      <th scope="col"> Team Lead</th>
      <th scope="col"> Due Date</th>
       <th scope="col">Actions</th> 
    </tr>
  </thead>
  <tbody>
  
 <!--  this is all the project that your not part of it , so just it going to display only join part  -->
      <c:forEach  var ="project" items="${allProjects}" >
      		<tr>
      		<td class="table-primary border-3  text-danger"><c:out value="${project.title}"/></td>
     		<td class="table-secondary border-3 text-success "><a href="/projects/${project.id}"><c:out value="${project.creatore.firstName}"/></a> 
    		 <td class="table-secondary border-3 text-success"> <c:out value="${project.duaDate}"/></td>	
    		     <th> <a href="/projects/join/${project.id}"> Join Team</a>
    		     
    		     
    		     
    		     </th>
    		 
    		 
    		 </c:forEach>
<%--                    <th> <a href="/projects/join/${project.id}">Join Team</a></th>
 --%>
   				   <!-- we on't need this since we only need to join in the toptable  -->
    
      		 <%-- <c:if test="${project.creatore.id eq userID}">
      		
      		          <td class="table-primary border-3  text-danger"><a href="/projects/edit/${project.id}"> edit </a> |<a href="/projects/delete/${project.id}"> delete </a> 
      		          </td>
      		 </c:if>  --%>
<%--       		  <c:choose >
 --%>      		 
		         <%-- <c:when test = "${project.teamMembers.contains(currentUser)}">
		                     <th> <a href="# ">Leave Team</a></th>	       
		         </c:when>  
          --%>
<%--           <c:otherwise>
 --%><%--         			<c:out value="${currentUser}"></c:out>
 --%>        
<%--          </c:otherwise>
 --%>         
<%--     </c:choose> 
 --%>    
  
      
     
     
     
   

     
     

</body>

</html>