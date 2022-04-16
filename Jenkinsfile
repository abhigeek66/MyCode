node{
   stage('SCM Checkout'){
	 git 'https://github.com/smartsanjayeng/MyCode.git'
	}
   stage('Compile-Package'){
   def mvnHome = tool name: 'maven3.8.5', type:'maven'
	 sh "${mvnHome}/bin/mvn clean package"
	}
}
