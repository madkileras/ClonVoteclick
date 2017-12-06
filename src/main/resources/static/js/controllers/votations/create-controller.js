app.controller('VotationCreateController', ['$scope', '$location', '$filter', '$http',
    function ($scope, $location, $filter, $http) {
        $scope.institution = {};
        $scope.title = "Crear Votación";

        $scope.matchQuery = false;
        $scope.selectedList = '';
        $scope.query = '';

        $scope.votation = {
            title: '',
            type: '',
            initDate: '',
            endDate: '',
            options: [],
            voters: [],
            institution: {id: 2}
        };
        $scope.lista = [{text: ''}];
        $scope.lists = [];

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

        $scope.filterFunction = function (voter) {
            var match = $scope.query !== '' && $scope.clean(voter.name).includes($scope.query);
            if (match) $scope.matchQuery = true;
            return match;
        };

        $scope.assignVoter = function (voter, update) {
            var exists = false;
            $scope.votation.voters.forEach(function(votationVoter) {
               if(votationVoter.name === voter.name) exists = true;
            });
            if(exists) return;

            $scope.votation.voters.push(voter);
            var index = -1, i = 0;
            $scope.institution.voters.forEach(function(insVoter) {
                if(insVoter.name === voter.name) index = i;
                i++;
            });
            $scope.institution.voters.splice(index, 1);
            if (update) $scope.updateLists();
        };

        $scope.removeVoter = function (index) {
            var voter = $scope.votation.voters[index];
            $scope.votation.voters.splice(index, 1);
            $scope.institution.voters.push(voter);
            $scope.updateLists();
        };

        $scope.assignList = function () {
            var voters = [];
            $scope.institution.censuses.forEach(function (census) {
                if(census.name === $scope.selectedList) {
                    voters = census.associates;
                }
            });

            voters.forEach(function (voter) {
                $scope.assignVoter(voter);
            });
            $scope.updateLists();
        };

        $scope.updateLists = function () {
            $scope.lists = [];
            $scope.institution.censuses.forEach(function (census) {
                $scope.institution.voters.forEach(function (voter) {
                    census.associates.forEach(function(assocVoter) {
                        if(assocVoter.name === voter.name && !$scope.lists.includes(census.name))
                            $scope.lists.push(census.name);
                    });
                });
            });
            $scope.lists.sort();
        };

        $scope.send = function () {
            $scope.votation.options = $scope.lista;
            $scope.votation.initDate = $filter('date')($scope.votation.initDate, "dd/MM/yyyy' a las 'HH:mm");
            $scope.votation.endDate = $filter('date')($scope.votation.endDate, "dd/MM/yyyy' a las 'HH:mm");
            $http.post("http://localhost:9090/votations", $scope.votation);
            console.log($scope.votation);
        };

        // Other functions
        $scope.clean = function (text) {
            var replace = 'áéíóúüÁÉÍÓÚÜ';
            var repWith = 'aeiouuAEIOUU';
            for (var i = 0; i < replace.length; i++)
                text = text.replace(replace[i], repWith[i]);

            return text.toLowerCase();
        };

        $scope.getInstitution = function () {
            $http.get("http://localhost:9090/institutions/4").then(function(response) {
                $scope.institution = response.data;
                $scope.updateLists();
            });
        };
        $scope.getInstitution();
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