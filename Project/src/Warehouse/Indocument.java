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
import Warehouse.Wrappermethods;
import atu.testng.reports.listeners.ATUReportsListener;
import atu.testng.reports.listeners.ConfigurationListener;
import atu.testng.reports.listeners.MethodListener;

@Listeners({ ATUReportsListener.class, ConfigurationListener.class, MethodListener.class })
public class Indocument {

	static {

		// System.setProperty("atu.reporter.config",
		// "C:\\ATUReports\\atu.properties");
		System.setProperty("atu.reporter.config", "C:\\ATUReports\\atu.properties");

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
	public void logincheckK(String Sno, String Username, String Password, String Searchmenu, 
			String InhShipmentReference,
			String InhDocumentDate1,String InhDocumentDate2,String InhDocumentDate3,
			String InhOperationTypeRefKey_listbox,
			String InhCustomerCbtlKey_listbox,String InhCustomerCbtlKey_listboxIndex,
			String InhSupplierCbtlKey_listbox,String InhSupplierCbtlKey_listboxIndex,
			String InhExecutiveCbtlKey_listbox,String InhExecutiveCbtlKey_listboxIndex,
			String InhBasisKey_listbox,
			String InhStatusKey_listbox,
			
			String InsHouseDocument,
			String InsMasterDocument,
			String InsDeclarationNumber,
			String InsBeNumber,
			String InsBeDate1,String InsBeDate2,String InsBeDate3,
			String InsEta1,String InsEta2,String InsEta3,
			String InsCarrierTypeRefKey_listbox,
			String InsCarrierNumber,
			String InsShipmentModeRefKey_listbox,
			String InsShipmentModeRefName,
			
			String InsLine,
			String InsVessel,
			String InsVoyage,
			String InsOriginPortKey_listbox,
			String InsOriginPortKey_listboxIndex,
			String InsDischargePortKey_listbox,
			String InsDischargePortKey_listboxIndex,
			String InsDestinationPortKey_listbox,
			String InsDestinationPortKey_listboxIndex,
			
			String IncContainerTypeKey_listbox,
			String IncContainerTypeKey_listboxIndex,
			String IncContainerNumber,
			String IncServiceTypeRefKey_listbox,
			String IncLineSeal,
			String IncShipperSeal,
			String IncAgentSeal,
			String IncCustomsSeal,
			//String IncHazardousFlag,
			//String IncReeferFlag,
			String IncImoKey_listbox,
			String IncImoKey_listboxIndex,
			String IncRemarksKey_listbox,
			
			String IniIncContainerNumber_listbox,
			String IniItemKey_listbox,
			String IniItemKey_listboxIndex,
			String IniUomKey_listbox,
			String IniUomKey_listboxIndex,
			String IniContain,
			String IniQuantity,
			String IniGrossWeight,
			String IniWeightUomKey_listbox,
			String IniWeightUomKey_listboxIndex,
			String IniNetWeight,
			String IniVolume,
			String IniVolumeUomKey_listbox,
			String IniVolumeUomKey_listboxIndex,
			String IniLotNumber,
			String IniManufactureDate1, String IniManufactureDate2, String IniManufactureDate3,
			String IniExpiryDate1, String IniExpiryDate2, String IniExpiryDate3,
			String IniOriginCountryKey_listbox,
			String IniHsCode,
			String IniSsccBarcode,
			String IniPalletNumber,
			String IniPalletRefKey_listbox,
			String IniMarksNumbers,
			String IniDescription,
			String IniDeclarationNumber,
			String IniBeNumber,
			String IniBeDate1, String IniBeDate2, String IniBeDate3,
			String IniValueTypeRefKey_listbox,
			String IniUnitValue,
			String IniCurrencyKey_listbox,
			String IniCurrencyKey_listboxIndex,
			String IniExRate,
			String IniRemarksKey_listbox,
			String IniRemarksKey_listboxIndex,
			String IniRemarks,
			String IniHazardousFlag,
			String IniImoKey_listbox,
			String IniImoKey_listboxIndex,
			String IniReeferFlag,
			String IniAssignedFlag,
			String IniCustomsReqFlag,
			String IniAssignedReference,
			String ItemPromptIndex,
			String ItemValueCodeIndex,

			
			String InpPartyTypeRefKey_listbox,
			String InpPartyName,
			String InpPartyAddress,
			
			String Promptindex,
			String ValueCodeIndex,

			String InoteNmKey_listbox,
			String InoteDescription,
			String InoteStatusKey_listbox
			) throws Exception
			
			
			
			

	{

		Thread.sleep(2000);

		// wm.sendtextbyid("", );
		wm.sendtextbyid("LoginCode", Username);
		Thread.sleep(100);
		wm.sendtextbyid("Password", Password);
		Thread.sleep(100);
		wm.clickbyxpath("//input[@value='Login']");
		wm.sleep();

		// Enter master name in the left side of the screen

		wm.sendtextbyid("input-items", Searchmenu);
		Thread.sleep(900);

		wm.clickbyid("modBOOK001");
		Thread.sleep(500);
		wm.clickbyid("pgmBFC001");
		Thread.sleep(4000);
		wm.clickbyid("btnMainAdd");
		Thread.sleep(4000);
			
		
		  //Header
		
		
		/*
		 * wm.sendtextbycssselecotrwithoutclear("#InhShipmentReference",
		 * InhShipmentReference); Thread.sleep(70);
		 * wm.sendtextbycssselecotr("#InhDocumentDate", "" + InhDocumentDate1+ "-" +
		 * InhDocumentDate2 + "-" + InhDocumentDate3); Thread.sleep(200);
		 * 
		 * wm.clickbyxpath("//span[@aria-owns='InhOperationTypeRefKey_listbox']");
		 * Thread.sleep(500);
		 * wm.Listandenter("//*[@id='InhOperationTypeRefKey_listbox']/li",
		 * InhOperationTypeRefKey_listbox); Thread.sleep(200);
		 * 
		 * wm.sendtextbyxvalue("//input[@aria-owns='InhCustomerCbtlKey_listbox']",
		 * InhCustomerCbtlKey_listbox); Thread.sleep(300);
		 * wm.Listandenter("//*[@id='InhCustomerCbtlKey_listbox']/li",
		 * InhCustomerCbtlKey_listboxIndex); Thread.sleep(300);
		 * 
		 * wm.sendtextbyxvalue("//input[@aria-owns='InhSupplierCbtlKey_listbox']",
		 * InhSupplierCbtlKey_listbox); Thread.sleep(300);
		 * wm.Listandenter("//*[@id='InhSupplierCbtlKey_listbox']/li",
		 * InhSupplierCbtlKey_listboxIndex); Thread.sleep(300);
		 * 
		 * wm.sendtextbyxvalue("//input[@aria-owns='InhExecutiveCbtlKey_listbox']",
		 * InhExecutiveCbtlKey_listbox); Thread.sleep(300);
		 * wm.Listandenter("//*[@id='InhExecutiveCbtlKey_listbox']/li",
		 * InhExecutiveCbtlKey_listboxIndex); Thread.sleep(300);
		 * 
		 * wm.clickbyxpath("//span[@aria-owns='InhBasisKey_listbox']");
		 * Thread.sleep(300); wm.Listandenter("//*[@id='InhBasisKey_listbox']/li",
		 * InhBasisKey_listbox); Thread.sleep(300);
		 * 
		 * wm.clickbyxpath("//span[@aria-owns='InhStatusKey_listbox']");
		 * Thread.sleep(300);
		 * wm.Listandenter("//*[@id='InhStatusKey_listbox']/li",InhStatusKey_listbox);
		 * Thread.sleep(500);
		 */
		 
		 
		 
		 
		  
		//===========================Shipment Grid===========================
		    //wm.doubleclickusingxpath("//*[@id='ShippingGrid']/div/a/span[@class='k-icon k-i-add']");
		    wm.doubleclickusingxpath("//*[@id=\"ShippingGrid\"]/div[1]/a/span[@class='k-icon k-i-add']");
		    Thread.sleep(300);
			
			wm.sendtextbycssselecotr("#InsHouseDocument", InsHouseDocument);
			Thread.sleep(50);
			wm.sendtextbycssselecotr("#InsMasterDocument", InsMasterDocument);
			Thread.sleep(50);
			wm.sendtextbycssselecotr("#InsDeclarationNumber", InsDeclarationNumber);
			Thread.sleep(50);
			wm.sendtextbycssselecotr("#InsBeNumber", InsBeNumber);
			Thread.sleep(50);
			wm.sendtextbycssselecotr("#InsBeDate", "" + InsBeDate1+ "-" + InsBeDate2 + "-" + InsBeDate3);
			Thread.sleep(50);
			wm.sendtextbycssselecotr("#InsEta", "" + InsEta1+ "-" + InsEta2 + "-" + InsEta3);
			Thread.sleep(50);
			wm.clickbyxpath("//span[@aria-owns='InsCarrierTypeRefKey_listbox']");
			Thread.sleep(50);
			wm.Listandenter("//*[@id='InsCarrierTypeRefKey_listbox']/li", InsCarrierTypeRefKey_listbox);
			Thread.sleep(50);
			
			wm.sendtextbycssselecotr("#InsCarrierNumber", InsCarrierNumber);
			Thread.sleep(50);
			wm.clickbyxpath("//span[@aria-owns='InsShipmentModeRefKey_listbox']");
			Thread.sleep(50);
			wm.Listandenter("//*[@id='InsShipmentModeRefKey_listbox']/li",InsShipmentModeRefKey_listbox);
			Thread.sleep(500);
			
			// More details -- Popup
		
		  wm.Listandenter("//a[@class='k-button k-button-icontext k-grid-detail']",
		  "0"); Thread.sleep(100); wm.sendtextbycssselecotr("#InsLine", InsLine);
		  Thread.sleep(50); wm.sendtextbycssselecotr("#InsVessel", InsVessel);
		  Thread.sleep(50); wm.sendtextbycssselecotr("#InsVoyage", InsVoyage);
		  Thread.sleep(50); Thread.sleep(300);
		  wm.sendtextbyxvalue("//input[@aria-owns='InsOriginPortKey_listbox']",
		  InsOriginPortKey_listbox); Thread.sleep(300);
		  wm.Listandenter("//*[@id='InsOriginPortKey_listbox']/li",
		  InsOriginPortKey_listboxIndex); Thread.sleep(300);
		  
		  wm.sendtextbyxvalue("//input[@aria-owns='InsDischargePortKey_listbox']",
		  InsDischargePortKey_listbox); Thread.sleep(300);
		  wm.Listandenter("//*[@id='InsDischargePortKey_listbox']/li",
		  InsDischargePortKey_listboxIndex); Thread.sleep(300);
		  
		  wm.sendtextbyxvalue("//input[@aria-owns='InsDestinationPortKey_listbox']",
		  InsDestinationPortKey_listbox); Thread.sleep(300);
		  wm.Listandenter("//*[@id='InsDestinationPortKey_listbox']/li",
		  InsDestinationPortKey_listboxIndex); Thread.sleep(300);
		  
		  wm.Listandenter("//*[@id='btnOk']", "0");
		 
			wm.Listandenter("//span[@class='k-icon k-i-check']", "0");
			//wm.Listandenter("//*[@id=\"ShippingGrid_active_cell\"]/a[1]/span[@class='k-icon k-i-check']", "0");
			//wm.doubleclickusingxpath("//*[@id=\"ShippingGrid_active_cell\"]/a[1]/span[@class='k-icon k-i-check']");
			Thread.sleep(300);
			wm.scrollupbyxpath("//span[@class='k-icon k-i-add']");
			Thread.sleep(50);
			
			
			
			Thread.sleep(300);
			
			//===========================Container Grid===========================
			//wm.doubleclickusingxpath("//*[@id='ContainerGrid']/div/a/span[@class='k-icon k-i-add']");
			//wm.Listandenter("//span[@class='k-icon k-i-add']", "1");
			
		
		
		/*
		 * wm.Listandenter("//a[@class='k-button k-button-icontext k-grid-add']", "1");
		 * 
		 * Thread.sleep(200);
		 * wm.sendtextbyxvalue("//input[@aria-owns='IncContainerTypeKey_listbox']",
		 * IncContainerTypeKey_listbox); Thread.sleep(600);
		 * wm.Listandenter("//*[@id='IncContainerTypeKey_listbox']/li",
		 * IncContainerTypeKey_listboxIndex); Thread.sleep(600);
		 * 
		 * wm.sendtextbycssselecotr("#IncContainerNumber", IncContainerNumber);
		 * wm.clickbyxpath("//span[@aria-owns='IncServiceTypeRefKey_listbox']");
		 * Thread.sleep(50);
		 * wm.Listandenter("//*[@id='IncServiceTypeRefKey_listbox']/li",
		 * IncServiceTypeRefKey_listbox); Thread.sleep(200);
		 * 
		 * wm.sendtextbycssselecotr("#IncLineSeal", IncLineSeal); Thread.sleep(50);
		 * wm.sendtextbycssselecotr("#IncShipperSeal", IncShipperSeal);
		 * Thread.sleep(50); wm.sendtextbycssselecotr("#IncAgentSeal", IncAgentSeal);
		 * Thread.sleep(50); wm.sendtextbycssselecotr("#IncCustomsSeal",
		 * IncCustomsSeal); Thread.sleep(50);
		 * 
		 * wm.clickbyid("IncHazardousFlag"); wm.clickbyid("IncReeferFlag");
		 * wm.Listandenter("//a[@class='k-button k-grid-HazardousDetails']", "0");
		 * Thread.sleep(300);
		 * wm.sendtextbyxvalue("//input[@aria-owns='IncImoKey_listbox']",
		 * IncImoKey_listbox); Thread.sleep(300);
		 * wm.Listandenter("//*[@id='IncImoKey_listbox']/li", IncImoKey_listboxIndex);
		 * Thread.sleep(300); wm.Listandenter("//*[@id='btn']","0");
		 * 
		 * wm.clickbyxpath("//span[@aria-owns='IncRemarksKey_listbox']");
		 * Thread.sleep(50); wm.Listandenter("//*[@id='IncRemarksKey_listbox']/li",
		 * IncRemarksKey_listbox); Thread.sleep(200);
		 * 
		 * //wm.Listandenter("//span[@class='k-icon k-i-check']", "1"); wm.
		 * Listandenter("/html/body/div[3]/div/div[1]/div[1]/div/div/div/div[3]/form/div/div[2]/div/div[2]/div[11]/div/div/div[2]/div/div/div/div/table/tbody/tr/td[13]/a[1]/span[@class='k-icon k-i-check']"
		 * ,"0");
		 * 
		 * Thread.sleep(200);
		 */
		 
			wm.scrolldownbyxpath(" //a[contains(text(),'Customs Declaration No')]");
			
			//===========================ItemGrid===========================
			
			wm.Listandenter("//span[@class='k-icon k-i-add']", "2");
			Thread.sleep(300);
			
			//wm.Listandenter("/html/body/div[64]/div[2]/div/div/a[1]/span[@class='k-icon k-i-add']","0");
			
		
		
		  wm.clickbyxpath("//span[@aria-owns='IniIncContainerNumber_listbox']");
		  Thread.sleep(50);
		  wm.Listandenter("//*[@id='IniIncContainerNumber_listbox']/li",
		  IniIncContainerNumber_listbox); Thread.sleep(50);
		  
		  
		  
		  wm.sendtextbyxvalue("//input[@aria-owns='IniItemKey_listbox']",
		  IniItemKey_listbox); Thread.sleep(300);
		  wm.Listandenter("//*[@id='IniItemKey_listbox']/li", IniItemKey_listboxIndex);
		  Thread.sleep(300);
		 
			
		/*
		 * wm.sendtextbyxvalue("//input[@aria-owns='IniUomKey_listbox']",
		 * IniUomKey_listbox); Thread.sleep(300);
		 * wm.Listandenter("//*[@id='IniUomKey_listbox']/li", IniUomKey_listboxIndex);
		 * Thread.sleep(300);
		 */
			
			
		
		  Thread.sleep(50); wm.stabbyxpath("//input[@aria-owns='IniUomKey_listbox']");
		  
		  Thread.sleep(50); wm.sendtextbycssselecotrwithoutclear("#IniContain", ""
		  +IniContain); Thread.sleep(50);
		  
		  
		  Thread.sleep(50); wm.stabbyxpath("//input[@name='IniContain']");
		  Thread.sleep(50); wm.sendtextbycssselecotrwithoutclear("#IniQuantity", ""
		  +IniQuantity); Thread.sleep(50);
		 
			
		
		  Thread.sleep(50); wm.stabbyxpath("//input[@name='IniGrossWeight']");
		  Thread.sleep(50); wm.sendtextbycssselecotrwithoutclear("#IniGrossWeight", ""
		  +IniGrossWeight); Thread.sleep(50);
		 
		/*
		 * wm.sendtextbyxvalue("//input[@aria-owns='IniWeightUomKey_listbox']",
		 * IniWeightUomKey_listbox); Thread.sleep(300);
		 * wm.Listandenter("//*[@id='IniWeightUomKey_listbox']/li",
		 * IniWeightUomKey_listboxIndex); Thread.sleep(300);
		 */
			
			//wm.sendtextbycssselecotr("#IniNetWeight", IniNetWeight);
		/*
		 * wm.stabbyxpath("//input[@aria-owns='IniWeightUomKey_listbox'");
		 * Thread.sleep(50); wm.sendtextbycssselecotrwithoutclear("#IniNetWeight", ""
		 * +IniNetWeight); Thread.sleep(50);
		 */
			
			//wm.sendtextbycssselecotr("#IniVolume", IniVolume);
		/*
		 * wm.stabbyxpath("//input[@name='IniVolume']"); Thread.sleep(50);
		 * wm.sendtextbycssselecotrwithoutclear("#IniVolume", "" +IniVolume);
		 * Thread.sleep(50);
		 */
			
			
		
		/*
		 * wm.sendtextbyxvalue("//input[@aria-owns='IniVolumeUomKey_listbox']",
		 * IniVolumeUomKey_listbox); Thread.sleep(300);
		 * wm.Listandenter("//*[@id='IniVolumeUomKey_listbox']/li",
		 * IniVolumeUomKey_listboxIndex); Thread.sleep(300);
		 * 
		 * 
		 * wm.sendtextbycssselecotr("#IniLotNumber", IniLotNumber); Thread.sleep(50);
		 * wm.sendtextbycssselecotr("#IniManufactureDate", "" + IniManufactureDate1+ "-"
		 * + IniManufactureDate2 + "-" + IniManufactureDate3); Thread.sleep(50);
		 * wm.sendtextbycssselecotr("#IniExpiryDate", "" + IniExpiryDate1+ "-" +
		 * IniExpiryDate2 + "-" + IniExpiryDate3); Thread.sleep(50);
		 * 
		 * wm.clickbyxpath("//span[@aria-owns='IniOriginCountryKey_listbox']");
		 * Thread.sleep(50);
		 * wm.Listandenter("//*[@id='IniOriginCountryKey_listbox']/li",
		 * IniOriginCountryKey_listbox); Thread.sleep(50);
		 * 
		 * wm.sendtextbycssselecotr("#IniHsCode", IniHsCode); Thread.sleep(50);
		 * wm.sendtextbycssselecotr("#IniSsccBarcode", IniSsccBarcode);
		 * Thread.sleep(50); wm.sendtextbycssselecotr("#IniPalletNumber",
		 * IniPalletNumber); Thread.sleep(50);
		 * 
		 * wm.clickbyxpath("//span[@aria-owns='IniPalletRefKey_listbox']");
		 * Thread.sleep(50); wm.Listandenter("//*[@id='IniPalletRefKey_listbox']/li",
		 * IniPalletRefKey_listbox); Thread.sleep(50);
		 * 
		 * wm.sendtextbycssselecotr("#IniMarksNumbers", IniMarksNumbers);
		 * Thread.sleep(50); wm.sendtextbycssselecotr("#IniDescription",
		 * IniDescription); Thread.sleep(50);
		 * wm.sendtextbycssselecotr("#IniDeclarationNumber", IniDeclarationNumber);
		 * Thread.sleep(50); wm.sendtextbycssselecotr("#IniBeNumber", IniBeNumber);
		 * Thread.sleep(50); wm.sendtextbycssselecotr("#IniBeDate", "" + IniBeDate1+ "-"
		 * + IniBeDate2 + "-" + IniBeDate3); Thread.sleep(50);
		 * 
		 * wm.clickbyxpath("//span[@aria-owns='IniValueTypeRefKey_listbox']");
		 * Thread.sleep(50); wm.Listandenter("//*[@id='IniValueTypeRefKey_listbox']/li",
		 * IniValueTypeRefKey_listbox); Thread.sleep(50);
		 * 
		 * 
		 * Thread.sleep(50);
		 * wm.stabbyxpath("//span[@aria-owns='IniValueTypeRefKey_listbox']");
		 * Thread.sleep(50); wm.sendtextbycssselecotrwithoutclear("#IniUnitValue", ""
		 * +IniUnitValue); Thread.sleep(50); Thread.sleep(50);
		 * 
		 * wm.clickbyxpath("//span[@aria-controls='IniCurrencyKey_listbox']");
		 * 
		 * wm.Listandenter("//*[@id='IniCurrencyKey_listbox']/li",
		 * IniCurrencyKey_listboxIndex); Thread.sleep(300);
		 * 
		 * Thread.sleep(50);
		 * wm.stabbyxpath("//input[@aria-owns='IniCurrencyKey_listbox']");
		 * Thread.sleep(50); wm.sendtextbycssselecotrwithoutclear("#IniExRate", ""
		 * +IniExRate);
		 * 
		 * Thread.sleep(50);
		 * 
		 * 
		 * wm.clickbyxpath("//span[@aria-controls='IniRemarksKey_listbox']");
		 * wm.Listandenter("//*[@id='IniRemarksKey_listbox']/li",
		 * IniRemarksKey_listboxIndex); Thread.sleep(300);
		 */
		  //wm.sendtextbycssselecotr("#IniRemarks", IniRemarks);
		  
		  wm.clickbyid("IniHazardousFlag"); Thread.sleep(50);
		  wm.clickbyid("IniReeferFlag"); Thread.sleep(50);
		  wm.clickbyid("IniAssignedFlag"); Thread.sleep(50);
		  wm.clickbyid("IniCustomsReqFlag"); Thread.sleep(50);
		  
		  wm.sendtextbycssselecotr("#IniAssignedReference", IniAssignedReference);
		  Thread.sleep(300);
		
		  wm.clickbyxpath("//span[@aria-controls='IniImoKey_listbox']");
		  //wm.sendtextbyxvalue("//input[@aria-owns='IniImoKey_listbox']", IniImoKey_listbox); Thread.sleep(300);
		  wm.Listandenter("//*[@id='IniImoKey_listbox']/li", IniImoKey_listboxIndex);
		  Thread.sleep(300);
		  
		  wm.scrolldownbyxpath("//*[@id=\"ItemAdditionalInfoDetailsGrid\"]/div[1]/a/span[@class='k-icon k-i-add']");
		  Thread.sleep(300);
		 
			//===========================Item Additional Info ===========================
			wm.doubleclickusingxpath("//*[@id=\"ItemAdditionalInfoDetailsGrid\"]/div[1]/a/span[@class='k-icon k-i-add']");
			Thread.sleep(300);
			wm.clickbyxpath("//span[@aria-owns='PromptKey_listbox']");
			Thread.sleep(200);
			wm.Listandenter("//*[@id='PromptKey_listbox']/li", ItemPromptIndex);
			Thread.sleep(200);
			
			wm.clickbyxpath("//span[@aria-owns='ValueCode_listbox']");
			Thread.sleep(50);
			wm.Listandenter("//*[@id='ValueCode_listbox']/li",ItemValueCodeIndex);
			Thread.sleep(500);
			//wm.Listandenter("/html/body/div[64]/div[2]/div/form/div[3]/div/div[2]/div/div/div/table/tbody/tr/td[5]/a[1]/span[@class='k-icon k-i-check']","0");
			 ///html/body/div[95]/div[2]/div/form/div[3]/div/div[2]/div/div/div/table/tbody/tr/td[5]/a[1]/span
			wm.scrolldownbyxpath(" //a[contains(text(),'Quantity')]");
			wm.Listandenter("//a[@class='k-button k-button-icontext k-primary k-grid-update']", "0");
			//wm.Listandenter("//*[@id=\"ItemAdditionalInfoDetailsGrid\"]/div[1]/a/span[@class='k-icon k-i-check']","0");
			//wm.Listandenter("/html/body/div[95]/div[2]/div/form/div[3]/div/div[2]/div/div/div/table/tbody/tr/td[5]/a[1]/span[@class='k-icon k-i-check']","0");
			//wm.Listandenter("//a[@class='k-button k-button-icontext k-primary k-grid-update']", "1");
			//wm.Listandenter("/html/body/div[95]/div[2]/div/div/a[1]/span[@class='k-icon k-i-check']","0");
			wm.Listandenter("//span[@class='k-icon k-i-check']", "0");
			//wm.Listandenter("/html/body/div[64]/div[2]/div/div/a[2]/span[@class='k-icon k-i-cancel']","0");
			
			//===========================PartyGrid==========================
			Thread.sleep(1000);
			wm.scrolldownbyxpath(" //a[contains(text(),'Party Type')]");
			//wm.scrolldownbyxpath("/html/body/div[3]/div/div[1]/div[1]/div/div/div/div[3]/form/div/div[2]/div/div[2]/div[13]/div/div/div[2]/div/div/div/div[1]/a/span[@class='k-icon k-i-add']");
			//Thread.sleep(4000);
			//wm.scrolldownbyxpath("//*[@id=\"PartyGrid\"]/div[1]/a/span[@class='k-icon k-i-add']");
			Thread.sleep(2000);
			//wm.Listandenter("//span[@class='k-icon k-i-add']", "3");
			wm.Listandenter("//a[@class='k-button k-button-icontext k-grid-add']", "3");
			//wm.doubleclickusingxpath("//*[@id=\"PartyGrid\"]/div[1]/a/span[@class='k-icon k-i-add']");
			//wm.doubleclickusingxpath("//*[@id='PartyGrid']/div/a/span[@class='k-icon k-i-add']");
			
		
			Thread.sleep(500);
			wm.clickbyxpath("//span[@aria-owns='InpPartyTypeRefKey_listbox']");
			Thread.sleep(50);
			wm.Listandenter("//*[@id='InpPartyTypeRefKey_listbox']/li", InpPartyTypeRefKey_listbox);
			Thread.sleep(50);
			wm.sendtextbycssselecotr("#InpPartyName", InpPartyName);
			wm.sendtextbycssselecotr("#InpPartyAddress", InpPartyAddress);
			//wm.Listandenter("//span[@class='k-icon k-i-check']", "0");
			//wm.doubleclickusingxpath("//*[@id=\"PartyGrid_active_cell\"]/a[1]/span[@class='k-icon k-i-check']");
			wm.Listandenter("/html/body/div[3]/div/div[1]/div[1]/div/div/div/div[3]/form/div/div[2]/div/div[2]/div[13]/div/div/div[2]/div/div/div/table/tbody/tr/td[8]/a[1]/span[@class='k-icon k-i-check']","0");
			Thread.sleep(300);
			
			//===========================AdditionalInfo===========================
			wm.scrolldownbyxpath("//*[@id=\"AdditionalInfoDetailsGrid\"]/div[1]/a/span[@class='k-icon k-i-add']");
			Thread.sleep(50);
			wm.doubleclickusingxpath("//*[@id=\"AdditionalInfoDetailsGrid\"]/div[1]/a/span[@class='k-icon k-i-add']");
			Thread.sleep(100);
			//wm.doubleclickusingxpath("//*[@id='AdditionalInfoDetailsGrid']/div/a/span[@class='k-icon k-i-add']");
			Thread.sleep(300);
			wm.clickbyxpath("//span[@aria-owns='PromptKey_listbox']");
			Thread.sleep(100);
			wm.Listandenter("//*[@id='PromptKey_listbox']/li", Promptindex);
			Thread.sleep(100);
			
			wm.clickbyxpath("//span[@aria-owns='ValueCode_listbox']");
			Thread.sleep(100);
			wm.Listandenter("//*[@id='ValueCode_listbox']/li",ValueCodeIndex);
			Thread.sleep(100);
			
			//wm.sendtextbycssselecotrwithoutclear("#ValueCode", ValueCode);
			
			//wm.Listandenter("//span[@class='k-icon k-i-check']", "0");
			
			//wm.Listandenter("//*[@id=\"AdditionalInfoDetailsGrid_active_cell\"]/a[1]/span[@class='k-icon k-i-check']", "0");
			wm.Listandenter("/html/body/div[3]/div/div[1]/div[1]/div/div/div/div[3]/form/div/div[2]/div/div[2]/div[14]/div/div/div[2]/div/div/div/table/tbody/tr/td[4]/a[1]/span[@class='k-icon k-i-check']","0");
			Thread.sleep(50);
			
			//===========================NotesGrid===================================
			wm.scrolldownbyxpath("//*[@id=\"NotesGrid\"]/div[1]/a/span[@class='k-icon k-i-add']");
			Thread.sleep(50);
			wm.doubleclickusingxpath("//*[@id=\"NotesGrid\"]/div[1]/a/span[@class='k-icon k-i-add']");
			Thread.sleep(50);
			//wm.doubleclickusingxpath("//*[@id='NotesGrid']/div/a/span[@class='k-icon k-i-add']");
			Thread.sleep(300);
			wm.clickbyxpath("//span[@aria-owns='InoteNmKey_listbox']");
			Thread.sleep(50);
			wm.Listandenter("//*[@id='InoteNmKey_listbox']/li", InoteNmKey_listbox);
			Thread.sleep(50);
			wm.sendtextbycssselecotr("#InoteDescription", InoteDescription);
			
			wm.clickbyxpath("//span[@aria-owns='InoteStatusKey_listbox']");
			Thread.sleep(50);
			wm.Listandenter("//*[@id='InoteStatusKey_listbox']/li", InoteStatusKey_listbox);
			Thread.sleep(50);
			wm.Listandenter("//span[@class='k-icon k-i-check']", "0");
			//wm.Listandenter("//*[@id=\"NotesGrid_active_cell\"]/a[1]/span[@class='k-icon k-i-check']", "0");
			Thread.sleep(50);
			
			wm.Listandenter("/html/body/div[3]/div/div[1]/div[1]/div/div/div/div[3]/form/div/div[2]/div/div[2]/div[16]/div/div/div[2]/div/div/div/table/tbody/tr/td[5]/a[1]/span[@class='k-icon k-i-check']","0");
			Thread.sleep(100);
			
			wm.clickbyid("btnMainSave");
			Thread.sleep(100);
			

		    wm.capturetextfrommsgbox("//span[@id='diaInfoMessage']", " Indocument record created successfully ");
			Thread.sleep(50);
			
		  
			Thread.sleep(100);


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

		return Wrappermethods.getSheet("Indocument", "Indocument");

	}
}