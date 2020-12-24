package invoicegenerations;
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
public class invoicegenerations {

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
	public void invoicegenerations(String Username, String Password, String Leftsidemenu, String Voucherstatus,
			String Commonindex, String Branch, String FOP, String Docketnumber, String Filterby,
			String VChqDate1,String VChqDate2,String VChqDate3,String VRemarks) throws Exception

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
		wm.clickbyid("modINV001");
		Thread.sleep(500);
		wm.clickbyid("pgmICD001");
		wm.sleep();

		// sales status
		wm.sendtextbyxvalue("//input[@aria-owns='ticketStatus_listbox']", Voucherstatus);
		Thread.sleep(120);
		wm.Listandenter("//*[@id='ticketStatus_listbox']/li", Commonindex);
		Thread.sleep(120);

		// Brnach selections
		wm.sendtextbyxvalue("//input[@aria-owns='locationName_listbox']", Branch);
		Thread.sleep(120);
		wm.Listandenter("//*[@id='locationName_listbox']/li", Commonindex);
		Thread.sleep(120);

		// FOP
		wm.sendtextbyxvalue("//input[@aria-owns='fopdSettleType_listbox']", FOP);
		Thread.sleep(120);
		wm.Listandenter("//*[@id='fopdSettleType_listbox']/li", Commonindex);
		Thread.sleep(120);

		// send textyid

		wm.sendtextbyid("dktKey", Docketnumber);
		Thread.sleep(200);

		wm.doubleclickusingxpath("//button[@onclick='InvoiceSearch()']");
		Thread.sleep(2000);

		wm.Listandenterquick("//span[@class='k-icon k-i-more-vertical']", "4");
		Thread.sleep(200);

		wm.Listandenterquick("//span[@class='k-icon k-i-filter']", "0");
		Thread.sleep(800);

		wm.Listandentersend("//input[@data-bind='value:filters[0].value']", Filterby, "0");

		Thread.sleep(200);

		wm.Listandenterquick("//button[@class='k-button k-primary']", Commonindex);
		Thread.sleep(200);

		wm.Listandenter("//input[@id='chk1']", "0");
		Thread.sleep(300);

		wm.sendtextbycssselecotr("#VChqDate", "" +VChqDate1 + "-" + VChqDate2 + "-" + VChqDate3);
		Thread.sleep(300);
 	
		wm.sendtextbycssselecotrwithoutclear("#VRemarks",VRemarks);
		
		Thread.sleep(300);
		
		wm.clickbyid("btnMainSave");
		wm.sleep();
		wm.sleep();
		

		wm.Listandenterquick("//span[contains(text(),'OK')]", "0");
		wm.Listandenterquick("//span[contains(text(),'OK')]", "1");
		wm.Listandenterquick("//span[contains(text(),'OK')]", "2");
		wm.Listandenterquick("//span[contains(text(),'OK')]", "3");
        
        wm.sleep();
        wm.sleep();

		
	}

	@AfterMethod
	public void close()

	{
		wm.close();

	}

	@DataProvider(name = "dp")
	public Object[][] dp() throws IOException {

		return Wrappermethods.getSheet("invoicegenerations", "invoicegenerations");

	}
}