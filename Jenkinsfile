pipeline {
    agent any
    environment {
        MAVEN_HOME = 'C:\\apache-maven-3.9.6'
        PATH = "C:\\apache-maven-3.9.6\\bin;${env.PATH};C:\\Program Files\\OpenLogic\\jdk-21.0.3.1-hotspot\\bin"
    }
    stages {
        stage('Clean') {
            steps {
                // Clean up any temporary files or resources
                bat 'mvn clean'
            }
        }
        stage('Build') {
            steps {
                // Clean and build the Maven project
                bat 'mvn compile' // or 'mvn package'
            }
        }
        stage('Test') {
            steps {
                // Run tests
                bat 'mvn test'
            }
        }
        stage('Deploy') {
            steps {
                // Placeholder for deployment steps
                // Replace this with your deployment script or commands
                echo 'Deploying the application...'
            }
        }
        stage('Clean Up') {
            steps {
                // Clean up any temporary files or resources
                bat 'mvn clean'
            }
        }
    }
    post {
        success {
            echo 'Pipeline executed successfully!'
        }
        failure {
            echo 'Pipeline failed!'
        }
    }
}
