app.controller('VotationCreateController', ['$scope', '$location','$filter','$http', function ($scope, $location,$filter,$http) {
    $scope.title = "Crear Votación";
    $scope.isActive = function (route) {
        return route === $location.path();
    };

    $scope.newVotation = {
        title:'',
        votationType:'',
        initDate:'',
        endDate:'',
        options:[],
        institutions:{institutionId:2}
    };
    $scope.lista = [{text: ''}];



    $scope.eliminar = function (row) {
        if (confirm("¿Seguro que desea eliminar?")) {
            $scope.lista.splice(row, 1);
            console.log(row);
        }
    };

    $scope.agregar = function () {
        $scope.lista.push({
            text: ''
        })
    };

    $scope.recuperarValores = function () {
        console.log($scope.lista);
        $("#JSON").text(JSON.stringify($scope.lista));
    };

    $scope.send = function(){
        $scope.newVotation.options=$scope.lista;
        $scope.newVotation.initDate= $filter('date')($scope.newVotation.initDate,"yyyy-MM-dd");
        $scope.newVotation.endDate= $filter('date')($scope.newVotation.endDate,"yyyy-MM-dd");
        $http.post("http://localhost:9090/votations",$scope.newVotation);
        console.log($scope.newVotation);

        //aca newVotation esta listo para ser utilizado en el método POST, en teoría

    }
}]);

app.directive('editableTd', [function () {
    return {
        restrict: 'A',
        link: function (scope, element, attrs) {
            element.css("cursor", "pointer");
            element.attr('contenteditable', 'true');

            element.bind('blur keyup change', function () {
                scope.lista[attrs.row][attrs.field] = element.text();
            });

            element.bind('click', function () {
                document.execCommand('selectAll', false, null)
            });
        }
    };
}]);