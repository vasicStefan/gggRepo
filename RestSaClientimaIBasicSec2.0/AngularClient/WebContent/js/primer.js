var app = angular.module('myApp', ['base64']);

app.controller('myCtrl', ['$base64', '$scope', '$http', function($base64, $scope, $http) {
	
	var porukaData = {}
	porukaData.idKlijenta = 2;
	porukaData.idVlasnika = 1;
	porukaData.sadrzaj = "ides pod...";
	porukaData.date = "kad tad"
	
	var cred = $base64.encode('user:user');
	
	$scope.sadrzaj;
	
	//naravno mogu se prosledjivati i parametri funkciji :D
	
	$scope.posaljiPoruku = function() {
		porukaData.sadrzaj = $scope.sadrzaj;
		$http({
		//	method: "POST",
			method: "GET",
		//	url: "https://localhost:8443/RestService/rest/impl/posaljiPorukuKlijentu",
			url: "http://localhost:8080/RestServiceFormAuth/rest/restic/vratiSveKategorije"
		//	data: porukaData,
		//	headers: {"Authorization":"Basic " + cred}
		}).then(function mySuccess(response) {
			console.log(response.data)
			$scope.odgovor = response.data;
		}, function error(response) {
			$scope.odgovor = response.statusText;
		})
		
	}
	
	
	$http({
		method: "GET",
		url: "http://localhost:8080/RestService/rest/impl/vratiSveKategorije",
		headers: {"Authorization":"Basic " + cred}
	}).then(function mySuccess(response) {
		$scope.odgovor = response.data;
	}, function error(response) {
		$scope.odgovor = response.statusText;
	})
}]);