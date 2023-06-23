package vtiger.Products;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Test;

import genericUtilities.BaseClass;
import objectRepository.CreateNewProductPage;
import objectRepository.HomePage;
import objectRepository.ProductsInfoPage;
import objectRepository.ProductsPage;

public class CreateNewProductWithBaseClassTest extends BaseClass{
	
	@Test(groups={"SmokeSuite","RegressionSuite"})
	public void createProduct() throws EncryptedDocumentException, IOException
	{
		String PRODUCTNAME = eUtil.readDataFromExcelFile("Product", 1, 2);
		String GLACCOUNT = eUtil.readDataFromExcelFile("Product", 1, 3);
		
		HomePage hp=new HomePage(driver);
		hp.clickOnProducts();
		System.out.println("Clicked");
		
		ProductsPage pp=new ProductsPage(driver);
		pp.clickOnProductsLookUpImg();
		System.out.println("clicked");
		
		CreateNewProductPage cnpp=new CreateNewProductPage(driver);
		cnpp.createProductWithDateAndGLAccount(PRODUCTNAME, GLACCOUNT);
		System.out.println("created");
		
		ProductsInfoPage pip=new ProductsInfoPage(driver);
		String PRODUCTHEADER = pip.getHeader();
		Assert.assertTrue(PRODUCTHEADER.contains(PRODUCTNAME));
		System.out.println(PRODUCTHEADER);
		
	}

}
