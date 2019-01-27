/* 
 * Copyright (c) 2019 Quinn Shultz <vanoxite@gmail.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

/*********************************************************************************************************/
/*                                                                                                       */
/*                                              TABLES                                                   */
/*                                                                                                       */
/*********************************************************************************************************/

/*
 * Create table for storing user encryption keys
 */
CREATE table opalUsers(ID int auto_increment
, username varchar(256) UNIQUE NOT NULL
, fullName varchar(256)
-- In the future, we may need to force asymmetric key cryptography
, password varchar(128)
, primary key (id));

/*
 * Create a template table for Objects
 * with an username and password
 */
CREATE table passwordAccounts_template(ID int auto_increment
, url varchar(2048)
, name varchar(256) UNIQUE NOT NULL
, username varchar(256) NOT NULL
, encryptedPassword varchar(256)
, notes varchar(10240)
, characterEncoding varchar(128) NOT NULL
, cipherTransformation varchar(128) NOT NULL
, aesEncryptionAlgorithm varchar(128) NOT NULL
, primary key (id));

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
 * Parameter paramPublicKey			Key used for encryption (optional)
 */
DELIMITER //
CREATE DEFINER=`jdbcopal`@`localhost`
PROCEDURE `add_new_opaluser` (In paramUserName varchar(256), In paramFullName varchar(256), In paramPublicKey varchar(128))
BEGIN
	If not exists (Select 1 FROM information_schema.TABLES
	WHERE table_schema=DATABASE()
	AND table_name=CONCAT(paramUserName,'_accounts') )
	Then
        
        SET @sql = CONCAT('CREATE TABLE ', CONCAT(paramUserName,'_accounts'),' LIKE passwordaccounts_template');
		PREPARE s FROM @sql;
		EXECUTE s;
		DEALLOCATE PREPARE s;

		SET @sql = CONCAT('INSERT INTO opalUsers (username, fullName, publicKey) VALUES (',"'",paramUserName,
							"'",', ',"'",paramFullName,"'",', ',"'",paramPublicKey,"'",')');
		PREPARE s FROM @sql;
		EXECUTE s;
		DEALLOCATE PREPARE s;
        
	END IF;

END //
DELIMITER ;

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

/*
 * Adds a new account to the password manager.
 *
 * Parameter paramName						Name of the account
 * Parameter paramOpalName					Opal username this account should be stored under
 * Parameter paramURL						URL of the account
 * Parameter paramAccountUsernmame			Username of the account being added
 * Parameter paramEncryptedPassword			Password after encryption
 * Parameter paramNotes						Any notes to store with the account
 * Parameter paramCharacterEncoding
 * Parameter paramCipherTransformation
 * Parameter paramAesEncryptionAlgorithm
 */
DELIMITER //
CREATE DEFINER=`jdbcopal`@`localhost`
PROCEDURE `add_account` (In paramName varchar(256), In paramOpalName varchar(256), In paramURL varchar(2048), In paramAccountUsername varchar(256),
							In paramEncryptedPassword varchar(256), In paramNotes varchar(10240), In paramCharacterEncoding varchar(128),
                            In paramCipherTransformation varchar(128), In paramAesEncryptionAlgorithm varchar(128))
BEGIN
	If exists (Select 1 FROM information_schema.TABLES
	WHERE table_schema=DATABASE()
	AND table_name=CONCAT(paramOpalName,'_accounts') )
	Then
		SET @sql = CONCAT('INSERT INTO ', CONCAT(paramOpalName,'_accounts'),' (name, url, username, encryptedPassword, notes, characterEncoding, cipherTransformation, aesEncryptionAlgorithm) VALUES(',"'",
							paramName,"'",', ',"'",paramURL,"'",', ',"'",paramAccountUsername,"'",', ',"'",paramEncryptedPassword,"'",', ',"'",paramNotes,"'",', ',"'",
                            paramCharacterEncoding,"'",', ',"'",paramCipherTransformation,"'",', ',"'",paramAesEncryptionAlgorithm,"'",')');
		PREPARE s FROM @sql;
        EXECUTE s;
        DEALLOCATE PREPARE s;
        
	END IF;
    
END //
DELIMITER ;

/*
 * Removes an account from the password manager.
 *
 * Parameter paramRemoveAccount		Name of the account being removed
 * Parameter paramOpalName			Opal username this account is stored under
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