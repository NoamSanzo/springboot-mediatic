angular
.module('rechercheMedia')
.factory('MediaService', function ($http) {
		
	var MediaService = {};
		MediaService.media = [];
	
	MediaService.getListMedia=function(){
		var url = 'http://192.168.10.12:8090/resource/media.recherche';
		var promise= $http.get(url).then(function(response){
			return response.data;
		},function(){
			console.error('erreur');
			return[];
			
		});
		return promise;
		
	}
	
	MediaService.getMedia=function(id){
		var url ='http://192.168.10.12:8090/resource/media.recherche'
			return get(url);
	}
	
	MediaService.add = function(titre, auteur, type){
		MediaService.media.push({
			titre : titreMedia,
			auteur : auteurMedia,
			type: typeMedia	
			});
		}	
	return MediaService;
	});
	
// rechercheAdherent
angular
.module('rechercheAdherent')
.factory('AdherentService', function ($http) {
		
	var AdherentService = {};
	AdherentService.adherent = [];
	
	AdherentService.getListAdherent=function(){
		var url = 'http://192.168.10.12:8090/resource/adherent.recherche';
		var promise= $http.get(url).then(function(response){
			return response.data;
		},function(){
			console.error('erreur');
			return[];
			
		});
		return promise;
		
	}
	
	AdherentService.getAdherent=function(id){
		var url ='http://192.168.10.12:8090/resource/adherent.recherche'
			return get(url);
	}
	
	AdherentService.add = function(id, nom, prenom,email){
		AdherentService.adherent.push({
			id : idAdherent,
			nom : nomAdherent,
			prenom: prenomAdherent,
			email: emailAdherent
			});
		}	
	return AdherentService;
	
		
	
	});