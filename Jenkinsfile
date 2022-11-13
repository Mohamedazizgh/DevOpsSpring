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

            sh "mvn clean verify  sonar:sonar"

  
               }
     }
        
            stage('Nexus'){
            steps{
                sh """mvn deploy """
            }
        
     }
        
        
       stage('sending mail'){
           steps {
            mail bcc: '', body: '''Hello from Jenkins,
            Devops Pipeline returned success.
            Best Regards''', cc: '', from: '', replyTo: '', subject: 'Devops Pipeline', to: 'zeineb.ghazouani2@esprit.tn'
    
            }
       } 

         
       
   
  
       stage("Docker Image") {
        steps{
           sh ' docker build -t zeinebghz/achat-1.0:latest .'
        }
       }
     
  

    }
      
}
