package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.dao.StudentDao;


@RestController
public class HelloController {
	
	@Autowired
	StudentDao studentDao;
	
	
	@RequestMapping(value="/sampleAPI",method=RequestMethod.GET)
	public @ResponseBody String sampleAPI(){
		//logger.info("test");
		System.out.println("Inside");
		return "result";
	}

	
	 
}
