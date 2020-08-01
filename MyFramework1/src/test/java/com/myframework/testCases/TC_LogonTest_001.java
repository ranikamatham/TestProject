package com.myframework.testCases;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.myframework.pageObjects.LoginPage;

public class TC_LogonTest_001 extends BaseClass {

	// once control comes into this page first the control will go to base class and
	// setup() will executes first and then @ test() will executes

	@Test
	public void loginTest() {

		driver.get(baseURL);
		LoginPage lp = new LoginPage(driver);
		lp.clickSubmit();
		System.out.println("**Title**" + driver.getTitle());
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

		String MainWindow = driver.getWindowHandle();

		// To handle all new opened window.
		Set<String> s1 = driver.getWindowHandles();

		Iterator<String> i1 = s1.iterator();

		while (i1.hasNext()) {
			String ChildWindow = i1.next();

			if (!MainWindow.equalsIgnoreCase(ChildWindow)) {

				// Switching to Child window
				driver.switchTo().window(ChildWindow);
				System.out.println("****New window title***" + driver.getTitle());

				lp.setUserName(username);
				// System.out.println("****New username title***"+());
				driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);

				lp.setPassWord(password);
				driver.manage().window().maximize();
				//driver.manage().timeouts().implicitlyWait(120, 
				//WebElement iFrame = driver.findElement(By.xpath("/html/body/div[2]/div[4]\r\n" + 
						//""));
				//driver.switchTo().frame(iFrame);

				/*WebElement iFrame_checkbox = driver
						.findElement(By.xpath("/html/body/div[2]/div[3]/div[1]/div/div/span/div[1]\r\n" + ""));
				iFrame_checkbox.click();

				lp.check();*/
			 // driver.manage().window().maximize();
				lp.clickLogin();

			if (driver.getTitle().equals("Cli" + "ent Area - PHPTRAVELS")) {

					Assert.assertTrue(true);

				} else {

					Assert.assertTrue(false);
				}

			}
		}
	}
}

		
	

