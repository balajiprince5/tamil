package com.ipt.octbatch.IPT_Oct_Batch;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLSX_Write {
	public static void writeData() throws IOException {
		File f = new File("C:\\Users\\WELCOME\\Desktop\\amazon & flipkart.xlsx");
		FileInputStream fi = new FileInputStream(f);
		Workbook w = new XSSFWorkbook(fi);
		Sheet s = w.createSheet("IPTOctBatch");
		Row r1 = s.createRow(0);
		Cell c = r1.createCell(1);
//		c.setCellValue("ONE");
//		w.getSheet("IPTOctBatch").createRow(2).createCell(2).setCellValue("TWO");
//		FileOutputStream fo = new FileOutputStream(f);
//		w.write(fo);
//		w.close();
	}
//int a[] = {10,2033,12,78,32,21}
//	descending order & descending order 
//	without  with inbuilt function
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		writeData();
	}

}
