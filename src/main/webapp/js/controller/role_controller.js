'use strict';

angular.module('myApp').controller('RoleController', ['$scope', 'RoleService', function($scope, RoleService) {
    var self = this;
    self.role={id:'',name:''};
    self.roles = [];

    self.submit = submit;
    self.edit = edit;
    self.remove = remove;
    self.reset = reset;
    self.updateSub = updateSub;


    fetchAllUsers();

    function fetchAllUsers(){
        RoleService.fetchAllUsers().then(
            function(d) {
                self.roles = d.data;
            }/*,
            function(errResponse){
                console.error('Error while fetching Roles');
            }*/
        );
    }

    function createUser(id, role){
        RoleService.createUser(id,role).then(
            fetchAllUsers/*,
            function(errResponse){
                console.error('Error while creating User');
            }*/
        );
    }

    function updateUser(id, role){
        RoleService.updateUser(id, role)
            .then(
            fetchAllUsers/*,
            function(errResponse){
                console.error('Error while updating User');
            }*/
        );
    }

    function deleteUser(role){
        RoleService.deleteUser(role)
            .then(
            fetchAllUsers/*,
            function(errResponse){
                console.error('Error while deleting User');
            }*/
        );
    }

/*    function submit() {
        if(self.user.id===null){
            console.log('Saving New User', self.user);
            createUser(self.user);
        }else{
            updateUser(self.user, self.user.id);
            console.log('User updated with id ', self.user.id);
        }
        reset();
    }*/

    function submit() {
        console.log('Saving New User', self.role);
        createUser(self.role.id, self.role);
        reset();
    }

    function updateSub() {
        console.log('Saving New User', self.role);
        updateUser(self.role.id, self.role);
        reset();
    }

        /*    function edit(id, role) {
                for(var i = 0; i < self.roles.length; i++) {
                    if (self.roles[i].id === id) {
                        console.log('id to be edited', id);
                        updateUser(role, id);
                        break;
                    }
                }
                reset();
            }*/

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
        console.log('id to be deleted', role);
/*        if(self.role.id === id) {//clean form if the user to be deleted is shown there.
            reset();
        }*/
        self.role.id = role.id;
        self.role.name = role.name;
        self.role.new = false;
        deleteUser(self.role);
    }


    function reset(){
        self.user={id:'',name:''};
        $scope.myForm.$setPristine(); //reset Form
    }

}]);
