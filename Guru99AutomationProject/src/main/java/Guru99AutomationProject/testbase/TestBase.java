 package Guru99AutomationProject.testbase;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Guru99AutomationProject.excelreader.Excel_reader;

import org.apache.log4j.Logger;

public class TestBase {

	public static final Logger log = Logger.getLogger(TestBase.class.getName());

	// static(no need to create object) and final(value can't be changed)
	// TestBase.class.getName(): this will give the name of the class in the
	// logs

	// initialize global variables
	public WebDriver dr;

	//created reference of the excel_reader class
	Excel_reader excel;

	String url = "http://demo.guru99.com/v4/index.php";

	String browser = "firefox";

	// String browser = "chrome";
	
	//String browser = "IE";

	public void init() {

		selectBrowser(browser);// will goto select browser method create its
								// object and then executed that method.

		getURL(url); // will go to geturl method

		String logconfig = "log4j.properties";

		PropertyConfigurator.configure(logconfig);

	}

	// to open browser.
	public void selectBrowser(String browser) {

		if (browser.equalsIgnoreCase("firefox")) {

			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\Drivers\\geckodriver.exe");

			dr = new FirefoxDriver();

			log.info("Opening browser" +browser.getClass() );

		} else if (browser.equalsIgnoreCase("chrome")) {

			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "\\Drivers\\chromedriver.exe");

			dr = new ChromeDriver();

		} else if (browser.equalsIgnoreCase("IE")) {

			System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") + "\\Drivers\\IEDriverServer.exe");

			dr = new InternetExplorerDriver();

		}

	}

	// to get redirected to url requiured.
	public void getURL(String url) {

		dr.get(url);

		log.info("Navigate to url" + url);

		dr.manage().window().maximize();

		dr.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

	}
// to get data from the excel sheet.
	public String[][] getData(String excelName, String sheetName) {
		
		
		String path = System.getProperty("user.dir")
				+ "\\src\\main\\java\\Guru99AutomationProject\\data\\" + excelName;
		
		//created object of excel_reader class
		excel = new Excel_reader(path);
		
		String[][] data = excel.getDataFromSheet(sheetName, excelName);
		
		
		return data;
	}
	
	
	//method to implement wait if it takes time to locate the element.
	public void waitForElement(int timeOutInSeconds, WebElement element) {
		
		 WebDriverWait wait = new WebDriverWait(dr, timeOutInSeconds);
		
		 wait.until(ExpectedConditions.visibilityOf(element));
	}

}
