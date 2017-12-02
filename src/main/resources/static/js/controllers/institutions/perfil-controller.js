app.controller('InstitutionHomeController', ['$scope', '$location','$filter','$http', function ($scope, $location,$filter,$http){
    $scope.institution = [];

    $scope.getInstitutionData = function() {
        $http.get("http://localhost:9090/institutions/" + $id)
            .then(function (response) {
                $scope.institution = response.data;
            });
    };
    $scope.getInstitutionData();
}]);