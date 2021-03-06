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
public class Miscrulenegativescenarios

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
	public void Miscrulenegativescenarios(String Username, String Password, String Leftsidemenu,String Commonindex,
			String dupliateservicerulename,String Servicetype,String Servicecategroy,String Chargenamemaster,
			String Country,String Cityy,String inactiveServicetype,String inactiveServicecategroy,
			String inactiveChargenamemaster,String inactiveCountry,String inactiveCityy) throws Exception

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

		// ====================Creating Car Service Charge Rule Master negative
		// scenarios
		// screnn===========================================================
		wm.sendtextbyid("input-items", Leftsidemenu);
		Thread.sleep(500);
		wm.clickbyid("modTRS001");
		Thread.sleep(500);
		wm.clickbyid("pgmMIRU");
		wm.sleep();

		// 1 Misc Service Charge Rule Clicking the save button without changes

		wm.clickbyid("btnMainSave");
		wm.sleep();

		wm.Verifythealertpopupmessagesusincontains("//span[@id='diaInfoMessage']",
				"without doing changes",
				"without doing changes clicking the save button , System showing validation messages correctly ",
				"without doing changes clicking the save button ,  System showing validation messages not correctly ");
		Thread.sleep(300);

		wm.Listandenterquick("//span[contains(text(),'OK')]", "0");
		wm.Listandenterquick("//span[contains(text(),'OK')]", "1");
		wm.Listandenterquick("//span[contains(text(),'OK')]", "2");
		wm.Listandenterquick("//span[contains(text(),'OK')]", "3");
		Thread.sleep(500);

		// 2 Misc Verify the Audit log fucntioanltiy [popup ]
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

		// 3 Misc Service charge rule page Verify the UI field validations All
		// Madatroy fields

		wm.clickbyid("btnMainAdd");
		Thread.sleep(300);
		wm.Clearbyxpath("//input[@name='ActiveFrom']");
		Thread.sleep(900);

		wm.clickbyxpath("//span[@class='k-icon k-i-check']");
		Thread.sleep(300);

		// Service fullname

		wm.Mousemoveover("//input[@name='mimscrServiceRuleName']");
		Thread.sleep(300);
		wm.Listnegativescearios(utility.Constant.Travelogixuitooltipvalidation, Commonindex,
				"Service fullname vaidationis avilable ", "Service fullname vaidationis is not avilable ");
		Thread.sleep(300);

		// srvicetype validations

		wm.Mousemoveover("//input[@name='mimscrServiceType_input']");
		Thread.sleep(300);
		wm.Listnegativescearios(utility.Constant.Travelogixuitooltipvalidation, Commonindex,
				"mimscrServiceType_listbox vaidationis avilable ",
				"mimscrServiceType_listbox vaidationis is not avilable ");
		Thread.sleep(300);

		// service category validaions

		wm.Mousemoveover("//input[@name='miserviceCatName_input']");
		Thread.sleep(300);
		wm.Listnegativescearios(utility.Constant.Travelogixuitooltipvalidation, Commonindex,
				"miserviceCatName_input vaidationis avilable ", "miserviceCatName_input vaidationis is not avilable ");
		Thread.sleep(300);

		// Chargename validations

		wm.Mousemoveover("//input[@name='michargeName_input']");
		Thread.sleep(300);
		wm.Listnegativescearios(utility.Constant.Travelogixuitooltipvalidation, Commonindex,
				"michargeName_input vaidationis avilable ", "michargeName_input vaidationis is not avilable ");
		Thread.sleep(300);
		
		wm.clickbyxpath("//span[@class='k-icon k-i-cancel']");
		Thread.sleep(500);

		wm.clickbyid("btnMainClear");
		Thread.sleep(600);

		wm.clickbyid("btnMainAdd");
		Thread.sleep(400);

		// ===========================================================================================

		// 9 Misc Service charge rule page Verify the duplciate record creations

		wm.sendtextbyxvalue("//input[@name='mimscrServiceRuleName']", dupliateservicerulename);
		Thread.sleep(400);
		wm.clickbyxpath("//span[@class='k-icon k-i-check']");
		Thread.sleep(300);
		wm.Mousemoveover("//input[@name='mimscrServiceRuleName']");
		Thread.sleep(300);
		wm.Listnegativescearios(utility.Constant.Travelogixuitooltipvalidation, Commonindex,
				"mimscrService RuleName Duplicate vaidationis is avilable ",
				"mimscrService RuleName Duplicate vaidationis is not avilable ");
		Thread.sleep(300);

		// 4 Misc Service charge rule page Newly created service type master
		// refleced in the Service type field

		Thread.sleep(300);
		wm.sendtextbyxvalue("//input[@aria-owns='mimscrServiceType_listbox']", Servicetype);
		Thread.sleep(300);
		wm.Listnegativescearios("//*[@id='mimscrServiceType_listbox']/li", Commonindex,
				"Newly created mimscrServiceType_listbox is avilable in mimscrServiceType_listbox field in misc ",
				"Newly created mimscrServiceType_listbox  is not avilable in mimscrServiceType_listbox filed in misc ");
		Thread.sleep(500);

		// 5 Misc Service charge rule page Newly created service Category master
		// refleced in
		// the Service Category field

		Thread.sleep(300);
		wm.sendtextbyxvalue("//input[@aria-owns='miserviceCatName_listbox']", Servicecategroy);
		Thread.sleep(300);
		wm.Listnegativescearios("//*[@id='miserviceCatName_listbox']/li", Commonindex,
				"Newly created miserviceCatName_listbox is avilable in miserviceCatName_listbox",
				"Newly created miserviceCatName_listbox  is not avilable in miserviceCatName_listbox");
		Thread.sleep(500);

		// 6 Misc Service charge rule page Newly created Charge master refleced
		// in the charge name field

		Thread.sleep(300);
		wm.sendtextbyxvalue("//input[@aria-owns='michargeName_listbox']", Chargenamemaster);
		Thread.sleep(300);
		wm.Listnegativescearios("//*[@id='michargeName_listbox']/li", Commonindex,
				"Newly created michargeName_listbox is avilable in misc michargeName_listbox",
				"Newly created michargeName_listbox  is not avilable in misc michargeName_listbox");
		Thread.sleep(500);

		// 7 Misc Service charge rule page Newly created country master refleced
		// in the country field

		Thread.sleep(300);
		wm.sendtextbyxvalue("//input[@aria-owns='micountryName_listbox']", Country);
		Thread.sleep(300);
		wm.Listnegativescearios("//*[@id='micountryName_listbox']/li", Commonindex,
				"Newly created micountryName_listbox is avilable in msic service charge rulepage",
				"Newly created micountryName_listbox  is not avilable in misc  service charge rulepage");
		Thread.sleep(500);

		// 8 Misc Service charge rule page Newly created City master refleced in
		// the City field

		Thread.sleep(300);
		wm.sendtextbyxvalue("//input[@aria-owns='micityName_listbox']", Cityy);
		Thread.sleep(300);
		wm.Listnegativescearios("//*[@id='micityName_listbox']/li", Commonindex,
				"Newly created micityName_listbox is avilable in misc service charge rulepage",
				"Newly created micityName_listbox  is not avilable in misc service charge rulepage");
		Thread.sleep(500);

		
//=============================================================================================================
		
		// Verify the inactive datasis avilable in the miscc

		// 4 Misc Service charge rule page Newly created service type master
		// refleced in the Service type field

		Thread.sleep(300);
		wm.sendtextbyxvalue("//input[@aria-owns='mimscrServiceType_listbox']",inactiveServicetype);
		Thread.sleep(300);
		wm.Listnegativesceariosnegativecaseschecking("//*[@id='mimscrServiceType_listbox']/li",
				Commonindex,
				"inactive mimscrServiceType_listbox is  avilable in mimscrServiceType_listbox field in misc ",
				"inactive mimscrServiceType_listbox  is not avilable in mimscrServiceType_listbox filed in misc ");
		Thread.sleep(500);

		// 5 Misc Service charge rule page Newly created service Category master
		// refleced in
		// the Service Category field

		Thread.sleep(300);
		wm.sendtextbyxvalue("//input[@aria-owns='miserviceCatName_listbox']", inactiveServicecategroy);
		Thread.sleep(300);
		wm.Listnegativesceariosnegativecaseschecking("//*[@id='miserviceCatName_listbox']/li", Commonindex,
				"inactive  miserviceCatName_listbox is  avilable in miserviceCatName_listbox",
				"inactive miserviceCatName_listbox  is not avilable in miserviceCatName_listbox");
		Thread.sleep(500);

		// 6 Misc Service charge rule page Newly created Charge master refleced
		// in the charge name field

		Thread.sleep(300);
		wm.sendtextbyxvalue("//input[@aria-owns='michargeName_listbox']", inactiveChargenamemaster);
		Thread.sleep(300);
		wm.Listnegativesceariosnegativecaseschecking("//*[@id='michargeName_listbox']/li", Commonindex,
				"inactive michargeName_listbox is  avilable in misc michargeName_listbox",
				"inactive michargeName_listbox  is not  avilable in misc michargeName_listbox");
		Thread.sleep(500);

		// 7 Misc Service charge rule page Newly created country master refleced
		// in the country field

		Thread.sleep(300);
		wm.sendtextbyxvalue("//input[@aria-owns='micountryName_listbox']", inactiveCountry);
		Thread.sleep(300);
		wm.Listnegativesceariosnegativecaseschecking("//*[@id='micountryName_listbox']/li", Commonindex,
				"inactive micountryName_listbox is  avilable in msic service charge rulepage",
				"inactive micountryName_listbox  is not  avilable in misc  service charge rulepage");
		Thread.sleep(500);

		// 8 Misc Service charge rule page Newly created City master refleced in
		// the City field

		Thread.sleep(300);
		wm.sendtextbyxvalue("//input[@aria-owns='micityName_listbox']", inactiveCityy);
		Thread.sleep(300);
		wm.Listnegativesceariosnegativecaseschecking("//*[@id='micityName_listbox']/li", Commonindex,
				"inactive  micityName_listbox is  avilable in misc service charge rulepage",
				"inactive micityName_listbox  is not avilable in misc service charge rulepage");
		Thread.sleep(500);

		wm.sleep();
	}

	@AfterMethod
	public void close()

	{
		wm.close();

	}

	@DataProvider(name = "dp")
	public Object[][] dp() throws IOException {

		return Wrappermethods.getSheet("Miscrulenegativescenarios", "Miscrulenegativescenarios");

	}
}