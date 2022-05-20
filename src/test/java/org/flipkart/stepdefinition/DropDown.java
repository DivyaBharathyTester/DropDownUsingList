package org.flipkart.stepdefinition;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDown {
	
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://demo.guru99.com/test/newtours/register.php");
		driver.manage().window().maximize();
		WebElement submitButton = driver.findElement(By.xpath("//input[@name='submit']"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(false)", submitButton);
		WebElement country = driver.findElement(By.xpath("//select[@name='country']"));
        Select dropdown = new Select(country);
		
		// Get all options
		List<WebElement> allOptionsElement = dropdown.getOptions();
		
		// Creating a list to store drop down options
		List options = new ArrayList();
		
		// Storing options in list
		for(WebElement optionElement : allOptionsElement)
		{
			options.add(optionElement.getText());
		}
		
		// Removing "Select" option as it is not actual option
		options.remove("Select");
		
		// Default order of option in drop down
		System.out.println("Options in dropdown with Default order :"+options);
		
		// Creating a temp list to sort
		List tempList = new ArrayList(options);
				
		// Sort list ascending
		Collections.sort(tempList);		
		System.out.println("Sorted List "+ tempList);
				
				
		// equals() method checks for two lists if they contain the same elements in the same order.
		if(tempList.equals(options)) {
			System.out.println("List is sorted");
		}
		else {
			System.out.println("List is not sorted");
		}
}
}