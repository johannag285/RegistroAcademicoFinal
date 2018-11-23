var personaModule = angular.module('personaModule');

personaModule.controller('listarPersonaCtrl', ['$scope', '$http', '$state', function ($scope, $http, $state) {
        $scope.personas = new Array();

        $http.get('api/personas').then(function (response) {
            console.log(response);
            $scope.personas = response.data;
        }, function (error) {
            console.log(error);
        });
        
        $scope.eliminarPersona = function(id){
            $http.delete('api/personas/'+id).then(function(response){
                // Recargar la vista 
                $state.reload(); 
            }, function(error){
                console.log(error);
            });
        };
}]);


