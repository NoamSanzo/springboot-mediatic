'use strict'
angular.module('connexion')
.controller('connexionCtrl',  ['$scope', '$rootScope', '$location', 'connexionService',
	function ($scope, $rootScope, $location, connexionService) {
        
        $scope.login = function(){

        	var estBienConnecte = false;
        	console.log('password = ' + $scope.password + ': mot de passe =' + $scope.username);
        	var promise = connexionService.login($scope.username, $scope.password);

        	promise.then(function(data){
        		console.log( 'valeur renvoyée par la requete' + data);
        		connexionService.setCredentials($scope.username, $scope.password)
                console.log(data);
                if(data != null && data.status == 200)
     			    $location.url('/recherche_media');
                else
                    alert("mauvais mot de passe ou login");
        	});

        }
       }
 ]);