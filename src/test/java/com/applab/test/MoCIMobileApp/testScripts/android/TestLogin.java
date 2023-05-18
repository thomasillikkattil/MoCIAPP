package com.applab.test.MoCIMobileApp.testScripts.android;

import com.applab.test.MoCIApp.pageObjects.android.LoginObjects;
import com.applab.test.MoCIMobileApp.testUtils.AndroidBaseClass;
import com.microsoft.appcenter.appium.Factory;
import com.microsoft.appcenter.appium.EnhancedAndroidDriver;
import org.junit.rules.TestWatcher;
import org.junit.Rule;

public class TestLogin extends AndroidBaseClass {
	@Rule
    public TestWatcher watcher = Factory.createWatcher();
	/*
	 * public void login() throws InterruptedException { LoginObjects loginObjects=
	 * new LoginObjects(driver); loginObjects.login();
	 * loginObjects.setUsername("29700000041");
	 * loginObjects.setPassword("ApplabQatar123"); Thread.sleep(10000); }
	 */
	@org.junit.Test
	public void validlogin() throws InterruptedException {
		LoginObjects loginObjects= new LoginObjects(driver);
		loginObjects.enterCredentials("29700000041", "ApplabQatar123");
		loginObjects.clickLoginButton();
		Thread.sleep(10000);
	}
	@org.junit.Test
	public void invalidlogin() throws InterruptedException {
		LoginObjects loginObjects= new LoginObjects(driver);
		loginObjects.enterCredentials("29700000041", "Applatar123");
		loginObjects.clickLoginButton();
		Thread.sleep(10000);
	}
}