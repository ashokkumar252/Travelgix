package Voidticket;

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
public class VoidticketAir {

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
	public void VoidticketAir(String Username, String Password, String Leftsidemenu, String Product, String Airline,
			String Tickectnumber, String TVvoidDate1, String TVvoidDate2, String TVvoidDate3, String Bookingclerk,
			String TVvoidCharges, String Customerdetails, String Commonindex) throws Exception

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
		wm.clickbyid("pgmTV001");
		wm.sleep();

		// Enter theproduct
		wm.sendtextbyxvalue("//input[@name='TVproductName_input']", Product);
		Thread.sleep(200);
		wm.keyboardarrowdownonetime("//input[@name='TVproductName_input']");
		Thread.sleep(200);
		wm.Enterbyxpath("//input[@name='TVproductName_input']");
		Thread.sleep(200);

		// Enter the airlinee
		wm.sendtextbyxvalue("//input[@name='TVtransTypeName_input']", Airline);
		Thread.sleep(200);
		wm.keyboardarrowdownonetime("//input[@name='TVtransTypeName_input']");
		Thread.sleep(200);
		wm.Enterbyxpath("//input[@name='TVtransTypeName_input']");
		Thread.sleep(200);

		// Enter the tickectnumber
		wm.sendtextbyxvalue("//input[@name='TVticketNumber']", Tickectnumber);
		Thread.sleep(200);
		wm.keyboardarrowdownonetime("//input[@name='TVticketNumber']");
		Thread.sleep(200);
		wm.Enterbyxpath("//input[@name='TVticketNumber']");
		Thread.sleep(200);

		wm.doubleclickusingxpath("//button[@class='btn btn-success']");
		Thread.sleep(600);

		// Eneter the voiddate
		wm.sendtextbycssselecotr("#TVvoidDate", "" + TVvoidDate1 + "-" + TVvoidDate2 + "-" + TVvoidDate3);
		Thread.sleep(90);

		// Enter the Bookingclerk
		wm.sendtextbyxvalue("//input[@name='TVbookingClerkName_input']", Bookingclerk);
		Thread.sleep(200);
		wm.keyboardarrowdownonetime("//input[@name='TVbookingClerkName_input']");
		Thread.sleep(200);
		wm.Enterbyxpath("//input[@name='TVbookingClerkName_input']");
		Thread.sleep(200);

		wm.sendtextbycssselecotrwithoutclear("#TVvoidCharges", "" + TVvoidCharges);
		Thread.sleep(200);

		wm.Listandenter("//span[@class='k-icon k-i-add']", "0");
		Thread.sleep(900);

		wm.Listandenter("//button[@id='ConformationYes']", "0");

		Thread.sleep(200);

		// selected the cashoptions
		wm.clickbyxpath("//span[@aria-owns='MiscFOPModeKey_listbox']");
		Thread.sleep(100);
		wm.Listandenter("//*[@id='MiscFOPModeKey_listbox']/li", "1");
		Thread.sleep(200);

		wm.clickbyxpath("//span[@aria-owns='fbbranch_listbox']");
		Thread.sleep(300);
		wm.sendtextbyxvalue("//input[@aria-owns='fbbranch_listbox']", Customerdetails);
		Thread.sleep(200);
		wm.Listandenter("//*[@id='fbbranch_listbox']/li", Commonindex);
		Thread.sleep(200);

		// ===============================================

		wm.doubleclickusingxpath("//span[@class='k-icon k-i-check']");
		Thread.sleep(900);

		wm.clickbyid("btnMainSave");
		Thread.sleep(200);

		wm.Verifythealertpopupmessagesusincontains("//*[@id='diaInfoMessage']", "Successfully",
				"Void tickect done successfully", "Void tickect not done successfully");

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

		return Wrappermethods.getSheet("Voidticket", "Voidticket");

	}
}