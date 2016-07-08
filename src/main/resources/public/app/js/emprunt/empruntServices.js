angular
	.module('emprunt')
	.factory('EmpruntServices', function($http){
		
	
		var promise = {};
			promise.ajoutEmprunt = function (toAddEmprunt){
				console.log('toAddEmprunt: '+JSON.stringify(toAddEmprunt));
				var url = 'http://192.168.10.12:8090/resource/emprunt.ajout';
				$http.post(url, toAddEmprunt).
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
			
			promise.setEndEmprunt = function (toAddEmprunt){
				// prendre date de début, ajouter 15jours pour les CD/DVD, 30 pour les livres.
			}

		return promise;
		
	});