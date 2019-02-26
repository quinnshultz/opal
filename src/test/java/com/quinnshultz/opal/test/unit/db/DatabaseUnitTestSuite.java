package com.quinnshultz.opal.test.unit.db;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

// Database Suite Test
@RunWith(Suite.class)

@SuiteClasses({ OpalUserTest.class, OpalUserNotFoundTest.class })

public class DatabaseUnitTestSuite {

}
