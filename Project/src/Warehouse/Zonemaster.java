//WASTA login screen
package Warehouse;

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
public class Zonemaster {

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

		// wm.launchbrowser("chrome", utility.Constant.WAREHOUSEURL);

		wm.launchbrowser("chrome", "http://webuat.infodynamic.net:8083/wmsdev/");

	}

	@Test(dataProvider = "dp")
	public void logincheckK(String Username, String Password, String Searchmenu,String DockPosition) throws Exception

	{

		Thread.sleep(2000);

		// wm.sendtextbyid("", );
		wm.sendtextbyid("LoginCode", Username);
		Thread.sleep(100);
		wm.sendtextbyid("Password", Password);
		Thread.sleep(100);
		wm.clickbyxpath("//input[@value='Login']");
		wm.sleep();

		// Eneter master name in the left sideof the scree

		wm.sendtextbyid("input-items", Searchmenu);
		Thread.sleep(900);

		wm.clickbyid("modMAS001");
		Thread.sleep(200);
		wm.clickbyid("pgmZN001");
		wm.sleep();
		
		
		wm.clickbyid("btnMainAdd");
		Thread.sleep(500);
		
		wm.Listandenter("//span[@class='k-icon k-i-add']", "0");
		Thread.sleep(500);
		
		wm.stabbyxpath("//span[@aria-owns='DockStatusKey_listbox']");
		Thread.sleep(500);
		
		wm.sendtextbycssselecotrwithoutclear("#DockPosition", DockPosition);
		Thread.sleep(500);
		
		
		
		
	}

	@AfterMethod
	public void close()

	{
		wm.close();

	}

	@DataProvider(name = "dp")
	public Object[][] dp() throws IOException {

		return Wrappermethods.getSheet("Zonemaster", "Zonemaster");

	}
}