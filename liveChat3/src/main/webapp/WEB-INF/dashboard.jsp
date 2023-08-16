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
<link rel="stylesheet" href="/css/sytle.css"/>
<!-- For any Bootstrap that uses JS -->
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
 <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
</head>
<body class="body">
<div class="wrapper">
<p class=" mt-4 textColor fw-lighter offset-1">Thank You <span>${currentUser.firstName}</span> For Registering </p>
<c:out value=""></c:out>
<p class="offset-1 text-white">Your Full Name : <span class="text-white fw-lighter underline"> ${currentUser.firstName} ${currentUser.lastName}</span></p>

<p class="offset-1 text-white">Your Email: <span class="text-white fw-lighter underline">${currentUser.email}</span></p>

<div class="offset-4">
<a href="/users/logout">  <button class="btn btn-danger">LogOut</button></a>

<a href="/community/info" ><button class="btn btn-success">go to see more info</button></a>

<a href="/community/new"><button class="btn btn-danger"> + New Information</button></a>
</div>


 </div>

 <h3 class="text-center text-danger"> List Of Your Neighbors</h3>
 
  
    <!-- this is that the project that the user is not a part of it   -->
<%-- <table class="offset-4">
<h3 class="text-center">welcome to neighborhood</h3>
  <thead>
    <tr class="bg-warning border-2 ">
      <th scope="col">Title</th>
      <th scope="col"> Description </th>
      <th scope="col"> Date</th>
       <th scope="col">Location</th> 
        <th scope="col">Hosted By </th> 
         <th scope="col">Action </th> 
       </tr>
  </thead>
  <tbody>

 <!--  this is all the project that your not part of it , so just it going to display only join part  -->
     <c:forEach  var ="thisCommonity" items="${allNCommonities}" >
      		<tr>
      		<td class="table-primary border-3  text-danger"> <a href="/commant/"> <c:out value="${thisCommonity.name}"/></a></td>
      		 <td class="table-secondary border-3 text-success"> <c:out value="${thisCommonity.discription}"/></td>
      		
    		 <td class="table-secondary border-3 text-success"> <c:out value="${thisCommonity.date}"/></td>
    		   <td class="table-secondary border-3 text-success"><a href="/maps"><c:out value="${thisCommonity.address}"/></a> </td>
    		 
     		<td class="table-secondary border-3 text-success "><c:out value="${thisCommonity.creator.firstName}"/>
    		    <th> <a href="/projects/join/${project.id}"> Join Team</a> 
    		 </c:forEach>
    		 
    		 </tbody>
    		 </table> --%> 
    		  
    	 
     		 
    		 <table class="table">
  <thead>
    <tr class="bg-warning border-2 ">
       <td class="table-secondary ">FirstName</td>
  <td class=" table-primary">LastName</td>
  <td class="table-success">Age</td>
    <td class="table-light">Gander</td>
  
  <td class="table-danger">Language</td>
  <td class="table-warning">Email</td>
  <td class="table-info">Phone Number</td>
  <td class="table-light">Social Media</td>
       </tr>
  </thead>
  <tbody>   
    
    <c:forEach  var ="user" items="${allUsers}" >
      		 <tr class="table-active table1">
      		<td class="table-secondary"> <a href="/commant/${user.id}"> <c:out value="${user.firstName}"/></a></td>
  		 <td class="table-primary "> <c:out value="${user.lastName}"/></td>
      		
    		 <td class="table-success"> <c:out value="${user.age}"/></td>  
    		     		 <td class="table-light"> <c:out value="${user.gander}"/></td>    		
    		   		
   		     <td class="table-danger"> <c:out value="${user.langauge}"/></td>    		
   		 
     		<td class="table-warning"><c:out value="${user.email}"/>
     		 <td class="table-info  "><c:out value="${user.phoneNumber}"/>
     		  <td class="table-light"><c:out value="${user.socialMadia}"/>
     		   </tr>
     		   
     		   
    		 </c:forEach>
    
       <h1 class="text-primary">"${creator.size()}"</h1>
   
  </tbody>
</table> 

</body>

</html>