package Guru99AutomationProject.loginpage;

import org.testng.annotations.Test;

import Guru99AutomationProject.testbase.TestBase;
import uiActions.Loginpage;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import java.sql.Time;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.PageFactory;
import org.testng.SkipException;
import org.testng.annotations.AfterTest;

public class Tc_002_ValidLogin extends TestBase {

	public static final Logger log = Logger.getLogger(Tc_002_ValidLogin.class.getName());

	@DataProvider(name = "login_data")

	public String[][] getTestData() {

		// call method getdata from testbase.
		// give excelname and sheet name here
		String[][] testrecords = getData("Guru99TestData.xlsx", "LoginTestData");
		return testrecords;

	}

	@Test(dataProvider = "login_data")
	public void verifyValidLogin(String uname2, String pass2, String runMode) {
		
		if (runMode.equalsIgnoreCase("N")) {
			
			throw new SkipException("Runmode is set to No!!!!");
			
		}
		
		
		
		
		
		
		
		log.info("====== Login with multiple records======");

		Loginpage login_page2 = PageFactory.initElements(dr, Loginpage.class);

		login_page2.validLogin(uname2, pass2);

		// calling method to get text after login
		String text = login_page2.managertext();

		System.out.println("*****" + text + "*****");

		login_page2.Logout();

		Alert alert = dr.switchTo().alert();

		System.out.println("******" + alert.getText() + "******");

		alert.accept();

		log.info("getting text from alert box.");

	}

	@BeforeTest
	public void setup2() {

		init();

		log.info("Opening browser & getting redirected to url");
	}

	@AfterTest
	public void afterTest() {

		/*
		 * dr.close();
		 * 
		 * log.info("Closing browser");
		 */

	}

}
