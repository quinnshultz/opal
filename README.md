# Opal
A secure password manager.


## Synopsis
```
./gradlew run
```


## Description
Opal is a password manager designed to run in a server environment. Future features such as a compatible Android app are
planned.


## Compiling and Using
Edit password in src/main/sql/quickStartScript.sql and run as MySQL root. This script creates a database for our program and
an user account authorized to manipulate it. Switch the account we just created in your MySQL shell.

Now run src/main/sql/initTablesAndProcs.sql. This script creates a couple of tables and stored procedures necessary to the 
functionality of opal. Soon, I will implement an install option that does this automatically on the first run.

Gradle handles dependencies (MySQL Connector J, and JUnit) for this project.
```
# Build with
./gradlew build

# Run with
java -jar build/libs/opal-0.jar
```


## Testing
```
# Run JUnit tests
./gradlew test
```

## Authors
Written by Quinn Shultz.
