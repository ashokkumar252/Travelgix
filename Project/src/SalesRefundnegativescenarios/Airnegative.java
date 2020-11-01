package SalesRefundnegativescenarios;

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

		wm.launchbrowser("chrome", utility.Constant.TRAVELOGIXURL);

	}

	@Test(dataProvider = "dp")
	public void logincheckK(String Username, String Password, String Leftsidemenu, String Commonindex,
			String Notcollectedtick, String Partiallycollectedtick, String Collectedtickects, String Docketinbound,
			String Docketoutbound, String Salesbranchinactivedata, String Afterselesalesbranchcodereflected,
			String Acticecustomer, String Inactivecustomer,String Verifydocketinactivestatus,
			String dktClientReference,String dktTransactionReference) throws Exception

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

		// 1 Workbench Search - not accountable dockets [Not collected ,
		// partillay collected ] -need to show ,
		// collected - no need to show

		// Not Collected

		wm.sendtextbyxvalue("//input[@aria-owns='dktKey_listbox']", Notcollectedtick);
		Thread.sleep(600);
		wm.Listandenter("//*[@id='dktKey_listbox']/li", Commonindex);
		Thread.sleep(600);

		wm.clickbyxpath("//button[@onclick='salesPreSearch()']");
		Thread.sleep(500);

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
		//9	Sales Refund header	Lead passenger	Field validatio empty data validations


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
		Thread.sleep(200);
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

//10	Sales Refund header	client reference	Free text
		
wm.sendtextbycssselecotrwithoutclear("#dktClientReference", dktClientReference);
Thread.sleep(200);
wm.Verifythealertpopupmessagesusincontainsusinggetattribute("//input[@name='dktClientReference']", dktClientReference,
		"user enter the dktClientReference details successfully", 
		"user not able to enter the dktClientReference details successfully");
		
//11	Sales Refund header	Trasanction reference	Free text

wm.sendtextbycssselecotrwithoutclear("#dktTransactionReference", dktTransactionReference);
Thread.sleep(200);
wm.Verifythealertpopupmessagesusincontainsusinggetattribute("//input[@name='dktTransactionReference']", dktTransactionReference,
		"user enter the dktTransactionReference details successfully", 
		"user not able to enter the dktTransactionReference details successfully");
		
		
//12	Sales Refund header	Dockect typee	Without selecting the  dockect type systm not allowed to 
//add the service 
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

		wm.sendtextbyxvalue("//input[@aria-owns='dktKey_listbox']",Verifydocketinactivestatus);
		Thread.sleep(600);
		wm.Listandenter("//*[@id='dktKey_listbox']/li", "1");
		Thread.sleep(600);

		wm.clickbyxpath("//button[@onclick='salesPreSearch()']");
		Thread.sleep(200);
		wm.Listandenter("//td[@data-field='dktLeadPaxName']", "0");
		Thread.sleep(200);
		wm.clickbyid("btnMainEdit");
		Thread.sleep(200);
		
		//selected the statuss	
		
		wm.Listnegativesceariosnegativecaseschecking("//*[@id='Status_listbox']/li", Commonindex,
				"Pass :  User unable to selected the Status_listbox when service is avilabe in the docket " + "",
				"Fail:  User able to selected the Status_listbox when service is avilabe in the docket" + "");
		Thread.sleep(200);

		
		
		wm.sleep();
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