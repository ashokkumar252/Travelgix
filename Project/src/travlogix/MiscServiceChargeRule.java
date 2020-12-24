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
public class MiscServiceChargeRule {

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
	public void MiscServiceChargeRule(String Username, String Password, String Leftsidemenu, String mimscrServiceRuleName,
			String Servicetype, String Servicetypeindex, String Servicecatgeory, String Servicecatgeoryindex,
			String ActiveFrom1, String ActiveFrom2, String ActiveFrom3, String ActiveTo1, String ActiveTo2,
			String ActiveTo3, String Chargename, String Chargenameindex, String Country, String Contryindexx,
			String Cityname, String Citynameindexx, String Statusindex, String MimscrRemarks) throws Exception

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
		wm.clickbyid("pgmMIRU");
		Thread.sleep(200);

		wm.clickbyid("btnMainAdd");
		Thread.sleep(300);

		wm.sendtextbyxvalue("//input[@name='mimscrServiceRuleName']", mimscrServiceRuleName);
		Thread.sleep(200);

		// Servicetypee
		wm.sendtextbyxvalue("//input[@aria-owns='mimscrServiceType_listbox']", Servicetype);
		Thread.sleep(500);
		wm.Listandenter("//*[@id='mimscrServiceType_listbox']/li", Servicetypeindex);
		Thread.sleep(100);

		// Servicecategory
		wm.sendtextbyxvalue("//input[@aria-owns='miserviceCatName_listbox']", Servicecatgeory);
		Thread.sleep(500);
		wm.Listandenter("//*[@id='miserviceCatName_listbox']/li", Servicecatgeoryindex);
		Thread.sleep(100);

		// dateselections

		wm.sendtextbycssselecotr("#ActiveFrom", "" + ActiveFrom1 + "-" + ActiveFrom2 + "-" + ActiveFrom3);
		Thread.sleep(50);
		wm.sendtextbycssselecotr("#ActiveTo", "" + ActiveTo1 + "-" + ActiveTo2 + "-" + ActiveTo3);
		Thread.sleep(50);

		// Servicecategory
		wm.sendtextbyxvalue("//input[@aria-owns='michargeName_listbox']", Chargename);
		Thread.sleep(500);
		wm.Listandenter("//*[@id='michargeName_listbox']/li", Chargenameindex);
		Thread.sleep(100);

		// Servicecategory
		wm.sendtextbyxvalue("//input[@aria-owns='micountryName_listbox']", Country);
		Thread.sleep(500);
		wm.Listandenter("//*[@id='micountryName_listbox']/li", Contryindexx);
		Thread.sleep(100);

		// Cityy
		wm.sendtextbyxvalue("//input[@aria-owns='micityName_listbox']", Cityname);
		Thread.sleep(500);
		wm.Listandenter("//*[@id='micityName_listbox']/li", Citynameindexx);
		Thread.sleep(100);

		// Statuselections

		wm.clickbyxpath(" //span[@aria-owns='Status_listbox']");
		Thread.sleep(100);
		wm.Listandenter("//*[@id='Status_listbox']/li", Statusindex);
		Thread.sleep(100);

		// enertheremarks
		wm.sendtextbycssselecotrwithoutclear("#mimscrRemarks", MimscrRemarks);
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
		Thread.sleep(500);

		wm.Verifythealertpopupmessages("//*[@id='diaInfoMessage']",
				"MIS Service Charge Rule Master Saved/Updated Successfully",
				"MIS service charge rule created successfully", "MIS service charge rule not created successfully");
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

		return Wrappermethods.getSheet("MiscServiceChargeRule", "MiscServiceChargeRule");

	}
}