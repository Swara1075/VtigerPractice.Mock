package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtilities.WebDriverUtility;

public class CreateNewProductPage extends WebDriverUtility {
	

	@FindBy(name="productname")
	private WebElement productnameEdt;
	
	@FindBy(xpath = "//img[@src='themes/softed/images/btnL3Calendar.gif' and @id='jscal_trigger_sales_start_date']")
	private WebElement salesStartDateImg;
	
	@FindBy(xpath = "//*[.='June, 2023']/ancestor::div[@style='position: absolute; display: block; left: 572px; top: 367px;']/descendant::tbody/descendant::td[.='29']")
	private WebElement salesStartDate;
	
	@FindBy(xpath = "//img[@src='themes/softed/images/btnL3Calendar.gif' and @id='jscal_trigger_sales_end_date']")
    private WebElement salesEndDateImg;
	
	@FindBy(xpath = "//td[.='June, 2023']/ancestor::div[@style='position: absolute; display: block; left: 572px; top: 458px;']/descendant::tbody/descendant::td[.='30']")
	private WebElement salesEndDate;
	
	@FindBy(name="glacct")
	private WebElement glAccountDropDown;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	public CreateNewProductPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getProductnameEdt() {
		return productnameEdt;
	}

	public WebElement getSalesStartDateImg() {
		return salesStartDateImg;
	}

	public WebElement getSalesStartDate() {
		return salesStartDate;
	}

	public WebElement getSalesEndDateImg() {
		return salesEndDateImg;
	}

	public WebElement getSalesEndDate() {
		return salesEndDate;
	}

	public WebElement getGlAccountDropDown() {
		return glAccountDropDown;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	//Business Library
	public void createProduct(String PRODUCTNAME)
	{
		productnameEdt.sendKeys(PRODUCTNAME);
		saveBtn.click();
	}
	
	public void createProductWithDateAndGLAccount(String PRODUCTNAME,String OPTION)
	{
		productnameEdt.sendKeys(PRODUCTNAME);
		handleDropDown(OPTION, glAccountDropDown);
		saveBtn.click();
		
	}
}
