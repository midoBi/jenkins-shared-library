#!/usr/bin/env groovy
import com.script.Docker
def call(String imgName) {
    return new Docker(this).dockerLogin()
}