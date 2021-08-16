package testBase;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import pageObjects.HomePageObjects;
import pageObjects.InsurantDataPageObjects;
import pageObjects.ProductDataPageObjects;
import pageObjects.SelectPriceOptionObjects;
import pageObjects.VehicleDataPageObjects;
import reusableComponents.CommonMethods;

public class ObjectRepo {
	public static WebDriver driver;
	public static ExtentReports extent;
	public static ExtentTest test;
	
	public static HomePageObjects homepage;
	public static VehicleDataPageObjects vehicleData;
	public static InsurantDataPageObjects InsurantData;
	public static ProductDataPageObjects ProductData;
	public static SelectPriceOptionObjects priceOption;
	public static CommonMethods cm = new CommonMethods();

}
