package pageObjects;

import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testBase.TestBase;

public class InsurantDataPageObjects extends TestBase{
	
	public InsurantDataPageObjects()
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "firstname")
	WebElement txt_Firstname;
	
	@FindBy(id = "lastname")
	WebElement txt_Lastname;
	
	@FindBy(id = "birthdate")
	WebElement date_Birthdate;
	
	@FindBy(xpath = "//input[@name = 'Gender']/parent::label")
	List<WebElement> rdo_gender;
	
	@FindBy(id = "streetaddress")
	WebElement txt_Streetaddress;
	
	@FindBy(id = "country")
	WebElement dd_Country;
	
	@FindBy(id = "zipcode")
	WebElement txt_Zipcode;
	
	@FindBy(id = "city")
	WebElement txt_City;
	
	@FindBy(id = "occupation")
	WebElement dd_Occupation;
	
	@FindBy(xpath = "//input[@name = 'Hobbies']/parent::label")
	List<WebElement> chkBox_Hobbies;
		
	@FindBy(id = "website")
	WebElement txt_website;
	
	@FindBy(id = "picture")
	WebElement txt_fileUpload;
	
	@FindBy(id = "open")
	WebElement btn_fileUpload;
	
	@FindBy(id = "preventervehicledata")
	WebElement btn_prevEntervehicledata;
	
	@FindBy(id = "nextenterproductdata")
	WebElement btn_nextEnterproductdata;
	
	public void enterInsuranceData(HashMap<String, String> testData) throws Exception
	{
		txt_Firstname.sendKeys(testData.get("Insurant_FirstName"));
		txt_Lastname.sendKeys(testData.get("Insurant_LastName"));
		date_Birthdate.sendKeys(testData.get("Insurant_birthdate"));
		cm.selectRadioButtonValue(rdo_gender, testData.get("Insurant_gender"));
		txt_Streetaddress.sendKeys(testData.get("Insurant_StreeAddress"));
		cm.selectDropdownOption(dd_Country, testData.get("Insurant_country"));
		txt_Zipcode.sendKeys(testData.get("Insurant_zipcode"));
		txt_City.sendKeys(testData.get("Insurant_City"));
		cm.selectDropdownOption(dd_Occupation, testData.get("Insurant_occupation"));
		cm.selectCheckBoxes(chkBox_Hobbies, testData.get("Insurant_Hobby"));
		txt_website.sendKeys(testData.get("Insurant_Website"));
	}
	
	public void clickOnNextButton()
	{
		btn_nextEnterproductdata.click();
	}
	

}
