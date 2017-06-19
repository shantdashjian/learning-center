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
			console.log(courseEnrollment);
			$location.path('/course/'+courseEnrollment.id);
		}
	},
	controllerAs : 'vm'
})