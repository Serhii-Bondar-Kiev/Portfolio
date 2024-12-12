# Test task for Java candidate

### How to run 
 - install docker
 - mvn clean package -DskipTests
 - docker-compose up -d

### Task definition
You should create service for aggregating users data from multiple databases. Application must
provide single rest endpoint for selecting data, selected from all databases
GET /users
Success response body example:
```json
[
  {
    "id": "example-user-id-1",
    "username": "user-1",
    "name": "User",
    "surname": "Userenko"
  },
  {
    "id": "example-user-id-2",
    "username": "user-2",
    "name": "Testuser",
    "surname": "Testov"
  }
  
]
```
Application must have declarative configuration for specification of data sources, maximal quality
of data sources is infinite:
```
data-sources:
  - name: data-base-1
    strategy: postgres #this property is optional, only if you implements multiple database type support (Postgres, ORACLE, MySQL...)
    url: jdbc://.....
    table: users
    user: testuser
    password: testpass
    mapping:
    id: user_id
    username: login
    name: first_name
    surname: last_name
  - name: data-base-2
    strategy: postgres
    url: jdbc://.....
    table: user_table
    user: testuser
    password: testpass
    mapping:
    id: ldap_login
    username: ldap_login
    name: name
    surname: surname
```


### Strong requirements

• Use Spring Boot for writing this application
• Use OpenApi contracts specification for declare endpoint definition
• Include a README.md file with instructions on how to run the application (using Docker
Compose would be a big plus)
• Project must be pushed to git repository with readme file

### Optional requirements
• Add integration test using testcontainers
• Add selecting filters in api and queries
