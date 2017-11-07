app.controller('VotationResultController', ['$scope', '$routeParams', function($scope, $routeParams) {
    $scope.votacion = {};

    $scope.getResults = function(id) {
        return Number(id) === 1 ? {
            nombre: 'Votación 1',
            ganador: {
                nombre: 'Candidato 1',
                imagen: '../../img/opcion.png'
            },
            candidatos: [
                'Candidato 1',
                'Candidato 2',
                'Candidato 3'
            ],
            resultados: [
                132,
                109,
                82
            ]
        } : {
            nombre: 'Votación 2',
            ganador: {
                nombre: 'Candidato 2',
                imagen: '../../img/opcion.png'
            },
            candidatos: [
                'Candidato 1',
                'Candidato 2',
                'Candidato 3',
                'Candidato 4'
            ],
            resultados: [
                201,
                313,
                298,
                103
            ]
        }
    };

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
                        display: true
                    }]
                }
            }
        });
    };

    $scope.initView = function() {
        console.log($routeParams.id);
        $scope.votacion = this.getResults($routeParams.id);
        $scope.putGraph();
    }

    $scope.initView();
}]);