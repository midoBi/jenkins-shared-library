#!/usr/bin/env groovy
package com.script

class Docker implements Serializable {
    def script

    Docker(script) {
        this.script = script;
    }

    def buildDockerImages(String imgName) {
        script.echo "Building the docker image"

        script.sh "docker build -t $imgName ."


    }

    def dockerLogin() {
        script.withCredentials([script.usernamePassword(credentialsId: 'docker-hub-repo', usernameVariable: 'USERNAME', passwordVariable: 'PASSWORD')]) {
            script.sh "echo $script.$PASSWORD | docker login -u $script.$USERNAME --password-stdin"
        }
    }

    def dockerPush(String imgName) {
        script.withCredentials([script.usernamePassword(credentialsId: 'docker-hub-repo', usernameVariable: 'USERNAME', passwordVariable: 'PASSWORD')]) {
            script.sh "docker push $imgName"
        }
    }
}
