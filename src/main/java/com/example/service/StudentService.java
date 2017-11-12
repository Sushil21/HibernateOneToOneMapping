package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.StudentDao;
import com.example.model.Address;
import com.example.model.Student;
import com.example.response.ClientResponse;

@Service
public class StudentService {
	
	@Autowired
	StudentDao studentDao;
	
	 public ClientResponse saveStudentData() {
		ClientResponse clientResponse = new ClientResponse();
		Student student = new Student();
		student.setStudentName("sushil");
		Address address = new Address();
		address.setAddressName("delhi");
		student.setAddress(address);
		studentDao.saveStudentData(student);
		clientResponse.setData(student);
		return clientResponse;
	}
	 
	 public ClientResponse getStudentData(Long studId) {
		 ClientResponse clientResponse = new ClientResponse();
		 Student stud = studentDao.getStudentData(studId);
		 clientResponse.setData(stud);
		 return clientResponse;
	 }
}
