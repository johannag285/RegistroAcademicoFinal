var cursoModule = angular.module('cursoModule');

cursoModule.controller('crearCursoCtrl', ['$scope', '$http', '$state', function ($scope, $http, $state) {
        var id = $state.params.id;

        $scope.curso = {};

        if (id) {
            $http.get('api/cursos/' + id).then(function (response) {
                $scope.cursos = response.data;
            }, function (error) {
                console.log(error);
            });
        }

        $scope.crearCurso = function () {
            if ($scope.curso.nom_curso && $scope.curso.PROGRAMA_id_fk) {
                $http.post('api/cursos', JSON.stringify($scope.curso)).then(function (response) {
                    //Reinicia la vaariable
                    $scope.curso = {};
                    // Nombre de la ruta definida en routes
                    $state.go('listarCurso');
                }, function (error) {
                    console.log(error);
                });
            }
        };
        
        $scope.actualizarCurso = function(){
            if ($scope.curso.nom_curso && $scope.curso.PROGRAMA_id_fk) {
                $http.put('api/cursos/'+id, JSON.stringify($scope.curso)).then(function(response){
                    //Reinicia la vaariable
                    $scope.curso = {};
                    // Nombre de la ruta definida en routes
                    $state.go('listarCurso');
                }, function(error){
                    console.log(error);
                });
            }
        };
    }]);


