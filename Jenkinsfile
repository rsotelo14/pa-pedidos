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

		stage('Send Email') {
            steps {
                emailext(
                    subject: "Actualizacion en Pedidos",
                    body: "Se acaba de hacer una actualización en el repositorio del proyecto de Pedidos. Para ver la nueva documentación vaya a http://ec2-34-201-54-91.compute-1.amazonaws.com",
                    to: "rsotelosilva@gmail.com",
                    from: "rsotelosilva@gmail.com"
                )
            }
        }
    }
}

