package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.response.ClientResponse;
import com.example.service.StudentService;

@RestController
public class StudentController {
	
	@Autowired
	StudentService studentService;
	
 
	@RequestMapping(value="/saveStudent",method=RequestMethod.GET)
	public @ResponseBody ClientResponse SaveStudent(){
		return studentService.saveStudentData();
	}
	
	
	@RequestMapping(value="/getStudent/{studId}",method=RequestMethod.GET)
	public @ResponseBody ClientResponse getStudent(@PathVariable Long studId){
		return studentService.getStudentData(studId);
	}
}
