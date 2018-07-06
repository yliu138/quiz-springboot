## How to run
1. Run `gradle bootRun` to start up the project
2. Open the link in the browser _http://localhost:8080_ to check if the spring project has successfully booted.

## Database configuration
Go to `src/main/resources/application.properties`
For configuration issues, refer to [this](https://stackoverflow.com/questions/43249308/cant-create-a-mysql-database-using-spring-boot)

## Spring boot explanation
| Annotation | Meaning                                             |
|------------|-----------------------------------------------------|
| @Component | generic stereotype for any Spring-managed component |
| @Repository| stereotype for persistence layer                    |
| @Service   | stereotype for service layer                        |
| @Controller| stereotype for presentation layer (spring-mvc)      |


## Issues and resolutions
1. [External database rather than in-memory DB configuration](https://stackoverflow.com/questions/43249308/cant-create-a-mysql-database-using-spring-boot)

2. [Initialize the database with schema and data](https://stackoverflow.com/questions/38040572/spring-boot-loading-initial-data)