package com.SP14Apr.utils;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DropDownHandlers {
	
		public static void selectDDLByIndex(WebElement DDL, int index)
		{
			Select sct = new Select(DDL);
			sct.selectByIndex(index);
		}
		
		public static void selectDDLByValue(WebElement DDL, String value)
		{
			Select sct = new Select(DDL);
			sct.selectByValue(value);
		}

		public static void selectDDLByVisibleText(WebElement DDL, String text)
		{
			Select sct = new Select(DDL);
			sct.selectByVisibleText(text);
		}
		
		public static void deSelectDDLByIndex(WebElement DDL, int index)
		{
			Select sct = new Select(DDL);
			sct.deselectByIndex(index);
		}
		
		public static void deSelectDDLByValue(WebElement DDL, String value)
		{
			Select sct = new Select(DDL);
			sct.deselectByValue(value);
		}

		public static void deSelectDDLByVisibleText(WebElement DDL, String text)
		{
			Select sct = new Select(DDL);
			sct.deselectByVisibleText(text);
		}
		
		public static void deSelectAll(WebElement DDL)
		{
			Select sct = new Select(DDL);
			sct.deselectAll();
		}
	
	

}
