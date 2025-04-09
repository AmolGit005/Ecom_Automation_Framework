pipeline {
    agent any
    stages {
        stage('Checkout') {
            steps {
                // Pull code from the Git repository
                git url: 'https://github.com/AmolGit005/ShoppingCart_Automation.git', branch: 'main'
            }
        }
        stage('Build') {
            steps {
                // Run Maven build
                bat 'mvn clean install'
            }
        }
        stage('Test') {
            steps {
                // Run Maven tests
                bat 'mvn test'
            }
        }
        stage('Package') {
            steps {
                // Package the application
                bat 'mvn package'
            }
        }
    }
    post {
        success {
            echo 'Build and test completed successfully.'
        }
        failure {
            echo 'Build or test failed. Check logs for details.'
        }
    }
}