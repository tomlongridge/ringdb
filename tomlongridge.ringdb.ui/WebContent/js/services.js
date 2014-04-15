/**
 * 
 */

var countryService = angular.module('countryService', ['ngResource']);

countryService.factory('Country',
		['$resource',
		 function($resource) {
			return $resource(
					'http://localhost:8080/Service/countries',
					{},
					{
						query: { method:'GET', params: { }, isArray:true }
					}
			);
		}
	]
);