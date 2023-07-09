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
<link rel="stylesheet" href="/CSS/style.css"/>
<!-- For any Bootstrap that uses JS -->
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">

</head>
<body>
<h1 class="text-center mt-5 text-warning-emphasis "> Burbank Location Ninjas</h1>

<table class="tables offset-4">
  <thead>
    <tr class="bg-warning border-2 ">
      <th scope="col">First Name</th>
      <th scope="col">Last Name</th>
      <th scope="col">Age</th>
    </tr>
  </thead>
  <tbody>
    <tr>
     
      <c:forEach  var ="ninja" items="${datialDojos.ninja}">
      <tr>
      		<td class="table-primary border-3  text-danger "><c:out value="${ninja.firstName}"/></td>
      		<td class="table-secondary border-3 text-success  "><c:out value="${ninja.lastName}"/></td>
      		<td class="table-primary border-3 text-danger "><c:out value="${ninja.age}"/></td>
      </c:forEach>
     
    </tr>
    
  </tbody>
</table>
</body>


</html>