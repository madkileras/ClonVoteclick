app.controller('VotationResultController', ['$scope','$http', '$routeParams', function($scope,$http, $routeParams) {
    $scope.votacion = {};

    $scope.getResultados=function(){
        var url='http://127.0.0.1:9090/votations/'+$routeParams.id;

        console.log($routeParams.id);
        console.log(url);
        $http.get(url).then(function(response){
            $scope.votacion=response.data;
            console.log($scope.votacion);
            $scope.putGraph();
        });

    }




    $scope.putGraph = function() {
        var ctxSem = document.getElementById("resultados").getContext('2d');
        new Chart(ctxSem, {
            type: 'bar',
            data: {
                labels: $scope.votacion.candidatos,

                datasets: [{
                    label: "# de votos",
                    backgroundColor: '#69BFB6',
                    borderColor: '#249085',
                    fill: false,
                    data: $scope.votacion.resultados
                }]
            },

            options: {
                responsive: true,

                scales: {
                    xAxes: [{
                        display: true
                    }],
                    yAxes: [{
                        display: true,
                        ticks: {
                            suggestedMin: 0,    // minimum will be 0, unless there is a lower value.
                            // OR //
                            beginAtZero: true   // minimum value will be 0.
                        }

                    }]
                }
            }
        });
    };

    $scope.initView = function() {
        //$scope.votacion = this.getResults($routeParams.id);
        $scope.getResultados();

    }

    $scope.initView();
}]);