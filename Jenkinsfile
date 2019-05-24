pipeline{
    agent any

    stages{
        stage('Compile'){
            steps{
                withMaven(maven: 'maven_version'){
                    sh 'mvn clean compile'
                }
            }
        }
        stage('Test'){
            steps{
                 withMaven(maven: 'maven_version'){
                     sh 'mvn test'
                 }
            }
        }
    }
}