app.controller('MainController', ['$scope', '$location','$routeParams','$http', function($scope, $location,$routeParams,$http) {
	$scope.title = "Inicio";
    $scope.template = "js/views/templates/guest-links.html";
    $scope.loggedUser; 
    $http.get('http://localhost:9090/voters/'+$routeParams.id).then(function(response){
   		$scope.loggedUser = response.data.name;

   	});

    if($scope.loggedUser!=""){
    	$scope.template="js/views/templates/voter-links.html";
    }
    else{
    	$scope.template="js/views/templates/guest-links.html";

    }

	$scope.isActive = function(route) {
        return route === $location.path();
    };
}]);