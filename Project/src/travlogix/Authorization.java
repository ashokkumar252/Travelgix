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
public class Authorization
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
	public void Authorization(String Username, String Password, String Leftsidemenu,String Code,
			String authTicketNumber,String authAmount,String authUserName,String Airline,String Airlineindex,
			String Tickectstatus,String Tickectstatusindex,String Useruser,String Useduserindex,
			String Statusindexx) throws Exception

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
		wm.clickbyid("pgmAUZ");
		wm.sleep();

		wm.clickbyid("btnMainAdd");
		Thread.sleep(500);

		// Start enter thecodee

		wm.sendtextbycssselecotrwithoutclear("#Code", "" + Code);
		Thread.sleep(50);
		wm.sendtextbycssselecotrwithoutclear("#authTicketNumber", "" + authTicketNumber);
		Thread.sleep(50);
		wm.sendtextbycssselecotrwithoutclear("#authAmount", "" + authAmount);
		Thread.sleep(50);
		wm.sendtextbycssselecotrwithoutclear("#authUserName", "" + authUserName);
		Thread.sleep(50);

		// enterthe customername and indexx
		wm.sendtextbyxvalue("//input[@aria-owns='authAirlineKey_listbox']", Airline);
		Thread.sleep(200);
		wm.Listandenter("//*[@id='authAirlineKey_listbox']/li", Airlineindex);
		Thread.sleep(200);

		// Tickect status index
		wm.sendtextbyxvalue("//input[@aria-owns='authTicketStatusKey_listbox']", Tickectstatus);
		Thread.sleep(200);
		wm.Listandenter("//*[@id='authTicketStatusKey_listbox']/li", Tickectstatusindex);
		Thread.sleep(200);

		// Useduser
		wm.sendtextbyxvalue("//input[@aria-owns='authUsedStatus_listbox']", Useruser);
		Thread.sleep(200);
		wm.Listandenter("//*[@id='authUsedStatus_listbox']/li", Useduserindex);
		Thread.sleep(200);

		// Useduser
		/*wm.sendtextbyxvalue("//input[@aria-owns='authUsedStatus_listbox']", Useruser);
		Thread.sleep(200);
		wm.Listandenter("//*[@id='authUsedStatus_listbox']/li", Useduserindex);
		Thread.sleep(200);
*/
		// Sttaus
		wm.clickbyxpath("//span[@aria-owns='Status_listbox']");
		Thread.sleep(200);
		wm.Listandenter("//*[@id='Status_listbox']/li", Statusindexx);
		Thread.sleep(200);

		// grid dsave button

		wm.clickbyxpath("//span[@class='k-icon k-i-check']");
		Thread.sleep(300);

		Thread.sleep(300);
		wm.clickbyid("btnMainSave");
		Thread.sleep(900);

		wm.Verifythealertpopupmessages("//*[@id='diaInfoMessage']", 
				"Saved/Updated Successfully",
				"Authorization Created successfully", 
				"Authorization not Created Successfully");

		Thread.sleep(500);

		Thread.sleep(500);
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

		return Wrappermethods.getSheet("Authorization", "Authorization");

	}
}