package com.sri.test;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.sri.goindigopages.goindiPage1;
import com.sri.utilclass.UtilClass;

public class DemoIndigo {

	private UtilClass util;
	private goindiPage1 goindiPage1;

	@BeforeSuite
	public void intialize() {
		util = new UtilClass();
		goindiPage1 = new goindiPage1(util);
        goindiPage1.launchURL();
	}

	@Test
	public void selectTrip(){
		
		goindiPage1.selectOneway();
		
	}
	
}
