package LPO;

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
public class Lpo {

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
	public void Lpo(String Username, String Password, String Leftsidemenu, String tickectnumber,
			String Gridindex,String lpoNumberUpdate,String lpoDateUpdate1,String lpoDateUpdate2,
			String lpoDateUpdate3) throws Exception

	{

		Thread.sleep(2000);

		// wm.sendtextbyid("", );
		wm.sendtextbyid("LoginCode", Username);
		Thread.sleep(50);
		wm.stab("LoginCode");
		wm.sendtextbyid("Password", Password);
		Thread.sleep(50);
		wm.clickbyxpath("//input[@value='Login']");
		Thread.sleep(900);

		// screnn===========================================================
		wm.sendtextbyid("input-items", Leftsidemenu);
		Thread.sleep(500);
		wm.clickbyid("modCAS001");
		Thread.sleep(500);
		wm.clickbyid("pgmSTCHNG");
		wm.sleep();

		// Enter thetickectnumber
		wm.sendtextbyxvalue("//input[@id='STC_ticketNumber']", tickectnumber);
		Thread.sleep(200);
		wm.keyboardarrowdownonetime("//input[@id='STC_ticketNumber']");
		Thread.sleep(200);
		wm.Enterbyxpath("//input[@id='STC_ticketNumber']");
		Thread.sleep(200);
		wm.doubleclickusingxpath("//button[@class='btn btn-success']");

		Thread.sleep(2000);

		wm.Listandenterquick("//*[@id='StaticChangeSearchGrid_active_cell']", Gridindex);

		Thread.sleep(200);

		// Enter the lponumber

		wm.sendtextbycssselecotrwithoutclear("#lpoNumberUpdate",lpoNumberUpdate);
		Thread.sleep(200);

		// LPO datee
		wm.sendtextbycssselecotr("#lpoDateUpdate", "" + lpoDateUpdate1 + "-" + lpoDateUpdate2 + "-" + lpoDateUpdate3);
		Thread.sleep(200);

		wm.doubleclickusingxpath("//button[@title='Update']");
		Thread.sleep(2000);

		wm.Verifythealertpopupmessagesusincontains("//*[@id='diaInfoMessage']", "successfully",
				"LPO done successfully", "LPO not done successfully");

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

		return Wrappermethods.getSheet("Lpo", "Lpo");

	}
}