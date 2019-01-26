1. **About**\
Demo REST application for download information about documents from API prozorro.gov.ua\
Application has API, it allows you to work with the application using JSON
2. **API:**\
**2.1**\
**`POST`** **`http://localhost:8080/documents/save`** returns http status OK code 200\
{
	"url": "https://lb-api-sandbox.prozorro.gov.ua/api/2.4/contracts/47fa8764e1b74f4db58f84c9db460566/documents"
}\

**3. Requirements**\
Java 1.8 https://docs.oracle.com/javase/8/docs/technotes/guides/install/install_overview.html\
Apache Maven 3.5.3 https://maven.apache.org/install.html\
For manage the application need 
Rest client(for example "Postman"). https://www.getpostman.com

**4. How to run**\
Download project from Git
https://github.com/ArturRoze/test-java-REST.\
Open commandLine go to directory with pom.xml (root project for example C:\Users\Artur\IdeaProjects\testJavaREST)

**mvn spring-boot:run**

Application runs on port: 8080