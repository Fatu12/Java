<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div id="wrapper">

 <h1>  Houston, we have lift-off!!!!!!! </h1>
 <h2> <c:out value="${pizza}"/></h2>
  <h2> <c:out value="${dfpizza}"/></h2>
  
  <!--  Loop through pizzas -->
  
    <c:forEach var="iterator" items="${allPizzas}">
    <!--  using if statem to show pizza or not equals is comperacen for string -->
    <%-- <c:if test="${iterator.equals('Hawaiian')}">
    <p> I love pinapple on cold pizza</p>
    </c:if> --%>
    <!--  if ele  -->
    <c:choose > 
    <c:when test="${iterator.equals('sausage')}">
    	<p>	I love pinapple on cold pizza</p>
    </c:when>
    <c:otherwise>
     <h3> ${iterator}</h3>
    </c:otherwise>
    
    </c:choose>
    
          <h3> ${iterator}</h3>
    </c:forEach>
  
</div>

</body>
</html>