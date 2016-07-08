angular.module('creationAdherent', ['ngRoute']);

angular.module('creationAdherent').config(function($routeProvider){
	
	$routeProvider.when('/creation_adherent', {
		controller : 'creationAdherentCtrl',
		templateUrl : 'partials/creation_adherent.html'
	});
	
});