/**
 * Created by igor on 8.12.16.
 */
(function () {

    'use strict';

    angular.module('pgc.services')
        .factory('ProductService', ['$http', '$q', function($http, $q){

            var REST_SERVICE_URI = 'http://localhost:8080/bsuir-ief/api/';

            var factory = {
                fetchAllProducts: fetchAllProducts,
                createProduct: createProduct,
                updateProduct:updateProduct,
                deleteProduct:deleteProduct
            };

            return factory;

            function fetchAllProducts() {
                var deferred = $q.defer();
                $http.get(REST_SERVICE_URI+"products")
                    .then(
                        function (response) {
                            deferred.resolve(response.data);
                        }/*,
                         function(errResponse){
                         console.error('Error while fetching products');
                         deferred.reject(errResponse);
                         }*/
                    );
                return deferred.promise;
            }

            function createProduct( id, product) {
                var deferred = $q.defer();
                $http.post(REST_SERVICE_URI + "products/" + id, product)
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


            function updateProduct(id, product) {
                var deferred = $q.defer();
                $http.put(REST_SERVICE_URI + "products/" + id, product)
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

            function deleteProduct(product) {
                var deferred = $q.defer();
                $http.delete(REST_SERVICE_URI + "products", product)
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