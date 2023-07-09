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
<h1 class="offset-4 mt-4"> New Ninja </h1>

<form:form action="/ninja/new" method ="POST" modelAttribute="newNinja" class = "offset border offset-3 bg-success">
  
  <div  class="form-label offset-3">
  	<form:label path="dojo" class="text-black fw-bolder">Name: </form:label>
  	<br>
  	<form:select path = "dojo" class="form ms-3">
  	<c:forEach  var ="dojo" items="${listDojos}">
  	<option value="${dojo.id}">${dojo.name}</option>
  	</c:forEach>
  	</form:select>
  	
  </div>
  
<div  class="offset-2">
 <p class = "offset-5 text-danger"><form:errors path="firstName"></form:errors></p>

<form:label path="firstName"  class="form-label offset-3 mt-2 text-black fw-bolder "> First Name:</form:label>
<br>
<form:input path="firstName" class="form" />
</div>

<div class="mb-3 offset-2 "> 
 <p class = "offset-5 text-danger"><form:errors path="lastName"></form:errors></p>

<form:label path="lastName" class="form-label  offset-3 mt-2 text-black fw-bolder" >Last Name: </form:label>
<br>
<form:input path="lastName"  class=" form "/>
</div>
<div class="offset-2">
 <p class = "offset-5 text-danger"><form:errors path="age"></form:errors></p>

<form:label path="age"  class="form-label offset-3 mt-2 text-black fw-bolder">Age:</form:label>
<br>
<form:input type="number" path="age" class="form " />
</div>

 <div class=" d-flex justify-content-center mt-3 "><button class="btn btn-primary text-black fw-bolder">Create</button>
 
	
</form:form>
</body>
</html>