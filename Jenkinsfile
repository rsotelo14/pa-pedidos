pipeline {
    agent any
    stages {
        stage('Clonar Repositorio') {
            steps {
                git url: 'https://github.com/rsotelo14/pa-pedidos.git', branch: 'master'
            }
        }
        stage('Compilar Proyecto') {
            steps {
                sh 'mvn clean compile'
            }
        }
        stage('Ejecutar Pruebas') {
            steps {
                sh 'mvn test'
            }
        }
        stage('Generar Documentación') {
            steps {
                sh 'mvn javadoc:javadoc'
            }
        }
        stage('Publicar Documentación') {
            steps {
			// Genera la documentación con Javadoc
                sh 'mvn javadoc:javadoc'
                
                // Mueve la documentación generada al directorio de destino
                sh 'sudo mv target/site/apidocs /var/www/html/documentins/java_project_docs'
			
           }
        }
    }
    post {
        always {
            archiveArtifacts artifacts: 'target/**/*.jar', allowEmptyArchive: true
            junit 'target/surefire-reports/*.xml'
        }
    }
}

