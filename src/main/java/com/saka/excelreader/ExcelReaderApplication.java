package com.saka.excelreader;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.boot.SpringApplication;
import java.io.*;
import java.util.Iterator;

import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ExcelReaderApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExcelReaderApplication.class, args);
		
		System.out.println("====Hello===");
			
		try {

            FileInputStream excelFile = new FileInputStream("D:\\internship\\ExcelReader\\src\\main\\resources\\Test.xlsx");
            Workbook workbook = new XSSFWorkbook(excelFile);   
            Sheet sheet = workbook.getSheetAt(0);
            Iterator<Row> iterator = sheet.iterator();

            while (iterator.hasNext()) {

                Row currentRow = iterator.next();
                Iterator<Cell> cellIterator = currentRow.iterator();

                while (cellIterator.hasNext()) {

                    Cell currentCell = cellIterator.next();
                   
                    if (currentCell.getCellType() == CellType.STRING) {
                        System.out.print(currentCell.getStringCellValue());
                    } else if (currentCell.getCellType() == CellType.NUMERIC) {
                        System.out.print(currentCell.getNumericCellValue());
                    }
                }
                System.out.println("");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } 
	}
}
