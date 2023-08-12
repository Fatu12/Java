 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
	  <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<%@ page isErrorPage="true" %> 
	    
<!-- <!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
for Bootstrap CSS
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
YOUR own local CSS
<link rel="stylesheet" href="/CSS/sytle.css"/>
For any Bootstrap that uses JS
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
 <style>
        body {
            margin: 0;
            padding: 0;
            background-size: cover;
            background-repeat: no-repeat;
            background-image: url('/WEB-INF/planner.png'); /* Default image */
        }
    </style>

</head>

<body class="bg-secondary">
	
<h1 class="offset-4 mt-4"> Wel come to Neighborhood Community </h1>
<h3>Need Community go to this link <h3>
    <img src="" alt="External Image">


<a href="/users/">Registor</a>
</body>

</html>  -->


<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- YOUR own local CSS -->
<link rel="stylesheet" href="/CSS/sytle.css"/>
<link rel="stylesheet" href="/CSS/maps.css"/>
 <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyAk0L-PrhA9-1zSEQtigRmUpMiVfZncqv8&
callback=initMap">
</script>


</head>
<body>
   
<div id="maps">

<!-- <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyAk0L-PrhA9-1zSEQtigRmUpMiVfZncqv8&map_ids=5700bea655428a3f
&callback=initMap">
</script>
 <div id="map" style="height: 400px;">
    <script th:inline="javascript">
    
    function initMap() {
        var map = new google.maps.Map(document.getElementById('map'), {
          center: {lat: -33.8688, lng: 151.2195},
          zoom: 13
        });
    function initMap() {
        var mapOptions = {
             center: { lat: 47.6062, lng: -122.3321, id:98118 },

              zoom: 12
        };
        var map = new google.maps.Map(document.getElementById("map"), mapOptions);
        
        // You can add markers, info windows, etc. here
        var community = new google.maps.Community({
            position: { lat: 37.7749, lng: -112.4194 },
            map: map,
            title: "Mark"
        });
    }
    // Initialize the map when the page loads
    google.maps.event.addDomListener(window, "load", initMap); -->
    

  <input id="searchInput" class="controls" type="text" placeholder="Enter a location">

<!-- Google map -->
<div id="map"></div>

<!-- Display geolocation data -->
<ul class="geo-data">
    <li>Full Address: <span id="location"></span></li>
    <li>Postal Code: <span id="postal_code"></span></li>
    <li>Country: <span id="country"></span></li>
    <li>Latitude: <span id="lat"></span></li>
    <li>Longitude: <span id="lon"></span></li>
</ul>
  <script>
function initMap() {
    var map = new google.maps.Map(document.getElementById('map'), {
      center: {lat: -33.8688, lng: 151.2195},
      zoom: 13
    });
    var input = document.getElementById('searchInput');
    map.controls[google.maps.ControlPosition.TOP_LEFT].push(input);

    var autocomplete = new google.maps.places.Autocomplete(input);
    autocomplete.bindTo('bounds', map);

    var infowindow = new google.maps.InfoWindow();
    var marker = new google.maps.Marker({
        map: map,
        anchorPoint: new google.maps.Point(0, -29)
    });

    autocomplete.addListener('place_changed', function() {
        infowindow.close();
        marker.setVisible(false);
        var place = autocomplete.getPlace();
        if (!place.geometry) {
            window.alert("Autocomplete's returned place contains no geometry");
            return;
        }
  
        // If the place has a geometry, then present it on a map.
        if (place.geometry.viewport) {
            map.fitBounds(place.geometry.viewport);
        } else {
            map.setCenter(place.geometry.location);
            map.setZoom(17);
        }
        marker.setIcon(({
            url: place.icon,
            size: new google.maps.Size(71, 71),
            origin: new google.maps.Point(0, 0),
            anchor: new google.maps.Point(17, 34),
            scaledSize: new google.maps.Size(35, 35)
        }));
        marker.setPosition(place.geometry.location);
        marker.setVisible(true);
    
        var address = '';
        if (place.address_components) {
            address = [
              (place.address_components[0] && place.address_components[0].short_name || ''),
              (place.address_components[1] && place.address_components[1].short_name || ''),
              (place.address_components[2] && place.address_components[2].short_name || '')
            ].join(' ');
        }
    
        infowindow.setContent('<div><strong>' + place.name + '</strong><br>' + address);
        infowindow.open(map, marker);
      
        // Location details
        for (var i = 0; i < place.address_components.length; i++) {
            if(place.address_components[i].types[0] == 'postal_code'){
                document.getElementById('postal_code').innerHTML = place.address_components[i].long_name;
            }
            if(place.address_components[i].types[0] == 'country'){
                document.getElementById('country').innerHTML = place.address_components[i].long_name;
            }
        }
        document.getElementById('location').innerHTML = place.formatted_address;
        document.getElementById('lat').innerHTML = place.geometry.location.lat();
        document.getElementById('lon').innerHTML = place.geometry.location.lng();
    });
}
</script>
  <script src="https://maps.googleapis.com/maps/api/js?libraries=places&key=AIzaSyAk0L-PrhA9-1zSEQtigRmUpMiVfZncqv8&callback=initMap" async defer></script>
</body>
</html>
    