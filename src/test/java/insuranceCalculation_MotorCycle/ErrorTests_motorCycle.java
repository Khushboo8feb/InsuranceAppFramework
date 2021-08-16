package insuranceCalculation_MotorCycle;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import testBase.TestBase;

public class ErrorTests_motorCycle extends TestBase {
	
	@Test(enabled=false)
	public void errorMessageOnCylinderCapacity() throws IOException
	{
		homepage.clickMotorCycleLink();
		vehicleData.enterCylinderCapacity("3000");
		test.log(Status.PASS, "Cylinder Capacity is filled with Data:  3000");
		String actualErrorMessage  = vehicleData.getErrorMessageOnCylinderCapacity();
		String expectedErrorMessage = "Must be a number between 1 and 2000";
		Assert.assertEquals(actualErrorMessage, expectedErrorMessage);
	
	}
	@Test(enabled=false)
	public void errorMessageOnCylinderCapacity1() throws IOException
	{
		homepage.clickMotorCycleLink();
		vehicleData.enterCylinderCapacity("3000");
		test.log(Status.PASS, "Cylinder Capacity is filled with Data:  3000");
		String actualErrorMessage  = vehicleData.getErrorMessageOnCylinderCapacity();
		String expectedErrorMessage = "Must be a number between 1 and 3000";
		Assert.assertEquals(actualErrorMessage, expectedErrorMessage);
	
	}
	
	@Test(enabled=true)
	public void verifyModelDropdownOptions()
	{
		homepage.clickMotorCycleLink();
		//get the actual Model dropdown list 
		List<String> actualList = vehicleData.getModelDropdownOptionsList();
		test.log(Status.INFO, "Actual dropdown list for Model dropdown is: " +actualList);
		//get expected list for Model dropdown
		List<String> expectedList = Arrays.asList("– please select –","Scooter","Three-Wheeler","Moped","Motorcycle");
		test.log(Status.INFO, "Expected dropdown list for Model dropdown is: " +expectedList);
		//compare the actual list to expected model dropdown list
		
		Assert.assertEquals(actualList, expectedList, "Values mismatched in Model drop down");
		
	}

}
