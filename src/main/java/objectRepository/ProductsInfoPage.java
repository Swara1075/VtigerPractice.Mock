package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsInfoPage {
	
	@FindBy(xpath = "//span[@class='lvtHeaderText']")
	private WebElement productHeader;
	
	public ProductsInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getProductHeader() {
		return productHeader;
	}

	//Business Library
	public String getHeader()
	{
		return productHeader.getText();
	}
}
