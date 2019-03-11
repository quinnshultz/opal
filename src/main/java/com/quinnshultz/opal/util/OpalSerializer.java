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
package com.quinnshultz.opal.util;

/**
 * Stores the database version. Used to serialize java beans.
 * 
 * @author Quinn Shultz
 */
public class OpalSerializer {
	
	// Official database version.
	// This must be incremented every
	// time the schema is changed
	static final long DATABASE_SCHEMA_VERSION = 7L;
	
	/**
	 * @return The database schema version
	 */
	public static long getSerialVersionUID() {
		return DATABASE_SCHEMA_VERSION;
	}

}
