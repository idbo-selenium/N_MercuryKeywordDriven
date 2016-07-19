package com.Data.Mercury_ApachePOI;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Mercury_TestClass {

	public static WebDriver driver;
	
	public void OpenBrowser(String s,String d){
		System.setProperty("webdriver.chrome.driver", "F:\\Eclipse_Selenium\\Java_Selenium_Maven\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		System.out.println("OpenBrowser");
	}
	
	public void Navigate_To(String s,String d){
		driver.navigate().to(s);
		System.out.println("Navigate_To");
	}
	
	public void Click_SignOn(String s,String d){
		driver.findElement(By.xpath(s)).click();
		System.out.println("Click_SignOn");
	}
	
	public void Enter_Username(String s,String d){
		driver.findElement(By.name(s)).sendKeys(d);
		System.out.println("Enter_Username");
	}
	
	public void Enter_Password(String s,String d){
		driver.findElement(By.name(s)).sendKeys(d);
		System.out.println("Enter_Password");
	}
	
	public void Click_Submit(String s,String d){
		driver.findElement(By.name(s)).click();
		System.out.println("Click_Submit");
	}
}