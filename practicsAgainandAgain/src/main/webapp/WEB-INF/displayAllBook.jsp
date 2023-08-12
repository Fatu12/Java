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

<h1 class=" mt-4"> WEL COME, ${currentUser.firstName} </h1>

<a href="/books/new"> + add  a to my shelf!</a>


<table class="offset-3"> 
  <thead>
  
    <tr class="bg-warning border-2 ">
      <th scope="col">ID</th>
      <th scope="col"> Title</th>
      <th scope="col">Author Name</th>
       <th scope="col">Posted By</th> 
    </tr>
  </thead>
  <tbody>

  
 <!--  this is all the project that your not part of it , so just it going to display only join part  -->
      <c:forEach  var ="book" items="${allBooks}" >
      		<tr>
      		 <td class="table-secondary border-3 text-success "><c:out value="${book.id}"/>
      		
      		<td class="table-primary border-3  text-danger"> <a href="/books/${book.id}"> <c:out value="${book.title}"/></a></td>
    		 <td class="table-secondary border-3 text-success"> <c:out value="${book.author}"/></td>
     		<td class="table-secondary border-3 text-success "><c:out value="${book.creatore.firstName}"/>
    		 </c:forEach>
    		 
    		 </tbody>
    		 </table>


     
     

</body>

</html>