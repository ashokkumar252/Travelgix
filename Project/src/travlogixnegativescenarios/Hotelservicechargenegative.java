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
public class Hotelservicechargenegative

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
	public void Hotelservicechargenegative(String Username, String Password, String Leftsidemenu,String Commonindex,
			String Hotelservicerulename,String Hotelapplytypee,String Servicehargemodepercentage,
			String HhscdServChrgMon,String Discount,String Allocationtypeclientcategory,
			String Allocationtypeasall,String Servicechargetypeon,String inactivehotelservicrulename,
			String Duplicateservicechargerulename) throws Exception

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
		wm.clickbyid("pgmSC002");
		wm.sleep();

		// 1 Misc Service Charge Rule Clicking the save button without changes

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

		// 2 Hotel  Verify the Audit log fucntioanltiy [popup ]
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

		
//3	Hotel service charge	Verify the Edit and save actions
//No feasability

//4	Hotel service charge	Newly created Service charge should reflected in  hotel service rule name 


		wm.clickbyid("btnMainAdd");
		Thread.sleep(300);
		wm.clickbyxpath("//span[@class='k-icon k-i-check']");
		Thread.sleep(300);
	
		wm.sendtextbyxvalue("//input[@aria-owns='HhscdServChrgId_listbox']", Hotelservicerulename);
		Thread.sleep(200);
		wm.Listnegativescearios("//*[@id='HhscdServChrgId_listbox']/li", Commonindex,
				"Created service charge reflected in the service rule name",
				"Created service charge not reflected in the service rule name");
		Thread.sleep(200);

//5	Hotel service charge	Verify user able to selected the apply typee and  Service rulename 


//Servicerulename
		/*wm.sendtextbyxvalue("//input[@aria-owns='HhscdServChrgId_listbox']", Hotelservicerulename);
		Thread.sleep(200);
		wm.Listnegativescearios("//*[@id='HhscdServChrgId_listbox']/li", Commonindex,
				"Created service charge reflected in the service rule name",
				"Created service charge not reflected in the service rule name");
		Thread.sleep(200);
*/

	//applytypee

		wm.sendtextbyxvalue("//input[@aria-owns='HhscdApplyType_listbox']", Hotelapplytypee);
		Thread.sleep(200);
		wm.Listnegativescearios("//*[@id='HhscdApplyType_listbox']/li", Commonindex,
				"Created Apply type  reflected in the service rule name",
				"Created Apply type not reflected in the service rule name");
		Thread.sleep(200);

//7	Hotel service charge	Verify the Service charge mode : Percentage	Not allowed  more than 100%

		
		

		Thread.sleep(300);
		wm.clickbyxpath("//span[@class='k-icon k-i-cancel']");
		Thread.sleep(300);
		wm.clickbyid("btnMainAdd");
		Thread.sleep(600);

		wm.sendtextbyxvalue("//input[@aria-owns='HhscdServChrgMode_listbox']",Servicehargemodepercentage);
		Thread.sleep(200);
		wm.Listnegativescearios("//*[@id='HhscdServChrgMode_listbox']/li", "1",
				"Selected service chargemode as Percentage",
				"Selected service chargemode not as Percentage");
		Thread.sleep(500);
		
		//enter percentage
		wm.sendtextbycssselecotrwithoutclear("#HhscdServChrgMon", ""+HhscdServChrgMon);
		Thread.sleep(300);
		//enter discount
		wm.sendtextbycssselecotrwithoutclear("#discount",""+Discount);
		Thread.sleep(500);
	
		wm.clickbyxpath("//span[@class='k-icon k-i-check']");
		Thread.sleep(300);

		
		wm.Mousemoveover("//input[@name='discount']");
		Thread.sleep(300);
		wm.Listnegativescearios(utility.Constant.Travelogixuitooltipvalidation, Commonindex,
				"Discount field have vaidaion if enter the percentage amount greater than 100%",
				"Discount field have no vaidaion if enter the percentage amount greater than 100%");
		Thread.sleep(600);


//validatin gthe serie chargemode fied vaidations
		wm.Mousemoveover("//input[@name='HhscdServChrgMon']");
		Thread.sleep(300);
		wm.Listnegativescearios(utility.Constant.Travelogixuitooltipvalidation, Commonindex,
				"Service charge field have vaidaion if enter the percentage amount greater than 100%",
				"Service charge have no vaidaion if enter the percentage amount greater than 100%");
		Thread.sleep(500);
		
		
//8	Hotel service charge	When selected the allocation type  as client category 
		//system should display the  client category filed seperately 
		wm.sendtextbyxvalue("//input[@aria-owns='HhscdCategoryType_listbox']",Allocationtypeclientcategory);
		Thread.sleep(400);
		wm.Listandenter("//*[@id='HhscdCategoryType_listbox']/li", "1");
		Thread.sleep(300);
	    
		wm.Listnegativescearios("//input[@aria-haspopup='listbox']", "0",
				"Allocation type as client category field  getting displayed",
				"Allocation type as client category Field nott getting displayed");
		Thread.sleep(500);
	

//9	Hotel service charge	When selected the allocation type as All system should not display the
		//client category field  seperately 	

		wm.clickbyxpath("//input[@aria-owns='HhscdCategoryType_listbox']");
		Thread.sleep(500);
		wm.clickbyxpath("//span[@class='k-icon k-i-cancel']");
		Thread.sleep(500);
		wm.clickbyid("btnMainAdd");
		Thread.sleep(600);


		wm.sendtextbyxvalue("//input[@aria-owns='HhscdCategoryType_listbox']",Allocationtypeasall);
		Thread.sleep(200);
		wm.Listandenter("//*[@id='HhscdCategoryType_listbox']/li", "0");
		Thread.sleep(300);
	    
		wm.Listnegativesceariosnegativecaseschecking("//input[@aria-haspopup='listbox']", "0",
				"Allocation type as all means the client category drop down not getting displayed",
				"Allocation type as all means the client category drop down  getting displayed");
		Thread.sleep(500);
		
//10	Hotel service charge	Verify the Service charge Apply on

		Thread.sleep(300);
		wm.clickbyxpath("//span[@class='k-icon k-i-cancel']");
		Thread.sleep(300);
		wm.clickbyid("btnMainAdd");
		Thread.sleep(600);


		wm.sendtextbyxvalue("//input[@aria-owns='hscdServChrgApplyOn_listbox']",Servicechargetypeon);
		Thread.sleep(200);	    
		wm.Listnegativescearios("//*[@id='hscdServChrgApplyOn_listbox']/li", "0",
				"Service charge apply type selected ",
				"Service charge apply type not selected ");
		Thread.sleep(500);
		
		
/*		Thread.sleep(300);
		wm.clickbyxpath("//span[@class='k-icon k-i-cancel']");
		Thread.sleep(300);
		wm.clickbyid("btnMainAdd");
		Thread.sleep(600);
*/
//11	Hotel service charge	Verify the inactive rules in  hotel service charge

		wm.sendtextbyxvalue("//input[@aria-owns='HhscdServChrgId_listbox']",inactivehotelservicrulename);
		Thread.sleep(300);
		wm.Listnegativesceariosnegativecaseschecking("//*[@id='HhscdServChrgId_listbox']/li", Commonindex,
				"Inactive records are not showing in service rule name field",
				"Inactive records are  showing in service rule name field");
		Thread.sleep(500);
		
		
//12	Hotel service charge	Verify the duplicate code creations

		Thread.sleep(300);
		wm.clickbyxpath("//span[@class='k-icon k-i-cancel']");
		Thread.sleep(300);
		wm.clickbyid("btnMainAdd");
		Thread.sleep(600);

		
		wm.sendtextbyxvalue("//input[@aria-owns='HhscdServChrgId_listbox']",Duplicateservicechargerulename);
		Thread.sleep(300);
		wm.Listandenter("//*[@id='HhscdServChrgId_listbox']/li", "0");
		Thread.sleep(300);
		
		wm.clickbyxpath("//span[@class='k-icon k-i-check']");
		Thread.sleep(200);
		
		wm.Mousemoveover("//input[@aria-owns='HhscdServChrgId_listbox']");
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

		return Wrappermethods.getSheet("Hotelservicechargenegative", "Hotelservicechargenegative");

	}
}