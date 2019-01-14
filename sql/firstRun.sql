/* Opal
 * A free and secure password manager.
 *
 * Database start-up script for creating tables and stored procedures
 * used by this program.
 *
 * Written by Quinn Shultz
 */

-- Creates a new database for user tables
Create database opalPasswordManager;
Use opalPasswordManager;



/*********************************************************************************************************/
/*                                                                                                       */
/*                                          TABLE TEMPLATES                                              */
/*                                                                                                       */
/*********************************************************************************************************/

/*
 * Create table for storing user encryption keys
 */
CREATE table opalUsers(ID int auto_increment
, username varchar(256) UNIQUE NOT NULL
, fullName varchar(256)
, characterEncoding varchar(128) NOT NULL
, cipherTransformation varchar(128) NOT NULL
, aesEncryptionAlgorithm varchar(128) NOT NULL
, primary key (id));

/*
 * Create a template table for accounts
 * with an username and password
 */
CREATE table accounts_template(ID int auto_increment
, url varchar(2048)
, name varchar(256) NOT NULL
, username varchar(256) NOT NULL
, encryptedPassword varchar(256)
, encryptionKey varchar(256)
, notes varchar(10240)
, primary key (id));

-- Make sure template tables seem appropriate
SELECT * FROM opalUsers;
SELECT * FROM accounts_template;


/*********************************************************************************************************/
/*                                                                                                       */
/*                                             PROCEDURES                                                */
/*                                                                                                       */
/*********************************************************************************************************/

/*
 * Adds a new account by creating MySQL table:
 * userName_accounts and inserting into opalUsers
 *
 * Parameter paramUserName			Username for the new account
 * Parameter paramFullName			Full name of the new account user (optional)
 * Parameter paramCharacterEncoding
 * Parameter paramCipherTransformation
 * Parameter paramAESEncryptionAlgorithm
 */
DELIMITER //
CREATE DEFINER=`jdbcopal`@`localhost`
PROCEDURE `add_new_opaluser` (In paramUserName varchar(256), In paramFullName varchar(256), In paramCharacterEncoding varchar(128),
								In paramCipherTransformation varchar(128), In paramAESEncryptionAlgorithm varchar(128))
BEGIN
	If not exists (Select 1 FROM information_schema.TABLES
	WHERE table_schema=DATABASE()
	AND table_name=CONCAT(paramUserName,'_accounts') )
	Then
        
        SET @sql = CONCAT('CREATE TABLE ', CONCAT(paramUserName,'_accounts'),' LIKE accounts_template');
		PREPARE s FROM @sql;
		EXECUTE s;
		DEALLOCATE PREPARE s;

		SET @sql = CONCAT('INSERT INTO opalUsers (username, fullName, characterEncoding, cipherTransformation, aesEncryptionAlgorithm) VALUES (',"'",paramUserName,
							"'",', ',"'",paramFullName,"'",', ',"'",paramCharacterEncoding,"'",', ',"'",paramCipherTransformation,"'",', ',"'",
                            paramAESEncryptionAlgorithm,"'",')');
		PREPARE s FROM @sql;
		EXECUTE s;
		DEALLOCATE PREPARE s;
        
	END IF;

END //
DELIMITER ;

-- For development user only! Removes the above procedure
DROP procedure add_new_opaluser;

-- Test adding an user
CALL add_new_opaluser('quinnshultz', 'Quinn Shultz', 'UTF-8', 'AES/CBC/PKCS5PADDING', 'AES');
SELECT * FROM opalUsers;
SELECT * FROM quinnshultz_accounts;

/*
 * Removes an account by dropping MySQL table:
 * userName_accounts and deleting from opalUsers
 *
 * Parameter paramUserName	Username of the account
 */
DELIMITER //
CREATE DEFINER=`jdbcopal`@`localhost`
PROCEDURE `remove_opaluser` (In paramUserName varchar(256))
BEGIN

	SET @sql = CONCAT('DELETE FROM opalUsers WHERE username= ',"'",paramUserName,"'");
	PREPARE s FROM @sql;
	EXECUTE s;
	DEALLOCATE PREPARE s;

	If exists (Select 1 FROM information_schema.TABLES
	WHERE table_schema=DATABASE()
	AND table_name=CONCAT(paramUserName,'_accounts') )
	Then
        
        SET @sql = CONCAT('DROP TABLE ', CONCAT(paramUserName,'_accounts'));
		PREPARE s FROM @sql;
		EXECUTE s;
		DEALLOCATE PREPARE s;
        
	END IF;

END //
DELIMITER ;

-- For development user only! Removes the above procedure
DROP procedure remove_opaluser;

-- Test adding an user
CALL remove_opaluser('quinnshultz');
SELECT * FROM opalUsers;
SELECT * FROM quinnshultz_accounts;

/*
 * Adds a new account to the password manager.
 *
 * Parameter paramName						Name of the account
 * Parameter paramOpalName					Opal username this account should be stored under
 * Parameter paramURL						URL of the account
 * Parameter paramAccountUsernmame			Username of the account being added
 * Parameter paramEncryptedPassword			Password after encryption
 * Parameter paramEncryptionKey				Randomly generated key for encrypting and decrypting account password
 * Parameter paramNotes						Any notes to store with the account
 */
DELIMITER //
CREATE DEFINER=`jdbcopal`@`localhost`
PROCEDURE `add_account` (In paramName varchar(256), In paramOpalName varchar(256), In paramURL varchar(2048), In paramAccountUsername varchar(256),
							In paramEncryptedPassword varchar(256), In paramEncryptionKey varchar(256), In paramNotes varchar(10240))
BEGIN
	If exists (Select 1 FROM information_schema.TABLES
	WHERE table_schema=DATABASE()
	AND table_name=CONCAT(paramOpalName,'_accounts') )
	Then
		SET @sql = CONCAT('INSERT INTO ', CONCAT(paramOpalName,'_accounts'),' (url, name, username, encryptedPassword, encryptionKey, notes) VALUES(',"'",
							paramURL,"'",', ',"'",paramName,"'",', ',"'",paramAccountUsername,"'",', ',"'",paramEncryptedPassword,"'",', ',"'",paramEncryptionKey,
                            "'",', ',"'",paramNotes,"'",')');
		PREPARE s FROM @sql;
        EXECUTE s;
        DEALLOCATE PREPARE s;
        
	END IF;
    
END //
DELIMITER ;

-- For development user only! Removes the above procedure
DROP procedure add_account;

-- Test adding an account
CALL add_account('BBB', 'quinnshultz', 'https://billsbackyardbees.com/', 'fakeusername', 'fakepassword', 'ABCDEFGHIJKLMNOP', 'A test account with credentials fakeusername and fakepassword');
SELECT * FROM quinnshultz_accounts;

/*
 * Removes an account from the password manager.
 *
 * Parameter paramOpalName		Opal username this account is stored under
 * Parameter paramRemoveAccount	Name of the account being removed
 */
DELIMITER //
CREATE DEFINER=`jdbcopal`@`localhost`
PROCEDURE `remove_account` (In paramRemoveAccount varchar(256), In paramOpalName varchar(256))
BEGIN
	If exists (Select 1 FROM information_schema.TABLES
	WHERE table_schema=DATABASE()
	AND table_name=CONCAT(paramOpalName,'_accounts') )
	Then
		SET @sql = CONCAT('DELETE FROM ', CONCAT(paramOpalName,'_accounts'),' WHERE name= ',"'",paramRemoveAccount,"'");
		PREPARE s FROM @sql;
		EXECUTE s;
		DEALLOCATE PREPARE s;
        
	END IF;

END //
DELIMITER ;

-- For development user only! Removes the above procedure
DROP procedure remove_account;

-- Test removing an account
CALL remove_account('BBB', 'quinnshultz');
SELECT * FROM quinnshultz_accounts;

/*********************************************************************************************************/
/*                                                                                                       */
/*                                      EXPANDED TEST CASES                                              */
/*                                                                                                       */
/*********************************************************************************************************/
DROP table opalUsers;
DROP table accounts_template;