package com.sri.pages;

import com.sri.utilclass.UtilClass;

public class ApplePageSri2 {
	private UtilClass util;
	private String topic = "//span[@aw-resource='%s']/ancestor::button";
	private String symtoms = "//span[@aw-resource='%s']/ancestor::button"; 
	
	public ApplePageSri2(UtilClass util) {
		this.util = util;
	}

	public void selectTopic(String topicName){
		System.out.println(String.format(topic, topicName));
		util.getElement(String.format(topic, topicName)).click();
	}
	
	public void selectSymtoms(String symtomsName){
		//System.out.println(String.format(topic, productName1));
		util.getElement(String.format(symtoms, symtomsName)).click();
	}

}
