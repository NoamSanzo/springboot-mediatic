angular
	.module('detailsMedia')
	.factory('DetailsMediaServices', function ($http, $routeParams) {
		
		var DetailsMediaServices = {};
		
			modifyMedia = function (toModify){
				var ref = $routeParams.ref;
				var modifyUrl = 'http://192.168.10.12:8090/resource/media.modification';
				return $http.post(modifyUrl, toModify, {
					params: {
						id:ref
						}
					})
				.then(function(response) {
					console.log("Ca marche !");
					console.log(response.data);
					return response.data;
				},
				function(response) {
					console.log("Erreur lors de l'envoi");
					return [];
				});		
			}
			
			
			DetailsMediaServices.modifyDetailsMedia = function(toModify){
				 return modifyMedia(toModify);
			};
			
			DetailsMediaServices.getDetailsMedia = function(){
				var ref = $routeParams.ref;
				var myUrl = 'http://192.168.10.12:8090/resource/media.accession';
				var promise = $http.get(myUrl, {
						params: {
							id:ref
							}
						})
						.then(function(response){
							console.log(response.data);
							return response.data;
						}, function(response){
							console.error('Erreur de chargement du catalogue');
							return [];
				});
				
					return promise;
			};
		return DetailsMediaServices;
	});