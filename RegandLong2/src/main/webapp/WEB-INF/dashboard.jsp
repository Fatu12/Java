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




<div class="offset-1 mt-3 ">
	<a class="offset-1" href="/users/logout"> Log out</a>
   <a  class="offset-1" href="/users/book/new"> Add Book</a>
   
      <a class="offset-1" href="/users"> go back </a>
   
   
   

	

</div>



<h1 class=" offset-1 mt-5 text-warning-emphasis "> Welecome ${currentUser.firstName} </h1>
		<h5 class="offset-1 mt-5 text-warning-emphasis "> Books from everyine's shelves </h5>
		
	

<table class=" offset-1">
  <thead>
    <tr class="bg-warning border-2 ">
      <th scope="col">ID</th>
      <th scope="col">Title</th>
      <th scope="col">Author Name</th>
       <th scope="col">Posted By</th>
      
    </tr>
  </thead>
  <tbody>
    <tr>
     
      <c:forEach var="book" items="${books}">
      <tr>
      		<td class="table-primary border-3  text-danger "><c:out value="${book.id}"/></td>
      		<td class="table-secondary border-3 text-success"> <a href="/users/${book.id}"><c:out value="${book.title}"/></a>
      		 </td>
      		<td class="table-primary border-3 text-danger "><c:out value="${book.author}"/></td>
      		      		<td class="table-primary border-3 text-danger "><c:out value="${book.user.firstName}"/></td>
      
    </tr>
      </c:forEach>
    
  </tbody>
</table>
</body>

</html>