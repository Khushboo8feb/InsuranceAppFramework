package pageObjects;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testBase.TestBase;

public class SelectPriceOptionObjects extends TestBase{
	
	public SelectPriceOptionObjects()
	{
		PageFactory.initElements(driver, this );
	}
	
	@FindBy(id = "nextsendquote")
	WebElement btn_next;
	
	public String getPriceforSelectedOption(String string)
	{
	
		String dataXpath = "//table[@id='priceTable']//tr[1]//td[@data-label ='"+string+"']/span";
		return driver.findElement(By.xpath(dataXpath)).getText();
	}
	
	public void selectPriceOption(String plan)
	{
		String dataXpath = "//input[@name ='Select Option' and @value = '"+plan+"']//parent::label";
		driver.findElement(By.xpath(dataXpath)).click();
		
	}
	
	public void clickOnNextButton()
	{
		btn_next.click();
	}

}
