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
public class HotelServiceChargeRule {

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
	public void logincheckK(String Username, String Password, String Leftsidemenu, String HotelServiceChargeName,
			String Country, String Countryindex, String City, String Cityindexx, String Hotelname,
			String Hotelnameindex, String Noofrooms, String Noofroomsindex, String Hoteltype, String Hoteltypeindex,
			String Chargename, String Chargenameindex, String BookingFromDate1, String BookingFromDate2,
			String BookingFromDate3, String BookingToDate1, String BookingToDate2, String BookingToDate3,
			String StayingFromDate1, String StayingFromDate2, String StayingFromDate3, String StayingToDate1,
			String StayingToDate2, String StayingToDate3, String Suppliername, String Suppliernameindexx,
			String Statusindex,String HotelServiceChargeName1) throws Exception

	{

		Thread.sleep(2000);

		// wm.sendtextbyid("", );
		wm.sendtextbyid("LoginCode", Username);
		Thread.sleep(200);
		wm.sendtextbyid("Password", Password);
		Thread.sleep(200);
		wm.clickbyxpath("//input[@value='Login']");
		wm.sleep();
		wm.sendtextbyid("input-items", Leftsidemenu);
		Thread.sleep(500);
		wm.clickbyid("modTRS001");
		Thread.sleep(200);
		wm.clickbyid("pgmHSR001");
		Thread.sleep(200);

		wm.clickbyid("btnMainAdd");
		Thread.sleep(300);

		// Eneterthehotelservicehcargeame
		wm.sendtextbyxvalue("//input[@name='HotelServiceChargeName']", HotelServiceChargeName);
		Thread.sleep(200);

		// Countryy
		wm.sendtextbyxvalue("//input[@aria-owns='CountryDesc_listbox']", Country);
		Thread.sleep(200);
		wm.Listandenter("//*[@id='CountryDesc_listbox']/li", Countryindex);
		Thread.sleep(200);

		// Cityy
		wm.sendtextbyxvalue("//input[@aria-owns='CityDesc_listbox']", City);
		Thread.sleep(200);
		wm.Listandenter("//*[@id='CityDesc_listbox']/li", Cityindexx);
		Thread.sleep(200);

		// Hotelname
		wm.sendtextbyxvalue("//input[@aria-owns='HotelName_listbox']", Hotelname);
		Thread.sleep(200);
		wm.Listandenter("//*[@id='HotelName_listbox']/li", Hotelnameindex);
		Thread.sleep(200);

		// Noofrooms
		wm.sendtextbyxvalue("//input[@aria-owns='NoOfRoomsVal_listbox']", Noofrooms);
		Thread.sleep(200);
		wm.Listandenter("//*[@id='NoOfRoomsVal_listbox']/li", Noofroomsindex);
		Thread.sleep(200);

		// Hoteltypee
		wm.sendtextbyxvalue("//input[@aria-owns='HotelTypeDesc_listbox']", Hoteltype);
		Thread.sleep(200);
		wm.Listandenter("//*[@id='HotelTypeDesc_listbox']/li", Hoteltypeindex);
		Thread.sleep(200);

		// Chargename
		wm.sendtextbyxvalue("//input[@aria-owns='ChargeName_listbox']", Chargename);
		Thread.sleep(200);
		wm.Listandenter("//*[@id='ChargeName_listbox']/li", Chargenameindex);
		Thread.sleep(200);

		// datgeselections

		wm.sendtextbycssselecotr("#BookingFromDate",
				"" + BookingFromDate1 + "-" + BookingFromDate2 + "-" + BookingFromDate3);
		Thread.sleep(50);

		wm.sendtextbycssselecotr("#BookingToDate", "" + BookingToDate1 + "-" + BookingToDate2 + "-" + BookingToDate3);
		Thread.sleep(50);
		wm.sendtextbycssselecotr("#StayingFromDate",
				"" + StayingFromDate1 + "-" + StayingFromDate2 + "-" + StayingFromDate3);
		Thread.sleep(50);
		wm.sendtextbycssselecotr("#StayingToDate", "" + StayingToDate1 + "-" + StayingToDate2 + "-" + StayingToDate3);
		Thread.sleep(50);
		// Supliernamee
		wm.sendtextbyxvalue("//input[@aria-owns='SupplierName_listbox']", Suppliername);
		Thread.sleep(200);
		wm.Listandenter("//*[@id='SupplierName_listbox']/li", Suppliernameindexx);
		Thread.sleep(200);

		// statusindexx

		// slectthe status
		wm.clickbyxpath("//span[@aria-owns='Status_listbox']");
		Thread.sleep(200);
		wm.Listandenter("//*[@id='Status_listbox']/li", Statusindex);
		Thread.sleep(200);

		wm.clickbyxpath("//span[@class='k-icon k-i-check']");
		Thread.sleep(2000);

		wm.clickbyid("btnMainSave");
		wm.sleep();
		// wm.capturetextfrommsgbox("//span[@id='diaWarningMessage']", "
		
		// Bussiness partner Record created successfully ");
		wm.capturetextfrommsgbox("//*[@id='diaInfoMessage']",
				" Hotel Service Charge Rule  Record created successfully ");

		
		Thread.sleep(500);

		wm.Verifythealertpopupmessages("//*[@id='diaInfoMessage']", 
				"Hotel Service Charge Rule Master Saved/Updated Successfully", "Hotel service charge rule created successfully",
				"Hotel service charge rule not created successfully");
		Thread.sleep(300);
		
		

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

		return Wrappermethods.getSheet("HotelServiceChargeRule", "HotelServiceChargeRule");

	}
}