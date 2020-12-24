package Ticketquery;
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
public class Ticketquery {

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
	public void Ticketquery(String Username, String Password, String Leftsidemenu, String Product,
			String Documentnumber, String Customername, String Supplier, String Branch, String Ticketnumber,
			String Salesexecutive, String Airline, String Orgin,String Verifymessages,
			String Sourceagent,String issuedpcc,String createdby,String userCreatedOn1,
			String userCreatedOn2,String userCreatedOn3) throws Exception

	{

		Thread.sleep(2000);

		// wm.sendtextbyid("", );
		wm.sendtextbyid("LoginCode", Username);
		Thread.sleep(50);
		wm.stab("LoginCode");
		wm.sendtextbyid("Password", Password);
		Thread.sleep(50);
		wm.clickbyxpath("//input[@value='Login']");
		Thread.sleep(900);

		// screnn===========================================================
		wm.sendtextbyid("input-items", Leftsidemenu);
		Thread.sleep(500);
		wm.clickbyid("modCAS001");
		Thread.sleep(500);
		wm.clickbyid("pgmTCKSTUS001");
		wm.sleep();

		// Search by product

		wm.sendtextbyxvalue("//input[@name='productName_input']", Product);
		Thread.sleep(200);
		wm.keyboardarrowdownonetime("//input[@name='productName_input']");
		Thread.sleep(200);
		wm.Enterbyxpath("//input[@name='productName_input']");
		Thread.sleep(200);
		wm.doubleclickusingxpath("//button[@class='btn btn-success']");
		wm.sleep();
		wm.sleep();
		wm.Copyandpasteandmessage("//span[@class='k-pager-info k-label']", "Search by Product" + Product);
		wm.sleep();
		wm.Verifythealertpopupmessagesnegativescenarios("//span[@class='k-pager-info k-label']", 
				Verifymessages, "Getting search resuts  By Product", 
				"Not getting search reuslts By Product");
		// wm.sleep();
		wm.clickbyid("btnMainClear");
		wm.sleep();
		
		

		// Search by Documentnumbe

		wm.sendtextbyxvalue("//input[@name='docketNumber']", Documentnumber);
		Thread.sleep(200);
		wm.keyboardarrowdownonetime("//input[@name='docketNumber']");
		Thread.sleep(200);
		wm.Enterbyxpath("//input[@name='docketNumber']");
		Thread.sleep(200);
		wm.doubleclickusingxpath("//button[@class='btn btn-success']");
		wm.sleep();
		wm.sleep();
		wm.Copyandpasteandmessage("//span[@class='k-pager-info k-label']", "Search by documentnumber" + Documentnumber);
		wm.Verifythealertpopupmessagesnegativescenarios("//span[@class='k-pager-info k-label']", 
				Verifymessages, "Getting search resuts  By Documentnumber", 
				"Not getting search reuslts By Documentnumber");
		
		Thread.sleep(900);
		wm.clickbyid("btnMainClear");
		wm.sleep();

		// Search bycustomername

		wm.sendtextbyxvalue("//input[@name='dktPartnerName_input']", Customername);
		Thread.sleep(200);
		wm.keyboardarrowdownonetime("//input[@name='dktPartnerName_input']");
		Thread.sleep(200);
		wm.Enterbyxpath("//input[@name='dktPartnerName_input']");
		Thread.sleep(200);
		wm.doubleclickusingxpath("//button[@class='btn btn-success']");
		wm.sleep();
		 wm.sleep();
		wm.Copyandpasteandmessage("//span[@class='k-pager-info k-label']", "Search by Customername" + Customername);
		wm.Verifythealertpopupmessagesnegativescenarios("//span[@class='k-pager-info k-label']", 
				Verifymessages, "Getting search resuts  By Customername", 
				"Not getting search reuslts By Customername");
		
		Thread.sleep(900);
		wm.clickbyid("btnMainClear");
		wm.sleep();

		// Search by supplier

		wm.sendtextbyxvalue("//input[@name='payableAgntKey_input']", Supplier);
		Thread.sleep(200);
		wm.keyboardarrowdownonetime("//input[@name='payableAgntKey_input']");
		Thread.sleep(200);
		wm.Enterbyxpath("//input[@name='payableAgntKey_input']");
		Thread.sleep(200);
		wm.doubleclickusingxpath("//button[@class='btn btn-success']");
		wm.sleep();
		wm.sleep();
		wm.Copyandpasteandmessage("//span[@class='k-pager-info k-label']", "Search by Supplier" + Supplier);
		wm.Verifythealertpopupmessagesnegativescenarios("//span[@class='k-pager-info k-label']", 
				Verifymessages, "Getting search resuts  By Supplier", 
				"Not getting search reuslts By Supplier");
		
		Thread.sleep(900);
		wm.clickbyid("btnMainClear");
		wm.sleep();

		// Search by branch

		wm.sendtextbyxvalue("//input[@name='locationName_input']", Branch);
		Thread.sleep(200);
		wm.keyboardarrowdownonetime("//input[@name='locationName_input']");
		Thread.sleep(200);
		wm.Enterbyxpath("//input[@name='locationName_input']");
		Thread.sleep(200);
		wm.doubleclickusingxpath("//button[@class='btn btn-success']");
		wm.sleep();
		wm.sleep();
		wm.sleep();
		wm.Copyandpasteandmessage("//span[@class='k-pager-info k-label']", "Search by Branch" + Branch);
		wm.Verifythealertpopupmessagesnegativescenarios("//span[@class='k-pager-info k-label']", 
				Verifymessages, "Getting search resuts  By Branch", 
				"Not getting search reuslts By Branch");
		
		Thread.sleep(900);
		wm.clickbyid("btnMainClear");
		wm.sleep();

		// Search by Ticketnumber

		wm.sendtextbyxvalue("//input[@name='ticketNumber']", Ticketnumber);
		Thread.sleep(200);
		wm.keyboardarrowdownonetime("//input[@name='ticketNumber']");
		Thread.sleep(200);
		wm.Enterbyxpath("//input[@name='ticketNumber']");
		Thread.sleep(200);
		wm.doubleclickusingxpath("//button[@class='btn btn-success']");
		wm.sleep();
		wm.sleep();
		// wm.sleep();
		wm.Copyandpasteandmessage("//span[@class='k-pager-info k-label']", "Search by Ticketnumber" + Ticketnumber);
		wm.Verifythealertpopupmessagesnegativescenarios("//span[@class='k-pager-info k-label']", 
				Verifymessages, "Getting search resuts  By Ticketnumber", 
				"Not getting search reuslts By Ticketnumber");
		
		Thread.sleep(900);
		wm.clickbyid("btnMainClear");
		wm.sleep();

		// Search by Salesexecutive

		wm.sendtextbyxvalue("//input[@name='salesExecutiveName_input']", Salesexecutive);
		Thread.sleep(200);
		wm.keyboardarrowdownonetime("//input[@name='salesExecutiveName_input']");
		Thread.sleep(200);
		wm.Enterbyxpath("//input[@name='salesExecutiveName_input']");
		Thread.sleep(200);
		wm.doubleclickusingxpath("//button[@class='btn btn-success']");
		wm.sleep();
		wm.sleep();
		wm.sleep();
		wm.Copyandpasteandmessage("//span[@class='k-pager-info k-label']", "Search by Salesexecutive" + Salesexecutive);
		wm.Verifythealertpopupmessagesnegativescenarios("//span[@class='k-pager-info k-label']", 
				Verifymessages, "Getting search resuts  By Salesexecutive", 
				"Not getting search reuslts By Salesexecutive");
		
		Thread.sleep(900);
		wm.clickbyid("btnMainClear");
		wm.sleep();

		// Search by Airline , Search by orgin
		
		wm.sendtextbyxvalue("//input[@name='productName_input']", Product);
		Thread.sleep(200);
		wm.keyboardarrowdownonetime("//input[@name='productName_input']");
		Thread.sleep(200);
		wm.Enterbyxpath("//input[@name='productName_input']");
		Thread.sleep(200);


		wm.sendtextbyxvalue("//input[@name='airlineName_input']", Airline);
		Thread.sleep(200);
		wm.keyboardarrowdownonetime("//input[@name='airlineName_input']");
		Thread.sleep(200);
		wm.Enterbyxpath("//input[@name='airlineName_input']");
		Thread.sleep(200);

		wm.sendtextbyxvalue("//input[@name='originName_input']", Orgin);
		Thread.sleep(200);
		wm.keyboardarrowdownonetime("//input[@name='originName_input']");
		Thread.sleep(200);
		wm.Enterbyxpath("//input[@name='originName_input']");
		Thread.sleep(200);

		wm.doubleclickusingxpath("//button[@class='btn btn-success']");
		wm.sleep();
		wm.sleep();
		wm.sleep();
		wm.Copyandpasteandmessage("//span[@class='k-pager-info k-label']",
				"Search by Airline and Orgin" + Airline + "," + Orgin);
		wm.Verifythealertpopupmessagesnegativescenarios("//span[@class='k-pager-info k-label']", 
				Verifymessages, "Getting search resuts  By Airline,Orgin,Product", 
				"Not getting search reuslts By By Airline,Orgin,Product");
		
		Thread.sleep(900);
		wm.clickbyid("btnMainClear");
		wm.sleep();
		//Thread.sleep(2000);
		
		//Search using advancesearch
		
	wm.clickbyxpath(" //button[@class='btn btn-info']");
	Thread.sleep(500);
	
	

	//Search by source agent
	
	wm.sendtextbyxvalue("//input[@name='sourceAgentKey_input']", Sourceagent);
	Thread.sleep(200);
	wm.keyboardarrowdownonetime("//input[@name='sourceAgentKey_input']");
	Thread.sleep(200);
	wm.Enterbyxpath("//input[@name='sourceAgentKey_input']");
	Thread.sleep(200);

	wm.doubleclickusingxpath("//button[@class='btn btn-success']");
	wm.sleep();
	wm.sleep();
	wm.sleep();
	wm.Copyandpasteandmessage("//span[@class='k-pager-info k-label']",
			"Search by source agent" + Sourceagent );
	wm.Verifythealertpopupmessagesnegativescenarios("//span[@class='k-pager-info k-label']", 
			Verifymessages, "Getting search resuts  By Sourceagent", 
			"Not getting search reuslts By Sourceagent");
	
	Thread.sleep(900);
	wm.clickbyid("btnMainClear");
	wm.sleep();

	
//Search by source agent ,issuedpcc ,createdby 
	
	//spurceagent

	wm.clickbyxpath(" //button[@class='btn btn-info']");
	Thread.sleep(500);
	
	wm.sendtextbyxvalue("//input[@name='sourceAgentKey_input']", Sourceagent);
	Thread.sleep(200);
	wm.keyboardarrowdownonetime("//input[@name='sourceAgentKey_input']");
	Thread.sleep(200);
	wm.Enterbyxpath("//input[@name='sourceAgentKey_input']");
	Thread.sleep(200);
//issuedpcc
	wm.sendtextbyxvalue("//input[@name='PCC_input']", issuedpcc);
	Thread.sleep(200);
	wm.keyboardarrowdownonetime("//input[@name='PCC_input']");
	Thread.sleep(200);
	wm.Enterbyxpath("//input[@name='PCC_input']");
	Thread.sleep(200);
	//createdby
	
	wm.sendtextbyxvalue("//input[@name='userCreatedName_input']", createdby);
	Thread.sleep(200);
	wm.keyboardarrowdownonetime("//input[@name='userCreatedName_input']");
	Thread.sleep(200);
	wm.Enterbyxpath("//input[@name='userCreatedName_input']");
	Thread.sleep(200);
	
	
	wm.doubleclickusingxpath("//button[@class='btn btn-success']");
	wm.sleep();
	wm.sleep();
	wm.sleep();
	wm.Copyandpasteandmessage("//span[@class='k-pager-info k-label']",
			"Search by source agent ,issuedpcc ,createdby " + Sourceagent + "," + issuedpcc+","+createdby);
	wm.Verifythealertpopupmessagesnegativescenarios("//span[@class='k-pager-info k-label']", 
			Verifymessages, "Getting search resuts  By Sourceagent,issuedpcc,createdby", 
			"Not getting search reuslts By Sourceagent ,issuedpcc,createdby");
	
	Thread.sleep(900);
	wm.clickbyid("btnMainClear");
	wm.sleep();

	
	wm.clickbyxpath(" //button[@class='btn btn-info']");
	Thread.sleep(500);

	wm.sendtextbyxvalue("//input[@name='sourceAgentKey_input']", Sourceagent);
	Thread.sleep(200);
	wm.keyboardarrowdownonetime("//input[@name='sourceAgentKey_input']");
	Thread.sleep(200);
	wm.Enterbyxpath("//input[@name='sourceAgentKey_input']");
	Thread.sleep(200);
	wm.sendtextbycssselecotr("#userCreatedOn",
			"" + userCreatedOn1 + "/" + userCreatedOn2 + "/" + userCreatedOn3);

	Thread.sleep(200);
	
	wm.doubleclickusingxpath("//button[@class='btn btn-success']");
	wm.sleep();
	wm.sleep();
	wm.sleep();
	wm.Copyandpasteandmessage("//span[@class='k-pager-info k-label']",
			"Search by source agent , createddate " + Sourceagent + "," + userCreatedOn1+","+userCreatedOn3);
	wm.Verifythealertpopupmessagesnegativescenarios("//span[@class='k-pager-info k-label']", 
			Verifymessages, "Getting search resuts  By Sourceagent,Created date", 
			"Not getting search reuslts By Sourceagent ,Createeddate");
	
	Thread.sleep(900);
	wm.clickbyid("btnMainClear");
	wm.sleep();

	
	}

	@AfterMethod
	public void close()

	{
		wm.close();

	}

	@DataProvider(name = "dp")
	public Object[][] dp() throws IOException {

		return Wrappermethods.getSheet("Ticketquery", "Ticketquery");

	}
}