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
public class CarServiceCharge {

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
	public void logincheckK(String Username, String Password, String Leftsidemenu,String Servicerulename,String Applytype,
			String Applytypeindex,String Servicechargemode,String Servicechargemodeindexx,String discount,String Allocationtype,
			String Allocationtypeindex,String CcscdCarServChgBook,String Sericechageapplyon,String Sericechageapplyonindex,String Clientcategory,
			String Clientcategoryindex) throws Exception

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
		wm.clickbyid("pgmSC003");
		Thread.sleep(200);

		wm.clickbyid("btnMainAdd");
		Thread.sleep(300);

		// Enter thedetislas

		wm.sendtextbyxvalue("//input[@aria-owns='CcscdCarServChgId_listbox']", Servicerulename);
		Thread.sleep(100);

		// Applytype
		wm.sendtextbyxvalue("//input[@aria-owns='CcscdApplyType_listbox']", Applytype);
		Thread.sleep(200);
		wm.Listandenter("//*[@id='CcscdApplyType_listbox']/li", Applytypeindex);
		Thread.sleep(200);

		// servicechargemodee
		wm.sendtextbyxvalue("//input[@aria-owns='CcscdCarServChgMode_listbox']", Servicechargemode);
		Thread.sleep(200);
		wm.Listandenter("//*[@id='CcscdCarServChgMode_listbox']/li", Servicechargemodeindexx);
		Thread.sleep(200);

		// Discountt
		wm.sendtextbycssselecotrwithoutclear("#discount", discount);
		Thread.sleep(200);

		// Allocationtypee
		wm.sendtextbyxvalue("//input[@aria-owns='CcscdAllocationType_listbox']", Allocationtype);
		Thread.sleep(100);
		wm.Listandenter("//*[@id='CcscdAllocationType_listbox']/li", Allocationtypeindex);
		Thread.sleep(100);

		wm.sendtextbycssselecotrwithoutclear("#CcscdCarServChgBook", CcscdCarServChgBook);
		Thread.sleep(200);

		// Allocationtypee
		wm.sendtextbyxvalue("//input[@aria-owns='cscdServChrgApplyOn_listbox']", Sericechageapplyon);
		Thread.sleep(100);
		wm.Listandenter("//*[@id='cscdServChrgApplyOn_listbox']/li", Sericechageapplyonindex);
		Thread.sleep(100);

		// selethe client ctegory
		wm.findelementandsendtextbyxvalue("//input[@aria-haspopup='listbox']", Clientcategory);
		Thread.sleep(200);
		wm.Listandenter("//*[@id='CarClientKeyKey_listbox']/li", Clientcategoryindex);
		Thread.sleep(200);

		// clicking the grid level savebutton

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
				"CAR Service Charge Saved/Updated Successfully", "Car service charge  created successfully",
				"Car service charge not created successfully");
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

		return Wrappermethods.getSheet("CarServiceCharge", "CarServiceCharge");

	}
}