package com.saka.excelreader.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.saka.excelreader.core.ReadWrite;
import com.saka.excelreader.models.InputModel;
import com.saka.excelreader.models.OutputModel;

@CrossOrigin
@RestController
public class ExcelController {
	@Autowired
	private ReadWrite readwrite;
	


	@RequestMapping(value = "/input", method = RequestMethod.POST )
	public OutputModel getData(@RequestBody InputModel input) {
		
		
		return readwrite.getData(input);
		
	}
	
}
