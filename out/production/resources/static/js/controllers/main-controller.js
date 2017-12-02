app.controller('MainController', ['$scope', '$location', function($scope, $location) {
	$scope.title = "Inicio";
    $scope.template = "js/views/templates/guest-links.html";

	$scope.isActive = function(route) {
        return route === $location.path();
    }
}]);