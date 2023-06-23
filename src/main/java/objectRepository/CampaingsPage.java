package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampaingsPage {
	
	@FindBy(xpath = "//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement campaignLookUpImg;
	
	public CampaingsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getCampaignLookUpImag() {
		return campaignLookUpImg;
	}

	//Business Library
	public void clickOnCampaignLookUpImg()
	{
		campaignLookUpImg.click();
	}
}
