(function() {

    'use strict';

    angular.module('pgc.controllers')
        .controller('CommController', ['$scope', 'CommService', function($scope, CommService) {
        var self = this;
        self.comm={id:1,name:'',email:'',subject:'',message:''};
        self.comms = [];

        self.submit = submit;
        self.reset = reset;


        fetchAllComms();

        function fetchAllComms(){
            CommService.fetchAllComms().then(
                function(d) {
                    self.comms = d.data;
                }/*,
                 function(errResponse){
                 console.error('Error while fetching comms');
                 }*/
            );
        }

        function createComm(comm){
            CommService.createComm(comm).then(
                fetchAllComms/*,
                 function(errResponse){
                 console.error('Error while creating User');
                 }*/
            );
        }


        function submit() {
            console.log('Saving New User', self.comm);
            createComm(self.comm);
            reset();
        }


        function reset(){
            self.comm={id:null,name:'',email:'',subject:'',message:''};
            $scope.myForm.$setPristine(); //reset Form
        }

    }]);
}());

