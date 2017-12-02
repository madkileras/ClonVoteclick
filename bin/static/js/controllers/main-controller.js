app.controller('MainController', ['$scope','$location', function($scope, $location) {

	$scope.title = "Inicio";

	$scope.loadNav = function() {
	    $scope.indexPage = ($location.path() === '/') ? 'active' : '';
	    $scope.servicesPage = ($location.path() === '/servicios') ? 'active' : '';
	    $scope.aboutPage = ($location.path() === '/nosotros') ? 'active' : '';
	    $scope.contactPage = ($location.path() === '/contacto') ? 'active' : '';

		$scope.navigation = [
			{ 
				"text": "Inicio",
				"link":"/",
				"class":$scope.indexPage
			},
			{
				"text": "Servicios",
				"link":"/servicios",
				"class":$scope.servicesPage
			},
			{
				"text": "Nosotros",
				"link":"/nosotros",
				"class":$scope.aboutPage
			},
			{
				"text": "Contacto",
				"link":"/contacto",
				"class":$scope.contactPage
			}
		];		
	}

	$scope.loadNav();

}]);