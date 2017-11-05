package com.sri.pages;

import com.sri.utilclass.UtilClass;

public class ApplePageSri1 {
	private UtilClass util;
	/*private WebDriver driver;
	private WebDriverWait wait;*/
	private String product = "//span[@aw-resource='%s']";

	public ApplePageSri1(UtilClass util) {
		this.util = util;
		/*driver = util.getDriver();
		wait = new WebDriverWait(driver, 30);*/
	}

	public void launchURL() {
		util.getDriver().get(util.getTestData("url"));
		util.getDriver().manage().window().maximize();
	}

	public void clickProduct(String productName) {
		/*product = String.format(product, productName);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(product)));
		driver.findElement(By.xpath(product)).click();*/
		
		util.getElement(String.format(product, productName)).click();
	}
}
