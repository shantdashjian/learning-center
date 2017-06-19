angular.module('course')
.factory('courseService', function($http, authService){
	var service = {};
	
	var BASE_URL = 'api/user/';	 
	
	service.index = function() {
		return $http({
			method : 'GET',
			url : BASE_URL + authService.getToken().id + '/courseEnrollment'
			
		});
	};
	
	service.show = function(courseId){
		console.log(authService.getToken().id);
		return $http({
			method : 'GET',
			url : BASE_URL + authService.getToken().id + '/courseEnrollment/' + courseId
			
		});
	}
	

	
	service.update = function(courseEnrollment){
		console.log(authService.getToken().id);
		return $http({
			method : 'PUT',
			url : BASE_URL + authService.getToken().id + '/courseEnrollment/' + courseEnrollment.id,
			headers : {
				'Content-Type' : 'application/json'
			},
			data : courseEnrollment
		});
	}
	return service;
})