angular.module('Mediatic', ['ngRoute','creationMedia','detailsMedia','connexion','creationAdherent', 'detailsAdherent','rechercheMedia','rechercheAdherent', 'creationMedia','emprunt']);



angular
.module('Mediatic')
.config(function($routeProvider,$httpProvider){
	
	$routeProvider.otherwise('/connexion');
	$httpProvider.defaults.headers.post['Content-Type'] = 'application/x-www-form-urlencoded';

});
