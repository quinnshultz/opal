/*
 * Copyright (c) 2019 Quinn Shultz <vanoxite@gmail.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.billsbackyardbees.opal.db;

/**
 * Defines an Object type that is perfectly compatible with the Opal database tables.
 * @author Quinn Shultz
 */
public interface OpalDataType {

	/**
	 * All classes that implement this interface are Objects that correspond to tuples
	 * in the RDBMS. The id is the primary key of all tables. It has option auto increment
	 * so there will not be a java method to set the id.
	 * 
	 * @return id and primary key of tuple
	 */
	public int getId();
	
}
