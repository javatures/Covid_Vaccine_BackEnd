pipeline {
    agent any

    stages {
        stage('Build') {
             steps {
                 echo 'Compile project'
                 sh "pwd"
                 sh "cd covid_vaccine/"
    
    sh "chmod +x gradlew"
    sh "./gradlew build"
}
        }
        stage('Test') {
            steps {
                echo 'Testing..'
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying....'
            }
        }
    }
}
