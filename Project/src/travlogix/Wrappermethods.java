package travlogix;
import java.awt.Desktop;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import javax.swing.plaf.synth.SynthStyle;
import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
//import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Listeners;
import atu.testng.reports.ATUReports;
import atu.testng.reports.listeners.ATUReportsListener;
import atu.testng.reports.listeners.ConfigurationListener;
import atu.testng.reports.listeners.MethodListener;
import atu.testng.reports.logging.LogAs;
import atu.testng.reports.utils.Utils;
import atu.testng.selenium.reports.CaptureScreen;
import atu.testng.selenium.reports.CaptureScreen.ScreenshotOf;
@Listeners({ ATUReportsListener.class, ConfigurationListener.class, MethodListener.class })
public class Wrappermethods {

	/*
	 * static {
	 * 
	 * System.setProperty("atu.reporter.config",
	 * "c:\\Users\\AshokPrabha\\Desktop\\Frameworkmarch26\\Project\\atu.properties"
	 * );
	 * 
	 * }
	 */
	static {
		//System.setProperty("atu.reporter.config", "C:\\ATUReports\\atu.properties");
		System.setProperty("atu.reporter.config", utility.Constant.ATUREPORTS);
		
	
		
	//ATUReports.add("Started", LogAs.INFO, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

		ATUReports.add("Started", LogAs.INFO, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		
		

		
	
		
	}

	// D:\\selenium jajars 2.46\\ATUReporter_Selenium_testNG_5.5 BETA + ATU
	// Recorder 2.1+javadoc+propfile\\atu.properties

	RemoteWebDriver driver;
	WebElement element;
	RemoteWebDriver driver1;
	WebElement wait;
	//HtmlUnitDriver driver3;
	// AndroidDriver driver1;
	int i = 1;
	static String store1; 
	public static String store2;
	
	
	public void launchbrowser(String brwsr, String URL)

	{
		if (brwsr.equalsIgnoreCase("chrome")) {
			
			ATUReports.setWebDriver(driver);
			ATUReports.indexPageDescription = "Information dynamic Project";
			ATUReports.setAuthorInfo("Automation", Utils.getCurrentTime(), "1.0");
			System.setProperty("webdriver.chrome.driver", utility.Constant.CHROMEDRIVEREXE);
			ATUReports.add("Chrome Browser is instantiated", LogAs.INFO, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				
			
				
			// C:\\chromedriver\\chromedriver1\\chromedriver.exe

			driver = new ChromeDriver();

/*			ATUReports.setWebDriver(driver);
			ATUReports.indexPageDescription = "Information dynamic Project";
			ATUReports.setAuthorInfo("Automation", Utils.getCurrentTime(), "1.0");
			ATUReports.add("Chromebrowser is instantiated", LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
*/
		}

		else if (brwsr.equalsIgnoreCase("ie")) {
			System.setProperty("webdriver.ie.driver", "C:\\IE driver\\IE64\\IEDriverServer.exe");
			// C:\\IE driver\\IE64\\IEDriverServer.exe

			driver = new InternetExplorerDriver();

			ATUReports.setWebDriver(driver);
			ATUReports.indexPageDescription = "FreeWheel MRM Project";
			ATUReports.setAuthorInfo("ID", Utils.getCurrentTime(), "1.0");
			ATUReports.add("InternetExplorer is instantiated", LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			
		}
		else if (brwsr.equalsIgnoreCase("headless"))
		{
			
		System.setProperty("webdriver.chrome.driver", utility.Constant.CHROMEDRIVEREXE);

			ChromeOptions options = new ChromeOptions();
			options.addArguments("--headless");
			options.addArguments("Window-size=1280,800");
		
			options.setHeadless(true);
			driver = new ChromeDriver(options);
			
			ATUReports.setWebDriver(driver);
			ATUReports.indexPageDescription = "Travlogix headless project";
			ATUReports.setAuthorInfo("ID", Utils.getCurrentTime(), "1.0");
			ATUReports.add("headless chrome browser is instantiated", LogAs.PASSED, 
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			} 
		else

		{
			driver = new FirefoxDriver();

			ATUReports.setWebDriver(driver);
			ATUReports.indexPageDescription = "ID Project";
			ATUReports.setAuthorInfo("ID", Utils.getCurrentTime(), "1.0");
			// ATUReports.setAuthorInfo(ID, arg1, arg2);

			ATUReports.add("Firefox Driver is instantiated", LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(URL);
		ATUReports.add("Browser launched and URL got triggered ", LogAs.PASSED,
				new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
	}

	public void enterbyxpath(String xpt, String data)

	{
		try {
			driver.findElementByXPath(xpt).clear();
			driver.findElementByXPath(xpt).sendKeys(data);
			

			// ATUReports.add("Enter the Data successfully", LogAs.PASSED, new
			// CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			ATUReports.add("Data Entered as " + data, LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

		} catch (NoSuchElementException e) {

			ATUReports.add("No element found", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
			ATUReports.add("No element found ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		} catch (WebDriverException e) {
			ATUReports.add("No driver found ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		} finally {
			takeSnap();
		}
	}

	public void clickbyxpath(String xpt1) {

		try {
			
			driver.findElementByXPath(xpt1).click();
			//ATUReports.add("Click by Xpath ", LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			//test.log(LogStatus.PASS, "Clicked by xpath");
		} catch (NoSuchElementException e) {

		//	ATUReports.add("No element found ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		} catch (WebDriverException e) {
			ATUReports.add("No driver found ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			//test.log(LogStatus.FAIL, "Not Clicked by xpath");
		} finally {
			takeSnap();
		}
	}

	public void clickbylinktext(String xpth, String lnk) throws InterruptedException

	{

		try {
			Actions Builder = new Actions(driver);

			Builder.moveToElement(driver.findElementByXPath(xpth)).build().perform();

			Thread.sleep(1000);
			ATUReports.add("Mouse moved over to the Manage ", LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			driver.findElementByLinkText(lnk).click();
			ATUReports.add("User clicked the " + lnk + "link", LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		} catch (NoSuchElementException e) {

			ATUReports.add("No element found ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		} catch (WebDriverException e) {
			ATUReports.add("No driver found ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		} finally {
			takeSnap();
		}
	}

	public void clickBylinktext(String lnk) {

		try {
			driver.findElementByLinkText(lnk).click();
			ATUReports.add("User clicked the " + lnk + "link", LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		} catch (NoSuchElementException e) {

			ATUReports.add("No element found ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		} catch (WebDriverException e) {
			ATUReports.add("No driver found ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		} finally {
			takeSnap();
		}

	}

	public void sendtextbyid(String id, String txt) {
		try {

			driver.findElementById(id).clear();
			driver.findElementById(id).sendKeys(txt);
		//	ATUReports.add(" User Entered the text as " + txt, LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			ATUReports.add(" User Entered the text as " + txt, LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			ATUReports.add(" User Entered the text as " + txt, LogAs.INFO,new CaptureScreen(ScreenshotOf.DESKTOP));

			
			//test.log(LogStatus.PASS, "User Entered the text");
		} catch (NoSuchElementException e) {

			//ATUReports.add("No element found ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		} catch (WebDriverException e) {
			//ATUReports.add("No driver found ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			ATUReports.add("No driver found ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			ATUReports.add(" ", LogAs.INFO, new CaptureScreen(ScreenshotOf.DESKTOP));
			
			//test.log(LogStatus.FAIL, "User not Entered the text");
			
		} finally {
			takeSnap();
		}
	}

	// ===========================

	public void sendtextbyidbyint(String id, int txt) {
		try {

			driver.findElementById(id).clear();
			driver.findElementById(id).sendKeys("txt");
			ATUReports.add(" User Entered the text as " + txt, LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		} catch (NoSuchElementException e) {

			ATUReports.add("No element found ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		} catch (WebDriverException e) {
			ATUReports.add("No driver found ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		} finally {
			takeSnap();
		}
	}
	// =========================================================

	public void sendtextbyxvalue(String xva, String txt) {
		try {
			driver.findElementByXPath(xva).clear();
			driver.findElementByXPath(xva).sendKeys(txt);

			ATUReports.add(" User Entered the text as " + txt, LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		} catch (NoSuchElementException e) {

			ATUReports.add("No element found ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		} catch (WebDriverException e) {
			ATUReports.add("No driver found ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		} finally {
			takeSnap();
		}
	}
	
	//=======================================================================
	public void sendtextbyxvalueintt(String xva, String txt) {
		try {
			driver.findElementByXPath(xva).clear();
			driver.findElementByXPath(xva).sendKeys(""+5);

			ATUReports.add(" User Entered the text as " + txt, LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		} catch (NoSuchElementException e) {

			ATUReports.add("No element found ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		} catch (WebDriverException e) {
			ATUReports.add("No driver found ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		} finally {
			takeSnap();
		}
	}
	

	// =====================================================================

	public void sendtextbycssselecotr(String xva, String txt) {
		try {
			driver.findElementByCssSelector(xva).clear();

			driver.findElementByCssSelector(xva).sendKeys(txt);
			// driver.findElementByCssSelector(xva).sendKeys(txt);

			ATUReports.add(" User Entered the text as " + txt, LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		} catch (NoSuchElementException e) {

			ATUReports.add("No element found ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		} catch (WebDriverException e) {
			//ATUReports.add("No driver found ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		} finally {
			takeSnap();
		}
	}

	// ================================================================

	// Enter the interger values using xpath :

	public void sendintvalueusingxvalue(String xva, String txt) {
		try {
			int i = 10;
			driver.findElementByXPath(xva).clear();
			driver.findElementByXPath(xva).sendKeys(txt.valueOf(i));
			ATUReports.add(" User Entered the text as " + txt, LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		} catch (NoSuchElementException e) {

			ATUReports.add("No element found ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		} catch (WebDriverException e) {
			ATUReports.add("No driver found ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		} finally {
			takeSnap();
		}
	}

	//======================================================================
	
	
	public void sendintvaluebyxpath(String xpath, String txt) {
		try {

			//int i = 10;
			
			String strTest = "txt";
		    int iTest = Integer.parseInt(strTest);
		 
		    
			driver.findElementByXPath(xpath).clear();
			driver.findElementByXPath(xpath).sendKeys("iTest");
			
			//driver.findElementByXPath(xpath).sendKeys(txt.valueOf(i));

			ATUReports.add(" User Entered the text as " + txt, LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		} catch (NoSuchElementException e) {

			ATUReports.add("No element found ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		} catch (WebDriverException e) {
			ATUReports.add("No driver found ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		} finally {
			takeSnap();
		}
	}
	
	//=========================================================================
	// Enter the integer values using ID ..

	// Enter the interger values using xpath :

	public void sendintvaluebyid(String id, String txt) {
		try {

			int i = 10;
			driver.findElementById(id).clear();
			driver.findElementById(id).sendKeys(txt.valueOf(i));

			ATUReports.add(" User Entered the text as " + txt, LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		} catch (NoSuchElementException e) {

			ATUReports.add("No element found ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		} catch (WebDriverException e) {
			ATUReports.add("No driver found ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		} finally {
			takeSnap();
		}
	}

	// ======================================================
	
	
	// sending int value in the xvalue for AR matching and unmatching screen 

		public void sendintbyhcxvaluee(String xva) {
			try {
				//driver.findElementByXPath(xva).clear();
				driver.findElementByXPath(xva).sendKeys(Integer.toString(5));

				// driver.findElement(By.id("accountInputBox_input")).sendKeys(Integer.toString(vCustAccNum));

				ATUReports.add(" User Entered the text as ", LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			} catch (NoSuchElementException e) {

				ATUReports.add("No element found ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			} catch (WebDriverException e) {
				ATUReports.add("No driver found ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			} finally {
				takeSnap();
			}
		}

		
		
		
		//================================================
		
		//Claer the values 
		
		public void Clearbyxpath(String xpt1) {

			try {
				
				driver.findElementByXPath(xpt1).clear();
				ATUReports.add("Network link got clicked ", LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			} catch (NoSuchElementException e) {

			ATUReports.add("No element found ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			} catch (WebDriverException e) {
				ATUReports.add("Element not cleared", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			} finally {
				takeSnap();
			}
		}

	
	
	
	//============================================================
	// sending int value in the xvalue

	public void sendintbyhcxvalue(String xva) {
		try {
			//driver.findElementByXPath(xva).clear();
			driver.findElementByXPath(xva).sendKeys(Integer.toString(100));

			// driver.findElement(By.id("accountInputBox_input")).sendKeys(Integer.toString(vCustAccNum));

			ATUReports.add(" User Entered the text as ", LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		} catch (NoSuchElementException e) {

			ATUReports.add("No element found ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		} catch (WebDriverException e) {
			ATUReports.add("No driver found ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		} finally {
			takeSnap();
		}
	}

	// ===============================================================

	public void selectbyvalueid(String idvalue, String text) throws InterruptedException {
		try {
			Select dropdown = new Select(driver.findElementById(idvalue));
			ATUReports.add(" List Values are loaded in to Dropdown ", LogAs.PASSED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			Thread.sleep(3000);
			dropdown.selectByVisibleText(text);
			ATUReports.add(" user selected the Rating ", LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		} catch (NoSuchElementException e) {

			ATUReports.add("No element found ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		} catch (WebDriverException e) {
			ATUReports.add("No driver found ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		} finally {
			takeSnap();
		}
	}

	public void selectbyValuexp(String xpvalue, String text) throws InterruptedException {
		try {
			Thread.sleep(2000);
			Select dropdown = new Select(driver.findElementByXPath(xpvalue));
			ATUReports.add(" List Values are loaded in to Dropdown ", LogAs.PASSED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			Thread.sleep(2000);
			dropdown.selectByVisibleText(text);
			Thread.sleep(2000);
			// dropdown.selectByIndex(1);
			ATUReports.add(" user selected the Rating ", LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		} catch (NoSuchElementException e) {

			ATUReports.add("No element found ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		} catch (WebDriverException e) {
			System.out.print("Error message" + e);
			ATUReports.add("No driver found ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		} finally {
			takeSnap();
		}
	}

	// ===================================================================================

	// Selecting the Kendo UI Drop down...

	public void selectbykendoUI(String xpvalue, int text) throws InterruptedException {
		try {
			Thread.sleep(2000);
			Select dropdown1 = new Select(driver.findElementByXPath(xpvalue));

			dropdown1.selectByIndex(text);

			String xpath1 = driver.findElementByXPath(xpvalue).getText();

			Select dropdown = new Select(driver.findElementByXPath(xpvalue));

			System.out.println("xpath1 value is" + xpath1);

			ATUReports.add(" List Values are loaded in to Dropdown ", LogAs.PASSED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			Thread.sleep(2000);

			// dropdown.selectByVisibleText(text);

			Thread.sleep(2000);
			// dropdown.selectByIndex(1);
			ATUReports.add(" user selected the Rating ", LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		} catch (NoSuchElementException e) {

			ATUReports.add("No element found ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		} catch (WebDriverException e) {
			ATUReports.add("No driver found ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		} finally {
			takeSnap();
		}
	}

	// ==============

	public void selectbyindexvalue(String id, int text) throws InterruptedException {
		try {
			Select dropdown = new Select(driver.findElementById(id));

			ATUReports.add(" List Values are loaded in to Dropdown ", LogAs.PASSED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			Thread.sleep(1000);
			// dropdown.selectByVisibleText(text);
			dropdown.selectByIndex(text);
			ATUReports.add(" user selected the Rating ", LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		} catch (NoSuchElementException e) {

			ATUReports.add("No element found ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		} catch (WebDriverException e) {
			ATUReports.add("No driver found ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		} finally {
			takeSnap();
		}
	}

	// =============================================================

	// select index value using Xpath

	public void selectbyindexvaluexpath(String xpath, int text) throws InterruptedException {
		try {
			Select dropdown = new Select(driver.findElementByXPath(xpath));

			ATUReports.add(" List Values are loaded in to Dropdown ", LogAs.PASSED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			Thread.sleep(1000);
			// dropdown.selectByVisibleText(text);
			dropdown.selectByIndex(text);
			ATUReports.add(" user selected the Rating ", LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		} catch (NoSuchElementException e) {

			ATUReports.add("index value not found", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		} catch (WebDriverException e) {
			ATUReports.add("index value not found ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		} finally {
			takeSnap();
		}
	}

	// ==============

	// verified actual element is presented ....

	public void elementfindedbyid(String id) throws InterruptedException {
		try {
			driver.findElementById(id);
			ATUReports.add(" Element finded by id value ", LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			Thread.sleep(1000);
		} catch (NoSuchElementException e) {

			ATUReports.add("Element not finded by id value ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		} catch (WebDriverException e) {
			ATUReports.add("Element not finded by id value ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		} finally {
			takeSnap();
		}
	}

	// element find by xpath :

	public void elementfindedbyxpath(String xpath1) throws InterruptedException {
		try {
			driver.findElementByXPath(xpath1);
			ATUReports.add(" Element finded by xpath ", LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			Thread.sleep(1000);
		} catch (NoSuchElementException e) {

			ATUReports.add("Element not finded by xpath ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		} catch (WebDriverException e) {
			ATUReports.add("Element not finded by xpath", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		} finally {
			takeSnap();
		}
	}

	/// Element finded by name :

	public void elementfindedbyname(String name1) throws InterruptedException {
		try {
			driver.findElementByName(name1);
			ATUReports.add(" Element finded by name  ", LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			Thread.sleep(1000);
		} catch (NoSuchElementException e) {

			ATUReports.add("Element not finded by name  ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		} catch (WebDriverException e) {
			ATUReports.add("Element not finded by name ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		} finally {
			takeSnap();
		}
	}

	public void elementfindedlinktext(String linkname) throws InterruptedException {
		try {
			driver.findElementByLinkText(linkname);
			ATUReports.add(" Element finded by linkname  ", LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			Thread.sleep(1000);
		} catch (NoSuchElementException e) {

			ATUReports.add("Element not finded by linkname  ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		} catch (WebDriverException e) {
			ATUReports.add("Element not finded by linkname ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		} finally {
			takeSnap();
		}
	}

	// Entering the spacebar by id
	// enter the Space bar in the key board...

	public void spacebar(String id) {
		try {

			// driver.findElementById(id).sendKeys(Keys.TAB);
			driver.findElementById(id).sendKeys(Keys.SPACE);

			// Keys.TAB();

			// driver.findElementById(id).sendKeys(Keys.);

			ATUReports.add("keyboard space  Action Done", LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		}

		catch (WebDriverException e) {
			ATUReports.add("Keyboard space Action  not Done ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		} finally {
			takeSnap();
		}
	}

	// =====================================================================space
	// bar by xpath
//======================================
	
//clicking the keyboard tab button
	
	public void alert() throws InterruptedException {
		try 
		{

	
            Alert alert1 = driver.switchTo().alert();
		     Thread.sleep(900);
            String text = alert1.getText();
            Thread.sleep(900);
			
			alert1.accept();	  

			
			ATUReports.add("keyboard tab  Action Done", LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		}

		catch (WebDriverException e) {
			ATUReports.add("Keyboard tab Action  not Done ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		} finally {
			takeSnap();
		}
	}
	
	//==================================================================================
	public void spacebarbyxapth(String xpath) {
		try {

			// driver.findElementById(id).sendKeys(Keys.TAB);
			// driver.findElementById(xpath).sendKeys(Keys.SPACE);
			driver.findElementByXPath(xpath).sendKeys(Keys.SPACE);

			// driver.findElementById(id).sendKeys(Keys.);

			ATUReports.add("keyboard space  Action Done", LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		}

		catch (WebDriverException e) {
			ATUReports.add("Keyboard space Action  not Done ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		} finally {
			takeSnap();
		}
	}

	// =============

	public void selectbyvalue(String id, String text) throws InterruptedException {
		try {
			Select dropdown = new Select(driver.findElementById(id));

			ATUReports.add(" List Values are loaded in to Dropdown ", LogAs.PASSED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			Thread.sleep(1000);
			dropdown.selectByVisibleText(text);
			ATUReports.add(" user selected the Rating ", LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		} catch (NoSuchElementException e) {

			ATUReports.add("No element found ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		} catch (WebDriverException e) {
			ATUReports.add("No driver found ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		} finally {
			takeSnap();
		}
	}

	// ==============================================

	public void selectbycssselectorvalue(String id, String text) throws InterruptedException {
		try {
			// Select dropdown = new Select(driver.findElementById(id));
			Select dropdown = new Select(driver.findElementByCssSelector(id));

			ATUReports.add(" List Values are loaded in to Dropdown ", LogAs.PASSED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			Thread.sleep(1000);
			dropdown.selectByVisibleText(text);
			ATUReports.add(" user selected the Rating ", LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		} catch (NoSuchElementException e) {

			ATUReports.add("No element found ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		} catch (WebDriverException e) {
			ATUReports.add("No driver found ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		} finally {
			takeSnap();
		}
	}

	// ==============================

	public void clickbyclassname(String name)

	{
		try {
			driver.findElementByClassName(name).click();
			ATUReports.add("User clicked the Submit Button", LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		} catch (NoSuchElementException e) {

			ATUReports.add("No element found ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		} catch (WebDriverException e) {
			ATUReports.add("No driver found ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		} finally {
			takeSnap();
		}
	}

	public void clickbyid(String id)

	{
		try {
			driver.findElementById(id).click();
			ATUReports.add("User clicked the Submit Button", LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		} catch (NoSuchElementException e) {

			ATUReports.add("No element found ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		} catch (WebDriverException e) {
			//ATUReports.add("No driver found ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		} finally {
			takeSnap();
		}
	}

	public void clickbyname(String name) {
		try {
			driver.findElementByName(name).click();

			ATUReports.add("User clicked the Submit Button", LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		} catch (NoSuchElementException e) {

			ATUReports.add("No element found ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		} catch (WebDriverException e) {
			ATUReports.add("No driver found ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		} finally {
			takeSnap();
		}
	}

	public void close()

	{
		ATUReports.add("Browser got closed", LogAs.INFO, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		driver.close();

		

	}
	
	//======================
	
	public void quit()
	{
		driver.quit();
	}
	
	//=========================

	
	//windows handling by keyboard
	//=========================================================================================


	public void windwshandling1()

	{
		//driver.findElement(By.xpath(xpath1).click(); // click some link that opens a new window

		for (String winHandle : driver.getWindowHandles()) 
		{
		    driver.switchTo().window(winHandle); // switch focus of WebDriver to the next found window handle (that's your newly opened window)
		}


	}

				//===========================================================================

	
	//=========================================
	//driver switch to frame
	

	public void switchtoframeandentervaluexpath(int i)

	{
		driver.switchTo().frame(i);
		

	}
	
	//========================================
	
	// Retrive the frame numbers using the xpath
	
	public void switchtoframeandentervaluexpath(String xpath1)

	{
	driver.switchTo().frame(driver.findElement(By.xpath(xpath1)));
	
}
	
	
	//=====================================

	
	//==================================================
	//
	public void takeSnap() {

		try {
			File src = driver.getScreenshotAs(OutputType.FILE);
			//FileUtils.copyFile(src, new File("C:\\project1" + "\\O_" + i + ".png"));
			FileUtils.copyFile(src, new File("C:\\project1" + "\\O_" + i + ".png"));
				
		} catch (IOException e) {
			System.out.println("Snapshot could not be taken");
		}
		i++;

	}

	public static String[][] getSheet(String fileName, String sheetname) throws IOException {

		String[][] data = null;

		try {
			
			FileInputStream fis = new FileInputStream(new File("C://Travlogix//Excel//" + fileName + ".xlsx"));

			
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			XSSFSheet sheet = workbook.getSheet(sheetname);

			// get the number of rows
			int rowCount = sheet.getLastRowNum();

			// get the number of columns
			int columnCount = sheet.getRow(0).getLastCellNum();
			data = new String[rowCount][columnCount];

			// loop through the rows
			for (int i = 1; i < rowCount + 1; i++) {
				try {
					XSSFRow row = sheet.getRow(i);
					for (int j = 0; j < columnCount; j++) { // loop through the
															// columns
						try {
							String cellValue = "";
							try {
								if (cellValue != null) {
									cellValue = row.getCell(j).getStringCellValue();
								}
							} catch (NullPointerException e) {

							}

							data[i - 1][j] = cellValue; // add to the data array
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}

				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				fis.close();

				// workbook.close();

			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return data;

	}

	public void Enterbyid(String id) {

		driver.findElementById(id).sendKeys(Keys.ENTER);

	}

	// Clicking the tab by id ..

	public void stab(String id) {
		try {

			driver.findElementById(id).sendKeys(Keys.TAB);

			ATUReports.add("TAb Action Done", LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		}

		catch (WebDriverException e) {
			ATUReports.add("Tab Action not Done ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		} finally {
			takeSnap();
		}
	}

	// Enter by xpath

	// Clicking the tab by id ..

	public void stabbyxpath(String xpath) {
		try {

			// driver.findElementById(id).sendKeys(Keys.TAB);

			driver.findElementByXPath(xpath).sendKeys(Keys.TAB);

			ATUReports.add("TAb Action Done", LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		}

		catch (WebDriverException e) {
			//ATUReports.add("Tab Action not Done ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		} finally {
			takeSnap();
		}
	}

	// entr by xpath

	public void Enterr() {
		try {
			element.sendKeys(Keys.ENTER);

			ATUReports.add("Enter Action Done", LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		} catch (WebDriverException e) {
			ATUReports.add("Enter Action not Done ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		} finally {
			takeSnap();
		}
	}
	
	//================================
	
	//Clicking the ECS button in the keyboard 
	
	public void Ecs() {
		try {
			element.sendKeys(Keys.ESCAPE);

			ATUReports.add("Enter Action Done", LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		} catch (WebDriverException e) {
			ATUReports.add("Enter Action not Done ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		} finally {
			takeSnap();
		}
	}

	

	//================================================================
	
	// ===Click by CSS

	public void clickbycssselector(String xpt1) {

		try {

			driver.findElementByCssSelector(xpt1).click();

			ATUReports.add("CSSselector  got clicked ", LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		} catch (NoSuchElementException e) {

			ATUReports.add("No element found ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		} catch (WebDriverException e) {
			ATUReports.add("No driver found ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		} finally {
			takeSnap();
		}
	}

	// =================================================
	
	public void findbyelementbyxpathandclick(String xpath) 
	{

		try {

			if (driver.findElementByXPath(xpath).isDisplayed())

			{
				driver.findElementByXPath(xpath).click();
			
			
			ATUReports.add("Element found ", LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			}
			
			else
			{
			//	ATUReports.add("No element found ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			}

			// ATUReports.add("ID element got clicked ", LogAs.PASSED, new
			// CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		} catch (NoSuchElementException e) {

			//ATUReports.add("No element found ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		} 
		finally {
			takeSnap();
		}
	}

	//=====================================================
	// Element finder by ID

	public void findbyelementbyid(String id) 
	{

		try {

			if (driver.findElementById(id).isDisplayed())

				driver.findElementById(id);
			

			// ATUReports.add("ID element got clicked ", LogAs.PASSED, new
			// CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		} catch (NoSuchElementException e) {

			ATUReports.add("No element found ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		} catch (WebDriverException e) {
			ATUReports.add("No driver found ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		} finally {
			takeSnap();
		}
	}

	// Element find by xpath

	// public void findElementByXPath(String xpath) {
	/*
	 * public boolean findElementByXPath(String xpath) {
	 * 
	 * try {
	 * 
	 * if (driver.findElementByXPath(xpath).isDisplayed())
	 * 
	 * 
	 * { return true; driver.findElementByXPath(xpath); }
	 * 
	 * else { return false;
	 * 
	 * } //ATUReports.add("Xpath element got clicked ", LogAs.PASSED, new
	 * CaptureScreen(ScreenshotOf.BROWSER_PAGE));
	 * 
	 * }catch (NoSuchElementException e) {
	 * 
	 * ATUReports.add("No element found ", LogAs.FAILED, new
	 * CaptureScreen(ScreenshotOf.BROWSER_PAGE)); } catch (WebDriverException e) {
	 * ATUReports.add("No driver found ", LogAs.FAILED, new
	 * CaptureScreen(ScreenshotOf.BROWSER_PAGE)); } }finally { takeSnap(); } }
	 */

	// System sleep time

	public void sleep() throws Exception {
		try {
			Thread.sleep(4000);
			// ATUReports.add("waiting sleep time", LogAs.PASSED, new
			// CaptureScreen(ScreenshotOf.BROWSER_PAGE));

		} catch (WebDriverException e) {
			// ATUReports.add("waiting sleep time failed", LogAs.FAILED, new
			// CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		}
	}

	// public void How to iterate a list of WebElements

	/*
	 * public void iterativewebelementsbyindex(String id,String count) throws
	 * Exception { try {
	 * 
	 * driver.findElement(by) ATUReports.add("waiting sleep time", LogAs.PASSED,
	 * new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
	 * 
	 * } catch (WebDriverException e) { ATUReports.add(
	 * "waiting sleep time failed", LogAs.FAILED, new
	 * CaptureScreen(ScreenshotOf.BROWSER_PAGE)); } }
	 */
	// driver Close

	// Gettext

	public void gettext(String xpath) throws Exception {
		try {
			Thread.sleep(2000);
			String jobid = driver.findElementByXPath("xpath").getText();

			ATUReports.add("capture the  message as" + jobid + "xpath", LogAs.PASSED,
					new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

		} catch (WebDriverException e) {
			ATUReports.add("user unable to capture the message", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		}
	}

	// ==================================================

	// compariosn the icon and print the statement

	public void gettextimageprinttext(String xpath) throws Exception {
		try {
			Thread.sleep(3000);

			if (driver.findElementByXPath(xpath).isDisplayed()) {

				// driver.findElementByXPath(xpath).click();
				ATUReports.add("Error message" + "Passenger Age mismatch issue" + "", LogAs.PASSED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			} else {
				ATUReports.add("Error message" + "No Error message  displayed" + "", LogAs.PASSED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			}
		} catch (NoSuchElementException e) {

			ATUReports.add("No element found ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		} catch (WebDriverException e) {
			ATUReports.add("No driver found ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		} finally {
			takeSnap();
		}
	}

	// =======================================================
	// Swich to iframe

	public void switchiframe0() throws Exception {
		try {
			Thread.sleep(1000);

			int size = driver.findElements(By.tagName("iframe")).size();
			Thread.sleep(1000);
			driver.switchTo().frame(0);
			Thread.sleep(1000);

			ATUReports.add("switch to iframe" + "" + "xpath", LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

		} catch (WebDriverException e) {
			ATUReports.add("user unable switch to iframe", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		}
	}

	// ==========================================================================
	// xpathmultiple condition checker

	public void Multipleconditionchecker(String xpath, String xpath1, String xpath2, String xpath3, String xpath4,
			String xpath5, String xpath6, String xpath7, String xpath8, String xpath9) throws Exception {

		try {

			Thread.sleep(3000);

			// if (driver.findElementById(id).isDisplayed())

			if (driver.findElementByXPath(xpath).isDisplayed()) {

				driver.findElementByXPath(xpath).click();
			}

			else if (driver.findElementByXPath(xpath1).isDisplayed())

			{

				driver.findElementByXPath(xpath1).click();

			} else if (driver.findElementByXPath(xpath2).isDisplayed()) {
				driver.findElementByXPath(xpath2).click();
			} else if (driver.findElementByXPath(xpath3).isDisplayed()) {
				driver.findElementByXPath(xpath3).click();
			} else if (driver.findElementByXPath(xpath4).isDisplayed()) {
				driver.findElementByXPath(xpath4).click();
			} else if (driver.findElementByXPath(xpath5).isDisplayed()) {
				driver.findElementByXPath(xpath5).click();
			} else if (driver.findElementByXPath(xpath6).isDisplayed()) {
				driver.findElementByXPath(xpath6).click();
			} else if (driver.findElementByXPath(xpath7).isDisplayed()) {
				driver.findElementByXPath(xpath7).click();
			} else if (driver.findElementByXPath(xpath8).isDisplayed()) {
				driver.findElementByXPath(xpath8).click();
			} else {
				driver.findElementByXPath(xpath9).click();
			}

			// ATUReports.add("xpath element got clicked ", LogAs.PASSED, new
			// CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		} catch (NoSuchElementException e) {

			ATUReports.add("No element found ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		} catch (WebDriverException e) {
			ATUReports.add("No driver found ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		} finally {
			takeSnap();
		}
	}

	// Scroll donw by xpath
	public void scrolldownbyxpath(String xpath) {
		try {
			// int y = driver.findElementById(id).getLocation().getY();
			int y = driver.findElementByXPath(xpath).getLocation().getY();

			((JavascriptExecutor) driver).executeScript("window.scrollBy(0," + y + ");");

			// ATUReports.add("User scroll down the page ", LogAs.PASSED, new
			// CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		} catch (NoSuchElementException e) {

			ATUReports.add("No element found ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		} catch (WebDriverException e) {
			ATUReports.add("No driver found ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		} finally {
			takeSnap();
		}

	}

	// =================================

	// Scroll up

	public void scrollupbyxpath(String xpath) {
		try {
			// int y = driver.findElementById(id).getLocation().getY();
			int y = driver.findElementByXPath(xpath).getLocation().getY();

			// ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,"
			// + y + ");");

			((JavascriptExecutor) driver).executeScript("window.scrollBy(y," + 0 + ");");

			// ATUReports.add("User scroll down the page ", LogAs.PASSED, new
			// CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		} catch (NoSuchElementException e) {

			ATUReports.add("No element found ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		} catch (WebDriverException e) {
			ATUReports.add("No driver found ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		} finally {
			takeSnap();
		}

	}

	// ======================================================

	// keyboard arrow down

	public void keyboardarrowdown(String xpath) throws InterruptedException {
		try {
			driver.findElementByXPath(xpath).sendKeys(Keys.ARROW_DOWN);
			Thread.sleep(200);
			driver.findElementByXPath(xpath).sendKeys(Keys.ARROW_DOWN);
			Thread.sleep(200);

			driver.findElementByXPath(xpath).sendKeys(Keys.ARROW_DOWN);

			ATUReports.add("User scroll down the page ", LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		} catch (NoSuchElementException e) {

			ATUReports.add("No element found ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		} catch (WebDriverException e) {
			ATUReports.add("No driver found ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		} finally {
			takeSnap();
		}

	}

	
	//================================================== ===============
	
	
	public void keyboardenter(String xpath) throws InterruptedException {
		try {
			driver.findElementByXPath(xpath).sendKeys(Keys.ENTER);
			Thread.sleep(200);
			
			//ATUReports.add("User scroll down the page ", LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		} catch (NoSuchElementException e) {

//			ATUReports.add("No element found ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		} catch (WebDriverException e) {
	//		ATUReports.add("No driver found ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		} finally {
			takeSnap();
		}

	}
	
	
	// ===========================================================

	// keyboard arrow donw for one time

	public void keyboardarrowdownonetime(String xpath) throws InterruptedException {
		try {
			driver.findElementByXPath(xpath).sendKeys(Keys.ARROW_DOWN);
			Thread.sleep(200);
			// driver.findElementByXPath(xpath).sendKeys(Keys.ARROW_DOWN);
			Thread.sleep(200);

			// driver.findElementByXPath(xpath).sendKeys(Keys.ARROW_DOWN);

			//ATUReports.add("User scroll down the page ", LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		} catch (NoSuchElementException e) {

			//ATUReports.add("No element found ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		} catch (WebDriverException e) {
			//ATUReports.add("No driver found ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		} finally {
			takeSnap();
		}

	}

	// ================================================================================

	// keyboard arrow up

	public void keyboardarrowup(String xpath) throws InterruptedException {
		try {
			driver.findElementByXPath(xpath).sendKeys(Keys.ARROW_UP);
			Thread.sleep(200);
			driver.findElementByXPath(xpath).sendKeys(Keys.ARROW_UP);
			Thread.sleep(200);

			driver.findElementByXPath(xpath).sendKeys(Keys.ARROW_UP);

			ATUReports.add("User scroll down the page ", LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		} catch (NoSuchElementException e) {

			ATUReports.add("No element found ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		} catch (WebDriverException e) {
			ATUReports.add("No driver found ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		} finally {
			takeSnap();
		}

	}

	// ================================================================================
	// Keyboar drop down by id

	public void keyboardarrowdownbyid(String id) throws InterruptedException {
		try {
			// driver.findElementById(using)
			driver.findElementById(id).sendKeys(Keys.ARROW_DOWN);
			Thread.sleep(200);
			driver.findElementById(id).sendKeys(Keys.ARROW_DOWN);
			Thread.sleep(200);

			driver.findElementById(id).sendKeys(Keys.ARROW_DOWN);

			ATUReports.add("User scroll down the page ", LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		} catch (NoSuchElementException e) {

			ATUReports.add("No element found ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		} catch (WebDriverException e) {
			ATUReports.add("No driver found ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		} finally {
			takeSnap();
		}

	}

	
	//

	
	//enter letters by keyboard
	
//========================================================
	public void Enterlettersbykeyboardd(String value) 
	{

		/*Actions builder = new Actions(driver);        
		builder.sendKeys(Keys.ENTER);
		*/
		
		
		element = driver.findElement(By.id("q"));
		
		element.sendKeys(value);
		
		
		}
	
	//===============================================
	
	//
	
	
	public void Enterbykeyboard() 
	{

		/*Actions builder = new Actions(driver);        
		builder.sendKeys(Keys.ENTER);
		*/
		
		
		element = driver.findElement(By.id("q"));
		
		element.sendKeys(Keys.ENTER);
		element.sendKeys(Keys.RETURN);

		
		}
	
	
//ENTER LETTERS BY KEYBOARD
	
	public void Enterlettersbykeyboard() 
	{

		/*Actions builder = new Actions(driver);        
		builder.sendKeys(Keys.ENTER);
		*/
		
		
		element = driver.findElement(By.id("q"));
		
		element.sendKeys(Keys.NUMPAD3);
		element.sendKeys(Keys.NUMPAD3);
		element.sendKeys(Keys.NUMPAD3);
		element.sendKeys(Keys.NUMPAD3);
		element.sendKeys(Keys.NUMPAD3);
		element.sendKeys(Keys.NUMPAD3);
			
		
		}
	

	
	//
	
	// =============================================================

	// Enter by xpath

	public void Enterbyxpath(String xpath) {

		// driver.findel(xpath).sendKeys(Keys.ENTER);
		driver.findElementByXPath(xpath).sendKeys(Keys.ENTER);

	}

	// ================================================================================

	// List elements :

	public void Listelementclick(String xpath1, int count1) throws Exception {

		try {

			Thread.sleep(3000);

			/*
			 * //String gettext1 = driver.findElementByXPath(xpath1).getText();
			 * List <Webelement> Li =
			 * WebElement.findElements(By.xpath("xpath1"));
			 * Li.get("count1").click();
			 */

			// ATUReports.add("xpath element got clicked ", LogAs.PASSED, new
			// CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		} catch (NoSuchElementException e) {

			// ATUReports.add("No element found ", LogAs.FAILED, new
			// CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		} catch (WebDriverException e) {
			// ATUReports.add("No driver found ", LogAs.FAILED, new
			// CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		} finally {
			takeSnap();
		}
	}

	// List elelkmtne endf

	// ======================================================================
	// Multiconditon checked 1

	// ==================================================================================================================

	public void Multipleconditionchecker1(String xpath, String id) throws Exception {

		try {

			Thread.sleep(3000);

			if (driver.findElementByXPath(xpath).isEnabled()) {

				driver.findElementByXPath(xpath).click();
			}

			else if (driver.findElementById(id).isDisplayed())

			{

				driver.findElementById(id).click();

			}

			else {
				driver.findElementById(id).click();
			}

			ATUReports.add("xpath element got clicked ", LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		} catch (NoSuchElementException e) {

			ATUReports.add("No element found ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		} catch (WebDriverException e) {
			ATUReports.add("No driver found ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		} finally {
			takeSnap();
		}
	}

	// =========================================================================================

	// Servic charge comparions

	public void Servicechargecomparision(String xpath, String id) throws Exception {

		try {

			Thread.sleep(3000);

			//String gettext1 = driver.findElementByXPath(xpath).getText();
			String gettext1 = driver.findElementByXPath(xpath).getAttribute("value");
			String gettext2 = id.toString();

			// if (driver.findElementByXPath(xpath).isEnabled())
			if (gettext1.contentEquals(gettext2))
			// if(gettext1.contains(gettext2))
			{
				// ATUReports.add("Service charge matches ", LogAs.PASSED, new
				// CaptureScreen(ScreenshotOf.BROWSER_PAGE));

				ATUReports.add("value not mathces" + gettext1 + "", LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			} else 
			{
				ATUReports.add("value mathces" + gettext1 + "", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			}

			// ATUReports.add("xpath element got clicked ", LogAs.PASSED, new
			// CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		} catch (NoSuchElementException e) {

			// ATUReports.add("No element found ", LogAs.FAILED, new
			// CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		} catch (WebDriverException e) {
			// ATUReports.add("No driver found ", LogAs.FAILED, new
			// CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		} finally {
			takeSnap();
		}
	}

	// ====================================================================================================================

	// Service charge comparisons

	public void Servicechargecomparisionchild(String xpath, String id) throws Exception {

		try {

			Thread.sleep(3000);

			String gettext1 = driver.findElementByXPath(xpath).getText();
			String gettext2 = id.toString();

			// if (driver.findElementByXPath(xpath).isEnabled())
			//if (gettext1.contentEquals(gettext2))
			 if(gettext1.contains(gettext2))
			{
				

				ATUReports.add("Service charge matches for child" + gettext1 + "", LogAs.PASSED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			} else {
				ATUReports.add("Service charge not matches for child" + gettext1 + "", LogAs.FAILED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			}

			// ATUReports.add("xpath element got clicked ", LogAs.PASSED, new
			// CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		} catch (NoSuchElementException e) {

			// ATUReports.add("No element found ", LogAs.FAILED, new
			// CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		} catch (WebDriverException e) {
			// ATUReports.add("No driver found ", LogAs.FAILED, new
			// CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		} finally {
			takeSnap();
		}
	}
	// ===============================================================================================================
	// Discount comparisions done

	public void Discountcomparision(String xpath, String id) throws Exception {

		try {

			Thread.sleep(3000);

			String gettext1 = driver.findElementByXPath(xpath).getText();
			String gettext2 = id.toString();

			// if (driver.findElementByXPath(xpath).isEnabled())
			if (gettext1.contentEquals(gettext2))
			// if(gettext1.contains(gettext2))
			{
				// ATUReports.add("Service charge matches ", LogAs.PASSED, new
				// CaptureScreen(ScreenshotOf.BROWSER_PAGE));

				ATUReports.add("Dicount amount reflected correctly" + gettext1 + "", LogAs.PASSED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			} else {
				ATUReports.add("Dicount amount not reflected correctly" + gettext1 + "", LogAs.FAILED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			}

			// ATUReports.add("xpath element got clicked ", LogAs.PASSED, new
			// CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		} catch (NoSuchElementException e) {

			// ATUReports.add("No element found ", LogAs.FAILED, new
			// CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		} catch (WebDriverException e) {
			// ATUReports.add("No driver found ", LogAs.FAILED, new
			// CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		} finally {
			takeSnap();
		}
	}

	// =================================================================================

	public void Couponcodecomparision(String xpath, String id) throws Exception {

		try {

			Thread.sleep(3000);

			String gettext1 = driver.findElementByXPath(xpath).getText();
			String gettext2 = id.toString();

			// if (driver.findElementByXPath(xpath).isEnabled())
			if (gettext1.contentEquals(gettext2))
			// if(gettext1.contains(gettext2))
			{
				// ATUReports.add("Service charge matches ", LogAs.PASSED, new
				// CaptureScreen(ScreenshotOf.BROWSER_PAGE));

				ATUReports.add("Coupon code reflected successfully" + gettext1 + "", LogAs.PASSED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			} else {
				ATUReports.add("Coupon code not reflected" + gettext1 + "", LogAs.FAILED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			}

			// ATUReports.add("xpath element got clicked ", LogAs.PASSED, new
			// CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		} catch (NoSuchElementException e) {

			// ATUReports.add("No element found ", LogAs.FAILED, new
			// CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		} catch (WebDriverException e) {
			// ATUReports.add("No driver found ", LogAs.FAILED, new
			// CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		} finally {
			takeSnap();
		}
	}

	// ======================================================================================

	// ========================================================================================
	// Service charge percenatge

	public void Servicechargepercecomparison(String basefare, String excelser, String appservicec) throws Exception {

		try {

			Thread.sleep(3000);

			String gettext1 = driver.findElementByXPath(basefare).getText(); // basefare

			int basefare1 = Integer.parseInt(gettext1);

			String excelser1 = excelser.toString();

			int excelser12 = Integer.parseInt(excelser1);

			int results3 = basefare1 * excelser12 / 100;

			String results5 = Integer.toString(results3);

			String resutls4 = driver.findElementByXPath(appservicec).getText();

			// if (driver.findElementByXPath(xpath).isEnabled())
			if (results5.contentEquals(resutls4)) {
				// ATUReports.add("Service charge matches ", LogAs.PASSED, new
				// CaptureScreen(ScreenshotOf.BROWSER_PAGE));

				ATUReports.add("Service charge matches" + results5 + "", LogAs.PASSED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

				ATUReports.add("Service charge matches" + resutls4 + "", LogAs.PASSED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			} else {
				ATUReports.add("Service charge not matches" + gettext1 + "", LogAs.FAILED,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			}

			// ATUReports.add("xpath element got clicked ", LogAs.PASSED, new
			// CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		} catch (NoSuchElementException e) {

			// ATUReports.add("No element found ", LogAs.FAILED, new
			// CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		} catch (WebDriverException e) {
			// ATUReports.add("No driver found ", LogAs.FAILED, new
			// CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		} finally {
			takeSnap();
		}
	}

	// ========================================================================================================================

	// Page refresh done :

	public void pagerefresh() {

		driver.navigate().refresh();
	}
	// ========================

	// getext and pass the value to textboox

	public void gettexttotextbox(String xpath) throws Exception {

		try {

			Thread.sleep(1000);
  //Step 1: 
			String gettext1 = driver.findElementByXPath(xpath).getAttribute("value");
			String gettext2 = gettext1.toString();
			String gettext3;
			System.out.println(gettext2);
			int myNum = Integer.parseInt(gettext2);
			myNum = Math.abs(myNum);
			System.out.println(myNum);
			gettext3 = Integer.toString(myNum);
			System.out.println("After integer to string conversions == " + gettext3);
			
						// CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		} catch (NoSuchElementException e) {

			// ATUReports.add("No element found ", LogAs.FAILED, new
			// CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		} catch (WebDriverException e) {
			// ATUReports.add("No driver found ", LogAs.FAILED, new
			// CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		} finally {
			takeSnap();
		}
	}

	// ===============
	
	//gettext3
	
	
	public void Gridlistselections() throws InterruptedException
    {
    try {

    //List<WebElement> list = driver.findElements(By.xpath("//*[contains(@aria-describedby,'8')]"));

        int k=0,i=0;
       
        
    List<WebElement> list = driver.findElements(By.id("chk1"));

    Thread.sleep(1000);
    //List<WebElement> list = driver.findElements(By.xpath("//*[@id='ReceiptGenerationSearchGrid_active_cell']"));

    System.out.println("Totla list size"+list.size());

    //int k=0,i=0;
    
  
    for(i=0;i<list.size();i++)
    {

    //list.get(i).click();

    Thread.sleep(500);



    WebElement elt = driver.findElement(By.xpath("//*[@id='TotalTempAmount']"));

    Thread.sleep(500);

     Double d = new Double(elt.getAttribute("value").trim());


    //Double d = new Double(elt.getAttribute("value"));


    // System.out.println("List Size is",+ list.size());
    Thread.sleep(500);
    System.out.print("the value of d is" + d);

    if(d<=1)
    {
    k=i;
    List<WebElement> list1= driver.findElements(By.id("chk1"));
    Thread.sleep(4000);
    list1.get(k).click();

    Thread.sleep(4000);



    //list.get(i).click();






    //list.
    //list.size(i).click();
     if(i==9)
    {
    driver.findElement(By.xpath("//span[contains(@class,'arrow-60-right')]")).click();
    Thread.sleep(2000);
    }
     }
    }

    ATUReports.add("clicked", LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
    } catch (NoSuchElementException e) {

    ATUReports.add("NotClicked ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
    } catch (Exception e) {
    System.out.println("error");
    } finally {
    takeSnap();
    }

    }       
	
	//==================================================================
	
	public void Getlistindropdown(String xpath10,String currency) throws InterruptedException
	   {
	    try 
		{
	        int k=0,i=0;        



	 
	        
	        Select gettext1 = new Select(driver.findElement(By.xpath(xpath10)));
	        
	        //gettext1.Select. selectByVisibleText(�March�);
	        
	    String gettext3 = gettext1.toString();
		
	    String gettext4 = currency.toString();
	    System.out.println(gettext3);
    	System.out.println(gettext4);
	    if(gettext3.contains(gettext4))
	    {
	    	System.out.println(gettext3);
	    	System.out.println(gettext4);
	    	 ATUReports.add("currency matched", LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
	    }
	    else
	    	
	    {
	    	System.out.println(gettext3);
	    	System.out.println(gettext4);
	    
	    	 ATUReports.add("currency not matched", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
	    }
	    
	    		//System.out.println(elements.size());
	    
	    
/*
	    for(WebElement option : elements)
	    {
	        //if(option.getText().equals(currency))
	    	System.out.println(option);
	        	if(option.getText().contains(currency))
	        {
	            //option.click();
	        		System.out.print("pass");
	        		Thread.sleep(1000);
	        		 ATUReports.add("currency matched", LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
	            break;
	        }
	        	else
	        	{
	        		System.out.print("fail");
	        		Thread.sleep(1000);
	        		 ATUReports.add("Currency not matched ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
	        	
	    }*/

	    
	  /*  for (int j = 0; j < elements.size(); j++)
	    {
	        System.out.println(elements.get(j).getText());
	        
	        
	    }*/

	  

	   // ATUReports.add("clicked", LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
	    } catch (NoSuchElementException e) {

	   // ATUReports.add("NotClicked ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
	    } catch (Exception e) {
	    System.out.println("error");
	    } finally {
	    takeSnap();
	    }

	    }  
	
	
	//===============================================
	//Numbner compariiosn
	
	public void numbercomparisions(String xpath,String xpath1) throws InterruptedException
    {
		
		{
			Thread.sleep(5000);
			
			 List<WebElement> list2 = driver.findElements(By.id("chk1"));

			    Thread.sleep(1000);
			    //List<WebElement> list = driver.findElements(By.xpath("//*[@id='ReceiptGenerationSearchGrid_active_cell']"));

			    System.out.println("Totla list size"+list2.size());

			    int k=0;

			    for(int i=0;i<1;i++)
			    {
			    list2.get(i).click();
			    
			    Thread.sleep(500);
			    
			    

			    WebElement elt = driver.findElement(By.xpath(xpath));

			    Thread.sleep(500);

			     Double value1 = new Double(elt.getAttribute("value").trim());

                  System.out.println(value1);
                  Thread.sleep(1000);
                  
                  driver.findElement(By.xpath(xpath1)).click();
                  driver.findElement(By.xpath(xpath1)).click();
                  Thread.sleep(2000);
                   
                  driver.findElement(By.xpath("//input[@id='MatchedAmount']")).clear();
                  Thread.sleep(200);
                    driver.findElement(By.xpath("//input[@id='MatchedAmount']")).sendKeys(Keys.NUMPAD9);
    				Thread.sleep(1000);
    				driver.findElementByXPath("//input[@id='MatchedAmount']").sendKeys(Keys.TAB);
    				Thread.sleep(1000);
    				
    				driver.findElement(By.xpath("//a[@id='btnMainSave']")).click();
    					
                  Thread.sleep(4000);
                  //driver.findElement(By.xpath("/html/body/div[4]/div[3]/div/button")).click();
                		  Thread.sleep(2000);
                		  element.sendKeys(Keys.ENTER); 
                		  
                //
                  
                  WebElement elt1 = driver.findElement(By.xpath(xpath));
                  Thread.sleep(500);		    
  			     Double value2 = new Double(elt.getAttribute("value").trim());
  			   Thread.sleep(500);
  			   System.out.println(value2);
  			 Thread.sleep(500);
  			   if(value1<value2)
  			   {
  				 ATUReports.add("Amount reduced", LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
  				Thread.sleep(500);
  			   }
  			   else
  			   {
  				 ATUReports.add("Amount not getting reduced", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
  				Thread.sleep(500);
  			   }

		}
			    
	}
		
      
  /*  WebElement elt = driver.findElement(By.xpath("xpath"));
     
    Double d = new Double(elt.getAttribute("value").trim());
    
    
    
    System.out.print("output is" + d);*/
	}
       
 	//===============================================================
	//Selecting nthe List element 
	
	
	/*public void Listelementcollections(String id) throws InterruptedException
	  {
	    try 
		{
	    	Thread.sleep(2000);
	    List<WebElement> list = driver.findElements(By.id("id"));    
	    Thread.sleep(2000);
	    System.out.println("List Size is"+ +list.size());
	    Thread.sleep(1000);
	    list.get(i).click();        
	    
	    //ATUReports.add("NotClicked ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
	    }
	    catch (Exception e) {
	    System.out.println("error");
	    } finally {
	    takeSnap();
	    }

	    }  */
	


	//==========================================================================================
	//String compariosn
	//===================================================================================
	
	public void gettexttotextbox1( ) throws Exception
	{
		Thread.sleep(5000);
		
		 List<WebElement> list2 = driver.findElements(By.id("chk1"));

		    Thread.sleep(1000);
		    //List<WebElement> list = driver.findElements(By.xpath("//*[@id='ReceiptGenerationSearchGrid_active_cell']"));

		    System.out.println("Totla list size"+list2.size());

		    int k=0;

		    for(int i=0;i<list2.size();i++)
		    {
		    //list.get(i).click();
		    Thread.sleep(500);

		    WebElement elt = driver.findElement(By.xpath("//*[@id='TotalTempAmount']"));

		    Thread.sleep(500);

		     Double d = new Double(elt.getAttribute("value").trim());


		    //Double d = new Double(elt.getAttribute("value"));


		    // System.out.println("List Size is",+ list.size());
		    Thread.sleep(500);
		    System.out.print("the value of d is" + d);

		    if(d<=1)
		    {
		    k=i;
		    List<WebElement> list1= driver.findElements(By.id("chk1"));
		    Thread.sleep(4000);
		    list2.get(k).click();

		    Thread.sleep(4000);

	}
		    }


		/*try {numbe

			Thread.sleep(1000);
  //Step 1: 
			String gettext1 = driver.findElementByXPath(xpath).getAttribute("value");
			String gettext2 = gettext1.toString();
			String gettext3;
			System.out.println(gettext2);
			int myNum = Integer.parseInt(gettext2);
			myNum = Math.abs(myNum);
			System.out.println(myNum);
			gettext3 = Integer.toString(myNum);
			System.out.println("After integer to string conversions == " + gettext3);
			
			driver.findElementByXPath("//button[@id='customSettel']").click();
		Thread.sleep(3000);
			driver.findElementByXPath("//a[@class='k-button k-button-icontext k-grid-Edit']").click();
			driver.findElementByXPath("//a[@class='k-button k-button-icontext k-grid-Edit']").click();
			Thread.sleep(8000);
			System.out.println("value of gettext3 is "+gettext3);
			Thread.sleep(500);
			driver.findElementByXPath("//input[@id='VoucherDetailDrBaseAmount']").click();
			Thread.sleep(500);
			driver.findElementByXPath("//input[@id='VoucherDetailDrBaseAmount']").click();
			Thread.sleep(500);
			driver.findElementByXPath("//input[@id='VoucherDetailDrBaseAmount']").sendKeys(gettext3);
			Thread.sleep(1000);
			//
			
						// CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		} catch (NoSuchElementException e) {

			ATUReports.add("No element found ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		} catch (WebDriverException e) {
			ATUReports.add("No driver found ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		} finally {
			takeSnap();
		}*/
	}
	
//============================================================================
	
	//Page Field comparios
	
	public void elementfindedbyxpathnegtive(String xpath1) throws InterruptedException {
		try {
			driver.findElementByXPath(xpath1);
			ATUReports.add(" Element finded by xpath ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			Thread.sleep(1000);
		} catch (NoSuchElementException e) {

			ATUReports.add("Element not finded by xpath ", LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		} catch (WebDriverException e) {
			ATUReports.add("Element not finded by xpath", LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		} finally {
			takeSnap();
		}
	}

	//=================================================
	
	public void elementfindedbyxpathnegtive1(String xpath1) throws InterruptedException {
		try {
			driver.findElementByXPath(xpath1);
			ATUReports.add(" Element Finded by xpath ", LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			Thread.sleep(1000);
		} catch (NoSuchElementException e) {

			ATUReports.add("Element not finded by xpath ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		} catch (WebDriverException e) {
			ATUReports.add("Element not finded by xpath", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		} finally {
			takeSnap();
		}
	}

	
	//==================================
	
	//ATU Reports verifications
	
	public void AUTreports()
	{
		
	}
	
	//=======================================================================================
	// System navigate to i frmae

	public void navigatetoiframe(String xpath1) throws InterruptedException {
		try {

			int size = driver.findElements(By.tagName("iframe")).size();
			Thread.sleep(1000);
			driver.switchTo().frame(0);
			Thread.sleep(1000);
			driver.findElement(By.xpath("xpath1")).click();
			Thread.sleep(2000);

			ATUReports.add("clicked", LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		} catch (NoSuchElementException e) {

			ATUReports.add("NotClicked ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		} catch (WebDriverException e) {
			// ATUReports.add("No driver found ", LogAs.FAILED, new
			// CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		} finally {
			takeSnap();
		}

	}

	
	//=============================================
	
	//value comparisions 
	
	public void financevaluecompariisons(String id) throws InterruptedException
    {
    try 
    {
    //List<WebElement> list = driver.findElements(By.xpath("//*[contains(@aria-describedby,'8')]"));

        int k=0,i=0;
       
        
    List<WebElement> list = driver.findElements(By.id("chk1"));

    Thread.sleep(1000);
    //List<WebElement> list = driver.findElements(By.xpath("//*[@id='ReceiptGenerationSearchGrid_active_cell']"));

    //System.out.println("Totla list size"+list.size());

    //int k=0,i=0;
    
  
    for(i=0;i<1;i++)
    {

    list.get(i).click();

    Thread.sleep(500);


   
    Thread.sleep(500);
    driver.findElement(By.xpath("/html/body/div[3]/div/div[1]/div[1]/div/div/div[2]/div[2]/form/div[2]/div/div[13]/div/table/tbody/tr[1]/td[2]")).click();
    driver.findElement(By.xpath("/html/body/div[3]/div/div[1]/div[1]/div/div/div[2]/div[2]/form/div[2]/div/div[13]/div/table/tbody/tr[1]/td[2]")).click();
    Thread.sleep(1000);
    //driver.findElement(By.xpath("//*[@id='ReceiptGenerationSearchGrid_active_cell']")).click();
    
    driver.findElement(By.xpath("//*[@id='ReceiptGenerationSearchGrid_active_cell']")).sendKeys("1");
    Thread.sleep(500);
    WebElement elt = driver.findElement(By.xpath("//*[@id='TotalTempAmount']"));

    Thread.sleep(500);

    // Double d = new Double(elt.getAttribute("value").trim());
    

    Double d = new Double(elt.getAttribute("value"));


    //System.out.println("List Size is",+ list.size());
    
    Thread.sleep(500);
    System.out.print("the value of d is" + d);

    //String id;
    double d1 = Double.parseDouble(id);

    if(d!=d1)
    {
    	ATUReports.add("Value not chnaged", LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
    }
    	else
    	{
    		ATUReports.add("Value changed ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
     }

    }
    
    } 
    catch (NoSuchElementException e) 
    {
    ATUReports.add("NotClicked ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
    } catch (Exception e) {
    System.out.println("error");
    } finally {
    takeSnap();
    }

    }       
	
	
	//==========================================================
	
	//pass the vaue b keboard
	
		public void sendnuberbykeboardxpath(String xva) throws InterruptedException
		{
			try {
				driver.findElement(By.xpath("//input[@id='ArtMatchAmount']")).clear();

				driver.findElement(By.xpath("//input[@id='ArtMatchAmount']")).click();			
				driver.findElement(By.xpath("//input[@id='ArtMatchAmount']")).click();
				driver.findElement(By.xpath("//input[@id='ArtMatchAmount']")).click();
				
				
				//driver.findElementByCssSelector(xva).sendKeys(txt);
				//driver.findElement(By.xpath("xva")).SendKeys(Keys.NUMPAD0);
				
				driver.findElement(By.xpath("//input[@id='ArtMatchAmount']")).sendKeys(Keys.INSERT);
				Thread.sleep(100);
				driver.findElement(By.xpath("//input[@id='ArtMatchAmount']")).sendKeys(Keys.NUMPAD9);
				Thread.sleep(100);
				driver.findElement(By.xpath("//input[@id='ArtMatchAmount']")).sendKeys(Keys.NUMPAD5);
				Thread.sleep(100);
				
				
				// driver.findElementByCssSelector(xva).sendKeys(txt);

				//ATUReports.add(" User Entered the text as " + "", LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			} catch (NoSuchElementException e) {

				//ATUReports.add("No element found ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			} catch (WebDriverException e) {
				//ATUReports.add("No driver found ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			} finally {
				takeSnap();
			}
		}
		
	
	//=========================================================================
		//pass the vaue b keboard
		
			public void sendnuberbykeboardxpathsubrctvalue(String xva) throws InterruptedException
			{
				try {
					driver.findElement(By.xpath("//input[@id='ArtMatchAmount']")).clear();

					driver.findElement(By.xpath("//input[@id='ArtMatchAmount']")).click();			
					driver.findElement(By.xpath("//input[@id='ArtMatchAmount']")).click();
					driver.findElement(By.xpath("//input[@id='ArtMatchAmount']")).click();
					
					
					//driver.findElementByCssSelector(xva).sendKeys(txt);
					//driver.findElement(By.xpath("xva")).SendKeys(Keys.NUMPAD0);
					
					driver.findElement(By.xpath("//input[@id='ArtMatchAmount']")).sendKeys(Keys.INSERT);
					Thread.sleep(100);
					driver.findElement(By.xpath("//input[@id='ArtMatchAmount']")).sendKeys(Keys.SUBTRACT);
					Thread.sleep(100);
					driver.findElement(By.xpath("//input[@id='ArtMatchAmount']")).sendKeys(Keys.NUMPAD9);
					Thread.sleep(100);
					driver.findElement(By.xpath("//input[@id='ArtMatchAmount']")).sendKeys(Keys.NUMPAD5);
					Thread.sleep(100);
					
					
					// driver.findElementByCssSelector(xva).sendKeys(txt);

					//ATUReports.add(" User Entered the text as " + "", LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				} catch (NoSuchElementException e) {

					//ATUReports.add("No element found ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				} catch (WebDriverException e) {
					//ATUReports.add("No driver found ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				} finally {
					takeSnap();
				}
			}
			
			//============================================================================
			
			//Send value by webelement 
			
			public void sendvaluebywebelementxpath(String xva) throws InterruptedException
			{
				try {			
					

                       WebElement webElement = driver.findElement(By.xpath(xva));
                       
                       /*webElement.sendKeys(Keys.NUMPAD0);
                        webElement.sendKeys(Keys.NUMPAD9);
                        Thread.sleep(100);
                        webElement.sendKeys(Keys.TAB);
                        webElement.sendKeys(Keys.TAB);*/
                        
                    //   webElement.sendKeys(Keys.END);
                       //webElement.sendKeys(Keys.BACK_SPACE);
                       //webElement.sendKeys(Keys.

                       
                        
                       // webElement.sendKeys(Keys.ENTER);
                        Thread.sleep(100);
					
				/*	Thread.sleep(2000);
                    // driver.findElement(By.xpath("xva")).sendKeys(Keys.INSERT);
					Thread.sleep(1000);
					driver.findElement(By.xpath("xva")).sendKeys(Keys.NUMPAD0);
					Thread.sleep(100);
					driver.findElement(By.xpath("xva")).sendKeys(Keys.NUMPAD5);
					Thread.sleep(2000);
					
					Thread.sleep(100);
					*/
					
					// driver.findElementByCssSelector(xva).sendKeys(txt);

					//ATUReports.add(" User Entered the text as " + "", LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				} catch (NoSuchElementException e) {

					//ATUReports.add("No element found ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				} catch (WebDriverException e) {
					//ATUReports.add("No driver found ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				} finally {
					takeSnap();
				}
			}
			
			
		//================================================================================
			//sent value by keyboard
			
			public void sendnuberbykeboardxpath1(String xva) throws InterruptedException
			{
				try {			
					
					
					
					Thread.sleep(2000);
                    // driver.findElement(By.xpath("xva")).sendKeys(Keys.INSERT);
					Thread.sleep(1000);
					driver.findElement(By.xpath("xva")).sendKeys(Keys.NUMPAD0);
					Thread.sleep(100);
					driver.findElement(By.xpath("xva")).sendKeys(Keys.NUMPAD5);
					Thread.sleep(2000);
					
					Thread.sleep(100);
					
					
					// driver.findElementByCssSelector(xva).sendKeys(txt);

					//ATUReports.add(" User Entered the text as " + "", LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				} catch (NoSuchElementException e) {

					//ATUReports.add("No element found ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				} catch (WebDriverException e) {
					//ATUReports.add("No driver found ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				} finally {
					takeSnap();
				}
			}
			
			//======================================================================
			
			public void Stringcomparisions(String xpath, String xpath1) throws Exception {

				try {

					Thread.sleep(3000);

					String gettext1 = driver.findElementByXPath(xpath).getText();
					//String gettext2 = id.toString();
					String gettext2 = driver.findElementByXPath(xpath1).getText();
				
					String gettext3 = "indian ruppes";
					
					// if (driver.findElementByXPath(xpath).isEnabled())
					if (gettext1.contentEquals(gettext2))
					
					{
					System.out.println(gettext1);
				System.out.println(gettext2);
					System.out.println(gettext3);
						
						// ATUReports.add("Service charge matches ", LogAs.PASSED, new
						// CaptureScreen(ScreenshotOf.BROWSER_PAGE));

						ATUReports.add("Currency reflected correctly" + gettext1 + "", LogAs.PASSED,
								new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

					} else {
						ATUReports.add("Currency  not reflected correctly" + gettext1 + "", LogAs.FAILED,
								new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					}

					// ATUReports.add("xpath element got clicked ", LogAs.PASSED, new
					// CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				} catch (NoSuchElementException e) {

					// ATUReports.add("No element found ", LogAs.FAILED, new
					// CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				} catch (WebDriverException e) {
					// ATUReports.add("No driver found ", LogAs.FAILED, new
					// CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				} finally {
					takeSnap();
				}
			}

			
			//============================================================================
			//=============================================================================
			
			//gettest and string comparions
			
			public void gettextstringcomparsions(String xva) throws InterruptedException
			{
				try {
					
					WebElement elt = driver.findElement(By.xpath("xva"));

					Double d = new Double(elt.getAttribute("value"));
					
					//String d = new String(elt.getAttribute("value"));

					System.out.print("the value of d is" + d);
				
					
					
					// driver.findElementByCssSelector(xva).sendKeys(txt);

					ATUReports.add(" User Entered the text as " + d, LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				} catch (NoSuchElementException e) {
					System.out.print("Error messgae is" + e);
					ATUReports.add("No element found ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				} catch (WebDriverException e) {
					ATUReports.add("No driver found ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				} finally {
					takeSnap();
				}
			}
			
			//===========================================================================
			
			public void Armatching(String xva12) throws InterruptedException
			{
				
					try
					{
					WebElement elt1 = driver.findElement(By.xpath(xva12));

					//Double d = new Double(elt.getAttribute("value"));
					
					//String d = new String(elt1.getAttribute("value"));
					
					String d = new String(elt1.getText());
					
					
					int foo = Integer.parseInt(d);
					//Double foo1 = Double.parseDouble(foo)
					//String d = new String(elt.getAttribute("value"));

					System.out.print("the value of d is" + foo);
				
					if(foo==0)
					{		
						ATUReports.add(" AR matching Done successfully" + foo, LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					}
					else
					{
						ATUReports.add(" AR matching Not Done successfully " + foo, LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					}		
					}
					catch(Exception e)
					{
						System.out.print("error message"+e);
					}
			}
			
			//===========================================================================================
			
			public void Arunmatching(String xva12) throws InterruptedException
			{
				
					try
					{
					WebElement elt1 = driver.findElement(By.xpath(xva12));

					//Double d = new Double(elt.getAttribute("value"));
					
					//String d = new String(elt1.getAttribute("value"));
					
					String d = new String(elt1.getText());
					
					
					int foo = Integer.parseInt(d);
					//Double foo1 = Double.parseDouble(foo)
					//String d = new String(elt.getAttribute("value"));

					System.out.print("the value of d is" + foo);
				
					if(foo!=0)
					{		
						ATUReports.add(" AR unmatching Done successfully" + foo, LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					}
					else
					{
						ATUReports.add(" AR unmatching Not Done successfully " + foo, LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					}		
					}
					catch(Exception e)
					{
						System.out.print("error message"+e);
					}
			}
			
			//====================================================================================

			
			//AR PARtial un matching
			
			public void Arpartialunmatching(String xva12,String xva14) throws InterruptedException
			{
				
					try
					{
					WebElement elt1 = driver.findElement(By.xpath(xva12));

					//Double d = new Double(elt.getAttribute("value"));
					
					//String d = new String(elt1.getAttribute("value"));
					
					String d = new String(elt1.getText());
					
					
					int foo = Integer.parseInt(d);
					int foo1 = Integer.parseInt(xva14);
					//Double foo1 = Double.parseDouble(foo)
					//String d = new String(elt.getAttribute("value"));

					System.out.print("the value of d is" + foo);
				
					if(foo==foo1)
					{		
						ATUReports.add(" AR unmatching Done successfully" + foo, LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					}
					else
					{
						ATUReports.add(" AR unmatching Not Done successfully " + foo, LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					}		
					}
					catch(Exception e)
					{
						System.out.print("error message"+e);
					}
			}
			
			
			//================================================================================================

 public void storestrign1() throws InterruptedException
	  {
	    try 
		{
	    	Thread.sleep(2000);
	    
	    	
	    	WebElement elt = driver.findElement(By.xpath("//input[@id='VoucherDocNumber']"));

	        Thread.sleep(500);

	         String d = new String(elt.getAttribute("value"));
	         store1 = d;
		        Thread.sleep(500);

	         System.out.println("the value is"+d);
	         //ATUReports.add("created details are " + store1, LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				 
	    }
	    catch (Exception e) {
	    System.out.println("error");
	    } finally {
	    takeSnap();
	    }

	    }
 
 //================================================================================
 
 public void storestrign2(String xpath10) throws InterruptedException
 {
   try 
	{
   	Thread.sleep(2000);
   
   	WebElement elt = driver.findElement(By.xpath(xpath10));

       Thread.sleep(500);

        String d = new String(elt.getAttribute("value"));
        store2 = d;
	        Thread.sleep(500);
	        
        System.out.println("the value is"+store2);
        
      ATUReports.add("Newly created details " + store2, LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
    	
        
   }
   catch (Exception e) {
   System.out.println("error");
   } finally {
   takeSnap();
   }

   }
 //==========================================================================================
 
 
 public void storestringpassingxpathvalue(String xva,String value)
 {
		try {
			driver.findElementByXPath(xva).clear();
			driver.findElementByXPath(xva).sendKeys(value);

			ATUReports.add(" User Entered the text as " + store1, LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		} catch (NoSuchElementException e) {

			ATUReports.add("No element found ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		} catch (WebDriverException e) {
			ATUReports.add("No driver found ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		} finally {
			takeSnap();
		}
	}
 
  
 //======================================================================================
 
 
 //================ Findelement by xpath and enter the values ...  
 
 public void findelementbyxpathandselectenterthevalues(String xpath,String xpath1) 
	{	
List<WebElement> dynamicElement = driver.findElements(By.xpath("xpath"));
if(dynamicElement.size() != 0)

System.out.println("Element is present");
driver.findElementByXPath(xpath).click();
driver.findElementByXPath(xpath).clear();
driver.findElementByXPath(xpath).sendKeys(xpath1);
{
System.out.println("Element not present");
		}		
		} 

 //
 
			//============================================================================================
			
			public void Listelementcollectionsbvyusingxpath(String xpath1,String value) throws InterruptedException
			  {
			    try 
				{
			    	int j1=0;
			    	Thread.sleep(2000);
			    List<WebElement> list = driver.findElements(By.xpath(xpath1));    
			    Thread.sleep(2000);
			    System.out.println("List Size is"+ +list.size());
			    Thread.sleep(1000);
			    //list.get(j1).click();
			    int foo = Integer.parseInt(value);
			    Thread.sleep(1000);
			    list.get(foo).click();
			     Thread.sleep(1000);
			    
			    //ATUReports.add("NotClicked ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			    }
			    catch (Exception e) {
			    System.out.println("error");
			    } finally {
			    takeSnap();
			    }

			    }  
			
			//================================================================================

			//Listbyenter  and send the values for visible xpath
			
			public void Listandenter(String xpath1,String value) throws InterruptedException
			  {
			    try 
				{
			    	int j1=0;
			    	Thread.sleep(1000);
			    List<WebElement> list = driver.findElements(By.xpath(xpath1));    
			    Thread.sleep(1000);
			    System.out.println("List Size is"+ +list.size());
			    Thread.sleep(1000);
			    //list.get(j1).click();
			    int foo = Integer.parseInt(value);
			    Thread.sleep(1000);
			    
			   list.get(foo).click();
			   

               // driver.findElementByXPath(xpath1).sendKeys(Keys.ENTER);

			     Thread.sleep(600);
			    
			    //ATUReports.add("NotClicked ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			    }
			    catch (Exception e) {
			    System.out.println("error");
			    } finally {
			    takeSnap();
			    }

			    }  

			
			// ==============

//Listbyenter
			
			public void Listandenterquick(String xpath1,String value) throws InterruptedException
			  {
			    try 
				{
			    	int j1=0;
			    	Thread.sleep(1000);
			    List<WebElement> list = driver.findElements(By.xpath(xpath1));    
			    Thread.sleep(200);
			    System.out.println("List Size is"+ +list.size());
			    Thread.sleep(200);
			    //list.get(j1).click();
			    int foo = Integer.parseInt(value);
			    Thread.sleep(100);
			    
			   list.get(foo).click();
               // driver.findElementByXPath(xpath1).sendKeys(Keys.ENTER);
			     Thread.sleep(100);
			  //  ATUReports.add("Getindexandclicked", LogAs.INFO, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			    }
			    catch (Exception e) {
			    System.out.println("error");
			    } finally {
			    takeSnap();
			    }
			    }			
			
			//===========================================================================

			public void Textcomparisonsfornullvalues(String xpath,String excelvalues,String usermessage) throws Exception {
				try {
					Thread.sleep(2000);
					String jobid = driver.findElementByXPath(xpath).getText();
					
					if(jobid.contentEquals(excelvalues))
					{
						System.out.println(excelvalues);
						
						System.out.println(jobid);
						

					ATUReports.add(usermessage + jobid + "", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

					}
					else
					{
						ATUReports.add(usermessage , LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			
					}
					
				} catch (WebDriverException e) {
					ATUReports.add("user unable to capture the message", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				}
			}
			
			//=====================================================================================================
			//========================================================
			
			//input[@id='_value']
			
			public void Listenterthevalues(String xpath1,String value,String value1) throws InterruptedException
			  {
			    try 
				{
			    	int j1=0;
			    	Thread.sleep(2000);
			    List<WebElement> list = driver.findElements(By.xpath(xpath1));    
			    Thread.sleep(2000);
			    System.out.println("List Size is"+ +list.size());
			    Thread.sleep(1000);
			    list.get(j1).click();
			    int foo = Integer.parseInt(value);
			    Thread.sleep(1000);
			    
			   list.get(foo).click();

             driver.findElementByXPath(xpath1).sendKeys(value1);

			     Thread.sleep(1000);
			    
			    //ATUReports.add("NotClicked ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			    }
			    catch (Exception e) {
			    System.out.println("error");
			    } finally {
			    takeSnap();
			    }

			    }  
			
			
			

			//==================================================
			
			//Fnding lement in xpath and sending values
			

			//Listbyenter  and send the values for visible xpath
			
			public void Listandenterthevaluesinvisblexpath(String xpath1,String value)
			
			  {
			    List<WebElement> list = driver.findElements(By.xpath(xpath1));      
			    	
					    System.out.println("List Size is"+ +list.size());
			    if(list.size()!=0)
			    {
			    	driver.findElementByXPath(xpath1).sendKeys(value);
				    
			    	
			    }
			    else
			    {
			   System.out.println("Element is not rpesent");
			    }
			   
			

            	    //ATUReports.add("NotClicked ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			    }
			    
			      
//===================================================================================
			
			//===============================================================================
			

			public void Textcomparisons(String xpath,String excelvalues,String usermessage) throws Exception {
				try {
					Thread.sleep(2000);
					
					String jobid = driver.findElementByXPath(xpath).getText();
							
					
					String jobid2 = excelvalues.toString();
					
					System.out.println(jobid2);
					
					System.out.println(jobid);
					

					if(jobid.contentEquals(excelvalues))
					{
					//if(jobid.matches(jobid2))
					ATUReports.add(usermessage + jobid , LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					}
					else
					{
					ATUReports.add(usermessage + jobid , LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					}		
					
					
										
				} catch (WebDriverException e) {
					ATUReports.add("user unable to capture the message", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				}
			}

			
			//================================================================================


			//textcompariosna nd contains
			

			public void Textcomparisonsstringcontains(String xpath,String excelvalues,String usermessage) throws Exception {
				try {
					Thread.sleep(2000);
					
					String jobid = driver.findElementByXPath(xpath).getText().trim();
							
					
					String jobid2 = excelvalues.trim();
					
					System.out.println(jobid2);
					
					System.out.println(jobid);
					
					if(jobid.contentEquals(jobid2))
					{
					//if(jobid.matches(jobid2))
					ATUReports.add(usermessage + jobid , LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					}
					else
					{
					ATUReports.add(usermessage + jobid , LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					}		
					
					
										
				} catch (WebDriverException e) {
					ATUReports.add("user unable to capture the message", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				}
			}

			
			
			
			
			//==================================================================================
			public void Listselectallvalues(String xpath1) throws InterruptedException
			  {
			    try 
				{
			   
			    	int k=0,i=0;       
			        List<WebElement> list = driver.findElements(By.xpath(xpath1));

			        
			        System.out.println("Totla list size"+list.size());

			        
			        for(i=0;i<list.size();i++)
			        {

			        list.get(i).click();



			        Thread.sleep(500);

			      }
               			    }
			    catch (Exception e) {
			    System.out.println("error");
			    } finally {
			    takeSnap();
			    }

			    }  


			
			// ============================================================

			
			//=======================================================================================
			
			
			public void Textcomparisonsfornegative(String xpath,String excelvalues,String usermessage) throws Exception {
				try {
					Thread.sleep(2000);
					String jobid = driver.findElementByXPath(xpath).getText().trim();
					
					String jobid1 = excelvalues.trim();
					
					
					if(jobid==jobid1)
					{
						System.out.println(excelvalues);
						
						System.out.println(jobid);
						

					ATUReports.add(usermessage + jobid , LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

					}
					else
					{
						ATUReports.add(usermessage + jobid  , LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			
					}
					
				} catch (WebDriverException e) {
					ATUReports.add("user unable to capture the message", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				}
			}
			
			//==================================================
			


			 public void openurlinnewtab(String URl) 
				{	
				 driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "\t");
					System.out.println(driver.getCurrentUrl());
					driver.switchTo().defaultContent();
					//Thread.sleep(2000);


//				driver.get(URl);
				}
			 

			 
			 //======================================================================================================
			 
			 //String converted into arraylist values and done the comparisons

			 public void Stringtolistvalueandcomparisions(String xpath,String excelvalues,String usermessage)
			 {
				 String jobid = driver.findElementByXPath(xpath).getText().trim();
				 
				 String jobid1 = excelvalues.trim();
				 
				String str[] = jobid.split("\\n");
				 
				System.out.println(str);
				
				 List<String> al = new ArrayList<String>();
				
				 //System.out.println(s1);
					
				 al = Arrays.asList(str);

				 System.out.println("value of a1"+al);
				 
					
					
				// System.out.println("The calue are applicaiton"  a1);
				 
				 
				 for(String s: al)
				 {
					 System.out.println("The calue are applicaiton"+ s);
					 
					// System.out.println("The calue are applicaiton"+ s1);
					 	
					if(s.matches(excelvalues))
							 

						// if(s.matches(jobid1))
							
						 
						 
					 {
						 
						 ATUReports.add( usermessage + s , excelvalues+ "", LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
	 
	                      //break;
					 
					 }
					 
						/*else
						
							ATUReports.add(usermessage , LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				*/
						}

					   //System.out.println(s);
					
				 
			 
				 
					//ATUReports.add(usermessage , LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
							 
				 
			 }
			 
			 			 

			 
			 //String convert into arraylist USING CSS VALUES 
			 
			 //==========================================================================

			 public void Stringtolistvalueandcomparisionsusingcss(String css,String excelvalues,String usermessage)
			 {
				 String jobid = driver.findElementByCssSelector(css).getText().trim();
				 
				 String jobid1 = excelvalues.trim();
				 
				String str[] = jobid.split("\\n");
				 
				System.out.println(str);
				
				 List<String> al = new ArrayList<String>();
				
				 //System.out.println(s1);
					
				 al = Arrays.asList(str);

				 System.out.println("value of a1"+al);
				 
					
					
				// System.out.println("The calue are applicaiton"  a1);
				 
				 
				 for(String s: al)
				 {
					 System.out.println("The calue are applicaiton"+ s);
					 
					// System.out.println("The calue are applicaiton"+ s1);
					 	
					if(s.matches(excelvalues))
							 

						// if(s.matches(jobid1))
							
						 
						 
					 {
						 
						 ATUReports.add( usermessage + s , excelvalues+ "", LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
	 
	                      //break;
					 
					 }
					 
						/*else
						
							ATUReports.add(usermessage , LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				*/
						}

					   //System.out.println(s);
					
				 
			 
				 
					//ATUReports.add(usermessage , LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
							 
				 
			 }
			 
			 			 

			 
			 //===================================================================
			 
			 
			 //==============================================================================================================
			 
			 //negative comparisions
			 

			 public void Stringtolistvalueandcomparisionsnegative(String xpath,String excelvalues,String usermessage)
			 {
				 String jobid = driver.findElementByXPath(xpath).getText().trim();
				 
				 String jobid1 = excelvalues.trim();
				 
				String str[] = jobid.split("\\n");
				 
				System.out.println(str);
				
				 List<String> al = new ArrayList<String>();
				
				 //System.out.println(s1);
					
				 al = Arrays.asList(str);

				 System.out.println("value of a1"+al);
				 
					
					
				// System.out.println("The calue are applicaiton"  a1);
				 
				 
				 for(String s: al)
				 {
					 System.out.println("The calue are applicaiton"+ s);
					 
					// System.out.println("The calue are applicaiton"+ s1);
					 	
					 //if(s.matches(excelvalues))
					 
						if(s!=excelvalues)
										 
							// if(s==excelvalues)
									
							 
					 {
							 ATUReports.add( usermessage + s , excelvalues+ "", LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
								
						 
						// ATUReports.add( "value is s" + s , excelvalues+ "xpath", LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
	 
	                   //   break;
					 
					 }
					 
						else
						
							ATUReports.add(usermessage , LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				
						}

					   //System.out.println(s);
					
				 
			 
				 
					//ATUReports.add(usermessage , LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
							 
				 
			 }
			 

			 
			 
			 
			 
			 //=============================================================================================================
			 //==============================================================================================================

			 
			 //String comparions by comma
			  
			 

			 public void Stringtolistvalueandcomparisionsbycomma(String xpath,String excelvalues,String usermessage)
			 {
				 String jobid = driver.findElementByXPath(xpath).getText();
				 
				 String jobid1 = excelvalues;
				 
				String str[] = jobid.split(",");
				 
				System.out.println(str);
				
				 List<String> al = new ArrayList<String>();
				
				 //System.out.println(s1);
					
				 al = Arrays.asList(str);

				 System.out.println("value of a1"+al);
				 
					
					
				// System.out.println("The calue are applicaiton"  a1);
				 
				 
				 for(String s: al)
				 {
					 System.out.println("The calue are applicaiton"+ s);
					 
					// System.out.println("The calue are applicaiton"+ s1);
					 	
					 if(s.matches(excelvalues))
							 

							 
					 {
						 
						 //ATUReports.add( "value is s" + s , excelvalues+ "xpath", LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
						 
						 ATUReports.add( usermessage + s , excelvalues+ "", LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
							
						 
	                      break;
					 
					 }
					 
						/*else
						
							ATUReports.add(usermessage , LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				*/
						}

					   //System.out.println(s);
					
				 
			 
				 
					//ATUReports.add(usermessage , LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
							 
				 
			 }

			 
			 
			 

			 
			 //========================================================================
			 
			 

			 

			 public void Stringtolistvalueandcomparisionsbycommanegative(String xpath,String excelvalues,String usermessage)
			 {
				 String jobid = driver.findElementByXPath(xpath).getText();
				 
				 String jobid1 = excelvalues;
				 
				String str[] = jobid.split(",");
				 
				System.out.println(str);
				
				 List<String> al = new ArrayList<String>();
				
				 //System.out.println(s1);
					
				 al = Arrays.asList(str);

				 System.out.println("value of a1"+al);
				 
					
					
				// System.out.println("The calue are applicaiton"  a1);
				 
				 
				 for(String s: al)
				 {
					 System.out.println("The calue are applicaiton"+ s);
					 
					// System.out.println("The calue are applicaiton"+ s1);
					 	
			//		 if(s.matches(excelvalues))
						 if(s!=excelvalues)
									 

							 
					 {
						 
						 ATUReports.add( "value is s" + s , excelvalues+ "xpath", LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
	 
	                      break;
					 
					 }
					 
						else
						
							ATUReports.add(usermessage , LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				
						}

					   //System.out.println(s);
					
				 
			 
				 
					//ATUReports.add(usermessage , LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
							 
				 
			 }

			 
			 



			 
			 //=====================================================================================================
			 //String comparions by comma
			  
			 

			 public void Stringtolistvalueandcomparisionsbyundercore(String xpath,String excelvalues,String usermessage)
			 {
				 String jobid = driver.findElementByXPath(xpath).getText().trim();
				 
				 String jobid1 = excelvalues.trim();
				 
				String str[] = jobid.split("-");
				 
				System.out.println(str);
				
				 List<String> al = new ArrayList<String>();
				
				 //System.out.println(s1);
					
				 al = Arrays.asList(str);

				 System.out.println("value of a1"+al);
				 
					
					
				// System.out.println("The calue are applicaiton"  a1);
				 
				 
				 for(String s: al)
				 {
					 System.out.println("The calue are applicaiton"+ s);
					 
					// System.out.println("The calue are applicaiton"+ s1);
					 	
					 if(s.matches(excelvalues))
							 

							 
					 {
						 
						 //ATUReports.add( "value is s" + s , excelvalues+ "xpath", LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
	 
						 ATUReports.add( usermessage + s , excelvalues+ "", LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
							
	                      break;
					 
					 }
					 
						/*else
						
							ATUReports.add(usermessage , LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				*/
						}

					   //System.out.println(s);
					
				 
			 
				 
					//ATUReports.add(usermessage , LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
							 
				 
			 }

			 
			 

			 //===========================================================================
			 
			 


			 public void Stringtolistvalueandcomparisionsbyundercorenegative(String xpath,String excelvalues,String usermessage)
			 {
				 String jobid = driver.findElementByXPath(xpath).getText();
				 
				 String jobid1 = excelvalues;
				 
				String str[] = jobid.split(",");
				 
				System.out.println(str);
				
				 List<String> al = new ArrayList<String>();
				
				 //System.out.println(s1);
					
				 al = Arrays.asList(str);

				 System.out.println("value of a1"+al);
				 
					
					
				// System.out.println("The calue are applicaiton"  a1);
				 
				 
				 for(String s: al)
				 {
					 System.out.println("The calue are applicaiton"+ s);
					 
					// System.out.println("The calue are applicaiton"+ s1);
					 	
					// if(s.matches(excelvalues))
						 
						 if(s!=excelvalues)
								
							 

							 
					 {
						 
						 ATUReports.add( "value is s" + s , excelvalues+ "xpath", LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
	 
	                      break;
					 
					 }
					 
						else
						
							ATUReports.add(usermessage , LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				
						}

					   //System.out.println(s);
					
				 
			 
				 
					//ATUReports.add(usermessage , LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
							 
				 
			 }

			 

			 
//===========================================================================================================
			 
			 
			 public void Stringtolistvalueandcomparisionsbyundercore1(String xpath,String excelvalues,String usermessage)
			 {
				 String jobid = driver.findElementByXPath(xpath).getText();
				 
				 String jobid1 = excelvalues;
				 
				String str[] = jobid.split(",");
				 
				System.out.println(str);
				
				 List<String> al = new ArrayList<String>();
				
				 //System.out.println(s1);
					
				 al = Arrays.asList(str);

				 System.out.println("value of a1"+al);
				 
					
					
				// System.out.println("The calue are applicaiton"  a1);
				 
				 
				 for(String s: al)
				 {
					 System.out.println("The calue are applicaiton"+ s);
					 
					// System.out.println("The calue are applicaiton"+ s1);
					 	
					 if(s.matches(excelvalues))
							 

							 
					 {
						 
						 //ATUReports.add( "value is s" + s , excelvalues+ "xpath", LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
	 
						 ATUReports.add( usermessage + s , excelvalues+ "", LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
							
	                      break;
					 
					 }
					 
						/*else
						
							ATUReports.add(usermessage , LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				*/
						}

					   //System.out.println(s);
					
				 
			 
				 
					//ATUReports.add(usermessage , LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
							 
				 
			 }

			 
			 

			 //===========================================================================
			 
			 


			 public void Stringtolistvalueandcomparisionsbyundercorenegative1(String xpath,String excelvalues,String usermessage)
			 {
				 String jobid = driver.findElementByXPath(xpath).getText();
				 
				 String jobid1 = excelvalues;
				 
				String str[] = jobid.split(",");
				 
				System.out.println(str);
				
				 List<String> al = new ArrayList<String>();
				
				 //System.out.println(s1);
					
				 al = Arrays.asList(str);

				 System.out.println("value of a1"+al);
				 
					
					
				// System.out.println("The calue are applicaiton"  a1);
				 
				 
				 for(String s: al)
				 {
					 System.out.println("The calue are applicaiton"+ s);
					 
					// System.out.println("The calue are applicaiton"+ s1);
					 	
					// if(s.matches(excelvalues))
						 
						 if(s!=excelvalues)
								
							 

							 
					 {
						 
						 ATUReports.add( "value is s" + s , excelvalues+ "xpath", LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
	 
	                      break;
					 
					 }
					 
						else
						
							ATUReports.add(usermessage , LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				
						}

					   //System.out.println(s);
					
				 
			 
				 
					//ATUReports.add(usermessage , LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
							 
				 
			 }

			 


			 //sending value by xpath if element is found
			 
			 //===============================================================================
			 
				public void findelementandsendtextbyxvalue(String xva, String txt) {
					try {
					if (driver.findElementByXPath(xva).isDisplayed())
			                 {
						driver.findElementByXPath(xva).clear();
						driver.findElementByXPath(xva).sendKeys(txt);

						ATUReports.add(" User Entered the text as " + txt, LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
						}
					} catch (NoSuchElementException e) {

						ATUReports.add("No element found ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					} catch (WebDriverException e) {
						ATUReports.add("No driver found ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					} finally {
						takeSnap();
					}
				}

			 
			 //==========================================================================================
			 
			 //sendtextbyname
				
				public void sendtextbyname(String name, String txt) {
					try {

						//driver.findElementById(id).clear();
						driver.findElementByName(name).clear();
						driver.findElementByName(name).sendKeys(txt);
						ATUReports.add(" User Entered the text as " + txt, LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					} catch (NoSuchElementException e) {

						ATUReports.add("No element found ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					} catch (WebDriverException e) {
						ATUReports.add("No driver found ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					} finally {
						takeSnap();
					}
				}

				
				//
			 //=======================================================================================


				 public void Gettextbylistandprint(String xpath,String usermessage)
				 {
					 String jobid = driver.findElementByXPath(xpath).getText().trim();
					 
					 //String jobid1 = excelvalues.trim();
					 
					String str[] = jobid.split("\\n");
					 
					System.out.println(str);
					
					 List<String> al = new ArrayList<String>();
					
					 //System.out.println(s1);
						
					 al = Arrays.asList(str);

					 System.out.println("value of a1"+al);
					 
						
						
					// System.out.println("The calue are applicaiton"  a1);
					 
					 
					 for(String s: al)
					 {
						 System.out.println("The calue are applicaiton"+ s);
						 
						// System.out.println("The calue are applicaiton"+ s1);
						 	
						//if(s.matches(excelvalues))
								 

							// if(s.matches(jobid1))
								
							 
							 
						 {
							 
							 ATUReports.add( usermessage ,s, LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		 
		                      //break;
						 
						 }
						 
							/*else
							
								ATUReports.add(usermessage , LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					*/
							}

						   //System.out.println(s);
						
					 
				 
					 
						//ATUReports.add(usermessage , LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
								 
					 
				 }
				 
				 			 


				
			//======================================================================================
			 
				 //send text id withclear the records
				 
				 public void sendtextbyidnotusingclear(String id, String txt) {
						try {

							//driver.findElementById(id).clear();
							driver.findElementById(id).sendKeys(txt);
							ATUReports.add(" User Entered the text as " + txt, LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
						} catch (NoSuchElementException e) {

							ATUReports.add("No element found ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
						} catch (WebDriverException e) {
							ATUReports.add("No driver found ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
						} finally {
							takeSnap();
						}
					}

				 //==============================================================================
				 
				 public void sendtextbyxvaluewihtoutclear(String xva, String txt) {
						try {
							//driver.findElementByXPath(xva).clear();
							driver.findElementByXPath(xva).sendKeys(txt);

							ATUReports.add(" User Entered the text as " + txt, LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
						} catch (NoSuchElementException e) {

							ATUReports.add("No element found ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
						} catch (WebDriverException e) {
							ATUReports.add("No driver found ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
						} finally {
							takeSnap();
						}
					}
				 
				 
				 //=================================================================================
				 
				 //sendtextvalueby css
				 
				 public void sendtextbycssselecotrwithoutclear(String xva, String txt) {
						try {
							//driver.findElementByCssSelector(xva).clear();

							driver.findElementByCssSelector(xva).sendKeys(txt);
							// driver.findElementByCssSelector(xva).sendKeys(txt);

							ATUReports.add(" User Entered the text as " + txt, LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
						} catch (NoSuchElementException e) {

							ATUReports.add("No element found ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
						} catch (WebDriverException e) {
							//ATUReports.add("No driver found ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
						} finally {
							takeSnap();
						}
					}

				 
				 
				 //===================================================================================
				 
				 //======================================================================================
				 
				 //set attrinut values
				 


				 public void setattributeusingxpath(String xva,String txt) {
						try {
							//driver.findElementByXPath(xva).clear();
				
							//driver.findElementById(id).sendKeys(Keys.ARROW_DOWN);
							//driver.findElementsByXPath(xva).sendKeys(Keys.NUMPAD5);
							
						ATUReports.add(" User Entered the text as " + txt, LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
						} catch (NoSuchElementException e) {

							ATUReports.add("No element found ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
						} catch (WebDriverException e) {
							ATUReports.add("No driver found ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
						} finally {
							takeSnap();
						}
					}


				 
				 //================================================================================
			 
				 //Browser zoo in
				 
				 public void Zooin()
				 {
					 WebElement html = driver.findElement(By.tagName("html"));
					 html.sendKeys(Keys.chord(Keys.CONTROL, Keys.ADD));

				 }

				 
				 //Zoomout
				 
				 public void Zooout()
				 {
					 WebElement html = driver.findElement(By.tagName("html"));
					 html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));

				 }

				 
				 //======================================================
				 
				 
				 
	//
					//Listbyenter by css selector
					
					public void Listandenterbycss(String css,String value) throws InterruptedException
					  {
					    try 
						{
					    	int j1=0;
					    	Thread.sleep(1000);
					    List<WebElement> list = driver.findElements(By.cssSelector(css));
					    		
					    Thread.sleep(1000);
					    System.out.println("List Size is"+ +list.size());
					    Thread.sleep(1000);
					    //list.get(j1).click();
					    int foo = Integer.parseInt(value);
					    Thread.sleep(1000);
					    
					   list.get(foo).click();

		               // driver.findElementByXPath(xpath1).sendKeys(Keys.ENTER);

					     Thread.sleep(600);
					    
					    //ATUReports.add("NotClicked ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					    }
					    catch (Exception e) {
					    System.out.println("error");
					    } finally {
					    takeSnap();
					    }

					    }  

					
					//======================================================================================================
					
					
					

					//Lis and prin the values
								
								public void Listandgettext(String xpath1) throws InterruptedException
								  {
								    try 
									{
								    	int j1=0;
								    	Thread.sleep(1000);
								    List<WebElement> list = driver.findElements(By.xpath(xpath1));    
								    Thread.sleep(200);
								    System.out.println("List Size is"+ +list.size());
								    String jobid = list.get(0).getText();
								    /*
								    Thread.sleep(200);
								    //list.get(j1).click();
								    int foo = Integer.parseInt(value);
								    Thread.sleep(100);
								    
								   list.get(foo).getText();
*/
								   ATUReports.add("Record number" + "" , jobid, LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
								   
					               // driver.findElementByXPath(xpath1).sendKeys(Keys.ENTER);

								     Thread.sleep(100);
								    
								   // ATUReports.add("value not captured  ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
								    }
								    catch (Exception e) {
								    System.out.println("error");
								    } finally {
								    takeSnap();
								    }

								    }  


					
					//===========================================================================================

				 
								
					//=============================================================
				 
								public void UIvalidationtestingusingxpath(String xpt1,String expectedTooltip,String usermessage,String usermessage1) 
								{

										try {
											
											
											//WebElement github = driver.findElement(By.xpath(xpt1));
											String actualTooltip = driver.findElementByXPath(xpt1).getText();

																							
											if(actualTooltip.equals(expectedTooltip))
											{							
									            System.out.println("Test Case Passed");		
									            ATUReports.add(usermessage, LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
												
									        }
												} catch (NoSuchElementException e) {

										  ATUReports.add(usermessage1, LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
										} catch (WebDriverException e) {
											//ATUReports.add("No driver found ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
										} finally {
											takeSnap();
										}
									}
				 

								
								//============================================================================
								
								//UI validation using css selector 
								

								public void UIvalidationtestingusingcss(String csss,String expectedTooltip,String usermessage,String usermessage1) 
								{

										try {
											
											
											//WebElement github = driver.findElement(By.xpath(xpt1));
										//	String actualTooltip = driver.findElementByXPath(xpt1).getText();
											String actualTooltip = driver.findElementByCssSelector("csss").getText();

																							
											if(actualTooltip.equals(expectedTooltip))
											{							
									            System.out.println("Test Case Passed");		
									            ATUReports.add(usermessage, LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
												
									        }
												} catch (NoSuchElementException e) {

										  ATUReports.add(usermessage1, LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
										} catch (WebDriverException e) {
											//ATUReports.add("No driver found ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
										} finally {
											takeSnap();
										}
									}

								
								
								//=====================================================================
								
				//mouse move over the element
								
								public void Mousemoveover(String xpth) throws InterruptedException

								{

									try {
										Actions Builder = new Actions(driver);

										Builder.moveToElement(driver.findElementByXPath(xpth)).build().perform();

										Thread.sleep(1000);
										ATUReports.add("Mouse moved over to the Manage ", LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
										//driver.findElementByLinkText(lnk).click();
										//ATUReports.add("User clicked the " + "" + "link", LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
									} catch (NoSuchElementException e) {

										ATUReports.add("No element found ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
									} catch (WebDriverException e) {
										ATUReports.add("No driver found ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
									} finally {
										takeSnap();
									}
								}

								
								
		//===============================================================================
								
								
							
								public void findbyelementbyxpath(String xpath,String usermessage) 
								{

									try {

										if (driver.findElementByXPath(xpath).isDisplayed())
											
										ATUReports.add(usermessage, LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
										
										// ATUReports.add("ID element got clicked ", LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
									} catch (NoSuchElementException e) {

										ATUReports.add("No element found ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
									} catch (WebDriverException e) {
										ATUReports.add("No driver found ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
									} finally {
										takeSnap();
									}
								}

								//==================================================================================
//checking the Field enabled 
								

								public void Elementcheckingisenabledbyxpathpositivescenarios(String xpath,String usermessage,String usermessage1) 
								{

									try {

										if (driver.findElementByXPath(xpath).isDisplayed())
										{
											
										ATUReports.add(usermessage, LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
										}
										// ATUReports.add("ID element got clicked ", LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
									} catch (NoSuchElementException e) {

										ATUReports.add(usermessage1, LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
									} catch (WebDriverException e) {
										//ATUReports.add("No driver found ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
									} finally {
										takeSnap();
									}
								}

								
	//Clickin ghe filed enabled by css selecotr
								
								


								public void Elementcheckingisenabledbycsspositivescenarios(String css,String usermessage,String usermessage1) 
								{

									try {

										//if (driver.findElementByXPath(xpath).isDisplayed())
									  
										driver.findElementByCssSelector(css);												
											
										
											
										ATUReports.add(usermessage, LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
										
										// ATUReports.add("ID element got clicked ", LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
									} catch (NoSuchElementException e) {

										ATUReports.add(usermessage1, LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
									} catch (WebDriverException e) {
										//ATUReports.add("No driver found ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
									} finally {
										takeSnap();
									}
								}


								
	//==============================================================================
								
	//negative scenarios
								

								public void Elementcheckingisenabledbycssnegativescenarios(String css,String usermessage,String usermessage1) 
								{

									try {

										//if (driver.findElementByXPath(xpath).isDisplayed())
									  
										driver.findElementByCssSelector(css);												
											
										
											
										ATUReports.add(usermessage, LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
										
										// ATUReports.add("ID element got clicked ", LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
									} catch (NoSuchElementException e) {

										ATUReports.add(usermessage1, LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
									} catch (WebDriverException e) {
										//ATUReports.add("No driver found ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
									} finally {
										takeSnap();
									}
								}

								
 //==========================================================================================
								
								//===============================================================================================
//checking the field disabled 
								


								public void Elementcheckingisenabledbyxpathnegatoivescenarios(String xpath,String usermessage,String usermessage1) 
								{

									try {

										if (driver.findElementByXPath(xpath).isDisplayed())
										{

											ATUReports.add(usermessage, LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
										}
										// ATUReports.add("ID element got clicked ", LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
									} catch (NoSuchElementException e) {

										ATUReports.add(usermessage1, LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
									} catch (WebDriverException e) {
										//ATUReports.add("No driver found ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
									} finally {
										takeSnap();
									}
								}
								
								
								
//=====================================================================================
								
								//click by xapth by negative scenarios
								

								public void clickbyxpathnegativescenarios(String xpt1,String usermessage,String usermessage1) {

									try 
									{
										driver.findElementByXPath(xpt1).click();
									ATUReports.add(usermessage, LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
									
									} 
									catch (NoSuchElementException e)
									
									{

									ATUReports.add(usermessage1, LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
									} catch (WebDriverException e) {
										//ATUReports.add("No driver found ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
									} finally {
										takeSnap();
									}
								}
								
								
//==============================================================================================
								
	//wait for the element
								

								public void waituntillelementpresent(String xpt1)

								{
									WebDriverWait wait = new WebDriverWait(driver, 15);

								
									wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpt1)));

									
								}

								
								
//================================================================================================
							
//findelementbyxpath
								
								public void findbyelementbyxpathispresentandclick(String xpath) 
								{

									try {

										if (driver.findElementByXPath(xpath).isEnabled())

										{
											driver.findElementByXPath(xpath).click();
										
										
										ATUReports.add("Element found ", LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
										}
										
										else
										{
										//	ATUReports.add("No element found ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
										}

										// ATUReports.add("ID element got clicked ", LogAs.PASSED, new
										// CaptureScreen(ScreenshotOf.BROWSER_PAGE));
									} catch (NoSuchElementException e) {

										//ATUReports.add("No element found ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
									} 
									finally {
										takeSnap();
									}
								}

								
								
		//=============================================================================
				
								//Listandenter Double click
								

								public void Listandenterdoubleclick(String xpath1,String value) throws InterruptedException
								  {
								    try 
									{
								    	int j1=0;
								    	Thread.sleep(1000);
								    List<WebElement> list = driver.findElements(By.xpath(xpath1));    
								    Thread.sleep(1000);
								    System.out.println("List Size is"+ +list.size());
								    Thread.sleep(1000);
								    //list.get(j1).click();
								    int foo = Integer.parseInt(value);
								    Thread.sleep(1000);
								    
								   list.get(foo).click();
								   list.get(foo).click();
								   list.get(foo).click();
								   
								   

					               // driver.findElementByXPath(xpath1).sendKeys(Keys.ENTER);

								     Thread.sleep(600);
								    
								    //ATUReports.add("NotClicked ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
								    }
								    catch (Exception e) {
								    System.out.println("error");
								    } finally {
								    takeSnap();
								    }

								    }  
					
								
								
	
								
		//
								
	//==========================================================================
								

								public void doubleclickusingxpath(String xpt1) 
								{
									Actions actions = new Actions(driver);
									WebElement elementLocator = driver.findElement(By.xpath(xpt1));
									actions.doubleClick(elementLocator).perform();
								    ATUReports.add("Double click done",LogAs.INFO, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
									

								}

								
   //========================================================================
								
//====================================================================================================================
								

								public void checkingtextfieldisenablednegativescenarios(String xpt1,String Usermessage,String Usermessage1 ) {

									try {
										
										driver.findElementByXPath(xpt1).clear();
										
										ATUReports.add(Usermessage1, LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
									} catch (NoSuchElementException e) {

									ATUReports.add(Usermessage , LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
									} catch (WebDriverException e) {
										ATUReports.add(Usermessage, LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
									} finally {
										takeSnap();
									}
								}

								
//=======================================================================================================


								public void checkingtextfieldisenabledpositivescenarios(String xpt1,String Usermessage,String Usermessage1 ) {

									try {
										
										driver.findElementByXPath(xpt1).clear();
										
										ATUReports.add(Usermessage1, LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
									} catch (NoSuchElementException e) {

									ATUReports.add(Usermessage , LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
									} catch (WebDriverException e) {
										ATUReports.add(Usermessage, LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
									} finally {
										takeSnap();
									}
								}

								

//=========================================================================================

								public void xpathindexclicking(String xpt1,String Usermessage,String Usermessage1 ) {

									try {
										

										List<WebElement> list = driver.findElements(By.xpath(xpt1));

										System.out.println("Totla list size"+list.size());
										for(i=0;i<=list.size();i++)
										//for(i=0;i<1000;i++)
												
										{
											//int n=Integer.parseInt(i);  

											System.out.println(list.get(i));
											
											list.get(i).click();
											
											//list.get(i).click();
											
										}

										//driver.findElementByXPath(xpt1).clear();
										
										ATUReports.add(Usermessage1, LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
									} catch (NoSuchElementException e) {

									//ATUReports.add(Usermessage , LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
							
									} catch (WebDriverException e) {
										//ATUReports.add(Usermessage, LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
									} finally {
										takeSnap();
									}
								}

								
//==============================================================


//================================================================================================


								public void xpathindexdoubleclicking(String xpt1,String Usermessage,String Usermessage1 ) {

									try {
										

										List<WebElement> list = driver.findElements(By.xpath(xpt1));

										System.out.println("Totla list size"+list.size());
										for(i=0;i<=list.size();i++)
										//for(i=0;i<1000;i++)
												
										{
											System.out.println(list.get(i));
											list.get(i).click();
											list.get(i).click();
											list.get(i).click();
											
											
										}

										//driver.findElementByXPath(xpt1).clear();
										
										ATUReports.add(Usermessage1, LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
									} catch (NoSuchElementException e) {

									//ATUReports.add(Usermessage , LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
							
									} catch (WebDriverException e) {
										//ATUReports.add(Usermessage, LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
									} finally {
										takeSnap();
									}
								}

								

								
								
//=============================================================================
//=============================================================================================================

								public void Checkboxselectionsbyloop(String xpath1,String numberofcount) throws InterruptedException
								  {
								    try 
									{
								   
								    	int k=0,i=0;     
								    	
								        List<WebElement> list = driver.findElements(By.xpath(xpath1));

								        
								        System.out.println("Totla list size"+list.size());


								        int n=Integer.parseInt(numberofcount);  

								        //for(i=0;i<list.size();i++)
								        for(i=0;i<n;i++)
										        	
								        {

								        list.get(i).click();



								        Thread.sleep(500);

								      }
					               			    }
								    catch (Exception e) {
								    System.out.println("error");
								    } finally {
								    takeSnap();
								    }

								    }  
								
		//===============================================================================
								
								
			//capturing text in textboxes
								
		

								 public void capturetextfrommsgbox(String xpath,String usermessage)
								 {
									 String jobid = driver.findElementByXPath(xpath).getText().trim();
									 
									 
									String str[] = jobid.split("\\n");
									 
									System.out.println(str);
									
									 List<String> al = new ArrayList<String>();
									
									 //System.out.println(s1);
										
									 al = Arrays.asList(str);

									 System.out.println("value of a1"+al);
									 
										
										
									// System.out.println("The calue are applicaiton"  a1);
									 
									 
									 for(String s: al)
									 {
										 System.out.println("The calue are applicaiton"+ s);
										 
										// System.out.println("The calue are applicaiton"+ s1);
										 	
										//if(s.matches(excelvalues))
												 

											// if(s.matches(jobid1))
										 ATUReports.add( usermessage + s , ""+ s, LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
										 	
											 
											 
										
											}
									 
								 
									 
									//	ATUReports.add("Message not capture" , LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
												 
									 
								 }
								 
								 			 
//=======================================================================================


									
									//capturing text in textboxes
														
								

														 public void capturetextfrommsgboxuisngcssselector(String xpath,String usermessage)
														 {
															 //String jobid = driver.findElementByXPath(xpath).getText().trim();
															 String jobid = driver.findElementByCssSelector(xpath).getText().trim();
																 
															 
															String str[] = jobid.split("\\n");
															 
															System.out.println(str);
															
															 List<String> al = new ArrayList<String>();
															
															 //System.out.println(s1);
																
															 al = Arrays.asList(str);

															 System.out.println("value of a1"+al);
															 
																
																
															// System.out.println("The calue are applicaiton"  a1);
															 
															 
															 for(String s: al)
															 {
																 System.out.println("The calue are applicaiton"+ s);
																 
																// System.out.println("The calue are applicaiton"+ s1);
																 	
																//if(s.matches(excelvalues))
																		 

																	// if(s.matches(jobid1))
																 ATUReports.add( usermessage + s , ""+ s, LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
																 	
																	 
																	 
																 {
																	 
																	// ATUReports.add( usermessage + s , ""+ "", LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
												 
												                      //break;
																 
																 }
																 
																	/*else
																	
																		ATUReports.add(usermessage , LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
															*/
																	}

																   //System.out.println(s);
																
															 
														 
															 
																//ATUReports.add(usermessage , LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
																		 
															 
														 }
														 

								 
//======================================================================================================
								 
								 
	//Double value calculations
							

									public void Commissioncalc(String xpcm,String xptotaltax,String Tds,String Totalamount) throws InterruptedException
									{
										
											try
											{
										//  String jobid = driver.findElementByXPath(xpath).getText().trim();
												//commison local amount
											WebElement  elt = driver.findElement(By.xpath(xpcm));
											Thread.sleep(500);
											//Double Commission = new Double(elt.getAttribute("value").trim());
											Double Commission = new Double(elt.getText().trim());
											

											// Total Tax
											WebElement elt1 = driver.findElement(By.xpath(xptotaltax));
											Thread.sleep(500);
											//Double tax = new Double(elt1.getAttribute("value").trim());
											Double tax = new Double(elt1.getText().trim());

											//TDS
											WebElement elt2 = driver.findElement(By.xpath(Tds));
											Thread.sleep(500);
											//Double TDS = new Double(elt2.getAttribute("value").trim());
											Double TDS = new Double(elt2.getText().trim());

											//Total amount 
											WebElement elt3 = driver.findElement(By.xpath(Totalamount));
											Thread.sleep(500);
											//Double Totalamountt = new Double(elt2.getAttribute("value").trim());
											Double Totalamountt = new Double(elt3.getText().trim());
											
											Double Expecedamount = Commission + tax + TDS;
																					

											System.out.print("the value of d is" + Totalamountt);
											System.out.print("the value of d is" + Expecedamount);
																					
										
											if(Totalamountt==Totalamountt)
											{		
												ATUReports.add("matching Done successfully" + Totalamountt, LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
											}
											else
											{
												ATUReports.add("nmatching Not Done successfully " + Totalamountt, LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
											}		
											}
											catch(Exception e)
											{
												System.out.print("error message"+e);
											}
									}

								
//===================================================================================================================
									
									public void stabbyxpathandsendvalues(String xpath,String input) {
										try {

											// driver.findElementById(id).sendKeys(Keys.TAB);

											driver.findElementByXPath(xpath).sendKeys(Keys.TAB);
											driver.findElementByXPath(xpath).sendKeys(input);

											ATUReports.add("TAb Action Done", LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
										}

										catch (WebDriverException e) {
											//ATUReports.add("Tab Action not Done ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
										} finally {
											takeSnap();
										}
									}

									
//=====================================================================================================================
									
	//============================================================

									public void Listandentersend(String xpath1,String excelvalues,String value) throws InterruptedException
									  {
									    try 
										{
									    	int j1=0;
									    	Thread.sleep(1000);
									    List<WebElement> list = driver.findElements(By.xpath(xpath1));    
									    Thread.sleep(200);
									    System.out.println("List Size is"+ +list.size());
									    Thread.sleep(200);
									    //list.get(j1).click();
									    int foo = Integer.parseInt(value);
									    Thread.sleep(100);
									    
									   //list.get(foo).click();
									   list.get(foo).sendKeys(excelvalues);
									   
									   
						               // driver.findElementByXPath(xpath1).sendKeys(Keys.ENTER);
									     Thread.sleep(100);
									    //ATUReports.add("NotClicked ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
									    }
									    catch (Exception e) {
									    System.out.println("error");
									    } finally {
									    takeSnap();
									    }
									    }			
	//================================================================================================
									

									public void Listnegativescearios(String xpath1,String value,String Positivemessages,String Negativemessages) throws InterruptedException
								  {
								    try 
									{
								    	int j1=0;
								    	Thread.sleep(200);
								    List<WebElement> list = driver.findElements(By.xpath(xpath1));    
								    Thread.sleep(90);
								    System.out.println("List Size is"+ +list.size());
								    String  gtxt = driver.findElementByXPath(xpath1).getText();	
								    Thread.sleep(90);
								    int foo = Integer.parseInt(value);
								    Thread.sleep(90);
								   list.get(foo).click();
					               ATUReports.add(Positivemessages, gtxt, LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
								  //  Thread.sleep(100);
								  
								    }			    
								    
								    catch (NoSuchElementException e) 
								    {
								    	ATUReports.add(Negativemessages, LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
										} 
								    catch (Exception e) {
								    	ATUReports.add(Negativemessages, LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
								    }
								   
								    finally 
								    {
								    takeSnap();
								    }
								    }				
									
									
									
  //==================================================================================================


									public void Listnegativesceariosnegativecaseschecking(String xpath1
											,String value,String Positivemessages,String Negativemessages) throws InterruptedException
									  {
									    try 
										{
									    	int j1=0;
									    	Thread.sleep(300);
									    List<WebElement> list = driver.findElements(By.xpath(xpath1));    
									    Thread.sleep(200);
									    System.out.println("List Size is"+ +list.size());
									    String  gtxt = driver.findElementByXPath(xpath1).getText();	
									    Thread.sleep(200);
									    int foo = Integer.parseInt(value);
									    Thread.sleep(100);
									   list.get(foo).click();
						               ATUReports.add(Negativemessages, gtxt, LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
									     Thread.sleep(100);
									  
									    }			    
									    
									    catch (NoSuchElementException e) 
									    {
									    	ATUReports.add(Positivemessages, LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
											} 
									    catch (Exception e) {
									    	ATUReports.add(Positivemessages, LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
									    }
									   
									    finally 
									    {
									    takeSnap();
									    }
									    }				
										

									
//==================================================================================================================================

									public void Textallowed(String xpath1,String Positivemessages,String Negativemessages ) throws InterruptedException
								  {
								    try 
									{
								    	
								    	WebElement inputBox = driver.findElement(By.xpath(xpath1));
								    	String textInsideInputBox = inputBox.getAttribute("value");
								    	System.out.println("capturemessage as " + textInsideInputBox);
								    
								    	int size = textInsideInputBox.length();
								    	System.out.println("size as " + size);
								    	if(size<16)
								    	{
								   
								          ATUReports.add(Positivemessages, LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
								    	}
								    	
								    		else
								    		{
								    			 ATUReports.add(Negativemessages, LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
											       		
									    			
								    	}
									    
									}
								    catch (WebDriverException e) {
								    	ATUReports.add("", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
								    } finally {
								    takeSnap();
								    }
								    }			

									
//==============================================================================================================================
					

									public void Verifythedropdownvalues(String xpath,String Positivemessage,String Negativemessages) 
									{

										try {

											if (driver.findElementByXPath(xpath).isDisplayed())
												
												//driver.findElementByXPath(xpath).click();
											
											ATUReports.add(Positivemessage, LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
											
											// ATUReports.add("ID element got clicked ", LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
										} catch (NoSuchElementException e) {

											ATUReports.add(Negativemessages, LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
										} catch (WebDriverException e) {
											ATUReports.add(Negativemessages, LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
										} finally {
											takeSnap();
										}
									}
//=====================================================================================================
	//Verify the Alert popup messages  using equal

									public void Verifythealertpopupmessages(String xpath,String Verifymessages,
											String Positivemessage,String Negativemessages)
									{

										try 
										{
											Thread.sleep(1000);
											String  gtxt = driver.findElementByXPath(xpath).getText();											
											System.out.println(gtxt);

											if (gtxt.equals(Verifymessages)) 

//											{
											ATUReports.add(Positivemessage, LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
										  
										else
											ATUReports.add(Negativemessages, LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
												
											
											} 
										catch (NoSuchElementException e) {

											//ATUReports.add(Negativemessages, LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
										} catch (WebDriverException e) {
											//ATUReports.add(Negativemessages, LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
										} catch (Exception e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										} 
										finally {
											takeSnap();
										}
									}
									
									
//===================================================================================================
									
									public void Verifythealertpopupmessagesnegativescenarios(String xpath,
											String Verifymessages,
											String Positivemessage,String Negativemessages)
									{

										try 
										{
											Thread.sleep(1000);
											String  gtxt = driver.findElementByXPath(xpath).getText();											
											System.out.println(gtxt);
											System.out.println(Verifymessages);
											

											if (gtxt.equals(Verifymessages)) 

//											{
											ATUReports.add(Negativemessages, LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
										  
										else
											ATUReports.add(Positivemessage, LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
												
											
											} 
										catch (NoSuchElementException e) {

											//ATUReports.add(Negativemessages, LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
										} catch (WebDriverException e) {
											//ATUReports.add(Negativemessages, LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
										} catch (Exception e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										} 
										finally {
											takeSnap();
										}
									}
									

									
//==============================================================================================

									//Verify the Alert popup messages  using Contains

									public void Verifythealertpopupmessagesusincontains(String xpath,String Verifymessages,
											String Positivemessage,String Negativemessages)
									{

										try 
										{
											Thread.sleep(1000);
											String  gtxt = driver.findElementByXPath(xpath).getText();											
											System.out.println("gtxt"+gtxt);
											System.out.println("Verifymessages"+Verifymessages);
											

											if (gtxt.contains(Verifymessages))													

//											{
											ATUReports.add(Positivemessage, LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
										  
										else
											ATUReports.add(Negativemessages, LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
												
											
											} 
										catch (NoSuchElementException e) {

											//ATUReports.add(Negativemessages, LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
										} catch (WebDriverException e) {
											//ATUReports.add(Negativemessages, LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
										} catch (Exception e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										} 
										finally {
											takeSnap();
										}
									}
									
	//==========================================================================================================

									public void Checkingtextboxcontainstextornumeric(String xpath,String telephonefield,
											String Positivemessage,String Negativemessages)
									{
									
										String  s = driver.findElementByXPath(xpath).getText();
										//String s = telephonefield;
										
										//String str = "Tutorials123";
										System.out.println(s);
										
										System.out.println(s.length());
										
										String numRegex   = ".*[0-9].*";
										String alphaRegex = ".*[A-Z].*";

										if (s.matches(alphaRegex)) 
									         {
									            //System.out.println("'"+ str.charAt(i)+"' is a number");
									            ATUReports.add(Positivemessage, LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
												 
									         }
									         else {
									         //   System.out.println("'"+ str.charAt(i)+"' is a letter");
									            ATUReports.add(Negativemessages, LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
									        	
									         }
									      }
																			
									
									
									
																		
//===================================================================================================================

//delete thedefault valuesin the textbox

									public void Deletedefaultvaluesinthetextbox(String xpt1) 
									{
																		
										WebElement toClear = driver.findElementByXPath(xpt1);
										toClear.sendKeys(Keys.CONTROL + "a");
										toClear.sendKeys(Keys.DELETE);

									
									}


//==================================================================================================================
									
//select all by xapth
									
									public void Selectallbyxpath(String xpt1) 
									{
																		
										WebElement toClear = driver.findElementByXPath(xpt1);
										toClear.sendKeys(Keys.CONTROL + "a");
																
									}
									
//===================================================================================================
									
//select all by CSs
									
									public void Selectallbycsspath(String Css1) 
									{
																		
										WebElement toClear = driver.findElementByCssSelector(Css1);
										toClear.sendKeys(Keys.CONTROL + "a");
																
									}
									
									
	//==========================================================================================

		public void Checktextcount(String xpt1,String Positivemessage,String negativemessage) 
									{
									
									 String  gtxt = driver.findElementByXPath(xpt1).getText();	
									final int tick = gtxt.length();
									if(tick>10)
									{
										ATUReports.add(Positivemessage, LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
									}
									else
									{
										ATUReports.add(negativemessage, LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
											
										
										} 
								
									}

									

//=============================================================================================================================

	//

									public void Verifythealertpopupmessagesusincontainsusinggetattribute(String xpath,String Verifymessages,
											String Positivemessage,String Negativemessages)
									{

										try 
										{
											Thread.sleep(1000);
											String  gtxt = driver.findElementByXPath(xpath).getAttribute("value");										
											//System.out.println(gtxt);

											String gtxt1=gtxt.toString();
											String gtxt2 =Verifymessages.toString();
											
											
											System.out.println(gtxt1);
											System.out.println(gtxt2);
										
											if (gtxt2.contains(gtxt1))																			

//											{
											ATUReports.add(Positivemessage, LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
										  
										else
											ATUReports.add(Negativemessages, LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
												
											
											} 
										catch (NoSuchElementException e) {

											//ATUReports.add(Negativemessages, LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
										} catch (WebDriverException e) {
											//ATUReports.add(Negativemessages, LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
										} catch (Exception e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										} 
										finally {
											takeSnap();
										}
									}

									
									
									
//=========================================================================================

									public void Verifythealertpopupmessagesusincontainsusinggetattributenegative(String xpath,
											String Verifymessages,String Positivemessage,String Negativemessages)
									{

										try 
										{
											Thread.sleep(1000);
											String  gtxt = driver.findElementByXPath(xpath).getAttribute("value");										
											//System.out.println(gtxt);

											String gtxt1=gtxt.toString();
											String gtxt2 =Verifymessages.toString();
											
											System.out.println(gtxt1);
											System.out.println(gtxt2);
										
											if (gtxt2.contains(gtxt1))													

//											{
											ATUReports.add(Negativemessages, LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
										  
										else
											ATUReports.add(Positivemessage, LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
												
											
											} 
										catch (NoSuchElementException e) {

											//ATUReports.add(Negativemessages, LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
										} catch (WebDriverException e) {
											//ATUReports.add(Negativemessages, LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
										} catch (Exception e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										} 
										finally {
											takeSnap();
										}
									}

									
//=========================================================================================================================
									

									public void Verifythealertpopupmessagesnotequal(String xpath,String Verifymessages,
											String Positivemessage,String Negativemessages)
									{

										try 
										{
											Thread.sleep(1000);
											String  gtxt = driver.findElementByXPath(xpath).getAttribute("value");										
											//System.out.println(gtxt);

											String gtxt1=gtxt.toString();
											String gtxt2 =Verifymessages.toString();
											
											System.out.println(gtxt1);
											System.out.println(gtxt2);
										
											//if (gtxt2.contains(gtxt1))		
												if (gtxt2!=	gtxt1)	

//											{
											ATUReports.add(Positivemessage, LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
										  
										else
											ATUReports.add(Negativemessages, LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
												
											
											} 
										catch (NoSuchElementException e) {

											//ATUReports.add(Negativemessages, LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
										} catch (WebDriverException e) {
											//ATUReports.add(Negativemessages, LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
										} catch (Exception e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										} 
										finally {
											takeSnap();
										}
									}

//==========================================================================================================
									


									public void Verifythealertpopupmessagesequal(String xpath,String Verifymessages,
											String Positivemessage,String Negativemessages)
									{

										try 
										{
											Thread.sleep(1000);
											String  gtxt = driver.findElementByXPath(xpath).getAttribute("value");										
											//System.out.println(gtxt);

											String gtxt1=gtxt.toString();
											String gtxt2 =Verifymessages.toString();
											
											System.out.println(gtxt1);
											System.out.println(gtxt2);
										
											//if (gtxt2.contains(gtxt1))		
												
													if (gtxt2.contentEquals(gtxt1))
//											{
											ATUReports.add(Positivemessage, LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
										  
										else
											ATUReports.add(Negativemessages, LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
												
											
											} 
										catch (NoSuchElementException e) {

											//ATUReports.add(Negativemessages, LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
										} catch (WebDriverException e) {
											//ATUReports.add(Negativemessages, LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
										} catch (Exception e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										} 
										finally {
											takeSnap();
										}
									}

									
									
//=========================================================================================================================
									
									public void comparetwovaluesandsubract(String xpath1,String xpath2,String xpath3,String Positivemessages,
											String Negativemessages) throws InterruptedException
								    {
								    try 
								    {

								    WebElement elt1 = driver.findElement(By.xpath(xpath1));
									WebElement elt2 = driver.findElement(By.xpath(xpath2));
									WebElement elt3 = driver.findElement(By.xpath(xpath3));

								    Thread.sleep(500);

								    Double d1 = new Double(elt1.getAttribute("value").trim());
									Double d2 = new Double(elt2.getAttribute("value").trim());
									Double d3 = new Double(elt3.getAttribute("value").trim());

								    Thread.sleep(500);
								    System.out.print("\n the value of d1 is" + d1);
								    System.out.print("\n the value of d2 is" + d2);
								    System.out.print("\n the value of d3 is" + d3);

									Double d4 = d1-d2;
									System.out.print("the value of d is" + d4);

									System.out.print("the string value of d is" + d4.toString());

									//int d5 =  d4.compareTo(d3);

									
								   // if(d3.equals(d4))

									    if(d3.equals(d4))
								    {
								    ATUReports.add(Positivemessages, LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
								    }
								    else
								    {
								    ATUReports.add(Negativemessages, LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
									    	
								    }
								    }
									catch (NoSuchElementException e)
									{

								    ATUReports.add("NotClicked ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
								    } catch (Exception e) {
								    System.out.println("error");
								    } finally {
								    takeSnap();
								    }

								    }       


//===================================================================================================
									
									
									public void comparetwovalues1to1(String xpath1,String xpath2,String Positivemessages,
											String Negativemessages) throws InterruptedException
								    {
								    try 
								    {

								    WebElement elt1 = driver.findElement(By.xpath(xpath1));
									WebElement elt2 = driver.findElement(By.xpath(xpath2));
									

								    Thread.sleep(500);

								    Double d6 = new Double(elt1.getAttribute("value").trim());
									Double d7 = new Double(elt2.getAttribute("value").trim());
									

								    Thread.sleep(500);
								    System.out.print("\n the value of d6 is" + d6);
								    System.out.print("\n the value of d7 is" + d7);
								   
									    if(d6.equals(d7))
								    {
								    ATUReports.add(Positivemessages, LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
								    }
								    else
								    {
								    ATUReports.add(Negativemessages, LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
									    	
								    }
								    }
									catch (NoSuchElementException e)
									{

								    ATUReports.add("NotClicked ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
								    } catch (Exception e) {
								    System.out.println("error");
								    } finally {
								    takeSnap();
								    }

								    }       



//==========================================================================================================
//compare two to one
									
									public void comparetwovalues2to1(String xpath1,String xpath2,String xpath3,
											String Positivemessages,String Negativemessages) throws InterruptedException
								    {
								    try 
								    {

								    WebElement elt1 = driver.findElement(By.xpath(xpath1));
									WebElement elt2 = driver.findElement(By.xpath(xpath2));
									WebElement elt3 = driver.findElement(By.xpath(xpath2));
									

								    Thread.sleep(500);

								    Double d1 = new Double(elt1.getAttribute("value").trim()); //commiosn 1
									Double d2 = new Double(elt2.getAttribute("value").trim());  //commison2
									Double d3 = new Double(elt3.getAttribute("value").trim()); //total amount of commision
									
									Double d4 = d1 +d2;
									
									

								    Thread.sleep(500);
								    System.out.print("\n the value of d1 is" + d1);
								    System.out.print("\n the value of d2 is" + d2);
								    System.out.print("\n the value of d1 is" + d3);
								    System.out.print("\n the value of d2 is" + d4);								   
									if(d4.equals(d3))
								    {
								    ATUReports.add(Positivemessages, LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
								    }
								    else
								    {
								    ATUReports.add(Negativemessages, LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
									    	
								    }
								    }
									catch (NoSuchElementException e)
									{

								    ATUReports.add("NotClicked ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
								    } catch (Exception e) {
								    System.out.println("error");
								    } finally {
								    takeSnap();
								    }

								    }       

//================================================================================================
	//Net payable amount
									
									public void comparetwovaluesadd2sub1(String xpath1,String xpath2,String xpath3,String xpath4,
											String Positivemessages,String Negativemessages) throws InterruptedException
								    {
								    try 
								    {

								    WebElement elt11 = driver.findElement(By.xpath(xpath1));
									WebElement elt12 = driver.findElement(By.xpath(xpath2));
									WebElement elt13 = driver.findElement(By.xpath(xpath3));
									WebElement elt14 = driver.findElement(By.xpath(xpath4));
									

								    Thread.sleep(500);

								    Double d11 = new Double(elt11.getAttribute("value").trim()); //seeling fare
									Double d12 = new Double(elt12.getAttribute("value").trim());  //total tax
									Double d13 = new Double(elt13.getAttribute("value").trim()); //commissionamount
									Double d14 = new Double(elt14.getAttribute("value").trim()); //totalpayable
									
									Double d15 = d11 +d12-d13;
									
									

								    Thread.sleep(500);
								    System.out.print("\n the value of d11 is" + d11);//seeling fare
								    System.out.print("\n the value of d12 is" + d12); //
								    System.out.print("\n the value of d13 is" + d13);
								    System.out.print("\n the value of d14 is" + d14);	
									System.out.print("\n the value of d15 is" + d15);	
									
									if(d15.equals(d14))
								    {
								    ATUReports.add(Positivemessages, LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
								    }
								    else
								    {
								    ATUReports.add(Negativemessages, LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
									    	
								    }
								    }
									catch (NoSuchElementException e)
									{

								    ATUReports.add("NotClicked ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
								    } catch (Exception e) {
								    System.out.println("error");
								    } finally {
								    takeSnap();
								    }

								    }       


//====================================================================================================
									
									
									public void multipleandcompare(String xpath1,String xpath2,
											String xpath3,String xpath4,
											String Positivemessages,
											String Negativemessages) throws InterruptedException
								    {
								    try 
								    {

								    WebElement R1 = driver.findElement(By.xpath(xpath1)); //no of days
									WebElement R2 = driver.findElement(By.xpath(xpath2)); //no of units
									WebElement R3 = driver.findElement(By.xpath(xpath3)); //car rate
									WebElement R4 = driver.findElement(By.xpath(xpath4));  //totalratee
									

								    Thread.sleep(500);

								    Double d20 = new Double(R1.getAttribute("value").trim());
									Double d21 = new Double(R2.getAttribute("value").trim());
									Double d22 = new Double(R3.getAttribute("value").trim());
									
									Double d23 = new Double(R4.getAttribute("value").trim());
									
									Double d24=d20*d21*d22;
									
									
									
									

									
								    Thread.sleep(500);
								    System.out.print("\n the value of d6 is" + d20);
								    System.out.print("\n the value of d7 is" + d21);
								    System.out.print("\n the value of d7 is" + d22);
								    
								   
									    if(d23.equals(d24))
								    {
								    ATUReports.add(Positivemessages, LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
								    }
								    else
								    {
								    ATUReports.add(Negativemessages, LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
									    	
								    }
								    }
									catch (NoSuchElementException e)
									{

								    ATUReports.add("NotClicked ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
								    } catch (Exception e) {
								    System.out.println("error");
								    } finally {
								    takeSnap();
								    }

								    }       
									
									

//============================================================================================================


									public void multipletwovaluesandcompare(String xpath1,String xpath2,
											String xpath3,String Positivemessages,
											String Negativemessages) throws InterruptedException
								    {
								    try 
								    {

								    WebElement R11 = driver.findElement(By.xpath(xpath1)); //no of days
									WebElement R12 = driver.findElement(By.xpath(xpath2)); //no of units
									WebElement R13 = driver.findElement(By.xpath(xpath3)); //car rate
									

								    Thread.sleep(500);

								    Double d30 = new Double(R11.getAttribute("value").trim());
									Double d31 = new Double(R12.getAttribute("value").trim());
									Double d32 = new Double(R13.getAttribute("value").trim());
									
									Double d33=d30*d31;
																
															

									
								    Thread.sleep(500);
								    System.out.print("\n the value of d6 is" + d30);
								    System.out.print("\n the value of d7 is" + d31);
								    System.out.print("\n the value of d7 is" + d32);
								    
								   
									    if(d33.equals(d32))
								    {
								    ATUReports.add(Positivemessages, LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
								    }
								    else
								    {
								    ATUReports.add(Negativemessages, LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
									    	
								    }
								    }
									catch (NoSuchElementException e)
									{

								    ATUReports.add("NotClicked ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
								    } catch (Exception e) {
								    System.out.println("error");
								    } finally {
								    takeSnap();
								    }

								    }       
									

									
									
//==================================================================================================
									public void findelementandsendtextbycss(String Css, String txt) {
										try {
											
										if (driver.findElementByCssSelector(Css).isEnabled())
											//if (driver.findElementByCssSelector(Css).isDisplayed())
												
								                 {
											//driver.findElementByCssSelector(Css).clear();
											driver.findElementByCssSelector(Css).sendKeys(txt);
											

											ATUReports.add(" User Entered the text as " + txt, LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
											}
										} catch (NoSuchElementException e) {

											//ATUReports.add("No element found ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
										} catch (WebDriverException e) {
										//	ATUReports.add("No driver found ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
										} finally {
											takeSnap();
										}
									}

									
//==============================================================================================================

									public void Sendtextwhenduplicateproperty(String xpt1,String index,String text) 
									{
										
										List<WebElement> textfields = driver.findElements(By.xpath(xpt1));
										System.out.println("LIST size is" +textfields.size());
										int i=Integer.parseInt(index);  
										textfields.get(i).sendKeys(text);
									
									}

									
//======================================================================================================
									
	//Net collection calculted :
									

									public void Netcollections(String Publishedfare,
											String tax,String Servicefee,String Discount,String Outvat,String Systemnetcollections,
											String Positivemessages,String Negativemessages) throws InterruptedException
								    {
								    try 
								    {

								    WebElement Publishedfare1 = driver.findElement(By.xpath(Publishedfare)); 
									WebElement tax1 = driver.findElement(By.xpath(tax));
									WebElement Servicefee1 = driver.findElement(By.xpath(Servicefee));
									WebElement Discount1 = driver.findElement(By.xpath(Discount));
									WebElement Outvat1 = driver.findElement(By.xpath(Outvat));
									WebElement Systemnetcollections1 = driver.findElement(By.xpath(Systemnetcollections));
									
									
									

								    Thread.sleep(500);

								    Double Publishedfare2 = new Double(Publishedfare1.getAttribute("value").trim());
									Double tax2 = new Double(tax1.getAttribute("value").trim());
									Double Servicefee2 = new Double(Servicefee1.getAttribute("value").trim());
									Double Discount2 = new Double(Discount1.getAttribute("value").trim());
									Double Outvat2 = new Double(Outvat1.getAttribute("value").trim());
									Double Systemnetcollections2 = new Double(Systemnetcollections1.getAttribute("value").trim());
											
								//	Double d33=d30*d31;
																
								//Sales net collections : publish fare -ORC + TAX + Service fee -Discount +outvat 

									Double Netcollectionscalc = Publishedfare2 + tax2 + Servicefee2 - Discount2 + Outvat2;
				

									
								    Thread.sleep(500);
								    System.out.print("\n the value of Publishedfare2 is" + Publishedfare2);
								    System.out.print("\n the value of tax2 is" + tax2);
								    System.out.print("\n the value of Servicefee2 is" + Servicefee2);
								    System.out.print("\n the value of Discount2 is" + Discount2);
								    System.out.print("\n the value of Outvat2 is" + Outvat2);
								    System.out.print("\n the value of Systemnetcollections2 is" + Systemnetcollections2);

								    System.out.print("\n the value of Netcollectionscalc is" + Netcollectionscalc);
								    
								   
									    if(Netcollectionscalc.equals(Systemnetcollections2))
									    	
								    {
								    ATUReports.add(Positivemessages, LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
								    }
								    else
								    {
								    ATUReports.add(Negativemessages, LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
									    	
								    }
								    }
									catch (NoSuchElementException e)
									{

								    ATUReports.add("NotClicked ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
								    } catch (Exception e) {
								    System.out.println("error");
								    } finally {
								    takeSnap();
								    }

								    }       


									
//=======================================================================================================
									
//Netcollectionwithcacellationcharges
									
									public void Netcollectionuisngcancellatiocharges(String Publishedfare,
											String tax,String Servicefee,String Discount,String Outvat,
											String Systemnetcollections,String agentcancellatiocharges,
											String airlinecancelaltioncharges,
											String Positivemessages,String Negativemessages	) throws InterruptedException
								    {
								    try 
								    {

								    WebElement Publishedfare1 = driver.findElement(By.xpath(Publishedfare)); 
								    								    
									WebElement tax1 = driver.findElement(By.xpath(tax));
									WebElement Servicefee1 = driver.findElement(By.xpath(Servicefee));
									WebElement Discount1 = driver.findElement(By.xpath(Discount));
									WebElement Outvat1 = driver.findElement(By.xpath(Outvat));
									WebElement Systemnetcollections1 = driver.findElement(By.xpath(Systemnetcollections));
									WebElement agentcancellatiocharges1 = driver.findElement(By.xpath(agentcancellatiocharges));
									WebElement airlinecancelaltioncharges1 = driver.findElement(By.xpath(airlinecancelaltioncharges));
									
									
									

								    Thread.sleep(500);

								    Double Publishedfare2 = new Double(Publishedfare1.getAttribute("value").trim());
								    
									Double tax2 = new Double(tax1.getAttribute("value").trim());
									System.out.println("tax2 value is"+tax2);
									Double Servicefee2 = new Double(Servicefee1.getAttribute("value").trim());
									Double Discount2 = new Double(Discount1.getAttribute("value").trim());
									Double Outvat2 = new Double(Outvat1.getAttribute("value").trim());
									Double Systemnetcollections2 = new Double(Systemnetcollections1.getAttribute("value").trim());
									
									Double agentcancellatiocharges2 = new Double(agentcancellatiocharges1.getAttribute("value").trim());
									System.out.println("agentcancellatiocharges2"+agentcancellatiocharges1);
									
									Double airlinecancelaltioncharges2 = new Double(airlinecancelaltioncharges1.getAttribute("value").trim());

									System.out.println("airlinecancelaltioncharges2"+airlinecancelaltioncharges2);		
									
									
								//	Double d33=d30*d31;
																
								//Sales net collections : publish fare -ORC + TAX + Service fee -Discount +outvat 


	Double Netcollectionscalc = (Publishedfare2) - (0) + (tax2) + (Servicefee2) - (Discount2) + (Outvat2)-(agentcancellatiocharges2)
			-(airlinecancelaltioncharges2);
	
//publishedfare- ORC+totaltax-totaldiscount-agentcancllaitoncharges-airlinecancellaitoncharges+total servce charges+totaloutputvat

	


									
								    Thread.sleep(500);
								    System.out.print("\n the value of Publishedfare2 is" + Publishedfare2);
								    								    
								    System.out.print("\n the value of tax2 is" + tax2);
								    System.out.print("\n the value of Servicefee2 is" + Servicefee2);
								    System.out.print("\n the value of Discount2 is" + Discount2);
								    System.out.print("\n the value of Outvat2 is" + Outvat2);
								    System.out.print("\n the value of Systemnetcollections2 is" + Systemnetcollections2);

								    System.out.print("\n the value of Netcollectionscalc is" + Netcollectionscalc);

								    System.out.print("\n the value of agentcancellatiocharges2 is" + agentcancellatiocharges2);

								    System.out.print("\n the value of airlinecancelaltioncharges2 is" + airlinecancelaltioncharges2);
								    
								   
								    if(Netcollectionscalc.equals(Systemnetcollections2))												    	
									    	
								    {
								    ATUReports.add(Positivemessages, LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
								    
								    ATUReports.add("Publishedfare2="+Publishedfare2,LogAs.INFO, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
								   // ATUReports.add("Orc2="+Orc2,LogAs.INFO, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
								    ATUReports.add("tax2="+tax2,LogAs.INFO, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
								    ATUReports.add("Servicefee2="+Servicefee2,LogAs.INFO, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
								    ATUReports.add("Discount2="+Discount2,LogAs.INFO, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
								    ATUReports.add("Outvat2="+Outvat2,LogAs.INFO, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
								    ATUReports.add("Systemnetcollections2="+Systemnetcollections2,LogAs.INFO, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
								    ATUReports.add("Netcollectionscalc="+Netcollectionscalc,LogAs.INFO, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
								    ATUReports.add("agentcancellatiocharges2="+agentcancellatiocharges2,LogAs.INFO, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
								    ATUReports.add("airlinecancelaltioncharges2="+airlinecancelaltioncharges2,LogAs.INFO, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
								    
								    }
								    else
								    {
								    ATUReports.add(Negativemessages, LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
									    	
								    }
								    }
									catch (NoSuchElementException e)
									{

								    ATUReports.add("NotClicked ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
								    } catch (Exception e) {
								    System.out.println("error");
								    } finally {
								    takeSnap();
								    }

								    }       
//========================================================================================================
									
//hotel netcalcualtion charges withusing cancelaltioncharges
									
									public void Hotelnetcalculationchargesusingcancelationcharges(String Publishedfare,
											String tax,String Servicefee,String Discount,String Outvat,
											String Systemnetcollections,String Hotelagentcancellatiocharges,
											String Hotelairlinecancelaltioncharges,
											String Positivemessages,String Negativemessages	) throws InterruptedException
								    {
								    try 
								    {

								    WebElement Publishedfare1 = driver.findElement(By.xpath(Publishedfare)); 
								    								    
									WebElement tax1 = driver.findElement(By.xpath(tax));
									WebElement Servicefee1 = driver.findElement(By.xpath(Servicefee));
									WebElement Discount1 = driver.findElement(By.xpath(Discount));
									WebElement Outvat1 = driver.findElement(By.xpath(Outvat));
									WebElement Systemnetcollections1 = driver.findElement(By.xpath(Systemnetcollections));
									WebElement Hotelagentcancellatiocharges1 = driver.findElement(By.xpath(Hotelagentcancellatiocharges));
									WebElement Hotelairlinecancelaltioncharges1 = driver.findElement(By.xpath(Hotelairlinecancelaltioncharges));
									
									
									

								    Thread.sleep(500);

								    Double Publishedfare2 = new Double(Publishedfare1.getAttribute("value").trim());
								    
									Double tax2 = new Double(tax1.getAttribute("value").trim());
									System.out.println("tax2 value is"+tax2);
									Double Servicefee2 = new Double(Servicefee1.getAttribute("value").trim());
									Double Discount2 = new Double(Discount1.getAttribute("value").trim());
									Double Outvat2 = new Double(Outvat1.getAttribute("value").trim());
									Double Systemnetcollections2 = new Double(Systemnetcollections1.getAttribute("value").trim());
									
									Double Hotelagentcancellatiocharges2 = new Double(Hotelagentcancellatiocharges1.getAttribute("value").trim());
									System.out.println("Hotelagentcancellatiocharges2"+Hotelagentcancellatiocharges2);
									
									Double Hotelairlinecancelaltioncharges2 = new Double(Hotelairlinecancelaltioncharges1.getAttribute("value").trim());
									System.out.println("Hotelairlinecancelaltioncharges2"+Hotelairlinecancelaltioncharges2);		
									
									
								//	Double d33=d30*d31;
																
								//Sales net collections : publish fare -ORC + TAX + Service fee -Discount +outvat 


	Double Netcollectionscalc = (Publishedfare2) - (0) + (tax2) + (Servicefee2) - (Discount2) + (Outvat2)-(Hotelagentcancellatiocharges2)
			-(Hotelairlinecancelaltioncharges2);
	
//publishedfare- ORC+totaltax-totaldiscount-agentcancllaitoncharges-airlinecancellaitoncharges+total servce charges+totaloutputvat

	


									
								    Thread.sleep(500);
								    System.out.print("\n the value of Publishedfare2 is" + Publishedfare2);
								    								    
								    System.out.print("\n the value of tax2 is" + tax2);
								    System.out.print("\n the value of Servicefee2 is" + Servicefee2);
								    System.out.print("\n the value of Discount2 is" + Discount2);
								    System.out.print("\n the value of Outvat2 is" + Outvat2);
								    System.out.print("\n the value of Systemnetcollections2 is" + Systemnetcollections2);

								    System.out.print("\n the value of Netcollectionscalc is" + Netcollectionscalc);

								    System.out.print("\n the value of agentcancellatiocharges2 is" + Hotelairlinecancelaltioncharges2);

								    System.out.print("\n the value of airlinecancelaltioncharges2 is" + Hotelairlinecancelaltioncharges2);
								    
								   
								    if(Netcollectionscalc.equals(Systemnetcollections2))												    	
									    	
								    {
								    ATUReports.add(Positivemessages, LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
								    
								    ATUReports.add("Publishedfare2="+Publishedfare2,LogAs.INFO, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
								   // ATUReports.add("Orc2="+Orc2,LogAs.INFO, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
								    ATUReports.add("tax2="+tax2,LogAs.INFO, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
								    ATUReports.add("Servicefee2="+Servicefee2,LogAs.INFO, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
								    ATUReports.add("Discount2="+Discount2,LogAs.INFO, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
								    ATUReports.add("Outvat2="+Outvat2,LogAs.INFO, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
								    ATUReports.add("Systemnetcollections2="+Systemnetcollections2,LogAs.INFO, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
								    ATUReports.add("Netcollectionscalc="+Netcollectionscalc,LogAs.INFO, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
								    ATUReports.add("Hotelagentcancellatiocharges2="+Hotelagentcancellatiocharges2,LogAs.INFO, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
								    ATUReports.add("Hotelairlinecancelaltioncharges2="+Hotelairlinecancelaltioncharges2,LogAs.INFO, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
								    
								    }
								    else
								    {
								    ATUReports.add(Negativemessages, LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
									    	
								    }
								    }
									catch (NoSuchElementException e)
									{

								    ATUReports.add("NotClicked ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
								    } catch (Exception e) {
								    System.out.println("error");
								    } finally {
								    takeSnap();
								    }

								    }       





//===============================================================================================================									
									
									public void Netcollectionsuisngorc(String Publishedfare,String Orc,
											String tax,String Servicefee,String Discount,String Outvat,String Systemnetcollections,
											String Positivemessages,String Negativemessages) throws InterruptedException
								    {
								    try 
								    {

								    WebElement Publishedfare1 = driver.findElement(By.xpath(Publishedfare)); 
								    WebElement Orc1 = driver.findElement(By.xpath(Orc)); 								    
									WebElement tax1 = driver.findElement(By.xpath(tax));
									WebElement Servicefee1 = driver.findElement(By.xpath(Servicefee));
									WebElement Discount1 = driver.findElement(By.xpath(Discount));
									WebElement Outvat1 = driver.findElement(By.xpath(Outvat));
									WebElement Systemnetcollections1 = driver.findElement(By.xpath(Systemnetcollections));
									
									
									

								    Thread.sleep(500);

								    Double Publishedfare2 = new Double(Publishedfare1.getAttribute("value").trim());
								    Double Orc2 = new Double(Orc1.getAttribute("value").trim());
									Double tax2 = new Double(tax1.getAttribute("value").trim());
									Double Servicefee2 = new Double(Servicefee1.getAttribute("value").trim());
									Double Discount2 = new Double(Discount1.getAttribute("value").trim());
									Double Outvat2 = new Double(Outvat1.getAttribute("value").trim());
									Double Systemnetcollections2 = new Double(Systemnetcollections1.getAttribute("value").trim());
											
								//	Double d33=d30*d31;
																
								//Sales net collections : publish fare -ORC + TAX + Service fee -Discount +outvat 

	Double Netcollectionscalc = (Publishedfare2) - (Orc2) + (tax2) + (Servicefee2) - (Discount2) + (Outvat2);
				

									
								    Thread.sleep(500);
								    System.out.print("\n the value of Publishedfare2 is" + Publishedfare2);
								    System.out.print("\n the value of Publishedfare2 is" + Orc2);								    
								    System.out.print("\n the value of tax2 is" + tax2);
								    System.out.print("\n the value of Servicefee2 is" + Servicefee2);
								    System.out.print("\n the value of Discount2 is" + Discount2);
								    System.out.print("\n the value of Outvat2 is" + Outvat2);
								    System.out.print("\n the value of Systemnetcollections2 is" + Systemnetcollections2);

								    System.out.print("\n the value of Netcollectionscalc is" + Netcollectionscalc);
								    
								   
								    if(Netcollectionscalc.equals(Systemnetcollections2))												    	
									    	
								    {
								    ATUReports.add(Positivemessages, LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
								    }
								    else
								    {
								    ATUReports.add(Negativemessages, LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
									    	
								    }
								    }
									catch (NoSuchElementException e)
									{

								    ATUReports.add("NotClicked ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
								    } catch (Exception e) {
								    System.out.println("error");
								    } finally {
								    takeSnap();
								    }

								    }       
//===========================================================================================================

									
	//Net collectionusing cancelaltioncharges
									
									
									
									public void Netcollectionsuisngorcandcancellatiocharges(String Publishedfare,String Orc,
											String tax,String Servicefee,String Discount,String Outvat,
											String Systemnetcollections,String agentcancellatiocharges,
											String airlinecancelaltioncharges,
											String Positivemessages,String Negativemessages	) throws InterruptedException
								    {
								    try 
								    {

								    WebElement Publishedfare1 = driver.findElement(By.xpath(Publishedfare)); 
								    WebElement Orc1 = driver.findElement(By.xpath(Orc)); 								    
									WebElement tax1 = driver.findElement(By.xpath(tax));
									WebElement Servicefee1 = driver.findElement(By.xpath(Servicefee));
									WebElement Discount1 = driver.findElement(By.xpath(Discount));
									WebElement Outvat1 = driver.findElement(By.xpath(Outvat));
									WebElement Systemnetcollections1 = driver.findElement(By.xpath(Systemnetcollections));
									WebElement agentcancellatiocharges1 = driver.findElement(By.xpath(agentcancellatiocharges));
									WebElement airlinecancelaltioncharges1 = driver.findElement(By.xpath(airlinecancelaltioncharges));
									
									
									

								    Thread.sleep(500);

								    Double Publishedfare2 = new Double(Publishedfare1.getAttribute("value").trim());
								    Double Orc2 = new Double(Orc1.getAttribute("value").trim());
									Double tax2 = new Double(tax1.getAttribute("value").trim());
									Double Servicefee2 = new Double(Servicefee1.getAttribute("value").trim());
									Double Discount2 = new Double(Discount1.getAttribute("value").trim());
									Double Outvat2 = new Double(Outvat1.getAttribute("value").trim());
									Double Systemnetcollections2 = new Double(Systemnetcollections1.getAttribute("value").trim());
									Double agentcancellatiocharges2 = new Double(agentcancellatiocharges1.getAttribute("value").trim());
									Double airlinecancelaltioncharges2 = new Double(airlinecancelaltioncharges1.getAttribute("value").trim());
											
									
									
								//	Double d33=d30*d31;
																
								//Sales net collections : publish fare -ORC + TAX + Service fee -Discount +outvat 


	Double Netcollectionscalc = (Publishedfare2) - (Orc2) + (tax2) + (Servicefee2) - (Discount2) + (Outvat2)-(agentcancellatiocharges2)
			-(airlinecancelaltioncharges2);
	
//publishedfare- ORC+totaltax-totaldiscount-agentcancllaitoncharges-airlinecancellaitoncharges+total servce charges+totaloutputvat

	


									
								    Thread.sleep(500);
								    System.out.print("\n the value of Publishedfare2 is" + Publishedfare2);
								    System.out.print("\n the value of Publishedfare2 is" + Orc2);								    
								    System.out.print("\n the value of tax2 is" + tax2);
								    System.out.print("\n the value of Servicefee2 is" + Servicefee2);
								    System.out.print("\n the value of Discount2 is" + Discount2);
								    System.out.print("\n the value of Outvat2 is" + Outvat2);
								    System.out.print("\n the value of Systemnetcollections2 is" + Systemnetcollections2);

								    System.out.print("\n the value of Netcollectionscalc is" + Netcollectionscalc);

								    System.out.print("\n the value of agentcancellatiocharges2 is" + agentcancellatiocharges2);

								    System.out.print("\n the value of airlinecancelaltioncharges2 is" + airlinecancelaltioncharges2);
								    
								   
								    if(Netcollectionscalc.equals(Systemnetcollections2))												    	
									    	
								    {
								    ATUReports.add(Positivemessages, LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
								    
								    ATUReports.add("Publishedfare2="+Publishedfare2,LogAs.INFO, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
								    ATUReports.add("Orc2="+Orc2,LogAs.INFO, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
								    ATUReports.add("tax2="+tax2,LogAs.INFO, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
								    ATUReports.add("Servicefee2="+Servicefee2,LogAs.INFO, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
								    ATUReports.add("Discount2="+Discount2,LogAs.INFO, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
								    ATUReports.add("Outvat2="+Outvat2,LogAs.INFO, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
								    ATUReports.add("Systemnetcollections2="+Systemnetcollections2,LogAs.INFO, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
								    ATUReports.add("Netcollectionscalc="+Netcollectionscalc,LogAs.INFO, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
								    ATUReports.add("agentcancellatiocharges2="+agentcancellatiocharges2,LogAs.INFO, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
								    ATUReports.add("airlinecancelaltioncharges2="+airlinecancelaltioncharges2,LogAs.INFO, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
								    
								    }
								    else
								    {
								    ATUReports.add(Negativemessages, LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
									    	
								    }
								    }
									catch (NoSuchElementException e)
									{

								    ATUReports.add("NotClicked ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
								    } catch (Exception e) {
								    System.out.println("error");
								    } finally {
								    takeSnap();
								    }

								    }       

									
									
//=================================================================================================================
									
									
																		
//=================================================================================================================
									

									public void Netcollectionsuisngorcsub(String Publishedfare,String Orc,
											String tax,String Servicefee,String Discount,String Outvat,String Systemnetcollections,
											String Positivemessages,String Negativemessages) throws InterruptedException
								    {
								    try 
								    {

								    WebElement Publishedfare1 = driver.findElement(By.xpath(Publishedfare)); 
								    WebElement Orc1 = driver.findElement(By.xpath(Orc)); 								    
									WebElement tax1 = driver.findElement(By.xpath(tax));
									WebElement Servicefee1 = driver.findElement(By.xpath(Servicefee));
									WebElement Discount1 = driver.findElement(By.xpath(Discount));
									WebElement Outvat1 = driver.findElement(By.xpath(Outvat));
									WebElement Systemnetcollections1 = driver.findElement(By.xpath(Systemnetcollections));
									
									
									

								    Thread.sleep(500);

								    Double Publishedfare2 = new Double(Publishedfare1.getAttribute("value").trim());
								    Double Orc2 = new Double(Orc1.getAttribute("value").trim());
									Double tax2 = new Double(tax1.getAttribute("value").trim());
									Double Servicefee2 = new Double(Servicefee1.getAttribute("value").trim());
									Double Discount2 = new Double(Discount1.getAttribute("value").trim());
									Double Outvat2 = new Double(Outvat1.getAttribute("value").trim());
									Double Systemnetcollections2 = new Double(Systemnetcollections1.getAttribute("value").trim());
											
								//	Double d33=d30*d31;
																
								//Sales net collections : publish fare -ORC + TAX + Service fee -Discount +outvat 

	Double Netcollectionscalc = (Publishedfare2) - (Orc2) + (tax2) + (Servicefee2) - (Discount2) + (Outvat2);
				

									
								    Thread.sleep(500);
								    System.out.print("\n the value of Publishedfare2 is" + Publishedfare2);
								    System.out.print("\n the value of Publishedfare2 is" + Orc2);								    
								    System.out.print("\n the value of tax2 is" + tax2);
								    System.out.print("\n the value of Servicefee2 is" + Servicefee2);
								    System.out.print("\n the value of Discount2 is" + Discount2);
								    System.out.print("\n the value of Outvat2 is" + Outvat2);
								    System.out.print("\n the value of Systemnetcollections2 is" + Systemnetcollections2);

								    System.out.print("\n the value of Netcollectionscalc is" + Netcollectionscalc);
								    
								   
								    if(Netcollectionscalc-Systemnetcollections2==0)												    	
									    	
								    {
								    ATUReports.add(Positivemessages, LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
								    }
								    else
								    {
								    ATUReports.add(Negativemessages, LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
									    	
								    }
								    }
									catch (NoSuchElementException e)
									{

								    ATUReports.add("NotClicked ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
								    } catch (Exception e) {
								    System.out.println("error");
								    } finally {
								    takeSnap();
								    }

								    }       

									
//===========================================================================================================

		//publiher fare
	//Net collection calculted :
									

									public void Publishedfare(String Publishedfare,
											String tax,String commission,String invat,String Systemnetcollections,
											String Positivemessages,String Negativemessages) throws InterruptedException
								    {
								    try 
								    {

			//  Sales payable collections: Publish fare - ORC Received + Tax - commission + invat


								    WebElement Publishedfare1 = driver.findElement(By.xpath(Publishedfare)); 
									WebElement tax1 = driver.findElement(By.xpath(tax));
									WebElement commission1 = driver.findElement(By.xpath(commission));
									WebElement invat1 = driver.findElement(By.xpath(invat));
									
									WebElement Systemnetcollections1 = driver.findElement(By.xpath(Systemnetcollections));
									
									
									

								    Thread.sleep(500);

								    Double Publishedfare2 = new Double(Publishedfare1.getAttribute("value").trim());
									Double tax2 = new Double(tax1.getAttribute("value").trim());
									Double commission2 = new Double(commission1.getAttribute("value").trim());
									
									Double invat2 = new Double(invat1.getAttribute("value").trim());
									Double Systemnetcollections2 = new Double(Systemnetcollections1.getAttribute("value").trim());
											
								//	Double d33=d30*d31;
																
								//Sales net collections : publish fare -ORC + TAX + Service fee -Discount +outvat 

									Double Publishedfarecalculations = Publishedfare2 + tax2 - commission2 + invat2;
				

									
								    Thread.sleep(500);
								    System.out.print("\n the value of Publishedfare2 is" + Publishedfare2);
								    System.out.print("\n the value of tax2 is" + tax2);
								    System.out.print("\n the value of commission2 is" + commission2);
								    System.out.print("\n the value of invat2 is" + invat2);
								    
								    System.out.print("\n the value of Systemnetcollections2 is" + Publishedfarecalculations);

								    System.out.print("\n the value of Netcollectionscalc is" + Systemnetcollections2);
								    
								   
									    if(Systemnetcollections2.equals(Publishedfarecalculations))
								    {
								    ATUReports.add(Positivemessages, LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
								    }
								    else
								    {
								    ATUReports.add(Negativemessages, LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
									    	
								    }
								    }
									catch (NoSuchElementException e)
									{

								    ATUReports.add("NotClicked ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
								    } catch (Exception e) {
								    System.out.println("error");
								    } finally {
								    takeSnap();
								    }

								    }       

//=====================================================================================================
																		
									
//=========================================================================================================									
									public void Publishedfareusingorc(String Publishedfare,
									String Orc,String tax,String commission,String invat,String Systemnetcollections,
											String Positivemessages,String Negativemessages) throws InterruptedException
								    {
								    try 
								    {

			//  Sales payable collections: Publish fare - ORC Received + Tax - commission + invat


								    WebElement Publishedfare1 = driver.findElement(By.xpath(Publishedfare)); 
								    WebElement Orc1 = driver.findElement(By.xpath(Orc)); 
									WebElement tax1 = driver.findElement(By.xpath(tax));
									WebElement commission1 = driver.findElement(By.xpath(commission));
									WebElement invat1 = driver.findElement(By.xpath(invat));
									
									WebElement Systemnetcollections1 = driver.findElement(By.xpath(Systemnetcollections));
									
									
									

								    Thread.sleep(500);

								    Double Publishedfare2 = new Double(Publishedfare1.getAttribute("value").trim());
								    Double Orc2 = new Double(Orc1.getAttribute("value").trim());
									Double tax2 = new Double(tax1.getAttribute("value").trim());
									Double commission2 = new Double(commission1.getAttribute("value").trim());
									Double invat2 = new Double(invat1.getAttribute("value").trim());
									Double Systemnetcollections2 = new Double(Systemnetcollections1.getAttribute("value").trim());
											
								//	Double d33=d30*d31;
																
								//Sales net collections : publish fare -ORC + TAX + Service fee -Discount +outvat 

									Double Publishedfarecalculations = Publishedfare2-Orc2 + tax2 - commission2 + invat2;
				

									
								    Thread.sleep(500);
								    System.out.print("\n the value of Publishedfare2 is" + Publishedfare2);
								    System.out.print("\n the value of Orc2 is" + Orc2);								    
								    System.out.print("\n the value of tax2 is" + tax2);
								    System.out.print("\n the value of commission2 is" + commission2);
								    System.out.print("\n the value of invat2 is" + invat2);
								    
								    System.out.print("\n the value of Systemnetcollections2 is" + Publishedfarecalculations);

								    System.out.print("\n the value of Netcollectionscalc is" + Systemnetcollections2);
								    
								   
									    if(Systemnetcollections2.equals(Publishedfarecalculations))
								    {
								    ATUReports.add(Positivemessages, LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
								    }
								    else
								    {
								    ATUReports.add(Negativemessages, LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
									    	
								    }
								    }
									catch (NoSuchElementException e)
									{

								    ATUReports.add("NotClicked ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
								    } catch (Exception e) {
								    System.out.println("error");
								    } finally {
								    takeSnap();
								    }

								    }       

//===================================================================================================
									
//published fare using cancelaltion charges
									

									public void Publishedfareusingcancelaltioncharges(String Sellingfare,
											String tax,String commission,String aircancelchar,String invat
											,String airlincecardamount,String Systemnetcollections,
											String Positivemessages,String Negativemessages) throws InterruptedException
								    {
								    try 
								    {


//Sellingfare+totax-totalcommamount-aircancelchar+totalinputvat-airlincecardamount(uccf)



								    WebElement Sellingfare1 = driver.findElement(By.xpath(Sellingfare)); 
									WebElement tax1 = driver.findElement(By.xpath(tax));
									WebElement commission1 = driver.findElement(By.xpath(commission));
									WebElement aircancelchar1 = driver.findElement(By.xpath(aircancelchar));
									WebElement invat1 = driver.findElement(By.xpath(invat));
									//WebElement airlincecardamount1 = driver.findElement(By.xpath(airlincecardamount));
									WebElement Systemnetcollections1 = driver.findElement(By.xpath(Systemnetcollections));

								    Thread.sleep(500);

								    Double Sellingfare2 = new Double(Sellingfare1.getAttribute("value").trim());
									Double tax2 = new Double(tax1.getAttribute("value").trim());
									Double commission2 = new Double(commission1.getAttribute("value").trim());
									Double aircancelchar2 = new Double(aircancelchar1.getAttribute("value").trim());							
									Double invat2 = new Double(invat1.getAttribute("value").trim());
									//Double airlincecardamount2 = new Double(airlincecardamount1.getAttribute("value").trim());
									Double Systemnetcollections2 = new Double(Systemnetcollections1.getAttribute("value").trim());
											
								//	Double d33=d30*d31;
																
								//Sales net collections : publish fare -ORC + TAX + Service fee -Discount +outvat 

				Double Publishedfarecalculations = (Sellingfare2) + (tax2) - (commission2) -(aircancelchar2)+(invat2);
				

									
								    Thread.sleep(500);
								    System.out.print("\n the value of Sellingfare2 is" + Sellingfare2);
								    System.out.print("\n the value of tax2 is" + tax2);
								    System.out.print("\n the value of commission2 is" + commission2);
								    System.out.print("\n the value of aircancelchar2 is" + aircancelchar2);
								    System.out.print("\n the value of invat2 is" + invat2);
								    //System.out.print("\n the value of airlincecardamount2 is" + airlincecardamount2);
								    
								    
								    System.out.print("\n the value of Systemnetcollections2 is" + Publishedfarecalculations);

								    System.out.print("\n the value of Netcollectionscalc is" + Systemnetcollections2);
								    
								   
									    if(Systemnetcollections2.equals(Publishedfarecalculations))
								    {
								    ATUReports.add(Positivemessages, LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
								    
								    ATUReports.add("Sellingfare="+Sellingfare2,LogAs.INFO, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
								    ATUReports.add("tax2="+tax2,LogAs.INFO, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
								    ATUReports.add("commission2="+commission2,LogAs.INFO, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
								    ATUReports.add("aircancelchar2="+aircancelchar2,LogAs.INFO, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
								    ATUReports.add("invat2="+invat2,LogAs.INFO, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
								    //ATUReports.add("airlincecardamount2="+airlincecardamount2,LogAs.INFO, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
								    ATUReports.add("Publishedfarecalculations="+Publishedfarecalculations,LogAs.INFO, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
								    ATUReports.add("Systemnetcollections2="+Systemnetcollections2,LogAs.INFO, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
									    
								    
								    }
								    else
								    {
								    ATUReports.add(Negativemessages, LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
								    ATUReports.add("Sellingfare="+Sellingfare2,LogAs.INFO, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
								    ATUReports.add("tax2="+tax2,LogAs.INFO, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
								    ATUReports.add("commission2="+commission2,LogAs.INFO, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
								    ATUReports.add("aircancelchar2="+aircancelchar2,LogAs.INFO, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
								    ATUReports.add("invat2="+invat2,LogAs.INFO, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
								    //ATUReports.add("airlincecardamount2="+airlincecardamount2,LogAs.INFO, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
								    ATUReports.add("Publishedfarecalculations="+Publishedfarecalculations,LogAs.INFO, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
								    ATUReports.add("Systemnetcollections2="+Systemnetcollections2,LogAs.INFO, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
										
								    }
								    }
									catch (NoSuchElementException e)
									{

								    ATUReports.add("NotClicked ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
								    } catch (Exception e) {
								    System.out.println("error");
								    } finally {
								    takeSnap();
								    }

								    }       


									
									
//====================================================================================================
									
									

									//published fare using cancelaltion charges
																		
	public void Publishedfareusingcancelaltionchargeswithoutuccf(String Sellingfare, String tax, String commission,
			String aircancelchar, String invat, String Systemnetcollections, String Positivemessages,
			String Negativemessages) throws InterruptedException {
		try {

			// Sellingfare+totax-totalcommamount-aircancelchar+totalinputvat-airlincecardamount(uccf)

			WebElement Sellingfare1 = driver.findElement(By.xpath(Sellingfare));
			WebElement tax1 = driver.findElement(By.xpath(tax));
			WebElement commission1 = driver.findElement(By.xpath(commission));
			WebElement aircancelchar1 = driver.findElement(By.xpath(aircancelchar));
			WebElement invat1 = driver.findElement(By.xpath(invat));
			// WebElement airlincecardamount1 =
			// driver.findElement(By.xpath(airlincecardamount));
			WebElement Systemnetcollections1 = driver.findElement(By.xpath(Systemnetcollections));

			Thread.sleep(500);

			Double Sellingfare2 = new Double(Sellingfare1.getAttribute("value").trim());
			Double tax2 = new Double(tax1.getAttribute("value").trim());
			Double commission2 = new Double(commission1.getAttribute("value").trim());
			Double aircancelchar2 = new Double(aircancelchar1.getAttribute("value").trim());
			Double invat2 = new Double(invat1.getAttribute("value").trim());
			// Double airlincecardamount2 = new
			// Double(airlincecardamount1.getAttribute("value").trim());
			Double Systemnetcollections2 = new Double(Systemnetcollections1.getAttribute("value").trim());

			// Double d33=d30*d31;

			// Sales net collections : publish fare -ORC + TAX + Service fee
			// -Discount +outvat

			Double Publishedfarecalculations = (Sellingfare2) + (tax2) - (commission2) - (aircancelchar2) + (invat2);

			Thread.sleep(500);
			System.out.print("\n the value of Sellingfare2 is" + Sellingfare2);
			System.out.print("\n the value of tax2 is" + tax2);
			System.out.print("\n the value of commission2 is" + commission2);
			System.out.print("\n the value of aircancelchar2 is" + aircancelchar2);
			System.out.print("\n the value of invat2 is" + invat2);
			// System.out.print("\n the value of airlincecardamount2 is" +
			// airlincecardamount2);

			System.out.print("\n the value of Systemnetcollections2 is" + Publishedfarecalculations);

			System.out.print("\n the value of Netcollectionscalc is" + Systemnetcollections2);

			if (Systemnetcollections2.equals(Publishedfarecalculations)) {
				ATUReports.add(Positivemessages, LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

				ATUReports.add("Sellingfare=" + Sellingfare2, LogAs.INFO, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				ATUReports.add("tax2=" + tax2, LogAs.INFO, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				ATUReports.add("commission2=" + commission2, LogAs.INFO, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				ATUReports.add("aircancelchar2=" + aircancelchar2, LogAs.INFO,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				ATUReports.add("invat2=" + invat2, LogAs.INFO, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				// ATUReports.add("airlincecardamount2="+airlincecardamount2,LogAs.INFO,
				// new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				ATUReports.add("Publishedfarecalculations=" + Publishedfarecalculations, LogAs.INFO,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				ATUReports.add("Systemnetcollections2=" + Systemnetcollections2, LogAs.INFO,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			} else {
				ATUReports.add(Negativemessages, LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				ATUReports.add("Sellingfare=" + Sellingfare2, LogAs.INFO, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				ATUReports.add("tax2=" + tax2, LogAs.INFO, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				ATUReports.add("commission2=" + commission2, LogAs.INFO, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				ATUReports.add("aircancelchar2=" + aircancelchar2, LogAs.INFO,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				ATUReports.add("invat2=" + invat2, LogAs.INFO, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				// ATUReports.add("airlincecardamount2="+airlincecardamount2,LogAs.INFO,
				// new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				ATUReports.add("Publishedfarecalculations=" + Publishedfarecalculations, LogAs.INFO,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				ATUReports.add("Systemnetcollections2=" + Systemnetcollections2, LogAs.INFO,
						new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			}
		} catch (NoSuchElementException e) {

			ATUReports.add("NotClicked ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		} catch (Exception e) {
			System.out.println("error");
		} finally {
			takeSnap();
		}

	}

//======================================================================================================

									public void Airprofitcalculations(String commission,String Servicefee,
											String Discount,String Agentcancell,String ORCreceived,String ORCparted) throws InterruptedException
								    {
								    
								    

								    WebElement commission1 = driver.findElement(By.xpath(commission)); 
									WebElement Servicefee1 = driver.findElement(By.xpath(Servicefee));
									WebElement Discount1 = driver.findElement(By.xpath(Discount));
									WebElement Agentcancel = driver.findElement(By.xpath(Agentcancell));
									WebElement ORCreceived1 = driver.findElement(By.xpath(ORCreceived));
									WebElement ORCparted1 = driver.findElement(By.xpath(ORCparted));

								    Thread.sleep(500);

								    Double commission2 = new Double(commission1.getAttribute("value").trim());
									Double Servicefee2 = new Double(Servicefee1.getAttribute("value").trim());
									Double Discount2 = new Double(Discount1.getAttribute("value").trim());
									Double Agentcance2 = new Double(Agentcancel.getAttribute("value").trim());							
									Double ORCreceived2 = new Double(ORCreceived1.getAttribute("value").trim());
									//Double airlincecardamount2 = new Double(airlincecardamount1.getAttribute("value").trim());
									Double ORCparted2 = new Double(ORCparted1.getAttribute("value").trim());
											
							
Double Profitamount = ( commission2 ) + ( Servicefee2 ) - ( Discount2 ) + ( Agentcance2 )+( ORCreceived2 )-( ORCparted2);
				

									
								    Thread.sleep(500);
								    System.out.print("\n the value of commission2 is" + commission2);
								    System.out.print("\n the value of Servicefee2 is" + Servicefee2);
								    System.out.print("\n the value of Discount2 is" + Discount2);
								    System.out.print("\n the value of Agentcance2 is" + Agentcance2);
								    System.out.print("\n the value of ORCreceived2 is" + ORCreceived2);
								    System.out.print("\n the value of ORCparted2 is" + ORCparted2);
								    System.out.print("\n the value of Profitamount is" + Profitamount);
									    
								    								   
	ATUReports.add("Profitamount="+Profitamount,LogAs.INFO, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

								    

								    }
								    
//===========================================================================================================
									
									
		public void Totalamountdividebypercentage(String xpath1,String Fopdivide,
				String Positivemessages,String Negativemessages) throws InterruptedException
								    {
								    try 
								    {

								    WebElement elt11 = driver.findElement(By.xpath(xpath1));
									

								    Thread.sleep(300);

				Double d21 = new Double(elt11.getAttribute("value").trim()); //FOP Amountt
				Double d23 = new Double(Fopdivide.trim());
									
									Double d22 = d21*d23/100;
									
									

								    Thread.sleep(200);
								    System.out.print("\n the value of d11 is" + d21);//seeling fare
								    System.out.print("\n the value of d12 is" + d22); //
								    Thread.sleep(200);
								 	
									if(d21!=d22)
								    {
								driver.findElementByXPath(xpath1).clear();
								driver.findElementByXPath(xpath1).sendKeys(d22.toString());
								Thread.sleep(200);
								    ATUReports.add(Positivemessages, LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
								    }
								    else
								    {
								    ATUReports.add(Negativemessages, LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
									    	
								    }
								    }
									catch (NoSuchElementException e)
									{

								    ATUReports.add("NotClicked ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
								    } catch (Exception e) {
								    System.out.println("error");
								    } finally {
								    takeSnap();
								    }

								    }       



	
//=============================================================================================
									
//copy and paste the values
									
									 public void Copyandpaste(String xpath10) throws InterruptedException
									 {
									   try 
										{
									   	Thread.sleep(2000);
									   

			WebElement Elt = driver.findElement(By.xpath(xpath10)); 

//			String  Elt1 = new String(Elt.getAttribute("value").trim());

			String  Elt1 = new String(Elt.getText().trim());
			


									       Thread.sleep(500);

									   
									        store2 = Elt1.toString();
										        Thread.sleep(500);
										        
									        System.out.println("the value is"+store2);
									        
									      ATUReports.add("Newly created Details " + store2, LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
									    	
									        
									   }
									   catch (Exception e) {
									   System.out.println("error");
									   } finally {
									   takeSnap();
									   }

									   }

//================================================================================================
									 
									 

									//copy and paste the values and pass the message 

	public void Copyandpasteandmessage(String xpath10,String usermessage) throws InterruptedException {
		try {
			Thread.sleep(2000);

			WebElement Elt = driver.findElement(By.xpath(xpath10));

			// String Elt1 = new String(Elt.getAttribute("value").trim());

			String Elt1 = new String(Elt.getText().trim());

			Thread.sleep(500);

			store2 = Elt1.toString();
			Thread.sleep(500);

			System.out.println("the value is" + store2);

			ATUReports.add(usermessage + store2, LogAs.PASSED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));

		} catch (Exception e) {
			System.out.println("error");
		} finally {
			takeSnap();
		}

	}

//==================================================================================================
	

//=================================================================================================
									 
public void Printmessages(String Msg)
{
	 ATUReports.add(Msg,LogAs.INFO, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
	   
}
									


//======================================================================================



public void findbyelementbyxpathandsendthevalues(String xpath,String xpath1) 
{

	try {

		if (driver.findElementByXPath(xpath).isEnabled())

		{
			//driver.findElementByXPath(xpath).click();
			driver.findElementByXPath(xpath).sendKeys(xpath1);


			ATUReports.add("Element found ", LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		}

		else {
			// ATUReports.add("No element found ", LogAs.FAILED, new
			// CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		}

		// ATUReports.add("ID element got clicked ", LogAs.PASSED, new
		// CaptureScreen(ScreenshotOf.BROWSER_PAGE));
	} catch (NoSuchElementException e) {

		//ATUReports.add("No element found ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
	} finally {
		takeSnap();
	}
}



									
//===================================================================================================================
									
//====================================================================================================
	public void scrolldown(String id) {
		try {
			int y = driver.findElementById(id).getLocation().getY();
			((JavascriptExecutor) driver).executeScript("window.scrollBy(0," + y + ");");

			ATUReports.add("User scroll down the page ", LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		} catch (NoSuchElementException e) {

			ATUReports.add("No element found ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		} catch (WebDriverException e) {
			ATUReports.add("No driver found ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		} finally {
			takeSnap();
		}

	}
}
