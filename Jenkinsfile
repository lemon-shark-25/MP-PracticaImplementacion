pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build') {
            steps {
                bat 'ant clean compile'
            }
        }

        stage('SonarQube Analysis') {
            steps {
                bat 'ant sonar'
            }
        }
    }
}
