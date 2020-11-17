package utility;

import org.openqa.selenium.By;

/*import TravelB2bprivatefare.Email1;
import TravelB2bprivatefare.Email4;
*/
public class Constant
{
	
   //Atu Reports
	public static final String ATUREPORTS  = "C:\\ATUReports\\atu.properties";
	public static final String CHROMEDRIVEREXE  = "C:\\Wastaautomation\\chromedriver.exe";	
	public static final String TRAVELOGIXURL  = "https://webuat.infodynamic.net/TravelTraining/";
	
	
	//Warehouse URL
	public static final String WAREHOUSEURL  = "http://webuat.infodynamic.net:8083/wmsdev/";
	
	
	
	
	// Flight one way B2b Flightoneway.java
	public static final String URL = "http://dit.infodynamic.net/obe-demo/login.jsf";
	public static final String URL2 = "https://sit.infodynamic.net/obe/b2b/login.jsf";
	public static final String username = "j_username";
	public static final String password = "j_password";
	public static final String date = "stdatepicker";
	public static final String search = "//a[@id='searchrequestform:j_idt421:0:cmdlink_id";
	// Flight one way B2c
	public static final String URL1 = "http://sit.infodynamic.net/obe/b2c/";
	// http://172.17.56.219:8080/b2c/
	public static final String idflightmodule = "oneWay";
	public static final String roundTrip = "roundTrip";
	public static final String idchilddropdown = "som_child";

	public static final String idfrom = "origin";
	public static final String idto = "destination";
	public static final String iddate1 = "stdatepicker";
	public static final String xpselecteddate = "/html/body/div[9]/div[2]/table/tbody/tr[4]/td[3]/a";
	public static final String xpclickisearchbutton = "//div[@id='round_searchBt']";
	public static final String xpsearchresults1 = "//input[@onclick='confirm(1)']";
	public static final String xpcontinuebutton = "//input[@value='Continue booking']";
	public static final String idemail = "email1";
	public static final String xpafteremilcontinuebutton = "//input[@value='Continue']";
	public static final String idsalutation0 = "salutation0";
	// public static final String xpchildsalutation =
	// "//*[@ng-model='trvlrInfoChild[profileCIndex].salutation']";

	public static final String xpchildsalutation = "//select[@ng-model='trvlrInfoChild[profileCIndex].salutation']";

	public static final String idfirst0 = "first0";
	public static final String first10 = "first10";

	public static final String idlastName0 = "lastName0";
	public static final String xplastName10 = "//input[@ng-model='trvlrInfoChild[profileCIndex].lName']";

	//// Revew page data picker
	public static final String iddatepicker = "dateOfBirthAdult0";
	public static final String iddatepicker1 = "dateOfBirthChild0";

	public static final String xpyear = "//select[@class='ui-datepicker-year']"; // 1993
	public static final String xpyearr = "/html/body/div[9]/table/tbody/tr[4]/td[3]/a";

	// child
	public static final String xpyear1 = "/html/body/div[9]/div/div/select[1]"; // 1993
	public static final String xpyearr1 = "/html/body/div[9]/table/tbody/tr[4]/td[3]/a";

	public static final String idphonecode = "phoneCountryCode";
	public static final String idphonecode1 = "phoneNumber";

	// child phpone numbers
	public static final String idphoneCountryCode0 = "phoneCountryCode0";
	public static final String idphoneNumber0 = "phoneNumber0";

	public static final String idpassportNumber0 = "passportNumber0";
	// password expiry date
	public static final String idpassportexpirydate = "doe0";
	public static final String xpselectmonth1 = "/html/body/div[9]/div/div/select[1]";
	public static final String xppassportexpirydate1 = "/html/body/div[9]/table/tbody/tr[3]/td[4]/a";
	public static final String idcpuntry = "passportIssueCountry";
	public static final String idnational = "passportNationality";
	public static final String xptraellercontinuebutton = "/html/body/div[6]/div[2]/article/section/div/div[2]/div[6]/div[6]/div[2]/form/div[3]/input";
	public static final String idaggreecheckox = "agree";
	public static final String idsubmitButton = "submitButton";
	// payment details
	public static final String idcardNoInput = "cardNoInput";
	public static final String xpexpDateInput = "/html/body/div/div/div[2]/section[1]/form/div/div/div/div[1]/span[2]/input";
	public static final String xpexpDateInput1 = "/html/body/div/div/div[2]/section[1]/form/div/div/div/div[1]/span[2]/input";
	public static final String cvvInput = "cvvInput";
	public static final String chNameInput = "chNameInput";
	public static final String xppay = "/html/body/div/div/div[2]/section[1]/form/button";

	// Flight booking using Child:

	public static final String xppassportNumber11 = "//input[@ng-model='trvlrInfoChild[profileCIndex].passportNo']";
	public static final String idpassportexpirydatech = "doeChild0";
	public static final String xpselectmonth11 = "/html/body/div[9]/div/div/select[2]";
	public static final String xppassportexpirydate11 = "/html/body/div[9]/table/tbody/tr[4]/td[3]/a";
	public static final String xpcpuntry = "//select[@ng-model='trvlrInfoChild[profileCIndex].ppIssueCountry']";
	public static final String xpnational = "//select[@ng-model='trvlrInfoChild[profileCIndex].country']";
	public static final String xptraellercontinuebutton1 = "/html/body/div[6]/div[2]/article/section/div/div[2]/div[6]/div[6]/div[2]/form/div[4]/input";

	// public static final String clickisearchbutton =
	// "/html/body/div[1]/div[2]/article/section/div/article/section/table/tbody/tr[1]/td[3]/div/div/form/div/table/tbody/tr[2]/td/div/div[3]/table/tbody/tr[2]/td[4]/div/div[1]/input";

	// Flight booking uisng multicity

	public static final String idmultiSity = "multiSity";
	public static final String idorigin_0 = "origin_0";
	public static final String iddestination_ = "destination_";
	public static final String xpAddbutton = "//img[@src='/obe/b2c/img/otta/xmultiCityAddBtn.jpg.pagespeed.ic.8xTfE4m0S1.jpg']";
	public static final String departureDate_0 = "departureDate_0";
	public static final String xpmulticityselecteddate = "/html/body/div[9]/div[2]/table/tbody/tr[4]/td[2]/a";

	// Hotel booking :

	public static final String Hotel_Search_Id = "Hotel_Search_Id";
	public static final String idcity = "city";
	public static final String xpcity = "//input[@id='city']";

	public static final String idcheckindate = "indatepicker";
	public static final String xpchckindateselection = "/html/body/div[9]/div[2]/table/tbody/tr[2]/td[2]/a";
	public static final String xpchckoutdateselection = "/html/body/div[9]/div[1]/table/tbody/tr[2]/td[4]/a";

	public static final String idcountryOfResidence = "countryOfResidence";
	public static final String idnantionality = "nantionality";
	public static final String idroomCount_1 = "roomCount_1";
	public static final String xpround_searchBtn = "//span[@class='srhotel']";

	public static final String xphotelsearchresults = "//*[@id='booknowHtml49']";

	public static final String xphotelcontinuebutton = "//input[@value='Continue booking']";
	public static final String hotelidemail = "email1";
	public static final String xphotelafteremilcontinuebutton = "//input[@value='Continue']";

	public static final String xphotelcontinuebuttonn = "/html/body/div[6]/div[2]/article/section/div/div[2]/div[5]/div[6]/div[2]/form/div[2]/input";
	// hotel trveller details selected

	public static final String idhotelsalutation = "s_a0";
	public static final String idhotelfirstname = "f_a0";
	public static final String idhotellastname = "l_a0";
	public static final String idphoneCountryCode = "phoneCountryCode0";
	public static final String idphoneNumber = "phoneNumber0";
	public static final String idhotelaggreecheckox = "agree";
	public static final String idhosubmitButton = "submitButton";

	public static final String idchildAge_211 = "childAge_211";

	// hotel booking using double room wity child

	public static final String idroomCount_2 = "roomCount_2";
	public static final String idwithChildren_2 = "withChildren_2";
	public static final String idchildCount_21 = "childCount_21";

	public static final String idhotelsalutation1 = "s_a10";
	public static final String idhotelsalutation2 = "s_a20";
	public static final String idhotelsalutation3 = "s_c10";

	public static final String idhotelfirstname1 = "f_a10";
	public static final String idhotelfirstname2 = "f_a20";
	public static final String idhotelfirstname3 = "f_c10";

	public static final String idhotellastname1 = "l_a10";
	public static final String idhotellastname2 = "l_a20";
	public static final String idhotellastname3 = "l_c10";

	public static final String idphoneCountryCode10 = "phoneCountryCode10";
	public static final String idphoneNumber10 = "phoneNumber10";

	public static final String idphoneCountryCode20 = "phoneCountryCode20";
	public static final String idphoneNumber20 = "phoneNumber20";

	public static final String idphoneCountryCode30 = "phoneCountryCode20";
	public static final String idphoneNumber30 = "phoneNumber20";

	public static final String dateforchild = "d_c10";

	// Hotel booking with triple room

	public static final String idroomCount_3 = "roomCount_3";

	public static final String idhotelsalutation33 = "s_a30";
	public static final String idhotelfirstname33 = "f_a30";
	public static final String idhotellastname33 = "l_a30";

	public static final String idphoneCountryCode300 = "phoneCountryCode30";
	public static final String idphoneNumber300 = "phoneNumber30";

	// flight filters

	public static final String xpclickingnonstop = "/html/body/div[6]/div[2]/article/section/div/div[4]/form/div/div[1]/div[1]/p/table/tbody/tr[2]/td[1]/a";

	public static final String xpclickingonestop = "/html/body/div[6]/div[2]/article/section/div/div[4]/form/div/div[1]/div[1]/p/table/tbody/tr[3]/td[1]/a";

	// Filter by near by airports
	public static final String idnearbyairports = "noneairports";

	// selected the ailine for filtes for eg : dxb to maa

	public static final String idnearbyairportss = "/html/body/div[6]/div[2]/article/section/div/div[4]/form/div/div[1]/div[3]/div[2]/div[3]/div/table/tbody/tr[3]/td[1]/div";

	public static final String xpfilterbyairportss = "/html/body/div[6]/div[2]/article/section/div/div[4]/form/div/div[1]/div[4]/div[2]/div[1]/div[1]/div/table/tbody/tr[1]/td[1]/div/div/div/table/tbody/tr/td[2]";

	/*
	 * public static final String dragandrop = ""; public static final String
	 * mimup = ""; public static final String displayprice = "";
	 */

	// Filter by airlines

	public static final String idfilterclearbutton = "none";

	public static final String xppromocode = "//input[@id='promo_code']";

	public static final String idfilterbyairliens = "//*[@id='airline_G9']";
	public static final String idfilterbyairlienss = "//div[@id='airline_SV']";

	public static final String xpairlinedetails = "/html/body/div[6]/div[2]/article/section/div/div[4]/form/div/div[1]/div[4]/div[2]/div[1]/div[1]/div/table/tbody/tr[1]/td[1]/div/div/div/table/tbody/tr/td[1]/div/div/span";

	// hotel filters

	public static final String xphotelfilters = "/html/body/div[6]/div[2]/article/section/div/div[5]/form/div[1]/div[2]/div[5]/div/div/div/a[2]";

	public static final String clickigntwostar = "/html/body/div[6]/div[2]/article/section/div/div[5]/form/div[1]/div[2]/div[5]/div/table/tbody/tr[2]/td[1]";

	public static final String xphotelfilterby = "/html/body/div[6]/div[2]/article/section/div/div[5]/form/div[2]/div/div[6]/div[1]/div[1]/div[2]/div/table/tbody/tr/td[2]/b";

	// hotel locations

	// clicking clear button
	public static final String xphotellocations1 = "/html/body/div[6]/div[2]/article/section/div/div[5]/form/div[1]/div[2]/div[6]/div/div/div/a[2]";

	// selecting the htoel lcoations
	public static final String xphotellocations2 = "/html/body/div[6]/div[2]/article/section/div/div[5]/form/div[1]/div[2]/div[6]/div/div/div/a[2]";

	// copying the hotel descrtiotns

	public static final String xphoteldesc = "/html/body/div[6]/div[2]/article/section/div/div[5]/form/div[2]/div/div[6]/div[1]/div[1]/div[3]/table[1]/tbody/tr/td[1]/table/tbody/tr[1]/td[2]/div[1]";

	// TRavel B2b Admin module testing
	public static final String Admin = "Admin";
	public static final String ClientDetails = "/html/body/div[7]/div/div/div[1]/div/div/form/div[4]/div/div[2]/div/ul/li[1]/a";

	public static final String ClientDetails1 = "//a[@href='/obe/b2b/pages/admin/setup/agencyDetails.jsf']";
	public static final String idsearchbutton = "j_idt227";
	public static final String idcompanyName = "companyName";
	public static final String idsearchBtn = "searchBtn";
	public static final String xpcompnaysetup = "/html/body/div[6]/div/div/div[2]/div[2]/div/form/div[2]/div[2]/div[1]/table/tbody/tr/td[5]/div/a/div/div/img";
	public static final String xpcompnaysetup1 = "//a[@id='compList:0:setup']";
	public static final String xpuserdetails = "//a[@id='compList:0:j_idt99']";
	public static final String xpusercategory = "//img[@alt='User Category Setup']";
	public static final String idaddnew = "j_idt130";
	public static final String idaddnew1 = "j_idt118";
	public static final String idaddnew2 = "j_idt102"; // userroelsadding
	public static final String idaddnew3 = "j_idt103"; // usergropus

	public static final String idusercategoryname = "name";
	public static final String xpselectcategory = "//select[@name='j_idt97']";
	public static final String idsavebuttonn = "saveBtn";
	// public static final String backbutton =
	// "//a[@href='/obe/b2b/pages/admin/setup/agencyDetails.jsf']";

	public static final String backbutton = "//a[@name='Back']";

	public static final String iduser = "userid";
	public static final String idfirstname = "firstname";
	public static final String idlastname = "lastname";
	public static final String iduserCode = "userCode";
	public static final String ideemail = "email";
	public static final String iduserCategory = "userCategory";

	public static final String xpsavebutton = "//span[@name='Save']";

	public static final String managementmodule = "/html/body/div[6]/div/div/div[1]/div/div/form/div[4]/div/div[3]/h4/a";
	public static final String xpuserroles = "//a[@href='/obe/b2b/pages/admin/management/roles.jsf']";
	public static final String iduserrolesname = "name";

	public static final String xpusergroups = "//a[@href='/obe/b2b/pages/admin/management/groups.jsf']";

	public static final String idgroupcode = "groupcode";

	public static final String idgroupname = "groupname";

	public static final String xprolesandprivilagese = "//a[@href='/obe/b2b/pages/admin/management/rolesAndPrivileges.jsf']";

	public static final String idfunctionalityname = "functionalityname";

	public static final String xpavilableprivilages = "//button[@class='ui-button ui-widget ui-state-default ui-corner-all ui-button-icon-only ui-picklist-button-add-all']";

	public static final String xpGroupsandroles = "//a[@href='/obe/b2b/pages/admin/management/groupsAndRoles.jsf']";

	public static final String idgroupCodes = "groupCodes";

	public static final String idrolelist = "roleList_source_filter";

	public static final String idrolelist1 = "//span[@class='ui-button-icon-left ui-icon ui-c ui-icon ui-icon-arrowstop-1-e']";

	public static final String xpuserandgroup = "//a[@href='/obe/b2b/pages/admin/management/userGroupsAssociation.jsf']";

	public static final String idselectedUser = "selectedUser";

	public static final String idgroupssourcefilter = "groups_source_filter";

	public static final String idgroupssourcefilter1 = "userClientAss_source_filter";

	public static final String xpclickingsetupleftsidemenu = "/html/body/div[6]/div/div/div[1]/div/div/form/div[4]/div/div[1]";

	// Air service charge rule

	public static final String xpairservichargemenu = "//a[@href='/obe/b2b/pages/admin/setup/airServiceChargeRule.jsf']";

	public static final String idairservicechargeaddnew = "j_idt141";
	public static final String idairservicechargename = "airServiceChargeName";
	public static final String idairline = "airlineCode";
	public static final String idtcktType = "tcktType";
	public static final String idregion = "region";
	public static final String xpsuppliername = "//label[@class='ui-selectcheckboxmenu-label ui-corner-all']";
	public static final String xpsuppliername1 = "//span[@class='ui-chkbox-icon ui-icon ui-icon-blank']";
	public static final String idclasstype = "airServiceCharge";
	public static final String idtravelType = "travelType";
	public static final String idstatus = "serviceChargeStatusPax";
	public static final String idAirass = "compList:2:j_idt99";
	public static final String Sername = "airService_name";
	public static final String idperbooking = "serviceChargeApplyType";
	public static final String idserviceChargeType = "serviceChargeType";
	public static final String idserChargeBased = "serChargeBased";
	public static final String idamount = "servChrgBook";
	public static final String scaddnew1 = "j_idt174";
	public static final String idallocatiotype = "serviceChargeAllocType";

	// Hotel service charges

	public static final String xpclickinghotelserleft = "//a[@href='/obe/b2b/pages/admin/setup/hotelServiceChargeRule.jsf']";
	public static final String idAddnew5 = "j_idt139";
	public static final String idhotelServiceChargename = "hotelServiceCharge"; // name
	public static final String idcountry = "country"; // country
	public static final String idnoorooms = "shortName"; // country
	public static final String idhotelType = "hotelType"; // idhotelType
	public static final String idsupplierName = "supplierName"; // supplierName
	public static final String idserviceChargeStatus = "serviceChargeStatus"; // serviceChargeStatus
	public static final String clickhotelicon = "//img[@alt='Service Charge - Hotel']";
	public static final String idaddnewhotel = "j_idt172";
	public static final String idhotelrulename = "srvRl";
	public static final String idapplynow = "serviceChargeApplyType";
	public static final String idhotelserchargemodel = "discountType1";
	public static final String idallocationtype = "serviceChargeAllocType";
	public static final String idmon = "mkup_Mon";
	public static final String idtue = "mkup_Tue";
	public static final String idwed = "mkup_Wed";
	public static final String idthu = "mkup_Thu";
	public static final String idfri = "mkup_Fri";
	public static final String idsat = "mkup_Sat";
	public static final String idsun = "mkup_Sun";

	// Airline private Fare

	public static final String xpairlienprivatefare = "//img[@alt='Airline Private Fare']";

	public static final String idprivatefareaddnew = "j_idt145";

	public static final String idprivatfarename = "supplierName";
	public static final String idhapName = "hapName";
	public static final String idhapCode = "hapCode";

	// private fare from date
	public static final String idfromdate = "privFareFrom";
	public static final String xpnext = "//a[@data-handler='next']";
	public static final String xpfromdate = "//a[@class='ui-state-default']";

	// private fare to date

	// privFareTo

	public static final String idtodate = "privFareTo";
	// public static final String xpnext ="//a[@data-handler='next']";
	// public static final String xpfromdate ="//a[@class='ui-state-default']";

	public static final String idairlinefare = "airlineName_input";
	public static final String idCategoryType = "CategoryType";

	public static final String idclientselected = "compPickList_source_filter";

	public static final String xpclientselected1 = "/html/body/div[6]/div/div/div[2]/div[2]/div/form/div[2]/div[2]/div/div[3]/div/div[2]/div/button[2]";

	// public static final String xpsavebutton = "//span[@name='Save']";

	public static final String iddealname = "acc_code";
	public static final String iddeal_name1 = "deal_name";
	public static final String xppsavebutton = "//button[@id='saveBtn']";
	public static final String xpprivatefaresearchbuton = "//button[@id='searchBtn']";
	public static final String xpcontractcreaionicon = "//img[@id='contractCreatioinImg']";
	public static final String idtriptype = "tripType";
	public static final String idclassType = "classType";

	// Private fare associations
	public static final String xpprivatefareasso = "//img[@alt='Private Fare Association']";

	// Car Service charge rule and Associations

	public static final String xpcarmenuleftside = "//a[@href='/obe/b2b/pages/admin/setup/carServiceChargeRule.jsf']";
	public static final String caraddnew = "j_idt117";
	public static final String idname = "carServChgName";
	public static final String idtype = "vehicleType";

	public static final String idcarfromdate = "effectiveFrm";
	public static final String idcartodate = "vehicleType";
	public static final String xpcarnext = "//span[@class='ui-icon ui-icon-circle-triangle-e']";
	public static final String xpdateselecion = "//a[@class='ui-state-default']";

	public static final String ideffectiveTo = "effectiveTo";
	public static final String idcarsupplierName = "supplierName";
	public static final String idcarServiceChargeactive = "carServiceCharge";
	public static final String xpcarassociations = "//img[@alt='Service Charge - Car']";
	public static final String idcaraddnew = "j_idt138";
	public static final String idcarService_name = "carService_name";
	public static final String idapplytype = "serviceChargeApplyType";
	public static final String idcarserviceType = "serviceChargeType";
	public static final String idalltypee = "serviceChargeAllocType";
	public static final String idfee = "servChrgBook";

	// insurance service charges

	public static final String xpinsuranceser = "//img[@alt='Service Charge - Insurance']";
	public static final String insaddnew = "//a[@class='ui-commandlink ui-widget addNewBtn']";

	public static final String xpname1 = "//input[@class='form-control ng-invalid ng-invalid-required ng-valid-maxlength ng-pristine k-invalid ng-touched']";

	public static final String Sname = "*//span[@class='k-input ng-scope']";

	// Coupon code setup
	public static final String xpcouponcode = "//img[@alt='Coupon Code Setup']";
	public static final String copuaddnew = "j_idt145";
	public static final String dealcode1 = "dealcode";
	public static final String iddealdesc = "dealdesc";
	// Date
	public static final String idbookingdate = "bookingFromDate";
	public static final String xpselectingdate = "//a[@class='ui-state-default']";
	public static final String xpdatenextbutton = "//span[@class='ui-icon ui-icon-circle-triangle-e']";
	public static final String idbookingToDate = "bookingToDate";
	
	public static final String xpbookingToDate = "//input[@id='bookingToDate']";

	public static final String iddealtype = "dealtype";
	public static final String idprdType = "prdType";
	public static final String idalloc = "serviceChargeAllocType";
	public static final String xpalloc1 = "/html/body/div[6]/div/div/div[2]/div[2]/div/form/div[2]/div[2]/div/div[4]/div/div[2]/div/button[2]";
	public static final String idvalue = "value";
	public static final String xpallcoaltio1 = "//input[@id='compPickList_source_filter']";
	public static final String xpuserchecklistfilter = "//input[@id='userPickList_source_filter']";
	
	public static final String xpallcoaltio11 = "//input[@id='userPickList_source_filter']";
	
	public static final String xpallcoaltio111 = "//button[@title='Add All']";
	
	public static final String xpallcoaltio1111 = "//input[@id='bookingToDate']";
	public static final String xpaddall ="//button[contains(@title, 'Add All')";

	// Schedulre configurations

	public static final String xpscheduler = "//img[@alt='Scheduler Configuration']";
	public static final String idjob = "patternForm:scheduler";
	public static final String idtime = "patternForm:timeZones";
	public static final String idtime1 = "patternForm:start_tme";
	public static final String xpnex3 = "//html/body/div[23]/div[3]/table/thead/tr[1]/th[3]/i";
	public static final String xpdateselection = "/html/body/div[23]/div[3]/table/tbody/tr[3]/td[2]";
	public static final String xpdateselection1 = "/html/body/div[23]/div[2]/table/tbody/tr/td/span[5]";
	public static final String xpdateselection2 = "/html/body/div[23]/div[1]/table/tbody/tr/td/span[3]";
	public static final String xppattern = "/html/body/div[6]/div/div/div[2]/div[2]/div/form/div[3]/div[2]/div/table/tbody/tr[4]/td[2]/div/div/table/tbody/tr/td[1]/div/div[2]";
	public static final String xpeveryday = "/html/body/div[6]/div/div/div[2]/div[2]/div/form/div[3]/div[2]/div/table/tbody/tr[5]/td/div[1]/table/tbody/tr/td[3]/div/div[2]/span";
	public static final String xpSavescheduler = "//input[@id='patternForm:comm_button']";

	// Currency conversion setup

	public static final String xpccconversion = "//img[@alt='Currency Conversion Setup']";
	public static final String ccadd = "j_idt110";

	public static final String idfrmCur = "frmCur";
	public static final String idtocur = "tocur";
	public static final String idrate = "conversionRate";

	public static final String xpccdate1 = "//input[@id='conversionDate']";
	public static final String xpccdate2 = "/html/body/div[23]/div[3]/table/tbody/tr[1]/td[2]";
	public static final String xpccdate3 = "/html/body/div[23]/div[2]/table/tbody/tr/td/span[5]";
	public static final String xpccdate4 = "/html/body/div[23]/div[1]/table/tbody/tr/td/span[4]";
	public static final String ccsavebutton = "//button[@id='saveBtn']";

	// Fare summary setup

	public static final String faresummaryicon = "//img[@alt='Fare Summary Setup']";
	public static final String radio1 = "//input[@id='displayVal_radio:0']";
	public static final String radio2 = "//input[@id='displayVal_radio:1']";
	public static final String submit = "//button[@id='j_idt101']";

	// Discoutn definiton

	public static final String xpdiscounticonclicking = "//img[@alt='Discount Definition']";
	public static final String idDiscountadd = "j_idt145";
	public static final String xpservicetype = "//*[@id='servType']";

	public static final String idDesc = "discName";
	public static final String idDesc1 = "shortDsc";
	public static final String idDesc2 = "detailDsc";

	// clicking date
	public static final String idvalidfrom = "validfrom";
	public static final String xpvalidfrom = "//select[@data-handler='selectMonth']";
	public static final String xpselectingdatedd = ".//html/body/div[15]/table/tbody/tr[2]/td[3]/a";

	// to date
	public static final String idvalidto = "validto";
	public static final String xpvalidto = "//select[@data-handler='selectMonth']";
	public static final String xpselectingdatedd1 = "/html/body/div[15]/table/tbody/tr[3]/td[3]/a";

	public static final String idallocationType = "allocationType";
	public static final String xpallocationtypea1 = "//span[@class='ui-button-icon-left ui-icon ui-c ui-icon ui-icon-arrowstop-1-e']";

	public static final String iddiscntType = "discntType";
	public static final String idddstatus = "ddstatus";
	public static final String iddiscVal = "discVal";

	// client details
	public static final String xpapplicatiosetup = "//a[@href='/obe/b2b/pages/admin/setup/appSetup.jsf']";
	public static final String iddisplayLbl = "displayLbl";
	public static final String idsearch = "searchBtn";
	public static final String xpeditoptions = "//span[@class='glyphicon glyphicon-pencil']";
	public static final String xpradiobuttons = "//span[@class='ui-radiobutton-icon ui-icon ui-icon-blank ui-c']";
	public static final String idclientdetailsaddnew = "j_idt229";
	public static final String idcompanyname = "companyName";
	public static final String idshortName = "shortName";
	public static final String idbusinessType = "businessType";
	public static final String idcompanyCode = "companyCode";
	public static final String idcompanyType = "companyType";

	public static final String xpmaincomany1 = "//button[@class='ui-autocomplete-dropdown ui-button ui-widget ui-state-default ui-corner-right ui-button-icon-only']";
	public static final String xpmaincomany2 = "//li[@data-item-label='ID Travel & Shipping Agencies LLC']";
	public static final String idEmail = "Email";

	public static final String idEmai2 = "Email1";
	public static final String idEmai3 = "Email2";
	public static final String idEmai4 = "Email3";
	public static final String idEmai5 = "Email4";
	public static final String ididaddress = "address";

	public static final String idphoneNo = "phoneNo";
	public static final String idzipcode = "zipcode";
	public static final String idcompanyCategory = "companyCategory";

	public static final String idFaxNo = "FaxNo";
	public static final String idtelexNo = "telexNo";
	public static final String idcreditLimitType = "creditLimitType";;

	public static final String idcreditFinalLimit = "creditFinalLimit";;
	public static final String idvisaFee = "visaFee";;
	public static final String idserviceFee = "serviceFee";;

	public static final String idadditionalCurrencyOne = "additionalCurrencyOne";;
	public static final String idadditionalCurrencyTwo = "additionalCurrencyTwo";;
	public static final String idadditionalCurrencyThree = "additionalCurrencyThree";;
	public static final String idadditionalCurrencyFour = "additionalCurrencyFour";;
	public static final String iddisplayCurrency = "displayCurrency";;

	// United Arab Emirates Dirham

	public static final String xpmanagement = "/html/body/div[7]/div/div/div[1]/div/div/form/div[4]/div/div[3]/h4";
	public static final String cccprofile = "//a[@href='/obe/b2b/pages/admin/management/customerProfile.jsf']";
	public static final String ccaddnew = "j_idt275";  

	public static final String idccsalutation = "idSalutation";
	public static final String idFirstName = "idFirstName";

	public static final String idMiddleName = "idMiddleName";
	public static final String idLastName = "idLastName";
	public static final String idSpecialRemark = "idSpecialRemark";

	public static final String idccdate = "idDOB";

	public static final String xpccdate11 = "//th[@class='switch']";
	
	public static final String xpccdate111 = "/html/body/div[25]/div[2]/table/thead/tr/th[1]/i";
	

	public static final String xpccdate12 = "/html/body/div[25]/div[2]/table/thead/tr/th[2]";

	public static final String xpccdate13 = "/html/body/div[25]/div[3]/table/thead/tr/th[2]";
	public static final String xpccdate14 = "/html/body/div[25]/div[1]/table/thead/tr[1]/th[1]/i";

	public static final String xpccdate15 = "/html/body/div[25]/div[3]/table/tbody/tr/td/span[6]";
	public static final String xpccdate16 = "/html/body/div[25]/div[2]/table/tbody/tr/td/span[6]";
	public static final String xpccdate17 = "/html/body/div[25]/div[1]/table/tbody/tr[3]/td[3]";

	public static final String idCountryCode = "idCountryCode";
	public static final String idPhoneNumber = "idPhoneNumber";

	public static final String idNation = "idNation";

	public static final String idcpairlinename = "tabmenu:ssrmenu:airLineName_input";

	public static final String idflyernumber = "tabmenu:ssrmenu:flyerNo";
	
	public static final String  idpassportnumberrr = "passportNo";
	
	public static final String  idpassportplaceofissue = "issuePlace";
	
	public static final String  idpassportissuedate = "issueDate";
	
	public static final String  xppassportissuedateselection = "/html/body/div[25]/div[1]/table/tbody/tr[1]/td[3]";
	
//expireDate	

public static final String  idpassportexpireDate = "expireDate";
	
	public static final String  xppassportexpireDateselection = "/html/body/div[26]/div[1]/table/tbody/tr[4]/td[4]";
	
	public static final String  idcontryHld = "contryHld";
	
	public static final String  xphotelphonenumber = "//input[@id='bookingSummary:phoneNumber1']";
	
	public static final String  idhotelsearch = "bookingSummary:j_idt503";
	
	public static final String  idapplyingdisocuntbutton = "bookingSummary:applyDiscount";
	
	public static final String   xpapplyingdiscountbutton = "//button[@id='bookingSummary:applyDiscount']";
	
	public static final String  idselectedhoteldiscounts = "bookingSummary:dicType";
	
	public static final String  idclikcingbookingbutton = "bookingSummary:discBkng";	
	public static final String  iddiscoutnpopup ="popup_ok";
	
	public static final String  xphtoelservicecharges = "/html/body/div[6]/div/div/div[2]/div[2]/div/form/div[2]/div/div[1]/table/tbody/tr[2]/td/div/div/div/table/tbody/tr/td[2]/table/tbody/tr[2]/td[3]/span[2]";
	
	public static final String  xpdiscount ="/html/body/div[6]/div/div/div[2]/div[2]/div/form/div[2]/div/div[1]/table/tbody/tr[2]/td/div/div/div/table/tbody/tr/td[2]/table/tbody/tr[2]/td[4]/div/span[2]";
	
	public static final String  xpscroolup ="/html/body/div[6]/div/div/div[2]/div[2]/div/form/div[2]/div/div[1]/table/tbody/tr[1]/td/table/tbody/tr[2]/td/table/tbody/tr[1]/td[3]/strong/b";
	
	
	
	//
	
	// provider configurations
	
	
	public static final String xpproviderconfig = "//img[@alt='Provider Configuration']";
	public static final String xpflightediticon = "//span[@class='glyphicon glyphicon-pencil']";	
	public static final String  xphoteleditopions="//a[@id='proList:1:view']";
	public static final String idsearch12 = "j_idt148";
	
	public static final String idsearchBtn12 = "searchBtn";
	
	public static final String xpclickhotel = "//a[@id='htl']";
	
	public static final String idsearch13 =  "j_idt120";
	public static final String idsearch14 ="j_idt117";
	

	//  Air service charge comparsions with flight bookings
	
	public static final String xplogout = "//button[@id='logoff']";
	
	public static final String searchhh =  "//a[@id='searchrequestform:j_idt421:0:cmdlink_id']";
	public static final String searchhh1 = "//a[@id='searchrequestform:j_idt418:2:cmdlink_id']";
	public static final String searchhh2 = "//a[@id='searchrequestform:j_idt418:3:cmdlink_id']";
	public static final String searchhh3 = "//a[@id='searchrequestform:j_idt418:4:cmdlink_id']";
	public static final String searchhh4 = "//a[@id='searchrequestform:j_idt421:0:cmdlink_id']";
	public static final String searchhh5 = "//a[@id='searchrequestform:j_idt421:1:cmdlink_id']";
	public static final String searchhh6 = "//a[@id='searchrequestform:j_idt421:2:cmdlink_id']";
	
	
	
	public static final String sssearch = "//a[@id='j_idt172']";
	public static final String sssearch1 = "//button[@id='searchBtn']";
	
	public static final String idpaxAdult = "serv_char_adult";
	public static final String idpaxchild = "serv_char_child";
	public static final String idpaxinfant = "serv_char_infant";
	public static final String xpServicechargecomparisionchild = "/html/body/div[6]/div/div/div[2]/div[2]/div/div[4]/div[3]/div/table/tbody/tr[2]/td[1]/div[2]/div/div/table/tbody/tr[4]/td[5]/div";
	
	public static final String xpdiscountcomparision = "/html/body/div[6]/div/div/div[2]/div[2]/div/div[4]/div[3]/div/table/tbody/tr[2]/td[1]/div[2]/div/div/table/tbody/tr[4]/td[5]";
	
	public static final String xpdiscountcomparisionforchild = "/html/body/div[6]/div/div/div[2]/div[2]/div/div[4]/div[3]/div/table/tbody/tr[2]/td[1]/div[2]/div/div/table/tbody/tr[5]/td[5]/div";
	
	public static final String xpcouponcodecomaprsions ="/html/body/div[6]/div/div/div[2]/div[2]/div/div[4]/div[3]/div/table/tbody/tr[2]/td[1]/div[2]/div/div/table/tbody/tr[5]/td[5]/div/div/span";
	public static final String clickingdiscountbutton = "//button[@id='applyDiscount']";
	
	public static final String iddiscountype = "dicType";
	public static final String iddiscountclikcing = "discBkng";
	public static final String iddispopup = "popup_ok";
	
	
	
	// Fowa1c1toa1
	
	public static final String xperrormessgae = "/html/body/div[6]/div/div/div[2]/div[2]/div/div[2]/div/span";
	//                                           html/body/div[6]/div/div/div[2]/div[2]/div/div[2]/div/ul/li/span[1]/text()
	//                                           /html/body/div[6]/div/div/div[2]/div[2]/div/div[2]/div/ul/li/span[1]
	//                                           html/body/div[6]/div/div/div[2]/div[2]/div/div[2]/div/span
	
	
	//user creations and  login 
	
	
	public static final String clicking  = "/html/body/div[6]/div/div/div[2]/div[2]/div/div[2]";
	
	public static final String localmailurl  = "https://webmail.infodynamic.in/#4";
	
	public static final String idlocalmailusername   ="username";
	
	public static final String idlocalmailpassword   ="password";
	
	public static final String xplocalmailsubmitbutton  ="//input[@class='ZLoginButton DwtButton']";
	
	public static final String identernametosearch  = "searchField";
	
	//                                                 searchField
	
	public static final String xpselectingmailid =  "/html/body/table/tbody/tr/td/table/tbody/tr[2]/td[2]/form/table/tbody/tr[2]/td/table/tbody/tr/td[1]/table[2]/tbody/tr/td[3]";
	
	public static final String idstandardhtml =  "client";
	
	public static final String xpdoubleclickingthepassword = "/html/body/div/div/p[3]/b";	
	public static final String copyingpassword ="html/body/div/div/p[3]/text()";
	
	//flightbookingwithAddnewpassengers
	
	public static final String idprofilesearch = "j_idt451";	
	public static final String phonesearch = "gs_CUST_COMM_VALUE";
	public static final String idselectedtheprofile = "jqg_grid_1";	
	public static final String idaddbookingbutton = "addtobooking";
	
	// Hoteldoubleroomsccc
	
	public static final String identerthedealcode = "deal_code";
	
	public static final String idclickingredeeembutton = "dealButton";
	
//Finance application Testing
	
	//Vocuher preparations : 
	
	public static final String vusername = "LoginCode";	
	public static final String vpassword = "Password";
	public static final String idvsubmit = "btnLoginButton";	
	public static final String idVOUCHERentry = "modVOUCHER";
	public static final String idaddbutton = "btnMainAdd";
	public static final String idvoucherpreparations ="pgmVOUT000010";
	public static final String xpenterthevouchertypedetails = "//input[@aria-owns='VoucherTemplate_listbox']";
	public static final String xpbussineessplace ="//input[@name='BusinessPlace_2_1_input']";
	public static final String xpsublocation ="//input[@name='SubLocation_3_1_input']";
	public static final String xpactivity = "//input[@name='TActivity_4_1_input']";
	public static final String xpactivitylocation = "//input[@name='ActivityLocation_5_1_input']";
	public static final String xpsubactivity = "//input[@name='SubActivity_6_1_input']";	
	public static final String edit1 = "/html/body/div[3]/div/div[1]/div[1]/div/div/div[2]/div[2]/form/div[3]/div/div[2]/button";
	public static final String edit2 = "//a[contains(@class,'k-button k-button-icontext k-grid-Edit')]";
	public static final String baseamount ="//input[@name='VoucherDetailDrBaseAmount']";
	
	public static final String Costcenter =  "//input[@name='CostCenter_0_input']";
	public static final String ARname1 = "//input[@name='ArARName_1_input']";
	public static final String Currency1 = "//input[@name='VoucherDetailCurrencyDesc_input']";
	
	
	public static final String Customername = "//input[@name='ARNAME_1_input']";
	public static final String xpAractivity = "//input[@name='ARActivity_2_input']";	
	public static final String  xppartybyaddress = "//button[@id='btnPartyAddress']";
	public static final String xpclickingokbutton = "//button[@id='btnAdd']";
	public static final String xpclickingaddbutton1 = "//button[@id='customVoucheradd']";
	public static final String  xpallocations = "//input[@name='VoucherDetailInfoDesc_input']";
	public static final String xpBaseaccountCT = "//input[@id='VoucherDetailCrBaseAmount']";
	public static final String xparactivity1 =  "//input[@name='ARINFO_ACTIVITY_3_input']";
	public static final String xpbranchactivity1 =  "input[@name='Branch_4_input']";
	public static final String xpbranchactivity2 = "//input[@aria-owns='Branch_4_listbox']";
	//
	public static final String XpadditionalAr =  "//input[@name='AddARName_4_input']";
	public static final String Clickingokbutton = "//button[@id='btnAdd']";
	public static final String clickingaddbutton1 = "//button[@id='customVoucheradd']";
	
	public static final String xpincomeGL = "//input[@name='IncomeGLAccount_1_input']";
	public static final String xpaddbutton = "//button[@id='btnAdd']";
	public static final String xptaxsavebut = "//button[@id='TaxSave']";
	public static final String idmainsave = "btnMainSave";
	public static final String xpclickingyesbutoon = "//button[@id='YesWarning']";
	public static final String xpclickokbuttononpopup = "//button/span[@class='ui-button-text']";
	public static final String gettingreferencenumber  =  "//span[contains(@id,'diaInfoMessage')]";
	public static final String gettingreferencenumber1 = "//button[contains(@class,'ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only')]";
	public static final String xpathclickingokbuttonfrompopup = "/html/body/div[4]/div[3]/div/button";
	public static final String okbytton ="//button[@id='YesWarning']";
	public static final String idvoucherentry = "modVOUCHER";
	public static final String idvoucherworkbench = "pgmVOUI000004";
	public static final String iddocumenttypee = "//input[@name='VouDocumentType_input']";
	public static final String idbuttonsearchhh = "btnSearch";
	public static final String xpclickingsearchbytton = "/html/body/div[3]/div/div[1]/div[1]/div/div/div[2]/div[2]/div[1]/div[3]/div/table/tbody/tr[1]/td[2]";
	public static final String xpdocnumber = "//input[@id='VoucherDocNumber']";
	public static final String xpdocumentnumber1 = "//span[@aria-controls='VouVoucherNumber_listbox']";
	public static final String xpdocumentnumber2 = "//*[@id='9c34ef92-f7d8-4205-bd35-41e2ccf21125']";
	public static final String xpdocumentnumber3 = "//input[@name='VouVoucherNumber_input']";
	public static final String xparnames1 = "//input[@name='ArARName_1_input']";
	public static final String xparnames11 =  "//input[@name='ARINFO_ACTIVITY_3_input']";
	public static final String xpadditionalar = "//input[@name='AddARName_4_input']";
	public static final String xpcurrencychanges = "//input[@name='VoucherDetailCurrencyDesc_input']";
	public static final String xpcapturingbalanclocalamount = "/html/body/div[3]/div/div[1]/div[1]/div/div/div[2]/div[2]/div[1]/div[3]/div/table/tbody/tr/td[26]";
	//public static final String xpcapturingbalancbaseamount = "/html/body/div[3]/div/div[1]/div[1]/div/div/div[2]/div[2]/div[1]/div[3]/div/table/tbody/tr/td[21]";	
	public static final String idARunmatching = "pgmARST000002";
	public static final String Xpcustomernameinput = "//input[@name='CustomerName_input']";
	public static final String xpunmatchdocumenttype = "//input[@name='DocumentTypeBaseDesc_input']";
	public static final String xpunmatchdocumentnumber = "//input[@name='DocumnetNumber_input']";
	public static final String xpadditionalarrinunmatching = "//input[@name='AdditionalCustomerName_input']";
	
	
	
	//Recepit Generations 
	
	public static final String idcashbankleftsidemenu = "modBANK";
	public static final String Customername1 = "//input[@name='CustomerName_input']";
	public static final String vouchertype1 = "//input[@name='VoucherTemplateName_input']";
	public static final String xpdoctype1 =  "//input[@name='VoucherDocType_input']";
	public static final String xpactivity1 ="//input[@name='SalesActivityName_input']";
	public static final String xpclickingsearchbutton1 = "//button[@id='Search']";
	public static final String idreceipetgenerations = "pgmARST000001";
	public static final String xpgridview = "//*[@id='ReceiptGenerationSearchGrid_active_cell']/a[1]";
	
	public static final String xpgridview1 = "/html/body/div[3]/div/div[1]/div[1]/div/div/div[2]/div[2]/form/div[2]/div/div[13]/div/table/thead/tr/th[5]/a[1]/span";
	public static final String xpdescending = "//*[@id='45119876-91dd-4f7b-98cf-9e02e2656a9b_mn_active']";
	public static final String xpclikcingcheckbox = "/html/body/div[3]/div/div[1]/div[1]/div/div/div[2]/div[2]/form/div[2]/div/div[13]/div/table/tbody/tr[1]/td[1]/input";
	//                                               //*[@id="ReceiptGenerationSearchGrid_active_cell"]
	public static final String xpclickingdocumentreferencenumber ="//*[@data-field='ArtDocumentNumber']";
	public static final String xpclickingsettlebutton = "//button[@id='customSettel']";
	public static final String xpclickingeditbutton2 =  "//a[@class='k-button k-button-icontext k-grid-Edit']";
	public static final String baseamount2 =  "//input[@id='VoucherDetailDrBaseAmount']";
	public static final String xpbankname="//input[@name='BankBankName_1_input']";
	public static final String xpchequebook = "//input[@id='ChequeNumber_2']";
	public static final String xpdates1 = "//input[@id='FINANCECHEQUEDATE_3']";
	public static final String xpreceivedfrom = "//input[@id='RECEIVEDFROM_5']";
	public static final String xpdateselection1111 = "//*[@id='d52113cd-87d1-4d9b-8d64-e738f46276be_cell_selected']/a";
	
	
	// payment generations
	
	public static final String idpaymentgenerationsleftsidemenu = "pgmAPST000001";	
	public static final String xpclickingcheckbox = "//input[contains(@name,'IsChecked')]";
	public static final String xpenterthevouchertype = "//input[contains(@name,'VoucherTemplateName_input')]";
	public static final String xppurchasetype = "//input[contains(@name,'PurchaseType_2_input')]";
	public static final String xpBussineeplace = "//input[contains(@name,'BusinessPlace_3_input')]";
	
	public static final String xpsublocation1 = "//input[contains(@name,'SubLocation_4_input')]";
	public static final String xpActivity1 = "//input[contains(@name,'TActivity_5_input')]";
	public static final String xpActivityLocation1 = "//input[contains(@name,'ActivityLocation_6_input')]";
	
	public static final String xpsubactivity1 = "//input[contains(@name,'SubActivity_7_input')]";	
	public static final String xpITCclassiications ="//input[contains(@name,'ITCClassification_10_input')]";
	
	public static final String xpNatureofbussiness = "//input[contains(@name,'NATUREOFBUSINESS_11_input')]";
	
	public static final String xpclickingeditbutton1  ="//a[@class='k-button k-button-icontext k-grid-Edit']";
	
	public static final String baseamount1 ="//input[@id='VoucherDetailCrBaseAmount']";
	
	public static final String bankname = "//input[@name='BankBankName_1_input']";
	
	public static final String chequenumber1 ="//input[@id='ChequeNumber_2']";
	
	public static final String xpDate1 = "//span[@aria-controls='FINANCECHEQUEDATE_3_dateview']";
	public static final String xpDate2 = "//a[@data-value='2020/1/26']";
	
	public static final String xppaymentmode = "//input[@name='PaymentMode_5_input']";
	
	public static final String xpclickingokbutton1 = "//button[@id='btnAdd']";
	
	public static final String clickingaddbutton= "//button[@id='customadd']";
	
	public static final String xpAllocations1 = "//input[@name='VoucherDetailInfoDesc_input']";
	
	public static final String amount2 = "//input[@id='VoucherDetailDrBaseAmount']";	
	public static final String Apname1 ="//input[@name='AP_INFO_APCODE_1_input']";
	
	public static final String APActivity1 = "//input[@name='APActivity_2_input']";
	public static final String APAddress1 = "//input[@name='ApAddress_3_input']";
	
	public static final String xpclickingpartyaddressdetails ="//button[@id='btnPartyAddress']";
	
	public static final String xpclickingokbutton2 = "//button[@id='btnAdd']";
	
	public static final String xptaxsave2 = "//button[@id='TaxSave']";
	
	public static final String xpclickingokbutton10 =  "//button[@id='YesWarning']";
	
	// FlightRoundtripA1C1sccc
	
	public static final String idvouchercode =  "voucher_code";
	
	public static final String idclickingvoucherbutton ="voucherButton";
	
	public static final String xpcouponcodecomapions ="voucherButton";
	public static final String iddealcode="deal_code";
	public static final String idclickingapplybutton ="searchrequestform:j_idt171";
	
	public static final String xpApname = "//input[@name='ApAPName_1_input']";
	public static final String xpAPactivity = "//input[@name='APINFO_ACTIVITY_2_input']";
	public static final String xpApbaseamount = "//input[@id='VoucherDetailCrBaseAmount']";
	
	public static final String xpApAllocations = "//input[@name='VoucherDetailInfoDesc_input']";
	
	public static final String xpApbaseamount1 =  "//input[@id='VoucherDetailDrBaseAmount']";
	
	
	public static final String xpApcostcenter =  "//input[@name='CostCenter_0_input']";
	
	public static final String xpApassetGL =  "//input[@name='AssetGL_1_input']";
	public static final String idPayemntgenerations = "pgmAPST000001";
	public static final String  Apvouchertype1 =  "//input[@name='VoucherTemplateName_input']";
	public static final String  baseamount3 = "//input[@name='VoucherDetailCrBaseAmount']";
	public static final String  costcenter3 = "//input[@name='CostCenter_0_input']";
	public static final String  bankanme2 = "//input[@name='BankBankName_1_input']";
	public static final String  xpcheckdate3 = "//input[@id='FINANCECHEQUEDATE_3']";
	
	public static final String  xpcheckquenumber = "//input[@id='ChequeNumber_2']";	
	public static final String  xpallocations4 = "//input[@name='VoucherDetailInfoDesc_input']";
	public static final String  xpbaseamount6 = "//input[@id='VoucherDetailDrBaseAmount']";
	
	public static final String  xpcostcenter5 = "//input[@id='VoucherDetailDrBaseAmount']";
	public static final String  xpApname4 = "//input[@name='ApAPName_1_input']";
	public static final String  xpApactivity6 = "//input[@name='APINFO_ACTIVITY_2_input']";
	
	
	
	
	
	
	
	//
	
	
	
	
	//finance Nagative scenarios
	
	
	public static final String  xpclickinggridvertical ="/html/body/div[3]/div/div[1]/div[1]/div/div/div[2]/div[2]/form/div[2]/div/div[13]/div/table/thead/tr/th[4]/a[1]/span";
	public static final String  xpclickingascendingicons ="//span[@class='k-icon k-i-sort-asc-sm']";
	public static final String  xpclickingdescdingicons = "//span[@class='k-icon k-i-sort-desc-sm']";
	public static final String  gettexttotextbox ="//*[@id='TotalTempAmount']";
	
	public static final String  xpverticalmatchedamount ="/html/body/div[3]/div/div[1]/div[1]/div/div/div[2]/div[2]/form/div[2]/div/div[13]/div/table/thead/tr/th[2]/a[1]";
	public static final String  xpascendingmatchedamount = "//span[@class='k-icon k-i-sort-asc-sm']";
	public static final String  xpdescdingiconsmatchedamount = "//span[@class='k-icon k-i-sort-desc-sm']";
	
	

	//Fimance bussiness scenarios
	
	public static final String  gridselections = "//a[@aria-label='Column Settings']";
	public static final String  findelements = "//button[@id='customadd1']";
	public static final String  chekbox1 ="chk1";
	public static final String  idclearbutton = "btnMainClear";
	
	public static final String  xpathtotalamount = "//*[@id='TotalTempAmount";
	
	public static final String  valuesending = "/html/body/div[3]/div/div[1]/div[1]/div/div/div[2]/div[2]/form/div[2]/div/div[13]/div/table/tbody/tr[1]/td[2]";
	public static final String  xporginalamount = "//a[@href='/FinanceHtpl/Finance/ReceiptGenerationUI/ReceiptGenerationSearch_Read?ReceiptGenerationSearchGrid-sort=ArtLocalAmount-asc']";
	
	
	//payment generations : 
	public static final String supplier ="//input[@name='CustomerName_input']";	
	public static final String Vouchertype = "//input[@name='VoucherTemplateName_input']";
	public static final String activity = "//input[@name='SalesActivityName_input']";	
	public static final String clickingorginalamounttabkleheader = "//a[@href='/FinanceHtpl/Finance/PaymentGeneration/ReceiptGenerationSearch_Read?ReceiptGenerationSearchGrid-sort=ArtLocalAmount-asc']";	
	public static final String currencyy ="//input[@aria-owns='VoucherDetailCurrencyDesc_listbox']";
	public static final String Accountreceivables = "//a[@id='modAR']";
	public static final String matching = "//a[@id='pgmARSI000001']";
	
	public static final String CustomerNameinput = "//input[@name='CustomerName_input']";
	public static final String SalesActivityNameinput = "//input[@name='SalesActivityName_input']";
	public static final String DocumentTypeDescinput = "//input[@name='DocumentTypeDesc_input']";
	public static final String Documentnumberinput = "//input[@name='DocumnetNumber_input']";
	public static final String searchbutton = "//button[@onclick='GetWorkBenchData();']";
	public static final String  currentamount = "//*[@id='CurrentAmount']";
	
	public static final String  currentamount1 = "/html/body/div[3]/div/div[1]/div[1]/div/div/div[2]/div[2]/div[1]/div/div[2]/table/tbody/tr[1]/td[5]";
	public static final String  currentamount2 =  "//*[@id='APMatchingUISearchGrid_active_cell']";
	
	public static final String  xpclickingreceiptsonly =  "//div[@class='col-sm-6 col-md-6 pad0']";
	public static final String  xpclickingsearchbutton  = "//button[@onclick='GetWorkBenchData();']";
	
	public static final String  xpcustoemrnameinput1  = "//input[@name='CustomerName_input']";
	public static final String xpdoctype = "//input[@name='DocumentTypeDesc_input']";
	public static final String xpclickingokbutton11 = "//span[@class='ui-button-text']";
	public static final String xpclickingokbutton111 = "/html/body/div[4]/div[3]/div/button/span";
	public static final String xpArcustomer = "//input[@name='CustomerName_input']";
	public static final String xpADoctype = "//input[@name='DocumentTypeDesc_input']";
	public static final String xpADocNumber = "//input[@name='DocumnetNumber_input']";
	public static final String xpADsearch =  "//button[@id='btnSearch']";
	public static final String xptablegridmatchingscreen = "//span[@class='k-icon k-i-more-vertical']";
	public static final String xpfilter = "//li[@class='k-item k-filter-item k-state-default k-last']";
	public static final String xpfilter1 = "//input[@title='Value']";
	public static final String xpfilterbutton = "//button[@class='k-button k-primary']";
	public static final String xpxheckboxclikcing = "//input[@id='chk1']";
	public static final String matchedbaseamountt = "//*[@id='APMatchingUISearchGrid_active_cell']";
	public static final String matchedamountfield = "/html/body/div[3]/div/div[1]/div[1]/div/div/div[2]/div[2]/div[1]/div/div[2]/table/tbody/tr/td[5]";
	public static final String matchedamountfield2 = "//input[@id='MatchedAmount']";
	public static final String CLCIKOKBUTTON = "html/body/div[4]/div[3]/div/button";
	public static final String CLCIKOKBUTTON1 = "/html/body/div[5]/div[3]/div/button";
	public static final String CLICKBUTTON2 ="/html/body/div[8]/div[3]/div/button/span";
	public static final String CLICKBUTTON2UNMATCHINGg = "/html/body/div[9]/div[3]/div/button" ;
	public static final String idArworkbench = "pgmARSI000007";
	public static final String xparworkbench = "//input[@name='ArDocumentType_input']";
	public static final String xpARDocumentnumber = "//input[@name='ArDocumentNumber_input']";
	
	
	
	
	//SAMSARA product
	
	public static final String SAMSARAURL = "http://sit.infodynamic.net/portal/";
	public static final String XPS1 = "//input[@name='j_username']";
	public static final String XPS2 = "//input[@id='password']";
	public static final String XPS3 = "//button[@id='submit']";
	public static final String XPS4 ="//a[@id='BKNG']";
	public static final String XPS5 ="//a[@id='BKNG-N']";
	public static final String XPS6 = "//select[@name='pcbhOfficeProfileKey']";
	public static final String XPS7 = "//select[@name='line']";
	
	public static final String XPS8 = "//input[@placeholder='Shipper Name']";
	public static final String XPS9 = "//input[@name='consigneeName']";
	
	public static final String XPS10 = "//input[@name='porecp']";
	public static final String XPS11 = "//input[@name='pol']";
	public static final String XPS12 = "//input[@name='pordis']";
	public static final String XPS13 = "//input[@name='pordel']";
	
	public static final String XPS14 = "//select[@name='vesVoy']";
	public static final String XPS15 = "//textarea[@name='cargoDesc']";
	public static final String XPS16 ="//input[@name='cargoWeight']";
	public static final String XPS17 ="//input[@name='grossVolume']";
	public static final String XPS18 = "//select[@name='grossVolumeKey']";
	public static final String XPS19 = "//select[@name='commodity']";
	public static final String XPS20 = "//select[@name='containerType']";
	
	public static final String XPS21 = "//input[@name='totalNoofContainers']";
	public static final String XPS22 = "//input[@ng-change='rateCount()']";
	public static final String XPS23 = "//input[@name='cargoGrossWeight']";
	
	
	public static final String XPS24 = "//select[@name='fgtTerm']";
	public static final String XPS25 = "//input[@name='mktPer']";
	public static final String XPS26 = "//input[@name='invParty']";
	public static final String XPS27 = "//input[@name='brokerPlan']";
	public static final String XPS28 = "//input[@name='incPartyAddress']";	
	public static final String XPS29 = "//input[@name='incPartyGstNo']";
	
	
	public static final String xps30 = "//input[@name='stufDate']";
	
	//public static final String xps31 = "//input[@name='stuffContact']";
	
	public static final String xps32 = "//input[@name='stuffContact']";
	public static final String xps33 = "//textarea[@name='locationAndAddress']";
	public static final String xps34 = "//input[@name='phoneL']";
	public static final String xps35 = "//textarea[@name='comments']";
	public static final String xps36 = "//input[@name='phoneM']";
	public static final String xps37 = "//input[@name='freeDay']";
	
	public static final String xps38 = "//select[@name='stuffingAccount']";  //Selection box
	
	public static final String xps39 = "//select[@name='railFreightPay']"; //Selction box	
	
	
	public static final String xps40 = "//button[@id='submit']";
	public static final String ids400 = "submit";
	public static final String XPs41 = "/html/body/div[7]/span[3]/strong";
	public static final String xps42 = "//button[@class='close']";
	public static final String xps43 = "//span[@id='userSettings']";
	public static final String xps44 ="//a[@href='logout']";
	public static final String xps45 = "//a[@id='BKNG-P']";
	public static final String xps46 = "//button[@id='submit']";
	public static final String xps47 ="//a[@id='forAccept']";
	public static final String  xps48 = "/html/body/div[3]/div/div/div[2]/div/form[2]/div/div/div[4]/table/tbody/tr[1]/td[16]/a[1]/i";	
	public static final String  xps49  ="//textarea[@name='comments']";
	public static final String  xps50  =  "//button[@value='Approve']";
	
	public static final String  xps51  =  "//a[@id='SI']";
	public static final String  xps52  =  "//a[@id='SI-N']";
	public static final String  xps53  = "//input[@id='brNo']";
	public static final String  xps54  =  "//button[@id='search']";
	

	public static final String  xps55  =  "//input[@id='shipperName']";
	public static final String  xps56  = "//input[@id='consigneeName']";
   public static final String  xps57  = "//input[@id='notifyName']";
   
   public static final String  xps58  = "//textarea[@id='shiprdet']";
   public static final String  xps59  = "//textarea[@id='consigndet']";
   public static final String  xps60  = "//textarea[@id='notifydet']";
	
   public static final String  xps61  = "//input[@id='shipperTelFax']";
   public static final String  xps62  = "//input[@id='consigneeTelFax']";
   public static final String  xps63  = "//input[@id='notifyTelFax']";
   
   
   public static final String  xps64  = "//input[@id='notifyName2']";
   public static final String  xps65  = "//textarea[@id='anotifydet']";
	
   public static final String  xps66  = "//textarea[@name='comments']";
   public static final String  xps67  = "//textarea[@name='packagecomments']";
   public static final String  xps68  = "//textarea[@name='cargoDesc']";
   public static final String  xps69 = "//div[@class='k-header k-grid-toolbar']";
   public static final String  xps70 = "/html/body/div[3]/div[1]/div/div[2]/div/div/div/form[3]/div[11]/div/div/div[4]/table/tbody/tr/td[1]/input";
   public static final String  xps700 ="//input[@onclick='checkItem(this)']";
   public static final String  xps71 = "//input[@name='cctContainerNumber']";
   public static final String  xps72 = "/html/body/div[3]/div[1]/div/div[2]/div/div/div/form[3]/div[11]/div/div/div[4]/table/tbody/tr/td[3]";
   public static final String  xps722 ="//input[@name='cctCustomsSeal']";
   public static final String  xps73 = "//input[@name='cctCustomerSeal']";
   public static final String  xps74 = "//span[@aria-label='Increase value']";   
   public static final String  xps75 = "//span[@aria-label='Increase value']";
   public static final String  xps755 ="/html/body/div[3]/div[1]/div/div[2]/div/div/div/form[3]/div[11]/div/div/div[4]/table/tbody/tr/td[6]";
   public static final String  xps76 = "//input[@role='listbox']";
   public static final String  xps766 ="/html/body/div[3]/div[1]/div/div[2]/div/div/div/form[3]/div[11]/div/div/div[4]/table/tbody/tr/td[7]";
   public static final String  xps7666 = "//span[@class='k-icon k-i-arrow-60-down']"; 
     
   public static final String  xps77 = "//span[@class='k-icon k-i-arrow-60-down']";
   public static final String  xps788 = "/html/body/div[3]/div[1]/div/div[2]/div/div/div/form[3]/div[11]/div/div/div[4]/table/tbody/tr/td[8]";
   public static final String  xps79 = "/html/body/div[3]/div[1]/div/div[2]/div/div/div/form[3]/div[11]/div/div/div[4]/table/tbody/tr/td[9]";
   public static final String  xps80 =  "//input[@name='cwdHsCode']";
   public static final String  xps81 = "/html/body/div[3]/div[1]/div/div[2]/div/div/div/form[3]/div[11]/div/div/div[4]/table/tbody/tr/td[10]";   
   public static final String  xps82 ="/html/body/div[3]/div[1]/div/div[2]/div/div/div/form[3]/div[11]/div/div/div[4]/table/tbody/tr/td[11]";
   
   public static final String  xps83 = "//select[@id='boardStatus']";
   
   public static final String  xps84  =  "//a[@id='SI-P']";
   public static final String  xps85  =  "/html/body/div[5]/span[3]/strong/text()";
   
   public static final String  xps86 = "/html/body/div[3]/div[1]/div[1]/div[2]/div/div/div/div[4]/table/tbody/tr[1]/td[15]/a[1]";
   public static final String  xps87 = "//textarea[@id='comments']";   
   public static final String  xps88 = "//button[@value='Proceed']";   
   public static final String  xps89 = "//a[@id='LL']";   
   public static final String  xps90 =  "//a[@id='LL-P']";
   public static final String  xps91 =   "/html/body/div[3]/div[1]/div/div[2]/div/div[1]/form[2]/div/div/div[4]/table/tbody/tr[1]/td[1]/input";
   public static final String  xps92 = "//button[@id='submit']";
   public static final String  xps93 = "//input[@id='pcbhBookingNo']";
   public static final String  xps94 = "//button[@class='btn btn-default btn-success big-btn submit']";
   public static final String  xps95 = "//button[@class='close']";
   public static final String  xps96 = "//a[@id='LL-S']";   
   public static final String  xps97 = "//input[@name='pcbhBookingNo']";
   
   public static final String  xps98 = "/html/body/div[3]/div/div[1]/div[2]/div/form[1]/div[6]/button";   
   public static final String  xps99 = "/html/body/div[3]/div/div[1]/div[2]/div/form[2]/div[1]/div/div[4]/table/tbody/tr/td[1]/input";
   public static final String  xps100 = "/html/body/div[3]/div/div[1]/div[2]/div/form[2]/div[2]/button";
   
   public static final String  xps101= "//a[@id='VGM']";
   public static final String  xps102 = "//a[@id='VGM-P']";
   public static final String  xps103 = "//select[@id='line']";
   public static final String  xps104 ="//span[@class='k-icon k-i-more-vertical']";
   public static final String  xps105 = "//li[@class='k-item k-filter-item k-state-default k-last']";
   public static final String  xps106 = "//input[@data-bind='value:filters[0].value']";
   public static final String  xps107 = "//*[@name='Filter']";
   public static final String  xps108 = "/html/body/div[3]/div/div/div[2]/form[2]/div[1]/div/div/div[4]/table/tbody/tr[1]/td[1]/input";
   public static final String  xps109 = "//button[@id='submit']";
   public static final String  xps110 =  "/html/body/div[3]/div/div/div[2]/form[2]/div[2]/button[1]";
   public static final String  xps111 = "//a[@id='VGM-S']";
   public static final String  xps112 = "/html/body/div[3]/div/div/div[2]/form[2]/div[1]/div/div/div[3]/table/tbody/tr[1]/td[1]/input";
   public static final String  xps113 = "/html/body/div[3]/div/div/div[2]/form[2]/div[2]/button[1]";
   
   
  //WASTA:
   
   public static final String  wastausername = "//input[@id='UserCode']";
   public static final String  wastapassword =  "//input[@id='Password']";
   public static final String SUBMIT =  "//input[@id='btnLoginButton']";
   public static final String XPATHCLICKINGCONTACTNAME  =  "//a[@class='landing_contact_name ng-binding']";
   
   public static final String XPuseicon = " //img[@id='userIconImg']";
   public static final String   xpathusername = "//span[@class='profileNameOverFlow ng-binding']";
   public static final String XPATHADDINGBUSSINEOTENTIAL = "//*[@id='mainController']/div[5]/div/div[1]/span[1]/i";
   public static final String xpathenterbpovalues = "//input[@id='angAutoComplete_Skill_value']";
   public static final String xpathbpocountry = "//input[@placeholder='Country']";
   
   public static final String xpbporemarks =  "//textarea[@title='Remarks']" ;
   public static final String  xpclickignthesavebutton = "//button[@type='submit']";
   public static final String  XPATHCREATECONTACT= "//i[@class='fa fa-book']";
   
   public static final String   xpathskiptheadd = "//a[@href='/WastaworldTest/ContactsEntry/ContactsEntry']";
   
   public static final String   xpathrelationship = "//span[@aria-owns='CustomerRelationshipType_listbox']";
   public static final String   xptitleselections =  "//span[@aria-owns='Title_listbox']";
   
   public static final String   xpfirstname =  "//input[@id='FirstName']";
   public static final String   xplastname =  "//input[@id='LastName']";
   public static final String   xpnickname = "//input[@id='NickName']";
   
   // Designation	Departement	Role	Companyname

   public static final String   xpDesignation = "//input[@name='Designation']";
   public static final String   xpDepartement = "//input[@name='FunctionalArea']";
   public static final String   xpRole = "//input[@name='Role']";
   public static final String   xpCompanyname1 = "//input[@name='CompanyName']";
   public static final String   xpotherCompanyname = "//input[@id='OtherCompanyName']";
   
   // Industry	city	state	country

   
   public static final String   xpIndustry = "//div[@id='Industry_chosen']";
   public static final String  xpindustry1 = "//*[@id='Industry_chosen']/div[2]/ul/li[2]";
   
   public static final String   xpcityy = "//input[@id='City']";
   
   public static final String   xpstate = "//input[@id='State']";
   
   public static final String   xpcountry = "//input[@id='Country']";
   
   public static final String   xpeducation = "//div[@id='Degree_chosen']";
   public static final String   xpeducation1 = "//*[@id='Degree_chosen']/div[2]/ul/li[5]";
   
   public static final String   XpLanugage ="//div[@id='Language_chosen']";
   public static final String   XpLanugage1 ="//div[@id='Language_chosen']/div[2]/ul/li[5]";
   
   //phonenumabe and emailid

   public static final String   xpphone = "//input[@id='phone']";
   public static final String   Xpphone1= "//div[@class='numberHolder']";
   public static final String   xpphone1 = "//input[@id='phone1']";
   public static final String   xpemailid = "//input[@id='EmailId']";
   public static final String   xpcompany1 = "//span[@aria-owns='GroupCompaniesName_listbox']";
   
   public static final String  XPSAVE = "//input[@value='Save']";   
   public static final String  xpaddingcontact = "//button[@class='btn btn-blue']";
   
   
	//23 / mar / 2020 
   
   public static final String  xpcontactname = "//a[@class='landing_contact_name ng-binding']";   
   public static final String  xpselectingcontactname  = "//*[@id='mainControllerHome']/div[2]/div/div/div[1]/div/div[1]/div[2]/div";
   public static final String  xpsendcontactname = "//input[@id='icon-right']";
   
   public static final String  xpwastagroupselecton   = "/html/body/div[38]/div[2]/div[1]/div[2]/div/div/div[1]/span[1]/i";   
   
    // shiplogix 
   
   public static final String  xpordertype    = "//span[@aria-owns='OrderType_listbox']";
   
   
   //Travlogix applications
   
   public static final String  Travelogixuitooltipvalidation  = "//div[@class='k-tooltip-content']";
   
}
