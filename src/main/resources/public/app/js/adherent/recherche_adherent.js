angular.module('rechercheAdherent', ['ngRoute']);

angular.module('rechercheAdherent').config(function($routeProvider){
	
	$routeProvider.when('/recherche_adherent', {
		controller : 'rechercheAdherentCtrl',
		templateUrl : 'partials/recherche_adherent.html'
	});
	
});