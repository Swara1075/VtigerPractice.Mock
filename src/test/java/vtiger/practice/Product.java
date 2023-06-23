package vtiger.practice;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import genericUtilities.ExcelFileUtility;
import genericUtilities.PropertyFileUtility;
import genericUtilities.WebDriverUtility;
import io.github.bonigarcia.wdm.WebDriverManager;
import objectRepository.CreateNewProductPage;
import objectRepository.HomePage;
import objectRepository.LoginPage;
import objectRepository.ProductsInfoPage;
import objectRepository.ProductsPage;

public class Product {
	
	@Test
	public void createProduct() throws IOException
	{
		WebDriverUtility wUtil=new WebDriverUtility();
		PropertyFileUtility pUtil=new PropertyFileUtility();
		ExcelFileUtility eUtil=new ExcelFileUtility();
		String USERNAME = pUtil.readDataFromPropertyFile("username");
		String PASSWORD = pUtil.readDataFromPropertyFile("password");
		String URL = pUtil.readDataFromPropertyFile("url");
		String PRODUCTNAME = eUtil.readDataFromExcelFile("Product", 1, 2);
		String GLACCOUNT = eUtil.readDataFromExcelFile("Product", 1, 3);
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		wUtil.maximize(driver);
		wUtil.waitForPageLoad(driver);
		driver.get(URL);
		
		LoginPage lp=new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);
		
		HomePage hp=new HomePage(driver);
		hp.clickOnProducts();
		
		ProductsPage pp=new ProductsPage(driver);
		pp.clickOnProductsLookUpImg();
		
		CreateNewProductPage cnpp=new CreateNewProductPage(driver);
		cnpp.createProductWithDateAndGLAccount(PRODUCTNAME, GLACCOUNT);
		
		ProductsInfoPage pio=new ProductsInfoPage(driver);
		String productHeader = pio.getHeader();
		Assert.assertTrue(productHeader.contains(PRODUCTNAME));
		
		hp.logoutApp(driver);
		System.out.println("Logout Successful");
		driver.close();
	}

}
