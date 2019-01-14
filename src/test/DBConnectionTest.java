package test;

import junit.framework.TestCase;
import database.DBConnection;

import org.junit.Test;

public class DBConnectionTest extends TestCase {
	
	private DBConnection connection;

	/**
	 * Constructs a new DBConnection Object
	 */
	protected void setUp() throws Exception {
		super.setUp();
		connection = new DBConnection();
	}
	
	/**
	 * Tests that a new DBConnection Object is constructed
	 */
	@Test
	public void testDBCConstructor() {
		assertNotNull(connection);
	}
}
