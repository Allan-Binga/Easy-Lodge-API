pipeline {
    agent any
    tools {
        maven 'Maven 3.8.7'  // Use the Maven version configured in Jenkins
        jdk 'JDK23'     // Use the JDK configured in Jenkins
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
        // stage('Debug Environment') {
        //     steps {
        //         sh 'echo $JAVA_HOME'
        //     // sh '/var/jenkins_home/tools/hudson.model.JDK/JDK_23/bin/java -version'
        //     }
        // }
        stage('Build with Maven') {
            steps {
                sh 'mvn clean package -DskipTests'  // Skipping tests for build speed
            }
        }
        // stage('Run Tests') {
        //     steps {
        //         sh 'mvn test'
        //     }
        // }
        stage('Package and Archive') {
            steps {
                archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
            }
        }
    }
// post {
//     success {
//         slackSend(
//             color: 'good',
//             message: 'Spring Boot build & tests passed! ✅'
//         )
//     }
//     failure {
//         slackSend(
//             color: 'danger',
//             message: 'Spring Boot build/tests failed. ❌'
//         )
//     }
// }
}
