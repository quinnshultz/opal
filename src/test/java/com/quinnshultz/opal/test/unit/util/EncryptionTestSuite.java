package com.quinnshultz.opal.test.unit.util;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)

@SuiteClasses({ DataEncrypterTest.class,
	KeyGenTest.class })

public class EncryptionTestSuite {

}
