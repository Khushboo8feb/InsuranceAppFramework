package pageObjects;

import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import testBase.TestBase;

public class VehicleDataPageObjects extends TestBase {
	
	public VehicleDataPageObjects()
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "make")
	WebElement dd_Make;
	
	@FindBy(id = "model")
	WebElement dd_Model;
	
	
	@FindBy(id = "cylindercapacity")
	WebElement txt_Cylindercapacity;
	
	@FindBy(xpath = "//input[@id = 'cylindercapacity']/following-sibling::span[@class = 'error']")
	WebElement error_CylinderCapacity;
	
	@FindBy(id = "engineperformance")
	WebElement txt_Engineperformance;
	
	@FindBy(id = "dateofmanufacture")
	WebElement date_Dateofmanufacture;
	
	@FindBy(id = "numberofseatsmotorcycle")
	WebElement dd_Numberofseatsmotorcycle;
	
	@FindBy(id = "listprice")
	WebElement txt_Listprice;
	
	@FindBy(id = "annualmileage")
	WebElement txt_Annualmileage;
	
	@FindBy(id = "nextenterinsurantdata")
	WebElement btn_Nextenterinsurantdata;
	
	public void enterCylinderCapacity(String cylinderCapacity)
	{
		txt_Cylindercapacity.sendKeys(cylinderCapacity);
	}
	
	public String getErrorMessageOnCylinderCapacity()
	{
		return error_CylinderCapacity.getText();
	}
	
	public List<String> getModelDropdownOptionsList()
	{
		return cm.getDropdownOptionsAsList(dd_Model);
	}
	
	public void enterVehicleData(HashMap<String, String> testData) throws Exception
	{
		cm.selectDropdownOption(dd_Make, testData.get("Vehicle_Make"));
		cm.selectDropdownOption(dd_Model, testData.get("Vehicle_Model"));
		txt_Cylindercapacity.sendKeys(testData.get("Vehicle_CylinderCapacity"));
		txt_Engineperformance.sendKeys(testData.get("Vehicle_Enging Performance"));
		date_Dateofmanufacture.sendKeys(testData.get("Vehicle_Date of Manufacture"));
		cm.selectDropdownOption(dd_Numberofseatsmotorcycle, testData.get("Vehicle_No of Seats_motorcycle"));
		txt_Listprice.sendKeys(testData.get("Vehicle_List Price"));
		txt_Annualmileage.sendKeys(testData.get("Vehicle_Annual Mileage"));
		
	}
	public void clickOnNextButton()
	{
		btn_Nextenterinsurantdata.click();
	}

}
