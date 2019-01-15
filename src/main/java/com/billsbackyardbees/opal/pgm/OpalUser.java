package com.billsbackyardbees.opal.pgm;

/**
 * An user of this program.
 * @author Quinn Shultz
 *
 */
public abstract class OpalUser {
	
	private int id;
	private String userName;
	private String fullName;
	private String publicKey;
	
	public OpalUser() {
		
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
	public String getUserName() {
		return userName;
	}
	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
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
	

}
