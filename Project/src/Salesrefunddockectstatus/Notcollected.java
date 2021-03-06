package Salesrefunddockectstatus;

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
import SalesRefundPositivecases.Airpositivecash;
@Listeners({ ATUReportsListener.class, ConfigurationListener.class, MethodListener.class })
public class Notcollected 
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
	public void Notcollected(String Username, String Password, String Leftsidemenu, String ActiveFrom1,
			String ActiveFrom2, String ActiveFrom3, String Docktype, String Docktypeindex, String Salesbracnh,
			String Salesbracnhindex, String Customer, String Customerindex, String Leadpaxnamee,
			String dktClientReference, String AatdTicketNumber,
			String CopyAatdTicketNumber, String Carcopytickect,
			String Commonindex, String Miscvouchernumber) throws Exception

	{

		Thread.sleep(2000);

		// wm.sendtextbyid("", );
		wm.sendtextbyid("LoginCode", Username);
		wm.stab("LoginCode");

		Thread.sleep(300);
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

		// Step 1:

		// Creating nw docket
		// Navigate to sales refund screen
		// Enter the details click the save and created the docket number . and
		// verify the workbench status as : new

		// clickinthe save button
		wm.clickbyid("btnMainSave");
		Thread.sleep(300);

		wm.Listandenterquick("//span[contains(text(),'OK')]", "0");
		wm.Listandenterquick("//span[contains(text(),'OK')]", "1");
		wm.Listandenterquick("//span[contains(text(),'OK')]", "2");
		wm.Listandenterquick("//span[contains(text(),'OK')]", "3");
		Thread.sleep(500);
		wm.clickbyxpath("//button[@class='btn btn-success']");
		Thread.sleep(900);

		wm.Copyandpaste("//*[@id='SalesSearchGrid']/div[3]/table/tbody/tr[1]/td[1]");
		Thread.sleep(300);

		// wm.sendtextbyxvalue("//input[@name='DktNumber']","");

		wm.sendtextbyxvalue("//input[@name='DktNumber']", wm.store2);
		Thread.sleep(300);
		wm.clickbyxpath("//button[@class='btn btn-success']");
		Thread.sleep(600);

		wm.doubleclickusingxpath("//*[@id='SalesSearchGrid']/div[3]/table/tbody/tr[1]/td[1]");
		Thread.sleep(300);

		wm.clickbyid("btnMainEdit");
		Thread.sleep(1200);

		// 1. Air : Enter the Air booking details

		// wm.Listandenter("//i[@class='fa fa-chevron-down']", "0");
		Thread.sleep(200);
		wm.Listandenter("//i[@class='fa fa-plus']", "0");

		Thread.sleep(2500);

		// enter the tickect nuber
		wm.sendtextbycssselecotrwithoutclear("#AatdTicketNumber", "" + AatdTicketNumber);
		Thread.sleep(200);

		// copy tickect number

		wm.sendtextbyxvalue("//input[@onchange='CopyonairTicketChange(this)']", CopyAatdTicketNumber);
		Thread.sleep(90);
		wm.clickbyxpath("//input[@name='AirBookingExecutieveName_input']");
		Thread.sleep(150);
		wm.Listandenter("//button[@id='ConformationYes']", "0");

		// wm.clickbyxpath("//button[@id='ConformationYes']");
		Thread.sleep(2000);

		// clicking the savebuttons

		// wm.clickbyid("SalesChkInvoices");
		Thread.sleep(200);

		wm.doubleclickusingxpath("//button[@id='btnairsave']");
		wm.sleep();

		// wm.clickbyid("btnMainSave");
		wm.sleep();
		wm.sleep();

		/*
		 * wm.sendtextbycssselecotrwithoutclear("#AatdTicketNumber", "" +
		 * AatdTicketNumber); Thread.sleep(300);
		 */
		wm.doubleclickusingxpath("//button[@id='btnairsave']");
		Thread.sleep(500);

		wm.Mousemoveover("//input[@onchange='onairTicketChange(this)']");
		Thread.sleep(200);
		wm.Listnegativescearios(utility.Constant.Travelogixuitooltipvalidation, "0",
				"Pass : Sales Refund Air Tickect created successfuly" + "",
				"Fail:  Sales Refund Air Tickect not created successfuly " + "");

		// wm.Netcollections(Publishedfare, tax, Servicefee, Discount, Outvat,
		// Systemnetcollections, Positivemessages, Negativemessages);

		wm.sleep();

		wm.clickbyxpath("//button[@class='btn btn-danger']");
		Thread.sleep(90);

		wm.Listandenterquick("//span[contains(text(),'Leave Page')]", "0");
		wm.Listandenterquick("//span[contains(text(),'Leave Page')]", "1");
		wm.Listandenterquick("//span[contains(text(),'Leave Page')]", "2");
		wm.Listandenterquick("//span[contains(text(),'Leave Page')]", "3");
		Thread.sleep(2000);

		// up the Air
		wm.clickbyxpath("//*[@id='divdetailstab']/div[1]/div/div[1]/div[1]/a/i");
		// up the hotel
		wm.clickbyxpath("//*[@id='divdetailstab']/div[2]/div/div[1]/div[1]/a/i");

		// Enter the cardetails
		wm.Listandenter("//i[@class='fa fa-plus']", "2");
		Thread.sleep(2000);

		// Enter the car details

		wm.sendtextbyxvalue("//input[@onchange='onCarCopyTicketChange(this)']", Carcopytickect);
		Thread.sleep(300);
		wm.stabbyxpath("//input[@onchange='onCarCopyTicketChange(this)']");
		Thread.sleep(200);
		wm.Listandenter("//button[@id='ConformationYes']", "0");
		Thread.sleep(2000);

		wm.clickbyxpath("//span[@aria-owns='CcvdVoucherStatus_listbox']");
		Thread.sleep(90);
		wm.keyboardarrowdownonetime("//span[@aria-owns='CcvdVoucherStatus_listbox']");
		// wm.Listandenter("//*[@id='CcvdVoucherStatus_listbox']/li",
		// Commonindex);
		Thread.sleep(200);

		wm.clickbyxpath("//button[@id='btncarsave']");
		wm.sleep();

		wm.sleep();
		Thread.sleep(2000);
		wm.clickbyxpath("//button[@id='btncarsave']");
		Thread.sleep(200);

		wm.Mousemoveover("//input[@name='CcvdSalesExecutiveName_input']");
		Thread.sleep(200);
		wm.Listnegativescearios(utility.Constant.Travelogixuitooltipvalidation, "0",
				"Pass : Sales Refund Car Tickect created successfuly" + "",
				"Fail:  Sales Refund Car Tickect not created successfuly " + "");

		// wm.Netcollections(Publishedfare, tax, Servicefee, Discount, Outvat,
		// Systemnetcollections, Positivemessages, Negativemessages);
		Thread.sleep(500);

		wm.clickbyxpath("//button[@class='btn btn-danger']");
		Thread.sleep(90);

		wm.Listandenterquick("//span[contains(text(),'Leave Page')]", "0");
		wm.Listandenterquick("//span[contains(text(),'Leave Page')]", "1");
		wm.Listandenterquick("//span[contains(text(),'Leave Page')]", "2");
		wm.Listandenterquick("//span[contains(text(),'Leave Page')]", "3");

		Thread.sleep(200);


		wm.doubleclickusingxpath("//a[@id='btnMainSave']");

		
		wm.sleep();

		wm.Listandenterquick("//span[contains(text(),'OK')]", "0");
		wm.Listandenterquick("//span[contains(text(),'OK')]", "1");
		wm.Listandenterquick("//span[contains(text(),'OK')]", "2");
		wm.Listandenterquick("//span[contains(text(),'OK')]", "3");
Thread.sleep(200);

		
		
		wm.clickbyid("btnMainReturn");
		Thread.sleep(900);
		
		wm.sendtextbyxvalue("//input[@name='DktNumber']", wm.store2);
		Thread.sleep(300);
		
		wm.clickbyxpath("//button[@class='btn btn-success']");
		Thread.sleep(600);

		wm.doubleclickusingxpath("//*[@id='SalesSearchGrid']/div[3]/table/tbody/tr[1]/td[1]");
		Thread.sleep(300);

		wm.Verifythealertpopupmessagesusincontains("//*[@id='SalesSearchGrid']/div[3]/table/tbody/tr[1]/td[13]", 
				"Not Collected",
				"Newly created docket status saveas Not Collected", "Newly created docket status Not saveas Not Collected");


		
	}

	@AfterMethod
	public void close()

	{
		wm.close();

	}

	@DataProvider(name = "dp")
	public Object[][] dp() throws IOException {

		return Wrappermethods.getSheet("Notcollected", "Notcollected");

	}
}