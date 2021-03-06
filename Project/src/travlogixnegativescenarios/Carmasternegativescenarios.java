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
public class Carmasternegativescenarios
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
	public void Carmasternegativescenarios(String Username, String Password, String Leftsidemenu,String Commonindex,
			String Duplicatecodee,String Name,String Filterbycode) throws Exception

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
		wm.clickbyid("pgmCMS001");
		wm.sleep();
		Thread.sleep(2000);
		wm.clickbyid("btnMainAdd");
		Thread.sleep(500);

		
		//Starte writing the negative scenarios

				wm.Clearbyxpath("//input[@aria-owns='ActiveFrom_dateview']");
				Thread.sleep(200);
				wm.clickbyxpath("//span[@class='k-icon k-i-check']");

				
		
	//1	Car Master	clicking the add button and Clicking the save button	System should display the proper validations

				wm.Mousemoveover("//input[@name='Code']");
				Thread.sleep(200);
				wm.Listnegativescearios(utility.Constant.Travelogixuitooltipvalidation, Commonindex,
						"Pass :   validations is avilable in Codee  field" + "",
						"Fail:  validations is not avilable in Codee  field " + "");
				Thread.sleep(200);
				
	//2	Car Master	Code Field	Duplicate code validations
				wm.sendtextbyxvalue("//input[@name='Code']", Duplicatecodee);
				Thread.sleep(200);
				wm.clickbyxpath("//span[@class='k-icon k-i-check']");
				Thread.sleep(200);
				wm.Mousemoveover("//input[@name='Code']");
				Thread.sleep(200);
				wm.Listnegativescearios(utility.Constant.Travelogixuitooltipvalidation, Commonindex,
						"Pass :   Duplciate validations is avilable in Codee  field" + "",
						"Fail:  Duplicate validations is not avilable in Codee  field " + "");
				Thread.sleep(200);
				
				
				
	//3	Car Master	Name field	Verify the  "name field  should not be empty " 
				wm.Mousemoveover("//input[@name='Description']");
				Thread.sleep(200);
				wm.Listnegativescearios(utility.Constant.Travelogixuitooltipvalidation, Commonindex,
						"Pass :   validation is avilable in Name  field" + "",
						"Fail:  validations is not avilable in Name  field " + "");
				Thread.sleep(200);
				
				
				
	//4	Car Master	Verhicle type field	Verify the UI validations  
	//[ without selecting the value clickign the save button ]
				wm.Mousemoveover("//input[@aria-owns='CarVehicleType_listbox']");
				Thread.sleep(200);
				wm.Listnegativescearios(utility.Constant.Travelogixuitooltipvalidation, Commonindex,
						"Pass :   validation is avilable in Vehicle type  field" + "",
						"Fail:  validations is not avilable in Vehicle type  field " + "");
				Thread.sleep(200);
				

	//5	Car Master	From date	Verify the from date validations
				wm.Mousemoveover("//input[@aria-owns='ActiveFrom_dateview']");
				Thread.sleep(200);
				wm.Listnegativescearios(utility.Constant.Travelogixuitooltipvalidation, Commonindex,
						"Pass :   validation is avilable in Active from Date  field" + "",
						"Fail:  validations is not avilable in  Active from Date  field " + "");
				Thread.sleep(200);
				

				
	
	//6	Car Master	status field	Verify the Status field validions  selected as select 
				
				wm.clickbyxpath("//span[@aria-owns='Status_listbox']");
				Thread.sleep(200);
						wm.Listnegativescearios("//*[@id='Status_listbox']/li", Commonindex,
								"Pass :   Active status selectedsuccessfully" + "",
								"Fail:  Active status not selectedsuccessfully " + "");
						
		//clickig tecnacelbutton

						wm.clickbyxpath("//span[@class='k-icon k-i-cancel']");
						
	//8	Car Master	Audit log	Verify thye Audit log popup open is not ?


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
						
//9	Car Master	Filter by data	Verify the filter functionality


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
						
//7	Car Master	Edit ->Chnaged from active to inactive status 	After inactive data shoul not be displayed
		
		wm.sleep();

	}

	@AfterMethod
	public void close()

	{
		wm.close();

	}

	@DataProvider(name = "dp")
	public Object[][] dp() throws IOException {

		return Wrappermethods.getSheet("Carmasternegativescenarios", "Carmasternegativescenarios");

	}
}