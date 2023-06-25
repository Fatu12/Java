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
<h3> ${name} , we have lift-off </h3>
<h3> Current count is: </h3>
<c:out value="${count}"></c:out>


<!--  think that if the user is not proveding data why we need to use form, then
is better not using -->

<form action='/counting/clear' method='POST'>


<button>ClearSession</button>

</form>
<c:out value="${amountError}"> </c:out>
<form action='/counting/increment/${userId}' method='POST'>
  
	</label>$Player Name:</label>
    	<input type="text" name="name">
	<label>Amount to Increment:</label>
    	<input type="number" name="amount">
    	<button>count by this</button>
<!--   	<input type='submit' value='count by this'>
 -->  </form>
</body>
</html>