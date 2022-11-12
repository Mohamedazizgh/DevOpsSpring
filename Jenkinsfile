pipeline {
    agent any

    stages {
        
                stage('get  git ') {
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
	   stage('Test') {
           steps {
               sh 'mvn test'
            }
            
        }
          /*   stage("Sonar") {
        steps {

       sh "mvn clean install  sonar:sonar \
  -Dsonar.projectKey=Achat \
  -Dsonar.host.url=http://192.168.112.65:9000 \
  -Dsonar.login=ab8fe572293d73d97439de2a1bc96e0bb27c53a5 \
  -Dsonar.java.binaries=src/main "
  
  
               }
     }
        stage("nexus") {
        steps{
           sh 'mvn deploy:deploy-file -DgroupId=tn.esprit.rh -DartifactId=achat -Dversion=1.0 -DgeneratePom=true -Dpackaging=jar -DrepositoryId=deploymentRepo -Durl=http://192.168.112.65:8081/repository/maven-releases/  -Dfile=target/achat-1.0.jar'
        }
       
        }
          stage("Build docker image") {
        steps{
           sh ' docker build -t mhamedazizghorbel/achat-1.0 .'
        }
        } 
          stage("Publish  image to docker hub") {
        steps{
         withCredentials([string(credentialsId: 'dockerpwd', variable: 'docker')])  {
             sh'docker login -u  mhamedazizghorbel -p ${docker} docker.io'
         }
            sh' docker push mhamedazizghorbel/achat-1.0:latest'
        }
        }
         stage('DOCKER COMPOSE') {
                 steps {
		      
                      sh 'docker-compose up -d --build'
                   }
              } */
   
       
      
    }
}
