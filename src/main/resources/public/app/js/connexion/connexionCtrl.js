'use strict'
angular.module('connexion')
.controller('connexionCtrl',  ['$scope', '$rootScope', '$location', 'connexionService',
	function ($scope, $rootScope, $location, connexionService) {
        
        $scope.login = function(){

        	var estBienConnecte = false;
        	console.log('password = ' + $scope.password + ': mot de passe =' + $scope.username);
        	var promise = connexionService.login($scope.username, $scope.password);

        	promise.then(function(response){
        		console.log( 'valeur renvoyée par la requete' + response);
                console.log(response);
                if(response != null && response.status == 200){
                	connexionService.setCredentials($scope.username, $scope.password);
     			    $location.url('/recherche_media');
                }
                else
                    alert("mauvais mot de passe ou login");
        	});

        }
       }
 ]);