package Refund;
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
public class Airrefund
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

		wm.launchbrowser("chrome", utility.Constant.TRAVELOGIXURL);

	}

	@Test(dataProvider = "dp")
	public void Airpositive(String Username, String Password, String Leftsidemenu, String ActiveFrom1,
			String ActiveFrom2, String ActiveFrom3, String Docktype, String Docktypeindex, String Salesbracnh,
			String Salesbracnhindex, String Customer, String Customerindex, String Leadpaxnamee,
			String dktClientReference,String Tickectstatusindex,String AatdTicketNumber) throws Exception

	{

		Thread.sleep(2000);

		// wm.sendtextbyid("", );
		wm.sendtextbyid("LoginCode", Username);
		Thread.sleep(50);
		wm.stab("LoginCode");
		wm.sendtextbyid("Password", Password);
		Thread.sleep(50);
		wm.clickbyxpath("//input[@value='Login']");
		Thread.sleep(900);

		// screnn===========================================================
		wm.sendtextbyid("input-items", Leftsidemenu);
		Thread.sleep(500);
		wm.clickbyid("modCAS001");
		Thread.sleep(500);
		wm.clickbyid("pgmSAL001");
		wm.sleep();

		wm.clickbyid("btnMainAdd");

		Thread.sleep(2000);

		wm.sendtextbycssselecotr("#DktDate", "" + ActiveFrom1 + "-" + ActiveFrom2 + "-" + ActiveFrom3);

		// Dockett
		wm.sendtextbyxvalue("//input[@aria-owns='dktDocTypeCode_listbox']", Docktype);
		Thread.sleep(50);
		wm.Listandenter("//*[@id='dktDocTypeCode_listbox']/li", Docktypeindex);
		Thread.sleep(150);

		// Salesbranch
		wm.sendtextbyxvalue("//input[@aria-owns='DktBranchKey_listbox']", Salesbracnh);
		Thread.sleep(50);
		wm.Listandenter("//*[@id='DktBranchKey_listbox']/li", Salesbracnhindex);
		Thread.sleep(150);

		// customerr
		wm.sendtextbyxvalue("//input[@aria-owns='DktPartnername_listbox']", Customer);
		Thread.sleep(50);
		wm.Listandenter("//*[@id='DktPartnername_listbox']/li", Customerindex);
		Thread.sleep(150);

		wm.sendtextbycssselecotrwithoutclear("#dktLeadPaxName", "" + Leadpaxnamee);
		Thread.sleep(200);

		// clintrefecnce
		wm.sendtextbycssselecotrwithoutclear("#dktClientReference", "" + dktClientReference);
		Thread.sleep(150);

		wm.Listandenter("//i[@class='fa fa-chevron-down']", "0");
		Thread.sleep(200);
		wm.Listandenter("//i[@class='fa fa-plus']", "0");
		Thread.sleep(2500);

		// Ait

		// ===============================================================================
		//Select the tickectstatus
		
		wm.clickbyxpath("//span[@aria-owns='AatdTicketStatus_listbox']");
		Thread.sleep(90);
		wm.Listandenter("//*[@id='AatdTicketStatus_listbox']/li",Tickectstatusindex);
		Thread.sleep(150);

		wm.sendtextbycssselecotrwithoutclear("#AatdTicketNumber", "" + AatdTicketNumber);
		wm.stabbyxpath("//input[@id='AatdTicketNumber']");
		
		Thread.sleep(900);
		
		

		wm.doubleclickusingxpath("//input[@name='AtfdReasonCode']");
		wm.stabbyxpath("//input[@name='AtfdReasonCode']");
		Thread.sleep(600);

		wm.clickbyxpath("//*[@id='divAirsectordtls']/div/div[1]/div[1]/a/i");
		Thread.sleep(500);


//Calcualtion amount details
		
wm.sendtextbycssselecotrwithoutclear("#AtfdAgentCancelCharge",""+AtfdAgentCancelCharge);

wm.sendtextbycssselecotrwithoutclear("#AtfdAirlineCancelCharge",""+AtfdAirlineCancelCharge);






				
		
		wm.sleep();
		Thread.sleep(300);

	}

	@AfterMethod
	public void close()

	{
		wm.close();

	}

	@DataProvider(name = "dp")
	public Object[][] dp() throws IOException {

		return Wrappermethods.getSheet("Airrefund", "Airrefund");

	}
}