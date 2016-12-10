(function() {

    'use strict';

    angular.module('pgc.controllers')
        .controller('RoleController', ['$scope', 'RoleService', function($scope, RoleService) {
        var self = this;
        self.role={id:'',name:''};
        self.roles = [];

        self.submit = submit;
        self.edit = edit;
        self.remove = remove;
        self.reset = reset;
        self.updateSub = updateSub;


        fetchAllRoles();

        function fetchAllRoles(){
            RoleService.fetchAllRoles().then(
                function(d) {
                    self.roles = d.data;
                }/*,
                 function(errResponse){
                 console.error('Error while fetching Roles');
                 }*/
            );
        }

        function createRole(id, role){
            RoleService.createRole(id,role).then(
                fetchAllRoles/*,
                 function(errResponse){
                 console.error('Error while creating User');
                 }*/
            );
        }

        function updateRole(id, role){
            RoleService.updateRole(id, role)
                .then(
                    fetchAllRoles/*,
                     function(errResponse){
                     console.error('Error while updating User');
                     }*/
                );
        }

        function deleteRole(role){
            RoleService.deleteRole(role)
                .then(
                    fetchAllRoles/*,
                     function(errResponse){
                     console.error('Error while deleting User');
                     }*/
                );
        }


        function submit() {
            console.log('Saving New User', self.role);
            createRole(self.role.id, self.role);
            reset();
        }

        function updateSub() {
            console.log('Saving New User', self.role);
            updateRole(self.role.id, self.role);
            reset();
        }

        function edit(id){
            console.log('id to be edited', id);
            for(var i = 0; i < self.roles.length; i++){
                if(self.roles[i].id === id) {
                    self.role = angular.copy(self.roles[i]);
                    break;
                }
            }
        }

        function remove(role){
            self.role.id = role.id;
            self.role.name = role.name;
            self.role.new = false;
            deleteRole(self.role);
        }


        function reset(){
            self.role={id:'',name:''};
            $scope.myForm.$setPristine(); //reset Form
        }

    }]);
}());

