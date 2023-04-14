pipeline {
    agent any
    triggers {
        cron ("0 0 * * *")
    }

    stages {
        stage('Init') {
            steps {
                echo "Testing..."
            }
        }
        stage('Run') {
            steps {
                bat "mvn test"
            }
        }
    }

    post {
        always {
            step([$class: 'Publisher', reportFilenamePattern: '**/testng-results.xml'])
        }
    }

}