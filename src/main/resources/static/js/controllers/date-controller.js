app.controller('DateController', ['$scope', function($scope) {
    $scope.extractDate = function(date) {
        var day = date.getDate();
        var month = date.getMonth() + 1;
        var year = date.getFullYear();
        return year + '-' + ('0' + month).substr(-2) + '-' + ('0' + day).substr(-2);
    }

    $scope.start = $scope.extractDate(new Date());
    $scope.endRestrict = $scope.start;

    $scope.$watch('newVotation.dateStart', function(dateStart) {
        $scope.endRestrict = $scope.extractDate(dateStart);
    });
}]);