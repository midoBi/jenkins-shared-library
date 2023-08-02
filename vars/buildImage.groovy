#!/usr/bin/env groovy

def call(String imgName) {
    echo "Building the docker image"

    withCredentials([usernamePassword(credentialsId: 'docker-hub-repo', usernameVariable: 'USERNAME', passwordVariable: 'PASSWORD')]) {
        sh "ocker build -t $imgName ."
        sh "echo $PASSWORD | docker login -u $USERNAME --password-stdin"
        sh "docker push $imgName"
    }
}