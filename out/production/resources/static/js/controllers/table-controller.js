app.controller('TableController', ['$scope', '$location','$filter', function ($scope, $location,$filter) {
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
        institutions:{name:"Tricel CEII",institutionId:2}
    };
    $scope.lista = [{text: ''}];

    $scope.eliminar = function (row) {
        if (confirm("¿Seguro que desea eliminar?")) {
            $scope.lista.splice(row, 1);
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
        $scope.newVotation.initDate= $filter('date')($scope.newVotation.initDate,"MM/dd/yyyy - HH:mm:ss");
        $scope.newVotation.endDate= $filter('date')($scope.newVotation.endDate,"MM/dd/yyyy - HH:mm:ss");

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