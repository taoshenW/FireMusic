package com.sfp.web;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sfp.domain.User;
import com.sfp.service.LoginService;

@Controller
public class LoginController {

	@Autowired
	LoginService loginService;

	@ResponseBody
	@RequestMapping("/login")
	public String checkLogin(String name, String password, HttpSession session) {
		User user = loginService.checkLogin(name, password);
		if (user != null) {
			session.setAttribute("name", user.getName());
			session.setAttribute("account", user.getAccount());
			return "success";
		}
		return "fail";
	}

	@ResponseBody
	@RequestMapping("/logout")
	public void logout(HttpSession session) {
		session.setAttribute("user", null);
		session.setAttribute("account", null);
	}
}
