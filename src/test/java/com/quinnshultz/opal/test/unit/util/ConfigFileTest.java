package com.quinnshultz.opal.test.unit.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import com.quinnshultz.opal.util.ConfigFile;

/**
 * Tests the ConfigFile Object and .properties files.
 * 
 * @author Quinn Shultz
 */
public class ConfigFileTest {
	
	private final String DRIVER_CLASS_NAME = "com.mysql.cj.jdbc.Driver";
	private final String URL = "jdbc:mysql://localhost:3306/opalPasswordManager";
	private final String USERNAME = "jdbcopal";
	private final String PASSWORD = "Nth@Z8giog5uL3tD";
	
	private ConfigFile configFile;

	/**
	 * 
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		configFile = new ConfigFile();
	}

	/**
	 * Tests that the first String in the array returned by getDBProperties() matches the expected value
	 * for database driverClassName and that no Exception is thrown
	 */
	@Test
	public void testPropertiesClassName() {
		try {
			String[] result = configFile.getDBProperties();
			assertEquals(result[0], DRIVER_CLASS_NAME);
		} catch (Exception e) {
			fail("Caught Exception when executing getDBProperties()");
		}
	}
	
	/**
	 * Tests that the second String in the array returned by getDBProperties() matches the expected value
	 * for database url and that no Exception is thrown
	 */
	@Test
	public void testPropetiesUrl() {
		try {
			String[] result = configFile.getDBProperties();
			assertEquals(result[1], URL);
		} catch (Exception e) {
			fail("Caught Exception when executing getDBProperties()");
		}
	}
	
	/**
	 * Tests that the third String in the array returned by getDBProperties() matches the expected value
	 * for database username and that no Exception is thrown
	 */
	@Test
	public void testPropetiesUsername() {
		try {
			String[] result = configFile.getDBProperties();
			assertEquals(result[2], USERNAME);
		} catch (Exception e) {
			fail("Caught Exception when executing getDBProperties()");
		}
	}
	
	/**
	 * Tests that the fourth String in the array returned by getDBProperties() matches the expected value
	 * for database password and that no Exception is thrown
	 */
	@Test
	public void testPropetiesPassword() {
		try {
			String[] result = configFile.getDBProperties();
			assertEquals(result[3], PASSWORD);
		} catch (Exception e) {
			fail("Caught Exception when executing getDBProperties()");
		}
	}

}
