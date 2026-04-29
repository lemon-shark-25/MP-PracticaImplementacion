pipeline {
    agent any

    environment {
        SONAR_TOKEN = credentials('sonar-token')
    }

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
