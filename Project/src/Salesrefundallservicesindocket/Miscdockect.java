package Salesrefundallservicesindocket;

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
public class Miscdockect {
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
	public void Miscdockect(String Username, String Password, String Leftsidemenu, String Docketnumber,
			String ActiveFrom1, String ActiveFrom2, String ActiveFrom3, String Docktype, String Docktypeindex,
			String Salesbracnh, String Salesbracnhindex, String Customer, String Customerindex, String Leadpaxnamee,
			String dktClientReference, String Tickectstatusindex,

			String Commonindex, String Servicetype, String Payableagent, String Bookingexecutive, String Salesexecutive,
			String Cityname, String Saledate1, String Saledate2, String Saledate3, String MiscConfirmationNumber,
			String MiscBookingReference, String Remarks, String Servicedetails, String Servicedetails1,

			String Processtype, String Currency, String MiscRateUnits, String MiscRateServiceRate, String Lodgecard,

			String MiscTaxAmount, String Servicecharge, String MiscServiceFeeAmount, String MiscRateCommPercent1,
			String MiscRateCommPercent2, String MiscRateDiscPercent1, String Agentincentive, String Customerdetails,

			String ProjectNumberAP, String DepartmentAP, String MajorClassAP, String TravelStatusAP,
			String TotalSavingCodeAP, String GroupTravelIndicatorAP, String TourCodeAP, String EndorsementRestrictAP,
			String FareCalculationAreaAP, String IntlSalesIndicatorAP, String Miscvouchernumber, String Modeindex,
			String Cardtypedetails, String fcardnum, String fcardDate1, String fcardDate3

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

		wm.sendtextbyxvalue("//input[@name='DktNumber']", Docketnumber);
		Thread.sleep(300);
		wm.clickbyxpath("//button[@class='btn btn-success']");
		Thread.sleep(600);

		wm.doubleclickusingxpath("//*[@id='SalesSearchGrid']/div[3]/table/tbody/tr[1]/td[1]");
		Thread.sleep(300);

		wm.clickbyid("btnMainEdit");
		Thread.sleep(2000);

		wm.Listandenter("//i[@class='fa fa-chevron-down']", "0");
		Thread.sleep(30);
		wm.Listandenter("//i[@class='fa fa-chevron-down']", "1");
		Thread.sleep(30);
		wm.Listandenter("//i[@class='fa fa-chevron-down']", "2");
		Thread.sleep(30);
		wm.Listandenter("//i[@class='fa fa-plus']", "3");
		Thread.sleep(2500);

		// Enter the miscdetails

		wm.sendtextbyxvalue("//input[@aria-owns='MiscServiceType_listbox']", Servicetype);
		Thread.sleep(200);
		wm.Listandenter("//*[@id='MiscServiceType_listbox']/li", Commonindex);
		Thread.sleep(200);

		// payableagent

		wm.sendtextbyxvalue("//input[@aria-owns='MiscPayableAgentKey_listbox']", Payableagent);
		Thread.sleep(200);
		wm.Listandenter("//*[@id='MiscPayableAgentKey_listbox']/li", Commonindex);
		Thread.sleep(200);

		// Bookingexecutive
		wm.sendtextbyxvalue("//input[@aria-owns='MiscBookingExecutieveName_listbox']", Bookingexecutive);
		Thread.sleep(200);
		wm.Listandenter("//*[@id='MiscBookingExecutieveName_listbox']/li", Commonindex);
		Thread.sleep(200);

		// sales exectivee
		wm.sendtextbyxvalue("//input[@aria-owns='MiscSalesExecutiveName_listbox']", Salesexecutive);
		Thread.sleep(200);
		wm.Listandenter("//*[@id='MiscSalesExecutiveName_listbox']/li", Commonindex);
		Thread.sleep(200);

		// enter thecityname
		wm.sendtextbyxvalue("//input[@aria-owns='MiscCityName_listbox']", Cityname);
		Thread.sleep(200);
		wm.Listandenter("//*[@id='MiscCityName_listbox']/li", Commonindex);
		Thread.sleep(200);

		// datee

		wm.sendtextbycssselecotr("#MiscServicetktDate", "" + Saledate1 + "-" + Saledate2 + "-" + Saledate3);
		Thread.sleep(200);

		// confirmationnumber
		wm.sendtextbycssselecotrwithoutclear("#MiscConfirmationNumber", MiscConfirmationNumber);
		Thread.sleep(90);

		// boking refernece
		wm.sendtextbycssselecotrwithoutclear("#MiscBookingReference", MiscBookingReference);
		Thread.sleep(90);

		wm.sendtextbycssselecotrwithoutclear("#Remarks", Remarks);
		Thread.sleep(90);

		// Enter theservicedetails

		wm.Sendtextwhenduplicateproperty("//input[@name='MiscHtlInternationalDomestic']", "0", Servicedetails);
		Thread.sleep(90);

		wm.Sendtextwhenduplicateproperty("//input[@name='MiscHtlInternationalDomestic']", "1", Servicedetails1);
		Thread.sleep(90);
		wm.clickbyxpath("//*[@id='IdSAMiscDynamicServiceDetailsDiv']/div/div/div[1]/div[1]/a/i");
		Thread.sleep(200);

		// Enter the faredetails

		// processtypee
		wm.sendtextbyxvalue("//input[@aria-owns='MisctfdProcessTypeKey_listbox']", Processtype);
		Thread.sleep(90);
		wm.Listandenter("//*[@id='MisctfdProcessTypeKey_listbox']/li", Commonindex);
		Thread.sleep(200);

		// Currecydetails
		wm.sendtextbyxvalue("//input[@aria-owns='MiscRateCurrencyKey_listbox']", Currency);
		Thread.sleep(90);
		wm.Listandenter("//*[@id='MiscRateCurrencyKey_listbox']/li", Commonindex);
		Thread.sleep(200);

		// unit
		wm.sendtextbycssselecotr("#MiscRateUnits", "" + MiscRateUnits);
		Thread.sleep(200);

		wm.stabbyxpath("//input[@name='MiscRateUnits']");
		Thread.sleep(100);

		/*
		 * wm.clickbyxpath("//input[@name='MiscRateServiceRate']");
		 * Thread.sleep(90);
		 * wm.Clearbyxpath("//input[@name='MiscRateServiceRate']");
		 * Thread.sleep(90);
		 */

		wm.Selectallbyxpath("//input[@name='MiscRateServiceRate']");
		Thread.sleep(90);

		// wm.sendtextbyxvalue("//input[@name='MiscRateServiceRate']",""+MiscRateServiceRate);

		wm.sendtextbycssselecotrwithoutclear("#MiscRateServiceRate", "" + MiscRateServiceRate);
		Thread.sleep(100);
		wm.stabbyxpath("//input[@name='MiscRateServiceRate']");
		Thread.sleep(200);

		// Lodgecardd

		wm.sendtextbyxvalue("//input[@aria-owns='MiscOwnLodgeCardKey_listbox']", Lodgecard);
		Thread.sleep(90);
		wm.Listandenter("//*[@id='MiscOwnLodgeCardKey_listbox']/li", Commonindex);
		Thread.sleep(200);

		// Enter the taxdetails

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

		
		wm.clickbyxpath("//*[@id='idSAMiscFareDev']/div/div[1]/div[1]/a/i");
		Thread.sleep(200);

		// enterthe commissionamount

		wm.Selectallbyxpath("//input[@name='MiscRateCommPercent1']");
		wm.sendtextbycssselecotrwithoutclear("#MiscRateCommPercent1", "" + MiscRateCommPercent1);
		Thread.sleep(50);

		wm.Selectallbyxpath("//input[@name='MiscRateCommPercent2']");
		wm.sendtextbycssselecotrwithoutclear("#MiscRateCommPercent2", "" + MiscRateCommPercent2);
		Thread.sleep(50);

		wm.Selectallbyxpath("//input[@name='MiscRateDiscPercent1']");
		wm.sendtextbycssselecotrwithoutclear("#MiscRateDiscPercent1", "" + MiscRateDiscPercent1);

		Thread.sleep(300);

		wm.clickbyxpath("//*[@id='idMiscCommissionAndDiscountDiv']/div/div[1]/div[1]/a/i");

		Thread.sleep(500);

		// Agent incentivee

		wm.sendtextbyxvalue("//input[@aria-owns='MiscAgentIncentiveAccountName_listbox']", Agentincentive);
		Thread.sleep(100);
		wm.Listandenter("//*[@id='MiscAgentIncentiveAccountName_listbox']/li", Commonindex);
		Thread.sleep(500);

		wm.clickbyxpath("//*[@id='AgentIncentiveDiv']/div[1]/div[1]/a/i");
		Thread.sleep(500);

		// select the fop window

		wm.Listandenter("//span[@class='k-icon k-i-add']", "2");
		Thread.sleep(500);
		wm.Listandenter("//button[@id='ConformationYes']", "0");
		Thread.sleep(600);

		// ==================================================================
		// enter thecardetails

		// selecte the Credit card options
		wm.clickbyxpath("//span[@aria-owns='MiscFOPModeKey_listbox']");
		// wm.sendtextbyxvalue("//input[@aria-owns='AAtscPaybackParnerDesc_listbox']",
		// Agentincetive);
		Thread.sleep(200);
		wm.Listandenter("//*[@id='MiscFOPModeKey_listbox']/li", Modeindex);
		Thread.sleep(1200);

		// selected the branch

		wm.clickbyxpath("//*[@id='FOPPaymentDetails']/div[1]/div/div/span[1]/span/span[2]/span");
		Thread.sleep(600);

		wm.sendtextbyxvalue("//input[@aria-owns='fcardtype_listbox']", Cardtypedetails);
		Thread.sleep(500);
		wm.Listandenter("//*[@id='fcardtype_listbox']/li", Commonindex);
		Thread.sleep(200);

		wm.sendtextbycssselecotrwithoutclear("#fcardnum", "" + fcardnum);
		Thread.sleep(200);

		wm.sendtextbycssselecotr("#fcardDate", "" + fcardDate1 + "/" + fcardDate3);
		Thread.sleep(200);

		// ============================================================================

		wm.doubleclickusingxpath("//span[@class='k-icon k-i-check']");
		Thread.sleep(900);

/*		wm.comparetwovalues1to1("//input[@name='AirFopAmount']", "//input[@name='Amt_NetCollection']",
				"Pass: FOP and total amount matches successfully",
				" Fail: FOP and total amount not matches successfully");

		Thread.sleep(200);

		wm.Netcollections("//input[@name='MiscRateDealFare']", "//input[@name='TotalTaxAmount']",
				"//input[@name='TotalServiceFee']", "//input[@name='TotalDiscount']", "//input[@name='TotOutputVat']",
				"//input[@name='Amt_NetCollection']", "Net calclaiton done correectly",
				"Net calclaiton not done correectly");

		wm.Publishedfare("//input[@name='MiscRateDealFare']", "//input[@name='TotalTaxAmount']",
				"//input[@name='salestotcommm']", "//input[@name='TotInputVat']", "//input[@name='Amt_NetPayable']",
				"Net payable Calclated successfuly", "Net payable not Calclated successfuly");
*/
		wm.Netcollectionuisngcancellatiocharges("//input[@name='MiscRateDealFare']", "//input[@name='TotalTaxAmount']",
				"//input[@name='TotalServiceFee']", "//input[@name='TotalDiscount']", "//input[@name='TotOutputVat']",
				"//input[@name='Amt_NetCollection']", "//*[@name='MiscRateSupplierCancellationChargeRfnd']",
				"//*[@name='MiscRateSupplierCancellationCharge']",
				"Net calclaiton done correectly by using the cancelaltion charges",
				"Net calclaiton not done correectly by using the cancelaltion charges");

		wm.Publishedfareusingcancelaltionchargeswithoutuccf("//input[@name='MiscRateDealFare']",
				"//input[@name='TotalTaxAmount']", "//input[@name='salestotcommm']",
				"//*[@name='MiscRateSupplierCancellationCharge']", "//input[@name='TotInputVat']",
				"//input[@name='Amt_NetPayable']", "Publishedfare done correectly by using the cancelaltion charges",
				"ublishedfare not done correectly by using the cancelaltion charges");

		wm.clickbyxpath("//*[@id='testData']/i");
		Thread.sleep(500);

		wm.clickbyxpath("//button[@id='btnmiscsave']");

		Thread.sleep(500);

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

		wm.doubleclickusingxpath("//button[@id='btnmiscsave']");

		Thread.sleep(16000);
		
		 wm.clickbyxpath("//*[@class='btn btn-danger']");
			Thread.sleep(500);
		
			wm.Listandenterquick("//span[contains(text(),'Leave Page')]", "0");
			wm.Listandenterquick("//span[contains(text(),'Leave Page')]", "1");
			wm.Listandenterquick("//span[contains(text(),'Leave Page')]", "2");
			wm.Listandenterquick("//span[contains(text(),'Leave Page')]", "3");
		 wm.sleep();
			
			/*wm.Listnegativescearios("//*[@id='DktNumber']", "0",
					"Pass : Sales Refund Misc    created successfuly" + "",
					"Fail:  Sales Refund Misc not created successfuly " + "");
			*/
		 

			wm.Verifythedropdownvalues("//input[@name='DktNumber']",
					"Pass : Sales Refund misc using docket   created successfuly" + "",
					"Fail:  Sales Refund misc using docket   not created successfuly " + "");
		
			
			Thread.sleep(2000);
			
			//wm.gettext("//*[@id='DktNumber']");
			
			wm.storestrign2("//input[@name='DktNumber']");
			
			//wm.gettext("//*[@id='DktNumber']");
			
			//wm.Gettextbylistandprint("//*[@id='DktNumber']", "Docketnumber is");
			
			
			Thread.sleep(300);

/*

		wm.doubleclickusingxpath("//button[@id='btnmiscsave']");

		Thread.sleep(200);
		
		wm.Mousemoveover("//input[@name='MiscIssuingExecutieveName_input']");
		Thread.sleep(200);
		wm.Listnegativescearios(utility.Constant.Travelogixuitooltipvalidation, "0",
				"Pass : Sales Refund MISC   created successfuly ,Docketnumber is" +Docketnumber,
				"Fail:  Sales Refund MISC   not created successfuly " + "");
*/	
		wm.Printmessages("Docketnumber is"+ Docketnumber);
	
		
		wm.sleep();

	}

	@AfterMethod
	public void close()

	{
		wm.close();

	}

	@DataProvider(name = "dp")
	public Object[][] dp() throws IOException {

		return Wrappermethods.getSheet("Miscdockect", "Miscdockect");

	}
}