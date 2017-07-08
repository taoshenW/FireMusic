package com.sfp.service;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.sfp.domain.User;
import com.sfp.domain.repository.UserRepository;
import com.sfp.util.Util;

@Service
@Transactional
public class UserService {

	@Autowired
	UserRepository userRepository;
	@Value("${user.icon.path}")
	private String ICONPATH;
	@PersistenceContext
	private EntityManager entityManager;
	
	public User findByAccount(String account){
		return userRepository.findByAccount(account);
	}

	public void insert(MultipartFile file, User user) throws IllegalStateException, IOException {
		if (!file.isEmpty())
			user.setImage(Util.saveImage(file, ICONPATH));
		userRepository.save(user);
	}

	public void modify(MultipartFile file, User Transient) throws IllegalStateException, IOException {
		User Managed = userRepository.findByAccount(Transient.getAccount());
		if (!file.isEmpty()) {
			if (Managed.getImage() != null)
				Util.deleteImage(ICONPATH + "//" + Managed.getImage());
			Transient.setImage(Util.saveImage(file, ICONPATH));
		}
		BeanUtils.copyProperties(Transient, Managed);
	}

}
