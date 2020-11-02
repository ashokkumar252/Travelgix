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
import Warehouse.Wrappermethods;
import atu.testng.reports.listeners.ATUReportsListener;
import atu.testng.reports.listeners.ConfigurationListener;
import atu.testng.reports.listeners.MethodListener;

@Listeners({ ATUReportsListener.class, ConfigurationListener.class, MethodListener.class })
public class ResourceMaster {

	static {

		// System.setProperty("atu.reporter.config",
		// "C:\\ATUReports\\atu.properties");
		System.setProperty("atu.reporter.config", "C:\\ATUReports\\atu.properties");

	}

	Wrappermethods wm;

	@BeforeTest
	public void instantiation() {
		wm = new Wrappermethods();

	}

	@BeforeMethod
	public void browesrnstatiation()

	{

		//wm.launchbrowser("chrome", utility.Constant.WAREHOUSEURL);


		wm.launchbrowser("chrome", "http://webuat.infodynamic.net:8083/wmsdev/");

		

	}

	@Test(dataProvider = "dp")
	public void logincheckK(String Username, String Password, String Searchmenu, String ResProviderCbtlKeylistbox,
			String Code, String Name,
			String ResCategoryRefKeylistbox,String ResTypeRefKeylistbox,String ResIdTypeRefKeylistbox,
			String ResIdNumber, String Statuskey,
			String ActiveFrom1,String ActiveFrom2,String ActiveFrom3,
			String ActiveTo1,String ActiveTo2,String ActiveTo3) throws Exception

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
		Thread.sleep(500);
		wm.clickbyid("pgmRE001");
		Thread.sleep(4000);
		wm.clickbyid("btnMainAdd");
		Thread.sleep(4000);
			Thread.sleep(50);
		
		  wm.clickbyxpath("//span[@aria-owns='ResProviderCbtlKey_listbox']");
		  Thread.sleep(500);
		  wm.Listandenter("//*[@id='ResProviderCbtlKey_listbox']/li",
		  ResProviderCbtlKeylistbox); Thread.sleep(500);
		  
		  wm.sendtextbycssselecotrwithoutclear("#ResCode", Code); Thread.sleep(70);
		  wm.sendtextbycssselecotrwithoutclear("#ResDescription", Name);
		  
		  Thread.sleep(500);
		  wm.clickbyxpath("//span[@aria-owns='ResCategoryRefKey_listbox']");
		  Thread.sleep(500); wm.Listandenter("//*[@id='ResCategoryRefKey_listbox']/li",
		  ResCategoryRefKeylistbox); Thread.sleep(500);
		  
		  wm.clickbyxpath("//span[@aria-owns='ResTypeRefKey_listbox']");
		  Thread.sleep(500);
		  wm.Listandenter("//*[@id='ResTypeRefKey_listbox']/li",ResTypeRefKeylistbox);
		  Thread.sleep(500);
		  
		  wm.clickbyxpath("//span[@aria-owns='ResIdTypeRefKey_listbox']");
		  Thread.sleep(500); wm.Listandenter("//*[@id='ResIdTypeRefKey_listbox']/li",
		  ResIdTypeRefKeylistbox); Thread.sleep(500);
		  
		  wm.sendtextbycssselecotrwithoutclear("#ResIdNumber", ResIdNumber);
		  Thread.sleep(100);
		  
		  wm.sendtextbycssselecotr("#ActiveFrom", "" + ActiveFrom1+ "-" + ActiveFrom2 +
		  "-" + ActiveFrom3); wm.sendtextbycssselecotr("#ActiveTo", "" + ActiveTo1+ "-"
		  + ActiveTo2 + "-" + ActiveTo3); Thread.sleep(200);
		  
		  wm.clickbyxpath("//span[@aria-owns='Status_listbox']"); Thread.sleep(500);
		  wm.Listandenter("//*[@id='Status_listbox']/li", Statuskey);
		  Thread.sleep(500); wm.stabbyxpath("//span[@aria-owns='Status_listbox']");
		  Thread.sleep(500);
		 
			
			Thread.sleep(50);
			
			wm.Listandenter("//span[@class='k-icon k-i-check']", "0");
			Thread.sleep(200);
			wm.doubleclickusingxpath("//span[@class='k-icon k-i-check']");
			
				Thread.sleep(5000);
			
				
			wm.clickbyid("btnMainSave");
			Thread.sleep(200);
			

		    wm.capturetextfrommsgbox("//span[@id='diaInfoMessage']", " Resource Master record created successfully ");
			Thread.sleep(50);
			
		  
			Thread.sleep(100);


			wm.Listandenterquick("//span[contains(text(),'OK')]", "0");
			wm.Listandenterquick("//span[contains(text(),'OK')]", "1");
			wm.Listandenterquick("//span[contains(text(),'OK')]", "2");
			wm.Listandenterquick("//span[contains(text(),'OK')]", "3");
	        
		    

		

			wm.sleep();
	}

	@AfterMethod
	public void close()

	{
		wm.close();

	}

	@DataProvider(name = "dp")
	public Object[][] dp() throws IOException {

		return Wrappermethods.getSheet("Resourcemaster", "Resourcemaster");

	}
}