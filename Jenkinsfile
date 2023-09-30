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

        stage('SonarQube Analysis') {
            steps {
                script {
                    def scannerHome = tool name: 'SonarQube Scanner', type: 'hudson.plugins.sonar.SonarRunnerInstallation'
                    withSonarQubeEnv('SonarQube Server') {
                        sh "${scannerHome}/bin/sonar-scanner -Dsonar.projectKey=devops -Dsonar.sources=src -Dsonar.host.url=http://localhost:9000 -Dsonar.login=sqp_4c3a3b6ce8092c9e4ec29ed61aa16a7f746b810c"
                    }
                }
            }
        }

        stage('Test kubectl') {
            steps {
                echo 'Solo falta la autenticacion en el K8s'
                // sh 'kubectl version'
            }
        }

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
