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
public class CarServiceChargeRule {

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
	public void CarServiceChargeRule(String Username, String Password, String Leftsidemenu,
			String Code,String Vehicletype,String Vehicletypeindex,String ActiveFrom1,String ActiveFrom2,
			String ActiveFrom3,String ActiveTo1,String ActiveTo2,String ActiveTo3,String Suppliername,
			String Suppliernameindexx,String Chargename,String Chargenameindexx,String Statusindex
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
		wm.clickbyid("pgmCSM001");
		Thread.sleep(200);

		wm.clickbyid("btnMainAdd");
		Thread.sleep(300);

		wm.sendtextbyid("Code", Code);
		Thread.sleep(200);

		wm.sendtextbyxvalue("//input[@aria-owns='VehicleTypeCode_listbox']", Vehicletype);
		Thread.sleep(200);
		wm.Listandenter("//*[@id='VehicleTypeCode_listbox']/li", Vehicletypeindex);
		Thread.sleep(200);

		wm.sendtextbycssselecotr("#ActiveFrom", "" + ActiveFrom1 + "-" + ActiveFrom2 + "-" + ActiveFrom3);
		Thread.sleep(50);
		wm.sendtextbycssselecotr("#ActiveTo", "" + ActiveTo1 + "-" + ActiveTo2 + "-" + ActiveTo3);
		Thread.sleep(50);

		// suppliername

		wm.sendtextbyxvalue("//input[@aria-owns='SupplierCode_listbox']", Suppliername);
		Thread.sleep(100);
		wm.Listandenter("//*[@id='SupplierCode_listbox']/li", Suppliernameindexx);
		Thread.sleep(100);

		// Chargenamee

		wm.sendtextbyxvalue("//input[@aria-owns='chargeKey_listbox']", Chargename);
		Thread.sleep(100);
		wm.Listandenter("//*[@id='chargeKey_listbox']/li", Chargenameindexx);
		Thread.sleep(100);

		// Statuselections

		wm.clickbyxpath(" //span[@aria-owns='Status_listbox']");
		Thread.sleep(100);
		wm.Listandenter("//*[@id='Status_listbox']/li", Statusindex);
		Thread.sleep(100);

		// clicking the grid level savebutton

		wm.clickbyxpath("//span[@class='k-icon k-i-check']");
		Thread.sleep(200);

		wm.clickbyid("btnMainSave");
		Thread.sleep(2000);
		
		// wm.capturetextfrommsgbox("//span[@id='diaWarningMessage']", "

		// Bussiness partner Record created successfully ");
/*		wm.capturetextfrommsgbox("//*[@id='diaInfoMessage']",
				" Car Service Charge Rule  Record created successfully ");
*/
		Thread.sleep(500);

		wm.Verifythealertpopupmessages("//*[@id='diaInfoMessage']",
				"Car Service Charge Master Saved/Updated Successfully",
				"Car service charge rule created successfully", "Car service charge rule not created successfully");
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

		return Wrappermethods.getSheet("CarServiceChargeRule", "CarServiceChargeRule");

	}
}