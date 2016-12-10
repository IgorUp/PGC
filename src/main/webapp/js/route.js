/**
 * Created by igor on 8.12.16.
 */

/**
 * Created by igor on 8.12.16.
 */
(function () {
    'use strict';
//Посмотреть завтра что тут происходит
    angular.module('pgc.controllers')
        .controller('AppCtrl', function($scope) {
            $scope.myDate = new Date();

            $scope.minDate = new Date(
                $scope.myDate.getFullYear(),
                $scope.myDate.getMonth() - 2,
                $scope.myDate.getDate());

            $scope.maxDate = new Date(
                $scope.myDate.getFullYear(),
                $scope.myDate.getMonth() + 2,
                $scope.myDate.getDate());

            $scope.onlyWeekendsPredicate = function(date) {
                var day = date.getDay();
                return day === 0 || day === 6;
            };
        });
}());