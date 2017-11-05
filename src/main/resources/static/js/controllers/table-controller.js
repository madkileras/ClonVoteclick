app.controller('TableController', ['$scope', '$location', function ($scope, $location) {
    $scope.title = "Crear Votación";
    $scope.isActive = function (route) {
        return route === $location.path();
    };

    $scope.newVotation = {};
    $scope.lista = [{nombres: ''}];

    $scope.eliminar = function (row) {
        if (confirm("¿Seguro que desea eliminar?")) {
            $scope.lista.splice(row, 1);
        }
    };

    $scope.agregar = function () {
        $scope.lista.push({
            nombres: '',
            apellidos: ''
        })
    };

    $scope.recuperarValores = function () {
        console.log($scope.lista);
        $("#JSON").text(JSON.stringify($scope.lista));
    };
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