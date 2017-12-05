app.controller('RegisterInstitutionController', ['$scope', '$location','$filter','$http', function ($scope, $location,$filter,$http){
    $scope.newInstitution = {
        name: '',
        rut: '',
        email:'',
        phone:'',
        description:'',
        blocked:true
    };

    $scope.send = function() {
        $http.post("http://localhost:9090/institutions/", $scope.newInstitution);
        console.log($scope.newInstitution);

    };
}]);