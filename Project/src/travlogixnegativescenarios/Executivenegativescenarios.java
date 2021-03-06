//WASTA login screen
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
public class Executivenegativescenarios {

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
	public void Executivenegativescenarios(String Username, String Password, String Leftsidemenu, String Newlycreatedusermaster,
			String Newlycreatedusermasterindex, String Newlycreatedbranch, String Newlycreatedbranchindex,
			String Newlycreatenationality, String Newlycreatenationalityindex, String Newlycreateddesigination,
			String Newlycreateddesiginationindex, String Discountmenthod, String Discountmenthodindex,
			String Discountvalue, String Commonindex) throws Exception

	{

		Thread.sleep(2000);

		// wm.sendtextbyid("", );
		wm.sendtextbyid("LoginCode", Username);
		wm.stab("LoginCode");
		Thread.sleep(200);
		wm.sendtextbyid("Password", Password);
		Thread.sleep(300);
		wm.clickbyxpath("//input[@value='Login']");
		wm.sleep();

		wm.sendtextbyid("input-items", Leftsidemenu);
		Thread.sleep(500);

		wm.clickbyid("modMAS001");
		Thread.sleep(900);
		wm.clickbyid("pgmEXT001");
		Thread.sleep(900);

		wm.clickbyid("btnMainAdd");
		Thread.sleep(500);

		// 1 Executive Master User master User master newly created data
		// reflected in the executive master

		wm.sendtextbyxvalue("//input[@aria-owns='UserCode_listbox']", Newlycreatedusermaster);
		Thread.sleep(200);
		wm.Listnegativescearios("//*[@id='UserCode_listbox']/li", Newlycreatedusermasterindex,
				"Pass :  Newlycreatedusermaster is avilable in Newlycreatedusermaster field " + "",
				"Fail:   Newlycreatedusermaster is not avilable in Newlycreatedusermaster field " + "");
		Thread.sleep(300);

		// 2 Executive Master Verify the branch field Newly created branch
		// reflcted in the allocated bracnh field
		wm.sendtextbyxvalue("//input[@aria-owns='ExecAllocatedBranch_listbox']", Newlycreatedbranch);
		Thread.sleep(200);
		wm.Listnegativescearios("//*[@id='ExecAllocatedBranch_listbox']/li", Newlycreatedbranchindex,
				"Pass :  Newlycreatedusermaster is avilable in Newlycreatedusermaster field " + "",
				"Fail:   Newlycreatedusermaster is not avilable in Newlycreatedusermaster field " + "");
		Thread.sleep(300);

		// 6 Executive Master Verify the allocated locations Verify the
		// allocated locaion [ same as branch ]

		wm.sendtextbyxvalue("//input[@aria-owns='ExecAllowedLocations_listbox']", Newlycreatedbranch);
		Thread.sleep(200);
		wm.Listnegativescearios("//*[@id='ExecAllowedLocations_listbox']/li", Newlycreatedbranchindex,
				"Pass :  Allocated branch is also avilable in Allocated Location Field  " + "",
				"Fail:   Allocated branch is not avilable in Allocated Location Field  " + "");
		Thread.sleep(300);

		// 3 Executive Master Verify the nationaltiy field new created
		// nationality reflected or not
		wm.sendtextbyxvalue("//input[@aria-owns='ExecNationality_listbox']", Newlycreatenationality);
		Thread.sleep(200);
		wm.Listnegativescearios("//*[@id='ExecNationality_listbox']/li", Newlycreatenationalityindex,
				"Pass :  Newlycreatenationality is avilable in nationality  field " + "",
				"Fail:   Newlycreatenationality is not avilable in nationality  field " + "");
		Thread.sleep(300);

		// 4 Executive Master Verify the desingination new created Desigination
		// reflected or not
		wm.sendtextbyxvalue("//input[@aria-owns='ExecDesignation_listbox']", Newlycreateddesigination);
		Thread.sleep(200);
		wm.Listnegativescearios("//*[@id='ExecDesignation_listbox']/li", Newlycreateddesiginationindex,
				"Pass :  Newlycreateddesigination is avilable in desigination  field " + "",
				"Fail:   Newlycreateddesigination is not avilable in desigination field " + "");
		Thread.sleep(300);

		wm.clickbyxpath("//span[@class='k-icon k-i-cancel']");
		Thread.sleep(300);

		// 5 Executive Master Verify the discount field validations Discount
		// filed validaion using percentage [200%]
		wm.clickbyid("btnMainAdd");

		Thread.sleep(200);

		wm.sendtextbyxvalue("//input[@aria-owns='ExecDiscMethod_listbox']", Discountmenthod);
		Thread.sleep(200);
		wm.Listnegativescearios("//*[@id='ExecDiscMethod_listbox']/li", Discountmenthodindex,
				"Pass :  Selected discount method as percentage  " + "",
				"Fail:   User not able to Selected the method as percentage " + "");
		Thread.sleep(300);

		wm.sendtextbyxvalue("//input[@name='ExecAllowedDiscValue']", "" + Discountvalue);
		Thread.sleep(100);

		wm.Mousemoveover("//input[@name='ExecAllowedDiscValue']");
		Thread.sleep(200);

		wm.Listnegativescearios("//div[@class='k-tooltip-content']", Commonindex,
				"Pass :  Discount validations is avilable Disocunt  field" + "",
				"Fail:  Discount validations is not avilable Disocunt  field" + "");
		Thread.sleep(300);

		wm.clickbyxpath("//span[@class='k-icon k-i-cancel']");
		Thread.sleep(300);

		// 7 Executive Master Overall UI validations Clicking save button
		// without enter the mandatory details

		wm.clickbyid("btnMainAdd");
		Thread.sleep(300);
		wm.Clearbyxpath("//input[@aria-owns='ActiveFrom_dateview']");
		Thread.sleep(100);

		wm.clickbyxpath("//span[@class='k-icon k-i-check']");
		Thread.sleep(300);
		wm.clickbyxpath("//*[@id='SAAirSegmentDetailModelId']/div/div[3]/label"); // For
																					// close
																					// the
																					// drop
																					// downn
		Thread.sleep(300);

		// user
		wm.Mousemoveover("//input[@aria-owns='UserCode_listbox']");
		Thread.sleep(300);
		wm.Listnegativescearios(utility.Constant.Travelogixuitooltipvalidation, Commonindex,
				"Pass :  Validation is avilable in the user field" + "",
				"Fail:   Validation is not avilable in the user field" + "");
		Thread.sleep(300);

		// Gender
		wm.Mousemoveover("//span[@aria-owns='ExecGender_listbox']");
		Thread.sleep(300);
		wm.Listnegativescearios(utility.Constant.Travelogixuitooltipvalidation, Commonindex,
				"Pass :  Validation is avilable in the Gender  field" + "",
				"Fail:   Validation is not avilable in the Gender field" + "");
		Thread.sleep(300);

		// Accesslevel
		wm.Mousemoveover("//input[@name='ExecAccessLevel']");
		Thread.sleep(300);
		wm.Listnegativescearios(utility.Constant.Travelogixuitooltipvalidation, Commonindex,
				"Pass :  Validation is avilable in the Accesslevel field" + "",
				"Fail:   Validation is not avilable in the Accesslevel field" + "");
		Thread.sleep(300);

		// Alocatedbranch
		wm.Mousemoveover("//input[@aria-owns='ExecAllocatedBranch_listbox']");
		Thread.sleep(300);
		wm.Listnegativescearios(utility.Constant.Travelogixuitooltipvalidation, Commonindex,
				"Pass :  Validation is avilable in the Allocated branch field" + "",
				"Fail:   Validation is not avilable in the Allocated branch field" + "");
		Thread.sleep(300);

		// Discountmethod
		wm.Mousemoveover("//input[@aria-owns='ExecDiscMethod_listbox']");
		Thread.sleep(300);
		wm.Listnegativescearios(utility.Constant.Travelogixuitooltipvalidation, Commonindex,
				"Pass :  Validation is avilable in the Discountmethod field" + "",
				"Fail:   Validation is not avilable in the Discountmethod field" + "");
		Thread.sleep(300);

		// Discountallowed
		wm.Mousemoveover("//input[@name='ExecAllowedDiscValue']");
		Thread.sleep(300);
		wm.Listnegativescearios(utility.Constant.Travelogixuitooltipvalidation, Commonindex,
				"Pass :  Validation is avilable in the Discountallowed field" + "",
				"Fail:   Validation is not avilable in the Discountallowed field" + "");
		Thread.sleep(300);

		// Fromdatee
		wm.Mousemoveover("//input[@aria-owns='ActiveFrom_dateview']");
		Thread.sleep(300);
		wm.Listnegativescearios(utility.Constant.Travelogixuitooltipvalidation, Commonindex,
				"Pass :  Validation is avilable in the Fromdatee field" + "",
				"Fail:   Validation is not avilable in the Fromdatee field" + "");
		Thread.sleep(300);

		// Allocatedlocations
		wm.Mousemoveover("//input[@aria-owns='ExecAllowedLocations_listbox']");
		Thread.sleep(300);
		wm.Listnegativescearios(utility.Constant.Travelogixuitooltipvalidation, Commonindex,
				"Pass :  Validation is avilable in the Allocatedlocations field" + "",
				"Fail:   Validation is not avilable in the Allocatedlocations field" + "");
		Thread.sleep(300);

		wm.sleep();

	}

	@AfterMethod
	public void close()

	{
		wm.close();

	}

	@DataProvider(name = "dp")
	public Object[][] dp() throws IOException {

		return Wrappermethods.getSheet("Executivenegativescenarios", "Executivenegativescenarios");

	}
}