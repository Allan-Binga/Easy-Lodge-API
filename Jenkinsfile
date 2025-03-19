pipeline {
    agent any
    tools {
        maven 'Maven 3.8.7'
        jdk 'JDK 17'
    }
    environment {
        MAVEN_OPTS = '-Dmaven.test.failure.ignore=true'
    }
    stages {
        stage('Clone Repository') {
            steps {
                git 'https://github.com/Allan-Binga/Easy-Lodge-API'
            }
        }
        stage('Debug Environment') {
            steps {
                sh 'echo JAVA_HOME=$JAVA_HOME'
                sh 'java -version'
            }
        }
        stage('Build with Maven') {
            steps {
                sh 'mvn clean package -DskipTests'
            }
        }
        stage('Package and Archive') {
            steps {
                archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
            }
        }
    }
}
