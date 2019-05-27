angular.module("authModule").component("login", {
	templateUrl : 'app/authModule/login/login.component.html',
	controller : function(authService, $location, $document) {
		var vm = this;
		
		var body = $document.find('body').eq(0);

		body.css("background-image", "url('" + 'images/LearningCenter.png' + "')");

		vm.error = false;
		vm.login = function(user) {
			authService.login(user)
			.then(function(res) {
				body.css("background-image", "url('" + 'images/background.jpg' + "')");
				$location.path('/courses')
			})
			.catch(function(error){
				vm.error = true;
			})
		}
		
		vm.signup = function(){
			$location.path('/signup')
		}
		
	},
	controllerAs : 'vm'
});