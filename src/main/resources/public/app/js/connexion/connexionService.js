'use strict'

angular.module('connexion')
.factory('connexionService', function($rootScope, $http){

	var service = {};

	service.setCredentials = function (username, password) {
            var authdata = btoa(username + ':' + password);
  
            $rootScope.globals = {
                currentUser: {
                    username: username,
                    authdata: authdata
                }
            };

            $http.defaults.headers.common['Authorization'] = 'Basic ' + authdata;
    }

    service.login = function (username, password) {
    	var myUrl  = 'http://192.168.10.12:8090/resource/connexion.login';
    	console.log('on tente de se connecter', username, password);
    	
    	var promise = $http.post(myUrl, { login: username, mdp: password })
               .then(function(response) {
               		console.log(' success du post ' + response.data);
  					return response.data;
				}, function(reason) {
               		console.log(' echec du post ' + reason.data);
					return reason.data;
				});

        return promise;
    };

    service.getDroitAcces = function(){
        var myUrl = 'http://192.168.10.12:8090/resource/connexion.rights'
        console.log('on tente de recuper les droits dacces');

        var promise = $http.get(myUrl).then(function(response){
            console.log('succès de la requete de droits dacces ' + response.data);
            return response.data;
        }, function(reason){
            console.log('echec de la demande de droits dacces ' + reason.data);
            return reason.data;
        });
        return promise;
    }
    
    return service;
});