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
public class BussinessPatnernegativescenarios {

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
			String ActiveToaddresstype2,String ActiveToaddresstype3,String Statusindex9,
			String LeftsideBussinesspartner,String Commonindex,String Vatnumber,String Executivecode,String Salutation,
			String Genderr,String UDIDCustomername) throws Exception

	{

		Thread.sleep(2000);

		// wm.sendtextbyid("", );
		wm.sendtextbyid("LoginCode", Username);
		Thread.sleep(200);
		wm.sendtextbyid("Password", Password);
		Thread.sleep(200);
		wm.clickbyxpath("//input[@value='Login']");
		wm.sleep();

		// ====================Testing the bussiness partner negativescenarios
		// screnn===========================================================
		wm.sendtextbyid("input-items", LeftsideBussinesspartner);
		Thread.sleep(900);
		wm.clickbyid("modMAS001");
		Thread.sleep(900);
		wm.clickbyid("pgmBUP001");
		wm.sleep();
		Thread.sleep(900);
		wm.clickbyid("btnMainAdd");
		Thread.sleep(900);
		
		//Chekcing header =========================================================================================================================
	// 1	Header  Screen	Verify the newly created Details reflected in customer category field 	Need to create new entry in bussiness category Screen 

		wm.sendtextbyxvalue("//input[@aria-owns='objCmsMasterModel_CustomerCategoryName_listbox']", ccdCategory);
		Thread.sleep(500);
		//wm.Listandenter("//*[@id='objCmsMasterModel_CustomerCategoryName_listbox']/li", Commonindex);
		wm.Listnegativescearios("//*[@id='objCmsMasterModel_CustomerCategoryName_listbox']/li", Commonindex, 
				"Newly created Custoemr category reflected in bussinee patner screen \n Enter input as"  +ccdCategory, 
				"Newly created Custoemr category not reflected in bussinee patner screen \n Enter input as"  +ccdCategory);
		Thread.sleep(500);

//  2	Header  Screen	Verify the newly created Details reflected in Master currency field 	Need to create new entry in Currency master screen

		wm.sendtextbyxvalue("//input[@aria-owns='objCmsMasterModel_MasterCurrency_listbox']", name);
		Thread.sleep(500);

		
		wm.Listnegativescearios("//*[@id='objCmsMasterModel_MasterCurrency_listbox']/li", Commonindex, 
				"Newly created Currency reflected in Master screen \n Enter input as"  +name, 
				"Newly created Currency not reflected in  Master  screen \n Enter input as"  +name);
		Thread.sleep(500);
		
		wm.sendtextbyxvalue("//input[@name='customerVatNumber']", Vatnumber);
		Thread.sleep(500);
		wm.Textallowed("//input[@name='customerVatNumber']", "VAT Number size not exceeds more than 15", "VAT Number size exceeds more than 15");
        Thread.sleep(300);
        
     //7	Header  Screen	Sales Executive	Created Executive master details reflected in Sales executive screen 
    

		wm.sendtextbyxvalue("//input[@aria-owns='objCmsMasterModel_ExecutiveName_listbox']",Executivecode );
		Thread.sleep(500);
		wm.Listnegativescearios("//*[@id='objCmsMasterModel_ExecutiveName_listbox']/li", Commonindex, 
				"Newly created Executivecode reflected in Salse executive field \n Enter input as"  +  Executivecode, 
				"Newly created Executivecode not reflected in Salse executive field \n Enter input as \n Enter input as"  + Executivecode);
		Thread.sleep(500);

        

      //8	Header  Screen	Front office Executive	Created Executive master details reflected in Fron offfice executive screen 
		wm.sendtextbyxvalue("//input[@aria-owns='objCmsMasterModel_frontoffExeName_listbox']", Executivecode);
		Thread.sleep(500);
		wm.Listnegativescearios("//*[@id='objCmsMasterModel_frontoffExeName_listbox']/li", Commonindex, 
				"Newly created Executivecode reflected in front office  executive field  \n Enter input as"  +  Executivecode, 
				"Newly created Executivecode not reflected in Front ofice  executive field \n Enter input as"  + Executivecode);
		Thread.sleep(500);

//		9	Header  Screen	Custome type	Created classification master details should reflected in the Customer type field

		wm.sendtextbyxvalue("//input[@aria-owns='objCmsMasterModel_classificationName_listbox']", ClassificationCode
);
		Thread.sleep(500);
		wm.Listnegativescearios("//*[@id='objCmsMasterModel_classificationName_listbox']/li", Commonindex, 
				"Newly created Classification master details reflected in Customer type field  \n Enter input as"  +  ClassificationCode, 
				"Newly created Classification master details not reflected in Customer type field \n Enter input as"  + ClassificationCode);
		Thread.sleep(600);

		
		
//=========================================================================================================
		
		//=================================================================================================
		
		//Service allocation details
					wm.clickbyxpath("//a[@id='acc810']");
					Thread.sleep(600);
					wm.Listandenter("//span[@class='k-icon k-i-add']", "7");
					Thread.sleep(500);
					
//					27	Service allocation details	Date	Verify the Date validations
					wm.Clearbyxpath("//input[@aria-owns='ActiveFrom_dateview']");
	                Thread.sleep(500);
					wm.clickbyxpath("//span[@class='k-icon k-i-check']");
					Thread.sleep(300);
					
				   wm.Mousemoveover("//input[@aria-owns='ActiveFrom_dateview']");
					 Thread.sleep(900);
				   
				   wm.Listnegativescearios("//div[@class='k-tooltip-content']", Commonindex, 
							"Pass : In Service allocation details Date validations is avilable for Active from field"  +  "",
							"Fail:In Service allocation details Date validations is not avilable for Active from field"  + "");
				   
				   Thread.sleep(600);

					 wm.Mousemoveover("//input[@aria-owns='ActiveTo_dateview']");
					 Thread.sleep(900);
				   
				   wm.Listnegativescearios("//div[@class='k-tooltip-content']", Commonindex, 
							"Pass : In Service allocation details Date validations is avilable for Active To field"  +  "",
							"Fail:In Service allocation details Date validations is not avilable for Active To field"  + "");
				   Thread.sleep(500);

		//			28	Service charge	Service charge	Validation checking : without service fee allocation details user not able to do add the service charge

	//need clarricfiaction for the point 28				
					
					
					

				   Thread.sleep(500);

				    
					wm.clickbyxpath("//span[@class='k-icon k-i-cancel']");
					Thread.sleep(600);
					wm.clickbyxpath("//a[@id='acc810']");
					Thread.sleep(500);
	//=======================================================================================================

		
		
//=========================================================================================================
//Addressdetails==================================================================
		
		wm.clickbyxpath("//a[@id='acc110']");
		Thread.sleep(600);
		wm.Listandenter("//span[@class='k-icon k-i-add']", "0");
		Thread.sleep(600);

		
	//	10	Address fetails	Type	Newly created address type master need to show in Type field 
		

		wm.sendtextbyxvalue("//input[@aria-owns='AddressTypeKey_listbox']", AddresstypeName);
		Thread.sleep(500);
		wm.Listnegativescearios("//*[@id='AddressTypeKey_listbox']/li", Commonindex, 
				"Newly created AddresstypeName reflected in Address type field  \n Enter input as"  +  AddresstypeName, 
				"Newly created AddresstypeName not reflected in Address type field  \n Enter input as"  + AddresstypeName);
		Thread.sleep(500);


		
//		11	Address fetails	Country	Newly created country masters should reflected in country field 
		
		wm.sendtextbyxvalue("//input[@aria-owns='CountryName_listbox']", CountryName);
		Thread.sleep(500);
		wm.Listnegativescearios("//*[@id='CountryName_listbox']/li", Commonindex, 
				"Newly created CountryName reflected in Address type field  \n Enter input as"  +  CountryName
, 
				"Newly created CountryName not reflected in Address type field  \n Enter input as"  + CountryName
);
		Thread.sleep(500);
		
		//12	Address fetails	State	Newly created Satte  masters should reflected in State  field 
		wm.sendtextbyxvalue("//input[@aria-owns='StateName_listbox']", StateName);
		Thread.sleep(500);
		wm.Listnegativescearios("//*[@id='StateName_listbox']/li", Commonindex, 
				"Newly created State  name reflected in Address type field  \n Enter input as"  +  StateName, 
				"Newly created State  name not reflected in Address type field  \n Enter input as"  + StateName);
		Thread.sleep(500);
		
		
		//13	Address fetails	city	Newly created City masters should reflected in City  field 
		wm.sendtextbyxvalue("//input[@aria-owns='CityName_listbox']", CityName);
		Thread.sleep(500);
		wm.Listnegativescearios("//*[@id='CityName_listbox']/li", Commonindex, 
				"Newly created CityName reflected in Address type field  \n Enter input as"  +  CityName, 
				"Newly created CityName not reflected in Address type field  \n Enter input as"  + CityName
);
		Thread.sleep(500);
		
		//Verify the amailvalidations
		wm.clickbyxpath("//span[@class='k-icon k-i-check']");
		 Thread.sleep(600);  
			
		
		wm.sendtextbycssselecotrwithoutclear("#Email", CityName);
		Thread.sleep(500);
	    wm.Mousemoveover("//*[@id='Email']");
	    Thread.sleep(600);
	    wm.Listnegativescearios("//div[@class='k-tooltip-content']", Commonindex, 
				"System display the Email validations" , 
				"System not display the Email validations");
	    //wm.findbyelementbyxpath("/html/body/div[59]/div/div[1]", "Validation message getting diplayed for Email " );
	     Thread.sleep(300);  
	     wm.clickbyxpath("//span[@class='k-icon k-i-cancel']");
	     Thread.sleep(700);
	     wm.clickbyxpath("//a[@id='acc110']");
	     Thread.sleep(700);  	
	  
//==============================================================================================================================
	    
	   //enterthecontactdetails=============================================================================
	    

			wm.clickbyxpath("//a[@id='acc210']");
			Thread.sleep(600);
			wm.Listandenter("//span[@class='k-icon k-i-add']", "1");
			Thread.sleep(600);

	     
	    // 15	Contact Details	Salutaiton 	Verify the newly created Salutaiton master reflected in the Salutation field	Need to start
			wm.sendtextbyxvalue("//input[@aria-owns='Salutation_listbox']", Salutation);
			Thread.sleep(500);
			wm.Listnegativescearios("//*[@id='Salutation_listbox']/li", Commonindex, 
					"Newly created Salutation reflected in Contact details Salutation field  \n Enter input as"  +  Salutation, 
					"Newly created Salutation not reflected in Contact details Salutation field \n Enter input as"  + Salutation);
			Thread.sleep(500);
 
			
	     
	    // 16	Contact Details	Gender	Verify the newly created Gender master reflected in the Gender field	Need to start
			

			wm.clickbyxpath("//span[@aria-owns='Gender_listbox']");
			Thread.sleep(600);						
			wm.Verifythedropdownvalues("//li[contains(text(),'FEMALE')]", "Created Gender  values reflected in Contacts", 
					"Created Gender  values not reflected in Contacts");
			
			//wm.Listandenter("//*[@id='Gender_listbox']/li", Genderindex);
			Thread.sleep(900);

			
			
	     
	    // 17	Contact Details	Desigination	Verify the newly created Desigination master reflected in the Desigination field	Need to start

			wm.sendtextbyxvalue("//input[@aria-owns='DesignationKey_listbox']", DesignationName);
			Thread.sleep(500);
			wm.Listnegativescearios("//*[@id='DesignationKey_listbox']/li", Commonindex, 
					"Newly created DesignationName reflected in Contact details DesignationName field  \n Enter input as"  +  DesignationName, 
					"Newly created DesignationName not reflected in Contact details DesignationName field \n Enter input as"  + DesignationName);
			Thread.sleep(500);
 
	     //18	Contact Details	Nationality	Verify the newly created Nationality  master reflected in the Nationality field	Need to start

			wm.sendtextbyxvalue("//input[@aria-owns='NationalityKey_listbox']", NationalityName
);
			Thread.sleep(300);
			wm.Listnegativescearios("//*[@id='NationalityKey_listbox']/li", Commonindex, 
					"Newly created Nationality reflected in Contact details Nationality field  \n Enter input as"  +  NationalityName, 
					"Newly created Nationality not reflected in Contact details Nationality field \n Enter input as"  + NationalityName);
			Thread.sleep(300);
 		
			wm.clickbyxpath("//span[@class='k-icon k-i-cancel']");
			Thread.sleep(700);
			wm.clickbyxpath("//a[@id='acc210']");
			Thread.sleep(700);
			
			
//BankDetails ======================================================================================

			wm.clickbyxpath("//a[@id='acc310']");
			Thread.sleep(600);

			wm.Listandenter("//span[@class='k-icon k-i-add']", "2");
			Thread.sleep(300);

			
			
//			19	Bank Details	Country	Newly created country masters should reflected in country field [ Ref Address field]	Need to start
			
			wm.sendtextbyxvalue("//input[@aria-owns='BcmbCountryName_listbox']", CountryName);
			Thread.sleep(500);
			wm.Listnegativescearios("//*[@id='BcmbCountryName_listbox']/li", Commonindex, 
					"Newly created Country  reflected in Bank  details DesignationName field  \n Enter input as"  +  CountryName, 
					"Newly created Country not reflected in Bank  details DesignationName field \n Enter input as"  + CountryName);
			Thread.sleep(500);
			
			
	//		20	Bank Details	city	Newly created City masters should reflected in City  field  [ Ref Address field]	Need to start

			wm.sendtextbyxvalue("//input[@aria-owns='BcmbCityName_listbox']", CityName);
			Thread.sleep(500);
			wm.Listnegativescearios("//*[@id='BcmbCityName_listbox']/li", Commonindex, 
					"Newly created City reflected in Bank  details DesignationName field  \n Enter input as"  +  CityName, 
					"Newly created City  not reflected in Bank details DesignationName field \n Enter input as"  + CityName);
			Thread.sleep(300);

			wm.clickbyxpath("//span[@class='k-icon k-i-cancel']");
			Thread.sleep(700);

			wm.clickbyxpath("//a[@id='acc310']");
			Thread.sleep(900);
	//==================================================================================================================
			//Chekcing the date validations
			

			wm.clickbyxpath("//a[@id='acc410']");
			Thread.sleep(500);

			wm.Listandenter("//span[@class='k-icon k-i-add']", "3");
			Thread.sleep(500);

			
			wm.Clearbyxpath("//input[@aria-owns='AgreementDate_dateview']");
			Thread.sleep(300);
			wm.Clearbyxpath("//input[@aria-owns='AgreementValidTo_dateview']");
			Thread.sleep(300);
	
			
			wm.clickbyxpath("//span[@class='k-icon k-i-check']");
			Thread.sleep(500);
			 wm.Mousemoveover("//input[@aria-owns='AgreementDate_dateview']");
			 Thread.sleep(500);
		   wm.findbyelementbyxpath("//*[contains(text(),'Valid From')]",
				   "Validation message getting diplayed from date " );
             
			 Thread.sleep(500);
			 
			 wm.Mousemoveover("//input[@aria-owns='AgreementValidTo_dateview']");
			 Thread.sleep(300);
			 wm.findbyelementbyxpath("//*[contains(text(),'Valid To should be greater than Valid From.')]", 
					 "Validation message getting diplayed for Todate " );
			 
              
			 Thread.sleep(500);

				wm.clickbyxpath("//span[@class='k-icon k-i-cancel']");
				Thread.sleep(700);
				wm.clickbyxpath("//a[@id='acc410']");
			    Thread.sleep(900);
				
//===================================================================================================================
		//Credit limit details

				wm.clickbyxpath("//a[@id='acc510']");
				Thread.sleep(600);
				wm.Listandenter("//span[@class='k-icon k-i-add']", "4");
				Thread.sleep(500);

//22	Credit limit details	Currency	Newly created record in currency master should reflected in Currency Field

				wm.sendtextbyxvalue("//input[@aria-owns='SettlementCurrency_listbox']", name);
				Thread.sleep(500);
				wm.Listnegativescearios("//*[@id='SettlementCurrency_listbox']/li", Commonindex, 
						"Newly created currency reflected in credit limit field  \n Enter input as"  +  name,
						"Newly created currency not reflected in credit limit field  \n Enter input as"  + name);
				Thread.sleep(300);
				
				
//23	Credit limit details	No Limit field	Limittype no limit , verify the Credit limit validations [Field should not be mandatory ]


				wm.clickbyxpath("//span[@aria-owns='PaymentType_listbox']");
				Thread.sleep(500);
				wm.Listandenter("//*[@id='PaymentType_listbox']/li", "1");
				Thread.sleep(500);
				

				wm.clickbyxpath("//span[@class='k-icon k-i-check']");
				Thread.sleep(500);
				 wm.Mousemoveover("//input[@name='CreditLimit']");
				 Thread.sleep(500);
			   
			   wm.Listnegativescearios("//*[contains(text(),'Credit Limit')]", Commonindex, 
						"Pass : After select no limit system showing credit limit field not as mandatory field  in credit limit field"  +  "",
						"Fail: After select no limit system showing credit limit field as mandatory field  in credit limit field"  + "");
			    
				
				wm.clickbyxpath("//span[@class='k-icon k-i-cancel']");
				Thread.sleep(600);
				wm.clickbyxpath("//a[@id='acc510']");
                Thread.sleep(600);
                
                wm.scrolldownbyxpath("//a[@id='acc1010']");
        		Thread.sleep(300);
				//Additioanl Credit limits=======================================================================

//24	Additional credit limits	Date validations	Date validation checking from date   To  to date

				wm.clickbyxpath("//a[@id='acc610']");
				Thread.sleep(600);
				wm.Listandenter("//span[@class='k-icon k-i-add']", "5");
				Thread.sleep(500);

		

				wm.Clearbyxpath("//input[@aria-owns='ActiveFrom_dateview']");
				Thread.sleep(300);

				wm.clickbyxpath("//span[@class='k-icon k-i-check']");
				Thread.sleep(300);

				
				 wm.Mousemoveover("//input[@aria-owns='ActiveFrom_dateview']");
				 Thread.sleep(500);

			   wm.Listnegativescearios("//*[contains(text(),'Active From')]", Commonindex, 
						"Pass : Date validations is avilable Additioanl credit limit Active From field"  +  "",
						"Fail: Date validations is not avilable Additioanl credit limit Active From  field"  + "");
			    
			   Thread.sleep(500);

				 wm.Mousemoveover("//input[@aria-owns='ActiveTo_dateview']");
				 Thread.sleep(500);
			   
			   wm.Listnegativescearios("//*[contains(text(),'Active To')]", Commonindex, 
						"Pass : Date validations is avilable Additioanl credit limit Active To field"  +  "",
						"Fail: Date validations is not avilable Additioanl credit limit Active To  field"  + "");
			   
			   Thread.sleep(500);

			    
				wm.clickbyxpath("//span[@class='k-icon k-i-cancel']");
				Thread.sleep(600);
				wm.clickbyxpath("//a[@id='acc610']");
				Thread.sleep(500);
		//=================================UDID  Code duplicate validations ================================
				
				
				wm.clickbyxpath("//a[@id='acc710']");
				Thread.sleep(600);
				wm.Listandenter("//span[@class='k-icon k-i-add']", "6");
				Thread.sleep(500);

				//clicking the copyicon in UDID
				wm.clickbyxpath("//button[@onclick='CustomerDetailSearch()']");
				Thread.sleep(500);
				wm.sendtextbyxvalue("//input[@aria-owns='DktPartnerKey_listbox']", UDIDCustomername);
				Thread.sleep(500);
				wm.Listnegativescearios("//*[@id='DktPartnerKey_listbox']/li", Commonindex, 
						"Newly created Custoemr name  reflected in UDID  \n Enter input as"  +  UDIDCustomername,
						"Newly created Custoemr name not reflected in UDID  \n Enter input as"  + UDIDCustomername);
				Thread.sleep(500);
				
				wm.clickbyxpath("//button[@onclick='CancelUDIDSearch()']");
				Thread.sleep(500);
				
				wm.clickbyxpath("//a[@id='acc710']");

				Thread.sleep(500);
				wm.scrolldownbyxpath("//a[@id='acc1110']");
				Thread.sleep(600);
				
//================================================================================================================
//Actiitylinkk
//=============================================================================================================
//				29	Activity link	Address validations	Without addredd details system not allowed to add the Activity link details


			    wm.clickbyxpath("//a[@id='acc1110']");
				Thread.sleep(600);
				wm.scrolldownbyxpath("//a[@id='acc1210']");
				Thread.sleep(500);
				wm.clickbyxpath("//*[@id='ActivityLinkGrid']/div[1]/a");
				//wm.Listandenterdoubleclick("//span[@class='k-icon k-i-add']", "11");
				//wm.Listandenterdoubleclick(xpath1, value);
				Thread.sleep(500);
				wm.Listnegativescearios("//*[@id='dialogError']", Commonindex, 
						"Without addredd details system not allowed to add the Activity link"  +  "",
						"Without addredd details system allowed to add the Activity link"  + "");
				Thread.sleep(300);
				wm.Listandenter("//*[contains(text(),'OK')]", "0");
				wm.Listandenter("//*[contains(text(),'OK')]", "1");
				wm.Listandenter("//*[contains(text(),'OK')]", "2");
				wm.Listandenter("//*[contains(text(),'OK')]", "3");
				
				
				Thread.sleep(500);
			    wm.clickbyxpath("//a[@id='acc1110']");
				Thread.sleep(500);
				
//			30	Activity link	Address validations	Given address details  need to display in  Activity link

				
				
//==================================================================================================================
		wm.sleep();
		wm.sleep();

		
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