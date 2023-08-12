<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
	  <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %> 
	    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Live Chat</title>
<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- YOUR own local CSS -->
<link rel="stylesheet" href="/css/main.css"/>
<!-- For any Bootstrap that uses JS -->
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>

    <script src="https://cdnjs.cloudflare.com/ajax/libs/sockjs-client/1.5.1/sockjs.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/stomp.js/2.3.3/stomp.min.js"></script>

    <script>
        var socket = new SockJS('/chat');
        var stompClient = Stomp.over(socket);

        stompClient.connect({}, function(frame) {
            stompClient.subscribe('/topic/messages', function(response) {
                var message = JSON.parse(response.body);
                // Handle the received message and display it in the UI
                // Example: document.getElementById('chat').innerHTML += message.content + '<br>';
            });
        });

        function sendMessage() {
            var content = document.getElementById('message').value;
            stompClient.send('/app/chat', {}, JSON.stringify({ 'content': content }));
            document.getElementById('message').value = '';
        }
    </script>
</head>
<body>
    <div id="chat"></div>
    <input type="text" id="message" placeholder="Type your message..." />
    <button onclick="sendMessage()">Send</button>
</body>
</html>

