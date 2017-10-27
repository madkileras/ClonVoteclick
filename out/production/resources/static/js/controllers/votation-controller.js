app.controller('VotationController', ['$scope', '$location', function($scope, $location) {

    $scope.isActive = function(route) {
        return route === $location.path();
    }
}]);