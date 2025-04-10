pipeline {
    agent any
    stages {
        stage('Checkout') {
            steps {
                // Pull code from the Git repository
                git url: 'https://github.com/AmolGit005/Ecom_Automation_Framework.git', branch: 'main'
            }
        }
        stage('Build') {
            steps {
                // Run Maven build
                bat 'mvn clean'
            }
        }
        stage('Test') {
            steps {
                // Run Maven tests
                bat 'mvn test -Dbrowser=chromium'
                bat 'mvn test -Dbrowser=firefox'
                bat 'mvn test -Dbrowser=webkit'
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