package reusableComponents;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class CommonMethods {
	
	public List<String> getDropdownOptionsAsList(WebElement element)
	{

		Select optionList = new Select(element);
		List<WebElement> listWebElement = optionList.getOptions();
		List<String> actualDropdownList = new ArrayList();
		
		for(WebElement options : listWebElement)
		{
			 actualDropdownList.add(options.getText());
		}
		return actualDropdownList;
	}
	
	public void selectDropdownOption(WebElement element, String valueToBeSelected) throws Exception
	{
		Select se = new Select(element);
		try {
			se.selectByVisibleText(valueToBeSelected);
		} catch (Exception e) {
			throw new Exception("Value is not present in dropdown for WebElement:  "+element+ "  value to be selected is:  "+valueToBeSelected);
			
		}
		
	}
	
	public void selectRadioButtonValue(List<WebElement> element, String valueToBeSelected)
	{
		for(WebElement ref: element )
		{
			if(ref.getText().equalsIgnoreCase(valueToBeSelected))
			{
				ref.click();
				break;
			}
		}
	}
	
	public void selectCheckBoxes(List<WebElement> element, String checkbox)
	{
		String[] checksArray = checkbox.split(",");
		for(String value : checksArray) // speeding, Other
		{
			for(WebElement ele: element)
			{
				if(ele.getText().equalsIgnoreCase(value))
				{
					ele.click();
					break;
				}
			}
		}
		
	}

}
