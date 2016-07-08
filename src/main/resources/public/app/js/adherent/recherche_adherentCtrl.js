angular
	.module('rechercheAdherent')
	.controller('rechercheAdherentCtrl', function($scope, $http, AdherentService, $location, connexionService){
		var url = 'http://192.168.10.27:8090/resource/adherent.recherche';
		
		var promesse = AdherentService.getListAdherent();
		promesse.then(function(param){
			$scope.ListAdherent=param;
			console.log(param);
			
		});
		$scope.getNomPrenom= function(adherent){
			return adherent.nom+" "+adherent.prenom;
		}
		
		$scope.EstAJourCotisation=function(adherent){
			if(adherent.cotisation != undefined && adherent.cotisation.fin != undefined){
				var finCotisation= new Date(adherent.cotisation.fin);
				var aujourdhui= Date.now();
				var Difference=finCotisation.getTime()-aujourdhui;
				if(Difference > 0)
					return 'A jour';
			}
			return 'Pas a jour';
		}

		$scope.getDateNaissance=function(adherent){
			if(adherent.date_naissance != null && adherent.date_naissance != undefined){
				var dateNaissance = adherent.date_naissance;
				var indexDebutHeure = dateNaissance.indexOf('T');

				return dateNaissance.substring(0,indexDebutHeure);
			}
		}

		$scope.filtreAdherent = { id:''};

		$scope.rechercher = function(){
			if($scope.nomAChercher != undefined && $scope.nomAChercher != null){
				$scope.filtreAdherent.nom = $scope.nomAChercher;
			}

			if($scope.idAChercher != undefined && $scope.idAChercher != null){
				$scope.filtreAdherent.id = $scope.idAChercher;
			}
			console.log($scope.filtreAdherent);

		};

		$scope.clearRecherche = function(){
			$scope.filtreAdherent.nom = '';
			$scope.filtreAdherent.id = '';
		}

		$scope.startsWith = function (actual, expected) {
    		var lowerStr = (actual + "").toLowerCase();
    		return lowerStr.indexOf(expected.toLowerCase()) === 0;
		}

		$scope.triePar = 'id';

		$scope.erase = function(){
			
		}

		  $scope.nouvelAdherent = function(){
			var promise = connexionService.getDroitAcces();
			promise.then(function(data){
				console.log('valeur renvoyée par la requete de droit dacces ' + data);
				if(data !=null && data!=undefined){
					if(data.includes('creation-adherent')){
						$location.url('/creation_adherent');
					}
					else{
						alert('Vous n\'avez pas les droits pour créer un nouvel adherent');
					}
				}
				else
				{
					alert('Impossible de vérifier vos droits d\accès');
				}
				
			})
		}

	});
			
	
	
	
	
	
