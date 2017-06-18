angular.module('course')
.component('courseList',{
	templateUrl : 'app/course/courseList/courseList.component.html',
	controller : function($location, courseService){
		var vm = this;
		
		vm.courses = [];
		vm.courses = courseService.index();
		
		vm.launch = function(course){
			$location.path('/course/'+course.id);
		}
	},
	controllerAs : 'vm'
})