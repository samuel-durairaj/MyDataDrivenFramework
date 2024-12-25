package com.myapp.dataprovider;

import org.testng.annotations.DataProvider;

import com.myapp.utility.NewExcelLibrary;

public class DataProviders {

	NewExcelLibrary obj = new NewExcelLibrary();
	
	@DataProvider(name="credentials")
	public Object[][] getCredentials(){
		//Total row count-"Credentials" is the worksheet name
		int rowCount = (obj.getRowCount("Credentials"))-1;
		//Total column count-"Credentials" is the worksheet name
		int colCount = obj.getColumnCount("Credentials");
		
		Object[][] data = new Object[rowCount][colCount];
		
		for(int i=0;i<rowCount;i++) {
			for(int j=0;j<colCount;j++) {
				data[i][j] = obj.getCellData("Credentials", j, i+2);
			}
		}
		return data;
	}
	
	@DataProvider(name="accountCreation")
	public Object[][] createAccount(){
		//Total Row Count-Email
		int rowCount = (obj.getRowCount("Email"))-1;
		//Total column count
		int colCount = obj.getColumnCount("Email");
		
		Object[][] data = new Object[rowCount][colCount];
		
		for(int i=0;i<rowCount;i++) {
			for(int j=0;j<colCount;j++) {
				data[i][j] = obj.getCellData("Email", j, i+2);
			}
		}
		return data;
	}
}
