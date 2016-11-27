'use strict';

angular.module('myApp').factory('RoleService', ['$http', '$q', function($http, $q){

    var REST_SERVICE_URI = 'http://localhost:8080/bsuir-ief/api/';

    var factory = {
        fetchAllUsers: fetchAllUsers,
        createUser: createUser,
        /*updateUser:updateUser,*/
        deleteUser:deleteUser
    };

    return factory;

    function fetchAllUsers() {
        var deferred = $q.defer();
        $http.get(REST_SERVICE_URI+"roles")
            .then(
            function (response) {
                deferred.resolve(response.data);
            }/*,
            function(errResponse){
                console.error('Error while fetching Roles');
                deferred.reject(errResponse);
            }*/
        );
        return deferred.promise;
    }

    function createUser( id, role) {
        var deferred = $q.defer();
        $http.post(REST_SERVICE_URI + "roles/" + id, role)
            .then(
            function (response) {
                deferred.resolve(response.data);
            }/*,
            function(errResponse){
                console.error('Error while creating User');
                deferred.reject(errResponse);
            }*/
        );
        return deferred.promise;
    }


/*    function updateUser(user, id) {
        var deferred = $q.defer();
        $http.put(REST_SERVICE_URI+id, user)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while updating User');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }*/

    function deleteUser(role) {
        var deferred = $q.defer();
        $http.delete(REST_SERVICE_URI + "roles", role)
            .then(
            function (response) {
                deferred.resolve(response.data);
            }/*,
            function(errResponse){
                console.error('Error while deleting User');
                deferred.reject(errResponse);
            }*/
        );
        return deferred.promise;
    }

}]);
