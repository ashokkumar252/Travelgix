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
public class HotelMaster {

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
	public void HotelMaster(String Username, String Password, String Leftsidemenu,String Name,String Country,
			String Countryindex,String Cityname,String Cityindexx,String HtlPBox,String Hotelchainname,
			String Hotelchainnameindex,String HtlTypeNamelistbox,String HtlTypeNamelistboxindex,
			String HtlServiceDetails,String Supplierlink,String Supplierlinkindex,String HtlAddress1,
			String HtlAddress2,String HtlAddress3,String HtlAddress4,String HtlTelephone,String HtlFax,String HtlEmail,
			String HtlTelex,String HtlContactPerson,String HtlBankName,String HtlBankDetails,String HtlWebUrl,
			String Amadeus,String Galileo,String Sabre,String HtlRemarks,String HtlReference,
			String ActiveFrom1,String ActiveFrom2,String ActiveFrom3,String ActiveTo1,String ActiveTo2,
			String ActiveTo3,String Statusindex) throws Exception

	{

		Thread.sleep(2000);

		// wm.sendtextbyid("", );
		wm.sendtextbyid("LoginCode", Username);
		Thread.sleep(200);
		wm.stab("LoginCode");
		wm.sendtextbyid("Password", Password);
		Thread.sleep(200);
		wm.clickbyxpath("//input[@value='Login']");
		wm.sleep();

		// ====================Creating executive master
		// screnn===========================================================
		wm.sendtextbyid("input-items", Leftsidemenu);
		Thread.sleep(500);
		wm.clickbyid("modMAS001");
		Thread.sleep(500);
		wm.clickbyid("pgmHTL001");
		wm.sleep();
		Thread.sleep(900);
		wm.clickbyid("btnMainAdd");
		Thread.sleep(900);

		wm.sendtextbycssselecotrwithoutclear("#Description", Name);

		// country
		wm.sendtextbyxvalue("//input[@aria-owns='HtlCountryName_listbox']", Country);
		Thread.sleep(300);
		wm.Listandenter("//*[@id='HtlCountryName_listbox']/li", Countryindex);
		Thread.sleep(300);

		// Cityy
		wm.sendtextbyxvalue("//input[@aria-owns='HtlCityName_listbox']", Cityname);
		Thread.sleep(300);
		wm.Listandenter("//*[@id='HtlCityName_listbox']/li", Cityindexx);
		Thread.sleep(300);

		// postboxnumber
		wm.sendtextbycssselecotrwithoutclear("#HtlPBox", "" + HtlPBox);
		
		//Hotelchain
				wm.sendtextbyxvalue("//input[@aria-owns='HtlChainName_listbox']", Hotelchainname);
				Thread.sleep(300);
				wm.Listandenter("//*[@id='HtlChainName_listbox']/li", Hotelchainnameindex);
				Thread.sleep(300);
				
				

				//Starttypee
						wm.sendtextbyxvalue("//input[@aria-owns='HtlTypeName_listbox']", HtlTypeNamelistbox);
						Thread.sleep(300);
						wm.Listandenter("//*[@id='HtlTypeName_listbox']/li", HtlTypeNamelistboxindex);
						Thread.sleep(300);
						

						//Servicedetails
						wm.sendtextbycssselecotrwithoutclear("#HtlServiceDetails", "" +HtlServiceDetails);
				
						//Supplierlink
						wm.sendtextbyxvalue("//input[@aria-owns='HtlSupplierLinkName_listbox']",Supplierlink);
						Thread.sleep(300);
						wm.Listandenter("//*[@id='HtlSupplierLinkName_listbox']/li", Supplierlinkindex);
						Thread.sleep(300);
		
						

						// Address1
						wm.sendtextbycssselecotrwithoutclear("#HtlAddress1", "" +HtlAddress1);
						//address2
						wm.sendtextbycssselecotrwithoutclear("#HtlAddress2", "" +HtlAddress2);
						//address3
						wm.sendtextbycssselecotrwithoutclear("#HtlAddress3", "" +HtlAddress3);
						
						//address4
						wm.sendtextbycssselecotrwithoutclear("#HtlAddress4", "" +HtlAddress4);
							
						//Telephnee
						wm.sendtextbycssselecotrwithoutclear("#HtlTelephone", "" +HtlTelephone);

						//Fax
						wm.sendtextbycssselecotrwithoutclear("#HtlFax", "" +HtlFax);
						//Email
						wm.sendtextbycssselecotrwithoutclear("#HtlEmail", "" +HtlEmail);
						
						//Telexenumber
						wm.sendtextbycssselecotrwithoutclear("#HtlTelex", "" +HtlTelex);
						

						//Contactperson
						wm.sendtextbycssselecotrwithoutclear("#HtlContactPerson", "" +HtlContactPerson);
						

						//Bankname
						wm.sendtextbycssselecotrwithoutclear("#HtlBankName", "" +HtlBankName);
						
						//Bankname
						wm.sendtextbycssselecotrwithoutclear("#HtlBankDetails", "" +HtlBankDetails);
						
						//Bankname
						//wm.sendtextbycssselecotrwithoutclear("#HtlBankDetails", "" +HtlBankDetails);
						
						//Weurl
						wm.sendtextbycssselecotrwithoutclear("#HtlWebUrl", "" +HtlWebUrl);
						
						//Entertheamedeous details
						wm.sendtextbycssselecotrwithoutclear("#Amadeus", "" +Amadeus);
						
						//Galileo
						wm.sendtextbycssselecotrwithoutclear("#Galileo", "" +Galileo);
						
						//Saberr
						wm.sendtextbycssselecotrwithoutclear("#Sabre", "" +Sabre);
						
						//Remarkss
						wm.sendtextbycssselecotrwithoutclear("#HtlRemarks", "" +HtlRemarks);
						
						//Referencee
						wm.sendtextbycssselecotrwithoutclear("#HtlReference", "" +HtlReference);
						
						//Referencee
						//wm.sendtextbycssselecotrwithoutclear("#HtlReference", "" +HtlReference);
						
						//selectedthe Activefromdate

						wm.sendtextbycssselecotr("#ActiveFrom", "" + ActiveFrom1 + "-" + ActiveFrom2 + "-" + ActiveFrom3);
						
						//selected the active to date 
						wm.sendtextbycssselecotr("#ActiveTo", "" + ActiveTo1 + "-" + ActiveTo2 + "-" + ActiveTo3);
						
						
						//selectedthestatus

						wm.clickbyxpath("//span[@aria-owns='HtlStatus_listbox']");
						Thread.sleep(600);
						wm.Listandenter("//*[@id='HtlStatus_listbox']/li", Statusindex);
						Thread.sleep(600);
						
						//clicking the save button in the popup
						wm.clickbyxpath("//span[@class='k-icon k-i-check']");
						Thread.sleep(500);
						
						

						wm.clickbyid("btnMainSave");
						
						wm.sleep();
						wm.sleep();
						

					//    wm.capturetextfrommsgbox("//span[@id='diaWarningMessage']", " Bussiness partner Record created successfully ");
						wm.Verifythealertpopupmessagesusincontainsusinggetattribute("//span[@id='diaInfoMessage']", 
								"successfully",
								"Hotel Master Created successfully", 
								"Hotel Master not Created successfully");
						

					   // wm.capturetextfrommsgbox("//span[@id='diaInfoMessage']", " Hotel Master Record created successfully ");

					  
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

		return Wrappermethods.getSheet("HotelMaster", "HotelMaster");

	}
}