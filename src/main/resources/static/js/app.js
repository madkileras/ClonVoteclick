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
        .otherwise({
            redirectTo: '/'
        });
});