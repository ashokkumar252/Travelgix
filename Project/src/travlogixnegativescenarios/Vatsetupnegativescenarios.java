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
public class Vatsetupnegativescenarios {

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
	public void Vatsetupnegativescenarios(String Username, String Password, String Leftsidemenu, String Commonindex,
			String Type,String Typeindex,String Category,String Catindexxegoryindex,String Glcodee,
			String Glcodeeindexx,String Hsntype,String Hsntypeindex,String Producttype,
			String Producttypeindex,String Servicetype,String Servicetypeindex,String Packagenormal,
			String Packagenormalindex,String Classtype,String Classtypeindex,String Vatstatus,
			String Vatstatusindex,String State,String Stateindex,String Outputype,String Outputypeindex,
			String Appliedon,String Appliedonindexx,String InclusiveExclusivelistbox,
			String InclusiveExclusivelistboxindex,String Collectiontypelistbox,
			String Collectiontypelistboxindex,String Chargelistbox,String Chargelistboxindex,
			
			String Customerlistbox,String Customerlistboxindexx,String Exempttype,String Exempttypeindex,
			String Productlistbox,String Productlistboxindex,String InterDomesticlistbox,
			String InterDomesticlistboxindex,String PackageNormallistbox,String PackageNormallistboxindex,
			String ClassTypelistbox,String ClassTypelistboxindex,String VEtvsSupplierVatStatuslistbox,
			String VEtvsSupplierVatStatuslistboxindex,String Statelistbox,String Statelistboxindexx,
			String OutputInputTypelistbox,String OutputInputTypelistboxindexx,String AppliedOnlistbox,
			String AppliedOnlistboxindexx,String InclusiveExclsivelistbox,String InclusiveExclsivelistboxindexx,
			String CollectionTypelistbox,String CollectionTypelistboxindex,String Chargelistboxx,
			String Chargelistboxindexx) throws Exception

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

		// ====================Creating agentincentives as negative scenarios

		// screnn===========================================================
		wm.sendtextbyid("input-items", Leftsidemenu);
		Thread.sleep(500);
		wm.clickbyid("modTRS001");
		Thread.sleep(500);
		wm.clickbyid("pgmMVS001");
		Thread.sleep(2000);

		//1 no feasability 
		
		// 2 Agent incentive Verify the Audit log Popup opening

		wm.clickbyid("btnAuditLog");
		Thread.sleep(300);
		wm.Verifythealertpopupmessagesusincontains("//span[@id='AuditLog_wnd_title']", "Audit Log",
				"When clicking the audit log icon system displays the auditlog popup",
				"When clicking the audit log icon system displays the auditlog popup");
		Thread.sleep(200);

		wm.Listandenterquick("//span[@class='k-icon k-i-close']", "0");
		wm.Listandenterquick("//span[@class='k-icon k-i-close']", "1");
		wm.Listandenterquick("//span[@class='k-icon k-i-close']", "2");
		wm.Listandenterquick("//span[@class='k-icon k-i-close']", "3");
		Thread.sleep(600);

		// 3 VAT setup Verify the UI field validations including Date
		// validations

		wm.clickbyid("btnMainAdd");
		Thread.sleep(500);
		wm.clickbyid("btnMainSave");
		Thread.sleep(500);

		// code
		wm.Mousemoveover("//input[@name='Code']");
		Thread.sleep(200);
		wm.Listnegativescearios(utility.Constant.Travelogixuitooltipvalidation, Commonindex,
				"Pass :  validations is avilable Code  field" + "",
				"Fail:  validations is not avilable Code field" + "");
		Thread.sleep(200);

		// namefieldd
		wm.Mousemoveover("//input[@name='Description']");
		Thread.sleep(200);
		wm.Listnegativescearios(utility.Constant.Travelogixuitooltipvalidation, Commonindex,
				"Pass :  validations is avilable Description  field" + "",
				"Fail:  validations is not avilable Description field" + "");
		Thread.sleep(200);

		// typee================
		wm.Mousemoveover("//input[@name='VGtcmTypeName_input']");
		Thread.sleep(200);
		wm.Listnegativescearios(utility.Constant.Travelogixuitooltipvalidation, Commonindex,
				"Pass :  validations is avilable VGtcmTypeName_input  field" + "",
				"Fail:  validations is not avilable VGtcmTypeName_input field" + "");
		Thread.sleep(200);

		// category

		wm.Mousemoveover("//input[@name='VGtcmCategoryName_input']");
		Thread.sleep(200);
		wm.Listnegativescearios(utility.Constant.Travelogixuitooltipvalidation, Commonindex,
				"Pass :  validations is avilable VGtcmCategoryName_input  field" + "",
				"Fail:  validations is not avilable VGtcmCategoryName_input field" + "");
		Thread.sleep(200);

		// GLcodee

		wm.Mousemoveover("//input[@name='VGtcmGlKey_input']");
		Thread.sleep(200);
		wm.Listnegativescearios(utility.Constant.Travelogixuitooltipvalidation, Commonindex,
				"Pass :  validations is avilable VGtcmGlKey_input  field" + "",
				"Fail:  validations is not avilable VGtcmGlKey_input field" + "");
		Thread.sleep(200);

		// HSN code

		wm.Mousemoveover("//input[@name='VGtcmHsnCode']");
		Thread.sleep(200);
		wm.Listnegativescearios(utility.Constant.Travelogixuitooltipvalidation, Commonindex,
				"Pass :  validations is avilable VGtcmHsnCode  field" + "",
				"Fail:  validations is not avilable VGtcmHsnCode field" + "");
		Thread.sleep(200);

		// hsn typee

		wm.Mousemoveover("//input[@name='VGtcmHsnTypeName_input']");
		Thread.sleep(200);
		wm.Listnegativescearios(utility.Constant.Travelogixuitooltipvalidation, Commonindex,
				"Pass :  validations is avilable VGtcmHsnTypeName_input  field" + "",
				"Fail:  validations is not avilable VGtcmHsnTypeName_input field" + "");
		Thread.sleep(200);

		// hsn description
		wm.Mousemoveover("//input[@name='VGtcmHsnDescription']");
		Thread.sleep(200);
		wm.Listnegativescearios(utility.Constant.Travelogixuitooltipvalidation, Commonindex,
				"Pass :  validations is avilable VGtcmHsnDescription  field" + "",
				"Fail:  validations is not avilable VGtcmHsnDescription field" + "");
		Thread.sleep(200);

		// Fromdatee
		wm.Mousemoveover("//input[@name='ActiveFrom']");
		Thread.sleep(100);
		wm.Listnegativescearios(utility.Constant.Travelogixuitooltipvalidation, Commonindex,
				"Pass :  validations is avilable ActiveFrom  field" + "",
				"Fail:  validations is not avilable ActiveFrom field" + "");

		Thread.sleep(200);

		// ============================================================================================

		// vat setupp

		wm.Listandenter("//span[@class='k-icon k-i-add']", "0");
		Thread.sleep(300);


		wm.clickbyxpath("//span[@class='k-icon k-i-check']");
		Thread.sleep(200);

		
		// producttype

		wm.Mousemoveover("//input[@name='VtvsProductType_input']");
		Thread.sleep(100);
		wm.Listnegativescearios(utility.Constant.Travelogixuitooltipvalidation, Commonindex,
				"Pass :  validations is avilable VtvsProductType_input  field" + "",
				"Fail:  validations is not avilable VtvsProductType_input field" + "");
		Thread.sleep(200);

		// Sectortypee

		wm.Mousemoveover("//input[@name='VtvsInterDomestic_input']");
		Thread.sleep(100);
		wm.Listnegativescearios(utility.Constant.Travelogixuitooltipvalidation, Commonindex,
				"Pass :  validations is avilable VtvsInterDomestic_input  field" + "",
				"Fail:  validations is not avilable VtvsInterDomestic_input field" + "");
		Thread.sleep(200);

		// packagenormall
		wm.Mousemoveover("//input[@name='VtvsPackageNormal_input']");
		Thread.sleep(100);
		wm.Listnegativescearios(utility.Constant.Travelogixuitooltipvalidation, Commonindex,
				"Pass :  validations is avilable VtvsPackageNormal_input  field" + "",
				"Fail:  validations is not avilable VtvsPackageNormal_input field" + "");
		Thread.sleep(200);

		// classtypee
		wm.Mousemoveover("//input[@name='VtvsClassType_input']");
		Thread.sleep(100);
		wm.Listnegativescearios(utility.Constant.Travelogixuitooltipvalidation, Commonindex,
				"Pass :  validations is avilable VtvsClassType_input  field" + "",
				"Fail:  validations is not avilable VtvsClassType_input field" + "");
		Thread.sleep(200);

		// VAT statuss
		wm.Mousemoveover("//input[@name='VtvsSupplierVatStatus_input']");
		Thread.sleep(100);
		wm.Listnegativescearios(utility.Constant.Travelogixuitooltipvalidation, Commonindex,
				"Pass :  validations is avilable VtvsSupplierVatStatus_input  field" + "",
				"Fail:  validations is not avilable VtvsSupplierVatStatus_input field" + "");
		Thread.sleep(200);

		// outputinputtype
		wm.Mousemoveover("//input[@name='VtvsOutputInputType_input']");
		Thread.sleep(100);
		wm.Listnegativescearios(utility.Constant.Travelogixuitooltipvalidation, Commonindex,
				"Pass :  validations is avilable VtvsOutputInputType_input  field" + "",
				"Fail:  validations is not avilable VtvsOutputInputType_input field" + "");
		Thread.sleep(200);

		// PErcentagee
		wm.Mousemoveover("//input[@name='VtvsPercentage']");
		Thread.sleep(100);
		wm.Listnegativescearios(utility.Constant.Travelogixuitooltipvalidation, Commonindex,
				"Pass :  validations is avilable VtvsPercentage  field" + "",
				"Fail:  validations is not avilable VtvsPercentage field" + "");
		Thread.sleep(200);

		// applicabe from
		wm.Mousemoveover("//input[@name='VtvsApplicableFrom']");
		Thread.sleep(100);
		wm.Listnegativescearios(utility.Constant.Travelogixuitooltipvalidation, Commonindex,
				"Pass :  validations is avilable VtvsApplicableFrom  field" + "",
				"Fail:  validations is not avilable VtvsApplicableFrom field" + "");
		Thread.sleep(200);

		// applicabe on
		wm.Mousemoveover("//input[@name='VtvsAppliedOn_input']");
		Thread.sleep(100);
		wm.Listnegativescearios(utility.Constant.Travelogixuitooltipvalidation, Commonindex,
				"Pass :  validations is avilable VtvsAppliedOn_input  field" + "",
				"Fail:  validations is not avilable VtvsAppliedOn_input field" + "");
		Thread.sleep(200);

		// InclusiveExclusive input
		wm.Mousemoveover("//input[@name='InclusiveExclusive_input']");
		Thread.sleep(100);
		wm.Listnegativescearios(utility.Constant.Travelogixuitooltipvalidation, Commonindex,
				"Pass :  validations is avilable InclusiveExclusive_input  field" + "",
				"Fail:  validations is not avilable InclusiveExclusive_input field" + "");
		Thread.sleep(200);

		// collectivetypee
		wm.Mousemoveover("//input[@name='Collectiontype_input']");
		Thread.sleep(100);
		wm.Listnegativescearios(utility.Constant.Travelogixuitooltipvalidation, Commonindex,
				"Pass :  validations is avilable Collectiontype_input  field" + "",
				"Fail:  validations is not avilable Collectiontype_input field" + "");
		Thread.sleep(200);

		// Charge
		wm.Mousemoveover("//input[@name='Charge_input']");
		Thread.sleep(100);
		wm.Listnegativescearios(utility.Constant.Travelogixuitooltipvalidation, Commonindex,
				"Pass :  validations is avilable Charge_input  field" + "",
				"Fail:  validations is not avilable Charge_input field" + "");
		Thread.sleep(200);

		// valuefrom
		wm.Mousemoveover("//input[@name='VtvsValueFrom']");
		Thread.sleep(100);
		wm.Listnegativescearios(utility.Constant.Travelogixuitooltipvalidation, Commonindex,
				"Pass :  validations is avilable VtvsValueFrom  field" + "",
				"Fail:  validations is not avilable VtvsValueFrom field" + "");
		Thread.sleep(200);

		// validto
		wm.Mousemoveover("//input[@name='VtvsValueTo']");
		Thread.sleep(100);
		wm.Listnegativescearios(utility.Constant.Travelogixuitooltipvalidation, Commonindex,
				"Pass :  validations is avilable VtvsValueTo  field" + "",
				"Fail:  validations is not avilable VtvsValueTo field" + "");
		Thread.sleep(200);

		// statuss
		wm.Mousemoveover("//input[@name='Statuss_input']");
		Thread.sleep(100);
		wm.Listnegativescearios(utility.Constant.Travelogixuitooltipvalidation, Commonindex,
				"Pass :  validations is avilable Statuss_input  field" + "",
				"Fail:  validations is not avilable Statuss_input field" + "");
		Thread.sleep(600);
		wm.clickbyxpath("//span[@class='k-icon k-i-cancel']");
		Thread.sleep(900);

		// ====================================================================================================
		// EXEMPTED VAT SETUP

		wm.Listandenter("//span[@class='k-icon k-i-add']", "1");
		Thread.sleep(300);
		

		wm.clickbyxpath("//span[@class='k-icon k-i-check']");
		Thread.sleep(200);
		
		// Compayname
		wm.Mousemoveover("//input[@name='Customer_input']");
		Thread.sleep(100);
		wm.Listnegativescearios(utility.Constant.Travelogixuitooltipvalidation, Commonindex,
				"Pass :  validations is avilable Customer_input  field" + "",
				"Fail:  validations is not avilable Customer_input field" + "");
		Thread.sleep(200);

		// exempttypee

		wm.Mousemoveover("//input[@name='ExemptType_input']");
		Thread.sleep(100);
		wm.Listnegativescearios(utility.Constant.Travelogixuitooltipvalidation, Commonindex,
				"Pass :  validations is avilable ExemptType_input  field" + "",
				"Fail:  validations is not avilable ExemptType_input field" + "");
		Thread.sleep(200);

		// productname
		wm.Mousemoveover("//input[@name='Product_input']");
		Thread.sleep(100);
		wm.Listnegativescearios(utility.Constant.Travelogixuitooltipvalidation, Commonindex,
				"Pass :  validations is avilable Product_input  field" + "",
				"Fail:  validations is not avilable Product_input field" + "");
		Thread.sleep(200);

		// internation domstic
		wm.Mousemoveover("//input[@name='InterDomestic_input']");
		Thread.sleep(100);
		wm.Listnegativescearios(utility.Constant.Travelogixuitooltipvalidation, Commonindex,
				"Pass :  validations is avilable InterDomestic_input  field" + "",
				"Fail:  validations is not avilable InterDomestic_input field" + "");
		Thread.sleep(200);

		// PackageNormal input
		wm.Mousemoveover("//input[@name='PackageNormal_input']");
		Thread.sleep(100);
		wm.Listnegativescearios(utility.Constant.Travelogixuitooltipvalidation, Commonindex,
				"Pass :  validations is avilable PackageNormal_input  field" + "",
				"Fail:  validations is not avilable PackageNormal_input field" + "");
		Thread.sleep(200);

		// classtypee
		wm.Mousemoveover("//input[@name='ClassType_input']");
		Thread.sleep(100);
		wm.Listnegativescearios(utility.Constant.Travelogixuitooltipvalidation, Commonindex,
				"Pass :  validations is avilable ClassType_input  field" + "",
				"Fail:  validations is not avilable ClassType_input field" + "");
		Thread.sleep(200);

		// Vatstatus
		wm.Mousemoveover("//input[@name='VEtvsSupplierVatStatus_input']");
		Thread.sleep(100);
		wm.Listnegativescearios(utility.Constant.Travelogixuitooltipvalidation, Commonindex,
				"Pass :  validations is avilable VEtvsSupplierVatStatus_input  field" + "",
				"Fail:  validations is not avilable VEtvsSupplierVatStatus_input field" + "");
		Thread.sleep(200);

		// ouput/inputtypee
		wm.Mousemoveover("//input[@name='OutputInputType_input']");
		Thread.sleep(100);
		wm.Listnegativescearios(utility.Constant.Travelogixuitooltipvalidation, Commonindex,
				"Pass :  validations is avilable OutputInputType_input  field" + "",
				"Fail:  validations is not avilable OutputInputType_input field" + "");
		Thread.sleep(200);

		// percentagee
		wm.Mousemoveover("//input[@name='Percentage']");
		Thread.sleep(100);
		wm.Listnegativescearios(utility.Constant.Travelogixuitooltipvalidation, Commonindex,
				"Pass :  validations is avilable Percentage  field" + "",
				"Fail:  validations is not avilable Percentage field" + "");
		Thread.sleep(200);

		// applicableofrm
		wm.Mousemoveover("//input[@name='tvseApplicableFrom']");
		Thread.sleep(100);
		wm.Listnegativescearios(utility.Constant.Travelogixuitooltipvalidation, Commonindex,
				"Pass :  validations is avilable tvseApplicableFrom  field" + "",
				"Fail:  validations is not avilable tvseApplicableFrom field" + "");
		Thread.sleep(200);

		// Appliedon
		wm.Mousemoveover("//input[@name='AppliedOn_input']");
		Thread.sleep(100);
		wm.Listnegativescearios(utility.Constant.Travelogixuitooltipvalidation, Commonindex,
				"Pass :  validations is avilable AppliedOn_input  field" + "",
				"Fail:  validations is not avilable AppliedOn_input field" + "");
		Thread.sleep(200);

		// inclusieand exclusive
		wm.Mousemoveover("//input[@name='InclusiveExclsive_input']");
		Thread.sleep(100);
		wm.Listnegativescearios(utility.Constant.Travelogixuitooltipvalidation, Commonindex,
				"Pass :  validations is avilable InclusiveExclsive_input  field" + "",
				"Fail:  validations is not avilable InclusiveExclsive_input field" + "");
		Thread.sleep(200);

		// collectivetypee
		wm.Mousemoveover("//input[@name='CollectionType_input']");
		Thread.sleep(100);
		wm.Listnegativescearios(utility.Constant.Travelogixuitooltipvalidation, Commonindex,
				"Pass :  validations is avilable CollectionType_input  field" + "",
				"Fail:  validations is not avilable CollectionType_input field" + "");
		Thread.sleep(200);

		// chargee
		wm.Mousemoveover("//input[@name='Charge_input']");
		Thread.sleep(100);
		wm.Listnegativescearios(utility.Constant.Travelogixuitooltipvalidation, Commonindex,
				"Pass :  validations is avilable Charge_input  field" + "",
				"Fail:  validations is not avilable Charge_input field" + "");
		Thread.sleep(200);

		// valuefromm
		wm.Mousemoveover("//input[@name='ValueFrom']");
		Thread.sleep(100);
		wm.Listnegativescearios(utility.Constant.Travelogixuitooltipvalidation, Commonindex,
				"Pass :  validations is avilable ValueFrom  field" + "",
				"Fail:  validations is not avilable ValueFrom field" + "");
		Thread.sleep(200);

		// calid too
		wm.Mousemoveover("//input[@name='ValueTo']");
		Thread.sleep(100);
		wm.Listnegativescearios(utility.Constant.Travelogixuitooltipvalidation, Commonindex,
				"Pass :  validations is avilable ValueTo  field" + "",
				"Fail:  validations is not avilable ValueTo field" + "");
		Thread.sleep(200);

		// status
		wm.Mousemoveover("//input[@name='Statusss_input']");
		Thread.sleep(100);
		wm.Listnegativescearios(utility.Constant.Travelogixuitooltipvalidation, Commonindex,
				"Pass :  validations is avilable Statusss_input  field" + "",
				"Fail:  validations is not avilable Statusss_input field" + "");
		Thread.sleep(200);

		wm.clickbyxpath("//span[@class='k-icon k-i-cancel']");
		Thread.sleep(500);

	
//		4	VAT setup	Newly created type

		// enter the typee
		wm.sendtextbyxvalue("//input[@aria-owns='VGtcmTypeName_listbox']", Type);
		Thread.sleep(200);
		//wm.Listandenter("//*[@id='VGtcmTypeName_listbox']/li", Typeindex);
		Thread.sleep(200);
		wm.Listnegativescearios("//*[@id='VGtcmTypeName_listbox']/li", Typeindex,
				"Pass :  newlycreated date  is avilable VGtcmTypeName_listbox  field" + "",
				"Fail:  validations data  is not avilable VGtcmTypeName_listbox field" + "");
		Thread.sleep(200);


//		5	VAT setup	Newly created category

		// enter the typee
		wm.sendtextbyxvalue("//input[@aria-owns='VGtcmCategoryName_listbox']", Category);
		Thread.sleep(200);
	//	wm.Listandenter("//*[@id='VGtcmCategoryName_listbox']/li", Catindexxegoryindex);
		Thread.sleep(200);
		wm.Listnegativescearios("//*[@id='VGtcmCategoryName_listbox']/li", Catindexxegoryindex,
				"Pass :  newlycreated date  is avilable VGtcmCategoryName_listbox  field" + "",
				"Fail:  validations data  is not avilable VGtcmCategoryName_listbox field" + "");
	

//		6	VAT setup	Newly created GL code 

		// enter the GLcodee
		wm.sendtextbyxvalue("//input[@aria-owns='VGtcmGlKey_listbox']", Glcodee);
		Thread.sleep(200);
		//wm.Listandenter("//*[@id='VGtcmGlKey_listbox']/li", Glcodeeindexx);
		Thread.sleep(200);
		wm.Listnegativescearios("//*[@id='VGtcmGlKey_listbox']/li", Glcodeeindexx,
				"Pass :  newlycreated date  is avilable VGtcmGlKey_listbox  field" + "",
				"Fail:  validations data  is not avilable VGtcmGlKey_listbox field" + "");
	
//		7	VAT setup	Newly created HSN type


		// HSN typee
		wm.sendtextbyxvalue("//input[@aria-owns='VGtcmHsnTypeName_listbox']", Hsntype);
		Thread.sleep(200);
		//wm.Listandenter("//*[@id='VGtcmHsnTypeName_listbox']/li", Hsntypeindex);
		Thread.sleep(200);
		wm.Listnegativescearios("//*[@id='VGtcmHsnTypeName_listbox']/li", Hsntypeindex,
				"Pass :  newlycreated date  is avilable VGtcmHsnTypeName_listbox  field" + "",
				"Fail:  validations data  is not avilable VGtcmHsnTypeName_listbox field" + "");
	
		
		wm.Listandenter("//span[@class='k-icon k-i-add']", "0");
		Thread.sleep(300);
		

//VAT setup
//8	VAT setup	Newly created product type

		wm.sendtextbyxvalue("//input[@aria-owns='VtvsProductType_listbox']", Producttype);
		Thread.sleep(200);
		//wm.Listandenter("//*[@id='VtvsProductType_listbox']/li", Producttypeindex);
		Thread.sleep(200);
		wm.Listnegativescearios("//*[@id='VtvsProductType_listbox']/li", Producttypeindex,
				"Pass :  newlycreated date  is avilable Producttypeindex  field" + "",
				"Fail:  validations data  is not avilable Producttypeindex field" + "");

//9	VAT setup	Newly created service type
		
		wm.sendtextbyxvalue("//input[@aria-owns='VtvsInterDomestic_listbox']", Servicetype);
		Thread.sleep(200);
		//wm.Listandenter("//*[@id='VtvsInterDomestic_listbox']/li", Servicetypeindex);
		Thread.sleep(200);
		wm.Listnegativescearios("//*[@id='VtvsInterDomestic_listbox']/li", Servicetypeindex,
				"Pass :  newlycreated date  is avilable VtvsInterDomestic_listbox  field" + "",
				"Fail:  validations data  is not avilable VtvsInterDomestic_listbox field" + "");

		
//10	VAT setup	Newly created pacakge / normal
		

		wm.sendtextbyxvalue("//input[@aria-owns='VtvsPackageNormal_listbox']", Packagenormal);
		Thread.sleep(200);
		//wm.Listandenter("//*[@id='VtvsPackageNormal_listbox']/li", Packagenormalindex);
		Thread.sleep(200);
		wm.Listnegativescearios("//*[@id='VtvsPackageNormal_listbox']/li", Packagenormalindex,
				"Pass :  newlycreated date  is avilable Packagenormalindex  field" + "",
				"Fail:  validations data  is not avilable Packagenormalindex field" + "");


//11	VAT setup	Newly created classtype
		wm.sendtextbyxvalue("//input[@aria-owns='VtvsClassType_listbox']", Classtype);
		Thread.sleep(200);
		//wm.Listandenter("//*[@id='VtvsClassType_listbox']/li", Classtypeindex);
		Thread.sleep(200);
		wm.Listnegativescearios("//*[@id='VtvsClassType_listbox']/li", Classtypeindex,
				"Pass :  newlycreated date  is avilable VtvsClassType_listbox  field" + "",
				"Fail:  validations data  is not avilable VtvsClassType_listbox field" + "");

		
//12	VAT setup	Newly created vat status
		wm.sendtextbyxvalue("//input[@aria-owns='VtvsSupplierVatStatus_listbox']", Vatstatus);
		Thread.sleep(200);
		//wm.Listandenter("//*[@id='VtvsSupplierVatStatus_listbox']/li", Vatstatusindex);
		Thread.sleep(200);
		wm.Listnegativescearios("//*[@id='VtvsSupplierVatStatus_listbox']/li", Vatstatusindex,
				"Pass :  newlycreated date  is avilable VtvsClassType_listbox  field" + "",
				"Fail:  validations data  is not avilable VtvsClassType_listbox field" + "");

		
//13	VAT setup	Newly created state 
		wm.sendtextbyxvalue("//input[@aria-owns='VtvsStateKey_listbox']", State);
		Thread.sleep(200);
		//wm.Listandenter("//*[@id='VtvsStateKey_listbox']/li", Stateindex);
		Thread.sleep(200);
		wm.Listnegativescearios("//*[@id='VtvsStateKey_listbox']/li", Stateindex,
				"Pass :  newlycreated date  is avilable VtvsStateKey_listbox  field" + "",
				"Fail:  validations data  is not avilable VtvsStateKey_listbox field" + "");

		
		
//14	VAT setup	Newly created output/input type
		wm.sendtextbyxvalue("//input[@aria-owns='VtvsOutputInputType_listbox']", Outputype);
		Thread.sleep(200);
		//wm.Listandenter("//*[@id='VtvsOutputInputType_listbox']/li", Outputypeindex);
		Thread.sleep(200);
		wm.Listnegativescearios("//*[@id='VtvsOutputInputType_listbox']/li", Outputypeindex,
				"Pass :  newlycreated date  is avilable VtvsOutputInputType_listbox  field" + "",
				"Fail:  validations data  is not avilable VtvsOutputInputType_listbox field" + "");

		
		
//16	VAT setup	Newly created applied on
		
		wm.sendtextbyxvalue("//input[@aria-owns='VtvsAppliedOn_listbox']", Appliedon);
		Thread.sleep(200);
	//	wm.Listandenter("//*[@id='VtvsAppliedOn_listbox']/li", Appliedonindexx);
		Thread.sleep(200);
		wm.Listnegativescearios("//*[@id='VtvsAppliedOn_listbox']/li", Appliedonindexx,
				"Pass :  newlycreated date  is avilable VtvsAppliedOn_listbox  field" + "",
				"Fail:  validations data  is not avilable VtvsAppliedOn_listbox field" + "");
		
		
//17	VAT setup	Newly created inclusive and exclusive
		wm.sendtextbyxvalue("//input[@aria-owns='InclusiveExclusive_listbox']", InclusiveExclusivelistbox);
		Thread.sleep(200);
		//wm.Listandenter("//*[@id='InclusiveExclusive_listbox']/li", InclusiveExclusivelistboxindex);
		Thread.sleep(200);
		wm.Listnegativescearios("//*[@id='InclusiveExclusive_listbox']/li", InclusiveExclusivelistboxindex,
				"Pass :  newlycreated date  is avilable InclusiveExclusive_listbox  field" + "",
				"Fail:  validations data  is not avilable InclusiveExclusive_listbox field" + "");
		
		
//18	VAT setup	Newly created collection type
		wm.sendtextbyxvalue("//input[@aria-owns='Collectiontype_listbox']", Collectiontypelistbox);
		Thread.sleep(200);
		//wm.Listandenter("//*[@id='Collectiontype_listbox']/li", Collectiontypelistboxindex);
		Thread.sleep(200);
		wm.Listnegativescearios("//*[@id='Collectiontype_listbox']/li", Collectiontypelistboxindex,
				"Pass :  newlycreated date  is avilable Collectiontype_listbox  field" + "",
				"Fail:  validations data  is not avilable Collectiontype_listbox field" + "");
		
		
//19	VAT setup	Newly created charge
		
		wm.sendtextbyxvalue("//input[@aria-owns='Charge_listbox']", Chargelistbox);
		Thread.sleep(200);
		//wm.Listandenter("//*[@id='Charge_listbox']/li", Chargelistboxindex);
		Thread.sleep(200);
		wm.Listnegativescearios("//*[@id='Charge_listbox']/li", Chargelistboxindex,
				"Pass :  newlycreated date  is avilable Charge_listbox  field" + "",
				"Fail:  validations data  is not avilable Charge_listbox field" + "");

		Thread.sleep(200);
		
wm.clickbyxpath("//span[@class='k-icon k-i-cancel']");


		Thread.sleep(900);

		
	//Exempted vatsetup		

		wm.Listandenter("//span[@class='k-icon k-i-add']", "1");
		Thread.sleep(300);

		
	//20	VAT setup	Newly created customer name

		// Customername
		wm.sendtextbyxvalue("//input[@aria-owns='Customer_listbox']", Customerlistbox);
		Thread.sleep(200);
		//wm.Listandenter("//*[@id='Customer_listbox']/li", Customerlistboxindexx);
		Thread.sleep(200);
		wm.Listnegativescearios("//*[@id='Customer_listbox']/li", Customerlistboxindexx,
				"Pass :  newlycreated date  is avilable Customer_listbox  field" + "",
				"Fail:  validations data  is not avilable Customer_listbox field" + "");
		
		
	//21	VAT setup	Newly created exepmt type

		// exemprttypee
		wm.sendtextbyxvalue("//input[@aria-owns='ExemptType_listbox']", Exempttype);
		Thread.sleep(200);
		//wm.Listandenter("//*[@id='ExemptType_listbox']/li", Exempttypeindex);
		Thread.sleep(200);
		wm.Listnegativescearios("//*[@id='ExemptType_listbox']/li", Exempttypeindex,
				"Pass :  newlycreated date  is avilable ExemptType_listbox  field" + "",
				"Fail:  validations data  is not avilable ExemptType_listbox field" + "");
		
		
	//22	VAT setup	Newly created product name

		// Productname
		wm.sendtextbyxvalue("//input[@aria-owns='Product_listbox']", Productlistbox);
		Thread.sleep(200);
	//	wm.Listandenter("//*[@id='Product_listbox']/li", Productlistboxindex);
		Thread.sleep(200);
		wm.Listnegativescearios("//*[@id='Product_listbox']/li", Productlistboxindex,
				"Pass :  newlycreated date  is avilable Product_listbox  field" + "",
				"Fail:  validations data  is not avilable Product_listbox field" + "");
		
		
		
	//23	VAT setup	Newly created internationand domestice inbounds and outbounds
		

		// internation/domestice
		wm.sendtextbyxvalue("//input[@aria-owns='InterDomestic_listbox']", InterDomesticlistbox);
		Thread.sleep(200);
		//wm.Listandenter("//*[@id='InterDomestic_listbox']/li", InterDomesticlistboxindex);
		Thread.sleep(200);
		wm.Listnegativescearios("//*[@id='InterDomestic_listbox']/li", InterDomesticlistboxindex,
				"Pass :  newlycreated date  is avilable InterDomestic_listbox  field" + "",
				"Fail:  validations data  is not avilable InterDomestic_listbox field" + "");
		
		
	//24	VAT setup	Newly created package format
		

		// PAckage/normal
		wm.sendtextbyxvalue("//input[@aria-owns='PackageNormal_listbox']", PackageNormallistbox);
		Thread.sleep(200);
		//wm.Listandenter("//*[@id='PackageNormal_listbox']/li", PackageNormallistboxindex);
		Thread.sleep(200);
		wm.Listnegativescearios("//*[@id='PackageNormal_listbox']/li", PackageNormallistboxindex,
				"Pass :  newlycreated date  is avilable PackageNormal_listbox  field" + "",
				"Fail:  validations data  is not avilable PackageNormal_listbox field" + "");
		
		
	//25	VAT setup	Newly created class type

		// classtypee
		wm.sendtextbyxvalue("//input[@aria-owns='ClassType_listbox']", ClassTypelistbox);
		Thread.sleep(200);
		//wm.Listandenter("//*[@id='ClassType_listbox']/li", ClassTypelistboxindex);
		Thread.sleep(200);
		wm.Listnegativescearios("//*[@id='ClassType_listbox']/li", ClassTypelistboxindex,
				"Pass :  newlycreated date  is avilable ClassType_listbox  field" + "",
				"Fail:  validations data  is not avilable ClassType_listbox field" + "");
		

	//26	VAT setup	Newly created vat status
		

		// VATstatuss
		wm.sendtextbyxvalue("//input[@aria-owns='VEtvsSupplierVatStatus_listbox']", VEtvsSupplierVatStatuslistbox);
		Thread.sleep(200);
		//wm.Listandenter("//*[@id='VEtvsSupplierVatStatus_listbox']/li", VEtvsSupplierVatStatuslistboxindex);
		Thread.sleep(500);
		wm.Listnegativescearios("//*[@id='VEtvsSupplierVatStatus_listbox']/li", VEtvsSupplierVatStatuslistboxindex,
				"Pass :  newlycreated date  is avilable VEtvsSupplierVatStatus_listbox  field" + "",
				"Fail:  validations data  is not avilable VEtvsSupplierVatStatus_listbox field" + "");
		
	//27	VAT setup	Newly created  state 

		// Statee
		wm.sendtextbyxvalue("//input[@aria-owns='State_listbox']", Statelistbox);
		Thread.sleep(200);
		//wm.Listandenter("//*[@id='State_listbox']/li", Statelistboxindexx);
		Thread.sleep(200);
		wm.Listnegativescearios("//*[@id='State_listbox']/li", Statelistboxindexx,
				"Pass :  newlycreated date  is avilable Statelistboxindexx  field" + "",
				"Fail:  validations data  is not avilable Statelistboxindexx field" + "");
		
		
	//28	VAT setup	Newly created ouput and input typee
		// Output/inputbox
				wm.sendtextbyxvalue("//input[@aria-owns='OutputInputType_listbox']", OutputInputTypelistbox);
				Thread.sleep(200);
				//wm.Listandenter("//*[@id='OutputInputType_listbox']/li", OutputInputTypelistboxindexx);
				Thread.sleep(200);
				wm.Listnegativescearios("//*[@id='OutputInputType_listbox']/li", OutputInputTypelistboxindexx,
						"Pass :  newlycreated date  is avilable OutputInputType_listbox  field" + "",
						"Fail:  validations data  is not avilable OutputInputType_listbox field" + "");
				
				
	//29	VAT setup	Verify the percentage amount greater than 100 %
	
	//30	VAT setup	Verify the newly created applied on
				// Appleedon
				wm.sendtextbyxvalue("//input[@aria-owns='AppliedOn_listbox']", AppliedOnlistbox);
				Thread.sleep(200);
				//wm.Listandenter("//*[@id='AppliedOn_listbox']/li", AppliedOnlistboxindexx);
				Thread.sleep(200);
				wm.Listnegativescearios("//*[@id='AppliedOn_listbox']/li", AppliedOnlistboxindexx,
						"Pass :  newlycreated date  is avilable AppliedOn_listbox  field" + "",
						"Fail:  validations data  is not avilable AppliedOn_listbox field" + "");
				
				
	//31	VAT setup	Verify the newly created inclusive and exclusive
				// Inclusiveandexcuslive
				wm.sendtextbyxvalue("//input[@aria-owns='InclusiveExclsive_listbox']", InclusiveExclsivelistbox);
				Thread.sleep(200);
				//wm.Listandenter("//*[@id='InclusiveExclsive_listbox']/li", InclusiveExclsivelistboxindexx);
				Thread.sleep(200);
				wm.Listnegativescearios("//*[@id='InclusiveExclsive_listbox']/li", InclusiveExclsivelistboxindexx,
						"Pass :  newlycreated date  is avilable InclusiveExclsive_listbox  field" + "",
						"Fail:  validations data  is not avilable InclusiveExclsive_listbox field" + "");
				
				
	//32	VAT setup	Newly created collection type
				

				// CollectionType_listbox
				wm.sendtextbyxvalue("//input[@aria-owns='CollectionType_listbox']", CollectionTypelistbox);
				Thread.sleep(200);
				//wm.Listandenter("//*[@id='CollectionType_listbox']/li", CollectionTypelistboxindex);
				Thread.sleep(200);
				wm.Listnegativescearios("//*[@id='CollectionType_listbox']/li", CollectionTypelistboxindex,
						"Pass :  newlycreated date  is avilable CollectionType_listbox  field" + "",
						"Fail:  validations data  is not avilable CollectionType_listbox field" + "");
				
				
	//33	VAT setup	Newly created charge

				// chargee
				wm.sendtextbyxvalue("//input[@aria-owns='Charge_listbox']", Chargelistboxx);
				Thread.sleep(200);
				//wm.Listandenter("//*[@id='Charge_listbox']/li", Chargelistboxindexx);
				Thread.sleep(200);
				wm.Listnegativescearios("//*[@id='Charge_listbox']/li", Chargelistboxindexx,
						"Pass :  newlycreated date  is avilable Charge_listbox  field" + "",
						"Fail:  validations data  is not avilable Charge_listbox field" + "");
				
		
		
		wm.sleep();

	}

	@AfterMethod
	public void close()

	{
		wm.close();

	}

	@DataProvider(name = "dp")
	public Object[][] dp() throws IOException {

		return Wrappermethods.getSheet("Vatsetupnegativescenarios", "Vatsetupnegativescenarios");

	}
}