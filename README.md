## Installations (dependencies)
1. check java version if already installed by using command `java -version`, if not installed, [Download](https://java.com/en/download/help/download_options.html) and install java 8 (preferred for version compatibility with various dependencies)
2. check maven version if already installed by using command `mvn -version`, if not installed, [Download](https://maven.apache.org/download.cgi) and Install maven 3.6.0 (preferred)
3. check mongod version if already installed by using command `mongod -version`, if not installed, [Download](https://www.mongodb.com/try/download/community) and Install mongod 4.4.6 (preferred)

## After making sure the above installations are fine, follow the steps to start the API:
1. Goto the project folder, where you will see `pom.xml`
2. Run the command `mvn clean install` to create a jar (it will be found here `target/mongo-0.0.1-SNAPSHOT.jar` which can be used later also)
3. Start the API using either the jar above created with command `java -jar target/mongo-0.0.1-SNAPSHOT.jar` or by using maven `mvn spring-boot:run`

## After starting the API, you can use it via curl, postman, or simply your browser:
1. Goto your browser, and hit the URL http://localhost:8092/starter-mongo-api/v1/objects

### For bugs or improvements, you can raise an issue. Thanks for reading. 
