//WASTA login screen
package travlogixnegativescenarios;
import utility.Constant;
import java.io.IOException;
import java.sql.Driver;
import java.util.ArrayList;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import travlogix.Wrappermethods;
import atu.testng.reports.listeners.ATUReportsListener;
import atu.testng.reports.listeners.ConfigurationListener;
import atu.testng.reports.listeners.MethodListener;
@Listeners({ ATUReportsListener.class, ConfigurationListener.class, MethodListener.class })
public class Travelclassnegativescenarios {

	static {

		// System.setProperty("atu.reporter.config",
		// "C:\\ATUReports\\atu.properties");
		System.setProperty("atu.reporter.config", utility.Constant.ATUREPORTS);

	}

	Wrappermethods wm;

	@BeforeTest
	public void instantiation() {
		wm = new Wrappermethods();

	}

	@BeforeMethod
	public void browesrnstatiation()

	{

		wm.launchbrowser("chrome", utility.Constant.TRAVELOGIXURL);

	}

	@Test(dataProvider = "dp")
	public void logincheckK(String Username, String Password, String Leftsidemenu,String Duplicatecode
,String Commonindex,String Classtype,String Classtypeindex) throws Exception

	{

		Thread.sleep(2000);

		// wm.sendtextbyid("", );
		wm.sendtextbyid("LoginCode", Username);
		Thread.sleep(200);
		wm.sendtextbyid("Password", Password);
		Thread.sleep(200);
		wm.clickbyxpath("//input[@value='Login']");
		wm.sleep();

		// ====================Creating Branch Master negative scenarios
		// screnn===========================================================
		wm.sendtextbyid("input-items", Leftsidemenu);
		Thread.sleep(500);
		wm.clickbyid("modMAS001");
		Thread.sleep(500);
		wm.clickbyid("pgmTVL001");
		wm.sleep();
		
		

		
//		1	Travel class	Code validations [ duplicate ]	Duplicate  code should not be allowed	Need to start 

		wm.clickbyid("btnMainAdd");
	    Thread.sleep(300);
		wm.sendtextbyxvalue("//input[@name='TravelClassCode']", Duplicatecode);
		Thread.sleep(100);
		wm.clickbyxpath("//span[@class='k-icon k-i-check']");
		Thread.sleep(100);
		wm.Mousemoveover("//input[@name='TravelClassCode']");
		Thread.sleep(500);
		wm.Listnegativescearios("//div[@class='k-tooltip-content']", Commonindex,
				"Pass :  Duplicate code validations is avilable " + "",
				"Fail:  Duplicate codee validations is not avilable " + "");
		Thread.sleep(350);
		
		
		

		
//	2	Travel class	Data Validations	From and to validations	Need to start 

		wm.Clearbyxpath("//input[@name='ActiveFrom']");
		Thread.sleep(100);
		wm.clickbyxpath("//span[@class='k-icon k-i-check']");
		Thread.sleep(100);
		wm.Mousemoveover("//input[@name='ActiveFrom']");
		Thread.sleep(500);
		wm.Listnegativescearios(utility.Constant.Travelogixuitooltipvalidation, Commonindex,
				"Pass :  Date validations is avilable " + "",
				"Fail:  Date validations is not avilable " + "");
	
		Thread.sleep(800);
		
	
//3	Travel class	Clear functioanltiy	Shstem should clear the record 	Need to start 

		wm.clickbyid("btnMainClear");
		wm.sleep();
		wm.sleep();
		wm.Listnegativescearios("//*[@class='text-uppercase']", Commonindex,
				"Pass :  Clear functionality is working fine" + "",
				"Fail:  Clear functionality is not working fine" + "");
					
		wm.sleep();
	}

	@AfterMethod
	public void close()

	{
		wm.close();

	}

	@DataProvider(name = "dp")
	public Object[][] dp() throws IOException {

		return Wrappermethods.getSheet("Travelclassnegativescenarios", "Travelclassnegativescenarios");

	}
}