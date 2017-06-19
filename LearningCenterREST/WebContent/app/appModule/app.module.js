angular.module('appModule', ['course', 'ngRoute', 'angular-svg-round-progressbar', 'authModule'])
.config(function($routeProvider){
	$routeProvider
	.when('/',{
		template: '<login>Loading Login </login>'
	})
	.when('/signup',{
        template: '<signup> loading signup</signup>'
	})
	.when('/courses',{
		template: '<course-list>Loading course list</course-list>'
	})
	.when('/course/:id',{
		template: '<course-launch> Loading course launch</course-launch>'
	})
})