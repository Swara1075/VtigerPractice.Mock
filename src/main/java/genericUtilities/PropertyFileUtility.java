package genericUtilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyFileUtility {
	
	public String readDataFromPropertyFile(String key) throws IOException
	{
		FileInputStream fis=new FileInputStream(IConstantsUtility.propertyFilePath);
		Properties pObj=new Properties();
		pObj.load(fis);
		return pObj.getProperty(key);
	}

}
