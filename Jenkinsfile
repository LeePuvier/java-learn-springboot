pipeline {
    agent {
        node {
            label "Test_dpt"
        }
    }
    stages {
        stage('Check out code') {
			steps {
				dir('code') {
					echo "starting APIScript......"
					//git([url: 'git@git.wecash.net:wangteng/test_for_sonar.git', branch: env.CaseBranch, credentialsId: '7726e85b-f455-40d1-b12c-447ecac70f23'])
					//git([url: 'git@git.wecash.net:capital/capital-bill.git', branch: env.CaseBranch, credentialsId: '17a38999-6caf-4576-9356-2f798892bf61'])
				}
			}
        }
		stage('Testing') {
			steps {
				dir('code') {
					echo "starting Testing......"
					//dir(env.TestModule){
						//withMaven(globalMavenSettingsConfig: '80d7f536-d473-44a8-9edf-60630acc7d72', jdk: 'Oracle JDK 8', maven: 'Maven 3.5.0', mavenSettingsConfig: 'bfa90212-2742-4611-aa71-8e0ec76d0c28') {        
							//script {
								//try {
									//sh "mvn -Dapp.id=capital-bill -Dapollo.meta=http://meta-tapollo01cn.wecash.net:8080 -Denv=FAT -Dapollo.bootstrap.enabled=true -Dapollo.bootstrap.eagerLoad.enabled=true -Dapollo.bootstrap.namespaces=application,capital.base -Deureka.client.register-with-eureka=false clean test"
								//} catch (exc) {
									//echo 'Some TestCase failed'
								//}
							//}
						//}
					//}
				}
			}
        }
		stage('Create sonar file') {
            steps {
                echo "Start create sonar file......"
				script {
					sh "chmod +x -R ${JOB_NAME}"
					//sh "${JOB_NAME}/generate_sonar_file.sh code"
				}
            }
        }
		stage('Sonar scanner') {
            steps {
                echo "starting excute sonar scanner......"
                dir('code') {
                    script {
						//def sonarqubeScannerHome = tool name: 'SonarQube Scanner'
                        //withSonarQubeEnv('SonarQube-Public') {
                            //sh "${sonarqubeScannerHome}/bin/sonar-scanner"
                        //}
                    }
                }
            }
        }
		stage('Analysis jacoco results') {
			steps {
				echo "starting parse jacoco report......"
				
				dir('code') {
					//script {
						//if(!"".equals(env.CodeInclusions)){
							//def SourcePattern = CodeInclusions.replaceAll('/[*][*]/[*].java','')
							//SourcePattern = SourcePattern.replaceAll('/[*].java','')
							//jacoco classPattern:SourcePattern
						//}else{
							jacoco
						//}
					//}
				}
			}
		}
    }
}
