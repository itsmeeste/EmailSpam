package com.qa.quickstart.SomeWebSite;

import java.io.File;
import java.util.Random;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class WebsiteTest
{
	
	public static ExtentReports report;
	public ExtentTest test;
	WebDriver driver;
	
	String url = "http://kleki.com/";
	
	@BeforeClass
	public static void init()
	{
		report = new ExtentReports(System.getProperty("user.dir") + "\\report.html");
		
	}
	
	@AfterClass
	public static void end()
	{
		report.flush();
	}
	
	@Before
	public void Start()
	{
		System.setProperty("webdriver.chrome.driver","C:/Testing/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		test = report.startTest("test");
		
		
	}
	
	@Test
	public void Test() throws Exception
	{
		test.log(LogStatus.INFO, "Started");
		//driver.get(url);
		//homepage home = PageFactory.initElements(driver, homepage.class);
		//Actions action = new Actions(driver);
		//home.drawTesting(action);
		//File srcfile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//String filepath = srcfile.getAbsolutePath();
		//System.out.println(filepath);
		SendEmail email = new SendEmail();
//		email.Send("itsmeeste@gmail.com", filepath);
//		email.read();
		Utils.file();
		System.out.println(Utils.filepaths.get(0));
		
		// randomly select a number
		Random r = new Random();
		int Low = 0;
		int High = 2;
		int Result = r.nextInt(High-Low) + Low;
		
		Utils.random = Result;
		email.SendTestStuff("itsmeeste@gmail.com",Utils.filepaths.get(Utils.random),Utils.expected.get(Utils.random));
		System.out.println("Got to this point");
		test.log(LogStatus.INFO, "Finished Drawing");
		//home.clickPage(homepage.webPage.WOMEN);
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		test.log(LogStatus.PASS, "Finished TEST");
		
	}
	
	@After
	public void tearDown()
	{
		driver.quit();
		report.endTest(test);
	}

}
