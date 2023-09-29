pipeline {
    agent any // Esto indica que se puede ejecutar en cualquier agente de Jenkins

    stages {
        stage('Checkout') {
            steps {
                checkout scm // Esto verifica el código fuente desde tu repositorio
            }
        }

        stage('Build') {
            steps {
                sh './gradlew build' // Ejecuta el comando Gradle para construir tu proyecto
            }
        }

        stage('Test') {
            steps {
                sh './gradlew test' // Ejecuta las pruebas de tu proyecto
            }
        }

        stage('Deploy') {
            steps {
                // Aquí puedes agregar comandos para desplegar tu aplicación (por ejemplo, en un servidor de aplicaciones)
            }
        }
    }
}
