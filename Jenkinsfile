pipeline {
    agent any

  
    stages {
        
                stage('git') {
            steps {
            
                git branch: 'zeineb', url: 'https://github.com/Mohamedazizgh/DevOpsSpring.git',
                credentialsId:"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";
                
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
  -Dsonar.projectKey=zeineb \
  -Dsonar.host.url=http://192.168.1.47/:9000 \
  -Dsonar.login=0d355ec5aec6866f746b1ea314984766d20b100d \
  -Dsonar.java.binaries=src/main "
  
  
               }
                      }
            stage('Nexus'){
            steps{
                sh """mvn deploy """
            }
        
     }
        
        

         
       
   
  
       
     
  

    }
      
}
