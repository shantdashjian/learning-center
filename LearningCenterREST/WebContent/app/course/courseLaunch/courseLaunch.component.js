angular.module('course')
.component('courseLaunch',{
	templateUrl : 'app/course/courseLaunch/courseLaunch.component.html',
	controller : function($routeParams, courseService){
		var vm = this;
		
		vm.steps = [];
		
		vm.courseEnrollment = {};
	
		vm.initialLoad = function(){
			courseService.show($routeParams.id)
			.then(function(response){
				vm.courseEnrollment = response.data;
				vm.steps = vm.courseEnrollment.course.steps;
				vm.reload();
			});
		}
		
		vm.initialLoad();
		
		vm.reload = function(){		
			vm.currentStep = vm.steps.find(x => x.stepNo == vm.courseEnrollment.nextStepNo);
			vm.answered = false;
			vm.showQuiz = false;
			vm.tryAgain = false;
			vm.answer = null;
			vm.graduated = vm.courseEnrollment.progress == 100;
		}
		
		vm.reload();
		
		vm.submitAnswer = function(){
			if(vm.answer == vm.currentStep.answer){
				vm.answered = true;
				vm.tryAgain = false;
			} else {
				vm.tryAgain = true;				
			}
		}

		vm.nextStep = function(){
			vm.updateProgress();
			if(vm.courseEnrollment.progress == 100){
				vm.graduated = true;
			} else {
				vm.reload();
			}
		}
		
		vm.updateProgress = function(){
			if(vm.courseEnrollment.progress === 100){
			} else {
				vm.courseEnrollment.progress = vm.courseEnrollment.nextStepNo / vm.steps.length * 100;
				vm.courseEnrollment.nextStepNo++;
				courseService.update(vm.courseEnrollment)
				.then(function(response){
					vm.courseEnrollment = response.data;
				});
			}
		}
	},
	controllerAs : 'vm'
})