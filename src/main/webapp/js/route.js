/**
 * Created by igor on 8.12.16.
 */

angular.module('myApp').config(['$routeProvider', function ($routeProvider) {

    $routeProvider
        .when('/', {
            templateUrl: 'index.jsp',
            controller: 'RoleController'
        })

        .when('/index', {
            templateUrl: 'roleAdm.html',
            controller: 'RoleController'
        })

}]);