app.controller('InstitutionController', ['$scope', '$location','$filter','$http', function ($scope, $location,$filter,$http){
    $scope.institutionName='TRICEL CEII';

    $http.get('http://localhost:9090/votations/institution/2').then(function(response){
        $scope.votation = response.data;});

    $scope.goResults=function(id){
        $location.url('/votaciones/'+ id +'/resultado');
    };


    $scope.isActive = function(route) {
        return route === $location.path();
    };



}]);