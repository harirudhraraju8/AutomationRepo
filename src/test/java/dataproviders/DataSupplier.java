package dataproviders;

import org.testng.annotations.DataProvider;

public class DataSupplier {
	
	@DataProvider()
	public Object[][] loginData() {
		Object[][] data = new Object[2][2];

		data[0][0] = "Admin";
		data[0][1] = "admin123";

		data[1][0] = "Admin";
		data[1][1] = "test123";
		
		return data;
	}

	
	
	

}
