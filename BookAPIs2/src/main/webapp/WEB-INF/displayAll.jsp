<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
    
    
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

<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>



</head>
<body>
<h1 class="text-center"> All Books </h1>
<!-- .table-{color} can be use with .table, thead, tbody, tr, th and td -->
<table  class="table offset-1 mt-5 ps-3 border border-blacks">
  <thead>
    <tr class="table-success"> 
      <th scope="col">ID</th>
      <th scope="col">Title</th>
      <th scope="col">Description</th>
      
      <th scope="col">language</th>
       <th scope="col"># Pages</th>
    </tr>
  </thead>
  <tbody>
           <c:forEach var="oneBook" items="${book}">
           
         	<tr >
         	
         	
         	 <td> <a href="/show/${oneBook.id}"><c:out value="${oneBook.id}"/></td>
         	
         
         		<td class="border border-black"><c:out value="${oneBook.bookTittle}"/></td>
         		<td class="border border-black"><c:out value="${oneBook.bookDesctiption}"/></td>
         		<td class="border border-black"><c:out value="${oneBook.bookLanguage}"/></td>
         		<td class="border border-black"><c:out value="${oneBook.bookPage}"/></td>
         	</tr>
         </c:forEach>
      
    
  </tbody>
</table>
</body>
</html>