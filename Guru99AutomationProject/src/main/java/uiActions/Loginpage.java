package uiActions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Guru99AutomationProject.testbase.TestBase;

public class Loginpage extends TestBase {

	WebDriver dr;

	@FindBy(name = "uid")
	WebElement userid;

	@FindBy(name = "password")
	WebElement password;

	@FindBy(xpath = "html/body/form/table/tbody/tr[3]/td[2]/input[1]")
	WebElement loginbutton;

	@FindBy(xpath = "html/body/table/tbody/tr/td/table/tbody/tr[2]/td/marquee")
	WebElement managerpage;

	@FindBy(xpath = "html/body/div[2]/div/ul/li[15]/a")
	WebElement logout;

	// create constructor to initialize

	public Loginpage(WebDriver dr) {

		// this: it refers to current class of this object

		PageFactory.initElements(dr, this);
	}

	public void invalidlogintoapplication(String uname, String pass) {

		userid.sendKeys(uname);

		password.sendKeys(pass);

		loginbutton.click();

	}

	public void validLogin(String uname2, String pass2) {

		waitForElement(5, userid);
		
		userid.isDisplayed();
		
		userid.sendKeys(uname2);

		password.sendKeys(pass2);

		loginbutton.click();

	}

	public String managertext() {

		String txt = managerpage.getText();

		return txt;

	}

	public void Logout() {

		logout.click();

	}

}
