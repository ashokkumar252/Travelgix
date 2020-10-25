//WASTA login screen
package Warehouse;
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
public class BinMaster {

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

		//wm.launchbrowser("chrome", utility.Constant.WAREHOUSEURL);


		wm.launchbrowser("chrome", "http://webuat.infodynamic.net:8083/wmsdev/");

		

	}

	@Test(dataProvider = "dp")
	public void logincheckK(String Username, String Password, String Searchmenu, String BinCode, String BinName,
			String BinZoneKeylistboxindex,String BinTypeRefKeylistbox,String Statuskey,String Binrowlistbox,
			String Bincolumnlistbox,String BinPosition,String BinReplenishQuantity,String BinPutawaySequence,
			String BinPickSequence,String ActiveFrom1,String ActiveFrom2,String ActiveFrom3,String ActiveTo1,
			String ActiveTo2,String ActiveTo3,String BinAvgTemperature,String BinMinTemperature,
			String BinMaxTemperature,String TempUOM	,String TempUOMlistbox,String Weightuom,
			String Weightuomindex,String Volumeuom,String Volumeindex,String BinMinWeight,
			String BinMaxWeight,String BinMinVolume,String BinMaxVolume,String BinHeight,String Heightcode,
			String Heightcodeindex,String BinLength,String Length,String Lengthindex,String BinDepth,
			String Depth,String Depthindex,String Maintanceuom,String Maintanceuomindex,String Promptindex,
			String Vauecodeindex,String Maintypeindex,String Notesindex,String BmdMaintenanceDate1,String BmdMaintenanceDate2,
			String BmdMaintenanceDate3,String BmdMaintenanceByKeylistbox) throws Exception

	{

		Thread.sleep(2000);

		// wm.sendtextbyid("", );
		wm.sendtextbyid("LoginCode", Username);
		Thread.sleep(100);
		wm.sendtextbyid("Password", Password);
		Thread.sleep(100);
		wm.clickbyxpath("//input[@value='Login']");
		wm.sleep();

		// Eneter master name in the left sideof the scree

		wm.sendtextbyid("input-items", Searchmenu);
		Thread.sleep(900);

		wm.clickbyid("modMAS001");
		Thread.sleep(500);
		wm.clickbyid("pgmBN001");
		Thread.sleep(500);
		wm.clickbyid("btnMainAdd");
		Thread.sleep(2000);

		// Enetr the data in bin master screen

		// wm.sendtextbyid("BinCode", BinCode);
		wm.sendtextbycssselecotrwithoutclear("#BinCode", "" + BinCode);

		Thread.sleep(200);

		wm.sendtextbyid("BinName", BinName);
		Thread.sleep(200);

		// Zone
		wm.clickbyxpath("//span[@aria-owns='BinZoneKey_listbox']");
		Thread.sleep(100);
		wm.Listandenter("//*[@id='BinZoneKey_listbox']/li", BinZoneKeylistboxindex);
		Thread.sleep(100);

		// Bintype
		wm.clickbyxpath("//span[@aria-owns='BinTypeRefKey_listbox']");
		Thread.sleep(100);
		wm.Listandenter("//*[@id='BinTypeRefKey_listbox']/li", BinTypeRefKeylistbox);
		Thread.sleep(100);

		// Status
		wm.clickbyxpath("//span[@aria-owns='BinStatusKey_listbox']");
		Thread.sleep(300);
		wm.Listandenter("//*[@id='BinStatusKey_listbox']/li", Statuskey);
		Thread.sleep(300);
		
		//warhouse list box is alredy selected
		
	//Binrow
		wm.clickbyxpath("//span[@aria-owns='BinRowRefKey_listbox']");
		Thread.sleep(100);
		wm.Listandenter("//*[@id='BinRowRefKey_listbox']/li", Binrowlistbox);
		Thread.sleep(100);
		
		
		//BinColumn
			wm.clickbyxpath("//span[@aria-owns='BinColumnRefKey_listbox']");
			Thread.sleep(100);
			wm.Listandenter("//*[@id='BinColumnRefKey_listbox']/li", Bincolumnlistbox);
			Thread.sleep(100);
			
//Postion
			wm.stabbyxpath("//span[@aria-owns='BinColumnRefKey_listbox']");
	        Thread.sleep(100);
			wm.sendtextbycssselecotrwithoutclear("#BinPosition", "" + BinPosition);
			Thread.sleep(100);

	//enter the replinshqty
			wm.stabbyxpath("//input[@name='BinPosition']");
		    Thread.sleep(100);
			wm.sendtextbycssselecotrwithoutclear("#BinReplenishQuantity", "" + BinReplenishQuantity);
			Thread.sleep(100);
			
			wm.stabbyxpath("//input[@name='BinReplenishQuantity']");
		    Thread.sleep(100);			
			wm.sendtextbycssselecotrwithoutclear("#BinPutawaySequence", "" + BinPutawaySequence);
			Thread.sleep(100);
			wm.stabbyxpath("//input[@name='BinPutawaySequence']");
		    Thread.sleep(100);			
			wm.sendtextbycssselecotrwithoutclear("#BinPickSequence", "" + BinPickSequence);
			Thread.sleep(100);
			
			
			
			wm.stabbyxpath("//input[@name='BinPickSequence']");
		    Thread.sleep(100);		
			wm.sendtextbycssselecotr("#ActiveFrom", "" + ActiveFrom1 + "-" + ActiveFrom2 + "-" + ActiveFrom3);
			Thread.sleep(100);
			wm.stabbyxpath("//span[@aria-controls='ActiveFrom_dateview']");
			Thread.sleep(100);
			wm.sendtextbycssselecotr("#ActiveTo", "" + ActiveTo1 + "-" + ActiveTo2 + "-" + ActiveTo3);
			Thread.sleep(100);
	
			wm.clickbyxpath("//span[@aria-controls='ActiveTo_dateview']");
			Thread.sleep(100);
			
			Thread.sleep(100);	
			wm.clickbyxpath("//*[@id='BinMaster']/div/div/div[2]/div[15]/div/span[1]/span/input[1]");
			Thread.sleep(100);		
			wm.sendtextbyxvalue("//input[@name='BinAvgTemperature']", ""+BinAvgTemperature);

			//mintemp
			wm.stabbyxpath("//input[@name='BinAvgTemperature']");
			Thread.sleep(100);
			wm.sendtextbycssselecotrwithoutclear("#BinMinTemperature", "" +BinMinTemperature );
			Thread.sleep(100);
			//maxtemp
			wm.stabbyxpath("//input[@name='BinMinTemperature']");
			Thread.sleep(100);		
			wm.sendtextbycssselecotrwithoutclear("#BinMaxTemperature", "" + BinMaxTemperature);
			Thread.sleep(100);
			
			//TEMPUOMm

			wm.sendtextbyxvalue("//input[@aria-owns='BinTempUomKey_listbox']", TempUOM);
			Thread.sleep(300);
			wm.Listandenter("//*[@id='BinTempUomKey_listbox']/li", TempUOMlistbox);
			Thread.sleep(300);


			//Weightuom

			wm.sendtextbyxvalue("//input[@aria-owns='BinWeightUomKey_listbox']", Weightuom);
			Thread.sleep(300);
			wm.Listandenter("//*[@id='BinWeightUomKey_listbox']/li", Weightuomindex);
			Thread.sleep(300);
			
			//Volumeuom

			wm.sendtextbyxvalue("//input[@aria-owns='BinVolumeUomKey_listbox']", Volumeuom);
			Thread.sleep(300);
			wm.Listandenter("//*[@id='BinVolumeUomKey_listbox']/li", Volumeindex);
			Thread.sleep(300);

			//minweigth			
			wm.stabbyxpath("//input[@aria-owns='BinTempUomKey_listbox']");
			Thread.sleep(100);		
			wm.sendtextbycssselecotrwithoutclear("#BinMinWeight", "" +BinMinWeight);
			Thread.sleep(100);
			
			
			//Enterthe maxweight			
			//wm.stabbyxpath("//input[@name='BinMinTemperature']");
			wm.doubleclickusingxpath("//*[@id='BinMaster']/div/div/div[2]/div[20]/div/span[1]/span/input[1]");
			Thread.sleep(50);		
			wm.sendtextbycssselecotrwithoutclear("#BinMaxWeight", "" +BinMaxWeight);
			Thread.sleep(50);
			
			//Entertheminvaloume
			wm.stabbyxpath("//input[@aria-owns='BinWeightUomKey_listbox']");
			Thread.sleep(100);		
			wm.sendtextbycssselecotrwithoutclear("#BinMinVolume", "" +BinMinVolume);
			Thread.sleep(100);
			
			//Enterthemaxvaloume
			wm.stabbyxpath("//input[@name='BinMinVolume']");
			Thread.sleep(100);		
			wm.sendtextbycssselecotrwithoutclear("#BinMaxVolume", "" +BinMaxVolume);
			Thread.sleep(100);
			
			
			//Enterthe heightvalues
			wm.stabbyxpath("//input[@aria-owns='BinVolumeUomKey_listbox']");
			Thread.sleep(100);		
			wm.sendtextbycssselecotrwithoutclear("#BinHeight", "" +BinHeight);
			Thread.sleep(100);
			
			//enter the heightdropdwon
			wm.sendtextbyxvalue("//input[@aria-owns='BinHeightUomKey_listbox']", Heightcode);
			Thread.sleep(100);
			wm.Listandenter("//*[@id='BinHeightUomKey_listbox']/li", Heightcodeindex);
			Thread.sleep(100);

			//Enter the length
			wm.stabbyxpath("//input[@aria-owns='BinHeightUomKey_listbox']");
			Thread.sleep(100);		
			wm.sendtextbycssselecotrwithoutclear("#BinLength", "" + BinLength);
			Thread.sleep(100);
			wm.sendtextbyxvalue("//input[@aria-owns='BinLengthUomKey_listbox']", Length);
			Thread.sleep(100);
			wm.Listandenter("//*[@id='BinLengthUomKey_listbox']/li", Lengthindex);
			Thread.sleep(100);
			
			//Enterthedepth
			wm.stabbyxpath("//input[@aria-owns='BinLengthUomKey_listbox']");
			Thread.sleep(100);		
			wm.sendtextbycssselecotrwithoutclear("#BinDepth", "" +BinDepth);
			Thread.sleep(100);
			
			wm.sendtextbyxvalue("//input[@aria-owns='BinDepthUomKey_listbox']", Depth);
			Thread.sleep(100);
			wm.Listandenter("//*[@id='BinDepthUomKey_listbox']/li", Depthindex);
			Thread.sleep(100);
			
			//Maintanceuom
			wm.sendtextbyxvalue("//input[@aria-owns='BinMaintenanceUomKey_listbox']", Maintanceuom);
			Thread.sleep(100);
			wm.Listandenter("//*[@id='BinMaintenanceUomKey_listbox']/li", Maintanceuomindex);
			Thread.sleep(100);
			
			wm.clickbyid("BinReplenishFlag");

			wm.clickbyid("BinAllowMixFlag");

			wm.clickbyid("BinMaintenanceFlag");
			Thread.sleep(200);
			
			
	//Additional info
			
			wm.scrolldownbyxpath("//span[@class='k-icon k-i-add']");
			Thread.sleep(100);
			wm.Listandenter("//span[@class='k-icon k-i-add']", "0");
			Thread.sleep(300);
			
			
	
			wm.clickbyxpath("//span[@aria-owns='PromptKey_listbox']");
			Thread.sleep(100);
			wm.Listandenter("//*[@id='PromptKey_listbox']/li", Promptindex);
			Thread.sleep(50);
			
			wm.clickbyxpath("//span[@aria-owns='ValueCode_listbox']");
			Thread.sleep(100);
			wm.Listandenter("//*[@id='ValueCode_listbox']/li",Vauecodeindex);
			Thread.sleep(50);
			
			//wm.sendtextbycssselecotrwithoutclear("#ValueCode", ValueCode);
			
			wm.Listandenter("//span[@class='k-icon k-i-check']", "0");
			Thread.sleep(100);
			
			wm.scrollupbyxpath("//span[@class='k-icon k-i-add']");
			Thread.sleep(100);
			
			
			//Enterthemaintances
			wm.Listandenter("//span[@class='k-icon k-i-add']", "1");
			Thread.sleep(100);
			

			//maintancetype
			wm.clickbyxpath("//span[@aria-owns='BmdTypeRefKey_listbox']");
			Thread.sleep(100);
			wm.Listandenter("//*[@id='BmdTypeRefKey_listbox']/li", Maintypeindex);
			Thread.sleep(100);
			
			//Notes
			wm.clickbyxpath("//span[@aria-owns='BmdNotesKey_listbox']");
			Thread.sleep(100);
			wm.Listandenter("//*[@id='BmdNotesKey_listbox']/li", Notesindex);
			Thread.sleep(100);
			
			//selectedtehdate
			wm.sendtextbycssselecotr("#BmdMaintenanceDate", "" + BmdMaintenanceDate1+ "-" + BmdMaintenanceDate2 + "-" + BmdMaintenanceDate3);
			
			//maintanceby
			wm.clickbyxpath("//span[@aria-owns='BmdMaintenanceByKey_listbox']");
			Thread.sleep(100);
			wm.Listandenter("//*[@id='BmdMaintenanceByKey_listbox']/li", BmdMaintenanceByKeylistbox);
			Thread.sleep(100);
			
			wm.Listandenter("//span[@class='k-icon k-i-check']", "0");
				
			Thread.sleep(500);
				
			wm.clickbyid("btnMainSave");
			Thread.sleep(200);
			

		    wm.capturetextfrommsgbox("//span[@id='diaInfoMessage']", " BIN MAster Record created successfully ");
			Thread.sleep(200);


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

		return Wrappermethods.getSheet("Binmaster", "Binmaster");

	}
}