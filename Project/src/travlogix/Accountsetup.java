//WASTA login screen
package travlogix;
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
public class Accountsetup 
{

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

		wm.launchbrowser(utility.Constant.Browsername, utility.Constant.TRAVELOGIXURL);

	}

	@Test(dataProvider = "dp")
	public void Accountsetup(String Username, String Password, String Leftsidemenu,String Branchname,String Branchnameindex,
			String Productname,String Productnamindex,String Servicetype,String Servicetypeindex,String Voucher,
			String Voucherstatusindex,String Default,String Defaultcollectionsindex,String Playbackaccount,
			String Playbackaccountindex) throws Exception

	{

		Thread.sleep(2000);

		// wm.sendtextbyid("", );
		wm.sendtextbyid("LoginCode", Username);
		Thread.sleep(200);
		wm.stab("LoginCode");
		wm.sendtextbyid("Password", Password);
		Thread.sleep(200);
		wm.clickbyxpath("//input[@value='Login']");
        Thread.sleep(900);

		// screnn===========================================================
		wm.sendtextbyid("input-items", Leftsidemenu);
		Thread.sleep(500);
		wm.clickbyid("modTRS001");
		Thread.sleep(500);
		wm.clickbyid("pgmACS001");
		wm.sleep();

		wm.clickbyid("btnMainAdd");
		Thread.sleep(500);
		

		
		
		// enterthe customername and indexx
				wm.sendtextbyxvalue("//input[@aria-owns='branchName_listbox']",Branchname);
				Thread.sleep(200);
				wm.Listandenter("//*[@id='branchName_listbox']/li",Branchnameindex);
				Thread.sleep(200);
		
				//productname
				wm.sendtextbyxvalue("//input[@aria-owns='productName_listbox']",Productname);
				Thread.sleep(200);
				wm.Listandenter("//*[@id='productName_listbox']/li",Productnamindex);
				Thread.sleep(200);
		        wm.stabbyxpath("//input[@aria-owns='productName_listbox']");
		        Thread.sleep(200);
		        
				//productname
				wm.sendtextbyxvalue("//input[@aria-owns='transName_listbox']",Servicetype);
				Thread.sleep(200);
				wm.Listandenter("//*[@id='transName_listbox']/li",Servicetypeindex);
				Thread.sleep(200);
		
				//Voucherstatus
				wm.sendtextbyxvalue("//input[@aria-owns='VoucherstatusName_listbox']",Voucher);
				Thread.sleep(200);
				wm.Listandenter("//*[@id='VoucherstatusName_listbox']/li",Voucherstatusindex);
				Thread.sleep(200);
				
				
				//Defaltcollections
				wm.sendtextbyxvalue("//input[@aria-owns='DefaultBankName_listbox']",Default);
				Thread.sleep(200);
				wm.Listandenter("//*[@id='DefaultBankName_listbox']/li",Defaultcollectionsindex);
				Thread.sleep(200);
				
		

				//Playbck account
				wm.sendtextbyxvalue("//input[@aria-owns='PaybackExpenseGlName_listbox']",Playbackaccount);
				Thread.sleep(200);
				wm.Listandenter("//*[@id='PaybackExpenseGlName_listbox']/li",Playbackaccountindex);
				Thread.sleep(200);
		
				
				wm.Listandenter("//span[@class='k-icon k-i-check']", "0");
				
		
	//	wm.sleep();
		Thread.sleep(50000);
	}

	@AfterMethod
	public void close()

	{
		wm.close();

	}

	@DataProvider(name = "dp")
	public Object[][] dp() throws IOException {

		return Wrappermethods.getSheet("Accountsetup", "Accountsetup");

	}
}