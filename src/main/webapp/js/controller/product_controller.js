/**
 * Created by igor on 8.12.16.
 */
(function () {
    'use strict';
//Посмотреть завтра что тут происходит
    angular.module('pgc.controllers')
        .controller('ProductController', ['$scope', 'ClientService', 'ProductService', function($scope, ClientService, ProductService) {
            var self = this;

            self.product = {
                id:null,
                name:'',
                productCol:null,
                date:null,
                client:{
                    id:null,
                    name:'',
                    email:'',
                    compani:'',
                    password:'',
                    firstName:'',
                    lastName:''
                },
              stocks:[]
            };

            self.products = [];

            self.clients = [];

            self.submit = submit;
            self.edit = edit;
            self.remove = remove;
            self.reset = reset;
            self.updateSub = updateSub;


            fetchAllProducts();
            fetchAllClients();

            function fetchAllClients(){
                ClientService.fetchAllClients().then(
                    function(d) {
                        self.clients = d.data;
                        if (d.data.length > 0)
                            self.product.client = d.data[0];
                    }/*,
                     function(errResponse){
                     console.error('Error while fetching Roles');
                     }*/
                );
            }

            function fetchAllProducts(){
                ProductService.fetchAllProducts().then(
                    function(d) {
                        self.products = d.data;
                    }/*,
                     function(errResponse){
                     console.error('Error while fetching Roles');
                     }*/
                );
            }

            function createProduct(id, product){
                ProductService.createProduct(id,product).then(
                    fetchAllProducts/*,
                     function(errResponse){
                     console.error('Error while creating User');
                     }*/
                );
            }

            function updateProduct(id, product){
                ProductService.updateProduct(id, product)
                    .then(
                        fetchAllProducts/*,
                         function(errResponse){
                         console.error('Error while updating User');
                         }*/
                    );
            }

            function deleteProduct(product){
                ProductService.deleteProduct(product)
                    .then(
                        fetchAllProducts/*,
                         function(errResponse){
                         console.error('Error while deleting User');
                         }*/
                    );
            }


            function submit() {
                console.log('Saving New User', self.product);
                createProduct(self.product.id, self.product);
                reset();
            }

            function updateSub() {
                console.log('Saving New User', self.product);
                updateProduct(self.product.id, self.product);
                reset();
            }


            function edit(id){
                console.log('id to be edited', id);
                for(var i = 0; i < self.products.length; i++){
                    if(self.products[i].id === id) {
                        self.product = angular.copy(self.products[i]);
                        break;
                    }
                }
            }

            function remove(product){
                deleteProduct(product);
            }


            function reset(){
                self.product = {
                    id:null,
                    name:'',
                    productCol:null,
                    date:null,
                    client:{
                        id:null,
                        name:'',
                        email:'',
                        compani:'',
                        password:'',
                        firstName:'',
                        lastName:''
                    },
                    stocks:[]
                };
                $scope.myForm.$setPristine(); //reset Form
            }

        }]);
}());