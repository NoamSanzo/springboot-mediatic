angular.module('Mediatic', ['ngRoute','creationMedia','detailsMedia',
                            'connexion','creationAdherent', 'detailsAdherent',
                            'rechercheMedia','rechercheAdherent', 'creationMedia',
                            ,'ngCookies', 'emprunt']);



angular
.module('Mediatic')
.config(function($routeProvider,$httpProvider){
	
	$routeProvider.otherwise('/connexion');
	$httpProvider.defaults.headers.post['Content-Type'] = 'application/x-www-form-urlencoded';

})

.run(['$rootScope', '$location', '$cookieStore', '$http',
      function ($rootScope, $location, $cookieStore, $http) {
    // keep user logged in after page refresh
    $rootScope.globals = $cookieStore.get('globals') || {};
    if ($rootScope.globals.currentUser) {
        $http.defaults.headers.common['Authorization'] = 'Basic ' + $rootScope.globals.currentUser.authdata; // jshint ignore:line
    }

    $rootScope.$on('$locationChangeStart', function (event, next, current) {
        // redirect to login page if not logged in
        if ($location.path() !== '/connexion' && !$rootScope.globals.currentUser) {
            $location.path('/connexion');
        }
    });
}]);
