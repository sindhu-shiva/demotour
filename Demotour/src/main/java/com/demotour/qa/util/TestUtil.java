package com.demotour.qa.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.demotour.qa.base.TestBase;

public class TestUtil extends TestBase{
	
	
	
	public static String Test_data_sheet_path= "C:\\Users\\91973\\git\\demotour\\Demotour\\src\\main\\java\\com\\demotour\\qa\\testData\\ExcelDemo.xlsx";
 static Workbook book;
 static Sheet sheet;


public static Object[][] getTestData(){
	FileInputStream file= null;
	try {
		file=new FileInputStream(Test_data_sheet_path);
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	try {
		book= WorkbookFactory.create(file);
	} catch (EncryptedDocumentException | IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	sheet=book.getSheetAt(0);
	
	Object[][] data= new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
	System.out.println(sheet.getLastRowNum());
	for (int i=0;i<sheet.getLastRowNum();i++)
	{
	for (int k=0;i<sheet.getRow(0).getLastCellNum();k++)
	{
		data[i][k]=sheet.getRow(i+1).getCell(k).toString();
	}
	
	}
	return data;
}
}


	
	
	
	
	