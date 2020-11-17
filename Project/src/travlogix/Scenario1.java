//WASTA login screen
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
public class Scenario1 {

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
	public void logincheckK(String Username, String Password, String Leftsidemenu, String ccdCategory,

			String Leftsidemenucurrency, String Code, String name, String currencyLocalizedName,
			String currencyBaseDescription, String Country, String Countryindex, String currencySymbol,
			String currencyPastiveFormat, String currencyNegativeFormat, String currencyDecimalDescription,
			String currencyNumberToBase, String currencyDecimalSymbol, String currencyDecimalDigits, String ActiveFrom1,
			String ActiveFrom2, String ActiveFrom3, String ActiveTo1, String ActiveTo2, String ActiveTo3,
			String Statusindex1, String Leftsidemenucountry, String CountryCode, String CountryName,
			String Abbreviation, String IsoCode, String InitialDialCode, String Region, String Regionindex,
			String ActiveFromCounry1, String ActiveFromCounry2, String ActiveFromCounry3, String ActiveToCountry1,
			String ActiveToCountry2, String ActiveToCountry3, String Statusindex2, String Leftsidemenustate,
			String StateCode, String StateName, String StateCountry, String StateCountryindex, String ActiveFromstate1,
			String ActiveFromstate2, String ActiveFromstate3, String ActiveTostate1, String ActiveTostate2,
			String ActiveTostate3, String Statusindex3, String Leftsidemenucityy, String CityCode, String CityName,
			String CityCountryName,String CityStateNameindexx,String CityStateName,String CityStateNameindexxx,String ActiveFromcity1, String ActiveFromcity2,
			String ActiveFromcity3, String ActiveTocity1, String ActiveTocity2, String ActiveTocity3,
			String Statusindex5, String Leftsidemenudesignation, String DesignationCode, String DesignationName,
			String ActiveFromdesignation1, String ActiveFromdesignation2, String ActiveFromdesignation3,
			String ActiveTodesignation1, String ActiveTodesignation2, String ActiveTodesignation3, String Statusindex6,
			String Leftsidemenunationality, String NationalityCode, String NationalityName, String Nationalitycountry,
			String Nationalitycountryindex, String ActiveFromnationality1, String ActiveFromnationality2,
			String ActiveFromnationality3, String ActiveTonationality1, String ActiveTonationality2,
			String ActiveTonationality3, String Statusindex7, String Leftsidemenuclassification,
			String ClassificationCode, String ClassificationName, String Patnertype, String Patnertypeindexx,
			String ActiveFromnclass1, String ActiveFromnclass2, String ActiveFromnclass3, String ActiveToclass1,
			String ActiveToclass2, String ActiveToclass3, String Statusindex8,
			String Leftsidemenuaddresstypee,String AddresstypeCode,String AddresstypeName,String ActiveFromnaddresstype1,
			String ActiveFromnaddresstype2,String ActiveFromnaddresstype3,String ActiveToaddresstype1,
			String ActiveToaddresstype2,String ActiveToaddresstype3,String Statusindex9,String LeftsideBussinesspartner,
			String Commonindex,String Vatnumber,String Executivecode,String Salutation,String Genderr,
			String UDIDCustomername) throws Exception

	{

		Thread.sleep(2000);

		// wm.sendtextbyid("", );
		wm.sendtextbyid("LoginCode", Username);
		Thread.sleep(200);
		wm.sendtextbyid("Password", Password);
		Thread.sleep(200);
		wm.clickbyxpath("//input[@value='Login']");
		wm.sleep();

		// Creating new Bussiness category Screen
		// ======================================================================
		// enter the eft side menu
		wm.sendtextbyid("input-items", Leftsidemenu);
		Thread.sleep(900);
		wm.clickbyid("modMAS001");
		Thread.sleep(900);
		wm.clickbyid("pgmCOMCAT001");
		wm.sleep();
		Thread.sleep(900);
		wm.clickbyid("btnMainAdd");
		wm.sleep();
		// sendin client categry detials
		wm.sendtextbycssselecotrwithoutclear("#ccdCategory", ccdCategory);
		Thread.sleep(500);
		wm.doubleclickusingxpath("//span[@class='k-icon k-i-check']");
		Thread.sleep(500);
		wm.clickbyid("btnMainSave");
		Thread.sleep(500);
		wm.capturetextfrommsgbox("//div[@id='dialogWarning']", "Bussiness Category Record created successfully ");
		Thread.sleep(500);
		wm.Listandenterquick("//span[contains(text(),'OK')]", "0");
		wm.Listandenterquick("//span[contains(text(),'OK')]", "1");
		wm.Listandenterquick("//span[contains(text(),'OK')]", "2");
		wm.Listandenterquick("//span[contains(text(),'OK')]", "3");
		Thread.sleep(900);
		// ===========================================================================================

		// Adding the currency Details

		wm.sendtextbyid("input-items", Leftsidemenucurrency);
		Thread.sleep(900);
		// wm.clickbyid("modMAS001");
		// Thread.sleep(900);
		wm.clickbyid("pgmCR001");
		Thread.sleep(900);

		wm.clickbyid("btnMainAdd");
		Thread.sleep(900);
		wm.sendtextbycssselecotrwithoutclear("#Code", Code);
		Thread.sleep(50);
		wm.sendtextbycssselecotrwithoutclear("#name", name);
		Thread.sleep(50);
		wm.sendtextbycssselecotrwithoutclear("#currencyLocalizedName", "" + currencyLocalizedName);
		Thread.sleep(50);
		wm.sendtextbycssselecotrwithoutclear("#currencyBaseDescription", "" + currencyBaseDescription);
		Thread.sleep(50);
		wm.sendtextbyxvalue("//input[@aria-owns='currencyCountryName_listbox']", Country);
		Thread.sleep(500);
		wm.Listandenter("//*[@id='currencyCountryName_listbox']/li", Countryindex);
		Thread.sleep(500);

		wm.sendtextbycssselecotrwithoutclear("#currencySymbol", currencySymbol);
		Thread.sleep(50);
		wm.sendtextbycssselecotrwithoutclear("#currencyPastiveFormat", currencyPastiveFormat);
		Thread.sleep(50);
		wm.sendtextbycssselecotrwithoutclear("#currencyNegativeFormat", "" + currencyNegativeFormat);
		Thread.sleep(50);
		wm.sendtextbycssselecotrwithoutclear("#currencyDecimalDescription", "" + currencyDecimalDescription);
		Thread.sleep(50);
		wm.sendtextbycssselecotrwithoutclear("#currencyNumberToBase", "" + currencyNumberToBase);
		Thread.sleep(50);
		wm.sendtextbycssselecotrwithoutclear("#currencyDecimalSymbol", "" + currencyDecimalSymbol);
		Thread.sleep(50);
		wm.sendtextbycssselecotrwithoutclear("#currencyDecimalDigits", "" + currencyDecimalDigits);
		Thread.sleep(50);
		wm.sendtextbycssselecotr("#ActiveFrom", "" + ActiveFrom1 + "-" + ActiveFrom2 + "-" + ActiveFrom3);
		Thread.sleep(50);
		wm.sendtextbycssselecotr("#ActiveTo", "" + ActiveTo1 + "-" + ActiveTo2 + "-" + ActiveTo3);
		Thread.sleep(50);
		wm.clickbyxpath("//span[@aria-owns='Status_listbox']");
		Thread.sleep(300);
		wm.Listandenter("//*[@id='Status_listbox']/li", Statusindex1);
		Thread.sleep(600);

		wm.doubleclickusingxpath("//span[@class='k-icon k-i-check']");
		Thread.sleep(900);
		wm.clickbyid("btnMainSave");
		Thread.sleep(600);
		wm.capturetextfrommsgbox("//div[@id='dialogWarning']", "Currency Record created successfully ");
		Thread.sleep(600);
		wm.Listandenterquick("//span[contains(text(),'OK')]", "0");
		wm.Listandenterquick("//span[contains(text(),'OK')]", "1");
		wm.Listandenterquick("//span[contains(text(),'OK')]", "2");
		wm.Listandenterquick("//span[contains(text(),'OK')]", "3");
		Thread.sleep(900);

		// ======================================================================
		// Adding country=======================================================

		wm.sendtextbyid("input-items", Leftsidemenucountry);
		Thread.sleep(300);
		wm.clickbyid("modRPT001");
		Thread.sleep(300);
		wm.clickbyid("pgmCU001");
		Thread.sleep(300);

		wm.clickbyid("btnMainAdd");
		Thread.sleep(300);

		wm.sendtextbycssselecotrwithoutclear("#CountryCode", "" + CountryCode);
		Thread.sleep(50);
		wm.sendtextbycssselecotrwithoutclear("#CountryName", "" + CountryName);
		Thread.sleep(50);
		wm.sendtextbycssselecotrwithoutclear("#Abbreviation", "" + Abbreviation);
		Thread.sleep(50);
		wm.sendtextbycssselecotrwithoutclear("#IsoCode", "" + IsoCode);
		Thread.sleep(50);
		wm.sendtextbycssselecotrwithoutclear("#InitialDialCode", "" + InitialDialCode);
		Thread.sleep(50);

		wm.sendtextbyxvalue("//input[@aria-owns='RegionDescription_listbox']", Region);
		Thread.sleep(300);
		wm.Listandenter("//*[@id='RegionDescription_listbox']/li", Regionindex);
		Thread.sleep(300);

		wm.sendtextbycssselecotr("#ActiveFrom",
				"" + ActiveFromCounry1 + "-" + ActiveFromCounry2 + "-" + ActiveFromCounry3);
		Thread.sleep(50);
		wm.sendtextbycssselecotr("#ActiveTo", "" + ActiveToCountry1 + "-" + ActiveToCountry2 + "-" + ActiveToCountry3);
		Thread.sleep(50);

		Thread.sleep(50);
		wm.clickbyxpath("//span[@aria-owns='Status_listbox']");
		Thread.sleep(200);
		wm.Listandenter("//*[@id='Status_listbox']/li", Statusindex2);
		Thread.sleep(500);

		wm.doubleclickusingxpath("//span[@class='k-icon k-i-check']");
		Thread.sleep(300);
		wm.clickbyid("btnMainSave");
		Thread.sleep(500);
		wm.capturetextfrommsgbox("//div[@id='dialogWarning']", "Country Record created successfully ");
		Thread.sleep(300);
		wm.Listandenterquick("//span[contains(text(),'OK')]", "0");
		wm.Listandenterquick("//span[contains(text(),'OK')]", "1");
		wm.Listandenterquick("//span[contains(text(),'OK')]", "2");
		wm.Listandenterquick("//span[contains(text(),'OK')]", "3");
		Thread.sleep(900);

		// ==============================================================================

		// Adding state==================================================

		wm.sendtextbyid("input-items", Leftsidemenustate);
		Thread.sleep(300);
		// wm.clickbyid("modRPT001");
		// Thread.sleep(300);
		wm.clickbyid("pgmS0001");
		Thread.sleep(300);

		wm.clickbyid("btnMainAdd");
		Thread.sleep(300);

		wm.sendtextbycssselecotrwithoutclear("#Code", "" + StateCode);
		Thread.sleep(50);

		wm.sendtextbycssselecotrwithoutclear("#StateName", "" + StateName);
		Thread.sleep(50);

		wm.sendtextbyxvalue("//input[@aria-owns='CountryKey_listbox']", StateCountry);
		Thread.sleep(300);
		wm.Listandenter("//*[@id='CountryKey_listbox']/li", StateCountryindex);
		Thread.sleep(300);

		wm.sendtextbycssselecotr("#ActiveFrom",
				"" + ActiveFromstate1 + "-" + ActiveFromstate2 + "-" + ActiveFromstate3);
		Thread.sleep(50);
		wm.sendtextbycssselecotr("#ActiveTo", "" + ActiveTostate1 + "-" + ActiveTostate2 + "-" + ActiveTostate3);

		Thread.sleep(50);
		wm.clickbyxpath("//span[@aria-owns='Status_listbox']");
		Thread.sleep(200);
		wm.Listandenter("//*[@id='Status_listbox']/li", Statusindex3);
		Thread.sleep(300);

		wm.doubleclickusingxpath("//span[@class='k-icon k-i-check']");
		Thread.sleep(300);
		wm.clickbyid("btnMainSave");
		Thread.sleep(500);
		wm.capturetextfrommsgbox("//div[@id='dialogWarning']", "State Record created successfully ");
		Thread.sleep(500);
		wm.Listandenterquick("//span[contains(text(),'OK')]", "0");
		wm.Listandenterquick("//span[contains(text(),'OK')]", "1");
		wm.Listandenterquick("//span[contains(text(),'OK')]", "2");
		wm.Listandenterquick("//span[contains(text(),'OK')]", "3");
		Thread.sleep(900);

		// =====================================Adding city
		// masterr=====================================
		wm.sendtextbyid("input-items", Leftsidemenucityy);
		Thread.sleep(300);
		// wm.clickbyid("modRPT001");
		// Thread.sleep(300);
		wm.clickbyid("pgmCT001");
		Thread.sleep(300);

		wm.clickbyid("btnMainAdd");
		Thread.sleep(300);

		wm.sendtextbycssselecotrwithoutclear("#CityCode", "" + CityCode);
		Thread.sleep(50);
		wm.sendtextbycssselecotrwithoutclear("#CityName", "" + CityName);
		Thread.sleep(50);
		wm.sendtextbycssselecotrwithoutclear("#CountryName", "" + CityCountryName);
		Thread.sleep(120);
		//wm.sendtextbyxvalue("//input[@aria-owns='Destination_listbox']",Destination);
				Thread.sleep(300);
				wm.Listandenter("//*[@id='CountryName_listbox']/li", CityStateNameindexx);
				Thread.sleep(1200);
				
		
		wm.sendtextbycssselecotrwithoutclear("#StateName", "" + CityStateName);
		Thread.sleep(50);
		wm.Listandenter("//*[@id='StateName_listbox']/li", CityStateNameindexxx);
		Thread.sleep(1200);


		wm.sendtextbycssselecotr("#ActiveFrom", "" + ActiveFromcity1 + "-" + ActiveFromcity2 + "-" + ActiveFromcity3);
		Thread.sleep(50);
		wm.sendtextbycssselecotr("#ActiveTo", "" + ActiveTocity1 + "-" + ActiveTocity2 + "-" + ActiveTocity3);

		Thread.sleep(50);
		wm.clickbyxpath("//span[@aria-owns='Status_listbox']");
		Thread.sleep(200);
		wm.Listandenter("//*[@id='Status_listbox']/li", Statusindex5);
		Thread.sleep(500);

		wm.doubleclickusingxpath("//span[@class='k-icon k-i-check']");
		Thread.sleep(500);
		wm.clickbyid("btnMainSave");
		Thread.sleep(300);
		wm.capturetextfrommsgbox("//div[@id='dialogWarning']", "City Record created successfully ");
		Thread.sleep(300);
		wm.Listandenterquick("//span[contains(text(),'OK')]", "0");
		wm.Listandenterquick("//span[contains(text(),'OK')]", "1");
		wm.Listandenterquick("//span[contains(text(),'OK')]", "2");
		wm.Listandenterquick("//span[contains(text(),'OK')]", "3");
		Thread.sleep(900);

		// =====================Desigination
		// Master=====================================================

		wm.sendtextbyid("input-items", Leftsidemenudesignation);
		Thread.sleep(300);
		// wm.clickbyid("modRPT001");
		// Thread.sleep(300);
		wm.clickbyid("pgmDSG001");
		Thread.sleep(300);

		wm.clickbyid("btnMainAdd");
		Thread.sleep(300);

		wm.sendtextbycssselecotrwithoutclear("#DesignationCode", "" + DesignationCode);
		Thread.sleep(50);
		wm.sendtextbycssselecotrwithoutclear("#DesignationName", "" + DesignationName);
		Thread.sleep(50);

		wm.sendtextbycssselecotr("#ActiveFrom",
				"" + ActiveFromdesignation1 + "-" + ActiveFromdesignation2 + "-" + ActiveFromdesignation3);
		Thread.sleep(50);
		wm.sendtextbycssselecotr("#ActiveTo",
				"" + ActiveTodesignation1 + "-" + ActiveTodesignation2 + "-" + ActiveTodesignation3);

		Thread.sleep(50);
		wm.clickbyxpath("//span[@aria-owns='Status_listbox']");
		Thread.sleep(200);
		wm.Listandenter("//*[@id='Status_listbox']/li", Statusindex6);
		Thread.sleep(500);

		wm.doubleclickusingxpath("//span[@class='k-icon k-i-check']");
		Thread.sleep(300);
		wm.clickbyid("btnMainSave");
		Thread.sleep(2000);
		wm.capturetextfrommsgbox("//div[@id='dialogWarning']", "Desigination Record created successfully ");
		Thread.sleep(300);
		wm.Listandenterquick("//span[contains(text(),'OK')]", "0");
		wm.Listandenterquick("//span[contains(text(),'OK')]", "1");
		wm.Listandenterquick("//span[contains(text(),'OK')]", "2");
		wm.Listandenterquick("//span[contains(text(),'OK')]", "3");
		Thread.sleep(900);

		// ========Nationality
		// master===================================================================================

		wm.sendtextbyid("input-items", Leftsidemenunationality);
		Thread.sleep(300);
		// wm.clickbyid("modRPT001");
		// Thread.sleep(300);
		wm.clickbyid("pgmNT001");
		Thread.sleep(300);

		wm.clickbyid("btnMainAdd");
		Thread.sleep(300);

		wm.sendtextbycssselecotrwithoutclear("#NationalityCode", "" + NationalityCode);
		Thread.sleep(50);
		wm.sendtextbycssselecotrwithoutclear("#NationalityName", "" + NationalityName);
		Thread.sleep(50);

		
		wm.sendtextbycssselecotr("#ActiveFrom",
				"" + ActiveFromnationality1 + "-" + ActiveFromnationality2 + "-" + ActiveFromnationality3);
		Thread.sleep(50);
		wm.sendtextbycssselecotr("#ActiveTo",
				"" + ActiveTonationality1 + "-" + ActiveTonationality2 + "-" + ActiveTonationality3);

		Thread.sleep(50);
		wm.clickbyxpath("//span[@aria-owns='Status_listbox']");
		Thread.sleep(200);
		wm.Listandenter("//*[@id='Status_listbox']/li", Statusindex7);
		Thread.sleep(500);

		//wm.clickbyxpath("//span[@aria-controls='CountryName_listbox']");
				wm.sendtextbyxvalue("//input[@aria-owns='CountryName_listbox']", Nationalitycountry);
				Thread.sleep(200);
				wm.keyboardarrowdownonetime("//input[@aria-owns='CountryName_listbox']");
				Thread.sleep(50);
				wm.Enterbyxpath("//input[@aria-owns='CountryName_listbox']");
				Thread.sleep(500);

				wm.Listandenterdoubleclick("//span[@class='k-icon k-i-check']", "0");
				
		//wm.doubleclickusingxpath("//span[@class='k-icon k-i-check']");
		Thread.sleep(500);
		wm.clickbyid("btnMainSave");
		Thread.sleep(900);
		wm.capturetextfrommsgbox("//div[@id='dialogWarning']", "Nationality Record created successfully ");
		Thread.sleep(300);
		wm.Listandenterquick("//span[contains(text(),'OK')]", "0");
		wm.Listandenterquick("//span[contains(text(),'OK')]", "1");
		wm.Listandenterquick("//span[contains(text(),'OK')]", "2");
		wm.Listandenterquick("//span[contains(text(),'OK')]", "3");
		Thread.sleep(900);

		// =====================Classification master
		// ========================================

		wm.sendtextbyid("input-items", Leftsidemenuclassification);
		Thread.sleep(300);
		wm.clickbyid("modMAS001");
		Thread.sleep(300);
		wm.clickbyid("pgmCLS001");
		Thread.sleep(300);

		wm.clickbyid("btnMainAdd");
		Thread.sleep(300);

		wm.sendtextbycssselecotrwithoutclear("#ClassificationCode", "" + ClassificationCode);
		Thread.sleep(50);

		wm.sendtextbycssselecotrwithoutclear("#ClassificationName", "" + ClassificationName);
		Thread.sleep(50);

		wm.sendtextbyxvalue("//input[@aria-owns='classficType_listbox']", Patnertype);
		Thread.sleep(200);
		wm.Listandenter("//*[@id='classficType_listbox']/li", Patnertypeindexx);
		Thread.sleep(200);

		wm.sendtextbycssselecotr("#ActiveFrom",
				"" + ActiveFromnclass1 + "-" + ActiveFromnclass2 + "-" + ActiveFromnclass3);
		Thread.sleep(150);
		wm.sendtextbycssselecotr("#ActiveTo", "" + ActiveToclass1 + "-" + ActiveToclass2 + "-" + ActiveToclass3);
		wm.sendtextbycssselecotr("#ActiveTo", "" + ActiveToclass1 + "-" + ActiveToclass2 + "-" + ActiveToclass3);

		Thread.sleep(500);
		wm.clickbyxpath("//span[@aria-owns='ActiveStatus_listbox']");
		Thread.sleep(300);
		wm.Listandenter("//*[@id='ActiveStatus_listbox']/li", Statusindex8);
		Thread.sleep(600);

		wm.doubleclickusingxpath("//span[@class='k-icon k-i-check']");
		Thread.sleep(600);
		wm.clickbyid("btnMainSave");
		Thread.sleep(500);
		wm.capturetextfrommsgbox("//div[@id='dialogWarning']", "Classification  Record created successfully ");
		Thread.sleep(300);
		wm.Listandenterquick("//span[contains(text(),'OK')]", "0");
		wm.Listandenterquick("//span[contains(text(),'OK')]", "1");
		wm.Listandenterquick("//span[contains(text(),'OK')]", "2");
		wm.Listandenterquick("//span[contains(text(),'OK')]", "3");
		Thread.sleep(500);
		
	//============Address typee========================================================================
		
		wm.sendtextbyid("input-items", Leftsidemenuaddresstypee);
		Thread.sleep(300);
		//wm.clickbyid("modMAS001");
		//Thread.sleep(300);
		wm.clickbyid("pgmADDRESSTYPE");
		Thread.sleep(300);

		wm.clickbyid("btnMainAdd");
		Thread.sleep(300);

		wm.sendtextbycssselecotrwithoutclear("#Code", "" + AddresstypeCode);
		Thread.sleep(50);
		wm.sendtextbycssselecotrwithoutclear("#Name", "" + AddresstypeName);
		Thread.sleep(50);
		

		wm.sendtextbycssselecotr("#ActiveFrom",
				"" + ActiveFromnaddresstype1 + "-" + ActiveFromnaddresstype2 + "-" + ActiveFromnaddresstype3);
		Thread.sleep(200);
		wm.sendtextbycssselecotr("#ActiveTo", "" + ActiveToaddresstype1 + "-" + ActiveToaddresstype2 + "-" + 
		ActiveToaddresstype3);
		
		wm.sendtextbycssselecotr("#ActiveTo", "" + ActiveToaddresstype1 + "-" + ActiveToaddresstype2 + "-" + 
		ActiveToaddresstype3);
		
		Thread.sleep(300);
		wm.clickbyxpath("//span[@aria-owns='Status_listbox']");
		Thread.sleep(200);
		wm.Listandenter("//*[@id='Status_listbox']/li", Statusindex9);
		Thread.sleep(600);

		wm.doubleclickusingxpath("//span[@class='k-icon k-i-check']");
		Thread.sleep(500);
		wm.clickbyid("btnMainSave");
		Thread.sleep(900);
		wm.capturetextfrommsgbox("//div[@id='dialogWarning']", "Address  Record created successfully ");
		Thread.sleep(300);
		wm.Listandenterquick("//span[contains(text(),'OK')]", "0");
		wm.Listandenterquick("//span[contains(text(),'OK')]", "1");
		wm.Listandenterquick("//span[contains(text(),'OK')]", "2");
		wm.Listandenterquick("//span[contains(text(),'OK')]", "3");
		Thread.sleep(300);
		

	}

	@AfterMethod
	public void close()

	{
		wm.close();

	}

	@DataProvider(name = "dp")
	public Object[][] dp() throws IOException {

		return Wrappermethods.getSheet("BusinessPartner", "negative");

	}
}