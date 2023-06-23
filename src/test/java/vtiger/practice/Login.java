package vtiger.practice;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import genericUtilities.JavaUtility;
import genericUtilities.PropertyFileUtility;
import genericUtilities.WebDriverUtility;
import io.github.bonigarcia.wdm.WebDriverManager;
import objectRepository.LoginPage;

public class Login {
	
	@Test
	public void login() throws IOException
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		WebDriverUtility wUtil=new WebDriverUtility();
		JavaUtility jUtil=new JavaUtility();
		wUtil.maximize(driver);
		PropertyFileUtility pUtil=new PropertyFileUtility();
		String USERNAME = pUtil.readDataFromPropertyFile("username");
		String PASSWORD = pUtil.readDataFromPropertyFile("password");
		String URL = pUtil.readDataFromPropertyFile("url");
		LoginPage lp=new LoginPage(driver);
		driver.get(URL);
		lp.loginToApp(USERNAME, PASSWORD);
		System.out.println(jUtil.getSystemDate());
		System.out.println(jUtil.getSystemDateInformat());
	}

}
