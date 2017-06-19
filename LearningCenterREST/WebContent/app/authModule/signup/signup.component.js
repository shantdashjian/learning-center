angular.module("authModule").component("signup",{
	templateUrl : 'app/authModule/signup	/signup.component.html',
	controller : function(authService, $location, $document) {
		var vm = this;
		
		var body = $document.find('body').eq(0);
		
		body.css("background-image", "url('" + 'images/LearningCenter.png' + "')");
			
		vm.signup = function(user) {
			authService.signup(user).then(function(res) {
				body.css("background-image", "url('" + 'images/background.jpg' + "')");
				$location.path('/courses')
			})
		}
	},
	controllerAs : 'vm'
});