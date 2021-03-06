//WASTA login screen
package travlogixnegativescenarios;
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
public class Airscrulenegative
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
	public void Airscrulenegative(String Username, String Password, String Leftsidemenu,String Commonindex,
			String Airlinedesc,String Chargenamemaster,String Tickecttype,String Classtypee,
			String Regionmaster,String Traveltype,String Suppliername,String Servicechargename,
			String inactiveAirlinedesc,String inactiveChargenamemaster,String inactiveTickecttype,
			String inactiveClasstypee,String inactiveRegionmaster,String inactiveTraveltype,
			String inactiveSuppliername
) throws Exception

	{

		Thread.sleep(2000);

		// wm.sendtextbyid("", );
		wm.sendtextbyid("LoginCode", Username);
		wm.stab("LoginCode");
		Thread.sleep(200);
		wm.sendtextbyid("Password", Password);
		Thread.sleep(200);
		wm.clickbyxpath("//input[@value='Login']");
		wm.sleep();

		// ====================Creating Air Service Charge Rule Master negative scenarios
		// screnn===========================================================
		wm.sendtextbyid("input-items", Leftsidemenu);
		Thread.sleep(500);
		wm.clickbyid("modTRS001");
		Thread.sleep(500);
		wm.clickbyid("pgmASR001");
		wm.sleep();

//		1	Air Service Charge Rule	Clicking the save button without changes

		wm.clickbyid("btnMainSave");
		wm.sleep();

		wm.Verifythealertpopupmessagesusincontains("//span[@id='diaInfoMessage']",
				"changes",
				"without doing changes clicking the save button , System showing validation messages correctly ",
				"without doing changes clicking the save button ,  System showing validation messages not correctly ");
		Thread.sleep(300);

		wm.Listandenterquick("//span[contains(text(),'OK')]", "0");
		wm.Listandenterquick("//span[contains(text(),'OK')]", "1");
		wm.Listandenterquick("//span[contains(text(),'OK')]", "2");
		wm.Listandenterquick("//span[contains(text(),'OK')]", "3");
		Thread.sleep(500);

		
//2	Air Service Charge Rule	Verify the Audit log Popup opening


		wm.clickbyid("btnAuditLog");
		Thread.sleep(300);
		wm.Verifythealertpopupmessagesusincontains("//span[@id='AuditLog_wnd_title']", "Audit Log",
				"When clicking the audit log icon system displays the auditlog popup",
				"When clicking the audit log icon system displays the auditlog popup");
		Thread.sleep(300);

		wm.Listandenterquick("//span[@class='k-icon k-i-close']", "0");
		wm.Listandenterquick("//span[@class='k-icon k-i-close']", "1");
		wm.Listandenterquick("//span[@class='k-icon k-i-close']", "2");
		wm.Listandenterquick("//span[@class='k-icon k-i-close']", "3");
		Thread.sleep(300);


//==================================================================================
		
//3	Air Service Charge Rule	Verify the UI field validations

		wm.clickbyid("btnMainAdd");
		Thread.sleep(500);
		wm.Clearbyxpath("//input[@name='ActiveFrom']");
		Thread.sleep(200);		
		wm.clickbyxpath("//span[@aria-owns='Status_listbox']");
        Thread.sleep(200);
        wm.Listandenterquick("//span[@aria-owns='Status_listbox']", "0");
        Thread.sleep(300);
        wm.clickbyxpath("//span[@class='k-icon k-i-check']");
        Thread.sleep(300);
        
        //sevricchargename field
        wm.Mousemoveover("//input[@name='AirServiceChargeName']");
		Thread.sleep(300);
		wm.Listnegativescearios(utility.Constant.Travelogixuitooltipvalidation, Commonindex,
				"Pass :  Service Charge Name validations is avilable " + "",
				"Fail:  Service Charge Name  validations is not avilable " + "");
		Thread.sleep(300);
		
        //airline validations
		  wm.Mousemoveover("//input[@name='AirlineDesc_input']");
			Thread.sleep(300);
			wm.Listnegativescearios(utility.Constant.Travelogixuitooltipvalidation, Commonindex,
					"Pass :  AirlineDesc_input validations is avilable " + "",
					"Fail:  AirlineDesc_input validations is not avilable " + "");
			Thread.sleep(300);
			

        //Class type field
        wm.Mousemoveover("//input[@name='ClassTypeCode_input']");
		Thread.sleep(300);
		wm.Listnegativescearios(utility.Constant.Travelogixuitooltipvalidation, Commonindex,
				"Pass :  ClassTypeCode_input validations is avilable " + "",
				"Fail:  ClassTypeCode_input  validations is not avilable " + "");
		Thread.sleep(300);
		

        //Chargename type field
        wm.Mousemoveover("//input[@name='ascChargeKey_input']");
		Thread.sleep(300);
		wm.Listnegativescearios(utility.Constant.Travelogixuitooltipvalidation, Commonindex,
				"Pass :  Chargename validations is avilable " + "",
				"Fail:  Chargename  validations is not avilable " + "");
		Thread.sleep(300);
		


        //Regionn type field
        wm.Mousemoveover("//input[@name='RegionTypeCode_input']");
		Thread.sleep(300);
		wm.Listnegativescearios(utility.Constant.Travelogixuitooltipvalidation, Commonindex,
				"Pass :  Regionn validations is avilable " + "",
				"Fail:  Regionn  validations is not avilable " + "");
		Thread.sleep(300);



/*        //Regionn type field
        wm.Mousemoveover("//input[@name='ascChargeKey_input']");
		Thread.sleep(300);
		wm.Listnegativescearios(utility.Constant.Travelogixuitooltipvalidation, Commonindex,
				"Pass :  Regionn validations is avilable " + "",
				"Fail:  Regionn  validations is not avilable " + "");
		Thread.sleep(300);
*/		

        //Tickect type field
        wm.Mousemoveover("//input[@name='TicketTypeCode_input']");
		Thread.sleep(300);
		wm.Listnegativescearios(utility.Constant.Travelogixuitooltipvalidation, Commonindex,
				"Pass :  TicketTypeCode_input validations is avilable " + "",
				"Fail:  TicketTypeCode_input  validations is not avilable " + "");
		Thread.sleep(300);




        //Efffective datge validations
        wm.Mousemoveover("//input[@name='ActiveFrom']");
		Thread.sleep(300);
		wm.Listnegativescearios(utility.Constant.Travelogixuitooltipvalidation, Commonindex,
				"Pass :  ActiveFrom validations is avilable " + "",
				"Fail:  ActiveFrom  validations is not avilable " + "");
		Thread.sleep(300);

		


        //Travel typee validations
        wm.Mousemoveover("//input[@name='TravelTypeCode_input']");
		Thread.sleep(300);
		wm.Listnegativescearios(utility.Constant.Travelogixuitooltipvalidation, Commonindex,
				"Pass :  TravelTypeCode_input validations is avilable " + "",
				"Fail:  TravelTypeCode_input  validations is not avilable " + "");
		Thread.sleep(300);
		
		wm.clickbyxpath("//span[@class='k-icon k-i-cancel']");
		Thread.sleep(200);
		wm.clickbyid("btnMainAdd");
		Thread.sleep(300);
		

//4	Air Service Charge Rule	Newly created Ailine master refleced in the Airline field

		
		wm.sendtextbyxvalue("//input[@aria-owns='AirlineDesc_listbox']", Airlinedesc);
		Thread.sleep(100);
		wm.Listnegativescearios("//*[@id='AirlineDesc_listbox']/li", "0", "Nwly created airline master reflcted in the Airline Field  ",
				"Nwly created airline master not reflcted in the Airline Field");
		Thread.sleep(100);
		
		
		
//5	Air Service Charge Rule	Newly created Charge name master  refleced in the Charge name field
		wm.sendtextbyxvalue("//input[@aria-owns='ascChargeKey_listbox']",Chargenamemaster);
		Thread.sleep(100);
		wm.Listnegativescearios("//*[@id='ascChargeKey_listbox']/li", "0", "Nwly created Chargename master  reflcted in the Chargename Field  ",
				"Nwly created Chargename master  not reflcted in the Chargename Field");
		Thread.sleep(100);
		
		
//6	Air Service Charge Rule	Newly created Ticket type  master  refleced in the Ticket type  field
		wm.sendtextbyxvalue("//input[@aria-owns='TicketTypeCode_listbox']",Tickecttype);
		Thread.sleep(100);
		wm.Listnegativescearios("//*[@id='TicketTypeCode_listbox']/li", "0", "Newly created Tickecttype  master  reflcted in the tickect type Field  ",
				"Newly created Tickecttype  master not reflcted in the tickect type Field ");
		Thread.sleep(100);
		
		
//7	Air Service Charge Rule	Newly created Class  type  master  refleced in the Class  type field
		wm.sendtextbyxvalue("//input[@aria-owns='ClassTypeCode_listbox']",Classtypee);
		Thread.sleep(100);
		wm.Listnegativescearios("//*[@id='ClassTypeCode_listbox']/li", "0", "Newly created Classtype  master  reflcted in the Class type Field  ",
				"Newly created Classtype  master not reflcted in the Class type Field ");
		Thread.sleep(100);
		
		
//8	Air Service Charge Rule	Newly created Region  master  refleced in the Region field
		wm.sendtextbyxvalue("//input[@aria-owns='RegionTypeCode_listbox']",Regionmaster);
		Thread.sleep(100);
		wm.Listnegativescearios("//*[@id='RegionTypeCode_listbox']/li", "0", 
				"Newly created Region  master  reflcted in the Region Field  ",
				"Newly created Region  master  nott reflcted in the Region Field ");
		Thread.sleep(100);
		
		
//9	Air Service Charge Rule	Newly created Travel type master  refleced in the Travel  field
		wm.sendtextbyxvalue("//input[@aria-owns='TravelTypeCode_listbox']",Traveltype);
		Thread.sleep(100);
		wm.Listnegativescearios("//*[@id='TravelTypeCode_listbox']/li", "0", 
				"Newly created TravelType reflcted in the Region Field  ",
				"Newly created TravelType nott reflcted in the Region Field ");
		Thread.sleep(100);
		
		
//10	Air Service Charge Rule	Newly created supplier should reflecetd in the supplier field 
		wm.sendtextbyxvalue("//input[@aria-owns='SupplierCode_listbox']",Suppliername);
		Thread.sleep(100);
		wm.Listnegativescearios("//*[@id='SupplierCode_listbox']/li", "0", 
				"Newly created Suppliername reflcted in the Region Field  ",
				"Newly created Suppliername nott reflcted in the Region Field ");
		Thread.sleep(100);
		

//12	Air Service Charge Rule	Verify the duplicate record creations
		wm.clickbyxpath("//span[@class='k-icon k-i-cancel']");
		Thread.sleep(200);
		wm.clickbyid("btnMainAdd");
		Thread.sleep(300);
	
		wm.sendtextbyxvalue("//input[@name='AirServiceChargeName']",Servicechargename);
		Thread.sleep(300);
		wm.Mousemoveover("//input[@name='AirServiceChargeName']");
		Thread.sleep(300);
		wm.clickbyxpath("//span[@class='k-icon k-i-check']");
		Thread.sleep(100);
		
		wm.Listnegativescearios(utility.Constant.Travelogixuitooltipvalidation, "0",
				"System not allowed to create duplicate records",
				"System  allowed to create duplicate records");
		Thread.sleep(200);

		
//11	Air Service Charge Rule	Inactive data should not reflected in  Air service charge rule pagee
		
		
//		Field :  ,airline ,

//chargename ,
		
//tickect typp
//class type ,
//region, 
//traveltype,suppliername 

		

		//4	Air Service Charge Rule	Newly created inactive  Ailine master refleced in the Airline field

		
				wm.sendtextbyxvalue("//input[@aria-owns='AirlineDesc_listbox']", inactiveAirlinedesc);
				Thread.sleep(100);
				wm.Listnegativesceariosnegativecaseschecking("//*[@id='AirlineDesc_listbox']/li", "0",
						"inctive airline master not reflcted in the Airline Field  ",
						"Inactiv airline master  reflcted in the Airline Field");
				Thread.sleep(100);
				
				
				
		//5	inactive  Charge name master  refleced in the Charge name field
				wm.sendtextbyxvalue("//input[@aria-owns='ascChargeKey_listbox']",inactiveChargenamemaster);
				Thread.sleep(100);
				wm.Listnegativesceariosnegativecaseschecking("//*[@id='ascChargeKey_listbox']/li", "0", 
						"inctive  Chargename master  not reflcted in the Chargename Field  ",
						"inctive Chargename master   reflcted in the Chargename Field");
				Thread.sleep(100);
				
				
		//6	Inactive  Ticket type  master  refleced in the Ticket type  field
				wm.sendtextbyxvalue("//input[@aria-owns='TicketTypeCode_listbox']",inactiveTickecttype);
				Thread.sleep(100);
				wm.Listnegativesceariosnegativecaseschecking("//*[@id='TicketTypeCode_listbox']/li", "0", 
						"inctive Tickecttype  master  not reflcted in the tickect type Field  ",
						"inctive Tickecttype  master  reflcted in the tickect type Field ");
				Thread.sleep(100);
				
				
		//7	Inactivee Class  type  master  refleced in the Class  type field
				wm.sendtextbyxvalue("//input[@aria-owns='ClassTypeCode_listbox']",inactiveClasstypee);
				Thread.sleep(100);
				wm.Listnegativesceariosnegativecaseschecking("//*[@id='ClassTypeCode_listbox']/li", "0", 
						"inctive Classtype  master  not reflcted in the Class type Field  ",
						"inctive Classtype  master  reflcted in the Class type Field ");
				Thread.sleep(100);
				
				
		//8	Air Service Charge Rule	Newly created inactive Region    refleced in the Region field
				wm.sendtextbyxvalue("//input[@aria-owns='RegionTypeCode_listbox']",inactiveRegionmaster);
				Thread.sleep(100);
				wm.Listnegativesceariosnegativecaseschecking("//*[@id='RegionTypeCode_listbox']/li", "0", 
						"inctive Region  master not  reflcted in the Region Field  ",
						"inctive Region  master   reflcted in the Region Field ");
				Thread.sleep(100);
				
				
		//9	negative Travel type master  refleced in the Travel  field
				wm.sendtextbyxvalue("//input[@aria-owns='TravelTypeCode_listbox']",inactiveTraveltype);
				Thread.sleep(100);
				wm.Listnegativesceariosnegativecaseschecking("//*[@id='TravelTypeCode_listbox']/li", "0", 
						"inctive TravelType not reflcted in the Region Field  ",
						"inctive TravelType  reflcted in the Region Field ");
				Thread.sleep(100);
				
				
		//10	 Inactive reflecetd in the supplier field 
				wm.sendtextbyxvalue("//input[@aria-owns='SupplierCode_listbox']",inactiveSuppliername);
				Thread.sleep(100);
				wm.Listnegativesceariosnegativecaseschecking("//*[@id='SupplierCode_listbox']/li", "0", 
						"inctive  Suppliername not reflcted in the Region Field  ",
						"inctive Suppliername  reflcted in the Region Field ");
				Thread.sleep(100);


			
		wm.sleep();
	}

	@AfterMethod
	public void close()

	{
		wm.close();

	}

	@DataProvider(name = "dp")
	public Object[][] dp() throws IOException {

		return Wrappermethods.getSheet("Airscrulenegative", "Airscrulenegative");

	}
}