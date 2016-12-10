(function() {

    'use strict';

    angular.module('pgc.controllers')
        .controller('TypeStockController', ['$scope', 'TypeStockService', function($scope, TypeStockService) {
        var self = this;
        self.typeStock={id:'',name:''};
        self.typeStocks = [];

        self.submit = submit;
        self.edit = edit;
        self.remove = remove;
        self.reset = reset;
        self.updateSub = updateSub;


        fetchAllTypeStocks();

        function fetchAllTypeStocks(){
            TypeStockService.fetchAllTypeStocks().then(
                function(d) {
                    self.typeStocks = d.data;
                }/*,
                 function(errResponse){
                 console.error('Error while fetching Roles');
                 }*/
            );
        }

        function createTypeStock(typeStock){
            TypeStockService.createTypeStock(typeStock).then(
                fetchAllTypeStocks/*,
                 function(errResponse){
                 console.error('Error while creating User');
                 }*/
            );
        }

        function updateTypeStock(id, typeStock){
            TypeStockService.updateTypeStock(id, typeStock)
                .then(
                    fetchAllTypeStocks/*,
                     function(errResponse){
                     console.error('Error while updating User');
                     }*/
                );
        }

        function deleteTypeStock(typeStock){
            TypeStockService.deleteTypeStock(typeStock)
                .then(
                    fetchAllTypeStocks/*,
                     function(errResponse){
                     console.error('Error while deleting User');
                     }*/
                );
        }


        function submit() {
            console.log('Saving New User', self.typeStock);
            createTypeStock(self.typeStock);
            reset();
        }

        function updateSub() {
            console.log('Saving New User', self.typeStock);
            updateTypeStock(self.typeStock.id, self.typeStock);
            reset();
        }

        function edit(id){
            console.log('id to be edited', id);
            for(var i = 0; i < self.typeStocks.length; i++){
                if(self.typeStocks[i].id === id) {
                    self.typeStock = angular.copy(self.typeStocks[i]);
                    break;
                }
            }
        }

        function remove(typeStock){
            deleteTypeStock(self.typeStock);
        }


        function reset(){
            self.typeStock={id:'',name:''};
            $scope.myForm.$setPristine(); //reset Form
        }

    }]);
}());

