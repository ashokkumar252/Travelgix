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
public class Carscrulepagenegativescenarios

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
	public void Carscrulepagenegativescenarios(String Username, String Password, String Leftsidemenu,String Commonindex,
			String Code1,String Vehicletyee,String Chargenamemaster,String Suppliermaster,String negativeVehicletyee,
			String negativeChargenamemaster,String	negativesuppliermaster
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

		// ====================Creating Car Service Charge Rule Master negative
		// scenarios
		// screnn===========================================================
		wm.sendtextbyid("input-items", Leftsidemenu);
		Thread.sleep(500);
		wm.clickbyid("modTRS001");
		Thread.sleep(500);
		wm.clickbyid("pgmCSM001");
		wm.sleep();

		// 1 Air Service Charge Rule Clicking the save button without changes

		wm.clickbyid("btnMainSave");
		wm.sleep();

		wm.Verifythealertpopupmessages("//span[@id='diaInfoMessage']",
				"Car Service Charge Master Saved/Updated Successfully",
				"without doing changes clicking the save button , System showing validation messages correctly ",
				"without doing changes clicking the save button ,  System showing validation messages not correctly ");
		Thread.sleep(300);

		wm.Listandenterquick("//span[contains(text(),'OK')]", "0");
		wm.Listandenterquick("//span[contains(text(),'OK')]", "1");
		wm.Listandenterquick("//span[contains(text(),'OK')]", "2");
		wm.Listandenterquick("//span[contains(text(),'OK')]", "3");
		Thread.sleep(500);

		// 2 Car Service Charge Rule Verify the Audit log Popup opening

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
		Thread.sleep(500);

		// 3 Car Service charge rule pagee Verify the UI field validations All
		// Mandatroy Fields

		wm.clickbyid("btnMainAdd");
		Thread.sleep(500);
		wm.Clearbyxpath("//input[@name='ActiveFrom']");
		Thread.sleep(300);

		wm.Listandenterquick("//span[@aria-owns='Status_listbox']", "0");
		Thread.sleep(300);
		wm.Listandenter("//div[contains(text(),'Select')]", "0");
		Thread.sleep(100);

		// carservice chargename
		wm.clickbyxpath("//span[@class='k-icon k-i-check']");
		Thread.sleep(500);

		wm.Mousemoveover("//input[@name='Code']");
		Thread.sleep(300);

		
		wm.Listnegativescearios(utility.Constant.Travelogixuitooltipvalidation, "0",
				"Validation is avilable in  car service charge name field",
				"Validation is not avilable in  car service charge name field");
		Thread.sleep(300);

		// vehicletype validations
		wm.Mousemoveover("//input[@aria-owns='VehicleTypeCode_listbox']");
		Thread.sleep(300);
		wm.Listnegativescearios(utility.Constant.Travelogixuitooltipvalidation, "0",
				"Vehicle type vaidationis avilable ",
				"Vehicle type vaidation is not avilable in  car service charge name field");
		Thread.sleep(300);

		// Active fromdatevalidations
		wm.Mousemoveover("//input[@name='ActiveFrom']");
		Thread.sleep(300);
		wm.Listnegativescearios(utility.Constant.Travelogixuitooltipvalidation, "0",
				"Active from vaidationis avilable in car service charge rulepage",
				"Active from vaidationis not avilable in car service charge rulepage");
		Thread.sleep(300);

		// chargename validaitons

		wm.Mousemoveover("//input[@name='chargeKey_input']");
		Thread.sleep(300);
		wm.Listnegativescearios(utility.Constant.Travelogixuitooltipvalidation, "0",
				"Charge name vaidationis avilable in car service charge rulepage",
				"Charge name vaidationis not avilable in car service charge rulepage");
		Thread.sleep(300);

		// Dateactivefrom validaitons

		wm.Mousemoveover("//span[@aria-owns='Status_listbox']");
		Thread.sleep(300);
		wm.Listnegativescearios(utility.Constant.Travelogixuitooltipvalidation, "0",
				"Status vaidationis avilable in car service charge rulepage",
				"status vaidationis not avilable in car service charge rulepage");
		Thread.sleep(300);

		// duplicate codeverifications
		wm.sendtextbycssselecotrwithoutclear("#Code", Code1);
		Thread.sleep(200);
		wm.clickbyxpath("//span[@class='k-icon k-i-check']");
		Thread.sleep(300);

		wm.Mousemoveover("//input[@name='Code']");
		Thread.sleep(300);
		wm.Listnegativescearios(utility.Constant.Travelogixuitooltipvalidation, "0",
				"Duplication code validation is  avilable", "Duplication code validation is  not avilable");
		Thread.sleep(300);
		wm.clickbyid("btnMainClear");
		Thread.sleep(900);
		
		//===================
//5	Car Service charge rule pagee	Verify the newly created  VEHICLE TYPE  avilable in the vehicle type field	
		
		wm.clickbyid("btnMainAdd");
		Thread.sleep(300);
       wm.sendtextbyxvalue("//input[@aria-owns='VehicleTypeCode_listbox']", Vehicletyee);   
		Thread.sleep(500);
		wm.Listnegativescearios("//*[@id='VehicleTypeCode_listbox']/li", Commonindex,
				"Newly created vehicle type is avilable in car service charge rulepage",
				"Newly created vehicle type is not avilable in car service charge rulepage");
		Thread.sleep(500);
	
		
		
//6	Car Service charge rule pagee	Verify the newly created  Charge master  avilable in the Charge field	
		Thread.sleep(300);
	       wm.sendtextbyxvalue("//input[@aria-owns='chargeKey_listbox']",Chargenamemaster);   
			Thread.sleep(300);
			wm.Listnegativescearios("//*[@id='chargeKey_listbox']/li", Commonindex,
					"Newly created chargeKey_listbox is avilable in car service charge rulepage",
					"Newly created chargeKey_listbox  is not avilable in car service charge rulepage");
			Thread.sleep(500);
		
			
//7 .Suppier master
			Thread.sleep(300);
		       wm.sendtextbyxvalue("//input[@aria-owns='SupplierCode_listbox']",Suppliermaster);   
				Thread.sleep(300);
				wm.Listnegativescearios("//*[@id='SupplierCode_listbox']/li", Commonindex,
						"Newly created supplier master  is avilable in car service charge rulepage",
						"Newly created supplier master  is not avilable in car service charge rulepage");
				Thread.sleep(500);
			

				
	//========================================================================================
				
	//Verfed the inactive datas 
				Thread.sleep(200);
				wm.clickbyid("btnMainClear");
				Thread.sleep(900);
				
				wm.clickbyid("btnMainAdd");
				Thread.sleep(300);
		       wm.sendtextbyxvalue("//input[@aria-owns='VehicleTypeCode_listbox']", negativeVehicletyee);   
				Thread.sleep(300);
				wm.Listnegativesceariosnegativecaseschecking("//*[@id='VehicleTypeCode_listbox']/li", Commonindex,
						"inactive vehicle type is not avilable in car service charge rulepage",
						"inactive vehicle type is  avilable in car service charge rulepage");
				Thread.sleep(500);
			
				
				
		//6	Car Service charge rule pagee	Verify the newly created  Charge master  avilable in the Charge field	
				Thread.sleep(300);
			       wm.sendtextbyxvalue("//input[@aria-owns='chargeKey_listbox']",negativeChargenamemaster);   
					Thread.sleep(300);
					wm.Listnegativesceariosnegativecaseschecking("//*[@id='chargeKey_listbox']/li", Commonindex,
							"inactive chargeKey_listbox is not avilable in car service charge rulepage",
							"inactive chargeKey_listbox  is  avilable in car service charge rulepage");
					Thread.sleep(500);
				
					
		//7 .Suppier master
					Thread.sleep(300);
				       wm.sendtextbyxvalue("//input[@aria-owns='SupplierCode_listbox']",negativesuppliermaster);   
						Thread.sleep(300);
						wm.Listnegativesceariosnegativecaseschecking("//*[@id='SupplierCode_listbox']/li", Commonindex,
								"inactive supplier master  is not avilable in car service charge rulepage",
								"inactive supplier master  is avilable in car service charge rulepage");
						Thread.sleep(500);

		wm.sleep();
	}

	@AfterMethod
	public void close()

	{
		wm.close();

	}

	@DataProvider(name = "dp")
	public Object[][] dp() throws IOException {

		return Wrappermethods.getSheet("Carscrulepagenegativescenarios", "Carscrulepagenegativescenarios");

	}
}