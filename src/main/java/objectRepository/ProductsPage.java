package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsPage {
	
	@FindBy(xpath = "//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement productsLookUpImg;
	
	public ProductsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getProductsLookUpImg() {
		return productsLookUpImg;
	}
	
	//Business Library
	public void clickOnProductsLookUpImg()
	{
		productsLookUpImg.click();
	}
	
}
