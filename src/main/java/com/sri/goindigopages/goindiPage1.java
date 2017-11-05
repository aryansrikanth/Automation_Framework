package com.sri.goindigopages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;

import com.sri.utilclass.UtilClass;

public class goindiPage1 {

	private UtilClass util;

	public goindiPage1(UtilClass util) {
           this.util = util;
	}

	public void launchURL(){
		util.getDriver().get("https://www.goindigo.in/");
		util.getDriver().manage().window().maximize();
		
	}
	
	public void selectOneway(){
		
		util.getDriver().findElement(By.xpath("//a[@href = '#oneWay']")).click();
		util.getElement("//h4[@class='modal-title']");
		Alert al = util.getDriver().switchTo().alert();
		System.out.println(al.getText());
		al.accept();
		
	}
	
	
	
	
}
