/**
 * Controllers
 */

var app = angular.module('ringdbApp', ['countryService']);
app.controller('countryListController', ['$scope', 'Country',
  function($scope, Country) {
    $scope.countries = Country.query();
  }]);
