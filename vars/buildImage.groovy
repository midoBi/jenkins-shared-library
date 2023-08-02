#!/usr/bin/env groovy

def call() {
    echo "Building the docker image"

    withCredentials([usernamePassword(credentialsId: 'docker-hub-repo', usernameVariable: 'USERNAME', passwordVariable: 'PASSWORD')]) {
        sh 'docker build -t 123456789mehdibirouk/demo-app:jma-2.0 .'
        sh "echo $PASSWORD | docker login -u $USERNAME --password-stdin"
        sh 'docker push 123456789mehdibirouk/demo-app:jma-2.0'
    }
}