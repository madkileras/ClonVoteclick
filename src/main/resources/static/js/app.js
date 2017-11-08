var app = angular.module('VoteClick', ['ngRoute']);

app.config(function($routeProvider){
    $routeProvider
        .when('/', {
            templateUrl: 'js/views/index.html',
            controller: 'MainController'
        })
        .when('/servicios', {
            templateUrl: 'js/views/services.html',
            controller: 'MainController'
        })
        .when('/nosotros', {
            templateUrl: 'js/views/about.html',
            controller: 'MainController'
        })
        .when('/contacto', {
            templateUrl: 'js/views/contact.html',
            controller: 'MainController'
        })
        .when('/registro', {
            templateUrl: 'js/views/register.html',
            controller: 'MainController'
        })
        .when('/nuevaVotacion', {
            templateUrl: 'js/views/createVotation.html',
            controller: 'TableController'
        })
        .when('/votaciones/:id/resultado', {
            templateUrl: 'js/views/votacion-result.html',
            controller: 'VotationResultController'
        })
        .when('/institution', {
            templateUrl: 'js/views/institution.html',
            controller: 'InstitutionController'
        })
        .otherwise({
            redirectTo: '/'
        });
});