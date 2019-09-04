comscore-vfs project for all console java lib related projects.

### Required
 * JDK 1.8
 * Gradle 2.14 or above (optional)
 * Eclipse or IntelliJ IDE (optional)

### Preconfigured Items

 * Gradle build script:
	* Java 8.
	* Junit test dependency.
	* Creates zip artifact which can deployed to cs_bin.
 * Git will ignore the files and folders created by the IDE and build directory created by gradle.
	* Gradle can auto create IDE files.


### Configuration Steps

 1. Importing the project in to Eclipse or IntelliJ.
	* IntelliJ.
		* File -> Project from existing source -> Select build.gradle in git repo.
			* Select use default gradle wrapper (recommended) OR Use local distribution and set Gradle home is set to gradle 2.14 and above.
			* Set and check Gradle JVM is pointing to JDK 1.8. 
	* Eclipse
		* Installing/ configuring gradle eclipse plugin (first time, may not be needed for newer eclipse versions).
			* Install Buildship Gradle Integration via Eclipse marketplace (Restart eclipse after install).
		* File -> Import -> Gradle -> Gradle Project, next, insert path to git repo at root folder.
			* Select Use Gradle Wrapper (recommended) OR Select specific gradle version 2.14.
			* Optional: Set Java home directory, for example C:\Program Files\Java\jdk1.8.0_92
		* Depending on selected steps above or if Eclipse is configured with JDK 1.8 the project will auto configure and also install gradle 2.14 if need be.
 2. Building your project artifact from terminal/ cmd.
	* Navigate to this git repo via terminal or cmd and execute command example: gradlew.bat build
		* For list of some of the available default gradle tasks for java project view: https://docs.gradle.org/current/userguide/java_plugin.html
		* Please ensure JAVA_HOME is set to specific or higher JDK version you need to the project compiled with.
	* The above command needs access to http://pp-nexus.office.comscore.com (since it grabs gradle binaries and other project dependencies from it).
 3. Gradle task csBinExport exports artifacts to 'build/cs_bin' needed to deploy.
 4. Gradle task zipCsBin archives exported artifacts listed in the previous step.
 