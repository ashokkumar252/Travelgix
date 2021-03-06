package Salesrefundmisc;
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
public class Miscnegative {
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
	public void Miscnegative(String Username, String Password, String Leftsidemenu, String Commonindex,
			String Documenttypee, String Customer, String dktLeadPaxName, String Salesbranch, String Servicetype,
			String Payableagent, String Bookingexecutive, String Salesexecutive, String InboundOutbound,
			String MiscConfirmationNumber,String MiscServiceDate1,
			String MiscServiceDate2,String MiscServiceDate3,String Processtype,String Currency,
			String MiscRateUnits,String MiscRateServiceRate,String Lodgecard,
			String MiscTaxAmount,String Servicecharge,String MiscServiceFeeAmount
			,String MiscRateCommPercent1,String MiscRateCommPercent2,String MiscRateDiscPercent1,
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
				"Pass : Docket Date validation is avilable ", 
				"Fail :  Docket  Date validaiton is not avilable ");
		Thread.sleep(600);
		wm.sendtextbycssselecotr("#MiscServiceDate", "" + MiscServiceDate1 + "-" + MiscServiceDate2 + "-" + MiscServiceDate3);

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

		
		wm.sendtextbyxvalue("//input[@aria-owns='dktDocTypeCode_listbox']", Documenttypee);
		Thread.sleep(200);
		//wm.Listandenter("//*[@id='dktDocTypeCode_listbox']/li", Commonindex);
		wm.Listnegativescearios("//*[@id='dktDocTypeCode_listbox']/li", Commonindex,
				"Newly created Document type reflected in documentypefiled ",
				"Newly created Document type not reflected in documentypefiled ");
		Thread.sleep(200);

		Thread.sleep(200);

		// Salesranch
		wm.sendtextbyxvalue("//input[@aria-owns='DktBranchKey_listbox']", Salesbranch);
		Thread.sleep(500);
		wm.Listandenter("//*[@id='DktBranchKey_listbox']/li", Commonindex);
		Thread.sleep(200);

		// Custmerr
		wm.sendtextbyxvalue("//input[@aria-owns='DktPartnername_listbox']", Customer);
		Thread.sleep(200);
		wm.Listandenter("//*[@id='DktPartnername_listbox']/li", Commonindex);
		Thread.sleep(200);

		// leadpaxname
		wm.sendtextbycssselecotrwithoutclear("#dktLeadPaxName", "" + dktLeadPaxName);

		wm.Listandenter("//i[@class='fa fa-chevron-down']", "3");
		Thread.sleep(200);
		wm.Listandenter("//i[@class='fa fa-plus']", "3");
		Thread.sleep(1500);

		// 1 Misc Service date Verify the date validations

		wm.Clearbyxpath("//input[@name='MiscServiceDate']");
		Thread.sleep(90);
		wm.clickbyid("btnmiscsave");
		Thread.sleep(100);
		wm.clickbyxpath("//input[@name='MiscConfirmationNumber']");
		Thread.sleep(200);
		// service date
		wm.Mousemoveover("//input[@name='MiscServiceDate']");
		Thread.sleep(90);
		wm.Listnegativescearios(utility.Constant.Travelogixuitooltipvalidation, Commonindex,
				"Pass : Car  Date Field  validation is avilable ",
				"Fail : Car  Date Field  validaiton is not avilable ");
		Thread.sleep(90);

		// 2 misc Service type User allowed to selected the service type Need to
		// start
		wm.sendtextbyxvalue("//input[@aria-owns='MiscServiceType_listbox']", Servicetype);
		Thread.sleep(200);
		wm.Listnegativescearios("//*[@id='MiscServiceType_listbox']/li", "0",
				"User able to selected the newly created MiscServiceType_listbox successfully",
				"User not able to selected the newly created MiscServiceType_listbox successfully");
		Thread.sleep(90);

		// 3 Misc Voucher status User allowed to select the newly created
		// voucher status

		wm.clickbyxpath("//span[@aria-owns='MiscServiceTypeCode_listbox']");
		Thread.sleep(200);
		wm.Listnegativescearios("//*[@id='MiscServiceTypeCode_listbox']/li", "0",
				"User able to selected the newly created Vocuher successfully",
				"User not able to selected the newly created Voucher successfully");
		Thread.sleep(90);

		// 4 Misc Sales branch User allowed to select the newly created sales
		// branch lov
		// Salesranch
		wm.sendtextbyxvalue("//input[@aria-owns='miscBranchKey_listbox']", Salesbranch);
		Thread.sleep(500);
		wm.Listnegativescearios("//*[@id='miscBranchKey_listbox']/li", "0",
				"User able to selected the newly created miscBranchKey_listbox successfully",
				"User not able to selected the newly created miscBranchKey_listbox successfully");
		Thread.sleep(500);

//		wm.Listandenter("//*[@id='miscBranchKey_listbox']/li", Commonindex);
		Thread.sleep(200);

		// 5 Misc Payable agent User allowed to select the newly created payable
		// agent lov
		wm.Clearbyxpath("//input[@aria-owns='MiscPayableAgentKey_listbox']");
		Thread.sleep(200);
		
		wm.sendtextbyxvalue("//input[@aria-owns='MiscPayableAgentKey_listbox']", Payableagent);
		Thread.sleep(500);
		wm.Listnegativescearios("//*[@id='miscBranchKey_listbox']/li", "0",
				"User able to selected the newly created MiscPayableAgentKey_listbox successfully",
				"User not able to selected the newly created MiscPayableAgentKey_listbox successfully");
		Thread.sleep(90);

//		wm.Listandenter("//*[@id='MiscPayableAgentKey_listbox']/li", Commonindex);
		Thread.sleep(200);

		// 6 Misc Booking Executive User allowed to select the newly created
		// booking executive lov
		wm.sendtextbyxvalue("//input[@aria-owns='MiscBookingExecutieveName_listbox']", Bookingexecutive);
		Thread.sleep(500);
		wm.Listnegativescearios("//*[@id='MiscBookingExecutieveName_listbox']/li", "0",
				"User able to selected the newly created MiscBookingExecutieveName_listbox successfully",
				"User not able to selected the newly created MiscBookingExecutieveName_listbox successfully");

		//wm.Listandenter("//*[@id='MiscBookingExecutieveName_listbox']/li", Commonindex);
		Thread.sleep(200);

		// sales executive
		// 7 Misc Sales executive User allowed to select the newly created Sales
		// executive lov
		wm.sendtextbyxvalue("//input[@aria-owns='MiscSalesExecutiveName_listbox']", Salesexecutive);
		Thread.sleep(500);
		
		Thread.sleep(200);
		wm.Listnegativescearios("//*[@id='MiscSalesExecutiveName_listbox']/li", Commonindex,
				"User able to selected the newly created MiscSalesExecutiveName_listbox successfully",
				"User not able to selected the newly created MiscSalesExecutiveName_listbox successfully");


		// 8 Misc inbound/outbound User allowed to slecte the newly created
		// inbound and outbound
		wm.sendtextbyxvalue("//input[@aria-owns='mvdInboundOutboundkey_listbox']", InboundOutbound);
		Thread.sleep(200);
		wm.Listnegativescearios("//*[@id='mvdInboundOutboundkey_listbox']/li", Commonindex,
				"User able to selected the newly created mvdInboundOutboundkey_listbox successfully",
				"User not able to selected the newly created mvdInboundOutboundkey_listbox successfully");
		Thread.sleep(200);

		// 9 Misc Conformation number Verify the Duplciate number validations

		wm.sendtextbycssselecotrwithoutclear("#MiscConfirmationNumber", "" + MiscConfirmationNumber);
		Thread.sleep(200);
		wm.clickbyid("btnMainSave");
		Thread.sleep(50);
		wm.Mousemoveover("//input[@name='MiscConfirmationNumber']");
		Thread.sleep(50);
		wm.Listnegativescearios(utility.Constant.Travelogixuitooltipvalidation, Commonindex,
				"MiscConfirmationNumber Field  validation is avilable ",
				"MiscConfirmationNumber Field  validaiton is not avilable ");
		Thread.sleep(200);
		
//10	Fare Details	proceee type	User allowed to selec the newly created process type

		wm.sendtextbyxvalue("//input[@aria-owns='MisctfdProcessTypeKey_listbox']", Processtype);
		Thread.sleep(200);
		wm.Listnegativescearios("//*[@id='MisctfdProcessTypeKey_listbox']/li", Commonindex,
				"User able to selected the newly created MisctfdProcessTypeKey_listbox successfully",
				"User not able to selected the newly created MisctfdProcessTypeKey_listbox successfully");
		Thread.sleep(200);
	
//11	Fare Details	Currency	Newly  created currency master reflected in the currency field 
		wm.sendtextbyxvalue("//input[@aria-owns='MiscRateCurrencyKey_listbox']", Currency);
		Thread.sleep(200);
		wm.Listnegativescearios("//*[@id='MiscRateCurrencyKey_listbox']/li", Commonindex,
				"User able to selected the newly created MiscRateCurrencyKey_listbox successfully",
				"User not able to selected the newly created MiscRateCurrencyKey_listbox successfully");
		Thread.sleep(200);

//12	Fare Details	Unit	User allowed to enter the unit level
	wm.Selectallbyxpath("//input[@name='MiscRateUnits']");
	Thread.sleep(90);		
	wm.sendtextbycssselecotrwithoutclear("#MiscRateUnits", MiscRateUnits);
	Thread.sleep(90);
	
	

//13	Fare Details	Service rate	User allowed to enter the service rate 
	wm.Selectallbyxpath("//input[@name='MiscRateServiceRate']");
	Thread.sleep(90);	
	wm.sendtextbycssselecotrwithoutclear("#MiscRateServiceRate", MiscRateServiceRate);
	Thread.sleep(2500);
wm.clickbyxpath("//input[@name='MiscRateDealFare']");
Thread.sleep(900);


	
//14	Fare Details	Total amount calculations	Verify the total amount calculations [Service rate * no of units ] = total amount 

	wm.multipletwovaluesandcompare("//input[@name='MiscRateUnits']", 
			"//input[@name='MiscRateServiceRate']", 
			"//input[@name='MiscRateDealFare']", 
			"Total amount calcuation done successfully", 
			"Total amount calcuation not done successfully");
Thread.sleep(300);


wm.stabbyxpath("//input[@name='MiscRateServiceRate']");
Thread.sleep(200);


//15	Fare Details	Logic card	User allowed to slecte the newly created Login card in th drop down 
	


//16	FOP	Net Collections	Verify the Total fop amount = net collections 

	

//==================================================================================


//Lodgecardd

wm.sendtextbyxvalue("//input[@aria-owns='MiscOwnLodgeCardKey_listbox']",Lodgecard);
Thread.sleep(90);
wm.Listandenter("//*[@id='MiscOwnLodgeCardKey_listbox']/li", Commonindex);
Thread.sleep(200);



wm.stabbyxpath("//input[@aria-owns='MiscOwnLodgeCardKey_listbox']");
Thread.sleep(600);

//Enter the taxdetails
//Enter the taxdetails

		// enter the details in service fee

		wm.Listandenter("//span[@class='k-icon k-i-add']", "1");
		Thread.sleep(500);

		// enter service chargee
		wm.sendtextbyxvalue("//input[@aria-owns='MiscServiceChargeId_listbox']", Servicecharge);
		Thread.sleep(90);
		wm.Listandenter("//*[@id='MiscServiceChargeId_listbox']/li", Commonindex);
		Thread.sleep(200);

		wm.sendtextbycssselecotrwithoutclear("#MiscServiceFeeAmount", "" + MiscServiceFeeAmount);
		Thread.sleep(200);
		wm.clickbyxpath("//span[@class='k-icon k-i-check']");

		Thread.sleep(200);


		// Enter the taxdetails

		wm.Listandenter("//span[@class='k-icon k-i-add']", "0");
		Thread.sleep(500);

		wm.stabbyxpath(" //span[@class='k-icon k-i-cancel']");
		Thread.sleep(200);

		// taxcodee

		wm.clickbyxpath("//span[@aria-owns='MiscTaxCodeCode_listbox']");
		Thread.sleep(50);
		wm.Listandenter("//*[@id='MiscTaxCodeCode_listbox']/li", Commonindex);
		Thread.sleep(200);

		wm.sendtextbycssselecotrwithoutclear("#MiscTaxAmount", "" + MiscTaxAmount);
		Thread.sleep(200);
		wm.stabbyxpath("//input[@name='MiscTaxAmount']");
		Thread.sleep(90);
		
		wm.clickbyxpath("//span[@class='k-icon k-i-check']");
		Thread.sleep(200);


// wm.clickbyxpath("//*[@id='idSAMiscFareDev']/div/div[1]/div[1]/a/i");
Thread.sleep(200);

//enterthe commissionamount

wm.Selectallbyxpath("//input[@name='MiscRateCommPercent1']");
wm.sendtextbycssselecotrwithoutclear("#MiscRateCommPercent1", "" + MiscRateCommPercent1);
Thread.sleep(50);

wm.Selectallbyxpath("//input[@name='MiscRateCommPercent2']");
wm.sendtextbycssselecotrwithoutclear("#MiscRateCommPercent2", "" + MiscRateCommPercent2);
Thread.sleep(50);


wm.Selectallbyxpath("//input[@name='MiscRateDiscPercent1']");
wm.sendtextbycssselecotrwithoutclear("#MiscRateDiscPercent1", "" + MiscRateDiscPercent1);


Thread.sleep(500);

wm.clickbyxpath("//*[@id='idMiscCommissionAndDiscountDiv']/div/div[1]/div[1]/a/i");

Thread.sleep(500);


//Agent incentivee

wm.sendtextbyxvalue("//input[@aria-owns='MiscAgentIncentiveAccountName_listbox']", Agentincentive);
Thread.sleep(100);
wm.Listandenter("//*[@id='MiscAgentIncentiveAccountName_listbox']/li", Commonindex);
Thread.sleep(500);

wm.clickbyxpath("//*[@id='AgentIncentiveDiv']/div[1]/div[1]/a/i");
Thread.sleep(500);

//select the fop window

wm.Listandenter("//span[@class='k-icon k-i-add']", "2");
Thread.sleep(500);

wm.Listandenter("//button[@id='ConformationYes']", "0");
//wm.findbyelementbyxpathandclick("//button[@id='ConformationYes']");
Thread.sleep(900);

Thread.sleep(200);

//===============================================

wm.doubleclickusingxpath("//span[@class='k-icon k-i-check']");
Thread.sleep(900);


/*
wm.comparetwovalues1to1("//input[@name='AirFopAmount']"
		, "//input[@name='Amt_NetCollection']", 
		"Pass: FOP and total amount matches successfully"
		, " Fail: FOP and total amount not matches successfully");
*/
Thread.sleep(200);
/*
wm.Netcollections("//input[@name='MiscRateDealFare']", "//input[@name='TotalTaxAmount']",
		"//input[@name='TotalServiceFee']", "//input[@name='TotalDiscount']", " //input[@name='TotOutputVat']", 
		"//input[@name='Amt_NetCollection']", "Net calclaiton done correectly", "Net calclaiton not done correectly");


wm.Publishedfare("//input[@name='MiscRateDealFare']", "//input[@name='TotalTaxAmount']", "//input[@name='salestotcommm']"
		,"//input[@name='TotInputVat']", "//input[@name='Amt_NetPayable']", "Net payable Calclated successfuly", 
		"Net payable not Calclated successfuly");
*/


wm.Netcollectionuisngcancellatiocharges("//input[@name='MiscRateDealFare']", "//input[@name='TotalTaxAmount']",
		"//input[@name='TotalServiceFee']", "//input[@name='TotalDiscount']", "//input[@name='TotOutputVat']", 
		"//input[@name='Amt_NetCollection']", "//*[@name='MiscRateSupplierCancellationChargeRfnd']",
		"//*[@name='MiscRateSupplierCancellationCharge']", "Net calclaiton done correectly by using the cancelaltion charges",
		"Net calclaiton not done correectly by using the cancelaltion charges");

Thread.sleep(200);

wm.Publishedfareusingcancelaltionchargeswithoutuccf("//input[@name='MiscRateDealFare']", "//input[@name='TotalTaxAmount']",
		"//input[@name='salestotcommm']", "//*[@name='MiscRateSupplierCancellationCharge']", 
		"//input[@name='TotInputVat']", "//input[@name='Amt_NetPayable']", 
		"Publishedfare done correectly by using the cancelaltion charges", 
		"ublishedfare not done correectly by using the cancelaltion charges");


//=============================================================================================

	
		
		wm.sleep();

	}

	@AfterMethod
	public void close()

	{
		wm.close();

	}

	@DataProvider(name = "dp")
	public Object[][] dp() throws IOException {

		return Wrappermethods.getSheet("Miscnegative", "Miscnegative");

	}
}