package vtiger.Campaign;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import genericUtilities.ExcelFileUtility;
import genericUtilities.PropertyFileUtility;
import genericUtilities.WebDriverUtility;
import io.github.bonigarcia.wdm.WebDriverManager;
import objectRepository.CampaignInfoPage;
import objectRepository.CampaingsPage;
import objectRepository.CreateNewCampaignPage;
import objectRepository.CreateNewProductPage;
import objectRepository.HomePage;
import objectRepository.LoginPage;
import objectRepository.ProductsInfoPage;
import objectRepository.ProductsPage;

public class CreateNewCampaignWithProductTest {
	
	@Test
	public void createCampaignWithproduct() throws IOException
	{
	
	WebDriver driver=null;
	PropertyFileUtility pUtil=new PropertyFileUtility();
	ExcelFileUtility eUtil=new ExcelFileUtility();
	WebDriverUtility wUtil=new WebDriverUtility();
	
	String BROWSER = pUtil.readDataFromPropertyFile("browser");
	String URL = pUtil.readDataFromPropertyFile("url");
	String USERNAME = pUtil.readDataFromPropertyFile("username");
	String PASSWORD = pUtil.readDataFromPropertyFile("password");
	
	String PRODUCTNAME = eUtil.readDataFromExcelFile("Product", 1, 2);
	String GLACCOUNT = eUtil.readDataFromExcelFile("Product", 1, 3);
	
	String CAMPAIGNNAME = eUtil.readDataFromExcelFile("Campaign", 1, 2);
	String TYPE = eUtil.readDataFromExcelFile("Campaign", 1, 3);
	String STATUS = eUtil.readDataFromExcelFile("Campaign", 1, 4);
	
	
	if(BROWSER.equalsIgnoreCase("chrome"))
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		System.out.println("Chrome Launched");
	}
	else if(BROWSER.equalsIgnoreCase("firefox"))
	{
		WebDriverManager.firefoxdriver().setup();
		driver=new FirefoxDriver();
		System.out.println("Firefox Launched");
	}
	else
	{
		System.out.println("Invalid Browser Name");
	}
	wUtil.maximize(driver);
	wUtil.waitForPageLoad(driver);
	driver.get(URL);
	
	LoginPage lp=new LoginPage(driver);
	lp.loginToApp(USERNAME, PASSWORD);
	System.out.println("Login successfully");
	
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
	
	hp.logoutApp(driver);
    driver.close();
	
	
	
	}
}
