(function () {
    'use strict';

    var app = angular.module('myApp',['ngRoute', 'pgc.services', 'pgc.controllers']);

    app.config(['$routeProvider', function ($routeProvider) {

    $routeProvider
        .when('', {
            templateUrl: 'index.jsp',
        })

        .when('/roles', {
            templateUrl: 'view/roleAdm.html',
            controller: 'RoleController as ctrl'
        })

        .when('/clients', {
            templateUrl: 'view/client_tab.html',
            controller: 'ClientController as ctrl'
        })

        .when('/products', {
            templateUrl: 'view/product_tab.html',
            controller: 'ProductController as ctrl'
        })

        .when('/typestocks', {
            templateUrl: 'view/typeStock_tab.html',
            controller: 'TypeStockController as ctrl'
        })

        .when('/stocks', {
            templateUrl: 'view/stock_tab.html',
            controller: 'StockController as ctrl'
        })
    }]);
}());



/*App.service('RoleService', ['$http', '$q', function($http, $q){

    var REST_SERVICE_URI = 'http://localhost:8080/bsuir-ief/api/';

    var factory = {
        fetchAllRoles: fetchAllRoles,
        createRole: createRole,
        updateRole:updateRole,
        deleteRole:deleteRole
    };

    return factory;

    function fetchAllRoles() {
        var deferred = $q.defer();
        $http.get(REST_SERVICE_URI+"roles")
            .then(
                function (response) {
                    deferred.resolve(response.data);
                }/!*,
                 function(errResponse){
                 console.error('Error while fetching Roles');
                 deferred.reject(errResponse);
                 }*!/
            );
        return deferred.promise;
    }

    function createRole( id, role) {
        var deferred = $q.defer();
        $http.post(REST_SERVICE_URI + "roles/" + id, role)
            .then(
                function (response) {
                    deferred.resolve(response.data);
                }/!*,
                 function(errResponse){
                 console.error('Error while creating User');
                 deferred.reject(errResponse);
                 }*!/
            );
        return deferred.promise;
    }


    function updateRole(id, role) {
        var deferred = $q.defer();
        $http.put(REST_SERVICE_URI + "roles/" + id, role)
            .then(
                function (response) {
                    deferred.resolve(response.data);
                }/!*,
                 function(errResponse){
                 console.error('Error while updating User');
                 deferred.reject(errResponse);
                 }*!/
            );
        return deferred.promise;
    }

    function deleteRole(role) {
        var deferred = $q.defer();
        $http.delete(REST_SERVICE_URI + "roles", role)
            .then(
                function (response) {
                    deferred.resolve(response.data);
                }/!*,
                 function(errResponse){
                 console.error('Error while deleting User');
                 deferred.reject(errResponse);
                 }*!/
            );
        return deferred.promise;
    }

}]);

App.config(function ($routeProvider) {

    $routeProvider
        .when('/', {
            templateUrl: 'index.jsp',
            controller: 'RoleController'
        })

        .when('/index', {
            templateUrl: 'roleAdm.html',
            controller: 'RoleController'
        })

});


App.controller('RoleController', ['$scope', 'RoleService', function($scope, RoleService) {
    var self = this;
    self.role={id:'',name:''};
    self.roles = [];

    self.submit = submit;
    self.edit = edit;
    self.remove = remove;
    self.reset = reset;
    self.updateSub = updateSub;


    fetchAllRoles();

    function fetchAllRoles(){
        RoleService.fetchAllRoles().then(
            function(d) {
                self.roles = d.data;
            }/!*,
             function(errResponse){
             console.error('Error while fetching Roles');
             }*!/
        );
    }

    function createRole(id, role){
        RoleService.createRole(id,role).then(
            fetchAllRoles/!*,
             function(errResponse){
             console.error('Error while creating User');
             }*!/
        );
    }

    function updateRole(id, role){
        RoleService.updateRole(id, role)
            .then(
                fetchAllRoles/!*,
                 function(errResponse){
                 console.error('Error while updating User');
                 }*!/
            );
    }

    function deleteRole(role){
        RoleService.deleteRole(role)
            .then(
                fetchAllRoles/!*,
                 function(errResponse){
                 console.error('Error while deleting User');
                 }*!/
            );
    }

    /!*    function submit() {
     if(self.user.id===null){
     console.log('Saving New User', self.user);
     createRole(self.user);
     }else{
     updateRole(self.user, self.user.id);
     console.log('User updated with id ', self.user.id);
     }
     reset();
     }*!/

    function submit() {
        console.log('Saving New User', self.role);
        createRole(self.role.id, self.role);
        reset();
    }

    function updateSub() {
        console.log('Saving New User', self.role);
        updateRole(self.role.id, self.role);
        reset();
    }

    /!*    function edit(id, role) {
     for(var i = 0; i < self.roles.length; i++) {
     if (self.roles[i].id === id) {
     console.log('id to be edited', id);
     updateRole(role, id);
     break;
     }
     }
     reset();
     }*!/

    function edit(id){
        console.log('id to be edited', id);
        for(var i = 0; i < self.roles.length; i++){
            if(self.roles[i].id === id) {
                self.role = angular.copy(self.roles[i]);
                break;
            }
        }
    }

    function remove(role){
        console.log('id to be deleted', role);
        /!*        if(self.role.id === id) {//clean form if the user to be deleted is shown there.
         reset();
         }*!/
        self.role.id = role.id;
        self.role.name = role.name;
        self.role.new = false;
        deleteRole(self.role);
    }


    function reset(){
        self.role={id:'',name:''};
        $scope.myForm.$setPristine(); //reset Form
    }

}]);*/
