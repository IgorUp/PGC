/**
 * Created by igor on 5.12.16.
 */
(function () {
    'use strict';

    angular.module('pgc.controllers')
        .controller('ClientController', ['$scope', 'ClientService', 'RoleService', function($scope, ClientService, RoleService) {
            var self = this;
            self.client={
                id:null,
                name:'',
                email:'',
                compani:'',
                password:'',
                firstName:'',
                lastName:'',
                role:{id:'', name:''}
            };

            self.roles=[];

            self.clients = [];

            self.submit = submit;
            self.edit = edit;
            self.remove = remove;
            self.reset = reset;
            self.updateSub = updateSub;


            fetchAllUsers();
            fetchAllRoles();

            function fetchAllRoles(){
                RoleService.fetchAllRoles().then(
                    function(d) {
                        self.roles = d.data;
                        if (d.data.length > 0)
                            self.client.role = d.data[0];
                    }/*,
                     function(errResponse){
                     console.error('Error while fetching Roles');
                     }*/
                );
            }

            function fetchAllUsers(){
                ClientService.fetchAllUsers().then(
                    function(d) {
                        self.clients = d.data;
                    }/*,
                     function(errResponse){
                     console.error('Error while fetching Roles');
                     }*/
                );
            }

            function createUser(id, client){
                ClientService.createUser(id,client).then(
                    fetchAllUsers/*,
                     function(errResponse){
                     console.error('Error while creating User');
                     }*/
                );
            }

            function updateUser(id, client){
                ClientService.updateUser(id, client)
                    .then(
                        fetchAllUsers/*,
                         function(errResponse){
                         console.error('Error while updating User');
                         }*/
                    );
            }

            function deleteUser(client){
                ClientService.deleteUser(client)
                    .then(
                        fetchAllUsers/*,
                         function(errResponse){
                         console.error('Error while deleting User');
                         }*/
                    );
            }


            function submit() {
                console.log('Saving New User', self.client);
                createUser(self.client.id, self.client);
                reset();
            }

            function updateSub() {
                console.log('Saving New User', self.client);
                updateUser(self.client.id, self.client);
                reset();
            }


            function edit(id){
                console.log('id to be edited', id);
                for(var i = 0; i < self.clients.length; i++){
                    if(self.clients[i].id === id) {
                        self.client = angular.copy(self.clients[i]);
                        break;
                    }
                }
            }

            function remove(client){
                self.client.id = role.id;
                self.client.name = client.name;
                self.client.new = false;
                deleteUser(self.client);
            }


            function reset(){
                self.client={id:null,name:'',email:'',compani:'',password:'',firstName:'',lastName:'',role:'',idRole:''};
                $scope.myForm.$setPristine(); //reset Form
            }

        }]);
}());

