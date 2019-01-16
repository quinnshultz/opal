package com.billsbackyardbees.opal.util;

/**
 * An user of this program.
 * @author Quinn Shultz
 *
 */
public class OpalUser {
	
	private int id;
	private String userName;
	private String fullName;
	private String publicKey;
	
	/**
	 * Create an user of this program
	 */
	public OpalUser() {
		id = -1;
	}
	
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @return the userName
	 */
	public String getUsername() {
		return userName;
	}
	/**
	 * @param userName the userName to set
	 */
	public void setUsername(String userName) {
		this.userName = userName;
	}
	/**
	 * @return the fullName
	 */
	public String getFullName() {
		return fullName;
	}
	/**
	 * @param fullName the fullName to set
	 */
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	/**
	 * @return the publicKey
	 */
	public String getPublicKey() {
		return publicKey;
	}

	/**
	 * @param publicKey the publicKey to set
	 */
	public void setPublicKey(String publicKey) {
		this.publicKey = publicKey;
	}
	
	

}
