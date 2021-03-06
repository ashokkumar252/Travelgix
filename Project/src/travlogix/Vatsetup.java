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
public class Vatsetup {

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
	public void Vatsetup(String Username, String Password, String Leftsidemenu, String Code, String Description,
			String Type, String Typeindex, String Category, String Catindexxegoryindex, String Glcodee,
			String Glcodeeindexx, String VGtcmHsnCode, String Hsntype, String Hsntypeindex, String VGtcmHsnDescription,
			String ActfromDate1, String ActfromDate2, String ActfromDate3, String ActtoDate1, String ActtoDate2,
			String ActtoDate3, String Statuslistboxindex, String Producttype, String Producttypeindex,
			String Servicetype, String Servicetypeindex, String Packagenormal, String Packagenormalindex,
			String Classtype, String Classtypeindex, String Vatstatus, String Vatstatusindex, String State,
			String Stateindex, String Outputype, String Outputypeindex, String VtvsPercentage, String Applidatefrom1,
			String Applidatefrom2, String Applidatefrom3, String Appliedon, String Appliedonindexx,
			String InclusiveExclusivelistbox, String InclusiveExclusivelistboxindex, String Collectiontypelistbox,
			String Collectiontypelistboxindex, String Chargelistbox, String Chargelistboxindex, String VtvsValueFrom,
			String VtvsValueTo, String Statusslistbox, String Statusslistboxindex, String Customerlistbox,
			String Customerlistboxindexx, String Exempttype, String Exempttypeindex, String Productlistbox,
			String Productlistboxindex, String InterDomesticlistbox, String InterDomesticlistboxindex,
			String PackageNormallistbox, String PackageNormallistboxindex, String ClassTypelistbox,
			String ClassTypelistboxindex, String VEtvsSupplierVatStatuslistbox,
			String VEtvsSupplierVatStatuslistboxindex, String Statelistbox, String Statelistboxindexx,
			String OutputInputTypelistbox, String OutputInputTypelistboxindexx, String Percentage,
			String Applidatefrom4, String Applidatefrom5, String Applidatefrom6, String AppliedOnlistbox,
			String AppliedOnlistboxindexx, String InclusiveExclsivelistbox, String InclusiveExclsivelistboxindexx,
			String CollectionTypelistbox, String CollectionTypelistboxindex, String Chargelistboxx,
			String Chargelistboxindexx, String ValueFromm, String ValueTo, String Statussslistbox,
			String Statussslistboxindexx) throws Exception

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
		wm.clickbyid("modTRS001");
		Thread.sleep(500);
		wm.clickbyid("pgmMVS001");
		wm.sleep();

		wm.clickbyid("btnMainAdd");
		Thread.sleep(500);

		wm.sendtextbycssselecotrwithoutclear("#Code", Code);

		wm.sendtextbycssselecotrwithoutclear("#Description", Description);

		// enter the typee
		wm.sendtextbyxvalue("//input[@aria-owns='VGtcmTypeName_listbox']", Type);
		Thread.sleep(200);
		wm.Listandenter("//*[@id='VGtcmTypeName_listbox']/li", Typeindex);
		Thread.sleep(200);

		// enter the typee
		wm.sendtextbyxvalue("//input[@aria-owns='VGtcmCategoryName_listbox']", Category);
		Thread.sleep(200);
		wm.Listandenter("//*[@id='VGtcmCategoryName_listbox']/li", Catindexxegoryindex);
		Thread.sleep(200);

		/*
		 * // enter the typee
		 * wm.sendtextbyxvalue("//input[@aria-owns='VGtcmCategoryName_listbox']"
		 * ,Category); Thread.sleep(200);
		 * wm.Listandenter("//*[@id='VGtcmCategoryName_listbox']/li",
		 * Catindexxegoryindex); Thread.sleep(200);
		 */

		// enter the GLcodee
		wm.sendtextbyxvalue("//input[@aria-owns='VGtcmGlKey_listbox']", Glcodee);
		Thread.sleep(200);
		wm.Listandenter("//*[@id='VGtcmGlKey_listbox']/li", Glcodeeindexx);
		Thread.sleep(200);

		// Eter the hsncode
		wm.sendtextbycssselecotrwithoutclear("#VGtcmHsnCode", VGtcmHsnCode);

		// HSN typee
		wm.sendtextbyxvalue("//input[@aria-owns='VGtcmHsnTypeName_listbox']", Hsntype);
		Thread.sleep(200);
		wm.Listandenter("//*[@id='VGtcmHsnTypeName_listbox']/li", Hsntypeindex);
		Thread.sleep(200);

		// Hsn descriptions
		wm.sendtextbycssselecotrwithoutclear("#VGtcmHsnDescription", VGtcmHsnDescription);

		// Date
		wm.sendtextbycssselecotr("#ActiveFrom", "" + ActfromDate1 + "-" + ActfromDate2 + "-" + ActfromDate3);

		wm.sendtextbycssselecotr("#ActiveTo", "" + ActtoDate1 + "-" + ActtoDate2 + "-" + ActtoDate3);

		// HSN typee

		wm.clickbyxpath("//span[@aria-owns='Status_listbox']");
		Thread.sleep(200);
		wm.Listandenter("//*[@id='Status_listbox']/li", Statuslistboxindex);
		Thread.sleep(200);

		// etering the vatsetup

		wm.Listandenter("//span[@class='k-icon k-i-add']", "0");
		Thread.sleep(300);

		// enterthe producttype

		wm.sendtextbyxvalue("//input[@aria-owns='VtvsProductType_listbox']", Producttype);
		Thread.sleep(200);
		wm.Listandenter("//*[@id='VtvsProductType_listbox']/li", Producttypeindex);
		Thread.sleep(200);

		// Servicetype

		wm.sendtextbyxvalue("//input[@aria-owns='VtvsInterDomestic_listbox']", Servicetype);
		Thread.sleep(200);
		wm.Listandenter("//*[@id='VtvsInterDomestic_listbox']/li", Servicetypeindex);
		Thread.sleep(200);

		// Packageornormal

		wm.sendtextbyxvalue("//input[@aria-owns='VtvsPackageNormal_listbox']", Packagenormal);
		Thread.sleep(200);
		wm.Listandenter("//*[@id='VtvsPackageNormal_listbox']/li", Packagenormalindex);
		Thread.sleep(200);

		// Classtype
		wm.sendtextbyxvalue("//input[@aria-owns='VtvsClassType_listbox']", Classtype);
		Thread.sleep(200);
		wm.Listandenter("//*[@id='VtvsClassType_listbox']/li", Classtypeindex);
		Thread.sleep(200);

		// VATstatus
		wm.sendtextbyxvalue("//input[@aria-owns='VtvsSupplierVatStatus_listbox']", Vatstatus);
		Thread.sleep(200);
		wm.Listandenter("//*[@id='VtvsSupplierVatStatus_listbox']/li", Vatstatusindex);
		Thread.sleep(200);

		// VATstatus
		wm.sendtextbyxvalue("//input[@aria-owns='VtvsStateKey_listbox']", State);
		Thread.sleep(200);
		wm.Listandenter("//*[@id='VtvsStateKey_listbox']/li", Stateindex);
		Thread.sleep(200);

		// Output type
		wm.sendtextbyxvalue("//input[@aria-owns='VtvsOutputInputType_listbox']", Outputype);
		Thread.sleep(200);
		wm.Listandenter("//*[@id='VtvsOutputInputType_listbox']/li", Outputypeindex);
		Thread.sleep(200);

		// enter thepercentage
		wm.sendtextbycssselecotrwithoutclear("#VtvsPercentage", VtvsPercentage);
		Thread.sleep(200);
		// Dateselections
		wm.sendtextbycssselecotr("#VtvsApplicableFrom",
				"" + Applidatefrom1 + "-" + Applidatefrom2 + "-" + Applidatefrom3);
		Thread.sleep(200);

		// Applieon
		wm.sendtextbyxvalue("//input[@aria-owns='VtvsAppliedOn_listbox']", Appliedon);
		Thread.sleep(200);
		wm.Listandenter("//*[@id='VtvsAppliedOn_listbox']/li", Appliedonindexx);
		Thread.sleep(200);

		// Applieon
		wm.sendtextbyxvalue("//input[@aria-owns='InclusiveExclusive_listbox']", InclusiveExclusivelistbox);
		Thread.sleep(200);
		wm.Listandenter("//*[@id='InclusiveExclusive_listbox']/li", InclusiveExclusivelistboxindex);
		Thread.sleep(200);

		// Collectiontypee
		wm.sendtextbyxvalue("//input[@aria-owns='Collectiontype_listbox']", Collectiontypelistbox);
		Thread.sleep(200);
		wm.Listandenter("//*[@id='Collectiontype_listbox']/li", Collectiontypelistboxindex);
		Thread.sleep(200);

		// Chargee
		wm.sendtextbyxvalue("//input[@aria-owns='Charge_listbox']", Chargelistbox);
		Thread.sleep(200);
		wm.Listandenter("//*[@id='Charge_listbox']/li", Chargelistboxindex);
		Thread.sleep(200);

		// valuefrom

		wm.sendtextbycssselecotrwithoutclear("#VtvsValueFrom", VtvsValueFrom);
		Thread.sleep(200);

		// valueto

		wm.sendtextbycssselecotrwithoutclear("#VtvsValueTo", VtvsValueTo);
		Thread.sleep(200);

		// Statuss_listbox
		wm.sendtextbyxvalue("//input[@aria-owns='Statuss_listbox']", Statusslistbox);
		Thread.sleep(200);
		wm.Listandenter("//*[@id='Statuss_listbox']/li", Statusslistboxindex);
		Thread.sleep(200);

		wm.clickbyxpath("//span[@class='k-icon k-i-check']");
		Thread.sleep(900);

		// ========================================================================================

		// EXEMPTED VAT SETUP

		wm.Listandenter("//span[@class='k-icon k-i-add']", "1");
		Thread.sleep(300);

		// Customername
		wm.sendtextbyxvalue("//input[@aria-owns='Customer_listbox']", Customerlistbox);
		Thread.sleep(200);
		wm.Listandenter("//*[@id='Customer_listbox']/li", Customerlistboxindexx);
		Thread.sleep(200);

		// exemprttypee
		wm.sendtextbyxvalue("//input[@aria-owns='ExemptType_listbox']", Exempttype);
		Thread.sleep(200);
		wm.Listandenter("//*[@id='ExemptType_listbox']/li", Exempttypeindex);
		Thread.sleep(200);

		// Productname
		wm.sendtextbyxvalue("//input[@aria-owns='Product_listbox']", Productlistbox);
		Thread.sleep(200);
		wm.Listandenter("//*[@id='Product_listbox']/li", Productlistboxindex);
		Thread.sleep(200);

		// internation/domestice
		wm.sendtextbyxvalue("//input[@aria-owns='InterDomestic_listbox']", InterDomesticlistbox);
		Thread.sleep(200);
		wm.Listandenter("//*[@id='InterDomestic_listbox']/li", InterDomesticlistboxindex);
		Thread.sleep(200);

		// PAckage/normal
		wm.sendtextbyxvalue("//input[@aria-owns='PackageNormal_listbox']", PackageNormallistbox);
		Thread.sleep(200);
		wm.Listandenter("//*[@id='PackageNormal_listbox']/li", PackageNormallistboxindex);
		Thread.sleep(200);

		// classtypee
		wm.sendtextbyxvalue("//input[@aria-owns='ClassType_listbox']", ClassTypelistbox);
		Thread.sleep(200);
		wm.Listandenter("//*[@id='ClassType_listbox']/li", ClassTypelistboxindex);
		Thread.sleep(200);

		// VATstatuss
		wm.sendtextbyxvalue("//input[@aria-owns='VEtvsSupplierVatStatus_listbox']", VEtvsSupplierVatStatuslistbox);
		Thread.sleep(200);
		wm.Listandenter("//*[@id='VEtvsSupplierVatStatus_listbox']/li", VEtvsSupplierVatStatuslistboxindex);
		Thread.sleep(200);

		// Statee
		wm.sendtextbyxvalue("//input[@aria-owns='State_listbox']", Statelistbox);
		Thread.sleep(200);
		wm.Listandenter("//*[@id='State_listbox']/li", Statelistboxindexx);
		Thread.sleep(200);
		/*
		 * //Statee wm.sendtextbyxvalue("//input[@aria-owns='State_listbox']",
		 * Statelistbox); Thread.sleep(200);
		 * wm.Listandenter("//*[@id='State_listbox']/li",Statelistboxindexx);
		 * Thread.sleep(200);
		 * 
		 * 
		 */
		// Output/inputbox
		wm.sendtextbyxvalue("//input[@aria-owns='OutputInputType_listbox']", OutputInputTypelistbox);
		Thread.sleep(200);
		wm.Listandenter("//*[@id='OutputInputType_listbox']/li", OutputInputTypelistboxindexx);
		Thread.sleep(200);

		// Enter thepercentage
		wm.sendtextbycssselecotrwithoutclear("#Percentage", Percentage);
		Thread.sleep(200);

		// date

		wm.sendtextbycssselecotr("#tvseApplicableFrom",
				"" + Applidatefrom4 + "-" + Applidatefrom5 + "-" + Applidatefrom6);
		Thread.sleep(200);

		// Appleedon
		wm.sendtextbyxvalue("//input[@aria-owns='AppliedOn_listbox']", AppliedOnlistbox);
		Thread.sleep(200);
		wm.Listandenter("//*[@id='AppliedOn_listbox']/li", AppliedOnlistboxindexx);
		Thread.sleep(200);

		// Inclusiveandexcuslive
		wm.sendtextbyxvalue("//input[@aria-owns='InclusiveExclsive_listbox']", InclusiveExclsivelistbox);
		Thread.sleep(200);
		wm.Listandenter("//*[@id='InclusiveExclsive_listbox']/li", InclusiveExclsivelistboxindexx);
		Thread.sleep(200);

		// CollectionType_listbox
		wm.sendtextbyxvalue("//input[@aria-owns='CollectionType_listbox']", CollectionTypelistbox);
		Thread.sleep(200);
		wm.Listandenter("//*[@id='CollectionType_listbox']/li", CollectionTypelistboxindex);
		Thread.sleep(200);

		// chargee
		wm.sendtextbyxvalue("//input[@aria-owns='Charge_listbox']", Chargelistboxx);
		Thread.sleep(200);
		wm.Listandenter("//*[@id='Charge_listbox']/li", Chargelistboxindexx);
		Thread.sleep(200);

		// validfrom
		wm.sendtextbycssselecotrwithoutclear("#ValueFrom", ValueFromm);
		Thread.sleep(200);

		// validtoo
		wm.sendtextbycssselecotrwithoutclear("#ValueTo", ValueTo);
		Thread.sleep(200);

		// Statuss_listbox
		wm.sendtextbyxvalue("//input[@aria-owns='Statusss_listbox']", Statussslistbox);
		Thread.sleep(200);
		wm.Listandenter("//*[@id='Statusss_listbox']/li", Statussslistboxindexx);
		Thread.sleep(200);

		wm.clickbyxpath("//span[@class='k-icon k-i-check']");
		Thread.sleep(900);

		wm.clickbyid("btnMainSave");

		wm.sleep();

		wm.Verifythealertpopupmessages("//*[@id='diaInfoMessage']",
				"VAT Setup Saved/Updated Successfully",
				"VAT Setup Saved/Updated Successfully", 
				"VAT Setup not Saved/Updated Successfully");

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

		return Wrappermethods.getSheet("Vatsetup", "Vatsetup");

	}
}