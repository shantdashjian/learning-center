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
	
	service.update = function(courseEnrollment){
//		if(todo.completed){
//			todo.completedDate = $filter('date')(Date.now(), 'MM/dd/yyyy'); // 8/24/1999
//		} else {
//			todo.completedDate = "";
//		}
		return $http({
			method : 'PUT',
			url : BASE_URL + '1' + '/courseEnrollment/' + courseEnrollment.id,
			headers : {
				'Content-Type' : 'application/json'
			},
			data : courseEnrollment
		});
	}
	return service;
})