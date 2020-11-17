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
public class Airpositive {

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
			String dktClientReference, String Tickectstatusindex, String Airline, String Airlineindex,
			String Salesbranch, String Salesbranchindex, String AatdTicketNumber, String ClassTypeCodelistbox,
			String Payableagent, String Payableagentindexx, String Sourceagent, String Sourceagentindexx,
			String issuemodeindex, String Servicetype, String Servicetypeindexx, String AatdPassengerName,
			String PAxtypeindex, String Bookingexecutive, String Bookingexecutiveindex, String AirIssuingExecutieveName,
			String AirIssuingExecutieveNameindex, String Salesexecutive, String Salesexecutiveindex,
			String intedomectiv, String intedomectivindex, String AatdPnrNumber, String Destination,
			String Destinationindexx, String Remarks, String issuepccindex, String Bookingdate1, String Bookingdate2,
			String Bookingdate3, String Bookingpccc, String AtfdHighFare, String AtfdLowFare, String AtfdReasonCode,
			String Fromsector, String Fromsectorindex, String Tosector, String Tosectorindex, String AasegFlightNo,
			String Flightcalssindexx, String Bookingdate4, String Bookingdate5, String Bookingdate6,
			String AasegDepTime, String Bookingdate7, String Bookingdate8, String Bookingdate9, String AasegArrTime,
			String AasegCouponNumber, String AasegDuration, String AasegFareBasis, String Couponstatusindex,
			String AasegSectorMiles, String AasegSectorC02, String Processtype, String Processtypeindex,
			String Currency, String Currecnyindex, String AtfdBaseFare, String AtfdDealFare, String Aatcode,
			String Aatcodeindex, String AatAmount, String Namee, String Nameeindex, String AtscBaseAmount,
			String AtfdCommPercent1, String AtfdCommPercent2, String Agentincetive, String Agentincetiveindexx,
			String AtfdDiscPercent1,String Modeindex,String Selectedbranch,String TravelStatusDN) throws Exception

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

		wm.Listandenter("//i[@class='fa fa-chevron-down']", "0");
		Thread.sleep(200);
		wm.Listandenter("//i[@class='fa fa-plus']", "0");
		Thread.sleep(2500);

		// Ait
		// ===============================================================================

		// sales:

		wm.clickbyxpath("//span[@aria-owns='AatdTicketStatus_listbox']");
		Thread.sleep(50);
		wm.Listandenter("//*[@id='AatdTicketStatus_listbox']/li", Tickectstatusindex);
		Thread.sleep(200);

		// airlinee
		wm.sendtextbyxvalue("//input[@aria-owns='AatdAirlineName_listbox']", Airline);
		Thread.sleep(50);
		wm.Listandenter("//*[@id='AatdAirlineName_listbox']/li", Airlineindex);
		Thread.sleep(200);

		// salesbranch
		wm.sendtextbyxvalue("//input[@aria-owns='AatdBranchKey_listbox']", Salesbranch);
		Thread.sleep(100);
		wm.Listandenter("//*[@id='AatdBranchKey_listbox']/li", Salesbranchindex);
		Thread.sleep(200);

		// enter the tickect nuber
		wm.sendtextbycssselecotrwithoutclear("#AatdTicketNumber", "" + AatdTicketNumber);
		Thread.sleep(300);

		// selecttheclass
		wm.clickbyxpath("//span[@aria-owns='ClassTypeCode_listbox']");
		wm.clickbyxpath("//span[@aria-owns='ClassTypeCode_listbox']");
		Thread.sleep(200);
		wm.Listandenter("//*[@id='ClassTypeCode_listbox']/li", ClassTypeCodelistbox);
		Thread.sleep(200);

		// payableagett
		wm.sendtextbyxvalue("//input[@aria-owns='AatdPayAgntCmsKey_listbox']", Payableagent);
		Thread.sleep(600);
		wm.Listandenter("//*[@id='AatdPayAgntCmsKey_listbox']/li", Payableagentindexx);
		Thread.sleep(200);

		// sourceagent
		wm.sendtextbyxvalue("//input[@aria-owns='AatdSrcAgntCmsKey_listbox']", Sourceagent);
		Thread.sleep(100);
		wm.Listandenter("//*[@id='AatdSrcAgntCmsKey_listbox']/li", Sourceagentindexx);
		Thread.sleep(200);

		// issuemodee
		// wm.sendtextbyxvalue("//input[@aria-owns='AatdIssueType_listbox']",issuemode);
		wm.clickbyxpath("//span[@aria-owns='AatdIssueType_listbox']");
		Thread.sleep(50);
		wm.Listandenter("//*[@id='AatdIssueType_listbox']/li", issuemodeindex);
		Thread.sleep(200);

		// servicetype
		wm.sendtextbyxvalue("//input[@aria-owns='AatdTransTypeDesc_listbox']", Servicetype);
		Thread.sleep(50);
		wm.Listandenter("//*[@id='AatdTransTypeDesc_listbox']/li", Servicetypeindexx);
		Thread.sleep(200);

		// passengername

		wm.sendtextbycssselecotrwithoutclear("#AatdPassengerName", AatdPassengerName);
		Thread.sleep(100);

		// paxtype

		wm.clickbyxpath("//span[@aria-owns='AatdPassengerType_listbox']");
		Thread.sleep(50);
		wm.Listandenter("//*[@id='AatdPassengerType_listbox']/li", PAxtypeindex);
		Thread.sleep(200);

		// bookinegexecutivee
		wm.sendtextbyxvalue("//input[@aria-owns='AirBookingExecutieveName_listbox']", Bookingexecutive);
		Thread.sleep(50);
		wm.Listandenter("//*[@id='AirBookingExecutieveName_listbox']/li", Bookingexecutiveindex);
		Thread.sleep(200);

		// issuringexecutive
		wm.sendtextbyxvalue("//input[@aria-owns='AirIssuingExecutieveName_listbox']", AirIssuingExecutieveName);
		Thread.sleep(50);
		wm.Listandenter("//*[@id='AirIssuingExecutieveName_listbox']/li", AirIssuingExecutieveNameindex);
		Thread.sleep(200);

		// salesexecutive
		wm.sendtextbyxvalue("//input[@aria-owns='AatdSalesExecutiveName_listbox']", Salesexecutive);
		Thread.sleep(50);
		wm.Listandenter("//*[@id='AatdSalesExecutiveName_listbox']/li", Salesexecutiveindex);
		Thread.sleep(200);

		// nternatio or doemstic

		wm.sendtextbyxvalue("//input[@aria-owns='AatdInterDomestic_listbox']", intedomectiv);
		Thread.sleep(50);
		wm.Listandenter("//*[@id='AatdInterDomestic_listbox']/li", intedomectivindex);
		Thread.sleep(200);

		// sending PNR
		wm.sendtextbycssselecotrwithoutclear("#AatdPnrNumber", "" + AatdPnrNumber);
		Thread.sleep(200);

		// Enter thedestinations

		wm.sendtextbyxvalue("//input[@aria-owns='DestinationDesc_listbox']", Destination);
		Thread.sleep(100);
		wm.Listandenter("//*[@id='DestinationDesc_listbox']/li", Destinationindexx);
		Thread.sleep(200);

		// Eter the remarks
		wm.sendtextbycssselecotrwithoutclear("#Remarks", Remarks);
		Thread.sleep(200);

		// =========================================================================
		// other details

		// issuedpcc
		wm.clickbyxpath("//span[@aria-owns='AatdIssuingPcc_listbox']");
		Thread.sleep(50);
		wm.Listandenter("//*[@id='AatdIssuingPcc_listbox']/li", issuepccindex);
		Thread.sleep(200);

		// date

		wm.sendtextbycssselecotr("#AatdBookingDate", "" + Bookingdate1 + "-" + Bookingdate2 + "-" + Bookingdate3);
		Thread.sleep(300);

		// bookingpcc
		wm.clickbyxpath("//span[@aria-owns='AatdBookingPcc_listbox']");
		Thread.sleep(50);
		wm.Listandenter("//*[@id='AatdBookingPcc_listbox']/li", Bookingpccc);
		Thread.sleep(200);

		// enter highfare
		wm.sendtextbycssselecotrwithoutclear("#AtfdHighFare", AtfdHighFare);
		Thread.sleep(50);
		// enter the lowfare
		wm.sendtextbycssselecotrwithoutclear("#AtfdLowFare", AtfdLowFare);
		Thread.sleep(50);

		wm.sendtextbycssselecotrwithoutclear("#AtfdReasonCode", AtfdReasonCode);
		Thread.sleep(50);

		// Enter the secotr details
		// ==========================================================

		wm.stabbyxpath("//input[@name='AtfdReasonCode']");
		Thread.sleep(600);

		// Enter the sectordetails ...

		// ======================================================================================

		wm.Listandenter("//span[@class='k-icon k-i-add']", "0");
		Thread.sleep(300);

		// from sector
		wm.sendtextbyxvalue("//input[@aria-owns='AasegOriginKeyCode_listbox']", Fromsector);
		Thread.sleep(100);
		wm.Listandenter("//*[@id='AasegOriginKeyCode_listbox']/li", Fromsectorindex);
		Thread.sleep(200);

		// Tosector
		wm.sendtextbyxvalue("//input[@aria-owns='AasegDestinationKeyCode_listbox']", Tosector);
		Thread.sleep(100);
		wm.Listandenter("//*[@id='AasegDestinationKeyCode_listbox']/li", Tosectorindex);
		Thread.sleep(200);

		wm.sendtextbycssselecotrwithoutclear("#AasegFlightNo", AasegFlightNo);
		Thread.sleep(50);

		// select the flight class

		wm.clickbyxpath(" //span[@aria-controls='AasegClassKey_listbox']");
		Thread.sleep(200);
		wm.Listandenter("//*[@id='AasegClassKey_listbox']/li", Flightcalssindexx);
		Thread.sleep(200);

		// Enter thedate
		wm.sendtextbycssselecotr("#AasegDepDate", "" + Bookingdate1 + "-" + Bookingdate2 + "-" + Bookingdate3);
		Thread.sleep(50);
		wm.sendtextbycssselecotrwithoutclear("#AasegDepTime", "" + AasegDepTime);
		Thread.sleep(50);
		wm.sendtextbycssselecotr("#AasegArrDate", "" + Bookingdate3 + "-" + Bookingdate4 + "-" + Bookingdate5);
		Thread.sleep(50);
		wm.sendtextbycssselecotrwithoutclear("#AasegArrTime", "" + AasegArrTime);
		Thread.sleep(50);
		wm.sendtextbycssselecotrwithoutclear("#AasegCouponNumber", AasegCouponNumber);
		Thread.sleep(50);
		wm.sendtextbycssselecotrwithoutclear("#AasegDuration", AasegDuration);
		Thread.sleep(50);
		wm.sendtextbycssselecotrwithoutclear("#AasegFareBasis", AasegFareBasis);
		Thread.sleep(200);

		// coupon status

		wm.clickbyxpath(" //span[@aria-owns='AasegCouponStatus_listbox']");
		Thread.sleep(200);
		wm.Listandenter("//*[@id='AasegCouponStatus_listbox']/li", Couponstatusindex);
		Thread.sleep(200);

		wm.sendtextbycssselecotrwithoutclear("#AasegSectorMiles", AasegSectorMiles);
		Thread.sleep(50);

		wm.sendtextbycssselecotrwithoutclear("#AasegSectorC02", AasegSectorC02);
		Thread.sleep(900);

		wm.Listandenter("//span[@class='k-icon k-i-check']", "0");
		Thread.sleep(500);

		wm.clickbyxpath("//*[@id='divAirsectordtls']/div/div[1]/div[1]/a/i");
		Thread.sleep(500);

		// Faredetails==============================================================

		wm.sendtextbyxvalue("//input[@aria-owns='AtfdProcessTypeKey_listbox']", Processtype);
		Thread.sleep(100);
		wm.Listandenter("//*[@id='AtfdProcessTypeKey_listbox']/li", Processtypeindex);
		Thread.sleep(200);

		// selected tecuurecny
		wm.sendtextbyxvalue("//input[@aria-owns='AtfdTransCurrency_listbox']", Currency);
		Thread.sleep(100);
		wm.Listandenter("//*[@id='AtfdTransCurrency_listbox']/li", Currecnyindex);
		Thread.sleep(200);
		// publishedfare
		wm.sendtextbycssselecotrwithoutclear("#AtfdBaseFare", "" + AtfdBaseFare);
		Thread.sleep(200);
		
		wm.stabbyxpath("//input[@name='AtfdBaseFare']");
		Thread.sleep(4000);	
		// sellngfare
		
		wm.Deletedefaultvaluesinthetextbox("//input[@name='AtfdDealFare']");
		
		//wm.Clearbyxpath("//input[@name='AtfdDealFare']");
		
		//wm.sendtextbycssselecotr("#AtfdDealFare", "" +"0");
		Thread.sleep(200);
		wm.sendtextbycssselecotr("#AtfdDealFare", AtfdDealFare);
        //wm.sendtextbycssselecotr("", txt);
		
		Thread.sleep(600);
		wm.clickbyxpath("//input[@name='AFAirlineIncentiveReceived']");

		/*
		 * wm.clickbyxpath("//*[@id='divAirCommissDtls']/div/div[1]/div[1]/a/i")
		 * ; Thread.sleep(1200);
		 */

		wm.stabbyxpath("//input[@name='ESF_INPVAT']");
		Thread.sleep(500);

		wm.Listandenter("//span[@class='k-icon k-i-add']", "1");
		Thread.sleep(500);

		// Tosector
		wm.sendtextbyxvalue("//input[@aria-owns='AatCode_listbox']", Aatcode);
		Thread.sleep(100);
		wm.Listandenter("//*[@id='AatCode_listbox']/li", Aatcodeindex);
		Thread.sleep(200);

		wm.sendtextbycssselecotrwithoutclear("#AatAmount", "" + AatAmount);
		Thread.sleep(200);
		wm.clickbyxpath("//span[@class='k-icon k-i-check']");
		Thread.sleep(200);

		wm.Listandenter("//span[@class='k-icon k-i-add']", "2");
		Thread.sleep(500);

		// AtscServiceChargeId_listbox

		wm.sendtextbyxvalue("//input[@aria-owns='AtscServiceChargeId_listbox']", Namee);
		Thread.sleep(100);
		wm.Listandenter("//*[@id='AtscServiceChargeId_listbox']/li", Nameeindex);
		Thread.sleep(200);

		// enter thefee
		wm.sendtextbycssselecotrwithoutclear("#AtscBaseAmount", "" + AtscBaseAmount);
		Thread.sleep(200);

		wm.stabbyxpath("//input[@name='AtscDisc']"); // tab actin from discount
														// field
		Thread.sleep(200);
		// tab action ffrom pagination screen
		wm.stabbyxpath("//*[@id='AirServiceFeeDetailGrid']/div[5]/span[1]/span/span/span[2]/span");
		Thread.sleep(200);

		wm.Listandenter("//span[@class='k-icon k-i-check']", "0");

		Thread.sleep(200);

		wm.stabbyxpath("//*[@id='div_Air_Header_Details']/div[7]/div/div[1]/div[1]/a/i");

		Thread.sleep(500);

		// Enter the commission amunt

		wm.sendtextbycssselecotrwithoutclear("#AtfdCommPercent1", "" + AtfdCommPercent1);
		Thread.sleep(50);

		wm.sendtextbycssselecotrwithoutclear("#AtfdCommPercent2", "" + AtfdCommPercent2);
		Thread.sleep(50);

		wm.sendtextbycssselecotrwithoutclear("#AtfdDiscPercent1", "" + AtfdDiscPercent1);
		Thread.sleep(600);

		wm.stabbyxpath("//input[@name='AtfdDiscAmount1']");
		Thread.sleep(200);
		
		wm.clickbyxpath("//*[@id='div_Air_Header_Details']/div[7]/div/div[1]/div[1]/a/i");
		Thread.sleep(600);
		
		
		// agent incentivee

		wm.sendtextbyxvalue("//input[@aria-owns='AAtscPaybackParnerDesc_listbox']", Agentincetive);
		Thread.sleep(100);
		wm.Listandenter("//*[@id='AAtscPaybackParnerDesc_listbox']/li", Agentincetiveindexx);
		Thread.sleep(200);

		//Enter the FOPwindows

		wm.Listandenter("//span[@class='k-icon k-i-add']", "3");
		Thread.sleep(200);

		//selecte the cash options
		wm.clickbyxpath("//span[@aria-owns='MiscFOPModeKey_listbox']");		
		//wm.sendtextbyxvalue("//input[@aria-owns='AAtscPaybackParnerDesc_listbox']", Agentincetive);
		Thread.sleep(200);
		wm.Listandenter("//*[@id='MiscFOPModeKey_listbox']/li", Modeindex);
		Thread.sleep(1200);
		
		//selected the branch
		
		wm.clickbyxpath("//*[@id='FOPPaymentDetails']/div[1]/div/div/span[1]/span/span[2]/span");
		
		//wm.clickbyxpath("//*[@aria-owns='fbbranch_listbox']");		
		//wm.sendtextbyxvalue("//input[@aria-owns='AAtscPaybackParnerDesc_listbox']", Agentincetive);
		Thread.sleep(900);
		wm.Listandenter("//*[@id='fbbranch_listbox']/li",Selectedbranch);
		Thread.sleep(300);
		
	   wm.clickbyxpath("//span[@class='k-icon k-i-check']");
		Thread.sleep(900);
		
		//udid details
				wm.clickbyxpath("//*[@id='testData']/i");
				Thread.sleep(900);
				
//				wm.clickbyxpath("//*[@id='acc110']/i");
//			Thread.sleep(300);
				
				wm.stabbyxpath("//*[@id='acc110']/i");
				Thread.sleep(600);
				
				
				wm.sendtextbycssselecotrwithoutclear("#Travel_Status_DN", ""+TravelStatusDN);
				Thread.sleep(600);
				
				
		//clicking the savebuttons
				wm.clickbyxpath("//button[@id='btnairsave']");
				wm.sleep();
				
				//wm.clickbyid("btnMainSave");
				wm.sleep();
				wm.sleep();
				
				wm.sendtextbycssselecotrwithoutclear("#AatdTicketNumber", "" + AatdTicketNumber);
				Thread.sleep(300);
				wm.clickbyxpath("//button[@id='btnairsave']");
				Thread.sleep(500);
				
				wm.Mousemoveover("//input[@onchange='onairTicketChange(this)']");
				Thread.sleep(200);
				wm.Listnegativescearios(utility.Constant.Travelogixuitooltipvalidation, "0",
						"Pass : Sales Refund Air Tickect created successfuly" + "",
						"Fail:  Sales Refund Air Tickect not created successfuly " + "");
			
				

				
		
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

		return Wrappermethods.getSheet("Airpositive", "Airpositive");

	}
}