pipeline {
    agent any
    parameters {
        string(name: 'browser', defaultValue: 'chrome', description: 'Browser to use')
        booleanParam(name: 'headless', defaultValue: true, description: 'Run in headless mode')
    }
    environment {
        MAVEN_HOME = 'C:\\apache-maven-3.9.6'
        PATH = "C:\\apache-maven-3.9.6\\bin;${env.PATH};C:\\Program Files\\OpenLogic\\jdk-21.0.3.1-hotspot\\bin"
        headless = 'true'
        url = 'https://www.flipkart.com/'
        chromeDriverPath = 'C:\\Users\\saumyapatel\\eclipse-workspace\\ExitTest\\src\\main\\resources\\drivers\\chromedriver.exe'
        firefoxDriverPath = 'C:\\Users\\saumyapatel\\eclipse-workspace\\ExitTest\\src\\main\\resources\\drivers\\geckodriver.exe'
        ieDriverPath = 'C:\\Users\\saumyapatel\\eclipse-workspace\\ExitTest\\src\\main\\resources\\drivers\\IEDriverServer.exe'
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
                script {
                    echo "Headless mode: ${headless}"
                    echo "URL: ${url}"
                    echo "ChromeDriver path: ${chromeDriverPath}"
                   // mvnTestCmd = "mvn test -Dbrowser=${params.browser} -Dheadless=${params.headless}"
                    //sh mvnTestCmd
                    // Run your build commands here
                }
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
