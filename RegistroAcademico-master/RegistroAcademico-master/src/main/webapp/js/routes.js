var app = angular.module("RegistroAcademico");

app.config(["$stateProvider", "$urlRouterProvider", function ($stateProvider, $urlRouterProvider) {
        
        //Otherwise - control 404
        $urlRouterProvider.otherwise('/');
        
        //Por cada ruta se crea un nuevo estado CURSO
        $stateProvider.state("listarCurso", {
           url: '/',
           views:{
               mainView: {
                   templateUrl: './js/curso/listar/listarCurso.html',
                   controller: 'listarCursoCtrl'
               }
           }
        });
        
        
        
        $stateProvider.state("crearCurso", {
           url: '/cursos',
           views:{
               mainView:{
                   templateUrl: './js/curso/crearActualizar/crearActualizar.html',
                   controller: 'crearCursoCtrl'
               }
           }
        });
        
        $stateProvider.state("editarCurso", {
            url: '/cursos/:id',
            views:{
               mainView:{
                   templateUrl: './js/curso/crearActualizar/crearActualizar.html',
                   controller: 'crearCursoCtrl'
               }
           }
        });
        
        
        //Por cada ruta se crea un nuevo estado PERSONA
        $stateProvider.state("listarPersona", {
           url: '/',
           views:{
               mainView: {
                   templateUrl: './js/persona/listar/listarPersona.html',
                   controller: 'listarPersonaCtrl'
               }
           }
        });
        
        
        
        $stateProvider.state("crearPersona", {
           url: '/personas',
           views:{
               mainView:{
                   templateUrl: './js/persona/crearActualizar/crearActualizar.html',
                   controller: 'crearPersonaCtrl'
               }
           }
        });
        
        $stateProvider.state("editarPersona", {
            url: '/personas/:id',
            views:{
               mainView:{
                   templateUrl: './js/persona/crearActualizar/crearActualizar.html',
                   controller: 'crearPersonaCtrl'
               }
           }
        });
        
        
        //Por cada ruta se crea un nuevo estado PROFESOR
        $stateProvider.state("listarProfesor", {
           url: '/',
           views:{
               mainView: {
                   templateUrl: './js/profesor/listar/listarProfesor.html',
                   controller: 'listarProfesorCtrl'
               }
           }
        });
        
        
        
        $stateProvider.state("crearProfesor", {
           url: '/profesores',
           views:{
               mainView:{
                   templateUrl: './js/profesor/crearActualizar/crearActualizar.html',
                   controller: 'crearProfesorCtrl'
               }
           }
        });
        
        $stateProvider.state("editarProfesor", {
            url: '/profesores/:id',
            views:{
               mainView:{
                   templateUrl: './js/profesor/crearActualizar/crearActualizar.html',
                   controller: 'crearProfesorCtrl'
               }
           }
        });
        
        
}]);


