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
public class Hotelservicecharge 
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
	public void Hotelservicecharge(String Username, String Password, String Leftsidemenu,String Hotelservicehcragerulename,
			String Hotelservicehcragerulenameindex,String Applytype,String Applytypeindex,String Servicechargmode,
			String Servicechargmodeindex,String discount,String Allocationtype,String Allocationtypeindex,
			String Servicehcrgaeapplyon,String Servicehcrgaeapplyonindex,String Clientcategory,
			String Clientcategoryindex,String HhscdServChrgMon,String HhscdServChrgTue,String HhscdServChrgWed,
			String HhscdServChrgThu,String HhscdServChrgFri,String HhscdServChrgSat,String HhscdServChrgSun
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
		wm.clickbyid("pgmSC002");
		Thread.sleep(200);

		wm.clickbyid("btnMainAdd");
		Thread.sleep(300);
		
		//enter the details
		
		wm.sendtextbyxvalue("//input[@aria-owns='HhscdServChrgId_listbox']", Hotelservicehcragerulename);
		Thread.sleep(200);
        wm.Listandenter("//*[@id='HhscdServChrgId_listbox']/li", Hotelservicehcragerulenameindex);
        Thread.sleep(200);
        //Applytype

		wm.sendtextbyxvalue("//input[@aria-owns='HhscdApplyType_listbox']",Applytype);
		Thread.sleep(200);
        wm.Listandenter("//*[@id='HhscdApplyType_listbox']/li",Applytypeindex);
        Thread.sleep(200);
        
        //Enter the service chareg mdoe
        

		wm.sendtextbyxvalue("//input[@aria-owns='HhscdServChrgMode_listbox']",Servicechargmode);
		Thread.sleep(200);
        wm.Listandenter("//*[@id='HhscdServChrgMode_listbox']/li",Servicechargmodeindex);
        Thread.sleep(200);
        
        //enterthe discount
        
        wm.sendtextbycssselecotrwithoutclear("#discount", ""+discount);
        Thread.sleep(200);
        
        //Allocationtypee
        wm.sendtextbyxvalue("//input[@aria-owns='HhscdCategoryType_listbox']",Allocationtype);
		Thread.sleep(200);
        wm.Listandenter("//*[@id='HhscdCategoryType_listbox']/li",Allocationtypeindex);
        Thread.sleep(200);
        
        //selectedthe base fare
        wm.sendtextbyxvalue("//input[@aria-owns='hscdServChrgApplyOn_listbox']",Servicehcrgaeapplyon);
		Thread.sleep(200);
        wm.Listandenter("//*[@id='hscdServChrgApplyOn_listbox']/li",Servicehcrgaeapplyonindex);
        Thread.sleep(200);
        

		// selethe client ctegory
		wm.findelementandsendtextbyxvalue("//input[@aria-haspopup='listbox']", Clientcategory);
		Thread.sleep(200);
		wm.Listandenter("//*[@id='HotelClientKeyKey_listbox']/li", Clientcategoryindex);
		Thread.sleep(200);

        //hotel roomwise pricecalculations
		
		//wm.sendtextbycssselecotr(xva, txt);
		wm.sendtextbycssselecotr("#HhscdServChrgMon", HhscdServChrgMon);
		wm.sendtextbycssselecotr("#HhscdServChrgTue", HhscdServChrgTue);
		wm.sendtextbycssselecotr("#HhscdServChrgWed", HhscdServChrgWed);
		wm.sendtextbycssselecotr("#HhscdServChrgThu", HhscdServChrgThu);
		wm.sendtextbycssselecotr("#HhscdServChrgFri", HhscdServChrgFri);
		wm.sendtextbycssselecotr("#HhscdServChrgSat", HhscdServChrgSat);
		wm.sendtextbycssselecotr("#HhscdServChrgSun", HhscdServChrgSun);
        
        //=======

		// clicking the grid level savebutton
		
		Thread.sleep(900);
		

		wm.clickbyxpath("//span[@class='k-icon k-i-check']");
		Thread.sleep(900);

		wm.clickbyid("btnMainSave");
		Thread.sleep(2000);


		Thread.sleep(900);

		wm.Verifythealertpopupmessages("//*[@id='diaInfoMessage']",
				"HOTEL Service Charge Saved/Updated Successfully", 
				"HOTEL Service Charge Saved/Updated Successfully",
				"HOTEL Service Charge not Saved/Updated Successfully");
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

		return Wrappermethods.getSheet("Hotelservicecharge", "Hotelservicecharge");

	}
}