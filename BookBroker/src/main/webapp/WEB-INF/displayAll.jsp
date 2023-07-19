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
		   <a  class="offset-1" href="/users/books"></a>
 
	   <a  class="offset-1" href="/users/books"> back to the shelves</a>
   
      <a class="offset-1" href="/users"> back to home</a>
      
<!--       <h4> Hello {userID.firstName}</h4>
 -->   </div>
   <h1 class="offset-1"> The Book Brioker!</h1>
      <h5 class="offset-1"> Available Books to Borrow </h5>
      
      
    <table class="table offset-1">
  <thead>
    <tr>
      <th scope="col">ID</th>
      <th scope="col">Title</th>
      <th scope="col">Author Name</th>
      <th scope="col">Owner</th>
            <th scope="col">Action</th>

    </tr>
  </thead>
  <tbody>
    <tr>
    <tr>
      <c:forEach  var ="book" items="${allBooks}">
      <tr>
      		<td class="table-primary border-3  text-danger "><c:out value="${book.id}"/></td>
      		
      		<td class="table-secondary border-3 text-success  "> <a href="/users/books/${book.id}"><c:out value="${ book.title}"/></a>
      		<td class="table-primary border-3  text-danger "><c:out value="${book.author}"/></td>
      		
      		 <td class="table-primary border-3 text-danger "><c:out value="${book.userTable.firstName}"/></td>
      		 <c:choose>
         
         <c:when test ="${book.userTable.id eq userID}">
               		  <td><a href="/users/books/${book.id}/edit"> Edit</a> |  <a href="/users/delete/${book.id}">delete</a>
         </c:when>
         
         
         <c:otherwise>
          
               		  <td><a href="/users/books/${book.id}/borrow"> borrow</a></td>
         </c:otherwise>
      </c:choose>
      		
      		       		  
      		       		 
      		       		 	
      		       		 	
      		       		
      		       	
      		       		 
      		     		 
    </c:forEach>
     
    </tr>
   
  </tbody>
</table>
   
   
   
   
   

<body>
</html>