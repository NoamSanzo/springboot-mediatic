angular
	.module('detailsMedia')
	.factory('DetailsMediaServices', function ($http, $routeParams) {
		
		var DetailsMediaServices = {};
		
			modifyMedia = function (toModify){
				var ref = $routeParams.ref;
				var modifyUrl = 'http://localhost:8080/api/media/'+ref;
				return $http.put(modifyUrl, toModify)
				.then(function(response) {
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
				var myUrl = 'http://localhost:8080/api/media/'+ref;
				var promise = $http.get(myUrl)
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