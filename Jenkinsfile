node{
   stage('SCM Checkout'){
	 git branch: 'main', url: 'https://github.com/abhigeek66/MyCode.git'
	}
   stage('Compile-Package'){
   def mavenHome = tool name: "maven3.8.5"
	 sh "${mvnHome}/bin/mvn clean package"
	}
}
