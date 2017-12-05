app.controller('VoterController', ['$scope', '$location','$filter','$http', function ($scope, $location,$filter,$http){
    $scope.newVoter = {
        name: '',
        rut: '',
        email:'',
        phone:''
    };

    $scope.send = function() {
        $http.post("http://localhost:9090/voters/", $scope.newVoter);
        console.log($scope.newVoter);

    };
}]);