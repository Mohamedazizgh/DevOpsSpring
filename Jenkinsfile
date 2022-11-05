pipeline {
    agent any

    stages {
        
                stage('git') {
            steps {
            
                git branch: 'Aziz', url: 'https://github.com/Mohamedazizgh/DevOpsSpring.git',
                credentialsId:"3f75cff3-a207-4578-b90d-ecb49aff331e";
                
            }
}
        
       stage('MVN Package'){
            steps {
                sh """mvn -version  """
                sh """java -version """
               sh """mvn package -e """
            }
        }
        
      stage("MVN Compile"){
            steps {
                sh """mvn compile -e """
                
            }
        }
           stage("MVN Install"){
            steps {
                sh """mvn install """
                
            }
        }
        stage("MVN Clean"){
            steps {
                sh """mvn clean -e """
                
            }
        }
          stage("Sonar") {
        steps {

       sh "mvn clean verify  sonar:sonar \
  -Dsonar.projectKey=Aziz \
  -Dsonar.host.url=http://192.168.1.18:9000 \
  -Dsonar.login=9e592a527675c41a4306af79277e2cd66a84415a \
  -Dsonar.java.binaries=src/main "
  
  
               }
     }
        stage("nexus") {
        steps{
           sh 'mvn deploy:deploy-file -DgroupId=tn.esprit.rh -DartifactId=achat -Dversion=1.0 -DgeneratePom=true -Dpackaging=jar -DrepositoryId=deploymentRepo -Durl=http://192.168.1.18:8081/repository/maven-releases/  -Dfile=target/achat-1.0.jar'
        }
       
        }
    }
}
