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

import com.saka.excelreader.models.InputModel;
import com.saka.excelreader.models.OutputModel;



@Component
public class ReadWrite {
	
	public OutputModel getData(InputModel input){
		//ClassLoader classLoader = new ReadResourceFileDemo().getClass().getClassLoader();
		File  file = new File(getClass().getClassLoader().getResource("Test.xlsx").getFile());
		OutputModel out = new OutputModel(0, 0, 0) ;
		try {
			FileInputStream  fis = new FileInputStream(file);
			 XSSFWorkbook workbook = new XSSFWorkbook(fis);

	            XSSFSheet sheet = workbook.getSheetAt(0);
	            
	            FormulaEvaluator evaluator = workbook.getCreationHelper().createFormulaEvaluator();
	           // workbook.getCreationHelper().createFormulaEvaluator().evaluateAll();
	           
	            XSSFFormulaEvaluator.evaluateAllFormulaCells(workbook);
	            
	            Cell cell1 = sheet.createRow(2).createCell(1);
	            cell1.setCellValue(input.getfield1());
	            Cell cell2 = sheet.createRow(3).createCell(1);
	            cell2.setCellValue(input.getfield2());
	            Cell cell3 = sheet.createRow(4).createCell(1);
	            cell3.setCellValue(input.getfield3());
	            
	            //FormulaEvaluator evaluator = workbook.getCreationHelper().createFormulaEvaluator();
	            //workbook.getCreationHelper().createFormulaEvaluator().evaluateAll();
	            
	            
	            XSSFSheet sheet2 = workbook.getSheetAt(1);
	            
	         
				
	          
            System.out.println(evaluator.evaluate(sheet2.getRow(1).getCell(1)).getNumberValue());
            System.out.println(evaluator.evaluate(sheet2.getRow(2).getCell(1)).getNumberValue());
            
            System.out.println(evaluator.evaluate(sheet2.getRow(3).getCell(1)).getNumberValue());
            
             out = new OutputModel( evaluator.evaluate(sheet2.getRow(1).getCell(1)).getNumberValue(), 
            		evaluator.evaluate(sheet2.getRow(2).getCell(1)).getNumberValue(),
            		evaluator.evaluate(sheet2.getRow(3).getCell(1)).getNumberValue());
            
           
	            
		} catch (  IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return out;
		
	}
	
	
	
	public static void main(String[] args) {
		ReadWrite rw = new ReadWrite();
		
		InputModel input = new InputModel(1, 2, 3);
		rw.getData(input);
		
	}

}
