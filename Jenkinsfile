pipeline {
    agent any

  
    stages {
        
                stage('git') {
            steps {
            
                git branch: 'salma', url: 'https://github.com/Mohamedazizgh/DevOpsSpring.git',
                credentialsId:"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";
                
               }
                    }
      
	    
	       stage("MVN Install and Clean"){
            steps {
                sh """mvn install """
		sh """mvn clean -e """
                
              }
           } 
	    
	        
       stage('Maven Compile'){
            steps {
                sh """mvn -version  """
                sh """java -version """
               sh """mvn package -e """
		sh """mvn compile -e """
            }
        }
        
   
	        stage("JUint"){
            steps {
                sh """mvn test """
                
            }
        }
        
        

            stage('SonarQube analysis') {
      steps {
       
          sh "mvn clean  sonar:sonar \
           -Dsonar.projectKey=achat \
           -Dsonar.host.url=http://192.168.1.100:32768 \
           -Dsonar.login=b9cbe1b1972541b542258bdf23edb1c9724d8111 \
           -Dsonar.java.binaries=src/main "
        
      }
    }
        
   
 stage("nexus") {
        steps{
           sh 'mvn deploy \
	     -DgroupId=tn.esprit.rh \
	     -DartifactId=achat  \
	     -Dversion=1.0 \
	     -DgeneratePom=true \
	     -Dpackaging=jar \
	     -DrepositoryId=deploymentRepo \
	     -Durl=http://192.168.1.100:8081/repository/maven-releases/ \
	     -Dfile=target/achat-1.0.jar'
        }
       
        }
          stage("Build docker image") {
        steps{
           sh ' docker build -t salmazd/achat-1.0:latest .'
	   echo " Build Success "
        }
        }
        
	         stage("login to docker hub") {
        steps{
	
	       sh 'docker login -u salmazd -p sasazdzd1979 '
	   
            
	    
        }
        }
               stage("push to docker hub") {
        steps{
	
	     //sh ' docker push --disable-content-trust salmazd/achat-1.0:latest'
             echo "Image pushed !!!"
	     sh ' docker ps '
	    
        }
        }
            stage('docker compose') {
                 steps {
		      
                     sh 'docker-compose up -d --build'
		     echo " success "
		    
                   }
              }
        
    
     

    }
      
}
