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
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">


<!-- For any Bootstrap that uses JS -->
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>

<a href="/books">Dashbaord</a>

  <div class="offset-3 mt-2">
  <a href="/dorms/new">Add a new dorm</a>
    <a href="/students/new">Add new Student</a>
  
  </div>
<table class="offset-4">
<h3 class="text-center">My Projects</h3>
  <thead>
  
    <tr class="bg-warning border-2 ">
      <th scope="col">Dorm</th>
       <th scope="col">Actions</th> 
    </tr>
  </thead>
  <tbody>
  
 <!--  this is all the project that your not part of it , so just it going to display only join part  -->
      <c:forEach  var ="dorm" items="${allDorms}" >
      		<tr>
     		<td class="table-secondary border-3 text-success "><c:out value="${dorm.dormName}"/>
      		<td class="table-primary border-3  text-danger"> <a href="/dorms/${dorm.id}">See Students</a></td>
    		
      		  
    		 </c:forEach>

     </tbody>
     </table>
     
</body>

</html>