package com.ipt.octbatch.IPT_Oct_Batch;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class XLSXReader {

	static String value;
	public static String singleData(String sheetName, int rowNo, int cellNo) throws Exception {
		File f = new File("C:\\Users\\WELCOME\\eclipse-workspace\\IPT_Project_Amazon\\Data_Driven\\amazon & flipkart.xlsx");
		FileInputStream fi = new FileInputStream(f);
		Workbook w = new XSSFWorkbook(fi);
		Sheet s =  w.getSheet(sheetName);
		Row r =  s.getRow(rowNo);
		Cell c = r.getCell(cellNo);
		CellType ce =  c.getCellType();
		if (ce.equals(CellType.STRING)) {
			 value = c.getStringCellValue();
		} else if (ce.equals(CellType.NUMERIC)) {
			double d = c.getNumericCellValue();
			int i = (int)d;
			 value = String.valueOf(i);
		} 
		return value;
	}
	public static void allData() throws IOException {
		File f = new File("C:\\Users\\WELCOME\\eclipse-workspace\\IPT_Project_Amazon\\Data_Driven\\amazon & flipkart.xlsx");
		FileInputStream fi = new FileInputStream(f);
		Workbook w = new XSSFWorkbook(fi);
		Sheet s = w.getSheet("AMAZON");
		int rowSize = s.getPhysicalNumberOfRows();
		for (int i = 0; i < rowSize; i++) {
			Row r = s.getRow(i);
			int cellSize = r.getPhysicalNumberOfCells();
			for (int j = 0; j <cellSize; j++) {
				Cell c= r.getCell(j);
				CellType ce = c.getCellType();
				if (ce.equals(CellType.STRING)) {
					String ss = c.getStringCellValue();
					System.out.print(ss);
					
				} else if(ce.equals(CellType.NUMERIC)){
					double d = c.getNumericCellValue();
					int in = (int)d;
					System.out.print(in);
				}System.out.print("\t" +"||");
			}System.out.println();
		}
	}

	public static void main(String[] args) throws Exception {
//		singleData();
		allData();
	}

}
