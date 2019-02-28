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

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Reads project .properties files.
 * 
 * @author Quinn Shultz
 */
public class ConfigFile {
	private String[] result;
	private InputStream inputStream;
	
	/**
	 * Constructor, creates a ConfigFile Object used to read the database authentication configuration.
	 */
	public ConfigFile() {
		result = new String[4];
	}
	
	/**
	 * Reads the config.properties file and returns the database configuration values.
	 * 
	 * @return An array of strings. First, the driver class name. Next, the database url. Finally, the username followed by the password.
	 * @throws IOException
	 */
	public String[] getDBProperties() throws IOException {
		try {
			Properties prop = new Properties();
			String propFileName = "config.properties";
			
			inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
			
			if (null != inputStream) {
				prop.load(inputStream);
			} else {
				throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
			}
			
			result[0] = prop.getProperty("jdbc.driverClassName");
			result[1] = prop.getProperty("jdbc.url");
			result[2] = prop.getProperty("jdbc.username");
			result[3] = prop.getProperty("jdbc.password");
		} catch (Exception e) {
			// TODO: Auto generated method stub
		} finally {
			inputStream.close();
		}
		return result;
	}
}
