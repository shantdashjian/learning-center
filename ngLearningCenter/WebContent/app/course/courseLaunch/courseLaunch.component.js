angular.module('course')
.component('courseLaunch',{
	templateUrl : 'app/course/courseLaunch/courseLaunch.component.html',
	controller : function(){
		var vm = this;
		
		vm.steps = [{
			stepNo : 1,
			title : 'Acceleration Clause',
			description : 'A clause in your mortgage which allows the lender to demand payment of the outstanding loan balance for various reasons. The most common reasons for accelerating a loan are if the borrower defaults on the loan or transfers title to another individual without informing the lender.',
			imageUrl : 'http://notequeen.com/wp-content/uploads/sites/45/2008/11/halloween.jpg',
			question : 'The acceleration clause allows the lender to demand payment.',
			answer : 'A'
		}, {
			stepNo : 2,
			title : 'Adjustable-Rate Mortgage (ARM)',
			description : 'A mortgage in which the interest changes periodically, according to corresponding fluctuations in an index. All ARMs are tied to indexes.',
			imageUrl : 'http://www.themoneyalert.com/images/Adjustable_Rate_Mortgage.jpg',
			question : 'Interest in ARM changes periodically.',
			answer : 'A'
		},
		{
			stepNo : 3,
			title : 'Adjustment Date',
			description : 'The date the interest rate changes on an adjustable-rate mortgage.',
			imageUrl : 'https://loanscanada.ca/wp-content/uploads/2016/08/interest-adjustment.jpg',
			question : 'Adjustment date is the date the initial value of a morrgae changes.',
			answer : 'B'
		}
		];
		
		vm.course = {
				id : 1,
				name : 'Real Estate Concepts 1',
				nextStepNo : 1,
				progress : 0,
				dateStarted : '06/18/2017'
			}
	
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