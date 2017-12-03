app.controller('adminCuentasController', ['$scope', '$location','$filter','$http', function ($scope, $location,$filter,$http){
    $scope.voters = [];

    $scope.getVotersData = function() {
        $http.get("http://localhost:9090/institutions/2/voters")
            .then(function (response) {
                $scope.voters = response.data;

            });
    };
    $scope.getVotersData();
}]);