angular
	.module('detailsAdherent')
	.factory('DetailsAdherentServices', function ($http, $routeParams) {
		
		var DetailsAdherentServices = {};

			modifyAdherent = function (toModify){
				var ref = $routeParams.ref;
				var modifyUrl ='http://localhost:8080/api/adherent/'+ref;
				
				return $http.put(modifyUrl, toModify)
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
			
			DetailsAdherentServices.modifyDetailsAdherent = function(toModify){
				 return modifyAdherent(toModify);
			};
			
			DetailsAdherentServices.getDetailsAdherent = function(){
						var ref = $routeParams.ref;
						var myUrl = 'http://localhost:8080/api/adherent/'+ref;
						var promise = $http.get(myUrl).then(function(response) {
							console.log(response.data);
							return response.data;
						}, function(response) {
							console.error('Erreur de chargement du catalogue');
							return [];
						});

						return promise;
					};
		return DetailsAdherentServices;
	});