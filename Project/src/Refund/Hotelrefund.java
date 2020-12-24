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
public class Hotelrefund {

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
	public void Hotelrefund(String Username, String Password, String Leftsidemenu, String ActiveFrom1, String ActiveFrom2,
			String ActiveFrom3, String Docktype, String Docktypeindex, String Salesbracnh, String Salesbracnhindex,
			String Customer, String Customerindex, String Leadpaxnamee, String dktClientReference,
			String Tickectstatusindex, String Hotelvouchernumber, String hvdRefundValidity1, String hvdRefundValidity2,
			String hvdRefundValidity3, String hotelConfirmationNumber, String ProjectNumberAP, String DepartmentAP,
			String MajorClassAP, String TravelStatusAP, String TotalSavingCodeAP, String GroupTravelIndicatorAP,
			String TourCodeAP, String EndorsementRestrictAP, String FareCalculationAreaAP, String IntlSalesIndicatorAP,
			String Commonindex) throws Exception

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

		wm.Listandenter("//i[@class='fa fa-chevron-down']", "1");
		Thread.sleep(200);
		wm.Listandenter("//i[@class='fa fa-plus']", "1");
		Thread.sleep(2000);

		// Hotel

		// ===============================================================================
		// Select the tickectstatus

		wm.clickbyxpath("//span[@aria-owns='hotelVoucherStatus_listbox']");
		Thread.sleep(90);
		wm.Listandenter("//*[@id='hotelVoucherStatus_listbox']/li", Tickectstatusindex);
		Thread.sleep(150);

		// Enetr the voucher number

		wm.sendtextbyxvalue("//input[@id='hotelVoucherNumberRead']", Hotelvouchernumber);
		Thread.sleep(90);
		wm.stabbyxpath("//input[@id='hotelVoucherNumberRead']");
		Thread.sleep(200);

		wm.Listandenterquick("//button[@id='ConformationYes']", "0");
		Thread.sleep(500);

		wm.sendtextbycssselecotr("#hvdRefundValidity",
				"" + hvdRefundValidity1 + "-" + hvdRefundValidity2 + "-" + hvdRefundValidity3);

		wm.clickbyxpath("//*[@id='div_Hotel_Header_Details']/div[2]/div/div[1]/div[1]/a/i");
		Thread.sleep(500);

		wm.sendtextbycssselecotrwithoutclear("#hotelConfirmationNumber", "" + hotelConfirmationNumber);
		Thread.sleep(900);
		wm.clickbyxpath("//*[@id='div_Hotel_Header_Details']/div[2]/div/div[1]/div[1]/a/i");
		Thread.sleep(500);

		// ==================

		wm.Hotelnetcalculationchargesusingcancelationcharges("//input[@name='hoteltfdBaseFare']",
				"//input[@name='TotalTaxAmount']", "//input[@name='TotalServiceFee']", "//input[@name='TotalDiscount']",
				"//input[@name='TotOutputVat']", "//input[@name='Amt_NetCollection']",
				"//*[@id='hoteltfdSupplierCancelCharge']", "//*[@id='AG_INPVAT']",
				"Net calclaiton done correectly uisng cancellation charges",
				"Net calclaiton not done correectly uisng cancellation charges");

		Thread.sleep(300);

		wm.Publishedfareusingcancelaltionchargeswithoutuccf("//input[@name='hoteltfdBaseFare']",
				"//input[@name='TotalTaxAmount']", "//input[@name='salestotcommm']", "//*[@id='AG_INPVAT']",
				"//input[@name='TotInputVat']", "//input[@name='Amt_NetPayable']",
				"Net payable Calclated successfuly done uisng cancellaiton charges",
				"Net payable Calclated not successfuly done uisng cancellaiton charges");

		// ===================================================================

		wm.clickbyxpath("//button[@id='btnhotelsave']");

		Thread.sleep(500);

		// Enter the udid details

		// wm.clickbyxpath("//*[@id='testData']/i");

		wm.findelementandsendtextbycss("#Project_Number_AP", ProjectNumberAP);
		Thread.sleep(50);
		wm.findelementandsendtextbycss("#Department_AP", DepartmentAP);
		Thread.sleep(50);
		wm.findelementandsendtextbycss("#Major_Class_AP", MajorClassAP);
		Thread.sleep(50);

		wm.findelementandsendtextbycss("#Travel_Status_AP", TravelStatusAP);
		Thread.sleep(50);
		wm.findelementandsendtextbycss("#Total_Saving_Code_AP", TotalSavingCodeAP);
		Thread.sleep(50);
		wm.findelementandsendtextbycss("#Group_Travel_Indicator_AP", GroupTravelIndicatorAP);
		Thread.sleep(50);
		wm.findelementandsendtextbycss("#Tour_Code_AP", TourCodeAP);
		Thread.sleep(50);
		wm.findelementandsendtextbycss("#Endorsement_Restrict_AP", EndorsementRestrictAP);
		Thread.sleep(50);
		wm.findelementandsendtextbycss("#Fare_Calculation_Area_AP", FareCalculationAreaAP);
		Thread.sleep(50);
		wm.clickbyxpath("//span[@aria-owns='Booking_Type_AP_listbox']");
		Thread.sleep(100);
		wm.Listandenter("//*[@id='Booking_Type_AP_listbox']/li", Commonindex);
		Thread.sleep(200);

		wm.findelementandsendtextbycss("#Intl_Sales_Indicator_AP", IntlSalesIndicatorAP);
		Thread.sleep(50);
		wm.findbyelementbyxpathandclick("//button[@id='btnhotelsave']");

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
		wm.sleep();

/*		wm.Listnegativescearios("//*[@id='DktNumber']", "0", "Pass :  Refund Hotel   created successfuly" + "",
				"Fail:  Refund Hotel   not created successfuly " + "");
*/


		wm.Verifythedropdownvalues("//input[@name='DktNumber']",
				"Pass : Sales Refund Hotel   created successfuly" + "",
				"Fail:  Sales Refund Hotel   not created successfuly " + "");
	
		
		wm.sleep();

		// wm.gettext("//*[@id='DktNumber']");

		wm.storestrign2("//input[@name='DktNumber']");

		// wm.gettext("//*[@id='DktNumber']");

		// wm.Gettextbylistandprint("//*[@id='DktNumber']", "Docketnumber is");

		Thread.sleep(300);

	}

	@AfterMethod
	public void close()

	{
		wm.close();

	}

	@DataProvider(name = "dp")
	public Object[][] dp() throws IOException {

		return Wrappermethods.getSheet("Hotelrefund", "Hotelrefund");

	}
}