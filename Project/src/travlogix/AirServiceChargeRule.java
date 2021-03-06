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
public class AirServiceChargeRule{

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
	public void AirServiceChargeRule(String Username, String Password, String Leftsidemenu,String AirServiceChargeName,
			String Airline,String Airlineindex,String ActiveFrom1,String ActiveFrom2,String ActiveFrom3,
			String ActiveTo1,String ActiveTo2,String ActiveTo3,String Chargename,String Chargenameindex,
			String Tickecttye,String Tickecttyeindexx,String Classtypee,String Classtypeeindexx,
			String Region,String Regionindex,String TravelTypeCode,String TravelTypeCodeindex,
			String SupplierCode,String SupplierCodeindex,String Statusindex) throws Exception

	{

		Thread.sleep(2000);

		// wm.sendtextbyid("", );
		wm.sendtextbyid("LoginCode", Username);
		Thread.sleep(200);
		wm.stab("LoginCode");
		wm.sendtextbyid("Password", Password);
		Thread.sleep(200);
		wm.clickbyxpath("//input[@value='Login']");
		wm.sleep();
		wm.sendtextbyid("input-items", Leftsidemenu);
		Thread.sleep(500);		
		wm.clickbyid("modTRS001");
		Thread.sleep(200);
		wm.clickbyid("pgmASR001");
		Thread.sleep(200);

		wm.clickbyid("btnMainAdd");
		Thread.sleep(300);

		wm.sendtextbyxvalue("//input[@name='AirServiceChargeName']", AirServiceChargeName);
		Thread.sleep(200);

		// Airline
		wm.sendtextbyxvalue("//input[@aria-owns='AirlineDesc_listbox']", Airline);
		Thread.sleep(600);
		wm.Listandenter("//*[@id='AirlineDesc_listbox']/li", Airlineindex);
		Thread.sleep(600);

		wm.sendtextbycssselecotr("#ActiveFrom", "" + ActiveFrom1 + "-" + ActiveFrom2 + "-" + ActiveFrom3);
		Thread.sleep(50);
		wm.sendtextbycssselecotr("#ActiveTo", "" + ActiveTo1 + "-" + ActiveTo2 + "-" + ActiveTo3);
		Thread.sleep(50);

		// Chhargename
		wm.sendtextbyxvalue("//input[@aria-owns='ascChargeKey_listbox']", Chargename);
		Thread.sleep(600);
		wm.Listandenter("//*[@id='ascChargeKey_listbox']/li", Chargenameindex);
		Thread.sleep(600);

		// tickecttypee
		wm.sendtextbyxvalue("//input[@aria-owns='TicketTypeCode_listbox']", Tickecttye);
		Thread.sleep(600);
		wm.Listandenter("//*[@id='TicketTypeCode_listbox']/li", Tickecttyeindexx);
		Thread.sleep(600);

		// Classtype
		wm.sendtextbyxvalue("//input[@aria-owns='ClassTypeCode_listbox']", Classtypee);
		Thread.sleep(600);
		wm.Listandenter("//*[@id='ClassTypeCode_listbox']/li", Classtypeeindexx);
		Thread.sleep(600);

		// REgionn
		wm.sendtextbyxvalue("//input[@aria-owns='RegionTypeCode_listbox']", Region);
		Thread.sleep(600);
		wm.Listandenter("//*[@id='RegionTypeCode_listbox']/li", Regionindex);
		Thread.sleep(600);

		// TravelTypeCode_listbox
		wm.sendtextbyxvalue("//input[@aria-owns='TravelTypeCode_listbox']", TravelTypeCode);
		Thread.sleep(600);
		wm.Listandenter("//*[@id='TravelTypeCode_listbox']/li", TravelTypeCodeindex);
		Thread.sleep(600);

		// SupplierCode_listbox
		wm.sendtextbyxvalue("//input[@aria-owns='SupplierCode_listbox']", SupplierCode);
		Thread.sleep(600);
		wm.Listandenter("//*[@id='SupplierCode_listbox']/li", SupplierCodeindex);
		Thread.sleep(600);

		// slectthe status
		wm.clickbyxpath("//span[@aria-owns='Status_listbox']");
		Thread.sleep(200);
		wm.Listandenter("//*[@id='Status_listbox']/li", Statusindex);
		Thread.sleep(600);

		wm.clickbyxpath("//span[@class='k-icon k-i-check']");
		Thread.sleep(500);

		wm.clickbyid("btnMainSave");

		Thread.sleep(2000);

		// wm.capturetextfrommsgbox("//span[@id='diaWarningMessage']", "
		// Bussiness partner Record created successfully ");

		wm.Verifythealertpopupmessages("//span[@id='diaInfoMessage']", 
				"Air Service Charge Rule Master Saved/Updated Successfully",
				"Air service charge rule Created successfully", 
				"Air service charge rule not created successfully");

		/*
		wm.capturetextfrommsgbox("//span[@id='diaInfoMessage']", 
				" Air Service Charge Rule  Record created successfully ");
*/
		Thread.sleep(500);

		wm.Listandenterquick("//span[contains(text(),'OK')]", "0");
		wm.Listandenterquick("//span[contains(text(),'OK')]", "1");
		wm.Listandenterquick("//span[contains(text(),'OK')]", "2");
		wm.Listandenterquick("//span[contains(text(),'OK')]", "3");

		Thread.sleep(300);
		

	}

	@AfterMethod
	public void close()

	{
		wm.close();

	}

	@DataProvider(name = "dp")
	public Object[][] dp() throws IOException {

		return Wrappermethods.getSheet("AirServiceChargeRule", "AirServiceChargeRule");

	}
}