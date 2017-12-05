app.controller('VotationVoteController', ['$scope','$http', '$routeParams', '$window',
    function($scope, $http, $routeParams, $window) {
    $scope.votation = {};
    $scope.vote = {
        votation: {},
        options: []
    };

    $scope.auth = {
      run: '',
      ndoc: ''
    };

    $scope.options = [];
    $scope.sendError = null;
    $scope.voteValidation = null;

    $scope.closeError = function() {
        $scope.sendError = null;
    };

    $scope.toggleOption = function(optionId) {
        if($scope.options.includes(optionId))
            $scope.options.splice($scope.options.indexOf(optionId), 1);
        else
            $scope.options.push(optionId);
    };

    $scope.verifyVote = function() {
        $scope.voteValidation = null;
        if($scope.options.length === 0)
            $scope.voteValidation = 'blanco';
        else if($scope.options.length > 1)
            $scope.voteValidation = 'nulo';
    };

    $scope.authVoter = function () {
        $scope.sendError = null;
        $http.post("http://localhost:9090/voter/auth", $scope.auth)
            .then(function(response) {
                if(response.data) {
                    $scope.send();
                } else {
                    $scope.sendError = 'No se pudo verificar el documento ingresado.';
                }
            }, function() {
                console.log("Error al enviar el voto [AUTH]...");
                $scope.sendError = 'No se pudo verificar el documento ingresado.';
            });
    };

    $scope.send = function () {
        console.log($scope.votation.options);
        console.log($scope.options);

        $scope.vote.options = [];
        $scope.options.forEach(function(optionId) {
            $scope.vote.options.push({ id: optionId });
        });

        console.log($scope.vote);
        $http.post("http://localhost:9090/votes", $scope.vote)
            .then(function() {
                $window.history.back();
            }, function() {
                console.log("Error al enviar el voto...");
                $scope.sendError = 'Ocurrió un error al enviar el voto.';
            });
    };

    $scope.getVotation = function() {
        $http.get("http://localhost:9090/votations/" + $routeParams.id)
            .then(function(response) {
                $scope.votation = response.data;
                $scope.vote.votation = { id: $scope.votation.id };
            });
    };
    $scope.getVotation();
}]);