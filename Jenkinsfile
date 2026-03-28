pipeline {
    agent any

    stages {
		
		stage('Clean') {
            steps {
                deleteDir()
            }
        }

        stage('Build with Maven') {
            steps {
                sh 'mvn clean package'
            }
        }

        stage('Build Docker Image') {
            steps {
                sh 'docker build -t user-service .'
            }
        }

    }
}