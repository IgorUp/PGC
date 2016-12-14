
(function () {

    'use strict';

    angular.module('pgc.services')
        .factory('CommService', ['$http', '$q', function($http, $q){

        var REST_SERVICE_URI = 'http://localhost:8080/bsuir-ief/api/';

        var factory = {
            fetchAllComms: fetchAllComms,
            createComm: createComm,
        };

        return factory;

        function fetchAllComms() {
            var deferred = $q.defer();
            $http.get(REST_SERVICE_URI+"coms")
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

        function createComm(comm) {
            var deferred = $q.defer();
            $http.post(REST_SERVICE_URI+"coms", comm)
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
    }]);

}());
