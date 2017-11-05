package com.sri.test;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.sri.pages.ApplePageSri1;
import com.sri.pages.ApplePageSri2;
import com.sri.pages.ApplePageSri3;
import com.sri.utilclass.UtilClass;

public class TestDemoSri {
	private UtilClass util;
	private ApplePageSri1 aPage1;
	private ApplePageSri2 aPage2;
	private ApplePageSri3 aPage3;

	@BeforeSuite
	public void intialize() {
		util = new UtilClass();
		aPage1 = new ApplePageSri1(util);
		aPage2 = new ApplePageSri2(util);
		aPage3 = new ApplePageSri3(util);
	}

	@AfterSuite
	public void deIntialize() {
		util.getDriver().close();
	}

	@Test
	public void testApp() {
		aPage1.launchURL();
		aPage1.clickProduct(util.getXpathData("iPhoneProduct"));
		//aPage2.selectTopic("Battery, Power & Charging");
		aPage2.selectTopic(util.getXpathData("BatteryPAC"));
		aPage2.selectSymtoms(util.getXpathData("Unpower"));
		aPage3.selectChat(util.getXpathData("chatt"));
		//util.waitTime(10000);
	}

}
