var app = angular.module('VoteClick', ['ngRoute']);

app.config(function($routeProvider){
    $routeProvider
        .otherwise({
            redirectTo: '/'
        });
});