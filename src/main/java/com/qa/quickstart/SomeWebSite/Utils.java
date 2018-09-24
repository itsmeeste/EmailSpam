package com.qa.quickstart.SomeWebSite;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Utils 
{
	public static ArrayList<String> emails = new ArrayList<String>();
	public static ArrayList<String> places = new ArrayList<String>();
	public static ArrayList<String> expected = new ArrayList<String>();
	public static ArrayList<String> filepaths = new ArrayList<String>();
	public static int random = 0;
	public static void file() throws IOException
	{
		FileInputStream file = null;
		FileInputStream placesF = null;
		
		try
		{
			file = new FileInputStream(Constant.FILEPATH + Constant.FILENAME);
			placesF = new FileInputStream(Constant.FILEPATH + Constant.FILENAMEPLACES);
		}
		catch(FileNotFoundException e)
		{
			System.out.println(e);
		}
		XSSFWorkbook workbook = null;
		XSSFWorkbook workbookPlaces = null;
		try
		{
			workbook = new XSSFWorkbook(file);
			workbookPlaces = new XSSFWorkbook(placesF);
		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}
		
		XSSFSheet sheet = workbook.getSheetAt(0);
			for(int i = 1; i < sheet.getPhysicalNumberOfRows(); i++)
			{
				XSSFCell cell = sheet.getRow(i).getCell(0);
				emails.add(cell.getStringCellValue());
			}
			file.close();
		
			
		XSSFSheet sheetPlaces = workbookPlaces.getSheetAt(0);
		for(int i = 1; i < sheetPlaces.getPhysicalNumberOfRows(); i++)
		{
			XSSFCell cell = sheetPlaces.getRow(i).getCell(0);
			places.add(cell.getStringCellValue());
			
			XSSFCell cellEx = sheetPlaces.getRow(i).getCell(1);
			expected.add(cellEx.getStringCellValue());
			XSSFCell cellFile = sheetPlaces.getRow(i).getCell(2);
			filepaths.add(cellFile.getStringCellValue());
		}
		placesF.close();
			
	}
	public static void IncScore(String email) throws IOException
	{
		FileInputStream file = null;
		try
		{
			file = new FileInputStream(Constant.FILEPATH + Constant.FILENAME);
		}
		catch(FileNotFoundException e)
		{
			System.out.println(e);
		}
		XSSFWorkbook workbook = null;
		try
		{
			workbook = new XSSFWorkbook(file);
		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}
		
		XSSFSheet sheet = workbook.getSheetAt(0);
			for(int i = 1; i < sheet.getPhysicalNumberOfRows(); i++)
			{
				XSSFCell cell = sheet.getRow(i).getCell(0);
				if(cell.getStringCellValue().equals(email))
				{
					XSSFCell cellNew = sheet.getRow(i).getCell(1);
					double itr = cellNew.getNumericCellValue();
					cellNew.setCellValue(++itr);
				}
			}
		file.close();
		FileOutputStream fos =new FileOutputStream(new File(Constant.FILEPATH + Constant.FILENAME));
        workbook.write(fos);
        fos.close();
	}

}
