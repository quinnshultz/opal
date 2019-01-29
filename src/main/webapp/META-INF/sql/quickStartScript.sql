/* 
 *                              Opal
 *                     A secure password manager
 * 
 *
 *                        SQL set-up script
 *
 * MySQL quick start script for creating an appropriate database and
 * account for the program to use. Also provides the user an option to
 * change the default SQL parameters used to connect to the database.
 * Changes must be mirrored to the database package in the Java project.
 */
 
/* Copyright (c) 2019 Quinn Shultz <vanoxite@gmail.com>
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
 
-- Creates a new database for Opal
Create database opalPasswordManager;

-- Creates a new user account for Opal
CREATE USER 'jdbcopal'@'localhost' IDENTIFIED BY 'Nth@Z8giog5uL3tD';

-- Grants all privileges to jdbcopal (new user) on opalPasswordManager (new database)
GRANT ALL PRIVILEGES ON opalPasswordManager.* TO 'jdbcopal'@'localhost' WITH GRANT OPTION;