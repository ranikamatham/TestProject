package com.myframework.testCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseClass {

	public String baseURL = "https://phptravels.com/demo";
	public String username = "ranimarpuri@gmail.com";
	public String password = "Chinnu@123";

	public static WebDriver driver;

	// in setup method we will intialize the drivers eg; chrome,ie
	// in maven project all the drivers also should avail in project itself( Drivers
	// folder)
	// user.dir - is project home directory

	@BeforeClass
	public void setUP() {
		System.out.println("****************************************");
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//Drivers//chromedriver.exe");
		System.out.println("after system" + System.getProperty("webdriver.chrome.driver"));

		// ChromeOptions options = new ChromeOptions();
		//options.setPageLoadStrategy(PageLoadStrategy.EAGER);
		// driver= new ChromeDriver(options);
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		System.out.println("**************After Chrome**********");
		// driver.get("http://www.facebook.com");
		// driver.manage().window().maximize();

	}

	@AfterClass
	public void tearDown() {

		driver.quit();

	}

}
