
app.controller('adminCuentasController', ['$scope', '$location','$filter','$http',function ($scope, $location,$filter,$http,$checklistModel){
    $scope.voters = [];
    $scope.chosenVoters = [];
    $scope.getVotersData = function() {
        $http.get("http://localhost:9090/institutions/2/voters")
            .then(function (response) {
                $scope.voters = response.data;

            });
    };

    $scope.agregar = function(index){
        $scope.chosenVoters.push($scope.voters[index]);
        console.log($scope.voters[index+1]);

    };

    $scope.getVotersData();
}]);