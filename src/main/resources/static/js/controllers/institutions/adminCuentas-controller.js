
app.controller('adminCuentasController', ['$scope', '$location','$filter','$http','$routeParams',function ($scope, $location,$filter,$http,$routeParams){
    $scope.voters = [];
    $scope.associates = [];
    $scope.votacion = [];
    $scope.getVotersData = function() {
        $http.get("http://localhost:9090/institutions/"+$routeParams.id+"/voters")
            .then(function (response) {
                $scope.voters = response.data;
            });	
    };

    $scope.mostrar = function(){
    	var name = document.getElementById("name").value;
    	var institution = {'id': $routeParams.id};
    	$scope.votacion.push($scope.associates);
    	$scope.votacion.push(name);
    	$scope.votacion.push(institution); 	
    };
    $scope.getVotersData();
    
}]);