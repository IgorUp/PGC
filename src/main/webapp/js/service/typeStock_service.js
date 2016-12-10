
(function () {

    'use strict';

    angular.module('pgc.services')
        .factory('TypeStockService', ['$http', '$q', function($http, $q){

        var REST_SERVICE_URI = 'http://localhost:8080/bsuir-ief/api/';

        var factory = {
            fetchAllTypeStocks: fetchAllTypeStocks,
            createTypeStock: createTypeStock,
            updateTypeStock:updateTypeStock,
            deleteStock:deleteStock
        };

        return factory;

        function fetchAllTypeStocks() {
            var deferred = $q.defer();
            $http.get(REST_SERVICE_URI+"typestocks")
                .then(
                    function (response) {
                        deferred.resolve(response.data);
                    }/*,
                     function(errResponse){
                     console.error('Error while fetching typeStocks');
                     deferred.reject(errResponse);
                     }*/
                );
            return deferred.promise;
        }

        function createTypeStock(typeStock) {
            var deferred = $q.defer();
            $http.post(REST_SERVICE_URI + "typestocks", typeStock)
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


        function updateTypeStock(id, typeStock) {
            var deferred = $q.defer();
            $http.put(REST_SERVICE_URI + "typestocks/" + id, typeStock)
                .then(
                    function (response) {
                        deferred.resolve(response.data);
                    }/*,
                     function(errResponse){
                     console.error('Error while updating User');
                     deferred.reject(errResponse);
                     }*/
                );
            return deferred.promise;
        }

        function deleteStock(typeStock) {
            var deferred = $q.defer();
            $http.delete(REST_SERVICE_URI + "typestocks", typeStock)
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

}());
