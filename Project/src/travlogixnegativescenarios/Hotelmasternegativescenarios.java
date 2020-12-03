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
public class Hotelmasternegativescenarios {

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
	public void Hotelmasternegativescenarios(String Username, String Password, String Leftsidemenu,String Email,String Commonindex, String Hcountry,
			String Hcountryindex, String Hcity, String Hcityindex, String Hotelchain, String Hotelchainindex,
			String Startype, String Startypeindexx, String Statusindexx,String Filterbycode,String telephonnumbers,
			String Faxnumber) throws Exception

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

		// ====================Creating executive master
		// screnn===========================================================
		wm.sendtextbyid("input-items", Leftsidemenu);
		Thread.sleep(500);
		wm.clickbyid("modMAS001");
		Thread.sleep(500);
		wm.clickbyid("pgmHTL001");
		wm.sleep();
		Thread.sleep(2000);
		wm.clickbyid("btnMainAdd");
		Thread.sleep(500);

		// starte wrign the negative scenarios

		wm.Clearbyxpath("//input[@aria-owns='ActiveFrom_dateview']");
		Thread.sleep(200);
		
		wm.sendtextbyxvalue("//input[@name='HtlEmail']", Email);
		Thread.sleep(200);

		wm.clickbyxpath("//span[@class='k-icon k-i-check']");

		// 1 Hotel Master Mandatory validations name Field Verify the Validation
		// message clicking the save button without enter the details

		wm.Mousemoveover("//input[@name='Description']");
		Thread.sleep(200);
		wm.Listnegativescearios(utility.Constant.Travelogixuitooltipvalidation, Commonindex,
				"Pass :   validations is avilable in name  field" + "",
				"Fail:  validations is not avilable in name  field " + "");
		Thread.sleep(200);

		// 2 Hotel Master Mandatory validations nam Country Field Verify the
		// Validation message clicking the save button without enter the details
		wm.Mousemoveover("//input[@aria-owns='HtlCountryName_listbox']");
		Thread.sleep(200);
		wm.Listnegativescearios(utility.Constant.Travelogixuitooltipvalidation, Commonindex,
				"Pass :   validations is avilable in Country  field" + "",
				"Fail:  validations is not avilable in Country  field " + "");
		Thread.sleep(200);

		// 3 Hotel Master Mandatory validations city Field Verify the Validation
		// message clicking the save button without enter the details
		wm.Mousemoveover("//input[@aria-owns='HtlCityName_listbox']");
		Thread.sleep(200);
		wm.Listnegativescearios(utility.Constant.Travelogixuitooltipvalidation, Commonindex,
				"Pass :   validations is avilable in City  field" + "",
				"Fail:  validations is not avilable in City  field " + "");
		Thread.sleep(200);
		
		
		
		//16	Hotel Master	Email validations	Validation should get displayed  for invalid emial ids
		
		
		wm.Mousemoveover("//input[@name='HtlEmail']");
		Thread.sleep(200);
		wm.Listnegativescearios(utility.Constant.Travelogixuitooltipvalidation, Commonindex,
				"Pass :   Email validations is avilable in Email field " + "",
				"Fail:  Email validations is not avilable in Email field " + "");
		Thread.sleep(200);
		
		

		// 4 Hotel Master Mandatory validations hotel chain Field Verify the
		// Validation message clicking the save button without enter the details
		wm.Mousemoveover("//input[@aria-owns='HtlChainName_listbox']");
		Thread.sleep(200);
		wm.Listnegativescearios(utility.Constant.Travelogixuitooltipvalidation, Commonindex,
				"Pass :   validations is avilable in Hotel chian  field" + "",
				"Fail:  validations is not avilable in Hotel chain  field " + "");
		Thread.sleep(200);

		// 5 Hotel Master Mandatory validations start type Field Verify the
		// Validation message clicking the save button without enter the details
		wm.Mousemoveover("//input[@aria-owns='HtlTypeName_listbox']");
		Thread.sleep(200);
		wm.Listnegativescearios(utility.Constant.Travelogixuitooltipvalidation, Commonindex,
				"Pass :   validations is avilable in Start type field" + "",
				"Fail:  validations is not avilable in Start type field " + "");
		Thread.sleep(200);

		// 6 Hotel Master Mandatory validations status Field Verify the
		// Validation message clicking the save button without enter the details

		wm.Mousemoveover("//span[@aria-owns='HtlStatus_listbox']");
		Thread.sleep(200);
		wm.Listnegativescearios(utility.Constant.Travelogixuitooltipvalidation, Commonindex,
				"Pass :   validations is avilable in Status type field" + "",
				"Fail:  validations is not avilable in Status type field " + "");
		Thread.sleep(200);

		// 7 Hotel Master Mandatory validations Fromdate Field Verify the
		// Validation message clicking the save button without enter the details

		wm.Mousemoveover("//input[@aria-owns='ActiveFrom_dateview']");
		Thread.sleep(200);
		wm.Listnegativescearios(utility.Constant.Travelogixuitooltipvalidation, Commonindex,
				"Pass :   validations is avilable in From date field" + "",
				"Fail:  validations is not avilable in From datee field " + "");
		Thread.sleep(200);

		wm.clickbyxpath("//span[@class='k-icon k-i-cancel']");
		Thread.sleep(3000);
		wm.clickbyid("btnMainAdd");
		Thread.sleep(500);

		// 8 Hotel Master Country Newly created Country Reflected on not

		wm.sendtextbyxvalue("//input[@aria-owns='HtlCountryName_listbox']", Hcountry);
		Thread.sleep(500);
		wm.Listnegativescearios("//*[@id='HtlCountryName_listbox']/li", Hcountryindex,
				"Pass :   Newly created country is refleted in the Country field" + "",
				"Fail:  Newly created country is not avilable in Country field " + "");
		Thread.sleep(200);

		// 9 Hotel Master City Newly created City Reflected on not
		wm.sendtextbyxvalue("//input[@aria-owns='HtlCityName_listbox']", Hcity);
		Thread.sleep(200);
		wm.Listnegativescearios("//*[@id='HtlCityName_listbox']/li", Hcityindex,
				"Pass :   newcly created city is avilable in City field" + "",
				"Fail:  newcly created city is not avilable in City field " + "");
		Thread.sleep(200);

		// 10 Hotel Master Hotel chain Newly created hotel chain reflected in
		// the field

		wm.sendtextbyxvalue("//input[@aria-owns='HtlChainName_listbox']", Hotelchain);
		Thread.sleep(200);
		wm.Listnegativescearios("//*[@id='HtlChainName_listbox']/li", Hotelchainindex,
				"Pass :   Newly created HtlChainName is avilable in Hotelchain field" + "",
				"Fail:  Newly created HtlChainName is not avilable in Hotelchain field " + "");
		Thread.sleep(200);

		// 12 Hotel Master Status Verify the user able to selected the status or
		// not

		wm.clickbyxpath("//span[@aria-owns='HtlStatus_listbox']");
		// wm.sendtextbyxvalue("//input[@aria-owns='HtlStatus_listbox']",
		// Status);
		Thread.sleep(200);
		wm.Listnegativescearios("//*[@id='HtlStatus_listbox']/li", Statusindexx,
				"Pass :   Status is avilable in Status field" + "",
				"Fail:  Status is not avilable in Status field " + "");
		Thread.sleep(200);

		// 11 Hotel Master Star type Newly created start type reflected in the
		// star type field
		wm.sendtextbyxvalue("//input[@aria-owns='HtlTypeName_listbox']", Startype);
		Thread.sleep(200);
		wm.Listnegativescearios("//*[@id='HtlTypeName_listbox']/li", Startypeindexx,
				"Pass :   Newly created star type  is avilable in Starttype field" + "",
				"Fail:  Newly created star type  is not avilable in Starttype field " + "");
		Thread.sleep(200);

		wm.clickbyxpath("//span[@class='k-icon k-i-cancel']");
		Thread.sleep(200);

		
//Audit log 
		
//13	Hotel Master	Audit log	Verify the Audit log popup is open or not

wm.clickbyid("btnAuditLog");
		Thread.sleep(300);
		wm.Verifythealertpopupmessagesusincontains("//span[@id='AuditLog_wnd_title']", "Audit Log",
				"When clicking the audit log icon system displays the auditlog popup",
				"When clicking the audit log icon system not displays the auditlog popup");
		Thread.sleep(200);

		wm.Listandenterquick("//span[@class='k-icon k-i-close']", "0");
		wm.Listandenterquick("//span[@class='k-icon k-i-close']", "1");
		wm.Listandenterquick("//span[@class='k-icon k-i-close']", "2");
		wm.Listandenterquick("//span[@class='k-icon k-i-close']", "3");
		Thread.sleep(200);

//clickig the savebutton
		

		wm.clickbyid("btnMainSave");
		Thread.sleep(300);
		wm.Verifythealertpopupmessagesusincontains("//span[@id='diaErrorMessage']", 
				"Selection or Changes are not happened.",
				"Without enter the details and click save button in the grid level  , System showing validation messages correctly ",
				"Without enter the details and click save button in the grid level ,  System showing validation messages not correctly ");
		Thread.sleep(200);

		wm.Listandenterquick("//span[contains(text(),'OK')]", "0");
		wm.Listandenterquick("//span[contains(text(),'OK')]", "1");
		wm.Listandenterquick("//span[contains(text(),'OK')]", "2");
		wm.Listandenterquick("//span[contains(text(),'OK')]", "3");
		Thread.sleep(200);
		
//Filterby data
		

		wm.Listandenter("//span[@class='k-icon k-i-more-vertical']", "0");
		Thread.sleep(100);
		wm.clickbyxpath(" //li[@class='k-item k-menu-item k-filter-item k-state-default k-last']");
		Thread.sleep(100);
		wm.sendtextbyxvalue("//input[@data-bind='value:filters[0].value']", Filterbycode);
		Thread.sleep(200);
		wm.clickbyxpath("//button[@type='submit']");
		Thread.sleep(100);
		wm.Verifythealertpopupmessages("//*[@class='text-uppercase']", Filterbycode, "Filter by data is success",
				"Filter by data is nott success");
		Thread.sleep(300);
		
		//15	Hotel Master	Edit -> Filter the data -> change from active to inactive status	Inactive status should not be displayed in the grid	Nofeasbility [ During  editing someof the mandatory details are not loaded ]
/*
		wm.clickbyxpath("//*[@class='text-uppercase']");
		Thread.sleep(200);
		wm.Listandenter("//span[@class='k-icon k-i-edit']", "0");
		Thread.sleep(200);
		wm.clickbyxpath("//span[@aria-owns='HtlStatus_listbox']");
		Thread.sleep(200);
		wm.Listnegativescearios("//*[@id='HtlStatus_listbox']/li", "1",
				"Pass :   Selected inactive status successfuly" + "",
				"Fail:   Not ableto to Selected the inactive status successfuly " + "");
		Thread.sleep(200);
		wm.clickbyxpath(" //span[@class='k-icon k-i-check']");
		Thread.sleep(900);
*/		

	
//17	Hotel Master	Telephone file	only numbers should accept

		wm.clickbyid("btnMainAdd");
		Thread.sleep(200);
		
		wm.sendtextbyxvalue("//input[@name='HtlTelephone']", ""+telephonnumbers);
		Thread.sleep(200);
		wm.Checkingtextboxcontainstextornumeric("//input[@name='HtlTelephone']",telephonnumbers,"Telephone Field allowed only numbers", 
				"Telephone field not allowed only numbers,itallowed text also");
//18	Hotel Master	Fax numberfield	only numbers  should accept

		wm.sendtextbyxvalue("//input[@name='HtlFax']", ""+Faxnumber);
		Thread.sleep(200);
		wm.Checkingtextboxcontainstextornumeric("//input[@name='HtlTelephone']",telephonnumbers,
				"Faxnumber field is allowed only numbers", 
				"Faxnukber  field not allowed only numbers,it allowed text also");
 Thread.sleep(200);
 wm.clickbyxpath("//span[@class='k-icon k-i-cancel']");
 Thread.sleep(200);

 
//=====================================================================================================
 

	
		
		wm.sleep();

	}

	@AfterMethod
	public void close()

	{
		wm.close();

	}

	@DataProvider(name = "dp")
	public Object[][] dp() throws IOException {

		return Wrappermethods.getSheet("Hotelmasternegativescenarios", "Hotelmasternegativescenarios");

	}
}