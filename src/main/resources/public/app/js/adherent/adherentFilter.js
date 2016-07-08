angular.module('rechercheAdherent')

.filter('regex', function() {
	return function(input, field, regex) {

		if(input != undefined && input != null){
			var patt = new RegExp(regex);
			var out = [];
			for (var i = 0; i < input.length; i++) {
				if (patt.test(input[i][field]))
					out.push(input[i]);
			}
			return out;
		}
	};
});
