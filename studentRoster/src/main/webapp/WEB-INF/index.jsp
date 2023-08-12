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
<div class="d-flex">
 
<div>
<h1 class="offset-4 mt-4"> Register </h1>

<form:form action="/users/register" method ="POST" modelAttribute="newUser" class = "offset border offset-3 bg-info-subtle">
  
<div  class="offset-2">
 <p class = "offset-5 text-danger"><form:errors path="firstName"></form:errors></p>

<form:label path="firstName"  class="form-label offset-3 mt-2 text-primary-emphasis fw-bolder "> First Name:</form:label>
<br>
<form:input path="firstName" class="form" />
</div>

<div class="mb-3 offset-2 "> 
 <p class = "offset-5 text-danger"><form:errors path="lastName"></form:errors></p>

<form:label path="lastName" class="form-label  offset-3 mt-2 text-primary-emphasis fw-bolder" >Last Name: </form:label>
<br>
<form:input path="lastName"  class=" form "/>
</div>
<div class="offset-2">
 <p class = "offset-5 text-danger"><form:errors path="email"></form:errors></p>

<form:label path="email"  class="form-label offset-3 mt-2 text-primary-emphasis fw-bolder">Email:</form:label>
<br>
<form:input  path="email" class="form " />
</div>

<div class="offset-2">
 <p class = "offset-5 text-danger"><form:errors path="password"></form:errors></p>

<form:label path="password"  class="form-label offset-3 mt-2 text-primary-emphasis fw-bolder">password:</form:label>
<br>
<form:input type="password" path="password" class="form " />
</div>

<div class="offset-2">
 <p class = "offset-5 text-danger"><form:errors path="confirm"></form:errors></p>

<form:label path="confirm"  class="form-label offset-3 mt-2 text-primary-emphasis fw-bolder">Confirm password:</form:label>
<br>
<form:input type="password" path="confirm" class="form " />
</div>


 <div class=" d-flex justify-content-center mt-3 "><button class="btn btn-warning text-black fw-bolder">Create</button>
 </div>
 
	
</form:form>

 </div>


<div class="offset-1">
<h1 class="offset-4 mt-4"> Login </h1>

<form:form action="/users/login" method ="POST" modelAttribute="loginUser" class = "offset border offset-3 bg-info-subtle">
  

<div class="offset-2">
 <p class = "offset-5 text-danger"><form:errors path="email"></form:errors></p>

<form:label path="email"  class="form-label offset-3 mt-2 text-primary-emphasis fw-bolder">Email:</form:label>
<br>
<form:input  path="email" class="form " />
</div>
<div class="offset-2">
 <p class = "offset-5 text-danger"><form:errors path="password"></form:errors></p>

<form:label path="password"  class="form-label offset-3 mt-2 text-primary-emphasis fw-bolder">password:</form:label>
<br>
<form:input type="password" path="password" class="form " />
</div>


 <div class=" d-flex justify-content-center mt-3 "><button class="btn btn-warning text-black fw-bolder">Login</button>
 
 </div>
	
</form:form>

</div>
</div>
</body>


</html>