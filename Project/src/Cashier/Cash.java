package Cashier;

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
public class Cash {
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
	public void Cash(String Username, String Password, String Leftsidemenu, String Voucherstatus,
			String Voucherstatusindex, String fromDate1, String fromDate2, String fromDate3, String toDate1,
			String toDate2, String toDate3, String Currency, String Branch, String Product, String Productindex,
			String Dockectnumber, String Checkboxinddex, String Customerdetails, String Customerdetailsindex)
			throws Exception

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
		wm.clickbyid("pgmSR001");
		wm.sleep();

		// Select the fop mode options
		wm.clickbyxpath("//span[@aria-owns='FopMode_listbox']");
		Thread.sleep(200);
		wm.Listandenterquick("//*[@id='FopMode_listbox']/li", "0");
		Thread.sleep(200);

		// Select the fop mode options
		wm.sendtextbyxvalue("//input[@aria-owns='CR_ticketStatus_listbox']", Voucherstatus);
		Thread.sleep(200);
		wm.Listandenterquick("//*[@id='CR_ticketStatus_listbox']/li", Voucherstatusindex);
		Thread.sleep(200);

		// Fromdatee
		wm.sendtextbycssselecotr("#CR_fromDate", "" + fromDate1 + "/" + fromDate2 + "/" + fromDate3);
		Thread.sleep(200);
		// Todatee
		wm.sendtextbycssselecotr("#CR_toDate", "" + toDate1 + "/" + toDate2 + "/" + toDate3);
		Thread.sleep(200);

		// currency
		wm.sendtextbyxvalue("//input[@name='transCurrencyKey_input']", Currency);
		Thread.sleep(200);
		wm.keyboardarrowdownonetime("//input[@name='transCurrencyKey_input']");
		Thread.sleep(200);
		wm.Enterbyxpath("//input[@name='transCurrencyKey_input']");
		Thread.sleep(200);

		// Branch
		wm.sendtextbyxvalue("//input[@name='CR_locations_input']", Branch);
		Thread.sleep(200);
		wm.keyboardarrowdownonetime("//input[@name='CR_locations_input']");
		Thread.sleep(200);
		wm.Enterbyxpath("//input[@name='CR_locations_input']");
		Thread.sleep(200);

		// Product
		wm.sendtextbyxvalue("//input[@aria-owns='CR_Product_listbox']", Product);
		Thread.sleep(200);
		wm.Listandenterquick("//*[@id='CR_Product_listbox']/li", Productindex);
		Thread.sleep(200);

		wm.sendtextbyid("CR_docketNumber", Dockectnumber);
		Thread.sleep(200);

		// clicking thesearchbutton
		wm.doubleclickusingxpath("//button[@class='btn btn-success']");

		wm.sleep();

		wm.sleep();

		// Seected thecheckbox

		wm.Listandenterquick("//input[@id='chk1']", Checkboxinddex);
		Thread.sleep(200);

		wm.scrolldownbyxpath("//*[@id='Cashier1']/div[4]/div/div/div/div[1]/div[2]/h4");

		wm.Listandenter("//span[@class='k-icon k-i-add']", "0");
		Thread.sleep(900);

		// selected the cashoptions
		wm.clickbyxpath("//span[@aria-owns='MiscFOPModeKey_listbox']");
		Thread.sleep(100);
		wm.Listandenter("//*[@id='MiscFOPModeKey_listbox']/li", "0");
		Thread.sleep(200);

		wm.clickbyxpath("//span[@aria-owns='fcashcode_listbox']");
		Thread.sleep(200);
		wm.sendtextbyxvalue("//input[@aria-owns='fcashcode_listbox']", Customerdetails);
		Thread.sleep(200);
		wm.Listandenter("//*[@id='fcashcode_listbox']/li", Customerdetailsindex);
		Thread.sleep(200);

		// ===============================================

		wm.doubleclickusingxpath("//span[@class='k-icon k-i-check']");
		Thread.sleep(900);

		wm.clickbyid("btnMainSave");
		Thread.sleep(200);

		wm.Verifythealertpopupmessagesusincontains("//*[@id='diaInfoMessage']", "Successfully",
				"Cashier done successfully", "Cashier not done successfully");

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

		return Wrappermethods.getSheet("Cash", "Cash");

	}
}