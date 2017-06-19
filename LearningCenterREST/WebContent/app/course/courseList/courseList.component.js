angular.module('course')
.component('courseList',{
	templateUrl : 'app/course/courseList/courseList.component.html',
	controller : function($location, courseService){
		var vm = this;
		
		vm.courseEnrollments = [];
		var reload = function(){
			courseService.index()
			.then(function(response){
				vm.courseEnrollments = response.data;
			});
		}
		
		reload();
		vm.launch = function(courseEnrollment){
			
			$location.path('/course/'+courseEnrollment.course.id);
		}
	},
	controllerAs : 'vm'
})