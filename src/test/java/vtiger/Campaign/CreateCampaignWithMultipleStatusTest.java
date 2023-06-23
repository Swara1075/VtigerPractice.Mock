package vtiger.Campaign;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;



import genericUtilities.ExcelFileUtility;
import genericUtilities.PropertyFileUtility;
import genericUtilities.WebDriverUtility;
import io.github.bonigarcia.wdm.WebDriverManager;
import objectRepository.CampaignInfoPage;
import objectRepository.CampaingsPage;
import objectRepository.CreateNewCampaignPage;
import objectRepository.HomePage;
import objectRepository.LoginPage;

@Listeners(genericUtilities.ListenersImplementation.class)
public class CreateCampaignWithMultipleStatusTest {
	
	WebDriver driver=null;
	PropertyFileUtility pUtil=new PropertyFileUtility();
	ExcelFileUtility eUtil=new ExcelFileUtility();
	WebDriverUtility wUtil=new WebDriverUtility();
	
	@Test(dataProvider="getdata")
	public void createCampaignWithMultipleStaus(String CAMPAIGNNAME,String STATUS ) throws IOException
	{
		String BROWSER = pUtil.readDataFromPropertyFile("browser");
		String URL = pUtil.readDataFromPropertyFile("url");
		String USERNAME = pUtil.readDataFromPropertyFile("username");
		String PASSWORD = pUtil.readDataFromPropertyFile("password");
		
//		String CAMPAIGNNAME = eUtil.readDataFromExcelFile("DataProvider", 1, 0);
//		String STATUS = eUtil.readDataFromExcelFile("DataProvider", 1, 1);
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
		
		hp.clickOnCampaign(driver);
		System.out.println("clicked on campaign link");
		
		CampaingsPage cp=new CampaingsPage(driver);
		cp.clickOnCampaignLookUpImg();
		System.out.println("clicked on look up image");
		
		CreateNewCampaignPage cncp=new CreateNewCampaignPage(driver);
		cncp.createCampaign(CAMPAIGNNAME, STATUS);
		System.out.println("Campaign created successfully");
		
		CampaignInfoPage cip=new CampaignInfoPage(driver);
		String CAMPAIGNHEADER = cip.getHeaderText();
		Assert.assertTrue(CAMPAIGNHEADER.contains(CAMPAIGNNAME));
		System.out.println(CAMPAIGNHEADER);
		
		hp.logoutApp(driver);
	   driver.close();
	} 
	@DataProvider
	public Object[][] getdata() throws EncryptedDocumentException, IOException
	{
		return eUtil.readMultipleDataFromExcel("DataProvider");
	}
		
	}


