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
public class Taxnegativescenarios {

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
	public void Taxnegativescenarios(String Username, String Password, String Leftsidemenu, String Duplicatecode,
			String Taxcategory,String Commonindex,String Taxtypee) throws Exception

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

		// ====================Creating Branch Master negative scenarios
		// screnn===========================================================
		wm.sendtextbyid("input-items", Leftsidemenu);
		Thread.sleep(500);
		wm.clickbyid("modMAS001");
		Thread.sleep(500);
		wm.clickbyid("pgmTX001");
		wm.sleep();

		// 1 Tax Unique code validations Duplicate code should not be allowed

		wm.clickbyid("btnMainAdd");
		Thread.sleep(300);
		wm.sendtextbyxvalue("//input[@name='Code']", Duplicatecode);
		Thread.sleep(100);
		wm.clickbyxpath("//span[@class='k-icon k-i-check']");
		Thread.sleep(100);
		wm.Mousemoveover("//input[@name='Code']");
		Thread.sleep(500);
		wm.Listnegativescearios(utility.Constant.Travelogixuitooltipvalidation, Commonindex,
				"Pass :  Duplicate code validations is avilable " + "",
				"Fail:  Duplicate codee validations is not avilable " + "");
		Thread.sleep(350);

		// 2 Tax Tax category selections [no masters ] Verify the Tax categroy
		// selections

		wm.sendtextbyxvalue("//input[@aria-owns='TaxCategoryName_listbox']", Taxcategory);
		Thread.sleep(100);
		wm.Listnegativescearios("//*[@id='TaxCategoryName_listbox']/li", Commonindex,
				"Pass :  Tax catrgory is  avilable " + "", "Fail:  Tax catrgory is not avilable " + "");
		Thread.sleep(350);

		// 3 Tax Verify the tax type - newly created Reference code master data
		// reflected in the tax type field Newcly created data should
		// reflecetdin the Tax type field
		

		wm.sendtextbyxvalue("//input[@aria-owns='TaxTypeName_listbox']", Taxtypee);
		Thread.sleep(100);
		wm.Listnegativescearios("//*[@id='TaxTypeName_listbox']/li", Commonindex,
				"Pass :  Tax type is  avilable in the tax type dro downn " + "", 
				"Fail:  Tax type is  not avilable in the tax type dro downn " + "");
		Thread.sleep(350);


		// 4 Tax Date validations Verify the date validaitons
		

		wm.Clearbyxpath("//input[@name='ActiveFrom']");
		Thread.sleep(100);
		wm.clickbyxpath("//span[@class='k-icon k-i-check']");
		Thread.sleep(100);
		wm.Mousemoveover("//input[@name='ActiveFrom']");
		Thread.sleep(500);
		wm.Listnegativescearios(utility.Constant.Travelogixuitooltipvalidation, Commonindex,
				"Pass :  Date validations is avilable " + "",
				"Fail:  Date validations is not avilable " + "");
	
		Thread.sleep(800);


	}

	@AfterMethod
	public void close()

	{
		wm.close();

	}

	@DataProvider(name = "dp")
	public Object[][] dp() throws IOException {

		return Wrappermethods.getSheet("Taxnegativescenarios", "Taxnegativescenarios");

	}
}