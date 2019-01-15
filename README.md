# Opal
A secure password manager.


## Synopsis
```
./opal.sh
```


## Description
Opal is a password manager designed to run in a server environment. Future features such as a compatible Android app are planned.


## Compiling and Using
Edit password in src/main/sql/quickStartScript.sql and run as MySQL root. This script creates a database for our program and an
user account authorized to manipulate it. Switch the account we just created in your MySQL shell.

Now run src/main/sql/initTablesAndProcs.sql. This script creates a couple of tables and stored procedures necessary to the 
functionality of opal. Soon, I will implement an install option that does this automatically on the first run.

MySQL Connector J is necessary to communicate with the database. Add it to your classpath by including the -cp option.
```
# Compile with
javac -cp .:lib/mysql-connector-java-8.0.13.jar -d bin src/main/java/com/billsbackyardbees/opal/*/*.java

# Run with
java -cp .:lib/mysql-connector-java-8.0.13.jar:bin com/billsbackyardbees/opal/pgm/Opal 
```


## Testing
Running the included JUnit test classes requires that JUnit is present in your classpath.
```
# Compile testing sources along with main source
javac -cp .:lib/mysql-connector-java-8.0.13.jar:/<path>/<to>/<junit>.jar -d bin src/main/java/com/billsbackyardbees/opal/*/*.java src/test/java/com/billsbackyardbees/opal/test/*/*.java
```

## Authors
Written by Quinn Shultz.
