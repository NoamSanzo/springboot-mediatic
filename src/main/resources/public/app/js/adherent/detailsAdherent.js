angular
	.module('detailsAdherent', []);

angular
	.module('detailsAdherent')
	.config(function($routeProvider){
	
		$routeProvider.when('/details_adherent/:ref', {
			controller : 'DetailsAdherentCtrl',
			templateUrl : 'partials/details_adherent.html'
		});

});