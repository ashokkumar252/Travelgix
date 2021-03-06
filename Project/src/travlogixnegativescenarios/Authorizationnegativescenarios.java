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
public class Authorizationnegativescenarios 
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
	public void Authorizationnegativescenarios(String Username, String Password, String Leftsidemenu,
			String Commonindex,String Airline,String Airlineindex,String Tickectstatus,
			String Tickectstatusndex,String Usedstatus,String Usedstatusindexx,String Code) throws Exception

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

		// ====================Creating agentincentives as negative scenarios

		// screnn===========================================================
		wm.sendtextbyid("input-items", Leftsidemenu);
		Thread.sleep(500);
		wm.clickbyid("modTRS001");
		Thread.sleep(500);
		wm.clickbyid("pgmAUZ");
		Thread.sleep(2000);

		// 1.Agent incentive Clicking the save button without changes

		wm.clickbyid("btnMainSave");
		Thread.sleep(900);

		wm.Verifythealertpopupmessagesusincontains("//span[@id='diaWarningMessage']", 
				"Changes",
				"Authorization : System showing validation messages correctly ",
				"Authorization :  System showing validation messages not correctly ");
		Thread.sleep(500);

		wm.Listandenterquick("//span[contains(text(),'OK')]", "0");
		wm.Listandenterquick("//span[contains(text(),'OK')]", "1");
		wm.Listandenterquick("//span[contains(text(),'OK')]", "2");
		wm.Listandenterquick("//span[contains(text(),'OK')]", "3");

		// 2 Branch Master Bramch Group : Clicking the Add button and click the
		// grid level save button Proper validation should be displayed

		Thread.sleep(600);

		// 2 Agent incentive Verify the Audit log Popup opening

		wm.clickbyid("btnAuditLog");
		Thread.sleep(300);
		wm.Verifythealertpopupmessagesusincontains("//span[@id='AuditLog_wnd_title']", "Audit Log",
				"When clicking the audit log icon system displays the auditlog popup",
				"When clicking the audit log icon system displays the auditlog popup");
		Thread.sleep(200);

		wm.Listandenterquick("//span[@class='k-icon k-i-close']", "0");
		wm.Listandenterquick("//span[@class='k-icon k-i-close']", "1");
		wm.Listandenterquick("//span[@class='k-icon k-i-close']", "2");
		wm.Listandenterquick("//span[@class='k-icon k-i-close']", "3");
		Thread.sleep(600);

		
	//3	Authorization	Verify the UI field validations	All mandatory fields

		

		wm.clickbyid("btnMainAdd");
		Thread.sleep(200);
		wm.clickbyxpath("//span[@class='k-icon k-i-check']");
		Thread.sleep(200);
		
		// Code Field
				wm.Mousemoveover("//input[@name='Code']");
				Thread.sleep(100);
				wm.Listnegativescearios(utility.Constant.Travelogixuitooltipvalidation, Commonindex,
						"Pass :  validations is avilable Code  field" + "",
						"Fail:  validations is not avilable Code field" + "");
				Thread.sleep(200);

	
				// authAirlineKey_input Field
				wm.Mousemoveover("//input[@name='authAirlineKey_input']");
				Thread.sleep(100);
				wm.Listnegativescearios(utility.Constant.Travelogixuitooltipvalidation, Commonindex,
						"Pass :  validations is avilable authAirlineKey_input  field" + "",
						"Fail:  validations is not avilable authAirlineKey_input field" + "");
				Thread.sleep(200);
				
				//tickectnumbe validations
				
				wm.Mousemoveover("//input[@name='authTicketNumber']");
				Thread.sleep(100);
				wm.Listnegativescearios(utility.Constant.Travelogixuitooltipvalidation, Commonindex,
						"Pass :  validations is avilable authTicketNumber  field" + "",
						"Fail:  validations is not avilable authTicketNumber field" + "");
				Thread.sleep(200);
				
				//amont validationss
				wm.Mousemoveover("//input[@name='authAmount']");
				Thread.sleep(100);
				wm.Listnegativescearios(utility.Constant.Travelogixuitooltipvalidation, Commonindex,
						"Pass :  validations is avilable authAmount  field" + "",
						"Fail:  validations is not avilable authAmount field" + "");
				Thread.sleep(200);
				
				//usedstatus validations
				wm.Mousemoveover("//input[@name='authUsedStatus_input']");
				Thread.sleep(100);
				wm.Listnegativescearios(utility.Constant.Travelogixuitooltipvalidation, Commonindex,
						"Pass :  validations is avilable authUsedStatus_input  field" + "",
						"Fail:  validations is not avilable authUsedStatus_input field" + "");
				Thread.sleep(200);
				
	//4	Authorization	Duplicate code validations

		wm.sendtextbycssselecotrwithoutclear("#Code", Code);
		Thread.sleep(200);
		wm.clickbyxpath("//span[@class='k-icon k-i-check']");
		Thread.sleep(200);
			
		// Duplicate Code Field
		wm.Mousemoveover("//input[@name='Code']");
		Thread.sleep(100);
		wm.Listnegativescearios(utility.Constant.Travelogixuitooltipvalidation, Commonindex,
				"Pass :  Duplicate validations is avilable Code  field" + "",
				"Fail:  Duplcaite validations is not avilable Code field" + "");
		Thread.sleep(200);

	wm.clickbyxpath("//span[@class='k-icon k-i-cancel']");
    Thread.sleep(200);
	wm.clickbyid("btnMainAdd");
	Thread.sleep(200);
	wm.clickbyxpath("//span[@class='k-icon k-i-check']");
	Thread.sleep(200);
	
//		5	Authorization	Newly created airline should reflected 


	wm.sendtextbyxvalue("//input[@aria-owns='authAirlineKey_listbox']",Airline);
	Thread.sleep(200);
	wm.Listnegativescearios("//*[@id='authAirlineKey_listbox']/li", Airlineindex,
			"Pass :   Newly created value reflected in Airline field " + "",
			"Fail:   Newly created value not reflected in Airline field  " + "");
	Thread.sleep(200);

		
//	6	Authorization	Newly created tickect status  should reflected 


	wm.sendtextbyxvalue("//input[@aria-owns='authTicketStatusKey_listbox']", Tickectstatus);
	Thread.sleep(200);
	wm.Listnegativescearios("//*[@id='authTicketStatusKey_listbox']/li", Tickectstatusndex,
			"Pass :   Newly created value reflected in Tickectstatus field " + "",
			"Fail:   Newly created value not reflected in Tickectstatus field  " + "");
	Thread.sleep(200);

//	7	Authorization	Newly created Used status  should reflected 


	wm.sendtextbyxvalue("//input[@aria-owns='authUsedStatus_listbox']", Usedstatus);
	Thread.sleep(200);
	wm.Listnegativescearios("//*[@id='authUsedStatus_listbox']/li", Usedstatusindexx,
			"Pass :   Newly created value reflected in authUsedStatus_listbox field " + "",
			"Fail:   Newly created value not reflected in authUsedStatus_listbox field  " + "");
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

		return Wrappermethods.getSheet("Authorizationnegativescenarios", "Authorizationnegativescenarios");

	}
}