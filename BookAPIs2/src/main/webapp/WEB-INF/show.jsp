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
</head>
<body>
<!-- since we getting from the database we need to mutch our attributes 
with model -->

<h1> <c:out value="${book.bookTittle}"></c:out> </h1>
<h4>Language: <c:out value="${book.bookDesctiption}"></c:out> </h4>

<h4>Language: <c:out value="${book.bookLanguage}"></c:out> </h4>

<h4>Number of Pages: <c:out value="${book.bookPage}"></c:out> </h4>



</body>

</body>
</html>