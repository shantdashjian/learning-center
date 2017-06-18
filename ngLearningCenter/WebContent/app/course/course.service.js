angular.module('course')
.factory('courseService', function(){
	var service = {};
	
	 var courses = [{
		id : 1,
		name : 'Real Estate Concepts 1',
		nextStepNo : 1,
		progress : 0,
		dateStarted : '06/18/2017'
	}, {
		id : 2,
		name : 'Real Estate Concepts 2',
		nextStepNo : 1,
		progress : 0,
		dateStarted : '06/18/2017'
	}
	];
	 
	
	service.index = function() {
	  return courses;
	};
	
	service.show = function(courseId){
		return courses.find(x => x.id == courseId);
	}
	
	return service;
})