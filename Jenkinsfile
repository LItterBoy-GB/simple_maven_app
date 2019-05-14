pipeline {
  agent any
  stages {
    stage('info') {
      steps {
        sh 'mvn help:effective-settings'
      }
    }
    stage('Build') {
      steps {
        sh 'mvn -B -DskipTests clean package'
      }
    }
    stage('Deliver') {
      steps {
        sh './script/deploy.sh'
      }
    }
  }
}