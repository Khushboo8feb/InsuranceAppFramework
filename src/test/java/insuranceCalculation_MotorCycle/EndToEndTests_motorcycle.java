package insuranceCalculation_MotorCycle;

import java.io.IOException;
import java.util.HashMap;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import reusableComponents.ExcelOperations;
import testBase.TestBase;

public class EndToEndTests_motorcycle extends TestBase{
	ExcelOperations excel = new ExcelOperations("InsurancePremium");
	@Test(dataProvider = "vehData")
	public void insuranceCalculate(Object obj1) throws Exception
	{
		HashMap<String, String> testData = (HashMap<String, String>) obj1;
		System.out.println("Test data is:  " +testData);
		//test.log(Status.INFO, "Test Data is used for execution is:  "+testData);
		  homepage.clickMotorCycleLink(); 
		  vehicleData.enterVehicleData(testData);
		  vehicleData.clickOnNextButton(); 
		  InsurantData.enterInsuranceData(testData);
		  InsurantData.clickOnNextButton(); 
		  ProductData.enterProductData(testData);
		  ProductData.clickOnNextButton(); 
		  //String expectedPrice = "230.00"; 
		  //String actualPrice = priceOption.getPriceforSelectedOption("Silver");
		  
		  Assert.assertEquals(priceOption.getPriceforSelectedOption("Silver"), testData.get("PriceValidation_Silver"));
		  Assert.assertEquals(priceOption.getPriceforSelectedOption("Gold"), testData.get("PriceValidation_Gold"));
		  Assert.assertEquals(priceOption.getPriceforSelectedOption("Platinum"), testData.get("PriceValidation_Platinum"));
		  Assert.assertEquals(priceOption.getPriceforSelectedOption("Ultimate"), testData.get("PriceValidation_Ultimate"));

		  priceOption.selectPriceOption(testData.get("SelectOption")); 
		  priceOption.clickOnNextButton();
		 
	
	}
	
	//DataProvider method ---> return Object array
	@DataProvider(name = "vehData")
	public Object[][] testDataSupplier() throws EncryptedDocumentException, IOException
	{
		Object[][] obj = new Object[excel.getRowCount()][1];
		for(int i =1; i<=excel.getRowCount(); i++)
		{
			HashMap<String, String> testData = excel.getTestDataInMap(i);
			obj[i-1][0] = testData;
		}
		
		return obj;
		
	}
	

}
