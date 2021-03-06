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
public class Branchmasternegativescenarios {

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
	public void Branchmasternegativescenarios(String Username, String Password, String Leftsidemenu, String Companynamee,
			String Filterbycode, String Commonindex, String Country, String Countryindex, String State,
			String Stateindex, String City, String Cityindex, String Category, String Categoryindex,
			String Receivableagent, String Receivableagentindex, String Airportname, String Airportnameindex,
			String Wrongemailid,String Duplicatecde) throws Exception

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
		wm.clickbyid("pgmBR001");
		wm.sleep();

		// 1 Branch Master Clicking the save button without any changes Proper
		// validation should be displayed

		wm.clickbyid("btnMainSave");
		wm.sleep();

		wm.Verifythealertpopupmessages("//span[@id='diaInfoMessage']", "No Changes",
				"without doing chnages clicking the save button , System showing validation messages correctly ",
				"without doing chnages clicking the save button ,  System showing validation messages not correctly ");
		Thread.sleep(500);

		wm.Listandenterquick("//span[contains(text(),'OK')]", "0");
		wm.Listandenterquick("//span[contains(text(),'OK')]", "1");
		wm.Listandenterquick("//span[contains(text(),'OK')]", "2");
		wm.Listandenterquick("//span[contains(text(),'OK')]", "3");

		// 2 Branch Master Bramch Group : Clicking the Add button and click the
		// grid level save button Proper validation should be displayed

		wm.clickbyid("btnMainAdd");
		Thread.sleep(200);

		wm.clickbyid("btnMainSave");
		Thread.sleep(300);
		wm.Verifythealertpopupmessagesusincontains("//span[@id='diaWarningMessage']", 
				"Please select complete",
				"Without enter the details and click save button in the grid level  , System showing validation messages correctly ",
				"Without enter the details and click save button in the grid level ,  System showing validation messages not correctly ");
		Thread.sleep(200);

		wm.Listandenterquick("//span[contains(text(),'OK')]", "0");
		wm.Listandenterquick("//span[contains(text(),'OK')]", "1");
		wm.Listandenterquick("//span[contains(text(),'OK')]", "2");
		wm.Listandenterquick("//span[contains(text(),'OK')]", "3");
		Thread.sleep(500);

		// 3 Branch Master Bramch Group : View the Audit log popup Verify the
		// popup get displayed

		wm.Listandenter("//a[@class='k-button k-button-icontext k-grid-cLog']", "0");
		Thread.sleep(300);
		wm.Verifythealertpopupmessagesusincontains("//span[@id='AuditLog_wnd_title']", "Audit Log",
				"When clicking the audit log icon system displays the auditlog popup",
				"When clicking the audit log icon system displays the auditlog popup");
		Thread.sleep(200);

		wm.Listandenterquick("//span[@class='k-icon k-i-close']", "0");
		wm.Listandenterquick("//span[@class='k-icon k-i-close']", "1");
		wm.Listandenterquick("//span[@class='k-icon k-i-close']", "2");
		wm.Listandenterquick("//span[@class='k-icon k-i-close']", "3");
		Thread.sleep(200);

		// 4 Branch Master Bramch Group : View the Details in Edit mode options
		// Verify the details viewd in Edit mode options are not
		wm.Listandenterquick("//span[@class='k-icon k-i-edit']", "0");
		Thread.sleep(100);

		wm.sendtextbyxvalue("//input[@aria-owns='companyKey_listbox']", Companynamee);
		Thread.sleep(100);
		wm.Listnegativescearios("//*[@id='companyKey_listbox']/li", "0", "Grid is in Edit mode",
				"Grid nottt in Edit mode");
		Thread.sleep(100);
		wm.clickbyxpath("//span[@class='k-icon k-i-check']");
		Thread.sleep(300);

		// 5 Branch Master Bramch Group : View the Grid level filter options
		// Verify the Grid level
		// filter by data is working fine

		wm.Listandenter("//span[@class='k-icon k-i-more-vertical']", "0");
		Thread.sleep(100);
		wm.clickbyxpath(" //li[@class='k-item k-menu-item k-filter-item k-state-default k-last']");
		Thread.sleep(100);
		wm.sendtextbyxvalue("//input[@data-bind='value:filters[0].value']", Filterbycode);
		Thread.sleep(300);
		wm.clickbyxpath("//button[@type='submit']");
		Thread.sleep(100);
		wm.Verifythealertpopupmessages("//*[@class='text-uppercase']", Filterbycode, "Filter by data is success",
				"Filter by data is nott success");
		Thread.sleep(300);
		// wm.clickbyxpath("//a[@id='btnMainClear']");
		Thread.sleep(500);

		// 6 Branch Master Bramch Group : Without selecting the group not
		// allowed to add the branches Proper validation should be displayed

		wm.clickbyxpath("//span[@class='k-icon k-i-add']");
		Thread.sleep(500);
		wm.Verifythealertpopupmessages("//span[@id='diaWarningMessage']", "Please select any one row in Group",
				"Pass: Not able to add the Branch without branch group",
				"Userr able to add the Branch without branch group or wron validaion message");

		Thread.sleep(600);

		wm.Listandenterquick("//span[contains(text(),'OK')]", "0");
		wm.Listandenterquick("//span[contains(text(),'OK')]", "1");
		wm.Listandenterquick("//span[contains(text(),'OK')]", "2");
		wm.Listandenterquick("//span[contains(text(),'OK')]", "3");

		Thread.sleep(300);

		// 7 Branch Master Bramch Group : Verify the newly created data saved
		// successfully Verify the newly created data saved succcessfully

		// already done in positive flow

		// 8 Branch Master Bramches : Clicking the Add button and click the grid
		// level save button Proper validation should be displayed

		wm.clickbyid("btnMainAdd");
		Thread.sleep(200);
		wm.clickbyxpath("//span[@class='k-icon k-i-check']");
		Thread.sleep(200);

		// code validations
		wm.Mousemoveover("//input[@name='Code']");
		Thread.sleep(200);
		wm.Listnegativescearios(utility.Constant.Travelogixuitooltipvalidation, Commonindex,
				"Pass :   validation is avilable in the code field %" + "",
				"Fail:  validation is not avilable in the code field %" + "");
	
/*
		wm.Listnegativescearios("//*[contains(text(),'should not be empty.')]", Commonindex,
				"Pass :  validations is avilable Code field" + "",
				"Fail:  validations is not avilable Code field" + "");
		Thread.sleep(300);
*/
		// Descriptions validations
		wm.Mousemoveover("//input[@name='Description']");
		Thread.sleep(200);

		wm.Listnegativescearios("//div[@class='k-tooltip-content']", Commonindex,
				"Pass :  validations is avilable Code field" + "",
				"Fail:  validations is not avilable Code field" + "");
		Thread.sleep(300);

		// Descriptions validations
		wm.Mousemoveover("//input[@name='Description']");
		Thread.sleep(200);

		wm.Listnegativescearios("//div[@class='k-tooltip-content']", Commonindex,
				"Pass :  validations is avilable name field" + "",
				"Fail:  validations is not avilable name field" + "");
		Thread.sleep(300);

		// company name validations
		wm.Mousemoveover("//input[@aria-owns='companyKey_listbox']");
		Thread.sleep(200);

		wm.Listnegativescearios("//div[@class='k-tooltip-content']", Commonindex,
				"Pass :  validations is avilable companyKey_listbox field" + "",
				"Fail:  validations is not avilable companyKey_listbox field" + "");
		Thread.sleep(300);
		wm.clickbyxpath("//span[@class='k-icon k-i-cancel']");
		Thread.sleep(300);

		// 9 Branch Master Bramches : Verify the details in Edit modeoptions
		// Verify the details viewd in Edit mode options are not

		// 9 Branch Master Bramches : Verify the details in Edit modeoptions
		// Verify the details viewd in Edit mode options are not
		// 10 Branch Master Verify the Country master Newly created country
		// master should reflected in the drop down
		// 11 Branch Master Verify the State master Newly created country master
		// should reflected in the drop down
		// 12 Branch Master Verify the City master Newly created country master
		// should reflected in the drop down
		// 13 Branch Master Verify the email validations Verify the eamil field
		// validaiton messages
		// 14 Branch Master Verify the category Newly created cateory reflected
		// in the catgory field

		wm.Listandenter("//*[@class='text-uppercase']", "0");
		Thread.sleep(300);
		wm.Listandenter("//span[@class='k-icon k-i-add']", "0");
		Thread.sleep(200);

		// Country
		wm.sendtextbyxvalue("//input[@aria-owns='BmcountryName_listbox']", Country);
		Thread.sleep(200);
		wm.Listnegativescearios("//*[@id='BmcountryName_listbox']/li", Countryindex,
				"Pass : in Edit mode Newly created country is avilable in the field" + "",
				"Fail:  in Edit mode Newly created country is not avilable in the field" + "");
		Thread.sleep(200);

		// state
		wm.sendtextbyxvalue("//input[@aria-owns='BmstateName_listbox']", State);
		Thread.sleep(200);
		wm.Listnegativescearios("//*[@id='BmstateName_listbox']/li", Stateindex,
				"Pass :  in Edit mode Newly created state is avilable State field" + "",
				"Fail:   in Edit mode Newly created state is not avilable in State field" + "");
		Thread.sleep(200);

		// City
		wm.sendtextbyxvalue("//input[@aria-owns='BmcityName_listbox']", City);
		Thread.sleep(200);
		wm.Listnegativescearios("//*[@id='BmcityName_listbox']/li", Cityindex,
				"Pass :   in Edit mode Newly created state is avilable State field" + "",
				"Fail:   in Edit mode Newly created state is not avilable in State field" + "");
		Thread.sleep(200);

		// Category
		wm.sendtextbyxvalue("//input[@aria-owns='BmType_listbox']", Category);
		Thread.sleep(200);
		wm.Listnegativescearios("//*[@id='BmType_listbox']/li", Categoryindex,
				"Pass :  in Edit mode  Newly created Category is avilable Category field" + "",
				"Fail:   in Edit mode Newly created Category is not avilable in Category field" + "");
		Thread.sleep(200);

		// REceivable agent
		wm.sendtextbyxvalue("//input[@aria-owns='BmCmsName_listbox']", Receivableagent);
		Thread.sleep(200);
		wm.Listnegativescearios("//*[@id='BmCmsName_listbox']/li", Receivableagentindex,
				"Pass :   in Edit mode Newly created Receivableagent is avilable Receivableagent field" + "",
				"Fail:    in Edit mode Newly created Receivableagent is not avilable in Receivableagent field" + "");
		Thread.sleep(200);

		// Airpot name
		wm.sendtextbyxvalue("//input[@aria-owns='BmDefaultAirportName_listbox']", Airportname);
		Thread.sleep(200);
		wm.Listnegativescearios("//*[@id='BmDefaultAirportName_listbox']/li", Airportnameindex,
				"Pass :   in Edit mode Newly created Receivableagent is avilable Receivableagent field" + "",
				"Fail:   in Edit mode Newly created Receivableagent is not avilable in Receivableagent field" + "");
		Thread.sleep(200);

		// Wrong emailformat validations

		wm.sendtextbyxvalue("//input[@name='BmEmail']", Wrongemailid);
		Thread.sleep(200);
		wm.clickbyxpath("//span[@class='k-icon k-i-check']");
		Thread.sleep(200);
		wm.Mousemoveover("//input[@name='BmEmail']");
		Thread.sleep(200);

		wm.Listnegativescearios("//div[@class='k-tooltip-content']", Commonindex,
				"Pass :  validations is avilable Email  field" + "",
				"Fail:  validations is not avilable Eamil field" + "");
		Thread.sleep(300);

		// 16 Branch Master Verify the cancelbutton functionality Oce click the
		// cancel the popup should closed

		// Verify the cancelbutton functionality

		wm.Listnegativescearios("//span[@class='k-icon k-i-cancel']", Commonindex,
				"Pass :  System close the branch popup successfully" + "",
				"Fail:   System close the branch popup not successfully" + "");
		Thread.sleep(300);

		// Branch Master Branches : Verify the UI validations in mandatoryfield

		wm.Listandenter("//*[@class='text-uppercase']", "0");
		Thread.sleep(300);
		wm.Listandenter("//span[@class='k-icon k-i-add']", "0");
		Thread.sleep(200);

		wm.Clearbyxpath("//input[@aria-owns='ActiveFrom_dateview']");
		Thread.sleep(200);

		wm.clickbyxpath("//span[@class='k-icon k-i-check']");
		Thread.sleep(200);

		// branchcodee
		wm.Mousemoveover("//input[@name='Code']");
		Thread.sleep(300);
		wm.Listnegativescearios("//div[@class='k-tooltip-content']", Commonindex,
				"Pass :  Branchcodee validations is avilable " + "",
				"Fail:  Branchcodee validations is not avilable " + "");
		Thread.sleep(350);

		// Branchname
		wm.Mousemoveover("//input[@name='Description']");
		Thread.sleep(500);
		wm.Listnegativescearios("//div[@class='k-tooltip-content']", Commonindex,
				"Pass :  Branch name validations is avilable " + "",
				"Fail:  Branch name  validations is not avilable " + "");
		Thread.sleep(350);

		// Country
		wm.Mousemoveover("//input[@name='BmcountryName_input']");
		Thread.sleep(300);
		wm.Listnegativescearios("//div[@class='k-tooltip-content']", Commonindex,
				"Pass :  BmcountryName_input validations is avilable " + "",
				"Fail:  BmcountryName_input  validations is not avilable " + "");
		Thread.sleep(300);

		// statee
		wm.Mousemoveover("//input[@name='BmstateName_input']");
		Thread.sleep(300);
		wm.Listnegativescearios("//div[@class='k-tooltip-content']", Commonindex,
				"Pass :  BmstateName_listbox validations is avilable " + "",
				"Fail:  BmstateName_listbox  validations is not avilable " + "");
		Thread.sleep(300);

		// Cityyname
		wm.Mousemoveover("//input[@name='BmcityName_input']");
		Thread.sleep(300);
		wm.Listnegativescearios("//div[@class='k-tooltip-content']", Commonindex,
				"Pass :  BmcityName_input validations is avilable " + "",
				"Fail:  BmcityName_input  validations is not avilable " + "");
		Thread.sleep(300);

		// Category
		wm.Mousemoveover("//input[@name='BmType_input']");
		Thread.sleep(300);
		wm.Listnegativescearios("//div[@class='k-tooltip-content']", Commonindex,
				"Pass :  BmType_input category  validations is avilable " + "",
				"Fail:  BmType_input Category  validations is not avilable " + "");
		Thread.sleep(300);

		// DAtevalidations
		wm.Mousemoveover("//input[@name='ActiveFrom']");
		Thread.sleep(300);
		wm.Listnegativescearios("//div[@class='k-tooltip-content']", Commonindex,
				"Pass :  From date  validations is avilable " + "",
				"Fail:  From date   validations is not avilable " + "");
		Thread.sleep(600);
		
		wm.clickbyxpath("//span[@class='k-icon k-i-cancel']");
		Thread.sleep(1200);
		
		wm.clickbyid("btnMainClear");
		wm.sleep();
		wm.sleep();
		wm.sleep();
		
		//duplicate code checking
		
		wm.clickbyid("btnMainAdd");
		wm.clickbyid("btnMainAdd");
		
		Thread.sleep(500);
		wm.sendtextbyxvalue("//input[@name='Code']", Duplicatecde);
		Thread.sleep(200);
		wm.clickbyxpath("//span[@class='k-icon k-i-check']");
		Thread.sleep(100);
		wm.Mousemoveover("//input[@name='Code']");
		Thread.sleep(300);
		wm.Listnegativescearios("//div[@class='k-tooltip-content']", Commonindex,
				"Pass :  Duplciate code  validations is avilable " + "",
				"Fail:  Duplciate code  validations is not avilable " + "");
		Thread.sleep(300);
		
		
		
		wm.sleep();
	}

	@AfterMethod
	public void close()

	{
		wm.close();

	}

	@DataProvider(name = "dp")
	public Object[][] dp() throws IOException {

		return Wrappermethods.getSheet("Branchmasternegativescenarios", "Branchmasternegativescenarios");

	}
}