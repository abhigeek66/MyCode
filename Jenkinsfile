node{
   stage('SCM Checkout'){
	 git 'git branch: 'main', url: 'https://github.com/abhigeek66/MyCode.git'
	}
   stage('Compile-Package'){
   def mvnHome = tool name: 'maven3.8.5', type:'maven'
	 sh "${mvnHome}/bin/mvn clean package"
	}
}
