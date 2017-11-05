package com.sri.utilclass;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UtilClass {

	private Properties prop = new Properties();
	private XSSFWorkbook workbook = null;
	private HashMap<String, String> xPathMap = new HashMap<String, String>();
	private HashMap<String, String> testDataMap = new HashMap<String, String>();

	private WebDriver driver;
	private WebDriverWait wait;

	public UtilClass() {
		loadProp();
		loadDriver();
		loadWorkbook();
		loadXpathData();
		loadTestData();
		wait = new WebDriverWait(driver, 60);

	}

	private void loadProp() {
		try {
			InputStream inputStream = new FileInputStream("src/main/resources/config.properties");
			prop.load(inputStream);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public String getProperty(String key) {
		return prop.getProperty(key);
	}

	private void loadDriver() {
		if (getProperty("browser").equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
			driver = new ChromeDriver();
		} else {
			driver = new FirefoxDriver();
		}
	}

	public WebDriver getDriver() {
		return driver;
	}

	private void loadWorkbook() {
		InputStream inputstream = null;
		try {
			inputstream = new FileInputStream("src/main/resources/testData.xlsx");
			workbook = new XSSFWorkbook(inputstream);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private void loadXpathData() {
		XSSFSheet sheet = workbook.getSheet("xPathData");
		Iterator<Row> rows = sheet.rowIterator();
		sheet.
		rows.next();

		while (rows.hasNext()) {
			XSSFRow row = (XSSFRow) rows.next();
			String key = row.getCell(0).getStringCellValue();
			String value = row.getCell(1).getStringCellValue();
			xPathMap.put(key, value);
		}

	}

	private void loadTestData() {
		XSSFSheet sheet = workbook.getSheet("testData");
		Iterator<Row> rows = sheet.rowIterator();

		int cellIndex = 1;
		switch (getProperty("env").toUpperCase()) {
		case "PROD":
			cellIndex = 1;
			break;
		case "UAT":
			cellIndex = 2;
			break;
		case "IT":
			cellIndex = 3;
			break;

		default:
			break;
		}

		rows.next();
		while (rows.hasNext()) {
			XSSFRow row = (XSSFRow) rows.next();
			String key = row.getCell(0).getStringCellValue();
			String value = row.getCell(cellIndex).getStringCellValue();
			testDataMap.put(key, value);
		}
	}

	public String getXpathData(String key) {
		return xPathMap.get(key);
	}

	public String getTestData(String key) {
		return testDataMap.get(key);
	}
	
	public WebElement getElement(String xPath) {
		return wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xPath)));
	}
	
	public void waitTime(long timeout){
		try {
			Thread.sleep(timeout);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
