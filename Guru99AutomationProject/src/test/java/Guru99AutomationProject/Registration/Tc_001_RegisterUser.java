package Guru99AutomationProject.Registration;

import java.io.File;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import Guru99AutomationProject.testbase.TestBase;
import uiActions.Registeruser;

public class Tc_001_RegisterUser extends TestBase {

	public static final Logger log = Logger.getLogger(Tc_001_RegisterUser.class.getName());
	public static String path = "C://Users//rohini.burde//workspace//Guru99AutomationProject//src//main//java//screenshots//Credentials.png";

	@BeforeTest
	public void setup() {

		//

		init();

		log.info("Opening browser & getting redirected to url");
	}

	@Test
	public void registr() throws Exception {

		Registeruser registr = PageFactory.initElements(dr, Registeruser.class);
		registr.registernew("test12@gmail.com");

		log.info("Entering Email id for registration" + registr.toString());

		dr.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		dr.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		File src = ((TakesScreenshot) dr).getScreenshotAs(OutputType.FILE);

		// now copy the screenshot to desired location using copyFile //method
		FileUtils.copyFile(src, new File(path));
				

	}
}