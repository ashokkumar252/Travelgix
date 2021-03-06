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
//import pack.Wrappermethods;
@Listeners({ ATUReportsListener.class, ConfigurationListener.class, MethodListener.class })
public class BusinessPartnersupplier {

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
	public void BusinessPartnersupplier(String Username, String Password, String Leftsidemenu, String Account, String SupplierCode,
			String SupplierName, String Suppliertype, String Suppliertypeindex,String VATRegStatusindex
,String Customercategory,
			String Customercategoryindex, String Mastercurrecny, String Mastercurrecnyindex, String Documentmethod,
			String Documentmethodindex, String Statusindex, String Companylistboxindexx, String Parentcompnay,
			String Parentcompnayindex, String Salesexective, String Salesexectiveindex, String Frontoffice,
			String Frontofficeindex, String PDCMethod, String PDCmethodindex, String Secureinputindex,
			String Secureoutputindex, String Type, String Typeindex, String Address, String Country,
			String Countryindex, String State, String Stateindex, String City, String Cityindex, String Postboxnumber,
			String PostboxName, String Phone, String Faxnumber, String Mobile, String Email, String SecondaryEmail,
			String TaxRegstatus, String TaxRegstatusindex, String caddrPanNo, String SEZ, String SEZindex,
			String caddrLicenceNo, String caddrTanNo, String caddrCinNo, String Compostion, String Compostionindex,
			String Salutation, String Salutationindex, String Gender, String Genderindex, String Natioality,
			String Nationalityindex, String Desigination, String Desiginationindex, String Statusindex1,
			String FirstName, String MiddleName, String LastName, String PhoneOffice, String PhoneMobile,
			String PhoneResidence, String AlternativeEmail, String SocialNetworkId1, String SocialNetworkId2,
			String SocialNetworkId3, String SocialNetworkId4, String SocialNetworkId5, String BcmbBankName,
			String BcmbBankAddress, String Modeofpayment, String Modeofpaymentindexx, String Countryname2,
			String Countryindex2, String Cityname3, String Citynameindex3, String BcmbAccNo, String BcmbBankSwift,
			String BcmbBankRtgs, String AgreementNumber1, String AgreementTitle, String VersionSerialNumber,
			String Aggrementtype, String Aggrementtypeindex, String AgreementDate1, String AgreementDate2,
			String AgreementDate3, String AgreementValidTo1, String AgreementValidTo2, String AgreementValidTo3,
			String Statusindex4, String Currency, String Currencyindex, String Limittypeeindex, String CreditLimit,
			String Threshold, String CreditLimitDays, String PCCCode,String Description,String Pcstatusindex,
String AecacCreditLimit, String ActiveFrom1, String ActiveFrom2,
			String ActiveFrom3, String ActiveTo1, String ActiveTo2, String ActiveTo3, String ecasRemarks,
			String Udidmode, String Udidmodeindex, String Code, String Udidname, String Udidnameindex, String pdisOrder,
			String Produccategory,String Produccategoryindex,String Prodcuttype,String Prodcuttypeindexx,String ActiveFrom31,
			String ActiveFrom32,String ActiveFrom33,String ActiveTo31,String ActiveTo32,String ActiveTo33,String Statusindex3,			
			String BGecbgdBankName,String BGecbgdBankNameindex,String Guarantee,String Guaranteetypee,String BGecbgdAmount,
			String Currency4,String Currencyindex4,String BGecbgdDescription,String ActiveFrom41,String ActiveFrom42,
			String ActiveFrom43,String ActiveTo41,String ActiveTo42,String ActiveTo43,String Statusindex5,String Salesactivity1,
			String Salesactivityindex1,String Defaultaddress2,String Defaultaddress2index,String Province,String Provinceindex,
			String Bussineetype,String Bussineetypeindex)			throws Exception

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

		// enter the eft side menu
		wm.sendtextbyid("input-items", Leftsidemenu);
		Thread.sleep(900);
		wm.clickbyid("modMAS001");
		Thread.sleep(900);
		wm.clickbyid("pgmBUP001");
		wm.sleep();
		Thread.sleep(900);
		wm.clickbyid("btnMainAdd");
		wm.sleep();

		// selected the account type

		wm.sendtextbyxvalue("//input[@aria-owns='objCmsMasterModel_AccountTypeName_listbox']", Account);
		Thread.sleep(900);
		wm.Enterbyxpath("//input[@aria-owns='objCmsMasterModel_AccountTypeName_listbox']");
		Thread.sleep(900);

		// suppiercode
		wm.stabbyxpath("//input[@aria-owns='objCmsMasterModel_AccountTypeName_listbox']");
		Thread.sleep(500);
		wm.sendtextbycssselecotr("#SupplierCode", "" + SupplierCode);
		Thread.sleep(600);
		wm.stabbyxpath("//input[@id='SupplierCode']");
		Thread.sleep(600);
		wm.sendtextbycssselecotr("#SupplierName", "" + SupplierName);
		Thread.sleep(600);

		wm.sendtextbyxvalue("//input[@aria-owns='SupplierType_listbox']", Suppliertype);
		Thread.sleep(600);
		wm.Listandenter("//*[@id='SupplierType_listbox']/li", Suppliertypeindex);
		Thread.sleep(600);

		//VAT Reg status
		wm.clickbyxpath("//span[@aria-owns='VATRegStat_listbox']");
		Thread.sleep(600);
		wm.Listandenter("//*[@id='VATRegStat_listbox']/li", VATRegStatusindex);
		Thread.sleep(600);

		
		wm.sendtextbyxvalue("//input[@aria-owns='objCmsMasterModel_CustomerCategoryName_listbox']", Customercategory);
		Thread.sleep(600);
		wm.Listandenter("//*[@id='objCmsMasterModel_CustomerCategoryName_listbox']/li", Customercategoryindex);
		Thread.sleep(600);

		// mastercurrency

		// objCmsMasterModel_MasterCurrency_listbox

		wm.sendtextbyxvalue("//input[@aria-owns='objCmsMasterModel_MasterCurrency_listbox']", Mastercurrecny);
		Thread.sleep(900);
		wm.Listandenter("//*[@id='objCmsMasterModel_MasterCurrency_listbox']/li", Mastercurrecnyindex);
		Thread.sleep(900);

		// document method

		wm.sendtextbyxvalue("//input[@aria-owns='DMdcmDocumentMethodName_listbox']", Documentmethod);
		Thread.sleep(600);
		wm.Listandenter("//*[@id='DMdcmDocumentMethodName_listbox']/li", Documentmethodindex);
		Thread.sleep(600);

		// satus

		wm.clickbyxpath("//span[@aria-owns='StatusHead_listbox']");
		// wm.sendtextbyxvalue("//span[@aria-owns='StatusHead_listbox']",Documentmethod);
		Thread.sleep(600);
		wm.Listandenter("//*[@id='StatusHead_listbox']/li", Statusindex);
		Thread.sleep(600);

		// cmpnaylistbox

		wm.clickbyxpath("//span[@aria-owns='customerCompanyId_listbox']");
		Thread.sleep(600);
		wm.Listandenter("//*[@id='customerCompanyId_listbox']/li", Companylistboxindexx);
		Thread.sleep(600);

		// parentcompnay
		wm.sendtextbyxvalue("//input[@aria-owns='objCmsMasterModel_customerParentName_listbox']", Parentcompnay);
		Thread.sleep(600);
		wm.Listandenter("//*[@id='objCmsMasterModel_customerParentName_listbox']/li", Parentcompnayindex);
		Thread.sleep(600);

		// Salesexecutive
		wm.sendtextbyxvalue("//input[@aria-owns='objCmsMasterModel_ExecutiveName_listbox']", Salesexective);
		Thread.sleep(600);
		wm.Listandenter("//*[@id='objCmsMasterModel_ExecutiveName_listbox']/li", Salesexectiveindex);
		Thread.sleep(600);

		// Frontofficeexecutive
		wm.sendtextbyxvalue("//input[@aria-owns='objCmsMasterModel_frontoffExeName_listbox']", Frontoffice);
		Thread.sleep(600);
		wm.Listandenter("//*[@id='objCmsMasterModel_frontoffExeName_listbox']/li", Frontofficeindex);
		Thread.sleep(600);

		// PDCmethod
		wm.sendtextbyxvalue("//input[@aria-owns='objCmsMasterModel_customerPdcMethodName_listbox']", PDCMethod);
		Thread.sleep(600);
		wm.Listandenter("//*[@id='objCmsMasterModel_customerPdcMethodName_listbox']/li", PDCmethodindex);
		Thread.sleep(600);

		// secureinput

		wm.clickbyxpath("//span[@aria-owns='SecureInputHead_listbox']");
		Thread.sleep(600);
		wm.Listandenter("//*[@id='SecureInputHead_listbox']/li", Secureinputindex);
		Thread.sleep(600);

		// Secure output
		wm.clickbyxpath("//span[@aria-owns='SecureOutputHead_listbox']");
		Thread.sleep(600);
		wm.Listandenter("//*[@id='SecureOutputHead_listbox']/li", Secureoutputindex);
		Thread.sleep(600);

		// =================================================================================================

		// Adding addressdetails
		wm.clickbyxpath("//a[@id='acc110']");
		Thread.sleep(300);
		wm.Listandenter("//span[@class='k-icon k-i-add']", "0");
		Thread.sleep(900);

		wm.sendtextbyxvalue("//input[@aria-owns='AddressTypeKey_listbox']", Type);
		Thread.sleep(600);
		wm.Listandenter("//*[@id='AddressTypeKey_listbox']/li", Typeindex);
		Thread.sleep(600);

		wm.sendtextbycssselecotr("#DefaultAddress", Address);

		// selectedthecountry
		wm.sendtextbyxvalue("//input[@aria-owns='CountryName_listbox']", Country);
		Thread.sleep(600);
		wm.Listandenter("//*[@id='CountryName_listbox']/li", Countryindex);
		Thread.sleep(600);

		wm.sendtextbyxvalue("//input[@aria-owns='StateName_listbox']", State);
		Thread.sleep(600);
		wm.Listandenter("//*[@id='StateName_listbox']/li", Stateindex);
		Thread.sleep(600);

		wm.sendtextbyxvalue("//input[@aria-owns='CityName_listbox']", City);
		Thread.sleep(600);
		wm.Listandenter("//*[@id='CityName_listbox']/li", Cityindex);
		Thread.sleep(600);

		wm.sendtextbycssselecotrwithoutclear("#PostboxNumber", "" + Postboxnumber);
		Thread.sleep(100);
		wm.sendtextbycssselecotrwithoutclear("#PostboxName", "" + PostboxName);
		Thread.sleep(100);
		wm.sendtextbycssselecotrwithoutclear("#Phone", "" + Phone);
		Thread.sleep(100);
		wm.sendtextbycssselecotrwithoutclear("#Fax", "" + Faxnumber);
		Thread.sleep(100);
		wm.sendtextbycssselecotrwithoutclear("#Mobile", "" + Mobile);
		Thread.sleep(100);
		wm.sendtextbycssselecotrwithoutclear("#Email", "" + Email);
		Thread.sleep(100);
		wm.sendtextbycssselecotrwithoutclear("#SecondaryEmail", "" + SecondaryEmail);

		Thread.sleep(500);

		// TaxRegstatuss
		wm.sendtextbyxvalue("//input[@aria-owns='caddrTaxRegName_listbox']", TaxRegstatus);
		Thread.sleep(600);
		wm.Listandenter("//*[@id='caddrTaxRegName_listbox']/li", TaxRegstatusindex);
		Thread.sleep(600);

		wm.sendtextbycssselecotrwithoutclear("#caddrPanNo", "" + caddrPanNo);

		wm.sendtextbyxvalue("//input[@aria-owns='caddrSezFlagName_listbox']", SEZ);
		Thread.sleep(600);
		wm.Listandenter("//*[@id='caddrSezFlagName_listbox']/li", SEZindex);
		Thread.sleep(600);

		wm.sendtextbycssselecotrwithoutclear("#caddrLicenceNo", "" + caddrLicenceNo);
		Thread.sleep(100);

		wm.sendtextbycssselecotrwithoutclear("#caddrTanNo", "" + caddrTanNo);
		Thread.sleep(100);
		wm.sendtextbycssselecotrwithoutclear("#caddrCinNo", "" + caddrCinNo);
		Thread.sleep(100);
		wm.sendtextbyxvalue("//input[@aria-owns='caddrCompositionName_listbox']", Compostion);
		Thread.sleep(600);
		wm.Listandenter("//*[@id='caddrCompositionName_listbox']/li", Compostionindex);
		Thread.sleep(900);

		wm.clickbyxpath("//span[@class='k-icon k-i-check']");
		wm.sleep();
		wm.clickbyxpath("//a[@id='acc110']");
		Thread.sleep(500);

		// =======================================================================================================================

		// Adding the contact details

		wm.clickbyxpath("//a[@id='acc210']");
		Thread.sleep(600);
		wm.Listandenter("//span[@class='k-icon k-i-add']", "1");
		Thread.sleep(900);

		// selected the salutationss

		wm.sendtextbyxvalue("//input[@aria-owns='Salutation_listbox']", Salutation);
		Thread.sleep(600);
		wm.Listandenter("//*[@id='Salutation_listbox']/li", Salutationindex);
		Thread.sleep(900);

		wm.clickbyxpath("//span[@aria-owns='Gender_listbox']");
		Thread.sleep(600);
		wm.Listandenter("//*[@id='Gender_listbox']/li", Genderindex);
		Thread.sleep(900);

		// Nationalityindexx
		wm.sendtextbyxvalue("//input[@aria-owns='NationalityKey_listbox']", Natioality);
		Thread.sleep(600);
		wm.Listandenter("//*[@id='NationalityKey_listbox']/li", Nationalityindex);
		Thread.sleep(900);

		wm.sendtextbyxvalue("//input[@aria-owns='DesignationKey_listbox']", Desigination);
		Thread.sleep(600);
		wm.Listandenter("//*[@id='DesignationKey_listbox']/li", Desiginationindex);
		Thread.sleep(900);

		// Status
		wm.clickbyxpath("//span[@aria-owns='ContactStatus_listbox']");
		Thread.sleep(600);
		wm.Listandenter("//*[@id='ContactStatus_listbox']/li", Statusindex1);
		Thread.sleep(900);

		wm.sendtextbycssselecotrwithoutclear("#FirstName", "" + FirstName);
		Thread.sleep(100);
		wm.sendtextbycssselecotrwithoutclear("#MiddleName", "" + MiddleName);
		Thread.sleep(100);
		wm.sendtextbycssselecotrwithoutclear("#LastName", "" + LastName);
		Thread.sleep(100);
		wm.sendtextbycssselecotrwithoutclear("#PhoneOffice", "" + PhoneOffice);
		Thread.sleep(100);
		wm.sendtextbycssselecotrwithoutclear("#PhoneMobile", "" + PhoneMobile);
		Thread.sleep(100);
		wm.sendtextbycssselecotrwithoutclear("#PhoneResidence", "" + PhoneResidence);
		Thread.sleep(100);
		wm.sendtextbycssselecotrwithoutclear("#Email", "" + Email);
		Thread.sleep(100);
		wm.sendtextbycssselecotrwithoutclear("#AlternativeEmail", "" + AlternativeEmail);
		Thread.sleep(100);
		wm.sendtextbycssselecotrwithoutclear("#SocialNetworkId1", "" + SocialNetworkId1);
		Thread.sleep(100);
		wm.sendtextbycssselecotrwithoutclear("#SocialNetworkId2", "" + SocialNetworkId2);
		Thread.sleep(100);
		wm.sendtextbycssselecotrwithoutclear("#SocialNetworkId3", "" + SocialNetworkId3);
		Thread.sleep(100);
		wm.sendtextbycssselecotrwithoutclear("#SocialNetworkId4", "" + SocialNetworkId4);
		Thread.sleep(100);

		wm.sendtextbycssselecotrwithoutclear("#SocialNetworkId5", "" + SocialNetworkId5);
		Thread.sleep(100);
		wm.clickbyxpath("//span[@class='k-icon k-i-check']");
		Thread.sleep(900);
		wm.clickbyxpath("//a[@id='acc210']");
		Thread.sleep(600);

		// =================================================================================================================================
		// Adding the bank details

		wm.clickbyxpath("//a[@id='acc310']");
		Thread.sleep(600);

		wm.Listandenter("//span[@class='k-icon k-i-add']", "2");

		Thread.sleep(600);
		wm.sendtextbycssselecotrwithoutclear("#BcmbBankName", "" + BcmbBankName);
		Thread.sleep(100);
		wm.sendtextbycssselecotrwithoutclear("#BcmbBankAddress", "" + BcmbBankAddress);
		Thread.sleep(100);
		// mode ofpayment
		wm.sendtextbyxvalue("//input[@aria-owns='BcmbPaymentModeKey_listbox']", Modeofpayment);
		Thread.sleep(600);
		wm.Listandenter("//*[@id='BcmbPaymentModeKey_listbox']/li", Modeofpaymentindexx);
		Thread.sleep(600);

		wm.sendtextbyxvalue("//input[@aria-owns='BcmbCountryName_listbox']", Countryname2);
		Thread.sleep(600);
		wm.Listandenter("//*[@id='BcmbCountryName_listbox']/li", Countryindex2);
		Thread.sleep(600);

		wm.sendtextbyxvalue("//input[@aria-owns='BcmbCityName_listbox']", Cityname3);
		Thread.sleep(600);
		wm.Listandenter("//*[@id='BcmbCityName_listbox']/li", Citynameindex3);
		Thread.sleep(600);

		wm.sendtextbycssselecotrwithoutclear("#BcmbAccNo", "" + BcmbAccNo);
		Thread.sleep(100);
		wm.sendtextbycssselecotrwithoutclear("#BcmbBankSwift", "" + BcmbBankSwift);
		Thread.sleep(100);
		wm.sendtextbycssselecotrwithoutclear("#BcmbBankRtgs", "" + BcmbBankRtgs);
		Thread.sleep(100);
		wm.clickbyxpath("//span[@class='k-icon k-i-check']");
		Thread.sleep(900);

		wm.clickbyxpath("//a[@id='acc310']");

		// Agreementdetails
		// ===================================================================

		wm.clickbyxpath("//a[@id='acc410']");
		Thread.sleep(600);

		wm.Listandenter("//span[@class='k-icon k-i-add']", "3");
		Thread.sleep(500);

		wm.sendtextbycssselecotrwithoutclear("#AgreementNumber", "" + AgreementNumber1);
		Thread.sleep(80);
		wm.sendtextbycssselecotrwithoutclear("#AgreementTitle", "" + AgreementTitle);
		Thread.sleep(80);
		wm.sendtextbycssselecotrwithoutclear("#VersionSerialNumber", "" + VersionSerialNumber);
		Thread.sleep(80);

		// Agrremnttype
		wm.sendtextbyxvalue("//input[@aria-owns='AgreementType_listbox']", Aggrementtype);
		Thread.sleep(600);
		wm.Listandenter("//*[@id='AgreementType_listbox']/li", Aggrementtypeindex);
		Thread.sleep(600);

		// wm.sendtextbycssselecotr(xva, txt);
		wm.sendtextbycssselecotr("#AgreementDate", "" + AgreementDate1 + "-" + AgreementDate2 + "-" + AgreementDate3);
		wm.sendtextbycssselecotr("#AgreementValidTo",
				"" + AgreementValidTo1 + "-" + AgreementValidTo2 + "-" + AgreementValidTo3);

		wm.clickbyxpath("//span[@aria-owns='AgreementStatus_listbox']");
		Thread.sleep(600);
		wm.Listandenter("//*[@id='AgreementStatus_listbox']/li", Statusindex4);
		Thread.sleep(900);

		wm.clickbyxpath(" //span[@class='k-icon k-i-check']");
		Thread.sleep(600);

		wm.clickbyxpath("//a[@id='acc410']");
		Thread.sleep(600);

		// ============Credit
		// limitdetails============================================================================================================
		wm.clickbyxpath("//a[@id='acc510']");
		Thread.sleep(600);
		wm.Listandenter("//span[@class='k-icon k-i-add']", "4");
		Thread.sleep(500);

		wm.sendtextbyxvalue("//input[@aria-owns='SettlementCurrency_listbox']", Currency);
		Thread.sleep(600);
		wm.Listandenter("//*[@id='SettlementCurrency_listbox']/li", Currencyindex);
		Thread.sleep(600);

		wm.clickbyxpath("//span[@aria-owns='PaymentType_listbox']");
		Thread.sleep(600);
		wm.Listandenter("//*[@id='PaymentType_listbox']/li", Limittypeeindex);
		Thread.sleep(900);

		wm.sendtextbycssselecotrwithoutclear("#CreditLimit", "" + CreditLimit);
		wm.sendtextbycssselecotrwithoutclear("#Threshold", "" + Threshold);
		wm.sendtextbycssselecotrwithoutclear("#CreditLimitDays", "" + CreditLimitDays);

		wm.clickbyxpath("//span[@class='k-icon k-i-check']");
		Thread.sleep(600);

		wm.clickbyxpath("//a[@id='acc510']");

		// ==============
		// PCC Details=============================================================================================

		wm.clickbyxpath("//a[@id='acc910']");
		Thread.sleep(600);
	
		wm.Listandenter("//span[@class='k-icon k-i-add']", "8");
		
		
		
		Thread.sleep(500);

		wm.sendtextbycssselecotrwithoutclear("#PCCCode", "" + PCCCode);
		wm.sendtextbycssselecotrwithoutclear("#Description", "" + Description);
		
		//wm.sendtextbycssselecotrwithoutclear("#PCCCode", "" + AecacCreditLimit);
		
		Thread.sleep(100);
		wm.sendtextbycssselecotr("#ActiveFrom", "" + ActiveFrom1 + "-" + ActiveFrom2 + "-" + ActiveFrom3);
		Thread.sleep(50);
		wm.sendtextbycssselecotr("#ActiveTo", "" + ActiveTo1 + "-" + ActiveTo2 + "-" + ActiveTo3);
		Thread.sleep(50);
		
		wm.clickbyxpath("//span[@aria-owns='Status_listbox']");
		Thread.sleep(600);
		wm.Listandenter("//*[@id='Status_listbox']/li",Pcstatusindex);
		Thread.sleep(900);

		
		//wm.sendtextbycssselecotrwithoutclear("#ecasRemarks", "" + ecasRemarks);
		Thread.sleep(50);
		wm.clickbyxpath("//span[@class='k-icon k-i-check']");
		Thread.sleep(500);
		wm.clickbyxpath("//a[@id='acc910']");
		Thread.sleep(900);

		// ====================UDID
		// DEFINTION==================================================================================
	/*	wm.clickbyxpath("//a[@id='acc710']");
		Thread.sleep(600);
		wm.Listandenter("//span[@class='k-icon k-i-add']", "6");
		Thread.sleep(500);

		// Udidmode

		wm.sendtextbyxvalue("//input[@aria-owns='pdisModeKey_listbox']", Udidmode);
		Thread.sleep(600);
		wm.Listandenter("//*[@id='pdisModeKey_listbox']/li", Udidmodeindex);
		Thread.sleep(600);

		wm.sendtextbycssselecotrwithoutclear("#Code", "" + Code);

		// UDIDNAME
		wm.sendtextbyxvalue("//input[@aria-owns='pdisDefintionKey_listbox']", Udidname);
		Thread.sleep(600);
		wm.Listandenter("//*[@id='pdisDefintionKey_listbox']/li", Udidnameindex);
		Thread.sleep(600);

		wm.sendtextbycssselecotrwithoutclear("#pdisOrder", "" + pdisOrder);
		Thread.sleep(500);

		wm.clickbyxpath("//span[@class='k-icon k-i-check']");
		Thread.sleep(500);
		wm.clickbyxpath("//a[@id='acc710']");
		Thread.sleep(500);

*/		// SERVICE allocation details==================================================================================
	/*	wm.clickbyxpath("//a[@id='acc810']");
		Thread.sleep(600);
		wm.Listandenter("//span[@class='k-icon k-i-add']", "7");
		Thread.sleep(500);
		// product categry
		wm.sendtextbyxvalue("//input[@aria-owns='ADecprlProductKey_listbox']", Produccategory);
		Thread.sleep(600);
		wm.Listandenter("//*[@id='ADecprlProductKey_listbox']/li", Produccategoryindex);
		Thread.sleep(600);

		// Producttypee
		wm.sendtextbyxvalue("//input[@aria-owns='ADecprlProviderKey_listbox']", Prodcuttype);
		Thread.sleep(600);
		wm.Listandenter("//*[@id='ADecprlProviderKey_listbox']/li", Prodcuttypeindexx);
		Thread.sleep(600);

		// Enter the date

		wm.sendtextbycssselecotr("#ActiveFrom", "" + ActiveFrom31 + "-" + ActiveFrom32 + "-" + ActiveFrom33);
		Thread.sleep(50);
		wm.sendtextbycssselecotr("#ActiveTo", "" + ActiveTo31 + "-" + ActiveTo32 + "-" + ActiveTo33);
		Thread.sleep(50);

		wm.clickbyxpath("//span[@aria-owns='Status_listbox']");
		Thread.sleep(600);
		wm.Listandenter("//*[@id='Status_listbox']/li", Statusindex3);
		Thread.sleep(600);

		wm.clickbyxpath("//span[@class='k-icon k-i-check']");
		Thread.sleep(500);

		Thread.sleep(500);
		wm.clickbyxpath("//a[@id='acc810']");
        Thread.sleep(500);*/
        
		// Guarettee details==================================================================================
		wm.clickbyxpath("//a[@id='acc1010']");
		Thread.sleep(600);
		
		wm.Listandenter("//span[@class='k-icon k-i-add']", "9");
		
		
		Thread.sleep(500);
		wm.scrolldownbyxpath("//a[@id='acc1010']");
			
		
		//bankk namee
		wm.sendtextbycssselecotrwithoutclear("#BGecbgdBankName", "" + BGecbgdBankName);
		Thread.sleep(500);
		wm.Listandenter("//span[@class='k-icon k-i-add']", BGecbgdBankNameindex);
		Thread.sleep(500);
		
		
          //====================guartetypee ============================================================================================================
		wm.sendtextbyxvalue("//input[@aria-owns='BGecbgdType_listbox']", Guarantee);
		Thread.sleep(600);
		wm.Listandenter("//*[@id='BGecbgdType_listbox']/li", Guaranteetypee);
		Thread.sleep(600);

		wm.sendtextbycssselecotrwithoutclear("#BGecbgdAmount", "" + BGecbgdAmount);
		
		//currency

		wm.sendtextbyxvalue("//input[@aria-owns='BGecbgdCurrency_listbox']", Currency4);
		Thread.sleep(600);
		wm.Listandenter("//*[@id='BGecbgdCurrency_listbox']/li", Currencyindex4);
		Thread.sleep(600);

		
		wm.sendtextbycssselecotrwithoutclear("#BGecbgdDescription", "" +BGecbgdDescription);
		

		// Enter the date

		wm.sendtextbycssselecotr("#ActiveFrom", "" + ActiveFrom41 + "-" + ActiveFrom42 + "-" + ActiveFrom43);
		Thread.sleep(50);
		wm.sendtextbycssselecotr("#ActiveTo", "" + ActiveTo41 + "-" + ActiveTo42 + "-" + ActiveTo43);
		Thread.sleep(50);

		wm.clickbyxpath("//span[@aria-owns='Status_listbox']");
		Thread.sleep(600);
		wm.Listandenter("//*[@id='Status_listbox']/li", Statusindex5);
		Thread.sleep(600);


		wm.clickbyxpath("//span[@class='k-icon k-i-check']");
		Thread.sleep(300);

		wm.clickbyxpath("//a[@id='acc1010']");
	    Thread.sleep(500);
	    
	
	    
	    //======Activity linkk======================================================================================================
	    
	    wm.clickbyxpath("//a[@id='acc1110']");
		Thread.sleep(600);

		wm.Listandenter("//span[@class='k-icon k-i-add']", "10");
		
		wm.scrolldownbyxpath("//a[@id='acc1110']");
		Thread.sleep(100);
	

		//Sales Activityy
		wm.sendtextbyxvalue("//input[@aria-owns='cmsalActivityName_listbox']",Salesactivity1);
		Thread.sleep(600);
		wm.Listandenter("//*[@id='cmsalActivityName_listbox']/li",Salesactivityindex1);
		Thread.sleep(600);
		

		//default address 
		wm.sendtextbyxvalue("//input[@aria-owns='cmsalActivityAddressName_listbox']",Defaultaddress2);
		Thread.sleep(600);
		wm.Listandenter("//*[@id='cmsalActivityAddressName_listbox']/li",Defaultaddress2index);
		Thread.sleep(600);
		
		

		wm.clickbyxpath("//span[@class='k-icon k-i-check']");
		Thread.sleep(300);

		wm.clickbyxpath("//a[@id='acc1110']");
	    Thread.sleep(500);
		
	    
	   //===============analysiis detailss==============================================================
	    

	    wm.clickbyxpath("//a[@id='acc1210']");
		Thread.sleep(600);
		

		wm.Listandenter("//span[@class='k-icon k-i-add']", "11");
		
		wm.scrolldownbyxpath("//a[@id='acc1210']");
		Thread.sleep(100);
	
		//province
		
		wm.sendtextbyxvalue("//input[@aria-owns='CMSMoreSupplier_listbox']",Province);
		Thread.sleep(600);
		wm.Listandenter("//*[@id='CMSMoreSupplier_listbox']/li",Provinceindex);
		Thread.sleep(600);
	

         //Bussinesstypee
		wm.sendtextbyxvalue("//input[@aria-owns='AP_ANA_BUSINESSTYPE_listbox']",Bussineetype);
		Thread.sleep(600);
		wm.Listandenter("//*[@id='AP_ANA_BUSINESSTYPE_listbox']/li",Bussineetypeindex);
		Thread.sleep(600);
	

		
		wm.clickbyxpath("//a[@id='acc1210']");
		Thread.sleep(500);	
		
		wm.clickbyid("btnMainSave");
		
		wm.sleep();
		wm.sleep();
		

	//    wm.capturetextfrommsgbox("//span[@id='diaWarningMessage']", " Bussiness partner Record created successfully ");


	    wm.capturetextfrommsgbox("//div[@id='dialogWarning']", " Bussiness partner Record created successfully ");

	  
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

		return Wrappermethods.getSheet("BusinessPartner", "BusinessPartnersupplier");

	}
}