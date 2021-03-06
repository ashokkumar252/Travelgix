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
public class Executivemaster {

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
	public void Executivemaster(String Username, String Password, String Leftsidemenu,String user,String userindex,String Executivegenderindex,
			String ExecContactNo,String ExecEmailId,String Allocatedbranch,String Allocatedbranchindex,String Nationality,
			String Nationalityindex,String Desigination,String Desiginationindex,String ExecAccessLevel,
			String Discountmethod,String Discountmethodindexx,String ExecAllowedDiscValue,String ExecGalileoSignInCode,
			String ExecSabreSignInCode,String ExecAmadeusSignInCode,String ExecWorldSpanSignInCode,
			String Allocatedallocations,String Allocatedallocationsindex,String ExecRemarks,String ActiveFrom1,
			String ActiveFrom2,String ActiveFrom3,String ActiveTo1,String ActiveTo2,String ActiveTo3,
			String Statuslistboxindex,String ExecDefaultBankcodelistbox,String ExecDefaultBankcodelistboxindex
) throws Exception

	{

		Thread.sleep(2000);

		// wm.sendtextbyid("", );
		wm.sendtextbyid("LoginCode", Username);
		Thread.sleep(200);
		wm.stab("LoginCode");
		wm.sendtextbyid("Password", Password);
		Thread.sleep(200);
		wm.clickbyxpath("//input[@value='Login']");
		wm.sleep();
		
		// ====================Creating executive master
		// screnn===========================================================
		wm.sendtextbyid("input-items", Leftsidemenu);
		Thread.sleep(900);
		wm.clickbyid("modMAS001");
		Thread.sleep(900);
		wm.clickbyid("pgmEXT001");
		wm.sleep();
		Thread.sleep(900);
		wm.clickbyid("btnMainAdd");
		Thread.sleep(900);
		

		//user
		wm.sendtextbyxvalue("//input[@aria-owns='UserCode_listbox']",user);
		Thread.sleep(300);
		wm.Listandenter("//*[@id='UserCode_listbox']/li",userindex);
		Thread.sleep(300);
		
		//Genderlist
		Thread.sleep(50);
		wm.clickbyxpath("//span[@aria-owns='ExecGender_listbox']");
		Thread.sleep(50);
		wm.Listandenter("//*[@id='ExecGender_listbox']/li", Executivegenderindex);
		Thread.sleep(300);

		
		wm.sendtextbycssselecotrwithoutclear("#ExecContactNo", "" +ExecContactNo);
		wm.sendtextbycssselecotrwithoutclear("#ExecEmailId", "" +ExecEmailId);
		
		//allocatedbranch negativescenarios
		wm.sendtextbyxvalue("//input[@aria-owns='ExecAllocatedBranch_listbox']",Allocatedbranch);
		Thread.sleep(300);
		wm.Listandenter("//*[@id='ExecAllocatedBranch_listbox']/li",Allocatedbranchindex);
		Thread.sleep(300);
		
		
		//Nationaltiy
				wm.sendtextbyxvalue("//input[@aria-owns='ExecNationality_listbox']",Nationality);
				Thread.sleep(300);
				wm.Listandenter("//*[@id='ExecNationality_listbox']/li",Nationalityindex);
				Thread.sleep(300);
	//Desigination
				wm.sendtextbyxvalue("//input[@aria-owns='ExecDesignation_listbox']",Desigination);
				Thread.sleep(300);
				wm.Listandenter("//*[@id='ExecDesignation_listbox']/li",Desiginationindex);
				Thread.sleep(300);
			
				//Accesslevel
				wm.sendtextbycssselecotrwithoutclear("#ExecAccessLevel", "" +ExecAccessLevel);
				
				
				//Discountmethod
				wm.sendtextbyxvalue("//input[@aria-owns='ExecDiscMethod_listbox']",Discountmethod);
				Thread.sleep(300);
				wm.Listandenter("//*[@id='ExecDiscMethod_listbox']/li",Discountmethodindexx);
				Thread.sleep(300);
		

				//discountallowed
				wm.sendtextbycssselecotrwithoutclear("#ExecAllowedDiscValue", "" +ExecAllowedDiscValue);
				wm.sendtextbycssselecotrwithoutclear("#ExecGalileoSignInCode", "" +ExecGalileoSignInCode);
				wm.sendtextbycssselecotrwithoutclear("#ExecSabreSignInCode", "" +ExecSabreSignInCode);
				wm.sendtextbycssselecotrwithoutclear("#ExecAmadeusSignInCode", "" +ExecAmadeusSignInCode);
				wm.sendtextbycssselecotrwithoutclear("#ExecWorldSpanSignInCode", "" +ExecWorldSpanSignInCode);
				
				//Allocated locations
				wm.sendtextbyxvalue("//input[@aria-owns='ExecAllowedLocations_listbox']",Allocatedallocations);
				Thread.sleep(300);
				wm.Listandenter("//*[@id='ExecAllowedLocations_listbox']/li",Allocatedallocationsindex);
				Thread.sleep(300);
		
				
				wm.sendtextbycssselecotrwithoutclear("#ExecRemarks", "" +ExecRemarks);
				
				wm.sendtextbycssselecotr("#ActiveFrom",
						"" + ActiveFrom1 + "-" + ActiveFrom2 + "-" + ActiveFrom3);
				Thread.sleep(50);
				wm.sendtextbycssselecotr("#ActiveTo", "" + ActiveTo1 + "-" + ActiveTo2 + "-" + ActiveTo3);
				Thread.sleep(50);
				
				wm.clickbyxpath("//span[@aria-owns='Status_listbox']");
				Thread.sleep(50);
				wm.Listandenter("//*[@id='Status_listbox']/li", Statuslistboxindex);
				Thread.sleep(300);
			

				//Defaultcollectionbank
				wm.sendtextbyxvalue("//input[@aria-owns='ExecDefaultBankcode_listbox']",ExecDefaultBankcodelistbox);
				Thread.sleep(300);
				wm.Listandenter("//*[@id='ExecDefaultBankcode_listbox']/li",ExecDefaultBankcodelistboxindex);
				Thread.sleep(300);
				

				wm.doubleclickusingxpath("//span[@class='k-icon k-i-check']");
				Thread.sleep(1500);
				wm.clickbyid("btnMainSave");
				Thread.sleep(300);
				
		wm.Verifythealertpopupmessages("//div[@id='dialogWarning']", 
				"Executive Saved/Updated Successfully",
				"Executive Master Created successfully", 
				"Executive Master not Created successfully");
		
				
				/*wm.capturetextfrommsgbox("//div[@id='dialogWarning']", 
						"Executive Master ecord created successfully ");
			*/	
		
		Thread.sleep(300);
				wm.Listandenterquick("//span[contains(text(),'OK')]", "0");
				wm.Listandenterquick("//span[contains(text(),'OK')]", "1");
				wm.Listandenterquick("//span[contains(text(),'OK')]", "2");
				wm.Listandenterquick("//span[contains(text(),'OK')]", "3");
				Thread.sleep(900);
				
				
	
		

	}

	@AfterMethod
	public void close()

	{
		wm.close();

	}

	@DataProvider(name = "dp")
	public Object[][] dp() throws IOException {

		return Wrappermethods.getSheet("Executivemaster", "Executivemaster");

	}
}