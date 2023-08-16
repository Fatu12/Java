<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
	  <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
  <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
	  
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



 <div class="wrapper"> <p class=" mt-4 textColor fw-lighter offset-1">Thank You <span>${currentUser.firstName}</span> For Registering </p>
<c:out value=""></c:out>
<p class="offset-1 text-white">Your Full Name : <span class="text-white fw-lighter underline"> ${currentUser.firstName} ${currentUser.lastName}</span></p>

<div class="offset-4">
<a href="/users/logout">  <button class="btn btn-danger">LogOut</button></a>
<a href="/users/home"> <button class="btn btn-success">go to see more info</button></a>


<!-- <a href="/comment/"><button class="btn btn-success">go back to home</button></a>
 -->
<a href="/community/new"><button class="btn btn-danger"> + New Information</button></a>
</div>
 </div>
 <h3 class="text-center text-danger">Information Of Your Neighborhood</h3>
		<ul class="offset-1">
    <c:forEach  var ="info" items="${allComminityInfo}" >
      
      		<li class="text-white"> more information<a href="/commant/${info.id}"> <c:out value="${info.title}"/> click this</a></li>
      		<li class="text-white"> hosted by <span class="text-danger">${info.creator.firstName}</span></li>
     		 <li class="text-white">Date <span class="text-danger"><fmt:formatDate value="${info.date}" pattern="EEE-MMM-dd-yyyy" /></span></li>
  		 	<li class="text-white"> Addresss:<a href="/maps"><c:out value="${info.address}"/></a></li>
      		    		   		 
     		<li class="text-white">Contant-Info:<span class="text-danger"><c:out value="${info.contatctInfo}"/></span></li>
     		 
     		   
    		 </c:forEach>
    		 </ul>
    		  
    
     
</body>

</html>