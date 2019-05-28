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

        stage('Packaging'){
             steps{
                  withMaven(maven: 'maven_3'){
                      bat 'mvn package'
                  }
             }
        }

        stage('Deploy'){
            steps{
                withMaven(maven: 'maven_3'){
                    bat 'mvn tomcat7:redeploy'
                }
            }
        }
    }
}