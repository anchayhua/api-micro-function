pipeline {
    agent any // Esto indica que se puede ejecutar en cualquier agente de Jenkins

    options {
        buildDiscarder (logRotator (numToKeepStr: '5'))        
    }

    environment {
        DOCKERHUB_CREDENTIALS = credentials('jenkins-dockerhub')
        SONAR_CREDENTIALS = credentials('devops')
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm // Esto verifica el código fuente desde el repositorio
            }
        }

        // stage('Build Project') {
        //     steps {
        //         sh './gradlew build' // Ejecuta el comando Gradle para construir el proyecto
        //     }
        // }

        // stage('Test JUnit') {
        //     steps {
        //         sh './gradlew test' // Ejecuta las pruebas del proyecto
        //     }
        // }

        // stage('Run SonarQube Analysis') {
        //     steps {
        //         sh './gradlew sonar \
        //                 -Dsonar.projectKey=devops \
        //                 -Dsonar.projectName=devops \
        //                 -Dsonar.token=$SONAR_CREDENTIALS_PSW' // Analiza y prueba en sonar el proyecto
        //     }
        // }

        // stage('Buil, Login & Push Image Docker Hub') {
        //     steps {
        //         sh 'docker build -t anchayhua/api-micro-function:latest .' // Construye la imagen Docker
        //         sh 'echo $DOCKERHUB_CREDENTIALS_PSW | docker login -u $DOCKERHUB_CREDENTIALS_USR --password-stdin'
        //         sh 'docker push anchayhua/api-micro-function' // Sube la imagen a un registro de Docker
        //     }
        // }

        stage('Test kubectl') {
            steps {
                echo 'Configurando contexto de Kubernetes'
                sh 'kubectl config use-context minikube'
                sh 'kubectl version'
            }
        }

        stage('Deploy') {
            steps {
                sh 'kubectl apply -f deployment.yaml'
                sh 'kubectl apply -f service.yaml'
            }
        }
    }

    post {
        // always {
        //     sh 'docker logout'
        // }
        success {
            // Acciones a realizar si el pipeline se ejecuta con éxito
            echo 'El pipeline se ha ejecutado con éxito.'
        }
        failure {
            // Acciones a realizar si el pipeline falla
            echo 'El pipeline ha fallado. Se requiere atención.'
        }
    }

}
