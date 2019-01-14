/* 
 *                              Opal
 *        A secure password manager written by Quinn Shultz
 * 
 
 *                        SQL set-up script
 *
 * MySQL quick start script for creating an appropriate database and
 * account for the program to use. Also provides the user an option to
 * change the default SQL parameters used to connect to the database.
 * Changes must be mirrored to the database package in the Java project.
 */
 
-- Creates a new database for Opal
Create database opalPasswordManager;

-- Creates a new user account for Opal
GRANT ALL PRIVILEGES ON opalPasswordManager.* TO 'jdbcopal'@'localhost' IDENTIFIED BY 'Nth@Z8giog5uL3tD';