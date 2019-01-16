package com.billsbackyardbees.opal.util;

import com.billsbackyardbees.opal.db.OpalDataType;

public class SecretNote implements OpalDataType {

	private int id;
	
	public SecretNote() {
		
	}
	
	@Override
	public int getId() {
		return id;
	}

}
