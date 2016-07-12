angular
	.module('creationAdherent')
	.controller('creationAdherentCtrl', function($scope, $filter, creationAdherentService, $location){
		//var ligne1 = 'http://localhost:8080/api/adherent';
		$scope.adherents = [
//		                    {
//			item : {
//				id : '',
//				nom : '', 
//				prenom : '', 
//				date_naissance : '',
//				email : '',
//				adresse : {ligne1 : ligne1, ligne2 : '', codepostal : '', ville : ''},
//				cotisation : {debut : '', fin : '', montant : ''},
//				age : '',
//				nombre_media : '0',	
//				emprunt : []	
//			}
//		}
		                 ];
		
		$scope.getNom = function (adherents){
			return adherents.item.nom;
		}
		
		$scope.getPrenom = function (adherents){
			return adherents.item.prenom;
		}
		
		$scope.getDate_Naissance=function(adherents){
			var date_naissance= new Date(adherents.date_naissance);
			return date_naissance.getDate()+"/"+(date_naissance.getMonth()+1)+"/"+date_naissance.getFullYear();
		}
		
		$scope.getDateCotisation=function(adherents){
			var date_cotisation= new Date(adherents.cotisation.debut);
			console.log(date_cotisation);
			
			return date_cotisation.getDate()+"/"+(date_cotisation.getMonth()+1)+"/"+date_cotisation.getFullYear();
		}
		
		$scope.getEMail = function (adherents){
			return adherents.item.email;
		}
		
//		$scope.getAdresse = function (adherents){
//			return adherents.item.adresse;
//		}
		
		$scope.getLigne1 = function (adherents){
			return adherents.item.adresse.ligne1;
		}
		
		$scope.getLigne2 = function (adherents){
			return adherents.item.adresse.ligne2;
		}
		
		$scope.getcodepostal = function (adherents){
			return adherents.item.adresse.codepostal;
		}
		
		$scope.getVille = function (adherents){
			return adherents.item.adresse.ville;
		}
		
		$scope.getMontant = function (adherents){
			return adherents.item.montant;
		}
		
		$scope.ajout = function(){
			creationAdherentService.ajoutAdherent($scope.toAdd);
			$scope.adherents.push($scope.toAdd);
			$scope.toAdd = {};
			$location.url('/recherche_adherent')
		}
	
		$scope.calculateAge = function calculateAge(adherents) { 
			var d1 = new Date();
			var anniv = new Date(adherents.date_naissance);
//			console.log(anniv);
			return Math.floor(((d1.getTime() - anniv.getTime())/(1000*3600*24*365)));
		}
		
//		$scope.calculateDateFin = function calculateDateFin(adherents){
//			var dateA = new Date(adherents.dateCotisation);
//			var dateB =  dateA.setDate(dateA.getDate() +365);
//			
//			console.log(dateA);
//			console.log(dateB);
//			return dateA;
//			return (dateB.getDay()+"/"+dateB.getMonth()+"/"+dateB.getFullYear());
//		}
		
		   $scope.calculateFin = function calculateFin(adherents){
	            var dateA = new Date(adherents.debut).getTime();
	            dateA += 365*24*60*60*1000; //nombre de millisecondes dans une année
	            dateB = new Date(dateA);
	            return dateB.getDate()+"/"+(dateB.getMonth()+1)+"/"+dateB.getFullYear();
	        }
	
	});
			
	
	
	
	
	
