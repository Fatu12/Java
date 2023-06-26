<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
 <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!-- YOUR own local CSS -->
<link rel="stylesheet" href="/css/main.css"/>
<!-- For any Bootstrap that uses JS -->
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">

</head>

  
<h2   style="margin-top:50px"  class=" offset-2 text-black fw-bold">Here is your Omikuji !</h2>
  <div  style="width:200px ;" class="container  mt-3 text-center offset-3 fw-lighter  border bg-info">
  <div class="row">
    <div class="col text-black ">

<!--  the value need to match with our variable that we have declared variable in our controller page  -->
    In <c:out value="${pickNumber}"/> years, you will live in<c:out value="${city}"/> with <c:out value="${personName}"/> as your roommate, selling
    origamis for a <c:out value="${typeLiving}"/>. The next time you see a ferret, you will
    have good luck. Also,<c:out value="${message}"/>.
    </div>
   
  </div>
</div>
  <p class="offset-4 mt-3"><a href="/omikuji">Go back</a> </p>

  

</body>
</html>