angular.module('rechercheMedia')

.filter('myOrderBy', function($filter){
	return function(input, param){

		if(typeof param === 'function'){
			$filter('orderBy')(param(input));
		}
		else{
			 $filter('orderBy')(input,param);
		}

		return input;
	}
});