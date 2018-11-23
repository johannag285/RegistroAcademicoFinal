var personaModule = angular.module('personaModule');

personaModule.controller('crearPersonaCtrl', ['$scope', '$http', '$state', function ($scope, $http, $state) {
        var id = $state.params.id;

        $scope.persona = {};

        if (id) {
            $http.get('api/personas/' + id).then(function (response) {
                $scope.personas = response.data;
            }, function (error) {
                console.log(error);
            });
        }

        $scope.crearPersona = function () {
            if ($scope.persona.nom_persona && $scope.persona.apelllido_persona && $scope.persona.tipo_documento && $scope.persona.num_documento && $scope.persona.genero && $scope.persona.email) {
                $http.post('api/personas', JSON.stringify($scope.persona)).then(function (response) {
                    //Reinicia la vaariable
                    $scope.persona = {};
                    // Nombre de la ruta definida en routes
                    $state.go('listarPersona');
                }, function (error) {
                    console.log(error);
                });
            }
        };
        
        $scope.actualizarPersona = function(){
            if ($scope.persona.nom_persona && $scope.persona.apelllido_persona && $scope.persona.tipo_documento && $scope.persona.num_documento && $scope.persona.genero && $scope.persona.email) {
                $http.put('api/personas/'+id, JSON.stringify($scope.persona)).then(function(response){
                    //Reinicia la vaariable
                    $scope.persona = {};
                    // Nombre de la ruta definida en routes
                    $state.go('listarPersona');
                }, function(error){
                    console.log(error);
                });
            }
        };
    }]);

