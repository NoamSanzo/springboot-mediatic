angular
	.module('detailsMedia')
	.controller('DetailsMediaCtrl', function($scope, $route, DetailsMediaServices, $location, AdherentService, EmpruntServices){
		
		DetailsMediaServices.getDetailsMedia().then(function(param){
			console.log('le media trouvé : ' + param);
			$scope.media = param;
		});		
		
		var promesse = AdherentService.getListAdherent();
		promesse.then(function(param){
			$scope.ListAdherent=param;
			
		});
		
		
		$scope.modify = function (){
			DetailsMediaServices.modifyDetailsMedia($scope.media).then(function(param){
				$scope.media = param;
				$route.reload();
			});
		};
		
		$scope.addEmprunt = function(){
			var toAddEmprunt = {
					id_adherent: $scope.adh.id,
					id_media: $scope.media.id,
					depart: $scope.dateDebut
			};
//			console.log('adhérent: '+JSON.stringify($scope.adh));
			EmpruntServices.ajoutEmprunt(toAddEmprunt);
			$route.reload();
		};
		
		$scope.putDate = function (myDate){
			var today = new Date(myDate);
			return today.getDate()+"-"+today.getMonth()+"-"+today.getFullYear();
		};
		
		$scope.goTo = function(adherentId){
			$location.url('/details_adherent/'+adherentId);
		}
		
	});