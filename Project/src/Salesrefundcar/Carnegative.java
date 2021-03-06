package Salesrefundcar;
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
public class Carnegative {
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
	public void Carnegative(String Username, String Password, String Leftsidemenu, String Commonindex,
			String Documenttypee, String Customer, String dktLeadPaxName, String invalidate1, String invalidate2,
			String invalidate3, String hotelDate1, String hotelDate2, String hotelDate3, String Salesbranch,
			String Payableagent, String Servicetypee,

			String BookingExecutive, String SalesExecutive, String inboundoutbound, String Bookingpcc, String Issuedpcc,
			String Cityy, String Cartypee, String Carchain, String Pickupplace, String Dropoffplace,
			String CcvdPickupTime1, String CcvdPickupTime2, String CcvdPickupTime3, String invalidDropoffTime1,
			String invalidDropoffTime2, String invalidDropoffTime3, String CcvdDropoffTime1, String CcvdDropoffTime2,
			String CcvdDropoffTime3, String CcvdBookingReference, String CcvdConfirmationNumber, String Processtype,
			String Currency, String CtfdCarRate, String Lodgecard, String AatAmount, String Servicecharge,
			String CscBaseAmount, String CtfdCommPercent1, String CtfdCommPercent2, String CtfdDiscPercent1,
			String Agentincentive) throws Exception {

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
		wm.clickbyxpath("//input[@name='dktLeadPaxName']");
		Thread.sleep(300);
		wm.Mousemoveover("//input[@name='DktDate']");
		Thread.sleep(50);
		wm.Listnegativescearios(utility.Constant.Travelogixuitooltipvalidation, Commonindex,
				"Pass : Docket Date validation is avilable ", "Fail :  Docket  Date validaiton is not avilable ");
		Thread.sleep(200);

		// Field validations

		// Docket type
		wm.Mousemoveover("//input[@name='dktDocTypeCode_input']");
		Thread.sleep(90);
		wm.Listnegativescearios(utility.Constant.Travelogixuitooltipvalidation, Commonindex,
				"Pass : dktDocTypeCode_input Field  validation is avilable ",
				"Fail : dktDocTypeCode_input Field  validaiton is not avilable ");
		Thread.sleep(200);

		// sales branch
		wm.Mousemoveover("//input[@name='DktBranchKey_input']");
		Thread.sleep(90);
		wm.Listnegativescearios(utility.Constant.Travelogixuitooltipvalidation, Commonindex,
				"Pass : DktBranchKey_input Field  validation is avilable ",
				"Fail : DktBranchKey_input Field  validaiton is not avilable ");
		Thread.sleep(200);

		// Customer
		wm.Mousemoveover("//input[@name='DktPartnername_input']");
		Thread.sleep(90);
		wm.Listnegativescearios(utility.Constant.Travelogixuitooltipvalidation, Commonindex,
				"Pass : DktPartnername_input Field  validation is avilable ",
				"Fail : DktPartnername_input Field  validaiton is not avilable ");
		Thread.sleep(200);

		// lead paxname
		wm.Mousemoveover("//input[@name='dktLeadPaxName']");
		Thread.sleep(90);
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
		Thread.sleep(500);
		wm.Listandenter("//*[@id='DktBranchKey_listbox']/li", Commonindex);
		Thread.sleep(200);

		// Custmerr
		wm.sendtextbyxvalue("//input[@aria-owns='DktPartnername_listbox']", Customer);
		Thread.sleep(300);
		wm.Listandenter("//*[@id='DktPartnername_listbox']/li", Commonindex);
		Thread.sleep(200);

		// leadpaxname
		wm.sendtextbycssselecotrwithoutclear("#dktLeadPaxName", "" + dktLeadPaxName);

		wm.Listandenter("//i[@class='fa fa-chevron-down']", "2");
		Thread.sleep(300);
		wm.Listandenter("//i[@class='fa fa-plus']", "2");
		Thread.sleep(1500);

		wm.Clearbyxpath("//input[@name='CcvdDate']");
		Thread.sleep(90);

		wm.clickbyid("btncarsave");
		Thread.sleep(100);
		wm.clickbyxpath("//input[@name='CcvdChild']");
		Thread.sleep(200);

		// service date
		wm.Mousemoveover("//input[@name='CcvdDate']");
		Thread.sleep(90);
		wm.Listnegativescearios(utility.Constant.Travelogixuitooltipvalidation, Commonindex,
				"Pass : Car  Date Field  validation is avilable ",
				"Fail : Car  Date Field  validaiton is not avilable ");
		Thread.sleep(90);

		// payable agent
		wm.Mousemoveover("//input[@name='CcvdProviderKey_input']");
		Thread.sleep(90);
		wm.Listnegativescearios(utility.Constant.Travelogixuitooltipvalidation, Commonindex,
				"Pass : CcvdProviderKey_input Field  validation is avilable ",
				"Fail : CcvdProviderKey_input Field  validaiton is not avilable ");
		Thread.sleep(90);

		// issuing executive
		wm.Mousemoveover("//input[@name='CcvdIssuingUserName_input']");
		Thread.sleep(90);
		wm.Listnegativescearios(utility.Constant.Travelogixuitooltipvalidation, Commonindex,
				"Pass : CcvdIssuingUserName_input Field  validation is avilable ",
				"Fail : CcvdIssuingUserName_input Field  validaiton is not avilable ");
		Thread.sleep(90);

		// issing executive
		wm.Mousemoveover("//input[@name='CcvdSalesExecutiveName_input']");
		Thread.sleep(90);
		wm.Listnegativescearios(utility.Constant.Travelogixuitooltipvalidation, Commonindex,
				"Pass : CcvdSalesExecutiveName_input Field  validation is avilable ",
				"Fail : CcvdSalesExecutiveName_input Field  validaiton is not avilable ");
		Thread.sleep(90);

		// Booking executive
		wm.Mousemoveover("//input[@name='CcvdBookingUserName_input']");
		Thread.sleep(90);
		wm.Listnegativescearios(utility.Constant.Travelogixuitooltipvalidation, Commonindex,
				"Pass : CcvdBookingUserName_input Field  validation is avilable ",
				"Fail : CcvdBookingUserName_input Field  validaiton is not avilable ");
		Thread.sleep(90);

		// 1 Car Service date Verify the date validations
		wm.sendtextbycssselecotr("#CcvdDate", "" + invalidate1 + "-" + invalidate2 + "-" + invalidate3);
		Thread.sleep(90);
		wm.clickbyid("btncarsave");
		wm.clickbyxpath("//input[@name='CcvdChild']");

		Thread.sleep(90);
		wm.Mousemoveover("//input[@name='CcvdDate']");
		Thread.sleep(90);
		wm.Listnegativescearios(utility.Constant.Travelogixuitooltipvalidation, Commonindex,
				"Pass : CcvdDate Field  validation is avilable whenuser enter the date grater than system current date",
				"Fail : CcvdDate Field  validation is not avilable whenuser enter the date grater than system current date");
		Thread.sleep(90);
		wm.sendtextbycssselecotr("#CcvdDate", "" + hotelDate1 + "-" + hotelDate2 + "-" + hotelDate3);
		Thread.sleep(90);

		// 2 Car Vocher status User able to selec the vocuher status
		wm.clickbyxpath("//span[@aria-owns='CcvdVoucherStatus_listbox']");
		Thread.sleep(90);
		wm.Listnegativescearios("//*[@id='CcvdVoucherStatus_listbox']/li", Commonindex,
				"Pass:User able to selected the voucherstatus successfully",
				"Fail:User not able to selected the voucherstatus successfully");
		Thread.sleep(500);

		// 3 Car Sales branch User able to select the branch [ Newly created
		// details reflcted in Sales branch ]
		// wm.Clearbyxpath("//input[@aria-owns= 'CcvdBranchKey_listbox']");
		wm.clickbyxpath("//input[@aria-owns= 'CcvdBranchKey_listbox']");
		Thread.sleep(300);

		wm.sendtextbyxvalue("//input[@aria-owns='CcvdBranchKey_listbox']", Salesbranch);
		Thread.sleep(2000);
		wm.Listnegativescearios("//*[@id='CcvdBranchKey_listbox']/li", "0",
				"Pass:User able to selected the CcvdBranchKey_listbox successfully",
				"Fail:User not able to selected the CcvdBranchKey_listbox successfully");
		Thread.sleep(90);

		// 4 Car Sales branch User able to select the branch [ Newly created
		// details reflcted in payable agent ]

		wm.Clearbyxpath("//input[@aria-owns= 'CcvdProviderKey_listbox']");
		wm.sendtextbyxvalue("//input[@aria-owns= 'CcvdProviderKey_listbox']", Payableagent);
		Thread.sleep(90);
		wm.Listnegativescearios("//*[@id='CcvdProviderKey_listbox']/li", Commonindex,
				"Pass:User able to selected the CcvdProviderKey_listbox successfully",
				"Fail:User not able to selected the CcvdProviderKey_listbox successfully");
		Thread.sleep(90);

		// 5 Car Vocucher [Service type ] User able to select newlycreated
		// voucher Need to start
		wm.Clearbyxpath("//input[@aria-owns= 'CcvdTransType_listbox']");
		wm.sendtextbyxvalue("//input[@aria-owns= 'CcvdTransType_listbox']", Servicetypee);
		Thread.sleep(90);
		wm.Listnegativescearios("//*[@id='CcvdTransType_listbox']/li", Commonindex,
				"Pass:User able to selected the CcvdTransType_listbox Service type  successfully",
				"Fail:User not able to selected the CcvdTransType_listbox  Service type  successfully");
		Thread.sleep(90);

		// 6 Car Booking executive User able to select newly created Booking
		// executive

		wm.sendtextbyxvalue("//input[@aria-owns= 'CcvdBookingUserName_listbox']", BookingExecutive);
		Thread.sleep(90);
		wm.Listnegativescearios("//*[@id='CcvdBookingUserName_listbox']/li", Commonindex,
				"Pass:User able to selected the CcvdBookingUserName_listbox    successfully",
				"Fail:User not able to selected the CcvdBookingUserName_listbox  successfully");
		Thread.sleep(120);

		// 7 Car Saes Executive User able to selected the sales executive
		wm.Clearbyxpath("//input[@aria-owns= 'CcvdSalesExecutiveName_listbox']");

		wm.sendtextbyxvalue("//input[@aria-owns= 'CcvdSalesExecutiveName_listbox']", SalesExecutive);
		Thread.sleep(90);
		wm.Listnegativescearios("//*[@id='CcvdSalesExecutiveName_listbox']/li", Commonindex,
				"Newly created values selected in CcvdSalesExecutiveName_listbox  successfully",
				"Newly created values not selected in CcvdSalesExecutiveName_listbox  successfully");
		Thread.sleep(120);

		// 8 Car Inbound/outbound User able to selected the inbound and outbound
		// services
		wm.sendtextbyxvalue("//input[@aria-owns='cvdInOutBoundName_listbox']", inboundoutbound);
		Thread.sleep(90);
		wm.Listnegativescearios("//*[@id='cvdInOutBoundName_listbox']/li", Commonindex,
				"Newly created values selected in cvdInOutBoundName_listbox  successfully",
				"Newly created values not selected in cvdInOutBoundName_listbox  successfully");
		Thread.sleep(120);

		// 9 Car Booking pcc Verify the nelwy created PCC reflected in the
		// booking Pcc field
		wm.sendtextbyxvalue("//input[@aria-owns='CcvdBookingPcc_listbox']", Bookingpcc);
		Thread.sleep(90);
		wm.Listnegativescearios("//*[@id='CcvdBookingPcc_listbox']/li", Commonindex,
				"Newly created values selected in CcvdBookingPcc_listbox  successfully",
				"Newly created values not selected in CcvdBookingPcc_listbox  successfully");
		Thread.sleep(120);

		// 10 Car Issued PCC Verify the nelwy created PCC reflected in the Issue
		// Pcc field
		wm.sendtextbyxvalue("//input[@aria-owns='CcvdIssuingPcc_listbox']", Issuedpcc);
		Thread.sleep(90);
		wm.Listnegativescearios("//*[@id='CcvdIssuingPcc_listbox']/li", Commonindex,
				"Newly created values selected in CcvdIssuingPcc_listbox  successfully",
				"Newly created values not selected in CcvdIssuingPcc_listbox  successfully");
		Thread.sleep(120);

		// 11 Service details City Newly created city reflected in the city
		// masters
		wm.sendtextbyxvalue("//input[@aria-owns='CcvdCityName_listbox']", Cityy);
		Thread.sleep(90);
		wm.Listnegativescearios("//*[@id='CcvdCityName_listbox']/li", Commonindex,
				"Newly created values selected in CcvdCityName_listbox  successfully",
				"Newly created values not selected in CcvdCityName_listbox  successfully");
		Thread.sleep(120);

		// 12 Service details Car type Newly created car type reflected in the
		// car type field
		wm.sendtextbyxvalue("//input[@aria-owns='CcvdCarTypeKey_listbox']", Cartypee);
		Thread.sleep(90);
		wm.Listnegativescearios("//*[@id='CcvdCarTypeKey_listbox']/li", Commonindex,
				"Newly created values selected in CcvdCarTypeKey_listbox  successfully",
				"Newly created values not selected in CcvdCarTypeKey_listbox  successfully");
		Thread.sleep(120);

		// 13 Service details Car chain Newly created car chain ,should
		// reflected in the car chain field

		wm.sendtextbyxvalue("//input[@aria-owns='CcvdCarChainKey_listbox']", Carchain);
		Thread.sleep(90);
		wm.Listnegativescearios("//*[@id='CcvdCarChainKey_listbox']/li", Commonindex,
				"Newly created values selected in CcvdCarChainKey_listbox  successfully",
				"Newly created values not selected in CcvdCarChainKey_listbox  successfully");
		Thread.sleep(120);

		// ================================================================================================
		// 14 Service details Pick up and drop places Validation when selected
		// the sample place for pickup and dropoff Clarrification
		// clarrification
		// pickup
		wm.sendtextbyxvalue("//input[@aria-owns='CcvdPickupPlace_listbox']", Pickupplace);
		Thread.sleep(90);
		wm.Listnegativescearios("//*[@id='CcvdPickupPlace_listbox']/li", Commonindex,
				"Newly created Pickupplace values selected in Pickupplace  successfully",
				"Newly created Pickupplace values not selected in Pickupplace  successfully");
		Thread.sleep(120);

		// dropoff
		wm.sendtextbyxvalue("//input[@aria-owns='CcvdDropoffPlace_listbox']", Dropoffplace);
		Thread.sleep(90);
		wm.Listnegativescearios("//*[@id='CcvdDropoffPlace_listbox']/li", Commonindex,
				"Newly created CcvdDropoffPlace values selected in CcvdDropoffPlace_listbox  successfully",
				"Newly created CcvdDropoffPlace values not selected in CcvdDropoffPlace_listbox  successfully");
		Thread.sleep(120);

		// 15 Service details pickup and drop off date and time System should
		// display the proper validations

		// pickupateandtimee

		wm.sendtextbycssselecotr("#CcvdPickupTime",
				"" + CcvdPickupTime1 + "-" + CcvdPickupTime2 + "-" + CcvdPickupTime3 + " " + "00:00");
		// wm.sendtextbycssselecotrwithoutclear("#CcvdPickupTime", "00:00");

		Thread.sleep(50);
		wm.sendtextbycssselecotr("#CcvdDropoffTime",
				"" + invalidDropoffTime1 + "-" + invalidDropoffTime2 + "-" + invalidDropoffTime3 + " " + "00:00");
		Thread.sleep(200);
		wm.clickbyid("btncarsave");
		Thread.sleep(200);

		wm.Mousemoveover("//input[@name='CcvdDropoffTime']");
		Thread.sleep(50);
		wm.Listnegativescearios(utility.Constant.Travelogixuitooltipvalidation, Commonindex,
				"Pass : Drop off date validatin is avilable when user ente the value droppoff less tha pickup value  ",
				"Fail : Drop off date validatin is  not avilable when user ente the value droppoff less tha pickup value  ");
		Thread.sleep(200);

		Thread.sleep(200);

		wm.sendtextbycssselecotr("#CcvdDropoffTime",
				"" + CcvdDropoffTime1 + "-" + CcvdDropoffTime2 + "-" + CcvdDropoffTime3 + " " + "00:00");
		// wm.sendtextbycssselecotrwithoutclear("#CcvdDropoffTime", "00:00");

		// 16 Service details Booking reference Verify the duplicate validations

		wm.sendtextbycssselecotr("#CcvdBookingReference", CcvdBookingReference);
		Thread.sleep(90);

		// 17 Service details Confrmation number Verify the duplicate
		// validations

		wm.sendtextbycssselecotr("#CcvdConfirmationNumber", CcvdConfirmationNumber);
		Thread.sleep(90);

		Thread.sleep(200);
		wm.clickbyid("btncarsave");
		Thread.sleep(200);

		wm.Mousemoveover("//input[@name='CcvdBookingReference']");
		Thread.sleep(50);
		wm.Listnegativescearios(utility.Constant.Travelogixuitooltipvalidation, Commonindex,
				"Duplicate validations is avilable in booking refernece field",
				"Duplicate validations is not avilable in booking refernece field");
		Thread.sleep(200);

		wm.Mousemoveover("//input[@name='CcvdConfirmationNumber']");
		Thread.sleep(50);
		wm.Listnegativescearios(utility.Constant.Travelogixuitooltipvalidation, Commonindex,
				"Duplicate validations is avilable in Conformaiton number  field",
				":Duplicate validations is not avilable in Conformaiton number  field");
		Thread.sleep(900);

		// 18 Fare Details Procedd type User able to selcte the process type
		// [Newly created
		// should refelcted In the process type drop down ]
		wm.sendtextbyxvalue("//input[@aria-owns='CtfdProcessTypeKey_listbox']", Processtype);
		Thread.sleep(200);
		wm.Listnegativescearios("//*[@id='CtfdProcessTypeKey_listbox']/li", Commonindex,
				"Newly created CtfdProcessTypeKey values selected in CtfdProcessTypeKey_listbox  successfully",
				"Newly created CtfdProcessTypeKey values not selected in CtfdProcessTypeKey_listbox  successfully");
		Thread.sleep(120);

		// currency

		wm.sendtextbyxvalue("//input[@aria-owns='CtfdTransCurrency_listbox']", Currency);
		Thread.sleep(90);
		wm.Listnegativescearios("//*[@id='CtfdTransCurrency_listbox']/li", Commonindex,
				"Currency values reflected from currency master", "Currency values not reflected from currency master");
		Thread.sleep(120);

		// =======================================================================

		// roomrate

		wm.stabbyxpath("//input[@aria-owns='DealCodeDesc_listbox']");
		Thread.sleep(90);

		wm.Selectallbyxpath("//input[@name='CtfdCarRate']");
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

		//20	Fare Details	Total rate	Verify the total rate calculations 
		//[ car rate *  no of units = total rate ]
		/*
		wm.multipleandcompare("//input[@name='CcvdNotNoOfCars']","//input[@name='CtfdCarRate']", 
				"//input[@name='CtfdBaseFare']","Total rate calulation success", 
				"Total rate calulation not success");
		*/
		wm.multipleandcompare("//input[@name='CcvdNotNoOfDays']", 
				"//input[@name='CcvdNotNoOfCars']",
				" //input[@name='CtfdCarRate']", "//input[@name='CtfdBaseFare']",
				"Total rate calulation success", "Total rate not calulation success");
		

		
		
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
		Thread.sleep(500);


		
		//wm.clickbyxpath("//*[@id='div_Car_Header_Details']/div[4]/div/div[1]/div[1]/a/i");

		// Enter the commissiondetals

		Thread.sleep(200);

		wm.Selectallbyxpath("//input[@name='CtfdCommPercent1']");
		wm.sendtextbycssselecotrwithoutclear("#CtfdCommPercent1", "" + CtfdCommPercent1);

		wm.Selectallbyxpath("//input[@name='CtfdCommPercent2']");
		wm.sendtextbycssselecotrwithoutclear("#CtfdCommPercent2", "" + CtfdCommPercent2);

		wm.Selectallbyxpath("//input[@name='CtfdDiscPercent1']");
		wm.sendtextbycssselecotrwithoutclear("#CtfdDiscPercent1", "" + CtfdDiscPercent1);

		Thread.sleep(500);
		wm.clickbyxpath("//*[@id='div_Car_Header_Details']/div[5]/div/div[1]/div[1]/a/i");

		// Enter the agent incetives

		// Agent incentivee
		Thread.sleep(200);
		wm.sendtextbyxvalue("//input[@aria-owns='CtscPaybackParnerName_listbox']", Agentincentive);
		Thread.sleep(100);
		wm.Listandenter("//*[@id='CtscPaybackParnerName_listbox']/li", Commonindex);
		Thread.sleep(500);

		wm.clickbyxpath("//*[@id='AgentIncentiveDiv']/div/div[1]/div[1]/a/i");
		Thread.sleep(500);

		// select the fop window

		wm.Listandenter("//span[@class='k-icon k-i-add']", "2");
		Thread.sleep(500);

		wm.Listandenter("//button[@id='ConformationYes']", "0");

		//Thread.sleep(900);

		wm.doubleclickusingxpath("//span[@class='k-icon k-i-check']");
		Thread.sleep(1200);

		// ==============================================================

/*
wm.comparetwovalues1to1("//input[@name='AirFopAmount']"
		, "//input[@name='Amt_NetCollection']", 
		"Pass: FOP and total amount matches successfully"
		, " Fail: FOP and total amount not matches successfully");
*/
Thread.sleep(200);
/*
wm.Netcollections("//input[@name='CtfdBaseFare']", "//input[@name='TotalTaxAmount']",
		"//input[@name='TotalServiceFee']", "//input[@name='TotalDiscount']", " //input[@name='TotOutputVat']", 
		"//input[@name='Amt_NetCollection']", "Net calclaiton done correectly", "Net calclaiton not done correectly");


wm.Publishedfare("//input[@name='CtfdBaseFare']", "//input[@name='TotalTaxAmount']", "//input[@name='salestotcommm']"
		,"//input[@name='TotInputVat']", "//input[@name='Amt_NetPayable']", "Net payable Calclated successfuly", 
		"Net payable not Calclated successfuly");
*/

wm.Netcollectionuisngcancellatiocharges("//input[@name='CtfdBaseFare']", "//input[@name='TotalTaxAmount']", 
		"//input[@name='TotalServiceFee']", "//input[@name='TotalDiscount']", "//input[@name='TotOutputVat']", 
		"//input[@name='Amt_NetCollection']", "//input[@name='CtfdAgentCancelCharge']",
		"//input[@name='CtfdSupplierCancelCharge']", "Net calclaiton done correectly using cancelaltion charges",
		"Net calclaiton not done correectly using cancelaltion charges");


wm.Publishedfareusingcancelaltionchargeswithoutuccf("//input[@name='CtfdBaseFare']", "//input[@name='TotalTaxAmount']"
		, "//input[@name='salestotcommm']", "//input[@name='CtfdSupplierCancelCharge']",
		"//input[@name='TotInputVat']", "//input[@name='Amt_NetPayable']", "payable calculation done successfuly using cancellation charges", 
		"payable calculation not done successfuly using cancellation charges");




		
		wm.sleep();

	}

	@AfterMethod
	public void close()

	{
		wm.close();

	}

	@DataProvider(name = "dp")
	public Object[][] dp() throws IOException {

		return Wrappermethods.getSheet("Carnegative", "Carnegative");

	}
}