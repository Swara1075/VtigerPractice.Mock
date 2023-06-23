package genericUtilities;

import java.util.Date;
import java.util.Random;

public class JavaUtility {
	
	public int getRandomNumber()
	{
		Random ran=new Random();
		return ran.nextInt(1000);
	
	}
	
	public String getSystemDate()
	{
		Date d=new Date();
		return d.toString();
	}
	
	public String getSystemDateInformat()
	{
		Date d=new Date();
		String[] dArray = d.toString().split(" ");
		String date = dArray[2];
		String month = dArray[1];
		String year = dArray[5];
		String time = dArray[3].replace(":", "-");
		return date+" "+month+" "+year+" "+time;
		
	}
}
