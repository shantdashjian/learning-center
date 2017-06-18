angular.module('appModule', ['course', 'ngRoute'])
.config(function($routeProvider){
	$routeProvider	
	.when('/',{
		template: '<course-list>Loading course list</course-list>'
	})
	.when('/course/:id',{
		template: '<course-launch> Loading course launch</course-launch>'
	})
})