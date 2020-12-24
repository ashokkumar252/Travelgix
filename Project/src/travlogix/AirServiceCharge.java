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
public class AirServiceCharge {

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
	public void AirServiceCharge(String Username, String Password, String Leftsidemenu,String Servicehcargename,
			String Applytype,String Applytypeindex,String Allocationtype,String Allocationtypeindexx,
			String Servicechargemode,String Servicechargemodeindex,String discount,String AascdServChrgBook,
			String Servichcargeapplyon,String Servichcargeapplyonindexx,String AascdServChrgAdult,
			String AascdServChrgChild,String AascdServChrgInfant,String Clientcategory,String Clientcategoryindex
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
		wm.clickbyid("pgmSC001");
		Thread.sleep(2000);

		wm.clickbyid("btnMainAdd");
		Thread.sleep(300);

		// starenter thedetails

		wm.sendtextbyxvalue("//input[@name='AascdServChgId_input']", Servicehcargename);

		// Applytype
		wm.sendtextbyxvalue("//input[@aria-owns='AascdServApplyType_listbox']", Applytype);
		Thread.sleep(100);
		wm.Listandenter("//*[@id='AascdServApplyType_listbox']/li", Applytypeindex);
		Thread.sleep(100);

		// Allocationdetails
		wm.sendtextbyxvalue("//input[@aria-owns='AascdCategoryType_listbox']", Allocationtype);
		Thread.sleep(100);
		wm.Listandenter("//*[@id='AascdCategoryType_listbox']/li", Allocationtypeindexx);
		Thread.sleep(100);

		// AascdServChrgMode_listbox
		wm.sendtextbyxvalue("//input[@aria-owns='AascdServChrgMode_listbox']", Servicechargemode);
		Thread.sleep(100);
		wm.Listandenter("//*[@id='AascdServChrgMode_listbox']/li", Servicechargemodeindex);
		Thread.sleep(100);

		// Discountt
		wm.sendtextbycssselecotrwithoutclear("#discount", "" + discount);
		Thread.sleep(100);
		// AascdServChrgBook
		//wm.sendtextbycssselecotrwithoutclear("#AascdServChrgBook", "" + AascdServChrgBook);
		
		wm.findelementandsendtextbyxvalue("//input[@name='AascdServChrgBook']", AascdServChrgBook);
		Thread.sleep(100);
		// Servciechargeappyon
		wm.findelementandsendtextbyxvalue("//input[@aria-owns='AascdServChrgApplyOn_listbox']", Servichcargeapplyon);
		Thread.sleep(100);
	/*	wm.Listandenter("//*[@id='AascdServChrgApplyOn_listbox']/li", Servichcargeapplyonindexx);
		Thread.sleep(900);
*/
		wm.findelementandsendtextbyxvalue("//input[@id='AascdServChrgAdult']", "" + AascdServChrgAdult);
		Thread.sleep(100);
		wm.findelementandsendtextbyxvalue("//input[@id='AascdServChrgChild']", "" + AascdServChrgChild);
		Thread.sleep(100);
		wm.findelementandsendtextbyxvalue("//input[@id='AascdServChrgInfant']", "" + AascdServChrgInfant);
		Thread.sleep(100);
		
		
		//selectedtheclient category

		// selethe client ctegory
		wm.findelementandsendtextbyxvalue("//input[@aria-haspopup='listbox']", Clientcategory);
		Thread.sleep(200);
		wm.Listandenter("//*[@id='AirClientKeyKey_listbox']/li", Clientcategoryindex);
		Thread.sleep(200);


		// clicking the grid level savebutton

		wm.clickbyxpath("//span[@class='k-icon k-i-check']");
		Thread.sleep(1200);

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
				"AIR Service Charge Saved/Updated Successfully",
				"Air service charge  created successfully", 
				"Air service charge not created successfully");
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

		return Wrappermethods.getSheet("AirServiceCharge", "AirServiceCharge");

	}
}