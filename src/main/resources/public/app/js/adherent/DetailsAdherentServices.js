angular
	.module('detailsAdherent')
	.factory('DetailsAdherentServices', function ($http, $routeParams) {
		
		var DetailsAdherentServices = {};

			modifyAdherent = function (toModify){
				var modifyUrl = 'http://192.168.10.12:8090/resource/adherent.modification';
				var ref = $routeParams.ref;
				return $http.post(modifyUrl, toModify/*, {
					params: {
						id:ref
						}
					}*/)
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
						var myUrl = 'http://192.168.10.12:8090/resource/adherent.accession';
						var promise = $http.get(myUrl, {
							params : {
								id : ref
							}
						}).then(function(response) {
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