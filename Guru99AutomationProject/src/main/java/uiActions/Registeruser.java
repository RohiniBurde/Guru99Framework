package uiActions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Registeruser {
	WebDriver dr;

	@FindBy(linkText = "here")
	WebElement registrationlink;

	@FindBy(name = "emailid")
	WebElement Email;

	@FindBy(name = "btnLogin")
	WebElement Submitbutton;

	@FindBy(xpath = "html/body/table/tbody/tr[4]/td[2]")
	WebElement Credentials;

	@FindBy(xpath = "html/body/table/tbody/tr[5]/td[2]")
	WebElement Credentials2;

	// create constructor to initialize

	public Registeruser(WebDriver dr) {

		// this: it refers to current class of this object

		PageFactory.initElements(dr, this);
	}

	public void registernew(String email) {

		registrationlink.click();

		Email.sendKeys(email);

		Submitbutton.click();

		Credentials.getText();

		Credentials2.getText();

	}
}
