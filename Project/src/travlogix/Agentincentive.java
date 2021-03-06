//WASTA login screen
package travlogix;
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
public class Agentincentive {

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
	public void Agentincentive(String Username, String Password, String Leftsidemenu,String Code,
			String Description,String AtaiAddress,String AtaiBankAc,String Customername,
			String Customernameindex,String Agentincetive,String Agentincetiveindex,String Agentstatus,
			String Agentstatusindex,String AtaiEffectiveDate1,String AtaiEffectiveDate2,
			String AtaiEffectiveDate3,String Accountlink,String Accountlinkindexx,String Valuetype,
			String Valuetypeindex,String AtaimPercentage) throws Exception

	{

		Thread.sleep(2000);

		// wm.sendtextbyid("", );
		wm.sendtextbyid("LoginCode", Username);
		Thread.sleep(200);
		wm.stab("LoginCode");
		wm.sendtextbyid("Password", Password);
		Thread.sleep(200);
		wm.clickbyxpath("//input[@value='Login']");
        Thread.sleep(900);

		// screnn===========================================================
		wm.sendtextbyid("input-items", Leftsidemenu);
		Thread.sleep(500);
		wm.clickbyid("modTRS001");
		Thread.sleep(500);
		wm.clickbyid("pgmAI001");
		wm.sleep();

		wm.clickbyid("btnMainAdd");
		Thread.sleep(500);
		
		// Start enter thecodee

		wm.sendtextbycssselecotrwithoutclear("#Code", ""+Code);
		Thread.sleep(50);
		wm.sendtextbycssselecotrwithoutclear("#Description", ""+Description);
		Thread.sleep(50);
		wm.sendtextbycssselecotrwithoutclear("#AtaiAddress", ""+AtaiAddress);
		Thread.sleep(50);
		wm.sendtextbycssselecotrwithoutclear("#AtaiBankAc", ""+AtaiBankAc);
		Thread.sleep(50);
		// enterthe customername and indexx
		wm.sendtextbyxvalue("//input[@aria-owns='AtaiCmsKey_listbox']", Customername);
		Thread.sleep(200);
		wm.Listandenter("//*[@id='AtaiCmsKey_listbox']/li", Customernameindex);
		Thread.sleep(200);

		// enterthe customername and indexx
		wm.sendtextbyxvalue("//input[@aria-owns='AtaiType_listbox']", Agentincetive);
		Thread.sleep(200);
		wm.Listandenter("//*[@id='AtaiType_listbox']/li", Agentincetiveindex);
		Thread.sleep(200);

		// Agent status
		wm.sendtextbyxvalue("//input[@aria-owns='AStatus_listbox']", Agentstatus);
		Thread.sleep(200);
		wm.Listandenter("//*[@id='AStatus_listbox']/li", Agentstatusindex);
		Thread.sleep(200);

		// Effectivedate

		wm.sendtextbycssselecotr("#AtaiEffectiveDate",
				"" + AtaiEffectiveDate1 + "-" + AtaiEffectiveDate2 + "-" + AtaiEffectiveDate3);

		Thread.sleep(300);
		
		// Accountlinkk
		wm.sendtextbyxvalue("//input[@aria-owns='AtaiAccountLink_listbox']", Accountlink);
		Thread.sleep(200);
		wm.Listandenter("//*[@id='AtaiAccountLink_listbox']/li", Accountlinkindexx);
		Thread.sleep(200);

		// Valuetypee
		wm.sendtextbyxvalue("//input[@aria-owns='AtaiValueType_listbox']", Valuetype);
		Thread.sleep(200);
		wm.Listandenter("//*[@id='AtaiValueType_listbox']/li", Valuetypeindex);
		Thread.sleep(200);

		// enterthe value
		wm.stabbyxpath("//input[@aria-owns='AtaiValueType_listbox']");
		Thread.sleep(200);
		wm.sendtextbycssselecotrwithoutclear("#AtaimPercentage", ""+AtaimPercentage);
		Thread.sleep(200);

		wm.clickbyxpath("//span[@class='k-icon k-i-check']");
		Thread.sleep(300);
		wm.clickbyid("btnMainSave");
		Thread.sleep(600);

		wm.Verifythealertpopupmessages("//*[@id='diaInfoMessage']",
				"Agent Incentive Saved/Updated Successfully",
				"Agent Incentive Created successfully",
				"Agent incentive not Created Successfully");

		Thread.sleep(500);
		
		
		Thread.sleep(500);
		wm.Listandenterquick("//span[contains(text(),'OK')]", "0");
		wm.Listandenterquick("//span[contains(text(),'OK')]", "1");
		wm.Listandenterquick("//span[contains(text(),'OK')]", "2");
		wm.Listandenterquick("//span[contains(text(),'OK')]", "3");


		wm.sleep();
	}

	@AfterMethod
	public void close()

	{
		wm.close();

	}

	@DataProvider(name = "dp")
	public Object[][] dp() throws IOException {

		return Wrappermethods.getSheet("Agentincentive", "Agentincentive");

	}
}