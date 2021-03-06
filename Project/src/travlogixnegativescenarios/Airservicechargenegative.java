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
public class Airservicechargenegative

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
	public void Airservicechargenegative(String Username, String Password, String Leftsidemenu,String Commonindex,
			String Servicechargename,String Applytype,String Servicechargeapplyon,String Servicechargeapplymode,
			String Allocationtypeclientcategory,String Allocationtypeasall,String Applytypeasperbooking,
			String Servicehargemodepercentage,String AascdServChrgBook,String discount,
			String inactiveservicechargerulename,String Duplicateservicechargerulename) throws Exception

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
		wm.clickbyid("pgmSC001");
		wm.sleep();

		// 1 Air Service Charge Rule Clicking the save button without changes

		wm.clickbyid("btnMainSave");
		wm.sleep();

		wm.Verifythealertpopupmessagesusincontains("//span[@id='diaInfoMessage']", 
				"changes",
				"without doing changes clicking the save button , System showing validation messages correctly ",
				"without doing changes clicking the save button ,  System showing validation messages not correctly ");
		Thread.sleep(300);

		wm.Listandenterquick("//span[contains(text(),'OK')]", "0");
		wm.Listandenterquick("//span[contains(text(),'OK')]", "1");
		wm.Listandenterquick("//span[contains(text(),'OK')]", "2");
		wm.Listandenterquick("//span[contains(text(),'OK')]", "3");
		Thread.sleep(500);

		// 2 Air Verify the Audit log fucntioanltiy [popup ]
		wm.clickbyid("btnAuditLog");
		Thread.sleep(300);
		wm.Verifythealertpopupmessagesusincontains("//span[@id='AuditLog_wnd_title']", 
				"Audit Log",
				"When clicking the audit log icon system displays the auditlog popup",
				"When clicking the audit log icon system displays the auditlog popup");
		Thread.sleep(300);

		wm.Listandenterquick("//span[@class='k-icon k-i-close']", "0");
		wm.Listandenterquick("//span[@class='k-icon k-i-close']", "1");
		wm.Listandenterquick("//span[@class='k-icon k-i-close']", "2");
		wm.Listandenterquick("//span[@class='k-icon k-i-close']", "3");
		Thread.sleep(500);

//3	Air Service charge	Validation in UI field	All mandatory Fields

	wm.clickbyid("btnMainAdd");
	Thread.sleep(900);
	wm.clickbyxpath("//span[@class='k-icon k-i-check']");
	Thread.sleep(300);
	wm.clickbyxpath("//input[@aria-owns='AascdServChrgMode_listbox']");
	Thread.sleep(300);

	// Service chargename
	wm.Mousemoveover("//input[@aria-owns='AascdServChgId_listbox']");
	Thread.sleep(300);
	wm.Listnegativescearios(utility.Constant.Travelogixuitooltipvalidation, Commonindex,
			"Service chargename vaidationis avilable ",
			"Service chargename vaidationis is not avilable ");
	Thread.sleep(300);

	//Applytype
	wm.Mousemoveover("//input[@aria-owns='AascdServApplyType_listbox']");
	Thread.sleep(300);
	wm.Listnegativescearios(utility.Constant.Travelogixuitooltipvalidation, Commonindex,
			"Apply type vaidationis avilable ",
			"Apply type vaidationis is not avilable ");
	Thread.sleep(300);



	//Service cargesappy on
	wm.Mousemoveover("//input[@aria-owns='AascdServChrgApplyOn_listbox']");
	Thread.sleep(300);
	wm.Listnegativescearios(utility.Constant.Travelogixuitooltipvalidation, Commonindex,
			"service charges applyon vaidationis avilable ",
			"service charges applyon  vaidationis is not avilable ");
	Thread.sleep(300);


	//Service cargesappy on
	wm.Mousemoveover("//input[@aria-owns='AascdServChrgMode_listbox']");
	Thread.sleep(300);
	wm.Listnegativescearios(utility.Constant.Travelogixuitooltipvalidation, Commonindex,
			"AascdServChrgMode_listbox applyon vaidationis avilable ",
			"AascdServChrgMode_listbox applyon  vaidationis is not avilable ");
	Thread.sleep(300);

	
//4	Air Service charge	Created Service charge rule should refelcted in the Service charge page
	

	Thread.sleep(300);
	wm.clickbyxpath("//span[@class='k-icon k-i-cancel']");
	Thread.sleep(300);
	wm.clickbyid("btnMainAdd");
	Thread.sleep(600);

	
	wm.sendtextbyxvalue("//input[@aria-owns='AascdServChgId_listbox']", Servicechargename);
	Thread.sleep(500);
	wm.Listnegativescearios("//*[@id='AascdServChgId_listbox']/li", Commonindex, 
			"Newly created Servicechargename reflected in Servicechargename field",
			"Newly created Servicechargename not reflected in Servicechargename field");
	Thread.sleep(300);
	
//5	Air Service charge	User able to selected the  Apply type
	

	wm.sendtextbyxvalue("//input[@aria-owns='AascdServApplyType_listbox']", Applytype);
	Thread.sleep(600);
	wm.Listnegativescearios("//*[@id='AascdServApplyType_listbox']/li", "0", 
			"Newly created Apply type  reflected in Servicechargename field",
			"Newly created Apply type  not reflected in Servicechargename field");
	Thread.sleep(300);
	
	
//6	Air Service charge	User able to selected the  Service charge apply on
	

	wm.sendtextbyxvalue("//input[@aria-owns='AascdServChrgApplyOn_listbox']", Servicechargeapplyon);
	Thread.sleep(300);
	wm.Listnegativescearios("//*[@id='AascdServChrgApplyOn_listbox']/li", Commonindex, 
			"Newly created AascdServChrgApplyOn_listbox  reflected in AascdServChrgApplyOn_listbox field",
			"Newly created AascdServChrgApplyOn_listbox  not reflected in AascdServChrgApplyOn_listbox field");
	Thread.sleep(300);
	
	
//7	Air Service charge	User able to selected the  Service charge mode


	wm.sendtextbyxvalue("//input[@aria-owns='AascdServChrgMode_listbox']", Servicechargeapplymode);
	Thread.sleep(300);
	wm.Listnegativescearios("//*[@id='AascdServChrgMode_listbox']/li", "0", 
			"Newly created AascdServChrgMode_listbox  reflected in AascdServChrgMode_listbox field",
			"Newly created AascdServChrgMode_listbox  not reflected in AascdServChrgMode_listbox field");
	Thread.sleep(300);

//8	Air Service charge	When selected the allocation type  as client category 
//system should display the  client category filed seperately 


	

	wm.sendtextbyxvalue("//input[@aria-owns='AascdCategoryType_listbox']",Allocationtypeclientcategory);
	Thread.sleep(300);
	wm.Listandenter("//*[@id='AascdCategoryType_listbox']/li", "1");
	Thread.sleep(500);
    
	wm.Listnegativescearios("//input[@aria-haspopup='listbox']", "0",
			"Allocation type as client category drop down  getting displayed",
			"Allocation type as client category drop down nott getting displayed");
	Thread.sleep(500);

//	9	Air Service charge	When selected the allocation type as All system should not display the 
	//client category field  seperately 	

	
	wm.sendtextbyxvalue("//input[@aria-owns='AascdCategoryType_listbox']",Allocationtypeasall);
	Thread.sleep(200);
	wm.Listandenter("//*[@id='AascdCategoryType_listbox']/li", "0");
	Thread.sleep(500);
    
	wm.Listnegativesceariosnegativecaseschecking("//input[@aria-haspopup='listbox']", "0",
			"Allocation type as all means the client category drop down not getting displayed",
			"Allocation type as all means the client category drop down  getting displayed");
	Thread.sleep(500);

	
//10  no feasbility to cehck	

//11 11	Air Service charge	Service  charge mode percentage  means	only allowed as percentage 

	
	Thread.sleep(300);
	wm.clickbyxpath("//span[@class='k-icon k-i-cancel']");
	Thread.sleep(300);
	wm.clickbyid("btnMainAdd");
	Thread.sleep(600);

	//selected as apply type
	wm.sendtextbyxvalue("//input[@aria-owns='AascdServApplyType_listbox']",Applytypeasperbooking);
	Thread.sleep(200);
	wm.Listnegativescearios("//*[@id='AascdServApplyType_listbox']/li", Commonindex,
			"Selected type as Applytypeasperbooking",
			"Selected type as Applytypeasperbooking");
	Thread.sleep(500);
	
	
	
	wm.sendtextbyxvalue("//input[@aria-owns='AascdServChrgMode_listbox']",Servicehargemodepercentage);
	Thread.sleep(200);
	wm.Listnegativescearios("//*[@id='AascdServChrgMode_listbox']/li", "1",
			"Selected service chargemode as Percentage",
			"Selected service chargemode not as Percentage");
	Thread.sleep(500);
	
	//enter percentage
	wm.sendtextbycssselecotrwithoutclear("#AascdServChrgBook", ""+AascdServChrgBook);
	Thread.sleep(300);
	//enter discount
	wm.sendtextbycssselecotrwithoutclear("#discount",""+discount);
	Thread.sleep(900);

	wm.clickbyxpath("//span[@class='k-icon k-i-check']");
	Thread.sleep(600);
	wm.clickbyxpath("//input[@aria-owns='AascdCategoryType_listbox']");
	Thread.sleep(600);

	wm.Mousemoveover("//input[@name='discount']");
	Thread.sleep(300);
	wm.Listnegativescearios(utility.Constant.Travelogixuitooltipvalidation, Commonindex,
			"Discount field have vaidaion if enter the percentage amount greater than 100%",
			"Discount field have no vaidaion if enter the percentage amount greater than 100%");
	Thread.sleep(300);


	wm.Mousemoveover("//input[@name='AascdServChrgBook']");
	Thread.sleep(300);
	wm.Listnegativescearios(utility.Constant.Travelogixuitooltipvalidation, Commonindex,
			"Service charge field have vaidaion if enter the percentage amount greater than 100%",
			"Service charge field have no vaidaion if enter the percentage amount greater than 100%");
	Thread.sleep(900);

	
	Thread.sleep(300);
	wm.clickbyxpath("//span[@class='k-icon k-i-cancel']");
	Thread.sleep(300);
	wm.clickbyid("btnMainAdd");
	Thread.sleep(900);

	
	//12	Air Service charge	Verify the inactive serivce charges rules
	
	wm.sendtextbyxvalue("//input[@aria-owns='AascdServChgId_listbox']",inactiveservicechargerulename);
	Thread.sleep(300);
	wm.Listnegativesceariosnegativecaseschecking("//*[@id='AascdServChgId_listbox']/li", Commonindex,
			"Inactive records are  showing in service rule name field",
			"Inactive records are not showing in service rule name field");
	Thread.sleep(500);
	
	
	//13	Air Service charge	Verify the duplicate record creations
	

	wm.sendtextbyxvalue("//input[@aria-owns='AascdServChgId_listbox']",Duplicateservicechargerulename);
	Thread.sleep(300);
	wm.Listandenter("//*[@id='AascdServChgId_listbox']/li", "0");
	Thread.sleep(300);
	
	wm.clickbyxpath("//span[@class='k-icon k-i-check']");
	Thread.sleep(200);
	
	wm.Mousemoveover("//input[@aria-owns='AascdServChgId_listbox']");
	Thread.sleep(300);

	wm.Listnegativescearios(utility.Constant.Travelogixuitooltipvalidation, Commonindex,
			"Duplicate validations is avilable ",
			"Duplicate validations is not avilable ");
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

		return Wrappermethods.getSheet("Airservicechargenegative", "Airservicechargenegative");

	}
}