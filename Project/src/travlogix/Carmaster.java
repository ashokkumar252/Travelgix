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
public class Carmaster {

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
	public void Carmaster(String Username, String Password, String Leftsidemenu, String Ccode, String Cdescription,
			String Cvehciletypee, String Cvehciletypeeindexx, String Csupplier, String Csupplierindex,
			String CarRemarks, String CarReference, String CActiveFrom1, String CActiveFrom2, String CActiveFrom3,
			String CActiveto1, String CActiveto2, String CActiveto3, String Statusindex3) throws Exception

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
		wm.clickbyid("pgmCMS001");
		wm.sleep();
		wm.clickbyid("btnMainAdd");
		Thread.sleep(900);

		// after clickign the add button start to enter the details

		wm.sendtextbyxvalue("//input[@id='Code']", Ccode);

		wm.sendtextbyxvalue("//input[@id='Description']", Cdescription);

		// vehcletypee

		wm.sendtextbyxvalue("//input[@aria-owns='CarVehicleType_listbox']", Cvehciletypee);
		Thread.sleep(300);
		wm.Listandenter("//*[@id='CarVehicleType_listbox']/li", Cvehciletypeeindexx);
		Thread.sleep(300);

		// selectig the supplier

		wm.sendtextbyxvalue("//input[@aria-owns='CarSupplier_listbox']", Csupplier);
		Thread.sleep(300);
		wm.Listandenter("//*[@id='CarSupplier_listbox']/li", Csupplierindex);
		Thread.sleep(300);

		// remarks
		wm.sendtextbyxvalue("//input[@id='CarRemarks']", CarRemarks);
		Thread.sleep(200);

		// reference
		wm.sendtextbyxvalue("//input[@id='CarReference']", CarReference);
		Thread.sleep(200);

		// Fromdate

		wm.sendtextbycssselecotr("#ActiveFrom", "" + CActiveFrom1 + "-" + CActiveFrom2 + "-" + CActiveFrom3);
		Thread.sleep(50);
		// Todate
		wm.sendtextbycssselecotr("#ActiveTo", "" + CActiveto1 + "-" + CActiveto2 + "-" + CActiveto3);
		Thread.sleep(50);

		// Selected the stayusdropdwon
		wm.clickbyxpath("//span[@aria-owns='Status_listbox']");
		Thread.sleep(200);
		wm.Listandenter("//*[@id='Status_listbox']/li", Statusindex3);
		Thread.sleep(200);

		wm.clickbyxpath("//span[@class='k-icon k-i-check']");

		Thread.sleep(900);

		wm.clickbyid("btnMainSave");

		wm.sleep();

		wm.Verifythealertpopupmessages("//span[@id='diaInfoMessage']", 
				"Car Saved/Updated Successfully",
				"Car master Created successfully", 
				"Car master  not created successfully");

		
		//wm.capturetextfrommsgbox("//span[@id='diaInfoMessage']", " Car master created successfully ");

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

		return Wrappermethods.getSheet("Carmaster", "Carmaster");

	}
}