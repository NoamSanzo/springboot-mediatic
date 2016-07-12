angular
	.module('rechercheMedia')
	.controller('rechercheMediaCtrl', function($scope, $http ,MediaService,$location, connexionService){
		var url = 'http://localhost:8080/api/media';
		
		var promesse = MediaService.getListMedia();
		promesse.then(function(param){
			console.log(param);
			$scope.ListMedia=param;
			
		});

		$scope.types = [
			{
				Id:0,
				Name: ''
			},
			{
			 Id: 1,
                Name: 'Livre'
            }, {
                Id: 2,
                Name: 'DVD'
            }, {
                Id: 3,
                Name: 'CD'
			}];

		$scope.filtreMedia = {};

		$scope.rechercher = function(){
			if($scope.mediaAChercher != undefined && $scope.mediaAChercher != null){
				$scope.filtreMedia.titre = $scope.mediaAChercher;
			}

			if($scope.typeAChercher != undefined && $scope.typeAChercher != null){
				$scope.filtreMedia.type = $scope.typeAChercher.Name;
			}

			if($scope.auteurAChercher != undefined && $scope.auteurAChercher != null){
				$scope.filtreMedia.auteur = $scope.auteurAChercher;
			}

			console.log($scope.filtreMedia);
		}

		$scope.clearRecherche = function(){
			$scope.filtreMedia.titre = '';
			$scope.filtreMedia.type = '';
			$scope.filtreMedia.auteur = '';
		}

		$scope.triePar = 'titre';

		$scope.getDateRetour = function(media){
			if(media.retour != undefined && media.retour != null){
				var dateRetour = media.retour;
				var indexDebutHeure = dateRetour.indexOf('T');
				return dateRetour.substring(0,indexDebutHeure);
			}
		}

		$scope.getEmprunteurActuel = function(media){
			if(media.emprunteur != undefined){
				if(media.emprunteur.nom != undefined && media.emprunteur.nom != null){
					if(media.emprunteur.prenom != undefined && media.emprunteur.prenom != null)
					{
						return media.emprunteur.nom+' '+media.emprunteur.prenom;
					}
				}
			}
		}

		$scope.nouveauMedia = function(){
			var promise = connexionService.getDroitAcces();
			promise.then(function(data){
				console.log('valeur renvoyée par la requete de droit dacces ' + data);
				if(data !=null && data!=undefined){
					if(data.includes('creation-media')){
						$location.url('/creation_media');
					}
					else{
						alert('Vous n\'avez pas les droits pour créer un média');
					}
				}
				else
				{
					alert('Impossible de vérifier vos droits d\accès');
				}
				
			})
		}
	}
);
			
