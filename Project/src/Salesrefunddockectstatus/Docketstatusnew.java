package Salesrefunddockectstatus;
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
public class Docketstatusnew 
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

//		wm.launchbrowser("chrome", utility.Constant.TRAVELOGIXURL);

		wm.launchbrowser(utility.Constant.Browsername, utility.Constant.TRAVELOGIXURL);

		

	}

	@Test(dataProvider = "dp")
	public void Docketstatusnew(String Username,String Password,
			String Leftsidemenu,String ActiveFrom1,String ActiveFrom2,String ActiveFrom3,
			String Docktype,String Docktypeindex,String Salesbracnh,String Salesbracnhindex,
			String Customer,String Customerindex,String Leadpaxnamee,String dktClientReference) throws Exception

	{

		Thread.sleep(2000);

		// wm.sendtextbyid("", );
		wm.sendtextbyid("LoginCode", Username);
		wm.stab("LoginCode");

		Thread.sleep(300);
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
		Thread.sleep(200);

		// Salesbranch
		wm.sendtextbyxvalue("//input[@aria-owns='DktBranchKey_listbox']", Salesbracnh);
		Thread.sleep(50);
		wm.Listandenter("//*[@id='DktBranchKey_listbox']/li", Salesbracnhindex);
		Thread.sleep(200);

		// customerr
		wm.sendtextbyxvalue("//input[@aria-owns='DktPartnername_listbox']", Customer);
		Thread.sleep(50);
		wm.Listandenter("//*[@id='DktPartnername_listbox']/li", Customerindex);
		Thread.sleep(200);

		wm.sendtextbycssselecotrwithoutclear("#dktLeadPaxName", "" + Leadpaxnamee);
		Thread.sleep(200);

		// clintrefecnce
		wm.sendtextbycssselecotrwithoutclear("#dktClientReference", "" + dktClientReference);
		Thread.sleep(200);

		// Step 1:

		// Creating nw docket
		// Navigate to sales refund screen
		// Enter the details click the save and created the docket number . and
		// verify the workbench status as : new

		// clickinthe save button
		wm.clickbyid("btnMainSave");
		Thread.sleep(300);

		wm.Listandenterquick("//span[contains(text(),'OK')]", "0");
		wm.Listandenterquick("//span[contains(text(),'OK')]", "1");
		wm.Listandenterquick("//span[contains(text(),'OK')]", "2");
		wm.Listandenterquick("//span[contains(text(),'OK')]", "3");
		Thread.sleep(500);
		wm.clickbyxpath("//button[@class='btn btn-success']");
		Thread.sleep(900);

		wm.Copyandpaste("//*[@id='SalesSearchGrid']/div[3]/table/tbody/tr[1]/td[1]");
		Thread.sleep(300);

		// wm.sendtextbyxvalue("//input[@name='DktNumber']","");

		wm.sendtextbyxvalue("//input[@name='DktNumber']", wm.store2);
		Thread.sleep(300);
		wm.clickbyxpath("//button[@class='btn btn-success']");
		Thread.sleep(600);

		wm.doubleclickusingxpath("//*[@id='SalesSearchGrid']/div[3]/table/tbody/tr[1]/td[1]");
		Thread.sleep(300);

		wm.Verifythealertpopupmessagesusincontains("//*[@id='SalesSearchGrid']/div[3]/table/tbody/tr[1]/td[13]", "NEW",
				"Newly created docket status saveas NEW", "Newly created docket status Not saveas NEW");

		Thread.sleep(200);

		wm.clickbyid("btnMainEdit");
		Thread.sleep(600);

		
	}

	@AfterMethod
	public void close()

	{
		wm.close();

	}

	@DataProvider(name = "dp")
	public Object[][] dp() throws IOException {

		return Wrappermethods.getSheet("Salesrefundtickectstatus", "Salesrefundtickectstatus");

	}
}