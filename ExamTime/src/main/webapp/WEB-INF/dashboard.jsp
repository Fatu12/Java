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
 <div class="offset-4 ">
<h1 class="offset-2 mt-4"> WEL COME  ${currentUser.firstName}! </h1>

<c:out value=""></c:out>
<h3> First Name : ${currentUser.firstName}</h3>
<h3>Last Name: ${currentUser.lastName}</h3>
<h3>Email: ${currentUser.email}</h3>
<a href="/users/logout">Log out</a>

</div>

<table class="offset-3"> 
  <thead>
  
    <tr class="bg-warning border-2 ">
      <th scope="col">Address</th>
      <th scope="col"> Listed On </th>
      <th scope="col">Added By</th>
       <th scope="col">Price</th> 
    </tr>
  </thead>
  <tbody>
 <!--  this is all the project that your not part of it , so just it going to display only join part  -->
      <c:forEach  var ="houseHunter" items="${allHouseHunter}" >
      		<tr>
      		
      		<td class="table-primary border-3  text-danger"> <a href="/notes/${houseHunter.id}"> <c:out value="${houseHunter.address}"/></a></td>
      		 <td class="table-secondary border-3 text-success "><c:out value="${houseHunter.createdAt}"/>
     		<td class="table-secondary border-3 text-success "><c:out value="${houseHunter.creatore.firstName}"/></td>
     		
    		 <td class="table-secondary border-3 text-success"> $<c:out  value="${houseHunter.price}"/></td>
    		 </c:forEach>
    		 
    		 </tbody>
    		 </table>
    		 
    		 <a class="offset-4 mt-5" href="/houses/new">Add Listing</a>
    		 
    		 
    		 

</body>

</html>