package pageObjects;

import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testBase.TestBase;

public class ProductDataPageObjects extends TestBase {
	
	public ProductDataPageObjects()
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "startdate")
	WebElement date_startdate;
	
	@FindBy(id = "insurancesum")
	WebElement dd_insurancesum;
	
	@FindBy(id = "damageinsurance")
	WebElement dd_damageinsurance;
	
	@FindBy(xpath = "//input[@name = 'Optional Products[]']/parent::label")
	List<WebElement> chk_OptionalProducts;
	
	@FindBy(id = "preventerinsurancedata")
	WebElement btn_prevEnterinsurancedata;
	
	@FindBy(id = "nextselectpriceoption")
	WebElement btn_nextSelectpriceoption;
	
	public void enterProductData(HashMap<String, String> testData) throws Exception
	{
		date_startdate.sendKeys(testData.get("Product_startdate"));
		cm.selectDropdownOption(dd_insurancesum, testData.get("Product_insurancesum"));
		cm.selectDropdownOption(dd_damageinsurance, testData.get("Product_damageinsurance"));
		cm.selectCheckBoxes(chk_OptionalProducts, testData.get("Product_OptionalProducts"));
	}
	
	public void clickOnNextButton()
	{
		btn_nextSelectpriceoption.click();
	}
	
}
