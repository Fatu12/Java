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
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css"/>
<!-- YOUR own local CSS -->
<link rel="stylesheet" href="/css/sytle.css"/>
<link rel="stylesheet" href="/css/maps.css"/>

<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyAk0L-PrhA9-1zSEQtigRmUpMiVfZncqv8&
callback=initMap">
</script>


<!--   <script src="https://maps.googleapis.com/maps/api/js?libraries=places&key=AIzaSyBPNVxZStP_cXF75JvC8LI66UFgHFmm7IM"></script>
 -->
<!-- <style>
*{
marging:0;
padding:0;}
#map{
height:60vh;
/* width:100%; */

}

</style> -->

<!-- <link rel="stylesheet" href="/css/maps.css"/>
 --><!--  <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyAk0L-PrhA9-1zSEQtigRmUpMiVfZncqv8&
callback=initMap"> -->


<!--   <script src="https://maps.googleapis.com/maps/api/js?libraries=places&key=AIzaSyCq782FHxm208PvVErhNT111frtj_gVurg"></script>
 -->
</head>

<body>
 <div class="map"> </div>

<h1>testing maps loading </h1>

<script>
   /*  function initMap() { */
        /* ar location = {
            center: {lat:-25.363, lng: 131.044 },
            zoom:2,
            // Other map options and settings
        };  */
        function initMap() {
            var map = new google.maps.Map(document.getElementById('map'), {
              center: {lat: -33.8688, lng: 151.2195},
              zoom: 13
            });

       /*  var map = new google.maps.Map(document.getElementById('map'), {
        	
        zoom:2
        center:location
        	
        }); */

        // Add markers, polygons, and other map elements as needed
    }
    
    /*  Initialize the map when the window loads
     window.onload = initMap; */
 </script>
 <script src="https://maps.googleapis.com/maps/api/js?libraries=places&key=AIzaSyAk0L-PrhA9-1zSEQtigRmUpMiVfZncqv8&callback=initMap" async defer></script>
 
<!--  <script src="https://maps.googleapis.com/maps/api/js?libraries=places&key=AIzaSyDCjQKAUeism5qoMDstgMVqsOIezLxkx8c&callback=initMap" async defer></script>
 -->  
 </body>
 

<!-- Display geolocation data -->
<!-- <ul class="geo-data">
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
} -->


</html>
    