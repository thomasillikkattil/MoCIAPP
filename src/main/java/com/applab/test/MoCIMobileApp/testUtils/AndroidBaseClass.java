package com.applab.test.MoCIMobileApp.testUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import com.applab.test.MoCIApp.pageObjects.android.LoginObjects;
import com.microsoft.appcenter.appium.EnhancedAndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import utils.AppiumUtils;
import io.appium.java_client.AppiumBy;
import com.microsoft.appcenter.appium.Factory;
import org.junit.rules.TestWatcher;
import org.junit.Rule;

public class AndroidBaseClass extends AppiumUtils {
	public static EnhancedAndroidDriver<WebElement> driver;
	public static AppiumDriverLocalService service;
	public static LoginObjects loginObjects;
	@Rule 
	public TestWatcher watcher = Factory.createWatcher();
	
	@org.junit.BeforeClass
	public static void ConfigureAppium() throws IOException
	{		
		Properties prop= new Properties();
		FileInputStream fis=new FileInputStream("C://Users//thoma//eclipse-workspace//MoCIMobileApp//src//main//java//com//applab//test//MoCIApp//resources//data.properties");
		prop.load(fis);
		String ipAddress= prop.getProperty("ipAddress");
		String port= prop.getProperty("port");
		service = startAppiumServer(ipAddress,Integer.parseInt(port));
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("deviceName", "RF8TB0QC1TJ");
		caps.setCapability("app", "C://Users//thoma//eclipse-workspace//MoCIMobileApp_Appcenter_Integration//app-development-debug-17-05.apk");
		//options.setCapability(MobileCapabilityType.NO_RESET, true);
		caps.setCapability("unicodeKeyboard", "false");                                    
		caps.setCapability("resetKeyboard", "true");
		caps.setCapability("autoGrantPermissions", "true");
		caps.setCapability("appium:automationName", "UIAutomator2");
		driver = Factory.createAndroidDriver(service.getUrl(),caps);
		System.out.println("driver initialized");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(180));
		loginObjects = new LoginObjects(driver);
		System.out.println("App is ready to launch");
		driver.findElement(AppiumBy.id("com.applab.moci.dev:id/englishButton")).click();
		driver.findElement(AppiumBy.id("com.applab.moci.dev:id/ivClose")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		System.out.println("***Configurations completed***");
	}
	@org.junit.AfterClass
	public static void tearDown() {
		driver.label("Stopping App");
		driver.quit();
		service.stop();
	}

}
