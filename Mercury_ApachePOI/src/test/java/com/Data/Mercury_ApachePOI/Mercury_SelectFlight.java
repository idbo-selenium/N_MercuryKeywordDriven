package com.Data.Mercury_ApachePOI;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Mercury_SelectFlight {

	public WebDriver driver;
	public int seconds = 4000;
	
	public void Click_OneWay(String s){
		Mercury_TestClass.driver.findElement(By.xpath(s)).click();
	}
	
	public void Select_Passengers(String s){
		WebElement element = Mercury_TestClass.driver.findElement(By.name("passCount"));
		Select se = new Select(element);
		se.selectByIndex(3);
		System.out.println("Select_Passengers");
	}
	
	public void Departing_From(String s)throws Exception{Thread.sleep(2000);
		WebElement element = Mercury_TestClass.driver.findElement(By.name("fromPort"));
		Select se = new Select(element);
		se.selectByValue("London");
		System.out.println("Departing_From");
	}
	
	public void Departing_From_Month(String s)throws Exception{Thread.sleep(2000);
		WebElement element = Mercury_TestClass.driver.findElement(By.xpath(s));
		Select se = new Select(element);
		se.selectByIndex(6);
		System.out.println("Departing_From_Month");				
	}
	
	public void Departing_From_Day(String s)throws Exception{Thread.sleep(2000);
		WebElement element = Mercury_TestClass.driver.findElement(By.xpath(s));
		Select se = new Select(element);
		se.selectByIndex(4);
		System.out.println("Departing_From_Day");
	}
	
	public void Arriving_In(String s)throws Exception{Thread.sleep(2000);
		WebElement element = Mercury_TestClass.driver.findElement(By.xpath(s));
		Select se = new Select(element);
		//se.selectByIndex(3);
		se.selectByValue("Paris");
		System.out.println("Arriving_In");
	}
	
	public void Service_Class(String s){
		Mercury_TestClass.driver.findElement(By.xpath(s)).click();
		System.out.println("Service_Class");
	}
	
	public void Click_Continue(String s){
		Mercury_TestClass.driver.findElement(By.xpath(s)).click();
		System.out.println("Click_Continue");
	}
	
	public void Click_SignOff(String s){
		Mercury_TestClass.driver.findElement(By.xpath(s)).click();
		System.out.println("Click_SignOff");
	}
	
	public void Close_Browser(String s){
		Mercury_TestClass.driver.close();
		System.out.println("Close_Browser");
	}
}