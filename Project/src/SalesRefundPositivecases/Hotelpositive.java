package SalesRefundPositivecases;
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
public class Hotelpositive
{
	static 
	{

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
	public void logincheckK(String Username, String Password, String Leftsidemenu, String ActiveFrom1,
			String ActiveFrom2, String ActiveFrom3, String Docktype, String Docktypeindex, String Salesbracnh,
			String Salesbracnhindex, String Customer, String Customerindex, String Leadpaxnamee,
			String dktClientReference, String Tickectstatusindex,
			
			String Payableagent,String Payableagentindex,String hotelAdult,String hotelChild,
			String Bookingexecutive,String Bookingexecutiveindexx,String Salesexecutive,String Salesexecutiveindexx,
			String hoteltktDate1,String hoteltktDate2,String hoteltktDate3,
			
			String Hotelcity,String Hotelname,String Hotelchain,String hotelHotelPropertyCode,
			String Roomtypee,String Roombasics,String hotelCheckIn1,String hotelCheckIn2,
			String hotelCheckIn3,String hotelCheckOut1,String hotelCheckOut2,
			String hotelCheckOut3,String hotelNoOfRooms,String hotelConfirmationNumber,String hotelBookingReference,
			String Remarks,String Commonindex

) throws Exception

	{

		Thread.sleep(2000);

		// wm.sendtextbyid("", );
		wm.sendtextbyid("LoginCode", Username);
		Thread.sleep(50);
		wm.sendtextbyid("Password", Password);
		Thread.sleep(50);
		wm.clickbyxpath("//input[@value='Login']");
		Thread.sleep(900);

		// screnn===========================================================
		wm.sendtextbyid("input-items", Leftsidemenu);
		Thread.sleep(500);
		wm.clickbyid("modCAS001");
		Thread.sleep(500);
		wm.clickbyid("pgmSAL001");
		wm.sleep();

		wm.clickbyid("btnMainAdd");

		Thread.sleep(2000);

		wm.sendtextbycssselecotr("#DktDate", "" + ActiveFrom1 + "-" + ActiveFrom2 + "-" + ActiveFrom3);

		// Dockett
		wm.sendtextbyxvalue("//input[@aria-owns='dktDocTypeCode_listbox']", Docktype);
		Thread.sleep(50);
		wm.Listandenter("//*[@id='dktDocTypeCode_listbox']/li", Docktypeindex);
		Thread.sleep(200);

		// Salesbranch
		wm.sendtextbyxvalue("//input[@aria-owns='DktBranchKey_listbox']", Salesbracnh);
		Thread.sleep(50);
		wm.Listandenter("//*[@id='DktBranchKey_listbox']/li", Salesbracnhindex);
		Thread.sleep(200);

		// customerr
		wm.sendtextbyxvalue("//input[@aria-owns='DktPartnername_listbox']", Customer);
		Thread.sleep(50);
		wm.Listandenter("//*[@id='DktPartnername_listbox']/li", Customerindex);
		Thread.sleep(200);

		wm.sendtextbycssselecotrwithoutclear("#dktLeadPaxName", "" + Leadpaxnamee);
		Thread.sleep(200);

		// clintrefecnce
		wm.sendtextbycssselecotrwithoutclear("#dktClientReference", "" + dktClientReference);
		Thread.sleep(200);

		wm.Listandenter("//i[@class='fa fa-chevron-down']", "1");
		Thread.sleep(200);
		wm.Listandenter("//i[@class='fa fa-plus']", "1");
		Thread.sleep(2500);

		// hOTEL
		// ===============================================================================
		//Enter the payable agentt
		
		wm.sendtextbyxvalue("//input[@aria-owns='hotelProviderKey_listbox']",Payableagent);
		Thread.sleep(200);
		wm.Listandenter("//*[@id='hotelProviderKey_listbox']/li",Payableagentindex);
		Thread.sleep(200);
		
	
		//adut
		wm.sendtextbycssselecotr("#hotelAdult", ""+hotelAdult);
		Thread.sleep(90);	
		
		//child
		wm.sendtextbycssselecotr("#hotelChild", ""+hotelChild);
		Thread.sleep(80);
		
		
		//booking executivee
		wm.sendtextbyxvalue("//input[@aria-owns='hotelBookingUserName_listbox']",Bookingexecutive);
		Thread.sleep(200);
		wm.Listandenter("//*[@id='hotelBookingUserName_listbox']/li",Bookingexecutiveindexx);
		Thread.sleep(200);
		
		//sales executivee
		wm.sendtextbyxvalue("//input[@aria-owns='hotelSalesExecutiveName_listbox']",Salesexecutive);
		Thread.sleep(200);
		wm.Listandenter("//*[@id='hotelSalesExecutiveName_listbox']/li",Salesexecutiveindexx);
		Thread.sleep(200);
	
		
		// date selections 

		wm.sendtextbycssselecotr("#hoteltktDate", "" + hoteltktDate1 + "-" + hoteltktDate2 + "-" + hoteltktDate3);		
		
		
		//Enter the Service detailss
		
		wm.sendtextbyxvalue("//input[@aria-owns='hotelCityName_listbox']",Hotelcity);
		Thread.sleep(50);
		wm.Listandenter("//*[@id='hotelCityName_listbox']/li",Commonindex);
		Thread.sleep(200);
		
		
		//ente the hotelame
		wm.sendtextbyxvalue("//input[@aria-owns='hotelHotelName_listbox']",Hotelname);
		Thread.sleep(50);
		wm.Listandenter("//*[@id='hotelHotelName_listbox']/li",Commonindex);
		Thread.sleep(200);
		
		//enter the hotelchainn
		wm.sendtextbyxvalue("//input[@aria-owns='hotelHotelChainKey_listbox']",Hotelchain);
		Thread.sleep(50);
		wm.Listandenter("//*[@id='hotelHotelChainKey_listbox']/li",Commonindex);
		Thread.sleep(200);
		//ente tthe hotelpropertycode
	 wm.sendtextbycssselecotrwithoutclear("#hotelHotelPropertyCode", hotelHotelPropertyCode);
	 Thread.sleep(200);
	 
	 //roomtypee
	 
		wm.sendtextbyxvalue("//input[@aria-owns='hotelRoomTypeKey_listbox']",Roomtypee);
		Thread.sleep(50);
		wm.Listandenter("//*[@id='hotelRoomTypeKey_listbox']/li",Commonindex);
		Thread.sleep(200);
		
		//enter the roombaseics
		wm.sendtextbyxvalue("//input[@aria-owns='hotelRoombasisCode_listbox']",Roombasics);
		Thread.sleep(50);
		wm.Listandenter("//*[@id='hotelRoombasisCode_listbox']/li",Commonindex);
		Thread.sleep(200);
		
		////chekc in date

		wm.sendtextbycssselecotr("#hotelCheckIn", "" + hotelCheckIn1 + "-" + hotelCheckIn2 + "-" + hotelCheckIn3);
		Thread.sleep(50);
		
	
		//check out datee

		wm.sendtextbycssselecotr("#hotelCheckOut", "" + hotelCheckOut1 + "-" + hotelCheckOut2 + "-" + hotelCheckOut3);
		Thread.sleep(50);
	
		
		//no of unites
		wm.sendtextbycssselecotrwithoutclear("#hotelNoOfRooms", ""+hotelNoOfRooms);
		Thread.sleep(50);

		wm.sendtextbycssselecotrwithoutclear("#hotelConfirmationNumber", ""+hotelConfirmationNumber);
		Thread.sleep(50);
		
		//bboing reference
		wm.sendtextbycssselecotrwithoutclear("#hotelBookingReference", ""+hotelBookingReference);
		Thread.sleep(50);
		
		wm.sendtextbycssselecotrwithoutclear("#Remarks", ""+Remarks);
		Thread.sleep(50);
		
		
		
		wm.sleep();
		Thread.sleep(300);

	}

	@AfterMethod
	public void close()

	{
		wm.close();

	}

	@DataProvider(name = "dp")
	public Object[][] dp() throws IOException {

		return Wrappermethods.getSheet("Hotelpositive", "Hotelpositive");

	}
}