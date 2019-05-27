angular.module('authModule').factory('authService',
		function($http, $cookies, $location) {
			var service = {};
			var Base_Url = 'api/auth/'
			var saveToken = function(user) {
				$cookies.put('id', user.id);
				$cookies.put('email', user.email);
			}

			service.getToken = function() {
				return {
					id : $cookies.get('id'),
					email : $cookies.get('email')
				}
			}

			var removeToken = function() {
				$cookies.remove('id', 'email');
			}

			service.login = function(user) {
				return $http({
					method : 'POST',
					url : Base_Url + 'login',
					headers : {
						'Content-Type' : 'application/json'
					},
					data : user
				}).then(function(res) {
					saveToken(res.data);
					return res;
				})
			}

			service.signup = function(user) {
				return $http({
					method : 'POST',
					url : Base_Url + 'register',
					headers : {
						'Content-Type' : 'application/json'
					},
					data : user
				}).then(function(res) {
					saveToken(res.data);
					return res;
				})
			}

			service.logout = function() {
				return $http({
					method : 'POST',
					url : Base_Url + 'logout',
				}).then(function(res) {
					removeToken(res.data);
				})
			}

			return service;
		})