pipeline{
    agent any

    stages{
        stage('Compile'){
            steps{
                withMaven(maven: 'maven_3'){
                    bat 'mvn clean compile'
                }
            }
        }
        stage('Testing'){
            steps{
                 withMaven(maven: 'maven_3'){
                     bat 'mvn test'
                 }
            }
        }
    }
}