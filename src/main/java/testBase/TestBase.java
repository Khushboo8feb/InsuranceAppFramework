package testBase;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.HomePageObjects;
import pageObjects.InsurantDataPageObjects;
import pageObjects.ProductDataPageObjects;
import pageObjects.SelectPriceOptionObjects;
import pageObjects.VehicleDataPageObjects;
import reusableComponents.PropertiesOperations;

public class TestBase extends ObjectRepo{
	
	
	public void launchBrowserAndNavigate() throws Exception
	{
		//read properties file and get browser and url
		
		String browser = PropertiesOperations.getPropertiesValueByKey("browser");
		String url = PropertiesOperations.getPropertiesValueByKey("url");
		
		if(browser.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			 driver = new ChromeDriver();
		}
		else if (browser.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
		     driver = new FirefoxDriver();
			
		}
		else if(browser.equalsIgnoreCase("ie"))
		{
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
		}

		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(url);
	}
	

	@BeforeMethod
	public void appSetUp() throws Exception
	{
		launchBrowserAndNavigate();
		 homepage = new HomePageObjects();
		 vehicleData = new VehicleDataPageObjects();
		 InsurantData = new InsurantDataPageObjects();
		 ProductData = new ProductDataPageObjects();
		 priceOption = new SelectPriceOptionObjects();
	}
	
	@AfterMethod
	public void teardown()
	{
		driver.close();
	}
	

}
