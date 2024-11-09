pipeline {
    agent any
    stages {
        stage('Clonar Repositorio') {
            steps {
                git url: 'https://github.com/rsotelo14/pa-pedidos.git', branch: 'master'
            }
        }
       stage('Publicar Documentación') {
            steps {
                
                // Mueve la documentación generada al directorio de destino
                sh 'mv documentation_project_final.html /var/www/html/documentins/pedidos.html'
			
           }
        }
    }
}

