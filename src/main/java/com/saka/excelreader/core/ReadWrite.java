package com.saka.excelreader.core;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.StringWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.xssf.usermodel.XSSFFormulaEvaluator;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;


@Component
public class ReadWrite {
	/*
	public void getData(){
		//ClassLoader classLoader = new ReadResourceFileDemo().getClass().getClassLoader();
		File  file = new File(getClass().getClassLoader().getResource("Test.xlsx").getFile());
		try {
			 FileInputStream  fis = new FileInputStream(file);
			 XSSFWorkbook workbook = new XSSFWorkbook(fis);

	           // XSSFSheet sheet = workbook.getSheetAt(0);
			  XSSFSheet sheet = workbook.getSheet("sheet1");
	            FormulaEvaluator evaluator = workbook.getCreationHelper().createFormulaEvaluator();
	        //   workbook.getCreationHelper().createFormulaEvaluator().evaluateAll();
	           
	            XSSFFormulaEvaluator.evaluateAllFormulaCells(workbook);
	            
	            Cell cell1 = sheet.createRow(2).createCell(1);
	          //  Cell cell1 = sheet.createRow(
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
				
	        System.out.println("===========================");

	          
            System.out.println(evaluator.evaluate(sheet2.getRow(1).getCell(1)).getNumberValue());
            System.out.println(evaluator.evaluate(sheet2.getRow(2).getCell(1)).getNumberValue());
            
            System.out.println(evaluator.evaluate(sheet2.getRow(3).getCell(1)).getNumberValue());            
		} catch (  IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}*/
	
	    public void readJSON() throws IOException
	    {
			//read json file data to String byte[] jsonData =
	    	//byte[] jsonData = Files.readAllBytes(Paths.get("D:\\internship\\ExcelReader\\src\\main\\resources\\fields.json"));
		 
	    	byte[] jsonData = Files.readAllBytes(new File(getClass().getClassLoader().getResource("fields.json").getFile()).toPath());
	    	
	    	//create ObjectMapper instance
			ObjectMapper objectMapper = new ObjectMapper();
			
			//convert json string to object
			InputOutput io = objectMapper.readValue(jsonData, InputOutput.class);
			
			System.out.println("Inputoutput Object\n"+io);
			
			// Copy output test
			copyValuesToOutput(io);
			
			//configure Object mapper for pretty print
			objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
			
		}

		
	  private void copyValuesToOutput(InputOutput io) { 
		  // TODO Auto-generated method stub 
	  System.out.println("===hello java-=====");
	  System.out.println("Output is - " + io.getOutput());
	  io.setOutput(io.getInput()); 
	  }
	 
	
	public static void main(String[] args) throws IOException {
		ReadWrite rw = new ReadWrite();
		rw.readJSON();
		
	}
	/*public static void main(String[] args) {
	ReadWrite rw = new ReadWrite();

	//rw.getData();		
}*/


}