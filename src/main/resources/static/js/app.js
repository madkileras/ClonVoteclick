var app = angular.module('VoteClick', ['ngRoute']);

app.config(function($routeProvider){
    $routeProvider
        .when('/', {
            templateUrl: 'js/views/index.html'
        })
        .when('/servicios', {
            templateUrl: 'js/views/services.html'
        })
        .when('/nosotros', {
            templateUrl: 'js/views/about.html'
        })
        .when('/contacto', {
            templateUrl: 'js/views/contact.html'
        })
        // Institutions
        .when('/instituciones/registro', {
            templateUrl: 'js/views/institutions/register.html'
        })
        .when('/instituciones/inicio', {
            templateUrl: 'js/views/institutions/home.html'
        })
        .when('/instituciones/perfil/:id', {
            templateUrl: 'js/views/institutions/perfil.html'
        })
        .when('/instituciones/adminCuentas', {
            templateUrl: 'js/views/institutions/adminCuentas.html'
        })
        // Voters
        .when('/votantes/login', {
            templateUrl: 'js/views/voters/login.html'
        })
        .when('/votantes/inicio', {
            templateUrl: 'js/views/voters/home.html'
        })
        // Votations
        .when('/votaciones/crear', {
            templateUrl: 'js/views/votations/create.html'
        })
        .when('/votaciones/:id/resultado', {
            templateUrl: 'js/views/votations/result.html'
        })
        .when('/votaciones/:id/votar', {
            templateUrl: 'js/views/votations/vote.html'
        })
        .otherwise({
            redirectTo: '/'
        });
});