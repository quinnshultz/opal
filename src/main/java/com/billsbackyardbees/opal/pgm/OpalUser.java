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
	private String characterEncoding;
	private String cipherTransformation;
	private String aesEncryptionAlgorithm;
	
	// TODO: Create constructor
	
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
	/**
	 * @return the characterEncoding
	 */
	public String getCharacterEncoding() {
		return characterEncoding;
	}
	/**
	 * @param characterEncoding the characterEncoding to set
	 */
	public void setCharacterEncoding(String characterEncoding) {
		this.characterEncoding = characterEncoding;
	}
	/**
	 * @return the cipherTransformation
	 */
	public String getCipherTransformation() {
		return cipherTransformation;
	}
	/**
	 * @param cipherTransformation the cipherTransformation to set
	 */
	public void setCipherTransformation(String cipherTransformation) {
		this.cipherTransformation = cipherTransformation;
	}
	/**
	 * @return the aesEncryptionAlgorithm
	 */
	public String getAesEncryptionAlgorithm() {
		return aesEncryptionAlgorithm;
	}
	/**
	 * @param aesEncryptionAlgorithm the aesEncryptionAlgorithm to set
	 */
	public void setAesEncryptionAlgorithm(String aesEncryptionAlgorithm) {
		this.aesEncryptionAlgorithm = aesEncryptionAlgorithm;
	}
	

}
