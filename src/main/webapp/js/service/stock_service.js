/**
 * Created by igor on 8.12.16.
 */
(function () {

    'use strict';

    angular.module('pgc.services')
        .factory('StockService', ['$http', '$q', function($http, $q){

            var REST_SERVICE_URI = 'http://localhost:8080/bsuir-ief/api/';

            var factory = {
                fetchAllStocks: fetchAllStocks,
                createStock: createStock,
                updateStock:updateStock,
                deleteStock:deleteStock
            };

            return factory;

            function fetchAllStocks() {
                var deferred = $q.defer();
                $http.get(REST_SERVICE_URI+"stocks")
                    .then(
                        function (response) {
                            deferred.resolve(response.data);
                        }/*,
                         function(errResponse){
                         console.error('Error while fetching stocks');
                         deferred.reject(errResponse);
                         }*/
                    );
                return deferred.promise;
            }

            function createStock(stock) {
                var deferred = $q.defer();
                $http.post(REST_SERVICE_URI + "stocks", stock)
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


            function updateStock(id, stock) {
                var deferred = $q.defer();
                $http.put(REST_SERVICE_URI + "stocks/" + id, stock)
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

            function deleteStock(id) {
                var deferred = $q.defer();
                $http.delete(REST_SERVICE_URI + "stocks/" + id)
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