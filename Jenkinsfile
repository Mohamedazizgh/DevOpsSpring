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
	   stage('Test:junit/mockito') {
           steps {
               sh 'mvn test'
            }
            
        }
            stage("Sonar") {
        steps {

         sh"  mvn sonar:sonar \
  -Dsonar.projectKey=AchatS \
  -Dsonar.host.url=http://192.168.112.65:9000 \
  -Dsonar.login=ee35478154290773167e9941f54d7700ea78486d\
   -Dsonar.java.binaries=src/main "
   
  
               }
     }
       stage("Publish to nexus") {
            steps {
                script {
                    pom = readMavenPom file: "pom.xml";
			filesByGlob = findFiles(glob: "target/achat-${pom.version}.${pom.packaging}");
                    artifactPath = filesByGlob[0].path;
                    artifactExists = fileExists artifactPath;
                    
                    if(artifactExists) {
                        
                        nexusArtifactUploader(
                            nexusVersion: "nexus3",
                            protocol: "http",
                            nexusUrl: "192.168.112.65:8081",
                            groupId: pom.groupId,
                            version: pom.version,
                            repository: "maven-releases",
                            credentialsId: "58e80141-1d28-4dab-b6b7-577f962ba74e",
                            artifacts: [
                                [artifactId: pom.artifactId,
                                classifier: '',
                                file: artifactPath,
                                type: pom.packaging],

                                [artifactId: pom.artifactId,
                                classifier: '',
                                file: "pom.xml",
                                type: "pom"]
                            ]
                        );

                    } else {
                        error "* File could not be found";
                    }
                }
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
              } 
   
       
      
    }
}
