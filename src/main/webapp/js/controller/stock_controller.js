/**
 * Created by igor on 8.12.16.
 */
(function () {
    'use strict';
//Посмотреть завтра что тут происходит
    angular.module('pgc.controllers')
        .controller('StockController', ['$scope', 'TypeStockService', 'StockService', function($scope, TypeStockService, StockService) {
            var self = this;

            self.stock = {
                id:null,
                name:'',
                address:'',
                numberOfSeats:null,
                numberOfRemainingPlaces:null,
                numberOfSectors:null,
                height:'',
                width:'',
                capacity:'',
                typeStock:{
                    id:'',
                    name:''
                },
                stocks:[]
            };

            self.stocks = [];

            self.typeStocks = [];

            self.submit = submit;
            self.edit = edit;
            self.remove = remove;
            self.reset = reset;
            self.updateSub = updateSub;


            fetchAllStocks();
            fetchAllTypeStocks();

            function fetchAllTypeStocks(){
                TypeStockService.fetchAllTypeStocks().then(
                    function(d) {
                        self.typeStocks = d.data;
                        if (d.data.length > 0)
                            self.stock.typeStock = d.data[0];
                    }/*,
                     function(errResponse){
                     console.error('Error while fetching Roles');
                     }*/
                );
            }

            function fetchAllStocks(){
                StockService.fetchAllStocks().then(
                    function(d) {
                        self.stocks = d.data;
                    }/*,
                     function(errResponse){
                     console.error('Error while fetching Roles');
                     }*/
                );
            }

            function createStock(stock){
                StockService.createStock(stock).then(
                    fetchAllStocks/*,
                     function(errResponse){
                     console.error('Error while creating User');
                     }*/
                );
            }

            function updateStock(id, stock){
                StockService.updateStock(id, stock)
                    .then(
                        fetchAllStocks/*,
                         function(errResponse){
                         console.error('Error while updating User');
                         }*/
                    );
            }

            function deleteStock(id){
                StockService.deleteStock(id)
                    .then(
                        fetchAllStocks/*,
                         function(errResponse){
                         console.error('Error while deleting User');
                         }*/
                    );
            }


            function submit() {
                console.log('Saving New User', self.stock);
                createStock(self.stock);
                reset();
            }

            function updateSub() {
                console.log('Saving New User', self.stock);
                updateStock(self.stock.id, self.stock);
                reset();
            }


            function edit(id){
                console.log('id to be edited', id);
                for(var i = 0; i < self.stocks.length; i++){
                    if(self.stocks[i].id === id) {
                        self.stock = angular.copy(self.stocks[i]);
                        break;
                    }
                }
            }

            function remove(id){
                deleteStock(id);
            }


            function reset(){
                self.stock = {
                    id:null,
                    name:'',
                    address:'',
                    numberOfSeats:null,
                    numberOfRemainingPlaces:null,
                    numberOfSectors:null,
                    height:'',
                    width:'',
                    capacity:'',
                    typeStock:{
                        id:'',
                        name:''
                    },
                    stocks:[]
                };
                $scope.myForm.$setPristine(); //reset Form
            }

        }]);
}());