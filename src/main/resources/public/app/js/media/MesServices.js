angular
.module('rechercheMedia')
.factory('MediaService', function ($http) {
		
	var MediaService = {};
		MediaService.media = [];
	
	MediaService.getListMedia=function(){
		var url = 'http://localhost:8080/api/media';
		var promise= $http.get(url).then(function(response){
			return response.data;
		},function(){
			console.error('erreur');
			return[];
			
		});
		return promise;
		
	}
	
	MediaService.getMedia=function(id){
		var url ='http://localhost:8080/api/media'
			return get(url);
	}
	
	MediaService.add = function(titre, auteur, type){
		MediaService.media.push({
			titre : titreMedia,
			auteur : auteurMedia,
			type: typeMedia	
			});
		}
	
	MediaService.search = function(titre, type, auteur){
		var url = 'http://localhost:8080/api/media/search';
		var params = {};
		if(titre !== null && titre !== undefined)
			params.titre = titre;
		if(type !== null && type !== undefined)
			params.type = type;
		if(auteur !== null && auteur !== undefined)
			params.auteur = auteur;
		console.log(params);
		var config = {params: params}
		
		var promise = $http.get(url,config).then(function(response){
			return response.data;
		},function(){
			console.error('erreur');
			return[];
			
		});
		return promise;
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
		var url = 'http://localhost:8080/api/adherent';
		var promise= $http.get(url).then(function(response){
			return response.data;
		},function(){
			console.error('erreur');
			return[];
			
		});
		return promise;
		
	}
	
	AdherentService.getAdherent=function(id){
		var url ='http://localhost:8080/api/adherent'
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