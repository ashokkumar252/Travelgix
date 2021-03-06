package Copytickectverifications;
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
public class Carcopytickect
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
	public void Carcopytickect(String Username, String Password, String Leftsidemenu, String ActiveFrom1,
			String ActiveFrom2, String ActiveFrom3, String Docktype, String Docktypeindex, String Salesbracnh,
			String Salesbracnhindex, String Customer, String Customerindex, String Leadpaxnamee,
			String dktClientReference, String Tickectstatusindex,

			String PayableAgent, String CcvdAdult, String CcvdChild, String Bookingexecutive, String Salesexecutive,
			String CcvdtktDate1, String CcvdtktDate2, String CcvdtktDate3, String Commonindex, String CcvdBookingDate1,
			String CcvdBookingDate2, String CcvdBookingDate3, String Bookingpcc, String Issuedpcc, String CtfdHighFare,
			String CtfdLowFare, String CtfdReasonCode,

			String City, String Cartype, String Carchain, String Pickupplace, String Dropoffplace,
			String CcvdPickupTime1, String CcvdPickupTime2, String CcvdPickupTime3, String CcvdDropoffTime1,
			String CcvdDropoffTime2, String CcvdDropoffTime3, String CcvdNotNoOfCars, String CcvdBookingReference,
			String CcvdConfirmationNumber, String Remarks, String Processtype, String Currency, String CtfdCarRate,
			String CtfdBaseFare, String Lodgecard, String AatAmount, String CscBaseAmount, String Servicecharge,
			String CtfdCommPercent1, String CtfdCommPercent2, String CtfdDiscPercent1, String Agentincentive,

			String ProjectNumberAP, String DepartmentAP, String MajorClassAP, String TravelStatusAP,
			String TotalSavingCodeAP, String GroupTravelIndicatorAP, String TourCodeAP, String EndorsementRestrictAP,
			String FareCalculationAreaAP, String IntlSalesIndicatorAP, String Customerdetails,
			String Carcopytickect) throws Exception

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

		wm.Listandenter("//i[@class='fa fa-chevron-down']", "2");
		Thread.sleep(200);
		wm.Listandenter("//i[@class='fa fa-plus']", "2");
		Thread.sleep(2500);

		
//==================================

		//copy tickect number 
				
		wm.sendtextbyxvalue("//input[@onchange='onCarCopyTicketChange(this)']", Carcopytickect);
		Thread.sleep(300);
		wm.stabbyxpath("//input[@onchange='onCarCopyTicketChange(this)']");
		Thread.sleep(600);
		wm.clickbyxpath("//button[@id='ConformationYes']");
		wm.sleep();

		
		
//=====================================
		// Enter the cardetailss

		// Payableagent
		/*wm.sendtextbyxvalue("//input[@aria-owns='CcvdProviderKey_listbox']", PayableAgent);
		Thread.sleep(120);
		wm.Listandenter("//*[@id='CcvdProviderKey_listbox']/li", Commonindex);
		Thread.sleep(200);
*/

wm.Verifythealertpopupmessagesusincontainsusinggetattribute("//input[@aria-owns='CcvdProviderKey_listbox']"
	    		,PayableAgent, "PayableAgent status  details retrived successfuly", 
	    		"PayableAgent status  not retrived successfuly");


		// enter the adulta nchild
/*		wm.sendtextbycssselecotrwithoutclear("#CcvdAdult", "" + CcvdAdult);
		wm.sendtextbycssselecotrwithoutclear("#CcvdChild", "" + CcvdChild);
*/

wm.Verifythealertpopupmessagesusincontainsusinggetattribute("//input[@name='CcvdAdult']"
	    		,CcvdAdult, "CcvdAdult status  details retrived successfuly", 
	    		"CcvdAdult status  not retrived successfuly");

wm.Verifythealertpopupmessagesusincontainsusinggetattribute("//input[@name='CcvdChild']"
	    		,CcvdChild, "CcvdAdult status  details retrived successfuly", 
	    		"CcvdChild status  not retrived successfuly");
		

		// booking executivee
		/*wm.sendtextbyxvalue("//input[@aria-owns='CcvdBookingUserName_listbox']", Bookingexecutive);
		Thread.sleep(120);
		wm.Listandenter("//*[@id='CcvdBookingUserName_listbox']/li", Commonindex);
		Thread.sleep(200);
		*/
		wm.Verifythealertpopupmessagesequal("//input[@name='CcvdBookingUserName_input']"
	    		,Bookingexecutive, "Bookingexecutive status  details retrived successfuly", 
	    		"Bookingexecutive status  not retrived successfuly");

	/*	
		// booking executivee
		wm.sendtextbyxvalue("//input[@aria-owns='CcvdBookingUserName_listbox']", Bookingexecutive);
		Thread.sleep(120);
		wm.Listandenter("//*[@id='CcvdBookingUserName_listbox']/li", Commonindex);
		Thread.sleep(200);
*/
		
		
		// salesexecutive
/*		wm.sendtextbyxvalue("//input[@aria-owns='CcvdSalesExecutiveName_listbox']", Salesexecutive);
		Thread.sleep(120);
		wm.Listandenter("//*[@id='CcvdSalesExecutiveName_listbox']/li", Commonindex);
		Thread.sleep(200);
*/		
		
		wm.Verifythealertpopupmessagesequal("//input[@name='CcvdSalesExecutiveName_input']"
	    		,Salesexecutive, "Salesexecutive status  details retrived successfuly", 
	    		"Salesexecutive status not retrived successfuly");


		// enter theslaedate

		//wm.sendtextbycssselecotr("#CcvdtktDate", "" + CcvdtktDate1 + "-" + CcvdtktDate2 + "-" + CcvdtktDate3);

		// Enter other details

		// Bookingdate

/*		wm.sendtextbycssselecotr("#CcvdBookingDate",
				"" + CcvdBookingDate1 + "-" + CcvdBookingDate2 + "-" + CcvdBookingDate3);
		Thread.sleep(200);
*/
		// Bookingpcc
		/*wm.sendtextbyxvalue("//input[@aria-owns='CcvdBookingPcc_listbox']", Bookingpcc);
		Thread.sleep(120);
		wm.Listandenter("//*[@id='CcvdBookingPcc_listbox']/li", Commonindex);
		Thread.sleep(200);
*/

		
wm.Verifythealertpopupmessagesusincontainsusinggetattribute("//input[@aria-owns='CcvdBookingPcc_listbox']"
	    		,Bookingpcc, "Bookingpcc status  details retrived successfuly", 
	    		"Bookingpcc status not retrived successfuly");

		
		// issuedpcc
/*		wm.sendtextbyxvalue("//input[@aria-owns='CcvdIssuingPcc_listbox']", Issuedpcc);
		Thread.sleep(120);
		wm.Listandenter("//*[@id='CcvdIssuingPcc_listbox']/li", Commonindex);
		Thread.sleep(200);
*/
		

wm.Verifythealertpopupmessagesusincontainsusinggetattribute("//input[@aria-owns='CcvdIssuingPcc_listbox']"
	    		,Issuedpcc, "Issuedpcc status  details retrived successfuly", 
	    		"Issuedpcc status not retrived successfuly");


		// highfare
		wm.sendtextbycssselecotrwithoutclear("#CtfdHighFare", "" + CtfdHighFare);
		Thread.sleep(12);
		// lowfare
		wm.sendtextbycssselecotrwithoutclear("#CtfdLowFare", "" + CtfdLowFare);
		Thread.sleep(12);
		wm.sendtextbycssselecotrwithoutclear("#CtfdReasonCode", "" + CtfdReasonCode);
		Thread.sleep(200);

	//============
		
wm.clickbyxpath("//*[@id='div_Car_Header_Details']/div[3]/div/div[1]/div[1]/a/i");
Thread.sleep(500);


		// Servicedetails
		/*wm.sendtextbyxvalue("//input[@aria-owns='CcvdCityName_listbox']", City);
		Thread.sleep(50);
		wm.Listandenter("//*[@id='CcvdCityName_listbox']/li", Commonindex);
		Thread.sleep(90);
*/

wm.Verifythealertpopupmessagesusincontainsusinggetattribute("//input[@aria-owns='CcvdCityName_listbox']"
	    		,City, "City details retrived successfuly", 
	    		"City details not retrived successfuly");
		

		// cartypee
		/*wm.sendtextbyxvalue("//input[@aria-owns='CcvdCarTypeKey_listbox']", Cartype);
		Thread.sleep(50);
		wm.Listandenter("//*[@id='CcvdCarTypeKey_listbox']/li", Commonindex);
		Thread.sleep(90);
*/
wm.Verifythealertpopupmessagesusincontainsusinggetattribute("//input[@aria-owns='CcvdCarTypeKey_listbox']"
	    		,Cartype, "Cartype details retrived successfuly", 
	    		"Cartype details not retrived successfuly");

		
		
		// carchain

/*		wm.sendtextbyxvalue("//input[@aria-owns='CcvdCarChainKey_listbox']", Carchain);
		Thread.sleep(50);
		wm.Listandenter("//*[@id='CcvdCarChainKey_listbox']/li", Commonindex);
		Thread.sleep(90);
*/		
		wm.Verifythealertpopupmessagesusincontainsusinggetattribute("//input[@aria-owns='CcvdCarChainKey_listbox']"
	    		,Carchain, "Carchain details retrived successfuly", 
	    		"Carchain details not retrived successfuly");

/*
		// pickupplace
		wm.sendtextbyxvalue("//input[@aria-owns='CcvdPickupPlace_listbox']", Pickupplace);
		Thread.sleep(50);
		wm.Listandenter("//*[@id='CcvdPickupPlace_listbox']/li", Commonindex);
		Thread.sleep(90);

		// Dropofplace
		wm.sendtextbyxvalue("//input[@aria-owns='CcvdDropoffPlace_listbox']", Dropoffplace);
		Thread.sleep(50);
		wm.Listandenter("//*[@id='CcvdDropoffPlace_listbox']/li", Commonindex);
		Thread.sleep(90);
*/
		// pickupateandtimee

/*		wm.sendtextbycssselecotr("#CcvdPickupTime",
				"" + CcvdPickupTime1 + "-" + CcvdPickupTime2 + "-" + CcvdPickupTime3 + " " + "00:00");
		// wm.sendtextbycssselecotrwithoutclear("#CcvdPickupTime", "00:00");

		Thread.sleep(50);

		wm.sendtextbycssselecotr("#CcvdDropoffTime",
				"" + CcvdDropoffTime1 + "-" + CcvdDropoffTime2 + "-" + CcvdDropoffTime3 + " " + "00:00");
		// wm.sendtextbycssselecotrwithoutclear("#CcvdDropoffTime", "00:00");
*/
		Thread.sleep(50);
		// no of unites
		/*wm.sendtextbycssselecotrwithoutclear("#CcvdNotNoOfCars", CcvdNotNoOfCars);
		Thread.sleep(90);
		wm.stabbyxpath("//*[@id='CcvdNotNoOfCars']");
		Thread.sleep(90);
		
		wm.sendtextbycssselecotrwithoutclear("#CcvdBookingReference", CcvdBookingReference);
		*/
		
		wm.Verifythealertpopupmessagesusincontainsusinggetattribute("//input[@name='CcvdBookingReference']"
	    		,CcvdBookingReference, "CcvdBookingReference details retrived successfuly", 
	    		"CcvdBookingReference details not retrived successfuly");

		
	//	wm.sendtextbycssselecotrwithoutclear("#CcvdConfirmationNumber", CcvdConfirmationNumber);
		
		wm.Verifythealertpopupmessagesusincontainsusinggetattribute("//input[@name='CcvdConfirmationNumber']"
	    		,CcvdConfirmationNumber, "CcvdConfirmationNumber details retrived successfuly", 
	    		"CcvdConfirmationNumber details not retrived successfuly");

	/*	
		
		wm.sendtextbycssselecotrwithoutclear("#Remarks", Remarks);
		Thread.sleep(900);

		wm.clickbyxpath("//*[@id='div_Car_Header_Details']/div[3]/div/div[1]/div[1]/a/i");
		Thread.sleep(500);

		// Faredetails

		// enter the Fare details

		Thread.sleep(900);

		// procee typee
		wm.sendtextbyxvalue("//input[@aria-owns='CtfdProcessTypeKey_listbox']", Processtype);
		Thread.sleep(50);
		wm.Listandenter("//*[@id='CtfdProcessTypeKey_listbox']/li", Commonindex);
		Thread.sleep(200);

		// Currency
		wm.sendtextbyxvalue("//input[@aria-owns='CtfdTransCurrency_listbox']", Currency);
		Thread.sleep(50);
		wm.Listandenter("//*[@id='CtfdTransCurrency_listbox']/li", Commonindex);
		Thread.sleep(200);

		// roomrate

		wm.stabbyxpath("//input[@aria-owns='DealCodeDesc_listbox']");
		Thread.sleep(90);

		wm.Deletedefaultvaluesinthetextbox("//input[@name='CtfdCarRate']");
		Thread.sleep(400);

		wm.sendtextbycssselecotrwithoutclear("#CtfdCarRate", "" + CtfdCarRate);
		Thread.sleep(400);
		// wm.sendtextbycssselecotrwithoutclear("#CtfdBaseFare",
		// ""+CtfdBaseFare);
		Thread.sleep(200);

		// logigcard
		wm.sendtextbyxvalue("//input[@aria-owns='CtfdOwnLodgeCardKey_listbox']", Lodgecard);
		Thread.sleep(50);
		wm.Listandenter("//*[@id='CtfdOwnLodgeCardKey_listbox']/li", Commonindex);
		Thread.sleep(200);

		wm.stabbyxpath("//input[@aria-owns='CtfdOwnLodgeCardKey_listbox']");
		Thread.sleep(200);

		
		 * wm.clickbyxpath(
		 * "//*[@id='div_Car_Header_Details']/div[4]/div/div[1]/div[1]/a/i");
		 * Thread.sleep(500);
		 

		// Enter the taxdetails

		wm.Listandenter("//span[@class='k-icon k-i-add']", "0");
		Thread.sleep(500);

		wm.stabbyxpath(" //span[@class='k-icon k-i-cancel']");
		Thread.sleep(200);

		// taxcodee

		wm.clickbyxpath("//span[@aria-owns='AatCode_listbox']");
		Thread.sleep(50);
		wm.Listandenter("//*[@id='AatCode_listbox']/li", Commonindex);
		Thread.sleep(200);

		wm.sendtextbycssselecotrwithoutclear("#AatAmount", "" + AatAmount);
		Thread.sleep(200);
		wm.clickbyxpath("//span[@class='k-icon k-i-check']");
		Thread.sleep(200);

		// enter the details in service fee

		wm.Listandenter("//span[@class='k-icon k-i-add']", "1");
		Thread.sleep(500);

		// servicecarge
		wm.sendtextbyxvalue("//input[@aria-owns='CscServiceChargeId_listbox']", Servicecharge);

		// wm.clickbyxpath("//span[@aria-owns='CscServiceChargeId_listbox']");
		Thread.sleep(200);
		wm.Listandenter("//*[@id='CscServiceChargeId_listbox']/li", Commonindex);
		Thread.sleep(500);
		wm.stabbyxpath("//input[@aria-owns='CscServiceChargeId_listbox']");
		Thread.sleep(200);

		wm.sendtextbycssselecotr("#CscBaseAmount", "" + CscBaseAmount);
		Thread.sleep(200);

		wm.clickbyxpath("//span[@class='k-icon k-i-check']");
		Thread.sleep(200);

		wm.clickbyxpath("//*[@id='div_Car_Header_Details']/div[4]/div/div[1]/div[1]/a/i");

		// Enter the commissiondetals

		Thread.sleep(200);

		wm.sendtextbycssselecotr("#CtfdCommPercent1", ""+CtfdCommPercent1);
		wm.sendtextbycssselecotr("#CtfdCommPercent2", ""+CtfdCommPercent2);
		wm.sendtextbycssselecotr("#CtfdDiscPercent1", ""+CtfdDiscPercent1);
		Thread.sleep(500);
		wm.clickbyxpath("//*[@id='div_Car_Header_Details']/div[5]/div/div[1]/div[1]/a/i");

		// Enter the agent incetives

		// Agent incentivee

		wm.sendtextbyxvalue("//input[@aria-owns='CtscPaybackParnerName_listbox']", Agentincentive);
		Thread.sleep(100);
		wm.Listandenter("//*[@id='CtscPaybackParnerName_listbox']/li", Commonindex);
		Thread.sleep(500);

		wm.clickbyxpath("//*[@id='AgentIncentiveDiv']/div/div[1]/div[1]/a/i");
		Thread.sleep(500);

		// select the fop window

		wm.Listandenter("//span[@class='k-icon k-i-add']", "2");
		Thread.sleep(500);

		wm.findbyelementbyxpathandclick("//button[@id='ConformationYes']");
		Thread.sleep(900);

		wm.clickbyxpath("//span[@class='k-icon k-i-check']");
		Thread.sleep(900);
		wm.clickbyxpath("//*[@id='testData']/i");
		Thread.sleep(500);

		wm.clickbyxpath("//button[@id='btncarsave']");

		Thread.sleep(500);

		
		 * wm.findbyelementbyxpathandclick("//button[@id='ConformationYes']");
		 * Thread.sleep(900);
		 

		// ======================================================================

		// Enter the udid details

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
		Thread.sleep(200);
		wm.clickbyxpath("//span[@aria-owns='Booking_Type_AP_listbox']");
		Thread.sleep(200);
		wm.Listandenter("//*[@id='Booking_Type_AP_listbox']/li", Commonindex);
		Thread.sleep(200);

		wm.findelementandsendtextbycss("#Intl_Sales_Indicator_AP", IntlSalesIndicatorAP);
		Thread.sleep(200);
		wm.findbyelementbyxpathandclick("//button[@id='btncarsave']");
		Thread.sleep(50);

		Thread.sleep(16000);
*/
	}

	@AfterMethod
	public void close()

	{
		wm.close();

	}

	@DataProvider(name = "dp")
	public Object[][] dp() throws IOException {

		return Wrappermethods.getSheet("CarPositivecredit", "CarPositivecredit");

	}
}