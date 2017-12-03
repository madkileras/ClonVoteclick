app.controller('TypeController', ['$scope', function ($scope) {
    $scope.show1 = false;
    $scope.show2 = false;
    $scope.showVotation1 = function(){
        if(!$scope.show2)
            $scope.show1 = !$scope.show1; 
    };

    $scope.showVotation2 = function(){
        if(!$scope.show1)
            $scope.show2 = !$scope.show2; 
    };
    
}]);
