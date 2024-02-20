package com.orgName.genericUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;

import org.apache.commons.collections4.map.HashedMap;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * This class is used to maintain all excel specific common methods
 * @author MOHAN GOWDA
 *
 */
public class ExcelLibrary {
		private  Workbook wb; 
	public  void openExcel(String filePath){
		FileInputStream fisExcel = null;
		try {
			fisExcel = new FileInputStream(filePath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			wb = WorkbookFactory.create(fisExcel);
		} catch (EncryptedDocumentException | IOException e) {
			e.printStackTrace();
		}
		UtilityClass.getTest().info("Excel Opened SuccessFully");
	}

	/**
	 * This method is used to fetch the data from the excel sheet
	 * @param sheetName
	 * @param rowNumber
	 * @param cellNumber
	 * @return
	 * 
	 */
	public   String getData( String sheetName, int rowNumber, int cellNumber) {

		String data=wb.getSheet(sheetName).getRow(rowNumber).getCell(cellNumber).getStringCellValue();
		UtilityClass.getTest().info("Data Fetched From Excel SuccessFully");
		return data;
	}
	
	/**
	 * This method is used to fetch the data from the excel based on key
	 * @param sheetName
	 * @param requiredKey
	 * @return
	 */
	public String getData(String sheetName, String requiredKey, String testcaseName) {
		Sheet sheet = wb.getSheet(sheetName);
		String value=null;
		DataFormatter df=new DataFormatter();
		
		for(int i=0; i<=sheet.getLastRowNum(); i++) {
			String actualTestCaseName = df.formatCellValue(sheet.getRow(i).getCell(0));
			if(actualTestCaseName.equalsIgnoreCase(testcaseName)) {
				for(int j=1; j<sheet.getRow(i).getLastCellNum(); j++) {
				String actualKey =  df.formatCellValue(sheet.getRow(i).getCell(j));
				if(actualKey.equalsIgnoreCase(requiredKey)) {
				value =  df.formatCellValue(sheet.getRow(i+1).getCell(j));
				break;
				}
				}
				break;
			}
		}
		return value;
	}


	/**
	 * This method is used to fetch the Common data from the excel
	 * @param sheetName
	 * @param requiredKey
	 * @return
	 */
	public Map<String, String> getCommonData() {
		Sheet sheet = wb.getSheet("adminCommonData");
		Map<String, String> map=new HashedMap<>();
		DataFormatter df=new DataFormatter();
		for(int i=0; i<=sheet.getLastRowNum(); i++) {
			map.put(df.formatCellValue(sheet.getRow(i).getCell(0)), df.formatCellValue(sheet.getRow(i).getCell(1)));
		}
		return map;
	}

	
	/**
	 * This method is used to fetch the multiple data from the excel sheet
	 * @param sheetName
	 * @return
	 */
	public   Object[][] getMultipleDataFromExcel( String sheetName) {

		Sheet sh = wb.getSheet(sheetName);

		Object[][] arr=new Object[sh.getLastRowNum()][sh.getRow(0).getLastCellNum()];
		for(int i=0; i<sh.getLastRowNum(); i++)
		{
			for(int j=0; j<sh.getRow(i).getLastCellNum(); j++)
			{
				arr[i][j]=sh.getRow(i+1).getCell(j).getStringCellValue();
			}
		}
		UtilityClass.getTest().info("Data Fetched From Excel SuccessFully");
		return arr;
	}

	/**
	 * This method is used to set the value into Excel
	 * @param sheetName
	 * @param rowNumber
	 * @param cellNumber
	 * @param value
	 */
	public   void setDataIntoExcel(String sheetName, int rowNumber, int cellNumber, String value) {
		wb.getSheet(sheetName).getRow(rowNumber).createCell(cellNumber).setCellValue(value);
		UtilityClass.getTest().info("Data SuccessFully set to the Excel");
	}

	/**
	 * This method is used to save the data 
	 * @param fileSavePath
	 * @throws IOException
	 */
	public   void saveExcelData(String fileSavePath)  {
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(fileSavePath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			wb.write(fos);
		} catch (IOException e) {
			e.printStackTrace();
		}
		UtilityClass.getTest().info("Excel Saved SuccessFully");
		
	}

	/**
	 * This method is used to close the Excel Connection
	 */
	public   void closeExcel() {
		try {
			wb.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		UtilityClass.getTest().info("Excel Closed SuccessFully");
	}

}
