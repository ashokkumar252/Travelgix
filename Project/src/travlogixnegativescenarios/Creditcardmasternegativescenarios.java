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
public class Creditcardmasternegativescenarios {

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
	public void Creditcardmasternegativescenarios(String Username, String Password, String Leftsidemenu, String Commonindex,
			String Duplicatecodee, String CcServiceFeePercentage, String Aplink, String Filterbycode) throws Exception

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
		wm.clickbyid("pgmCCD001");
		wm.sleep();
		Thread.sleep(2000);
		wm.clickbyid("btnMainAdd");
		Thread.sleep(500);

		// start writing negative scenrios

		wm.Clearbyxpath("//input[@aria-owns='ActiveFrom_dateview']");
		Thread.sleep(500);
		wm.clickbyxpath("//span[@class='k-icon k-i-check']");
		Thread.sleep(200);

		// 1 CreditCard Master in home page clicking the save button System
		// should display the proper validations

		// 4 CreditCard Master Verify the duplciate code System should ot
		// allowed the duplicate codes

		// 1 Car Master clicking the add button and Clicking the save button
		// System should display the proper validations

		wm.Mousemoveover("//input[@name='Code']");
		Thread.sleep(200);
		wm.Listnegativescearios(utility.Constant.Travelogixuitooltipvalidation, Commonindex,
				"Pass :   validations is avilable in Codee  field" + "",
				"Fail:  validations is not avilable in Codee  field " + "");
		Thread.sleep(200);

		// 2 Car Master Code Field Duplicate code validations
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

		// 5 CreditCard Master Verify the name field validations Field should
		// not be empty
		wm.Mousemoveover("//input[@name='Description']");
		Thread.sleep(200);
		wm.Listnegativescearios(utility.Constant.Travelogixuitooltipvalidation, Commonindex,
				"Pass :   validation is avilable in Name  field" + "",
				"Fail:  validations is not avilable in Name  field " + "");
		Thread.sleep(200);

		// 6 CreditCard Master Verify the Credit card status credit card status
		// should not be empty
		wm.Mousemoveover("//input[@aria-owns='CcStatus_listbox']");
		Thread.sleep(200);
		wm.Listnegativescearios(utility.Constant.Travelogixuitooltipvalidation, Commonindex,
				"Pass :   validation is avilable in Credit card status	  field" + "",
				"Fail:  validations is not avilable in Credit card status	  field " + "");
		Thread.sleep(200);

		// 7 CreditCard Master Verify the AR link AR link should not be empty
		wm.Mousemoveover("//input[@aria-owns='CcAccountLink_listbox']");
		Thread.sleep(200);
		wm.Listnegativescearios(utility.Constant.Travelogixuitooltipvalidation, Commonindex,
				"Pass :   validation is avilable in AR Link field" + "",
				"Fail:  validations is not avilable in  AR Link  field " + "");
		Thread.sleep(200);

		// 8 CreditCard Master Verify the OWN lodge status Own lodge status
		// should not empty
		wm.Mousemoveover("//span[@aria-owns='CcOwnLodgeCardStatus_listbox']");
		Thread.sleep(200);
		wm.Listnegativescearios(utility.Constant.Travelogixuitooltipvalidation, Commonindex,
				"Pass :   validation is avilable in OWN LODGE field" + "",
				"Fail:  validations is not avilable in  OWN LODGE  field " + "");
		Thread.sleep(200);

		// 9 CreditCard Master Active from date validations Active from
		// validations should not be empty

		wm.Mousemoveover("//input[@aria-owns='ActiveFrom_dateview']");
		Thread.sleep(200);
		wm.Listnegativescearios(utility.Constant.Travelogixuitooltipvalidation, Commonindex,
				"Pass :   validation is avilable in Active from date field" + "",
				"Fail:  validations is not avilable in  Active from date   field " + "");
		Thread.sleep(200);

		// 10 CreditCard Master Status field validations Status should not be
		// empty

		wm.clickbyxpath("//span[@aria-owns='Status_listbox']");
		Thread.sleep(200);
		wm.Listnegativescearios("//*[@id='Status_listbox']/li", Commonindex,
				"Pass :   User able to select the Status field" + "",
				"Fail:  User not able to select the Status field " + "");
		Thread.sleep(200);

		// 12 CreditCard Master Verify the Service fee percentage System not
		// allowed more than 100 %

		wm.sendtextbycssselecotrwithoutclear("#CcServiceFeePercentage", "" + CcServiceFeePercentage);
		Thread.sleep(200);
		wm.clickbyxpath("//span[@class='k-icon k-i-check']");
		Thread.sleep(200);
		wm.Mousemoveover("//input[@name='CcServiceFeePercentage']");
		Thread.sleep(200);
		wm.Listnegativescearios(utility.Constant.Travelogixuitooltipvalidation, Commonindex,
				"Pass :   validation is avilable if percentage typed more than 100 %" + "",
				"Fail:  validation is not avilable if percentage typed more than 100 %" + "");
		Thread.sleep(200);

		// 13 CreditCard Master AP link Verify the newly created Ap link is
		// reflected or not

		wm.sendtextbyxvalue("//input[@aria-owns='CcApLink_listbox']", Aplink);
		// wm.clickbyxpath("//input[@aria-owns='Status_listbox']");
		Thread.sleep(200);
		wm.Listnegativescearios("//*[@id='CcApLink_listbox']/li", Commonindex,
				"Pass :   Give Aplink selected in the Aplink drop down " + "",
				"Fail:  Give Aplink is not selected in the Aplink drop down  " + "");
		Thread.sleep(200);

		// 2 CreditCard Master Filter functionality Verify the filter
		// functionality its working .

		wm.clickbyxpath("//span[@class='k-icon k-i-cancel']");

		Thread.sleep(200);
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

		// 3 CreditCard Master Verify the Auidt log popup System should display
		// the Audit logpopup

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

		// 11 CreditCard Master Edit ->Chnaged from active to inactive status
		// After inactive data shoul not be displayed

		wm.sleep();

	}

	@AfterMethod
	public void close()

	{
		wm.close();

	}

	@DataProvider(name = "dp")
	public Object[][] dp() throws IOException {

		return Wrappermethods.getSheet("Creditcardmasternegativescenarios", "Creditcardnegativescenarios");

	}
}