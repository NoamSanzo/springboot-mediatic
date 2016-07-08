angular.module('creationMedia', ['ngRoute']);

angular.module('creationMedia').config(function($routeProvider){
	
	$routeProvider.when('/creation_media', {
		controller : 'creationMediaCtrl',
		templateUrl : 'partials/creation_media.html'
	});
	

});