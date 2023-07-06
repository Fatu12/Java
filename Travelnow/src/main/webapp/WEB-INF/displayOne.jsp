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
<link rel="stylesheet" href="/css/main.css"/>
<!-- For any Bootstrap that uses JS -->
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
</head>
<body>


<h1> Expense Details</h1>
 <a href="/travel">Go back</a> 


  
  <p> Expense Name:  ${travelExpense.expenseName}</p>
  
  <p> Expense Description:  ${travelExpense.vendor}</p>
  <p> Vendor: $ ${travelExpense.amount} </p>
  <p> Amount Spend: ${travelExpense.description} </p>
</body>
</html>