package travlogix;

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
public class Airline {

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
	public void Airline(String Username, String Password, String Leftsidemenu, String AirlineCode,
			String AirlineName, String AirlineShortName, String AirlineActiveFrom1, String AirlineActiveFrom2,
			String AirlineActiveFrom3, String AirlineActiveTo1, String AirlineActiveTo2, String AirlineActiveTo3,
			String Statuindexx, String AirlineCommTypeValuelistbox, String AirlineCommTypeValuelistboxindex,
			String AirlineAgentTypeValuelistbox, String AirlineAgentTypeValuelistboxindex,
			String AirlineCommissionMethodNamelistbox, String AirlineCommissionMethodNamelistboxindexx,

			String AddressTypeKeylistbox, String AddressTypeKeylistboxindex, String Address, String City,
			String Cityindex, String ContactPerson, String Phone, String Mobile, String Fax, String Email,
			String ActiveFrom1, String ActiveFrom2, String ActiveFrom3, String ActiveTo1, String ActiveTo2,
			String ActiveTo3, String AddressStatuindexx,

			String TravelTypeCodelistbox, String TravelTypeCodelistboxindex, String FromSectorKeylistbox,
			String FromSectorKeylistboxindex, String ToSectorKeylistbox, String ToSectorKeylistboxindex,
			String GsaCommKeylistbox, String GsaCommKeylistboxindex, String AcsValue, String CActiveFrom1,
			String CActiveFrom2, String CActiveFrom3, String CActiveTo1, String CActiveTo2, String CActiveTo3,
			String Commissionstatuindexx,

			String Paxtype, String Paxtypeindex, String Classtype, String Classtypeindex, String Fromsector,
			String Fromsectorindex, String Tosector, String Tosectorindex, String Chargename, String Chargenameindexx,
			String Currency, String Currencyindex, String RefundChargeAmount, String Effdate1, String Effdate2,
			String Effdate3, String RCActiveFrom1, String RCActiveFrom2, String RCActiveFrom3, String RCActiveto1,
			String RCActiveto2, String RCActiveto3, String RCStatuslistbox,

			String Classname, String Classnameindex, String ClassTypeKeylistbox, String ClassTypeKeylistboxindex,
			String ClActiveFrom1, String ClActiveFrom2, String ClActiveFrom3, String CActiveto1, String CActiveto2,
			String CActiveto3, String Classtatusindex,
			
			String Supplier,String Supplierindexx,String Commissiontype,String Commissiontypeindexx,String PAActiveFrom1,String PAActiveFrom2,
			String PAActiveFrom3,String PActiveto1,String PActiveto2,String PActiveto3,String PAStatuslistbox) throws Exception

	{

		Thread.sleep(2000);

		// wm.sendtextbyid("", );
		wm.sendtextbyid("LoginCode", Username);
		Thread.sleep(200);
		wm.stab("LoginCode");
		wm.sendtextbyid("Password", Password);
		Thread.sleep(200);
		wm.clickbyxpath("//input[@value='Login']");
		Thread.sleep(900);

		// screnn===========================================================
		wm.sendtextbyid("input-items", Leftsidemenu);
		Thread.sleep(500);
		wm.clickbyid("modMAS001");
		Thread.sleep(500);
		wm.clickbyid("pgmAIR001");
		wm.sleep();

		wm.clickbyid("btnMainAdd");
		Thread.sleep(500);

		// Enter the details

		wm.sendtextbycssselecotrwithoutclear("#AirlineCode", AirlineCode);
		Thread.sleep(50);
		wm.sendtextbycssselecotrwithoutclear("#AirlineName", AirlineName);
		Thread.sleep(50);
		wm.sendtextbycssselecotrwithoutclear("#AirlineShortName", AirlineShortName);
		Thread.sleep(50);

		// Date:

		wm.sendtextbycssselecotr("#AirlineActiveFrom",
				"" + AirlineActiveFrom1 + "-" + AirlineActiveFrom2 + "-" + AirlineActiveFrom3);
		Thread.sleep(140);

		wm.sendtextbycssselecotr("#AirlineActiveTo",
				"" + AirlineActiveTo1 + "-" + AirlineActiveTo2 + "-" + AirlineActiveTo3);
		Thread.sleep(140);

		// selected the status

		wm.clickbyxpath(" //span[@aria-owns='HeadActiveStatus_listbox']");
		Thread.sleep(200);
		wm.Listandenter("//*[@id='HeadActiveStatus_listbox']/li", Statuindexx);
		Thread.sleep(200);

		// bugstatus
		wm.sendtextbyxvalue("//input[@aria-owns='AirlineCommTypeValue_listbox']", AirlineCommTypeValuelistbox);
		Thread.sleep(200);
		wm.Listandenter("//*[@id='AirlineCommTypeValue_listbox']/li", AirlineCommTypeValuelistboxindex);
		Thread.sleep(200);

		// GSA ststua

		wm.sendtextbyxvalue("//input[@aria-owns='AirlineAgentTypeValue_listbox']", AirlineAgentTypeValuelistbox);
		Thread.sleep(200);
		wm.Listandenter("//*[@id='AirlineAgentTypeValue_listbox']/li", AirlineAgentTypeValuelistboxindex);
		Thread.sleep(200);

		// commissionmethod
		wm.sendtextbyxvalue("//input[@aria-owns='AirlineCommissionMethodName_listbox']",
				AirlineCommissionMethodNamelistbox);
		Thread.sleep(200);
		wm.Listandenter("//*[@id='AirlineCommissionMethodName_listbox']/li", AirlineCommissionMethodNamelistboxindexx);
		Thread.sleep(200);

		// =====================================================================================================================

		// Enter the addressdetails

		wm.Listandenter("//i[@class='fa fa-chevron-down']", "1");
		Thread.sleep(900);
		wm.Listandenter("//span[@class='k-icon k-i-add']", "0");
		Thread.sleep(500);

		// addresstype
		wm.sendtextbyxvalue("//input[@aria-owns='AddressTypeKey_listbox']", AddressTypeKeylistbox);
		Thread.sleep(200);
		wm.Listandenter("//*[@id='AddressTypeKey_listbox']/li", AddressTypeKeylistboxindex);
		Thread.sleep(200);

		// city
		wm.sendtextbycssselecotrwithoutclear("#Address", Address);
		Thread.sleep(90);

		wm.sendtextbycssselecotrwithoutclear("#City", City);
		Thread.sleep(90);
		wm.Listandenter("//*[@id='City_listbox']/li", Cityindex);
		Thread.sleep(200);

		// contact person
		wm.sendtextbycssselecotrwithoutclear("#ContactPerson", ContactPerson);
		Thread.sleep(90);
		// phonee
		wm.sendtextbycssselecotrwithoutclear("#Phone", Phone);
		Thread.sleep(90);
		// mobile
		wm.sendtextbycssselecotrwithoutclear("#Mobile", Mobile);
		Thread.sleep(90);
		// fax
		wm.sendtextbycssselecotrwithoutclear("#Fax", Fax);
		Thread.sleep(90);
		// emaill

		wm.sendtextbycssselecotrwithoutclear("#Email", Email);
		Thread.sleep(90);
		// dateselections Activefrom
		wm.sendtextbycssselecotr("#ActiveFrom", "" + ActiveFrom1 + "-" + ActiveFrom2 + "-" + ActiveFrom3);
		Thread.sleep(90);
		// Activeto
		wm.sendtextbycssselecotr("#ActiveTo", "" + ActiveTo1 + "-" + ActiveTo2 + "-" + ActiveTo3);
		Thread.sleep(90);
		// selected the status

		wm.clickbyxpath(" //span[@aria-owns='Status_listbox']");
		Thread.sleep(200);
		wm.Listandenter("//*[@id='Status_listbox']/li", AddressStatuindexx);
		Thread.sleep(200);
		// clicking the savebutton in thegrid
		wm.doubleclickusingxpath("//span[@class='k-icon k-i-check']");

		Thread.sleep(200);
		wm.Listandenter("//i[@class='fa fa-chevron-down']", "1");
		Thread.sleep(900);

		// Star ente
		// thecommisison=====================================================================================================
		wm.Listandenter("//i[@class='fa fa-chevron-down']", "2");
		Thread.sleep(600);
		wm.Listandenter("//span[@class='k-icon k-i-add']", "1");
		Thread.sleep(800);

		Thread.sleep(500);

		wm.Listandenter("//span[@class='k-icon k-i-arrow-60-down']", "5");

		// wm.sendtextbyxvalue("//input[@aria-owns='TravelTypeCode_listbox']",
		// TravelTypeCodelistbox);
		Thread.sleep(200);
		wm.Listandenter("//*[@id='TravelTypeCode_listbox']/li", TravelTypeCodelistboxindex);
		Thread.sleep(200);

		// from sector
		wm.Listandenter("//span[@class='k-icon k-i-arrow-60-down']", "6");

		// wm.sendtextbyxvalue("//input[@aria-owns='FromSectorKey_listbox']",
		// FromSectorKeylistbox);
		Thread.sleep(200);
		wm.Listandenter("//*[@id='FromSectorKey_listbox']/li", FromSectorKeylistboxindex);
		Thread.sleep(200);

		// Tosecor
		wm.Listandenter("//span[@class='k-icon k-i-arrow-60-down']", "7");

		// wm.sendtextbyxvalue("//input[@aria-owns='ToSectorKey_listbox']",
		// ToSectorKeylistbox);
		Thread.sleep(200);
		wm.Listandenter("//*[@id='ToSectorKey_listbox']/li", ToSectorKeylistboxindex);
		Thread.sleep(200);

		// Commissionname
		wm.sendtextbyxvalue("//input[@aria-owns='GsaCommKey_listbox']", GsaCommKeylistbox);
		Thread.sleep(200);
		wm.Listandenter("//*[@id='GsaCommKey_listbox']/li", GsaCommKeylistboxindex);
		Thread.sleep(200);

		// commisson percentage
		wm.sendtextbycssselecotrwithoutclear("#AcsValue", AcsValue);
		Thread.sleep(300);

		// Dateselections
		wm.sendtextbycssselecotr("#ActiveFrom", "" + CActiveFrom1 + "-" + CActiveFrom2 + "-" + CActiveFrom3);

		// Dateselectins
		wm.sendtextbycssselecotr("#ActiveTo", "" + CActiveTo1 + "-" + CActiveTo2 + "-" + CActiveTo3);

		// selectedtheactivestatus
		wm.clickbyxpath(" //span[@aria-owns='Status_listbox']");
		Thread.sleep(200);
		wm.Listandenter("//*[@id='Status_listbox']/li", Commissionstatuindexx);
		Thread.sleep(200);

		wm.doubleclickusingxpath("//span[@class='k-icon k-i-check']");

		Thread.sleep(200);
		wm.Listandenter("//i[@class='fa fa-chevron-down']", "2");
		Thread.sleep(900);

		// ===================================================================

		// Enter the refndcharge list

		Thread.sleep(200);
		wm.Listandenter("//i[@class='fa fa-chevron-down']", "3");
		Thread.sleep(500);
		wm.Listandenter("//span[@class='k-icon k-i-add']", "2");
		Thread.sleep(800);

		// paxtypee
		wm.sendtextbyxvalue("//input[@aria-owns='RefundChargePaxTypeCode_listbox']", Paxtype);
		Thread.sleep(200);
		wm.Listandenter("//*[@id='RefundChargePaxTypeCode_listbox']/li", Paxtypeindex);
		Thread.sleep(200);

		// classtype
		wm.sendtextbyxvalue("//input[@aria-owns='RefundChargeClassTypeCode_listbox']", Classtype);
		Thread.sleep(200);
		wm.Listandenter("//*[@id='RefundChargeClassTypeCode_listbox']/li", Classtypeindex);
		Thread.sleep(200);

		// Fromsector
		wm.sendtextbyxvalue("//input[@aria-owns='RefundChargeFromSectorKey_listbox']", Fromsector);
		Thread.sleep(200);
		wm.Listandenter("//*[@id='RefundChargeFromSectorKey_listbox']/li", Fromsectorindex);
		Thread.sleep(200);

		// Tosector
		wm.sendtextbyxvalue("//input[@aria-owns='RefundChargeToSectorKey_listbox']", Tosector);
		Thread.sleep(200);
		wm.Listandenter("//*[@id='RefundChargeToSectorKey_listbox']/li", Tosectorindex);
		Thread.sleep(200);

		// chargename
		wm.sendtextbyxvalue("//input[@aria-owns='RefundChargeChargeKey_listbox']", Chargename);
		Thread.sleep(200);
		wm.Listandenter("//*[@id='RefundChargeChargeKey_listbox']/li", Chargenameindexx);
		Thread.sleep(200);

		// currencyy

		wm.sendtextbyxvalue("//input[@aria-owns='RefundChargeCurrencyKey_listbox']", Currency);
		Thread.sleep(200);
		wm.Listandenter("//*[@id='RefundChargeCurrencyKey_listbox']/li", Currencyindex);
		Thread.sleep(200);

		// entettheamount
		wm.sendtextbycssselecotrwithoutclear("#RefundChargeAmount", RefundChargeAmount);
		Thread.sleep(200);

		// dateselections
		wm.sendtextbycssselecotr("#RefundChargeEffectiveDate", "" + Effdate1 + "-" + Effdate2 + "-" + Effdate3);
		Thread.sleep(50);
		wm.sendtextbycssselecotr("#ActiveFrom", "" + RCActiveFrom1 + "-" + RCActiveFrom2 + "-" + RCActiveFrom3);
		Thread.sleep(50);
		wm.sendtextbycssselecotr("#ActiveTo", "" + RCActiveto1 + "-" + RCActiveto2 + "-" + RCActiveto3);
		Thread.sleep(50);

		// selectedtheactivestatus
		wm.clickbyxpath(" //span[@aria-owns='Status_listbox']");
		Thread.sleep(200);
		wm.Listandenter("//*[@id='Status_listbox']/li", RCStatuslistbox);
		Thread.sleep(200);

		wm.doubleclickusingxpath("//span[@class='k-icon k-i-check']");

		Thread.sleep(200);
		wm.Listandenter("//i[@class='fa fa-chevron-down']", "3");
		Thread.sleep(900);

		// classlinks
		// ==================================================================================

		Thread.sleep(200);
		wm.Listandenter("//i[@class='fa fa-chevron-down']", "4");
		Thread.sleep(500);
		wm.Listandenter("//span[@class='k-icon k-i-add']", "3");
		Thread.sleep(800);

		// class name
		wm.sendtextbyxvalue("//input[@aria-owns='ClassKey_listbox']", Classname);
		Thread.sleep(200);
		wm.Listandenter("//*[@id='ClassKey_listbox']/li", Classnameindex);
		Thread.sleep(200);

		// classtype
		wm.sendtextbyxvalue("//input[@aria-owns='ClassTypeKey_listbox']", ClassTypeKeylistbox);
		Thread.sleep(200);
		wm.Listandenter("//*[@id='ClassTypeKey_listbox']/li", ClassTypeKeylistboxindex);
		Thread.sleep(200);

		// date entering

		Thread.sleep(50);
		wm.sendtextbycssselecotr("#ActiveFrom", "" + ClActiveFrom1 + "-" + ClActiveFrom2 + "-" + ClActiveFrom3);
		Thread.sleep(50);
		wm.sendtextbycssselecotr("#ActiveTo", "" + CActiveto1 + "-" + CActiveto2 + "-" + CActiveto3);
		Thread.sleep(200);

		// selectedtheactivestatus
		wm.clickbyxpath(" //span[@aria-owns='Status_listbox']");
		Thread.sleep(200);
		wm.Listandenter("//*[@id='Status_listbox']/li", Classtatusindex);
		Thread.sleep(200);

		wm.doubleclickusingxpath("//span[@class='k-icon k-i-check']");

		Thread.sleep(200);
		wm.Listandenter("//i[@class='fa fa-chevron-down']", "4");
		Thread.sleep(900);
		
		
		//==========================================================================


		Thread.sleep(200);
		wm.Listandenter("//i[@class='fa fa-chevron-down']", "5");
		Thread.sleep(500);
		wm.Listandenter("//span[@class='k-icon k-i-add']", "4");
		Thread.sleep(800);
		

		// PAtnerlinks name===================================================================
		
		//supier
				wm.sendtextbyxvalue("//input[@aria-owns='CmsKey_listbox']",Supplier);
				Thread.sleep(200);
				wm.Listandenter("//*[@id='CmsKey_listbox']/li", Supplierindexx);
				Thread.sleep(200);


				// class name
						wm.sendtextbyxvalue("//input[@aria-owns='SupplierTypeKey_listbox']", Commissiontype);
						Thread.sleep(200);
						wm.Listandenter("//*[@id='SupplierTypeKey_listbox']/li", Commissiontypeindexx);
						Thread.sleep(200);
						
			//dateselectionss
						

						Thread.sleep(50);
						wm.sendtextbycssselecotr("#ActiveFrom", "" + PAActiveFrom1 + "-" + PAActiveFrom2 + "-" + PAActiveFrom3);
						Thread.sleep(50);
						wm.sendtextbycssselecotr("#ActiveTo", "" + PActiveto1 + "-" + PActiveto2 + "-" + PActiveto3);
						Thread.sleep(200);
						
						

						// selectedtheactivestatus
						wm.clickbyxpath(" //span[@aria-owns='Status_listbox']");
						Thread.sleep(200);
						wm.Listandenter("//*[@id='Status_listbox']/li", PAStatuslistbox);
						Thread.sleep(200);

						wm.doubleclickusingxpath("//span[@class='k-icon k-i-check']");

						Thread.sleep(200);
						wm.Listandenter("//i[@class='fa fa-chevron-down']", "5");
						Thread.sleep(900);
			
						
						wm.clickbyid("btnMainSave");
		
						wm.sleep();

						wm.Verifythealertpopupmessagesusincontains("//*[@id='diaInfoMessage']",
								"Updated Successfully",
								"Airline Saved/Updated Successfully",
								"Airline not Saved/Updated Successfully");

						Thread.sleep(500);
						
						
						Thread.sleep(500);
						wm.Listandenterquick("//span[contains(text(),'OK')]", "0");
						wm.Listandenterquick("//span[contains(text(),'OK')]", "1");
						wm.Listandenterquick("//span[contains(text(),'OK')]", "2");
						wm.Listandenterquick("//span[contains(text(),'OK')]", "3");

				
		
		wm.sleep();

	}

	@AfterMethod
	public void close()

	{
		wm.close();

	}

	@DataProvider(name = "dp")
	public Object[][] dp() throws IOException {

		return Wrappermethods.getSheet("Airline", "Airline");

	}
}