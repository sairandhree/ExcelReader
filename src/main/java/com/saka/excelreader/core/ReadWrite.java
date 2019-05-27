package com.saka.excelreader.core;

import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;
import java.util.Iterator;


import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFFormulaEvaluator;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;



@Component
public class ReadWrite {
	
	public void getData(){
		//ClassLoader classLoader = new ReadResourceFileDemo().getClass().getClassLoader();
		File  file = new File(getClass().getClassLoader().getResource("Test.xlsx").getFile());
		try {
			FileInputStream  fis = new FileInputStream(file);
			 XSSFWorkbook workbook = new XSSFWorkbook(fis);

	            XSSFSheet sheet = workbook.getSheetAt(0);
	            
	            FormulaEvaluator evaluator = workbook.getCreationHelper().createFormulaEvaluator();
	           // workbook.getCreationHelper().createFormulaEvaluator().evaluateAll();
	           
	            XSSFFormulaEvaluator.evaluateAllFormulaCells(workbook);
	            
	            Cell cell1 = sheet.createRow(2).createCell(1);
	            cell1.setCellValue(1);
	            Cell cell2 = sheet.createRow(3).createCell(1);
	            cell2.setCellValue(2);
	            Cell cell3 = sheet.createRow(4).createCell(1);
	            cell3.setCellValue(3);
	            
	            //FormulaEvaluator evaluator = workbook.getCreationHelper().createFormulaEvaluator();
	            //workbook.getCreationHelper().createFormulaEvaluator().evaluateAll();
	            
	            
	            XSSFSheet sheet2 = workbook.getSheetAt(1);
	            
	            Iterator<Row> rowIterator = sheet.iterator();
				while (rowIterator.hasNext()) 
				{
					Row row = rowIterator.next();
					//For each row, iterate through all the columns
					Iterator<Cell> cellIterator = row.cellIterator();
					
					while (cellIterator.hasNext()) 
					{
						Cell cell = cellIterator.next();
						//Check the cell type and format accordingly
						switch (cell.getCellType()) 
						{
							case NUMERIC:
								System.out.print(cell.getNumericCellValue() + "\t");
								break;
							case STRING:
								System.out.print(cell.getStringCellValue() + "\t");
								break;
						}
					}
					System.out.println("");
				}
				//file.close();
				
				
	          
            System.out.println(evaluator.evaluate(sheet2.getRow(1).getCell(1)).getNumberValue());
            System.out.println(evaluator.evaluate(sheet2.getRow(2).getCell(1)).getNumberValue());
            
            System.out.println(evaluator.evaluate(sheet2.getRow(3).getCell(1)).getNumberValue());
            
	            
		} catch (  IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
	
	public static void main(String[] args) {
		ReadWrite rw = new ReadWrite();
		
		rw.getData();
		
	}

}
