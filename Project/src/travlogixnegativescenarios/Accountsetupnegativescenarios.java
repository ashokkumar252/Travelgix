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
public class Accountsetupnegativescenarios
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
	public void Accountsetupnegativescenarios(String Username, String Password, String Leftsidemenu,String branchNamelistbox,
			String branchNamelistboxindex,String productName,String productNameindex,String transName,
			String transNameindex,String VoucherstatusName,String VoucherstatusNameindex,
			String DefaultBankName,String DefaultBankNameindex,String PaybackExpenseGlName,String PaybackExpenseGlNameindex,
			String chargeName,String chargeNameindex,String ChargeGlCode,String ChargeGlCodeindexx
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

		// ====================Creating agentincentives as negative scenarios

		// screnn===========================================================
		wm.sendtextbyid("input-items", Leftsidemenu);
		Thread.sleep(500);
		wm.clickbyid("modTRS001");
		Thread.sleep(500);
		wm.clickbyid("pgmACS001");
		Thread.sleep(2000);

		// 1.Agent incentive Clicking the save button without changes

		wm.clickbyid("btnMainSave");
		Thread.sleep(900);

		wm.Verifythealertpopupmessagesusincontains("//span[@id='diaWarningMessage']", "Changes not be found.",
				"when clicking save button without changes , System showing validation messages correctly ",
				"when clicking save button without changes ,  System showing validation messages not correctly ");
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

//		3	Account setup	Verify the UI field validations including Date validations

		wm.clickbyid("btnMainAdd");
		Thread.sleep(500);
		
		wm.clickbyxpath("//span[@class='k-icon k-i-check']");
		Thread.sleep(300);
		
		// BranchName input
		
		wm.Mousemoveover("//input[@name='branchName_input']");
		Thread.sleep(500);
		wm.Listnegativescearios(utility.Constant.Travelogixuitooltipvalidation, "0",
				"Pass :  validations is avilable in branchName_input  field" + "",
				"Fail:  validations is not avilable in branchName_input field" + "");
		Thread.sleep(200);
		
		//productname 
		wm.Mousemoveover("//input[@name='productName_input']");
		Thread.sleep(500);
		wm.Listnegativescearios(utility.Constant.Travelogixuitooltipvalidation, "0",
				"Pass :  validations is avilable in productName_input  field" + "",
				"Fail:  validations is not avilable in productName_input field" + "");
		Thread.sleep(200);
		
		//servicetypee
		wm.Mousemoveover("//input[@name='transName_input']");
		Thread.sleep(500);
		wm.Listnegativescearios(utility.Constant.Travelogixuitooltipvalidation, "0",
				"Pass :  validations is avilable in transName_input  field" + "",
				"Fail:  validations is not avilable in transName_input field" + "");
		Thread.sleep(200);
		
		//vouchersttaus
		wm.Mousemoveover("//input[@name='VoucherstatusName_input']");
		Thread.sleep(500);
		wm.Listnegativescearios(utility.Constant.Travelogixuitooltipvalidation, "0",
				"Pass :  validations is avilable in VoucherstatusName_input  field" + "",
				"Fail:  validations is not avilable in VoucherstatusName_input field" + "");
		Thread.sleep(200);
		
		wm.Listandenter("//span[@class='k-icon k-i-arrow-60-down']", "5");
		Thread.sleep(500);
	//defaultcollections
		wm.Mousemoveover("//input[@name='DefaultBankName_input']");
		Thread.sleep(500);
		wm.Listnegativescearios(utility.Constant.Travelogixuitooltipvalidation, "0",
				"Pass :  validations is avilable in DefaultBankName_input  field" + "",
				"Fail:  validations is not avilable in DefaultBankName_input field" + "");
		Thread.sleep(200);
		
		//PaybackExpenseGlName_input
		wm.Listandenter("//input[@name='PaybackExpenseGlName_input']", "0");
		Thread.sleep(200);
		
		
		wm.Mousemoveover("//input[@name='PaybackExpenseGlName_input']");
		Thread.sleep(500);
		wm.Listnegativescearios(utility.Constant.Travelogixuitooltipvalidation, "0",
				"Pass :  validations is avilable in PaybackExpenseGlName_input  field" + "",
				"Fail:  validations is not avilable in PaybackExpenseGlName_input field" + "");
		Thread.sleep(200);
		
		
		wm.clickbyid("btnMainClear");
		

		//wm.clickbyxpath(" //span[@class='k-icon k-i-cancel']");
		Thread.sleep(900);
	
		wm.clickbyxpath("//span[@class='k-icon k-i-add']");
		Thread.sleep(900);
		wm.Verifythealertpopupmessagesusincontains("//span[@id='diaWarningMessage']", 
				"Please select any one row",
				"System showing validaion message correctly when without selected the branch , try to add charge code",
				"System not showing validaion message correctly when without selected the branch , try to add charge code");
		Thread.sleep(900);
		wm.Listandenterquick("//span[contains(text(),'OK')]", "0");
		wm.Listandenterquick("//span[contains(text(),'OK')]", "1");
		wm.Listandenterquick("//span[contains(text(),'OK')]", "2");
		wm.Listandenterquick("//span[contains(text(),'OK')]", "3");

	Thread.sleep(600);

		
		wm.clickbyid("btnMainAdd");
		Thread.sleep(500);

		
//5	Account setup	Newly created branch name

		wm.sendtextbyxvalue("//input[@aria-owns='branchName_listbox']", branchNamelistbox);
		Thread.sleep(200);
		wm.Listnegativescearios("//*[@id='branchName_listbox']/li", branchNamelistboxindex,
				"Pass :   Newly created value reflected in branchNamelistbox field " + "",
				"Fail:   Newly created value not reflected in branchNamelistbox field  " + "");
		Thread.sleep(200);

		//nneed to rite
//6	Account setup	Newly created product name

		wm.sendtextbyxvalue("//input[@aria-owns='productName_listbox']", productName);
		Thread.sleep(200);
		wm.Listnegativescearios("//*[@id='productName_listbox']/li", productNameindex,
				"Pass :   Newly created value reflected in productName field " + "",
				"Fail:   Newly created value not reflected in productName field  " + "");
		Thread.sleep(200);

		
//7	Account setup	Newl created service type

		wm.sendtextbyxvalue("//input[@aria-owns='transName_listbox']", transName);
		Thread.sleep(200);
		wm.Listnegativescearios("//*[@id='transName_listbox']/li", transNameindex,
				"Pass :   Newly created value reflected in transName_listbox field " + "",
				"Fail:   Newly created value not reflected in transName_listbox field  " + "");
		Thread.sleep(200);

		
//8	Account setup	Newly created voucher status
		

		wm.sendtextbyxvalue("//input[@aria-owns='VoucherstatusName_listbox']",VoucherstatusName);
		Thread.sleep(200);
		wm.Listnegativescearios("//*[@id='VoucherstatusName_listbox']/li", VoucherstatusNameindex,
				"Pass :   Newly created value reflected in VoucherstatusName field " + "",
				"Fail:   Newly created value not reflected in VoucherstatusName field  " + "");
		Thread.sleep(200);

//9	Account setup	Newly created  default collections

		wm.sendtextbyxvalue("//input[@aria-owns='DefaultBankName_listbox']", DefaultBankName);
		Thread.sleep(200);
		wm.Listnegativescearios("//*[@id='DefaultBankName_listbox']/li", DefaultBankNameindex,
				"Pass :   Newly created value reflected in DefaultBankName field " + "",
				"Fail:   Newly created value not reflected in DefaultBankName field  " + "");
		Thread.sleep(200);
		
//10	Account setup	Newly created playbackaccount


		wm.sendtextbyxvalue("//input[@aria-owns='PaybackExpenseGlName_listbox']", PaybackExpenseGlName);
		Thread.sleep(200);
		wm.Listnegativescearios("//*[@id='PaybackExpenseGlName_listbox']/li", PaybackExpenseGlNameindex,
				"Pass :   Newly created value reflected in PaybackExpenseGlName field " + "",
				"Fail:   Newly created value not reflected in PaybackExpenseGlName field  " + "");
		Thread.sleep(200);

		//wm.clickbyxpath("//span[@class='k-icon k-i-cancel']");
		Thread.sleep(500);
		
		wm.clickbyid("btnMainClear");
		Thread.sleep(2000);
		
     wm.Listandenter("//*[@id='AccountSetupgrid']/div[3]/table/tbody/tr/td[3]", "1");
     
		Thread.sleep(500);

		
		wm.clickbyxpath("//span[@class='k-icon k-i-add']");
		Thread.sleep(900);
		wm.clickbyxpath("//span[@class='k-icon k-i-check']");
		Thread.sleep(500);
		
	
//11	Account setup	Newly created  charge code

		wm.sendtextbyxvalue("//input[@aria-owns='chargeName_listbox']", chargeName);
		Thread.sleep(200);
		wm.Listnegativescearios("//*[@id='chargeName_listbox']/li", chargeNameindex,
				"Pass :   Newly created value reflected in chargeName_input field " + "",
				"Fail:   Newly created value not reflected in chargeName_input field  " + "");
		Thread.sleep(200);
		
//12	Account setup	Newly created  charge GL Account
		

		wm.sendtextbyxvalue("//input[@aria-owns='ChargeGlCode_listbox']", ChargeGlCode);
		Thread.sleep(200);
		wm.Listnegativescearios("//*[@id='ChargeGlCode_listbox']/li", ChargeGlCodeindexx,
				"Pass :   Newly created value reflected in ChargeGlCode field " + "",
				"Fail:   Newly created value not reflected in ChargeGlCode field  " + "");
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

		return Wrappermethods.getSheet("Accountsetupnegativescenarios", "Accountsetupnegativescenarios");

	}
}