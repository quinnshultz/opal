# Opal
A password manager for an Apache Tomcat Server.


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
Javadoc API Specification https://quinnshultz.github.io/opal


## Testing
```
# Run JUnit tests
./gradlew test
```

## Authors
Written by Quinn Shultz.
