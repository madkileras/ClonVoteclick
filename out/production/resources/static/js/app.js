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
        // Votations
        .when('/votaciones/crear', {
            templateUrl: 'js/views/votations/create.html'
        })
        .when('/votaciones/:id/resultado', {
            templateUrl: 'js/views/result.html'
        })
        .otherwise({
            redirectTo: '/'
        });
});