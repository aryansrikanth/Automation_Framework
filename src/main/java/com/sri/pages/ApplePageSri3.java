package com.sri.pages;

import com.sri.utilclass.UtilClass;

public class ApplePageSri3 {
	private UtilClass util;
    private String chatt="//span[@aw-resource='%s ']/ancestor::button";
	
    public ApplePageSri3(UtilClass util) {
      this.util=util;
    }
	public void selectChat(String chatName){
		System.out.println(String.format(chatt, chatName));
		util.getElement(String.format(chatt, chatName)).click();
	}
	
	
	
}
