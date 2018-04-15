package com.SP14Apr.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class DataHandlers {

	public static String readDataFromExcel(String filename, String sheetName, int rowIndex, int cellIndex)
	{
		String data=null;
		
		try
		{
			File f= new File("./test-data/"+filename+".xlsx");													//Locate File
			FileInputStream fis=new FileInputStream(f);									//Open File
			Workbook wb = WorkbookFactory.create(fis);									//creates file into a workbook
			org.apache.poi.ss.usermodel.Sheet s = wb.getSheet(sheetName);				//locates sheet
			Row r=s.getRow(rowIndex);													//locates row
			Cell c=r.getCell(cellIndex);												//locates cell
			data = c.toString();														//gets data
		}
		catch(Exception e)
		{
			e.printStackTrace();
					
		}
		
		return data;	
	}
	
	public static void writeDataToExcel(String filename, String sheetName, int rowIndex, int cellIndex, String data)
	{
		
		try
		{
			File f = new File("./test-data/"+filename+".xlsx");
			FileInputStream fis = new FileInputStream(f);
			Workbook wb = WorkbookFactory.create(fis);
			Sheet s = wb.getSheet(sheetName);
			Row r = s.getRow(rowIndex);
			Cell c = r.getCell(cellIndex);
			c.setCellValue(data);
			FileOutputStream fos = new FileOutputStream(f);
			wb.write(fos);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
	}
	public static String getDataFromPropertyFile(String Filename,String key)
	{
		String data =null;
		try
		{
			File F = new File("./config-data/" + Filename+".properties");
			FileInputStream Fis =new FileInputStream(F);
			Properties prop = new Properties();
			prop.load(Fis);
			data=(String)prop.get(key);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return data;
	}
	public static void writeDataToPropertyFile(String filename, String key, String value, String comment)
	{
		
		try
		{
			File f = new File("./config-data/"+filename+".properties");
			FileInputStream fis = new FileInputStream(f);
			Properties prop = new Properties();
			prop.load(fis);
			prop.setProperty(key, value);
			FileOutputStream fos = new FileOutputStream(f);
			prop.store(fos, comment);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
