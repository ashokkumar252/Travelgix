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
public class Hotelnegative {

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
	public void Hotelnegative(String Username, String Password, String Leftsidemenu, String Commonindex,
			String Documenttypee, String Salesbranch, String Customer, String dktLeadPaxName, String invalidate1,
			String invalidate2, String invalidate3, String hotelDate1, String hotelDate2, String hotelDate3,
			String Payableagent, String Branch, String hotelservicdetype, String BookingExecutive,
			String issueexecutive, String Salesexecutive, String hvdInOutBoundName, String Hotelcity, String Hotelname,
			String Hotelchain, String Roomtype, String Roombasics, String Checkin1, String Checkin2, String Checkin3,
			String Checkout1, String Checkout2, String Checkout3, String hotelConfirmationNumber,
			String Processtype,String Currency,String hvdroomrate,String hoteltfdBaseFare,String Lodgecard,
			String Taxcodee,String HotelAtAmount,String Servicefeename,String hotelBaseAmount,String hotelFareCommPercent1,
			String hotelFareCommPercent2,String hotelFareCommPercent3,String hotelHOHotelHighFare,String hotelHOHotelCompareFare,
			String hotelHoRateAccessCode,String hotelHOReasonCode,String hotelHOGDSPropertyCode,String hotelBookingDate1,
			String hotelBookingDate2,String hotelBookingDate3,String Bookingpcc,String Issuedpcc,String Agentincentive
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
		wm.sleep();

		wm.Clearbyxpath("//input[@name='DktDate']");
		Thread.sleep(300);
		wm.clickbyid("btnMainSave");
		wm.clickbyxpath("//input[@name='dktClientReference']");
		Thread.sleep(300);
		wm.Mousemoveover("//input[@name='DktDate']");
		Thread.sleep(50);
		wm.Listnegativescearios(utility.Constant.Travelogixuitooltipvalidation, Commonindex,
				"Pass : Docket Date validation is avilable ", "Fail :  Docket  Date validaiton is not avilable ");
		Thread.sleep(200);

		// Field validations

		// Docket type
		wm.Mousemoveover("//input[@name='dktDocTypeCode_input']");
		Thread.sleep(50);
		wm.Listnegativescearios(utility.Constant.Travelogixuitooltipvalidation, Commonindex,
				"Pass : dktDocTypeCode_input Field  validation is avilable ",
				"Fail : dktDocTypeCode_input Field  validaiton is not avilable ");
		Thread.sleep(200);

		// sales branch
		wm.Mousemoveover("//input[@name='DktBranchKey_input']");
		Thread.sleep(50);
		wm.Listnegativescearios(utility.Constant.Travelogixuitooltipvalidation, Commonindex,
				"Pass : DktBranchKey_input Field  validation is avilable ",
				"Fail : DktBranchKey_input Field  validaiton is not avilable ");
		Thread.sleep(200);

		// Customer
		wm.Mousemoveover("//input[@name='DktPartnername_input']");
		Thread.sleep(50);
		wm.Listnegativescearios(utility.Constant.Travelogixuitooltipvalidation, Commonindex,
				"Pass : DktPartnername_input Field  validation is avilable ",
				"Fail : DktPartnername_input Field  validaiton is not avilable ");
		Thread.sleep(200);

		// lead paxname
		wm.Mousemoveover("//input[@name='dktLeadPaxName']");
		Thread.sleep(50);
		wm.Listnegativescearios(utility.Constant.Travelogixuitooltipvalidation, Commonindex,
				"Pass : dktLeadPaxName Field  validation is avilable ",
				"Fail : dktLeadPaxName Field  validaiton is not avilable ");
		Thread.sleep(200);

		wm.clickbyid("btnMainReturn");
		Thread.sleep(200);
		wm.clickbyid("btnMainAdd");
		Thread.sleep(900);

		// Enter the header details
		// Documenttype
		wm.sendtextbyxvalue("//input[@aria-owns='dktDocTypeCode_listbox']", Documenttypee);
		Thread.sleep(200);
		wm.Listandenter("//*[@id='dktDocTypeCode_listbox']/li", Commonindex);
		Thread.sleep(200);

		// Salesranch
		wm.sendtextbyxvalue("//input[@aria-owns='DktBranchKey_listbox']", Salesbranch);
		Thread.sleep(200);
		wm.Listandenter("//*[@id='DktBranchKey_listbox']/li", Commonindex);
		Thread.sleep(200);

		// Custmerr
		wm.sendtextbyxvalue("//input[@aria-owns='DktPartnername_listbox']", Customer);
		Thread.sleep(200);
		wm.Listandenter("//*[@id='DktPartnername_listbox']/li", Commonindex);
		Thread.sleep(200);

		// leadpaxname
		wm.sendtextbycssselecotrwithoutclear("#dktLeadPaxName", "" + dktLeadPaxName);

		wm.Listandenter("//i[@class='fa fa-chevron-down']", "1");
		Thread.sleep(200);
		wm.Listandenter("//i[@class='fa fa-plus']", "1");
		Thread.sleep(1500);

		wm.Clearbyxpath("//input[@name='hotelDate']");
		Thread.sleep(90);

		wm.clickbyid("btnhotelsave");
		wm.clickbyxpath("//input[@name='hotelChild']");
		Thread.sleep(200);

		// service date
		wm.Mousemoveover("//input[@name='hotelDate']");
		Thread.sleep(90);
		wm.Listnegativescearios(utility.Constant.Travelogixuitooltipvalidation, Commonindex,
				"Pass : hotelDate Field  validation is avilable ",
				"Fail : hotelDate Field  validaiton is not avilable ");
		Thread.sleep(90);

		wm.Mousemoveover("//input[@name='hotelProviderKey_input']");
		Thread.sleep(90);
		wm.Listnegativescearios(utility.Constant.Travelogixuitooltipvalidation, Commonindex,
				"Pass : hotelProviderKey_input Field  validation is avilable ",
				"Fail : hotelProviderKey_input Field  validaiton is not avilable ");
		Thread.sleep(90);

		wm.Mousemoveover("//input[@name='hotelIssuingUserName_input']");
		Thread.sleep(90);
		wm.Listnegativescearios(utility.Constant.Travelogixuitooltipvalidation, Commonindex,
				"Pass : hotelIssuingUserName_input Field  validation is avilable ",
				"Fail : hotelIssuingUserName_input Field  validaiton is not avilable ");
		Thread.sleep(90);

		wm.Mousemoveover("//input[@name='hotelSalesExecutiveName_input']");
		Thread.sleep(90);
		wm.Listnegativescearios(utility.Constant.Travelogixuitooltipvalidation, Commonindex,
				"Pass : hotelSalesExecutiveName_input Field  validation is avilable ",
				"Fail : hotelSalesExecutiveName_input Field  validaiton is not avilable ");
		Thread.sleep(90);

		// Hotelcity
		wm.Mousemoveover("//input[@name='hotelCityName']");
		Thread.sleep(90);
		wm.Listnegativescearios(utility.Constant.Travelogixuitooltipvalidation, Commonindex,
				"Pass : hotelCityName Field  validation is avilable ",
				"Fail : hotelCityName Field  validaiton is not avilable ");
		Thread.sleep(90);

		// Hotelname
		wm.Mousemoveover("//input[@name='hotelHotelName_input']");
		Thread.sleep(90);
		wm.Listnegativescearios(utility.Constant.Travelogixuitooltipvalidation, Commonindex,
				"Pass : hotelHotelName_input Field  validation is avilable ",
				"Fail : hotelHotelName_input Field  validaiton is not avilable ");
		Thread.sleep(90);

		// hotelHotelChainKey_input
		wm.Mousemoveover("//input[@name='hotelHotelChainKey_input']");
		Thread.sleep(90);
		wm.Listnegativescearios(utility.Constant.Travelogixuitooltipvalidation, Commonindex,
				"Pass : hotelHotelChainKey_input Field  validation is avilable ",
				"Fail : hotelHotelChainKey_input Field  validaiton is not avilable ");
		Thread.sleep(90);

		// roomtype
		wm.Mousemoveover("//input[@name='hotelRoomTypeKey_input']");
		Thread.sleep(90);
		wm.Listnegativescearios(utility.Constant.Travelogixuitooltipvalidation, Commonindex,
				"Pass : hotelRoomTypeKey_input Field  validation is avilable ",
				"Fail : hotelRoomTypeKey_input Field  validaiton is not avilable ");
		Thread.sleep(90);

		// Cjeckin date
		wm.Mousemoveover("//input[@name='hotelCheckIn']");
		Thread.sleep(90);
		wm.Listnegativescearios(utility.Constant.Travelogixuitooltipvalidation, Commonindex,
				"Pass : hotelCheckIn Field  validation is avilable ",
				"Fail : hotelCheckIn Field  validaiton is not avilable ");
		Thread.sleep(90);

		// Cjeckout date
		wm.Mousemoveover("//input[@name='hotelCheckOut']");
		Thread.sleep(90);
		wm.Listnegativescearios(utility.Constant.Travelogixuitooltipvalidation, Commonindex,
				"Pass : hotelCheckOut Field  validation is avilable ",
				"Fail : hotelCheckOut Field  validaiton is not avilable ");
		Thread.sleep(90);

		// Cjeckout date
		wm.Mousemoveover("//input[@name='hotelConfirmationNumber']");
		Thread.sleep(90);
		wm.Listnegativescearios(utility.Constant.Travelogixuitooltipvalidation, Commonindex,
				"Pass : hotelConfirmationNumber Field  validation is avilable ",
				"Fail : hotelConfirmationNumber Field  validaiton is not avilable ");
		Thread.sleep(90);

		// 1 Hotel header Hotel service Date validations Date validations

		wm.sendtextbycssselecotr("#hotelDate", "" + invalidate1 + "-" + invalidate2 + "-" + invalidate3);
		Thread.sleep(90);
		wm.clickbyid("btnMainSave");
		Thread.sleep(90);
		wm.Mousemoveover("//input[@name='hotelDate']");
		Thread.sleep(90);
		wm.Listnegativescearios(utility.Constant.Travelogixuitooltipvalidation, Commonindex,
				"Pass : hotelDate Field  validation is avilable whenuser enter the date grater than system current date",
				"Fail : hotelDate Field  validation is not avilable whenuser enter the date grater than system current date");
		Thread.sleep(90);
		wm.sendtextbycssselecotr("#hotelDate", "" + hotelDate1 + "-" + hotelDate2 + "-" + hotelDate3);

		// 2 Hotel header User able to select the Voucher status

		wm.clickbyxpath("//span[@aria-owns='hotelVoucherStatus_listbox']");
		Thread.sleep(90);
		wm.Listnegativescearios("//*[@id='hotelVoucherStatus_listbox']/li", Commonindex,
				"Pass:User able to selected the voucherstatus successfully",
				"Fail:User not able to selected the voucherstatus successfully");
		Thread.sleep(200);

		// 3 Hotel header User able to select the payable agent [ Coming from
		// Bussiness partner AP get displayed]
		wm.Clearbyxpath("//input[@aria-owns= 'hotelProviderKey_listbox']");
		wm.sendtextbyxvalue("//input[@aria-owns= 'hotelProviderKey_listbox']", Payableagent);
		Thread.sleep(90);
		wm.Listnegativescearios("//*[@id='hotelProviderKey_listbox']/li", Commonindex,
				"Pass:User able to selected the hotelProviderKey_listbox successfully",
				"Fail:User not able to selected the hotelProviderKey_listbox successfully");
		Thread.sleep(90);

		// 4 Hotel header User allow to change the branch

		wm.Clearbyxpath("//input[@aria-owns= 'hotelBranchKey_listbox']");
		wm.sendtextbyxvalue("//input[@aria-owns= 'hotelBranchKey_listbox']", Branch);
		Thread.sleep(90);
		wm.Listnegativescearios("//*[@id='hotelBranchKey_listbox']/li", Commonindex,
				"User allowed to changed the branch successfully",
				"User not allowed to changed the branch successfully");
		Thread.sleep(90);

		// 5 Hotel header USer allow to select the hotel vouchers
		wm.sendtextbyxvalue("//input[@aria-owns= 'hotelTransType_listbox']", hotelservicdetype);
		Thread.sleep(90);
		wm.Listnegativescearios("//*[@id='hotelTransType_listbox']/li", Commonindex,
				"User allowed to selected  the hotelservicdetype successfully",
				"User not allowed to selected  the hotelservicdetype successfully");
		Thread.sleep(90);

		// 6 Hotel header User able to select the booking executive
		wm.sendtextbyxvalue("//input[@aria-owns= 'hotelBookingUserName_listbox']", BookingExecutive);
		Thread.sleep(90);
		wm.Listnegativescearios("//*[@id='hotelBookingUserName_listbox']/li", Commonindex,
				"User allowed to selected  the hotelBookingUserName_listbox successfully",
				"User not allowed to selected  the hotelBookingUserName_listbox successfully");
		Thread.sleep(90);

		/*
		 * //7 Hotel header User able to select the issueing executive
		 * wm.sendtextbyxvalue(
		 * "//input[@aria-owns= 'hotelIssuingUserName_listbox']"
		 * ,issueexecutive);
		 * 
		 * Thread.sleep(90);
		 * wm.Listnegativescearios("//*[@id='hotelIssuingUserName_listbox']/li",
		 * Commonindex,
		 * "User allowed to selected  the hotelIssuingUserName_listbox successfully"
		 * ,
		 * "User not allowed to selected  hotelIssuingUserName_listbox successfully"
		 * ); Thread.sleep(90);
		 * 
		 * 
		 *///
			// 8 Hotel header User able to select the Sales executive

		wm.Clearbyxpath("//input[@aria-owns= 'hotelSalesExecutiveName_listbox']");

		wm.sendtextbyxvalue("//input[@aria-owns= 'hotelSalesExecutiveName_listbox']", Salesexecutive);
		Thread.sleep(90);
		wm.Listnegativescearios("//*[@id='hotelSalesExecutiveName_listbox']/li", Commonindex,
				"User allowed to selected  the hotelSalesExecutiveName_listbox successfully",
				"User not allowed to selected  the hotelSalesExecutiveName_listbox successfully");
		Thread.sleep(90);
		// 9 Hotel header hotel booking using inbound or outbound

		wm.Clearbyxpath("//input[@aria-owns= 'hvdInOutBoundName_listbox']");
		Thread.sleep(20);

		wm.sendtextbyxvalue("//input[@aria-owns= 'hvdInOutBoundName_listbox']", hvdInOutBoundName);
		Thread.sleep(90);
		wm.Listnegativescearios("//*[@id='hvdInOutBoundName_listbox']/li", Commonindex,
				"User allowed to selected  the hvdInOutBoundName_listbox successfully",
				"User not allowed to selected  the hvdInOutBoundName_listbox successfully");
		Thread.sleep(90);

		// 10 Service details Hotel city : Active city master detais get
		// reflected

		wm.sendtextbyxvalue("//input[@aria-owns= 'hotelCityName_listbox']", Hotelcity);
		Thread.sleep(90);
		wm.Listnegativescearios("//*[@id='hotelCityName_listbox']/li", Commonindex,
				"User allowed to selected  the hotelCityName_listbox successfully",
				"User not allowed to selected  the hotelCityName_listbox successfully");
		Thread.sleep(90);

		// 11 Service details Hotel master : newy create details get relected
		wm.sendtextbyxvalue("//input[@aria-owns= 'hotelHotelName_listbox']", Hotelname);
		Thread.sleep(90);
		wm.Listnegativescearios("//*[@id='hotelHotelName_listbox']/li", Commonindex,
				"Newly created Hotelname reflected in hotel name field ",
				"Newly created Hotelname not reflected in hotel name field ");
		Thread.sleep(90);

		// hotelchain
		wm.sendtextbyxvalue("//input[@aria-owns= 'hotelHotelChainKey_listbox']", Hotelchain);
		Thread.sleep(90);
		wm.Listnegativescearios("//*[@id='hotelHotelChainKey_listbox']/li", Commonindex,
				"Newly created Hotelchain reflected in hotelHotelChainKey_listbox field ",
				"Newly created Hotelchain not reflected in hotelHotelChainKey_listbox field ");
		Thread.sleep(90);

		// 12 Service details Room type master : created roomtype master
		// reflected in the roomtype field

		wm.sendtextbyxvalue("//input[@aria-owns= 'hotelRoomTypeKey_listbox']", Roomtype);
		Thread.sleep(90);
		wm.Listnegativescearios("//*[@id='hotelRoomTypeKey_listbox']/li", Commonindex,
				"Newly created Roomtype reflected in hotelRoomTypeKey_listboxfield ",
				"Newly created Roomtype not reflected in hotelRoomTypeKey_listbox field ");
		Thread.sleep(90);

		// 13 Service details Room type basics : created room type basics
		// reflected in room basic field

		wm.sendtextbyxvalue("//input[@aria-owns= 'hotelRoombasisCode_listbox']", Roombasics);
		Thread.sleep(90);
		wm.Listnegativescearios("//*[@id='hotelRoombasisCode_listbox']/li", Commonindex,
				"Newly created Roombasics reflected in hotelRoombasisCode_listbox field ",
				"Newly created Roombasics not reflected in hotelRoombasisCode_listbox field ");
		Thread.sleep(90);

		// 14 Service details Date vaidations : checkkins and checkout date
		// validations

		// check in
		wm.Mousemoveover("//input[@name='hotelCheckIn']");
		Thread.sleep(90);
		wm.Listnegativescearios(utility.Constant.Travelogixuitooltipvalidation, Commonindex,
				"Pass : hotelCheckIn Field  validation is avilable ",
				"Fail : hotelCheckIn Field  validaiton is not avilable ");
		Thread.sleep(90);

		// check out
		wm.Mousemoveover("//input[@name='hotelCheckOut']");
		Thread.sleep(90);
		wm.Listnegativescearios(utility.Constant.Travelogixuitooltipvalidation, Commonindex,
				"Pass : hotelCheckOut Field  validation is avilable ",
				"Fail : hotelCheckOut Field  validaiton is not avilable ");
		Thread.sleep(90);

		// Check in
		wm.sendtextbycssselecotr("#hotelCheckIn", "" + Checkout1 + "-" + Checkout2 + "-" + Checkout3);
		Thread.sleep(90);
		// Checkout
		Thread.sleep(200);
		wm.sendtextbycssselecotr("#hotelCheckOut", "" + Checkin1 + "-" + Checkin2 + "-" + Checkin3);
		Thread.sleep(200);
		wm.clickbyid("btnhotelsave");
		Thread.sleep(200);

		wm.clickbyxpath("//input[@name= 'hotelHotelPropertyCode']");
		Thread.sleep(90);

		wm.Mousemoveover("//input[@name='hotelCheckOut']");
		Thread.sleep(90);
		wm.Listnegativescearios(utility.Constant.Travelogixuitooltipvalidation, Commonindex,
				"Pass : When enter the checkout date is grater than checkin date and validation is avilable ",
				"Fail : When enter the checkout date is grater than checkin date and validation is not  avilable");
		Thread.sleep(90);

		wm.sendtextbycssselecotr("#hotelCheckIn", "" + Checkin1 + "-" + Checkin2 + "-" + Checkin3);
		Thread.sleep(90);
		// Checkout
		Thread.sleep(200);
		wm.sendtextbycssselecotr("#hotelCheckOut", "" + Checkout1 + "-" + Checkout2 + "-" + Checkout3);
		Thread.sleep(500);

		wm.clickbyxpath("//input[@name= 'hotelHotelPropertyCode']");
		Thread.sleep(300);

		wm.sendtextbycssselecotr("#hotelConfirmationNumber", "" + hotelConfirmationNumber);
		Thread.sleep(200);

		
//=========================================================================================
		// enter the Fare details

		wm.clickbyxpath("//*[@id='div_Hotel_Header_Details']/div[2]/div/div[1]/div[1]/a");

		Thread.sleep(900);

		// procee typee
		wm.sendtextbyxvalue("//input[@aria-owns='hoteltfdProcessTypeKey_listbox']", Processtype);
		Thread.sleep(50);
		wm.Listandenter("//*[@id='hoteltfdProcessTypeKey_listbox']/li", Commonindex);
		Thread.sleep(200);

		// Currency
		wm.sendtextbyxvalue("//input[@aria-owns='hoteltfdTransCurrency_listbox']", Currency);
		Thread.sleep(50);
		wm.Listandenter("//*[@id='hoteltfdTransCurrency_listbox']/li", Commonindex);
		Thread.sleep(200);

		// roomrate

		wm.Selectallbyxpath("//input[@name='hvd_room_rate']");
		Thread.sleep(50);

		wm.sendtextbycssselecotrwithoutclear("#hvd_room_rate", "" + hvdroomrate);
		wm.sleep();
		//wm.sendtextbycssselecotr("#hoteltfdBaseFare", "" + hoteltfdBaseFare);
		Thread.sleep(200);

		// logigcard
		wm.sendtextbyxvalue("//input[@aria-owns='HtfdOwnLodgeCardKey_listbox']", Lodgecard);
		Thread.sleep(50);
		wm.Listandenter("//*[@id='HtfdOwnLodgeCardKey_listbox']/li", Commonindex);
		Thread.sleep(200);

		// enter the tzzx detailss

		wm.stabbyxpath("//input[@aria-owns='HtfdOwnLodgeCardKey_listbox']");
		Thread.sleep(600);

/*		wm.Listandenter("//span[@class='k-icon k-i-add']", "0");
		Thread.sleep(500);

		wm.stabbyxpath(" //span[@class='k-icon k-i-cancel']");
		Thread.sleep(200);
		

		// TAX code
		wm.sendtextbyxvalue("//input[@aria-owns='HotelAtCode_listbox']", Taxcodee);
		Thread.sleep(100);
		wm.Listandenter("//*[@id='HotelAtCode_listbox']/li", Commonindex);
		Thread.sleep(200);

		// TAxamountt
		wm.sendtextbycssselecotrwithoutclear("#HotelAtAmount", HotelAtAmount);
		Thread.sleep(200);
		wm.clickbyxpath("//span[@class='k-icon k-i-check']");
		Thread.sleep(200);
*/
		// enter the details in service fee

		wm.Listandenter("//span[@class='k-icon k-i-add']", "1");
		Thread.sleep(500);

		// name
		wm.sendtextbyxvalue("//input[@aria-owns='hotelServiceChargeId_listbox']", Servicefeename);
		Thread.sleep(100);
		wm.Listandenter("//*[@id='hotelServiceChargeId_listbox']/li", Commonindex);
		Thread.sleep(500);

		wm.sendtextbycssselecotrwithoutclear("#hotelBaseAmount", "" + hotelBaseAmount);
		Thread.sleep(900);

		wm.stabbyxpath("//input[@name='hotelBaseAmount']");
		Thread.sleep(300);

		wm.clickbyxpath("//span[@class='k-icon k-i-check']");
		Thread.sleep(600);
	//======
		
		wm.Listandenter("//span[@class='k-icon k-i-add']", "0");
		Thread.sleep(500);

		wm.stabbyxpath(" //span[@class='k-icon k-i-cancel']");
		Thread.sleep(200);
		

		// TAX code
		wm.sendtextbyxvalue("//input[@aria-owns='HotelAtCode_listbox']", Taxcodee);
		Thread.sleep(100);
		wm.Listandenter("//*[@id='HotelAtCode_listbox']/li", Commonindex);
		Thread.sleep(200);

		// TAxamountt
		wm.sendtextbycssselecotrwithoutclear("#HotelAtAmount", HotelAtAmount);
		Thread.sleep(200);


		wm.stabbyxpath("//input[@name='HotelAtAmount']");
		Thread.sleep(200);
		wm.clickbyxpath("//span[@class='k-icon k-i-check']");
		Thread.sleep(200);

		
		
		
Thread.sleep(200);		
		wm.clickbyxpath("//*[@id='div_Hotel_Header_Details']/div[3]/div/div[1]/div[1]/a/i");

		// Enter the commissiondetails
		Thread.sleep(200);
		wm.Selectallbyxpath("//input[@name='hotelFareCommPercent1']");	
		wm.sendtextbycssselecotrwithoutclear("#hotelFareCommPercent1", "" + hotelFareCommPercent1);
		Thread.sleep(500);

		wm.Selectallbyxpath("//input[@name='hotelFareCommPercent2']");
		wm.sendtextbycssselecotrwithoutclear("#hotelFareCommPercent2", "" + hotelFareCommPercent2);
		Thread.sleep(500);

		wm.Selectallbyxpath("//input[@name='hotelFareDiscPercent1']");
		wm.sendtextbycssselecotrwithoutclear("#hotelFareDiscPercent1", "" + hotelFareCommPercent3);
		Thread.sleep(500);
		
		Thread.sleep(200);

		wm.clickbyxpath("//*[@id='div_Hotel_Header_Details']/div[4]/div/div[1]/div[1]/a");
		Thread.sleep(200);

		// enter the other details

		wm.sendtextbycssselecotrwithoutclear("#hotelHOHotelHighFare", "" + hotelHOHotelHighFare);
		wm.sendtextbycssselecotrwithoutclear("#hotelHOHotelCompareFare", "" + hotelHOHotelCompareFare);
		wm.sendtextbycssselecotrwithoutclear("#hotelHoRateAccessCode", "" + hotelHoRateAccessCode);
		wm.sendtextbycssselecotrwithoutclear("#hotelHOReasonCode", "" + hotelHOReasonCode);
		wm.sendtextbycssselecotrwithoutclear("#hotelHOGDSPropertyCode", "" + hotelHOGDSPropertyCode);
		// Booking datee

		wm.sendtextbycssselecotr("#hotelBookingDate",
				"" + hotelBookingDate1 + "-" + hotelBookingDate2 + "-" + hotelBookingDate3);

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
		Thread.sleep(900);
		
		// wm.findbyelementbyxpathandclick(xpath);
		
		wm.Listandenter("//button[@id='ConformationYes']", "0");
		
		//wm.findbyelementbyxpathandclick("//button[@id='ConformationYes']");
		Thread.sleep(900);
		
	
		wm.doubleclickusingxpath("//span[@class='k-icon k-i-check']");
		Thread.sleep(900);

		/*

wm.comparetwovalues1to1("//input[@name='AirFopAmount']"
		, "//input[@name='Amt_NetCollection']", 
		"49 Pass: FOP and total amount matches successfully"
		, "49 Fail: FOP and total amount matches successfully");

Thread.sleep(200);


wm.Netcollections("//input[@name='hoteltfdBaseFare']", "//input[@name='TotalTaxAmount']",
		"//input[@name='TotalServiceFee']", "//input[@name='TotalDiscount']", " //input[@name='TotOutputVat']", 
		"//input[@name='Amt_NetCollection']", "Net calclaiton done correectly", "Net calclaiton not done correectly");


wm.Publishedfare("//input[@name='hoteltfdBaseFare']", "//input[@name='TotalTaxAmount']", 
		"//input[@name='salestotcommm']"
		,"//input[@name='TotInputVat']", "//input[@name='Amt_NetPayable']", "Net payable Calclated successfuly", 
		"Net payable not Calclated successfuly");
*/

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

		
		
//================================================================================================

		
		

		wm.sleep();

	}

	@AfterMethod
	public void close()

	{
		wm.close();

	}

	@DataProvider(name = "dp")
	public Object[][] dp() throws IOException {

		return Wrappermethods.getSheet("Hotelnegative", "Hotelnegative");

	}
}