var profesorModule = angular.module('profesorModule');

profesorModule.controller('listarProfesorCtrl', ['$scope', '$http', '$state', function ($scope, $http, $state) {
        $scope.profesores = new Array();

        $http.get('api/profesores').then(function (response) {
            console.log(response);
            $scope.profesores = response.data;
        }, function (error) {
            console.log(error);
        });
        
        $scope.eliminarProfesores = function(id){
            $http.delete('api/profesores/'+id).then(function(response){
                // Recargar la vista 
                $state.reload(); 
            }, function(error){
                console.log(error);
            });
        };
}]);

