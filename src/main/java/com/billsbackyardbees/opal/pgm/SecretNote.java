package com.billsbackyardbees.opal.pgm;

public class SecretNote implements PasswordManagerStorable {

	private int id;
	
	public SecretNote() {
		
	}
	
	@Override
	public int getId() {
		return id;
	}

}
