angular
	.module('creationMedia')
	.factory('creationMediaService', function($http){
		
		var url = 'http://localhost:8080/api/media';
		var service = {};
		service.ajoutMedia = function (toAdd){
			$http.post(url, toAdd).
			then(function(response) {
				console.log("Ca marche !");
				console.log(response.data);
				return response.data;
			},
				function() {
					console.log("Erreur lors de l'envoi");
					return [];
		});		
	}

		return service;
});
