package com.sri.goindigopages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class indigoPage1 {
	
	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.goindigo.in/");
		
		driver.findElement(By.xpath("//a[@href = '#oneWay']")).click();
		/*try {
		    WebDriverWait wait = new WebDr6iverWait(driver, 30);
		    wait.until(ExpectedConditions.alertIsPresent());
		    Alert alert = driver.switchTo().alert();
		    System.out.println(alert.getText());
		    alert.accept();
		    //Assert.assertTrue(alert.getText().contains("Thanks."));
		} catch (Exception e) {
		    e.printStackTrace();
		}*/
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button.button-trigger")));
	    String alertText = driver.findElement(By.cssSelector("div.modal-body")).getText();
	    System.out.println("************************************************************");
	    System.out.println(alertText);
	    System.out.println("************************************************************");
	    Thread.sleep(5000);
	    driver.findElement(By.cssSelector("button.button-trigger")).click();
	    Thread.sleep(10000);
		driver.close();
	}
	

}
