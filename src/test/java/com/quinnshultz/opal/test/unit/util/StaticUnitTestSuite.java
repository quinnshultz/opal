package com.quinnshultz.opal.test.unit.util;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

// Suite Tests for static methods or classes not meant to be instantiated
@RunWith(Suite.class)

@SuiteClasses({ DataEncrypterTest.class, OpalSerializerTest.class })

public class StaticUnitTestSuite {

}
