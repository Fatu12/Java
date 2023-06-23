<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
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
</head>
<body>
<h1>Customer Name: ${name}</h1>
<!--  The first tag we going to use in this case is c:out tag that will be used
to instert values to display in the body of our hmtl code -->

<h4> Item name:<c:out value="${item}"></c:out> </h4>
<h2> Price: <c:out value="${itemPrice}"></c:out> </h4>
<h4>Description: <c:out value="${itemDescription}"></c:out> </h4>
<h4>Vendor: <c:out value="${vendorChore}"></c:out> </h4>
</body>
</html>