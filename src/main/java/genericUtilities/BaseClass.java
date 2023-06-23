package genericUtilities;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;
import objectRepository.HomePage;
import objectRepository.LoginPage;


public class BaseClass {
	
	public PropertyFileUtility pUtil=new PropertyFileUtility();
	public ExcelFileUtility eUtil=new ExcelFileUtility();
	public WebDriverUtility wUtil=new WebDriverUtility();
	
	public WebDriver driver=null;
	public static WebDriver sDriver;
	
	@BeforeSuite(groups={"SmokeSuite","RegressionSuite"})
	public void bs()
	{
		System.out.println("=====DB Connected Successfully=====");
	}
	
	//@Parameters("BROWSER")
	//@BeforeTest
	@BeforeClass(alwaysRun=true)
	public void bc(/*String BROWSER*/) throws IOException
	{
		String BROWSER = pUtil.readDataFromPropertyFile("browser");
		String URL = pUtil.readDataFromPropertyFile("url");
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			System.out.println("=====Chrome Launched Successfully=====");
		}
		else if(BROWSER.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			System.out.println("=====Firefox Launched Successfully=====");
		}
		else
		{
			System.out.println("Invalid Browser Name");
		}
		sDriver=driver;
		wUtil.maximize(driver);
		wUtil.waitForPageLoad(driver);
		driver.get(URL);
		}
	
	@BeforeMethod(groups={"SmokeSuite","RegressionSuite"})
	public void bm() throws IOException
	{
		LoginPage lp=new LoginPage(driver);
		String USERNAME = pUtil.readDataFromPropertyFile("username");
		String PASSWORD = pUtil.readDataFromPropertyFile("password");
		lp.loginToApp(USERNAME, PASSWORD);
		System.out.println("=====Login Successfully=====");
	}
	
	@AfterMethod(groups={"SmokeSuite","RegressionSuite"})
	public void am()
	{
		HomePage hp=new HomePage(driver);
		hp.logoutApp(driver);
		System.out.println("=====Logout Successfully=====");
		
	}
	
	//@AfterTest
	@AfterClass(groups={"SmokeSuite","RegressionSuite"})
	public void ac()
	{
		driver.quit();
		System.out.println("=====Browser closed successfully=====");
	}
	
	@AfterSuite(groups={"SmokeSuite","RegressionSuite"})
	public void as()
	{
		System.out.println("=====DB Closed Successfully=====");
	}

}
