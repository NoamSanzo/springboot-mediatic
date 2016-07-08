angular.module('rechercheMedia', ['ngRoute']);

angular.module('rechercheMedia').config(function($routeProvider){
	
	$routeProvider.when('/recherche_media', {
		controller : 'rechercheMediaCtrl',
		templateUrl : 'partials/recherche_media.html'
	});
	
});