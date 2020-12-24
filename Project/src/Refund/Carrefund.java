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
public class Carrefund {

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
	public void Carrefund(String Username, String Password, String Leftsidemenu, String ActiveFrom1, String ActiveFrom2,
			String ActiveFrom3, String Docktype, String Docktypeindex, String Salesbracnh, String Salesbracnhindex,
			String Customer, String Customerindex, String Leadpaxnamee, String dktClientReference,
			String Tickectstatusindex,String CcvdVoucherNumberRead,String cvdRefundValidity1,
			String cvdRefundValidity2,String cvdRefundValidity3) throws Exception

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

		wm.Listandenter("//i[@class='fa fa-chevron-down']", "2");
		Thread.sleep(200);
		wm.Listandenter("//i[@class='fa fa-plus']", "2");
		Thread.sleep(2000);

		// Car

		// ===============================================================================
		// Select the tickectstatus

		wm.clickbyxpath("//span[@aria-owns='CcvdVoucherStatus_listbox']");
		Thread.sleep(90);
		wm.Listandenter("//*[@id='CcvdVoucherStatus_listbox']/li", Tickectstatusindex);
		Thread.sleep(150);

		// Enetr the voucher number

		wm.sendtextbyxvalue("//input[@id='CcvdVoucherNumberRead']", CcvdVoucherNumberRead);
		Thread.sleep(90);
		wm.stabbyxpath("//input[@id='CcvdVoucherNumberRead']");
		Thread.sleep(200);

		wm.Listandenterquick("//button[@id='ConformationYes']", "0");
		Thread.sleep(500);

		wm.sendtextbycssselecotr("#cvdRefundValidity",
				"" + cvdRefundValidity1 + "-" + cvdRefundValidity2 + "-" + cvdRefundValidity3);

		Thread.sleep(500);

		wm.Netcollectionuisngcancellatiocharges("//input[@name='CtfdBaseFare']", "//input[@name='TotalTaxAmount']",
				"//input[@name='TotalServiceFee']", "//input[@name='TotalDiscount']", "//input[@name='TotOutputVat']",
				"//input[@name='Amt_NetCollection']", "//input[@name='CtfdAgentCancelCharge']",
				"//input[@name='CtfdSupplierCancelCharge']",
				"Net calclaiton done correectly using cancelaltion charges",
				"Net calclaiton not done correectly using cancelaltion charges");

		Thread.sleep(200);

		wm.Publishedfareusingcancelaltionchargeswithoutuccf("//input[@name='CtfdBaseFare']",
				"//input[@name='TotalTaxAmount']", "//input[@name='salestotcommm']",
				"//input[@name='CtfdSupplierCancelCharge']", "//input[@name='TotInputVat']",
				"//input[@name='Amt_NetPayable']", "payable calculation done successfuly using cancellation charges",
				"payable calculation not done successfuly using cancellation charges");

		Thread.sleep(500);

		wm.doubleclickusingxpath("//button[@id='btncarsave']");
		Thread.sleep(500);

		wm.Listandenterquick("//button[@id='ConformationYes']", "0");
		Thread.sleep(200);

		wm.sleep();
		wm.sleep();
		wm.sleep();

		Thread.sleep(8000);

		wm.clickbyxpath("//*[@class='btn btn-danger']");
		Thread.sleep(500);

		wm.Listandenterquick("//span[contains(text(),'Leave Page')]", "0");
		wm.Listandenterquick("//span[contains(text(),'Leave Page')]", "1");
		wm.Listandenterquick("//span[contains(text(),'Leave Page')]", "2");
		wm.Listandenterquick("//span[contains(text(),'Leave Page')]", "3");
		wm.sleep();
		wm.sleep();
		

		wm.Verifythedropdownvalues("//input[@name='DktNumber']",
				"Pass : Sales Refund CAR   created successfuly" + "",
				"Fail:  Sales Refund CAR   not created successfuly " + "");
/*	

		wm.Listnegativescearios("//span[@class='k-widget k-textbox k-state-disabled']", "0", "Pass :  Refund CAR   created successfuly" + "",
				"Fail:   Refund CAR   not created successfuly " + "");
*/
		Thread.sleep(500);

		// wm.gettext("//*[@id='DktNumber']");

		wm.storestrign2("//input[@name='DktNumber']");

		// wm.gettext("//*[@id='DktNumber']");

		// wm.Gettextbylistandprint("//*[@id='DktNumber']", "Docketnumber is");

		Thread.sleep(300);

	}

	@AfterMethod
	public void close()

	{
		wm.close();

	}

	@DataProvider(name = "dp")
	public Object[][] dp() throws IOException {

		return Wrappermethods.getSheet("Carrefund", "Carrefund");

	}
}