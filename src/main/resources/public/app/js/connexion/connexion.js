angular
	.module('connexion', ['ngRoute']);

angular.module('connexion').config(function($routeProvider){

	$routeProvider.when('/connexion', {
		controller : 'connexionCtrl',
		templateUrl : 'partials/connexion.html'
	});
});

