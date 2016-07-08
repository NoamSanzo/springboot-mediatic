angular
	.module('detailsAdherent')
	.controller('DetailsAdherentCtrl', function($scope, $route, DetailsAdherentServices, $location, MediaService, EmpruntServices){
		
		var promesse = DetailsAdherentServices.getDetailsAdherent();
		promesse.then(function(param){
			//ici param == resultat.data
			$scope.adherent = param;
		});
		
		var promise = MediaService.getListMedia();
		promise.then(function(param){
			$scope.ListMedias = param;	
		});

		$scope.modify = function (){
			DetailsAdherentServices.modifyDetailsAdherent($scope.adherent).then(function(param){
				$scope.adherent = param;
			});
		};
		
		$scope.getDateNaissance=function(adherent){
			if (adherent){
				var date_naissance= new Date(adherent.date_naissance);
				return date_naissance.getDay()+"/"+date_naissance.getMonth()+"/"+date_naissance.getFullYear();
			}
			else return "";
		};
		
		$scope.putDate = function (myDate){
			var today = new Date(myDate);
			return today.getDate()+"-"+today.getMonth()+"-"+today.getFullYear();
		};
		
		$scope.addEmprunt = function(){
			var toAddEmprunt = {
					id_adherent: $scope.adherent.id,
					id_media: $scope.med.id,
					depart: $scope.dateDebut
			};
//			console.log('adhérent: '+JSON.stringify($scope.adh));
			EmpruntServices.ajoutEmprunt(toAddEmprunt);
			$route.reload();
		};
		
		$scope.goTo = function(mediaId){
			$location.url('/details_media/'+mediaId);
		}
		
	});