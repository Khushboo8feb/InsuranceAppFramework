package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testBase.TestBase;

public class HomePageObjects extends TestBase {
	
	public HomePageObjects()
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id ="nav_automobile")
	WebElement lnk_automobile;
	
	@FindBy(id ="nav_truck")
	WebElement lnk_truck;
	
	@FindBy(id ="nav_motorcycle")
	WebElement lnk_motorcycle;
	
	@FindBy(id ="nav_camper")
	WebElement lnk_camper;
	
	public void clickMotorCycleLink()
	{
		lnk_motorcycle.click();
	}

}
