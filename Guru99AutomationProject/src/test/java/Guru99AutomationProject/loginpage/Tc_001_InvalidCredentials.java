package Guru99AutomationProject.loginpage;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Guru99AutomationProject.testbase.TestBase;
import uiActions.Loginpage;

public class Tc_001_InvalidCredentials extends TestBase {

	/**
	 * 
	 * @ description //WebDriver dr; // created reference for interface
	 * Webdriver now we will remove this as webdriver dr is already initialized
	 * in testbase and this class extends base class.
	 * 
	 * @see init
	 */
	public static final Logger log = Logger.getLogger(Tc_001_InvalidCredentials.class.getName());

	@BeforeTest
	public void setup() {

		//

		init();

		log.info("Opening browser & getting redirected to url");
	}

	@Test
	public void verifyInvalidCredentials() throws InterruptedException {

		/**
		 * 
		 * created object to initialize
		 */

		Loginpage login_page = PageFactory.initElements(dr, Loginpage.class);

		login_page.invalidlogintoapplication("Test", "password");

		log.info("Enter credentials");

		Thread.sleep(5000L);

		// to handle alert box and get text of alert

		Alert alert = dr.switchTo().alert();

		System.out.println("******" + alert.getText() + "******");

		alert.accept();
		
		log.info("getting text from alert box.");
	}

	@AfterTest
	public void endTest() {

		dr.close();
		
		log.info("Closing browser");
	}

}
