package com.sfp.domain.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

import com.sfp.domain.User;

public interface UserRepository extends CrudRepository<User, Integer> {

	public User findByAccount(String account);
	
	public User findByAccountAndPassword(String account, String password);

}
