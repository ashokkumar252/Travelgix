package Refund;
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
public class Miscrefund {

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
	public void Miscrefund(String Username, String Password, String Leftsidemenu, String ActiveFrom1,
			String ActiveFrom2,
			String ActiveFrom3, String Docktype, String Docktypeindex, String Salesbracnh, String Salesbracnhindex,
			String Customer, String Customerindex, String Leadpaxnamee, String dktClientReference,
			String Servicetype,String Commonindex,String Tickectstatusindex,
			String MiscVoucherNumberRead,String MiscConfirmationNumber,String ProjectNumberAP,
			String DepartmentAP,String MajorClassAP,String TravelStatusAP,String TotalSavingCodeAP,String GroupTravelIndicatorAP,
			String TourCodeAP,String EndorsementRestrictAP,String FareCalculationAreaAP,String IntlSalesIndicatorAP
) throws Exception

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
		wm.clickbyid("pgmSAL001");
		wm.sleep();

		wm.clickbyid("btnMainAdd");

		Thread.sleep(2000);

		wm.sendtextbycssselecotr("#DktDate", "" + ActiveFrom1 + "-" + ActiveFrom2 + "-" + ActiveFrom3);

		// Dockett
		wm.sendtextbyxvalue("//input[@aria-owns='dktDocTypeCode_listbox']", Docktype);
		Thread.sleep(50);
		wm.Listandenter("//*[@id='dktDocTypeCode_listbox']/li", Docktypeindex);
		Thread.sleep(150);

		// Salesbranch
		wm.sendtextbyxvalue("//input[@aria-owns='DktBranchKey_listbox']", Salesbracnh);
		Thread.sleep(50);
		wm.Listandenter("//*[@id='DktBranchKey_listbox']/li", Salesbracnhindex);
		Thread.sleep(150);

		// customerr
		wm.sendtextbyxvalue("//input[@aria-owns='DktPartnername_listbox']", Customer);
		Thread.sleep(50);
		wm.Listandenter("//*[@id='DktPartnername_listbox']/li", Customerindex);
		Thread.sleep(150);

		wm.sendtextbycssselecotrwithoutclear("#dktLeadPaxName", "" + Leadpaxnamee);
		Thread.sleep(200);

		// clintrefecnce
		wm.sendtextbycssselecotrwithoutclear("#dktClientReference", "" + dktClientReference);
		Thread.sleep(150);

		wm.Listandenter("//i[@class='fa fa-chevron-down']", "3");
		Thread.sleep(200);
		wm.Listandenter("//i[@class='fa fa-plus']", "3");
		Thread.sleep(2000);

		// MISc
		// Enter the miscdetails

		wm.sendtextbyxvalue("//input[@aria-owns='MiscServiceType_listbox']", Servicetype);
		Thread.sleep(200);
		wm.Listandenter("//*[@id='MiscServiceType_listbox']/li", Commonindex);
		Thread.sleep(200);



		// ===============================================================================
		// Select the tickectstatus

		wm.clickbyxpath("//span[@aria-owns='MiscServiceTypeCode_listbox']");
		Thread.sleep(90);
		wm.Listandenter("//*[@id='MiscServiceTypeCode_listbox']/li", Tickectstatusindex);
		Thread.sleep(150);
		
		// Enetr the voucher number

		wm.sendtextbyxvalue("//input[@id='MiscVoucherNumberRead']", MiscVoucherNumberRead);
		Thread.sleep(90);
		wm.stabbyxpath("//input[@id='MiscVoucherNumberRead']");
		Thread.sleep(200);

		wm.Listandenterquick("//button[@id='ConformationYes']", "0");
		Thread.sleep(500);

		wm.sleep();
		
		//Enterthe conformaitonnumber
		wm.sendtextbycssselecotrwithoutclear("#MiscConfirmationNumber", ""+MiscConfirmationNumber);
		Thread.sleep(200);
		
		
		//===================================================
		
		

wm.clickbyxpath("//button[@id='btnmiscsave']");

Thread.sleep(500);



// Enter the udid details



wm.Listandenterthevaluesinvisblexpath("//input[@name='Travel_Status_DN']", DepartmentAP);
//Thread.sleep(50);
wm.Listandenterthevaluesinvisblexpath("//*[@name='Project_Number_AP']", ProjectNumberAP);
//Thread.sleep(50);
wm.Listandenterthevaluesinvisblexpath("//*[@name='Department_AP']", DepartmentAP);
//Thread.sleep(50);
wm.Listandenterthevaluesinvisblexpath("//input[@name='Major_Class_AP']", MajorClassAP);
//Thread.sleep(50);

wm.Listandenterthevaluesinvisblexpath("//input[@name='Travel_Status_AP']", TravelStatusAP);
//Thread.sleep(50);
wm.Listandenterthevaluesinvisblexpath("//input[@name='Total_Saving_Code_AP']", TotalSavingCodeAP);
//Thread.sleep(50);
wm.Listandenterthevaluesinvisblexpath("//input[@name='Group_Travel_Indicator_AP']", GroupTravelIndicatorAP);
//Thread.sleep(50);
wm.Listandenterthevaluesinvisblexpath("//input[@name='Tour_Code_AP']", TourCodeAP);
//Thread.sleep(50);
wm.Listandenterthevaluesinvisblexpath("//input[@name='Endorsement_Restrict_AP']", EndorsementRestrictAP);
//Thread.sleep(50);
wm.Listandenterthevaluesinvisblexpath("//input[@name='Fare_Calculation_Area_AP']", FareCalculationAreaAP);
//Thread.sleep(200);


	wm.Listandenter("//span[@aria-owns='Booking_Type_AP_listbox']", "0");
	
	Thread.sleep(200);
	
	wm.Listandenter("//*[@id='Booking_Type_AP_listbox']/li", Commonindex);
	Thread.sleep(200);

	wm.Listandenterthevaluesinvisblexpath("//input[@name='Intl_Sales_Indicator_AP']", IntlSalesIndicatorAP);
	Thread.sleep(500);

	

wm.Netcollectionuisngcancellatiocharges("//input[@name='MiscRateDealFare']", "//input[@name='TotalTaxAmount']",
		"//input[@name='TotalServiceFee']", "//input[@name='TotalDiscount']", "//input[@name='TotOutputVat']", 
		"//input[@name='Amt_NetCollection']", "//*[@name='MiscRateSupplierCancellationChargeRfnd']",
		"//*[@name='MiscRateSupplierCancellationCharge']", "Net calclaiton done correectly by using the cancelaltion charges",
		"Net calclaiton not done correectly by using the cancelaltion charges");

wm.Publishedfareusingcancelaltionchargeswithoutuccf("//input[@name='MiscRateDealFare']", "//input[@name='TotalTaxAmount']",
		"//input[@name='salestotcommm']", "//*[@name='MiscRateSupplierCancellationCharge']", 
		"//input[@name='TotInputVat']", "//input[@name='Amt_NetPayable']", 
		"Publishedfare done correectly by using the cancelaltion charges", 
		"ublishedfare not done correectly by using the cancelaltion charges");
Thread.sleep(200);


wm.doubleclickusingxpath("//button[@id='btnmiscsave']");

wm.sleep();
wm.sleep();
wm.sleep();
wm.sleep();


wm.clickbyxpath("//*[@class='btn btn-danger']");
	Thread.sleep(500);

	wm.Listandenterquick("//span[contains(text(),'Leave Page')]", "0");
	wm.Listandenterquick("//span[contains(text(),'Leave Page')]", "1");
	wm.Listandenterquick("//span[contains(text(),'Leave Page')]", "2");
	wm.Listandenterquick("//span[contains(text(),'Leave Page')]", "3");
wm.sleep();
	
/*	wm.Listnegativescearios("//*[@id='DktNumber']", "0",
			"Pass : Sales Refund MISC   created successfuly" + "",
			"Fail:  Sales Refund MISC   not created successfuly " + "");
*/	
	wm.Verifythedropdownvalues("//input[@name='DktNumber']",
			"Pass : Refund MISc   created successfuly" + "",
			"Fail:  Refund MISC  not created successfuly " + "");

	Thread.sleep(2000);
	
	//wm.gettext("//*[@id='DktNumber']");
	
	wm.storestrign2("//*[@name='DktNumber']");
	
	//wm.gettext("//*[@id='DktNumber']");
	
	//wm.Gettextbylistandprint("//*[@id='DktNumber']", "Docketnumber is");
	
	
	Thread.sleep(300);


	}

	@AfterMethod
	public void close()

	{
		wm.close();

	}

	@DataProvider(name = "dp")
	public Object[][] dp() throws IOException {

		return Wrappermethods.getSheet("Miscrefund", "Miscrefund");

	}
}