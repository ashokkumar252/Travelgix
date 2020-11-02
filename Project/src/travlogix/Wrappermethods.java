package travlogix;
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
import org.openqa.selenium.firefox.FirefoxDriver;
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
	static String store2;
	public void launchbrowser(String brwsr, String URL)

	{
		if (brwsr.equalsIgnoreCase("chrome")) {
				//System.setProperty("webdriver.chrome.driver", "E:\\chrome driver\\chromedriver.exe");
				//System.setProperty("webdriver.chrome.driver", "C:\\chromedriver\\Chromedriver2\\chromedriver.exe");
			
				//System.setProperty("webdriver.chrome.driver", "C:\\Wastaautomation\\chromedriver.exe");
				System.setProperty("webdriver.chrome.driver", utility.Constant.CHROMEDRIVEREXE);
				
			
				
			// C:\\chromedriver\\chromedriver1\\chromedriver.exe

			driver = new ChromeDriver();

			ATUReports.setWebDriver(driver);
			ATUReports.indexPageDescription = "Information dynamic Project";
			ATUReports.setAuthorInfo("Automation", Utils.getCurrentTime(), "1.0");

		}

		else if (brwsr.equalsIgnoreCase("ie")) {
			System.setProperty("webdriver.ie.driver", "C:\\IE driver\\IE64\\IEDriverServer.exe");
			// C:\\IE driver\\IE64\\IEDriverServer.exe

			driver = new InternetExplorerDriver();

			ATUReports.setWebDriver(driver);
			ATUReports.indexPageDescription = "FreeWheel MRM Project";
			ATUReports.setAuthorInfo("ID", Utils.getCurrentTime(), "1.0");
			ATUReports.add("InternetExplorer is instantiated", LogAs.PASSED, new CaptureScreen(ScreenshotOf.DESKTOP));
		}
		else if (brwsr.equalsIgnoreCase("headless")) {
			System.setProperty("webdriver.ie.driver", "C:\\IE driver\\IE64\\IEDriverServer.exe");
			// C:\\IE driver\\IE64\\IEDriverServer.exe

		//	driver3 =  new HtmlUnitDriver();
			 

			ATUReports.setWebDriver(driver);
			ATUReports.indexPageDescription = "FreeWheel MRM Project";
			ATUReports.setAuthorInfo("ID", Utils.getCurrentTime(), "1.0");
			ATUReports.add("InternetExplorer is instantiated", LogAs.PASSED, new CaptureScreen(ScreenshotOf.DESKTOP));
		} 
		else

		{
			driver = new FirefoxDriver();

			ATUReports.setWebDriver(driver);
			ATUReports.indexPageDescription = "ID Project";
			ATUReports.setAuthorInfo("ID", Utils.getCurrentTime(), "1.0");
			// ATUReports.setAuthorInfo(ID, arg1, arg2);

			ATUReports.add("Firefox Driver is instantiated", LogAs.PASSED, new CaptureScreen(ScreenshotOf.DESKTOP));

		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(URL);
		ATUReports.add("Browser launched and URL got triggered ", LogAs.PASSED,
				new CaptureScreen(ScreenshotOf.DESKTOP));
	}

	public void enterbyxpath(String xpt, String data)

	{
		try {
			driver.findElementByXPath(xpt).clear();
			driver.findElementByXPath(xpt).sendKeys(data);
			

			// ATUReports.add("Enter the Data successfully", LogAs.PASSED, new
			// CaptureScreen(ScreenshotOf.BROWSER_PAGE));

			ATUReports.add("Data Entered as " + data, LogAs.PASSED, new CaptureScreen(ScreenshotOf.DESKTOP));

		} catch (NoSuchElementException e) {

			ATUReports.add("No element found", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.DESKTOP));
			ATUReports.add("No element found ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.DESKTOP));
		} catch (WebDriverException e) {
			ATUReports.add("No driver found ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.DESKTOP));
		} finally {
			takeSnap();
		}
	}

	public void clickbyxpath(String xpt1) {

		try {
			
			driver.findElementByXPath(xpt1).click();
			//ATUReports.add("Click by Xpath ", LogAs.PASSED, new CaptureScreen(ScreenshotOf.DESKTOP));
		} catch (NoSuchElementException e) {

		//	ATUReports.add("No element found ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.DESKTOP));
		} catch (WebDriverException e) {
			ATUReports.add("No driver found ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.DESKTOP));
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
			ATUReports.add("Mouse moved over to the Manage ", LogAs.PASSED, new CaptureScreen(ScreenshotOf.DESKTOP));
			driver.findElementByLinkText(lnk).click();
			ATUReports.add("User clicked the " + lnk + "link", LogAs.PASSED, new CaptureScreen(ScreenshotOf.DESKTOP));
		} catch (NoSuchElementException e) {

			ATUReports.add("No element found ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.DESKTOP));
		} catch (WebDriverException e) {
			ATUReports.add("No driver found ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.DESKTOP));
		} finally {
			takeSnap();
		}
	}

	public void clickBylinktext(String lnk) {

		try {
			driver.findElementByLinkText(lnk).click();
			ATUReports.add("User clicked the " + lnk + "link", LogAs.PASSED, new CaptureScreen(ScreenshotOf.DESKTOP));
		} catch (NoSuchElementException e) {

			ATUReports.add("No element found ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.DESKTOP));
		} catch (WebDriverException e) {
			ATUReports.add("No driver found ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.DESKTOP));
		} finally {
			takeSnap();
		}

	}

	public void sendtextbyid(String id, String txt) {
		try {

			driver.findElementById(id).clear();
			driver.findElementById(id).sendKeys(txt);
			ATUReports.add(" User Entered the text as " + txt, LogAs.PASSED, new CaptureScreen(ScreenshotOf.DESKTOP));
		} catch (NoSuchElementException e) {

			//ATUReports.add("No element found ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.DESKTOP));
		} catch (WebDriverException e) {
			ATUReports.add("No driver found ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.DESKTOP));
		} finally {
			takeSnap();
		}
	}

	// ===========================

	public void sendtextbyidbyint(String id, int txt) {
		try {

			driver.findElementById(id).clear();
			driver.findElementById(id).sendKeys("txt");
			ATUReports.add(" User Entered the text as " + txt, LogAs.PASSED, new CaptureScreen(ScreenshotOf.DESKTOP));
		} catch (NoSuchElementException e) {

			ATUReports.add("No element found ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.DESKTOP));
		} catch (WebDriverException e) {
			ATUReports.add("No driver found ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.DESKTOP));
		} finally {
			takeSnap();
		}
	}
	// =========================================================

	public void sendtextbyxvalue(String xva, String txt) {
		try {
			driver.findElementByXPath(xva).clear();
			driver.findElementByXPath(xva).sendKeys(txt);

			ATUReports.add(" User Entered the text as " + txt, LogAs.PASSED, new CaptureScreen(ScreenshotOf.DESKTOP));
		} catch (NoSuchElementException e) {

			ATUReports.add("No element found ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.DESKTOP));
		} catch (WebDriverException e) {
			ATUReports.add("No driver found ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.DESKTOP));
		} finally {
			takeSnap();
		}
	}
	
	//=======================================================================
	public void sendtextbyxvalueintt(String xva, String txt) {
		try {
			driver.findElementByXPath(xva).clear();
			driver.findElementByXPath(xva).sendKeys(""+5);

			ATUReports.add(" User Entered the text as " + txt, LogAs.PASSED, new CaptureScreen(ScreenshotOf.DESKTOP));
		} catch (NoSuchElementException e) {

			ATUReports.add("No element found ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.DESKTOP));
		} catch (WebDriverException e) {
			ATUReports.add("No driver found ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.DESKTOP));
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

			ATUReports.add(" User Entered the text as " + txt, LogAs.PASSED, new CaptureScreen(ScreenshotOf.DESKTOP));
		} catch (NoSuchElementException e) {

			ATUReports.add("No element found ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.DESKTOP));
		} catch (WebDriverException e) {
			ATUReports.add("No driver found ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.DESKTOP));
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
			ATUReports.add(" User Entered the text as " + txt, LogAs.PASSED, new CaptureScreen(ScreenshotOf.DESKTOP));
		} catch (NoSuchElementException e) {

			ATUReports.add("No element found ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.DESKTOP));
		} catch (WebDriverException e) {
			ATUReports.add("No driver found ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.DESKTOP));
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

			ATUReports.add(" User Entered the text as " + txt, LogAs.PASSED, new CaptureScreen(ScreenshotOf.DESKTOP));
		} catch (NoSuchElementException e) {

			ATUReports.add("No element found ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.DESKTOP));
		} catch (WebDriverException e) {
			ATUReports.add("No driver found ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.DESKTOP));
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

			ATUReports.add(" User Entered the text as " + txt, LogAs.PASSED, new CaptureScreen(ScreenshotOf.DESKTOP));
		} catch (NoSuchElementException e) {

			ATUReports.add("No element found ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.DESKTOP));
		} catch (WebDriverException e) {
			ATUReports.add("No driver found ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.DESKTOP));
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

				ATUReports.add(" User Entered the text as ", LogAs.PASSED, new CaptureScreen(ScreenshotOf.DESKTOP));
			} catch (NoSuchElementException e) {

				ATUReports.add("No element found ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.DESKTOP));
			} catch (WebDriverException e) {
				ATUReports.add("No driver found ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.DESKTOP));
			} finally {
				takeSnap();
			}
		}

		
		
		
		//================================================
		
		//Claer the values 
		
		public void Clearbyxpath(String xpt1) {

			try {
				
				driver.findElementByXPath(xpt1).clear();
				ATUReports.add("Network link got clicked ", LogAs.PASSED, new CaptureScreen(ScreenshotOf.DESKTOP));
			} catch (NoSuchElementException e) {

			ATUReports.add("No element found ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.DESKTOP));
			} catch (WebDriverException e) {
				ATUReports.add("Element not cleared", LogAs.FAILED, new CaptureScreen(ScreenshotOf.DESKTOP));
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

			ATUReports.add(" User Entered the text as ", LogAs.PASSED, new CaptureScreen(ScreenshotOf.DESKTOP));
		} catch (NoSuchElementException e) {

			ATUReports.add("No element found ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.DESKTOP));
		} catch (WebDriverException e) {
			ATUReports.add("No driver found ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.DESKTOP));
		} finally {
			takeSnap();
		}
	}

	// ===============================================================

	public void selectbyvalueid(String idvalue, String text) throws InterruptedException {
		try {
			Select dropdown = new Select(driver.findElementById(idvalue));
			ATUReports.add(" List Values are loaded in to Dropdown ", LogAs.PASSED,
					new CaptureScreen(ScreenshotOf.DESKTOP));
			Thread.sleep(3000);
			dropdown.selectByVisibleText(text);
			ATUReports.add(" user selected the Rating ", LogAs.PASSED, new CaptureScreen(ScreenshotOf.DESKTOP));
		} catch (NoSuchElementException e) {

			ATUReports.add("No element found ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.DESKTOP));
		} catch (WebDriverException e) {
			ATUReports.add("No driver found ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.DESKTOP));
		} finally {
			takeSnap();
		}
	}

	public void selectbyValuexp(String xpvalue, String text) throws InterruptedException {
		try {
			Thread.sleep(2000);
			Select dropdown = new Select(driver.findElementByXPath(xpvalue));
			ATUReports.add(" List Values are loaded in to Dropdown ", LogAs.PASSED,
					new CaptureScreen(ScreenshotOf.DESKTOP));
			Thread.sleep(2000);
			dropdown.selectByVisibleText(text);
			Thread.sleep(2000);
			// dropdown.selectByIndex(1);
			ATUReports.add(" user selected the Rating ", LogAs.PASSED, new CaptureScreen(ScreenshotOf.DESKTOP));
		} catch (NoSuchElementException e) {

			ATUReports.add("No element found ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.DESKTOP));
		} catch (WebDriverException e) {
			System.out.print("Error message" + e);
			ATUReports.add("No driver found ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.DESKTOP));
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
					new CaptureScreen(ScreenshotOf.DESKTOP));

			Thread.sleep(2000);

			// dropdown.selectByVisibleText(text);

			Thread.sleep(2000);
			// dropdown.selectByIndex(1);
			ATUReports.add(" user selected the Rating ", LogAs.PASSED, new CaptureScreen(ScreenshotOf.DESKTOP));
		} catch (NoSuchElementException e) {

			ATUReports.add("No element found ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.DESKTOP));
		} catch (WebDriverException e) {
			ATUReports.add("No driver found ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.DESKTOP));
		} finally {
			takeSnap();
		}
	}

	// ==============

	public void selectbyindexvalue(String id, int text) throws InterruptedException {
		try {
			Select dropdown = new Select(driver.findElementById(id));

			ATUReports.add(" List Values are loaded in to Dropdown ", LogAs.PASSED,
					new CaptureScreen(ScreenshotOf.DESKTOP));
			Thread.sleep(1000);
			// dropdown.selectByVisibleText(text);
			dropdown.selectByIndex(text);
			ATUReports.add(" user selected the Rating ", LogAs.PASSED, new CaptureScreen(ScreenshotOf.DESKTOP));
		} catch (NoSuchElementException e) {

			ATUReports.add("No element found ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.DESKTOP));
		} catch (WebDriverException e) {
			ATUReports.add("No driver found ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.DESKTOP));
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
					new CaptureScreen(ScreenshotOf.DESKTOP));
			Thread.sleep(1000);
			// dropdown.selectByVisibleText(text);
			dropdown.selectByIndex(text);
			ATUReports.add(" user selected the Rating ", LogAs.PASSED, new CaptureScreen(ScreenshotOf.DESKTOP));
		} catch (NoSuchElementException e) {

			ATUReports.add("index value not found", LogAs.FAILED, new CaptureScreen(ScreenshotOf.DESKTOP));
		} catch (WebDriverException e) {
			ATUReports.add("index value not found ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.DESKTOP));
		} finally {
			takeSnap();
		}
	}

	// ==============

	// verified actual element is presented ....

	public void elementfindedbyid(String id) throws InterruptedException {
		try {
			driver.findElementById(id);
			ATUReports.add(" Element finded by id value ", LogAs.PASSED, new CaptureScreen(ScreenshotOf.DESKTOP));
			Thread.sleep(1000);
		} catch (NoSuchElementException e) {

			ATUReports.add("Element not finded by id value ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.DESKTOP));
		} catch (WebDriverException e) {
			ATUReports.add("Element not finded by id value ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.DESKTOP));
		} finally {
			takeSnap();
		}
	}

	// element find by xpath :

	public void elementfindedbyxpath(String xpath1) throws InterruptedException {
		try {
			driver.findElementByXPath(xpath1);
			ATUReports.add(" Element finded by xpath ", LogAs.PASSED, new CaptureScreen(ScreenshotOf.DESKTOP));
			Thread.sleep(1000);
		} catch (NoSuchElementException e) {

			ATUReports.add("Element not finded by xpath ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.DESKTOP));
		} catch (WebDriverException e) {
			ATUReports.add("Element not finded by xpath", LogAs.FAILED, new CaptureScreen(ScreenshotOf.DESKTOP));
		} finally {
			takeSnap();
		}
	}

	/// Element finded by name :

	public void elementfindedbyname(String name1) throws InterruptedException {
		try {
			driver.findElementByName(name1);
			ATUReports.add(" Element finded by name  ", LogAs.PASSED, new CaptureScreen(ScreenshotOf.DESKTOP));
			Thread.sleep(1000);
		} catch (NoSuchElementException e) {

			ATUReports.add("Element not finded by name  ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.DESKTOP));
		} catch (WebDriverException e) {
			ATUReports.add("Element not finded by name ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.DESKTOP));
		} finally {
			takeSnap();
		}
	}

	public void elementfindedlinktext(String linkname) throws InterruptedException {
		try {
			driver.findElementByLinkText(linkname);
			ATUReports.add(" Element finded by linkname  ", LogAs.PASSED, new CaptureScreen(ScreenshotOf.DESKTOP));
			Thread.sleep(1000);
		} catch (NoSuchElementException e) {

			ATUReports.add("Element not finded by linkname  ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.DESKTOP));
		} catch (WebDriverException e) {
			ATUReports.add("Element not finded by linkname ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.DESKTOP));
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

			ATUReports.add("keyboard space  Action Done", LogAs.PASSED, new CaptureScreen(ScreenshotOf.DESKTOP));
		}

		catch (WebDriverException e) {
			ATUReports.add("Keyboard space Action  not Done ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.DESKTOP));
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

			
			ATUReports.add("keyboard tab  Action Done", LogAs.PASSED, new CaptureScreen(ScreenshotOf.DESKTOP));
		}

		catch (WebDriverException e) {
			ATUReports.add("Keyboard tab Action  not Done ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.DESKTOP));
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

			ATUReports.add("keyboard space  Action Done", LogAs.PASSED, new CaptureScreen(ScreenshotOf.DESKTOP));
		}

		catch (WebDriverException e) {
			ATUReports.add("Keyboard space Action  not Done ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.DESKTOP));
		} finally {
			takeSnap();
		}
	}

	// =============

	public void selectbyvalue(String id, String text) throws InterruptedException {
		try {
			Select dropdown = new Select(driver.findElementById(id));

			ATUReports.add(" List Values are loaded in to Dropdown ", LogAs.PASSED,
					new CaptureScreen(ScreenshotOf.DESKTOP));
			Thread.sleep(1000);
			dropdown.selectByVisibleText(text);
			ATUReports.add(" user selected the Rating ", LogAs.PASSED, new CaptureScreen(ScreenshotOf.DESKTOP));
		} catch (NoSuchElementException e) {

			ATUReports.add("No element found ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.DESKTOP));
		} catch (WebDriverException e) {
			ATUReports.add("No driver found ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.DESKTOP));
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
					new CaptureScreen(ScreenshotOf.DESKTOP));
			Thread.sleep(1000);
			dropdown.selectByVisibleText(text);
			ATUReports.add(" user selected the Rating ", LogAs.PASSED, new CaptureScreen(ScreenshotOf.DESKTOP));
		} catch (NoSuchElementException e) {

			ATUReports.add("No element found ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.DESKTOP));
		} catch (WebDriverException e) {
			ATUReports.add("No driver found ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.DESKTOP));
		} finally {
			takeSnap();
		}
	}

	// ==============================

	public void clickbyclassname(String name)

	{
		try {
			driver.findElementByClassName(name).click();
			ATUReports.add("User clicked the Submit Button", LogAs.PASSED, new CaptureScreen(ScreenshotOf.DESKTOP));
		} catch (NoSuchElementException e) {

			ATUReports.add("No element found ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.DESKTOP));
		} catch (WebDriverException e) {
			ATUReports.add("No driver found ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.DESKTOP));
		} finally {
			takeSnap();
		}
	}

	public void clickbyid(String id)

	{
		try {
			driver.findElementById(id).click();
			ATUReports.add("User clicked the Submit Button", LogAs.PASSED, new CaptureScreen(ScreenshotOf.DESKTOP));
		} catch (NoSuchElementException e) {

			ATUReports.add("No element found ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.DESKTOP));
		} catch (WebDriverException e) {
			//ATUReports.add("No driver found ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.DESKTOP));
		} finally {
			takeSnap();
		}
	}

	public void clickbyname(String name) {
		try {
			driver.findElementByName(name).click();

			ATUReports.add("User clicked the Submit Button", LogAs.PASSED, new CaptureScreen(ScreenshotOf.DESKTOP));
		} catch (NoSuchElementException e) {

			ATUReports.add("No element found ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.DESKTOP));
		} catch (WebDriverException e) {
			ATUReports.add("No driver found ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.DESKTOP));
		} finally {
			takeSnap();
		}
	}

	public void close()

	{

		driver.close();

		//ATUReports.add("Browser got closed", LogAs.PASSED, new CaptureScreen(ScreenshotOf.DESKTOP));

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

			ATUReports.add("TAb Action Done", LogAs.PASSED, new CaptureScreen(ScreenshotOf.DESKTOP));
		}

		catch (WebDriverException e) {
			ATUReports.add("Tab Action not Done ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.DESKTOP));
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

			ATUReports.add("TAb Action Done", LogAs.PASSED, new CaptureScreen(ScreenshotOf.DESKTOP));
		}

		catch (WebDriverException e) {
			//ATUReports.add("Tab Action not Done ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.DESKTOP));
		} finally {
			takeSnap();
		}
	}

	// entr by xpath

	public void Enterr() {
		try {
			element.sendKeys(Keys.ENTER);

			ATUReports.add("Enter Action Done", LogAs.PASSED, new CaptureScreen(ScreenshotOf.DESKTOP));
		} catch (WebDriverException e) {
			ATUReports.add("Enter Action not Done ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.DESKTOP));
		} finally {
			takeSnap();
		}
	}
	
	//================================
	
	//Clicking the ECS button in the keyboard 
	
	public void Ecs() {
		try {
			element.sendKeys(Keys.ESCAPE);

			ATUReports.add("Enter Action Done", LogAs.PASSED, new CaptureScreen(ScreenshotOf.DESKTOP));
		} catch (WebDriverException e) {
			ATUReports.add("Enter Action not Done ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.DESKTOP));
		} finally {
			takeSnap();
		}
	}

	

	//================================================================
	
	// ===Click by CSS

	public void clickbycssselector(String xpt1) {

		try {

			driver.findElementByCssSelector(xpt1).click();

			ATUReports.add("CSSselector  got clicked ", LogAs.PASSED, new CaptureScreen(ScreenshotOf.DESKTOP));
		} catch (NoSuchElementException e) {

			ATUReports.add("No element found ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.DESKTOP));
		} catch (WebDriverException e) {
			ATUReports.add("No driver found ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.DESKTOP));
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
			
			
			ATUReports.add("Element found ", LogAs.PASSED, new CaptureScreen(ScreenshotOf.DESKTOP));
			}
			
			else
			{
			//	ATUReports.add("No element found ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.DESKTOP));
			}

			// ATUReports.add("ID element got clicked ", LogAs.PASSED, new
			// CaptureScreen(ScreenshotOf.DESKTOP));
		} catch (NoSuchElementException e) {

			//ATUReports.add("No element found ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.DESKTOP));
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
			// CaptureScreen(ScreenshotOf.DESKTOP));
		} catch (NoSuchElementException e) {

			ATUReports.add("No element found ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.DESKTOP));
		} catch (WebDriverException e) {
			ATUReports.add("No driver found ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.DESKTOP));
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
	 * CaptureScreen(ScreenshotOf.DESKTOP));
	 * 
	 * }catch (NoSuchElementException e) {
	 * 
	 * ATUReports.add("No element found ", LogAs.FAILED, new
	 * CaptureScreen(ScreenshotOf.DESKTOP)); } catch (WebDriverException e) {
	 * ATUReports.add("No driver found ", LogAs.FAILED, new
	 * CaptureScreen(ScreenshotOf.DESKTOP)); } }finally { takeSnap(); } }
	 */

	// System sleep time

	public void sleep() throws Exception {
		try {
			Thread.sleep(4000);
			// ATUReports.add("waiting sleep time", LogAs.PASSED, new
			// CaptureScreen(ScreenshotOf.DESKTOP));

		} catch (WebDriverException e) {
			// ATUReports.add("waiting sleep time failed", LogAs.FAILED, new
			// CaptureScreen(ScreenshotOf.DESKTOP));
		}
	}

	// public void How to iterate a list of WebElements

	/*
	 * public void iterativewebelementsbyindex(String id,String count) throws
	 * Exception { try {
	 * 
	 * driver.findElement(by) ATUReports.add("waiting sleep time", LogAs.PASSED,
	 * new CaptureScreen(ScreenshotOf.DESKTOP));
	 * 
	 * } catch (WebDriverException e) { ATUReports.add(
	 * "waiting sleep time failed", LogAs.FAILED, new
	 * CaptureScreen(ScreenshotOf.DESKTOP)); } }
	 */
	// driver Close

	// Gettext

	public void gettext(String xpath) throws Exception {
		try {
			Thread.sleep(2000);
			String jobid = driver.findElementByXPath("xpath").getText();

			ATUReports.add("capture the  message as" + jobid + "xpath", LogAs.PASSED,
					new CaptureScreen(ScreenshotOf.DESKTOP));

		} catch (WebDriverException e) {
			ATUReports.add("user unable to capture the message", LogAs.FAILED, new CaptureScreen(ScreenshotOf.DESKTOP));
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
						new CaptureScreen(ScreenshotOf.DESKTOP));
			} else {
				ATUReports.add("Error message" + "No Error message  displayed" + "", LogAs.PASSED,
						new CaptureScreen(ScreenshotOf.DESKTOP));
			}
		} catch (NoSuchElementException e) {

			ATUReports.add("No element found ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.DESKTOP));
		} catch (WebDriverException e) {
			ATUReports.add("No driver found ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.DESKTOP));
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

			ATUReports.add("switch to iframe" + "" + "xpath", LogAs.PASSED, new CaptureScreen(ScreenshotOf.DESKTOP));

		} catch (WebDriverException e) {
			ATUReports.add("user unable switch to iframe", LogAs.FAILED, new CaptureScreen(ScreenshotOf.DESKTOP));
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
			// CaptureScreen(ScreenshotOf.DESKTOP));
		} catch (NoSuchElementException e) {

			ATUReports.add("No element found ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.DESKTOP));
		} catch (WebDriverException e) {
			ATUReports.add("No driver found ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.DESKTOP));
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

			ATUReports.add("No element found ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.DESKTOP));
		} catch (WebDriverException e) {
			ATUReports.add("No driver found ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.DESKTOP));
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

			ATUReports.add("No element found ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.DESKTOP));
		} catch (WebDriverException e) {
			ATUReports.add("No driver found ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.DESKTOP));
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

			ATUReports.add("No element found ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.DESKTOP));
		} catch (WebDriverException e) {
			ATUReports.add("No driver found ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.DESKTOP));
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

//			ATUReports.add("No element found ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.DESKTOP));
		} catch (WebDriverException e) {
	//		ATUReports.add("No driver found ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.DESKTOP));
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

			//ATUReports.add("No element found ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.DESKTOP));
		} catch (WebDriverException e) {
			//ATUReports.add("No driver found ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.DESKTOP));
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

			ATUReports.add("No element found ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.DESKTOP));
		} catch (WebDriverException e) {
			ATUReports.add("No driver found ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.DESKTOP));
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

			ATUReports.add("No element found ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.DESKTOP));
		} catch (WebDriverException e) {
			ATUReports.add("No driver found ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.DESKTOP));
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
			// CaptureScreen(ScreenshotOf.DESKTOP));
		} catch (NoSuchElementException e) {

			// ATUReports.add("No element found ", LogAs.FAILED, new
			// CaptureScreen(ScreenshotOf.DESKTOP));
		} catch (WebDriverException e) {
			// ATUReports.add("No driver found ", LogAs.FAILED, new
			// CaptureScreen(ScreenshotOf.DESKTOP));
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

			ATUReports.add("xpath element got clicked ", LogAs.PASSED, new CaptureScreen(ScreenshotOf.DESKTOP));
		} catch (NoSuchElementException e) {

			ATUReports.add("No element found ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.DESKTOP));
		} catch (WebDriverException e) {
			ATUReports.add("No driver found ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.DESKTOP));
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
				// CaptureScreen(ScreenshotOf.DESKTOP));

				ATUReports.add("value not mathces" + gettext1 + "", LogAs.PASSED,new CaptureScreen(ScreenshotOf.DESKTOP));

			} else 
			{
				ATUReports.add("value mathces" + gettext1 + "", LogAs.FAILED,new CaptureScreen(ScreenshotOf.DESKTOP));
			}

			// ATUReports.add("xpath element got clicked ", LogAs.PASSED, new
			// CaptureScreen(ScreenshotOf.DESKTOP));
		} catch (NoSuchElementException e) {

			// ATUReports.add("No element found ", LogAs.FAILED, new
			// CaptureScreen(ScreenshotOf.DESKTOP));
		} catch (WebDriverException e) {
			// ATUReports.add("No driver found ", LogAs.FAILED, new
			// CaptureScreen(ScreenshotOf.DESKTOP));
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
						new CaptureScreen(ScreenshotOf.DESKTOP));

			} else {
				ATUReports.add("Service charge not matches for child" + gettext1 + "", LogAs.FAILED,
						new CaptureScreen(ScreenshotOf.DESKTOP));
			}

			// ATUReports.add("xpath element got clicked ", LogAs.PASSED, new
			// CaptureScreen(ScreenshotOf.DESKTOP));
		} catch (NoSuchElementException e) {

			// ATUReports.add("No element found ", LogAs.FAILED, new
			// CaptureScreen(ScreenshotOf.DESKTOP));
		} catch (WebDriverException e) {
			// ATUReports.add("No driver found ", LogAs.FAILED, new
			// CaptureScreen(ScreenshotOf.DESKTOP));
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
				// CaptureScreen(ScreenshotOf.DESKTOP));

				ATUReports.add("Dicount amount reflected correctly" + gettext1 + "", LogAs.PASSED,
						new CaptureScreen(ScreenshotOf.DESKTOP));

			} else {
				ATUReports.add("Dicount amount not reflected correctly" + gettext1 + "", LogAs.FAILED,
						new CaptureScreen(ScreenshotOf.DESKTOP));
			}

			// ATUReports.add("xpath element got clicked ", LogAs.PASSED, new
			// CaptureScreen(ScreenshotOf.DESKTOP));
		} catch (NoSuchElementException e) {

			// ATUReports.add("No element found ", LogAs.FAILED, new
			// CaptureScreen(ScreenshotOf.DESKTOP));
		} catch (WebDriverException e) {
			// ATUReports.add("No driver found ", LogAs.FAILED, new
			// CaptureScreen(ScreenshotOf.DESKTOP));
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
				// CaptureScreen(ScreenshotOf.DESKTOP));

				ATUReports.add("Coupon code reflected successfully" + gettext1 + "", LogAs.PASSED,
						new CaptureScreen(ScreenshotOf.DESKTOP));

			} else {
				ATUReports.add("Coupon code not reflected" + gettext1 + "", LogAs.FAILED,
						new CaptureScreen(ScreenshotOf.DESKTOP));
			}

			// ATUReports.add("xpath element got clicked ", LogAs.PASSED, new
			// CaptureScreen(ScreenshotOf.DESKTOP));
		} catch (NoSuchElementException e) {

			// ATUReports.add("No element found ", LogAs.FAILED, new
			// CaptureScreen(ScreenshotOf.DESKTOP));
		} catch (WebDriverException e) {
			// ATUReports.add("No driver found ", LogAs.FAILED, new
			// CaptureScreen(ScreenshotOf.DESKTOP));
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
				// CaptureScreen(ScreenshotOf.DESKTOP));

				ATUReports.add("Service charge matches" + results5 + "", LogAs.PASSED,
						new CaptureScreen(ScreenshotOf.DESKTOP));

				ATUReports.add("Service charge matches" + resutls4 + "", LogAs.PASSED,
						new CaptureScreen(ScreenshotOf.DESKTOP));

			} else {
				ATUReports.add("Service charge not matches" + gettext1 + "", LogAs.FAILED,
						new CaptureScreen(ScreenshotOf.DESKTOP));
			}

			// ATUReports.add("xpath element got clicked ", LogAs.PASSED, new
			// CaptureScreen(ScreenshotOf.DESKTOP));
		} catch (NoSuchElementException e) {

			// ATUReports.add("No element found ", LogAs.FAILED, new
			// CaptureScreen(ScreenshotOf.DESKTOP));
		} catch (WebDriverException e) {
			// ATUReports.add("No driver found ", LogAs.FAILED, new
			// CaptureScreen(ScreenshotOf.DESKTOP));
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
			
						// CaptureScreen(ScreenshotOf.DESKTOP));
		} catch (NoSuchElementException e) {

			// ATUReports.add("No element found ", LogAs.FAILED, new
			// CaptureScreen(ScreenshotOf.DESKTOP));
		} catch (WebDriverException e) {
			// ATUReports.add("No driver found ", LogAs.FAILED, new
			// CaptureScreen(ScreenshotOf.DESKTOP));
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

    ATUReports.add("NotClicked ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.DESKTOP));
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
	        
	        //gettext1.Select. selectByVisibleText(“March”);
	        
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
	        		 ATUReports.add("Currency not matched ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.DESKTOP));
	        	
	    }*/

	    
	  /*  for (int j = 0; j < elements.size(); j++)
	    {
	        System.out.println(elements.get(j).getText());
	        
	        
	    }*/

	  

	   // ATUReports.add("clicked", LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
	    } catch (NoSuchElementException e) {

	   // ATUReports.add("NotClicked ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.DESKTOP));
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
	    
	    //ATUReports.add("NotClicked ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.DESKTOP));
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
			
						// CaptureScreen(ScreenshotOf.DESKTOP));
		} catch (NoSuchElementException e) {

			ATUReports.add("No element found ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.DESKTOP));
		} catch (WebDriverException e) {
			ATUReports.add("No driver found ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.DESKTOP));
		} finally {
			takeSnap();
		}*/
	}
	
//============================================================================
	
	//Page Field comparios
	
	public void elementfindedbyxpathnegtive(String xpath1) throws InterruptedException {
		try {
			driver.findElementByXPath(xpath1);
			ATUReports.add(" Element finded by xpath ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.DESKTOP));
			Thread.sleep(1000);
		} catch (NoSuchElementException e) {

			ATUReports.add("Element not finded by xpath ", LogAs.PASSED, new CaptureScreen(ScreenshotOf.DESKTOP));
		} catch (WebDriverException e) {
			ATUReports.add("Element not finded by xpath", LogAs.PASSED, new CaptureScreen(ScreenshotOf.DESKTOP));
		} finally {
			takeSnap();
		}
	}

	//=================================================
	
	public void elementfindedbyxpathnegtive1(String xpath1) throws InterruptedException {
		try {
			driver.findElementByXPath(xpath1);
			ATUReports.add(" Element Finded by xpath ", LogAs.PASSED, new CaptureScreen(ScreenshotOf.DESKTOP));
			Thread.sleep(1000);
		} catch (NoSuchElementException e) {

			ATUReports.add("Element not finded by xpath ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.DESKTOP));
		} catch (WebDriverException e) {
			ATUReports.add("Element not finded by xpath", LogAs.FAILED, new CaptureScreen(ScreenshotOf.DESKTOP));
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

			ATUReports.add("NotClicked ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.DESKTOP));
		} catch (WebDriverException e) {
			// ATUReports.add("No driver found ", LogAs.FAILED, new
			// CaptureScreen(ScreenshotOf.DESKTOP));
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
    		ATUReports.add("Value changed ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.DESKTOP));
     }

    }
    
    } 
    catch (NoSuchElementException e) 
    {
    ATUReports.add("NotClicked ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.DESKTOP));
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

				//ATUReports.add(" User Entered the text as " + "", LogAs.PASSED, new CaptureScreen(ScreenshotOf.DESKTOP));
			} catch (NoSuchElementException e) {

				//ATUReports.add("No element found ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.DESKTOP));
			} catch (WebDriverException e) {
				//ATUReports.add("No driver found ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.DESKTOP));
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

					//ATUReports.add(" User Entered the text as " + "", LogAs.PASSED, new CaptureScreen(ScreenshotOf.DESKTOP));
				} catch (NoSuchElementException e) {

					//ATUReports.add("No element found ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.DESKTOP));
				} catch (WebDriverException e) {
					//ATUReports.add("No driver found ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.DESKTOP));
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

					//ATUReports.add(" User Entered the text as " + "", LogAs.PASSED, new CaptureScreen(ScreenshotOf.DESKTOP));
				} catch (NoSuchElementException e) {

					//ATUReports.add("No element found ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.DESKTOP));
				} catch (WebDriverException e) {
					//ATUReports.add("No driver found ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.DESKTOP));
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

					//ATUReports.add(" User Entered the text as " + "", LogAs.PASSED, new CaptureScreen(ScreenshotOf.DESKTOP));
				} catch (NoSuchElementException e) {

					//ATUReports.add("No element found ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.DESKTOP));
				} catch (WebDriverException e) {
					//ATUReports.add("No driver found ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.DESKTOP));
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
						// CaptureScreen(ScreenshotOf.DESKTOP));

						ATUReports.add("Currency reflected correctly" + gettext1 + "", LogAs.PASSED,
								new CaptureScreen(ScreenshotOf.DESKTOP));

					} else {
						ATUReports.add("Currency  not reflected correctly" + gettext1 + "", LogAs.FAILED,
								new CaptureScreen(ScreenshotOf.DESKTOP));
					}

					// ATUReports.add("xpath element got clicked ", LogAs.PASSED, new
					// CaptureScreen(ScreenshotOf.DESKTOP));
				} catch (NoSuchElementException e) {

					// ATUReports.add("No element found ", LogAs.FAILED, new
					// CaptureScreen(ScreenshotOf.DESKTOP));
				} catch (WebDriverException e) {
					// ATUReports.add("No driver found ", LogAs.FAILED, new
					// CaptureScreen(ScreenshotOf.DESKTOP));
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

					ATUReports.add(" User Entered the text as " + d, LogAs.PASSED, new CaptureScreen(ScreenshotOf.DESKTOP));
				} catch (NoSuchElementException e) {
					System.out.print("Error messgae is" + e);
					ATUReports.add("No element found ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.DESKTOP));
				} catch (WebDriverException e) {
					ATUReports.add("No driver found ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.DESKTOP));
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
						ATUReports.add(" AR matching Done successfully" + foo, LogAs.PASSED, new CaptureScreen(ScreenshotOf.DESKTOP));
					}
					else
					{
						ATUReports.add(" AR matching Not Done successfully " + foo, LogAs.FAILED, new CaptureScreen(ScreenshotOf.DESKTOP));
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
						ATUReports.add(" AR unmatching Done successfully" + foo, LogAs.PASSED, new CaptureScreen(ScreenshotOf.DESKTOP));
					}
					else
					{
						ATUReports.add(" AR unmatching Not Done successfully " + foo, LogAs.FAILED, new CaptureScreen(ScreenshotOf.DESKTOP));
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
						ATUReports.add(" AR unmatching Done successfully" + foo, LogAs.PASSED, new CaptureScreen(ScreenshotOf.DESKTOP));
					}
					else
					{
						ATUReports.add(" AR unmatching Not Done successfully " + foo, LogAs.FAILED, new CaptureScreen(ScreenshotOf.DESKTOP));
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
	         //ATUReports.add("created details are " + store1, LogAs.PASSED, new CaptureScreen(ScreenshotOf.DESKTOP));
				 
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
        
      ATUReports.add("Newly created details " + store2, LogAs.PASSED, new CaptureScreen(ScreenshotOf.DESKTOP));
    	
        
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

			ATUReports.add(" User Entered the text as " + store1, LogAs.PASSED, new CaptureScreen(ScreenshotOf.DESKTOP));
		} catch (NoSuchElementException e) {

			ATUReports.add("No element found ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.DESKTOP));
		} catch (WebDriverException e) {
			ATUReports.add("No driver found ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.DESKTOP));
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
			    
			    //ATUReports.add("NotClicked ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.DESKTOP));
			    }
			    catch (Exception e) {
			    System.out.println("error");
			    } finally {
			    takeSnap();
			    }

			    }  
			
			//================================================================================

			//Listbyenter
			
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
			    
			    //ATUReports.add("NotClicked ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.DESKTOP));
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
			    //ATUReports.add("NotClicked ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.DESKTOP));
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
						

					ATUReports.add(usermessage + jobid + "xpath", LogAs.FAILED,new CaptureScreen(ScreenshotOf.DESKTOP));

					}
					else
					{
						ATUReports.add(usermessage , LogAs.PASSED,new CaptureScreen(ScreenshotOf.DESKTOP));
			
					}
					
				} catch (WebDriverException e) {
					ATUReports.add("user unable to capture the message", LogAs.FAILED, new CaptureScreen(ScreenshotOf.DESKTOP));
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
			    
			    //ATUReports.add("NotClicked ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.DESKTOP));
			    }
			    catch (Exception e) {
			    System.out.println("error");
			    } finally {
			    takeSnap();
			    }

			    }  
			
			
			

			//==================================================
			
			//Fnding lement in xpath and sending values
			
			public void findbyelementbyxpathandsend(String xpath,String xpath1) 
			{

				try {

					if (driver.findElementByXPath(xpath).isDisplayed())

					{
						driver.findElementByXPath(xpath).click();
						driver.findElementByXPath(xpath).sendKeys(xpath1);


						ATUReports.add("Element found ", LogAs.PASSED, new CaptureScreen(ScreenshotOf.DESKTOP));
					}

					else {
						// ATUReports.add("No element found ", LogAs.FAILED, new
						// CaptureScreen(ScreenshotOf.DESKTOP));
					}

					// ATUReports.add("ID element got clicked ", LogAs.PASSED, new
					// CaptureScreen(ScreenshotOf.DESKTOP));
				} catch (NoSuchElementException e) {

					//ATUReports.add("No element found ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.DESKTOP));
				} finally {
					takeSnap();
				}
			}


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
					ATUReports.add(usermessage + jobid , LogAs.PASSED,new CaptureScreen(ScreenshotOf.DESKTOP));
					}
					else
					{
					ATUReports.add(usermessage + jobid , LogAs.FAILED,new CaptureScreen(ScreenshotOf.DESKTOP));
					}		
					
					
										
				} catch (WebDriverException e) {
					ATUReports.add("user unable to capture the message", LogAs.FAILED, new CaptureScreen(ScreenshotOf.DESKTOP));
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
					ATUReports.add(usermessage + jobid , LogAs.PASSED,new CaptureScreen(ScreenshotOf.DESKTOP));
					}
					else
					{
					ATUReports.add(usermessage + jobid , LogAs.FAILED,new CaptureScreen(ScreenshotOf.DESKTOP));
					}		
					
					
										
				} catch (WebDriverException e) {
					ATUReports.add("user unable to capture the message", LogAs.FAILED, new CaptureScreen(ScreenshotOf.DESKTOP));
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
						

					ATUReports.add(usermessage + jobid , LogAs.FAILED,new CaptureScreen(ScreenshotOf.DESKTOP));

					}
					else
					{
						ATUReports.add(usermessage + jobid  , LogAs.PASSED,new CaptureScreen(ScreenshotOf.DESKTOP));
			
					}
					
				} catch (WebDriverException e) {
					ATUReports.add("user unable to capture the message", LogAs.FAILED, new CaptureScreen(ScreenshotOf.DESKTOP));
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
						 
						 ATUReports.add( usermessage + s , excelvalues+ "", LogAs.PASSED,new CaptureScreen(ScreenshotOf.DESKTOP));
	 
	                      //break;
					 
					 }
					 
						/*else
						
							ATUReports.add(usermessage , LogAs.FAILED,new CaptureScreen(ScreenshotOf.DESKTOP));
				*/
						}

					   //System.out.println(s);
					
				 
			 
				 
					//ATUReports.add(usermessage , LogAs.FAILED,new CaptureScreen(ScreenshotOf.DESKTOP));
							 
				 
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
						 
						 ATUReports.add( usermessage + s , excelvalues+ "", LogAs.PASSED,new CaptureScreen(ScreenshotOf.DESKTOP));
	 
	                      //break;
					 
					 }
					 
						/*else
						
							ATUReports.add(usermessage , LogAs.FAILED,new CaptureScreen(ScreenshotOf.DESKTOP));
				*/
						}

					   //System.out.println(s);
					
				 
			 
				 
					//ATUReports.add(usermessage , LogAs.FAILED,new CaptureScreen(ScreenshotOf.DESKTOP));
							 
				 
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
							 ATUReports.add( usermessage + s , excelvalues+ "", LogAs.PASSED,new CaptureScreen(ScreenshotOf.DESKTOP));
								
						 
						// ATUReports.add( "value is s" + s , excelvalues+ "xpath", LogAs.PASSED,new CaptureScreen(ScreenshotOf.DESKTOP));
	 
	                   //   break;
					 
					 }
					 
						else
						
							ATUReports.add(usermessage , LogAs.FAILED,new CaptureScreen(ScreenshotOf.DESKTOP));
				
						}

					   //System.out.println(s);
					
				 
			 
				 
					//ATUReports.add(usermessage , LogAs.FAILED,new CaptureScreen(ScreenshotOf.DESKTOP));
							 
				 
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
						 
						 //ATUReports.add( "value is s" + s , excelvalues+ "xpath", LogAs.PASSED,new CaptureScreen(ScreenshotOf.DESKTOP));
						 
						 ATUReports.add( usermessage + s , excelvalues+ "", LogAs.PASSED,new CaptureScreen(ScreenshotOf.DESKTOP));
							
						 
	                      break;
					 
					 }
					 
						/*else
						
							ATUReports.add(usermessage , LogAs.FAILED,new CaptureScreen(ScreenshotOf.DESKTOP));
				*/
						}

					   //System.out.println(s);
					
				 
			 
				 
					//ATUReports.add(usermessage , LogAs.FAILED,new CaptureScreen(ScreenshotOf.DESKTOP));
							 
				 
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
						 
						 ATUReports.add( "value is s" + s , excelvalues+ "xpath", LogAs.PASSED,new CaptureScreen(ScreenshotOf.DESKTOP));
	 
	                      break;
					 
					 }
					 
						else
						
							ATUReports.add(usermessage , LogAs.FAILED,new CaptureScreen(ScreenshotOf.DESKTOP));
				
						}

					   //System.out.println(s);
					
				 
			 
				 
					//ATUReports.add(usermessage , LogAs.FAILED,new CaptureScreen(ScreenshotOf.DESKTOP));
							 
				 
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
						 
						 //ATUReports.add( "value is s" + s , excelvalues+ "xpath", LogAs.PASSED,new CaptureScreen(ScreenshotOf.DESKTOP));
	 
						 ATUReports.add( usermessage + s , excelvalues+ "", LogAs.PASSED,new CaptureScreen(ScreenshotOf.DESKTOP));
							
	                      break;
					 
					 }
					 
						/*else
						
							ATUReports.add(usermessage , LogAs.FAILED,new CaptureScreen(ScreenshotOf.DESKTOP));
				*/
						}

					   //System.out.println(s);
					
				 
			 
				 
					//ATUReports.add(usermessage , LogAs.FAILED,new CaptureScreen(ScreenshotOf.DESKTOP));
							 
				 
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
						 
						 ATUReports.add( "value is s" + s , excelvalues+ "xpath", LogAs.PASSED,new CaptureScreen(ScreenshotOf.DESKTOP));
	 
	                      break;
					 
					 }
					 
						else
						
							ATUReports.add(usermessage , LogAs.FAILED,new CaptureScreen(ScreenshotOf.DESKTOP));
				
						}

					   //System.out.println(s);
					
				 
			 
				 
					//ATUReports.add(usermessage , LogAs.FAILED,new CaptureScreen(ScreenshotOf.DESKTOP));
							 
				 
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
						 
						 //ATUReports.add( "value is s" + s , excelvalues+ "xpath", LogAs.PASSED,new CaptureScreen(ScreenshotOf.DESKTOP));
	 
						 ATUReports.add( usermessage + s , excelvalues+ "", LogAs.PASSED,new CaptureScreen(ScreenshotOf.DESKTOP));
							
	                      break;
					 
					 }
					 
						/*else
						
							ATUReports.add(usermessage , LogAs.FAILED,new CaptureScreen(ScreenshotOf.DESKTOP));
				*/
						}

					   //System.out.println(s);
					
				 
			 
				 
					//ATUReports.add(usermessage , LogAs.FAILED,new CaptureScreen(ScreenshotOf.DESKTOP));
							 
				 
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
						 
						 ATUReports.add( "value is s" + s , excelvalues+ "xpath", LogAs.PASSED,new CaptureScreen(ScreenshotOf.DESKTOP));
	 
	                      break;
					 
					 }
					 
						else
						
							ATUReports.add(usermessage , LogAs.FAILED,new CaptureScreen(ScreenshotOf.DESKTOP));
				
						}

					   //System.out.println(s);
					
				 
			 
				 
					//ATUReports.add(usermessage , LogAs.FAILED,new CaptureScreen(ScreenshotOf.DESKTOP));
							 
				 
			 }

			 


			 //sending value by xpath if element is found
			 
			 //===============================================================================
			 
				public void findelementandsendtextbyxvalue(String xva, String txt) {
					try {
					if (driver.findElementByXPath(xva).isDisplayed())
			                 {
						driver.findElementByXPath(xva).clear();
						driver.findElementByXPath(xva).sendKeys(txt);

						ATUReports.add(" User Entered the text as " + txt, LogAs.PASSED, new CaptureScreen(ScreenshotOf.DESKTOP));
						}
					} catch (NoSuchElementException e) {

						ATUReports.add("No element found ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.DESKTOP));
					} catch (WebDriverException e) {
						ATUReports.add("No driver found ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.DESKTOP));
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
						ATUReports.add(" User Entered the text as " + txt, LogAs.PASSED, new CaptureScreen(ScreenshotOf.DESKTOP));
					} catch (NoSuchElementException e) {

						ATUReports.add("No element found ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.DESKTOP));
					} catch (WebDriverException e) {
						ATUReports.add("No driver found ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.DESKTOP));
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
							 
							 ATUReports.add( usermessage ,s, LogAs.PASSED,new CaptureScreen(ScreenshotOf.DESKTOP));
		 
		                      //break;
						 
						 }
						 
							/*else
							
								ATUReports.add(usermessage , LogAs.FAILED,new CaptureScreen(ScreenshotOf.DESKTOP));
					*/
							}

						   //System.out.println(s);
						
					 
				 
					 
						//ATUReports.add(usermessage , LogAs.FAILED,new CaptureScreen(ScreenshotOf.DESKTOP));
								 
					 
				 }
				 
				 			 


				
			//======================================================================================
			 
				 //send text id withclear the records
				 
				 public void sendtextbyidnotusingclear(String id, String txt) {
						try {

							//driver.findElementById(id).clear();
							driver.findElementById(id).sendKeys(txt);
							ATUReports.add(" User Entered the text as " + txt, LogAs.PASSED, new CaptureScreen(ScreenshotOf.DESKTOP));
						} catch (NoSuchElementException e) {

							ATUReports.add("No element found ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.DESKTOP));
						} catch (WebDriverException e) {
							ATUReports.add("No driver found ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.DESKTOP));
						} finally {
							takeSnap();
						}
					}

				 //==============================================================================
				 
				 public void sendtextbyxvaluewihtoutclear(String xva, String txt) {
						try {
							//driver.findElementByXPath(xva).clear();
							driver.findElementByXPath(xva).sendKeys(txt);

							ATUReports.add(" User Entered the text as " + txt, LogAs.PASSED, new CaptureScreen(ScreenshotOf.DESKTOP));
						} catch (NoSuchElementException e) {

							ATUReports.add("No element found ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.DESKTOP));
						} catch (WebDriverException e) {
							ATUReports.add("No driver found ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.DESKTOP));
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

							ATUReports.add(" User Entered the text as " + txt, LogAs.PASSED, new CaptureScreen(ScreenshotOf.DESKTOP));
						} catch (NoSuchElementException e) {

							ATUReports.add("No element found ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.DESKTOP));
						} catch (WebDriverException e) {
							ATUReports.add("No driver found ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.DESKTOP));
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
							
						ATUReports.add(" User Entered the text as " + txt, LogAs.PASSED, new CaptureScreen(ScreenshotOf.DESKTOP));
						} catch (NoSuchElementException e) {

							ATUReports.add("No element found ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.DESKTOP));
						} catch (WebDriverException e) {
							ATUReports.add("No driver found ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.DESKTOP));
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
					    
					    //ATUReports.add("NotClicked ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.DESKTOP));
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
								   ATUReports.add("Record number" + "" , jobid, LogAs.PASSED,new CaptureScreen(ScreenshotOf.DESKTOP));
								   
					               // driver.findElementByXPath(xpath1).sendKeys(Keys.ENTER);

								     Thread.sleep(100);
								    
								   // ATUReports.add("value not captured  ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.DESKTOP));
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
									            ATUReports.add(usermessage, LogAs.PASSED, new CaptureScreen(ScreenshotOf.DESKTOP));
												
									        }
												} catch (NoSuchElementException e) {

										  ATUReports.add(usermessage1, LogAs.FAILED, new CaptureScreen(ScreenshotOf.DESKTOP));
										} catch (WebDriverException e) {
											//ATUReports.add("No driver found ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.DESKTOP));
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
									            ATUReports.add(usermessage, LogAs.PASSED, new CaptureScreen(ScreenshotOf.DESKTOP));
												
									        }
												} catch (NoSuchElementException e) {

										  ATUReports.add(usermessage1, LogAs.FAILED, new CaptureScreen(ScreenshotOf.DESKTOP));
										} catch (WebDriverException e) {
											//ATUReports.add("No driver found ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.DESKTOP));
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
										ATUReports.add("Mouse moved over to the Manage ", LogAs.PASSED, new CaptureScreen(ScreenshotOf.DESKTOP));
										//driver.findElementByLinkText(lnk).click();
										//ATUReports.add("User clicked the " + "" + "link", LogAs.PASSED, new CaptureScreen(ScreenshotOf.DESKTOP));
									} catch (NoSuchElementException e) {

										ATUReports.add("No element found ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.DESKTOP));
									} catch (WebDriverException e) {
										ATUReports.add("No driver found ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.DESKTOP));
									} finally {
										takeSnap();
									}
								}

								
								
		//===============================================================================
								
								
							
								public void findbyelementbyxpath(String xpath,String usermessage) 
								{

									try {

										if (driver.findElementByXPath(xpath).isDisplayed())
											
										ATUReports.add(usermessage, LogAs.PASSED, new CaptureScreen(ScreenshotOf.DESKTOP));
										
										// ATUReports.add("ID element got clicked ", LogAs.PASSED, new CaptureScreen(ScreenshotOf.DESKTOP));
									} catch (NoSuchElementException e) {

										ATUReports.add("No element found ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.DESKTOP));
									} catch (WebDriverException e) {
										ATUReports.add("No driver found ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.DESKTOP));
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
											
										ATUReports.add(usermessage, LogAs.PASSED, new CaptureScreen(ScreenshotOf.DESKTOP));
										}
										// ATUReports.add("ID element got clicked ", LogAs.PASSED, new CaptureScreen(ScreenshotOf.DESKTOP));
									} catch (NoSuchElementException e) {

										ATUReports.add(usermessage1, LogAs.FAILED, new CaptureScreen(ScreenshotOf.DESKTOP));
									} catch (WebDriverException e) {
										//ATUReports.add("No driver found ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.DESKTOP));
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
											
										
											
										ATUReports.add(usermessage, LogAs.PASSED, new CaptureScreen(ScreenshotOf.DESKTOP));
										
										// ATUReports.add("ID element got clicked ", LogAs.PASSED, new CaptureScreen(ScreenshotOf.DESKTOP));
									} catch (NoSuchElementException e) {

										ATUReports.add(usermessage1, LogAs.FAILED, new CaptureScreen(ScreenshotOf.DESKTOP));
									} catch (WebDriverException e) {
										//ATUReports.add("No driver found ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.DESKTOP));
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
											
										
											
										ATUReports.add(usermessage, LogAs.PASSED, new CaptureScreen(ScreenshotOf.DESKTOP));
										
										// ATUReports.add("ID element got clicked ", LogAs.PASSED, new CaptureScreen(ScreenshotOf.DESKTOP));
									} catch (NoSuchElementException e) {

										ATUReports.add(usermessage1, LogAs.FAILED, new CaptureScreen(ScreenshotOf.DESKTOP));
									} catch (WebDriverException e) {
										//ATUReports.add("No driver found ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.DESKTOP));
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

											ATUReports.add(usermessage, LogAs.FAILED, new CaptureScreen(ScreenshotOf.DESKTOP));
										}
										// ATUReports.add("ID element got clicked ", LogAs.PASSED, new CaptureScreen(ScreenshotOf.DESKTOP));
									} catch (NoSuchElementException e) {

										ATUReports.add(usermessage1, LogAs.PASSED, new CaptureScreen(ScreenshotOf.DESKTOP));
									} catch (WebDriverException e) {
										//ATUReports.add("No driver found ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.DESKTOP));
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
									ATUReports.add(usermessage, LogAs.FAILED, new CaptureScreen(ScreenshotOf.DESKTOP));
									
									} 
									catch (NoSuchElementException e)
									
									{

									ATUReports.add(usermessage1, LogAs.PASSED, new CaptureScreen(ScreenshotOf.DESKTOP));
									} catch (WebDriverException e) {
										//ATUReports.add("No driver found ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.DESKTOP));
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
										
										
										ATUReports.add("Element found ", LogAs.PASSED, new CaptureScreen(ScreenshotOf.DESKTOP));
										}
										
										else
										{
										//	ATUReports.add("No element found ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.DESKTOP));
										}

										// ATUReports.add("ID element got clicked ", LogAs.PASSED, new
										// CaptureScreen(ScreenshotOf.DESKTOP));
									} catch (NoSuchElementException e) {

										//ATUReports.add("No element found ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.DESKTOP));
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
								    
								    //ATUReports.add("NotClicked ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.DESKTOP));
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

								}

								
   //========================================================================
								
//====================================================================================================================
								

								public void checkingtextfieldisenablednegativescenarios(String xpt1,String Usermessage,String Usermessage1 ) {

									try {
										
										driver.findElementByXPath(xpt1).clear();
										
										ATUReports.add(Usermessage1, LogAs.FAILED, new CaptureScreen(ScreenshotOf.DESKTOP));
									} catch (NoSuchElementException e) {

									ATUReports.add(Usermessage , LogAs.PASSED, new CaptureScreen(ScreenshotOf.DESKTOP));
									} catch (WebDriverException e) {
										ATUReports.add(Usermessage, LogAs.PASSED, new CaptureScreen(ScreenshotOf.DESKTOP));
									} finally {
										takeSnap();
									}
								}

								
//=======================================================================================================


								public void checkingtextfieldisenabledpositivescenarios(String xpt1,String Usermessage,String Usermessage1 ) {

									try {
										
										driver.findElementByXPath(xpt1).clear();
										
										ATUReports.add(Usermessage1, LogAs.PASSED, new CaptureScreen(ScreenshotOf.DESKTOP));
									} catch (NoSuchElementException e) {

									ATUReports.add(Usermessage , LogAs.FAILED, new CaptureScreen(ScreenshotOf.DESKTOP));
									} catch (WebDriverException e) {
										ATUReports.add(Usermessage, LogAs.FAILED, new CaptureScreen(ScreenshotOf.DESKTOP));
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
										
										ATUReports.add(Usermessage1, LogAs.PASSED, new CaptureScreen(ScreenshotOf.DESKTOP));
									} catch (NoSuchElementException e) {

									//ATUReports.add(Usermessage , LogAs.FAILED, new CaptureScreen(ScreenshotOf.DESKTOP));
							
									} catch (WebDriverException e) {
										//ATUReports.add(Usermessage, LogAs.FAILED, new CaptureScreen(ScreenshotOf.DESKTOP));
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
										
										ATUReports.add(Usermessage1, LogAs.PASSED, new CaptureScreen(ScreenshotOf.DESKTOP));
									} catch (NoSuchElementException e) {

									//ATUReports.add(Usermessage , LogAs.FAILED, new CaptureScreen(ScreenshotOf.DESKTOP));
							
									} catch (WebDriverException e) {
										//ATUReports.add(Usermessage, LogAs.FAILED, new CaptureScreen(ScreenshotOf.DESKTOP));
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
										 ATUReports.add( usermessage + s , ""+ s, LogAs.PASSED,new CaptureScreen(ScreenshotOf.DESKTOP));
										 	
											 
											 
										
											}
									 
								 
									 
									//	ATUReports.add("Message not capture" , LogAs.FAILED,new CaptureScreen(ScreenshotOf.DESKTOP));
												 
									 
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
																 ATUReports.add( usermessage + s , ""+ s, LogAs.PASSED,new CaptureScreen(ScreenshotOf.DESKTOP));
																 	
																	 
																	 
																 {
																	 
																	// ATUReports.add( usermessage + s , ""+ "", LogAs.PASSED,new CaptureScreen(ScreenshotOf.DESKTOP));
												 
												                      //break;
																 
																 }
																 
																	/*else
																	
																		ATUReports.add(usermessage , LogAs.FAILED,new CaptureScreen(ScreenshotOf.DESKTOP));
															*/
																	}

																   //System.out.println(s);
																
															 
														 
															 
																//ATUReports.add(usermessage , LogAs.FAILED,new CaptureScreen(ScreenshotOf.DESKTOP));
																		 
															 
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
												ATUReports.add("matching Done successfully" + Totalamountt, LogAs.PASSED, new CaptureScreen(ScreenshotOf.DESKTOP));
											}
											else
											{
												ATUReports.add("nmatching Not Done successfully " + Totalamountt, LogAs.FAILED, new CaptureScreen(ScreenshotOf.DESKTOP));
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

											ATUReports.add("TAb Action Done", LogAs.PASSED, new CaptureScreen(ScreenshotOf.DESKTOP));
										}

										catch (WebDriverException e) {
											//ATUReports.add("Tab Action not Done ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.DESKTOP));
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
									    //ATUReports.add("NotClicked ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.DESKTOP));
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
								    	Thread.sleep(300);
								    List<WebElement> list = driver.findElements(By.xpath(xpath1));    
								    Thread.sleep(200);
								    System.out.println("List Size is"+ +list.size());
								    String  gtxt = driver.findElementByXPath(xpath1).getText();	
								    Thread.sleep(200);
								    int foo = Integer.parseInt(value);
								    Thread.sleep(100);
								   list.get(foo).click();
					               ATUReports.add(Positivemessages, gtxt, LogAs.PASSED, new CaptureScreen(ScreenshotOf.DESKTOP));
								     Thread.sleep(100);
								  
								    }			    
								    
								    catch (NoSuchElementException e) 
								    {
								    	ATUReports.add(Negativemessages, LogAs.FAILED, new CaptureScreen(ScreenshotOf.DESKTOP));
										} 
								    catch (Exception e) {
								    	ATUReports.add(Negativemessages, LogAs.FAILED, new CaptureScreen(ScreenshotOf.DESKTOP));
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
						               ATUReports.add(Negativemessages, gtxt, LogAs.FAILED, new CaptureScreen(ScreenshotOf.DESKTOP));
									     Thread.sleep(100);
									  
									    }			    
									    
									    catch (NoSuchElementException e) 
									    {
									    	ATUReports.add(Positivemessages, LogAs.PASSED, new CaptureScreen(ScreenshotOf.DESKTOP));
											} 
									    catch (Exception e) {
									    	ATUReports.add(Positivemessages, LogAs.PASSED, new CaptureScreen(ScreenshotOf.DESKTOP));
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
								   
								          ATUReports.add(Positivemessages, LogAs.PASSED, new CaptureScreen(ScreenshotOf.DESKTOP));
								    	}
								    	
								    		else
								    		{
								    			 ATUReports.add(Negativemessages, LogAs.FAILED, new CaptureScreen(ScreenshotOf.DESKTOP));
											       		
									    			
								    	}
									    
									}
								    catch (WebDriverException e) {
								    	ATUReports.add("", LogAs.FAILED, new CaptureScreen(ScreenshotOf.DESKTOP));
								    } finally {
								    takeSnap();
								    }
								    }			

									
//==============================================================================================================================
					

									public void Verifythedropdownvalues(String xpath,String Positivemessage,String Negativemessages) 
									{

										try {

											if (driver.findElementByXPath(xpath).isDisplayed())
												
											ATUReports.add(Positivemessage, LogAs.PASSED, new CaptureScreen(ScreenshotOf.DESKTOP));
											
											// ATUReports.add("ID element got clicked ", LogAs.PASSED, new CaptureScreen(ScreenshotOf.DESKTOP));
										} catch (NoSuchElementException e) {

											ATUReports.add(Negativemessages, LogAs.FAILED, new CaptureScreen(ScreenshotOf.DESKTOP));
										} catch (WebDriverException e) {
											ATUReports.add(Negativemessages, LogAs.FAILED, new CaptureScreen(ScreenshotOf.DESKTOP));
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
											ATUReports.add(Positivemessage, LogAs.PASSED, new CaptureScreen(ScreenshotOf.DESKTOP));
										  
										else
											ATUReports.add(Negativemessages, LogAs.FAILED, new CaptureScreen(ScreenshotOf.DESKTOP));
												
											
											} 
										catch (NoSuchElementException e) {

											//ATUReports.add(Negativemessages, LogAs.FAILED, new CaptureScreen(ScreenshotOf.DESKTOP));
										} catch (WebDriverException e) {
											//ATUReports.add(Negativemessages, LogAs.FAILED, new CaptureScreen(ScreenshotOf.DESKTOP));
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
											System.out.println(gtxt);

											if (gtxt.contains(Verifymessages))													

//											{
											ATUReports.add(Positivemessage, LogAs.PASSED, new CaptureScreen(ScreenshotOf.DESKTOP));
										  
										else
											ATUReports.add(Negativemessages, LogAs.FAILED, new CaptureScreen(ScreenshotOf.DESKTOP));
												
											
											} 
										catch (NoSuchElementException e) {

											//ATUReports.add(Negativemessages, LogAs.FAILED, new CaptureScreen(ScreenshotOf.DESKTOP));
										} catch (WebDriverException e) {
											//ATUReports.add(Negativemessages, LogAs.FAILED, new CaptureScreen(ScreenshotOf.DESKTOP));
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
									            ATUReports.add(Positivemessage, LogAs.PASSED, new CaptureScreen(ScreenshotOf.DESKTOP));
												 
									         }
									         else {
									         //   System.out.println("'"+ str.charAt(i)+"' is a letter");
									            ATUReports.add(Negativemessages, LogAs.FAILED, new CaptureScreen(ScreenshotOf.DESKTOP));
									        	
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
											ATUReports.add(Positivemessage, LogAs.PASSED, new CaptureScreen(ScreenshotOf.DESKTOP));
										  
										else
											ATUReports.add(Negativemessages, LogAs.FAILED, new CaptureScreen(ScreenshotOf.DESKTOP));
												
											
											} 
										catch (NoSuchElementException e) {

											//ATUReports.add(Negativemessages, LogAs.FAILED, new CaptureScreen(ScreenshotOf.DESKTOP));
										} catch (WebDriverException e) {
											//ATUReports.add(Negativemessages, LogAs.FAILED, new CaptureScreen(ScreenshotOf.DESKTOP));
										} catch (Exception e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										} 
										finally {
											takeSnap();
										}
									}

									
									
									
//=========================================================================================

	public void scrolldown(String id) {
		try {
			int y = driver.findElementById(id).getLocation().getY();
			((JavascriptExecutor) driver).executeScript("window.scrollBy(0," + y + ");");

			ATUReports.add("User scroll down the page ", LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		} catch (NoSuchElementException e) {

			ATUReports.add("No element found ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.DESKTOP));
		} catch (WebDriverException e) {
			ATUReports.add("No driver found ", LogAs.FAILED, new CaptureScreen(ScreenshotOf.DESKTOP));
		} finally {
			takeSnap();
		}

	}
}
