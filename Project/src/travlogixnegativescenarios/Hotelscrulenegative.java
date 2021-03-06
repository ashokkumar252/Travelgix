//WASTA login screen
package travlogixnegativescenarios;

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
public class Hotelscrulenegative

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
	public void Hotelscrulenegative(String Username, String Password, String Leftsidemenu, String Commonindex, String Country,
			String Citymaster, String Hotelname, String Hoteltype, String ChargeNamelistbox, String Suppliername,
			String Servicechargename,String Inactivecountry,String inactiveCitymaster,String inactiveHotelname,
			String inactiveHoteltype,String inactiveChargeNamelistbox,String inactiveSuppliername
) throws Exception

	{

		Thread.sleep(2000);

		// wm.sendtextbyid("", );
		wm.sendtextbyid("LoginCode", Username);
		wm.stab("LoginCode");
		Thread.sleep(200);
		wm.sendtextbyid("Password", Password);
		Thread.sleep(200);
		wm.clickbyxpath("//input[@value='Login']");
		wm.sleep();

		// ====================Creating Air Service Charge Rule Master negative
		// scenarios
		// screnn===========================================================
		wm.sendtextbyid("input-items", Leftsidemenu);
		Thread.sleep(500);
		wm.clickbyid("modTRS001");
		Thread.sleep(500);
		wm.clickbyid("pgmHSR001");
		wm.sleep();

		// 1 Air Service Charge Rule Clicking the save button without changes

		wm.clickbyid("btnMainSave");
		wm.sleep();

		wm.Verifythealertpopupmessagesusincontains("//span[@id='diaInfoMessage']",
				"Without",
				"without doing changes clicking the save button , System showing validation messages correctly ",
				"without doing changes clicking the save button ,  System showing validation messages not correctly ");
		Thread.sleep(300);

		wm.Listandenterquick("//span[contains(text(),'OK')]", "0");
		wm.Listandenterquick("//span[contains(text(),'OK')]", "1");
		wm.Listandenterquick("//span[contains(text(),'OK')]", "2");
		wm.Listandenterquick("//span[contains(text(),'OK')]", "3");
		Thread.sleep(500);

		// 2 Air Service Charge Rule Verify the Audit log Popup opening

		wm.clickbyid("btnAuditLog");
		Thread.sleep(300);
		wm.Verifythealertpopupmessagesusincontains("//span[@id='AuditLog_wnd_title']", "Audit Log",
				"When clicking the audit log icon system displays the auditlog popup",
				"When clicking the audit log icon system displays the auditlog popup");
		Thread.sleep(300);

		wm.Listandenterquick("//span[@class='k-icon k-i-close']", "0");
		wm.Listandenterquick("//span[@class='k-icon k-i-close']", "1");
		wm.Listandenterquick("//span[@class='k-icon k-i-close']", "2");
		wm.Listandenterquick("//span[@class='k-icon k-i-close']", "3");
		Thread.sleep(500);

		// ==================================================================================

		// 3 Hotel Service Charge Rule Verify the UI field validations

		wm.clickbyid("btnMainAdd");
		Thread.sleep(500);
		// wm.Clearbyxpath("//input[@name='ActiveFrom']");
		// Thread.sleep(200);
		wm.clickbyxpath("//span[@aria-owns='Status_listbox']");
		Thread.sleep(200);
		wm.Listandenterquick("//span[@aria-owns='Status_listbox']", "0");
		Thread.sleep(300);
		wm.Listandenter("//div[contains(text(),'Select')]", "0");
		Thread.sleep(100);
		wm.clickbyxpath("//span[@class='k-icon k-i-check']");
		Thread.sleep(300);

		// sevricchargename field
		wm.Mousemoveover("//input[@name='HotelServiceChargeName']");
		Thread.sleep(300);
		wm.Listnegativescearios(utility.Constant.Travelogixuitooltipvalidation, Commonindex,
				"Pass :  Service Charge Name validations is avilable " + "",
				"Fail:  Service Charge Name  validations is not avilable " + "");
		Thread.sleep(300);

		// charge name field
		wm.Mousemoveover("//input[@name='ChargeName_input']");
		Thread.sleep(300);
		wm.Listnegativescearios(utility.Constant.Travelogixuitooltipvalidation, Commonindex,
				"Pass :   Charge Name validations is avilable " + "",
				"Fail:   Charge Name  validations is not avilable " + "");
		Thread.sleep(300);

		// No of rooms validations
		wm.Mousemoveover("//input[@name='NoOfRoomsVal_input']");
		Thread.sleep(300);
		wm.Listnegativescearios(utility.Constant.Travelogixuitooltipvalidation, Commonindex,
				"Pass :   No of rooms  validations is avilable " + "",
				"Fail:   No of rooms  validations is not avilable " + "");
		Thread.sleep(300);

		// Hoteltype validations
		wm.Mousemoveover("//input[@name='HotelTypeDesc_input']");
		Thread.sleep(300);
		wm.Listnegativescearios(utility.Constant.Travelogixuitooltipvalidation, Commonindex,
				"Pass : Hotel type validations is avilable " + "",
				"Fail:   Hotel type validations is not avilable " + "");
		Thread.sleep(300);

		wm.clickbyxpath("//span[@class='k-icon k-i-cancel']");
		Thread.sleep(200);

		wm.clickbyid("btnMainAdd");
		Thread.sleep(900);

		// 4 Hotel service charge rule Newly created country master refleced in
		// the country field

		wm.sendtextbyxvalue("//input[@aria-owns='CountryDesc_listbox']", Country);
		Thread.sleep(300);
		wm.Listnegativescearios("//*[@id='CountryDesc_listbox']/li", "0",
				"Nwly created country master reflcted in the country Field  ",
				"Nwly created country master not reflcted in the country Field");
		Thread.sleep(300);

		// 5 Hotel service charge rule Newly created City master refleced in the
		// City field
		wm.sendtextbyxvalue("//input[@aria-owns='CityDesc_listbox']", Citymaster);
		Thread.sleep(200);
		wm.Listnegativescearios("//*[@id='CityDesc_listbox']/li", "0",
				"Nwly created City master reflcted in the Airline Field  ",
				"Nwly created City master not reflcted in the Airline Field");
		Thread.sleep(200);

		// 6 Hotel service charge rule Newly created Hotel name master refleced
		// in the Hotel name field
		wm.sendtextbyxvalue("//input[@aria-owns='HotelName_listbox']", Hotelname);
		Thread.sleep(200);
		wm.Listnegativescearios("//*[@id='HotelName_listbox']/li", "0",
				"Nwly created Hotelname master reflcted in the Airline Field  ",
				"Nwly created Hotelname master not reflcted in the Airline Field");
		Thread.sleep(200);

		// 7 Hotel service charge rule Newly created Hotel type master refleced
		// in the Hotel type field

		wm.sendtextbyxvalue("//input[@aria-owns='HotelTypeDesc_listbox']", Hoteltype);
		Thread.sleep(200);
		wm.Listnegativescearios("//*[@id='HotelTypeDesc_listbox']/li", "0",
				"Nwly created HotelTypeDesc_listbox master reflcted in the Airline Field  ",
				"Nwly created HotelTypeDesc_listbox master not reflcted in the Airline Field");
		Thread.sleep(200);

		// 8 Hotel service charge rule Newly created Charge master refleced in
		// the charge name field

		wm.sendtextbyxvalue("//input[@aria-owns='ChargeName_listbox']", ChargeNamelistbox);
		Thread.sleep(200);
		wm.Listnegativescearios("//*[@id='ChargeName_listbox']/li", "0",
				"Nwly created ChargeName_listbox master reflcted in the Airline Field  ",
				"Nwly created ChargeName_listbox master not reflcted in the Airline Field");
		Thread.sleep(500);

		// 9 Hotel service charge rule Verify the nelwy created supplier name
		// reflected in the supplier name field
		wm.sendtextbyxvalue("//input[@aria-owns='SupplierName_listbox']", Suppliername);
		Thread.sleep(300);
		wm.Listnegativescearios("//*[@id='SupplierName_listbox']/li", "0",
				"Newly created SupplierName_listbox reflcted in the Airline Field  ",
				"Nwly created SupplierName_listbox master not reflcted in the Airline Field");
		Thread.sleep(200);
		wm.clickbyxpath("//span[@class='k-icon k-i-cancel']");
		Thread.sleep(200);

		wm.clickbyid("btnMainAdd");
		Thread.sleep(200);

		// 10 Hotel service charge rule Verify the duplicate code creations

		wm.sendtextbyxvalue("//input[@name='HotelServiceChargeName']", Servicechargename);
		Thread.sleep(300);
		wm.clickbyxpath("//span[@class='k-icon k-i-check']");
		Thread.sleep(200);

		wm.Mousemoveover("//input[@name='HotelServiceChargeName']");
		Thread.sleep(300);

		wm.Listnegativescearios(utility.Constant.Travelogixuitooltipvalidation, "0",
				"System not allowed to create duplicate records", "System  allowed to create duplicate records");
		Thread.sleep(200);

		// ===========================================================================================
		// 11 checkig inactive datas

		Thread.sleep(300);

		wm.clickbyxpath("//span[@class='k-icon k-i-cancel']");
		Thread.sleep(200);

		wm.clickbyid("btnMainAdd");

		Thread.sleep(500);

		wm.sendtextbyxvalue("//input[@aria-owns='CountryDesc_listbox']", Inactivecountry);
		Thread.sleep(300);
		wm.Listnegativesceariosnegativecaseschecking("//*[@id='CountryDesc_listbox']/li", "0",
				"Inactive country master not reflcted in the country Field  ",
				"inactive country master  reflcted in the country Field");
		Thread.sleep(300);

		// 5 Hotel service charge rule Newly created City master refleced in the
		// City field
		wm.sendtextbyxvalue("//input[@aria-owns='CityDesc_listbox']", inactiveCitymaster);
		Thread.sleep(200);
		wm.Listnegativesceariosnegativecaseschecking("//*[@id='CityDesc_listbox']/li", "0",
				"Inactive City master not reflcted in the City  Field  ",
				"Inactive City master reflcted in the City  Field");
		Thread.sleep(200);

		// 6 Hotel service charge rule Newly created Hotel name master refleced
		// in the Hotel name field
		wm.sendtextbyxvalue("//input[@aria-owns='HotelName_listbox']", inactiveHotelname);
		Thread.sleep(200);
		wm.Listnegativesceariosnegativecaseschecking("//*[@id='HotelName_listbox']/li", "0",
				"Inactive hotel name not reflcted in the hotelname Field  ",
				"Inactive hotel name reflcted in the hotelname Field");
		Thread.sleep(200);

		// 7 Hotel service charge rule Newly created Hotel type master refleced
		// in the Hotel type field

		wm.sendtextbyxvalue("//input[@aria-owns='HotelTypeDesc_listbox']", inactiveHoteltype);
		Thread.sleep(200);
		wm.Listnegativesceariosnegativecaseschecking("//*[@id='HotelTypeDesc_listbox']/li", "0",
				"inactive HotelTypeDesc_listbox master not reflcted in the Airline Field  ",
				"Inactive HotelTypeDesc_listbox master reflcted in the Airline Field");
		Thread.sleep(200);

		// 8 Hotel service charge rule Newly created Charge master refleced in
		// the charge name field

		wm.sendtextbyxvalue("//input[@aria-owns='ChargeName_listbox']", inactiveChargeNamelistbox);
		Thread.sleep(200);
		wm.Listnegativesceariosnegativecaseschecking("//*[@id='ChargeName_listbox']/li", "0",
				"Inactive ChargeName_listbox master not reflcted in the Airline Field  ",
				"Inactive ChargeName_listbox master reflcted in the Airline Field");
		Thread.sleep(500);

		// 9 Hotel service charge rule Verify the nelwy created supplier name
		// reflected in the supplier name field
		wm.sendtextbyxvalue("//input[@aria-owns='SupplierName_listbox']", inactiveSuppliername);
		Thread.sleep(300);
		wm.Listnegativesceariosnegativecaseschecking("//*[@id='SupplierName_listbox']/li", "0",
				"Inactive SupplierName_listbox not reflcted in the Airline Field  ",
				"Inactive SupplierName_listbox master reflcted in the Airline Field");
		Thread.sleep(200);
		wm.clickbyxpath("//span[@class='k-icon k-i-cancel']");
		Thread.sleep(200);

		
		wm.sleep();
	}

	@AfterMethod
	public void close()

	{
		wm.close();

	}

	@DataProvider(name = "dp")
	public Object[][] dp() throws IOException {

		return Wrappermethods.getSheet("Hotelscrulenegative", "Hotelscrulenegative");

	}
}