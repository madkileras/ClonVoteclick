
app.controller('adminCuentasController', ['$scope', '$location','$filter','$http','$routeParams',function ($scope, $location,$filter,$http,$routeParams){
    $scope.voters = [];
    $scope.associates = [];
    $scope.votacion = {
        name:"",
        institution:"",
        associates:""
    };

    $scope.getVotersData = function() {
        $http.get("http://localhost:9090/institutions/2/voters")
            .then(function (response) {
                $scope.voters = response.data;
            });	
    };

    $scope.votantes = {voters:["votantes"]};

    $scope.guardar = function(){
    	var name = document.getElementById("name").value;
    	var institution = {'id': 2};
    	if(name == "")
    		alert("No ha ingresado nombre de la lista");
    	else{
            $scope.votacion.associates=($scope.associates);
            $scope.votacion.name=(name);
            $scope.votacion.institution=(institution);
            console.log($scope.votacion);
            $http.post("http://localhost:9090/census/",$scope.votacion);
    	}

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