# 

## Setup, using Jenkins in a docker image

```
$ docker run -d -p 8080:8080 -p 50000:50000 jenkins/jenkins:lts-jdk11
```

https://github.com/jenkinsci/docker/blob/master/README.md

## Create a new job

## Add Credentials

## Checkout

## Assemble

Compile Java task

Path desde a root do repositório


## Test

## Archive

## Final Pipeline Script

```
pipeline {
    
    agent any
    
    stages {
        
        stage("Checkout") {
            steps{
                git credentialsId: 'bitbucket-credentials', url: 'https://bitbucket.org/Joao_Pinto_1201765/devops-20-21-1201765/src/master/'
            }
        }
        
        stage("Assemble") {
            steps{
                echo 'Assemble'
                
                dir('Ca2/part_2/tut-basic-gradle/'){
                    sh './gradlew clean assemble'
                }
            }
        }
    
        stage("Test") {
            steps{
                echo 'Test'
                dir('Ca2/part_2/tut-basic-gradle/'){
                    sh './gradlew test'
                    junit 'build/test-results/**/*.xml'
                }
            }
        }
        
        stage("Archive") {
            steps{
                echo 'Archive'
                dir('Ca2/part_2/tut-basic-gradle/'){
                    archiveArtifacts artifacts: 'build/libs/**/*.jar'    
                }
            }
        }
        
    }
}
```

## Jenkinsfile

```
pipeline {
    
    agent any
    
    stages {
        
        stage("Checkout") {
            steps{
                git credentialsId: 'bitbucket-credentials', url: 'https://bitbucket.org/Joao_Pinto_1201765/devops-20-21-1201765/src/master/'
            }
        }
        
        stage("Assemble") {
            steps{
                echo 'Assemble'
                
                
                    sh './gradlew clean assemble'
                
            }
        }
    
        stage("Test") {
            steps{
                echo 'Test'
                
                    sh './gradlew test'
                    junit 'build/test-results/**/*.xml'
                
            }
        }
        
        stage("Archive") {
            steps{
                echo 'Archive'
                
                    archiveArtifacts artifacts: 'build/libs/**/*.jar'    
                
            }
        }
        
    }
}
```


https://turkogluc.com/build-and-deploy-gradle-projects-with-jenkins/

https://stackoverflow.com/questions/44185165/what-are-the-differences-between-gradle-assemble-and-gradle-build-tasks

https://www.jenkins.io/doc/pipeline/tour/tests-and-artifacts/