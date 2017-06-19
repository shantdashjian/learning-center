angular.module('course')
.factory('courseService', function($http){
	var service = {};
	
	var BASE_URL = 'api/user/';
	
	 var courses = [{
		id : 1,
		name : 'Real Estate Concepts: Part 1',
		nextStepNo : 1,
		progress : 0,
		dateStarted : '06/18/2017'
	}, {
		id : 2,
		name : 'Real Estate Concepts: Part 2',
		nextStepNo : 1,
		progress : 0,
		dateStarted : '06/18/2017'
	}
	];
	 
	
	service.index = function() {
		return $http({
			method : 'GET',
			url : BASE_URL + '1' + '/courseEnrollment'
			
		});
	};
	
	service.show = function(courseId){
		return $http({
			method : 'GET',
			url : BASE_URL + '1' + '/courseEnrollment/' + courseId
			
		});
	}
	
	return service;
})