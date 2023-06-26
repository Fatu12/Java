<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
 <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">

</head>
<body>



<form  action="/omikuji/display" method= "POST" class="col-6 offset-2  border border-black border-5 bg-dark " >

<h1 class=" offset-1 text-success">Send an Omikuji!</h1>
 <div class="form-group  ">
    <label for="pickNumber" class = "fw-medium mb-3 ms-5 ps-5 border-black border-4 text-light">Pick any number from 5 to 25</label>
    <input type="number"  name="pickNumber" class="form-control "> 
  </div>
  <div class="form-group">
    <label for="city" class = " mb-3 fw-medium  ms-5 ps-5 text-light">Enter the name of any city</label>
    <input type="text"  name="city" class="form-control">
    
  </div>
 <div class="form-group">
    <label for="personName" class = " mb-3 fw-medium   ms-5 ps-5 text-light">Enter the name of any real person </label>
    <input type="text"  name="personName" class="form-control">
  </div>
  <div class="form-group">
    <label for="professional" class = " mb-3 fw-medium  ms-5 ps-5 text-light">Enter professional endeavor  hoppy:</label>
    <input type="text"  name="professional" class="form-control">
  </div>
  <div class="form-group">
    <label for="typeLiving" class = " mb-3 fw-medium  ms-5 ps-5 text-light">Enter any type of living things</label>
    <input type="text" name="typeLiving" class="form-control" >
  </div>
    
  <div class="form-group">
    <label for="message" class = "pr-5 mb-3 fw-medium  ms-5 ps-5 text-light">Say something nice to someone</label>
    <textarea  name="message" rows="3" class="form-control"></textarea>
  </div>
  
  <div class="form-group text-center">
  <p class = " mb-3 fw-medium ms-1 ps-5 text-light"> Send and show a friend </p>
  <button type="submit" class="btn btn-primary mt-2  ">send</button>
  </div>
</form>
</body>
</html>