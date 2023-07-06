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
	<body>

	
			<div id="wrapper">
			<h1> Houston, we have lift-off</h1>
			
			<form:form  action="/tweet/create" method="POST" modelAttribute="newRTweet">
			
			
			<div> 
			 <h5> <form:errors path="tweetContent"/>
			 </h5>
			<form:label  path="tweetContent">Content</form:label>
			 <form:input type="text" path="tweetContent"/>
			 </div>
			 <div>
			 			 <h5> <form:errors path="imginaryIntAtt"/></h5>
			 
						 
			  <h4><form:label  path="imginaryIntAtt">Integers</form:label></h4>
			 <form:input type="number" path="imginaryIntAtt" required="true" />
			 
			 </div>
			<form:button> Submit</form:button>
			
			</form:form>
			
			 <table>
			 <thead>
			 
			 <tr>
			 	<th> ID</th>
			 	<th> Conteent</th>
			 	<th> RandomInteger</th>
			 	<th> createAt</th>
			 	<th> update</th>
			 	<th> edit</th>
			 	
			 </tr>
			 
			
			 </thead>
			 <tbody>
			 	<c:forEach  var="tweet"  items="${allTheThings}">
			 	<tr>
			 	<td><c:out value="${tweet.id}">	</c:out></td>
			 	<td><c:out value="${tweet.imginaryIntAtt}"> </c:out></td>
			 	<td><c:out value="${tweet.tweetContent}" ></c:out></td>
			 	<td> <a href="/tweet/edit/${tweet.id}">Edit</a>| <a href="/tweet/delete/${tweet.id}">Delete</a> </td>
			 	
			 	<form action="/tweet/delete/${tweet.id}" method="post">
			    <input type="hidden" name="_method" value="delete">
			    <input type="submit" value="Delete">
			</form>
			 	
			 	
			 	</tr>
			 	</c:forEach>
			 	
			 
			 </tbody>
			 </table>
			</div>
			
			 
			
			
			
			
			
			
	
			
			
	
			
	</body>
	</html>