pipeline {
	agent {label "jenkins"}

    stages {
        
                stage('get  git ') {
            steps {
            
                git branch: 'Aziz', url: 'https://github.com/Mohamedazizgh/DevOpsSpring.git',
                credentialsId:"3f75cff3-a207-4578-b90d-ecb49aff331e";
                
            }
}
        
       stage('MVN Package'){
            steps {
               /* sh """mvn -version  """
                sh """java -version """
               sh """mvn package -e """*/
		    sh"echo test"
            }
        }
        
      stage("MVN Compile"){
            steps {
             //   sh """mvn compile -e """
                 sh"echo test"
            }
        }
           stage("MVN Install"){
            steps {
              //  sh """mvn install """
                 sh"echo test"
            }
        }
      stage("MVN Clean"){
            steps {
               // sh """mvn clean -e """
                 sh"echo test"
            }
        }
	   stage('Test:junit/mockito') {
           steps {
             //  sh ' mvn test'
		    sh"echo test"
            }
            
        }
              stage("Sonar") {
        steps {

       /*  sh"  mvn sonar:sonar \
  -Dsonar.projectKey=AchatS \
  -Dsonar.host.url=http://192.168.112.65:9000 \
  -Dsonar.login=ee35478154290773167e9941f54d7700ea78486d\
   -Dsonar.java.binaries=src/main "*/
   
   sh"echo test"
               }
     }
      stage("nexus") {
        steps{
         
        //   sh 'mvn deploy -DgroupId=tn.esprit.rh -DartifactId=achat -Dversion=1.0 -DgeneratePom=true -Dpackaging=jar -DrepositoryId=deploymentRepo -Durl=http://192.168.112.65:8081/repository/maven-releases/  -Dfile=target/achat-1.0.jar'
		 sh"echo test"
        }
        }
          stage("Build docker image") {
        steps{
	
      //   sh ' docker build -t mhamedazizghorbel/achat-1.0 .'
		 sh"echo test"
        }
        } 
        stage("Publish  image to docker hub") {
        steps{
		 sh"echo test"
      /*  withCredentials([string(credentialsId: 'dockerpwd', variable: 'docker')])  {
             sh'docker login -u  mhamedazizghorbel -p ${docker} docker.io'
         }
           sh' docker push mhamedazizghorbel/achat-1.0:latest'*/
        }
        }
         stage('DOCKER COMPOSE') {
                 steps {
		       sh"echo test"
                     // sh 'docker-compose up -d --build'
                   }
              } 
    }
	post {
		always {

		     mail to: "ghorbel.mhamedaziz@gmail.com",
            subject: "Jenkins Build ${currentBuild.currentResult}: Job ${env.JOB_NAME}",
            body: "${currentBuild.currentResult}: Job ${env.JOB_NAME} build ${env.BUILD_NUMBER}\n More info at: ${env.BUILD_URL}"

		}
    	}



}
