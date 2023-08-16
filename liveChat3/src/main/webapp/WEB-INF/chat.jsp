
<!DOCTYPE html>
<html>
  <head>
      <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0">
		<title>Spring Boot WebSocket Chat Application | Fatu</title>
      <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
      
      <link rel="stylesheet" href="/css/main.css" />
      <link rel="stylesheet" href="/css/sytle.css" />
       <style class="">
       
       
      /*   body {
            background-image: url('image/image1.png');
            background-size: cover; /* Adjust how the image covers the background */
         
    </style>
    
    
   <script>
  	function refresh(){ 
   		window.location.refresh();
 
  	}
/*   setInterval(refresh,5000); //the pictuter will run every five minute 
 */  
   setInterval(refresh,5000); //the pictuter will run every five minute 
   
  
  </script> 
  
  
    
     
  </head>
  <body >
  
  
  
  	<div>
<!--   		<button onclick="refreshBackground()"> random image</button>
 -->  	
  	</div>
  	<!-- 
  	<div class="content">
  	
  	<h3> random image in every 5 seconds</h3>
<!--   	<p> click on the button for new image</p> -->
<!--   	<button onclick="refresh()"> random image</button> -->
  	
  
     <!--  background="18.jpg container"
	style="background-position: center; background-repeat: no-repeat; background-size: cover;">
	 -->
     <noscript>
      <h2>Sorry! Your browser doesn't support Javascript</h2>
    </noscript>
    
    
    <div class="text-center">
    
    
    <p class="text-center text-light textColor">Need Info About This Neighborhood, Chat With Random People</p>
    </div>
    

    <div id="username-page">
        <div class="username-page-container">
            <h1 class="title">Type your username</h1>
            <form id="usernameForm" name="usernameForm">
                <div class="form-group">
                    <input type="text" id="name" placeholder="Username" autocomplete="off" class="form-control" />
                </div>
                <div class="form-group">
                    <button type="submit" class="accent username-submit">Start Chatting</button>
                </div>
            </form>
        </div>
    </div>

    <div id="chat-page" class="hidden">
        <div class="chat-container">
            <div class="chat-header">
                <h2>Chat Neighbors</h1>
                 </h2>
            </div>
            <div class="connecting">
                Connecting...
            </div>
            <ul id="messageArea">

            </ul>
            <form id="messageForm" name="messageForm">
                <div class="form-group">
                    <div class="input-group clearfix">
                        <input type="text" id="message" placeholder="Type a message..." autocomplete="off" class="form-control"/>
                        <button type="submit" class="primary">Send</button>
                         <p>want to be a member? please click this link to registor<a href="/users/"> Register</a></p>
                        
                    </div>
                </div>
            </form>
        </div>
    </div>
		<div>
		   
		</div>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/sockjs-client/1.1.4/sockjs.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/stomp.js/2.3.3/stomp.min.js"></script>
    <script src="/js/main.js"></script>
      <script src="/js/image.js"></script>
      
      
    
    
  </body>
</html>