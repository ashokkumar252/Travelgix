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
public class CarserviceChargenegative
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
	public void CarserviceChargenegative(String Username, String Password, String Leftsidemenu,String Commonindex,
			String Servicerulename,String Applytype,String Servicehargemodepercentage,String CcscdCarServChgBook,
			String discount,String Allocationtypeasall,String Allocationtypeclientcategory,
			String inactiveservicechargerulename,String Duplicateservicechargerulename
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

		// ====================Creating Car Service Charge Rule Master negative
		// scenarios
		// screnn===========================================================
		wm.sendtextbyid("input-items", Leftsidemenu);
		Thread.sleep(500);
		wm.clickbyid("modTRS001");
		Thread.sleep(500);
		wm.clickbyid("pgmSC003");
		wm.sleep();

		// 1 Misc Service Charge Rule Clicking the save button without changes

		wm.clickbyid("btnMainSave");
		wm.sleep();

		wm.Verifythealertpopupmessagesusincontains("//span[@id='diaInfoMessage']", 
				"without",
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

		// 3 Car Service charge page Verify the UI field validations Need to
		// start

		wm.clickbyid("btnMainAdd");
		Thread.sleep(300);
		wm.clickbyxpath("//span[@class='k-icon k-i-check']");
		Thread.sleep(300);
		wm.clickbyxpath("//input[@aria-owns='CcscdApplyType_listbox']");
		Thread.sleep(300);

		// service rulename

		wm.Mousemoveover("//input[@name='CcscdCarServChgId_input']");
		Thread.sleep(300);
		wm.Listnegativescearios(utility.Constant.Travelogixuitooltipvalidation, Commonindex,
				"Service rulename vaidationis avilable ", "Service rulename vaidationis is not avilable ");
		Thread.sleep(300);

		// Applytype
		wm.Mousemoveover("//input[@name='CcscdApplyType_input']");
		Thread.sleep(300);
		wm.Listnegativescearios(utility.Constant.Travelogixuitooltipvalidation, Commonindex,
				"CcscdApplyType_listbox vaidationis avilable ", "CcscdApplyType_listbox vaidationis is not avilable ");
		Thread.sleep(300);

		// Servicecharge mode
		wm.Mousemoveover("//input[@name='CcscdCarServChgMode_input']");
		Thread.sleep(300);
		wm.Listnegativescearios(utility.Constant.Travelogixuitooltipvalidation, Commonindex,
				"CcscdCarServChgMode_listbox vaidationis avilable ",
				"CcscdCarServChgMode_listbox vaidationis is not avilable ");
		Thread.sleep(300);

		// allocation type
		wm.Mousemoveover("//input[@name='CcscdAllocationType_input']");
		Thread.sleep(300);
		wm.Listnegativescearios(utility.Constant.Travelogixuitooltipvalidation, Commonindex,
				"CcscdCarServChgMode_listbox vaidationis avilable ",
				"CcscdCarServChgMode_listbox vaidationis is not avilable ");
		Thread.sleep(300);

		// Service charge appluon
		wm.Mousemoveover("//input[@name='cscdServChrgApplyOn_input']");
		Thread.sleep(300);
		wm.Listnegativescearios(utility.Constant.Travelogixuitooltipvalidation, Commonindex,
				"cscdServChrgApplyOn_listbox vaidationis avilable ",
				"cscdServChrgApplyOn_listbox vaidationis is not avilable ");
		Thread.sleep(300);

		wm.clickbyxpath("//span[@class='k-icon k-i-cancel']");
		Thread.sleep(300);
		wm.clickbyid("btnMainAdd");
		Thread.sleep(900);

		// 4 Car Service charge page Verify the newly created car service charge
		// reflected in service rule name

		wm.sendtextbyxvalue("//input[@aria-owns='CcscdCarServChgId_listbox']", Servicerulename);
		Thread.sleep(200);
		wm.Listnegativescearios("//*[@id='CcscdCarServChgId_listbox']/li", Commonindex,
				"Created service charge reflected in the service rule name",
				"Created service charge not reflected in the service rule name");
		Thread.sleep(200);

		// 5 Car Service charge page User able to select the apply type
		wm.sendtextbyxvalue("//input[@aria-owns='CcscdApplyType_listbox']",Applytype);
		Thread.sleep(200);
		wm.Listnegativescearios("//*[@id='CcscdApplyType_listbox']/li", Commonindex,
				"Created CcscdApplyType_listbox reflected in the service rule name",
				"Created CcscdApplyType_listbox not reflected in the service rule name");
		Thread.sleep(500);

	//6	Car Service charge page	Verify the Service charge mode : Fixed	Allowed only amount

		//point 6 : No feasability to checkk
		
// 7	Car Service charge page	Verify the Service charge mode : Percentage	Not allowed  more than %

		Thread.sleep(300);
		wm.clickbyxpath("//span[@class='k-icon k-i-cancel']");
		Thread.sleep(300);
		wm.clickbyid("btnMainAdd");
		Thread.sleep(600);

		wm.sendtextbyxvalue("//input[@aria-owns='CcscdCarServChgMode_listbox']",Servicehargemodepercentage);
		Thread.sleep(200);
		wm.Listnegativescearios("//*[@id='CcscdCarServChgMode_listbox']/li", Commonindex,
				"Selected service chargemode as Percentage",
				"Selected service chargemode not as Percentage");
		Thread.sleep(500);
		
		//enter percentage
		wm.sendtextbycssselecotrwithoutclear("#CcscdCarServChgBook", ""+CcscdCarServChgBook);
		Thread.sleep(300);
		//enter discount
		wm.sendtextbycssselecotrwithoutclear("#discount",""+discount);
		Thread.sleep(300);
	
		wm.clickbyxpath("//span[@class='k-icon k-i-check']");
		Thread.sleep(300);
		wm.clickbyxpath("//input[@aria-owns='CcscdApplyType_listbox']");
		Thread.sleep(300);

		wm.Mousemoveover("//input[@name='discount']");
		Thread.sleep(300);
		wm.Listnegativescearios(utility.Constant.Travelogixuitooltipvalidation, Commonindex,
				"Discount field have vaidaion if enter the percentage amount greater than 100%",
				"Discount field have no vaidaion if enter the percentage amount greater than 100%");
		Thread.sleep(300);


//validatin gthe serie chargemode fied vaidations
		wm.Mousemoveover("//input[@name='CcscdCarServChgBook']");
		Thread.sleep(300);
		wm.Listnegativescearios(utility.Constant.Travelogixuitooltipvalidation, Commonindex,
				"Service charge field have vaidaion if enter the percentage amount greater than 100%",
				"Service charge have no vaidaion if enter the percentage amount greater than 100%");
		Thread.sleep(300);

		
//		8	Car Service charge page	When selected the allocation type  as client category  system should display 
		//the  client category filed seperately 	
		
		wm.sendtextbyxvalue("//input[@aria-owns='CcscdAllocationType_listbox']",Allocationtypeasall);
		Thread.sleep(200);
		wm.Listandenter("//*[@id='CcscdAllocationType_listbox']/li", "0");
		Thread.sleep(200);
		
	
	    
		wm.Listnegativesceariosnegativecaseschecking("//input[@aria-haspopup='listbox']", "0",
				"Allocation type as all means the client category drop down not getting displayed",
				"Allocation type as all means the client category drop down  getting displayed");
		Thread.sleep(500);
		
		
		//selected allclient category
//	9	Car Service charge page	When selected the allocation type as All system should not 
	// display the  client category field  seperately 


		wm.sendtextbyxvalue("//input[@aria-owns='CcscdAllocationType_listbox']",Allocationtypeclientcategory);
		Thread.sleep(300);
		wm.Listandenter("//*[@id='CcscdAllocationType_listbox']/li", "0");
		Thread.sleep(300);
	    
		wm.Listnegativescearios("//input[@aria-haspopup='listbox']", "0",
				"Allocation type as client category drop down  getting displayed",
				"Allocation type as client category drop down nott getting displayed");
		Thread.sleep(500);
	
//10	Car Service charge page	Verify the discount field , should not increase more than 100 %

//Already tested on poin tno : 7
//===================================================================================
		
		
//11	Car Service charge page	Verify the inactive rules in  Car  service charge
		wm.sendtextbyxvalue("//input[@aria-owns='CcscdCarServChgId_listbox']",inactiveservicechargerulename);
		Thread.sleep(500);
		wm.Listnegativesceariosnegativecaseschecking("//*[@id='CcscdCarServChgId_listbox']/li", Commonindex,
				"Inactive records are not showing in service rule name field",
				"Inactive records are showing in service rule name field");
		Thread.sleep(500);
		
//12	Car Service charge page	Verify the duplicate code creations

		wm.sendtextbyxvalue("//input[@aria-owns='CcscdCarServChgId_listbox']",Duplicateservicechargerulename);
		Thread.sleep(300);
		wm.Listandenter("//*[@id='CcscdCarServChgId_listbox']/li", "0");
		Thread.sleep(300);
		
		wm.clickbyxpath("//span[@class='k-icon k-i-check']");
		Thread.sleep(200);
		
		wm.Mousemoveover("//input[@aria-owns='CcscdCarServChgId_listbox']");
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

		return Wrappermethods.getSheet("CarserviceChargenegative", "CarserviceChargenegative");

	}
}