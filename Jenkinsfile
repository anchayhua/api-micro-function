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
                echo 'Paso 1: Acceder al servidor de producción'
                echo 'Paso 2: Detener la versión anterior de la aplicación'
                echo 'Paso 3: Copiar la nueva versión de la aplicación'
                echo 'Paso 4: Iniciar la nueva versión de la aplicación'
                echo 'Paso 5: Verificar que la aplicación esté funcionando correctamente'
            }
        }
    }
}
