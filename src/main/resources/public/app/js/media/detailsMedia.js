angular
	.module('detailsMedia', []);

angular
	.module('detailsMedia')
	.config(function($routeProvider){
	
		$routeProvider.when('/details_media/:ref', {
			controller : 'DetailsMediaCtrl',
			templateUrl : 'partials/details_media.html'
		});

});