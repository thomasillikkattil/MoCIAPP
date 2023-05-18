package com.applab.test.MoCIMobileApp.testScripts.android;


import com.applab.test.MoCIApp.pageObjects.android.HomePageObjects;
import com.applab.test.MoCIMobileApp.testUtils.AndroidBaseClass;
import com.microsoft.appcenter.appium.Factory;
import com.microsoft.appcenter.appium.EnhancedAndroidDriver;
import org.junit.rules.TestWatcher;
import org.junit.Rule;


public class TestPopularServicesRegisteredUser extends AndroidBaseClass {
	@Rule
    public TestWatcher watcher = Factory.createWatcher();
	public HomePageObjects homeObjects;
	@org.junit.Test
	public void testPopularServices() throws InterruptedException {
		loginObjects.enterCredentials("29700000041", "ApplabQatar123");
		homeObjects = loginObjects.clickLoginButton();
		homeObjects.testInvestorServicesHomepage();
		homeObjects.testConsumerServicesHomepage();
		homeObjects.testIndustrialServicesHomepage();
		homeObjects.testSendSuggestion("Send");
		homeObjects.testReportComplaint("Submit");
		homeObjects.testGeneralServices();
		driver.label("tested TC03_PopularServices_Registered_User");
	}
}