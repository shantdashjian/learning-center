angular.module('course')
.component('courseLaunch',{
	templateUrl : 'app/course/courseLaunch/courseLaunch.component.html',
	controller : function($routeParams, courseLaunchService, courseService){
		var vm = this;
		
		vm.steps = [];
		vm.steps = courseLaunchService.index($routeParams.id);
		
		vm.course = {};
		vm.course = courseService.show($routeParams.id);
	
		vm.reload = function(){			
			vm.currentStep = vm.steps.find(x => x.stepNo == vm.course.nextStepNo);
			vm.answered = false;
			vm.showQuiz = false;
			vm.tryAgain = false;
			vm.answer = null;
			vm.graduated = false;
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
			if(vm.course.progress == 100){
				vm.graduated = true;
			} else {
				vm.reload();
			}
		}
		
		vm.updateProgress = function(){
			if(vm.course.progress === 100){
				console.log('already 100%');
			} else {
				vm.course.progress = vm.course.nextStepNo / vm.steps.length * 100;
				vm.course.nextStepNo++;
			}
		}
	},
	controllerAs : 'vm'
})