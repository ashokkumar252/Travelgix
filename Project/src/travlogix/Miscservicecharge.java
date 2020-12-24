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
public class Miscservicecharge 
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
	public void Miscservicecharge(String Username, String Password, String Leftsidemenu,String Servicecargename,
			String Servicecargenameindex,String Allocationtype,String Allocationtypeindex,
			String Servicechargemode,String Servicechargemodeindex,String misChargeAmount,
			String Applytype,String Applytypeindex,String Applyon,String Applyonindexx,String discount,
			String Statusindex,String Clientcategory,String Clientcategoryindex,String misRemarks
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
		wm.sendtextbyid("input-items", Leftsidemenu);
		Thread.sleep(500);
		wm.clickbyid("modTRS001");
		Thread.sleep(200);
		wm.clickbyid("pgmSC004");
		Thread.sleep(2000);
		
		wm.clickbyid("btnMainAdd");
		Thread.sleep(300);
		
		//Enter the detailsls
		
		wm.sendtextbyxvalue("//input[@aria-owns='misRuleKey_listbox']", Servicecargename);
		Thread.sleep(100);
		wm.Listandenter("//*[@id='misRuleKey_listbox']/li", Servicecargenameindex);
		Thread.sleep(100);

		//Allocationtype
		
				wm.sendtextbyxvalue("//input[@aria-owns='misAllocationType_listbox']",Allocationtype);
				Thread.sleep(100);
				wm.Listandenter("//*[@id='misAllocationType_listbox']/li", Allocationtypeindex);
				Thread.sleep(100);


				//servicehcargemodee
				
						wm.sendtextbyxvalue("//input[@aria-owns='mrcChrgMode_listbox']",Servicechargemode);
						Thread.sleep(100);
						wm.Listandenter("//*[@id='mrcChrgMode_listbox']/li",Servicechargemodeindex);
						Thread.sleep(100);

		//chrgeamount
		wm.sendtextbycssselecotrwithoutclear("#misChargeAmount",""+misChargeAmount);
		Thread.sleep(100);
		
		
	//Applytype
		
		wm.sendtextbyxvalue("//input[@aria-owns='mrcServApplyType_listbox']",Applytype);
		Thread.sleep(100);
		wm.Listandenter("//*[@id='mrcServApplyType_listbox']/li",Applytypeindex);
		Thread.sleep(100);


		//Applytype
			
			wm.sendtextbyxvalue("//input[@aria-owns='misApplyOnKey_listbox']",Applyon);
			Thread.sleep(100);
			wm.Listandenter("//*[@id='misApplyOnKey_listbox']/li",Applyonindexx);
			Thread.sleep(100);
//Disocunt
			
			wm.sendtextbycssselecotrwithoutclear("#discount", discount);
			Thread.sleep(200);
			


			//Applytype
				
			
			wm.clickbyxpath("//span[@aria-owns='Status_listbox']");
				//wm.sendtextbyxvalue("//input[@aria-owns='Status_listbox']",Status);
				Thread.sleep(200);
				wm.Listandenter("//*[@id='Status_listbox']/li",Statusindex);
				Thread.sleep(200);
			

				// selethe client ctegory
				wm.findelementandsendtextbyxvalue("//input[@aria-haspopup='listbox']", Clientcategory);
				Thread.sleep(200);
				wm.Listandenter("//*[@id='MISClientKeyKey_listbox']/li", Clientcategoryindex);
				Thread.sleep(200);

				//entertheremarks
				wm.stabbyxpath("//span[@aria-owns='Status_listbox']");
				Thread.sleep(200);
				wm.sendtextbycssselecotrwithoutclear("#misRemarks", ""+misRemarks);
				Thread.sleep(100);
                				
				
				wm.clickbyxpath("//span[@class='k-icon k-i-check']");
				Thread.sleep(200);

				wm.clickbyid("btnMainSave");
				Thread.sleep(2000);

				// wm.capturetextfrommsgbox("//span[@id='diaWarningMessage']", "

				// Bussiness partner Record created successfully ");
				/*
				 * wm.capturetextfrommsgbox("//*[@id='diaInfoMessage']",
				 * " Car Service Charge Rule  Record created successfully ");
				 */
				Thread.sleep(900);

				wm.Verifythealertpopupmessages("//*[@id='diaInfoMessage']",
						"MISC Service Charge Saved/Updated Successfully", "MISC service charge  created successfully",
						"MISC Service Charge not Saved/Updated Successfully");
				Thread.sleep(300);

				Thread.sleep(500);
				wm.Listandenterquick("//span[contains(text(),'OK')]", "0");
				wm.Listandenterquick("//span[contains(text(),'OK')]", "1");
				wm.Listandenterquick("//span[contains(text(),'OK')]", "2");
				wm.Listandenterquick("//span[contains(text(),'OK')]", "3");

				Thread.sleep(300);

				
		
	}

	@AfterMethod
	public void close()

	{
		wm.close();

	}

	@DataProvider(name = "dp")
	public Object[][] dp() throws IOException {

		return Wrappermethods.getSheet("Miscservicecharge", "Miscservicecharge");

	}
}