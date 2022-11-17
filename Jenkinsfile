pipeline {
    agent any

  
    stages {
        
                stage('git') {
            steps {
            
                git branch: 'zeineb', url: 'https://github.com/Mohamedazizgh/DevOpsSpring.git',
                credentialsId:"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";
                
            }
}
        stage("MVN Clean"){
            steps {
                sh """mvn clean """
                
            }
        }        
       stage('MVN Package'){
            steps {

               sh 'mvn package'
            }
        }
       stage('TEST'){
            steps {

               sh 'mvn test'
            }
        }   

        
        stage("Sonar") {
        steps {

            sh "mvn  sonar:sonar"

  
               }
     }
        
            stage('Nexus'){
            steps{
                sh """mvn deploy """
            }
        
     }
         
       
   
  
         stage('build')
        {
            steps {
                 sh 'docker build --build-arg IP=192.168.100.117  -t zoubaghz/devops  .'
            }
        }

      stage('Push') {

			steps {
				sh 'echo $dockerhub_PSW | docker login -u zoubaghz -p dckr_pat_R4PjLWflSBPghSQiVoBur0UFeaY'
				sh 'docker push zoubaghz/devops'
			}
		}
	               stage('Run app With DockerCompose') {
              steps {
                sh '''
                 docker pull zoubaghz/devops
		 docker-compose up -d
		'''
              }
              } 
     
         stage('sending mail'){
           steps {
            mail bcc: '', body: '''Hello from Jenkins,
            Devops Pipeline returned success.
            Best Regards''', cc: '', from: '', replyTo: '', subject: 'Devops Pipeline', to: 'zeineb.ghazouani2@esprit.tn'
    
            }
       } 


    }
      
}
