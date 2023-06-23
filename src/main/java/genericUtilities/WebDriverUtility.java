package genericUtilities;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

public class WebDriverUtility {
	
	public void maximize(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	
	public void minimize(WebDriver driver)
	{
		driver.manage().window().minimize();
	}

	public void waitForPageLoad(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	
	public void waitForElement(WebDriver driver,WebElement element)
	{ 
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public void waitForElement(WebElement element,WebDriver driver)
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void handleDropDown(WebElement element,int index)
	{
		Select sel=new Select(element);
		sel.selectByIndex(index);
	}
	
	public void handleDropDown(WebElement element,String value)
	{
		Select sel=new Select(element);
		sel.selectByValue(value);
	}
	
	public void handleDropDown(String text,WebElement element)
	{
		Select sel=new Select(element);
		sel.selectByVisibleText(text);
	}
	
	public void mouseHoverAction(WebDriver driver,WebElement element)
	{
		Actions act=new Actions(driver);
		act.moveToElement(element).perform();
	}
	
	public void rightClickAction(WebDriver driver)
	{
		Actions act=new Actions(driver);
		act.contextClick().perform();
	}
	
	public void rightClickAction(WebDriver driver,WebElement element)
	{
		Actions act=new Actions(driver);
		act.contextClick(element).perform();
	}
	
	public void doubleClickAction(WebDriver driver)
	{
		Actions act=new Actions(driver);
		act.doubleClick().perform();
	}
	
	public void doubleClickAction(WebDriver driver,WebElement element)
	{
		Actions act=new Actions(driver);
		act.doubleClick(element).perform();
	}
	
	public void dragAndDrop(WebDriver driver,WebElement src,WebElement dst)
	{
		Actions act=new Actions(driver);
		act.dragAndDrop(src, dst).perform();
	}
	
	public void dragAndDrop(WebDriver driver,WebElement element,int x,int y)
	{
		Actions act=new Actions(driver);
		act.dragAndDropBy(element, x, y);
	}
	
	public void handleFrames(WebDriver driver,int index)
	{
		driver.switchTo().frame(index);
	}
	
	public void handleFrames(WebDriver driver,String nameOrId)
	{
		driver.switchTo().frame(nameOrId);
	}
	
	public void handleFrames(WebDriver driver,WebElement element)
	{
		driver.switchTo().frame(element);
	}
	
	
	public void switchToParentFrame(WebDriver driver)
	{
		driver.switchTo().parentFrame();
	}
	
	public void switchToDefaultFrame(WebDriver driver)
	{
		driver.switchTo().defaultContent();
	}
	
	public void acceptAlert(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	
	public void dismissAlert(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	
	public String getAlertText(WebDriver driver)
	{
		return driver.switchTo().alert().getText();
	}
	
	public String takeScreenShot(WebDriver driver,String screenShotName) throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot) driver; //Type Casting
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dst=new File(".\\ScreenShots\\"+screenShotName+".png");
		Files.copy(src, dst);
		
		return dst.getAbsolutePath(); //extent report
		
	}
	
	public void switchToWindow(WebDriver driver,String partialWindowTitle)
	{
		//step 1: get all window IDs
		Set<String> winIDs = driver.getWindowHandles();
		//step 2:navigate to each window
		for(String winID:winIDs)
		{
			//Step 3:get title of each window
			String actualTitle = driver.switchTo().window(winID).getTitle();
		
		//Step 4:Compare the title
		if(actualTitle.contains(partialWindowTitle))
		{
			break;
		}
	}}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
