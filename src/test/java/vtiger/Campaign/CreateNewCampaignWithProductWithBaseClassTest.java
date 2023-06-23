package vtiger.Campaign;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Test;
import genericUtilities.BaseClass;
import objectRepository.CampaignInfoPage;
import objectRepository.CampaingsPage;
import objectRepository.CreateNewCampaignPage;
import objectRepository.CreateNewProductPage;
import objectRepository.HomePage;

import objectRepository.ProductsInfoPage;
import objectRepository.ProductsPage;

public class CreateNewCampaignWithProductWithBaseClassTest extends BaseClass{
	@Test(groups={"SmokeSuite","RegressionSuite"})
	public void createCamapignWithProduct() throws EncryptedDocumentException, IOException
	{
		
	String PRODUCTNAME = eUtil.readDataFromExcelFile("Product", 1, 2);
	String GLACCOUNT = eUtil.readDataFromExcelFile("Product", 1, 3);
	
	String CAMPAIGNNAME = eUtil.readDataFromExcelFile("Campaign", 1, 2);
	String TYPE = eUtil.readDataFromExcelFile("Campaign", 1, 3);
	String STATUS = eUtil.readDataFromExcelFile("Campaign", 1, 4);
	
	HomePage hp=new HomePage(driver);
	hp.clickOnProducts();
	System.out.println("clicked on products link");
	
	ProductsPage pp=new ProductsPage(driver);
	pp.clickOnProductsLookUpImg();
	System.out.println("clicked on look up image");
	
	CreateNewProductPage cnpp=new CreateNewProductPage(driver);
	cnpp.createProductWithDateAndGLAccount(PRODUCTNAME, GLACCOUNT);
	System.out.println("product created");
	
	ProductsInfoPage pip=new ProductsInfoPage(driver);
	String PRODUCTHEADER = pip.getHeader();
	Assert.assertTrue(PRODUCTHEADER.contains(PRODUCTNAME));
	System.out.println(PRODUCTHEADER);
	
	hp.clickOnCampaign(driver);
	System.out.println("clicked on campaign link");
	
	CampaingsPage cp=new CampaingsPage(driver);
	cp.clickOnCampaignLookUpImg();
	System.out.println("clicked on look up image");
	
	CreateNewCampaignPage cncp=new CreateNewCampaignPage(driver);
	cncp.createCampaign(CAMPAIGNNAME, TYPE, STATUS, driver, PRODUCTNAME);
	System.out.println("Campaign created successfully");
	
	CampaignInfoPage cip=new CampaignInfoPage(driver);
	String CAMPAIGNHEADER = cip.getHeaderText();
	Assert.assertTrue(CAMPAIGNHEADER.contains(CAMPAIGNNAME));
	System.out.println(CAMPAIGNHEADER);

}}
