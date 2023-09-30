pipeline {
    agent any // Esto indica que se puede ejecutar en cualquier agente de Jenkins

    stages {
        stage('Checkout') {
            steps {
                checkout scm // Esto verifica el código fuente desde el repositorio
            }
        }

        stage('Build') {
            steps {
                sh './gradlew build' // Ejecuta el comando Gradle para construir el proyecto
            }
        }

        // stage('Test') {
        //     steps {
        //         sh './gradlew test' // Ejecuta las pruebas del proyecto
        //     }
        // }

        // stage('Run SonarQube Analysis') {
        //     steps {
        //         sh './gradlew sonar' // Analiza y prueba en sonar el proyecto
        //     }
        // }

        stage('Build Docker') {
            steps {
                sh 'docker build -t anchayhua/api-micro-function:latest .' // Construye la imagen Docker
                sh 'docker push anchayhua/api-micro-function' // Sube la imagen a un registro de Docker
            }
        }

        // stage('Test kubectl') {
        //     steps {
        //         echo 'Solo falta la autenticacion en el K8s'
        //         // sh 'kubectl version'
        //     }
        // }

        // stage('Deploy') {
        //     steps {
        //         // sh 'docker build -t anchayhua/api-micro-function:latest .' // Construye la imagen Docker
        //         // sh 'docker push anchayhua/api-micro-function' // Sube la imagen a un registro de Docker
        //         sh 'kubectl apply -f deployment.yaml'
        //         sh 'kubectl apply -f service.yaml'
        //     }
        // }

    }
}
