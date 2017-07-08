package com.sfp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sfp.domain.User;
import com.sfp.domain.repository.UserRepository;

@Service
public class LoginService {

	@Autowired
	UserRepository userRepository;

	public User checkLogin(String account, String password) {
		return userRepository.findByAccountAndPassword(account, password);
	}

}
