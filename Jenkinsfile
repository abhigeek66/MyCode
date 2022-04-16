node{
	def mavenHome = tool name: "maven3.8.5"
   stage('SCM Checkout'){
	 git branch: 'main', url: 'https://github.com/abhigeek66/MyCode.git'
	}
   stage('Compile-Package'){
	 sh "${mavenHome}/bin/mvn clean package"
	}
   }
