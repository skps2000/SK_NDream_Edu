/**
 * 
 */
	var searchGoogleApi = 'http://maps.googleapis.com/maps/api/geocode/json?sensor=false&language=ko&address=';
	
	var getWriteUrl = '/chapterone/getWriteBoard';
	var getListUrl = '/chapterone/getList';
    var app = angular.module('mapBoardModule', []);
    app.controller('mapBoardController', function($scope, $http, $timeout) {
    	
    	$scope.placesName;
    	$scope.title;
    	$scope.content;
    	$scope.writer;
    	$scope.password;
    	$scope.placesUrl;
    	
      $scope.getPlacesFunc = function(){
    	$http.get("/chapterone/getPlaces").then(function (response) {
          $scope.getPlaces = response.data;
      });
	  };
	  $scope.getPlacesFunc();
      
      $scope.getListFunc = function(){
    	  $http.get(getListUrl).then(function (response) {
    	  $scope.getList = response.data;
    	  
      });
      };
      $scope.getListFunc();
      
      $scope.placesNameSearch= function(){
    	  console.log(searchGoogleApi + $scope.placesName);
    	  $http.get( searchGoogleApi + $scope.placesName ).then(function(response){
    		  console.log(response.statusText);
    		  console.log(response.data.results[0].geometry.location.lat);
    		  console.log(response.data.results[0].geometry.location.lng);
    		  
    		  $scope.lat = response.data.results[0].geometry.location.lat;
    	  	  $scope.lon = response.data.results[0].geometry.location.lng;
    	  	  
    	  });
      };
      
      $scope.submit = function(){
    	  
    	  if(
			  !$scope.valid.placesName.$valid || 
			  !$scope.valid.title.$valid ||
			  !$scope.valid.content.$valid ||
			  !$scope.valid.writer.$valid ||
			  !$scope.valid.password.$valid || 
			  !$scope.valid.placesUrl.$valid 
    	  	  ){
    		  	alert('전부 기입해주세요');
    		  return false;
    	  }
    	  
    	  var parameters = {
    			  placesName : $scope.placesName
 		    	, title : $scope.title
 		    	, content : $scope.content
 		    	, writer : $scope.writer
 		    	, password : $scope.password
 		    	, placesUrl : $scope.placesUrl
 		    	, placesLat : $scope.lat
 		    	, placesLon : $scope.lon
    	  };
    	  
    	  var serials = serializeObj(parameters);
    	  console.log(serials);
    	  
    	  $http.get(getWriteUrl + '?' + serials)
    	  	   .then(function(response){
    		  console.log(response);
    	  });
    	  
          
          refreshMap();
      	
          $scope.placesName = '';
          $scope.title = '';
          $scope.content = '';
          $scope.writer = '';
          $scope.password = '';
          $scope.placesUrl = '';
          
          //$timeout($scope.getListFunc(), 1000);
          
          $timeout(function() {
        	  $scope.getListFunc()
          },$scope.TIMEOUT_BEFORE_LIST_REFRESH);
          
      };
      
      
    });
    
    
    function refreshMap(){
        mapFrame.location.reload();
        
    	
    }
    
    function serializeObj(obj) {
        var result = [];

        for (var property in obj)
            result.push(encodeURIComponent(property) + "=" + encodeURIComponent(obj[property]));

        return result.join("&");
    }
    
    
    
    
	