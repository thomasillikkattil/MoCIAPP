package com.applab.test.MoCIApp.pageObjects.android;

import static org.junit.Assert.*;
import java.util.List;
import org.junit.Rule;
import org.junit.rules.TestWatcher;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import com.microsoft.appcenter.appium.Factory;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import utils.AndroidActions;

public class HomePageObjects extends AndroidActions {
	AndroidDriver driver;
	@Rule 
	TestWatcher watcher = Factory.createWatcher();

	public HomePageObjects(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(id = "com.applab.moci.dev:id/sideMenuButton")
	private WebElement mainMenuIcon;

	@AndroidFindBy(id = "com.applab.moci.dev:id/contactUsButton")
	private WebElement contactUs;

	@AndroidFindBy(id = "com.applab.moci.dev:id/fab")
	private WebElement servicesIcon;
	
	@AndroidFindBy(id= "com.applab.moci.dev:id/informationButton")
	private WebElement informationBtn;

	public void testSendSuggestion(String btnLabel) throws InterruptedException {
		mainMenuIcon.click();
		contactUs.click();
		driver.findElement(AppiumBy.id("com.applab.moci.dev:id/clSuggestions")).click();
		scrollToText(btnLabel);
		driver.findElement(AppiumBy.id("com.applab.moci.dev:id/etSuggestions")).sendKeys("Test Suggestion");
		driver.findElement(AppiumBy.id("com.applab.moci.dev:id/gAttachmentPrompt")).click();
		driver.findElement(AppiumBy.id("com.applab.moci.dev:id/camera")).click();
		driver.findElement(AppiumBy.id("com.sec.android.app.camera:id/normal_center_button")).click();
		driver.findElement(AppiumBy
				.xpath("//android.widget.Button[@content-desc=\"OK\"]/android.view.ViewGroup/android.widget.TextView"))
				.click();
		driver.findElement(AppiumBy.id("com.applab.moci.dev:id/tvBtnSend")).click();
		Thread.sleep(2000);
		System.out.println("Tested submitting a suggestion");
		driver.findElement(AppiumBy.id("com.applab.moci.dev:id/positiveActionButton")).click();
	}

	public void testInvestorServicesHomepage() throws InterruptedException {
		System.out.println("inside testInvestorServicesHomepage");
		servicesIcon.click();
		driver.findElement(By.xpath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]"))
				.click();

		String actualInvestorPageTitle = driver.findElement(AppiumBy.id("com.applab.moci.dev:id/tvTitle")).getText();
		String expectedInvestortedInvestorPageTitle = "Investor Services";
		assertEquals(expectedInvestortedInvestorPageTitle, actualInvestorPageTitle);

		System.out.println("Investor services page is loaded and the title has been verified");
		driver.findElement(AppiumBy.id("com.applab.moci.dev:id/btnBack")).click();
	}

	public void testConsumerServicesHomepage() throws InterruptedException {
		System.out.println("inside testConsumerServicesHomepage");
		servicesIcon.click();
		driver.findElement(By.xpath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[2]"))
				.click();

		String actualInvestorPageTitle = driver.findElement(AppiumBy.id("com.applab.moci.dev:id/tv_notification_title"))
				.getText();
		String expectedInvestorPageTitle = "Consumer Services";
		assertEquals(expectedInvestorPageTitle, actualInvestorPageTitle);
		System.out.println("Supply services page is loaded and the title has been verified");
		driver.findElement(AppiumBy.id("com.applab.moci.dev:id/sideMenuButton")).click();
	}

	public void testIndustrialServicesHomepage() throws InterruptedException {
		System.out.println("inside testIndustrialServicesHomepage");
		servicesIcon.click();
		driver.findElement(By.xpath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[3]"))
				.click();

		String actualInvestorPageTitle = driver.findElement(AppiumBy.id("com.applab.moci.dev:id/tvTitle")).getText();
		String expectedInvestortedInvestorPageTitle = "Industry Services";
		assertEquals(expectedInvestortedInvestorPageTitle, actualInvestorPageTitle);

		System.out.println("Industry services page is loaded");
		driver.findElement(AppiumBy.id("com.applab.moci.dev:id/btnBack")).click();
	}

	public void testReportComplaint(String btnLabel) throws InterruptedException {
		System.out.println("inside testReportComplaint");
		servicesIcon.click();
		driver.findElement(By.xpath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[2]"))
				.click();
		driver.findElement(AppiumBy.xpath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/androidx.appcompat.widget.LinearLayoutCompat/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]"))
				.click();
		driver.findElement(AppiumBy.id("com.applab.moci.dev:id/clItemWtsShop")).click();
		driver.findElement(AppiumBy.id("com.applab.moci.dev:id/clPersonalInfo")).click();
		scrollToText(btnLabel);
		driver.findElement(AppiumBy.id("com.applab.moci.dev:id/clComplaintType")).click();

		List<WebElement> complaintType = driver.findElements(AppiumBy.id("com.applab.moci.dev:id/rvComplaintType"));
		System.out.println("Found dropdown");
		System.out.println("Dropdown size: " + complaintType.size());
		System.out.println("Dropdown content: "+ complaintType.get(0).getText());
		complaintType.get(0).click();
		driver.findElement(AppiumBy.id("com.applab.moci.dev:id/etStoreName")).sendKeys("Maxxx");
		driver.findElement(AppiumBy.id("com.applab.moci.dev:id/etComplaintDescription")).sendKeys("Test complaint");
		driver.findElement(AppiumBy.id("com.applab.moci.dev:id/gAttachmentPrompt")).click();
		driver.findElement(AppiumBy.id("com.applab.moci.dev:id/camera")).click();
		driver.findElement(AppiumBy.id("com.sec.android.app.camera:id/normal_center_button")).click();
		driver.findElement(AppiumBy
				.xpath("//android.widget.Button[@content-desc=\"OK\"]/android.view.ViewGroup/android.widget.TextView"))
				.click();
		driver.findElement(AppiumBy.id("com.applab.moci.dev:id/tvBtnSubmit")).click();
		Thread.sleep(2000);
		// driver.switchTo().activeElement();
		String expectedSuccessTextTitle = "Success";
		String actualTextTitle = driver.findElement(AppiumBy.id("com.applab.moci.dev:id/titleText")).getText();
		assertEquals(actualTextTitle, expectedSuccessTextTitle);
		driver.findElement(AppiumBy.id("com.applab.moci.dev:id/positiveActionButton")).click();
		driver.navigate().back();
		//driver.findElement(AppiumBy.id("com.applab.moci.dev:id/sideMenuButton")).click();
	}
	
	public void testGeneralServices() throws InterruptedException {
		informationBtn.click();
		
		WebElement ministryNews = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/androidx.appcompat.widget.LinearLayoutCompat[1]/android.widget.FrameLayout/android.view.ViewGroup"));
		ministryNews.click();
		String newsHeader= driver.findElement(AppiumBy.id("com.applab.moci.dev:id/tvTitle")).getText();
		String expectedNewsHeader="Ministry News";
		assertEquals(newsHeader,expectedNewsHeader);
		driver.findElement(AppiumBy.id("com.applab.moci.dev:id/btnBack")).click();
		
		WebElement ministryInitiatives = driver.findElement(AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/androidx.appcompat.widget.LinearLayoutCompat[2]/android.widget.FrameLayout/android.view.ViewGroup"));
		ministryInitiatives.click();
		String initiativesHeader= driver.findElement(AppiumBy.id("com.applab.moci.dev:id/tvTitle")).getText();
		String expectedInitiativesHeader="Ministry Initiatives";
		assertEquals(initiativesHeader,expectedInitiativesHeader);
		driver.navigate().back();
		
		WebElement dailyBulletin = driver.findElement(AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/androidx.appcompat.widget.LinearLayoutCompat[3]/android.widget.FrameLayout/android.view.ViewGroup"));
		dailyBulletin.click();
		String bulletinHeader= driver.findElement(AppiumBy.id("com.applab.moci.dev:id/tvDailyBullettinTitle")).getText();
		String expectedBulletinHeader="Daily Bulletin";
		assertEquals(bulletinHeader,expectedBulletinHeader);
		driver.navigate().back();
		
		WebElement tenders = driver.findElement(AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/androidx.appcompat.widget.LinearLayoutCompat[4]/android.widget.FrameLayout/android.view.ViewGroup"));
		tenders.click();
		String tendersHeader= driver.findElement(AppiumBy.id("com.applab.moci.dev:id/tvTitle")).getText();
		String expectedTendersHeader="Tenders And Auctions";
		assertEquals(tendersHeader,expectedTendersHeader);
		driver.findElement(AppiumBy.id("com.applab.moci.dev:id/etSearch")).sendKeys("Qatar\n");
		driver.navigate().back();
		
		WebElement tradeName = driver.findElement(AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/androidx.appcompat.widget.LinearLayoutCompat[5]/android.widget.FrameLayout/android.view.ViewGroup"));
		tradeName.click();
		String tradeHeader= driver.findElement(AppiumBy.id("com.applab.moci.dev:id/tv_search_inquiry_title")).getText();
		String expectedTradeHeader="Search For A Trade Name";
		assertEquals(tradeHeader,expectedTradeHeader);
		//driver.findElement(AppiumBy.id("com.applab.moci.dev:id/ed_search")).sendKeys("Applab\n");
		//Thread.sleep(2000);
		driver.navigate().back();
		driver.findElement(AppiumBy.id("com.applab.moci.dev:id/homeButton")).click();
		
	}
}
