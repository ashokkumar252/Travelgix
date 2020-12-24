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
public class Airlinemasternegativvescenarios {

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
	public void Airlinemasternegativvescenarios(String Username, String Password, String Leftsidemenu, String Code, String Commonindex,
			String AirlineShortName, String BspStatus, String Bspstatusindex,String Traveltype,
			String Traveltypeindex,String Fromsector,String  Fromsectorindex,String Tosector,
			String Tosectorindex,String Paytype,String Paytypeindex,String  Classtype,String Classtypeindex,
			String Fromsectorr,String Fromsectorrindex,String Tosectorr,String Tosectorrindex,String Chargename,
			String Chargenameindex,String Currency,String Currencyindex,String Classnamee,
			String Classnameeindexx,String Suppliername,String Suppliernameindexx

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

		// ====================Creating Branch Master negative scenarios
		// screnn===========================================================
		wm.sendtextbyid("input-items", Leftsidemenu);
		Thread.sleep(500);
		wm.clickbyid("modMAS001");
		Thread.sleep(500);
		wm.clickbyid("pgmAIR001");
		wm.sleep();

		wm.clickbyid("btnMainAdd");
		Thread.sleep(200);

		// 1 Basicdetails Duplicate code not allowed System should not allowed
		// the duplicate code values

		wm.sendtextbyid("AirlineCode", Code);
		Thread.sleep(200);
		wm.clickbyid("btnMainSave");
		Thread.sleep(200);
		wm.Mousemoveover("//input[@name='AirlineCode']");
		Thread.sleep(300);

		wm.Listnegativescearios("//div[@class='k-tooltip-content']", Commonindex,
				"Pass :  Code duplciate validations is avilable " + "",
				"Fail:  Code  duplicate validations is not avilable " + "");
		Thread.sleep(350);

		// 2 Basicdetails Short name duplciate issues System should not allowed
		// the short name values
		wm.sendtextbyid("AirlineShortName", AirlineShortName);
		Thread.sleep(200);
		wm.clickbyid("btnMainSave");
		Thread.sleep(200);
		wm.Mousemoveover("//input[@name='AirlineShortName']");
		Thread.sleep(300);

		Thread.sleep(200);
		wm.Listnegativescearios("//div[@class='k-tooltip-content']", Commonindex,
				"Pass :  Short name  duplciate validations is avilable " + "",
				"Fail:  Short name  duplicate validations is not avilable " + "");
		Thread.sleep(350);

		// 3 Basicdetails Active from Date validations Active from Date
		// validations

		wm.Clearbyxpath("//input[@aria-owns='AirlineActiveFrom_dateview']");
		Thread.sleep(200);
		wm.clickbyid("btnMainSave");
		Thread.sleep(200);
		wm.Mousemoveover("//input[@aria-owns='AirlineActiveFrom_dateview']");
		Thread.sleep(300);
		wm.Listnegativescearios("//div[@class='k-tooltip-content']", Commonindex,
				"Pass :  Date  validations is avilable " + "", "Fail:   Date validations is not avilable " + "");
		Thread.sleep(350);

		// 4 Basicdetails BP status Verificaton created from referenc code]
		// Created BP status reflected in BP status field

		wm.sendtextbyxvalue("//input[@aria-owns='AirlineCommTypeValue_listbox']", BspStatus);
		Thread.sleep(200);
		wm.Listnegativescearios("//*[@id='AirlineCommTypeValue_listbox']/li", Bspstatusindex,
				"Pass :   newly created BSP status reflectd in the BSP status dropdown" + "",
				"Fail:    newly created BSP status not reflectd in the BSP status dropdown" + "");
		Thread.sleep(300);

		// ==========================================Commiosnable===============

		// 5 Address normal ui validations UI validation for all the filedin the
		// grid

		wm.Listandenter("//i[@class='fa fa-chevron-down']", "1");
		Thread.sleep(300);
		wm.clickbyxpath("//span[@class='k-icon k-i-add']");
		Thread.sleep(300);
		wm.Clearbyxpath("//input[@aria-owns='ActiveFrom_dateview']");
		Thread.sleep(300);
		wm.clickbyxpath("//span[@class='k-icon k-i-check']");
		Thread.sleep(300);

		wm.stabbyxpath("//input[@name='Address']");
		//wm.clickbyxpath("//input[@name='Address']");
		Thread.sleep(200);
		
		// clicking the grid level save button

		// 6 Address Date vaidations Date validations

		// Address typefield

		wm.Mousemoveover("//input[@aria-owns='AddressTypeKey_listbox']");
		Thread.sleep(200);
		wm.Listnegativescearios("//div[@class='k-tooltip-content']", Commonindex,
				"Pass :   validations is avilable in address type field" + "",
				"Fail:  validations is not avilable in address type field " + "");
		Thread.sleep(350);

		// address field

		wm.Mousemoveover("//input[@name='Address']");
		Thread.sleep(200);
		wm.Listnegativescearios("//div[@class='k-tooltip-content']", Commonindex,
				"Pass :   validations is avilable in address  field" + "",
				"Fail:  validations is not avilable in address  field " + "");
		Thread.sleep(350);

		// city field

		wm.Mousemoveover("//input[@aria-owns='City_listbox']");
		Thread.sleep(200);
		wm.Listnegativescearios("//div[@class='k-tooltip-content']", Commonindex,
				"Pass :   validations is avilable in city field" + "",
				"Fail:  validations is not avilable in city  field " + "");
		Thread.sleep(350);

		// contactperosnfield

		wm.Mousemoveover("//input[@name='ContactPerson']");
		Thread.sleep(200);
		wm.Listnegativescearios("//div[@class='k-tooltip-content']", Commonindex,
				"Pass :   validations is avilable in contactperosnvfield field" + "",
				"Fail:  validations is not avilable in contactperosnvfield field " + "");
		Thread.sleep(350);

		// phonefield

		wm.Mousemoveover("//input[@name='Phone']");
		wm.Listnegativescearios("//div[@class='k-tooltip-content']", Commonindex,
				"Pass :   validations is avilable in phonefield field" + "",
				"Fail:  validations is not avilable in phonefield field " + "");
		Thread.sleep(350);

		// Active from field

		wm.Mousemoveover("//input[@aria-owns='ActiveFrom_dateview']");
		wm.Listnegativescearios("//div[@class='k-tooltip-content']", Commonindex,
				"Pass :   validations is avilable in Active from  field" + "",
				"Fail:  validations is not avilable in Active from  field " + "");
		Thread.sleep(200);
		wm.clickbyxpath("//span[@class='k-icon k-i-cancel']");
		Thread.sleep(200);
		wm.Listandenter("//i[@class='fa fa-chevron-down']", "1");
		Thread.sleep(900);
		
	//===============================================
		
		wm.Listandenter("//i[@class='fa fa-chevron-down']", "2");
		Thread.sleep(900);
		wm.Listandenter("//span[@class='k-icon k-i-add']", "1");
		
		//wm.clickbyxpath("//span[@class='k-icon k-i-add']");
		Thread.sleep(500);
		
		//7	commission	Verify the travel type	Traveltype 
		
		wm.sendtextbyxvalue("//input[@aria-owns='TravelTypeCode_listbox']", Traveltype);
		Thread.sleep(200);
		wm.Listnegativescearios("//*[@id='TravelTypeCode_listbox']/li", Traveltypeindex,
				"Pass :   Given value reflected in the traveltype dropdow" + "",
				"Fail:   Given value is not reflected in the traveltype dropdow" + "");
		Thread.sleep(200);
		
		//8	commission	Airpot code master in  fromsector to sector	Created airport code reflected in airport field
		

		//fromsector
		wm.sendtextbyxvalue("//input[@aria-owns='FromSectorKey_listbox']", Fromsector);
		Thread.sleep(200);
		wm.Listnegativescearios("//*[@id='FromSectorKey_listbox']/li", Fromsectorindex,
				"Pass :   Given value from sector refleced  in the from secotr field " + "",
				"Fail:   Given value from sector is not refleced  in the from secotr field " + "");
		Thread.sleep(200);
		//tosector
		wm.sendtextbyxvalue("//input[@aria-owns='ToSectorKey_listbox']", Tosector);
		Thread.sleep(200);
		wm.Listnegativescearios("//*[@id='ToSectorKey_listbox']/li", Tosectorindex,
				"Pass :   Given value To sector refleced  in the To secotr field " + "",
				"Fail:   Given value to sector refleced  in the To secotr field " + "");
		Thread.sleep(200);
		
		
		
		//9	commission	Percentage amount	Verify the  subtract value is allowed to add

		//no feasbility
		
		//10	commission	date validations	Active from date validations

		wm.Clearbyxpath("//input[@aria-owns='ActiveFrom_dateview']");
		Thread.sleep(200);
		wm.clickbyxpath("//span[@class='k-icon k-i-check']");
		Thread.sleep(200);
		wm.Mousemoveover("//input[@aria-owns='ActiveFrom_dateview']");
		Thread.sleep(200);
		wm.Listnegativescearios("//div[@class='k-tooltip-content']", Commonindex,
				"Pass :   validations is avilable in Active from  field" + "",
				"Fail:  validations is not avilable in Active from  field " + "");
		Thread.sleep(200);
		wm.clickbyxpath("//span[@class='k-icon k-i-cancel']");
		Thread.sleep(200);
		wm.Listandenter("//i[@class='fa fa-chevron-down']", "2");
		Thread.sleep(200);
		
		
		
  //============================================================
		

		wm.Listandenter("//i[@class='fa fa-chevron-down']", "3");
		Thread.sleep(900);
		wm.Listandenter("//span[@class='k-icon k-i-add']", "2");
		Thread.sleep(200);
		
		
	//11	Refund chargelist	paxtyep- referenc code	Verify the dropdwon values
		wm.sendtextbyxvalue("//input[@aria-owns='RefundChargePaxTypeCode_listbox']", Paytype);
		Thread.sleep(200);
		wm.Listnegativescearios("//*[@id='RefundChargePaxTypeCode_listbox']/li", Paytypeindex,
				"Pass :   Given value avilable in Paytype field " + "",
				"Fail:   Given value avilable in Paytype field  " + "");
		Thread.sleep(200);

		//Classtype
		
		wm.sendtextbyxvalue("//input[@aria-owns='RefundChargeClassTypeCode_listbox']", Classtype);
		Thread.sleep(200);
		wm.Listnegativescearios("//*[@id='RefundChargeClassTypeCode_listbox']/li", Classtypeindex,
				"Pass :   Given value avilable in Classtype field " + "",
				"Fail:   Given value avilable in Classtype field  " + "");
		Thread.sleep(200);

		
		
	//12	Refund chargelist	from secoty , to seci - Airport secoty	Verify the from secor and to secotr 
		wm.sendtextbyxvalue("//input[@aria-owns='RefundChargeFromSectorKey_listbox']", Fromsectorr);
		Thread.sleep(200);
		wm.Listnegativescearios("//*[@id='RefundChargeFromSectorKey_listbox']/li", Fromsectorrindex,
				"Pass :   Given value avilable in Fromsector field " + "",
				"Fail:   Given value avilable in Fromsector field  " + "");
		Thread.sleep(200);

		wm.sendtextbyxvalue("//input[@aria-owns='RefundChargeToSectorKey_listbox']", Tosectorr);
		Thread.sleep(200);
		wm.Listnegativescearios("//*[@id='RefundChargeToSectorKey_listbox']/li", Tosectorrindex,
				"Pass :   Given value avilable in Tosectorr field " + "",
				"Fail:   Given value avilable in Tosectorr field  " + "");
		Thread.sleep(200);


		
	//13	Refund chargelist	charename: chargmaster	Created charge name master reflected in the chargename field 
		wm.sendtextbyxvalue("//input[@aria-owns='RefundChargeChargeKey_listbox']",Chargename);
		Thread.sleep(200);
		wm.Listnegativescearios("//*[@id='RefundChargeChargeKey_listbox']/li", Chargenameindex,
				"Pass :   Given value avilable in chargename field " + "",
				"Fail:   Given value avilable in chargename field  " + "");
		Thread.sleep(200);

		
	//14	Refund chargelist	curreny master	Created curreny master reflected in the currency field
		wm.sendtextbyxvalue("//input[@aria-owns='RefundChargeCurrencyKey_listbox']",Currency);
		Thread.sleep(200);
		wm.Listnegativescearios("//*[@id='RefundChargeCurrencyKey_listbox']/li", Currencyindex,
				"Pass :   Given value avilable in Currency field " + "",
				"Fail:   Given value avilable in Currency field  " + "");
		Thread.sleep(200);

		
	//15	Refund chargelist	amunt - ot allaowed	negative amount should not be allowed
		//ne feasbility to cehck
	//16	Refund chargelist	Date validations	Date validations 
		wm.Clearbyxpath("//input[@aria-owns='RefundChargeEffectiveDate_dateview']");
		Thread.sleep(200);
		wm.clickbyxpath("//span[@class='k-icon k-i-check']");
		Thread.sleep(200);
		wm.Mousemoveover("//input[@aria-owns='RefundChargeEffectiveDate_dateview']");
		Thread.sleep(200);
		wm.Listnegativescearios("//div[@class='k-tooltip-content']", Commonindex,
				"Pass :   validations is avilable in Effective  from  field" + "",
				"Fail:  validations is not avilable in Effective from  field " + "");
		Thread.sleep(500);
		
		
		wm.Clearbyxpath("//input[@aria-owns='ActiveFrom_dateview']");
		Thread.sleep(200);
		wm.clickbyxpath("//span[@class='k-icon k-i-check']");
		Thread.sleep(200);
		wm.Mousemoveover("//input[@aria-owns='ActiveFrom_dateview']");
		Thread.sleep(200);
		wm.Listnegativescearios("//div[@class='k-tooltip-content']", Commonindex,
				"Pass :   validations is avilable in ActiveFrom_dateview  from  field" + "",
				"Fail:  validations is not avilable in ActiveFrom_dateview from  field " + "");
		Thread.sleep(200);
		
		
		wm.clickbyxpath("//span[@class='k-icon k-i-cancel']");
		Thread.sleep(200);
		wm.Listandenter("//i[@class='fa fa-chevron-down']", "3");
		Thread.sleep(200);
		
		

		
	//================================================================================

		//class link validations
		
		wm.Listandenter("//i[@class='fa fa-chevron-down']", "4");
		Thread.sleep(900);
		wm.Listandenter("//span[@class='k-icon k-i-add']", "3");
		Thread.sleep(300);
		
//		17	Class link	Fromclass linkmasters	Created class link relfected in the class name field
		
		wm.sendtextbyxvalue("//input[@aria-owns='ClassKey_listbox']",Classnamee);
		Thread.sleep(500);
		wm.Listnegativescearios("//*[@id='ClassKey_listbox']/li", Classnameeindexx,
				"Pass :   Given value avilable in Classname field " + "",
				"Fail:   Given value not avilable in Classname field  " + "");
		Thread.sleep(200);
		

		
		
//	18	Class link	date validations	Verify the date validations
		

		
		wm.Clearbyxpath("//input[@aria-owns='ActiveFrom_dateview']");
		Thread.sleep(300);
		wm.clickbyxpath("//span[@class='k-icon k-i-check']");
		Thread.sleep(500);
		wm.Mousemoveover("//input[@aria-owns='ActiveFrom_dateview']");
		Thread.sleep(500);
		wm.Listnegativescearios(utility.Constant.Travelogixuitooltipvalidation, Commonindex,
				"Pass :   validation is avilable in Active from date field" + "",
				"Fail:  validations is not avilable in  Active from date   field " + "");

/*		wm.Listnegativescearios("//div[@class='k-tooltip-content']", Commonindex,
				"Pass :   validations is avilable in ActiveFrom_dateview  from  field" + "",
				"Fail:  validations is not avilable in ActiveFrom_datevie from  field " + "");
*/		Thread.sleep(200);
		

		wm.clickbyxpath("//span[@class='k-icon k-i-cancel']");
		Thread.sleep(200);
		wm.Listandenter("//i[@class='fa fa-chevron-down']", "4");
		Thread.sleep(200);
//====================================================================================
		
		
		wm.Listandenter("//i[@class='fa fa-chevron-down']", "5");
		Thread.sleep(900);
		wm.Listandenter("//span[@class='k-icon k-i-add']", "4");
		Thread.sleep(500);
		
//19	Parnet link	supplier - bussiness patner	Created bussiness partenr reflecte in the supplier drop down field

		wm.sendtextbyxvalue("//input[@aria-owns='CmsKey_listbox']",Suppliername);
		Thread.sleep(500);
		wm.Listnegativescearios("//*[@id='CmsKey_listbox']/li", Suppliernameindexx,
				"Pass :   Given value avilable in Supplier field " + "",
				"Fail:   Given value not avilable in supplier field  " + "");
		Thread.sleep(200);

		
//20	Parnet link	Date validaons	Date validations

		

		
		wm.Clearbyxpath("//input[@aria-owns='ActiveFrom_dateview']");
		Thread.sleep(200);
		wm.clickbyxpath("//span[@class='k-icon k-i-check']");
		Thread.sleep(200);
		wm.Mousemoveover("//input[@aria-owns='ActiveFrom_dateview']");
		Thread.sleep(200);
		wm.Listnegativescearios("//div[@class='k-tooltip-content']", Commonindex,
				"Pass :   validations is avilable in ActiveFrom_dateview  from  field" + "",
				"Fail:  validations is not avilable in ActiveFrom_datevie from  field " + "");
		Thread.sleep(200);
		

		wm.clickbyxpath("//span[@class='k-icon k-i-cancel']");
		Thread.sleep(200);
		wm.Listandenter("//i[@class='fa fa-chevron-down']", "4");
		Thread.sleep(200);
		

//==========================================================================================
		
		wm.sleep();
	}

	@AfterMethod
	public void close()

	{
		wm.close();

	}

	@DataProvider(name = "dp")
	public Object[][] dp() throws IOException {

		return Wrappermethods.getSheet("Airlinemasternegativvescenarios", "Airlinemasternegativvescenarios");

	}
}