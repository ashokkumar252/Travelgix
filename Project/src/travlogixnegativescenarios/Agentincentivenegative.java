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
public class Agentincentivenegative {

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
	public void Agentincentivenegative(String Username, String Password, String Leftsidemenu, String Commonindex, String Code,
			String Customername, String Customernameindex, String Agentinentive, String Agentinentiveindex,
			String AtaiAccountLinklistbox, String AtaiAccountLinklistboxidex, String AtaimPercentage) throws Exception

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
		wm.clickbyid("pgmAI001");
		Thread.sleep(2000);

		// 1.Agent incentive Clicking the save button without changes

		wm.clickbyid("btnMainSave");
		Thread.sleep(900);

		wm.Verifythealertpopupmessagesusincontains("//span[@id='diaWarningMessage']", "Changes not be found.",
				"Agent Incentive Changes not be found. , System showing validation messages correctly ",
				"System save the record without changes ,  System showing validation messages not correctly ");
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

		// 2 Agent incentive Verify the UI field validations

		wm.clickbyid("btnMainAdd");
		Thread.sleep(200);
		wm.Clearbyxpath("//input[@aria-owns='AtaiEffectiveDate_dateview']");
		Thread.sleep(50);
		wm.Clearbyxpath("//input[@aria-owns='AStatus_listbox']");
		Thread.sleep(50);
		wm.Clearbyxpath("//input[@aria-owns='AtaiValueType_listbox']");
		Thread.sleep(50);
		wm.clickbyxpath("//span[@class='k-icon k-i-check']");
		Thread.sleep(200);

		// 3 Agent incentive Verify the UI field validations All mandatory
		// fields

		// Code Field
		wm.Mousemoveover("//input[@name='Code']");
		Thread.sleep(100);
		wm.Listnegativescearios(utility.Constant.Travelogixuitooltipvalidation, Commonindex,
				"Pass :  validations is avilable Code  field" + "",
				"Fail:  validations is not avilable Code field" + "");
		Thread.sleep(200);

		// agentname
		wm.Mousemoveover("//input[@name='Description']");
		Thread.sleep(100);
		wm.Listnegativescearios(utility.Constant.Travelogixuitooltipvalidation, Commonindex,
				"Pass :  validations is avilable in agent name  field" + "",
				"Fail:  validations is not avilable in agent name field" + "");
		Thread.sleep(200);

		// address
		wm.Mousemoveover("//input[@name='AtaiAddress']");
		Thread.sleep(100);
		wm.Listnegativescearios(utility.Constant.Travelogixuitooltipvalidation, Commonindex,
				"Pass :  validations is AtaiAddress field" + "", "Fail:  validations is not AtaiAddress field" + "");
		Thread.sleep(200);

		// Agentincentive typee
		wm.Mousemoveover("//input[@name='AtaiType_input']");
		Thread.sleep(100);
		wm.Listnegativescearios(utility.Constant.Travelogixuitooltipvalidation, Commonindex,
				"Pass :  validations is avilable AtaiType_input  Agent incentive type  field" + "",
				"Fail:  validations is not avilable AtaiType_input Agent incentive type   field" + "");
		Thread.sleep(200);

		// date validationss
		wm.Mousemoveover("//input[@name='AtaiEffectiveDate']");
		Thread.sleep(200);
		wm.Listnegativescearios(utility.Constant.Travelogixuitooltipvalidation, Commonindex,
				"Pass :  validations is avilable AtaiEffectiveDate  field" + "",
				"Fail:  validations is not avilable AtaiEffectiveDate field" + "");
		Thread.sleep(600);

		// valuetypee
		wm.Mousemoveover("//input[@name='AtaiValueType_input']");
		Thread.sleep(100);
		wm.Listnegativescearios(utility.Constant.Travelogixuitooltipvalidation, Commonindex,
				"Pass :  validations is avilable AtaiValueType_input  field" + "",
				"Fail:  validations is not avilable AtaiValueType_input field" + "");
		Thread.sleep(200);

		// Duplciate code field verificcations
		wm.sendtextbycssselecotrwithoutclear("#Code", Code);
		Thread.sleep(100);
		wm.clickbyxpath("//span[@class='k-icon k-i-check']");
		Thread.sleep(200);
		wm.Mousemoveover("//input[@name='Code']");
		Thread.sleep(100);
		wm.Listnegativescearios(utility.Constant.Travelogixuitooltipvalidation, Commonindex,
				"Pass :  Duplicate validation is avilable in the field" + "",
				"Fail:  Duplicate validation is not avilable in the field" + "");
		Thread.sleep(200);

		wm.clickbyxpath(" //span[@class='k-icon k-i-cancel']");
		Thread.sleep(900);
		wm.clickbyid("btnMainAdd");
		Thread.sleep(900);

		// ==================================================================================

		// 4 Agent incentive Newly Created customer newly created customer
		// should reflected in the customer field

		wm.sendtextbyxvalue("//input[@aria-owns='AtaiCmsKey_listbox']", Customername);
		Thread.sleep(200);
		wm.Listnegativescearios("//*[@id='AtaiCmsKey_listbox']/li", Customernameindex,
				"Pass :   Newly created value reflected in Customername field " + "",
				"Fail:   Newly created value not reflected in Customername field  " + "");
		Thread.sleep(200);

		// 5 Agent incentive Newly created agent incentive type reflected in
		// Agent incentive type field
		wm.sendtextbyxvalue("//input[@aria-owns='AtaiType_listbox']", Agentinentive);
		Thread.sleep(200);
		wm.Listnegativescearios("//*[@id='AtaiType_listbox']/li", Agentinentiveindex,
				"Pass :   Newly created value reflected in Agentinentive field " + "",
				"Fail:   Newly created value not reflected in Agentinentive field  " + "");
		Thread.sleep(200);

		// 6 Agent incentive Newly created account link reflected in account
		// link field
		wm.sendtextbyxvalue("//input[@aria-owns='AtaiAccountLink_listbox']", AtaiAccountLinklistbox);
		Thread.sleep(200);
		wm.Listnegativescearios("//*[@id='AtaiAccountLink_listbox']/li", AtaiAccountLinklistboxidex,
				"Pass :   Newly created value reflected in AtaiAccountLink_listbox field " + "",
				"Fail:   Newly created value not reflected in AtaiAccountLink_listbox field  " + "");
		Thread.sleep(200);

		// 8 Agent incentive Select as percentage and enter the amount more than
		// 100 % and verify the validations

		// Precntage validations
		wm.Clearbyxpath("//input[@aria-owns='AStatus_listbox']");
		Thread.sleep(200);

		wm.clickbyxpath("//span[@aria-controls='AtaiValueType_listbox']");
		Thread.sleep(100);
		wm.Listandenter("//*[@id='AtaiValueType_listbox']/li", "1");
		Thread.sleep(200);
		wm.sendtextbycssselecotrwithoutclear("#AtaimPercentage", AtaimPercentage);
		Thread.sleep(200);
		wm.clickbyxpath("//span[@class='k-icon k-i-check']");
		Thread.sleep(200);
		wm.Mousemoveover("//input[@name='AtaimPercentage']");
		Thread.sleep(100);
		wm.Listnegativescearios(utility.Constant.Travelogixuitooltipvalidation, Commonindex,
				"Pass :  validations is avilable in percentage field when enter more than 100" + "",
				"Fail:  validations is not avilable in percentage field when enter more than 100" + "");
		Thread.sleep(200);

		// agent status
		wm.Mousemoveover("//input[@name='AStatus_input']");
		Thread.sleep(500);
		wm.Listnegativescearios(utility.Constant.Travelogixuitooltipvalidation, "0",
				"Pass :  validations is avilable in AStatus_input  field" + "",
				"Fail:  validations is not avilable in AStatus_input field" + "");
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

		return Wrappermethods.getSheet("Agentincentivenegative", "Agentincentivenegative");

	}
}