var profesorModule = angular.module('profesorModule');

profesorModule.controller('crearProfesorCtrl', ['$scope', '$http', '$state', function ($scope, $http, $state) {
        var id = $state.params.id;

        $scope.profesor = {};

        if (id) {
            $http.get('api/profesores/' + id).then(function (response) {
                $scope.profesores = response.data;
            }, function (error) {
                console.log(error);
            });
        }

        $scope.crearProfesor = function () {
            if ($scope.profesor.cod_profesor && $scope.profesor.PERSONA_id_fk && $scope.profesor.PROGRAMA_id_fk && $scope.profesor.area_profundizacion) {
                $http.post('api/profesores', JSON.stringify($scope.profesor)).then(function (response) {
                    //Reinicia la vaariable
                    $scope.profesor = {};
                    // Nombre de la ruta definida en routes
                    $state.go('listarProfesor');
                }, function (error) {
                    console.log(error);
                });
            }
        };
        
        $scope.actualizarProfesor = function(){
            if ($scope.profesor.cod_profesor && $scope.profesor.PERSONA_id_fk && $scope.profesor.PROGRAMA_id_fk && $scope.profesor.area_profundizacion) {
                $http.put('api/profesores/'+id, JSON.stringify($scope.profesor)).then(function(response){
                    //Reinicia la vaariable
                    $scope.profesor = {};
                    // Nombre de la ruta definida en routes
                    $state.go('listarProfesor');
                }, function(error){
                    console.log(error);
                });
            }
        };
    }]);


