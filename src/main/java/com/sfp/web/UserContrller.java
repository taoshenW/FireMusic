package com.sfp.web;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.sfp.domain.User;
import com.sfp.service.UserService;

@Controller
public class UserContrller {

	@Autowired
	private UserService userService;

	@RequestMapping("/user")
	public String index() {
		return "index";
	}
	
	@ResponseBody
	@RequestMapping("/user/findByAccount")
	public User findByAccount(String account) {
		return userService.findByAccount(account);
	}

	@ResponseBody
	@RequestMapping("/user/insert")
	public void insert(@RequestParam(value = "icon", required = false) MultipartFile file,User user)
			throws IllegalStateException, IOException {
		userService.insert(file,user);
	}
	
	@ResponseBody
	@RequestMapping("/user/modify")
	public void modify(@RequestParam(value = "icon", required = false) MultipartFile file,User user) throws IllegalStateException, IOException{
		userService.modify(file, user);
	}

}
