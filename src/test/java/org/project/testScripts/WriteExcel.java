package org.project.testScripts;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.tools.FileObject;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
public class WriteExcel {

	public static void main(String[] args) throws IOException {
		
		FileInputStream read = new FileInputStream("Testdata/Read.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(read);
		XSSFSheet sh = wb.getSheet("Sheet1");
		
		FileInputStream write = new FileInputStream("Testdata/write.xlsx");
		XSSFWorkbook wb1 = new XSSFWorkbook(write);
		XSSFSheet sh1 = wb1.getSheet("Sheet1");
		
		int rowcount = sh.getPhysicalNumberOfRows();
		int colcount = sh.getRow(0).getPhysicalNumberOfCells();
		for(int i =0 ;i<rowcount;i++) {
			sh1.createRow(i);
		}
		
		for(int i=0;i<rowcount;i++) {
			for(int j=0;j<colcount;j++) {
				XSSFRow row= sh.getRow(i);
				XSSFCell cell = row.getCell(j);
				cell.setCellType(CellType.STRING);
				String str = cell.getStringCellValue();
				sh1.getRow(i).createCell(j).setCellValue(str);
			}
		}
		FileOutputStream write1 = new FileOutputStream("Testdata/write.xlsx");
		wb1.write(write1);
		read.close();
		write.close();
		write1.close();
		System.out.println("Transfer Successful");
		
	}

}
