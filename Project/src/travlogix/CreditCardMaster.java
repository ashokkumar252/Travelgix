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
public class CreditCardMaster
 {

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
	public void CreditCardMaster(String Username, String Password, String Leftsidemenu,String CCcode,String CCdescription,
			String Creditcardstaus,String Creditcardstausindexx,String Arlinkstatus,String Arlinkstatusindex,
			String CcServiceFeePercentage,String Onlodgecardstatusindex,String CcOwnLodgeCardNumber,
			String Aplinkstatus,String Aplinkstatusindex,String CcRemarks,String CActiveFrom1,
			String CActiveFrom2,String CActiveFrom3,String CActiveto1,String CActiveto2,
			String CActiveto3,String Statusindex3) throws Exception

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
		wm.clickbyid("pgmCCD001");
		wm.sleep();
		wm.clickbyid("btnMainAdd");
		Thread.sleep(500);

		//enter the details here
		
		wm.sendtextbyxvalue("//input[@id='Code']", CCcode);
Thread.sleep(200);
		wm.sendtextbyxvalue("//input[@id='Description']", CCdescription);
		Thread.sleep(200);		
		// Creditcardstatus

		wm.sendtextbyxvalue("//input[@aria-owns='CcStatus_listbox']",Creditcardstaus);
		Thread.sleep(300);
		wm.Listandenter("//*[@id='CcStatus_listbox']/li", Creditcardstausindexx);
		Thread.sleep(300);

		// ARlinkstatus

				wm.sendtextbyxvalue("//input[@aria-owns='CcAccountLink_listbox']",Arlinkstatus);
				Thread.sleep(300);
				wm.Listandenter("//*[@id='CcAccountLink_listbox']/li", Arlinkstatusindex);
				Thread.sleep(300);
		
		    wm.stabbyxpath("//input[@aria-owns='CcAccountLink_listbox']");
		    Thread.sleep(200);
			wm.sendtextbycssselecotrwithoutclear("#CcServiceFeePercentage", ""+CcServiceFeePercentage);
            Thread.sleep(200);
           
            

    		// OWNLODGEcardstatus
            wm.clickbyxpath("//span[@aria-owns='CcOwnLodgeCardStatus_listbox']");
    		Thread.sleep(200);
    		wm.Listandenter("//*[@id='CcOwnLodgeCardStatus_listbox']/li", Onlodgecardstatusindex);
    		Thread.sleep(200);
    		
    		//ownlodgecardnumber
    		

		    wm.stabbyxpath("//span[@aria-owns='CcOwnLodgeCardStatus_listbox']");
		    Thread.sleep(200);
			wm.sendtextbycssselecotrwithoutclear("#CcOwnLodgeCardNumber", ""+CcOwnLodgeCardNumber);
            Thread.sleep(200);
            
            

    		// APlinkstatus

    		wm.sendtextbyxvalue("//input[@aria-owns='CcApLink_listbox']",Aplinkstatus);
    		Thread.sleep(300);
    		wm.Listandenter("//*[@id='CcApLink_listbox']/li",Aplinkstatusindex);
    		Thread.sleep(300);
        
    		
//Entertheremarks

    		wm.sendtextbyxvalue("//input[@id='CcRemarks']", CcRemarks);
    		Thread.sleep(50);

    		// Fromdate

    		wm.sendtextbycssselecotr("#ActiveFrom", "" + CActiveFrom1 + "-" + CActiveFrom2 + "-" + CActiveFrom3);
    		Thread.sleep(50);
    		// Todate
    		wm.sendtextbycssselecotr("#ActiveTo", "" + CActiveto1 + "-" + CActiveto2 + "-" + CActiveto3);
    		Thread.sleep(50);



    		// Selected the stayusdropdwon
    		wm.clickbyxpath("//span[@aria-owns='Status_listbox']");
    		Thread.sleep(200);
    		wm.Listandenter("//*[@id='Status_listbox']/li", Statusindex3);
    		Thread.sleep(200);

    		wm.clickbyxpath("//span[@class='k-icon k-i-check']");

    		Thread.sleep(200);

    		wm.clickbyid("btnMainSave");

    		Thread.sleep(2000);

    		wm.Verifythealertpopupmessages("//span[@id='diaInfoMessage']", 
    				"Credit CardType Master Saved/Updated Successfully",
    				"Credit care master Created successfully", 
    				"Credit care master not created successfully");

    		
    		//wm.capturetextfrommsgbox("//span[@id='diaInfoMessage']", " CreditCard Master master created successfully ");

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

		return Wrappermethods.getSheet("CreditCardMaster", "CreditCardMaster");

	}
}