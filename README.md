playing-cards git repo to share code base for Deck of Cards problem.

### Projects
 * playing-cards-api
 * playing-cards-impl
 * playing-cards-console-app

### Required
 * JDK 1.8 or higher
 * JAVA_HOME configured environment variable
 * Gradle 2.14 or above (optional)
 * IntelliJ IDE (optional)

### Build and Play
 * Navigate into directory where this git repo was cloned.
 * Build:
    * On Linux: ./gradlew build
    * On Windows: gradlew.bat build
 * Play:
    * On Linux: java -jar playing-cards-console-app/build/libs/playing-cards-console-app-1.0.0.jar
    * On Windows: java -jar playing-cards-console-app\build\libs\playing-cards-console-app-1.0.0.jar

### Notes
 * Unless specified explicitly in requirements I tend to write minimal code comments/ java doc.
    * I write java doc for interface so that it's purpose is well defined.
    * I believe comments should describe the 'why' and not the 'what' since simple code should be able to describe the 'what'.
 * Future enhancement
    * I would make implementation in console app configurable via a properties file.


### Preconfigured Items

 * Gradle build script:
	* Java 8.
	* Junit test dependency.
 * Git will ignore the files and folders created by the Intellij and build directory created by gradle.
	* Gradle can auto create Intellij IDE files.


### Configuration Steps

 1. Building your project artifact from terminal/ cmd.
	* Navigate to this git repo via terminal or cmd and execute command example: gradlew.bat build
		* For list of some of the available default gradle tasks for java project view: https://docs.gradle.org/current/userguide/java_plugin.html
		* Please ensure JAVA_HOME is set to specific or higher JDK version you need to the project compiled with.
 2. Importing the project in to Eclipse or IntelliJ.
	* IntelliJ.
		* File -> Project from existing source -> Select build.gradle in git repo.
			* Select use default gradle wrapper (recommended) OR Use local distribution and set Gradle home is set to gradle 2.14 and above.
			* Set and check Gradle JVM is pointing to JDK 1.8.