<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>AngularJS $http Example</title>
    <style>
        .username.ng-valid {
            background-color: lightgreen;
        }
        .username.ng-dirty.ng-invalid-required {
            background-color: red;
        }
        .username.ng-dirty.ng-invalid-minlength {
            background-color: yellow;
        }

        .email.ng-valid {
            background-color: lightgreen;
        }
        .email.ng-dirty.ng-invalid-required {
            background-color: red;
        }
        .email.ng-dirty.ng-invalid-email {
            background-color: yellow;
        }

    </style>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
    <link href="<c:url value='css/app.css' />" rel="stylesheet"></link>
</head>
<body ng-app="myApp" class="ng-cloak">
<div class="generic-container" ng-controller="RoleController as ctrl">
    <div class="panel panel-default">
        <div class="panel-heading"><span class="lead">User Registration Form </span></div>
        <div class="formcontainer">
            <form ng-submit="ctrl.submit()" name="myForm" class="form-horizontal">
                <div class="row">
                    <div class="form-group col-md-12">
                        <label class="col-md-2 control-lable" for="file">ID</label>
                        <div class="col-md-7">
                            <input type="text" ng-model="ctrl.role.id" name="id" class="username form-control input-sm" placeholder="Enter your ID" <%--required ng-minlength="3"--%>/>
                            <div class="has-error" ng-show="myForm.$dirty">
                                <span ng-show="myForm.id.$error.required">This is a required field</span>
                                <%--<span ng-show="myForm.id.$error.minlength">Minimum length required is 3</span>--%>
                                <span ng-show="myForm.id.$invalid">This field is invalid </span>
                            </div>
                        </div>
                    </div>
                </div>


                <div class="row">
                    <div class="form-group col-md-12">
                        <label class="col-md-2 control-lable" for="file">Name</label>
                        <div class="col-md-7">
                            <input type="text" ng-model="ctrl.role.name" class="form-control input-sm" placeholder="Enter your Name"/>
                        </div>
                    </div>
                </div>

                <%--<div class="row">
                    <div class="form-group col-md-12">
                        <label class="col-md-2 control-lable" for="file">Email</label>
                        <div class="col-md-7">
                            <input type="email" ng-model="ctrl.user.email" name="email" class="email form-control input-sm" placeholder="Enter your Email" required/>
                            <div class="has-error" ng-show="myForm.$dirty">
                                <span ng-show="myForm.email.$error.required">This is a required field</span>
                                <span ng-show="myForm.email.$invalid">This field is invalid </span>
                            </div>
                        </div>
                    </div>
                </div>--%>

                <div class="row">
                    <div class="form-actions floatRight">
                        <input type="submit"  value="Add" class="btn btn-primary btn-sm" ng-disabled="myForm.$invalid">
                        <button type="button" ng-click="ctrl.updateSub()" value="Update" class="btn btn-primary btn-sm" ng-disabled="myForm.$invalid">Update</button>
                        <button type="button" ng-click="ctrl.reset()" class="btn btn-warning btn-sm" ng-disabled="myForm.$pristine">Reset Form</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
    <div class="panel panel-default">
        <!-- Default panel contents -->
        <div class="panel-heading"><span class="lead">List of Roles </span></div>
        <div class="tablecontainer">
            <table class="table table-hover">
                <thead>
                <tr>
                    <th>ID.</th>
                    <th>Name</th>
                    <th width="20%"></th>
                </tr>
                </thead>
                <tbody>
                <tr ng-repeat="u in ctrl.roles">
                    <td><span>{{ u.id }}</span></td>
                    <td><span>{{ u.name }}</span></td>
                    <td>
                        <button type="button" ng-click="ctrl.edit(u.id)" class="btn btn-success custom-width">Edit</button>  <button type="button" ng-click="ctrl.remove(u)" class="btn btn-danger custom-width">Remove</button>
                    </td>
                </tr>
                </tbody>
            </table>
        </div>
    </div>
</div>

<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.4/angular.js"></script>
<script src="<c:url value='js/app.js' />"></script>
<script src="<c:url value='js/service/role_service.js' />"></script>
<script src="<c:url value='js/controller/role_controller.js' />"></script>
</body>
</html>