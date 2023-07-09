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
</head>
<body>

<h1 class="text-center offset-1 mt-3 text-primary-emphasis"> New Dojo </h1>

<form:form action="/dojos/new" method ="POST" modelAttribute="newDojos" >
<div class= "offset-3 fw-medium  ms-2">
 <p class = "offset-5 text-danger"><form:errors path="name"></form:errors></p>
 
<form:label path="name"  class="offset-5">Name:</form:label>
 <form:input path="name"/>
 </div>
 <div class=" d-flex justify-content-center mt-3 "><button  class="btn btn-primary ">Create</button>
 </div>
	
</form:form>

</body>
</html>