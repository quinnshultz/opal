package test;

import junit.framework.TestCase;
import pwmgr.AccountDBLoader;

import org.junit.Test;

/**
 * Tests for password encryption
 * @author quinnshultz
 *
 */
public class AccountLoaderTest extends TestCase {
	
	private final String EXAMPLE_ACCOUNT_URL = "https://accounts.spotify.com/en/login";
	private final String EXAMPLE_ACCOUNT_NAME = "Spotify";
	private final String EXAMPLE_USERNAME = "johndoe";
	private final String EXAMPLE_ORIGINAL_PASSWORD = "Uu%W@7Z2iaWa5@q7";
	private final String EXAMPLE_ENCRYPTION_KEY = "ABCDEFGHIJKLMNOP";
	private final String EXAMPLE_NOTES = "My favorite streaming service!";
	
	private AccountDBLoader encrypter;

	/**
	 * Constructs a new AccountDBLoader Object
	 */
	protected void setUp() throws Exception {
		super.setUp();
		
		encrypter = new AccountDBLoader();
	}
	
	/**
	 * Tests that a new AccountDBLoader Object may be constructed without error
	 */
	@Test
	public void testADBLConstructor() {
		assertNotNull(encrypter);
	}
	
	/**
	 * Tests that the URL can be retrieved after it is set
	 */
	@Test
	public void testUrl() {
		encrypter.setUrl(EXAMPLE_ACCOUNT_URL);
		assertEquals(encrypter.getUrl(), EXAMPLE_ACCOUNT_URL);
	}
	
	/**
	 * Tests that the account name can be retrieved after it is set
	 */
	@Test
	public void testName() {
		encrypter.setName(EXAMPLE_ACCOUNT_NAME);
		assertEquals(encrypter.getName(), EXAMPLE_ACCOUNT_NAME);
	}
	
	/**
	 * Tests that the username can be retrieved after it is set
	 */
	@Test
	public void testUsername() {
		encrypter.setUsername(EXAMPLE_USERNAME);
		assertEquals(encrypter.getUsername(), EXAMPLE_USERNAME);
	}
	
	/**
	 * Tests that the password can be retrieved after it is set
	 */
	@Test
	public void testPassword() {
		encrypter.storePassword(EXAMPLE_ORIGINAL_PASSWORD);
		assertEquals(encrypter.retrievePassword(), EXAMPLE_ORIGINAL_PASSWORD);
	}
	
	/**
	 * Tests that the password is encrypted when it is set
	 */
	@Test
	public void testEncryption() {
		encrypter.storePassword(EXAMPLE_ORIGINAL_PASSWORD);
		assertNotSame(encrypter.getEncryptedPassword(), EXAMPLE_ORIGINAL_PASSWORD);
	}
	
	/**
	 * Tests that the encryption key can be retrieved after it is set
	 */
	@Test
	public void testEncryptionKey() {
		encrypter.setEncryptionKey(EXAMPLE_ENCRYPTION_KEY);
		assertEquals(encrypter.getEncryptionKey(), EXAMPLE_ENCRYPTION_KEY);
	}
	
	/**
	 * Tests that notes may be retrieved after they are set
	 */
	@Test
	public void testNotes() {
		encrypter.setNotes(EXAMPLE_NOTES);
		assertEquals(encrypter.getNotes(), EXAMPLE_NOTES);
	}
	
}
