package SalesrefundHotel;
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
public class Hotelbookinguccf
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

		wm.launchbrowser("chrome", utility.Constant.TRAVELOGIXURL);

	}

	@Test(dataProvider = "dp")
	public void logincheckK(String Username, String Password, String Leftsidemenu, String ActiveFrom1,
			String ActiveFrom2, String ActiveFrom3, String Docktype, String Docktypeindex, String Salesbracnh,
			String Salesbracnhindex, String Customer, String Customerindex, String Leadpaxnamee,
			String dktClientReference, String Tickectstatusindex,

			String Payableagent, String Payableagentindex, String hotelAdult, String hotelChild,
			String Bookingexecutive, String Bookingexecutiveindexx, String Salesexecutive, String Salesexecutiveindexx,
			String hoteltktDate1, String hoteltktDate2, String hoteltktDate3,

			String Hotelcity, String Hotelname, String Hotelchain, String hotelHotelPropertyCode, String Roomtypee,
			String Roombasics, String hotelCheckIn1, String hotelCheckIn2, String hotelCheckIn3, String hotelCheckOut1,
			String hotelCheckOut2, String hotelCheckOut3, String hotelNoOfRooms, String hotelConfirmationNumber,
			String hotelBookingReference, String Remarks, String Commonindex, String Processtype, String Currency,
			String hvdroomrate, String hoteltfdBaseFare, String Lodgecard, String Taxcodee, String HotelAtAmount,
			String Servicefeename, String hotelBaseAmount, String hotelFareCommPercent1, String hotelFareCommPercent2,
			String hotelFareCommPercent3,
			String hotelHOHotelHighFare, String hotelHOHotelCompareFare, String hotelHoRateAccessCode,
			String hotelHOReasonCode, String hotelHOGDSPropertyCode, String hotelBookingDate1, String hotelBookingDate2,
			String hotelBookingDate3, String Bookingpcc, String Issuedpcc, String Agentincentive,String ProjectNumberAP,
			String DepartmentAP,String MajorClassAP,String TravelStatusAP,String TotalSavingCodeAP,
			String GroupTravelIndicatorAP,String TourCodeAP,String EndorsementRestrictAP,String FareCalculationAreaAP,
			String IntlSalesIndicatorAP,String Hoteltickectnumber,String Modeindex,String Cardtypedetails,
			String fcardnum,String fcardDate1,String fcardDate3,String fApprovenum) throws Exception

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
		// Enter the payable agentt

		wm.sendtextbyxvalue("//input[@aria-owns='hotelProviderKey_listbox']", Payableagent);
		Thread.sleep(200);
		wm.Listandenter("//*[@id='hotelProviderKey_listbox']/li", Payableagentindex);
		Thread.sleep(200);

		// adut
		wm.sendtextbycssselecotr("#hotelAdult", "" + hotelAdult);
		Thread.sleep(90);

		// child
		wm.sendtextbycssselecotr("#hotelChild", "" + hotelChild);
		Thread.sleep(80);

		// booking executivee
		wm.sendtextbyxvalue("//input[@aria-owns='hotelBookingUserName_listbox']", Bookingexecutive);
		Thread.sleep(300);
		wm.Listandenter("//*[@id='hotelBookingUserName_listbox']/li", Bookingexecutiveindexx);
		Thread.sleep(200);

		// sales executivee
		wm.sendtextbyxvalue("//input[@aria-owns='hotelSalesExecutiveName_listbox']", Salesexecutive);
		Thread.sleep(300);
		wm.Listandenter("//*[@id='hotelSalesExecutiveName_listbox']/li", Salesexecutiveindexx);
		Thread.sleep(200);

		// date selections

		wm.sendtextbycssselecotr("#hoteltktDate", "" + hoteltktDate1 + "-" + hoteltktDate2 + "-" + hoteltktDate3);

		// Enter the Service detailss

		wm.sendtextbyxvalue("//input[@aria-owns='hotelCityName_listbox']", Hotelcity);
		Thread.sleep(50);
		wm.Listandenter("//*[@id='hotelCityName_listbox']/li", Commonindex);
		Thread.sleep(200);

		// ente the hotelame
		wm.sendtextbyxvalue("//input[@aria-owns='hotelHotelName_listbox']", Hotelname);
		Thread.sleep(50);
		wm.Listandenter("//*[@id='hotelHotelName_listbox']/li", Commonindex);
		Thread.sleep(200);

		// enter the hotelchainn
		wm.sendtextbyxvalue("//input[@aria-owns='hotelHotelChainKey_listbox']", Hotelchain);
		Thread.sleep(50);
		wm.Listandenter("//*[@id='hotelHotelChainKey_listbox']/li", Commonindex);
		Thread.sleep(200);
		// ente tthe hotelpropertycode
		wm.sendtextbycssselecotrwithoutclear("#hotelHotelPropertyCode", hotelHotelPropertyCode);
		Thread.sleep(200);

		// roomtypee

		wm.sendtextbyxvalue("//input[@aria-owns='hotelRoomTypeKey_listbox']", Roomtypee);
		Thread.sleep(50);
		wm.Listandenter("//*[@id='hotelRoomTypeKey_listbox']/li", Commonindex);
		Thread.sleep(200);

		// enter the roombaseics
		wm.sendtextbyxvalue("//input[@aria-owns='hotelRoombasisCode_listbox']", Roombasics);
		Thread.sleep(50);
		wm.Listandenter("//*[@id='hotelRoombasisCode_listbox']/li", Commonindex);
		Thread.sleep(200);

		//// chekc in date

		wm.sendtextbycssselecotr("#hotelCheckIn", "" + hotelCheckIn1 + "-" + hotelCheckIn2 + "-" + hotelCheckIn3);
		Thread.sleep(50);

		// check out datee

		wm.sendtextbycssselecotr("#hotelCheckOut", "" + hotelCheckOut1 + "-" + hotelCheckOut2 + "-" + hotelCheckOut3);
		Thread.sleep(50);

		// no of unites
		wm.Selectallbyxpath("//input[@name='hotelNoOfRooms']");		
		wm.sendtextbycssselecotrwithoutclear("#hotelNoOfRooms", "" + hotelNoOfRooms);
		Thread.sleep(50);

		wm.sendtextbycssselecotrwithoutclear("#hotelConfirmationNumber", "" + hotelConfirmationNumber);
		Thread.sleep(50);

		// bboing reference
		wm.sendtextbycssselecotrwithoutclear("#hotelBookingReference", "" + hotelBookingReference);
		Thread.sleep(50);

		wm.sendtextbycssselecotrwithoutclear("#Remarks", "" + Remarks);
		Thread.sleep(50);

		// enter the Fare details

		wm.clickbyxpath("//*[@id='div_Hotel_Header_Details']/div[2]/div/div[1]/div[1]/a");

		Thread.sleep(900);

		// procee typee
		wm.sendtextbyxvalue("//input[@aria-owns='hoteltfdProcessTypeKey_listbox']", Processtype);
		Thread.sleep(120);
		wm.Listandenter("//*[@id='hoteltfdProcessTypeKey_listbox']/li", Commonindex);
		Thread.sleep(200);

		// Currency
		wm.sendtextbyxvalue("//input[@aria-owns='hoteltfdTransCurrency_listbox']", Currency);
		Thread.sleep(120);
		wm.Listandenter("//*[@id='hoteltfdTransCurrency_listbox']/li", Commonindex);
		Thread.sleep(200);

		// roomrate

	/*	wm.Clearbyxpath("//input[@name='hvd_room_rate']");
		Thread.sleep(90);
*/
		//wm.sendtextbycssselecotr("#hvd_room_rate", "" + hvdroomrate);
		//Thread.sleep(200);
		wm.Selectallbycsspath("#hoteltfdBaseFare");
		wm.sendtextbycssselecotr("#hoteltfdBaseFare", "" + hoteltfdBaseFare);
		Thread.sleep(500);

		// logigcard
		wm.sendtextbyxvalue("//input[@aria-owns='HtfdOwnLodgeCardKey_listbox']", Lodgecard);
		Thread.sleep(50);
		wm.Listandenter("//*[@id='HtfdOwnLodgeCardKey_listbox']/li", Commonindex);
		Thread.sleep(200);

		// enter the tzzx detailss

		wm.stabbyxpath("//input[@aria-owns='HtfdOwnLodgeCardKey_listbox']");
		Thread.sleep(600);

		wm.Listandenter("//span[@class='k-icon k-i-add']", "0");
		Thread.sleep(500);

		wm.stabbyxpath(" //span[@class='k-icon k-i-cancel']");
		Thread.sleep(200);

		// TAX code
		wm.sendtextbyxvalue("//input[@aria-owns='HotelAtCode_listbox']", Taxcodee);
		Thread.sleep(100);
		wm.Listandenter("//*[@id='HotelAtCode_listbox']/li", Commonindex);
		Thread.sleep(90);

		// TAxamountt
		wm.sendtextbycssselecotrwithoutclear("#HotelAtAmount", HotelAtAmount);
		Thread.sleep(200);
		wm.clickbyxpath("//span[@class='k-icon k-i-check']");
		Thread.sleep(90);

		// enter the details in service fee

		wm.Listandenter("//span[@class='k-icon k-i-add']", "1");
		Thread.sleep(500);

		// name
		wm.sendtextbyxvalue("//input[@aria-owns='hotelServiceChargeId_listbox']", Servicefeename);
		Thread.sleep(90);
		wm.Listandenter("//*[@id='hotelServiceChargeId_listbox']/li", Commonindex);
		Thread.sleep(300);

		wm.sendtextbycssselecotrwithoutclear("#hotelBaseAmount", "" + hotelBaseAmount);
		Thread.sleep(200);

		wm.stabbyxpath("//input[@name='hotelBaseAmount']");
		Thread.sleep(200);

		wm.clickbyxpath("//span[@class='k-icon k-i-check']");
		Thread.sleep(200);

		wm.clickbyxpath("//*[@id='div_Hotel_Header_Details']/div[3]/div/div[1]/div[1]/a/i");

		// Enter the commissiondetails

		Thread.sleep(90);
		wm.Selectallbyxpath("//input[@name='hotelFareDiscPercent1']");

		
		Thread.sleep(90);

		wm.sendtextbycssselecotrwithoutclear("#hotelFareCommPercent1", "" + hotelFareCommPercent1);

		Thread.sleep(90);
		
		//wm.Selectallbycsspath("#hotelFareCommPercent2");
		wm.Selectallbyxpath("//input[@name='hotelFareCommPercent2']");

		Thread.sleep(90);

		wm.sendtextbycssselecotrwithoutclear("#hotelFareCommPercent2", "" + hotelFareCommPercent1);

		Thread.sleep(90);
		
		wm.Selectallbycsspath("#hotelFareDiscPercent1");
		Thread.sleep(90);

		wm.sendtextbycssselecotrwithoutclear("#hotelFareDiscPercent1", "" + hotelFareCommPercent1);
		Thread.sleep(90);

		wm.clickbyxpath("//*[@id='div_Hotel_Header_Details']/div[4]/div/div[1]/div[1]/a");
		Thread.sleep(200);

		// enter the other details

		wm.sendtextbycssselecotrwithoutclear("#hotelHOHotelHighFare", "" + hotelHOHotelHighFare);
		Thread.sleep(50);
		wm.sendtextbycssselecotrwithoutclear("#hotelHOHotelCompareFare", "" + hotelHOHotelCompareFare);
		Thread.sleep(50);
		wm.sendtextbycssselecotrwithoutclear("#hotelHoRateAccessCode", "" + hotelHoRateAccessCode);
		Thread.sleep(50);
		wm.sendtextbycssselecotrwithoutclear("#hotelHOReasonCode", "" + hotelHOReasonCode);
		Thread.sleep(50);
		wm.sendtextbycssselecotrwithoutclear("#hotelHOGDSPropertyCode", "" + hotelHOGDSPropertyCode);
		Thread.sleep(50);
		// Booking datee

		wm.sendtextbycssselecotr("#hotelBookingDate",
				"" + hotelBookingDate1 + "-" + hotelBookingDate2 + "-" + hotelBookingDate3);

		Thread.sleep(50);
		// Booking pcc
		wm.sendtextbyxvalue("//input[@aria-owns='hotelBookingPcc_listbox']", Bookingpcc);
		Thread.sleep(100);
		wm.Listandenter("//*[@id='hotelBookingPcc_listbox']/li", Commonindex);
		Thread.sleep(200);

		// issues pcc
		wm.sendtextbyxvalue("//input[@aria-owns='hotelIssuingPcc_listbox']", Issuedpcc);
		Thread.sleep(100);
		// wm.Listandenter("//*[@id='hotelServiceChargeId_listbox']/li",
		// Commonindex);
		Thread.sleep(200);

		wm.clickbyxpath("//*[@id='div_Hotel_Header_Details']/div[5]/div/div[1]/div[1]/a/i");

		Thread.sleep(500);

		// Agent incentivee

		wm.sendtextbyxvalue("//input[@aria-owns='hotelHAAgentAccountName_listbox']", Agentincentive);
		Thread.sleep(100);
		wm.Listandenter("//*[@id='hotelHAAgentAccountName_listbox']/li", Commonindex);
		Thread.sleep(200);

		
		wm.clickbyxpath("//*[@id='AgentIncentiveDiv']/div/div[1]/div[1]/a/i");
		Thread.sleep(500);

		wm.Listandenter("//span[@class='k-icon k-i-add']", "2");
		Thread.sleep(500);
		
		wm.Listandenter("//button[@id='ConformationYes']", "0");
		
		//enter the uccf detailss
		
		//selecte the UCCF  options
		wm.clickbyxpath("//span[@aria-owns='MiscFOPModeKey_listbox']");		
		Thread.sleep(200);
		wm.Listandenter("//*[@id='MiscFOPModeKey_listbox']/li", Modeindex);
		Thread.sleep(900);
		
		//selected the branch
		
		wm.clickbyxpath("//*[@id='FOPPaymentDetails']/div[1]/div/div/span[1]/span/span[2]/span");
		Thread.sleep(600);

		//approvalnumber
		wm.sendtextbycssselecotrwithoutclear("#fApprovenum", ""+fApprovenum);
		
//expirydate
		wm.sendtextbycssselecotr("#fcardDate", "" + fcardDate1 + "/" + fcardDate3);
//cardnumber
		wm.sendtextbycssselecotrwithoutclear("#fcardnum", ""+fcardnum);
		
		
		wm.clickbyxpath("//span[@aria-owns='ucardtype_listbox']");
		Thread.sleep(200);
		wm.sendtextbyxvalue("//input[@aria-owns='ucardtype_listbox']", Cardtypedetails);
		Thread.sleep(500);
		wm.Listandenter("//*[@id='ucardtype_listbox']/li", Commonindex);
		Thread.sleep(200);
		
		
		/*wm.Listnegativescearios("//*[@id='AddressTypeKey_listbox']/li", Commonindex, 
				"Newly created AddresstypeName reflected in Address type field  \n Enter input as"  +  AddresstypeName, 
				"Newly created AddresstypeName not reflected in Address type field  \n Enter input as"  + AddresstypeName);
		Thread.sleep(500);*/

		
		//wm.Listandenter("//*[@id='fbbranch_listbox']/li",Selectedbranch);
		Thread.sleep(300);
		wm.doubleclickusingxpath("//span[@class='k-icon k-i-check']");
		
		
		
		wm.clickbyxpath("//span[@class='k-icon k-i-check']");
		Thread.sleep(900);

		
	//Amount calcualtion checking 
//=============================================================================

wm.Netcollections("//input[@name='hoteltfdBaseFare']", "//input[@name='TotalTaxAmount']",
		"//input[@name='TotalServiceFee']", "//input[@name='TotalDiscount']", " //input[@name='TotOutputVat']", 
		"//input[@name='Amt_NetCollection']", "Net calclaiton done correectly", "Net calclaiton not done correectly");


wm.Publishedfare("//input[@name='hoteltfdBaseFare']", "//input[@name='TotalTaxAmount']", 
		"//input[@name='salestotcommm']"
		,"//input[@name='TotInputVat']", "//input[@name='Amt_NetPayable']", "Net payable Calclated successfuly", 
		"Net payable not Calclated successfuly");


wm.Hotelnetcalculationchargesusingcancelationcharges("//input[@name='hoteltfdBaseFare']", "//input[@name='TotalTaxAmount']"
		,"//input[@name='TotalServiceFee']", "//input[@name='TotalDiscount']", "//input[@name='TotOutputVat']", 
		"//input[@name='Amt_NetCollection']", "//*[@id='hoteltfdSupplierCancelCharge']", 
		"//*[@id='AG_INPVAT']","Net calclaiton done correectly uisng cancellation charges", 
		"Net calclaiton not done correectly uisng cancellation charges");


wm.Publishedfareusingcancelaltionchargeswithoutuccf("//input[@name='hoteltfdBaseFare']", "//input[@name='TotalTaxAmount']"
		, "//input[@name='salestotcommm']", "//*[@id='AG_INPVAT']", 
		"//input[@name='TotInputVat']", "//input[@name='Amt_NetPayable']",
		"Net payable Calclated successfuly done uisng cancellaiton charges", 
		"Net payable Calclated not successfuly done uisng cancellaiton charges");

		
		
//===================================================================
		
		
		
		wm.clickbyxpath("//button[@id='btnhotelsave']");
	
		//Enter the udid details 
		
//wm.clickbyxpath("//*[@id='testData']/i");

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
		wm.clickbyxpath("//button[@id='btnhotelsave']");
		Thread.sleep(500);
			
		wm.Mousemoveover("//input[@name='hotelProviderKey_input']");
		Thread.sleep(200);
		wm.Listnegativescearios(utility.Constant.Travelogixuitooltipvalidation, "0",
				"Pass : Sales Refund hotel  created successfuly" + "",
				"Fail:  Sales Refund hotel  not created successfuly " + "");
	

	}

	@AfterMethod
	public void close()

	{
		wm.close();

	}

	@DataProvider(name = "dp")
	public Object[][] dp() throws IOException {

		return Wrappermethods.getSheet("Hotelbookinguccf", "Hotelbookinguccf");

	}
}