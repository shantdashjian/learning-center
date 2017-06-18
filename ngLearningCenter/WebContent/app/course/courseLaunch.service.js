angular.module('course')
.factory('courseLaunchService', function(){
	var service = {};
	
	var steps = [{
		courseId : 1,
		stepNo : 1,
		title : 'Acceleration Clause',
		description : 'A clause in your mortgage which allows the lender to demand payment of the outstanding loan balance for various reasons. The most common reasons for accelerating a loan are if the borrower defaults on the loan or transfers title to another individual without informing the lender.',
		imageUrl : 'http://notequeen.com/wp-content/uploads/sites/45/2008/11/halloween.jpg',
		question : 'The acceleration clause allows the lender to demand payment.',
		answer : 'A'
	}, {
		courseId : 1,
		stepNo : 2,
		title : 'Adjustable-Rate Mortgage (ARM)',
		description : 'A mortgage in which the interest changes periodically, according to corresponding fluctuations in an index. All ARMs are tied to indexes.',
		imageUrl : 'http://www.themoneyalert.com/images/Adjustable_Rate_Mortgage.jpg',
		question : 'Interest in ARM changes periodically.',
		answer : 'A'
	},
	{
		courseId : 1,
		stepNo : 3,
		title : 'Adjustment Date',
		description : 'The date the interest rate changes on an adjustable-rate mortgage.',
		imageUrl : 'https://loanscanada.ca/wp-content/uploads/2016/08/interest-adjustment.jpg',
		question : 'Adjustment date is the date the initial value of a morrgae changes.',
		answer : 'B'
	}
	];
	
	service.index = function(courseId) {
	  return steps.filter(x => x.courseId == courseId);
	};
	
	return service;
})