app.controller('MainController', ['$scope', '$location', function($scope, $location) {
	$scope.title = "Inicio";

	$scope.isActive = function(route) {
        return route === $location.path();
    }
}]);