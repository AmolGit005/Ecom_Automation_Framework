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
        stage('Publish HTML Report') {
                    steps {
                        publishHTML([
                            allowMissing: false,
                            alwaysLinkToLastBuild: true,
                            keepAll: true,
                            reportDir: 'Reports',
                            reportFiles: 'index.html',
                            reportName: 'Extent_Report'
                        ])
                    }
                }

    }
    post {
            success {
                emailext(
                    subject: 'Build SUCCESS: ${JOB_NAME} #${BUILD_NUMBER}',
                    body: """
                        <p>Good news!</p>
                        <p>Build #${BUILD_NUMBER} succeeded.</p>
                        <p><a href="${BUILD_URL}">View Build</a></p>
                        <p><a href="${BUILD_URL}HTML_20Report">View Extent Report</a></p>
                    """,
                    recipientProviders: [[$class: 'DevelopersRecipientProvider']],
                    to: 'your-team@example.com'
                )
            }

            failure {
                emailext(
                    subject: 'Build FAILED: ${JOB_NAME} #${BUILD_NUMBER}',
                    body: """
                        <p>Unfortunately, the build failed.</p>
                        <p><a href="${BUILD_URL}">View Build Logs</a></p>
                    """,
                    recipientProviders: [[$class: 'DevelopersRecipientProvider']],
                    to: 'your-team@example.com'
                )
            }
        }
}