package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtilities.WebDriverUtility;

public class HomePage extends WebDriverUtility{
	
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement adminImg;
	
	@FindBy(linkText = "Sign Out")
	private WebElement signoutLink;
	
	@FindBy(linkText = "Products")
	private WebElement productsLink;
	
	@FindBy(linkText = "More")
	private WebElement moreLink;
	
	@FindBy(linkText = "Campaigns")
	private WebElement campaignsLink;
	
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

	public WebElement getAdminImg() {
		return adminImg;
	}

	public WebElement getSignoutLink() {
		return signoutLink;
	}

	public WebElement getProductsLink() {
		return productsLink;
	}

	public WebElement getMoreLink() {
		return moreLink;
	}

	public WebElement getCampaignsLink() {
		return campaignsLink;
	}
	
	//Business Library
	
	public void logoutApp(WebDriver driver)
	{
		mouseHoverAction(driver, adminImg);
		signoutLink.click();
	}
	
	public void clickOnProducts()
	{
		productsLink.click();
	}

	public void clickOnCampaign(WebDriver driver)
	{
		mouseHoverAction(driver, moreLink);
		campaignsLink.click();
	}
}
