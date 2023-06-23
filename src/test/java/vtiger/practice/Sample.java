package vtiger.practice;

import java.io.IOException;

import genericUtilities.ExcelFileUtility;
import genericUtilities.PropertyFileUtility;

public class Sample {

	public static void main(String[] args) throws IOException {
		
		PropertyFileUtility pUtil=new PropertyFileUtility();
		String BROWSER = pUtil.readDataFromPropertyFile("browser");
		System.out.println(BROWSER);
		
		ExcelFileUtility eUtil=new ExcelFileUtility();
		String campaignName = eUtil.readDataFromExcelFile("Campaign", 1, 2);
		System.out.println(campaignName);
		
		eUtil.writeDataIntoExcelFile("Sample", 3, 3, "Hello");
		System.out.println("Data Written");
	}
}
