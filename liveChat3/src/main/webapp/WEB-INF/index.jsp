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
<link rel="stylesheet" href="/css/sytle.css"/>
<link rel="stylesheet" href="/image"/>

<!-- For any Bootstrap that uses JS -->
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
  
  <style>
        body {
            background-image: url('/image/image4.png');
            background-size: cover; /* Adjust as needed */
            background-repeat: no-repeat;
            background-attachment: fixed; /* This keeps the image fixed while scrolling */
        }
        </style>
        
</head>
<body  >
<h1 class="offset-4 mt-4 text-info ">Welcome To The Neighborhood</h1>
<div class="d-flex">

<div class="registor">

<h1 class="offset-4 text-info"> Register </h1>

<form:form action="/users/register" method ="POST"  modelAttribute="newUser" class = "offset border offset-3 bg-info-subtle">
  
<div  class="offset-2">
 <p class = " text-danger"><form:errors path="firstName"></form:errors></p>

<form:label path="firstName"  class="form-label offset-3 mt-1 text-primary-emphasis fw-bolder "> First Name*</form:label>
<br>
<form:input path="firstName" class="form" />
</div>

<div class="mb-3 offset-2 "> 
 <p class = "text-danger mt-2"><form:errors path="lastName"></form:errors></p>

<form:label path="lastName" class="form-label  offset-3 text-primary-emphasis fw-bolder" >Last Name* </form:label>
<br>
<form:input path="lastName"  class=" form "/>
</div>
<div class="offset-2 mt-2">
 <p class = "text-danger"><form:errors path="email"></form:errors></p>

<form:label path="email"  class="form-label offset-3 mt-2 text-primary-emphasis fw-bolder">Email*</form:label>
<br>
<form:input  path="email" class="form " />
</div>

<div class="offset-2 mt-2">
 <p class = "text-danger"><form:errors path="password"></form:errors></p>

<form:label path="password"  class="form-label offset-3 mt-2 text-primary-emphasis fw-bolder">password*</form:label>
<br>
<form:input type="password" path="password" class="form " />
</div>

<div class="offset-2 mt-2">
 <p class = "text-danger"><form:errors path="confirm"></form:errors></p>

<form:label path="confirm"  class="form-label offset-3 mt-2 text-primary-emphasis fw-bolder">Confirm password*</form:label>
<br>
<form:input type="password" path="confirm" class="form " />
</div>
<div class="mb-3 offset-2 mt-2"> 
 <p class = " text-danger"><form:errors path="race"></form:errors></p>

<form:label path="race" class="form-label  offset-3 mt-2 text-primary-emphasis fw-bolder" >Race* </form:label>
<br>
<form:input   path="race"  class=" form "/>
</div>

<div class="mb-3 offset-2 mt-2"> 
 <p class = "text-danger"><form:errors path="languageList"></form:errors></p>

<form:label path="languageList" class="form-label  offset-1 mt-2 text-primary-emphasis fw-bolder" >How Many Language You Speak* </form:label>
<br>
<form:input type="number" path="languageList"  class=" form "/>
</div>

 <div class="mb-3 offset-2 mt-2"> 
 <p class = "text-danger"><form:errors path="langauge"></form:errors></p>

<form:label path="langauge" class="form-label  offset-3 mt-2 text-primary-emphasis fw-bolder" >Language* </form:label>
<br>
<form:input path="langauge"  class=" form "/>
</div> 
<div class="mb-3 offset-2 mt-2"> 
 <p class = "text-danger"><form:errors path="age"></form:errors></p>

<form:label path="age" class="form-label  offset-3 mt-2 text-primary-emphasis fw-bolder" >Age* </form:label>
<br>
<form:input type="number" path="age"  class=" form "/>
</div>
<div class="mb-3 offset-2 mt-2"> 
 <p class = "text-danger"><form:errors path="gander"></form:errors></p>

<form:label path="gander" class="form-label  offset-3 mt-2 text-primary-emphasis fw-bolder" >Gander* </form:label>
<br>
<form:input path="gander"  class=" form "/>
</div>

<div class="mb-3 offset-2 mt-2"> 
 <p class = "text-danger"><form:errors path="socialMadia"></form:errors></p>

<form:label path="socialMadia" class="form-label  offset-2 mt-2 text-primary-emphasis fw-bolder" >SocialMadia(optional): </form:label>
<br>
<form:input  path="socialMadia"  class=" form "/>
</div>

<div class="mb-3 offset-2 mt-2"> 
 <p class = "text-danger"><form:errors path="phoneNumber"></form:errors></p>

<form:label path="phoneNumber" class="form-label  offset-2 mt-2 text-primary-emphasis fw-bolder" >PhoneNumber(optional): </form:label>
<br>
<%-- <form:input type="tel" path="phoneNumber"  id="phone" name="phone" placeholder="123-457-6788" pattern="[0-9]{3}-[0-9]{3}-[0-9]{3}" class=" form " />
 --%>
 
 <form:input  path="phoneNumber"  placeholder="123-457-6788" class=" form " />
 
 </div>

<div class="mb-3 offset-2 mt-2"> 
 <p class = "text-danger"><form:errors path="additioan"></form:errors></p>

<form:label  path="additioan" class="form-label  offset-2 mt-2 text-primary-emphasis fw-bolder" >anything you like to add: </form:label>
<br>
<form:textarea cols="50" rows="4" path="additioan" class=" form "/>
</div>
 <div class=" d-flex justify-content-center mt-3 "><button class="btn btn-warning text-black fw-bolder">Create</button>
 </div>
</form:form>

 </div>

<div class="offset-1 offset-2 comment ">
<h1 class="offset-4 mt-4 text-info"> Login </h1>

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