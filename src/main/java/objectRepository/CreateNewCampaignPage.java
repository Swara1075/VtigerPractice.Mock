package objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtilities.WebDriverUtility;

public class CreateNewCampaignPage extends WebDriverUtility{
	
	@FindBy(name="campaignname")
	private WebElement campaignNameEdt;
	
	@FindBy(name="campaigntype")
	private WebElement campaignTypeDropDown;
	
	@FindBy(name="campaignstatus")
	private WebElement campaignStatusDropDown;
	
	@FindBy(xpath = "//img[@src='themes/softed/images/select.gif']")
	private WebElement productLookUpImg;
	
	@FindBy(name="search_text")
	private WebElement searchEdt;
	
	@FindBy(name="search")
	private WebElement searchBtn;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	public CreateNewCampaignPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getCampaignNameEdt() {
		return campaignNameEdt;
	}

	public WebElement getCampaignTypeDropDown() {
		return campaignTypeDropDown;
	}

	public WebElement getCampaignStatusDropDown() {
		return campaignStatusDropDown;
	}

	public WebElement getProductLookUpImg() {
		return productLookUpImg;
	}

	
	public WebElement getSearchEdt() {
		return searchEdt;
	}

	public WebElement getSearchBtn() {
		return searchBtn;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
    //Business Library
	public void createCampaign(String CAMPAIGNNAME,String TYPE,String STATUS,WebDriver driver,String PRODUCTNAME)
	{
		campaignNameEdt.sendKeys(CAMPAIGNNAME);
		handleDropDown(TYPE, campaignTypeDropDown);
		handleDropDown(STATUS, campaignStatusDropDown);
		productLookUpImg.click();
		switchToWindow(driver, "Products");
		searchEdt.sendKeys(PRODUCTNAME);
		searchBtn.click();
		driver.findElement(By.xpath("//a[.='"+PRODUCTNAME+"']")).click();
		switchToWindow(driver, "Campaigns");
		saveBtn.click();
	}
	
	public void createCampaign(String CAMPAIGNNAME,String STATUS)
	{
		campaignNameEdt.sendKeys(CAMPAIGNNAME);
		handleDropDown(STATUS, campaignStatusDropDown);
		saveBtn.click();
	}
}
