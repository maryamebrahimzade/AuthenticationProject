# authentication
This application performs the process of user authentication and authorization

### List of used packages
1. The infrastructure of this app is from Spring Security based on jwt token

2. The jjwt and spring-security packages has been used.

3. Logs are stored in the Mongodb database.

4. The test database is h2 and packages h2 and assertj-core have been used.

5. Redis is used to cache ID tokens

### Requirements needed to devate the project
1. To run this application,simply copy the path of the exceptions_fa_IR.properties file and paste it in the RestExceptionHandler class.
2. To run this application,first you need to specify your username and password for connecting to the database in the application.yml file.

### API List:
|    API name    | Input Parameters  |          description          |
|:--------------:|:-----------------:|:-----------------------------:|
| register User  |     UserDto/      |     /api/v1/auth/register     |
|   login User   |     LoginDto/     |      /api/v1/auth/login       |
|  logout User   |  request header   |      /api/v1/user/logout      |   
| token validity |  request header   |    /api/v1/token/is-valid     | 

