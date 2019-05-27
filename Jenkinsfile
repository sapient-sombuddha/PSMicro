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
                bat "copy C:\\Users\\somchakr\\.jenkins\\workspace\\PSMicro\\target\\*.jar C:\\Users\\somchakr\\Desktop\\apache-tomcat-9.0.20\\webapps\\"
            }
        }
    }
}