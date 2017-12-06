app.controller('LoginController', ['$scope', '$location','$filter','$http','$routeParams',function ($scope, $location,$filter,$http,$routeParams) {

	$scope.usuario = {
		email = "",
		password =""
	};

    $scope.send = function () {
        var correo = document.getElementById("usuario").value;
        var pass = document.getElementById("pass").value;
        $scope.usuario.email = (correo);
        $scope.usuario.password = (pass);
        //$http.post("http://localhost:9090/validate/",$scope.usuario.password);
    };
}]);