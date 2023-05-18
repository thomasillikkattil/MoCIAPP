package com.applab.test.MoCIApp.pageObjects.android;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import utils.AndroidActions;

@Test
public class LoginObjects extends AndroidActions {
	AndroidDriver driver;

	public LoginObjects(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(id = "com.applab.moci.dev:id/btn_login")
	private WebElement loginBtn;

	@AndroidFindBy(id = "com.applab.moci.dev:id/etUserName")
	private WebElement usernameField;

	@AndroidFindBy(id = "com.applab.moci.dev:id/etPassword")
	private WebElement passwordField;

	@AndroidFindBy(id = "com.applab.moci.dev:id/btnLogin")
	private WebElement loginButton;

	@AndroidFindBy(id = "com.applab.moci.dev:id/negativeActionButton")
	private WebElement disableBiometric;

	@AndroidFindBy(id = "com.applab.moci.dev:id/tvTitle")
	private WebElement myDevicesTitle;

	@AndroidFindBy(id = "com.applab.moci.dev:id/positiveActionButton")
	private WebElement removeDeviceBtn;

	/*
	 * public void login() { loginBtn.click(); } public void setUsername(String
	 * username) { usernameField.sendKeys(username); } public void
	 * setPassword(String password) { passwordField.sendKeys(password);
	 * loginButton.click(); disableBiometric.click(); }
	 */
	public void enterCredentials(String username, String password) {
		loginBtn.click();
		usernameField.sendKeys(username);
		passwordField.sendKeys(password);
	}

	public HomePageObjects clickLoginButton() throws NoSuchElementException {
		loginButton.click();
		disableBiometric.click();
		By multiDevices = By.id("com.applab.moci.dev:id/tvTitle");
		boolean isElementPresent = isElementPresent(driver, multiDevices);
		// boolean multiDevices = myDevicesTitle.isDisplayed();
		if (isElementPresent) {
			List<WebElement> removeDevicesLabel = driver
					.findElements(By.xpath("//android.widget.TextView[@text='Remove this Device']"));
			for (int i = 1; i < removeDevicesLabel.size(); i++) {
				removeDevicesLabel.get(i).click();
				driver.findElement(By.id("com.applab.moci.dev:id/positiveActionButton")).click();
				System.out.println("Logged in by removing additional devices");
			}
		} else {
			System.out.println("Logged in without removing additional devices");
		}
		return new HomePageObjects(driver);
	}

	private static boolean isElementPresent(AndroidDriver driver, By locator) {
		try {
			WebElement element = driver.findElement(locator);
			return element.isDisplayed();
		} catch (NoSuchElementException e) {
			return false;
		}
	}
}