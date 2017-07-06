package com.sfp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sfp.domain.Admin;
import com.sfp.domain.repository.TestAdminRepository;

@Service
public class TestAdminService {

	@Autowired
	TestAdminRepository testAdminRespository;
	
	public Admin findById(int id){
		return testAdminRespository.findById(id);
		
	}
	
}
