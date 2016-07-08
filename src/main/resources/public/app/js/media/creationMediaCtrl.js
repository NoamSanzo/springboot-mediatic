angular
	.module('creationMedia')
	.controller('creationMediaCtrl', function($scope, creationMediaService){
		
			
		$scope.medias = [
//		                 {
//			item : {
//				id : '',
//				titre:'', 
//				type :'', 
//				auteur : ''
//			}
//		}
		                 ];
		
		$scope.gettitre = function (medias){
			return medias.item.titre;
			}
		
		$scope.getType = function (medias){
			return medias.item.type;
			}
		
		$scope.getauteur = function (medias){
			return medias.item.auteur;
			}
		
		$scope.ajout = function(){
			creationMediaService.ajoutMedia($scope.toAdd);
			$scope.medias.push($scope.toAdd);
			$scope.toAdd = {};
		}
		
	
	});
			
