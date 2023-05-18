package com.applab.test.MoCIMobileApp.testScripts.android;

import java.time.Duration;
import com.applab.test.MoCIApp.pageObjects.android.PopularServicesObjects;
import com.applab.test.MoCIMobileApp.testUtils.AndroidBaseClass;
import com.microsoft.appcenter.appium.Factory;
import com.microsoft.appcenter.appium.EnhancedAndroidDriver;
import org.junit.rules.TestWatcher;
import org.junit.Rule;


public class TestPopularServicesGuestUser extends AndroidBaseClass {
	@Rule
    public TestWatcher watcher = Factory.createWatcher();
	
	@org.junit.Test
	public void testGuestPopularServices() throws InterruptedException {
		PopularServicesObjects popularObjects = new PopularServicesObjects(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	
		popularObjects.testDailyBulletin();
		popularObjects.testVegetables("Corn");
		popularObjects.testFruits("Cherry");
		popularObjects.testFish(null);
		popularObjects.testTradeService();
		popularObjects.setSearchTradeName("Applab");
		popularObjects.testTendersAuctions("Qatar");
		popularObjects.testComplaint("29700000121","John Doe","john@gmail.com","70775696","NBKJ","Submit");
		popularObjects.testSuggestion("29700000121","John Doe","john@gmail.com","70775696","Send");
		driver.label("completed TC02_PopularServices_Guest_User");
	}
}