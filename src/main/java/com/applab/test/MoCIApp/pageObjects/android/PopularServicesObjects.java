package com.applab.test.MoCIApp.pageObjects.android;

import static org.junit.Assert.*;
import java.util.List;
import org.junit.Rule;
import org.junit.rules.TestWatcher;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import com.microsoft.appcenter.appium.Factory;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import utils.AndroidActions;

public class PopularServicesObjects extends AndroidActions{
	AndroidDriver driver;
	@Rule 
	TestWatcher watcher = Factory.createWatcher();
	
	public PopularServicesObjects(AndroidDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	@AndroidFindBy(xpath="(//androidx.appcompat.widget.LinearLayoutCompat)[2]")
	private WebElement dailyBullettin;
	
	@AndroidFindBy(xpath="(//androidx.appcompat.widget.LinearLayoutCompat)[3]")
	private WebElement tradeNameService;
	
	@AndroidFindBy(xpath="(//androidx.appcompat.widget.LinearLayoutCompat)[4]")
	private WebElement tendersAuctions;
	
	@AndroidFindBy(xpath="(//androidx.appcompat.widget.LinearLayoutCompat)[5]")
	private WebElement complaint;
	
	@AndroidFindBy(xpath="(//androidx.appcompat.widget.LinearLayoutCompat)[1]")
	private WebElement vegetables;
	
	@AndroidFindBy(xpath="(//androidx.appcompat.widget.LinearLayoutCompat)[2]")
	private WebElement fruits;
	
	@AndroidFindBy(xpath="(//androidx.appcompat.widget.LinearLayoutCompat)[3]")
	private WebElement fish;
	
	@AndroidFindBy(id="com.applab.moci.dev:id/ivBack")
	private WebElement backBtn;	
	
	@AndroidFindBy(id="com.applab.moci.dev:id/ed_search")
	private WebElement searchBox;
	
	@AndroidFindBy(id="com.applab.moci.dev:id/titleText")
	private WebElement successTestTitle;
	
	@AndroidFindBy(id="com.applab.moci.dev:id/sideMenuButton")
	private WebElement mainMenuIcon;
	
	//@AndroidBy(xpath="//android.widget.TextView[@text='Contact Us']")
	@AndroidFindBy(id="com.applab.moci.dev:id/contactUsButton")
	private WebElement contactUs;
	
	
	public void testDailyBulletin() {
		dailyBullettin.click();	
		System.out.println("Inside Daily Bulletin screen");
	}
	public void testVegetables(String vegName) {
		vegetables.click();
		scrollToText(vegName);
		//driver.findElement(AppiumBy.className("android.widget.TextView[@text='"+vegName+"']")).click();
		backBtn.click();
		System.out.println("Tested vegetables");
	}
	public void testFruits(String fruitName) {
		fruits.click();
		scrollToText(fruitName);
		backBtn.click();
		System.out.println("Tested Fruits");
	}
	public void testFish(String fishName) {
		fish.click();
		//scrollToText(fishName);
		backBtn.click();
		backBtn.click();
		System.out.println("Tested Fish");
	}	
	public void testTradeService() {
		tradeNameService.click();
	}
	public void setSearchTradeName(String tradeName) {
		searchBox.click();
		searchBox.sendKeys(tradeName+"\n");
		driver.findElement(AppiumBy.id("com.applab.moci.dev:id/backButton")).click();
		System.out.println("Tested trade name service");
	}
	public void testTendersAuctions(String searchString) {
		tendersAuctions.click();
		driver.findElement(AppiumBy.id("com.applab.moci.dev:id/etSearch")).sendKeys(searchString+"\n");
		driver.findElement(AppiumBy.id("com.applab.moci.dev:id/btnBack")).click();
		System.out.println("Tested tenders & auctions");
	}
	public void testComplaint(String qid,String name,String email,String phone,String store,String btnLabel) throws InterruptedException {
		complaint.click();
		driver.findElement(AppiumBy.id("com.applab.moci.dev:id/etQidNo")).sendKeys(qid);
		driver.findElement(AppiumBy.id("com.applab.moci.dev:id/etFullName")).sendKeys(name);
		driver.findElement(AppiumBy.id("com.applab.moci.dev:id/etEmailAddress")).sendKeys(email);
		driver.findElement(AppiumBy.id("com.applab.moci.dev:id/etPhone")).sendKeys(phone);
		driver.findElement(AppiumBy.id("com.applab.moci.dev:id/clComplaintType")).click();

		List<WebElement> complaintType= driver.findElements(AppiumBy.id("com.applab.moci.dev:id/rvComplaintType"));
		System.out.println("Found dropdown");
		System.out.println("Dropdown size: "+complaintType.size());
		complaintType.get(0).click();
		scrollToText(btnLabel);
		driver.findElement(AppiumBy.id("com.applab.moci.dev:id/etStoreName")).sendKeys(store);
		driver.findElement(AppiumBy.id("com.applab.moci.dev:id/etComplaintDescription")).sendKeys("Test complaint");
		driver.findElement(AppiumBy.id("com.applab.moci.dev:id/gAttachmentPrompt")).click();
		driver.findElement(AppiumBy.id("com.applab.moci.dev:id/camera")).click();
		driver.findElement(AppiumBy.id("com.sec.android.app.camera:id/normal_center_button")).click();
		driver.findElement(AppiumBy.xpath("//android.widget.Button[@content-desc=\"OK\"]/android.view.ViewGroup/android.widget.TextView")).click();
		driver.findElement(AppiumBy.id("com.applab.moci.dev:id/tvBtnSubmit")).click();
		Thread.sleep(2000);
		//driver.switchTo().activeElement();
		String expectedSuccessTextTitle="Success";
		String actualTextTitle= successTestTitle.getText();
		assertEquals(actualTextTitle, expectedSuccessTextTitle);
		System.out.println("Tested submitting a complaint1");
		driver.findElement(AppiumBy.id("com.applab.moci.dev:id/positiveActionButton")).click();
		Thread.sleep(2000);
	}
	public void testSuggestion(String qid,String name,String email,String phone,String btnLabel) throws InterruptedException {
		Thread.sleep(2000);
		mainMenuIcon.click();
		contactUs.click();
		driver.findElement(AppiumBy.id("com.applab.moci.dev:id/clSuggestions")).click();
		scrollToText(btnLabel);
		driver.findElement(AppiumBy.id("com.applab.moci.dev:id/etQidNo")).sendKeys(qid);
		driver.findElement(AppiumBy.id("com.applab.moci.dev:id/etFullName")).sendKeys(name);
		driver.findElement(AppiumBy.xpath("(//android.widget.EditText[@text='Email address'])")).sendKeys(email);
		driver.findElement(AppiumBy.id("com.applab.moci.dev:id/etPhone")).sendKeys(phone);
		driver.findElement(AppiumBy.id("com.applab.moci.dev:id/etSuggestions")).sendKeys("Test Suggestion");
		driver.findElement(AppiumBy.id("com.applab.moci.dev:id/gAttachmentPrompt")).click();
		driver.findElement(AppiumBy.id("com.applab.moci.dev:id/camera")).click();
		driver.findElement(AppiumBy.id("com.sec.android.app.camera:id/normal_center_button")).click();
		driver.findElement(AppiumBy.xpath("//android.widget.Button[@content-desc=\"OK\"]/android.view.ViewGroup/android.widget.TextView")).click();
		driver.findElement(AppiumBy.id("com.applab.moci.dev:id/tvBtnSend")).click();
		Thread.sleep(2000);
		//driver.switchTo().activeElement();
//		String expectedSuccessTextTitle="Success";
//		String actualTextTitle= driver.findElement(By.id("com.applab.moci.dev:id/titleText")).getText();
//		System.out.println("actual text: " + actualTextTitle);
//		Assert.assertEquals(actualTextTitle, expectedSuccessTextTitle);
		System.out.println("Tested submitting a suggestion");
		driver.findElement(AppiumBy.id("com.applab.moci.dev:id/positiveActionButton")).click();
		Thread.sleep(2000);
	}
}
