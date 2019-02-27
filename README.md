# Opal
A password manager for an Apache Tomcat Server.

[<img alt="Jenkins" src="https://img.shields.io/badge/-Download_from_Jenkins-D24939.svg?logo=jenkins&style=flat-square&logoColor=white" height=32>](http://ci.quinnshultz.com/job/Opal/)                                                 [<img alt="Deployment" src="https://img.shields.io/badge/-Try_on_App_Server-367588.svg?logo=java&style=flat-square&logoColor=white" height=32>](http://app.quinnshultz.com:8080/opal/)

## Description
Opal is a password manager designed to run on a JavaEE server. The front-end features are availiable in browser. Future features such as a compatible Android app are planned.


## Compiling and Using
You must add MySQL Connector J to src/main/webapp/WEB-INF/lib. Then, create an appropriate database and db user as specified in src/main/webapp/META-INF/sql/quickstart.sql with your MySQL root or similar user.

Additionally, you may need to create the tables, stored procedures, and views in your new database with /src/main/webapp/META-INF/sql/create.sql.

```
# Build with
./gradlew build
```

Now deploy the web application resource in build/libs on Glassfish or similar J2EE server.


## See Also
Javadoc API Specification (coming soon!)

## Testing
```
# Run JUnit tests
./gradlew test
```

## Authors
Written by Quinn Shultz.
