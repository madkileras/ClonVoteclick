app.controller('VotationVoteController', ['$scope','$http', '$routeParams', '$window',
    function($scope, $http, $routeParams, $window) {
    $scope.view = {
        sendError: false
    };

    $scope.votation = {};
    $scope.vote = {
        votation: { id: $scope.votation.id },
        options: []
    };

    $scope.options = [];

    $scope.toggleOption = function(optionId) {
        if($scope.options.includes(optionId))
            $scope.options.splice($scope.options.indexOf(optionId), 1);
        else
            $scope.options.push(optionId);
    };

    $scope.send = function () {
        if($scope.options.length === 0 && !confirm("El voto está en blanco. ¿Desea enviarlo de todas formas?")) return;
        if($scope.options.length > 1 && !confirm("El voto es nulo. ¿Desea enviarlo de todas formas?")) return;

        $scope.vote.options = [];
        for(var optionId in $scope.options)
            $scope.vote.options.push({ id: optionId });

        $http.post("http://localhost:9090/votes", $scope.vote)
            .then(function() {
                $window.history.back();
            }, function() {
                console.log("Error al enviar el voto...");
                $scope.view.sendError = true;
            });
    };

    $scope.getVotation = function() {
        $http.get("http://localhost:9090/votations/" + $routeParams.id)
            .then(function(response) {
                $scope.votation = response.data;
            });
    };
    $scope.getVotation();
}]);