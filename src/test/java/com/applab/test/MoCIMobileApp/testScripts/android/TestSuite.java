package com.applab.test.MoCIMobileApp.testScripts.android;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;


@RunWith(Suite.class)
@Suite.SuiteClasses({
	TestPopularServicesGuestUser.class,
	TestPopularServicesRegisteredUser.class
})
public class TestSuite {
    // This class doesn't need any implementation
//	 static {
//	        new TestPopularServicesGuestUser();
//	        new TestPopularServicesRegisteredUser();
//	    }
}

