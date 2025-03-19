pipeline {
    agent any
    tools {
        maven 'Maven 3.8.7'
        jdk 'JDK 23'
    }
    environment {
        MAVEN_OPTS = '-Dmaven.test.failure.ignore=true'
        DOCKERHUB_CREDENTIALS = credentials('allanbinga-dockerhub')
    }
    stages {
        stage('Clone Repository') {
            steps {
                git 'https://github.com/Allan-Binga/Easy-Lodge-API'
            }
        }
    
        stage('Build with Maven') {
            steps {
                sh 'mvn clean package -DskipTests'
            }
        }
        stage('Check docker version') {
            steps {
                sh 'docker -version'
            }
        }
        // stage('Build Docker Image') {
        //     steps {
        //         sh 'docker build -t allanbinga/hotelmanagement:v1 .'
        //     }
        // }
        // stage('Login to DockerHub') {
        //     steps{
        //         sh 'echo $DOCKERHUB_CREDENTIALS | docker login -u $DOCKERHUB_CREDENTIALS --password-stdin'
        //     }
        // }
        // stage('Push to DockerHUb') {
        //     steps {
        //         sh 'docker push allanbinga/hotelmanagement:v1'
        //     }
        // }
    }
    post {
        success {
            slackSend(
                channel: '#storeapi',
                color: 'good',
                message: 'Everything good.'
            )
        }
        failure {
            slackSend(
                channel: '#storeapi',
                color: 'danger',
                message: 'Something went wrong.'
            )
        }
        always {
            sh 'docker logout'
        }
    }
}
