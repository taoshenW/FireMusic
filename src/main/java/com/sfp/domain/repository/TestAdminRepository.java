package com.sfp.domain.repository;

import org.springframework.data.repository.Repository;

import com.sfp.domain.Admin;

public interface TestAdminRepository extends Repository<Admin,Integer>{

	public Admin findById(int id);
	
}
