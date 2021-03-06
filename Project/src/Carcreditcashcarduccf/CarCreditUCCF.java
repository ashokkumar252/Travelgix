package Carcreditcashcarduccf;
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
public class CarCreditUCCF {
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
	public void Carbookinguccf(String Username, String Password, String Leftsidemenu, String ActiveFrom1,
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
			String FareCalculationAreaAP, String IntlSalesIndicatorAP, String Customerdetails, String Carcopytickect,
			String Modeindex, String fApprovenum, String fcardDate1, String fcardDate3, String fcardnum,
			String Cardtypedetails,String Fopdivide) throws Exception

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
		Thread.sleep(90);
		wm.Listandenter("//*[@id='dktDocTypeCode_listbox']/li", Docktypeindex);
		Thread.sleep(200);

		// Salesbranch
		wm.sendtextbyxvalue("//input[@aria-owns='DktBranchKey_listbox']", Salesbracnh);
		Thread.sleep(90);
		wm.Listandenter("//*[@id='DktBranchKey_listbox']/li", Salesbracnhindex);
		Thread.sleep(200);

		// customerr
		wm.sendtextbyxvalue("//input[@aria-owns='DktPartnername_listbox']", Customer);
		Thread.sleep(90);
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

		// Enter the cardetailss

		// Payableagent
		wm.sendtextbyxvalue("//input[@aria-owns='CcvdProviderKey_listbox']", PayableAgent);
		Thread.sleep(150);
		wm.Listandenter("//*[@id='CcvdProviderKey_listbox']/li", Commonindex);
		Thread.sleep(200);

		// enter the adulta nchild
		wm.sendtextbycssselecotrwithoutclear("#CcvdAdult", "" + CcvdAdult);
		wm.sendtextbycssselecotrwithoutclear("#CcvdChild", "" + CcvdChild);

		// booking executivee
		wm.sendtextbyxvalue("//input[@aria-owns='CcvdBookingUserName_listbox']", Bookingexecutive);
		Thread.sleep(150);
		wm.Listandenter("//*[@id='CcvdBookingUserName_listbox']/li", Commonindex);
		Thread.sleep(200);

		// booking executivee
		wm.sendtextbyxvalue("//input[@aria-owns='CcvdBookingUserName_listbox']", Bookingexecutive);
		Thread.sleep(120);
		wm.Listandenter("//*[@id='CcvdBookingUserName_listbox']/li", Commonindex);
		Thread.sleep(200);

		// salesexecutive
		wm.sendtextbyxvalue("//input[@aria-owns='CcvdSalesExecutiveName_listbox']", Salesexecutive);
		Thread.sleep(120);
		wm.Listandenter("//*[@id='CcvdSalesExecutiveName_listbox']/li", Commonindex);
		Thread.sleep(200);

		// enter theslaedate

		wm.sendtextbycssselecotr("#CcvdtktDate", "" + CcvdtktDate1 + "-" + CcvdtktDate2 + "-" + CcvdtktDate3);

		// Enter other details

		// Bookingdate

		wm.sendtextbycssselecotr("#CcvdBookingDate",
				"" + CcvdBookingDate1 + "-" + CcvdBookingDate2 + "-" + CcvdBookingDate3);
		Thread.sleep(200);

		// Bookingpcc
		wm.sendtextbyxvalue("//input[@aria-owns='CcvdBookingPcc_listbox']", Bookingpcc);
		Thread.sleep(120);
		wm.Listandenter("//*[@id='CcvdBookingPcc_listbox']/li", Commonindex);
		Thread.sleep(200);

		// issuedpcc
		wm.sendtextbyxvalue("//input[@aria-owns='CcvdIssuingPcc_listbox']", Issuedpcc);
		Thread.sleep(120);
		wm.Listandenter("//*[@id='CcvdIssuingPcc_listbox']/li", Commonindex);
		Thread.sleep(200);

		// highfare
		wm.sendtextbycssselecotrwithoutclear("#CtfdHighFare", "" + CtfdHighFare);
		Thread.sleep(90);
		// lowfare
		wm.sendtextbycssselecotrwithoutclear("#CtfdLowFare", "" + CtfdLowFare);
		Thread.sleep(90);
		wm.sendtextbycssselecotrwithoutclear("#CtfdReasonCode", "" + CtfdReasonCode);
		Thread.sleep(200);

		// Servicedetails
		wm.sendtextbyxvalue("//input[@aria-owns='CcvdCityName_listbox']", City);
		Thread.sleep(50);
		wm.Listandenter("//*[@id='CcvdCityName_listbox']/li", Commonindex);
		Thread.sleep(90);

		// cartypee
		wm.sendtextbyxvalue("//input[@aria-owns='CcvdCarTypeKey_listbox']", Cartype);
		Thread.sleep(50);
		wm.Listandenter("//*[@id='CcvdCarTypeKey_listbox']/li", Commonindex);
		Thread.sleep(90);

		// carchain
		wm.sendtextbyxvalue("//input[@aria-owns='CcvdCarChainKey_listbox']", Carchain);
		Thread.sleep(50);
		wm.Listandenter("//*[@id='CcvdCarChainKey_listbox']/li", Commonindex);
		Thread.sleep(90);

		// pickupplace
		wm.sendtextbyxvalue("//input[@aria-owns='CcvdPickupPlace_listbox']", Pickupplace);
		Thread.sleep(90);
		wm.Listandenter("//*[@id='CcvdPickupPlace_listbox']/li", Commonindex);
		Thread.sleep(90);

		// Dropofplace
		wm.sendtextbyxvalue("//input[@aria-owns='CcvdDropoffPlace_listbox']", Dropoffplace);
		Thread.sleep(90);
		wm.Listandenter("//*[@id='CcvdDropoffPlace_listbox']/li", Commonindex);
		Thread.sleep(90);

		// pickupateandtimee

		wm.sendtextbycssselecotr("#CcvdPickupTime",
				"" + CcvdPickupTime1 + "-" + CcvdPickupTime2 + "-" + CcvdPickupTime3 + " " + "00:00");
		// wm.sendtextbycssselecotrwithoutclear("#CcvdPickupTime", "00:00");

		Thread.sleep(90);

		wm.sendtextbycssselecotr("#CcvdDropoffTime",
				"" + CcvdDropoffTime1 + "-" + CcvdDropoffTime2 + "-" + CcvdDropoffTime3 + " " + "00:00");
		// wm.sendtextbycssselecotrwithoutclear("#CcvdDropoffTime", "00:00");

		Thread.sleep(90);
		// no of unites
		wm.sendtextbycssselecotrwithoutclear("#CcvdNotNoOfCars", CcvdNotNoOfCars);
		Thread.sleep(90);
		wm.stabbyxpath("//*[@id='CcvdNotNoOfCars']");
		Thread.sleep(90);
		wm.sendtextbycssselecotrwithoutclear("#CcvdBookingReference", CcvdBookingReference);
		wm.sendtextbycssselecotrwithoutclear("#CcvdConfirmationNumber", CcvdConfirmationNumber);
		wm.sendtextbycssselecotrwithoutclear("#Remarks", Remarks);
		Thread.sleep(900);

		wm.clickbyxpath("//*[@id='div_Car_Header_Details']/div[3]/div/div[1]/div[1]/a/i");
		Thread.sleep(500);

		// Faredetails

		// enter the Fare details

		Thread.sleep(900);

		// procee typee
		wm.sendtextbyxvalue("//input[@aria-owns='CtfdProcessTypeKey_listbox']", Processtype);
		Thread.sleep(90);
		wm.Listandenter("//*[@id='CtfdProcessTypeKey_listbox']/li", Commonindex);
		Thread.sleep(200);

		// Currency
		wm.sendtextbyxvalue("//input[@aria-owns='CtfdTransCurrency_listbox']", Currency);
		Thread.sleep(90);
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
		Thread.sleep(90);
		wm.Listandenter("//*[@id='CtfdOwnLodgeCardKey_listbox']/li", Commonindex);
		Thread.sleep(200);

		wm.stabbyxpath("//input[@aria-owns='CtfdOwnLodgeCardKey_listbox']");
		Thread.sleep(200);

		/*
		 * wm.clickbyxpath(
		 * "//*[@id='div_Car_Header_Details']/div[4]/div/div[1]/div[1]/a/i");
		 * Thread.sleep(500);
		 */

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

		// taxcodee

		// Enter the taxdetails

		wm.Listandenter("//span[@class='k-icon k-i-add']", "0");
		Thread.sleep(500);

		wm.stabbyxpath(" //span[@class='k-icon k-i-cancel']");
		Thread.sleep(200);

		wm.clickbyxpath("//span[@aria-owns='AatCode_listbox']");
		Thread.sleep(50);
		wm.Listandenter("//*[@id='AatCode_listbox']/li", Commonindex);
		Thread.sleep(200);

		wm.sendtextbycssselecotrwithoutclear("#AatAmount", "" + AatAmount);
		Thread.sleep(200);
		wm.stabbyxpath("//input[@name='AatAmount']");
		Thread.sleep(200);

		wm.clickbyxpath("//span[@class='k-icon k-i-check']");
		Thread.sleep(200);

		// wm.clickbyxpath("//*[@id='div_Car_Header_Details']/div[4]/div/div[1]/div[1]/a/i");

		// Enter the commissiondetals

		Thread.sleep(200);

		wm.Selectallbycsspath("#CtfdCommPercent1");
		wm.sendtextbycssselecotrwithoutclear("#CtfdCommPercent1", "" + CtfdCommPercent1);
		wm.Selectallbycsspath("#CtfdCommPercent2");
		wm.sendtextbycssselecotrwithoutclear("#CtfdCommPercent2", "" + CtfdCommPercent2);
		wm.Selectallbycsspath("#CtfdDiscPercent1");
		wm.sendtextbycssselecotrwithoutclear("#CtfdDiscPercent1", "" + CtfdDiscPercent1);
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

		// selected the uccf

		wm.Listandenter("//span[@class='k-icon k-i-add']", "2");
		Thread.sleep(500);

		wm.Listandenter("//button[@id='ConformationYes']", "0");

		// wm.findbyelementbyxpathandclick("//button[@id='ConformationYes']");
		Thread.sleep(900);

		// ==============================================================================
		wm.clickbyxpath("//span[@aria-owns='MiscFOPModeKey_listbox']");

		Thread.sleep(200);
		wm.Listandenter("//*[@id='MiscFOPModeKey_listbox']/li", Modeindex);
		Thread.sleep(900);


		wm.Totalamountdividebypercentage("//input[@name='MiscFOPAmount']",Fopdivide,
				"Select  Fop amount divide and enter the values"
				, "Select  Fop amount not divide and enter the values");
		Thread.sleep(500);



		
		// selected the branch

		wm.clickbyxpath("//*[@id='FOPPaymentDetails']/div[1]/div/div/span[1]/span/span[2]/span");
		Thread.sleep(600);

		// approvalnumber
		wm.sendtextbycssselecotrwithoutclear("#fApprovenum", "" + fApprovenum);

		// expirydate
		wm.sendtextbycssselecotr("#fcardDate", "" + fcardDate1 + "/" + fcardDate3);
		// cardnumber
		wm.sendtextbycssselecotrwithoutclear("#fcardnum", "" + fcardnum);

		wm.clickbyxpath("//span[@aria-owns='ucardtype_listbox']");
		Thread.sleep(200);
		wm.sendtextbyxvalue("//input[@aria-owns='ucardtype_listbox']", Cardtypedetails);
		Thread.sleep(500);
		wm.Listandenter("//*[@id='ucardtype_listbox']/li", Commonindex);
		Thread.sleep(200);

		// ================================================================================

		wm.doubleclickusingxpath("//span[@class='k-icon k-i-check']");

		Thread.sleep(500);

		// Selected the credit

		wm.Listandenter("//span[@class='k-icon k-i-add']", "2");
		Thread.sleep(500);

		wm.Listandenter("//button[@id='ConformationYes']", "0");
		Thread.sleep(200);

		wm.doubleclickusingxpath("//span[@class='k-icon k-i-check']");
		Thread.sleep(500);

		/*
		 * wm.comparetwovalues1to1("//input[@name='AirFopAmount']" ,
		 * "//input[@name='Amt_NetCollection']",
		 * "Pass: FOP and total amount matches successfully" ,
		 * " Fail: FOP and total amount not matches successfully");
		 */
		Thread.sleep(200);
		/*
		 * wm.Netcollections("//input[@name='CtfdBaseFare']",
		 * "//input[@name='TotalTaxAmount']",
		 * "//input[@name='TotalServiceFee']", "//input[@name='TotalDiscount']",
		 * " //input[@name='TotOutputVat']",
		 * "//input[@name='Amt_NetCollection']",
		 * "Net calclaiton done correectly",
		 * "Net calclaiton not done correectly");
		 * 
		 * 
		 * wm.Publishedfare("//input[@name='CtfdBaseFare']",
		 * "//input[@name='TotalTaxAmount']", "//input[@name='salestotcommm']"
		 * ,"//input[@name='TotInputVat']", "//input[@name='Amt_NetPayable']",
		 * "Net payable Calclated successfuly",
		 * "Net payable not Calclated successfuly");
		 */

		wm.Netcollectionuisngcancellatiocharges("//input[@name='CtfdBaseFare']", "//input[@name='TotalTaxAmount']",
				"//input[@name='TotalServiceFee']", "//input[@name='TotalDiscount']", "//input[@name='TotOutputVat']",
				"//input[@name='Amt_NetCollection']", "//input[@name='CtfdAgentCancelCharge']",
				"//input[@name='CtfdSupplierCancelCharge']",
				"Net calclaiton done correectly using cancelaltion charges",
				"Net calclaiton not done correectly using cancelaltion charges");

		wm.Publishedfareusingcancelaltionchargeswithoutuccf("//input[@name='CtfdBaseFare']",
				"//input[@name='TotalTaxAmount']", "//input[@name='salestotcommm']",
				"//input[@name='CtfdSupplierCancelCharge']", "//input[@name='TotInputVat']",
				"//input[@name='Amt_NetPayable']", "payable calculation done successfuly using cancellation charges",
				"payable calculation not done successfuly using cancellation charges");

		wm.clickbyxpath("//*[@id='testData']/i");
		Thread.sleep(500);

		wm.clickbyxpath("//button[@id='btncarsave']");

		Thread.sleep(500);

		wm.Listandenterquick("//span[contains(text(),'OK')]", "0");
		wm.Listandenterquick("//span[contains(text(),'OK')]", "1");
		wm.Listandenterquick("//span[contains(text(),'OK')]", "2");
		wm.Listandenterquick("//span[contains(text(),'OK')]", "3");
		Thread.sleep(200);

		/*
		 * wm.findbyelementbyxpathandclick("//button[@id='ConformationYes']");
		 * Thread.sleep(900);
		 */

		// ======================================================================

		// Enter the udid details

		wm.Listandenterthevaluesinvisblexpath("//input[@name='Travel_Status_DN']", DepartmentAP);
		// Thread.sleep(50);
		wm.Listandenterthevaluesinvisblexpath("//*[@name='Project_Number_AP']", ProjectNumberAP);
		// Thread.sleep(50);
		wm.Listandenterthevaluesinvisblexpath("//*[@name='Department_AP']", DepartmentAP);
		// Thread.sleep(50);
		wm.Listandenterthevaluesinvisblexpath("//input[@name='Major_Class_AP']", MajorClassAP);
		// Thread.sleep(50);

		wm.Listandenterthevaluesinvisblexpath("//input[@name='Travel_Status_AP']", TravelStatusAP);
		// Thread.sleep(50);
		wm.Listandenterthevaluesinvisblexpath("//input[@name='Total_Saving_Code_AP']", TotalSavingCodeAP);
		// Thread.sleep(50);
		wm.Listandenterthevaluesinvisblexpath("//input[@name='Group_Travel_Indicator_AP']", GroupTravelIndicatorAP);
		// Thread.sleep(50);
		wm.Listandenterthevaluesinvisblexpath("//input[@name='Tour_Code_AP']", TourCodeAP);
		// Thread.sleep(50);
		wm.Listandenterthevaluesinvisblexpath("//input[@name='Endorsement_Restrict_AP']", EndorsementRestrictAP);
		// Thread.sleep(50);
		wm.Listandenterthevaluesinvisblexpath("//input[@name='Fare_Calculation_Area_AP']", FareCalculationAreaAP);
		// Thread.sleep(200);

		wm.Listandenter("//span[@aria-owns='Booking_Type_AP_listbox']", "0");

		Thread.sleep(200);

		wm.Listandenter("//*[@id='Booking_Type_AP_listbox']/li", Commonindex);
		Thread.sleep(200);

		wm.Listandenterthevaluesinvisblexpath("//input[@name='Intl_Sales_Indicator_AP']", IntlSalesIndicatorAP);
		Thread.sleep(500);

		wm.doubleclickusingxpath("//button[@id='btncarsave']");

		wm.sleep();
		wm.sleep();
		wm.sleep();

		Thread.sleep(8000);

		wm.doubleclickusingxpath("//*[@class='btn btn-danger']");
		Thread.sleep(500);

		wm.Listandenterquick("//span[contains(text(),'Leave Page')]", "0");
		wm.Listandenterquick("//span[contains(text(),'Leave Page')]", "1");
		wm.Listandenterquick("//span[contains(text(),'Leave Page')]", "2");
		wm.Listandenterquick("//span[contains(text(),'Leave Page')]", "3");
		wm.sleep();

		wm.Verifythedropdownvalues("//input[@name='DktNumber']",
				"Pass : Sales Refund CARbooking uccf   created successfuly" + "",
				"Fail:  Sales Refund CARbooking uccf   not created successfuly " + "");

		Thread.sleep(500);

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

		return Wrappermethods.getSheet("CarCreditUCCF", "CarCreditUCCF");

	}
}