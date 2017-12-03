
app.controller('adminCuentasController', ['$scope', '$location','$filter','$http','$routeParams',function ($scope, $location,$filter,$http,$routeParams){
    $scope.voters = [];
    $scope.associates = [];
    $scope.votacion = [];

    $scope.getVotersData = function() {
        $http.get("http://localhost:9090/institutions/2/voters")
            .then(function (response) {
                $scope.voters = response.data;
            });	
    };

    $scope.votantes = {voters:["votantes"]};

    $scope.guardar = function(){
    	var name = document.getElementById("name").value;
    	var institution = {'id': $routeParams.id};
    	if(name == "")
    		alert("No ha ingresado nombre de la lista");
    	else
    		$scope.votacion.push(name);
    	$scope.votacion.push($scope.associates);
    	$scope.votacion.push(institution); 	
    };



    $scope.limpiar = function(){
    	$scope.associates = [];
		$scope.voters = [];
		$scope.getVotersData();    	
    };

    $scope.todos = function(){
    	$scope.associates = angular.copy($scope.voters);
    };

    $scope.getVotersData();
    
}]);