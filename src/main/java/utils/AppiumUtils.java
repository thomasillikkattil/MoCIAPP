package utils;

import java.io.File;
import java.time.Duration;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class AppiumUtils {
	
	public static AppiumDriverLocalService service;
	
	public static AppiumDriverLocalService startAppiumServer(String ipAddress,int port) {
			service = new AppiumServiceBuilder()
					.withAppiumJS(new File("C://Users//thoma//AppData//Roaming//npm//node_modules//appium//build//lib//main.js"))
					.withIPAddress(ipAddress).usingPort(port).withTimeout(Duration.ofSeconds(200))
					.usingDriverExecutable(new File("C://Program Files//nodejs//node.exe")).build();
		service.start();
		return service;
	}
	public void waitForElementToAppear(WebElement e,AppiumDriver driver) {
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(5000));
		wait.until(ExpectedConditions.attributeContains((e), null, null));
	}
	
	

}
