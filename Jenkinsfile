pipeline {
  agent {
    docker {
      image 'maven:3-alpine'
      args '-v /var/local/.m2:/root/.m2'
    }

  }
  stages {
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