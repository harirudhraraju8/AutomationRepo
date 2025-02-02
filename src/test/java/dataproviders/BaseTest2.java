package dataproviders;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class BaseTest2 {
	
	@Test(dataProvider = "dp1")
	public void testLogi(String s) {
		System.out.println(s);
	}
	
	@DataProvider
	public String[] dp1() {
		
		String[] data=new String[] {
				"abcd", 
				"xyz",
				"pqr"
		};
		return data;
		
	}
	

}
