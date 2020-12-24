package SalesrefundAir;

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
public class Airnegative {

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
	public void Airnegative(String Username, String Password, String Leftsidemenu, String Commonindex,
			String Notcollectedtick, String Partiallycollectedtick, String Collectedtickects, String Docketinbound,
			String Docketoutbound, String Salesbranchinactivedata, String Afterselesalesbranchcodereflected,
			String Acticecustomer, String Inactivecustomer, String Verifydocketinactivestatus,
			String dktClientReference, String dktTransactionReference, String Docktype, String Docktypeindex,
			String Salesbracnh, String Salesbracnhindex, String Customer, String Customerindex, String Leadpaxnamee,
			String BSPAirlines, String NonBspairlines,String BSPandNONBSPAirlines,String PayableagentAirline
			,String PayableagentAirlineindex,String Duplicateticketnumbevalidations,
			String BSPlnkedpayableagent,String Bookingexecutive,String Salesexecutive,
			String Bookingexecutiveinactivedata,String SupplierPCC,String AatdTicketNumber,
			String Fromsector,String Fromsectorindex,String Tosector,String Tosectorindex,String Publishedfare,
			String Sellingfare,String IncentiveCRC,String Companycurrency,String Lodgecard,String Processtype,
			String Processtypeindex,String AtfdIncentivePaid,String Aatcode,String Aatcodeindex,
			String AatAmount,String Namee,String Nameeindex,String AtscBaseAmount,String AtfdCommPercent1,
			String AtfdCommPercent2,String AtfdDiscPercent1,String Agentincetive,String Agentincetiveindexx,
			String Modeindex,String Selectedbranch,String TravelStatusDN,String Agentincentive,
			String Fopcustomer,String Tickectdigitmorethan10digit,String BSPPayableAgent,
			String NonPayableAgent,String AatdDate1,String AatdDate2,String 
			AatdDate3
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

		// 1 Workbench Search - not accountable dockets [Not collected ,
		// partillay collected ] -need to show ,
		// collected - no need to show

		// Not Collected

		wm.sendtextbyxvalue("//input[@aria-owns='dktKey_listbox']", Notcollectedtick);
		Thread.sleep(600);
		wm.Listandenter("//*[@id='dktKey_listbox']/li", Commonindex);
		Thread.sleep(600);

		wm.clickbyxpath("//button[@onclick='salesPreSearch()']");
		wm.sleep();
		wm.sleep();

		wm.Verifythealertpopupmessages(" //*[@title='Not Collected']", "Not Collected",
				"Not Collected based details are showing in the workbench ",
				"Not Collected details are not showing in the workbench ");
		Thread.sleep(200);
		wm.Clearbyxpath("//input[@aria-owns='dktKey_listbox']");
		Thread.sleep(500);

		// partillay collected

		wm.sendtextbyxvalue("//input[@aria-owns='dktKey_listbox']", Partiallycollectedtick);
		Thread.sleep(600);
		wm.Listandenter("//*[@id='dktKey_listbox']/li", Commonindex);
		Thread.sleep(600);

		wm.clickbyxpath("//button[@onclick='salesPreSearch()']");
		Thread.sleep(500);

		wm.Verifythealertpopupmessages("//*[@title='Partially Collected']", "Partially Collected",
				"Partially Collected based details are showing in the workbench ",
				"Partially Collected details are not showing in the workbench ");
		Thread.sleep(200);
		wm.Clearbyxpath("//input[@aria-owns='dktKey_listbox']");
		Thread.sleep(500);

		// point 2: need to discuss

		// 3 Sales Refund header Docket date Need to check the validations

		wm.clickbyid("btnMainAdd");
		Thread.sleep(600);

		wm.Clearbyxpath("//input[@aria-owns='DktDate_dateview']");
		Thread.sleep(300);

		wm.clickbyid("btnMainSave");
		Thread.sleep(300);

		// UI validation wihou enterthedetials and clickigt he save button

		// date validaitons
		wm.Mousemoveover("//input[@aria-owns='DktDate_dateview']");
		Thread.sleep(50);
		wm.Listnegativescearios(utility.Constant.Travelogixuitooltipvalidation, Commonindex,
				"Pass : Date validaiton is avilable in the date field" + "",
				"Fail : Date validaiton is not avilable in the date field" + "");
		Thread.sleep(200);

		// dockettype validatins
		wm.Mousemoveover("//input[@aria-owns='dktDocTypeCode_listbox']");
		Thread.sleep(50);
		wm.Listnegativescearios(utility.Constant.Travelogixuitooltipvalidation, Commonindex,
				"Pass : dktDocTypeCode_listbox validaiton is avilable in the docket  field" + "",
				"Fail : dktDocTypeCode_listbox validaiton is not avilable in the Docket  field" + "");
		Thread.sleep(200);

		// sales branch validaitons

		wm.Mousemoveover("//input[@aria-owns='DktBranchKey_listbox']");
		Thread.sleep(50);
		wm.Listnegativescearios(utility.Constant.Travelogixuitooltipvalidation, Commonindex,
				"Pass : DktBranchKey_listbox validaiton is avilable in the Branch  field" + "",
				"Fail : DktBranchKey_listbox validaiton is not avilable in the Branch  field" + "");
		Thread.sleep(200);

		// custmer validations

		wm.Mousemoveover("//input[@aria-owns='DktPartnername_listbox']");
		Thread.sleep(50);
		wm.Listnegativescearios(utility.Constant.Travelogixuitooltipvalidation, Commonindex,
				"Pass : DktPartnername_listbox validaiton is avilable in the Customer  field" + "",
				"Fail : DktPartnername_listbox validaiton is not avilable in the Customer field" + "");
		Thread.sleep(200);

		// LEad paxname validaitons
		// 9 Sales Refund header Lead passenger Field validatio empty data
		// validations

		wm.Mousemoveover("//input[@name='dktLeadPaxName']");
		Thread.sleep(50);
		wm.Listnegativescearios(utility.Constant.Travelogixuitooltipvalidation, Commonindex,
				"Pass : dktLeadPaxName validaiton is avilable in the name  field" + "",
				"Fail : dktLeadPaxName validaiton is not avilable in the name  field" + "");
		Thread.sleep(200);

		// 4 Sales Refund header Docket type checking inboun andoubund

		// verify the inbound is avilable

		wm.sendtextbyxvalue("//input[@aria-owns='dktDocTypeCode_listbox']", Docketinbound);
		Thread.sleep(50);
		wm.Listnegativescearios("//*[@id='dktDocTypeCode_listbox']/li", Commonindex,
				"Pass :  INBOUND DOCKET is avilable Docket  field" + "",
				"Fail:  INBOUND DOCKET is not avilable Docket  field" + "");
		Thread.sleep(200);

		// verify the Outbound is avilable

		wm.sendtextbyxvalue("//input[@aria-owns='dktDocTypeCode_listbox']", Docketoutbound);
		Thread.sleep(50);
		wm.Listnegativescearios("//*[@id='dktDocTypeCode_listbox']/li", Commonindex,
				"Pass :  Docketoutbound is avilable Docket  field" + "",
				"Fail:  Docketoutbound is not avilable Docket  field" + "");
		Thread.sleep(200);

		// 5 Sales Refund header Sales branch Branch master [ inactive data
		// should not be reflected ]

		wm.sendtextbyxvalue("//input[@aria-owns='DktBranchKey_listbox']", Salesbranchinactivedata);
		Thread.sleep(200);
		wm.Listnegativesceariosnegativecaseschecking("//*[@id='DktBranchKey_listbox']/li", Commonindex,
				"Pass :  Sales Branch,branch master inactive datas are not getting reflected" + "",
				"Fail:  Sales Branch branch master inactive datas are getting reflected" + "");
		Thread.sleep(200);

		// 6 Sales Refund header Once selected the sales branch Branch code
		// should reflected

		wm.sendtextbyxvalue("//input[@aria-owns='DktBranchKey_listbox']", Afterselesalesbranchcodereflected);
		Thread.sleep(50);
		wm.Listandenter("//*[@id='DktBranchKey_listbox']/li", Commonindex);
		Thread.sleep(200);

		wm.Verifythealertpopupmessagesusincontainsusinggetattribute("//input[@name='DktBranchCode']",
				Afterselesalesbranchcodereflected, "After Selected sales branch,Branch code get reflected",
				"After Selected sales branch,Branch code not get reflected");
		Thread.sleep(200);

		// 7 Customer field Bussine parnet data should reflected [only active
		// data
		// shoulod reflceted ,inactive data should not be reflceted ]

		// customer filed : Bussine parnet in active data not get reflected

		wm.sendtextbyxvalue("//input[@aria-owns='DktPartnername_listbox']", Inactivecustomer);
		Thread.sleep(90);
		wm.Listnegativesceariosnegativecaseschecking("//*[@id='DktPartnername_listbox']/li", Commonindex,
				"Pass :  Bussiness parnet in active data not get reflected in customer field" + "",
				"Fail:  Bussiness parnet in active data get reflected in customer field" + "");
		Thread.sleep(200);

		// customer filed : Bussine parnet activeleadd data get reflected
		wm.sendtextbyxvalue("//input[@aria-owns='DktPartnername_listbox']", Acticecustomer);
		Thread.sleep(200);
		wm.Listnegativescearios("//*[@id='DktPartnername_listbox']/li", Commonindex,
				"Pass : Bussiness parnet active data get reflected in customer field " + "",
				"Fail : Bussiness parnet active data not get reflected in customer field " + "");
		Thread.sleep(200);

		// 10 Sales Refund header client reference Free text

		wm.sendtextbycssselecotrwithoutclear("#dktClientReference", dktClientReference);
		Thread.sleep(200);
		wm.Verifythealertpopupmessagesusincontainsusinggetattribute("//input[@name='dktClientReference']",
				dktClientReference, "user enter the dktClientReference details successfully",
				"user not able to enter the dktClientReference details successfully");

		// 11 Sales Refund header Trasanction reference Free text

		wm.sendtextbycssselecotrwithoutclear("#dktTransactionReference", dktTransactionReference);
		Thread.sleep(200);
		wm.Verifythealertpopupmessagesusincontainsusinggetattribute("//input[@name='dktTransactionReference']",
				dktTransactionReference, "user enter the dktTransactionReference details successfully",
				"user not able to enter the dktTransactionReference details successfully");

		// 12 Sales Refund header Dockect typee Without selecting the dockect
		// type systm not allowed to
		// add the service
		
	//need to add

		wm.clickbyid("btnMainReturn");
		Thread.sleep(300);

		wm.clickbyid("btnMainAdd");
		Thread.sleep(500);


		
		wm.Listandenter("//i[@class='fa fa-chevron-down']", "0");
		Thread.sleep(200);
		wm.Listandenter("//i[@class='fa fa-plus']", "0");
		Thread.sleep(1200);

		wm.Mousemoveover("//input[@aria-owns='dktDocTypeCode_listbox']");
		Thread.sleep(50);
		wm.Listnegativescearios(utility.Constant.Travelogixuitooltipvalidation, Commonindex,
				"Pass : Without selecting the  dockect type system not allowed to add the service " + "",
				"Fail : Without selecting the  dockect type system  allowed to add the service" + "");
		Thread.sleep(200);

		// 8 Sales Refund header Docket inactive in docket any service is their,
		// inactivedetials should not be display ..

		wm.clickbyid("btnMainReturn");
		Thread.sleep(600);

		wm.sendtextbyxvalue("//input[@aria-owns='dktKey_listbox']", Verifydocketinactivestatus);
		Thread.sleep(600);
		wm.Listandenter("//*[@id='dktKey_listbox']/li", "1");
		Thread.sleep(600);

		wm.clickbyxpath("//button[@onclick='salesPreSearch()']");
		Thread.sleep(200);
		wm.Listandenter("//td[@data-field='dktLeadPaxName']", "0");
		Thread.sleep(200);
		wm.clickbyid("btnMainEdit");
		Thread.sleep(200);

		// selected the statuss

		wm.Listnegativesceariosnegativecaseschecking("//*[@id='Status_listbox']/li", Commonindex,
				"Pass :  User unable to selected the Status_listbox when service is avilabe in the docket " + "",
				"Fail:  User able to selected the Status_listbox when service is avilabe in the docket" + "");
		Thread.sleep(200);

		// 13 Air BSP checkbox BSP airline should get displayed in the dropdwon
		// [airline master ]

		wm.clickbyid("btnMainReturn");
		Thread.sleep(300);

		wm.clickbyid("btnMainAdd");
		Thread.sleep(500);

		// Dockett
		wm.sendtextbyxvalue("//input[@aria-owns='dktDocTypeCode_listbox']", Docktype);
		Thread.sleep(120);
		wm.Listandenter("//*[@id='dktDocTypeCode_listbox']/li", Docktypeindex);
		Thread.sleep(200);

		// Salesbranch
		wm.sendtextbyxvalue("//input[@aria-owns='DktBranchKey_listbox']", Salesbracnh);
		Thread.sleep(90);
		wm.Listandenter("//*[@id='DktBranchKey_listbox']/li", Salesbracnhindex);
		Thread.sleep(200);

		// customerr
		wm.sendtextbyxvalue("//input[@aria-owns='DktPartnername_listbox']", Customer);
		Thread.sleep(200);
		wm.keyboardarrowdown("//input[@aria-owns='DktPartnername_listbox']");
		Thread.sleep(200);
		wm.Enterbyxpath("//input[@aria-owns='DktPartnername_listbox']");
		Thread.sleep(200);
		/*
		wm.Listandenter("//*[@id='DktPartnername_listbox']/li", Customerindex);
		Thread.sleep(200);
	*/	wm.sendtextbycssselecotrwithoutclear("#dktLeadPaxName", "" + Leadpaxnamee);
		Thread.sleep(300);

		wm.Listandenter("//i[@class='fa fa-chevron-down']", "0");
		Thread.sleep(200);
		wm.Listandenter("//i[@class='fa fa-plus']", "0");
		Thread.sleep(1500);

		// wm.sendtextbycssselecotrwithoutclear("#dktTransactionReference",
		// BSPAirlines);
		wm.sendtextbyxvalue("//input[@aria-owns='AatdAirlineName_listbox']", BSPAirlines);
		Thread.sleep(200);
		wm.Listnegativescearios("//*[@id='AatdAirlineName_listbox']/li", Commonindex,
				"Pass :  BSP airlines reflected in Airline field" + "",
				"Fail:  BSP airlines not reflected in Airline field" + "");
		Thread.sleep(200);
		
		//BSP based payable agent
		
		wm.sendtextbyxvalue("//input[@aria-owns='AatdPayAgntCmsKey_listbox']", BSPPayableAgent);
		Thread.sleep(200);
		wm.Listnegativescearios("//*[@id='AatdPayAgntCmsKey_listbox']/li", Commonindex,
				"BSP based payable agent reflected in payable agent field ",
				"BSP based payable agent not reflected in payable agent field ");
		Thread.sleep(200);
		
		

		// 14 Air BSP uncheck Non bsp airlnes validaitons[airline master ]

		wm.sendtextbyxvalue("//input[@aria-owns='AatdAirlineName_listbox']", NonBspairlines);
		Thread.sleep(200);
		wm.keyboardarrowdown("//input[@aria-owns='AatdAirlineName_listbox']");
		Thread.sleep(200);
		wm.Enterbyxpath("//input[@aria-owns='AatdAirlineName_listbox']");
	     Thread.sleep(300);
		wm.Verifythealertpopupmessagesusincontainsusinggetattribute("//input[@aria-owns='AatdAirlineName_listbox']"
				, NonBspairlines, "14)Pass :  NON BSP airlines not reflected in BSP field[enter]", 
				"14)Fail:  NON BSP airlines reflected in BSP field[enter]");
		Thread.sleep(500);
		
/*
		//NON BSP based payable agent
		
		wm.sendtextbyxvalue("//input[@aria-owns='AatdPayAgntCmsKey_listbox']", NonPayableAgent);
		Thread.sleep(200);
		wm.Listnegativescearios("//*[@id='AatdPayAgntCmsKey_listbox']/li", Commonindex,
				"NON BSP based payable agent reflected in payable agent field ",
				"NON BSP based payable agent not reflected in payable agent field ");
		Thread.sleep(200);
*/		
		/*wm.Listnegativesceariosnegativecaseschecking("//*[@id='AatdAirlineName_listbox']/li", Commonindex,
				"Pass :  NON BSP airlines not reflected in BSP field",
				"Fail:  NON BSP airlines reflected in BSP field");
	*/	
		Thread.sleep(500);

		// ucheck the bsp airline box
		wm.clickbyxpath("//*[contains(text(),'BSP Stock')]");
	       Thread.sleep(200);
	       
		
		//wm.clickbyxpath("//*[@id='divairheader']/div[3]/div/label");
		Thread.sleep(500);

		wm.sendtextbyxvalue("//input[@aria-owns='AatdAirlineName_listbox']", NonBspairlines);
		Thread.sleep(200);
		wm.Listnegativescearios("//*[@id='AatdAirlineName_listbox']/li", Commonindex,
				"Pass :  NON BSP airlines reflected in BSP field After uncheck the BSP checkboxx",
				"Fail:  NON BSP airlines not reflected in BSP field After uncheck the BSP checkboxx");
		Thread.sleep(500);
		

		//NON BSP based payable agent
		
		wm.sendtextbyxvalue("//input[@aria-owns='AatdPayAgntCmsKey_listbox']", NonPayableAgent);
		Thread.sleep(200);
		wm.Listnegativescearios("//*[@id='AatdPayAgntCmsKey_listbox']/li", Commonindex,
				"NON BSP based payable agent reflected in payable agent field ",
				"NON BSP based payable agent not reflected in payable agent field ");
		Thread.sleep(300);


//15	Air 	BSP both lccand bsp	both get displayed

		//wm.clickbyid("AatdBSPFlag");
		wm.clickbyxpath("//*[contains(text(),'BSP Stock')]");
        Thread.sleep(500);
        
		wm.sendtextbyxvalue("//input[@aria-owns='AatdAirlineName_listbox']",BSPandNONBSPAirlines);
		Thread.sleep(200);
		wm.Listnegativescearios("//*[@id='AatdAirlineName_listbox']/li", Commonindex,
				"15) Pass :  BSP airlines reflected in Airline field After selected airline master as Both " + "",
				"15) Fail:  BSP airlines not reflected in Airline field After selected airline master as Both " + "");
		Thread.sleep(200);


		//wm.clickbyid("AatdBSPFlag");
		wm.clickbyxpath("//*[contains(text(),'BSP Stock')]");
	        Thread.sleep(500);

		wm.sendtextbyxvalue("//input[@aria-owns='AatdAirlineName_listbox']",BSPandNONBSPAirlines);
		Thread.sleep(200);
		wm.Listnegativescearios("//*[@id='AatdAirlineName_listbox']/li", Commonindex,
				"Pass :  BSP airlines reflected in Airline field After selected airline master as Both " + "",
				"Fail:  BSP airlines not reflected in Airline field After selected airline master as Both " + "");
		Thread.sleep(200);

//16	Air 	Docket header - sales branch	should refected from docket header to Air screen

		wm.Verifythealertpopupmessagesusincontainsusinggetattribute("//input[@aria-owns='AatdBranchKey_listbox']"
				, Salesbracnh, 
				"16)Pass :  Docket header - sales branch - from docket header reflected to Air screen", 
				"16)Fail:   Docket header - sales branch - from docket header not reflected to  Air screen");
	Thread.sleep(500);
	
	//52	Air 	Date Validations	User not allowed to enter the date greater than 
	//Current system date 


	wm.sendtextbycssselecotr("#AatdDate", "" + AatdDate1 + "-" + AatdDate2 + "-" + AatdDate3);

//wm.sendtextbycssselecotrwithoutclear("#AatdDate",AatdDate);
Thread.sleep(300);
wm.Mousemoveover("//input[@name='AatdDate']");
Thread.sleep(300);
wm.Listnegativescearios(utility.Constant.Travelogixuitooltipvalidation, Commonindex,
		"Date validaion is avilable if user enter the date grater than todays date",
		"Date validaion is not avilable if the user enter the date grater than todays date");
Thread.sleep(300);

		
		
		
//17	Air 	tickct number filed	Duplicate should not be allowed and 10 digit validation is compelsury 

//Try to enter mre tha 10 digit in ticketnuber field 

//Ticke number 10digit validations
wm.sendtextbycssselecotrwithoutclear("#AatdTicketNumber", ""+Tickectdigitmorethan10digit);
Thread.sleep(200);

wm.Listandenterquick("//span[contains(text(),'OK')]", "0");
wm.Listandenterquick("//span[contains(text(),'OK')]", "1");
wm.Listandenterquick("//span[contains(text(),'OK')]", "2");
wm.Listandenterquick("//span[contains(text(),'OK')]", "3");

wm.Checktextcount("//input[@id='AatdTicketNumber']",
		"System allowed to enter tickect number more than 10 digit", 
		"System not  allowed to enter tickect number more than 10 digit");
Thread.sleep(500);
//wm.Clearbyxpath("//input[@id='AatdTicketNumber']");
Thread.sleep(200);


wm.sendtextbycssselecotrwithoutclear("#AatdTicketNumber", ""+Duplicateticketnumbevalidations);

wm.clickbyid("btnMainSave");
wm.clickbyxpath("//*[@id='divairheader']/div[15]/label");

//wm.sendtextbyxvalue("//input[@onchange='']", Duplicateticketnumbevalidations);
Thread.sleep(900);
wm.Mousemoveover("//input[@id='AatdTicketNumber']");
Thread.sleep(500);
wm.Listnegativescearios(utility.Constant.Travelogixuitooltipvalidation, Commonindex,
		"17)Pass : Duplicateticketnumbevalidations validaiton is avilable in the Tickect  field" + "",
		"17)Fail : Duplicateticketnumbevalidations validaiton is not avilable in the Tickect  field" + "");
Thread.sleep(900);


//19	Air 	payable agent	BSP linked agent shouold get rreflcted

// airlinee
wm.sendtextbyxvalue("//input[@aria-owns='AatdAirlineName_listbox']",PayableagentAirline);
Thread.sleep(50);
wm.Listandenter("//*[@id='AatdAirlineName_listbox']/li", PayableagentAirlineindex);
Thread.sleep(200);


wm.sendtextbyxvalue("//input[@aria-owns='AatdPayAgntCmsKey_listbox']", BSPlnkedpayableagent);
Thread.sleep(100);
wm.keyboardarrowdown("//input[@aria-owns='AatdPayAgntCmsKey_listbox']");
Thread.sleep(100);
wm.Enterbyxpath("//input[@aria-owns='AatdPayAgntCmsKey_listbox']");
Thread.sleep(200);
wm.Verifythealertpopupmessagesusincontainsusinggetattribute("//input[@aria-owns='AatdPayAgntCmsKey_listbox']"
		, BSPlnkedpayableagent, 
		"19) Pass :  BSP linked agent get rreflcted in payable agent ", 
		"19) Fail:  BSP linked agent not get rreflcted in payable agent");


//20		Source agent	Selected payable agent sould get reflected in payable agent

Thread.sleep(200);
//Sourceagent
wm.Verifythealertpopupmessagesusincontainsusinggetattribute("//input[@aria-owns='AatdSrcAgntCmsKey_listbox']"
		, BSPlnkedpayableagent, 
		"20)Pass :  Selected payable agent reflected in Sourceagent", 
		"20)Fail:   Selected payable agent not reflected in Sourceagent");

//22	Air 	passenger name	Laed passenger should get sync fro hearder 
Thread.sleep(200);
wm.Verifythealertpopupmessagesusincontainsusinggetattribute("//input[@name='AatdPassengerName']"
		, Leadpaxnamee, 
		"22)Pass :  Leadpaxnamee reflected in Passenger name Field", 
		"22)Fail:   Leadpaxnamee not reflected in Passenger name Field");

Thread.sleep(200);

//23	Air 	Pax type	User able to select the pax type 

wm.clickbyxpath("//span[@aria-owns='AatdPassengerType_listbox']");

//wm.sendtextbyxvalue("//span[@aria-owns='AatdPassengerType_listbox']", AddresstypeName);
Thread.sleep(500);
wm.Listnegativescearios("//*[@id='AatdPassengerType_listbox']/li", Commonindex, 
		"23) Pass: User able to selected the pax type successfully"  + "", 
		"23) Fail: User not able to selected the pax type successfully"  + "");
Thread.sleep(500);



//24	Air 	Booking executive	Data get reflected from exeutivemaster [only active data should get reflected ,inactive should not be get displayed ]

wm.sendtextbyxvalue("//input[@aria-owns='AirBookingExecutieveName_listbox']", Bookingexecutive);
Thread.sleep(500);
wm.Listnegativescearios("//*[@id='AirBookingExecutieveName_listbox']/li", Commonindex, 
		"Newly created AirBookingExecutieveName_listbox reflected in Booking Executive  field  "  +  "", 
		"Newly created AirBookingExecutieveName_listbox not reflected in Booking Executive  field "  + "");
Thread.sleep(500);



//25	Air 	issuing executive	Data get reflected from exeutivemaster [only active data should get reflected ,inactive should not be get displayed ]

wm.Verifythealertpopupmessagesusincontainsusinggetattribute("//input[@aria-owns='AirIssuingExecutieveName_listbox']"
		, Bookingexecutive, "22)Pass :  Booking executive reflected in issue executive field", 
		"22)Fail:  Booking executive not reflected in issue executive field");


//26	Air 	Sales executive	Data get reflected from exeutivemaster [only active data should get reflected ,inactive should not be get displayed ]

wm.sendtextbyxvalue("//input[@aria-owns='AatdSalesExecutiveName_listbox']", Salesexecutive);
Thread.sleep(500);
wm.Listnegativescearios("//*[@id='AatdSalesExecutiveName_listbox']/li", Commonindex, 
		"Newly created AatdSalesExecutiveName_listbox reflected in Sales Executive  field  "  +  "", 
		"Newly created AatdSalesExecutiveName_listbox not reflected in Sales  Executive  field "  + "");
Thread.sleep(300);

//27	Air 	PNR field	PNR field mandatory validation checking

wm.doubleclickusingxpath("//*[@id='btnairsave']");

Thread.sleep(500);

wm.Mousemoveover("//input[@name='AatdPnrNumber']");
Thread.sleep(200);
wm.Listnegativescearios(utility.Constant.Travelogixuitooltipvalidation, Commonindex,
		"27 Pass : PNR validaiton is avilable in the PNR  field" + "",
		"27 Fail : PNR validaiton is not avilable in the PNR  field" + "");
Thread.sleep(200);


//24	Air 	Booking executive chekcing inactive data reflected


//wm.sendtextbyxvalue("//input[@aria-owns='AirBookingExecutieveName_listbox']", BSPlnkedpayableagent);
wm.sendtextbyxvalue("//input[@aria-owns='AirBookingExecutieveName_listbox']", Bookingexecutiveinactivedata);
Thread.sleep(100);
wm.keyboardarrowdown("//input[@aria-owns='AirBookingExecutieveName_listbox']");
Thread.sleep(100);
wm.Enterbyxpath("//input[@aria-owns='AirBookingExecutieveName_listbox']");
Thread.sleep(300);

wm.Verifythealertpopupmessagesnotequal("//input[@aria-owns='AirBookingExecutieveName_listbox']",
		Bookingexecutiveinactivedata, "24 25 26 inactive data not showing in AirBookingExecutieveName_listbox", 
		"24 25 26  inactive data  showing in AirBookingExecutieveName_listbox");
/*
wm.Verifythealertpopupmessagesusincontainsusinggetattribute("//input[@aria-owns='AirBookingExecutieveName_listbox']"
		, Bookingexecutiveinactivedata, 
		"24,25,26) Pass :  inactive datas is not reflected in AirBookingExecutieveName_listbox", 
		"24,25,26) Fail:  inactive datas is  reflected in AirBookingExecutieveName_listbox");
*/Thread.sleep(300);

//30	Other details	Booking pcc field	Bussinee partner -supplier - pcc details shoulg get displayedd


/*wm.clickbyxpath("//span[@aria-owns='AatdIssuingPcc_listbox']");
Thread.sleep(200);
wm.clickbyxpath("//span[contains(text(),'SupplierPCC')]");
Thread.sleep(200);

//wm.selectbyValuexp("//span[@aria-owns='AatdIssuingPcc_listbox']",PCC);
//Thread.sleep(200);
wm.Verifythealertpopupmessagesusincontainsusinggetattribute("//span[@aria-owns='AatdIssuingPcc_listbox']"
		,SupplierPCC, "30)Pass :  Bussinee partner -supplier - pcc details get reflected", 
		"30)Fail:  Bussinee partner -supplier - pcc details get reflected");

*/
//Sector details : 

wm.sendtextbycssselecotrwithoutclear("#AatdTicketNumber", AatdTicketNumber);
Thread.sleep(200);
wm.stabbyxpath("//input[@name='AtfdReasonCode']");
Thread.sleep(600);

wm.Listandenter("//span[@class='k-icon k-i-add']", "0");
Thread.sleep(300);

//31	Sector details	From secot	User able to select the sector detailss
// from sector
wm.sendtextbyxvalue("//input[@aria-owns='AasegOriginKeyCode_listbox']", Fromsector);
Thread.sleep(100);
wm.Listnegativescearios("//*[@id='AasegOriginKeyCode_listbox']/li", Fromsectorindex, 
		"User able to select the from sector details successfully", 
		"User not able to select the from sector details successfully");

//wm.Listandenter("//*[@id='AasegOriginKeyCode_listbox']/li", Fromsectorindex);
Thread.sleep(200);


//32	Sector details	to sector	User able to select the sector detailss
//Tosector
wm.sendtextbyxvalue("//input[@aria-owns='AasegDestinationKeyCode_listbox']", Tosector);
Thread.sleep(100);
wm.Listnegativescearios("//*[@id='AasegDestinationKeyCode_listbox']/li", Tosectorindex, 
		"User able to select the to sector details successfully", 
		"User not able to select the to sector details successfully");

//wm.Listandenter("//*[@id='AasegDestinationKeyCode_listbox']/li", Tosectorindex);
Thread.sleep(200);

//33	Sector details	Airline 	sync fromheader
wm.Verifythealertpopupmessagesusincontainsusinggetattribute("//input[@aria-owns='AasegAirlineKey_listbox']"
		,PayableagentAirline, "33)Pass :  Airline detials sync from header to Sector", 
		"33)Fail:  Airline detials not sync from header to Sector");


//34 : no feasability


//35	Sector details	tickectnumber	Sync fromheader
wm.Verifythealertpopupmessagesusincontainsusinggetattribute("//input[@name='AasegTicketNumber']"
		,AatdTicketNumber, "33)Pass :  AatdTicketNumber detials sync from header tickect field ", 
		"33)Fail:  AatdTicketNumber detials not sync from header tickect field ");

//36 need to testin positive flow


//36	Sector details	Conjuction functionaity	After selecting four secotrs , 
//fifth sectors have new tickect has been generated 
/*
wm.clickbyxpath("//span[@class='k-icon k-i-check']");
Thread.sleep(600);

//sector 2
wm.Listandenter("//span[@class='k-icon k-i-add']", "0");
Thread.sleep(200);

wm.sendtextbyxvalue("//input[@aria-owns='AasegDestinationKeyCode_listbox']", Tosector1);
Thread.sleep(100);
wm.Listnegativescearios("//*[@id='AasegDestinationKeyCode_listbox']/li", Tosectorindex, 
		"User able to select the to sector details successfully", 
		"User not able to select the to sector details successfully");
Thread.sleep(200);
wm.clickbyxpath("//span[@class='k-icon k-i-check']");
Thread.sleep(600);

//sector 3
wm.Listandenter("//span[@class='k-icon k-i-add']", "0");
Thread.sleep(100);

wm.sendtextbyxvalue("//input[@aria-owns='AasegDestinationKeyCode_listbox']", Tosector2);
Thread.sleep(100);
wm.Listnegativescearios("//*[@id='AasegDestinationKeyCode_listbox']/li", Tosectorindex, 
		"User able to select the to sector details successfully", 
		"User not able to select the to sector details successfully");
Thread.sleep(200);

wm.clickbyxpath("//span[@class='k-icon k-i-check']");
Thread.sleep(600);

//sector 4
wm.Listandenter("//span[@class='k-icon k-i-add']", "0");
Thread.sleep(200);



wm.sendtextbyxvalue("//input[@aria-owns='AasegDestinationKeyCode_listbox']", Tosector3);
Thread.sleep(100);
wm.Listnegativescearios("//*[@id='AasegDestinationKeyCode_listbox']/li", Tosectorindex, 
		"User able to select the to sector details successfully", 
		"User not able to select the to sector details successfully");
Thread.sleep(200);


wm.clickbyxpath("//span[@class='k-icon k-i-check']");
Thread.sleep(600);


//sector 5
wm.Listandenter("//span[@class='k-icon k-i-add']", "0");
Thread.sleep(200);
wm.clickbyxpath("//span[@class='k-icon k-i-check']");
Thread.sleep(600);

wm.Verifythealertpopupmessagesusincontainsusinggetattributenegative("/html/body/div[46]/div[2]/div[1]/div[1]/div[5]/div/div[2]/div/div/div/div/div[4]/table/tbody/tr[5]/td[3]"
		,AatdTicketNumber, "36)Fail :  Conjuction functionaity not created successfully ", 
		"36)Pass:  Conjuction functionaity created successfully");

*/

//Need to enter the Fare details


wm.Listandenter("//span[@class='k-icon k-i-check']", "0");
Thread.sleep(500);

wm.clickbyxpath("//*[@id='divAirsectordtls']/div/div[1]/div[1]/a/i");
Thread.sleep(500);

//37	Fare details	Currency	Company curreny should get reflected

wm.sendtextbyxvalue("//input[@aria-owns='AtfdTransCurrency_listbox']", Companycurrency);
Thread.sleep(200);
wm.Listnegativescearios("//*[@id='AtfdTransCurrency_listbox']/li", Commonindex,
		"Pass : Newly created curreny reflected in currenyfield" + "",
		"Fail : Newly created curreny not reflected in currenyfield" + "");
Thread.sleep(200);

// 39	Fare details	Lodge card dropdowns	Lodge card sttuas =yes , shuld reflected , otherwise is no

wm.sendtextbyxvalue("//input[@aria-owns='AtfdOwnLodgeCardName_listbox']", Lodgecard);
Thread.sleep(200);
wm.Listnegativescearios("//*[@id='AtfdOwnLodgeCardName_listbox']/li", Commonindex,
		"Pass : Newly created AtfdOwnLodgeCardName_listbox reflected in Lodge field" + "",
		"Fail : Newly created AtfdOwnLodgeCardName_listbox not reflected in Lodge field" + "");
Thread.sleep(200);

//40	Fare details	published fare	published fare - selling fare =income received 
//41	Fare details	Selling fare 	



// Faredetails==============================================================

wm.sendtextbyxvalue("//input[@aria-owns='AtfdProcessTypeKey_listbox']", Processtype);
Thread.sleep(100);
wm.Listandenter("//*[@id='AtfdProcessTypeKey_listbox']/li", Processtypeindex);
Thread.sleep(200);
// publishedfare
wm.sendtextbycssselecotrwithoutclear("#AtfdBaseFare", "" + Publishedfare);
Thread.sleep(200);

wm.stabbyxpath("//input[@name='AtfdBaseFare']");
Thread.sleep(4000);	
// sellngfare

wm.Deletedefaultvaluesinthetextbox("//input[@name='AtfdDealFare']");

//wm.Clearbyxpath("//input[@name='AtfdDealFare']");

//wm.sendtextbycssselecotr("#AtfdDealFare", "" +"0");
Thread.sleep(500);
wm.sendtextbycssselecotr("#AtfdDealFare", Sellingfare);
//wm.sendtextbycssselecotr("", txt);

Thread.sleep(600);
wm.clickbyxpath("//input[@name='AFAirlineIncentiveReceived']");
Thread.sleep(1000);


//case 40 ,4111
//Fare details	Lodge card dropdowns	Lodge card sttuas =yes , shuld reflected , otherwise is no
//Fare details	published fare	published fare - selling fare =income received 
//Fare details	Selling fare 	

wm.comparetwovaluesandsubract("//input[@name='AtfdBaseFare']", "//input[@name='AtfdDealFare']", 
		"//input[@name='AFAirlineIncentiveReceived']",
		"40 41 Pass : Amount calclation done successfully for published  fare - selling fare =income received ",
		"40 41 Fail : Amount calclation done wrongly  for published  fare - selling fare =income received");
Thread.sleep(200);


//42	Fare details	ORC paid	Should not be grater than incentive receivedd

wm.comparetwovaluesandsubract("//input[@name='AtfdBaseFare']", "//input[@name='AtfdDealFare']", 
		"//input[@name='AFAirlineIncentiveReceived']",
		"40 41 Pass : Amount calclation done successfully for published  fare - selling fare =income received ",
		"40 41 Fail : Amount calclation done wrongly  for published  fare - selling fare =income received");
Thread.sleep(200);



//====================================================================================================
//incentive received ORCpaid

wm.sendtextbyxvalue("//input[@name='AtfdIncentivePaid']",""+AtfdIncentivePaid);
Thread.sleep(500);
wm.Mousemoveover("//input[@name='AtfdIncentivePaid']");
Thread.sleep(50);
wm.Listnegativescearios(utility.Constant.Travelogixuitooltipvalidation, Commonindex,
		"Pass : AtfdIncentivePaid validaiton is avilable in the AtfdIncentivePaid field" ,
		"Fail : AtfdIncentivePaid validaiton is not avilable in the AtfdIncentivePaid field" );
Thread.sleep(200);



//==============================================================================================


//====================================================================================================

//secondtime

//publishedfare
wm.sendtextbycssselecotrwithoutclear("#AtfdBaseFare", "" + Publishedfare);
Thread.sleep(200);

wm.stabbyxpath("//input[@name='AtfdBaseFare']");
Thread.sleep(4000);	
//sellngfare

wm.Deletedefaultvaluesinthetextbox("//input[@name='AtfdDealFare']");

//wm.Clearbyxpath("//input[@name='AtfdDealFare']");

//wm.sendtextbycssselecotr("#AtfdDealFare", "" +"0");
Thread.sleep(500);
wm.sendtextbycssselecotr("#AtfdDealFare", Sellingfare);
//wm.sendtextbycssselecotr("", txt);

Thread.sleep(600);
wm.clickbyxpath("//input[@name='AFAirlineIncentiveReceived']");
Thread.sleep(1000);


//=========================================================================================

//Chekcing tax modulee

// 43	Tax	Total tax amount	selected tax amount should reflected 

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

//checking the TAX totlaamount

wm.comparetwovalues1to1("//input[@name='TaxTotal']","//input[@name='TotalTaxAmount']", 
		"43 tax Pass Added tax reflcted in total amount grid ", "43 Tax : Fail Added tax not reflcted in total amount grid ");
Thread.sleep(200);


//checking the vat
wm.comparetwovalues1to1("//input[@name='AirServiceFeeTotal']","//input[@name='TotalServiceFee']", 
		"43 VAT Pass Added VAT reflcted in total amount grid ", "43 VAT : Fail Added VAT not reflcted in total amount grid ");
Thread.sleep(200);



// Enter the commission amunt

wm.sendtextbycssselecotrwithoutclear("#AtfdCommPercent1", "" + AtfdCommPercent1);
Thread.sleep(90);

wm.sendtextbycssselecotrwithoutclear("#AtfdCommPercent2", "" + AtfdCommPercent2);
Thread.sleep(90);

wm.sendtextbycssselecotrwithoutclear("#AtfdDiscPercent1", "" + AtfdDiscPercent1);
Thread.sleep(600);


//Compare the cimmission values : 

wm.comparetwovalues2to1("//input[@name='AtfdCommAmount1']", "//input[@name='AtfdCommAmount2']", 
		"//input[@name='salestotcommm']"
		, "44 Pass: Cmmmission amount caluclaiton mathes successfully"
		, "44 Fail : Cmmmission amount caluclaiton not mathes successfully");
Thread.sleep(1200);

//compare the discount values

wm.comparetwovalues1to1("//input[@name='AtfdDiscAmount1']", 
		"//input[@name='TotalDiscount']"
		, "45 Pass: Disocunt calcualtion done successfully", 
		" 45 Fail : Disocunt calcualtion not done successfully");
Thread.sleep(600);


//46	Commission	Agent account	Agent incetive detials should get reflected

wm.sendtextbyxvalue("//input[@aria-owns='AAtscPaybackParnerDesc_listbox']", Agentincentive);
Thread.sleep(200);
wm.Listnegativescearios("//*[@id='AAtscPaybackParnerDesc_listbox']/li", "0",
		"46 Pass :   Active Agentincentive get displayed in the drop down " ,
		"46 Fail:   In Active Agentincentive get displayed in the drop down " );

Thread.sleep(500);


wm.stabbyxpath("//input[@name='AtfdDiscAmount1']");
Thread.sleep(200);

wm.clickbyxpath("//*[@id='div_Air_Header_Details']/div[7]/div/div[1]/div[1]/a/i");
Thread.sleep(600);




// agent incentivee

wm.sendtextbyxvalue("//input[@aria-owns='AAtscPaybackParnerDesc_listbox']", Agentincetive);
Thread.sleep(900);
wm.Listandenter("//*[@id='AAtscPaybackParnerDesc_listbox']/li", Agentincetiveindexx);
Thread.sleep(500);

//Enter the FOPwindows

wm.Listandenter("//span[@class='k-icon k-i-add']", "3");
Thread.sleep(200);

//wm.Listandenter("//*[contains(text(),'Yes')]", "0");
Thread.sleep(2000);

//47	FOP	FOP Validaion 	Validation is based on : bussineess partner screen  , customer creidt limit

wm.sendtextbyxvalue("//input[@aria-owns='fbpcode_listbox']", Fopcustomer);
Thread.sleep(3000);
wm.keyboardarrowdownonetime("//input[@aria-owns='fbpcode_listbox']");

//wm.keyboardarrowdown("//input[@aria-owns='fbpcode_listbox']");
Thread.sleep(200);
wm.Enterbyxpath("//input[@aria-owns='fbpcode_listbox']");

//wm.enterbyxpath("", "//input[@aria-owns='fbpcode_listbox']");
Thread.sleep(1000);

/*wm.Listnegativescearios("//*[@id='fbpcode_listbox']/li", "0",
		"46 Pass :   Selected the given customer in the drop down " ,
		"46 Fail:   Not Selected the given customer in the drop down " );
*/Thread.sleep(1000);

wm.Listandenter("//button[@id='ConformationYes']", "0");

/*wm.Listnegativescearios("//button[@id='ConformationYes']", "0",
		"47 48 Pass :FOP validation is avilable" ,
		"47 48 Fail:FOP validation is not avilable" );
*/

Thread.sleep(900);
wm.doubleclickusingxpath("//span[@class='k-icon k-i-cancel']");
Thread.sleep(900);

wm.Listandenter("//span[@class='k-icon k-i-add']", "3");
Thread.sleep(900);


wm.Listandenter("//button[@id='ConformationYes']", "0");



//49	FOP	Total FOP amount and net collections	Amount calculation should match ..then 
// only allowed to save the data succesfully

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
wm.Listandenter("//*[@id='fbbranch_listbox']/li","0");
//wm.Listandenter("//*[@id='fbbranch_listbox']/li","1");

Thread.sleep(300);



wm.doubleclickusingxpath("//span[@class='k-icon k-i-check']");
Thread.sleep(500);

wm.stabbyxpath("//*[@id='AirFOPDetailGrid']/div[5]/span[1]/span/span/span[2]/span");
wm.clickbyxpath("//*[@id='AirFOPDetailGrid']/div[5]/span[1]/span/span/span[2]/span");
wm.clickbyxpath("//*[@id='AirFOPDetailGrid']/div[5]/span[1]/span/span/span[2]/span");

Thread.sleep(400);

wm.comparetwovalues1to1("//input[@name='AirFopAmount']"
		, "//input[@name='Amt_NetCollection']", 
		"49 Pass: FOP and total amount matches successfully"
		, "49 Fail: FOP and total amount not matches successfully");
Thread.sleep(200);


wm.Netcollectionsuisngorc("//input[@name='AtfdBaseFare']", "//input[@name='AtfdIncentivePaid']"
		, "//input[@name='TotalTaxAmount']",
		"//input[@name='TotalServiceFee']", "//input[@name='TotalDiscount']", " //input[@name='TotOutputVat']", 
		"//input[@name='Amt_NetCollection']", "Net collection  done correectly", "Net collection not done correectly");
Thread.sleep(200);


wm.Publishedfareusingorc("//input[@name='AtfdBaseFare']", "//input[@name='AtfdIncentivePaid']", 
		"//input[@name='TotalTaxAmount']", "//input[@name='salestotcommm']"
		,"//input[@name='TotInputVat']", "//input[@name='Amt_NetPayable']", "Net payable Calclated successfuly", 
		"Net payable not Calclated successfuly");






wm.Netcollectionsuisngorcandcancellatiocharges("//input[@name='AtfdBaseFare']", "//input[@name='AtfdIncentivePaid']"
		, "//input[@name='TotalTaxAmount']",
		"//input[@name='TotalServiceFee']", "//input[@name='TotalDiscount']", " //input[@name='TotOutputVat']", 
		"//input[@name='Amt_NetCollection']", "//input[@name='AtfdAgentCancelCharge']",
		" //input[@name='AtfdAirlineCancelCharge']","Net collection  done correectly", "Net collection not done correectly");
Thread.sleep(200);


wm.Publishedfareusingcancelaltioncharges("//input[@name='AtfdDealFare']", "//input[@name='TotalTaxAmount']"
		,"//input[@name='salestotcommm']", "//input[@name='AtfdAirlineCancelCharge']", 
		"//input[@name='TotInputVat']", "", "//input[@name='Amt_NetPayable']", 
		"Net publishedfare Calclated successfuly using cancelaltion charges"
		, "Net publishedfare not Calclated successfuly using cancelaltion charges");

Thread.sleep(200);

wm.Airprofitcalculations("//input[@name='salestotcommm']", "//input[@name='TotalServiceFee']",
		"//input[@name='TotalDiscount']", "//input[@name='AtfdAgentCancelCharge']",
		"//input[@name='AFAirlineIncentiveReceived']", "//input[@name='AtfdIncentivePaid']");

//udid details
//		wm.clickbyxpath("//*[@id='testData']/i");
		Thread.sleep(900);

		

//		wm.clickbyxpath("//*[@id='acc110']/i");
//	Thread.sleep(300);
		
	/*	wm.stabbyxpath("//*[@id='acc110']/i");
		Thread.sleep(600);
		
		
		wm.sendtextbycssselecotrwithoutclear("#Travel_Status_DN", ""+TravelStatusDN);
		Thread.sleep(600);
		
	*/	
//clicking the savebuttons
	
		/*wm.clickbyxpath("//button[@id='btnairsave']");
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
*/	
	



//============================================================================================================
		
		//wm.sleep();
		Thread.sleep(500);

		
	}

	@AfterMethod
	public void close()

	{
		wm.close();

	}

	@DataProvider(name = "dp")
	public Object[][] dp() throws IOException {

		return Wrappermethods.getSheet("Airnegative", "Airnegative");

	}
}